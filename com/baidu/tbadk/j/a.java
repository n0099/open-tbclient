package com.baidu.tbadk.j;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.lib.util.k;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.e;
/* loaded from: classes.dex */
public class a extends q.a {
    private TextView aKT;
    private View bbZ;
    private View bca;
    private HeadImageView bcb;
    private ImageView bcc;
    private TbPageContext mPageContext;

    public a(View view, TbPageContext tbPageContext) {
        super(view);
        this.mPageContext = tbPageContext;
        this.bbZ = view.findViewById(e.g.ala_follow_left_space);
        this.bca = view.findViewById(e.g.ala_follow_right_space);
        this.bcb = (HeadImageView) view.findViewById(e.g.ala_follow_head_img);
        this.bcb.setDefaultResource(e.f.icon_default_avatar100_bg);
        this.bcb.setIsRound(true);
        this.bcb.setAutoChangeStyle(false);
        this.bcb.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.bcc = (ImageView) view.findViewById(e.g.ala_follow_living_img);
        this.aKT = (TextView) view.findViewById(e.g.ala_follow_user_name);
    }

    public void a(int i, com.baidu.tbadk.data.a aVar) {
        if (aVar != null) {
            this.bcb.setImageDrawable(null);
            if (aVar.aWG == -100) {
                if (aVar.aWI > 0) {
                    al.c(this.bcb, aVar.aWI);
                } else {
                    al.c(this.bcb, e.f.icon_default_avatar100_bg);
                }
                this.bcb.setDrawBorder(false);
                if (!TextUtils.isEmpty(aVar.aWH)) {
                    this.aKT.setText(aVar.aWH);
                }
                this.bcc.setVisibility(8);
                this.bca.getLayoutParams().width = this.mPageContext.getPageActivity().getResources().getDimensionPixelSize(e.C0210e.tbds44);
                TiebaStatic.log("c12678");
            } else {
                if (aVar.aWF != null) {
                    this.bcb.startLoad(aVar.aWF.liveCover, 10, false);
                    this.bcb.setDrawBorder(true);
                    this.bcb.setBorderWidth(1);
                    this.bcb.setBorderColor(this.mPageContext.getPageActivity().getResources().getColor(e.d.black_alpha15));
                    String str = aVar.aWF.userName;
                    if (!TextUtils.isEmpty(str)) {
                        if (k.bz(str) > 8) {
                            str = ao.d(str, 8, "...");
                        }
                        this.aKT.setText(str);
                    }
                }
                this.bcc.setVisibility(0);
                this.bca.getLayoutParams().width = this.mPageContext.getPageActivity().getResources().getDimensionPixelSize(e.C0210e.tbds26);
                TiebaStatic.log("c12676");
            }
            if (i == 0) {
                this.bbZ.setVisibility(0);
            } else {
                this.bbZ.setVisibility(8);
            }
            al.c(this.bcc, e.f.btn_story_live);
            al.h(this.aKT, e.d.cp_cont_f);
        }
    }
}
