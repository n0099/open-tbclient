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
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class p extends LinearLayout {
    private ViewEventCenter bSq;
    private TextView bUQ;
    private ImageView bUR;
    private LinearLayout bVa;

    public p(Context context) {
        this(context, null);
    }

    public p(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setEventCenter(ViewEventCenter viewEventCenter) {
        this.bSq = viewEventCenter;
    }

    public void init() {
        LayoutInflater.from(getContext()).inflate(w.j.layout_enterforum_search, this);
        setOrientation(1);
        setDescendantFocusability(AccessibilityEventCompat.TYPE_GESTURE_DETECTION_START);
        this.bVa = (LinearLayout) findViewById(w.h.search_container);
        this.bVa.setVisibility(0);
        this.bVa.setOnClickListener(new q(this));
        this.bUQ = (TextView) findViewById(w.h.search_text);
        this.bUR = (ImageView) findViewById(w.h.search_icon);
    }

    public void n(TbPageContext<?> tbPageContext) {
        com.baidu.tbadk.m.a.a(tbPageContext, this);
        as.c(this.bUR, w.g.icon_search);
        as.i(this.bUQ, w.e.enter_forum_search_text_color);
        as.j(this.bVa, w.g.enter_forum_search_frame);
    }

    public void setSearchHint(String str) {
        this.bUQ.setText(UtilHelper.getFixedText(str, 20));
    }
}
