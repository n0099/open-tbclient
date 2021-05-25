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
import d.a.n0.f1.g.d;
import d.a.n0.f1.l.c.a;
import d.a.n0.f1.w.c;
/* loaded from: classes4.dex */
public class MultiImageTextTopView extends RelativeLayout {

    /* renamed from: e  reason: collision with root package name */
    public Context f17027e;

    /* renamed from: f  reason: collision with root package name */
    public TbImageView f17028f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f17029g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f17030h;

    /* renamed from: i  reason: collision with root package name */
    public d.a.c.e.h.b f17031i;
    public int j;

    /* loaded from: classes4.dex */
    public class a implements View.OnLongClickListener {
        public a() {
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            if (MultiImageTextTopView.this.f17031i != null) {
                MultiImageTextTopView.this.f17031i.onItemViewLongClick(view, 9, MultiImageTextTopView.this.j, 0L);
                return false;
            }
            return false;
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a.C1318a f17033e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ TbPageContext f17034f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f17035g;

        public b(a.C1318a c1318a, TbPageContext tbPageContext, int i2) {
            this.f17033e = c1318a;
            this.f17034f = tbPageContext;
            this.f17035g = i2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.C1318a c1318a = this.f17033e;
            if (c1318a == null || StringUtils.isNull(c1318a.f54610d)) {
                return;
            }
            UrlManager.getInstance().dealOneLink(this.f17034f, new String[]{this.f17033e.f54610d});
            if (this.f17035g == 1) {
                TiebaStatic.eventStat(MultiImageTextTopView.this.f17027e, "official_msg_ck", PrefetchEvent.STATE_CLICK, 1, "fid", this.f17033e.f54611e);
                d j = c.j(this.f17033e.f54612f);
                if (j != null) {
                    TiebaStatic.eventStat(MultiImageTextTopView.this.f17027e, "message_open_detail", PrefetchEvent.STATE_CLICK, 1, "task_type", j.f54466a, "task_id", j.f54467b, "loc", "0");
                    int i2 = this.f17033e.f54613g;
                    if ((i2 == 1 || i2 == 3) && !"0".equals(j.f54467b)) {
                        d.a.n0.f1.u.a.c().a(j.f54467b);
                    }
                }
                StatisticItem statisticItem = new StatisticItem("official_message_open_detail");
                statisticItem.param("msg_id", this.f17033e.f54614h / 100);
                statisticItem.param("official_id", this.f17033e.f54615i);
                statisticItem.param("official_type", this.f17033e.j);
                statisticItem.param("operate_time", System.currentTimeMillis() / 1000);
                statisticItem.param("task_id", this.f17033e.k);
                statisticItem.param("obj_params1", this.f17033e.f54610d);
                TiebaStatic.log(statisticItem);
            }
        }
    }

    public MultiImageTextTopView(Context context) {
        this(context, null);
    }

    public final void d() {
        LayoutInflater.from(this.f17027e).inflate(R.layout.msg_multi_pic_text_top_view, (ViewGroup) this, true);
        TbImageView tbImageView = (TbImageView) findViewById(R.id.top_content_pic);
        this.f17028f = tbImageView;
        tbImageView.setAutoChangeStyle(false);
        this.f17029g = (TextView) findViewById(R.id.top_title);
        this.f17030h = (TextView) findViewById(R.id.show_time);
        setOnLongClickListener(new a());
    }

    public void e(boolean z) {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (!z) {
            skinType = 0;
        }
        this.f17028f.setAutoChangeStyle(z);
        SkinManager.setViewTextColor(this.f17029g, R.color.CAM_X0111, 1, skinType);
        SkinManager.setViewTextColor(this.f17030h, R.color.common_color_10067, 1, skinType);
    }

    public void f() {
        this.f17029g.setText("");
        this.f17028f.setBackgroundDrawable(null);
        this.f17028f.setImageDrawable(null);
        this.f17030h.setVisibility(8);
        this.f17030h.setText("");
    }

    public void setData(TbPageContext<?> tbPageContext, a.C1318a c1318a, View view, int i2) {
        setPadding((int) this.f17027e.getResources().getDimension(R.dimen.ds30), (int) this.f17027e.getResources().getDimension(R.dimen.ds30), (int) this.f17027e.getResources().getDimension(R.dimen.ds30), (int) this.f17027e.getResources().getDimension(R.dimen.ds30));
        if (c1318a == null) {
            return;
        }
        this.f17029g.setText(!TextUtils.isEmpty(c1318a.f54607a) ? c1318a.f54607a : "");
        if (!TextUtils.isEmpty(c1318a.f54610d)) {
            setOnClickListener(new b(c1318a, tbPageContext, i2));
        }
        if (TextUtils.isEmpty(c1318a.f54609c)) {
            return;
        }
        this.f17028f.setTag(c1318a.f54609c);
        this.f17028f.V(c1318a.f54609c, 10, false);
    }

    public void setOnItemViewLongClickListener(d.a.c.e.h.b bVar) {
        this.f17031i = bVar;
    }

    public void setPosition(int i2) {
        this.j = i2;
    }

    public void setTime(String str) {
        if (TextUtils.isEmpty(str)) {
            this.f17030h.setVisibility(8);
            this.f17030h.setText("");
            return;
        }
        this.f17030h.setVisibility(0);
        this.f17030h.setText(str);
    }

    public MultiImageTextTopView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MultiImageTextTopView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f17031i = null;
        this.f17027e = context;
        d();
    }
}
