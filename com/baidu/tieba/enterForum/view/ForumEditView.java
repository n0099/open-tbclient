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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class ForumEditView extends LinearLayout {
    private LinearLayout bGn;
    private ViewEventCenter cOZ;
    private int cRT;
    private TextView cRU;
    private TextView cRV;
    private ImageView cRW;
    private DragGridView cRX;

    public ForumEditView(Context context) {
        this(context, null);
    }

    public ForumEditView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setColumnTypeAndRefeshView() {
        if (this.cRX == null) {
            aoV();
        }
        if (this.cRX.getParent() == null) {
            addView(this.cRX);
        }
    }

    private void aoV() {
        this.cRX = new DragGridView(getContext());
        this.cRX.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        this.cRX.setNumColumns(2);
        this.cRX.setPadding(this.cRT, 0, this.cRT, 0);
        this.cRX.setSelector(new ColorDrawable(0));
        this.cRX.setCacheColorHint(0);
        this.cRX.setFadingEdgeLength(0);
        this.cRX.setFocusable(false);
        this.cRX.setFocusableInTouchMode(false);
        this.cRX.setVerticalScrollBarEnabled(false);
    }

    public void setSelectionFromTop(int i, int i2) {
        if (this.cRX != null) {
            this.cRX.setSelection(i);
            this.cRX.setPadding(this.cRT, 0, this.cRT, 0);
        }
    }

    public void setGridAdapterIfNeeded(BaseAdapter baseAdapter) {
        if (this.cRX != null && this.cRX.getAdapter() != baseAdapter) {
            this.cRX.setAdapter((ListAdapter) baseAdapter);
        }
    }

    public void setEventCenter(ViewEventCenter viewEventCenter) {
        this.cOZ = viewEventCenter;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        getParent().requestDisallowInterceptTouchEvent(true);
        return super.dispatchTouchEvent(motionEvent);
    }

    private void init() {
        this.cRT = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.tbds44);
        LayoutInflater.from(getContext()).inflate(d.i.enter_forum_edit_view, this);
        setOrientation(1);
        this.bGn = (LinearLayout) findViewById(d.g.search_container);
        this.bGn.setVisibility(0);
        this.cRU = (TextView) findViewById(d.g.view_edit_forum_ok);
        this.cRU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.ForumEditView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ForumEditView.this.cOZ != null) {
                    ForumEditView.this.cOZ.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(3, null, null, null));
                }
            }
        });
        this.cRV = (TextView) findViewById(d.g.search_text);
        this.cRW = (ImageView) findViewById(d.g.search_icon);
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext) {
        com.baidu.tbadk.n.a.a(tbPageContext, this);
        setBackgroundColor(am.getColor(d.C0142d.cp_bg_line_d));
        am.c(this.cRW, d.f.icon_input_search);
        am.h(this.cRV, d.C0142d.cp_cont_d);
        am.j(this.bGn, d.C0142d.cp_bg_line_e);
    }
}
