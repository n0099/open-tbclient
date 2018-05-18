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
    private View aGG;
    private View aGH;
    private HeadImageView aGI;
    private ImageView aGJ;
    private TextView aqm;
    private TbPageContext mPageContext;

    public a(View view2, TbPageContext tbPageContext) {
        super(view2);
        this.mPageContext = tbPageContext;
        this.aGG = view2.findViewById(d.g.ala_follow_left_space);
        this.aGH = view2.findViewById(d.g.ala_follow_right_space);
        this.aGI = (HeadImageView) view2.findViewById(d.g.ala_follow_head_img);
        this.aGI.setDefaultResource(d.f.icon_default_avatar100_bg);
        this.aGI.setIsRound(true);
        this.aGI.setAutoChangeStyle(false);
        this.aGI.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.aGJ = (ImageView) view2.findViewById(d.g.ala_follow_living_img);
        this.aqm = (TextView) view2.findViewById(d.g.ala_follow_user_name);
    }

    public void a(int i, com.baidu.tbadk.data.a aVar) {
        if (aVar != null) {
            this.aGI.setImageDrawable(null);
            if (aVar.aBg == -100) {
                if (aVar.aBi > 0) {
                    ak.c(this.aGI, aVar.aBi);
                } else {
                    ak.c(this.aGI, d.f.icon_default_avatar100_bg);
                }
                this.aGI.setDrawBorder(false);
                if (!TextUtils.isEmpty(aVar.aBh)) {
                    this.aqm.setText(aVar.aBh);
                }
                this.aGJ.setVisibility(8);
                this.aGH.getLayoutParams().width = this.mPageContext.getPageActivity().getResources().getDimensionPixelSize(d.e.tbds44);
                TiebaStatic.log("c12678");
            } else {
                if (aVar.aBf != null) {
                    this.aGI.startLoad(aVar.aBf.liveCover, 10, false);
                    this.aGI.setDrawBorder(true);
                    this.aGI.setBorderWidth(1);
                    this.aGI.setBorderColor(this.mPageContext.getPageActivity().getResources().getColor(d.C0126d.black_alpha15));
                    String str = aVar.aBf.userName;
                    if (!TextUtils.isEmpty(str)) {
                        if (k.aU(str) > 8) {
                            str = an.e(str, 8, "...");
                        }
                        this.aqm.setText(str);
                    }
                }
                this.aGJ.setVisibility(0);
                this.aGH.getLayoutParams().width = this.mPageContext.getPageActivity().getResources().getDimensionPixelSize(d.e.tbds26);
                TiebaStatic.log("c12676");
            }
            if (i == 0) {
                this.aGG.setVisibility(0);
            } else {
                this.aGG.setVisibility(8);
            }
            ak.c(this.aGJ, d.f.btn_story_live);
            ak.h(this.aqm, d.C0126d.cp_cont_f);
        }
    }
}
