package com.baidu.tbadk.i;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.lib.util.k;
import com.baidu.adp.widget.ListView.r;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class a extends r.a {
    private TextView bcZ;
    private View btP;
    private View btQ;
    private HeadImageView btR;
    private ImageView btS;
    private TbPageContext mPageContext;

    public a(View view, TbPageContext tbPageContext) {
        super(view);
        this.mPageContext = tbPageContext;
        this.btP = view.findViewById(d.g.ala_follow_left_space);
        this.btQ = view.findViewById(d.g.ala_follow_right_space);
        this.btR = (HeadImageView) view.findViewById(d.g.ala_follow_head_img);
        this.btR.setDefaultResource(d.f.icon_default_avatar100_bg);
        this.btR.setIsRound(true);
        this.btR.setAutoChangeStyle(false);
        this.btR.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.btS = (ImageView) view.findViewById(d.g.ala_follow_living_img);
        this.bcZ = (TextView) view.findViewById(d.g.ala_follow_user_name);
    }

    public void a(int i, com.baidu.tbadk.data.a aVar) {
        if (aVar != null) {
            this.btR.setImageDrawable(null);
            if (aVar.bok == -100) {
                if (aVar.bom > 0) {
                    aj.c(this.btR, aVar.bom);
                } else {
                    aj.c(this.btR, d.f.icon_default_avatar100_bg);
                }
                this.btR.setDrawBorder(false);
                if (!TextUtils.isEmpty(aVar.bol)) {
                    this.bcZ.setText(aVar.bol);
                }
                this.btS.setVisibility(8);
                this.btQ.getLayoutParams().width = this.mPageContext.getPageActivity().getResources().getDimensionPixelSize(d.e.tbds44);
                TiebaStatic.log("c12678");
            } else {
                if (aVar.boj != null) {
                    this.btR.startLoad(aVar.boj.liveCover, 10, false);
                    this.btR.setDrawBorder(true);
                    this.btR.setBorderWidth(1);
                    this.btR.setBorderColor(this.mPageContext.getPageActivity().getResources().getColor(d.C0108d.black_alpha15));
                    String str = aVar.boj.userName;
                    if (!TextUtils.isEmpty(str)) {
                        if (k.aX(str) > 8) {
                            str = am.e(str, 8, "...");
                        }
                        this.bcZ.setText(str);
                    }
                }
                this.btS.setVisibility(0);
                this.btQ.getLayoutParams().width = this.mPageContext.getPageActivity().getResources().getDimensionPixelSize(d.e.tbds26);
                TiebaStatic.log("c12676");
            }
            if (i == 0) {
                this.btP.setVisibility(0);
            } else {
                this.btP.setVisibility(8);
            }
            aj.c(this.btS, d.f.btn_story_live);
            aj.r(this.bcZ, d.C0108d.cp_cont_f);
        }
    }
}
