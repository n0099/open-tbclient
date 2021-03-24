package com.baidu.tieba.im.chat.officialBar;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import d.b.i0.d1.g.d;
import d.b.i0.d1.l.c.a;
import d.b.i0.d1.w.c;
/* loaded from: classes4.dex */
public class MultiImageTextBottomView extends LinearLayout {

    /* renamed from: e  reason: collision with root package name */
    public Context f17795e;

    /* renamed from: f  reason: collision with root package name */
    public TbImageView f17796f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f17797g;

    /* renamed from: h  reason: collision with root package name */
    public d.b.b.e.h.b f17798h;
    public int i;
    public int j;
    public String k;

    /* loaded from: classes4.dex */
    public class a implements View.OnLongClickListener {
        public a() {
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            if (MultiImageTextBottomView.this.f17798h != null) {
                MultiImageTextBottomView.this.f17798h.onItemViewLongClick(view, 9, MultiImageTextBottomView.this.i, 0L);
                return false;
            }
            return false;
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a.C1202a f17800e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ TbPageContext f17801f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f17802g;

        public b(a.C1202a c1202a, TbPageContext tbPageContext, int i) {
            this.f17800e = c1202a;
            this.f17801f = tbPageContext;
            this.f17802g = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.C1202a c1202a = this.f17800e;
            if (c1202a == null || StringUtils.isNull(c1202a.f53909d)) {
                return;
            }
            UrlManager.getInstance().dealOneLink(this.f17801f, new String[]{this.f17800e.f53909d});
            if (this.f17802g == 1) {
                TiebaStatic.eventStat(MultiImageTextBottomView.this.f17795e, "official_msg_ck", PrefetchEvent.STATE_CLICK, 1, "fid", this.f17800e.f53910e);
                d j = c.j(MultiImageTextBottomView.this.k);
                if (j != null) {
                    Context context = MultiImageTextBottomView.this.f17795e;
                    TiebaStatic.eventStat(context, "message_open_detail", PrefetchEvent.STATE_CLICK, 1, "task_type", j.f53770a, "task_id", j.f53771b, "loc", "" + MultiImageTextBottomView.this.j);
                    int i = this.f17800e.f53912g;
                    if ((i == 1 || i == 3) && !"0".equals(j.f53771b)) {
                        d.b.i0.d1.u.a.c().a(j.f53771b);
                    }
                }
                StatisticItem statisticItem = new StatisticItem("official_message_open_detail");
                statisticItem.param("msg_id", this.f17800e.f53913h / 100);
                statisticItem.param("official_id", this.f17800e.i);
                statisticItem.param("official_type", this.f17800e.j);
                statisticItem.param("operate_time", System.currentTimeMillis() / 1000);
                statisticItem.param("task_id", this.f17800e.k);
                statisticItem.param("obj_params1", this.f17800e.f53909d);
                TiebaStatic.log(statisticItem);
            }
        }
    }

    public MultiImageTextBottomView(Context context) {
        this(context, null);
    }

    public final void f() {
        setOrientation(0);
        LayoutInflater.from(this.f17795e).inflate(R.layout.msg_multi_pic_text_bottom_view, (ViewGroup) this, true);
        TbImageView tbImageView = (TbImageView) findViewById(R.id.bottom_content_pic);
        this.f17796f = tbImageView;
        tbImageView.setAutoChangeStyle(false);
        this.f17797g = (TextView) findViewById(R.id.bottom_title);
    }

    public void g(boolean z) {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (!z) {
            skinType = 0;
        }
        this.f17796f.setAutoChangeStyle(z);
        SkinManager.setViewTextColor(this.f17797g, R.color.common_color_10039, 1, skinType);
    }

    public void h() {
        this.f17797g.setText("");
        this.f17796f.setBackgroundDrawable(null);
        this.f17796f.setImageDrawable(null);
    }

    public void setData(TbPageContext<?> tbPageContext, a.C1202a c1202a, View view, int i) {
        if (c1202a == null) {
            return;
        }
        this.f17797g.setText(!TextUtils.isEmpty(c1202a.f53906a) ? c1202a.f53906a : "");
        if (!TextUtils.isEmpty(c1202a.f53909d)) {
            setOnClickListener(new b(c1202a, tbPageContext, i));
        }
        if (TextUtils.isEmpty(c1202a.f53908c)) {
            return;
        }
        this.f17796f.setTag(c1202a.f53908c);
        this.f17796f.W(c1202a.f53908c, 10, false);
    }

    public void setOnItemViewLongClickListener(d.b.b.e.h.b bVar) {
        this.f17798h = bVar;
    }

    public void setPosition(int i) {
        this.i = i;
    }

    public void setStPosition(int i) {
        this.j = i;
    }

    public void setTaskInfo(String str) {
        this.k = str;
    }

    public MultiImageTextBottomView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f17798h = null;
        this.f17795e = context;
        f();
        setOnLongClickListener(new a());
    }
}
