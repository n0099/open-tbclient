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
    private ViewEventCenter csJ;
    private TextView cva;
    private ImageView cvb;
    private LinearLayout cvk;

    public f(Context context) {
        this(context, null);
    }

    public f(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setEventCenter(ViewEventCenter viewEventCenter) {
        this.csJ = viewEventCenter;
    }

    public void init() {
        LayoutInflater.from(getContext()).inflate(d.h.layout_enterforum_search, this);
        setOrientation(1);
        setDescendantFocusability(AccessibilityEventCompat.TYPE_GESTURE_DETECTION_START);
        this.cvk = (LinearLayout) findViewById(d.g.search_container);
        this.cvk.setVisibility(0);
        this.cvk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.b.f.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.csJ != null) {
                    TiebaStatic.log("c10362");
                    f.this.csJ.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(7, null, null, null));
                }
            }
        });
        this.cva = (TextView) findViewById(d.g.search_text);
        this.cvb = (ImageView) findViewById(d.g.search_icon);
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext) {
        com.baidu.tbadk.n.a.a(tbPageContext, this);
        aj.c(this.cvb, d.f.icon_input_seach);
        aj.i(this.cva, d.C0095d.enter_forum_search_text_color);
        aj.j(this.cvk, d.f.enter_forum_search_frame);
    }

    public void jr(int i) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cvk.getLayoutParams();
        layoutParams.topMargin = i;
        this.cvk.setLayoutParams(layoutParams);
    }

    public void setSearchHint(String str) {
        this.cva.setText(UtilHelper.getFixedText(str, 20));
    }
}
