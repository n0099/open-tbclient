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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
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
    private StarRank dKA;
    private TextView dKL;
    private TextView dKM;
    private TextView dKN;
    private ImageView dKO;
    private ViewGroup dKP;
    private ViewGroup dKQ;
    private ListView dKR;
    private a dKS;
    private d dKT;
    private int dKU;
    private Runnable dKV;
    private Handler handler;
    private Runnable mRunnable;
    private TbPageContext mTbPageContext;

    static /* synthetic */ int b(FrsStarRankAndTaskContainer frsStarRankAndTaskContainer) {
        int i = frsStarRankAndTaskContainer.dKU + 1;
        frsStarRankAndTaskContainer.dKU = i;
        return i;
    }

    public FrsStarRankAndTaskContainer(Context context) {
        this(context, null);
    }

    public FrsStarRankAndTaskContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.handler = new Handler();
        this.dKU = 0;
        this.dKV = new Runnable() { // from class: com.baidu.tieba.frs.view.FrsStarRankAndTaskContainer.1
            @Override // java.lang.Runnable
            public void run() {
                if (FrsStarRankAndTaskContainer.this.dKR != null) {
                    FrsStarRankAndTaskContainer.this.dKR.smoothScrollToPositionFromTop(FrsStarRankAndTaskContainer.b(FrsStarRankAndTaskContainer.this), 0, 300);
                }
                FrsStarRankAndTaskContainer.this.handler.removeCallbacksAndMessages(null);
                FrsStarRankAndTaskContainer.this.handler.postDelayed(this, 3000L);
            }
        };
        this.mRunnable = new Runnable() { // from class: com.baidu.tieba.frs.view.FrsStarRankAndTaskContainer.4
            @Override // java.lang.Runnable
            public void run() {
                FrsStarRankAndTaskContainer.this.dKR.setSelection(FrsStarRankAndTaskContainer.this.dKU);
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
        aBr();
    }

    private void init() {
        Context context = getContext();
        setOrientation(0);
        setPadding(l.f(context, d.e.tbds35), l.f(context, d.e.tbds30), l.f(context, d.e.tbds35), 0);
        LayoutInflater.from(getContext()).inflate(d.h.view_frs_star_rank_and_task, (ViewGroup) this, true);
        this.dKL = (TextView) findViewById(d.g.rank_number);
        this.dKM = (TextView) findViewById(d.g.user_contributions);
        this.dKN = (TextView) findViewById(d.g.star_task);
        this.dKO = (ImageView) findViewById(d.g.image_rank_icon);
        this.dKQ = (ViewGroup) findViewById(d.g.task_container);
        this.dKP = (ViewGroup) findViewById(d.g.rank_container);
        this.dKQ.setOnClickListener(this);
        this.dKP.setOnClickListener(this);
        this.dKR = (ListView) findViewById(d.g.rank_scroll);
        this.dKR.setClickable(false);
        this.dKR.setFocusable(false);
        this.dKR.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.frs.view.FrsStarRankAndTaskContainer.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (FrsStarRankAndTaskContainer.this.dKP != null) {
                    FrsStarRankAndTaskContainer.this.dKP.performClick();
                }
            }
        });
        this.dKR.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.frs.view.FrsStarRankAndTaskContainer.3
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
        this.dKS = new a(getContext());
        this.dKR.setAdapter((ListAdapter) this.dKS);
        onChangeSkinType();
    }

    public void setData(StarRank starRank) {
        String string;
        int i;
        if (starRank != null) {
            this.dKA = starRank;
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
            this.dKL.setText(string);
            this.dKM.setText(starRank.user_task_notice);
            if (!w.z(this.dKA.user_task_info)) {
                int size = this.dKA.user_task_info.size();
                int i2 = 0;
                int i3 = 0;
                while (i2 < size) {
                    if (this.dKA.user_task_info.get(i2) == null) {
                        i = i3;
                    } else {
                        i = this.dKA.user_task_info.get(i2).task_status.intValue() == 1 ? i3 + 1 : i3;
                    }
                    i2++;
                    i3 = i;
                }
                this.dKN.setText(String.format(Locale.CHINA, getResources().getString(d.j.see_task), Integer.valueOf(i3), Integer.valueOf(size)));
            } else {
                this.dKN.setText(d.j.no_have_task);
            }
            this.dKS.setData(starRank.contri_record_list);
            aBr();
        }
    }

    public void aBr() {
        if (this.dKS.getCount() != 0) {
            this.handler.removeCallbacks(this.dKV);
            this.handler.postDelayed(this.dKV, 3000L);
        }
    }

    public void onChangeSkinType() {
        am.h(this.dKL, d.C0140d.cp_cont_i);
        am.c(this.dKO, d.f.icon_frs_idol_ranking);
        am.i(this.dKP, d.f.bg_fts_star_rank_entrance);
        am.i(this.dKQ, d.f.bg_frs_star_task_entrance);
        this.dKN.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, am.getDrawable(d.f.icon_arrow12_white_right), (Drawable) null);
        am.h(this.dKN, d.C0140d.cp_cont_i);
        am.h(this.dKM, d.C0140d.cp_cont_i);
        this.dKS.notifyDataSetChanged();
        if (this.dKT != null) {
            this.dKT.aBq();
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
                view = LayoutInflater.from(this.mContext).inflate(d.h.item_star_rank_user_contri, viewGroup, false);
                bVar = new b();
                bVar.dKX = (TextView) view.findViewById(d.g.contri_desc);
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
            bVar.dKX.setText(starContriRecord.record_notice);
            bVar.tvUserName.requestLayout();
            if (UtilHelper.isCurrentAccount(String.valueOf(starContriRecord.user_id))) {
                am.h(bVar.dKX, d.C0140d.common_color_10326);
                am.h(bVar.tvUserName, d.C0140d.common_color_10326);
                return view;
            }
            am.h(bVar.dKX, d.C0140d.cp_cont_i);
            am.h(bVar.tvUserName, d.C0140d.cp_cont_i);
            return view;
        }
    }

    /* loaded from: classes2.dex */
    private static class b {
        TextView dKX;
        TextView tvUserName;

        private b() {
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.dKQ) {
            TiebaStatic.log(new an("c12880"));
            if (ba.aV(getContext())) {
                if (this.dKT == null) {
                    this.dKT = new d();
                }
                this.dKT.a(getContext(), this.dKA);
            }
        } else if (view == this.dKP) {
            if (this.mTbPageContext != null && this.dKA != null) {
                this.mTbPageContext.sendMessage(new CustomMessage(2002001, new ShareWebActivityConfig(this.mTbPageContext.getContext(), "", this.dKA.url, true)));
            }
            TiebaStatic.log(new an("c12879"));
        }
    }

    public void setContext(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
    }
}
