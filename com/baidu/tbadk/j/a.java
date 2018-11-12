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
    private TextView aHt;
    private View aYB;
    private View aYC;
    private HeadImageView aYD;
    private ImageView aYE;
    private TbPageContext mPageContext;

    public a(View view, TbPageContext tbPageContext) {
        super(view);
        this.mPageContext = tbPageContext;
        this.aYB = view.findViewById(e.g.ala_follow_left_space);
        this.aYC = view.findViewById(e.g.ala_follow_right_space);
        this.aYD = (HeadImageView) view.findViewById(e.g.ala_follow_head_img);
        this.aYD.setDefaultResource(e.f.icon_default_avatar100_bg);
        this.aYD.setIsRound(true);
        this.aYD.setAutoChangeStyle(false);
        this.aYD.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.aYE = (ImageView) view.findViewById(e.g.ala_follow_living_img);
        this.aHt = (TextView) view.findViewById(e.g.ala_follow_user_name);
    }

    public void a(int i, com.baidu.tbadk.data.a aVar) {
        if (aVar != null) {
            this.aYD.setImageDrawable(null);
            if (aVar.aTj == -100) {
                if (aVar.aTl > 0) {
                    al.c(this.aYD, aVar.aTl);
                } else {
                    al.c(this.aYD, e.f.icon_default_avatar100_bg);
                }
                this.aYD.setDrawBorder(false);
                if (!TextUtils.isEmpty(aVar.aTk)) {
                    this.aHt.setText(aVar.aTk);
                }
                this.aYE.setVisibility(8);
                this.aYC.getLayoutParams().width = this.mPageContext.getPageActivity().getResources().getDimensionPixelSize(e.C0200e.tbds44);
                TiebaStatic.log("c12678");
            } else {
                if (aVar.aTi != null) {
                    this.aYD.startLoad(aVar.aTi.liveCover, 10, false);
                    this.aYD.setDrawBorder(true);
                    this.aYD.setBorderWidth(1);
                    this.aYD.setBorderColor(this.mPageContext.getPageActivity().getResources().getColor(e.d.black_alpha15));
                    String str = aVar.aTi.userName;
                    if (!TextUtils.isEmpty(str)) {
                        if (k.bz(str) > 8) {
                            str = ao.d(str, 8, "...");
                        }
                        this.aHt.setText(str);
                    }
                }
                this.aYE.setVisibility(0);
                this.aYC.getLayoutParams().width = this.mPageContext.getPageActivity().getResources().getDimensionPixelSize(e.C0200e.tbds26);
                TiebaStatic.log("c12676");
            }
            if (i == 0) {
                this.aYB.setVisibility(0);
            } else {
                this.aYB.setVisibility(8);
            }
            al.c(this.aYE, e.f.btn_story_live);
            al.h(this.aHt, e.d.cp_cont_f);
        }
    }
}
