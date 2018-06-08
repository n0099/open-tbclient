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
import com.baidu.tbadk.core.util.w;
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import tbclient.FrsPage.StarContriRecord;
import tbclient.FrsPage.StarRank;
/* loaded from: classes2.dex */
public class FrsStarRankAndTaskContainer extends LinearLayout implements View.OnClickListener {
    private TextView dEB;
    private TextView dEC;
    private TextView dED;
    private ImageView dEE;
    private ViewGroup dEF;
    private ViewGroup dEG;
    private ListView dEH;
    private a dEI;
    private d dEJ;
    private int dEK;
    private Runnable dEL;
    private StarRank dEq;
    private Handler handler;
    private Runnable mRunnable;
    private TbPageContext mTbPageContext;

    static /* synthetic */ int b(FrsStarRankAndTaskContainer frsStarRankAndTaskContainer) {
        int i = frsStarRankAndTaskContainer.dEK + 1;
        frsStarRankAndTaskContainer.dEK = i;
        return i;
    }

    public FrsStarRankAndTaskContainer(Context context) {
        this(context, null);
    }

    public FrsStarRankAndTaskContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.handler = new Handler();
        this.dEK = 0;
        this.dEL = new Runnable() { // from class: com.baidu.tieba.frs.view.FrsStarRankAndTaskContainer.1
            @Override // java.lang.Runnable
            public void run() {
                if (FrsStarRankAndTaskContainer.this.dEH != null) {
                    FrsStarRankAndTaskContainer.this.dEH.smoothScrollToPositionFromTop(FrsStarRankAndTaskContainer.b(FrsStarRankAndTaskContainer.this), 0, 300);
                }
                FrsStarRankAndTaskContainer.this.handler.removeCallbacksAndMessages(null);
                FrsStarRankAndTaskContainer.this.handler.postDelayed(this, 3000L);
            }
        };
        this.mRunnable = new Runnable() { // from class: com.baidu.tieba.frs.view.FrsStarRankAndTaskContainer.4
            @Override // java.lang.Runnable
            public void run() {
                FrsStarRankAndTaskContainer.this.dEH.setSelection(FrsStarRankAndTaskContainer.this.dEK);
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
        aAb();
    }

    private void init() {
        Context context = getContext();
        setOrientation(0);
        setPadding(l.e(context, d.e.tbds35), l.e(context, d.e.tbds30), l.e(context, d.e.tbds35), 0);
        LayoutInflater.from(getContext()).inflate(d.i.view_frs_star_rank_and_task, (ViewGroup) this, true);
        this.dEB = (TextView) findViewById(d.g.rank_number);
        this.dEC = (TextView) findViewById(d.g.user_contributions);
        this.dED = (TextView) findViewById(d.g.star_task);
        this.dEE = (ImageView) findViewById(d.g.image_rank_icon);
        this.dEG = (ViewGroup) findViewById(d.g.task_container);
        this.dEF = (ViewGroup) findViewById(d.g.rank_container);
        this.dEG.setOnClickListener(this);
        this.dEF.setOnClickListener(this);
        this.dEH = (ListView) findViewById(d.g.rank_scroll);
        this.dEH.setClickable(false);
        this.dEH.setFocusable(false);
        this.dEH.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.frs.view.FrsStarRankAndTaskContainer.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (FrsStarRankAndTaskContainer.this.dEF != null) {
                    FrsStarRankAndTaskContainer.this.dEF.performClick();
                }
            }
        });
        this.dEH.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.frs.view.FrsStarRankAndTaskContainer.3
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
        this.dEI = new a(getContext());
        this.dEH.setAdapter((ListAdapter) this.dEI);
        onChangeSkinType();
    }

    public void setData(StarRank starRank) {
        String string;
        int i;
        if (starRank != null) {
            this.dEq = starRank;
            if (starRank.rank_ranking.intValue() > 0 && starRank.rank_ranking.intValue() <= 1000) {
                Locale locale = Locale.CHINA;
                String string2 = getResources().getString(d.k.star_rank_number);
                Object[] objArr = new Object[2];
                objArr[0] = StringUtils.isNull(starRank.rank_name) ? getResources().getString(d.k.affect_bang) : starRank.rank_name;
                objArr[1] = starRank.rank_ranking;
                string = String.format(locale, string2, objArr);
            } else {
                string = getResources().getString(d.k.no_bang);
            }
            this.dEB.setText(string);
            this.dEC.setText(starRank.user_task_notice);
            if (!w.z(this.dEq.user_task_info)) {
                int size = this.dEq.user_task_info.size();
                int i2 = 0;
                int i3 = 0;
                while (i2 < size) {
                    if (this.dEq.user_task_info.get(i2) == null) {
                        i = i3;
                    } else {
                        i = this.dEq.user_task_info.get(i2).task_status.intValue() == 1 ? i3 + 1 : i3;
                    }
                    i2++;
                    i3 = i;
                }
                this.dED.setText(String.format(Locale.CHINA, getResources().getString(d.k.see_task), Integer.valueOf(i3), Integer.valueOf(size)));
            } else {
                this.dED.setText(d.k.no_have_task);
            }
            this.dEI.setData(starRank.contri_record_list);
            aAb();
        }
    }

    public void aAb() {
        if (this.dEI.getCount() != 0) {
            this.handler.removeCallbacks(this.dEL);
            this.handler.postDelayed(this.dEL, 3000L);
        }
    }

    public void onChangeSkinType() {
        al.h(this.dEB, d.C0141d.cp_cont_i);
        al.c(this.dEE, d.f.icon_frs_idol_ranking);
        al.i(this.dEF, d.f.bg_fts_star_rank_entrance);
        al.i(this.dEG, d.f.bg_frs_star_task_entrance);
        this.dED.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, al.getDrawable(d.f.icon_arrow12_white_right), (Drawable) null);
        al.h(this.dED, d.C0141d.cp_cont_i);
        al.h(this.dEC, d.C0141d.cp_cont_i);
        this.dEI.notifyDataSetChanged();
        if (this.dEJ != null) {
            this.dEJ.aAa();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class a extends BaseAdapter {
        private final List<StarContriRecord> data = new ArrayList();
        private Context mContext;

        a(Context context) {
            this.mContext = context;
        }

        void setData(List<StarContriRecord> list) {
            if (!w.z(list)) {
                this.data.clear();
                this.data.addAll(list);
                notifyDataSetChanged();
            }
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (w.z(this.data)) {
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
                view = LayoutInflater.from(this.mContext).inflate(d.i.item_star_rank_user_contri, viewGroup, false);
                bVar = new b();
                bVar.dEN = (TextView) view.findViewById(d.g.contri_desc);
                bVar.tvUserName = (TextView) view.findViewById(d.g.contri_username);
                view.setTag(bVar);
            } else {
                bVar = (b) view.getTag();
            }
            StarContriRecord starContriRecord = this.data.get(i % this.data.size());
            if (starContriRecord == null) {
                return null;
            }
            bVar.tvUserName.setText(starContriRecord.user_name);
            bVar.dEN.setText(starContriRecord.record_notice);
            bVar.tvUserName.requestLayout();
            if (UtilHelper.isCurrentAccount(String.valueOf(starContriRecord.user_id))) {
                al.h(bVar.dEN, d.C0141d.common_color_10326);
                al.h(bVar.tvUserName, d.C0141d.common_color_10326);
                return view;
            }
            al.h(bVar.dEN, d.C0141d.cp_cont_i);
            al.h(bVar.tvUserName, d.C0141d.cp_cont_i);
            return view;
        }
    }

    /* loaded from: classes2.dex */
    private static class b {
        TextView dEN;
        TextView tvUserName;

        private b() {
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.dEG) {
            TiebaStatic.log(new am("c12880"));
            if (ba.aU(getContext())) {
                if (this.dEJ == null) {
                    this.dEJ = new d();
                }
                this.dEJ.a(getContext(), this.dEq);
            }
        } else if (view == this.dEF) {
            if (this.mTbPageContext != null && this.dEq != null) {
                this.mTbPageContext.sendMessage(new CustomMessage(2002001, new ShareWebActivityConfig(this.mTbPageContext.getContext(), "", this.dEq.url, true)));
            }
            TiebaStatic.log(new am("c12879"));
        }
    }

    public void setContext(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
    }
}
