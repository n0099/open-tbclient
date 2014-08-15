package com.baidu.tieba.d.c;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.h;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.d.a.f;
import com.baidu.tieba.r;
import com.baidu.tieba.s;
import com.baidu.tieba.t;
import com.baidu.tieba.u;
import com.baidu.tieba.x;
/* loaded from: classes.dex */
public class c extends a {
    public c(View view) {
        super(view);
        this.c = (TextView) view.findViewById(u.recommend_title);
        this.d = (TextView) view.findViewById(u.recommend_content);
        this.e = (HeadImageView) view.findViewById(u.recommend_icon);
        this.b = (TextView) view.findViewById(u.recommend_btn);
        this.f = view.findViewById(u.divider_line);
        view.setTag(this);
    }

    @Override // com.baidu.tieba.d.c.a
    public void a(f fVar, int i, boolean z) {
        super.a(fVar, i, z);
        if (fVar != null) {
            if (this.g == 1) {
                this.c.setCompoundDrawablesWithIntrinsicBounds(0, 0, t.icon_extend_1, 0);
            } else {
                this.c.setCompoundDrawablesWithIntrinsicBounds(0, 0, t.icon_extend, 0);
            }
            this.c.setText(fVar.j_());
            if (StringUtils.isNull(fVar.f())) {
                this.d.setVisibility(8);
            } else {
                this.d.setVisibility(0);
                this.d.setText(a(fVar.f()));
            }
            if (!h.a().d()) {
                ViewGroup.LayoutParams layoutParams = this.e.getLayoutParams();
                layoutParams.width = (int) this.a.getResources().getDimension(s.ds30);
                this.e.setLayoutParams(layoutParams);
                this.e.setVisibility(4);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.d.getLayoutParams();
                marginLayoutParams.leftMargin = (int) this.a.getResources().getDimension(s.ds50);
                this.d.setLayoutParams(marginLayoutParams);
            } else {
                ViewGroup.LayoutParams layoutParams2 = this.e.getLayoutParams();
                layoutParams2.width = (int) this.a.getResources().getDimension(s.ds60);
                this.e.setLayoutParams(layoutParams2);
                this.e.setVisibility(0);
                if (!TextUtils.isEmpty(fVar.k_())) {
                    this.e.a(fVar.k_(), z ? 17 : 18, false);
                }
                ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.d.getLayoutParams();
                marginLayoutParams2.leftMargin = (int) this.a.getResources().getDimension(s.ds80);
                this.d.setLayoutParams(marginLayoutParams2);
            }
            this.b.setTag(this);
            this.a.setBackgroundDrawable(null);
            b();
        }
    }

    @Override // com.baidu.tieba.d.c.a
    protected void c() {
        if (this.b != null && this.a != null) {
            if (this.g == 1) {
                this.b.setBackgroundResource(t.frs_praise_btn_bg_1);
                this.b.setTextColor(this.a.getResources().getColor(r.cp_cont_b_1));
                return;
            }
            this.b.setBackgroundResource(t.frs_praise_btn_bg);
            this.b.setTextColor(this.a.getResources().getColor(r.cp_cont_b));
        }
    }

    @Override // com.baidu.tieba.d.c.a
    protected void d() {
        if (this.b != null && this.a != null) {
            if (this.g == 1) {
                this.b.setBackgroundResource(t.frs_praise_btn_bg_1);
                this.b.setTextColor(this.a.getResources().getColor(r.cp_cont_b_1));
                return;
            }
            this.b.setBackgroundResource(t.frs_praise_btn_bg);
            this.b.setTextColor(this.a.getResources().getColor(r.cp_cont_b));
        }
    }

    @Override // com.baidu.tieba.d.c.a
    protected int e() {
        return x.download;
    }
}
