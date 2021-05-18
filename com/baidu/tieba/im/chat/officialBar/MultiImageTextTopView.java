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
import d.a.k0.e1.g.d;
import d.a.k0.e1.l.c.a;
import d.a.k0.e1.w.c;
/* loaded from: classes4.dex */
public class MultiImageTextTopView extends RelativeLayout {

    /* renamed from: e  reason: collision with root package name */
    public Context f17117e;

    /* renamed from: f  reason: collision with root package name */
    public TbImageView f17118f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f17119g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f17120h;

    /* renamed from: i  reason: collision with root package name */
    public d.a.c.e.h.b f17121i;
    public int j;

    /* loaded from: classes4.dex */
    public class a implements View.OnLongClickListener {
        public a() {
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            if (MultiImageTextTopView.this.f17121i != null) {
                MultiImageTextTopView.this.f17121i.onItemViewLongClick(view, 9, MultiImageTextTopView.this.j, 0L);
                return false;
            }
            return false;
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a.C1300a f17123e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ TbPageContext f17124f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f17125g;

        public b(a.C1300a c1300a, TbPageContext tbPageContext, int i2) {
            this.f17123e = c1300a;
            this.f17124f = tbPageContext;
            this.f17125g = i2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.C1300a c1300a = this.f17123e;
            if (c1300a == null || StringUtils.isNull(c1300a.f54420d)) {
                return;
            }
            UrlManager.getInstance().dealOneLink(this.f17124f, new String[]{this.f17123e.f54420d});
            if (this.f17125g == 1) {
                TiebaStatic.eventStat(MultiImageTextTopView.this.f17117e, "official_msg_ck", PrefetchEvent.STATE_CLICK, 1, "fid", this.f17123e.f54421e);
                d j = c.j(this.f17123e.f54422f);
                if (j != null) {
                    TiebaStatic.eventStat(MultiImageTextTopView.this.f17117e, "message_open_detail", PrefetchEvent.STATE_CLICK, 1, "task_type", j.f54276a, "task_id", j.f54277b, "loc", "0");
                    int i2 = this.f17123e.f54423g;
                    if ((i2 == 1 || i2 == 3) && !"0".equals(j.f54277b)) {
                        d.a.k0.e1.u.a.c().a(j.f54277b);
                    }
                }
                StatisticItem statisticItem = new StatisticItem("official_message_open_detail");
                statisticItem.param("msg_id", this.f17123e.f54424h / 100);
                statisticItem.param("official_id", this.f17123e.f54425i);
                statisticItem.param("official_type", this.f17123e.j);
                statisticItem.param("operate_time", System.currentTimeMillis() / 1000);
                statisticItem.param("task_id", this.f17123e.k);
                statisticItem.param("obj_params1", this.f17123e.f54420d);
                TiebaStatic.log(statisticItem);
            }
        }
    }

    public MultiImageTextTopView(Context context) {
        this(context, null);
    }

    public final void d() {
        LayoutInflater.from(this.f17117e).inflate(R.layout.msg_multi_pic_text_top_view, (ViewGroup) this, true);
        TbImageView tbImageView = (TbImageView) findViewById(R.id.top_content_pic);
        this.f17118f = tbImageView;
        tbImageView.setAutoChangeStyle(false);
        this.f17119g = (TextView) findViewById(R.id.top_title);
        this.f17120h = (TextView) findViewById(R.id.show_time);
        setOnLongClickListener(new a());
    }

    public void e(boolean z) {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (!z) {
            skinType = 0;
        }
        this.f17118f.setAutoChangeStyle(z);
        SkinManager.setViewTextColor(this.f17119g, R.color.CAM_X0111, 1, skinType);
        SkinManager.setViewTextColor(this.f17120h, R.color.common_color_10067, 1, skinType);
    }

    public void f() {
        this.f17119g.setText("");
        this.f17118f.setBackgroundDrawable(null);
        this.f17118f.setImageDrawable(null);
        this.f17120h.setVisibility(8);
        this.f17120h.setText("");
    }

    public void setData(TbPageContext<?> tbPageContext, a.C1300a c1300a, View view, int i2) {
        setPadding((int) this.f17117e.getResources().getDimension(R.dimen.ds30), (int) this.f17117e.getResources().getDimension(R.dimen.ds30), (int) this.f17117e.getResources().getDimension(R.dimen.ds30), (int) this.f17117e.getResources().getDimension(R.dimen.ds30));
        if (c1300a == null) {
            return;
        }
        this.f17119g.setText(!TextUtils.isEmpty(c1300a.f54417a) ? c1300a.f54417a : "");
        if (!TextUtils.isEmpty(c1300a.f54420d)) {
            setOnClickListener(new b(c1300a, tbPageContext, i2));
        }
        if (TextUtils.isEmpty(c1300a.f54419c)) {
            return;
        }
        this.f17118f.setTag(c1300a.f54419c);
        this.f17118f.V(c1300a.f54419c, 10, false);
    }

    public void setOnItemViewLongClickListener(d.a.c.e.h.b bVar) {
        this.f17121i = bVar;
    }

    public void setPosition(int i2) {
        this.j = i2;
    }

    public void setTime(String str) {
        if (TextUtils.isEmpty(str)) {
            this.f17120h.setVisibility(8);
            this.f17120h.setText("");
            return;
        }
        this.f17120h.setVisibility(0);
        this.f17120h.setText(str);
    }

    public MultiImageTextTopView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MultiImageTextTopView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f17121i = null;
        this.f17117e = context;
        d();
    }
}
