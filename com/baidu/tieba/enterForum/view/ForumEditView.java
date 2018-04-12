package com.baidu.tieba.enterForum.view;

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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class ForumEditView extends LinearLayout {
    private LinearLayout bvE;
    private ViewEventCenter cGR;
    private int cJH;
    private TextView cJI;
    private TextView cJJ;
    private ImageView cJK;
    private DragGridView cJL;

    public ForumEditView(Context context) {
        this(context, null);
    }

    public ForumEditView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setColumnTypeAndRefeshView() {
        if (this.cJL == null) {
            alv();
        }
        if (this.cJL.getParent() == null) {
            addView(this.cJL);
        }
    }

    private void alv() {
        this.cJL = new DragGridView(getContext());
        this.cJL.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        this.cJL.setNumColumns(2);
        this.cJL.setPadding(this.cJH, 0, this.cJH, 0);
        this.cJL.setSelector(new ColorDrawable(0));
        this.cJL.setCacheColorHint(0);
        this.cJL.setFadingEdgeLength(0);
        this.cJL.setFocusable(false);
        this.cJL.setFocusableInTouchMode(false);
        this.cJL.setVerticalScrollBarEnabled(false);
    }

    public void setSelectionFromTop(int i, int i2) {
        if (this.cJL != null) {
            this.cJL.setSelection(i);
            this.cJL.setPadding(this.cJH, 0, this.cJH, 0);
        }
    }

    public void setGridAdapterIfNeeded(BaseAdapter baseAdapter) {
        if (this.cJL != null && this.cJL.getAdapter() != baseAdapter) {
            this.cJL.setAdapter((ListAdapter) baseAdapter);
        }
    }

    public void setEventCenter(ViewEventCenter viewEventCenter) {
        this.cGR = viewEventCenter;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        getParent().requestDisallowInterceptTouchEvent(true);
        return super.dispatchTouchEvent(motionEvent);
    }

    private void init() {
        this.cJH = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.tbds44);
        LayoutInflater.from(getContext()).inflate(d.i.enter_forum_edit_view, this);
        setOrientation(1);
        this.bvE = (LinearLayout) findViewById(d.g.search_container);
        this.bvE.setVisibility(0);
        this.cJI = (TextView) findViewById(d.g.view_edit_forum_ok);
        this.cJI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.ForumEditView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (ForumEditView.this.cGR != null) {
                    ForumEditView.this.cGR.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(3, null, null, null));
                }
            }
        });
        this.cJJ = (TextView) findViewById(d.g.search_text);
        this.cJK = (ImageView) findViewById(d.g.search_icon);
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext) {
        com.baidu.tbadk.n.a.a(tbPageContext, this);
        setBackgroundColor(ak.getColor(d.C0126d.cp_bg_line_d));
        ak.c(this.cJK, d.f.icon_input_seach);
        ak.h(this.cJJ, d.C0126d.cp_cont_d);
        ak.j(this.bvE, d.C0126d.cp_bg_line_e);
    }
}
