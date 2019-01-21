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
    private LinearLayout caO;
    private ViewEventCenter drf;
    private int dtO;
    private TextView dtP;
    private TextView dtQ;
    private ImageView dtR;
    private DragGridView dtS;

    public ForumEditView(Context context) {
        this(context, null);
    }

    public ForumEditView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setColumnTypeAndRefeshView() {
        if (this.dtS == null) {
            axc();
        }
        if (this.dtS.getParent() == null) {
            addView(this.dtS);
        }
    }

    private void axc() {
        this.dtS = new DragGridView(getContext());
        this.dtS.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        this.dtS.setNumColumns(2);
        this.dtS.setPadding(this.dtO, 0, this.dtO, 0);
        this.dtS.setSelector(new ColorDrawable(0));
        this.dtS.setCacheColorHint(0);
        this.dtS.setFadingEdgeLength(0);
        this.dtS.setFocusable(false);
        this.dtS.setFocusableInTouchMode(false);
        this.dtS.setVerticalScrollBarEnabled(false);
    }

    public void setSelectionFromTop(int i, int i2) {
        if (this.dtS != null) {
            this.dtS.setSelection(i);
            this.dtS.setPadding(this.dtO, 0, this.dtO, 0);
        }
    }

    public void setGridAdapterIfNeeded(BaseAdapter baseAdapter) {
        if (this.dtS != null && this.dtS.getAdapter() != baseAdapter) {
            this.dtS.setAdapter((ListAdapter) baseAdapter);
        }
    }

    public void setEventCenter(ViewEventCenter viewEventCenter) {
        this.drf = viewEventCenter;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        getParent().requestDisallowInterceptTouchEvent(true);
        return super.dispatchTouchEvent(motionEvent);
    }

    private void init() {
        this.dtO = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0210e.tbds44);
        LayoutInflater.from(getContext()).inflate(e.h.enter_forum_edit_view, this);
        setOrientation(1);
        this.caO = (LinearLayout) findViewById(e.g.search_container);
        this.caO.setVisibility(0);
        this.dtP = (TextView) findViewById(e.g.view_edit_forum_ok);
        this.dtP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.ForumEditView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ForumEditView.this.drf != null) {
                    ForumEditView.this.drf.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(3, null, null, null));
                }
            }
        });
        this.dtQ = (TextView) findViewById(e.g.search_text);
        this.dtR = (ImageView) findViewById(e.g.search_icon);
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext) {
        com.baidu.tbadk.o.a.a(tbPageContext, this);
        setBackgroundColor(al.getColor(e.d.cp_bg_line_d));
        al.c(this.dtR, e.f.icon_input_search);
        al.h(this.dtQ, e.d.cp_cont_d);
        al.j(this.caO, e.d.cp_bg_line_e);
    }
}
