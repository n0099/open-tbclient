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
/* loaded from: classes2.dex */
public class d extends LinearLayout {
    private LinearLayout clu;
    private ViewEventCenter doM;
    private int drb;
    private TextView drc;
    private TextView drd;
    private ImageView dre;
    private a drf;

    public d(Context context) {
        this(context, null);
    }

    public d(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void arh() {
        if (this.drf == null) {
            ari();
        }
        if (this.drf.getParent() == null) {
            addView(this.drf);
        }
    }

    private void ari() {
        this.drf = new a(getContext());
        this.drf.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        this.drf.setNumColumns(2);
        this.drf.setPadding(this.drb, 0, this.drb, 0);
        this.drf.setSelector(new ColorDrawable(0));
        this.drf.setCacheColorHint(0);
        this.drf.setFadingEdgeLength(0);
        this.drf.setFocusable(false);
        this.drf.setFocusableInTouchMode(false);
        this.drf.setVerticalScrollBarEnabled(false);
    }

    public void setSelectionFromTop(int i, int i2) {
        if (this.drf != null) {
            this.drf.setSelection(i);
            this.drf.setPadding(this.drb, 0, this.drb, 0);
        }
    }

    public void setGridAdapterIfNeeded(BaseAdapter baseAdapter) {
        if (this.drf != null && this.drf.getAdapter() != baseAdapter) {
            this.drf.setAdapter((ListAdapter) baseAdapter);
        }
    }

    public void setEventCenter(ViewEventCenter viewEventCenter) {
        this.doM = viewEventCenter;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        getParent().requestDisallowInterceptTouchEvent(true);
        return super.dispatchTouchEvent(motionEvent);
    }

    private void init() {
        this.drb = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.tbds44);
        LayoutInflater.from(getContext()).inflate(d.h.enter_forum_edit_view, this);
        setOrientation(1);
        this.clu = (LinearLayout) findViewById(d.g.search_container);
        this.clu.setVisibility(0);
        this.drc = (TextView) findViewById(d.g.view_edit_forum_ok);
        this.drc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.b.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.doM != null) {
                    d.this.doM.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(3, null, null, null));
                }
            }
        });
        this.drd = (TextView) findViewById(d.g.search_text);
        this.dre = (ImageView) findViewById(d.g.search_icon);
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext) {
        com.baidu.tbadk.n.a.a(tbPageContext, this);
        setBackgroundColor(aj.getColor(d.C0141d.cp_bg_line_d));
        aj.c(this.dre, d.f.icon_input_seach);
        aj.r(this.drd, d.C0141d.enter_forum_search_text_color);
        aj.s(this.clu, d.f.enter_forum_search_frame);
    }
}
