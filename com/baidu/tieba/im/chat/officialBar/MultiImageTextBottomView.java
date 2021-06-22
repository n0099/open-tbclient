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
import d.a.o0.f1.g.d;
import d.a.o0.f1.l.c.a;
import d.a.o0.f1.w.c;
/* loaded from: classes4.dex */
public class MultiImageTextBottomView extends LinearLayout {

    /* renamed from: e  reason: collision with root package name */
    public Context f17175e;

    /* renamed from: f  reason: collision with root package name */
    public TbImageView f17176f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f17177g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.c.e.h.b f17178h;

    /* renamed from: i  reason: collision with root package name */
    public int f17179i;
    public int j;
    public String k;

    /* loaded from: classes4.dex */
    public class a implements View.OnLongClickListener {
        public a() {
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            if (MultiImageTextBottomView.this.f17178h != null) {
                MultiImageTextBottomView.this.f17178h.onItemViewLongClick(view, 9, MultiImageTextBottomView.this.f17179i, 0L);
                return false;
            }
            return false;
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a.C1378a f17181e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ TbPageContext f17182f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f17183g;

        public b(a.C1378a c1378a, TbPageContext tbPageContext, int i2) {
            this.f17181e = c1378a;
            this.f17182f = tbPageContext;
            this.f17183g = i2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.C1378a c1378a = this.f17181e;
            if (c1378a == null || StringUtils.isNull(c1378a.f58424d)) {
                return;
            }
            UrlManager.getInstance().dealOneLink(this.f17182f, new String[]{this.f17181e.f58424d});
            if (this.f17183g == 1) {
                TiebaStatic.eventStat(MultiImageTextBottomView.this.f17175e, "official_msg_ck", PrefetchEvent.STATE_CLICK, 1, "fid", this.f17181e.f58425e);
                d j = c.j(MultiImageTextBottomView.this.k);
                if (j != null) {
                    Context context = MultiImageTextBottomView.this.f17175e;
                    TiebaStatic.eventStat(context, "message_open_detail", PrefetchEvent.STATE_CLICK, 1, "task_type", j.f58280a, "task_id", j.f58281b, "loc", "" + MultiImageTextBottomView.this.j);
                    int i2 = this.f17181e.f58427g;
                    if ((i2 == 1 || i2 == 3) && !"0".equals(j.f58281b)) {
                        d.a.o0.f1.u.a.c().a(j.f58281b);
                    }
                }
                StatisticItem statisticItem = new StatisticItem("official_message_open_detail");
                statisticItem.param("msg_id", this.f17181e.f58428h / 100);
                statisticItem.param("official_id", this.f17181e.f58429i);
                statisticItem.param("official_type", this.f17181e.j);
                statisticItem.param("operate_time", System.currentTimeMillis() / 1000);
                statisticItem.param("task_id", this.f17181e.k);
                statisticItem.param("obj_params1", this.f17181e.f58424d);
                TiebaStatic.log(statisticItem);
            }
        }
    }

    public MultiImageTextBottomView(Context context) {
        this(context, null);
    }

    public final void f() {
        setOrientation(0);
        LayoutInflater.from(this.f17175e).inflate(R.layout.msg_multi_pic_text_bottom_view, (ViewGroup) this, true);
        TbImageView tbImageView = (TbImageView) findViewById(R.id.bottom_content_pic);
        this.f17176f = tbImageView;
        tbImageView.setAutoChangeStyle(false);
        this.f17177g = (TextView) findViewById(R.id.bottom_title);
    }

    public void g(boolean z) {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (!z) {
            skinType = 0;
        }
        this.f17176f.setAutoChangeStyle(z);
        SkinManager.setViewTextColor(this.f17177g, R.color.common_color_10039, 1, skinType);
    }

    public void h() {
        this.f17177g.setText("");
        this.f17176f.setBackgroundDrawable(null);
        this.f17176f.setImageDrawable(null);
    }

    public void setData(TbPageContext<?> tbPageContext, a.C1378a c1378a, View view, int i2) {
        if (c1378a == null) {
            return;
        }
        this.f17177g.setText(!TextUtils.isEmpty(c1378a.f58421a) ? c1378a.f58421a : "");
        if (!TextUtils.isEmpty(c1378a.f58424d)) {
            setOnClickListener(new b(c1378a, tbPageContext, i2));
        }
        if (TextUtils.isEmpty(c1378a.f58423c)) {
            return;
        }
        this.f17176f.setTag(c1378a.f58423c);
        this.f17176f.U(c1378a.f58423c, 10, false);
    }

    public void setOnItemViewLongClickListener(d.a.c.e.h.b bVar) {
        this.f17178h = bVar;
    }

    public void setPosition(int i2) {
        this.f17179i = i2;
    }

    public void setStPosition(int i2) {
        this.j = i2;
    }

    public void setTaskInfo(String str) {
        this.k = str;
    }

    public MultiImageTextBottomView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f17178h = null;
        this.f17175e = context;
        f();
        setOnLongClickListener(new a());
    }
}
