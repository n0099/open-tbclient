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
    private ViewEventCenter aET;
    private View aGw;
    private BannerView aGx;

    public q(Context context) {
        this(context, null);
    }

    public q(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setEventCenter(ViewEventCenter viewEventCenter) {
        this.aET = viewEventCenter;
    }

    public void init() {
        com.baidu.adp.lib.g.b.hr().inflate(getContext(), com.baidu.tieba.r.enter_forum_header_view, this);
        setOrientation(1);
        setDescendantFocusability(AccessibilityEventCompat.TYPE_GESTURE_DETECTION_START);
        findViewById(com.baidu.tieba.q.search_root).setOnClickListener(new r(this));
    }

    public void b(TbPageContext<?> tbPageContext, com.baidu.tbadk.core.data.u uVar) {
        if (uVar != null) {
            if (this.aGx == null) {
                ((ViewStub) findViewById(com.baidu.tieba.q.viewstub_banner)).inflate();
                this.aGx = (BannerView) findViewById(com.baidu.tieba.q.home_like_banner_view);
            }
            this.aGx.reset();
            this.aGx.setBannerType("enterforum_banner");
            this.aGx.a(tbPageContext, uVar.rg(), uVar.getLink());
            String link = uVar.getLink();
            if (link != null && link.startsWith("game:detail:")) {
                TiebaStatic.eventStat(tbPageContext.getPageActivity(), "game_show", "show", 1, "ref_id", "4000401");
            }
        }
    }

    public void a(TbPageContext<?> tbPageContext, boolean z) {
        if (z) {
            if (this.aGw == null) {
                IG();
            }
            com.baidu.tbadk.f.a.a(tbPageContext, this.aGw);
            this.aGw.setVisibility(0);
        } else if (this.aGw != null) {
            this.aGw.setVisibility(8);
        }
    }

    public void IG() {
        this.aGw = ((ViewStub) findViewById(com.baidu.tieba.q.viewstub_guide)).inflate();
        this.aGw.findViewById(com.baidu.tieba.q.enterforum_guide_find_interest).setOnClickListener(new s(this));
    }

    public void d(TbPageContext<?> tbPageContext) {
        com.baidu.tbadk.f.a.a(tbPageContext, this);
        if (this.aGx != null) {
            this.aGx.oG();
        }
    }
}
