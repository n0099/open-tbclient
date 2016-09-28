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
    private ViewEventCenter aPL;
    private View bIH;
    private ah bII;
    private TextView bIJ;
    private TextView bIK;
    private BannerView bIL;
    private TextView bIM;
    private TextView bIN;
    private View bIO;

    public r(Context context) {
        this(context, null);
    }

    public r(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setEventCenter(ViewEventCenter viewEventCenter) {
        this.aPL = viewEventCenter;
    }

    public void init() {
        LayoutInflater.from(getContext()).inflate(r.h.enter_forum_header_view, this);
        setOrientation(1);
        setDescendantFocusability(AccessibilityEventCompat.TYPE_GESTURE_DETECTION_START);
        this.bIM = (TextView) findViewById(r.g.search_root);
        this.bIM.setOnClickListener(new s(this));
        this.bIN = (TextView) findViewById(r.g.attention_forum_title);
        this.bIJ = (TextView) findViewById(r.g.space_line);
        this.bIK = (TextView) findViewById(r.g.space_line_bottom);
    }

    public void b(TbPageContext<?> tbPageContext, boolean z) {
        if (z) {
            if (this.bIH == null) {
                YL();
            }
            com.baidu.tbadk.i.a.a(tbPageContext, this.bIH);
            this.bIH.setVisibility(0);
        } else if (this.bIH != null) {
            this.bIH.setVisibility(8);
        }
    }

    public void YK() {
        ((ViewStub) findViewById(r.g.viewstub_frequently_foruminfo_view)).inflate();
        this.bII = new ah(getContext(), (LinearLayout) findViewById(r.g.frequently_forum_info_layout));
    }

    public void a(TbPageContext<?> tbPageContext, com.baidu.tieba.enterForum.b.b bVar) {
        if (bVar != null && bVar.Xu() != null) {
            if (this.bII == null) {
                YK();
            }
            this.bII.tx();
            if (bVar.Xu() != null && bVar.Xu().Xz() != null && bVar.Xu().Xz().size() > 0) {
                this.bII.setVisibility(0);
                this.bIJ.setVisibility(0);
                this.bII.d(bVar.Xu().Xz(), tbPageContext);
                return;
            }
            this.bIJ.setVisibility(8);
            this.bII.setVisibility(8);
        }
    }

    public void b(List<com.baidu.tbadk.data.e> list, TbPageContext<?> tbPageContext) {
        if (list == null || list.size() <= 0) {
            this.bIJ.setVisibility(8);
            this.bII.setVisibility(8);
            return;
        }
        this.bII.setVisibility(0);
        this.bIJ.setVisibility(0);
        this.bII.d(list, tbPageContext);
    }

    public void YL() {
        this.bIH = ((ViewStub) findViewById(r.g.viewstub_guide)).inflate();
        View findViewById = this.bIH.findViewById(r.g.enterforum_guide_find_interest);
        findViewById.setOnClickListener(new t(this));
        if (!TbadkCoreApplication.m9getInst().appResponseToCmd(CmdConfigCustom.CMD_SQUARE_FORUM_SQUARE)) {
            findViewById.setVisibility(8);
        } else {
            findViewById.setVisibility(0);
        }
    }

    public void q(TbPageContext<?> tbPageContext) {
        com.baidu.tbadk.i.a.a(tbPageContext, this);
        if (this.bIL != null) {
            this.bIL.lO();
        }
        if (this.bIO != null) {
            com.baidu.tbadk.i.a.a(tbPageContext, this.bIO);
        }
        if (this.bII != null) {
            this.bII.tx();
        }
    }

    public void setSearchHint(String str) {
        this.bIM.setText(UtilHelper.getFixedText(str, 20));
    }

    public View getBannerView() {
        return this.bIO;
    }

    public void aa(View view) {
        if (view != null) {
            if (this.bIO != null) {
                removeView(this.bIO);
            }
            this.bIO = view;
            addView(view, 0);
        }
    }

    public void setAttentionTitleVisibililty(boolean z) {
        if (z) {
            this.bIN.setVisibility(0);
            this.bIK.setVisibility(0);
            return;
        }
        this.bIN.setVisibility(8);
        this.bIK.setVisibility(8);
    }
}
