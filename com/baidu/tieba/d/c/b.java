package com.baidu.tieba.d.c;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.h;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d.a.f;
import com.baidu.tieba.r;
import com.baidu.tieba.s;
import com.baidu.tieba.t;
import com.baidu.tieba.u;
import com.baidu.tieba.x;
import java.util.Date;
/* loaded from: classes.dex */
public class b extends a {
    protected TbImageView j;
    protected TextView k;
    protected ViewGroup l;

    public b(View view) {
        super(view);
        this.c = (TextView) view.findViewById(u.recommend_title);
        this.e = (HeadImageView) view.findViewById(u.recommend_icon);
        this.b = (TextView) view.findViewById(u.recommend_btn);
        this.d = (TextView) view.findViewById(u.recommend_content);
        this.j = (TbImageView) view.findViewById(u.recommend_img);
        this.k = (TextView) view.findViewById(u.recommend_time);
        this.f = view.findViewById(u.divider_line);
        this.l = (ViewGroup) view.findViewById(u.layout);
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
            if (!h.a().d()) {
                ViewGroup.LayoutParams layoutParams = this.e.getLayoutParams();
                layoutParams.width = (int) this.a.getResources().getDimension(s.ds30);
                this.e.setLayoutParams(layoutParams);
                this.e.setVisibility(4);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.l.getLayoutParams();
                marginLayoutParams.leftMargin = (int) this.a.getResources().getDimension(s.ds50);
                this.l.setLayoutParams(marginLayoutParams);
            } else {
                ViewGroup.LayoutParams layoutParams2 = this.e.getLayoutParams();
                layoutParams2.width = (int) this.a.getResources().getDimension(s.ds60);
                this.e.setLayoutParams(layoutParams2);
                this.e.setVisibility(0);
                if (!TextUtils.isEmpty(fVar.k_())) {
                    this.e.a(fVar.k_(), z ? 17 : 18, false);
                }
                ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.l.getLayoutParams();
                marginLayoutParams2.leftMargin = (int) this.a.getResources().getDimension(s.ds80);
                this.l.setLayoutParams(marginLayoutParams2);
            }
            String e = ba.e(new Date(fVar.m_()));
            if (e == null) {
                e = "";
            }
            this.k.setText(e);
            if (StringUtils.isNull(fVar.f())) {
                this.d.setVisibility(8);
            } else {
                this.d.setVisibility(0);
                this.d.setText(a(fVar.f()));
            }
            ViewGroup.LayoutParams layoutParams3 = this.j.getLayoutParams();
            layoutParams3.width = (int) (this.a.getResources().getDimension(s.ds594) - this.a.getResources().getDimension(s.ds20));
            layoutParams3.height = (int) (this.a.getResources().getDimension(s.ds260) - this.a.getResources().getDimension(s.ds10));
            this.j.setLayoutParams(layoutParams3);
            if (!StringUtils.isNull(fVar.l_()) && h.a().f()) {
                this.j.setVisibility(0);
                this.j.a(fVar.l_(), z ? 17 : 18, false);
            } else {
                this.j.setVisibility(8);
            }
            this.b.setTag(this);
            this.a.setBackgroundDrawable(null);
            b();
            if (fVar.u()) {
                this.b.setVisibility(8);
            } else {
                this.b.setVisibility(0);
            }
        }
    }

    @Override // com.baidu.tieba.d.c.a
    protected void c() {
        if (this.b != null && this.a != null) {
            if (this.g == 1) {
                this.b.setBackgroundResource(t.btn_appdownload_1);
                this.b.setTextColor(this.a.getResources().getColor(r.cp_cont_i_1));
                return;
            }
            this.b.setBackgroundResource(t.btn_appdownload);
            this.b.setTextColor(this.a.getResources().getColor(r.cp_cont_i));
        }
    }

    @Override // com.baidu.tieba.d.c.a
    protected void d() {
        if (this.b != null && this.a != null) {
            if (this.g == 1) {
                this.b.setBackgroundResource(t.btn_content_download_d_1);
                this.b.setTextColor(this.a.getResources().getColor(r.faceshop_downloaded_text_1));
                return;
            }
            this.b.setBackgroundResource(t.btn_content_download_d);
            this.b.setTextColor(this.a.getResources().getColor(r.faceshop_downloaded_text));
        }
    }

    @Override // com.baidu.tieba.d.c.a
    protected int e() {
        return x.pb_app_download;
    }
}
