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
import d.a.k0.i0.d.c;
/* loaded from: classes4.dex */
public class ForumHeaderView extends LinearLayout implements View.OnClickListener {

    /* renamed from: e  reason: collision with root package name */
    public LinearLayout f14672e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f14673f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f14674g;

    /* renamed from: h  reason: collision with root package name */
    public c f14675h;

    /* renamed from: i  reason: collision with root package name */
    public int f14676i;

    public ForumHeaderView(Context context) {
        super(context);
        this.f14676i = 0;
        a();
    }

    public void a() {
        setOrientation(1);
        LayoutInflater.from(getContext()).inflate(R.layout.layout_enterforum_search, (ViewGroup) this, true);
        this.f14672e = (LinearLayout) findViewById(R.id.search_container);
        this.f14673f = (TextView) findViewById(R.id.search_text);
        this.f14674g = (ImageView) findViewById(R.id.search_icon);
        setDescendantFocusability(262144);
        this.f14672e.setOnClickListener(this);
    }

    public void b() {
        c cVar = this.f14675h;
        if (cVar != null && cVar.f55651a) {
            if (cVar.f55653c > 0) {
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f14674g, R.drawable.icon_pure_search_import16_svg, R.color.CAM_X0109, null);
                SkinManager.setViewTextColor(this.f14673f, R.color.white_alpha50);
                SkinManager.setBackgroundResource(this.f14672e, R.drawable.enter_forum_search_ad_bg);
                return;
            }
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f14674g, R.drawable.icon_pure_search_import16_svg, R.color.CAM_X0109, null);
            SkinManager.setViewTextColor(this.f14673f, R.color.CAM_X0109);
            SkinManager.setBackgroundResource(this.f14672e, R.drawable.enter_forum_search_bg);
            return;
        }
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f14674g, R.drawable.icon_pure_search_import16_svg, R.color.CAM_X0109, null);
        SkinManager.setViewTextColor(this.f14673f, R.color.CAM_X0109);
        SkinManager.setBackgroundResource(this.f14672e, R.drawable.enter_forum_search_bg);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!TbadkCoreApplication.isLogin()) {
            TiebaStatic.eventStat(getContext(), "notlogin_8", PrefetchEvent.STATE_CLICK, 1, new Object[0]);
        }
        if (this.f14676i != 1) {
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
        this.f14675h = cVar;
        b();
    }

    public void setFrom(int i2) {
        this.f14676i = i2;
    }

    public void setSearchHint(String str) {
        this.f14673f.setText(str);
    }

    public ForumHeaderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f14676i = 0;
        a();
    }

    public ForumHeaderView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f14676i = 0;
        a();
    }
}
