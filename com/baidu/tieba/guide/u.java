package com.baidu.tieba.guide;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.editortool.ab;
import com.baidu.tieba.data.InterestFrsData;
import java.util.ArrayList;
/* loaded from: classes.dex */
public final class u extends Dialog implements a {
    private Context a;
    private TextView b;
    private TextView c;
    private View d;
    private LinearLayout e;
    private View.OnClickListener f;
    private LinearLayout g;
    private View h;

    public u(Context context, int i) {
        super(context, i);
        this.a = context;
        this.h = View.inflate(this.a, com.baidu.tieba.a.i.new_user_box, null);
        setContentView(this.h);
        setCanceledOnTouchOutside(true);
        this.g = (LinearLayout) this.h.findViewById(com.baidu.tieba.a.h.box_close_layout);
        this.b = (TextView) this.h.findViewById(com.baidu.tieba.a.h.prompt_title);
        this.c = (TextView) this.h.findViewById(com.baidu.tieba.a.h.prompt_sub_title);
        this.d = this.h.findViewById(com.baidu.tieba.a.h.view_layout);
        this.e = (LinearLayout) this.h.findViewById(com.baidu.tieba.a.h.layout_content);
        this.d.setBackgroundDrawable(this.a.getResources().getDrawable(com.baidu.tieba.a.g.bg_startpage2_card_blue_up));
    }

    @Override // com.baidu.tieba.guide.a
    public final void a(View.OnClickListener onClickListener) {
        this.f = onClickListener;
        this.g.setOnClickListener(onClickListener);
    }

    @Override // android.app.Dialog, com.baidu.tieba.guide.a
    public final void show() {
        super.show();
    }

    @Override // com.baidu.tieba.guide.a
    public final void a(InterestFrsData.Tag tag) {
        this.b.setText(tag.getBname());
        this.c.setText(tag.getBdesc());
        ArrayList<InterestFrsData.Card> card_list = tag.getCard_list();
        int i = 0;
        while (i < card_list.size()) {
            View view = new v(this, card_list.get(i), this.f).a;
            this.e.addView(view);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) view.getLayoutParams();
            int dimensionPixelSize = this.a.getResources().getDimensionPixelSize(com.baidu.tieba.a.f.ds40);
            layoutParams.setMargins(0, i == 0 ? this.a.getResources().getDimensionPixelSize(com.baidu.tieba.a.f.ds52) : dimensionPixelSize, 0, dimensionPixelSize);
            view.setLayoutParams(layoutParams);
            if (i != card_list.size() - 1) {
                this.e.addView(LayoutInflater.from(this.a).inflate(com.baidu.tieba.a.i.new_user_line_item, (ViewGroup) null));
            }
            i++;
        }
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        float dimensionPixelSize2 = getContext().getResources().getDisplayMetrics().heightPixels - getContext().getResources().getDimensionPixelSize(com.baidu.tieba.a.f.ds120);
        if ((getContext().getResources().getDimensionPixelSize(com.baidu.tieba.a.f.ds112) * card_list.size()) + getContext().getResources().getDimensionPixelSize(com.baidu.tieba.a.f.ds188) + getContext().getResources().getDimensionPixelSize(com.baidu.tieba.a.f.ds100) > dimensionPixelSize2) {
            attributes.height = (int) dimensionPixelSize2;
        }
    }

    @Override // com.baidu.tieba.guide.a
    public final void a(int i) {
        View findViewWithTag = this.e.findViewWithTag(Integer.valueOf(i));
        if (findViewWithTag != null && (findViewWithTag instanceof LinearLayout)) {
            new v(this, findViewWithTag).a(true);
        }
    }

    @Override // com.baidu.tieba.guide.a
    public final void b(int i) {
        View findViewWithTag = this.e.findViewWithTag(Integer.valueOf(i));
        if (findViewWithTag != null && (findViewWithTag instanceof LinearLayout)) {
            new v(this, findViewWithTag).a(false);
        }
    }

    @Override // com.baidu.tieba.guide.a
    public final View a() {
        return this.h;
    }

    @Override // com.baidu.tieba.guide.a
    public final void a(ab abVar) {
    }

    @Override // android.app.Dialog, com.baidu.tieba.guide.a
    public final void hide() {
        super.dismiss();
    }
}
