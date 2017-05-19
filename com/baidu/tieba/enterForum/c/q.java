package com.baidu.tieba.enterForum.c;

import android.content.Context;
import android.support.v4.view.accessibility.AccessibilityEventCompat;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class q extends LinearLayout {
    private ViewEventCenter bGb;
    private TextView bIh;
    private ImageView bIi;
    private LinearLayout bIr;

    public q(Context context) {
        this(context, null);
    }

    public q(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setEventCenter(ViewEventCenter viewEventCenter) {
        this.bGb = viewEventCenter;
    }

    public void init() {
        LayoutInflater.from(getContext()).inflate(w.j.layout_enterforum_search, this);
        setOrientation(1);
        setDescendantFocusability(AccessibilityEventCompat.TYPE_GESTURE_DETECTION_START);
        this.bIr = (LinearLayout) findViewById(w.h.search_container);
        this.bIr.setVisibility(0);
        this.bIr.setOnClickListener(new r(this));
        this.bIh = (TextView) findViewById(w.h.search_text);
        this.bIi = (ImageView) findViewById(w.h.search_icon);
    }

    public void o(TbPageContext<?> tbPageContext) {
        com.baidu.tbadk.m.a.a(tbPageContext, this);
        aq.c(this.bIi, w.g.icon_enterforum_search);
        aq.i(this.bIh, w.e.enter_forum_search_text_color);
        aq.j(this.bIr, w.g.enter_forum_search_frame);
    }

    public void setSearchHint(String str) {
        this.bIh.setText(UtilHelper.getFixedText(str, 20));
    }
}
