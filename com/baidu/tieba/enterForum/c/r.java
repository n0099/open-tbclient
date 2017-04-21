package com.baidu.tieba.enterForum.c;

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
import com.baidu.tieba.w;
import java.util.List;
/* loaded from: classes.dex */
public class r extends LinearLayout {
    private ViewEventCenter bHa;
    private View bIF;
    private ah bIG;
    private TextView bIH;
    private TextView bII;
    private BannerView bIJ;
    private TextView bIK;
    private TextView bIL;
    private View bIM;

    public r(Context context) {
        this(context, null);
    }

    public r(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setEventCenter(ViewEventCenter viewEventCenter) {
        this.bHa = viewEventCenter;
    }

    public void init() {
        LayoutInflater.from(getContext()).inflate(w.j.enter_forum_header_view, this);
        setOrientation(1);
        setDescendantFocusability(AccessibilityEventCompat.TYPE_GESTURE_DETECTION_START);
        this.bIK = (TextView) findViewById(w.h.search_root);
        this.bIK.setOnClickListener(new s(this));
        this.bIL = (TextView) findViewById(w.h.attention_forum_title);
        this.bIH = (TextView) findViewById(w.h.space_line);
        this.bII = (TextView) findViewById(w.h.space_line_bottom);
    }

    public void a(TbPageContext<?> tbPageContext, boolean z) {
        if (z) {
            if (this.bIF == null) {
                XS();
            }
            com.baidu.tbadk.m.a.a(tbPageContext, this.bIF);
            this.bIF.setVisibility(0);
        } else if (this.bIF != null) {
            this.bIF.setVisibility(8);
        }
    }

    public void XR() {
        ((ViewStub) findViewById(w.h.viewstub_frequently_foruminfo_view)).inflate();
        this.bIG = new ah(getContext(), (LinearLayout) findViewById(w.h.frequently_forum_info_layout));
    }

    public void a(TbPageContext<?> tbPageContext, com.baidu.tieba.enterForum.b.b bVar) {
        if (bVar != null && bVar.Wz() != null) {
            if (this.bIG == null) {
                XR();
            }
            this.bIG.onChangeSkinType();
            if (bVar.Wz() != null && bVar.Wz().WE() != null && bVar.Wz().WE().size() > 0) {
                this.bIG.setVisibility(0);
                this.bIH.setVisibility(0);
                this.bIG.d(bVar.Wz().WE(), tbPageContext);
                return;
            }
            this.bIH.setVisibility(8);
            this.bIG.setVisibility(8);
        }
    }

    public void b(List<com.baidu.tbadk.data.e> list, TbPageContext<?> tbPageContext) {
        if (list == null || list.size() <= 0) {
            this.bIH.setVisibility(8);
            this.bIG.setVisibility(8);
            return;
        }
        this.bIG.setVisibility(0);
        this.bIH.setVisibility(0);
        this.bIG.d(list, tbPageContext);
    }

    public void XS() {
        this.bIF = ((ViewStub) findViewById(w.h.viewstub_guide)).inflate();
        View findViewById = this.bIF.findViewById(w.h.enterforum_guide_find_interest);
        findViewById.setOnClickListener(new t(this));
        if (!TbadkCoreApplication.m9getInst().appResponseToCmd(CmdConfigCustom.CMD_SQUARE_FORUM_SQUARE)) {
            findViewById.setVisibility(8);
        } else {
            findViewById.setVisibility(0);
        }
    }

    public void n(TbPageContext<?> tbPageContext) {
        com.baidu.tbadk.m.a.a(tbPageContext, this);
        if (this.bIJ != null) {
            this.bIJ.Bn();
        }
        if (this.bIM != null) {
            com.baidu.tbadk.m.a.a(tbPageContext, this.bIM);
        }
        if (this.bIG != null) {
            this.bIG.onChangeSkinType();
        }
    }

    public void setSearchHint(String str) {
        this.bIK.setText(UtilHelper.getFixedText(str, 20));
    }

    public View getBannerView() {
        return this.bIM;
    }

    public void ae(View view) {
        if (view != null) {
            if (this.bIM != null) {
                removeView(this.bIM);
            }
            this.bIM = view;
            addView(view, 0);
        }
    }

    public void setAttentionTitleVisibililty(boolean z) {
        if (z) {
            this.bIL.setVisibility(0);
            this.bII.setVisibility(0);
            return;
        }
        this.bIL.setVisibility(8);
        this.bII.setVisibility(8);
    }
}
