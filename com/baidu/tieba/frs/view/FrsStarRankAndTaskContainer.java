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
    private StarRank dYY;
    private TextView dZi;
    private TextView dZj;
    private TextView dZk;
    private ImageView dZl;
    private ViewGroup dZm;
    private ViewGroup dZn;
    private ListView dZo;
    private a dZp;
    private f dZq;
    private int dZr;
    private Runnable dZs;
    private Handler handler;
    private Runnable mRunnable;
    private TbPageContext mTbPageContext;

    static /* synthetic */ int b(FrsStarRankAndTaskContainer frsStarRankAndTaskContainer) {
        int i = frsStarRankAndTaskContainer.dZr + 1;
        frsStarRankAndTaskContainer.dZr = i;
        return i;
    }

    public FrsStarRankAndTaskContainer(Context context) {
        this(context, null);
    }

    public FrsStarRankAndTaskContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.handler = new Handler();
        this.dZr = 0;
        this.dZs = new Runnable() { // from class: com.baidu.tieba.frs.view.FrsStarRankAndTaskContainer.1
            @Override // java.lang.Runnable
            public void run() {
                if (FrsStarRankAndTaskContainer.this.dZo != null) {
                    FrsStarRankAndTaskContainer.this.dZo.smoothScrollToPositionFromTop(FrsStarRankAndTaskContainer.b(FrsStarRankAndTaskContainer.this), 0, 300);
                }
                FrsStarRankAndTaskContainer.this.handler.removeCallbacksAndMessages(null);
                FrsStarRankAndTaskContainer.this.handler.postDelayed(this, 3000L);
            }
        };
        this.mRunnable = new Runnable() { // from class: com.baidu.tieba.frs.view.FrsStarRankAndTaskContainer.4
            @Override // java.lang.Runnable
            public void run() {
                FrsStarRankAndTaskContainer.this.dZo.setSelection(FrsStarRankAndTaskContainer.this.dZr);
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
        aAW();
    }

    private void init() {
        Context context = getContext();
        setOrientation(0);
        setPadding(l.t(context, d.e.tbds35), l.t(context, d.e.tbds30), l.t(context, d.e.tbds35), 0);
        LayoutInflater.from(getContext()).inflate(d.h.view_frs_star_rank_and_task, (ViewGroup) this, true);
        this.dZi = (TextView) findViewById(d.g.rank_number);
        this.dZj = (TextView) findViewById(d.g.user_contributions);
        this.dZk = (TextView) findViewById(d.g.star_task);
        this.dZl = (ImageView) findViewById(d.g.image_rank_icon);
        this.dZn = (ViewGroup) findViewById(d.g.task_container);
        this.dZm = (ViewGroup) findViewById(d.g.rank_container);
        this.dZn.setOnClickListener(this);
        this.dZm.setOnClickListener(this);
        this.dZo = (ListView) findViewById(d.g.rank_scroll);
        this.dZo.setClickable(false);
        this.dZo.setFocusable(false);
        this.dZo.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.frs.view.FrsStarRankAndTaskContainer.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (FrsStarRankAndTaskContainer.this.dZm != null) {
                    FrsStarRankAndTaskContainer.this.dZm.performClick();
                }
            }
        });
        this.dZo.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.frs.view.FrsStarRankAndTaskContainer.3
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
        this.dZp = new a(getContext());
        this.dZo.setAdapter((ListAdapter) this.dZp);
        onChangeSkinType();
    }

    public void setData(StarRank starRank) {
        String string;
        int i;
        if (starRank != null) {
            this.dYY = starRank;
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
            this.dZi.setText(string);
            this.dZj.setText(starRank.user_task_notice);
            if (!v.E(this.dYY.user_task_info)) {
                int size = this.dYY.user_task_info.size();
                int i2 = 0;
                int i3 = 0;
                while (i2 < size) {
                    if (this.dYY.user_task_info.get(i2) == null) {
                        i = i3;
                    } else {
                        i = this.dYY.user_task_info.get(i2).task_status.intValue() == 1 ? i3 + 1 : i3;
                    }
                    i2++;
                    i3 = i;
                }
                this.dZk.setText(String.format(Locale.CHINA, getResources().getString(d.j.see_task), Integer.valueOf(i3), Integer.valueOf(size)));
            } else {
                this.dZk.setText(d.j.no_have_task);
            }
            this.dZp.setData(starRank.contri_record_list);
            aAW();
        }
    }

    public void aAW() {
        if (this.dZp.getCount() != 0) {
            this.handler.removeCallbacks(this.dZs);
            this.handler.postDelayed(this.dZs, 3000L);
        }
    }

    public void onChangeSkinType() {
        aj.r(this.dZi, d.C0141d.cp_cont_i);
        aj.c(this.dZl, d.f.icon_frs_idol_ranking);
        aj.s(this.dZm, d.f.bg_fts_star_rank_entrance);
        aj.s(this.dZn, d.f.bg_frs_star_task_entrance);
        this.dZk.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, aj.getDrawable(d.f.icon_arrow12_white_right), (Drawable) null);
        aj.r(this.dZk, d.C0141d.cp_cont_i);
        aj.r(this.dZj, d.C0141d.cp_cont_i);
        this.dZp.notifyDataSetChanged();
        if (this.dZq != null) {
            this.dZq.aAV();
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
                bVar.dZu = (TextView) view.findViewById(d.g.contri_desc);
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
            bVar.dZu.setText(starContriRecord.record_notice);
            bVar.tvUserName.requestLayout();
            if (UtilHelper.isCurrentAccount(String.valueOf(starContriRecord.user_id))) {
                aj.r(bVar.dZu, d.C0141d.common_color_10326);
                aj.r(bVar.tvUserName, d.C0141d.common_color_10326);
                return view;
            }
            aj.r(bVar.dZu, d.C0141d.cp_cont_i);
            aj.r(bVar.tvUserName, d.C0141d.cp_cont_i);
            return view;
        }
    }

    /* loaded from: classes2.dex */
    private static class b {
        TextView dZu;
        TextView tvUserName;

        private b() {
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.dZn) {
            TiebaStatic.log(new ak("c12880"));
            if (ay.ba(getContext())) {
                if (this.dZq == null) {
                    this.dZq = new f();
                }
                this.dZq.a(getContext(), this.dYY);
            }
        } else if (view == this.dZm) {
            if (this.mTbPageContext != null && this.dYY != null) {
                this.mTbPageContext.sendMessage(new CustomMessage(2002001, new ShareWebActivityConfig(this.mTbPageContext.getContext(), "", this.dYY.url, true)));
            }
            TiebaStatic.log(new ak("c12879"));
        }
    }

    public void setContext(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
    }
}
