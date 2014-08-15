package com.baidu.tieba.guide;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.widget.TbImageView;
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
    private View g;
    private LinearLayout h;

    public e(Context context, int i) {
        super(context, i);
        this.a = context;
        b();
    }

    private void b() {
        this.g = View.inflate(this.a, com.baidu.tieba.v.new_user_box, null);
        setContentView(this.g);
        setCanceledOnTouchOutside(true);
        this.h = (LinearLayout) this.g.findViewById(com.baidu.tieba.u.box_close_layout);
        this.b = (TextView) this.g.findViewById(com.baidu.tieba.u.prompt_title);
        this.c = (TextView) this.g.findViewById(com.baidu.tieba.u.prompt_sub_title);
        this.d = this.g.findViewById(com.baidu.tieba.u.view_layout);
        this.e = (LinearLayout) findViewById(com.baidu.tieba.u.layout_content);
        this.d.setBackgroundDrawable(this.a.getResources().getDrawable(com.baidu.tieba.t.bg_startpage2_card_purple_up));
    }

    @Override // com.baidu.tieba.guide.a
    public void a(View.OnClickListener onClickListener) {
        this.f = onClickListener;
        this.h.setOnClickListener(onClickListener);
    }

    @Override // android.app.Dialog, com.baidu.tieba.guide.a
    public void hide() {
        if (this.a instanceof Activity) {
            com.baidu.adp.lib.e.d.b(this, (Activity) this.a);
        } else {
            super.dismiss();
        }
    }

    @Override // com.baidu.tieba.guide.a
    public void a(InterestFrsData.Tag tag) {
        this.b.setText(tag.getBname());
        this.c.setText(tag.getBdesc());
        ArrayList<InterestFrsData.Card> card_list = tag.getCard_list();
        int i = 0;
        while (i < card_list.size()) {
            InterestFrsData.Card card = card_list.get(i);
            View a = new f(this, card, this.f).a();
            this.e.addView(a);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) a.getLayoutParams();
            int dimensionPixelSize = this.a.getResources().getDimensionPixelSize(com.baidu.tieba.s.ds20);
            layoutParams.setMargins(0, i == 0 ? this.a.getResources().getDimensionPixelSize(com.baidu.tieba.s.ds44) : dimensionPixelSize, 0, dimensionPixelSize);
            a.setLayoutParams(layoutParams);
            if (i != card_list.size() - 1) {
                this.e.addView(LayoutInflater.from(this.a).inflate(com.baidu.tieba.v.new_user_line_item, (ViewGroup) null));
            }
            ((TbImageView) this.e.findViewWithTag(card.getAvatar())).a(card.getAvatar(), 10, false);
            i++;
        }
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        float dimensionPixelSize2 = getContext().getResources().getDisplayMetrics().heightPixels - getContext().getResources().getDimensionPixelSize(com.baidu.tieba.s.ds120);
        if ((getContext().getResources().getDimensionPixelSize(com.baidu.tieba.s.ds140) * card_list.size()) + getContext().getResources().getDimensionPixelSize(com.baidu.tieba.s.ds188) + getContext().getResources().getDimensionPixelSize(com.baidu.tieba.s.ds100) > dimensionPixelSize2) {
            attributes.height = (int) dimensionPixelSize2;
        }
    }

    @Override // com.baidu.tieba.guide.a
    public void a(int i) {
        View findViewWithTag = this.e.findViewWithTag(Integer.valueOf(i));
        if (findViewWithTag != null && (findViewWithTag instanceof LinearLayout)) {
            new f(this, findViewWithTag).a(true);
        }
    }

    @Override // com.baidu.tieba.guide.a
    public void b(int i) {
        View findViewWithTag = this.e.findViewWithTag(Integer.valueOf(i));
        if (findViewWithTag != null && (findViewWithTag instanceof LinearLayout)) {
            new f(this, findViewWithTag).a(false);
        }
    }

    @Override // com.baidu.tieba.guide.a
    public View a() {
        return this.g;
    }
}
