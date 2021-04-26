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
import d.a.j0.e1.g.d;
import d.a.j0.e1.l.c.a;
import d.a.j0.e1.w.c;
/* loaded from: classes4.dex */
public class MultiImageTextBottomView extends LinearLayout {

    /* renamed from: e  reason: collision with root package name */
    public Context f17792e;

    /* renamed from: f  reason: collision with root package name */
    public TbImageView f17793f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f17794g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.c.e.h.b f17795h;

    /* renamed from: i  reason: collision with root package name */
    public int f17796i;
    public int j;
    public String k;

    /* loaded from: classes4.dex */
    public class a implements View.OnLongClickListener {
        public a() {
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            if (MultiImageTextBottomView.this.f17795h != null) {
                MultiImageTextBottomView.this.f17795h.onItemViewLongClick(view, 9, MultiImageTextBottomView.this.f17796i, 0L);
                return false;
            }
            return false;
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a.C1228a f17798e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ TbPageContext f17799f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f17800g;

        public b(a.C1228a c1228a, TbPageContext tbPageContext, int i2) {
            this.f17798e = c1228a;
            this.f17799f = tbPageContext;
            this.f17800g = i2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.C1228a c1228a = this.f17798e;
            if (c1228a == null || StringUtils.isNull(c1228a.f53713d)) {
                return;
            }
            UrlManager.getInstance().dealOneLink(this.f17799f, new String[]{this.f17798e.f53713d});
            if (this.f17800g == 1) {
                TiebaStatic.eventStat(MultiImageTextBottomView.this.f17792e, "official_msg_ck", PrefetchEvent.STATE_CLICK, 1, "fid", this.f17798e.f53714e);
                d j = c.j(MultiImageTextBottomView.this.k);
                if (j != null) {
                    Context context = MultiImageTextBottomView.this.f17792e;
                    TiebaStatic.eventStat(context, "message_open_detail", PrefetchEvent.STATE_CLICK, 1, "task_type", j.f53569a, "task_id", j.f53570b, "loc", "" + MultiImageTextBottomView.this.j);
                    int i2 = this.f17798e.f53716g;
                    if ((i2 == 1 || i2 == 3) && !"0".equals(j.f53570b)) {
                        d.a.j0.e1.u.a.c().a(j.f53570b);
                    }
                }
                StatisticItem statisticItem = new StatisticItem("official_message_open_detail");
                statisticItem.param("msg_id", this.f17798e.f53717h / 100);
                statisticItem.param("official_id", this.f17798e.f53718i);
                statisticItem.param("official_type", this.f17798e.j);
                statisticItem.param("operate_time", System.currentTimeMillis() / 1000);
                statisticItem.param("task_id", this.f17798e.k);
                statisticItem.param("obj_params1", this.f17798e.f53713d);
                TiebaStatic.log(statisticItem);
            }
        }
    }

    public MultiImageTextBottomView(Context context) {
        this(context, null);
    }

    public final void f() {
        setOrientation(0);
        LayoutInflater.from(this.f17792e).inflate(R.layout.msg_multi_pic_text_bottom_view, (ViewGroup) this, true);
        TbImageView tbImageView = (TbImageView) findViewById(R.id.bottom_content_pic);
        this.f17793f = tbImageView;
        tbImageView.setAutoChangeStyle(false);
        this.f17794g = (TextView) findViewById(R.id.bottom_title);
    }

    public void g(boolean z) {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (!z) {
            skinType = 0;
        }
        this.f17793f.setAutoChangeStyle(z);
        SkinManager.setViewTextColor(this.f17794g, R.color.common_color_10039, 1, skinType);
    }

    public void h() {
        this.f17794g.setText("");
        this.f17793f.setBackgroundDrawable(null);
        this.f17793f.setImageDrawable(null);
    }

    public void setData(TbPageContext<?> tbPageContext, a.C1228a c1228a, View view, int i2) {
        if (c1228a == null) {
            return;
        }
        this.f17794g.setText(!TextUtils.isEmpty(c1228a.f53710a) ? c1228a.f53710a : "");
        if (!TextUtils.isEmpty(c1228a.f53713d)) {
            setOnClickListener(new b(c1228a, tbPageContext, i2));
        }
        if (TextUtils.isEmpty(c1228a.f53712c)) {
            return;
        }
        this.f17793f.setTag(c1228a.f53712c);
        this.f17793f.V(c1228a.f53712c, 10, false);
    }

    public void setOnItemViewLongClickListener(d.a.c.e.h.b bVar) {
        this.f17795h = bVar;
    }

    public void setPosition(int i2) {
        this.f17796i = i2;
    }

    public void setStPosition(int i2) {
        this.j = i2;
    }

    public void setTaskInfo(String str) {
        this.k = str;
    }

    public MultiImageTextBottomView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f17795h = null;
        this.f17792e = context;
        f();
        setOnLongClickListener(new a());
    }
}
