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
import com.baidu.tbadk.core.util.bb;
import com.baidu.tbadk.core.util.w;
import com.baidu.tieba.f;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import tbclient.FrsPage.StarContriRecord;
import tbclient.FrsPage.StarRank;
/* loaded from: classes2.dex */
public class FrsStarRankAndTaskContainer extends LinearLayout implements View.OnClickListener {
    private TextView dKH;
    private TextView dKI;
    private TextView dKJ;
    private ImageView dKK;
    private ViewGroup dKL;
    private ViewGroup dKM;
    private ListView dKN;
    private a dKO;
    private d dKP;
    private int dKQ;
    private Runnable dKR;
    private StarRank dKw;
    private Handler handler;
    private Runnable mRunnable;
    private TbPageContext mTbPageContext;

    static /* synthetic */ int b(FrsStarRankAndTaskContainer frsStarRankAndTaskContainer) {
        int i = frsStarRankAndTaskContainer.dKQ + 1;
        frsStarRankAndTaskContainer.dKQ = i;
        return i;
    }

    public FrsStarRankAndTaskContainer(Context context) {
        this(context, null);
    }

    public FrsStarRankAndTaskContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.handler = new Handler();
        this.dKQ = 0;
        this.dKR = new Runnable() { // from class: com.baidu.tieba.frs.view.FrsStarRankAndTaskContainer.1
            @Override // java.lang.Runnable
            public void run() {
                if (FrsStarRankAndTaskContainer.this.dKN != null) {
                    FrsStarRankAndTaskContainer.this.dKN.smoothScrollToPositionFromTop(FrsStarRankAndTaskContainer.b(FrsStarRankAndTaskContainer.this), 0, 300);
                }
                FrsStarRankAndTaskContainer.this.handler.removeCallbacksAndMessages(null);
                FrsStarRankAndTaskContainer.this.handler.postDelayed(this, 3000L);
            }
        };
        this.mRunnable = new Runnable() { // from class: com.baidu.tieba.frs.view.FrsStarRankAndTaskContainer.4
            @Override // java.lang.Runnable
            public void run() {
                FrsStarRankAndTaskContainer.this.dKN.setSelection(FrsStarRankAndTaskContainer.this.dKQ);
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
        aBo();
    }

    private void init() {
        Context context = getContext();
        setOrientation(0);
        setPadding(l.f(context, f.e.tbds35), l.f(context, f.e.tbds30), l.f(context, f.e.tbds35), 0);
        LayoutInflater.from(getContext()).inflate(f.h.view_frs_star_rank_and_task, (ViewGroup) this, true);
        this.dKH = (TextView) findViewById(f.g.rank_number);
        this.dKI = (TextView) findViewById(f.g.user_contributions);
        this.dKJ = (TextView) findViewById(f.g.star_task);
        this.dKK = (ImageView) findViewById(f.g.image_rank_icon);
        this.dKM = (ViewGroup) findViewById(f.g.task_container);
        this.dKL = (ViewGroup) findViewById(f.g.rank_container);
        this.dKM.setOnClickListener(this);
        this.dKL.setOnClickListener(this);
        this.dKN = (ListView) findViewById(f.g.rank_scroll);
        this.dKN.setClickable(false);
        this.dKN.setFocusable(false);
        this.dKN.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.frs.view.FrsStarRankAndTaskContainer.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (FrsStarRankAndTaskContainer.this.dKL != null) {
                    FrsStarRankAndTaskContainer.this.dKL.performClick();
                }
            }
        });
        this.dKN.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.frs.view.FrsStarRankAndTaskContainer.3
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
        this.dKO = new a(getContext());
        this.dKN.setAdapter((ListAdapter) this.dKO);
        onChangeSkinType();
    }

    public void setData(StarRank starRank) {
        String string;
        int i;
        if (starRank != null) {
            this.dKw = starRank;
            if (starRank.rank_ranking.intValue() > 0 && starRank.rank_ranking.intValue() <= 1000) {
                Locale locale = Locale.CHINA;
                String string2 = getResources().getString(f.j.star_rank_number);
                Object[] objArr = new Object[2];
                objArr[0] = StringUtils.isNull(starRank.rank_name) ? getResources().getString(f.j.affect_bang) : starRank.rank_name;
                objArr[1] = starRank.rank_ranking;
                string = String.format(locale, string2, objArr);
            } else {
                string = getResources().getString(f.j.no_bang);
            }
            this.dKH.setText(string);
            this.dKI.setText(starRank.user_task_notice);
            if (!w.z(this.dKw.user_task_info)) {
                int size = this.dKw.user_task_info.size();
                int i2 = 0;
                int i3 = 0;
                while (i2 < size) {
                    if (this.dKw.user_task_info.get(i2) == null) {
                        i = i3;
                    } else {
                        i = this.dKw.user_task_info.get(i2).task_status.intValue() == 1 ? i3 + 1 : i3;
                    }
                    i2++;
                    i3 = i;
                }
                this.dKJ.setText(String.format(Locale.CHINA, getResources().getString(f.j.see_task), Integer.valueOf(i3), Integer.valueOf(size)));
            } else {
                this.dKJ.setText(f.j.no_have_task);
            }
            this.dKO.setData(starRank.contri_record_list);
            aBo();
        }
    }

    public void aBo() {
        if (this.dKO.getCount() != 0) {
            this.handler.removeCallbacks(this.dKR);
            this.handler.postDelayed(this.dKR, 3000L);
        }
    }

    public void onChangeSkinType() {
        am.h(this.dKH, f.d.cp_cont_i);
        am.c(this.dKK, f.C0146f.icon_frs_idol_ranking);
        am.i(this.dKL, f.C0146f.bg_fts_star_rank_entrance);
        am.i(this.dKM, f.C0146f.bg_frs_star_task_entrance);
        this.dKJ.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, am.getDrawable(f.C0146f.icon_arrow12_white_right), (Drawable) null);
        am.h(this.dKJ, f.d.cp_cont_i);
        am.h(this.dKI, f.d.cp_cont_i);
        this.dKO.notifyDataSetChanged();
        if (this.dKP != null) {
            this.dKP.aBn();
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
                view = LayoutInflater.from(this.mContext).inflate(f.h.item_star_rank_user_contri, viewGroup, false);
                bVar = new b();
                bVar.dKT = (TextView) view.findViewById(f.g.contri_desc);
                bVar.tvUserName = (TextView) view.findViewById(f.g.contri_username);
                view.setTag(bVar);
            } else {
                bVar = (b) view.getTag();
            }
            StarContriRecord starContriRecord = this.data.get(i % this.data.size());
            if (starContriRecord == null) {
                return null;
            }
            bVar.tvUserName.setText(starContriRecord.user_name);
            bVar.dKT.setText(starContriRecord.record_notice);
            bVar.tvUserName.requestLayout();
            if (UtilHelper.isCurrentAccount(String.valueOf(starContriRecord.user_id))) {
                am.h(bVar.dKT, f.d.common_color_10326);
                am.h(bVar.tvUserName, f.d.common_color_10326);
                return view;
            }
            am.h(bVar.dKT, f.d.cp_cont_i);
            am.h(bVar.tvUserName, f.d.cp_cont_i);
            return view;
        }
    }

    /* loaded from: classes2.dex */
    private static class b {
        TextView dKT;
        TextView tvUserName;

        private b() {
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.dKM) {
            TiebaStatic.log(new an("c12880"));
            if (bb.aU(getContext())) {
                if (this.dKP == null) {
                    this.dKP = new d();
                }
                this.dKP.a(getContext(), this.dKw);
            }
        } else if (view == this.dKL) {
            if (this.mTbPageContext != null && this.dKw != null) {
                this.mTbPageContext.sendMessage(new CustomMessage(2002001, new ShareWebActivityConfig(this.mTbPageContext.getContext(), "", this.dKw.url, true)));
            }
            TiebaStatic.log(new an("c12879"));
        }
    }

    public void setContext(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
    }
}
