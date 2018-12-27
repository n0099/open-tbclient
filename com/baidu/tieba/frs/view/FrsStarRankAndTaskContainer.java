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
    private TextView ekA;
    private ImageView ekB;
    private ViewGroup ekC;
    private ViewGroup ekD;
    private ListView ekE;
    private a ekF;
    private d ekG;
    private int ekH;
    private Runnable ekI;
    private StarRank ekp;
    private TextView eky;
    private TextView ekz;
    private Handler handler;
    private Runnable mRunnable;
    private TbPageContext mTbPageContext;

    static /* synthetic */ int b(FrsStarRankAndTaskContainer frsStarRankAndTaskContainer) {
        int i = frsStarRankAndTaskContainer.ekH + 1;
        frsStarRankAndTaskContainer.ekH = i;
        return i;
    }

    public FrsStarRankAndTaskContainer(Context context) {
        this(context, null);
    }

    public FrsStarRankAndTaskContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.handler = new Handler();
        this.ekH = 0;
        this.ekI = new Runnable() { // from class: com.baidu.tieba.frs.view.FrsStarRankAndTaskContainer.1
            @Override // java.lang.Runnable
            public void run() {
                if (FrsStarRankAndTaskContainer.this.ekE != null) {
                    FrsStarRankAndTaskContainer.this.ekE.smoothScrollToPositionFromTop(FrsStarRankAndTaskContainer.b(FrsStarRankAndTaskContainer.this), 0, 300);
                }
                FrsStarRankAndTaskContainer.this.handler.removeCallbacksAndMessages(null);
                FrsStarRankAndTaskContainer.this.handler.postDelayed(this, 3000L);
            }
        };
        this.mRunnable = new Runnable() { // from class: com.baidu.tieba.frs.view.FrsStarRankAndTaskContainer.4
            @Override // java.lang.Runnable
            public void run() {
                FrsStarRankAndTaskContainer.this.ekE.setSelection(FrsStarRankAndTaskContainer.this.ekH);
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
        aIQ();
    }

    private void init() {
        Context context = getContext();
        setOrientation(0);
        setPadding(l.h(context, e.C0210e.tbds35), l.h(context, e.C0210e.tbds30), l.h(context, e.C0210e.tbds35), 0);
        LayoutInflater.from(getContext()).inflate(e.h.view_frs_star_rank_and_task, (ViewGroup) this, true);
        this.eky = (TextView) findViewById(e.g.rank_number);
        this.ekz = (TextView) findViewById(e.g.user_contributions);
        this.ekA = (TextView) findViewById(e.g.star_task);
        this.ekB = (ImageView) findViewById(e.g.image_rank_icon);
        this.ekD = (ViewGroup) findViewById(e.g.task_container);
        this.ekC = (ViewGroup) findViewById(e.g.rank_container);
        this.ekD.setOnClickListener(this);
        this.ekC.setOnClickListener(this);
        this.ekE = (ListView) findViewById(e.g.rank_scroll);
        this.ekE.setClickable(false);
        this.ekE.setFocusable(false);
        this.ekE.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.frs.view.FrsStarRankAndTaskContainer.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (FrsStarRankAndTaskContainer.this.ekC != null) {
                    FrsStarRankAndTaskContainer.this.ekC.performClick();
                }
            }
        });
        this.ekE.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.frs.view.FrsStarRankAndTaskContainer.3
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
        this.ekF = new a(getContext());
        this.ekE.setAdapter((ListAdapter) this.ekF);
        onChangeSkinType();
    }

    public void setData(StarRank starRank) {
        String string;
        int i;
        if (starRank != null) {
            this.ekp = starRank;
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
            this.eky.setText(string);
            this.ekz.setText(starRank.user_task_notice);
            if (!v.I(this.ekp.user_task_info)) {
                int size = this.ekp.user_task_info.size();
                int i2 = 0;
                int i3 = 0;
                while (i2 < size) {
                    if (this.ekp.user_task_info.get(i2) == null) {
                        i = i3;
                    } else {
                        i = this.ekp.user_task_info.get(i2).task_status.intValue() == 1 ? i3 + 1 : i3;
                    }
                    i2++;
                    i3 = i;
                }
                this.ekA.setText(String.format(Locale.CHINA, getResources().getString(e.j.see_task), Integer.valueOf(i3), Integer.valueOf(size)));
            } else {
                this.ekA.setText(e.j.no_have_task);
            }
            this.ekF.setData(starRank.contri_record_list);
            aIQ();
        }
    }

    public void aIQ() {
        if (this.ekF.getCount() != 0) {
            this.handler.removeCallbacks(this.ekI);
            this.handler.postDelayed(this.ekI, 3000L);
        }
    }

    public void onChangeSkinType() {
        al.h(this.eky, e.d.cp_cont_i);
        al.c(this.ekB, e.f.icon_frs_idol_ranking);
        al.i(this.ekC, e.f.bg_fts_star_rank_entrance);
        al.i(this.ekD, e.f.bg_frs_star_task_entrance);
        this.ekA.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, al.getDrawable(e.f.icon_arrow12_white_right), (Drawable) null);
        al.h(this.ekA, e.d.cp_cont_i);
        al.h(this.ekz, e.d.cp_cont_i);
        this.ekF.notifyDataSetChanged();
        if (this.ekG != null) {
            this.ekG.aIP();
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
                bVar.ekK = (TextView) view.findViewById(e.g.contri_desc);
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
            bVar.ekK.setText(starContriRecord.record_notice);
            bVar.tvUserName.requestLayout();
            if (UtilHelper.isCurrentAccount(String.valueOf(starContriRecord.user_id))) {
                al.h(bVar.ekK, e.d.common_color_10326);
                al.h(bVar.tvUserName, e.d.common_color_10326);
                return view;
            }
            al.h(bVar.ekK, e.d.cp_cont_i);
            al.h(bVar.tvUserName, e.d.cp_cont_i);
            return view;
        }
    }

    /* loaded from: classes6.dex */
    private static class b {
        TextView ekK;
        TextView tvUserName;

        private b() {
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.ekD) {
            TiebaStatic.log(new am("c12880"));
            if (ba.bJ(getContext())) {
                if (this.ekG == null) {
                    this.ekG = new d();
                }
                this.ekG.a(getContext(), this.ekp);
            }
        } else if (view == this.ekC) {
            if (this.mTbPageContext != null && this.ekp != null) {
                this.mTbPageContext.sendMessage(new CustomMessage(2002001, new ShareWebActivityConfig(this.mTbPageContext.getContext(), "", this.ekp.url, true)));
            }
            TiebaStatic.log(new am("c12879"));
        }
    }

    public void setContext(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
    }
}
