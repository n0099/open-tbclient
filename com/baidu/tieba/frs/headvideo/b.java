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
    private TextView SD;
    private ImageView bOm;

    public b(Context context) {
        this(context, com.baidu.adp.lib.util.k.c(context, u.e.ds96));
    }

    public b(Context context, int i) {
        super(LayoutInflater.from(context).inflate(u.h.forum_head_video_guide_view, (ViewGroup) null));
        this.bOm = (ImageView) this.avm.findViewById(u.g.iv_show_img);
        this.SD = (TextView) this.avm.findViewById(u.g.tv_show_text);
        if (i > 0) {
            ViewGroup.LayoutParams layoutParams = this.bOm.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.topMargin = i;
                this.bOm.setLayoutParams(marginLayoutParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.g.a
    public void Dc() {
        onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
        this.avm.setClickable(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.g.a
    public void Dd() {
        this.bOm.setBackgroundResource(0);
        this.bOm.setImageBitmap(null);
    }

    public void onChangeSkinType(int i) {
        av.b(this.bOm, u.f.iocn_video_tip, i);
        av.e(this.avm, u.d.black_alpha40, i);
        av.c(this.SD, u.d.cp_cont_g, 1);
    }

    public View Dh() {
        return this.avm;
    }
}
