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
    private LinearLayout chE;
    private ViewEventCenter dlJ;
    private int dnV;
    private TextView dnW;
    private TextView dnX;
    private ImageView dnY;
    private a dnZ;

    public d(Context context) {
        this(context, null);
    }

    public d(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void aqm() {
        if (this.dnZ == null) {
            aqn();
        }
        if (this.dnZ.getParent() == null) {
            addView(this.dnZ);
        }
    }

    private void aqn() {
        this.dnZ = new a(getContext());
        this.dnZ.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        this.dnZ.setNumColumns(2);
        this.dnZ.setPadding(this.dnV, 0, this.dnV, 0);
        this.dnZ.setSelector(new ColorDrawable(0));
        this.dnZ.setCacheColorHint(0);
        this.dnZ.setFadingEdgeLength(0);
        this.dnZ.setFocusable(false);
        this.dnZ.setFocusableInTouchMode(false);
        this.dnZ.setVerticalScrollBarEnabled(false);
    }

    public void setSelectionFromTop(int i, int i2) {
        if (this.dnZ != null) {
            this.dnZ.setSelection(i);
            this.dnZ.setPadding(this.dnV, 0, this.dnV, 0);
        }
    }

    public void setGridAdapterIfNeeded(BaseAdapter baseAdapter) {
        if (this.dnZ != null && this.dnZ.getAdapter() != baseAdapter) {
            this.dnZ.setAdapter((ListAdapter) baseAdapter);
        }
    }

    public void setEventCenter(ViewEventCenter viewEventCenter) {
        this.dlJ = viewEventCenter;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        getParent().requestDisallowInterceptTouchEvent(true);
        return super.dispatchTouchEvent(motionEvent);
    }

    private void init() {
        this.dnV = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.tbds44);
        LayoutInflater.from(getContext()).inflate(d.h.enter_forum_edit_view, this);
        setOrientation(1);
        this.chE = (LinearLayout) findViewById(d.g.search_container);
        this.chE.setVisibility(0);
        this.dnW = (TextView) findViewById(d.g.view_edit_forum_ok);
        this.dnW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.b.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.dlJ != null) {
                    d.this.dlJ.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(3, null, null, null));
                }
            }
        });
        this.dnX = (TextView) findViewById(d.g.search_text);
        this.dnY = (ImageView) findViewById(d.g.search_icon);
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext) {
        com.baidu.tbadk.n.a.a(tbPageContext, this);
        setBackgroundColor(aj.getColor(d.C0107d.cp_bg_line_d));
        aj.c(this.dnY, d.f.icon_input_seach);
        aj.r(this.dnX, d.C0107d.enter_forum_search_text_color);
        aj.s(this.chE, d.f.enter_forum_search_frame);
    }
}
