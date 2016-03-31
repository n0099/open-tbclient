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
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class r extends LinearLayout {
    private ViewEventCenter bbj;
    private View bdD;
    private BannerView bdE;
    private TextView bdF;
    private View bdG;

    public r(Context context) {
        this(context, null);
    }

    public r(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setEventCenter(ViewEventCenter viewEventCenter) {
        this.bbj = viewEventCenter;
    }

    public void init() {
        LayoutInflater.from(getContext()).inflate(t.h.enter_forum_header_view, this);
        setOrientation(1);
        setDescendantFocusability(AccessibilityEventCompat.TYPE_GESTURE_DETECTION_START);
        this.bdF = (TextView) findViewById(t.g.search_root);
        this.bdF.setOnClickListener(new s(this));
    }

    public void a(TbPageContext<?> tbPageContext, boolean z) {
        if (z) {
            if (this.bdD == null) {
                OJ();
            }
            com.baidu.tbadk.i.a.a(tbPageContext, this.bdD);
            this.bdD.setVisibility(0);
        } else if (this.bdD != null) {
            this.bdD.setVisibility(8);
        }
    }

    public void OJ() {
        this.bdD = ((ViewStub) findViewById(t.g.viewstub_guide)).inflate();
        View findViewById = this.bdD.findViewById(t.g.enterforum_guide_find_interest);
        findViewById.setOnClickListener(new t(this));
        if (!TbadkCoreApplication.m411getInst().appResponseToCmd(CmdConfigCustom.CMD_SQUARE_FORUM_SQUARE)) {
            findViewById.setVisibility(8);
        } else {
            findViewById.setVisibility(0);
        }
    }

    public void f(TbPageContext<?> tbPageContext) {
        com.baidu.tbadk.i.a.a(tbPageContext, this);
        if (this.bdE != null) {
            this.bdE.oH();
        }
        if (this.bdG != null) {
            com.baidu.tbadk.i.a.a(tbPageContext, this.bdG);
        }
    }

    public void setSearchHint(String str) {
        this.bdF.setText(UtilHelper.getFixedText(str, 20));
    }

    public View getBannerView() {
        return this.bdG;
    }

    public void W(View view) {
        if (view != null) {
            if (this.bdG != null) {
                removeView(this.bdG);
            }
            this.bdG = view;
            addView(view, 0);
        }
    }
}
