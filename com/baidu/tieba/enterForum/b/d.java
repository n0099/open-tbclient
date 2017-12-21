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
    private LinearLayout bug;
    private ViewEventCenter csJ;
    private int cuY;
    private TextView cuZ;
    private TextView cva;
    private ImageView cvb;
    private a cvc;

    public d(Context context) {
        this(context, null);
    }

    public d(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void ahJ() {
        if (this.cvc == null) {
            ahK();
        }
        if (this.cvc.getParent() == null) {
            addView(this.cvc);
        }
    }

    private void ahK() {
        this.cvc = new a(getContext());
        this.cvc.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        this.cvc.setNumColumns(2);
        this.cvc.setPadding(this.cuY, 0, this.cuY, 0);
        this.cvc.setSelector(new ColorDrawable(0));
        this.cvc.setCacheColorHint(0);
        this.cvc.setFadingEdgeLength(0);
        this.cvc.setFocusable(false);
        this.cvc.setFocusableInTouchMode(false);
        this.cvc.setVerticalScrollBarEnabled(false);
    }

    public void setSelectionFromTop(int i, int i2) {
        if (this.cvc != null) {
            this.cvc.setSelection(i);
            this.cvc.setPadding(this.cuY, 0, this.cuY, 0);
        }
    }

    public void setGridAdapterIfNeeded(BaseAdapter baseAdapter) {
        if (this.cvc != null && this.cvc.getAdapter() != baseAdapter) {
            this.cvc.setAdapter((ListAdapter) baseAdapter);
        }
    }

    public void setEventCenter(ViewEventCenter viewEventCenter) {
        this.csJ = viewEventCenter;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        getParent().requestDisallowInterceptTouchEvent(true);
        return super.dispatchTouchEvent(motionEvent);
    }

    private void init() {
        this.cuY = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.tbds44);
        LayoutInflater.from(getContext()).inflate(d.h.enter_forum_edit_view, this);
        setOrientation(1);
        this.bug = (LinearLayout) findViewById(d.g.search_container);
        this.bug.setVisibility(0);
        this.cuZ = (TextView) findViewById(d.g.view_edit_forum_ok);
        this.cuZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.b.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.csJ != null) {
                    d.this.csJ.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(3, null, null, null));
                }
            }
        });
        this.cva = (TextView) findViewById(d.g.search_text);
        this.cvb = (ImageView) findViewById(d.g.search_icon);
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext) {
        com.baidu.tbadk.n.a.a(tbPageContext, this);
        setBackgroundColor(aj.getColor(d.C0095d.cp_bg_line_d));
        aj.c(this.cvb, d.f.icon_input_seach);
        aj.i(this.cva, d.C0095d.enter_forum_search_text_color);
        aj.j(this.bug, d.f.enter_forum_search_frame);
    }
}
