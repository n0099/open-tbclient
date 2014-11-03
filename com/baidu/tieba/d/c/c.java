package com.baidu.tieba.d.c;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.l;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.d.a.f;
import com.baidu.tieba.s;
import com.baidu.tieba.t;
import com.baidu.tieba.u;
import com.baidu.tieba.v;
import com.baidu.tieba.y;
/* loaded from: classes.dex */
public class c extends a {
    public c(View view) {
        super(view);
        this.bHO = (TextView) view.findViewById(v.recommend_title);
        this.bHP = (TextView) view.findViewById(v.recommend_content);
        this.bHQ = (HeadImageView) view.findViewById(v.recommend_icon);
        this.bHN = (TextView) view.findViewById(v.recommend_btn);
        this.bHR = view.findViewById(v.divider_line);
        view.setTag(this);
    }

    @Override // com.baidu.tieba.d.c.a
    public void a(f fVar, int i, boolean z) {
        super.a(fVar, i, z);
        if (fVar != null) {
            this.bHO.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, aw.getDrawable(u.icon_extend), (Drawable) null);
            this.bHO.setText(fVar.abo());
            if (StringUtils.isNull(fVar.abq())) {
                this.bHP.setVisibility(8);
            } else {
                this.bHP.setVisibility(0);
                this.bHP.setText(hj(fVar.abq()));
            }
            if (!l.js().ju()) {
                ViewGroup.LayoutParams layoutParams = this.bHQ.getLayoutParams();
                layoutParams.width = (int) this.Xm.getResources().getDimension(t.ds30);
                this.bHQ.setLayoutParams(layoutParams);
                this.bHQ.setVisibility(4);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.bHP.getLayoutParams();
                marginLayoutParams.leftMargin = (int) this.Xm.getResources().getDimension(t.ds50);
                this.bHP.setLayoutParams(marginLayoutParams);
            } else {
                ViewGroup.LayoutParams layoutParams2 = this.bHQ.getLayoutParams();
                layoutParams2.width = (int) this.Xm.getResources().getDimension(t.ds60);
                this.bHQ.setLayoutParams(layoutParams2);
                this.bHQ.setVisibility(0);
                if (!TextUtils.isEmpty(fVar.abp())) {
                    this.bHQ.c(fVar.abp(), z ? 17 : 18, false);
                }
                ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.bHP.getLayoutParams();
                marginLayoutParams2.leftMargin = (int) this.Xm.getResources().getDimension(t.ds80);
                this.bHP.setLayoutParams(marginLayoutParams2);
            }
            this.bHN.setTag(this);
            this.Xm.setBackgroundDrawable(null);
            abE();
        }
    }

    @Override // com.baidu.tieba.d.c.a
    protected void abF() {
        if (this.bHN != null && this.Xm != null) {
            aw.h((View) this.bHN, u.frs_praise_btn_bg);
            aw.b(this.bHN, s.cp_cont_b, 1);
        }
    }

    @Override // com.baidu.tieba.d.c.a
    protected void abG() {
        if (this.bHN != null && this.Xm != null) {
            aw.h((View) this.bHN, u.frs_praise_btn_bg);
            aw.b(this.bHN, s.cp_cont_b, 1);
        }
    }

    @Override // com.baidu.tieba.d.c.a
    protected int abH() {
        return y.download;
    }
}
