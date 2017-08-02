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
    private ViewEventCenter bWE;
    private TextView bZe;
    private ImageView bZf;
    private LinearLayout bZo;

    public f(Context context) {
        this(context, null);
    }

    public f(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setEventCenter(ViewEventCenter viewEventCenter) {
        this.bWE = viewEventCenter;
    }

    public void init() {
        LayoutInflater.from(getContext()).inflate(d.j.layout_enterforum_search, this);
        setOrientation(1);
        setDescendantFocusability(AccessibilityEventCompat.TYPE_GESTURE_DETECTION_START);
        this.bZo = (LinearLayout) findViewById(d.h.search_container);
        this.bZo.setVisibility(0);
        this.bZo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.c.f.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.bWE != null) {
                    TiebaStatic.log("c10362");
                    f.this.bWE.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(7, null, null, null));
                }
            }
        });
        this.bZe = (TextView) findViewById(d.h.search_text);
        this.bZf = (ImageView) findViewById(d.h.search_icon);
    }

    public void n(TbPageContext<?> tbPageContext) {
        com.baidu.tbadk.o.a.a(tbPageContext, this);
        ai.c(this.bZf, d.g.icon_search);
        ai.i(this.bZe, d.e.enter_forum_search_text_color);
        ai.j(this.bZo, d.g.enter_forum_search_frame);
    }

    public void setSearchHint(String str) {
        this.bZe.setText(UtilHelper.getFixedText(str, 20));
    }
}
