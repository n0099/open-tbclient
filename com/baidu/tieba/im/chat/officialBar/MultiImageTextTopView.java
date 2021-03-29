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
import d.b.i0.d1.g.d;
import d.b.i0.d1.l.c.a;
import d.b.i0.d1.w.c;
/* loaded from: classes3.dex */
public class MultiImageTextTopView extends RelativeLayout {

    /* renamed from: e  reason: collision with root package name */
    public Context f17805e;

    /* renamed from: f  reason: collision with root package name */
    public TbImageView f17806f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f17807g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f17808h;
    public d.b.b.e.h.b i;
    public int j;

    /* loaded from: classes3.dex */
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

    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a.C1203a f17810e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ TbPageContext f17811f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f17812g;

        public b(a.C1203a c1203a, TbPageContext tbPageContext, int i) {
            this.f17810e = c1203a;
            this.f17811f = tbPageContext;
            this.f17812g = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.C1203a c1203a = this.f17810e;
            if (c1203a == null || StringUtils.isNull(c1203a.f53910d)) {
                return;
            }
            UrlManager.getInstance().dealOneLink(this.f17811f, new String[]{this.f17810e.f53910d});
            if (this.f17812g == 1) {
                TiebaStatic.eventStat(MultiImageTextTopView.this.f17805e, "official_msg_ck", PrefetchEvent.STATE_CLICK, 1, "fid", this.f17810e.f53911e);
                d j = c.j(this.f17810e.f53912f);
                if (j != null) {
                    TiebaStatic.eventStat(MultiImageTextTopView.this.f17805e, "message_open_detail", PrefetchEvent.STATE_CLICK, 1, "task_type", j.f53771a, "task_id", j.f53772b, "loc", "0");
                    int i = this.f17810e.f53913g;
                    if ((i == 1 || i == 3) && !"0".equals(j.f53772b)) {
                        d.b.i0.d1.u.a.c().a(j.f53772b);
                    }
                }
                StatisticItem statisticItem = new StatisticItem("official_message_open_detail");
                statisticItem.param("msg_id", this.f17810e.f53914h / 100);
                statisticItem.param("official_id", this.f17810e.i);
                statisticItem.param("official_type", this.f17810e.j);
                statisticItem.param("operate_time", System.currentTimeMillis() / 1000);
                statisticItem.param("task_id", this.f17810e.k);
                statisticItem.param("obj_params1", this.f17810e.f53910d);
                TiebaStatic.log(statisticItem);
            }
        }
    }

    public MultiImageTextTopView(Context context) {
        this(context, null);
    }

    public final void d() {
        LayoutInflater.from(this.f17805e).inflate(R.layout.msg_multi_pic_text_top_view, (ViewGroup) this, true);
        TbImageView tbImageView = (TbImageView) findViewById(R.id.top_content_pic);
        this.f17806f = tbImageView;
        tbImageView.setAutoChangeStyle(false);
        this.f17807g = (TextView) findViewById(R.id.top_title);
        this.f17808h = (TextView) findViewById(R.id.show_time);
        setOnLongClickListener(new a());
    }

    public void e(boolean z) {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (!z) {
            skinType = 0;
        }
        this.f17806f.setAutoChangeStyle(z);
        SkinManager.setViewTextColor(this.f17807g, R.color.CAM_X0111, 1, skinType);
        SkinManager.setViewTextColor(this.f17808h, R.color.common_color_10067, 1, skinType);
    }

    public void f() {
        this.f17807g.setText("");
        this.f17806f.setBackgroundDrawable(null);
        this.f17806f.setImageDrawable(null);
        this.f17808h.setVisibility(8);
        this.f17808h.setText("");
    }

    public void setData(TbPageContext<?> tbPageContext, a.C1203a c1203a, View view, int i) {
        setPadding((int) this.f17805e.getResources().getDimension(R.dimen.ds30), (int) this.f17805e.getResources().getDimension(R.dimen.ds30), (int) this.f17805e.getResources().getDimension(R.dimen.ds30), (int) this.f17805e.getResources().getDimension(R.dimen.ds30));
        if (c1203a == null) {
            return;
        }
        this.f17807g.setText(!TextUtils.isEmpty(c1203a.f53907a) ? c1203a.f53907a : "");
        if (!TextUtils.isEmpty(c1203a.f53910d)) {
            setOnClickListener(new b(c1203a, tbPageContext, i));
        }
        if (TextUtils.isEmpty(c1203a.f53909c)) {
            return;
        }
        this.f17806f.setTag(c1203a.f53909c);
        this.f17806f.W(c1203a.f53909c, 10, false);
    }

    public void setOnItemViewLongClickListener(d.b.b.e.h.b bVar) {
        this.i = bVar;
    }

    public void setPosition(int i) {
        this.j = i;
    }

    public void setTime(String str) {
        if (TextUtils.isEmpty(str)) {
            this.f17808h.setVisibility(8);
            this.f17808h.setText("");
            return;
        }
        this.f17808h.setVisibility(0);
        this.f17808h.setText(str);
    }

    public MultiImageTextTopView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MultiImageTextTopView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.i = null;
        this.f17805e = context;
        d();
    }
}
