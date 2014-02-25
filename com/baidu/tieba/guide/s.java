package com.baidu.tieba.guide;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tieba.data.InterestFrsData;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class s extends Dialog implements a {
    private Context a;
    private ImageView b;
    private TextView c;
    private TextView d;
    private View e;
    private LinearLayout f;
    private View.OnClickListener g;
    private LinearLayout h;
    private View i;

    public s(Context context, int i) {
        super(context, i);
        this.a = context;
        b();
    }

    private void b() {
        this.i = View.inflate(this.a, R.layout.new_user_box, null);
        setContentView(this.i);
        setCanceledOnTouchOutside(true);
        this.h = (LinearLayout) this.i.findViewById(R.id.box_close_layout);
        this.b = (ImageView) this.i.findViewById(R.id.box_close);
        this.c = (TextView) this.i.findViewById(R.id.prompt_title);
        this.d = (TextView) this.i.findViewById(R.id.prompt_sub_title);
        this.e = this.i.findViewById(R.id.view_layout);
        this.f = (LinearLayout) this.i.findViewById(R.id.layout_content);
        this.e.setBackgroundDrawable(this.a.getResources().getDrawable(R.drawable.bg_startpage2_card_blue_up));
    }

    @Override // com.baidu.tieba.guide.a
    public void a(View.OnClickListener onClickListener) {
        this.g = onClickListener;
        this.h.setOnClickListener(onClickListener);
    }

    @Override // com.baidu.tieba.guide.a
    public void a(InterestFrsData.Tag tag) {
        this.c.setText(tag.getBname());
        this.d.setText(tag.getBdesc());
        ArrayList<InterestFrsData.Card> card_list = tag.getCard_list();
        int i = 0;
        while (i < card_list.size()) {
            View a = new t(this, card_list.get(i), this.g).a();
            this.f.addView(a);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) a.getLayoutParams();
            int dimensionPixelSize = this.a.getResources().getDimensionPixelSize(R.dimen.ds40);
            layoutParams.setMargins(0, i == 0 ? this.a.getResources().getDimensionPixelSize(R.dimen.ds52) : dimensionPixelSize, 0, dimensionPixelSize);
            a.setLayoutParams(layoutParams);
            if (i != card_list.size() - 1) {
                this.f.addView(LayoutInflater.from(this.a).inflate(R.layout.new_user_line_item, (ViewGroup) null));
            }
            i++;
        }
    }

    @Override // com.baidu.tieba.guide.a
    public void a(int i) {
        View findViewWithTag = this.f.findViewWithTag(Integer.valueOf(i));
        if (findViewWithTag != null && (findViewWithTag instanceof LinearLayout)) {
            new t(this, findViewWithTag).a(true);
        }
    }

    @Override // com.baidu.tieba.guide.a
    public void b(int i) {
        View findViewWithTag = this.f.findViewWithTag(Integer.valueOf(i));
        if (findViewWithTag != null && (findViewWithTag instanceof LinearLayout)) {
            new t(this, findViewWithTag).a(false);
        }
    }

    @Override // com.baidu.tieba.guide.a
    public View a() {
        return this.i;
    }

    @Override // com.baidu.tieba.guide.a
    public void a(com.baidu.tieba.util.i iVar) {
    }
}
