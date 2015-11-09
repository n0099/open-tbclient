package com.baidu.tieba.enterForum.d;

import android.content.Context;
import android.support.v4.view.accessibility.AccessibilityEventCompat;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewStub;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.coreExtra.view.BannerView;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class r extends LinearLayout {
    private ViewEventCenter aLU;
    private TextView aNA;
    private View aNy;
    private BannerView aNz;

    public r(Context context) {
        this(context, null);
    }

    public r(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setEventCenter(ViewEventCenter viewEventCenter) {
        this.aLU = viewEventCenter;
    }

    public void init() {
        LayoutInflater.from(getContext()).inflate(i.g.enter_forum_header_view, this);
        setOrientation(1);
        setDescendantFocusability(AccessibilityEventCompat.TYPE_GESTURE_DETECTION_START);
        this.aNA = (TextView) findViewById(i.f.search_root);
        this.aNA.setOnClickListener(new s(this));
    }

    public void b(TbPageContext<?> tbPageContext, com.baidu.tbadk.core.data.u uVar) {
        if (uVar != null) {
            if (this.aNz == null) {
                ((ViewStub) findViewById(i.f.viewstub_banner)).inflate();
                this.aNz = (BannerView) findViewById(i.f.home_like_banner_view);
            }
            this.aNz.reset();
            this.aNz.setBannerType("enterforum_banner");
            this.aNz.a(tbPageContext, uVar.se(), uVar.getLink());
            String link = uVar.getLink();
            if (link != null && link.startsWith("game:detail:")) {
                TiebaStatic.eventStat(tbPageContext.getPageActivity(), "game_show", "show", 1, "ref_id", "4000401");
            }
        }
    }

    public void a(TbPageContext<?> tbPageContext, boolean z) {
        if (z) {
            if (this.aNy == null) {
                Jq();
            }
            com.baidu.tbadk.h.a.a(tbPageContext, this.aNy);
            this.aNy.setVisibility(0);
        } else if (this.aNy != null) {
            this.aNy.setVisibility(8);
        }
    }

    public void Jq() {
        this.aNy = ((ViewStub) findViewById(i.f.viewstub_guide)).inflate();
        View findViewById = this.aNy.findViewById(i.f.enterforum_guide_find_interest);
        findViewById.setOnClickListener(new t(this));
        if (!TbadkCoreApplication.m411getInst().appResponseToCmd(CmdConfigCustom.CMD_SQUARE_FORUM_SQUARE)) {
            findViewById.setVisibility(8);
        } else {
            findViewById.setVisibility(0);
        }
    }

    public void e(TbPageContext<?> tbPageContext) {
        com.baidu.tbadk.h.a.a(tbPageContext, this);
        if (this.aNz != null) {
            this.aNz.oP();
        }
    }

    public void setSearchHint(String str) {
        this.aNA.setText(UtilHelper.getFixedText(str, 20));
    }
}
