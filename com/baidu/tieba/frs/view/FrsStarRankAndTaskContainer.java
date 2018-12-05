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
    private TextView ehI;
    private TextView ehJ;
    private TextView ehK;
    private ImageView ehL;
    private ViewGroup ehM;
    private ViewGroup ehN;
    private ListView ehO;
    private a ehP;
    private d ehQ;
    private int ehR;
    private Runnable ehS;
    private StarRank ehy;
    private Handler handler;
    private Runnable mRunnable;
    private TbPageContext mTbPageContext;

    static /* synthetic */ int b(FrsStarRankAndTaskContainer frsStarRankAndTaskContainer) {
        int i = frsStarRankAndTaskContainer.ehR + 1;
        frsStarRankAndTaskContainer.ehR = i;
        return i;
    }

    public FrsStarRankAndTaskContainer(Context context) {
        this(context, null);
    }

    public FrsStarRankAndTaskContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.handler = new Handler();
        this.ehR = 0;
        this.ehS = new Runnable() { // from class: com.baidu.tieba.frs.view.FrsStarRankAndTaskContainer.1
            @Override // java.lang.Runnable
            public void run() {
                if (FrsStarRankAndTaskContainer.this.ehO != null) {
                    FrsStarRankAndTaskContainer.this.ehO.smoothScrollToPositionFromTop(FrsStarRankAndTaskContainer.b(FrsStarRankAndTaskContainer.this), 0, 300);
                }
                FrsStarRankAndTaskContainer.this.handler.removeCallbacksAndMessages(null);
                FrsStarRankAndTaskContainer.this.handler.postDelayed(this, 3000L);
            }
        };
        this.mRunnable = new Runnable() { // from class: com.baidu.tieba.frs.view.FrsStarRankAndTaskContainer.4
            @Override // java.lang.Runnable
            public void run() {
                FrsStarRankAndTaskContainer.this.ehO.setSelection(FrsStarRankAndTaskContainer.this.ehR);
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
        aIb();
    }

    private void init() {
        Context context = getContext();
        setOrientation(0);
        setPadding(l.h(context, e.C0210e.tbds35), l.h(context, e.C0210e.tbds30), l.h(context, e.C0210e.tbds35), 0);
        LayoutInflater.from(getContext()).inflate(e.h.view_frs_star_rank_and_task, (ViewGroup) this, true);
        this.ehI = (TextView) findViewById(e.g.rank_number);
        this.ehJ = (TextView) findViewById(e.g.user_contributions);
        this.ehK = (TextView) findViewById(e.g.star_task);
        this.ehL = (ImageView) findViewById(e.g.image_rank_icon);
        this.ehN = (ViewGroup) findViewById(e.g.task_container);
        this.ehM = (ViewGroup) findViewById(e.g.rank_container);
        this.ehN.setOnClickListener(this);
        this.ehM.setOnClickListener(this);
        this.ehO = (ListView) findViewById(e.g.rank_scroll);
        this.ehO.setClickable(false);
        this.ehO.setFocusable(false);
        this.ehO.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.frs.view.FrsStarRankAndTaskContainer.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (FrsStarRankAndTaskContainer.this.ehM != null) {
                    FrsStarRankAndTaskContainer.this.ehM.performClick();
                }
            }
        });
        this.ehO.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.frs.view.FrsStarRankAndTaskContainer.3
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
        this.ehP = new a(getContext());
        this.ehO.setAdapter((ListAdapter) this.ehP);
        onChangeSkinType();
    }

    public void setData(StarRank starRank) {
        String string;
        int i;
        if (starRank != null) {
            this.ehy = starRank;
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
            this.ehI.setText(string);
            this.ehJ.setText(starRank.user_task_notice);
            if (!v.I(this.ehy.user_task_info)) {
                int size = this.ehy.user_task_info.size();
                int i2 = 0;
                int i3 = 0;
                while (i2 < size) {
                    if (this.ehy.user_task_info.get(i2) == null) {
                        i = i3;
                    } else {
                        i = this.ehy.user_task_info.get(i2).task_status.intValue() == 1 ? i3 + 1 : i3;
                    }
                    i2++;
                    i3 = i;
                }
                this.ehK.setText(String.format(Locale.CHINA, getResources().getString(e.j.see_task), Integer.valueOf(i3), Integer.valueOf(size)));
            } else {
                this.ehK.setText(e.j.no_have_task);
            }
            this.ehP.setData(starRank.contri_record_list);
            aIb();
        }
    }

    public void aIb() {
        if (this.ehP.getCount() != 0) {
            this.handler.removeCallbacks(this.ehS);
            this.handler.postDelayed(this.ehS, 3000L);
        }
    }

    public void onChangeSkinType() {
        al.h(this.ehI, e.d.cp_cont_i);
        al.c(this.ehL, e.f.icon_frs_idol_ranking);
        al.i(this.ehM, e.f.bg_fts_star_rank_entrance);
        al.i(this.ehN, e.f.bg_frs_star_task_entrance);
        this.ehK.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, al.getDrawable(e.f.icon_arrow12_white_right), (Drawable) null);
        al.h(this.ehK, e.d.cp_cont_i);
        al.h(this.ehJ, e.d.cp_cont_i);
        this.ehP.notifyDataSetChanged();
        if (this.ehQ != null) {
            this.ehQ.aIa();
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
                bVar.ehU = (TextView) view.findViewById(e.g.contri_desc);
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
            bVar.ehU.setText(starContriRecord.record_notice);
            bVar.tvUserName.requestLayout();
            if (UtilHelper.isCurrentAccount(String.valueOf(starContriRecord.user_id))) {
                al.h(bVar.ehU, e.d.common_color_10326);
                al.h(bVar.tvUserName, e.d.common_color_10326);
                return view;
            }
            al.h(bVar.ehU, e.d.cp_cont_i);
            al.h(bVar.tvUserName, e.d.cp_cont_i);
            return view;
        }
    }

    /* loaded from: classes6.dex */
    private static class b {
        TextView ehU;
        TextView tvUserName;

        private b() {
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.ehN) {
            TiebaStatic.log(new am("c12880"));
            if (ba.bJ(getContext())) {
                if (this.ehQ == null) {
                    this.ehQ = new d();
                }
                this.ehQ.a(getContext(), this.ehy);
            }
        } else if (view == this.ehM) {
            if (this.mTbPageContext != null && this.ehy != null) {
                this.mTbPageContext.sendMessage(new CustomMessage(2002001, new ShareWebActivityConfig(this.mTbPageContext.getContext(), "", this.ehy.url, true)));
            }
            TiebaStatic.log(new am("c12879"));
        }
    }

    public void setContext(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
    }
}
