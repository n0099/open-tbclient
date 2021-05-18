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
import d.a.k0.e1.g.d;
import d.a.k0.e1.l.c.a;
import d.a.k0.e1.w.c;
/* loaded from: classes4.dex */
public class MultiImageTextBottomView extends LinearLayout {

    /* renamed from: e  reason: collision with root package name */
    public Context f17107e;

    /* renamed from: f  reason: collision with root package name */
    public TbImageView f17108f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f17109g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.c.e.h.b f17110h;

    /* renamed from: i  reason: collision with root package name */
    public int f17111i;
    public int j;
    public String k;

    /* loaded from: classes4.dex */
    public class a implements View.OnLongClickListener {
        public a() {
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            if (MultiImageTextBottomView.this.f17110h != null) {
                MultiImageTextBottomView.this.f17110h.onItemViewLongClick(view, 9, MultiImageTextBottomView.this.f17111i, 0L);
                return false;
            }
            return false;
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a.C1300a f17113e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ TbPageContext f17114f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f17115g;

        public b(a.C1300a c1300a, TbPageContext tbPageContext, int i2) {
            this.f17113e = c1300a;
            this.f17114f = tbPageContext;
            this.f17115g = i2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.C1300a c1300a = this.f17113e;
            if (c1300a == null || StringUtils.isNull(c1300a.f54420d)) {
                return;
            }
            UrlManager.getInstance().dealOneLink(this.f17114f, new String[]{this.f17113e.f54420d});
            if (this.f17115g == 1) {
                TiebaStatic.eventStat(MultiImageTextBottomView.this.f17107e, "official_msg_ck", PrefetchEvent.STATE_CLICK, 1, "fid", this.f17113e.f54421e);
                d j = c.j(MultiImageTextBottomView.this.k);
                if (j != null) {
                    Context context = MultiImageTextBottomView.this.f17107e;
                    TiebaStatic.eventStat(context, "message_open_detail", PrefetchEvent.STATE_CLICK, 1, "task_type", j.f54276a, "task_id", j.f54277b, "loc", "" + MultiImageTextBottomView.this.j);
                    int i2 = this.f17113e.f54423g;
                    if ((i2 == 1 || i2 == 3) && !"0".equals(j.f54277b)) {
                        d.a.k0.e1.u.a.c().a(j.f54277b);
                    }
                }
                StatisticItem statisticItem = new StatisticItem("official_message_open_detail");
                statisticItem.param("msg_id", this.f17113e.f54424h / 100);
                statisticItem.param("official_id", this.f17113e.f54425i);
                statisticItem.param("official_type", this.f17113e.j);
                statisticItem.param("operate_time", System.currentTimeMillis() / 1000);
                statisticItem.param("task_id", this.f17113e.k);
                statisticItem.param("obj_params1", this.f17113e.f54420d);
                TiebaStatic.log(statisticItem);
            }
        }
    }

    public MultiImageTextBottomView(Context context) {
        this(context, null);
    }

    public final void f() {
        setOrientation(0);
        LayoutInflater.from(this.f17107e).inflate(R.layout.msg_multi_pic_text_bottom_view, (ViewGroup) this, true);
        TbImageView tbImageView = (TbImageView) findViewById(R.id.bottom_content_pic);
        this.f17108f = tbImageView;
        tbImageView.setAutoChangeStyle(false);
        this.f17109g = (TextView) findViewById(R.id.bottom_title);
    }

    public void g(boolean z) {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (!z) {
            skinType = 0;
        }
        this.f17108f.setAutoChangeStyle(z);
        SkinManager.setViewTextColor(this.f17109g, R.color.common_color_10039, 1, skinType);
    }

    public void h() {
        this.f17109g.setText("");
        this.f17108f.setBackgroundDrawable(null);
        this.f17108f.setImageDrawable(null);
    }

    public void setData(TbPageContext<?> tbPageContext, a.C1300a c1300a, View view, int i2) {
        if (c1300a == null) {
            return;
        }
        this.f17109g.setText(!TextUtils.isEmpty(c1300a.f54417a) ? c1300a.f54417a : "");
        if (!TextUtils.isEmpty(c1300a.f54420d)) {
            setOnClickListener(new b(c1300a, tbPageContext, i2));
        }
        if (TextUtils.isEmpty(c1300a.f54419c)) {
            return;
        }
        this.f17108f.setTag(c1300a.f54419c);
        this.f17108f.V(c1300a.f54419c, 10, false);
    }

    public void setOnItemViewLongClickListener(d.a.c.e.h.b bVar) {
        this.f17110h = bVar;
    }

    public void setPosition(int i2) {
        this.f17111i = i2;
    }

    public void setStPosition(int i2) {
        this.j = i2;
    }

    public void setTaskInfo(String str) {
        this.k = str;
    }

    public MultiImageTextBottomView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f17110h = null;
        this.f17107e = context;
        f();
        setOnLongClickListener(new a());
    }
}
