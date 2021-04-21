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
import d.b.j0.e1.g.d;
import d.b.j0.e1.l.c.a;
import d.b.j0.e1.w.c;
/* loaded from: classes4.dex */
public class MultiImageTextTopView extends RelativeLayout {

    /* renamed from: e  reason: collision with root package name */
    public Context f17490e;

    /* renamed from: f  reason: collision with root package name */
    public TbImageView f17491f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f17492g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f17493h;
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
        public final /* synthetic */ a.C1289a f17495e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ TbPageContext f17496f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f17497g;

        public b(a.C1289a c1289a, TbPageContext tbPageContext, int i) {
            this.f17495e = c1289a;
            this.f17496f = tbPageContext;
            this.f17497g = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.C1289a c1289a = this.f17495e;
            if (c1289a == null || StringUtils.isNull(c1289a.f55853d)) {
                return;
            }
            UrlManager.getInstance().dealOneLink(this.f17496f, new String[]{this.f17495e.f55853d});
            if (this.f17497g == 1) {
                TiebaStatic.eventStat(MultiImageTextTopView.this.f17490e, "official_msg_ck", PrefetchEvent.STATE_CLICK, 1, "fid", this.f17495e.f55854e);
                d j = c.j(this.f17495e.f55855f);
                if (j != null) {
                    TiebaStatic.eventStat(MultiImageTextTopView.this.f17490e, "message_open_detail", PrefetchEvent.STATE_CLICK, 1, "task_type", j.f55714a, "task_id", j.f55715b, "loc", "0");
                    int i = this.f17495e.f55856g;
                    if ((i == 1 || i == 3) && !"0".equals(j.f55715b)) {
                        d.b.j0.e1.u.a.c().a(j.f55715b);
                    }
                }
                StatisticItem statisticItem = new StatisticItem("official_message_open_detail");
                statisticItem.param("msg_id", this.f17495e.f55857h / 100);
                statisticItem.param("official_id", this.f17495e.i);
                statisticItem.param("official_type", this.f17495e.j);
                statisticItem.param("operate_time", System.currentTimeMillis() / 1000);
                statisticItem.param("task_id", this.f17495e.k);
                statisticItem.param("obj_params1", this.f17495e.f55853d);
                TiebaStatic.log(statisticItem);
            }
        }
    }

    public MultiImageTextTopView(Context context) {
        this(context, null);
    }

    public final void d() {
        LayoutInflater.from(this.f17490e).inflate(R.layout.msg_multi_pic_text_top_view, (ViewGroup) this, true);
        TbImageView tbImageView = (TbImageView) findViewById(R.id.top_content_pic);
        this.f17491f = tbImageView;
        tbImageView.setAutoChangeStyle(false);
        this.f17492g = (TextView) findViewById(R.id.top_title);
        this.f17493h = (TextView) findViewById(R.id.show_time);
        setOnLongClickListener(new a());
    }

    public void e(boolean z) {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (!z) {
            skinType = 0;
        }
        this.f17491f.setAutoChangeStyle(z);
        SkinManager.setViewTextColor(this.f17492g, R.color.CAM_X0111, 1, skinType);
        SkinManager.setViewTextColor(this.f17493h, R.color.common_color_10067, 1, skinType);
    }

    public void f() {
        this.f17492g.setText("");
        this.f17491f.setBackgroundDrawable(null);
        this.f17491f.setImageDrawable(null);
        this.f17493h.setVisibility(8);
        this.f17493h.setText("");
    }

    public void setData(TbPageContext<?> tbPageContext, a.C1289a c1289a, View view, int i) {
        setPadding((int) this.f17490e.getResources().getDimension(R.dimen.ds30), (int) this.f17490e.getResources().getDimension(R.dimen.ds30), (int) this.f17490e.getResources().getDimension(R.dimen.ds30), (int) this.f17490e.getResources().getDimension(R.dimen.ds30));
        if (c1289a == null) {
            return;
        }
        this.f17492g.setText(!TextUtils.isEmpty(c1289a.f55850a) ? c1289a.f55850a : "");
        if (!TextUtils.isEmpty(c1289a.f55853d)) {
            setOnClickListener(new b(c1289a, tbPageContext, i));
        }
        if (TextUtils.isEmpty(c1289a.f55852c)) {
            return;
        }
        this.f17491f.setTag(c1289a.f55852c);
        this.f17491f.W(c1289a.f55852c, 10, false);
    }

    public void setOnItemViewLongClickListener(d.b.c.e.h.b bVar) {
        this.i = bVar;
    }

    public void setPosition(int i) {
        this.j = i;
    }

    public void setTime(String str) {
        if (TextUtils.isEmpty(str)) {
            this.f17493h.setVisibility(8);
            this.f17493h.setText("");
            return;
        }
        this.f17493h.setVisibility(0);
        this.f17493h.setText(str);
    }

    public MultiImageTextTopView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MultiImageTextTopView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.i = null;
        this.f17490e = context;
        d();
    }
}
