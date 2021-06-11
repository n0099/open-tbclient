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
    public Context f17103e;

    /* renamed from: f  reason: collision with root package name */
    public TbImageView f17104f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f17105g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f17106h;

    /* renamed from: i  reason: collision with root package name */
    public d.a.c.e.h.b f17107i;
    public int j;

    /* loaded from: classes4.dex */
    public class a implements View.OnLongClickListener {
        public a() {
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            if (MultiImageTextTopView.this.f17107i != null) {
                MultiImageTextTopView.this.f17107i.onItemViewLongClick(view, 9, MultiImageTextTopView.this.j, 0L);
                return false;
            }
            return false;
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a.C1374a f17109e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ TbPageContext f17110f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f17111g;

        public b(a.C1374a c1374a, TbPageContext tbPageContext, int i2) {
            this.f17109e = c1374a;
            this.f17110f = tbPageContext;
            this.f17111g = i2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.C1374a c1374a = this.f17109e;
            if (c1374a == null || StringUtils.isNull(c1374a.f58299d)) {
                return;
            }
            UrlManager.getInstance().dealOneLink(this.f17110f, new String[]{this.f17109e.f58299d});
            if (this.f17111g == 1) {
                TiebaStatic.eventStat(MultiImageTextTopView.this.f17103e, "official_msg_ck", PrefetchEvent.STATE_CLICK, 1, "fid", this.f17109e.f58300e);
                d j = c.j(this.f17109e.f58301f);
                if (j != null) {
                    TiebaStatic.eventStat(MultiImageTextTopView.this.f17103e, "message_open_detail", PrefetchEvent.STATE_CLICK, 1, "task_type", j.f58155a, "task_id", j.f58156b, "loc", "0");
                    int i2 = this.f17109e.f58302g;
                    if ((i2 == 1 || i2 == 3) && !"0".equals(j.f58156b)) {
                        d.a.n0.f1.u.a.c().a(j.f58156b);
                    }
                }
                StatisticItem statisticItem = new StatisticItem("official_message_open_detail");
                statisticItem.param("msg_id", this.f17109e.f58303h / 100);
                statisticItem.param("official_id", this.f17109e.f58304i);
                statisticItem.param("official_type", this.f17109e.j);
                statisticItem.param("operate_time", System.currentTimeMillis() / 1000);
                statisticItem.param("task_id", this.f17109e.k);
                statisticItem.param("obj_params1", this.f17109e.f58299d);
                TiebaStatic.log(statisticItem);
            }
        }
    }

    public MultiImageTextTopView(Context context) {
        this(context, null);
    }

    public final void d() {
        LayoutInflater.from(this.f17103e).inflate(R.layout.msg_multi_pic_text_top_view, (ViewGroup) this, true);
        TbImageView tbImageView = (TbImageView) findViewById(R.id.top_content_pic);
        this.f17104f = tbImageView;
        tbImageView.setAutoChangeStyle(false);
        this.f17105g = (TextView) findViewById(R.id.top_title);
        this.f17106h = (TextView) findViewById(R.id.show_time);
        setOnLongClickListener(new a());
    }

    public void e(boolean z) {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (!z) {
            skinType = 0;
        }
        this.f17104f.setAutoChangeStyle(z);
        SkinManager.setViewTextColor(this.f17105g, R.color.CAM_X0111, 1, skinType);
        SkinManager.setViewTextColor(this.f17106h, R.color.common_color_10067, 1, skinType);
    }

    public void f() {
        this.f17105g.setText("");
        this.f17104f.setBackgroundDrawable(null);
        this.f17104f.setImageDrawable(null);
        this.f17106h.setVisibility(8);
        this.f17106h.setText("");
    }

    public void setData(TbPageContext<?> tbPageContext, a.C1374a c1374a, View view, int i2) {
        setPadding((int) this.f17103e.getResources().getDimension(R.dimen.ds30), (int) this.f17103e.getResources().getDimension(R.dimen.ds30), (int) this.f17103e.getResources().getDimension(R.dimen.ds30), (int) this.f17103e.getResources().getDimension(R.dimen.ds30));
        if (c1374a == null) {
            return;
        }
        this.f17105g.setText(!TextUtils.isEmpty(c1374a.f58296a) ? c1374a.f58296a : "");
        if (!TextUtils.isEmpty(c1374a.f58299d)) {
            setOnClickListener(new b(c1374a, tbPageContext, i2));
        }
        if (TextUtils.isEmpty(c1374a.f58298c)) {
            return;
        }
        this.f17104f.setTag(c1374a.f58298c);
        this.f17104f.U(c1374a.f58298c, 10, false);
    }

    public void setOnItemViewLongClickListener(d.a.c.e.h.b bVar) {
        this.f17107i = bVar;
    }

    public void setPosition(int i2) {
        this.j = i2;
    }

    public void setTime(String str) {
        if (TextUtils.isEmpty(str)) {
            this.f17106h.setVisibility(8);
            this.f17106h.setText("");
            return;
        }
        this.f17106h.setVisibility(0);
        this.f17106h.setText(str);
    }

    public MultiImageTextTopView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MultiImageTextTopView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f17107i = null;
        this.f17103e = context;
        d();
    }
}
