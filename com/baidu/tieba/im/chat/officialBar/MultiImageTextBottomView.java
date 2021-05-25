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
    public Context f17017e;

    /* renamed from: f  reason: collision with root package name */
    public TbImageView f17018f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f17019g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.c.e.h.b f17020h;

    /* renamed from: i  reason: collision with root package name */
    public int f17021i;
    public int j;
    public String k;

    /* loaded from: classes4.dex */
    public class a implements View.OnLongClickListener {
        public a() {
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            if (MultiImageTextBottomView.this.f17020h != null) {
                MultiImageTextBottomView.this.f17020h.onItemViewLongClick(view, 9, MultiImageTextBottomView.this.f17021i, 0L);
                return false;
            }
            return false;
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a.C1318a f17023e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ TbPageContext f17024f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f17025g;

        public b(a.C1318a c1318a, TbPageContext tbPageContext, int i2) {
            this.f17023e = c1318a;
            this.f17024f = tbPageContext;
            this.f17025g = i2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.C1318a c1318a = this.f17023e;
            if (c1318a == null || StringUtils.isNull(c1318a.f54610d)) {
                return;
            }
            UrlManager.getInstance().dealOneLink(this.f17024f, new String[]{this.f17023e.f54610d});
            if (this.f17025g == 1) {
                TiebaStatic.eventStat(MultiImageTextBottomView.this.f17017e, "official_msg_ck", PrefetchEvent.STATE_CLICK, 1, "fid", this.f17023e.f54611e);
                d j = c.j(MultiImageTextBottomView.this.k);
                if (j != null) {
                    Context context = MultiImageTextBottomView.this.f17017e;
                    TiebaStatic.eventStat(context, "message_open_detail", PrefetchEvent.STATE_CLICK, 1, "task_type", j.f54466a, "task_id", j.f54467b, "loc", "" + MultiImageTextBottomView.this.j);
                    int i2 = this.f17023e.f54613g;
                    if ((i2 == 1 || i2 == 3) && !"0".equals(j.f54467b)) {
                        d.a.n0.f1.u.a.c().a(j.f54467b);
                    }
                }
                StatisticItem statisticItem = new StatisticItem("official_message_open_detail");
                statisticItem.param("msg_id", this.f17023e.f54614h / 100);
                statisticItem.param("official_id", this.f17023e.f54615i);
                statisticItem.param("official_type", this.f17023e.j);
                statisticItem.param("operate_time", System.currentTimeMillis() / 1000);
                statisticItem.param("task_id", this.f17023e.k);
                statisticItem.param("obj_params1", this.f17023e.f54610d);
                TiebaStatic.log(statisticItem);
            }
        }
    }

    public MultiImageTextBottomView(Context context) {
        this(context, null);
    }

    public final void f() {
        setOrientation(0);
        LayoutInflater.from(this.f17017e).inflate(R.layout.msg_multi_pic_text_bottom_view, (ViewGroup) this, true);
        TbImageView tbImageView = (TbImageView) findViewById(R.id.bottom_content_pic);
        this.f17018f = tbImageView;
        tbImageView.setAutoChangeStyle(false);
        this.f17019g = (TextView) findViewById(R.id.bottom_title);
    }

    public void g(boolean z) {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (!z) {
            skinType = 0;
        }
        this.f17018f.setAutoChangeStyle(z);
        SkinManager.setViewTextColor(this.f17019g, R.color.common_color_10039, 1, skinType);
    }

    public void h() {
        this.f17019g.setText("");
        this.f17018f.setBackgroundDrawable(null);
        this.f17018f.setImageDrawable(null);
    }

    public void setData(TbPageContext<?> tbPageContext, a.C1318a c1318a, View view, int i2) {
        if (c1318a == null) {
            return;
        }
        this.f17019g.setText(!TextUtils.isEmpty(c1318a.f54607a) ? c1318a.f54607a : "");
        if (!TextUtils.isEmpty(c1318a.f54610d)) {
            setOnClickListener(new b(c1318a, tbPageContext, i2));
        }
        if (TextUtils.isEmpty(c1318a.f54609c)) {
            return;
        }
        this.f17018f.setTag(c1318a.f54609c);
        this.f17018f.V(c1318a.f54609c, 10, false);
    }

    public void setOnItemViewLongClickListener(d.a.c.e.h.b bVar) {
        this.f17020h = bVar;
    }

    public void setPosition(int i2) {
        this.f17021i = i2;
    }

    public void setStPosition(int i2) {
        this.j = i2;
    }

    public void setTaskInfo(String str) {
        this.k = str;
    }

    public MultiImageTextBottomView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f17020h = null;
        this.f17017e = context;
        f();
        setOnLongClickListener(new a());
    }
}
