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
/* loaded from: classes2.dex */
public class d extends LinearLayout {
    private LinearLayout chM;
    private ViewEventCenter dme;
    private int dor;
    private TextView dos;
    private TextView dot;
    private ImageView dou;
    private a dov;

    public d(Context context) {
        this(context, null);
    }

    public d(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void aqr() {
        if (this.dov == null) {
            aqs();
        }
        if (this.dov.getParent() == null) {
            addView(this.dov);
        }
    }

    private void aqs() {
        this.dov = new a(getContext());
        this.dov.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        this.dov.setNumColumns(2);
        this.dov.setPadding(this.dor, 0, this.dor, 0);
        this.dov.setSelector(new ColorDrawable(0));
        this.dov.setCacheColorHint(0);
        this.dov.setFadingEdgeLength(0);
        this.dov.setFocusable(false);
        this.dov.setFocusableInTouchMode(false);
        this.dov.setVerticalScrollBarEnabled(false);
    }

    public void setSelectionFromTop(int i, int i2) {
        if (this.dov != null) {
            this.dov.setSelection(i);
            this.dov.setPadding(this.dor, 0, this.dor, 0);
        }
    }

    public void setGridAdapterIfNeeded(BaseAdapter baseAdapter) {
        if (this.dov != null && this.dov.getAdapter() != baseAdapter) {
            this.dov.setAdapter((ListAdapter) baseAdapter);
        }
    }

    public void setEventCenter(ViewEventCenter viewEventCenter) {
        this.dme = viewEventCenter;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        getParent().requestDisallowInterceptTouchEvent(true);
        return super.dispatchTouchEvent(motionEvent);
    }

    private void init() {
        this.dor = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.tbds44);
        LayoutInflater.from(getContext()).inflate(d.h.enter_forum_edit_view, this);
        setOrientation(1);
        this.chM = (LinearLayout) findViewById(d.g.search_container);
        this.chM.setVisibility(0);
        this.dos = (TextView) findViewById(d.g.view_edit_forum_ok);
        this.dos.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.b.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.dme != null) {
                    d.this.dme.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(3, null, null, null));
                }
            }
        });
        this.dot = (TextView) findViewById(d.g.search_text);
        this.dou = (ImageView) findViewById(d.g.search_icon);
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext) {
        com.baidu.tbadk.n.a.a(tbPageContext, this);
        setBackgroundColor(aj.getColor(d.C0108d.cp_bg_line_d));
        aj.c(this.dou, d.f.icon_input_seach);
        aj.r(this.dot, d.C0108d.enter_forum_search_text_color);
        aj.s(this.chM, d.f.enter_forum_search_frame);
    }
}
