package com.baidu.tbadk.i;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.lib.util.k;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class a extends q.a {
    private View aGF;
    private View aGG;
    private HeadImageView aGH;
    private ImageView aGI;
    private TextView aqm;
    private TbPageContext mPageContext;

    public a(View view2, TbPageContext tbPageContext) {
        super(view2);
        this.mPageContext = tbPageContext;
        this.aGF = view2.findViewById(d.g.ala_follow_left_space);
        this.aGG = view2.findViewById(d.g.ala_follow_right_space);
        this.aGH = (HeadImageView) view2.findViewById(d.g.ala_follow_head_img);
        this.aGH.setDefaultResource(d.f.icon_default_avatar100_bg);
        this.aGH.setIsRound(true);
        this.aGH.setAutoChangeStyle(false);
        this.aGH.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.aGI = (ImageView) view2.findViewById(d.g.ala_follow_living_img);
        this.aqm = (TextView) view2.findViewById(d.g.ala_follow_user_name);
    }

    public void a(int i, com.baidu.tbadk.data.a aVar) {
        if (aVar != null) {
            this.aGH.setImageDrawable(null);
            if (aVar.aBf == -100) {
                if (aVar.aBh > 0) {
                    ak.c(this.aGH, aVar.aBh);
                } else {
                    ak.c(this.aGH, d.f.icon_default_avatar100_bg);
                }
                this.aGH.setDrawBorder(false);
                if (!TextUtils.isEmpty(aVar.aBg)) {
                    this.aqm.setText(aVar.aBg);
                }
                this.aGI.setVisibility(8);
                this.aGG.getLayoutParams().width = this.mPageContext.getPageActivity().getResources().getDimensionPixelSize(d.e.tbds44);
                TiebaStatic.log("c12678");
            } else {
                if (aVar.aBe != null) {
                    this.aGH.startLoad(aVar.aBe.liveCover, 10, false);
                    this.aGH.setDrawBorder(true);
                    this.aGH.setBorderWidth(1);
                    this.aGH.setBorderColor(this.mPageContext.getPageActivity().getResources().getColor(d.C0126d.black_alpha15));
                    String str = aVar.aBe.userName;
                    if (!TextUtils.isEmpty(str)) {
                        if (k.aU(str) > 8) {
                            str = an.e(str, 8, "...");
                        }
                        this.aqm.setText(str);
                    }
                }
                this.aGI.setVisibility(0);
                this.aGG.getLayoutParams().width = this.mPageContext.getPageActivity().getResources().getDimensionPixelSize(d.e.tbds26);
                TiebaStatic.log("c12676");
            }
            if (i == 0) {
                this.aGF.setVisibility(0);
            } else {
                this.aGF.setVisibility(8);
            }
            ak.c(this.aGI, d.f.btn_story_live);
            ak.h(this.aqm, d.C0126d.cp_cont_f);
        }
    }
}
