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
    private ViewEventCenter aUs;
    private View aWF;
    private BannerView aWG;
    private TextView aWH;
    private View aWI;

    public r(Context context) {
        this(context, null);
    }

    public r(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setEventCenter(ViewEventCenter viewEventCenter) {
        this.aUs = viewEventCenter;
    }

    public void init() {
        LayoutInflater.from(getContext()).inflate(n.h.enter_forum_header_view, this);
        setOrientation(1);
        setDescendantFocusability(AccessibilityEventCompat.TYPE_GESTURE_DETECTION_START);
        this.aWH = (TextView) findViewById(n.g.search_root);
        this.aWH.setOnClickListener(new s(this));
    }

    public void a(TbPageContext<?> tbPageContext, boolean z) {
        if (z) {
            if (this.aWF == null) {
                Ld();
            }
            com.baidu.tbadk.i.a.a(tbPageContext, this.aWF);
            this.aWF.setVisibility(0);
        } else if (this.aWF != null) {
            this.aWF.setVisibility(8);
        }
    }

    public void Ld() {
        this.aWF = ((ViewStub) findViewById(n.g.viewstub_guide)).inflate();
        View findViewById = this.aWF.findViewById(n.g.enterforum_guide_find_interest);
        findViewById.setOnClickListener(new t(this));
        if (!TbadkCoreApplication.m411getInst().appResponseToCmd(CmdConfigCustom.CMD_SQUARE_FORUM_SQUARE)) {
            findViewById.setVisibility(8);
        } else {
            findViewById.setVisibility(0);
        }
    }

    public void f(TbPageContext<?> tbPageContext) {
        com.baidu.tbadk.i.a.a(tbPageContext, this);
        if (this.aWG != null) {
            this.aWG.ot();
        }
        if (this.aWI != null) {
            com.baidu.tbadk.i.a.a(tbPageContext, this.aWI);
        }
    }

    public void setSearchHint(String str) {
        this.aWH.setText(UtilHelper.getFixedText(str, 20));
    }

    public View getBannerView() {
        return this.aWI;
    }

    public void E(View view) {
        if (view != null) {
            if (this.aWI != null) {
                removeView(this.aWI);
            }
            this.aWI = view;
            addView(view, 0);
        }
    }
}
