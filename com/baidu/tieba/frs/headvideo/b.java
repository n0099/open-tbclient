package com.baidu.tieba.frs.headvideo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.av;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class b extends com.baidu.tbadk.g.a {
    private TextView Wb;
    private ImageView cbf;

    public b(Context context) {
        this(context, com.baidu.adp.lib.util.k.e(context, t.e.ds96));
    }

    public b(Context context, int i) {
        super(LayoutInflater.from(context).inflate(t.h.forum_head_video_guide_view, (ViewGroup) null));
        this.cbf = (ImageView) this.azi.findViewById(t.g.iv_show_img);
        this.Wb = (TextView) this.azi.findViewById(t.g.tv_show_text);
        if (i > 0) {
            ViewGroup.LayoutParams layoutParams = this.cbf.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.topMargin = i;
                this.cbf.setLayoutParams(marginLayoutParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.g.a
    public void Ev() {
        onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
        this.azi.setClickable(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.g.a
    public void Ew() {
        this.cbf.setBackgroundResource(0);
        this.cbf.setImageBitmap(null);
    }

    public void onChangeSkinType(int i) {
        av.c(this.cbf, t.f.iocn_video_tip, i);
        av.e(this.azi, t.d.black_alpha40, i);
        av.c(this.Wb, t.d.cp_cont_g, 1);
    }

    public View EA() {
        return this.azi;
    }
}
