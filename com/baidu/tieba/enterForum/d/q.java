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
    private ViewEventCenter aCK;
    private View aEl;
    private BannerView aEm;

    public q(Context context) {
        this(context, null);
    }

    public q(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setEventCenter(ViewEventCenter viewEventCenter) {
        this.aCK = viewEventCenter;
    }

    public void init() {
        com.baidu.adp.lib.g.b.hH().inflate(getContext(), com.baidu.tieba.w.enter_forum_header_view, this);
        setOrientation(1);
        setDescendantFocusability(AccessibilityEventCompat.TYPE_GESTURE_DETECTION_START);
        findViewById(com.baidu.tieba.v.search_root).setOnClickListener(new r(this));
    }

    public void b(TbPageContext<?> tbPageContext, com.baidu.tbadk.core.data.u uVar) {
        if (uVar != null) {
            if (this.aEm == null) {
                ((ViewStub) findViewById(com.baidu.tieba.v.viewstub_banner)).inflate();
                this.aEm = (BannerView) findViewById(com.baidu.tieba.v.home_like_banner_view);
            }
            this.aEm.reset();
            this.aEm.setBannerType("enterforum_banner");
            this.aEm.a(tbPageContext, uVar.qA(), uVar.getLink());
            String link = uVar.getLink();
            if (link != null && link.startsWith("game:detail:")) {
                TiebaStatic.eventStat(tbPageContext.getPageActivity(), "game_show", "show", 1, "ref_id", "4000401");
            }
        }
    }

    public void a(TbPageContext<?> tbPageContext, boolean z) {
        if (z) {
            if (this.aEl == null) {
                HA();
            }
            com.baidu.tbadk.f.a.a(tbPageContext, this.aEl);
            this.aEl.setVisibility(0);
        } else if (this.aEl != null) {
            this.aEl.setVisibility(8);
        }
    }

    public void HA() {
        this.aEl = ((ViewStub) findViewById(com.baidu.tieba.v.viewstub_guide)).inflate();
        this.aEl.findViewById(com.baidu.tieba.v.enterforum_guide_find_interest).setOnClickListener(new s(this));
    }

    public void f(TbPageContext<?> tbPageContext) {
        com.baidu.tbadk.f.a.a(tbPageContext, this);
        if (this.aEm != null) {
            this.aEm.oq();
        }
    }
}
