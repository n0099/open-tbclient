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
    private LinearLayout bHc;
    private ViewEventCenter cRI;
    private int cUG;
    private TextView cUH;
    private TextView cUI;
    private ImageView cUJ;
    private DragGridView cUK;

    public ForumEditView(Context context) {
        this(context, null);
    }

    public ForumEditView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setColumnTypeAndRefeshView() {
        if (this.cUK == null) {
            apw();
        }
        if (this.cUK.getParent() == null) {
            addView(this.cUK);
        }
    }

    private void apw() {
        this.cUK = new DragGridView(getContext());
        this.cUK.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        this.cUK.setNumColumns(2);
        this.cUK.setPadding(this.cUG, 0, this.cUG, 0);
        this.cUK.setSelector(new ColorDrawable(0));
        this.cUK.setCacheColorHint(0);
        this.cUK.setFadingEdgeLength(0);
        this.cUK.setFocusable(false);
        this.cUK.setFocusableInTouchMode(false);
        this.cUK.setVerticalScrollBarEnabled(false);
    }

    public void setSelectionFromTop(int i, int i2) {
        if (this.cUK != null) {
            this.cUK.setSelection(i);
            this.cUK.setPadding(this.cUG, 0, this.cUG, 0);
        }
    }

    public void setGridAdapterIfNeeded(BaseAdapter baseAdapter) {
        if (this.cUK != null && this.cUK.getAdapter() != baseAdapter) {
            this.cUK.setAdapter((ListAdapter) baseAdapter);
        }
    }

    public void setEventCenter(ViewEventCenter viewEventCenter) {
        this.cRI = viewEventCenter;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        getParent().requestDisallowInterceptTouchEvent(true);
        return super.dispatchTouchEvent(motionEvent);
    }

    private void init() {
        this.cUG = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.tbds44);
        LayoutInflater.from(getContext()).inflate(d.h.enter_forum_edit_view, this);
        setOrientation(1);
        this.bHc = (LinearLayout) findViewById(d.g.search_container);
        this.bHc.setVisibility(0);
        this.cUH = (TextView) findViewById(d.g.view_edit_forum_ok);
        this.cUH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.ForumEditView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ForumEditView.this.cRI != null) {
                    ForumEditView.this.cRI.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(3, null, null, null));
                }
            }
        });
        this.cUI = (TextView) findViewById(d.g.search_text);
        this.cUJ = (ImageView) findViewById(d.g.search_icon);
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext) {
        com.baidu.tbadk.o.a.a(tbPageContext, this);
        setBackgroundColor(am.getColor(d.C0140d.cp_bg_line_d));
        am.c(this.cUJ, d.f.icon_input_search);
        am.h(this.cUI, d.C0140d.cp_cont_d);
        am.j(this.bHc, d.C0140d.cp_bg_line_e);
    }
}
