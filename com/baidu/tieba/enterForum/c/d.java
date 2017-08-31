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
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class d extends LinearLayout {
    private ViewEventCenter cbt;
    private int cdL;
    private TextView cdM;
    private LinearLayout cdN;
    private TextView cdO;
    private ImageView cdP;
    private a cdQ;

    public d(Context context) {
        this(context, null);
    }

    public d(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void adC() {
        if (this.cdQ == null) {
            adD();
        }
        if (this.cdQ.getParent() == null) {
            addView(this.cdQ);
        }
    }

    private void adD() {
        this.cdQ = new a(getContext());
        this.cdQ.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        this.cdQ.setNumColumns(2);
        this.cdQ.setPadding(this.cdL, 0, this.cdL, 0);
        this.cdQ.setSelector(new ColorDrawable(0));
        this.cdQ.setCacheColorHint(0);
        this.cdQ.setFadingEdgeLength(0);
        this.cdQ.setFocusable(false);
        this.cdQ.setFocusableInTouchMode(false);
        this.cdQ.setVerticalScrollBarEnabled(false);
    }

    public void setSelection(int i) {
        if (this.cdQ != null) {
            this.cdQ.setSelection(i);
        }
    }

    public void setSelectionFromTop(int i, int i2) {
        if (this.cdQ != null) {
            this.cdQ.setSelection(i);
            this.cdQ.setPadding(this.cdL, 0, this.cdL, 0);
        }
    }

    public void setGridAdapterIfNeeded(BaseAdapter baseAdapter) {
        if (this.cdQ != null && this.cdQ.getAdapter() != baseAdapter) {
            this.cdQ.setAdapter((ListAdapter) baseAdapter);
        }
    }

    public void setEventCenter(ViewEventCenter viewEventCenter) {
        this.cbt = viewEventCenter;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        getParent().requestDisallowInterceptTouchEvent(true);
        return super.dispatchTouchEvent(motionEvent);
    }

    private void init() {
        this.cdL = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds40);
        LayoutInflater.from(getContext()).inflate(d.j.enter_forum_edit_view, this);
        setOrientation(1);
        this.cdN = (LinearLayout) findViewById(d.h.search_container);
        this.cdN.setVisibility(0);
        this.cdM = (TextView) findViewById(d.h.view_edit_forum_ok);
        this.cdM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.c.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.cbt != null) {
                    d.this.cbt.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(3, null, null, null));
                }
            }
        });
        this.cdO = (TextView) findViewById(d.h.search_text);
        this.cdP = (ImageView) findViewById(d.h.search_icon);
    }

    public void n(TbPageContext<?> tbPageContext) {
        com.baidu.tbadk.o.a.a(tbPageContext, this);
        setBackgroundColor(aj.getColor(d.e.cp_bg_line_d));
        aj.c(this.cdP, d.g.icon_search);
        aj.i(this.cdO, d.e.enter_forum_search_text_color);
        aj.j(this.cdN, d.g.enter_forum_search_frame);
    }
}
