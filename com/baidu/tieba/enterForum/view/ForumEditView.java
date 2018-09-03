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
import com.baidu.tieba.f;
/* loaded from: classes2.dex */
public class ForumEditView extends LinearLayout {
    private LinearLayout bHc;
    private ViewEventCenter cRF;
    private int cUC;
    private TextView cUD;
    private TextView cUE;
    private ImageView cUF;
    private DragGridView cUG;

    public ForumEditView(Context context) {
        this(context, null);
    }

    public ForumEditView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setColumnTypeAndRefeshView() {
        if (this.cUG == null) {
            apw();
        }
        if (this.cUG.getParent() == null) {
            addView(this.cUG);
        }
    }

    private void apw() {
        this.cUG = new DragGridView(getContext());
        this.cUG.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        this.cUG.setNumColumns(2);
        this.cUG.setPadding(this.cUC, 0, this.cUC, 0);
        this.cUG.setSelector(new ColorDrawable(0));
        this.cUG.setCacheColorHint(0);
        this.cUG.setFadingEdgeLength(0);
        this.cUG.setFocusable(false);
        this.cUG.setFocusableInTouchMode(false);
        this.cUG.setVerticalScrollBarEnabled(false);
    }

    public void setSelectionFromTop(int i, int i2) {
        if (this.cUG != null) {
            this.cUG.setSelection(i);
            this.cUG.setPadding(this.cUC, 0, this.cUC, 0);
        }
    }

    public void setGridAdapterIfNeeded(BaseAdapter baseAdapter) {
        if (this.cUG != null && this.cUG.getAdapter() != baseAdapter) {
            this.cUG.setAdapter((ListAdapter) baseAdapter);
        }
    }

    public void setEventCenter(ViewEventCenter viewEventCenter) {
        this.cRF = viewEventCenter;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        getParent().requestDisallowInterceptTouchEvent(true);
        return super.dispatchTouchEvent(motionEvent);
    }

    private void init() {
        this.cUC = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(f.e.tbds44);
        LayoutInflater.from(getContext()).inflate(f.h.enter_forum_edit_view, this);
        setOrientation(1);
        this.bHc = (LinearLayout) findViewById(f.g.search_container);
        this.bHc.setVisibility(0);
        this.cUD = (TextView) findViewById(f.g.view_edit_forum_ok);
        this.cUD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.ForumEditView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ForumEditView.this.cRF != null) {
                    ForumEditView.this.cRF.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(3, null, null, null));
                }
            }
        });
        this.cUE = (TextView) findViewById(f.g.search_text);
        this.cUF = (ImageView) findViewById(f.g.search_icon);
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext) {
        com.baidu.tbadk.o.a.a(tbPageContext, this);
        setBackgroundColor(am.getColor(f.d.cp_bg_line_d));
        am.c(this.cUF, f.C0146f.icon_input_search);
        am.h(this.cUE, f.d.cp_cont_d);
        am.j(this.bHc, f.d.cp_bg_line_e);
    }
}
