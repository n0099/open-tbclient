package com.baidu.tieba.enterForum.c;

import android.content.Context;
import android.support.v4.view.accessibility.AccessibilityEventCompat;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class f extends LinearLayout {
    private ViewEventCenter ccl;
    private TextView ceG;
    private ImageView ceH;
    private LinearLayout ceQ;

    public f(Context context) {
        this(context, null);
    }

    public f(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setEventCenter(ViewEventCenter viewEventCenter) {
        this.ccl = viewEventCenter;
    }

    public void init() {
        LayoutInflater.from(getContext()).inflate(d.j.layout_enterforum_search, this);
        setOrientation(1);
        setDescendantFocusability(AccessibilityEventCompat.TYPE_GESTURE_DETECTION_START);
        this.ceQ = (LinearLayout) findViewById(d.h.search_container);
        this.ceQ.setVisibility(0);
        this.ceQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.c.f.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.ccl != null) {
                    TiebaStatic.log("c10362");
                    f.this.ccl.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(7, null, null, null));
                }
            }
        });
        this.ceG = (TextView) findViewById(d.h.search_text);
        this.ceH = (ImageView) findViewById(d.h.search_icon);
    }

    public void n(TbPageContext<?> tbPageContext) {
        com.baidu.tbadk.o.a.a(tbPageContext, this);
        aj.c(this.ceH, d.g.icon_search);
        aj.i(this.ceG, d.e.enter_forum_search_text_color);
        aj.j(this.ceQ, d.g.enter_forum_search_frame);
    }

    public void setSearchHint(String str) {
        this.ceG.setText(UtilHelper.getFixedText(str, 20));
    }
}
