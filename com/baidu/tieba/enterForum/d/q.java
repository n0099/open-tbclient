package com.baidu.tieba.enterForum.d;

import android.content.Context;
import android.support.v4.view.accessibility.AccessibilityEventCompat;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewStub;
import android.widget.LinearLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.view.BannerView;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class q extends LinearLayout {
    private ViewEventCenter aMG;
    private View aOk;
    private BannerView aOl;

    public q(Context context) {
        this(context, null);
    }

    public q(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setEventCenter(ViewEventCenter viewEventCenter) {
        this.aMG = viewEventCenter;
    }

    public void init() {
        LayoutInflater.from(getContext()).inflate(i.g.enter_forum_header_view, this);
        setOrientation(1);
        setDescendantFocusability(AccessibilityEventCompat.TYPE_GESTURE_DETECTION_START);
        findViewById(i.f.search_root).setOnClickListener(new r(this));
    }

    public void b(TbPageContext<?> tbPageContext, com.baidu.tbadk.core.data.u uVar) {
        if (uVar != null) {
            if (this.aOl == null) {
                ((ViewStub) findViewById(i.f.viewstub_banner)).inflate();
                this.aOl = (BannerView) findViewById(i.f.home_like_banner_view);
            }
            this.aOl.reset();
            this.aOl.setBannerType("enterforum_banner");
            this.aOl.a(tbPageContext, uVar.sk(), uVar.getLink());
            String link = uVar.getLink();
            if (link != null && link.startsWith("game:detail:")) {
                TiebaStatic.eventStat(tbPageContext.getPageActivity(), "game_show", "show", 1, "ref_id", "4000401");
            }
        }
    }

    public void a(TbPageContext<?> tbPageContext, boolean z) {
        if (z) {
            if (this.aOk == null) {
                Jj();
            }
            com.baidu.tbadk.h.a.a(tbPageContext, this.aOk);
            this.aOk.setVisibility(0);
        } else if (this.aOk != null) {
            this.aOk.setVisibility(8);
        }
    }

    public void Jj() {
        this.aOk = ((ViewStub) findViewById(i.f.viewstub_guide)).inflate();
        View findViewById = this.aOk.findViewById(i.f.enterforum_guide_find_interest);
        findViewById.setOnClickListener(new s(this));
        if (!TbadkCoreApplication.m411getInst().appResponseToCmd(CmdConfigCustom.CMD_SQUARE_FORUM_SQUARE)) {
            findViewById.setVisibility(8);
        } else {
            findViewById.setVisibility(0);
        }
    }

    public void e(TbPageContext<?> tbPageContext) {
        com.baidu.tbadk.h.a.a(tbPageContext, this);
        if (this.aOl != null) {
            this.aOl.oN();
        }
    }
}
