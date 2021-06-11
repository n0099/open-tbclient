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
import d.a.n0.f1.g.d;
import d.a.n0.f1.l.c.a;
import d.a.n0.f1.w.c;
/* loaded from: classes4.dex */
public class MultiImageTextBottomView extends LinearLayout {

    /* renamed from: e  reason: collision with root package name */
    public Context f17093e;

    /* renamed from: f  reason: collision with root package name */
    public TbImageView f17094f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f17095g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.c.e.h.b f17096h;

    /* renamed from: i  reason: collision with root package name */
    public int f17097i;
    public int j;
    public String k;

    /* loaded from: classes4.dex */
    public class a implements View.OnLongClickListener {
        public a() {
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            if (MultiImageTextBottomView.this.f17096h != null) {
                MultiImageTextBottomView.this.f17096h.onItemViewLongClick(view, 9, MultiImageTextBottomView.this.f17097i, 0L);
                return false;
            }
            return false;
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a.C1374a f17099e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ TbPageContext f17100f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f17101g;

        public b(a.C1374a c1374a, TbPageContext tbPageContext, int i2) {
            this.f17099e = c1374a;
            this.f17100f = tbPageContext;
            this.f17101g = i2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.C1374a c1374a = this.f17099e;
            if (c1374a == null || StringUtils.isNull(c1374a.f58299d)) {
                return;
            }
            UrlManager.getInstance().dealOneLink(this.f17100f, new String[]{this.f17099e.f58299d});
            if (this.f17101g == 1) {
                TiebaStatic.eventStat(MultiImageTextBottomView.this.f17093e, "official_msg_ck", PrefetchEvent.STATE_CLICK, 1, "fid", this.f17099e.f58300e);
                d j = c.j(MultiImageTextBottomView.this.k);
                if (j != null) {
                    Context context = MultiImageTextBottomView.this.f17093e;
                    TiebaStatic.eventStat(context, "message_open_detail", PrefetchEvent.STATE_CLICK, 1, "task_type", j.f58155a, "task_id", j.f58156b, "loc", "" + MultiImageTextBottomView.this.j);
                    int i2 = this.f17099e.f58302g;
                    if ((i2 == 1 || i2 == 3) && !"0".equals(j.f58156b)) {
                        d.a.n0.f1.u.a.c().a(j.f58156b);
                    }
                }
                StatisticItem statisticItem = new StatisticItem("official_message_open_detail");
                statisticItem.param("msg_id", this.f17099e.f58303h / 100);
                statisticItem.param("official_id", this.f17099e.f58304i);
                statisticItem.param("official_type", this.f17099e.j);
                statisticItem.param("operate_time", System.currentTimeMillis() / 1000);
                statisticItem.param("task_id", this.f17099e.k);
                statisticItem.param("obj_params1", this.f17099e.f58299d);
                TiebaStatic.log(statisticItem);
            }
        }
    }

    public MultiImageTextBottomView(Context context) {
        this(context, null);
    }

    public final void f() {
        setOrientation(0);
        LayoutInflater.from(this.f17093e).inflate(R.layout.msg_multi_pic_text_bottom_view, (ViewGroup) this, true);
        TbImageView tbImageView = (TbImageView) findViewById(R.id.bottom_content_pic);
        this.f17094f = tbImageView;
        tbImageView.setAutoChangeStyle(false);
        this.f17095g = (TextView) findViewById(R.id.bottom_title);
    }

    public void g(boolean z) {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (!z) {
            skinType = 0;
        }
        this.f17094f.setAutoChangeStyle(z);
        SkinManager.setViewTextColor(this.f17095g, R.color.common_color_10039, 1, skinType);
    }

    public void h() {
        this.f17095g.setText("");
        this.f17094f.setBackgroundDrawable(null);
        this.f17094f.setImageDrawable(null);
    }

    public void setData(TbPageContext<?> tbPageContext, a.C1374a c1374a, View view, int i2) {
        if (c1374a == null) {
            return;
        }
        this.f17095g.setText(!TextUtils.isEmpty(c1374a.f58296a) ? c1374a.f58296a : "");
        if (!TextUtils.isEmpty(c1374a.f58299d)) {
            setOnClickListener(new b(c1374a, tbPageContext, i2));
        }
        if (TextUtils.isEmpty(c1374a.f58298c)) {
            return;
        }
        this.f17094f.setTag(c1374a.f58298c);
        this.f17094f.U(c1374a.f58298c, 10, false);
    }

    public void setOnItemViewLongClickListener(d.a.c.e.h.b bVar) {
        this.f17096h = bVar;
    }

    public void setPosition(int i2) {
        this.f17097i = i2;
    }

    public void setStPosition(int i2) {
        this.j = i2;
    }

    public void setTaskInfo(String str) {
        this.k = str;
    }

    public MultiImageTextBottomView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f17096h = null;
        this.f17093e = context;
        f();
        setOnLongClickListener(new a());
    }
}
