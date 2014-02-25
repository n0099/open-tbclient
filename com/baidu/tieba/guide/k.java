package com.baidu.tieba.guide;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.tieba.data.InterestFrsData;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class k extends Dialog implements a {
    private Context a;
    private ImageView b;
    private TextView c;
    private TextView d;
    private View e;
    private View f;
    private InterestFrsData.Tag g;
    private g h;
    private GridView i;
    private LinearLayout j;

    public k(Context context, int i) {
        super(context, i);
        this.a = context;
        b();
    }

    private void b() {
        this.f = View.inflate(this.a, R.layout.new_user_img_box, null);
        this.h = new g(this.a);
        setCanceledOnTouchOutside(true);
        this.j = (LinearLayout) this.f.findViewById(R.id.box_close_layout);
        this.i = (GridView) this.f.findViewById(R.id.layout_content);
        this.i.setAdapter((ListAdapter) this.h);
        this.i.setSelector(R.color.transparent);
        setContentView(this.f);
        this.b = (ImageView) this.f.findViewById(R.id.box_close);
        this.c = (TextView) this.f.findViewById(R.id.prompt_title);
        this.d = (TextView) this.f.findViewById(R.id.prompt_sub_title);
        this.e = this.f.findViewById(R.id.view_layout);
        this.e.setBackgroundDrawable(this.a.getResources().getDrawable(R.drawable.bg_startpage2_card_orange_up));
    }

    @Override // com.baidu.tieba.guide.a
    public void a(InterestFrsData.Tag tag) {
        this.g = tag;
        if (this.g != null) {
            this.c.setText(tag.getBname());
            this.d.setText(tag.getBdesc());
            this.h.a(tag.getCard_list());
        }
    }

    @Override // com.baidu.tieba.guide.a
    public void a(int i) {
        this.h.notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.guide.a
    public void b(int i) {
        this.h.notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.guide.a
    public void a(View.OnClickListener onClickListener) {
        this.j.setOnClickListener(onClickListener);
        this.h.a(onClickListener);
    }

    @Override // com.baidu.tieba.guide.a
    public void a(com.baidu.tieba.util.i iVar) {
        this.h.a(iVar);
    }

    @Override // com.baidu.tieba.guide.a
    public View a() {
        return this.f;
    }
}
