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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import tbclient.FrsPage.StarContriRecord;
import tbclient.FrsPage.StarRank;
/* loaded from: classes2.dex */
public class FrsStarRankAndTaskContainer extends LinearLayout implements View.OnClickListener {
    private StarRank dvd;
    private TextView dvo;
    private TextView dvp;
    private TextView dvq;
    private ImageView dvr;
    private ViewGroup dvs;
    private ViewGroup dvt;
    private ListView dvu;
    private a dvv;
    private d dvw;
    private int dvx;
    private Runnable dvy;
    private Handler handler;
    private Runnable mRunnable;
    private TbPageContext mTbPageContext;

    static /* synthetic */ int b(FrsStarRankAndTaskContainer frsStarRankAndTaskContainer) {
        int i = frsStarRankAndTaskContainer.dvx + 1;
        frsStarRankAndTaskContainer.dvx = i;
        return i;
    }

    public FrsStarRankAndTaskContainer(Context context) {
        this(context, null);
    }

    public FrsStarRankAndTaskContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.handler = new Handler();
        this.dvx = 0;
        this.dvy = new Runnable() { // from class: com.baidu.tieba.frs.view.FrsStarRankAndTaskContainer.1
            @Override // java.lang.Runnable
            public void run() {
                if (FrsStarRankAndTaskContainer.this.dvu != null) {
                    FrsStarRankAndTaskContainer.this.dvu.smoothScrollToPositionFromTop(FrsStarRankAndTaskContainer.b(FrsStarRankAndTaskContainer.this), 0, 300);
                }
                FrsStarRankAndTaskContainer.this.handler.removeCallbacksAndMessages(null);
                FrsStarRankAndTaskContainer.this.handler.postDelayed(this, 3000L);
            }
        };
        this.mRunnable = new Runnable() { // from class: com.baidu.tieba.frs.view.FrsStarRankAndTaskContainer.4
            @Override // java.lang.Runnable
            public void run() {
                FrsStarRankAndTaskContainer.this.dvu.setSelection(FrsStarRankAndTaskContainer.this.dvx);
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
        avS();
    }

    private void init() {
        Context context = getContext();
        setOrientation(0);
        setPadding(l.e(context, d.e.tbds35), l.e(context, d.e.tbds30), l.e(context, d.e.tbds35), 0);
        LayoutInflater.from(getContext()).inflate(d.i.view_frs_star_rank_and_task, (ViewGroup) this, true);
        this.dvo = (TextView) findViewById(d.g.rank_number);
        this.dvp = (TextView) findViewById(d.g.user_contributions);
        this.dvq = (TextView) findViewById(d.g.star_task);
        this.dvr = (ImageView) findViewById(d.g.image_rank_icon);
        this.dvt = (ViewGroup) findViewById(d.g.task_container);
        this.dvs = (ViewGroup) findViewById(d.g.rank_container);
        this.dvt.setOnClickListener(this);
        this.dvs.setOnClickListener(this);
        this.dvu = (ListView) findViewById(d.g.rank_scroll);
        this.dvu.setClickable(false);
        this.dvu.setFocusable(false);
        this.dvu.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.frs.view.FrsStarRankAndTaskContainer.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
                if (FrsStarRankAndTaskContainer.this.dvs != null) {
                    FrsStarRankAndTaskContainer.this.dvs.performClick();
                }
            }
        });
        this.dvu.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.frs.view.FrsStarRankAndTaskContainer.3
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
        this.dvv = new a(getContext());
        this.dvu.setAdapter((ListAdapter) this.dvv);
        onChangeSkinType();
    }

    public void setData(StarRank starRank) {
        String string;
        int i;
        if (starRank != null) {
            this.dvd = starRank;
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
            this.dvo.setText(string);
            this.dvp.setText(starRank.user_task_notice);
            if (!v.w(this.dvd.user_task_info)) {
                int size = this.dvd.user_task_info.size();
                int i2 = 0;
                int i3 = 0;
                while (i2 < size) {
                    if (this.dvd.user_task_info.get(i2) == null) {
                        i = i3;
                    } else {
                        i = this.dvd.user_task_info.get(i2).task_status.intValue() == 1 ? i3 + 1 : i3;
                    }
                    i2++;
                    i3 = i;
                }
                this.dvq.setText(String.format(Locale.CHINA, getResources().getString(d.k.see_task), Integer.valueOf(i3), Integer.valueOf(size)));
            } else {
                this.dvq.setText(d.k.no_have_task);
            }
            this.dvv.setData(starRank.contri_record_list);
            avS();
        }
    }

    public void avS() {
        if (this.dvv.getCount() != 0) {
            this.handler.removeCallbacks(this.dvy);
            this.handler.postDelayed(this.dvy, 3000L);
        }
    }

    public void onChangeSkinType() {
        ak.h(this.dvo, d.C0126d.cp_cont_i);
        ak.c(this.dvr, d.f.icon_frs_idol_ranking);
        ak.i(this.dvs, d.f.bg_fts_star_rank_entrance);
        ak.i(this.dvt, d.f.bg_frs_star_task_entrance);
        this.dvq.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ak.getDrawable(d.f.icon_arrow12_white_right), (Drawable) null);
        ak.h(this.dvq, d.C0126d.cp_cont_i);
        ak.h(this.dvp, d.C0126d.cp_cont_i);
        this.dvv.notifyDataSetChanged();
        if (this.dvw != null) {
            this.dvw.avR();
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
            if (!v.w(list)) {
                this.data.clear();
                this.data.addAll(list);
                notifyDataSetChanged();
            }
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (v.w(this.data)) {
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
        public View getView(int i, View view2, ViewGroup viewGroup) {
            b bVar;
            if (view2 == null) {
                view2 = LayoutInflater.from(this.mContext).inflate(d.i.item_star_rank_user_contri, viewGroup, false);
                bVar = new b();
                bVar.dvA = (TextView) view2.findViewById(d.g.contri_desc);
                bVar.tvUserName = (TextView) view2.findViewById(d.g.contri_username);
                view2.setTag(bVar);
            } else {
                bVar = (b) view2.getTag();
            }
            StarContriRecord starContriRecord = this.data.get(i % this.data.size());
            if (starContriRecord == null) {
                return null;
            }
            bVar.tvUserName.setText(starContriRecord.user_name);
            bVar.dvA.setText(starContriRecord.record_notice);
            bVar.tvUserName.requestLayout();
            if (UtilHelper.isCurrentAccount(String.valueOf(starContriRecord.user_id))) {
                ak.h(bVar.dvA, d.C0126d.common_color_10326);
                ak.h(bVar.tvUserName, d.C0126d.common_color_10326);
                return view2;
            }
            ak.h(bVar.dvA, d.C0126d.cp_cont_i);
            ak.h(bVar.tvUserName, d.C0126d.cp_cont_i);
            return view2;
        }
    }

    /* loaded from: classes2.dex */
    private static class b {
        TextView dvA;
        TextView tvUserName;

        private b() {
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        if (view2 == this.dvt) {
            TiebaStatic.log(new al("c12880"));
            if (az.aK(getContext())) {
                if (this.dvw == null) {
                    this.dvw = new d();
                }
                this.dvw.a(getContext(), this.dvd);
            }
        } else if (view2 == this.dvs) {
            if (this.mTbPageContext != null && this.dvd != null) {
                this.mTbPageContext.sendMessage(new CustomMessage(2002001, new ShareWebActivityConfig(this.mTbPageContext.getContext(), "", this.dvd.url, true)));
            }
            TiebaStatic.log(new al("c12879"));
        }
    }

    public void setContext(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
    }
}
