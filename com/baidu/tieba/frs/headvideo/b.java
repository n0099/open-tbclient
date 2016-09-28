package com.baidu.tieba.frs.headvideo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.av;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class b extends com.baidu.tbadk.f.a {
    private TextView Wl;
    private ImageView cbh;

    public b(Context context) {
        this(context, com.baidu.adp.lib.util.k.e(context, r.e.ds96));
    }

    public b(Context context, int i) {
        super(LayoutInflater.from(context).inflate(r.h.forum_head_video_guide_view, (ViewGroup) null));
        this.cbh = (ImageView) this.ayL.findViewById(r.g.iv_show_img);
        this.Wl = (TextView) this.ayL.findViewById(r.g.tv_show_text);
        if (i > 0) {
            ViewGroup.LayoutParams layoutParams = this.cbh.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.topMargin = i;
                this.cbh.setLayoutParams(marginLayoutParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.f.a
    public void Ev() {
        onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
        this.ayL.setClickable(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.f.a
    public void Ew() {
        this.cbh.setBackgroundResource(0);
        this.cbh.setImageBitmap(null);
    }

    public void onChangeSkinType(int i) {
        av.c(this.cbh, r.f.iocn_video_tip, i);
        av.e(this.ayL, r.d.black_alpha40, i);
        av.c(this.Wl, r.d.cp_cont_g, 1);
    }

    public View EA() {
        return this.ayL;
    }
}
