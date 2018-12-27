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
    private TextView aKV;
    private View bcc;
    private View bcd;
    private HeadImageView bce;
    private ImageView bcf;
    private TbPageContext mPageContext;

    public a(View view, TbPageContext tbPageContext) {
        super(view);
        this.mPageContext = tbPageContext;
        this.bcc = view.findViewById(e.g.ala_follow_left_space);
        this.bcd = view.findViewById(e.g.ala_follow_right_space);
        this.bce = (HeadImageView) view.findViewById(e.g.ala_follow_head_img);
        this.bce.setDefaultResource(e.f.icon_default_avatar100_bg);
        this.bce.setIsRound(true);
        this.bce.setAutoChangeStyle(false);
        this.bce.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.bcf = (ImageView) view.findViewById(e.g.ala_follow_living_img);
        this.aKV = (TextView) view.findViewById(e.g.ala_follow_user_name);
    }

    public void a(int i, com.baidu.tbadk.data.a aVar) {
        if (aVar != null) {
            this.bce.setImageDrawable(null);
            if (aVar.aWJ == -100) {
                if (aVar.aWL > 0) {
                    al.c(this.bce, aVar.aWL);
                } else {
                    al.c(this.bce, e.f.icon_default_avatar100_bg);
                }
                this.bce.setDrawBorder(false);
                if (!TextUtils.isEmpty(aVar.aWK)) {
                    this.aKV.setText(aVar.aWK);
                }
                this.bcf.setVisibility(8);
                this.bcd.getLayoutParams().width = this.mPageContext.getPageActivity().getResources().getDimensionPixelSize(e.C0210e.tbds44);
                TiebaStatic.log("c12678");
            } else {
                if (aVar.aWI != null) {
                    this.bce.startLoad(aVar.aWI.liveCover, 10, false);
                    this.bce.setDrawBorder(true);
                    this.bce.setBorderWidth(1);
                    this.bce.setBorderColor(this.mPageContext.getPageActivity().getResources().getColor(e.d.black_alpha15));
                    String str = aVar.aWI.userName;
                    if (!TextUtils.isEmpty(str)) {
                        if (k.bz(str) > 8) {
                            str = ao.d(str, 8, "...");
                        }
                        this.aKV.setText(str);
                    }
                }
                this.bcf.setVisibility(0);
                this.bcd.getLayoutParams().width = this.mPageContext.getPageActivity().getResources().getDimensionPixelSize(e.C0210e.tbds26);
                TiebaStatic.log("c12676");
            }
            if (i == 0) {
                this.bcc.setVisibility(0);
            } else {
                this.bcc.setVisibility(8);
            }
            al.c(this.bcf, e.f.btn_story_live);
            al.h(this.aKV, e.d.cp_cont_f);
        }
    }
}
