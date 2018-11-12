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
    private LinearLayout bWh;
    private ViewEventCenter dgT;
    private int djN;
    private TextView djO;
    private TextView djP;
    private ImageView djQ;
    private DragGridView djR;

    public ForumEditView(Context context) {
        this(context, null);
    }

    public ForumEditView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setColumnTypeAndRefeshView() {
        if (this.djR == null) {
            auf();
        }
        if (this.djR.getParent() == null) {
            addView(this.djR);
        }
    }

    private void auf() {
        this.djR = new DragGridView(getContext());
        this.djR.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        this.djR.setNumColumns(2);
        this.djR.setPadding(this.djN, 0, this.djN, 0);
        this.djR.setSelector(new ColorDrawable(0));
        this.djR.setCacheColorHint(0);
        this.djR.setFadingEdgeLength(0);
        this.djR.setFocusable(false);
        this.djR.setFocusableInTouchMode(false);
        this.djR.setVerticalScrollBarEnabled(false);
    }

    public void setSelectionFromTop(int i, int i2) {
        if (this.djR != null) {
            this.djR.setSelection(i);
            this.djR.setPadding(this.djN, 0, this.djN, 0);
        }
    }

    public void setGridAdapterIfNeeded(BaseAdapter baseAdapter) {
        if (this.djR != null && this.djR.getAdapter() != baseAdapter) {
            this.djR.setAdapter((ListAdapter) baseAdapter);
        }
    }

    public void setEventCenter(ViewEventCenter viewEventCenter) {
        this.dgT = viewEventCenter;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        getParent().requestDisallowInterceptTouchEvent(true);
        return super.dispatchTouchEvent(motionEvent);
    }

    private void init() {
        this.djN = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0200e.tbds44);
        LayoutInflater.from(getContext()).inflate(e.h.enter_forum_edit_view, this);
        setOrientation(1);
        this.bWh = (LinearLayout) findViewById(e.g.search_container);
        this.bWh.setVisibility(0);
        this.djO = (TextView) findViewById(e.g.view_edit_forum_ok);
        this.djO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.ForumEditView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ForumEditView.this.dgT != null) {
                    ForumEditView.this.dgT.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(3, null, null, null));
                }
            }
        });
        this.djP = (TextView) findViewById(e.g.search_text);
        this.djQ = (ImageView) findViewById(e.g.search_icon);
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext) {
        com.baidu.tbadk.o.a.a(tbPageContext, this);
        setBackgroundColor(al.getColor(e.d.cp_bg_line_d));
        al.c(this.djQ, e.f.icon_input_search);
        al.h(this.djP, e.d.cp_cont_d);
        al.j(this.bWh, e.d.cp_bg_line_e);
    }
}
