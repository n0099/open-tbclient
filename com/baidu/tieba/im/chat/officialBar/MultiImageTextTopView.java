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
import d.a.j0.e1.g.d;
import d.a.j0.e1.l.c.a;
import d.a.j0.e1.w.c;
/* loaded from: classes4.dex */
public class MultiImageTextTopView extends RelativeLayout {

    /* renamed from: e  reason: collision with root package name */
    public Context f17802e;

    /* renamed from: f  reason: collision with root package name */
    public TbImageView f17803f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f17804g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f17805h;

    /* renamed from: i  reason: collision with root package name */
    public d.a.c.e.h.b f17806i;
    public int j;

    /* loaded from: classes4.dex */
    public class a implements View.OnLongClickListener {
        public a() {
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            if (MultiImageTextTopView.this.f17806i != null) {
                MultiImageTextTopView.this.f17806i.onItemViewLongClick(view, 9, MultiImageTextTopView.this.j, 0L);
                return false;
            }
            return false;
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a.C1228a f17808e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ TbPageContext f17809f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f17810g;

        public b(a.C1228a c1228a, TbPageContext tbPageContext, int i2) {
            this.f17808e = c1228a;
            this.f17809f = tbPageContext;
            this.f17810g = i2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.C1228a c1228a = this.f17808e;
            if (c1228a == null || StringUtils.isNull(c1228a.f53713d)) {
                return;
            }
            UrlManager.getInstance().dealOneLink(this.f17809f, new String[]{this.f17808e.f53713d});
            if (this.f17810g == 1) {
                TiebaStatic.eventStat(MultiImageTextTopView.this.f17802e, "official_msg_ck", PrefetchEvent.STATE_CLICK, 1, "fid", this.f17808e.f53714e);
                d j = c.j(this.f17808e.f53715f);
                if (j != null) {
                    TiebaStatic.eventStat(MultiImageTextTopView.this.f17802e, "message_open_detail", PrefetchEvent.STATE_CLICK, 1, "task_type", j.f53569a, "task_id", j.f53570b, "loc", "0");
                    int i2 = this.f17808e.f53716g;
                    if ((i2 == 1 || i2 == 3) && !"0".equals(j.f53570b)) {
                        d.a.j0.e1.u.a.c().a(j.f53570b);
                    }
                }
                StatisticItem statisticItem = new StatisticItem("official_message_open_detail");
                statisticItem.param("msg_id", this.f17808e.f53717h / 100);
                statisticItem.param("official_id", this.f17808e.f53718i);
                statisticItem.param("official_type", this.f17808e.j);
                statisticItem.param("operate_time", System.currentTimeMillis() / 1000);
                statisticItem.param("task_id", this.f17808e.k);
                statisticItem.param("obj_params1", this.f17808e.f53713d);
                TiebaStatic.log(statisticItem);
            }
        }
    }

    public MultiImageTextTopView(Context context) {
        this(context, null);
    }

    public final void d() {
        LayoutInflater.from(this.f17802e).inflate(R.layout.msg_multi_pic_text_top_view, (ViewGroup) this, true);
        TbImageView tbImageView = (TbImageView) findViewById(R.id.top_content_pic);
        this.f17803f = tbImageView;
        tbImageView.setAutoChangeStyle(false);
        this.f17804g = (TextView) findViewById(R.id.top_title);
        this.f17805h = (TextView) findViewById(R.id.show_time);
        setOnLongClickListener(new a());
    }

    public void e(boolean z) {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (!z) {
            skinType = 0;
        }
        this.f17803f.setAutoChangeStyle(z);
        SkinManager.setViewTextColor(this.f17804g, R.color.CAM_X0111, 1, skinType);
        SkinManager.setViewTextColor(this.f17805h, R.color.common_color_10067, 1, skinType);
    }

    public void f() {
        this.f17804g.setText("");
        this.f17803f.setBackgroundDrawable(null);
        this.f17803f.setImageDrawable(null);
        this.f17805h.setVisibility(8);
        this.f17805h.setText("");
    }

    public void setData(TbPageContext<?> tbPageContext, a.C1228a c1228a, View view, int i2) {
        setPadding((int) this.f17802e.getResources().getDimension(R.dimen.ds30), (int) this.f17802e.getResources().getDimension(R.dimen.ds30), (int) this.f17802e.getResources().getDimension(R.dimen.ds30), (int) this.f17802e.getResources().getDimension(R.dimen.ds30));
        if (c1228a == null) {
            return;
        }
        this.f17804g.setText(!TextUtils.isEmpty(c1228a.f53710a) ? c1228a.f53710a : "");
        if (!TextUtils.isEmpty(c1228a.f53713d)) {
            setOnClickListener(new b(c1228a, tbPageContext, i2));
        }
        if (TextUtils.isEmpty(c1228a.f53712c)) {
            return;
        }
        this.f17803f.setTag(c1228a.f53712c);
        this.f17803f.V(c1228a.f53712c, 10, false);
    }

    public void setOnItemViewLongClickListener(d.a.c.e.h.b bVar) {
        this.f17806i = bVar;
    }

    public void setPosition(int i2) {
        this.j = i2;
    }

    public void setTime(String str) {
        if (TextUtils.isEmpty(str)) {
            this.f17805h.setVisibility(8);
            this.f17805h.setText("");
            return;
        }
        this.f17805h.setVisibility(0);
        this.f17805h.setText(str);
    }

    public MultiImageTextTopView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MultiImageTextTopView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f17806i = null;
        this.f17802e = context;
        d();
    }
}
