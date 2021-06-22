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
import d.a.o0.f1.g.d;
import d.a.o0.f1.l.c.a;
import d.a.o0.f1.w.c;
/* loaded from: classes4.dex */
public class MultiImageTextTopView extends RelativeLayout {

    /* renamed from: e  reason: collision with root package name */
    public Context f17185e;

    /* renamed from: f  reason: collision with root package name */
    public TbImageView f17186f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f17187g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f17188h;

    /* renamed from: i  reason: collision with root package name */
    public d.a.c.e.h.b f17189i;
    public int j;

    /* loaded from: classes4.dex */
    public class a implements View.OnLongClickListener {
        public a() {
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            if (MultiImageTextTopView.this.f17189i != null) {
                MultiImageTextTopView.this.f17189i.onItemViewLongClick(view, 9, MultiImageTextTopView.this.j, 0L);
                return false;
            }
            return false;
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a.C1378a f17191e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ TbPageContext f17192f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f17193g;

        public b(a.C1378a c1378a, TbPageContext tbPageContext, int i2) {
            this.f17191e = c1378a;
            this.f17192f = tbPageContext;
            this.f17193g = i2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.C1378a c1378a = this.f17191e;
            if (c1378a == null || StringUtils.isNull(c1378a.f58424d)) {
                return;
            }
            UrlManager.getInstance().dealOneLink(this.f17192f, new String[]{this.f17191e.f58424d});
            if (this.f17193g == 1) {
                TiebaStatic.eventStat(MultiImageTextTopView.this.f17185e, "official_msg_ck", PrefetchEvent.STATE_CLICK, 1, "fid", this.f17191e.f58425e);
                d j = c.j(this.f17191e.f58426f);
                if (j != null) {
                    TiebaStatic.eventStat(MultiImageTextTopView.this.f17185e, "message_open_detail", PrefetchEvent.STATE_CLICK, 1, "task_type", j.f58280a, "task_id", j.f58281b, "loc", "0");
                    int i2 = this.f17191e.f58427g;
                    if ((i2 == 1 || i2 == 3) && !"0".equals(j.f58281b)) {
                        d.a.o0.f1.u.a.c().a(j.f58281b);
                    }
                }
                StatisticItem statisticItem = new StatisticItem("official_message_open_detail");
                statisticItem.param("msg_id", this.f17191e.f58428h / 100);
                statisticItem.param("official_id", this.f17191e.f58429i);
                statisticItem.param("official_type", this.f17191e.j);
                statisticItem.param("operate_time", System.currentTimeMillis() / 1000);
                statisticItem.param("task_id", this.f17191e.k);
                statisticItem.param("obj_params1", this.f17191e.f58424d);
                TiebaStatic.log(statisticItem);
            }
        }
    }

    public MultiImageTextTopView(Context context) {
        this(context, null);
    }

    public final void d() {
        LayoutInflater.from(this.f17185e).inflate(R.layout.msg_multi_pic_text_top_view, (ViewGroup) this, true);
        TbImageView tbImageView = (TbImageView) findViewById(R.id.top_content_pic);
        this.f17186f = tbImageView;
        tbImageView.setAutoChangeStyle(false);
        this.f17187g = (TextView) findViewById(R.id.top_title);
        this.f17188h = (TextView) findViewById(R.id.show_time);
        setOnLongClickListener(new a());
    }

    public void e(boolean z) {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (!z) {
            skinType = 0;
        }
        this.f17186f.setAutoChangeStyle(z);
        SkinManager.setViewTextColor(this.f17187g, R.color.CAM_X0111, 1, skinType);
        SkinManager.setViewTextColor(this.f17188h, R.color.common_color_10067, 1, skinType);
    }

    public void f() {
        this.f17187g.setText("");
        this.f17186f.setBackgroundDrawable(null);
        this.f17186f.setImageDrawable(null);
        this.f17188h.setVisibility(8);
        this.f17188h.setText("");
    }

    public void setData(TbPageContext<?> tbPageContext, a.C1378a c1378a, View view, int i2) {
        setPadding((int) this.f17185e.getResources().getDimension(R.dimen.ds30), (int) this.f17185e.getResources().getDimension(R.dimen.ds30), (int) this.f17185e.getResources().getDimension(R.dimen.ds30), (int) this.f17185e.getResources().getDimension(R.dimen.ds30));
        if (c1378a == null) {
            return;
        }
        this.f17187g.setText(!TextUtils.isEmpty(c1378a.f58421a) ? c1378a.f58421a : "");
        if (!TextUtils.isEmpty(c1378a.f58424d)) {
            setOnClickListener(new b(c1378a, tbPageContext, i2));
        }
        if (TextUtils.isEmpty(c1378a.f58423c)) {
            return;
        }
        this.f17186f.setTag(c1378a.f58423c);
        this.f17186f.U(c1378a.f58423c, 10, false);
    }

    public void setOnItemViewLongClickListener(d.a.c.e.h.b bVar) {
        this.f17189i = bVar;
    }

    public void setPosition(int i2) {
        this.j = i2;
    }

    public void setTime(String str) {
        if (TextUtils.isEmpty(str)) {
            this.f17188h.setVisibility(8);
            this.f17188h.setText("");
            return;
        }
        this.f17188h.setVisibility(0);
        this.f17188h.setText(str);
    }

    public MultiImageTextTopView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MultiImageTextTopView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f17189i = null;
        this.f17185e = context;
        d();
    }
}
