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
    private ViewEventCenter aWA;
    private View aYT;
    private BannerView aYU;
    private TextView aYV;
    private View aYW;

    public r(Context context) {
        this(context, null);
    }

    public r(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setEventCenter(ViewEventCenter viewEventCenter) {
        this.aWA = viewEventCenter;
    }

    public void init() {
        LayoutInflater.from(getContext()).inflate(t.h.enter_forum_header_view, this);
        setOrientation(1);
        setDescendantFocusability(AccessibilityEventCompat.TYPE_GESTURE_DETECTION_START);
        this.aYV = (TextView) findViewById(t.g.search_root);
        this.aYV.setOnClickListener(new s(this));
    }

    public void a(TbPageContext<?> tbPageContext, boolean z) {
        if (z) {
            if (this.aYT == null) {
                MV();
            }
            com.baidu.tbadk.i.a.a(tbPageContext, this.aYT);
            this.aYT.setVisibility(0);
        } else if (this.aYT != null) {
            this.aYT.setVisibility(8);
        }
    }

    public void MV() {
        this.aYT = ((ViewStub) findViewById(t.g.viewstub_guide)).inflate();
        View findViewById = this.aYT.findViewById(t.g.enterforum_guide_find_interest);
        findViewById.setOnClickListener(new t(this));
        if (!TbadkCoreApplication.m411getInst().appResponseToCmd(CmdConfigCustom.CMD_SQUARE_FORUM_SQUARE)) {
            findViewById.setVisibility(8);
        } else {
            findViewById.setVisibility(0);
        }
    }

    public void f(TbPageContext<?> tbPageContext) {
        com.baidu.tbadk.i.a.a(tbPageContext, this);
        if (this.aYU != null) {
            this.aYU.oO();
        }
        if (this.aYW != null) {
            com.baidu.tbadk.i.a.a(tbPageContext, this.aYW);
        }
    }

    public void setSearchHint(String str) {
        this.aYV.setText(UtilHelper.getFixedText(str, 20));
    }

    public View getBannerView() {
        return this.aYW;
    }

    public void S(View view) {
        if (view != null) {
            if (this.aYW != null) {
                removeView(this.aYW);
            }
            this.aYW = view;
            addView(view, 0);
        }
    }
}
