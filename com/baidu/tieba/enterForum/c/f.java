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
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class f extends LinearLayout {
    private ViewEventCenter bYx;
    private TextView caX;
    private ImageView caY;
    private LinearLayout cbh;

    public f(Context context) {
        this(context, null);
    }

    public f(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setEventCenter(ViewEventCenter viewEventCenter) {
        this.bYx = viewEventCenter;
    }

    public void init() {
        LayoutInflater.from(getContext()).inflate(d.j.layout_enterforum_search, this);
        setOrientation(1);
        setDescendantFocusability(AccessibilityEventCompat.TYPE_GESTURE_DETECTION_START);
        this.cbh = (LinearLayout) findViewById(d.h.search_container);
        this.cbh.setVisibility(0);
        this.cbh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.c.f.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.bYx != null) {
                    TiebaStatic.log("c10362");
                    f.this.bYx.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(7, null, null, null));
                }
            }
        });
        this.caX = (TextView) findViewById(d.h.search_text);
        this.caY = (ImageView) findViewById(d.h.search_icon);
    }

    public void n(TbPageContext<?> tbPageContext) {
        com.baidu.tbadk.o.a.a(tbPageContext, this);
        ai.c(this.caY, d.g.icon_search);
        ai.i(this.caX, d.e.enter_forum_search_text_color);
        ai.j(this.cbh, d.g.enter_forum_search_frame);
    }

    public void setSearchHint(String str) {
        this.caX.setText(UtilHelper.getFixedText(str, 20));
    }
}
