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
    private ViewEventCenter cGO;
    private int cJE;
    private TextView cJF;
    private TextView cJG;
    private ImageView cJH;
    private DragGridView cJI;

    public ForumEditView(Context context) {
        this(context, null);
    }

    public ForumEditView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setColumnTypeAndRefeshView() {
        if (this.cJI == null) {
            alv();
        }
        if (this.cJI.getParent() == null) {
            addView(this.cJI);
        }
    }

    private void alv() {
        this.cJI = new DragGridView(getContext());
        this.cJI.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        this.cJI.setNumColumns(2);
        this.cJI.setPadding(this.cJE, 0, this.cJE, 0);
        this.cJI.setSelector(new ColorDrawable(0));
        this.cJI.setCacheColorHint(0);
        this.cJI.setFadingEdgeLength(0);
        this.cJI.setFocusable(false);
        this.cJI.setFocusableInTouchMode(false);
        this.cJI.setVerticalScrollBarEnabled(false);
    }

    public void setSelectionFromTop(int i, int i2) {
        if (this.cJI != null) {
            this.cJI.setSelection(i);
            this.cJI.setPadding(this.cJE, 0, this.cJE, 0);
        }
    }

    public void setGridAdapterIfNeeded(BaseAdapter baseAdapter) {
        if (this.cJI != null && this.cJI.getAdapter() != baseAdapter) {
            this.cJI.setAdapter((ListAdapter) baseAdapter);
        }
    }

    public void setEventCenter(ViewEventCenter viewEventCenter) {
        this.cGO = viewEventCenter;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        getParent().requestDisallowInterceptTouchEvent(true);
        return super.dispatchTouchEvent(motionEvent);
    }

    private void init() {
        this.cJE = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.tbds44);
        LayoutInflater.from(getContext()).inflate(d.i.enter_forum_edit_view, this);
        setOrientation(1);
        this.bvE = (LinearLayout) findViewById(d.g.search_container);
        this.bvE.setVisibility(0);
        this.cJF = (TextView) findViewById(d.g.view_edit_forum_ok);
        this.cJF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.ForumEditView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (ForumEditView.this.cGO != null) {
                    ForumEditView.this.cGO.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(3, null, null, null));
                }
            }
        });
        this.cJG = (TextView) findViewById(d.g.search_text);
        this.cJH = (ImageView) findViewById(d.g.search_icon);
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext) {
        com.baidu.tbadk.n.a.a(tbPageContext, this);
        setBackgroundColor(ak.getColor(d.C0126d.cp_bg_line_d));
        ak.c(this.cJH, d.f.icon_input_seach);
        ak.h(this.cJG, d.C0126d.cp_cont_d);
        ak.j(this.bvE, d.C0126d.cp_bg_line_e);
    }
}
