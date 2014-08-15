package com.baidu.tieba.frs.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.PraiseData;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class FrsPraiseView extends LinearLayout {
    private Context a;
    private View b;
    private TextView c;
    private TextView d;
    private TextView e;
    private PraiseData f;
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
        a();
    }

    private void a() {
        this.b = View.inflate(this.a, com.baidu.tieba.v.frs_item_praise, this);
        this.c = (TextView) this.b.findViewById(com.baidu.tieba.u.frs_go_praise_list_num);
        this.d = (TextView) this.b.findViewById(com.baidu.tieba.u.frs_praise_user_name_text1);
        this.e = (TextView) this.b.findViewById(com.baidu.tieba.u.frs_praise_user_name_text2);
        setOnClickListener(new k(this));
        this.e.setOnClickListener(new l(this));
        this.d.setOnClickListener(new m(this));
    }

    public void a(PraiseData praiseData, String str, String str2, boolean z) {
        if (praiseData != null) {
            this.g = str;
            this.h = str2;
            this.f = praiseData;
            a(z);
        }
    }

    public void setIsFromPb(boolean z) {
        this.i = z;
    }

    private void a(boolean z) {
        long num = this.f.getNum();
        this.e.setVisibility(8);
        this.d.setVisibility(8);
        if (num > 0) {
            ArrayList<MetaData> user = this.f.getUser();
            if (user != null && user.size() > 0) {
                if (user.size() == 1) {
                    if (user.get(0) != null) {
                        this.d.setVisibility(0);
                        this.d.setText(a(user.get(0).getName_show()));
                    }
                } else {
                    if (user.get(0) != null) {
                        this.d.setVisibility(0);
                        this.d.setText(a(user.get(0).getName_show()));
                    }
                    if (user.get(1) != null) {
                        this.e.setVisibility(0);
                        this.e.setText("、" + a(user.get(1).getName_show()));
                    }
                }
            }
            if (num <= 2) {
                this.c.setText(this.a.getString(com.baidu.tieba.x.common_praise_view_text));
            } else if (num <= 999999) {
                this.c.setText(String.valueOf(this.a.getString(com.baidu.tieba.x.common_praise_view_text1)) + num + this.a.getString(com.baidu.tieba.x.common_praise_view_text2));
            } else {
                this.c.setText(String.valueOf(this.a.getString(com.baidu.tieba.x.common_praise_view_text1)) + "999999+" + this.a.getString(com.baidu.tieba.x.common_praise_view_text2));
            }
        }
    }

    private String a(String str) {
        if (!TextUtils.isEmpty(str) && str.length() > 14) {
            return str.substring(0, 14);
        }
        return str;
    }

    public void a(int i) {
        if (this.i) {
            if (i == 1) {
                this.b.setBackgroundResource(com.baidu.tieba.t.praise_head_selector_1);
                this.c.setTextColor(this.a.getResources().getColor(com.baidu.tieba.r.cp_cont_d_1));
                this.d.setTextColor(this.a.getResources().getColor(com.baidu.tieba.r.cp_cont_c_1));
                this.e.setTextColor(this.a.getResources().getColor(com.baidu.tieba.r.cp_cont_c_1));
                return;
            }
            this.b.setBackgroundResource(com.baidu.tieba.t.praise_head_selector);
            this.c.setTextColor(this.a.getResources().getColor(com.baidu.tieba.r.cp_cont_d));
            this.d.setTextColor(this.a.getResources().getColor(com.baidu.tieba.r.cp_cont_c));
            this.e.setTextColor(this.a.getResources().getColor(com.baidu.tieba.r.cp_cont_c));
        } else if (i == 1) {
            this.b.setBackgroundResource(com.baidu.tieba.t.praise_view_btn_color_1);
            this.c.setTextColor(this.a.getResources().getColor(com.baidu.tieba.r.cp_cont_d_1));
            this.d.setTextColor(this.a.getResources().getColor(com.baidu.tieba.r.cp_cont_c_1));
            this.e.setTextColor(this.a.getResources().getColor(com.baidu.tieba.r.cp_cont_c_1));
        } else {
            this.b.setBackgroundResource(com.baidu.tieba.t.praise_view_btn_color);
            this.c.setTextColor(this.a.getResources().getColor(com.baidu.tieba.r.cp_cont_d));
            this.d.setTextColor(this.a.getResources().getColor(com.baidu.tieba.r.cp_cont_c));
            this.e.setTextColor(this.a.getResources().getColor(com.baidu.tieba.r.cp_cont_c));
        }
    }
}
