package com.baidu.tieba.enterForum.d;

import android.content.Context;
import android.support.v4.view.accessibility.AccessibilityEventCompat;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewStub;
import android.widget.LinearLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.view.BannerView;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
/* loaded from: classes.dex */
public class q extends LinearLayout {
    private ViewEventCenter aEU;
    private View aGx;
    private BannerView aGy;

    public q(Context context) {
        this(context, null);
    }

    public q(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setEventCenter(ViewEventCenter viewEventCenter) {
        this.aEU = viewEventCenter;
    }

    public void init() {
        com.baidu.adp.lib.g.b.hr().inflate(getContext(), com.baidu.tieba.r.enter_forum_header_view, this);
        setOrientation(1);
        setDescendantFocusability(AccessibilityEventCompat.TYPE_GESTURE_DETECTION_START);
        findViewById(com.baidu.tieba.q.search_root).setOnClickListener(new r(this));
    }

    public void b(TbPageContext<?> tbPageContext, com.baidu.tbadk.core.data.u uVar) {
        if (uVar != null) {
            if (this.aGy == null) {
                ((ViewStub) findViewById(com.baidu.tieba.q.viewstub_banner)).inflate();
                this.aGy = (BannerView) findViewById(com.baidu.tieba.q.home_like_banner_view);
            }
            this.aGy.reset();
            this.aGy.setBannerType("enterforum_banner");
            this.aGy.a(tbPageContext, uVar.rg(), uVar.getLink());
            String link = uVar.getLink();
            if (link != null && link.startsWith("game:detail:")) {
                TiebaStatic.eventStat(tbPageContext.getPageActivity(), "game_show", "show", 1, "ref_id", "4000401");
            }
        }
    }

    public void a(TbPageContext<?> tbPageContext, boolean z) {
        if (z) {
            if (this.aGx == null) {
                IH();
            }
            com.baidu.tbadk.f.a.a(tbPageContext, this.aGx);
            this.aGx.setVisibility(0);
        } else if (this.aGx != null) {
            this.aGx.setVisibility(8);
        }
    }

    public void IH() {
        this.aGx = ((ViewStub) findViewById(com.baidu.tieba.q.viewstub_guide)).inflate();
        this.aGx.findViewById(com.baidu.tieba.q.enterforum_guide_find_interest).setOnClickListener(new s(this));
    }

    public void d(TbPageContext<?> tbPageContext) {
        com.baidu.tbadk.f.a.a(tbPageContext, this);
        if (this.aGy != null) {
            this.aGy.oG();
        }
    }
}
