package com.baidu.tieba.frs.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Handler;
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
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ShareWebActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import tbclient.FrsPage.StarContriRecord;
import tbclient.FrsPage.StarRank;
/* loaded from: classes2.dex */
public class FrsStarRankAndTaskContainer extends LinearLayout implements View.OnClickListener {
    private boolean aQq;
    private TextView dZA;
    private ImageView dZB;
    private ViewGroup dZC;
    private ViewGroup dZD;
    private ListView dZE;
    private a dZF;
    private f dZG;
    private int dZH;
    private Runnable dZI;
    private StarRank dZp;
    private TextView dZy;
    private TextView dZz;
    private Handler handler;
    private Runnable mRunnable;
    private TbPageContext mTbPageContext;

    static /* synthetic */ int b(FrsStarRankAndTaskContainer frsStarRankAndTaskContainer) {
        int i = frsStarRankAndTaskContainer.dZH + 1;
        frsStarRankAndTaskContainer.dZH = i;
        return i;
    }

    public FrsStarRankAndTaskContainer(Context context) {
        this(context, null);
    }

    public FrsStarRankAndTaskContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.handler = new Handler();
        this.dZH = 0;
        this.aQq = false;
        this.dZI = new Runnable() { // from class: com.baidu.tieba.frs.view.FrsStarRankAndTaskContainer.1
            @Override // java.lang.Runnable
            public void run() {
                if (FrsStarRankAndTaskContainer.this.dZE != null) {
                    FrsStarRankAndTaskContainer.this.dZE.smoothScrollToPositionFromTop(FrsStarRankAndTaskContainer.b(FrsStarRankAndTaskContainer.this), 0, 300);
                }
                FrsStarRankAndTaskContainer.this.handler.removeCallbacksAndMessages(null);
                FrsStarRankAndTaskContainer.this.handler.postDelayed(this, 3000L);
            }
        };
        this.mRunnable = new Runnable() { // from class: com.baidu.tieba.frs.view.FrsStarRankAndTaskContainer.4
            @Override // java.lang.Runnable
            public void run() {
                FrsStarRankAndTaskContainer.this.dZE.setSelection(FrsStarRankAndTaskContainer.this.dZH);
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
        aAX();
    }

    private void init() {
        Context context = getContext();
        setOrientation(0);
        setPadding(l.t(context, d.e.tbds35), l.t(context, d.e.tbds30), l.t(context, d.e.tbds35), 0);
        LayoutInflater.from(getContext()).inflate(d.h.view_frs_star_rank_and_task, (ViewGroup) this, true);
        this.dZy = (TextView) findViewById(d.g.rank_number);
        this.dZz = (TextView) findViewById(d.g.user_contributions);
        this.dZA = (TextView) findViewById(d.g.star_task);
        this.dZB = (ImageView) findViewById(d.g.image_rank_icon);
        this.dZD = (ViewGroup) findViewById(d.g.task_container);
        this.dZC = (ViewGroup) findViewById(d.g.rank_container);
        this.dZD.setOnClickListener(this);
        this.dZC.setOnClickListener(this);
        this.dZE = (ListView) findViewById(d.g.rank_scroll);
        this.dZE.setClickable(false);
        this.dZE.setFocusable(false);
        this.dZE.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.frs.view.FrsStarRankAndTaskContainer.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (FrsStarRankAndTaskContainer.this.dZC != null) {
                    FrsStarRankAndTaskContainer.this.dZC.performClick();
                }
            }
        });
        this.dZE.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.frs.view.FrsStarRankAndTaskContainer.3
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
        this.dZF = new a(getContext());
        this.dZE.setAdapter((ListAdapter) this.dZF);
        gF(false);
    }

    public void a(StarRank starRank, boolean z) {
        String string;
        int i;
        if (starRank != null) {
            this.dZp = starRank;
            if (starRank.rank_ranking.intValue() > 0 && starRank.rank_ranking.intValue() <= 1000) {
                Locale locale = Locale.CHINA;
                String string2 = getResources().getString(d.j.star_rank_number);
                Object[] objArr = new Object[2];
                objArr[0] = StringUtils.isNull(starRank.rank_name) ? getResources().getString(d.j.affect_bang) : starRank.rank_name;
                objArr[1] = starRank.rank_ranking;
                string = String.format(locale, string2, objArr);
            } else {
                string = getResources().getString(d.j.no_bang);
            }
            this.dZy.setText(string);
            this.dZz.setText(starRank.user_task_notice);
            if (!v.E(this.dZp.user_task_info)) {
                int size = this.dZp.user_task_info.size();
                int i2 = 0;
                int i3 = 0;
                while (i2 < size) {
                    if (this.dZp.user_task_info.get(i2) == null) {
                        i = i3;
                    } else {
                        i = this.dZp.user_task_info.get(i2).task_status.intValue() == 1 ? i3 + 1 : i3;
                    }
                    i2++;
                    i3 = i;
                }
                this.dZA.setText(String.format(Locale.CHINA, getResources().getString(d.j.see_task), Integer.valueOf(i3), Integer.valueOf(size)));
            } else {
                this.dZA.setText(d.j.no_have_task);
            }
            this.aQq = z;
            gF(z);
            this.dZF.setData(starRank.contri_record_list);
            aAX();
        }
    }

    public void aAX() {
        if (this.dZF.getCount() != 0) {
            this.handler.removeCallbacks(this.dZI);
            this.handler.postDelayed(this.dZI, 3000L);
        }
    }

    public void gF(boolean z) {
        boolean z2 = TbadkCoreApplication.getInst().getSkinType() == 1;
        aj.r(this.dZy, d.C0141d.cp_cont_i);
        aj.c(this.dZB, (z2 || !z) ? d.f.icon_frs_idol_ranking : d.f.icon_frs_idol_ranking_gray);
        aj.s(this.dZC, (z2 || !z) ? d.f.bg_fts_star_rank_entrance : d.f.bg_frs_star_task_entrance_gray);
        aj.s(this.dZD, (z2 || !z) ? d.f.bg_frs_star_task_entrance : d.f.bg_frs_star_task_entrance_gray);
        this.dZA.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, aj.getDrawable(d.f.icon_arrow12_white_right), (Drawable) null);
        aj.r(this.dZA, d.C0141d.cp_cont_i);
        aj.r(this.dZz, d.C0141d.cp_cont_i);
        this.dZF.notifyDataSetChanged();
        if (this.dZG != null) {
            this.dZG.gE(z);
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
            if (!v.E(list)) {
                this.data.clear();
                this.data.addAll(list);
                notifyDataSetChanged();
            }
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return v.E(this.data) ? 0 : Integer.MAX_VALUE;
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
                view = LayoutInflater.from(this.mContext).inflate(d.h.item_star_rank_user_contri, viewGroup, false);
                bVar = new b();
                bVar.dZK = (TextView) view.findViewById(d.g.contri_desc);
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
            bVar.dZK.setText(starContriRecord.record_notice);
            bVar.tvUserName.requestLayout();
            if (UtilHelper.isCurrentAccount(String.valueOf(starContriRecord.user_id))) {
                aj.r(bVar.dZK, d.C0141d.common_color_10326);
                aj.r(bVar.tvUserName, d.C0141d.common_color_10326);
                return view;
            }
            aj.r(bVar.dZK, d.C0141d.cp_cont_i);
            aj.r(bVar.tvUserName, d.C0141d.cp_cont_i);
            return view;
        }
    }

    /* loaded from: classes2.dex */
    private static class b {
        TextView dZK;
        TextView tvUserName;

        private b() {
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.dZD) {
            TiebaStatic.log(new ak("c12880"));
            if (ay.ba(getContext())) {
                if (this.dZG == null) {
                    this.dZG = new f();
                }
                this.dZG.a(getContext(), this.dZp, this.aQq);
            }
        } else if (view == this.dZC) {
            if (this.mTbPageContext != null && this.dZp != null) {
                this.mTbPageContext.sendMessage(new CustomMessage(2002001, new ShareWebActivityConfig(this.mTbPageContext.getContext(), "", this.dZp.url, true)));
            }
            TiebaStatic.log(new ak("c12879"));
        }
    }

    public void setContext(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
    }
}
