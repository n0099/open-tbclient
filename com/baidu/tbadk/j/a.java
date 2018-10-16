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
    private TextView aGD;
    private View aXN;
    private View aXO;
    private HeadImageView aXP;
    private ImageView aXQ;
    private TbPageContext mPageContext;

    public a(View view, TbPageContext tbPageContext) {
        super(view);
        this.mPageContext = tbPageContext;
        this.aXN = view.findViewById(e.g.ala_follow_left_space);
        this.aXO = view.findViewById(e.g.ala_follow_right_space);
        this.aXP = (HeadImageView) view.findViewById(e.g.ala_follow_head_img);
        this.aXP.setDefaultResource(e.f.icon_default_avatar100_bg);
        this.aXP.setIsRound(true);
        this.aXP.setAutoChangeStyle(false);
        this.aXP.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.aXQ = (ImageView) view.findViewById(e.g.ala_follow_living_img);
        this.aGD = (TextView) view.findViewById(e.g.ala_follow_user_name);
    }

    public void a(int i, com.baidu.tbadk.data.a aVar) {
        if (aVar != null) {
            this.aXP.setImageDrawable(null);
            if (aVar.aSt == -100) {
                if (aVar.aSv > 0) {
                    al.c(this.aXP, aVar.aSv);
                } else {
                    al.c(this.aXP, e.f.icon_default_avatar100_bg);
                }
                this.aXP.setDrawBorder(false);
                if (!TextUtils.isEmpty(aVar.aSu)) {
                    this.aGD.setText(aVar.aSu);
                }
                this.aXQ.setVisibility(8);
                this.aXO.getLayoutParams().width = this.mPageContext.getPageActivity().getResources().getDimensionPixelSize(e.C0175e.tbds44);
                TiebaStatic.log("c12678");
            } else {
                if (aVar.aSs != null) {
                    this.aXP.startLoad(aVar.aSs.liveCover, 10, false);
                    this.aXP.setDrawBorder(true);
                    this.aXP.setBorderWidth(1);
                    this.aXP.setBorderColor(this.mPageContext.getPageActivity().getResources().getColor(e.d.black_alpha15));
                    String str = aVar.aSs.userName;
                    if (!TextUtils.isEmpty(str)) {
                        if (k.bz(str) > 8) {
                            str = ao.d(str, 8, "...");
                        }
                        this.aGD.setText(str);
                    }
                }
                this.aXQ.setVisibility(0);
                this.aXO.getLayoutParams().width = this.mPageContext.getPageActivity().getResources().getDimensionPixelSize(e.C0175e.tbds26);
                TiebaStatic.log("c12676");
            }
            if (i == 0) {
                this.aXN.setVisibility(0);
            } else {
                this.aXN.setVisibility(8);
            }
            al.c(this.aXQ, e.f.btn_story_live);
            al.h(this.aGD, e.d.cp_cont_f);
        }
    }
}
