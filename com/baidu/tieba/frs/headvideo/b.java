package com.baidu.tieba.frs.headvideo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.av;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class b extends com.baidu.tbadk.g.a {
    private TextView Tl;
    private ImageView bPX;

    public b(Context context) {
        this(context, com.baidu.adp.lib.util.k.c(context, u.e.ds96));
    }

    public b(Context context, int i) {
        super(LayoutInflater.from(context).inflate(u.h.forum_head_video_guide_view, (ViewGroup) null));
        this.bPX = (ImageView) this.awb.findViewById(u.g.iv_show_img);
        this.Tl = (TextView) this.awb.findViewById(u.g.tv_show_text);
        if (i > 0) {
            ViewGroup.LayoutParams layoutParams = this.bPX.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.topMargin = i;
                this.bPX.setLayoutParams(marginLayoutParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.g.a
    public void Db() {
        onChangeSkinType(TbadkCoreApplication.m10getInst().getSkinType());
        this.awb.setClickable(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.g.a
    public void Dc() {
        this.bPX.setBackgroundResource(0);
        this.bPX.setImageBitmap(null);
    }

    public void onChangeSkinType(int i) {
        av.c(this.bPX, u.f.iocn_video_tip, i);
        av.e(this.awb, u.d.black_alpha40, i);
        av.c(this.Tl, u.d.cp_cont_g, 1);
    }

    public View Dg() {
        return this.awb;
    }
}
