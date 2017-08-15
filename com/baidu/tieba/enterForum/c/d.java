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
    private ViewEventCenter bYw;
    private int caT;
    private TextView caU;
    private LinearLayout caV;
    private TextView caW;
    private ImageView caX;
    private a caY;

    public d(Context context) {
        this(context, null);
    }

    public d(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void acI() {
        if (this.caY == null) {
            acJ();
        }
        if (this.caY.getParent() == null) {
            addView(this.caY);
        }
    }

    private void acJ() {
        this.caY = new a(getContext());
        this.caY.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        this.caY.setNumColumns(2);
        this.caY.setPadding(this.caT, 0, this.caT, 0);
        this.caY.setSelector(new ColorDrawable(0));
        this.caY.setCacheColorHint(0);
        this.caY.setFadingEdgeLength(0);
        this.caY.setFocusable(false);
        this.caY.setFocusableInTouchMode(false);
        this.caY.setVerticalScrollBarEnabled(false);
    }

    public void setSelection(int i) {
        if (this.caY != null) {
            this.caY.setSelection(i);
        }
    }

    public void setSelectionFromTop(int i, int i2) {
        if (this.caY != null) {
            this.caY.setSelection(i);
            this.caY.setPadding(this.caT, 0, this.caT, 0);
        }
    }

    public void setGridAdapterIfNeeded(BaseAdapter baseAdapter) {
        if (this.caY != null && this.caY.getAdapter() != baseAdapter) {
            this.caY.setAdapter((ListAdapter) baseAdapter);
        }
    }

    public void setEventCenter(ViewEventCenter viewEventCenter) {
        this.bYw = viewEventCenter;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        getParent().requestDisallowInterceptTouchEvent(true);
        return super.dispatchTouchEvent(motionEvent);
    }

    private void init() {
        this.caT = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds40);
        LayoutInflater.from(getContext()).inflate(d.j.enter_forum_edit_view, this);
        setOrientation(1);
        this.caV = (LinearLayout) findViewById(d.h.search_container);
        this.caV.setVisibility(0);
        this.caU = (TextView) findViewById(d.h.view_edit_forum_ok);
        this.caU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.c.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.bYw != null) {
                    d.this.bYw.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(3, null, null, null));
                }
            }
        });
        this.caW = (TextView) findViewById(d.h.search_text);
        this.caX = (ImageView) findViewById(d.h.search_icon);
    }

    public void n(TbPageContext<?> tbPageContext) {
        com.baidu.tbadk.o.a.a(tbPageContext, this);
        setBackgroundColor(ai.getColor(d.e.cp_bg_line_d));
        ai.c(this.caX, d.g.icon_search);
        ai.i(this.caW, d.e.enter_forum_search_text_color);
        ai.j(this.caV, d.g.enter_forum_search_frame);
    }
}
