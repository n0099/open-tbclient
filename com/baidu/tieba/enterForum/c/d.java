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
    private int ceD;
    private TextView ceE;
    private LinearLayout ceF;
    private TextView ceG;
    private ImageView ceH;
    private a ceI;

    public d(Context context) {
        this(context, null);
    }

    public d(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void adN() {
        if (this.ceI == null) {
            adO();
        }
        if (this.ceI.getParent() == null) {
            addView(this.ceI);
        }
    }

    private void adO() {
        this.ceI = new a(getContext());
        this.ceI.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        this.ceI.setNumColumns(2);
        this.ceI.setPadding(this.ceD, 0, this.ceD, 0);
        this.ceI.setSelector(new ColorDrawable(0));
        this.ceI.setCacheColorHint(0);
        this.ceI.setFadingEdgeLength(0);
        this.ceI.setFocusable(false);
        this.ceI.setFocusableInTouchMode(false);
        this.ceI.setVerticalScrollBarEnabled(false);
    }

    public void setSelection(int i) {
        if (this.ceI != null) {
            this.ceI.setSelection(i);
        }
    }

    public void setSelectionFromTop(int i, int i2) {
        if (this.ceI != null) {
            this.ceI.setSelection(i);
            this.ceI.setPadding(this.ceD, 0, this.ceD, 0);
        }
    }

    public void setGridAdapterIfNeeded(BaseAdapter baseAdapter) {
        if (this.ceI != null && this.ceI.getAdapter() != baseAdapter) {
            this.ceI.setAdapter((ListAdapter) baseAdapter);
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
        this.ceD = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds40);
        LayoutInflater.from(getContext()).inflate(d.j.enter_forum_edit_view, this);
        setOrientation(1);
        this.ceF = (LinearLayout) findViewById(d.h.search_container);
        this.ceF.setVisibility(0);
        this.ceE = (TextView) findViewById(d.h.view_edit_forum_ok);
        this.ceE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.c.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.ccl != null) {
                    d.this.ccl.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(3, null, null, null));
                }
            }
        });
        this.ceG = (TextView) findViewById(d.h.search_text);
        this.ceH = (ImageView) findViewById(d.h.search_icon);
    }

    public void n(TbPageContext<?> tbPageContext) {
        com.baidu.tbadk.o.a.a(tbPageContext, this);
        setBackgroundColor(aj.getColor(d.e.cp_bg_line_d));
        aj.c(this.ceH, d.g.icon_search);
        aj.i(this.ceG, d.e.enter_forum_search_text_color);
        aj.j(this.ceF, d.g.enter_forum_search_frame);
    }
}
