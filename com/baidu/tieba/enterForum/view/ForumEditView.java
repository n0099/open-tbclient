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
    private LinearLayout bZZ;
    private ViewEventCenter dnB;
    private int dqq;
    private TextView dqr;
    private TextView dqs;
    private ImageView dqt;
    private DragGridView dqu;

    public ForumEditView(Context context) {
        this(context, null);
    }

    public ForumEditView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setColumnTypeAndRefeshView() {
        if (this.dqu == null) {
            avQ();
        }
        if (this.dqu.getParent() == null) {
            addView(this.dqu);
        }
    }

    private void avQ() {
        this.dqu = new DragGridView(getContext());
        this.dqu.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        this.dqu.setNumColumns(2);
        this.dqu.setPadding(this.dqq, 0, this.dqq, 0);
        this.dqu.setSelector(new ColorDrawable(0));
        this.dqu.setCacheColorHint(0);
        this.dqu.setFadingEdgeLength(0);
        this.dqu.setFocusable(false);
        this.dqu.setFocusableInTouchMode(false);
        this.dqu.setVerticalScrollBarEnabled(false);
    }

    public void setSelectionFromTop(int i, int i2) {
        if (this.dqu != null) {
            this.dqu.setSelection(i);
            this.dqu.setPadding(this.dqq, 0, this.dqq, 0);
        }
    }

    public void setGridAdapterIfNeeded(BaseAdapter baseAdapter) {
        if (this.dqu != null && this.dqu.getAdapter() != baseAdapter) {
            this.dqu.setAdapter((ListAdapter) baseAdapter);
        }
    }

    public void setEventCenter(ViewEventCenter viewEventCenter) {
        this.dnB = viewEventCenter;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        getParent().requestDisallowInterceptTouchEvent(true);
        return super.dispatchTouchEvent(motionEvent);
    }

    private void init() {
        this.dqq = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0210e.tbds44);
        LayoutInflater.from(getContext()).inflate(e.h.enter_forum_edit_view, this);
        setOrientation(1);
        this.bZZ = (LinearLayout) findViewById(e.g.search_container);
        this.bZZ.setVisibility(0);
        this.dqr = (TextView) findViewById(e.g.view_edit_forum_ok);
        this.dqr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.ForumEditView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ForumEditView.this.dnB != null) {
                    ForumEditView.this.dnB.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(3, null, null, null));
                }
            }
        });
        this.dqs = (TextView) findViewById(e.g.search_text);
        this.dqt = (ImageView) findViewById(e.g.search_icon);
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext) {
        com.baidu.tbadk.o.a.a(tbPageContext, this);
        setBackgroundColor(al.getColor(e.d.cp_bg_line_d));
        al.c(this.dqt, e.f.icon_input_search);
        al.h(this.dqs, e.d.cp_cont_d);
        al.j(this.bZZ, e.d.cp_bg_line_e);
    }
}
