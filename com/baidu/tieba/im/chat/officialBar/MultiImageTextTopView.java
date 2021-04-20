package com.baidu.tieba.im.chat.officialBar;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
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
public class MultiImageTextTopView extends RelativeLayout {

    /* renamed from: e  reason: collision with root package name */
    public Context f17482e;

    /* renamed from: f  reason: collision with root package name */
    public TbImageView f17483f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f17484g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f17485h;
    public d.b.c.e.h.b i;
    public int j;

    /* loaded from: classes4.dex */
    public class a implements View.OnLongClickListener {
        public a() {
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            if (MultiImageTextTopView.this.i != null) {
                MultiImageTextTopView.this.i.onItemViewLongClick(view, 9, MultiImageTextTopView.this.j, 0L);
                return false;
            }
            return false;
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a.C1266a f17487e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ TbPageContext f17488f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f17489g;

        public b(a.C1266a c1266a, TbPageContext tbPageContext, int i) {
            this.f17487e = c1266a;
            this.f17488f = tbPageContext;
            this.f17489g = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.C1266a c1266a = this.f17487e;
            if (c1266a == null || StringUtils.isNull(c1266a.f55432d)) {
                return;
            }
            UrlManager.getInstance().dealOneLink(this.f17488f, new String[]{this.f17487e.f55432d});
            if (this.f17489g == 1) {
                TiebaStatic.eventStat(MultiImageTextTopView.this.f17482e, "official_msg_ck", PrefetchEvent.STATE_CLICK, 1, "fid", this.f17487e.f55433e);
                d j = c.j(this.f17487e.f55434f);
                if (j != null) {
                    TiebaStatic.eventStat(MultiImageTextTopView.this.f17482e, "message_open_detail", PrefetchEvent.STATE_CLICK, 1, "task_type", j.f55293a, "task_id", j.f55294b, "loc", "0");
                    int i = this.f17487e.f55435g;
                    if ((i == 1 || i == 3) && !"0".equals(j.f55294b)) {
                        d.b.i0.e1.u.a.c().a(j.f55294b);
                    }
                }
                StatisticItem statisticItem = new StatisticItem("official_message_open_detail");
                statisticItem.param("msg_id", this.f17487e.f55436h / 100);
                statisticItem.param("official_id", this.f17487e.i);
                statisticItem.param("official_type", this.f17487e.j);
                statisticItem.param("operate_time", System.currentTimeMillis() / 1000);
                statisticItem.param("task_id", this.f17487e.k);
                statisticItem.param("obj_params1", this.f17487e.f55432d);
                TiebaStatic.log(statisticItem);
            }
        }
    }

    public MultiImageTextTopView(Context context) {
        this(context, null);
    }

    public final void d() {
        LayoutInflater.from(this.f17482e).inflate(R.layout.msg_multi_pic_text_top_view, (ViewGroup) this, true);
        TbImageView tbImageView = (TbImageView) findViewById(R.id.top_content_pic);
        this.f17483f = tbImageView;
        tbImageView.setAutoChangeStyle(false);
        this.f17484g = (TextView) findViewById(R.id.top_title);
        this.f17485h = (TextView) findViewById(R.id.show_time);
        setOnLongClickListener(new a());
    }

    public void e(boolean z) {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (!z) {
            skinType = 0;
        }
        this.f17483f.setAutoChangeStyle(z);
        SkinManager.setViewTextColor(this.f17484g, R.color.CAM_X0111, 1, skinType);
        SkinManager.setViewTextColor(this.f17485h, R.color.common_color_10067, 1, skinType);
    }

    public void f() {
        this.f17484g.setText("");
        this.f17483f.setBackgroundDrawable(null);
        this.f17483f.setImageDrawable(null);
        this.f17485h.setVisibility(8);
        this.f17485h.setText("");
    }

    public void setData(TbPageContext<?> tbPageContext, a.C1266a c1266a, View view, int i) {
        setPadding((int) this.f17482e.getResources().getDimension(R.dimen.ds30), (int) this.f17482e.getResources().getDimension(R.dimen.ds30), (int) this.f17482e.getResources().getDimension(R.dimen.ds30), (int) this.f17482e.getResources().getDimension(R.dimen.ds30));
        if (c1266a == null) {
            return;
        }
        this.f17484g.setText(!TextUtils.isEmpty(c1266a.f55429a) ? c1266a.f55429a : "");
        if (!TextUtils.isEmpty(c1266a.f55432d)) {
            setOnClickListener(new b(c1266a, tbPageContext, i));
        }
        if (TextUtils.isEmpty(c1266a.f55431c)) {
            return;
        }
        this.f17483f.setTag(c1266a.f55431c);
        this.f17483f.W(c1266a.f55431c, 10, false);
    }

    public void setOnItemViewLongClickListener(d.b.c.e.h.b bVar) {
        this.i = bVar;
    }

    public void setPosition(int i) {
        this.j = i;
    }

    public void setTime(String str) {
        if (TextUtils.isEmpty(str)) {
            this.f17485h.setVisibility(8);
            this.f17485h.setText("");
            return;
        }
        this.f17485h.setVisibility(0);
        this.f17485h.setText(str);
    }

    public MultiImageTextTopView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MultiImageTextTopView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.i = null;
        this.f17482e = context;
        d();
    }
}
