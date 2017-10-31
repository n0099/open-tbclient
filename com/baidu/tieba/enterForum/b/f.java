package com.baidu.tieba.enterForum.b;

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
    private ViewEventCenter cjC;
    private TextView clO;
    private ImageView clP;
    private LinearLayout clY;

    public f(Context context) {
        this(context, null);
    }

    public f(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setEventCenter(ViewEventCenter viewEventCenter) {
        this.cjC = viewEventCenter;
    }

    public void init() {
        LayoutInflater.from(getContext()).inflate(d.h.layout_enterforum_search, this);
        setOrientation(1);
        setDescendantFocusability(AccessibilityEventCompat.TYPE_GESTURE_DETECTION_START);
        this.clY = (LinearLayout) findViewById(d.g.search_container);
        this.clY.setVisibility(0);
        this.clY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.b.f.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.cjC != null) {
                    TiebaStatic.log("c10362");
                    f.this.cjC.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(7, null, null, null));
                }
            }
        });
        this.clO = (TextView) findViewById(d.g.search_text);
        this.clP = (ImageView) findViewById(d.g.search_icon);
    }

    public void k(TbPageContext<?> tbPageContext) {
        com.baidu.tbadk.o.a.a(tbPageContext, this);
        aj.c(this.clP, d.f.icon_search);
        aj.i(this.clO, d.C0080d.enter_forum_search_text_color);
        aj.j(this.clY, d.f.enter_forum_search_frame);
    }

    public void setSearchHint(String str) {
        this.clO.setText(UtilHelper.getFixedText(str, 20));
    }
}
