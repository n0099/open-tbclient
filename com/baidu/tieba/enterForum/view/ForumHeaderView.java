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
import d.a.c.e.p.l;
import d.a.j0.i0.d.c;
/* loaded from: classes4.dex */
public class ForumHeaderView extends LinearLayout implements View.OnClickListener {

    /* renamed from: e  reason: collision with root package name */
    public LinearLayout f15357e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f15358f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f15359g;

    /* renamed from: h  reason: collision with root package name */
    public c f15360h;

    /* renamed from: i  reason: collision with root package name */
    public int f15361i;

    public ForumHeaderView(Context context) {
        super(context);
        this.f15361i = 0;
        a();
    }

    public void a() {
        setOrientation(1);
        LayoutInflater.from(getContext()).inflate(R.layout.layout_enterforum_search, (ViewGroup) this, true);
        this.f15357e = (LinearLayout) findViewById(R.id.search_container);
        this.f15358f = (TextView) findViewById(R.id.search_text);
        this.f15359g = (ImageView) findViewById(R.id.search_icon);
        setDescendantFocusability(262144);
        this.f15357e.setOnClickListener(this);
    }

    public void b() {
        c cVar = this.f15360h;
        if (cVar != null && cVar.f54944a) {
            if (cVar.f54946c > 0) {
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f15359g, R.drawable.icon_pure_search_import16_svg, R.color.CAM_X0109, null);
                SkinManager.setViewTextColor(this.f15358f, R.color.white_alpha50);
                SkinManager.setBackgroundResource(this.f15357e, R.drawable.enter_forum_search_ad_bg);
                return;
            }
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f15359g, R.drawable.icon_pure_search_import16_svg, R.color.CAM_X0109, null);
            SkinManager.setViewTextColor(this.f15358f, R.color.CAM_X0109);
            SkinManager.setBackgroundResource(this.f15357e, R.drawable.enter_forum_search_bg);
            return;
        }
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f15359g, R.drawable.icon_pure_search_import16_svg, R.color.CAM_X0109, null);
        SkinManager.setViewTextColor(this.f15358f, R.color.CAM_X0109);
        SkinManager.setBackgroundResource(this.f15357e, R.drawable.enter_forum_search_bg);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!TbadkCoreApplication.isLogin()) {
            TiebaStatic.eventStat(getContext(), "notlogin_8", PrefetchEvent.STATE_CLICK, 1, new Object[0]);
        }
        if (this.f15361i != 1) {
            TiebaStatic.log(new StatisticItem("c13367").param("obj_location", "1"));
        } else {
            TiebaStatic.log(new StatisticItem("c13648").param("uid", TbadkCoreApplication.getCurrentAccountId()));
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2015003, new IntentConfig(getContext())));
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i2, int i3) {
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(l.k(getContext()), 1073741824), View.MeasureSpec.makeMeasureSpec(l.g(getContext(), R.dimen.tbds114), 1073741824));
    }

    public void setAdState(c cVar) {
        this.f15360h = cVar;
        b();
    }

    public void setFrom(int i2) {
        this.f15361i = i2;
    }

    public void setSearchHint(String str) {
        this.f15358f.setText(str);
    }

    public ForumHeaderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f15361i = 0;
        a();
    }

    public ForumHeaderView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f15361i = 0;
        a();
    }
}
