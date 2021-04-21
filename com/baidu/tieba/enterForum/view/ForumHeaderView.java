package com.baidu.tieba.enterForum.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import d.b.c.e.p.l;
import d.b.j0.i0.d.c;
/* loaded from: classes4.dex */
public class ForumHeaderView extends LinearLayout implements View.OnClickListener {

    /* renamed from: e  reason: collision with root package name */
    public LinearLayout f15220e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f15221f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f15222g;

    /* renamed from: h  reason: collision with root package name */
    public c f15223h;
    public int i;

    public ForumHeaderView(Context context) {
        super(context);
        this.i = 0;
        a();
    }

    public void a() {
        setOrientation(1);
        LayoutInflater.from(getContext()).inflate(R.layout.layout_enterforum_search, (ViewGroup) this, true);
        this.f15220e = (LinearLayout) findViewById(R.id.search_container);
        this.f15221f = (TextView) findViewById(R.id.search_text);
        this.f15222g = (ImageView) findViewById(R.id.search_icon);
        setDescendantFocusability(262144);
        this.f15220e.setOnClickListener(this);
    }

    public void b() {
        c cVar = this.f15223h;
        if (cVar != null && cVar.f57021a) {
            if (cVar.f57023c > 0) {
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f15222g, R.drawable.icon_pure_search_import16_svg, R.color.CAM_X0109, null);
                SkinManager.setViewTextColor(this.f15221f, R.color.white_alpha50);
                SkinManager.setBackgroundResource(this.f15220e, R.drawable.enter_forum_search_ad_bg);
                return;
            }
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f15222g, R.drawable.icon_pure_search_import16_svg, R.color.CAM_X0109, null);
            SkinManager.setViewTextColor(this.f15221f, R.color.CAM_X0109);
            SkinManager.setBackgroundResource(this.f15220e, R.drawable.enter_forum_search_bg);
            return;
        }
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f15222g, R.drawable.icon_pure_search_import16_svg, R.color.CAM_X0109, null);
        SkinManager.setViewTextColor(this.f15221f, R.color.CAM_X0109);
        SkinManager.setBackgroundResource(this.f15220e, R.drawable.enter_forum_search_bg);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!TbadkCoreApplication.isLogin()) {
            TiebaStatic.eventStat(getContext(), "notlogin_8", PrefetchEvent.STATE_CLICK, 1, new Object[0]);
        }
        if (this.i != 1) {
            TiebaStatic.log(new StatisticItem("c13367").param("obj_location", "1"));
        } else {
            TiebaStatic.log(new StatisticItem("c13648").param("uid", TbadkCoreApplication.getCurrentAccountId()));
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2015003, new IntentConfig(getContext())));
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(l.k(getContext()), 1073741824), View.MeasureSpec.makeMeasureSpec(l.g(getContext(), R.dimen.tbds114), 1073741824));
    }

    public void setAdState(c cVar) {
        this.f15223h = cVar;
        b();
    }

    public void setFrom(int i) {
        this.i = i;
    }

    public void setSearchHint(String str) {
        this.f15221f.setText(str);
    }

    public ForumHeaderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.i = 0;
        a();
    }

    public ForumHeaderView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.i = 0;
        a();
    }
}
