package com.baidu.tieba.enterForum.c;

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
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class d extends LinearLayout {
    private ViewEventCenter bYx;
    private int caU;
    private TextView caV;
    private LinearLayout caW;
    private TextView caX;
    private ImageView caY;
    private a caZ;

    public d(Context context) {
        this(context, null);
    }

    public d(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void acE() {
        if (this.caZ == null) {
            acF();
        }
        if (this.caZ.getParent() == null) {
            addView(this.caZ);
        }
    }

    private void acF() {
        this.caZ = new a(getContext());
        this.caZ.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        this.caZ.setNumColumns(2);
        this.caZ.setPadding(this.caU, 0, this.caU, 0);
        this.caZ.setSelector(new ColorDrawable(0));
        this.caZ.setCacheColorHint(0);
        this.caZ.setFadingEdgeLength(0);
        this.caZ.setFocusable(false);
        this.caZ.setFocusableInTouchMode(false);
        this.caZ.setVerticalScrollBarEnabled(false);
    }

    public void setSelection(int i) {
        if (this.caZ != null) {
            this.caZ.setSelection(i);
        }
    }

    public void setSelectionFromTop(int i, int i2) {
        if (this.caZ != null) {
            this.caZ.setSelection(i);
            this.caZ.setPadding(this.caU, 0, this.caU, 0);
        }
    }

    public void setGridAdapterIfNeeded(BaseAdapter baseAdapter) {
        if (this.caZ != null && this.caZ.getAdapter() != baseAdapter) {
            this.caZ.setAdapter((ListAdapter) baseAdapter);
        }
    }

    public void setEventCenter(ViewEventCenter viewEventCenter) {
        this.bYx = viewEventCenter;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        getParent().requestDisallowInterceptTouchEvent(true);
        return super.dispatchTouchEvent(motionEvent);
    }

    private void init() {
        this.caU = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds40);
        LayoutInflater.from(getContext()).inflate(d.j.enter_forum_edit_view, this);
        setOrientation(1);
        this.caW = (LinearLayout) findViewById(d.h.search_container);
        this.caW.setVisibility(0);
        this.caV = (TextView) findViewById(d.h.view_edit_forum_ok);
        this.caV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.c.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.bYx != null) {
                    d.this.bYx.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(3, null, null, null));
                }
            }
        });
        this.caX = (TextView) findViewById(d.h.search_text);
        this.caY = (ImageView) findViewById(d.h.search_icon);
    }

    public void n(TbPageContext<?> tbPageContext) {
        com.baidu.tbadk.o.a.a(tbPageContext, this);
        setBackgroundColor(ai.getColor(d.e.cp_bg_line_d));
        ai.c(this.caY, d.g.icon_search);
        ai.i(this.caX, d.e.enter_forum_search_text_color);
        ai.j(this.caW, d.g.enter_forum_search_frame);
    }
}
