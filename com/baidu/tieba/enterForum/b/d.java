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
    private LinearLayout clr;
    private ViewEventCenter doJ;
    private int dqY;
    private TextView dqZ;
    private TextView dra;
    private ImageView drb;
    private a drc;

    public d(Context context) {
        this(context, null);
    }

    public d(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void arg() {
        if (this.drc == null) {
            arh();
        }
        if (this.drc.getParent() == null) {
            addView(this.drc);
        }
    }

    private void arh() {
        this.drc = new a(getContext());
        this.drc.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        this.drc.setNumColumns(2);
        this.drc.setPadding(this.dqY, 0, this.dqY, 0);
        this.drc.setSelector(new ColorDrawable(0));
        this.drc.setCacheColorHint(0);
        this.drc.setFadingEdgeLength(0);
        this.drc.setFocusable(false);
        this.drc.setFocusableInTouchMode(false);
        this.drc.setVerticalScrollBarEnabled(false);
    }

    public void setSelectionFromTop(int i, int i2) {
        if (this.drc != null) {
            this.drc.setSelection(i);
            this.drc.setPadding(this.dqY, 0, this.dqY, 0);
        }
    }

    public void setGridAdapterIfNeeded(BaseAdapter baseAdapter) {
        if (this.drc != null && this.drc.getAdapter() != baseAdapter) {
            this.drc.setAdapter((ListAdapter) baseAdapter);
        }
    }

    public void setEventCenter(ViewEventCenter viewEventCenter) {
        this.doJ = viewEventCenter;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        getParent().requestDisallowInterceptTouchEvent(true);
        return super.dispatchTouchEvent(motionEvent);
    }

    private void init() {
        this.dqY = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.tbds44);
        LayoutInflater.from(getContext()).inflate(d.h.enter_forum_edit_view, this);
        setOrientation(1);
        this.clr = (LinearLayout) findViewById(d.g.search_container);
        this.clr.setVisibility(0);
        this.dqZ = (TextView) findViewById(d.g.view_edit_forum_ok);
        this.dqZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.b.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.doJ != null) {
                    d.this.doJ.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(3, null, null, null));
                }
            }
        });
        this.dra = (TextView) findViewById(d.g.search_text);
        this.drb = (ImageView) findViewById(d.g.search_icon);
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext) {
        com.baidu.tbadk.n.a.a(tbPageContext, this);
        setBackgroundColor(aj.getColor(d.C0141d.cp_bg_line_d));
        aj.c(this.drb, d.f.icon_input_seach);
        aj.r(this.dra, d.C0141d.enter_forum_search_text_color);
        aj.s(this.clr, d.f.enter_forum_search_frame);
    }
}
