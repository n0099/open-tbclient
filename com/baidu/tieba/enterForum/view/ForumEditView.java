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
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class ForumEditView extends LinearLayout {
    private LinearLayout bEr;
    private ViewEventCenter cRe;
    private int cTT;
    private TextView cTU;
    private TextView cTV;
    private ImageView cTW;
    private DragGridView cTX;

    public ForumEditView(Context context) {
        this(context, null);
    }

    public ForumEditView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setColumnTypeAndRefeshView() {
        if (this.cTX == null) {
            apB();
        }
        if (this.cTX.getParent() == null) {
            addView(this.cTX);
        }
    }

    private void apB() {
        this.cTX = new DragGridView(getContext());
        this.cTX.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        this.cTX.setNumColumns(2);
        this.cTX.setPadding(this.cTT, 0, this.cTT, 0);
        this.cTX.setSelector(new ColorDrawable(0));
        this.cTX.setCacheColorHint(0);
        this.cTX.setFadingEdgeLength(0);
        this.cTX.setFocusable(false);
        this.cTX.setFocusableInTouchMode(false);
        this.cTX.setVerticalScrollBarEnabled(false);
    }

    public void setSelectionFromTop(int i, int i2) {
        if (this.cTX != null) {
            this.cTX.setSelection(i);
            this.cTX.setPadding(this.cTT, 0, this.cTT, 0);
        }
    }

    public void setGridAdapterIfNeeded(BaseAdapter baseAdapter) {
        if (this.cTX != null && this.cTX.getAdapter() != baseAdapter) {
            this.cTX.setAdapter((ListAdapter) baseAdapter);
        }
    }

    public void setEventCenter(ViewEventCenter viewEventCenter) {
        this.cRe = viewEventCenter;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        getParent().requestDisallowInterceptTouchEvent(true);
        return super.dispatchTouchEvent(motionEvent);
    }

    private void init() {
        this.cTT = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.tbds44);
        LayoutInflater.from(getContext()).inflate(d.i.enter_forum_edit_view, this);
        setOrientation(1);
        this.bEr = (LinearLayout) findViewById(d.g.search_container);
        this.bEr.setVisibility(0);
        this.cTU = (TextView) findViewById(d.g.view_edit_forum_ok);
        this.cTU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.ForumEditView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ForumEditView.this.cRe != null) {
                    ForumEditView.this.cRe.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(3, null, null, null));
                }
            }
        });
        this.cTV = (TextView) findViewById(d.g.search_text);
        this.cTW = (ImageView) findViewById(d.g.search_icon);
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext) {
        com.baidu.tbadk.n.a.a(tbPageContext, this);
        setBackgroundColor(al.getColor(d.C0141d.cp_bg_line_d));
        al.c(this.cTW, d.f.icon_input_seach);
        al.h(this.cTV, d.C0141d.cp_cont_d);
        al.j(this.bEr, d.C0141d.cp_bg_line_e);
    }
}
