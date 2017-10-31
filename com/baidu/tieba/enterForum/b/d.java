package com.baidu.tieba.enterForum.b;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class d extends LinearLayout {
    private ViewEventCenter cjC;
    private int clL;
    private TextView clM;
    private LinearLayout clN;
    private TextView clO;
    private ImageView clP;
    private a clQ;

    public d(Context context) {
        this(context, null);
    }

    public d(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void afD() {
        if (this.clQ == null) {
            afE();
        }
        if (this.clQ.getParent() == null) {
            addView(this.clQ);
        }
    }

    private void afE() {
        this.clQ = new a(getContext());
        this.clQ.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        this.clQ.setNumColumns(2);
        this.clQ.setPadding(this.clL, 0, this.clL, 0);
        this.clQ.setSelector(new ColorDrawable(0));
        this.clQ.setCacheColorHint(0);
        this.clQ.setFadingEdgeLength(0);
        this.clQ.setFocusable(false);
        this.clQ.setFocusableInTouchMode(false);
        this.clQ.setVerticalScrollBarEnabled(false);
    }

    public void setSelectionFromTop(int i, int i2) {
        if (this.clQ != null) {
            this.clQ.setSelection(i);
            this.clQ.setPadding(this.clL, 0, this.clL, 0);
        }
    }

    public void setGridAdapterIfNeeded(BaseAdapter baseAdapter) {
        if (this.clQ != null && this.clQ.getAdapter() != baseAdapter) {
            this.clQ.setAdapter((ListAdapter) baseAdapter);
        }
    }

    public void setEventCenter(ViewEventCenter viewEventCenter) {
        this.cjC = viewEventCenter;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        getParent().requestDisallowInterceptTouchEvent(true);
        return super.dispatchTouchEvent(motionEvent);
    }

    private void init() {
        this.clL = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds40);
        LayoutInflater.from(getContext()).inflate(d.h.enter_forum_edit_view, this);
        setOrientation(1);
        this.clN = (LinearLayout) findViewById(d.g.search_container);
        this.clN.setVisibility(0);
        this.clM = (TextView) findViewById(d.g.view_edit_forum_ok);
        this.clM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.b.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.cjC != null) {
                    d.this.cjC.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(3, null, null, null));
                }
            }
        });
        this.clO = (TextView) findViewById(d.g.search_text);
        this.clP = (ImageView) findViewById(d.g.search_icon);
    }

    public void k(TbPageContext<?> tbPageContext) {
        com.baidu.tbadk.o.a.a(tbPageContext, this);
        setBackgroundColor(aj.getColor(d.C0080d.cp_bg_line_d));
        aj.c(this.clP, d.f.icon_search);
        aj.i(this.clO, d.C0080d.enter_forum_search_text_color);
        aj.j(this.clN, d.f.enter_forum_search_frame);
    }
}
