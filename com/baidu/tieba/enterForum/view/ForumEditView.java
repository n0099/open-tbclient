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
    private LinearLayout bVt;
    private ViewEventCenter dfO;
    private int diI;
    private TextView diJ;
    private TextView diK;
    private ImageView diL;
    private DragGridView diM;

    public ForumEditView(Context context) {
        this(context, null);
    }

    public ForumEditView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setColumnTypeAndRefeshView() {
        if (this.diM == null) {
            auH();
        }
        if (this.diM.getParent() == null) {
            addView(this.diM);
        }
    }

    private void auH() {
        this.diM = new DragGridView(getContext());
        this.diM.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        this.diM.setNumColumns(2);
        this.diM.setPadding(this.diI, 0, this.diI, 0);
        this.diM.setSelector(new ColorDrawable(0));
        this.diM.setCacheColorHint(0);
        this.diM.setFadingEdgeLength(0);
        this.diM.setFocusable(false);
        this.diM.setFocusableInTouchMode(false);
        this.diM.setVerticalScrollBarEnabled(false);
    }

    public void setSelectionFromTop(int i, int i2) {
        if (this.diM != null) {
            this.diM.setSelection(i);
            this.diM.setPadding(this.diI, 0, this.diI, 0);
        }
    }

    public void setGridAdapterIfNeeded(BaseAdapter baseAdapter) {
        if (this.diM != null && this.diM.getAdapter() != baseAdapter) {
            this.diM.setAdapter((ListAdapter) baseAdapter);
        }
    }

    public void setEventCenter(ViewEventCenter viewEventCenter) {
        this.dfO = viewEventCenter;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        getParent().requestDisallowInterceptTouchEvent(true);
        return super.dispatchTouchEvent(motionEvent);
    }

    private void init() {
        this.diI = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0175e.tbds44);
        LayoutInflater.from(getContext()).inflate(e.h.enter_forum_edit_view, this);
        setOrientation(1);
        this.bVt = (LinearLayout) findViewById(e.g.search_container);
        this.bVt.setVisibility(0);
        this.diJ = (TextView) findViewById(e.g.view_edit_forum_ok);
        this.diJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.ForumEditView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ForumEditView.this.dfO != null) {
                    ForumEditView.this.dfO.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(3, null, null, null));
                }
            }
        });
        this.diK = (TextView) findViewById(e.g.search_text);
        this.diL = (ImageView) findViewById(e.g.search_icon);
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext) {
        com.baidu.tbadk.o.a.a(tbPageContext, this);
        setBackgroundColor(al.getColor(e.d.cp_bg_line_d));
        al.c(this.diL, e.f.icon_input_search);
        al.h(this.diK, e.d.cp_cont_d);
        al.j(this.bVt, e.d.cp_bg_line_e);
    }
}
