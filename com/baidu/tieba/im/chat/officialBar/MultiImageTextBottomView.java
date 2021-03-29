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
/* loaded from: classes3.dex */
public class MultiImageTextBottomView extends LinearLayout {

    /* renamed from: e  reason: collision with root package name */
    public Context f17796e;

    /* renamed from: f  reason: collision with root package name */
    public TbImageView f17797f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f17798g;

    /* renamed from: h  reason: collision with root package name */
    public d.b.b.e.h.b f17799h;
    public int i;
    public int j;
    public String k;

    /* loaded from: classes3.dex */
    public class a implements View.OnLongClickListener {
        public a() {
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            if (MultiImageTextBottomView.this.f17799h != null) {
                MultiImageTextBottomView.this.f17799h.onItemViewLongClick(view, 9, MultiImageTextBottomView.this.i, 0L);
                return false;
            }
            return false;
        }
    }

    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a.C1203a f17801e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ TbPageContext f17802f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f17803g;

        public b(a.C1203a c1203a, TbPageContext tbPageContext, int i) {
            this.f17801e = c1203a;
            this.f17802f = tbPageContext;
            this.f17803g = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.C1203a c1203a = this.f17801e;
            if (c1203a == null || StringUtils.isNull(c1203a.f53910d)) {
                return;
            }
            UrlManager.getInstance().dealOneLink(this.f17802f, new String[]{this.f17801e.f53910d});
            if (this.f17803g == 1) {
                TiebaStatic.eventStat(MultiImageTextBottomView.this.f17796e, "official_msg_ck", PrefetchEvent.STATE_CLICK, 1, "fid", this.f17801e.f53911e);
                d j = c.j(MultiImageTextBottomView.this.k);
                if (j != null) {
                    Context context = MultiImageTextBottomView.this.f17796e;
                    TiebaStatic.eventStat(context, "message_open_detail", PrefetchEvent.STATE_CLICK, 1, "task_type", j.f53771a, "task_id", j.f53772b, "loc", "" + MultiImageTextBottomView.this.j);
                    int i = this.f17801e.f53913g;
                    if ((i == 1 || i == 3) && !"0".equals(j.f53772b)) {
                        d.b.i0.d1.u.a.c().a(j.f53772b);
                    }
                }
                StatisticItem statisticItem = new StatisticItem("official_message_open_detail");
                statisticItem.param("msg_id", this.f17801e.f53914h / 100);
                statisticItem.param("official_id", this.f17801e.i);
                statisticItem.param("official_type", this.f17801e.j);
                statisticItem.param("operate_time", System.currentTimeMillis() / 1000);
                statisticItem.param("task_id", this.f17801e.k);
                statisticItem.param("obj_params1", this.f17801e.f53910d);
                TiebaStatic.log(statisticItem);
            }
        }
    }

    public MultiImageTextBottomView(Context context) {
        this(context, null);
    }

    public final void f() {
        setOrientation(0);
        LayoutInflater.from(this.f17796e).inflate(R.layout.msg_multi_pic_text_bottom_view, (ViewGroup) this, true);
        TbImageView tbImageView = (TbImageView) findViewById(R.id.bottom_content_pic);
        this.f17797f = tbImageView;
        tbImageView.setAutoChangeStyle(false);
        this.f17798g = (TextView) findViewById(R.id.bottom_title);
    }

    public void g(boolean z) {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (!z) {
            skinType = 0;
        }
        this.f17797f.setAutoChangeStyle(z);
        SkinManager.setViewTextColor(this.f17798g, R.color.common_color_10039, 1, skinType);
    }

    public void h() {
        this.f17798g.setText("");
        this.f17797f.setBackgroundDrawable(null);
        this.f17797f.setImageDrawable(null);
    }

    public void setData(TbPageContext<?> tbPageContext, a.C1203a c1203a, View view, int i) {
        if (c1203a == null) {
            return;
        }
        this.f17798g.setText(!TextUtils.isEmpty(c1203a.f53907a) ? c1203a.f53907a : "");
        if (!TextUtils.isEmpty(c1203a.f53910d)) {
            setOnClickListener(new b(c1203a, tbPageContext, i));
        }
        if (TextUtils.isEmpty(c1203a.f53909c)) {
            return;
        }
        this.f17797f.setTag(c1203a.f53909c);
        this.f17797f.W(c1203a.f53909c, 10, false);
    }

    public void setOnItemViewLongClickListener(d.b.b.e.h.b bVar) {
        this.f17799h = bVar;
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
        this.f17799h = null;
        this.f17796e = context;
        f();
        setOnLongClickListener(new a());
    }
}
