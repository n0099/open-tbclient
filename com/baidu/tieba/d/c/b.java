package com.baidu.tieba.d.c;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.k;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d.a.f;
import com.baidu.tieba.s;
import com.baidu.tieba.t;
import com.baidu.tieba.u;
import com.baidu.tieba.v;
import com.baidu.tieba.y;
/* loaded from: classes.dex */
public class b extends a {
    protected TbImageView bHF;
    protected TextView bHG;
    protected ViewGroup bHH;

    public b(View view) {
        super(view);
        this.bHA = (TextView) view.findViewById(v.recommend_title);
        this.bHC = (HeadImageView) view.findViewById(v.recommend_icon);
        this.bHz = (TextView) view.findViewById(v.recommend_btn);
        this.bHB = (TextView) view.findViewById(v.recommend_content);
        this.bHF = (TbImageView) view.findViewById(v.recommend_img);
        this.bHG = (TextView) view.findViewById(v.recommend_time);
        this.bHD = view.findViewById(v.divider_line);
        this.bHH = (ViewGroup) view.findViewById(v.layout);
    }

    @Override // com.baidu.tieba.d.c.a
    public void a(f fVar, int i, boolean z) {
        super.a(fVar, i, z);
        if (fVar != null) {
            this.bHA.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, aw.getDrawable(u.icon_extend), (Drawable) null);
            this.bHA.setText(fVar.abl());
            if (!k.js().ju()) {
                ViewGroup.LayoutParams layoutParams = this.bHC.getLayoutParams();
                layoutParams.width = (int) this.Xi.getResources().getDimension(t.ds30);
                this.bHC.setLayoutParams(layoutParams);
                this.bHC.setVisibility(4);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.bHH.getLayoutParams();
                marginLayoutParams.leftMargin = (int) this.Xi.getResources().getDimension(t.ds50);
                this.bHH.setLayoutParams(marginLayoutParams);
            } else {
                ViewGroup.LayoutParams layoutParams2 = this.bHC.getLayoutParams();
                layoutParams2.width = (int) this.Xi.getResources().getDimension(t.ds60);
                this.bHC.setLayoutParams(layoutParams2);
                this.bHC.setVisibility(0);
                if (!TextUtils.isEmpty(fVar.abm())) {
                    this.bHC.c(fVar.abm(), z ? 17 : 18, false);
                }
                ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.bHH.getLayoutParams();
                marginLayoutParams2.leftMargin = (int) this.Xi.getResources().getDimension(t.ds80);
                this.bHH.setLayoutParams(marginLayoutParams2);
            }
            String j = ay.j(fVar.abp());
            if (j == null) {
                j = "";
            }
            this.bHG.setText(j);
            if (StringUtils.isNull(fVar.abn())) {
                this.bHB.setVisibility(8);
            } else {
                this.bHB.setVisibility(0);
                this.bHB.setText(hj(fVar.abn()));
            }
            ViewGroup.LayoutParams layoutParams3 = this.bHF.getLayoutParams();
            layoutParams3.width = (int) (this.Xi.getResources().getDimension(t.ds594) - this.Xi.getResources().getDimension(t.ds20));
            layoutParams3.height = (int) (this.Xi.getResources().getDimension(t.ds260) - this.Xi.getResources().getDimension(t.ds10));
            this.bHF.setLayoutParams(layoutParams3);
            if (!StringUtils.isNull(fVar.abo()) && k.js().jw()) {
                this.bHF.setVisibility(0);
                this.bHF.c(fVar.abo(), z ? 17 : 18, false);
            } else {
                this.bHF.setVisibility(8);
            }
            this.bHz.setTag(this);
            this.Xi.setBackgroundDrawable(null);
            abB();
            if (fVar.abu()) {
                this.bHz.setVisibility(8);
            } else {
                this.bHz.setVisibility(0);
            }
        }
    }

    @Override // com.baidu.tieba.d.c.a
    protected void abC() {
        if (this.bHz != null && this.Xi != null) {
            aw.h((View) this.bHz, u.btn_appdownload);
            aw.b(this.bHz, s.cp_cont_i, 1);
        }
    }

    @Override // com.baidu.tieba.d.c.a
    protected void abD() {
        if (this.bHz != null && this.Xi != null) {
            aw.h((View) this.bHz, u.btn_content_download_d);
            aw.b(this.bHz, s.faceshop_downloaded_text, 1);
        }
    }

    @Override // com.baidu.tieba.d.c.a
    protected int abE() {
        return y.pb_app_download;
    }
}
