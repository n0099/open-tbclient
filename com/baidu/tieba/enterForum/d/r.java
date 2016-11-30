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
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.coreExtra.view.BannerView;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.r;
import java.util.List;
/* loaded from: classes.dex */
public class r extends LinearLayout {
    private ViewEventCenter aRS;
    private View bLA;
    private ah bLB;
    private TextView bLC;
    private TextView bLD;
    private BannerView bLE;
    private TextView bLF;
    private TextView bLG;
    private View bLH;

    public r(Context context) {
        this(context, null);
    }

    public r(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setEventCenter(ViewEventCenter viewEventCenter) {
        this.aRS = viewEventCenter;
    }

    public void init() {
        LayoutInflater.from(getContext()).inflate(r.h.enter_forum_header_view, this);
        setOrientation(1);
        setDescendantFocusability(AccessibilityEventCompat.TYPE_GESTURE_DETECTION_START);
        this.bLF = (TextView) findViewById(r.g.search_root);
        this.bLF.setOnClickListener(new s(this));
        this.bLG = (TextView) findViewById(r.g.attention_forum_title);
        this.bLC = (TextView) findViewById(r.g.space_line);
        this.bLD = (TextView) findViewById(r.g.space_line_bottom);
    }

    public void a(TbPageContext<?> tbPageContext, boolean z) {
        if (z) {
            if (this.bLA == null) {
                ZN();
            }
            com.baidu.tbadk.i.a.a(tbPageContext, this.bLA);
            this.bLA.setVisibility(0);
        } else if (this.bLA != null) {
            this.bLA.setVisibility(8);
        }
    }

    public void ZM() {
        ((ViewStub) findViewById(r.g.viewstub_frequently_foruminfo_view)).inflate();
        this.bLB = new ah(getContext(), (LinearLayout) findViewById(r.g.frequently_forum_info_layout));
    }

    public void a(TbPageContext<?> tbPageContext, com.baidu.tieba.enterForum.b.b bVar) {
        if (bVar != null && bVar.Yw() != null) {
            if (this.bLB == null) {
                ZM();
            }
            this.bLB.tB();
            if (bVar.Yw() != null && bVar.Yw().YB() != null && bVar.Yw().YB().size() > 0) {
                this.bLB.setVisibility(0);
                this.bLC.setVisibility(0);
                this.bLB.d(bVar.Yw().YB(), tbPageContext);
                return;
            }
            this.bLC.setVisibility(8);
            this.bLB.setVisibility(8);
        }
    }

    public void b(List<com.baidu.tbadk.data.e> list, TbPageContext<?> tbPageContext) {
        if (list == null || list.size() <= 0) {
            this.bLC.setVisibility(8);
            this.bLB.setVisibility(8);
            return;
        }
        this.bLB.setVisibility(0);
        this.bLC.setVisibility(0);
        this.bLB.d(list, tbPageContext);
    }

    public void ZN() {
        this.bLA = ((ViewStub) findViewById(r.g.viewstub_guide)).inflate();
        View findViewById = this.bLA.findViewById(r.g.enterforum_guide_find_interest);
        findViewById.setOnClickListener(new t(this));
        if (!TbadkCoreApplication.m9getInst().appResponseToCmd(CmdConfigCustom.CMD_SQUARE_FORUM_SQUARE)) {
            findViewById.setVisibility(8);
        } else {
            findViewById.setVisibility(0);
        }
    }

    public void r(TbPageContext<?> tbPageContext) {
        com.baidu.tbadk.i.a.a(tbPageContext, this);
        if (this.bLE != null) {
            this.bLE.lR();
        }
        if (this.bLH != null) {
            com.baidu.tbadk.i.a.a(tbPageContext, this.bLH);
        }
        if (this.bLB != null) {
            this.bLB.tB();
        }
    }

    public void setSearchHint(String str) {
        this.bLF.setText(UtilHelper.getFixedText(str, 20));
    }

    public View getBannerView() {
        return this.bLH;
    }

    public void ab(View view) {
        if (view != null) {
            if (this.bLH != null) {
                removeView(this.bLH);
            }
            this.bLH = view;
            addView(view, 0);
        }
    }

    public void setAttentionTitleVisibililty(boolean z) {
        if (z) {
            this.bLG.setVisibility(0);
            this.bLD.setVisibility(0);
            return;
        }
        this.bLG.setVisibility(8);
        this.bLD.setVisibility(8);
    }
}
