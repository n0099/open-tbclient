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
    private ViewEventCenter csF;
    private TextView cuW;
    private ImageView cuX;
    private LinearLayout cvg;

    public f(Context context) {
        this(context, null);
    }

    public f(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setEventCenter(ViewEventCenter viewEventCenter) {
        this.csF = viewEventCenter;
    }

    public void init() {
        LayoutInflater.from(getContext()).inflate(d.h.layout_enterforum_search, this);
        setOrientation(1);
        setDescendantFocusability(AccessibilityEventCompat.TYPE_GESTURE_DETECTION_START);
        this.cvg = (LinearLayout) findViewById(d.g.search_container);
        this.cvg.setVisibility(0);
        this.cvg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.b.f.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.csF != null) {
                    TiebaStatic.log("c10362");
                    f.this.csF.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(7, null, null, null));
                }
            }
        });
        this.cuW = (TextView) findViewById(d.g.search_text);
        this.cuX = (ImageView) findViewById(d.g.search_icon);
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext) {
        com.baidu.tbadk.n.a.a(tbPageContext, this);
        aj.c(this.cuX, d.f.icon_input_seach);
        aj.i(this.cuW, d.C0096d.enter_forum_search_text_color);
        aj.j(this.cvg, d.f.enter_forum_search_frame);
    }

    public void jr(int i) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cvg.getLayoutParams();
        layoutParams.topMargin = i;
        this.cvg.setLayoutParams(layoutParams);
    }

    public void setSearchHint(String str) {
        this.cuW.setText(UtilHelper.getFixedText(str, 20));
    }
}
