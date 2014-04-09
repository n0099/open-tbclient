package com.baidu.tieba.frs.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.data.PraiseData;
import com.baidu.tieba.view.UserPhotoLayout;
/* loaded from: classes.dex */
public class FrsPraiseView extends LinearLayout {
    private Context a;
    private View b;
    private TextView c;
    private UserPhotoLayout d;
    private PraiseData e;
    private com.baidu.tbadk.core.util.b f;
    private String g;
    private String h;
    private boolean i;

    public FrsPraiseView(Context context) {
        super(context, null);
        this.i = false;
    }

    public FrsPraiseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.i = false;
        setOrientation(0);
        this.a = context;
        this.b = View.inflate(this.a, com.baidu.tieba.a.i.frs_item_praise, this);
        this.c = (TextView) this.b.findViewById(com.baidu.tieba.a.h.frs_go_praise_list_num);
        this.d = (UserPhotoLayout) this.b.findViewById(com.baidu.tieba.a.h.frs_go_praise_list_photo);
        setOnClickListener(new k(this));
        this.d.setOnChildClickListener(new l(this));
    }

    public void setImageLoad(com.baidu.tbadk.core.util.b bVar) {
        this.f = bVar;
        this.d.setImageLoad(this.f);
    }

    public final void a(PraiseData praiseData, String str, String str2, boolean z) {
        if (praiseData != null) {
            this.g = str;
            this.h = str2;
            this.e = praiseData;
            long num = this.e.getNum();
            if (num > 0) {
                if (num <= 6) {
                    this.c.setText(this.a.getString(com.baidu.tieba.a.k.common_praise_view_text));
                } else if (num <= 999999) {
                    this.c.setText(String.valueOf(this.a.getString(com.baidu.tieba.a.k.common_praise_view_text1)) + num + this.a.getString(com.baidu.tieba.a.k.common_praise_view_text2));
                } else {
                    this.c.setText(String.valueOf(this.a.getString(com.baidu.tieba.a.k.common_praise_view_text1)) + "999999+" + this.a.getString(com.baidu.tieba.a.k.common_praise_view_text2));
                }
            }
            this.d.a(this.e.getUser(), z);
        }
    }

    public void setIsFromPb(boolean z) {
        this.i = z;
    }

    public final void a(int i) {
        if (this.i) {
            if (i == 1) {
                this.b.setBackgroundResource(com.baidu.tieba.a.g.praise_head_selector_1);
                this.c.setTextColor(this.a.getResources().getColor(com.baidu.tieba.a.e.frs_praise_view_praise_num_1));
                return;
            }
            this.b.setBackgroundResource(com.baidu.tieba.a.g.praise_head_selector);
            this.c.setTextColor(this.a.getResources().getColor(com.baidu.tieba.a.e.frs_praise_view_praise_num));
        } else if (i == 1) {
            this.b.setBackgroundResource(com.baidu.tieba.a.g.praise_view_btn_color_1);
            this.c.setTextColor(this.a.getResources().getColor(com.baidu.tieba.a.e.frs_praise_view_praise_num_1));
        } else {
            this.b.setBackgroundResource(com.baidu.tieba.a.g.praise_view_btn_color);
            this.c.setTextColor(this.a.getResources().getColor(com.baidu.tieba.a.e.frs_praise_view_praise_num));
        }
    }
}
