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
    private ViewEventCenter cbZ;
    private LinearLayout ceF;
    private TextView cev;
    private ImageView cew;

    public f(Context context) {
        this(context, null);
    }

    public f(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setEventCenter(ViewEventCenter viewEventCenter) {
        this.cbZ = viewEventCenter;
    }

    public void init() {
        LayoutInflater.from(getContext()).inflate(d.j.layout_enterforum_search, this);
        setOrientation(1);
        setDescendantFocusability(AccessibilityEventCompat.TYPE_GESTURE_DETECTION_START);
        this.ceF = (LinearLayout) findViewById(d.h.search_container);
        this.ceF.setVisibility(0);
        this.ceF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.c.f.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.cbZ != null) {
                    TiebaStatic.log("c10362");
                    f.this.cbZ.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(7, null, null, null));
                }
            }
        });
        this.cev = (TextView) findViewById(d.h.search_text);
        this.cew = (ImageView) findViewById(d.h.search_icon);
    }

    public void k(TbPageContext<?> tbPageContext) {
        com.baidu.tbadk.n.a.a(tbPageContext, this);
        aj.c(this.cew, d.g.icon_search);
        aj.i(this.cev, d.e.enter_forum_search_text_color);
        aj.j(this.ceF, d.g.enter_forum_search_frame);
    }

    public void setSearchHint(String str) {
        this.cev.setText(UtilHelper.getFixedText(str, 20));
    }
}
