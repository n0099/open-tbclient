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
    private LinearLayout chx;
    private ViewEventCenter dhh;
    private int dju;
    private TextView djv;
    private TextView djw;
    private ImageView djx;
    private a djy;

    public d(Context context) {
        this(context, null);
    }

    public d(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void apj() {
        if (this.djy == null) {
            apk();
        }
        if (this.djy.getParent() == null) {
            addView(this.djy);
        }
    }

    private void apk() {
        this.djy = new a(getContext());
        this.djy.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        this.djy.setNumColumns(2);
        this.djy.setPadding(this.dju, 0, this.dju, 0);
        this.djy.setSelector(new ColorDrawable(0));
        this.djy.setCacheColorHint(0);
        this.djy.setFadingEdgeLength(0);
        this.djy.setFocusable(false);
        this.djy.setFocusableInTouchMode(false);
        this.djy.setVerticalScrollBarEnabled(false);
    }

    public void setSelectionFromTop(int i, int i2) {
        if (this.djy != null) {
            this.djy.setSelection(i);
            this.djy.setPadding(this.dju, 0, this.dju, 0);
        }
    }

    public void setGridAdapterIfNeeded(BaseAdapter baseAdapter) {
        if (this.djy != null && this.djy.getAdapter() != baseAdapter) {
            this.djy.setAdapter((ListAdapter) baseAdapter);
        }
    }

    public void setEventCenter(ViewEventCenter viewEventCenter) {
        this.dhh = viewEventCenter;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        getParent().requestDisallowInterceptTouchEvent(true);
        return super.dispatchTouchEvent(motionEvent);
    }

    private void init() {
        this.dju = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.tbds44);
        LayoutInflater.from(getContext()).inflate(d.h.enter_forum_edit_view, this);
        setOrientation(1);
        this.chx = (LinearLayout) findViewById(d.g.search_container);
        this.chx.setVisibility(0);
        this.djv = (TextView) findViewById(d.g.view_edit_forum_ok);
        this.djv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.b.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.dhh != null) {
                    d.this.dhh.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(3, null, null, null));
                }
            }
        });
        this.djw = (TextView) findViewById(d.g.search_text);
        this.djx = (ImageView) findViewById(d.g.search_icon);
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext) {
        com.baidu.tbadk.n.a.a(tbPageContext, this);
        setBackgroundColor(aj.getColor(d.C0108d.cp_bg_line_d));
        aj.c(this.djx, d.f.icon_input_seach);
        aj.r(this.djw, d.C0108d.enter_forum_search_text_color);
        aj.s(this.chx, d.f.enter_forum_search_frame);
    }
}
