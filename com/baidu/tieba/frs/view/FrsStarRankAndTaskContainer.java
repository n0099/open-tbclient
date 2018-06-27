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
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import tbclient.FrsPage.StarContriRecord;
import tbclient.FrsPage.StarRank;
/* loaded from: classes2.dex */
public class FrsStarRankAndTaskContainer extends LinearLayout implements View.OnClickListener {
    private StarRank dHL;
    private TextView dHW;
    private TextView dHX;
    private TextView dHY;
    private ImageView dHZ;
    private ViewGroup dIa;
    private ViewGroup dIb;
    private ListView dIc;
    private a dId;
    private d dIe;
    private int dIf;
    private Runnable dIg;
    private Handler handler;
    private Runnable mRunnable;
    private TbPageContext mTbPageContext;

    static /* synthetic */ int b(FrsStarRankAndTaskContainer frsStarRankAndTaskContainer) {
        int i = frsStarRankAndTaskContainer.dIf + 1;
        frsStarRankAndTaskContainer.dIf = i;
        return i;
    }

    public FrsStarRankAndTaskContainer(Context context) {
        this(context, null);
    }

    public FrsStarRankAndTaskContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.handler = new Handler();
        this.dIf = 0;
        this.dIg = new Runnable() { // from class: com.baidu.tieba.frs.view.FrsStarRankAndTaskContainer.1
            @Override // java.lang.Runnable
            public void run() {
                if (FrsStarRankAndTaskContainer.this.dIc != null) {
                    FrsStarRankAndTaskContainer.this.dIc.smoothScrollToPositionFromTop(FrsStarRankAndTaskContainer.b(FrsStarRankAndTaskContainer.this), 0, 300);
                }
                FrsStarRankAndTaskContainer.this.handler.removeCallbacksAndMessages(null);
                FrsStarRankAndTaskContainer.this.handler.postDelayed(this, 3000L);
            }
        };
        this.mRunnable = new Runnable() { // from class: com.baidu.tieba.frs.view.FrsStarRankAndTaskContainer.4
            @Override // java.lang.Runnable
            public void run() {
                FrsStarRankAndTaskContainer.this.dIc.setSelection(FrsStarRankAndTaskContainer.this.dIf);
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
        aAI();
    }

    private void init() {
        Context context = getContext();
        setOrientation(0);
        setPadding(l.e(context, d.e.tbds35), l.e(context, d.e.tbds30), l.e(context, d.e.tbds35), 0);
        LayoutInflater.from(getContext()).inflate(d.i.view_frs_star_rank_and_task, (ViewGroup) this, true);
        this.dHW = (TextView) findViewById(d.g.rank_number);
        this.dHX = (TextView) findViewById(d.g.user_contributions);
        this.dHY = (TextView) findViewById(d.g.star_task);
        this.dHZ = (ImageView) findViewById(d.g.image_rank_icon);
        this.dIb = (ViewGroup) findViewById(d.g.task_container);
        this.dIa = (ViewGroup) findViewById(d.g.rank_container);
        this.dIb.setOnClickListener(this);
        this.dIa.setOnClickListener(this);
        this.dIc = (ListView) findViewById(d.g.rank_scroll);
        this.dIc.setClickable(false);
        this.dIc.setFocusable(false);
        this.dIc.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.frs.view.FrsStarRankAndTaskContainer.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (FrsStarRankAndTaskContainer.this.dIa != null) {
                    FrsStarRankAndTaskContainer.this.dIa.performClick();
                }
            }
        });
        this.dIc.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.frs.view.FrsStarRankAndTaskContainer.3
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
        this.dId = new a(getContext());
        this.dIc.setAdapter((ListAdapter) this.dId);
        onChangeSkinType();
    }

    public void setData(StarRank starRank) {
        String string;
        int i;
        if (starRank != null) {
            this.dHL = starRank;
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
            this.dHW.setText(string);
            this.dHX.setText(starRank.user_task_notice);
            if (!w.A(this.dHL.user_task_info)) {
                int size = this.dHL.user_task_info.size();
                int i2 = 0;
                int i3 = 0;
                while (i2 < size) {
                    if (this.dHL.user_task_info.get(i2) == null) {
                        i = i3;
                    } else {
                        i = this.dHL.user_task_info.get(i2).task_status.intValue() == 1 ? i3 + 1 : i3;
                    }
                    i2++;
                    i3 = i;
                }
                this.dHY.setText(String.format(Locale.CHINA, getResources().getString(d.k.see_task), Integer.valueOf(i3), Integer.valueOf(size)));
            } else {
                this.dHY.setText(d.k.no_have_task);
            }
            this.dId.setData(starRank.contri_record_list);
            aAI();
        }
    }

    public void aAI() {
        if (this.dId.getCount() != 0) {
            this.handler.removeCallbacks(this.dIg);
            this.handler.postDelayed(this.dIg, 3000L);
        }
    }

    public void onChangeSkinType() {
        am.h(this.dHW, d.C0142d.cp_cont_i);
        am.c(this.dHZ, d.f.icon_frs_idol_ranking);
        am.i(this.dIa, d.f.bg_fts_star_rank_entrance);
        am.i(this.dIb, d.f.bg_frs_star_task_entrance);
        this.dHY.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, am.getDrawable(d.f.icon_arrow12_white_right), (Drawable) null);
        am.h(this.dHY, d.C0142d.cp_cont_i);
        am.h(this.dHX, d.C0142d.cp_cont_i);
        this.dId.notifyDataSetChanged();
        if (this.dIe != null) {
            this.dIe.aAH();
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
            if (!w.A(list)) {
                this.data.clear();
                this.data.addAll(list);
                notifyDataSetChanged();
            }
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (w.A(this.data)) {
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
                bVar.dIi = (TextView) view.findViewById(d.g.contri_desc);
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
            bVar.dIi.setText(starContriRecord.record_notice);
            bVar.tvUserName.requestLayout();
            if (UtilHelper.isCurrentAccount(String.valueOf(starContriRecord.user_id))) {
                am.h(bVar.dIi, d.C0142d.common_color_10326);
                am.h(bVar.tvUserName, d.C0142d.common_color_10326);
                return view;
            }
            am.h(bVar.dIi, d.C0142d.cp_cont_i);
            am.h(bVar.tvUserName, d.C0142d.cp_cont_i);
            return view;
        }
    }

    /* loaded from: classes2.dex */
    private static class b {
        TextView dIi;
        TextView tvUserName;

        private b() {
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.dIb) {
            TiebaStatic.log(new an("c12880"));
            if (bb.aU(getContext())) {
                if (this.dIe == null) {
                    this.dIe = new d();
                }
                this.dIe.a(getContext(), this.dHL);
            }
        } else if (view == this.dIa) {
            if (this.mTbPageContext != null && this.dHL != null) {
                this.mTbPageContext.sendMessage(new CustomMessage(2002001, new ShareWebActivityConfig(this.mTbPageContext.getContext(), "", this.dHL.url, true)));
            }
            TiebaStatic.log(new an("c12879"));
        }
    }

    public void setContext(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
    }
}
