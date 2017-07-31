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
    private ViewEventCenter bXK;
    private int cah;
    private TextView cai;
    private LinearLayout caj;
    private TextView cak;
    private ImageView cal;
    private a cam;

    public d(Context context) {
        this(context, null);
    }

    public d(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void acn() {
        if (this.cam == null) {
            aco();
        }
        if (this.cam.getParent() == null) {
            addView(this.cam);
        }
    }

    private void aco() {
        this.cam = new a(getContext());
        this.cam.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        this.cam.setNumColumns(2);
        this.cam.setPadding(this.cah, 0, this.cah, 0);
        this.cam.setSelector(new ColorDrawable(0));
        this.cam.setCacheColorHint(0);
        this.cam.setFadingEdgeLength(0);
        this.cam.setFocusable(false);
        this.cam.setFocusableInTouchMode(false);
        this.cam.setVerticalScrollBarEnabled(false);
    }

    public void setSelection(int i) {
        if (this.cam != null) {
            this.cam.setSelection(i);
        }
    }

    public void setSelectionFromTop(int i, int i2) {
        if (this.cam != null) {
            this.cam.setSelection(i);
            this.cam.setPadding(this.cah, 0, this.cah, 0);
        }
    }

    public void setGridAdapterIfNeeded(BaseAdapter baseAdapter) {
        if (this.cam != null && this.cam.getAdapter() != baseAdapter) {
            this.cam.setAdapter((ListAdapter) baseAdapter);
        }
    }

    public void setEventCenter(ViewEventCenter viewEventCenter) {
        this.bXK = viewEventCenter;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        getParent().requestDisallowInterceptTouchEvent(true);
        return super.dispatchTouchEvent(motionEvent);
    }

    private void init() {
        this.cah = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds40);
        LayoutInflater.from(getContext()).inflate(d.j.enter_forum_edit_view, this);
        setOrientation(1);
        this.caj = (LinearLayout) findViewById(d.h.search_container);
        this.caj.setVisibility(0);
        this.cai = (TextView) findViewById(d.h.view_edit_forum_ok);
        this.cai.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.c.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.bXK != null) {
                    d.this.bXK.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(3, null, null, null));
                }
            }
        });
        this.cak = (TextView) findViewById(d.h.search_text);
        this.cal = (ImageView) findViewById(d.h.search_icon);
    }

    public void n(TbPageContext<?> tbPageContext) {
        com.baidu.tbadk.o.a.a(tbPageContext, this);
        setBackgroundColor(ai.getColor(d.e.cp_bg_line_d));
        ai.c(this.cal, d.g.icon_search);
        ai.i(this.cak, d.e.enter_forum_search_text_color);
        ai.j(this.caj, d.g.enter_forum_search_frame);
    }
}
