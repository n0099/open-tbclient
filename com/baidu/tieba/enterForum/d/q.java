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
    private ViewEventCenter aMt;
    private View aNX;
    private BannerView aNY;

    public q(Context context) {
        this(context, null);
    }

    public q(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setEventCenter(ViewEventCenter viewEventCenter) {
        this.aMt = viewEventCenter;
    }

    public void init() {
        LayoutInflater.from(getContext()).inflate(i.g.enter_forum_header_view, this);
        setOrientation(1);
        setDescendantFocusability(AccessibilityEventCompat.TYPE_GESTURE_DETECTION_START);
        findViewById(i.f.search_root).setOnClickListener(new r(this));
    }

    public void b(TbPageContext<?> tbPageContext, com.baidu.tbadk.core.data.s sVar) {
        if (sVar != null) {
            if (this.aNY == null) {
                ((ViewStub) findViewById(i.f.viewstub_banner)).inflate();
                this.aNY = (BannerView) findViewById(i.f.home_like_banner_view);
            }
            this.aNY.reset();
            this.aNY.setBannerType("enterforum_banner");
            this.aNY.a(tbPageContext, sVar.sj(), sVar.getLink());
            String link = sVar.getLink();
            if (link != null && link.startsWith("game:detail:")) {
                TiebaStatic.eventStat(tbPageContext.getPageActivity(), "game_show", "show", 1, "ref_id", "4000401");
            }
        }
    }

    public void a(TbPageContext<?> tbPageContext, boolean z) {
        if (z) {
            if (this.aNX == null) {
                Jv();
            }
            com.baidu.tbadk.f.a.a(tbPageContext, this.aNX);
            this.aNX.setVisibility(0);
        } else if (this.aNX != null) {
            this.aNX.setVisibility(8);
        }
    }

    public void Jv() {
        this.aNX = ((ViewStub) findViewById(i.f.viewstub_guide)).inflate();
        View findViewById = this.aNX.findViewById(i.f.enterforum_guide_find_interest);
        findViewById.setOnClickListener(new s(this));
        if (!TbadkCoreApplication.m411getInst().appResponseToCmd(CmdConfigCustom.CMD_SQUARE_FORUM_SQUARE)) {
            findViewById.setVisibility(8);
        } else {
            findViewById.setVisibility(0);
        }
    }

    public void e(TbPageContext<?> tbPageContext) {
        com.baidu.tbadk.f.a.a(tbPageContext, this);
        if (this.aNY != null) {
            this.aNY.oQ();
        }
    }
}
