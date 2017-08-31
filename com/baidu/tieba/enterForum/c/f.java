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
    private ViewEventCenter cbt;
    private TextView cdO;
    private ImageView cdP;
    private LinearLayout cdY;

    public f(Context context) {
        this(context, null);
    }

    public f(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setEventCenter(ViewEventCenter viewEventCenter) {
        this.cbt = viewEventCenter;
    }

    public void init() {
        LayoutInflater.from(getContext()).inflate(d.j.layout_enterforum_search, this);
        setOrientation(1);
        setDescendantFocusability(AccessibilityEventCompat.TYPE_GESTURE_DETECTION_START);
        this.cdY = (LinearLayout) findViewById(d.h.search_container);
        this.cdY.setVisibility(0);
        this.cdY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.c.f.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.cbt != null) {
                    TiebaStatic.log("c10362");
                    f.this.cbt.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(7, null, null, null));
                }
            }
        });
        this.cdO = (TextView) findViewById(d.h.search_text);
        this.cdP = (ImageView) findViewById(d.h.search_icon);
    }

    public void n(TbPageContext<?> tbPageContext) {
        com.baidu.tbadk.o.a.a(tbPageContext, this);
        aj.c(this.cdP, d.g.icon_search);
        aj.i(this.cdO, d.e.enter_forum_search_text_color);
        aj.j(this.cdY, d.g.enter_forum_search_frame);
    }

    public void setSearchHint(String str) {
        this.cdO.setText(UtilHelper.getFixedText(str, 20));
    }
}
