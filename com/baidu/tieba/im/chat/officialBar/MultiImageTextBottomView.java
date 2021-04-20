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
import d.b.i0.e1.g.d;
import d.b.i0.e1.l.c.a;
import d.b.i0.e1.w.c;
/* loaded from: classes4.dex */
public class MultiImageTextBottomView extends LinearLayout {

    /* renamed from: e  reason: collision with root package name */
    public Context f17473e;

    /* renamed from: f  reason: collision with root package name */
    public TbImageView f17474f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f17475g;

    /* renamed from: h  reason: collision with root package name */
    public d.b.c.e.h.b f17476h;
    public int i;
    public int j;
    public String k;

    /* loaded from: classes4.dex */
    public class a implements View.OnLongClickListener {
        public a() {
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            if (MultiImageTextBottomView.this.f17476h != null) {
                MultiImageTextBottomView.this.f17476h.onItemViewLongClick(view, 9, MultiImageTextBottomView.this.i, 0L);
                return false;
            }
            return false;
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a.C1266a f17478e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ TbPageContext f17479f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f17480g;

        public b(a.C1266a c1266a, TbPageContext tbPageContext, int i) {
            this.f17478e = c1266a;
            this.f17479f = tbPageContext;
            this.f17480g = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.C1266a c1266a = this.f17478e;
            if (c1266a == null || StringUtils.isNull(c1266a.f55432d)) {
                return;
            }
            UrlManager.getInstance().dealOneLink(this.f17479f, new String[]{this.f17478e.f55432d});
            if (this.f17480g == 1) {
                TiebaStatic.eventStat(MultiImageTextBottomView.this.f17473e, "official_msg_ck", PrefetchEvent.STATE_CLICK, 1, "fid", this.f17478e.f55433e);
                d j = c.j(MultiImageTextBottomView.this.k);
                if (j != null) {
                    Context context = MultiImageTextBottomView.this.f17473e;
                    TiebaStatic.eventStat(context, "message_open_detail", PrefetchEvent.STATE_CLICK, 1, "task_type", j.f55293a, "task_id", j.f55294b, "loc", "" + MultiImageTextBottomView.this.j);
                    int i = this.f17478e.f55435g;
                    if ((i == 1 || i == 3) && !"0".equals(j.f55294b)) {
                        d.b.i0.e1.u.a.c().a(j.f55294b);
                    }
                }
                StatisticItem statisticItem = new StatisticItem("official_message_open_detail");
                statisticItem.param("msg_id", this.f17478e.f55436h / 100);
                statisticItem.param("official_id", this.f17478e.i);
                statisticItem.param("official_type", this.f17478e.j);
                statisticItem.param("operate_time", System.currentTimeMillis() / 1000);
                statisticItem.param("task_id", this.f17478e.k);
                statisticItem.param("obj_params1", this.f17478e.f55432d);
                TiebaStatic.log(statisticItem);
            }
        }
    }

    public MultiImageTextBottomView(Context context) {
        this(context, null);
    }

    public final void f() {
        setOrientation(0);
        LayoutInflater.from(this.f17473e).inflate(R.layout.msg_multi_pic_text_bottom_view, (ViewGroup) this, true);
        TbImageView tbImageView = (TbImageView) findViewById(R.id.bottom_content_pic);
        this.f17474f = tbImageView;
        tbImageView.setAutoChangeStyle(false);
        this.f17475g = (TextView) findViewById(R.id.bottom_title);
    }

    public void g(boolean z) {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (!z) {
            skinType = 0;
        }
        this.f17474f.setAutoChangeStyle(z);
        SkinManager.setViewTextColor(this.f17475g, R.color.common_color_10039, 1, skinType);
    }

    public void h() {
        this.f17475g.setText("");
        this.f17474f.setBackgroundDrawable(null);
        this.f17474f.setImageDrawable(null);
    }

    public void setData(TbPageContext<?> tbPageContext, a.C1266a c1266a, View view, int i) {
        if (c1266a == null) {
            return;
        }
        this.f17475g.setText(!TextUtils.isEmpty(c1266a.f55429a) ? c1266a.f55429a : "");
        if (!TextUtils.isEmpty(c1266a.f55432d)) {
            setOnClickListener(new b(c1266a, tbPageContext, i));
        }
        if (TextUtils.isEmpty(c1266a.f55431c)) {
            return;
        }
        this.f17474f.setTag(c1266a.f55431c);
        this.f17474f.W(c1266a.f55431c, 10, false);
    }

    public void setOnItemViewLongClickListener(d.b.c.e.h.b bVar) {
        this.f17476h = bVar;
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
        this.f17476h = null;
        this.f17473e = context;
        f();
        setOnLongClickListener(new a());
    }
}
