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
    private LinearLayout bub;
    private ViewEventCenter csF;
    private int cuU;
    private TextView cuV;
    private TextView cuW;
    private ImageView cuX;
    private a cuY;

    public d(Context context) {
        this(context, null);
    }

    public d(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void ahK() {
        if (this.cuY == null) {
            ahL();
        }
        if (this.cuY.getParent() == null) {
            addView(this.cuY);
        }
    }

    private void ahL() {
        this.cuY = new a(getContext());
        this.cuY.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        this.cuY.setNumColumns(2);
        this.cuY.setPadding(this.cuU, 0, this.cuU, 0);
        this.cuY.setSelector(new ColorDrawable(0));
        this.cuY.setCacheColorHint(0);
        this.cuY.setFadingEdgeLength(0);
        this.cuY.setFocusable(false);
        this.cuY.setFocusableInTouchMode(false);
        this.cuY.setVerticalScrollBarEnabled(false);
    }

    public void setSelectionFromTop(int i, int i2) {
        if (this.cuY != null) {
            this.cuY.setSelection(i);
            this.cuY.setPadding(this.cuU, 0, this.cuU, 0);
        }
    }

    public void setGridAdapterIfNeeded(BaseAdapter baseAdapter) {
        if (this.cuY != null && this.cuY.getAdapter() != baseAdapter) {
            this.cuY.setAdapter((ListAdapter) baseAdapter);
        }
    }

    public void setEventCenter(ViewEventCenter viewEventCenter) {
        this.csF = viewEventCenter;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        getParent().requestDisallowInterceptTouchEvent(true);
        return super.dispatchTouchEvent(motionEvent);
    }

    private void init() {
        this.cuU = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.tbds44);
        LayoutInflater.from(getContext()).inflate(d.h.enter_forum_edit_view, this);
        setOrientation(1);
        this.bub = (LinearLayout) findViewById(d.g.search_container);
        this.bub.setVisibility(0);
        this.cuV = (TextView) findViewById(d.g.view_edit_forum_ok);
        this.cuV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.b.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.csF != null) {
                    d.this.csF.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(3, null, null, null));
                }
            }
        });
        this.cuW = (TextView) findViewById(d.g.search_text);
        this.cuX = (ImageView) findViewById(d.g.search_icon);
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext) {
        com.baidu.tbadk.n.a.a(tbPageContext, this);
        setBackgroundColor(aj.getColor(d.C0096d.cp_bg_line_d));
        aj.c(this.cuX, d.f.icon_input_seach);
        aj.i(this.cuW, d.C0096d.enter_forum_search_text_color);
        aj.j(this.bub, d.f.enter_forum_search_frame);
    }
}
