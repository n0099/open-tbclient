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
    private ViewEventCenter cbZ;
    private int ces;
    private TextView cet;
    private LinearLayout ceu;
    private TextView cev;
    private ImageView cew;
    private a cex;

    public d(Context context) {
        this(context, null);
    }

    public d(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void adw() {
        if (this.cex == null) {
            adx();
        }
        if (this.cex.getParent() == null) {
            addView(this.cex);
        }
    }

    private void adx() {
        this.cex = new a(getContext());
        this.cex.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        this.cex.setNumColumns(2);
        this.cex.setPadding(this.ces, 0, this.ces, 0);
        this.cex.setSelector(new ColorDrawable(0));
        this.cex.setCacheColorHint(0);
        this.cex.setFadingEdgeLength(0);
        this.cex.setFocusable(false);
        this.cex.setFocusableInTouchMode(false);
        this.cex.setVerticalScrollBarEnabled(false);
    }

    public void setSelection(int i) {
        if (this.cex != null) {
            this.cex.setSelection(i);
        }
    }

    public void setSelectionFromTop(int i, int i2) {
        if (this.cex != null) {
            this.cex.setSelection(i);
            this.cex.setPadding(this.ces, 0, this.ces, 0);
        }
    }

    public void setGridAdapterIfNeeded(BaseAdapter baseAdapter) {
        if (this.cex != null && this.cex.getAdapter() != baseAdapter) {
            this.cex.setAdapter((ListAdapter) baseAdapter);
        }
    }

    public void setEventCenter(ViewEventCenter viewEventCenter) {
        this.cbZ = viewEventCenter;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        getParent().requestDisallowInterceptTouchEvent(true);
        return super.dispatchTouchEvent(motionEvent);
    }

    private void init() {
        this.ces = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds40);
        LayoutInflater.from(getContext()).inflate(d.j.enter_forum_edit_view, this);
        setOrientation(1);
        this.ceu = (LinearLayout) findViewById(d.h.search_container);
        this.ceu.setVisibility(0);
        this.cet = (TextView) findViewById(d.h.view_edit_forum_ok);
        this.cet.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.c.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.cbZ != null) {
                    d.this.cbZ.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(3, null, null, null));
                }
            }
        });
        this.cev = (TextView) findViewById(d.h.search_text);
        this.cew = (ImageView) findViewById(d.h.search_icon);
    }

    public void k(TbPageContext<?> tbPageContext) {
        com.baidu.tbadk.n.a.a(tbPageContext, this);
        setBackgroundColor(aj.getColor(d.e.cp_bg_line_d));
        aj.c(this.cew, d.g.icon_search);
        aj.i(this.cev, d.e.enter_forum_search_text_color);
        aj.j(this.ceu, d.g.enter_forum_search_frame);
    }
}
