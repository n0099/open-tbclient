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
/* loaded from: classes2.dex */
public class ForumEditView extends LinearLayout {
    private LinearLayout bMR;
    private ViewEventCenter cXw;
    private int dau;
    private TextView dav;
    private TextView daw;
    private ImageView dax;
    private DragGridView daz;

    public ForumEditView(Context context) {
        this(context, null);
    }

    public ForumEditView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setColumnTypeAndRefeshView() {
        if (this.daz == null) {
            ark();
        }
        if (this.daz.getParent() == null) {
            addView(this.daz);
        }
    }

    private void ark() {
        this.daz = new DragGridView(getContext());
        this.daz.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        this.daz.setNumColumns(2);
        this.daz.setPadding(this.dau, 0, this.dau, 0);
        this.daz.setSelector(new ColorDrawable(0));
        this.daz.setCacheColorHint(0);
        this.daz.setFadingEdgeLength(0);
        this.daz.setFocusable(false);
        this.daz.setFocusableInTouchMode(false);
        this.daz.setVerticalScrollBarEnabled(false);
    }

    public void setSelectionFromTop(int i, int i2) {
        if (this.daz != null) {
            this.daz.setSelection(i);
            this.daz.setPadding(this.dau, 0, this.dau, 0);
        }
    }

    public void setGridAdapterIfNeeded(BaseAdapter baseAdapter) {
        if (this.daz != null && this.daz.getAdapter() != baseAdapter) {
            this.daz.setAdapter((ListAdapter) baseAdapter);
        }
    }

    public void setEventCenter(ViewEventCenter viewEventCenter) {
        this.cXw = viewEventCenter;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        getParent().requestDisallowInterceptTouchEvent(true);
        return super.dispatchTouchEvent(motionEvent);
    }

    private void init() {
        this.dau = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0141e.tbds44);
        LayoutInflater.from(getContext()).inflate(e.h.enter_forum_edit_view, this);
        setOrientation(1);
        this.bMR = (LinearLayout) findViewById(e.g.search_container);
        this.bMR.setVisibility(0);
        this.dav = (TextView) findViewById(e.g.view_edit_forum_ok);
        this.dav.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.ForumEditView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ForumEditView.this.cXw != null) {
                    ForumEditView.this.cXw.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(3, null, null, null));
                }
            }
        });
        this.daw = (TextView) findViewById(e.g.search_text);
        this.dax = (ImageView) findViewById(e.g.search_icon);
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext) {
        com.baidu.tbadk.o.a.a(tbPageContext, this);
        setBackgroundColor(al.getColor(e.d.cp_bg_line_d));
        al.c(this.dax, e.f.icon_input_search);
        al.h(this.daw, e.d.cp_cont_d);
        al.j(this.bMR, e.d.cp_bg_line_e);
    }
}
