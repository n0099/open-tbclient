package com.baidu.tieba.d.c;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.k;
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
        this.bHA = (TextView) view.findViewById(v.recommend_title);
        this.bHB = (TextView) view.findViewById(v.recommend_content);
        this.bHC = (HeadImageView) view.findViewById(v.recommend_icon);
        this.bHz = (TextView) view.findViewById(v.recommend_btn);
        this.bHD = view.findViewById(v.divider_line);
        view.setTag(this);
    }

    @Override // com.baidu.tieba.d.c.a
    public void a(f fVar, int i, boolean z) {
        super.a(fVar, i, z);
        if (fVar != null) {
            this.bHA.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, aw.getDrawable(u.icon_extend), (Drawable) null);
            this.bHA.setText(fVar.abl());
            if (StringUtils.isNull(fVar.abn())) {
                this.bHB.setVisibility(8);
            } else {
                this.bHB.setVisibility(0);
                this.bHB.setText(hj(fVar.abn()));
            }
            if (!k.js().ju()) {
                ViewGroup.LayoutParams layoutParams = this.bHC.getLayoutParams();
                layoutParams.width = (int) this.Xi.getResources().getDimension(t.ds30);
                this.bHC.setLayoutParams(layoutParams);
                this.bHC.setVisibility(4);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.bHB.getLayoutParams();
                marginLayoutParams.leftMargin = (int) this.Xi.getResources().getDimension(t.ds50);
                this.bHB.setLayoutParams(marginLayoutParams);
            } else {
                ViewGroup.LayoutParams layoutParams2 = this.bHC.getLayoutParams();
                layoutParams2.width = (int) this.Xi.getResources().getDimension(t.ds60);
                this.bHC.setLayoutParams(layoutParams2);
                this.bHC.setVisibility(0);
                if (!TextUtils.isEmpty(fVar.abm())) {
                    this.bHC.c(fVar.abm(), z ? 17 : 18, false);
                }
                ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.bHB.getLayoutParams();
                marginLayoutParams2.leftMargin = (int) this.Xi.getResources().getDimension(t.ds80);
                this.bHB.setLayoutParams(marginLayoutParams2);
            }
            this.bHz.setTag(this);
            this.Xi.setBackgroundDrawable(null);
            abB();
        }
    }

    @Override // com.baidu.tieba.d.c.a
    protected void abC() {
        if (this.bHz != null && this.Xi != null) {
            aw.h((View) this.bHz, u.frs_praise_btn_bg);
            aw.b(this.bHz, s.cp_cont_b, 1);
        }
    }

    @Override // com.baidu.tieba.d.c.a
    protected void abD() {
        if (this.bHz != null && this.Xi != null) {
            aw.h((View) this.bHz, u.frs_praise_btn_bg);
            aw.b(this.bHz, s.cp_cont_b, 1);
        }
    }

    @Override // com.baidu.tieba.d.c.a
    protected int abE() {
        return y.download;
    }
}
