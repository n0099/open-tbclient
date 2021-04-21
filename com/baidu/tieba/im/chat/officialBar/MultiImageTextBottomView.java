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
import d.b.j0.e1.g.d;
import d.b.j0.e1.l.c.a;
import d.b.j0.e1.w.c;
/* loaded from: classes4.dex */
public class MultiImageTextBottomView extends LinearLayout {

    /* renamed from: e  reason: collision with root package name */
    public Context f17481e;

    /* renamed from: f  reason: collision with root package name */
    public TbImageView f17482f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f17483g;

    /* renamed from: h  reason: collision with root package name */
    public d.b.c.e.h.b f17484h;
    public int i;
    public int j;
    public String k;

    /* loaded from: classes4.dex */
    public class a implements View.OnLongClickListener {
        public a() {
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            if (MultiImageTextBottomView.this.f17484h != null) {
                MultiImageTextBottomView.this.f17484h.onItemViewLongClick(view, 9, MultiImageTextBottomView.this.i, 0L);
                return false;
            }
            return false;
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a.C1289a f17486e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ TbPageContext f17487f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f17488g;

        public b(a.C1289a c1289a, TbPageContext tbPageContext, int i) {
            this.f17486e = c1289a;
            this.f17487f = tbPageContext;
            this.f17488g = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.C1289a c1289a = this.f17486e;
            if (c1289a == null || StringUtils.isNull(c1289a.f55853d)) {
                return;
            }
            UrlManager.getInstance().dealOneLink(this.f17487f, new String[]{this.f17486e.f55853d});
            if (this.f17488g == 1) {
                TiebaStatic.eventStat(MultiImageTextBottomView.this.f17481e, "official_msg_ck", PrefetchEvent.STATE_CLICK, 1, "fid", this.f17486e.f55854e);
                d j = c.j(MultiImageTextBottomView.this.k);
                if (j != null) {
                    Context context = MultiImageTextBottomView.this.f17481e;
                    TiebaStatic.eventStat(context, "message_open_detail", PrefetchEvent.STATE_CLICK, 1, "task_type", j.f55714a, "task_id", j.f55715b, "loc", "" + MultiImageTextBottomView.this.j);
                    int i = this.f17486e.f55856g;
                    if ((i == 1 || i == 3) && !"0".equals(j.f55715b)) {
                        d.b.j0.e1.u.a.c().a(j.f55715b);
                    }
                }
                StatisticItem statisticItem = new StatisticItem("official_message_open_detail");
                statisticItem.param("msg_id", this.f17486e.f55857h / 100);
                statisticItem.param("official_id", this.f17486e.i);
                statisticItem.param("official_type", this.f17486e.j);
                statisticItem.param("operate_time", System.currentTimeMillis() / 1000);
                statisticItem.param("task_id", this.f17486e.k);
                statisticItem.param("obj_params1", this.f17486e.f55853d);
                TiebaStatic.log(statisticItem);
            }
        }
    }

    public MultiImageTextBottomView(Context context) {
        this(context, null);
    }

    public final void f() {
        setOrientation(0);
        LayoutInflater.from(this.f17481e).inflate(R.layout.msg_multi_pic_text_bottom_view, (ViewGroup) this, true);
        TbImageView tbImageView = (TbImageView) findViewById(R.id.bottom_content_pic);
        this.f17482f = tbImageView;
        tbImageView.setAutoChangeStyle(false);
        this.f17483g = (TextView) findViewById(R.id.bottom_title);
    }

    public void g(boolean z) {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (!z) {
            skinType = 0;
        }
        this.f17482f.setAutoChangeStyle(z);
        SkinManager.setViewTextColor(this.f17483g, R.color.common_color_10039, 1, skinType);
    }

    public void h() {
        this.f17483g.setText("");
        this.f17482f.setBackgroundDrawable(null);
        this.f17482f.setImageDrawable(null);
    }

    public void setData(TbPageContext<?> tbPageContext, a.C1289a c1289a, View view, int i) {
        if (c1289a == null) {
            return;
        }
        this.f17483g.setText(!TextUtils.isEmpty(c1289a.f55850a) ? c1289a.f55850a : "");
        if (!TextUtils.isEmpty(c1289a.f55853d)) {
            setOnClickListener(new b(c1289a, tbPageContext, i));
        }
        if (TextUtils.isEmpty(c1289a.f55852c)) {
            return;
        }
        this.f17482f.setTag(c1289a.f55852c);
        this.f17482f.W(c1289a.f55852c, 10, false);
    }

    public void setOnItemViewLongClickListener(d.b.c.e.h.b bVar) {
        this.f17484h = bVar;
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
        this.f17484h = null;
        this.f17481e = context;
        f();
        setOnLongClickListener(new a());
    }
}
