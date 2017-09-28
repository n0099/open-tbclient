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
    private ViewEventCenter ccl;
    private int ceE;
    private TextView ceF;
    private LinearLayout ceG;
    private TextView ceH;
    private ImageView ceI;
    private a ceJ;

    public d(Context context) {
        this(context, null);
    }

    public d(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void adA() {
        if (this.ceJ == null) {
            adB();
        }
        if (this.ceJ.getParent() == null) {
            addView(this.ceJ);
        }
    }

    private void adB() {
        this.ceJ = new a(getContext());
        this.ceJ.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        this.ceJ.setNumColumns(2);
        this.ceJ.setPadding(this.ceE, 0, this.ceE, 0);
        this.ceJ.setSelector(new ColorDrawable(0));
        this.ceJ.setCacheColorHint(0);
        this.ceJ.setFadingEdgeLength(0);
        this.ceJ.setFocusable(false);
        this.ceJ.setFocusableInTouchMode(false);
        this.ceJ.setVerticalScrollBarEnabled(false);
    }

    public void setSelection(int i) {
        if (this.ceJ != null) {
            this.ceJ.setSelection(i);
        }
    }

    public void setSelectionFromTop(int i, int i2) {
        if (this.ceJ != null) {
            this.ceJ.setSelection(i);
            this.ceJ.setPadding(this.ceE, 0, this.ceE, 0);
        }
    }

    public void setGridAdapterIfNeeded(BaseAdapter baseAdapter) {
        if (this.ceJ != null && this.ceJ.getAdapter() != baseAdapter) {
            this.ceJ.setAdapter((ListAdapter) baseAdapter);
        }
    }

    public void setEventCenter(ViewEventCenter viewEventCenter) {
        this.ccl = viewEventCenter;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        getParent().requestDisallowInterceptTouchEvent(true);
        return super.dispatchTouchEvent(motionEvent);
    }

    private void init() {
        this.ceE = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds40);
        LayoutInflater.from(getContext()).inflate(d.j.enter_forum_edit_view, this);
        setOrientation(1);
        this.ceG = (LinearLayout) findViewById(d.h.search_container);
        this.ceG.setVisibility(0);
        this.ceF = (TextView) findViewById(d.h.view_edit_forum_ok);
        this.ceF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.c.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.ccl != null) {
                    d.this.ccl.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(3, null, null, null));
                }
            }
        });
        this.ceH = (TextView) findViewById(d.h.search_text);
        this.ceI = (ImageView) findViewById(d.h.search_icon);
    }

    public void k(TbPageContext<?> tbPageContext) {
        com.baidu.tbadk.n.a.a(tbPageContext, this);
        setBackgroundColor(aj.getColor(d.e.cp_bg_line_d));
        aj.c(this.ceI, d.g.icon_search);
        aj.i(this.ceH, d.e.enter_forum_search_text_color);
        aj.j(this.ceG, d.g.enter_forum_search_frame);
    }
}
