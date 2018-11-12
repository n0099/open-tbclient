package com.baidu.tieba.frs.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.support.v7.widget.ActivityChooserView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.ShareWebActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.e;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import tbclient.FrsPage.StarContriRecord;
import tbclient.FrsPage.StarRank;
/* loaded from: classes6.dex */
public class FrsStarRankAndTaskContainer extends LinearLayout implements View.OnClickListener {
    private StarRank eaV;
    private TextView ebf;
    private TextView ebg;
    private TextView ebh;
    private ImageView ebi;
    private ViewGroup ebj;
    private ViewGroup ebk;
    private ListView ebl;
    private a ebm;
    private d ebn;
    private int ebo;
    private Runnable ebp;
    private Handler handler;
    private Runnable mRunnable;
    private TbPageContext mTbPageContext;

    static /* synthetic */ int b(FrsStarRankAndTaskContainer frsStarRankAndTaskContainer) {
        int i = frsStarRankAndTaskContainer.ebo + 1;
        frsStarRankAndTaskContainer.ebo = i;
        return i;
    }

    public FrsStarRankAndTaskContainer(Context context) {
        this(context, null);
    }

    public FrsStarRankAndTaskContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.handler = new Handler();
        this.ebo = 0;
        this.ebp = new Runnable() { // from class: com.baidu.tieba.frs.view.FrsStarRankAndTaskContainer.1
            @Override // java.lang.Runnable
            public void run() {
                if (FrsStarRankAndTaskContainer.this.ebl != null) {
                    FrsStarRankAndTaskContainer.this.ebl.smoothScrollToPositionFromTop(FrsStarRankAndTaskContainer.b(FrsStarRankAndTaskContainer.this), 0, 300);
                }
                FrsStarRankAndTaskContainer.this.handler.removeCallbacksAndMessages(null);
                FrsStarRankAndTaskContainer.this.handler.postDelayed(this, 3000L);
            }
        };
        this.mRunnable = new Runnable() { // from class: com.baidu.tieba.frs.view.FrsStarRankAndTaskContainer.4
            @Override // java.lang.Runnable
            public void run() {
                FrsStarRankAndTaskContainer.this.ebl.setSelection(FrsStarRankAndTaskContainer.this.ebo);
            }
        };
        init();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.handler.removeCallbacks(this.mRunnable);
        this.handler.removeCallbacksAndMessages(null);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.handler.removeCallbacksAndMessages(null);
        aGp();
    }

    private void init() {
        Context context = getContext();
        setOrientation(0);
        setPadding(l.h(context, e.C0200e.tbds35), l.h(context, e.C0200e.tbds30), l.h(context, e.C0200e.tbds35), 0);
        LayoutInflater.from(getContext()).inflate(e.h.view_frs_star_rank_and_task, (ViewGroup) this, true);
        this.ebf = (TextView) findViewById(e.g.rank_number);
        this.ebg = (TextView) findViewById(e.g.user_contributions);
        this.ebh = (TextView) findViewById(e.g.star_task);
        this.ebi = (ImageView) findViewById(e.g.image_rank_icon);
        this.ebk = (ViewGroup) findViewById(e.g.task_container);
        this.ebj = (ViewGroup) findViewById(e.g.rank_container);
        this.ebk.setOnClickListener(this);
        this.ebj.setOnClickListener(this);
        this.ebl = (ListView) findViewById(e.g.rank_scroll);
        this.ebl.setClickable(false);
        this.ebl.setFocusable(false);
        this.ebl.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.frs.view.FrsStarRankAndTaskContainer.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (FrsStarRankAndTaskContainer.this.ebj != null) {
                    FrsStarRankAndTaskContainer.this.ebj.performClick();
                }
            }
        });
        this.ebl.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.frs.view.FrsStarRankAndTaskContainer.3
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (i == 0) {
                    FrsStarRankAndTaskContainer.this.handler.removeCallbacks(FrsStarRankAndTaskContainer.this.mRunnable);
                    FrsStarRankAndTaskContainer.this.handler.postDelayed(FrsStarRankAndTaskContainer.this.mRunnable, 100L);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }
        });
        this.ebm = new a(getContext());
        this.ebl.setAdapter((ListAdapter) this.ebm);
        onChangeSkinType();
    }

    public void setData(StarRank starRank) {
        String string;
        int i;
        if (starRank != null) {
            this.eaV = starRank;
            if (starRank.rank_ranking.intValue() > 0 && starRank.rank_ranking.intValue() <= 1000) {
                Locale locale = Locale.CHINA;
                String string2 = getResources().getString(e.j.star_rank_number);
                Object[] objArr = new Object[2];
                objArr[0] = StringUtils.isNull(starRank.rank_name) ? getResources().getString(e.j.affect_bang) : starRank.rank_name;
                objArr[1] = starRank.rank_ranking;
                string = String.format(locale, string2, objArr);
            } else {
                string = getResources().getString(e.j.no_bang);
            }
            this.ebf.setText(string);
            this.ebg.setText(starRank.user_task_notice);
            if (!v.I(this.eaV.user_task_info)) {
                int size = this.eaV.user_task_info.size();
                int i2 = 0;
                int i3 = 0;
                while (i2 < size) {
                    if (this.eaV.user_task_info.get(i2) == null) {
                        i = i3;
                    } else {
                        i = this.eaV.user_task_info.get(i2).task_status.intValue() == 1 ? i3 + 1 : i3;
                    }
                    i2++;
                    i3 = i;
                }
                this.ebh.setText(String.format(Locale.CHINA, getResources().getString(e.j.see_task), Integer.valueOf(i3), Integer.valueOf(size)));
            } else {
                this.ebh.setText(e.j.no_have_task);
            }
            this.ebm.setData(starRank.contri_record_list);
            aGp();
        }
    }

    public void aGp() {
        if (this.ebm.getCount() != 0) {
            this.handler.removeCallbacks(this.ebp);
            this.handler.postDelayed(this.ebp, 3000L);
        }
    }

    public void onChangeSkinType() {
        al.h(this.ebf, e.d.cp_cont_i);
        al.c(this.ebi, e.f.icon_frs_idol_ranking);
        al.i(this.ebj, e.f.bg_fts_star_rank_entrance);
        al.i(this.ebk, e.f.bg_frs_star_task_entrance);
        this.ebh.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, al.getDrawable(e.f.icon_arrow12_white_right), (Drawable) null);
        al.h(this.ebh, e.d.cp_cont_i);
        al.h(this.ebg, e.d.cp_cont_i);
        this.ebm.notifyDataSetChanged();
        if (this.ebn != null) {
            this.ebn.aGo();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static class a extends BaseAdapter {
        private final List<StarContriRecord> data = new ArrayList();
        private Context mContext;

        a(Context context) {
            this.mContext = context;
        }

        void setData(List<StarContriRecord> list) {
            if (!v.I(list)) {
                this.data.clear();
                this.data.addAll(list);
                notifyDataSetChanged();
            }
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (v.I(this.data)) {
                return 0;
            }
            return ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return null;
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return 0L;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            b bVar;
            if (view == null) {
                view = LayoutInflater.from(this.mContext).inflate(e.h.item_star_rank_user_contri, viewGroup, false);
                bVar = new b();
                bVar.ebr = (TextView) view.findViewById(e.g.contri_desc);
                bVar.tvUserName = (TextView) view.findViewById(e.g.contri_username);
                view.setTag(bVar);
            } else {
                bVar = (b) view.getTag();
            }
            StarContriRecord starContriRecord = this.data.get(i % this.data.size());
            if (starContriRecord == null) {
                return null;
            }
            bVar.tvUserName.setText(starContriRecord.user_name);
            bVar.ebr.setText(starContriRecord.record_notice);
            bVar.tvUserName.requestLayout();
            if (UtilHelper.isCurrentAccount(String.valueOf(starContriRecord.user_id))) {
                al.h(bVar.ebr, e.d.common_color_10326);
                al.h(bVar.tvUserName, e.d.common_color_10326);
                return view;
            }
            al.h(bVar.ebr, e.d.cp_cont_i);
            al.h(bVar.tvUserName, e.d.cp_cont_i);
            return view;
        }
    }

    /* loaded from: classes6.dex */
    private static class b {
        TextView ebr;
        TextView tvUserName;

        private b() {
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.ebk) {
            TiebaStatic.log(new am("c12880"));
            if (ba.bG(getContext())) {
                if (this.ebn == null) {
                    this.ebn = new d();
                }
                this.ebn.a(getContext(), this.eaV);
            }
        } else if (view == this.ebj) {
            if (this.mTbPageContext != null && this.eaV != null) {
                this.mTbPageContext.sendMessage(new CustomMessage(2002001, new ShareWebActivityConfig(this.mTbPageContext.getContext(), "", this.eaV.url, true)));
            }
            TiebaStatic.log(new am("c12879"));
        }
    }

    public void setContext(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
    }
}
