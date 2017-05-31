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
    private ViewEventCenter bLQ;
    private TextView bNV;
    private ImageView bNW;
    private LinearLayout bOf;

    public q(Context context) {
        this(context, null);
    }

    public q(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setEventCenter(ViewEventCenter viewEventCenter) {
        this.bLQ = viewEventCenter;
    }

    public void init() {
        LayoutInflater.from(getContext()).inflate(w.j.layout_enterforum_search, this);
        setOrientation(1);
        setDescendantFocusability(AccessibilityEventCompat.TYPE_GESTURE_DETECTION_START);
        this.bOf = (LinearLayout) findViewById(w.h.search_container);
        this.bOf.setVisibility(0);
        this.bOf.setOnClickListener(new r(this));
        this.bNV = (TextView) findViewById(w.h.search_text);
        this.bNW = (ImageView) findViewById(w.h.search_icon);
    }

    public void n(TbPageContext<?> tbPageContext) {
        com.baidu.tbadk.m.a.a(tbPageContext, this);
        aq.c(this.bNW, w.g.icon_enterforum_search);
        aq.i(this.bNV, w.e.enter_forum_search_text_color);
        aq.j(this.bOf, w.g.enter_forum_search_frame);
    }

    public void setSearchHint(String str) {
        this.bNV.setText(UtilHelper.getFixedText(str, 20));
    }
}
