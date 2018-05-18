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
    private LinearLayout bwo;
    private ViewEventCenter cHX;
    private int cKN;
    private TextView cKO;
    private TextView cKP;
    private ImageView cKQ;
    private DragGridView cKR;

    public ForumEditView(Context context) {
        this(context, null);
    }

    public ForumEditView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setColumnTypeAndRefeshView() {
        if (this.cKR == null) {
            alv();
        }
        if (this.cKR.getParent() == null) {
            addView(this.cKR);
        }
    }

    private void alv() {
        this.cKR = new DragGridView(getContext());
        this.cKR.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        this.cKR.setNumColumns(2);
        this.cKR.setPadding(this.cKN, 0, this.cKN, 0);
        this.cKR.setSelector(new ColorDrawable(0));
        this.cKR.setCacheColorHint(0);
        this.cKR.setFadingEdgeLength(0);
        this.cKR.setFocusable(false);
        this.cKR.setFocusableInTouchMode(false);
        this.cKR.setVerticalScrollBarEnabled(false);
    }

    public void setSelectionFromTop(int i, int i2) {
        if (this.cKR != null) {
            this.cKR.setSelection(i);
            this.cKR.setPadding(this.cKN, 0, this.cKN, 0);
        }
    }

    public void setGridAdapterIfNeeded(BaseAdapter baseAdapter) {
        if (this.cKR != null && this.cKR.getAdapter() != baseAdapter) {
            this.cKR.setAdapter((ListAdapter) baseAdapter);
        }
    }

    public void setEventCenter(ViewEventCenter viewEventCenter) {
        this.cHX = viewEventCenter;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        getParent().requestDisallowInterceptTouchEvent(true);
        return super.dispatchTouchEvent(motionEvent);
    }

    private void init() {
        this.cKN = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.tbds44);
        LayoutInflater.from(getContext()).inflate(d.i.enter_forum_edit_view, this);
        setOrientation(1);
        this.bwo = (LinearLayout) findViewById(d.g.search_container);
        this.bwo.setVisibility(0);
        this.cKO = (TextView) findViewById(d.g.view_edit_forum_ok);
        this.cKO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.ForumEditView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (ForumEditView.this.cHX != null) {
                    ForumEditView.this.cHX.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(3, null, null, null));
                }
            }
        });
        this.cKP = (TextView) findViewById(d.g.search_text);
        this.cKQ = (ImageView) findViewById(d.g.search_icon);
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext) {
        com.baidu.tbadk.n.a.a(tbPageContext, this);
        setBackgroundColor(ak.getColor(d.C0126d.cp_bg_line_d));
        ak.c(this.cKQ, d.f.icon_input_seach);
        ak.h(this.cKP, d.C0126d.cp_cont_d);
        ak.j(this.bwo, d.C0126d.cp_bg_line_e);
    }
}
