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
    private LinearLayout caN;
    private ViewEventCenter dre;
    private int dtN;
    private TextView dtO;
    private TextView dtP;
    private ImageView dtQ;
    private DragGridView dtR;

    public ForumEditView(Context context) {
        this(context, null);
    }

    public ForumEditView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setColumnTypeAndRefeshView() {
        if (this.dtR == null) {
            axc();
        }
        if (this.dtR.getParent() == null) {
            addView(this.dtR);
        }
    }

    private void axc() {
        this.dtR = new DragGridView(getContext());
        this.dtR.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        this.dtR.setNumColumns(2);
        this.dtR.setPadding(this.dtN, 0, this.dtN, 0);
        this.dtR.setSelector(new ColorDrawable(0));
        this.dtR.setCacheColorHint(0);
        this.dtR.setFadingEdgeLength(0);
        this.dtR.setFocusable(false);
        this.dtR.setFocusableInTouchMode(false);
        this.dtR.setVerticalScrollBarEnabled(false);
    }

    public void setSelectionFromTop(int i, int i2) {
        if (this.dtR != null) {
            this.dtR.setSelection(i);
            this.dtR.setPadding(this.dtN, 0, this.dtN, 0);
        }
    }

    public void setGridAdapterIfNeeded(BaseAdapter baseAdapter) {
        if (this.dtR != null && this.dtR.getAdapter() != baseAdapter) {
            this.dtR.setAdapter((ListAdapter) baseAdapter);
        }
    }

    public void setEventCenter(ViewEventCenter viewEventCenter) {
        this.dre = viewEventCenter;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        getParent().requestDisallowInterceptTouchEvent(true);
        return super.dispatchTouchEvent(motionEvent);
    }

    private void init() {
        this.dtN = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0210e.tbds44);
        LayoutInflater.from(getContext()).inflate(e.h.enter_forum_edit_view, this);
        setOrientation(1);
        this.caN = (LinearLayout) findViewById(e.g.search_container);
        this.caN.setVisibility(0);
        this.dtO = (TextView) findViewById(e.g.view_edit_forum_ok);
        this.dtO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.ForumEditView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ForumEditView.this.dre != null) {
                    ForumEditView.this.dre.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(3, null, null, null));
                }
            }
        });
        this.dtP = (TextView) findViewById(e.g.search_text);
        this.dtQ = (ImageView) findViewById(e.g.search_icon);
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext) {
        com.baidu.tbadk.o.a.a(tbPageContext, this);
        setBackgroundColor(al.getColor(e.d.cp_bg_line_d));
        al.c(this.dtQ, e.f.icon_input_search);
        al.h(this.dtP, e.d.cp_cont_d);
        al.j(this.caN, e.d.cp_bg_line_e);
    }
}
