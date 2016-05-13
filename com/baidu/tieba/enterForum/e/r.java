package com.baidu.tieba.enterForum.e;

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
    private ViewEventCenter aXs;
    private View aZk;
    private BannerView aZl;
    private TextView aZm;
    private View aZn;
    private View aZo;

    public r(Context context) {
        this(context, null);
    }

    public r(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setEventCenter(ViewEventCenter viewEventCenter) {
        this.aXs = viewEventCenter;
    }

    public void init() {
        LayoutInflater.from(getContext()).inflate(t.h.enter_forum_header_view, this);
        setOrientation(1);
        setDescendantFocusability(AccessibilityEventCompat.TYPE_GESTURE_DETECTION_START);
        this.aZm = (TextView) findViewById(t.g.search_root);
        this.aZm.setOnClickListener(new s(this));
    }

    public void a(TbPageContext<?> tbPageContext, boolean z) {
        if (z) {
            if (this.aZk == null) {
                NA();
            }
            com.baidu.tbadk.i.a.a(tbPageContext, this.aZk);
            this.aZk.setVisibility(0);
        } else if (this.aZk != null) {
            this.aZk.setVisibility(8);
        }
    }

    public void NA() {
        this.aZk = ((ViewStub) findViewById(t.g.viewstub_guide)).inflate();
        View findViewById = this.aZk.findViewById(t.g.enterforum_guide_find_interest);
        findViewById.setOnClickListener(new t(this));
        if (!TbadkCoreApplication.m11getInst().appResponseToCmd(CmdConfigCustom.CMD_SQUARE_FORUM_SQUARE)) {
            findViewById.setVisibility(8);
        } else {
            findViewById.setVisibility(0);
        }
    }

    public void g(TbPageContext<?> tbPageContext) {
        com.baidu.tbadk.i.a.a(tbPageContext, this);
        if (this.aZl != null) {
            this.aZl.kU();
        }
        if (this.aZn != null) {
            com.baidu.tbadk.i.a.a(tbPageContext, this.aZn);
        }
    }

    public void setSearchHint(String str) {
        this.aZm.setText(UtilHelper.getFixedText(str, 20));
    }

    public View getBannerView() {
        return this.aZn;
    }

    public void Y(View view) {
        if (view != null) {
            if (this.aZn != null) {
                removeView(this.aZn);
            }
            this.aZn = view;
            addView(view, 0);
        }
    }

    public View getTogetherHiBannerView() {
        return this.aZo;
    }

    public void Z(View view) {
        if (view != null) {
            if (this.aZo != null) {
                removeView(this.aZo);
            }
            this.aZo = view;
            addView(view, 0);
        }
    }
}
