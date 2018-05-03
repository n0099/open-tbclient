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
    private StarRank dtV;
    private TextView dug;
    private TextView duh;
    private TextView dui;
    private ImageView duj;
    private ViewGroup duk;
    private ViewGroup dul;
    private ListView dum;
    private a dun;
    private d duo;
    private int dup;
    private Runnable duq;
    private Handler handler;
    private Runnable mRunnable;
    private TbPageContext mTbPageContext;

    static /* synthetic */ int b(FrsStarRankAndTaskContainer frsStarRankAndTaskContainer) {
        int i = frsStarRankAndTaskContainer.dup + 1;
        frsStarRankAndTaskContainer.dup = i;
        return i;
    }

    public FrsStarRankAndTaskContainer(Context context) {
        this(context, null);
    }

    public FrsStarRankAndTaskContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.handler = new Handler();
        this.dup = 0;
        this.duq = new Runnable() { // from class: com.baidu.tieba.frs.view.FrsStarRankAndTaskContainer.1
            @Override // java.lang.Runnable
            public void run() {
                if (FrsStarRankAndTaskContainer.this.dum != null) {
                    FrsStarRankAndTaskContainer.this.dum.smoothScrollToPositionFromTop(FrsStarRankAndTaskContainer.b(FrsStarRankAndTaskContainer.this), 0, 300);
                }
                FrsStarRankAndTaskContainer.this.handler.removeCallbacksAndMessages(null);
                FrsStarRankAndTaskContainer.this.handler.postDelayed(this, 3000L);
            }
        };
        this.mRunnable = new Runnable() { // from class: com.baidu.tieba.frs.view.FrsStarRankAndTaskContainer.4
            @Override // java.lang.Runnable
            public void run() {
                FrsStarRankAndTaskContainer.this.dum.setSelection(FrsStarRankAndTaskContainer.this.dup);
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
        avT();
    }

    private void init() {
        Context context = getContext();
        setOrientation(0);
        setPadding(l.e(context, d.e.tbds35), l.e(context, d.e.tbds30), l.e(context, d.e.tbds35), 0);
        LayoutInflater.from(getContext()).inflate(d.i.view_frs_star_rank_and_task, (ViewGroup) this, true);
        this.dug = (TextView) findViewById(d.g.rank_number);
        this.duh = (TextView) findViewById(d.g.user_contributions);
        this.dui = (TextView) findViewById(d.g.star_task);
        this.duj = (ImageView) findViewById(d.g.image_rank_icon);
        this.dul = (ViewGroup) findViewById(d.g.task_container);
        this.duk = (ViewGroup) findViewById(d.g.rank_container);
        this.dul.setOnClickListener(this);
        this.duk.setOnClickListener(this);
        this.dum = (ListView) findViewById(d.g.rank_scroll);
        this.dum.setClickable(false);
        this.dum.setFocusable(false);
        this.dum.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.frs.view.FrsStarRankAndTaskContainer.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
                if (FrsStarRankAndTaskContainer.this.duk != null) {
                    FrsStarRankAndTaskContainer.this.duk.performClick();
                }
            }
        });
        this.dum.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.frs.view.FrsStarRankAndTaskContainer.3
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
        this.dun = new a(getContext());
        this.dum.setAdapter((ListAdapter) this.dun);
        onChangeSkinType();
    }

    public void setData(StarRank starRank) {
        String string;
        int i;
        if (starRank != null) {
            this.dtV = starRank;
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
            this.dug.setText(string);
            this.duh.setText(starRank.user_task_notice);
            if (!v.w(this.dtV.user_task_info)) {
                int size = this.dtV.user_task_info.size();
                int i2 = 0;
                int i3 = 0;
                while (i2 < size) {
                    if (this.dtV.user_task_info.get(i2) == null) {
                        i = i3;
                    } else {
                        i = this.dtV.user_task_info.get(i2).task_status.intValue() == 1 ? i3 + 1 : i3;
                    }
                    i2++;
                    i3 = i;
                }
                this.dui.setText(String.format(Locale.CHINA, getResources().getString(d.k.see_task), Integer.valueOf(i3), Integer.valueOf(size)));
            } else {
                this.dui.setText(d.k.no_have_task);
            }
            this.dun.setData(starRank.contri_record_list);
            avT();
        }
    }

    public void avT() {
        if (this.dun.getCount() != 0) {
            this.handler.removeCallbacks(this.duq);
            this.handler.postDelayed(this.duq, 3000L);
        }
    }

    public void onChangeSkinType() {
        ak.h(this.dug, d.C0126d.cp_cont_i);
        ak.c(this.duj, d.f.icon_frs_idol_ranking);
        ak.i(this.duk, d.f.bg_fts_star_rank_entrance);
        ak.i(this.dul, d.f.bg_frs_star_task_entrance);
        this.dui.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ak.getDrawable(d.f.icon_arrow12_white_right), (Drawable) null);
        ak.h(this.dui, d.C0126d.cp_cont_i);
        ak.h(this.duh, d.C0126d.cp_cont_i);
        this.dun.notifyDataSetChanged();
        if (this.duo != null) {
            this.duo.avS();
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
                bVar.dus = (TextView) view2.findViewById(d.g.contri_desc);
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
            bVar.dus.setText(starContriRecord.record_notice);
            bVar.tvUserName.requestLayout();
            if (UtilHelper.isCurrentAccount(String.valueOf(starContriRecord.user_id))) {
                ak.h(bVar.dus, d.C0126d.common_color_10326);
                ak.h(bVar.tvUserName, d.C0126d.common_color_10326);
                return view2;
            }
            ak.h(bVar.dus, d.C0126d.cp_cont_i);
            ak.h(bVar.tvUserName, d.C0126d.cp_cont_i);
            return view2;
        }
    }

    /* loaded from: classes2.dex */
    private static class b {
        TextView dus;
        TextView tvUserName;

        private b() {
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        if (view2 == this.dul) {
            TiebaStatic.log(new al("c12880"));
            if (az.aK(getContext())) {
                if (this.duo == null) {
                    this.duo = new d();
                }
                this.duo.a(getContext(), this.dtV);
            }
        } else if (view2 == this.duk) {
            if (this.mTbPageContext != null && this.dtV != null) {
                this.mTbPageContext.sendMessage(new CustomMessage(2002001, new ShareWebActivityConfig(this.mTbPageContext.getContext(), "", this.dtV.url, true)));
            }
            TiebaStatic.log(new al("c12879"));
        }
    }

    public void setContext(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
    }
}
