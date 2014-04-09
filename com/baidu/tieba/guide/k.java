package com.baidu.tieba.guide;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.tbadk.editortool.ab;
import com.baidu.tieba.data.InterestFrsData;
/* loaded from: classes.dex */
public final class k extends Dialog implements a {
    private Context a;
    private TextView b;
    private TextView c;
    private View d;
    private View e;
    private InterestFrsData.Tag f;
    private g g;
    private GridView h;
    private LinearLayout i;

    public k(Context context, int i) {
        super(context, i);
        this.a = context;
        this.e = View.inflate(this.a, com.baidu.tieba.a.i.new_user_img_box, null);
        this.g = new g(this.a);
        setCanceledOnTouchOutside(true);
        this.i = (LinearLayout) this.e.findViewById(com.baidu.tieba.a.h.box_close_layout);
        this.h = (GridView) this.e.findViewById(com.baidu.tieba.a.h.layout_content);
        this.h.setAdapter((ListAdapter) this.g);
        this.h.setSelector(com.baidu.tieba.a.e.transparent);
        setContentView(this.e);
        this.b = (TextView) this.e.findViewById(com.baidu.tieba.a.h.prompt_title);
        this.c = (TextView) this.e.findViewById(com.baidu.tieba.a.h.prompt_sub_title);
        this.d = this.e.findViewById(com.baidu.tieba.a.h.view_layout);
        this.d.setBackgroundDrawable(this.a.getResources().getDrawable(com.baidu.tieba.a.g.bg_startpage2_card_orange_up));
    }

    @Override // com.baidu.tieba.guide.a
    public final void a(InterestFrsData.Tag tag) {
        this.f = tag;
        if (this.f != null) {
            this.b.setText(tag.getBname());
            this.c.setText(tag.getBdesc());
            this.g.a(tag.getCard_list());
        }
    }

    @Override // com.baidu.tieba.guide.a
    public final void a(int i) {
        this.g.notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.guide.a
    public final void b(int i) {
        this.g.notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.guide.a
    public final void a(View.OnClickListener onClickListener) {
        this.i.setOnClickListener(onClickListener);
        this.g.a(onClickListener);
    }

    @Override // com.baidu.tieba.guide.a
    public final void a(ab abVar) {
        this.g.a(abVar);
    }

    @Override // com.baidu.tieba.guide.a
    public final View a() {
        return this.e;
    }

    @Override // android.app.Dialog, com.baidu.tieba.guide.a
    public final void hide() {
        super.dismiss();
    }
}
