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
public class e extends Dialog implements a {
    private Context a;
    private TextView b;
    private TextView c;
    private View d;
    private LinearLayout e;
    private View.OnClickListener f;
    private ab g;
    private View h;
    private LinearLayout i;

    public e(Context context, int i) {
        super(context, i);
        this.a = context;
        b();
    }

    private void b() {
        this.h = View.inflate(this.a, com.baidu.tieba.s.new_user_box, null);
        setContentView(this.h);
        setCanceledOnTouchOutside(true);
        this.i = (LinearLayout) this.h.findViewById(com.baidu.tieba.r.box_close_layout);
        this.b = (TextView) this.h.findViewById(com.baidu.tieba.r.prompt_title);
        this.c = (TextView) this.h.findViewById(com.baidu.tieba.r.prompt_sub_title);
        this.d = this.h.findViewById(com.baidu.tieba.r.view_layout);
        this.e = (LinearLayout) findViewById(com.baidu.tieba.r.layout_content);
        this.d.setBackgroundDrawable(this.a.getResources().getDrawable(com.baidu.tieba.q.bg_startpage2_card_purple_up));
    }

    @Override // com.baidu.tieba.guide.a
    public void a(View.OnClickListener onClickListener) {
        this.f = onClickListener;
        this.i.setOnClickListener(onClickListener);
    }

    @Override // android.app.Dialog, com.baidu.tieba.guide.a
    public void hide() {
        super.dismiss();
    }

    @Override // com.baidu.tieba.guide.a
    public void a(InterestFrsData.Tag tag) {
        this.b.setText(tag.getBname());
        this.c.setText(tag.getBdesc());
        ArrayList<InterestFrsData.Card> card_list = tag.getCard_list();
        int i = 0;
        while (i < card_list.size()) {
            InterestFrsData.Card card = card_list.get(i);
            View a = new g(this, card, this.f).a();
            this.e.addView(a);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) a.getLayoutParams();
            int dimensionPixelSize = this.a.getResources().getDimensionPixelSize(com.baidu.tieba.p.ds20);
            layoutParams.setMargins(0, i == 0 ? this.a.getResources().getDimensionPixelSize(com.baidu.tieba.p.ds44) : dimensionPixelSize, 0, dimensionPixelSize);
            a.setLayoutParams(layoutParams);
            if (i != card_list.size() - 1) {
                this.e.addView(LayoutInflater.from(this.a).inflate(com.baidu.tieba.s.new_user_line_item, (ViewGroup) null));
            }
            this.g.b(card.getAvatar(), new f(this));
            i++;
        }
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        float dimensionPixelSize2 = getContext().getResources().getDisplayMetrics().heightPixels - getContext().getResources().getDimensionPixelSize(com.baidu.tieba.p.ds120);
        if ((getContext().getResources().getDimensionPixelSize(com.baidu.tieba.p.ds140) * card_list.size()) + getContext().getResources().getDimensionPixelSize(com.baidu.tieba.p.ds188) + getContext().getResources().getDimensionPixelSize(com.baidu.tieba.p.ds100) > dimensionPixelSize2) {
            attributes.height = (int) dimensionPixelSize2;
        }
    }

    @Override // com.baidu.tieba.guide.a
    public void a(int i) {
        View findViewWithTag = this.e.findViewWithTag(Integer.valueOf(i));
        if (findViewWithTag != null && (findViewWithTag instanceof LinearLayout)) {
            new g(this, findViewWithTag).a(true);
        }
    }

    @Override // com.baidu.tieba.guide.a
    public void b(int i) {
        View findViewWithTag = this.e.findViewWithTag(Integer.valueOf(i));
        if (findViewWithTag != null && (findViewWithTag instanceof LinearLayout)) {
            new g(this, findViewWithTag).a(false);
        }
    }

    @Override // com.baidu.tieba.guide.a
    public void a(ab abVar) {
        this.g = abVar;
    }

    @Override // com.baidu.tieba.guide.a
    public View a() {
        return this.h;
    }
}
