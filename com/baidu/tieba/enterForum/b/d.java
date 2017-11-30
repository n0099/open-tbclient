package com.baidu.tieba.enterForum.b;

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
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class d extends LinearLayout {
    private LinearLayout bua;
    private ViewEventCenter csw;
    private int cuL;
    private TextView cuM;
    private TextView cuN;
    private ImageView cuO;
    private a cuP;

    public d(Context context) {
        this(context, null);
    }

    public d(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void ahC() {
        if (this.cuP == null) {
            ahD();
        }
        if (this.cuP.getParent() == null) {
            addView(this.cuP);
        }
    }

    private void ahD() {
        this.cuP = new a(getContext());
        this.cuP.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        this.cuP.setNumColumns(2);
        this.cuP.setPadding(this.cuL, 0, this.cuL, 0);
        this.cuP.setSelector(new ColorDrawable(0));
        this.cuP.setCacheColorHint(0);
        this.cuP.setFadingEdgeLength(0);
        this.cuP.setFocusable(false);
        this.cuP.setFocusableInTouchMode(false);
        this.cuP.setVerticalScrollBarEnabled(false);
    }

    public void setSelectionFromTop(int i, int i2) {
        if (this.cuP != null) {
            this.cuP.setSelection(i);
            this.cuP.setPadding(this.cuL, 0, this.cuL, 0);
        }
    }

    public void setGridAdapterIfNeeded(BaseAdapter baseAdapter) {
        if (this.cuP != null && this.cuP.getAdapter() != baseAdapter) {
            this.cuP.setAdapter((ListAdapter) baseAdapter);
        }
    }

    public void setEventCenter(ViewEventCenter viewEventCenter) {
        this.csw = viewEventCenter;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        getParent().requestDisallowInterceptTouchEvent(true);
        return super.dispatchTouchEvent(motionEvent);
    }

    private void init() {
        this.cuL = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.tbds44);
        LayoutInflater.from(getContext()).inflate(d.h.enter_forum_edit_view, this);
        setOrientation(1);
        this.bua = (LinearLayout) findViewById(d.g.search_container);
        this.bua.setVisibility(0);
        this.cuM = (TextView) findViewById(d.g.view_edit_forum_ok);
        this.cuM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.b.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.csw != null) {
                    d.this.csw.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(3, null, null, null));
                }
            }
        });
        this.cuN = (TextView) findViewById(d.g.search_text);
        this.cuO = (ImageView) findViewById(d.g.search_icon);
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext) {
        com.baidu.tbadk.n.a.a(tbPageContext, this);
        setBackgroundColor(aj.getColor(d.C0082d.cp_bg_line_d));
        aj.c(this.cuO, d.f.icon_input_seach);
        aj.i(this.cuN, d.C0082d.enter_forum_search_text_color);
        aj.j(this.bua, d.f.enter_forum_search_frame);
    }
}
