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
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class r extends LinearLayout {
    private ViewEventCenter aQB;
    private View aSD;
    private BannerView aSE;
    private TextView aSF;
    private View aSG;

    public r(Context context) {
        this(context, null);
    }

    public r(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setEventCenter(ViewEventCenter viewEventCenter) {
        this.aQB = viewEventCenter;
    }

    public void init() {
        LayoutInflater.from(getContext()).inflate(n.g.enter_forum_header_view, this);
        setOrientation(1);
        setDescendantFocusability(AccessibilityEventCompat.TYPE_GESTURE_DETECTION_START);
        this.aSF = (TextView) findViewById(n.f.search_root);
        this.aSF.setOnClickListener(new s(this));
    }

    public void a(TbPageContext<?> tbPageContext, boolean z) {
        if (z) {
            if (this.aSD == null) {
                KK();
            }
            com.baidu.tbadk.i.a.a(tbPageContext, this.aSD);
            this.aSD.setVisibility(0);
        } else if (this.aSD != null) {
            this.aSD.setVisibility(8);
        }
    }

    public void KK() {
        this.aSD = ((ViewStub) findViewById(n.f.viewstub_guide)).inflate();
        View findViewById = this.aSD.findViewById(n.f.enterforum_guide_find_interest);
        findViewById.setOnClickListener(new t(this));
        if (!TbadkCoreApplication.m411getInst().appResponseToCmd(CmdConfigCustom.CMD_SQUARE_FORUM_SQUARE)) {
            findViewById.setVisibility(8);
        } else {
            findViewById.setVisibility(0);
        }
    }

    public void f(TbPageContext<?> tbPageContext) {
        com.baidu.tbadk.i.a.a(tbPageContext, this);
        if (this.aSE != null) {
            this.aSE.oV();
        }
        if (this.aSG != null) {
            com.baidu.tbadk.i.a.a(tbPageContext, this.aSG);
        }
    }

    public void setSearchHint(String str) {
        this.aSF.setText(UtilHelper.getFixedText(str, 20));
    }

    public View getBannerView() {
        return this.aSG;
    }

    public void D(View view) {
        if (view != null) {
            if (this.aSG != null) {
                removeView(this.aSG);
            }
            this.aSG = view;
            addView(view, 0);
        }
    }
}
