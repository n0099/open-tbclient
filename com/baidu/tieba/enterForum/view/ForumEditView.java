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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.e;
/* loaded from: classes4.dex */
public class ForumEditView extends LinearLayout {
    private LinearLayout cac;
    private ViewEventCenter dqs;
    private int dte;
    private TextView dtf;
    private TextView dtg;
    private ImageView dth;
    private DragGridView dti;

    public ForumEditView(Context context) {
        this(context, null);
    }

    public ForumEditView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setColumnTypeAndRefeshView() {
        if (this.dti == null) {
            awF();
        }
        if (this.dti.getParent() == null) {
            addView(this.dti);
        }
    }

    private void awF() {
        this.dti = new DragGridView(getContext());
        this.dti.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        this.dti.setNumColumns(2);
        this.dti.setPadding(this.dte, 0, this.dte, 0);
        this.dti.setSelector(new ColorDrawable(0));
        this.dti.setCacheColorHint(0);
        this.dti.setFadingEdgeLength(0);
        this.dti.setFocusable(false);
        this.dti.setFocusableInTouchMode(false);
        this.dti.setVerticalScrollBarEnabled(false);
    }

    public void setSelectionFromTop(int i, int i2) {
        if (this.dti != null) {
            this.dti.setSelection(i);
            this.dti.setPadding(this.dte, 0, this.dte, 0);
        }
    }

    public void setGridAdapterIfNeeded(BaseAdapter baseAdapter) {
        if (this.dti != null && this.dti.getAdapter() != baseAdapter) {
            this.dti.setAdapter((ListAdapter) baseAdapter);
        }
    }

    public void setEventCenter(ViewEventCenter viewEventCenter) {
        this.dqs = viewEventCenter;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        getParent().requestDisallowInterceptTouchEvent(true);
        return super.dispatchTouchEvent(motionEvent);
    }

    private void init() {
        this.dte = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0210e.tbds44);
        LayoutInflater.from(getContext()).inflate(e.h.enter_forum_edit_view, this);
        setOrientation(1);
        this.cac = (LinearLayout) findViewById(e.g.search_container);
        this.cac.setVisibility(0);
        this.dtf = (TextView) findViewById(e.g.view_edit_forum_ok);
        this.dtf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.ForumEditView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ForumEditView.this.dqs != null) {
                    ForumEditView.this.dqs.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(3, null, null, null));
                }
            }
        });
        this.dtg = (TextView) findViewById(e.g.search_text);
        this.dth = (ImageView) findViewById(e.g.search_icon);
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext) {
        com.baidu.tbadk.o.a.a(tbPageContext, this);
        setBackgroundColor(al.getColor(e.d.cp_bg_line_d));
        al.c(this.dth, e.f.icon_input_search);
        al.h(this.dtg, e.d.cp_cont_d);
        al.j(this.cac, e.d.cp_bg_line_e);
    }
}
