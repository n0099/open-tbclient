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
    private TextView aLy;
    private View bcN;
    private View bcO;
    private HeadImageView bcP;
    private ImageView bcQ;
    private TbPageContext mPageContext;

    public a(View view, TbPageContext tbPageContext) {
        super(view);
        this.mPageContext = tbPageContext;
        this.bcN = view.findViewById(e.g.ala_follow_left_space);
        this.bcO = view.findViewById(e.g.ala_follow_right_space);
        this.bcP = (HeadImageView) view.findViewById(e.g.ala_follow_head_img);
        this.bcP.setDefaultResource(e.f.icon_default_avatar100_bg);
        this.bcP.setIsRound(true);
        this.bcP.setAutoChangeStyle(false);
        this.bcP.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.bcQ = (ImageView) view.findViewById(e.g.ala_follow_living_img);
        this.aLy = (TextView) view.findViewById(e.g.ala_follow_user_name);
    }

    public void a(int i, com.baidu.tbadk.data.a aVar) {
        if (aVar != null) {
            this.bcP.setImageDrawable(null);
            if (aVar.aXs == -100) {
                if (aVar.aXu > 0) {
                    al.c(this.bcP, aVar.aXu);
                } else {
                    al.c(this.bcP, e.f.icon_default_avatar100_bg);
                }
                this.bcP.setDrawBorder(false);
                if (!TextUtils.isEmpty(aVar.aXt)) {
                    this.aLy.setText(aVar.aXt);
                }
                this.bcQ.setVisibility(8);
                this.bcO.getLayoutParams().width = this.mPageContext.getPageActivity().getResources().getDimensionPixelSize(e.C0210e.tbds44);
                TiebaStatic.log("c12678");
            } else {
                if (aVar.aXr != null) {
                    this.bcP.startLoad(aVar.aXr.liveCover, 10, false);
                    this.bcP.setDrawBorder(true);
                    this.bcP.setBorderWidth(1);
                    this.bcP.setBorderColor(this.mPageContext.getPageActivity().getResources().getColor(e.d.black_alpha15));
                    String str = aVar.aXr.userName;
                    if (!TextUtils.isEmpty(str)) {
                        if (k.bz(str) > 8) {
                            str = ao.d(str, 8, "...");
                        }
                        this.aLy.setText(str);
                    }
                }
                this.bcQ.setVisibility(0);
                this.bcO.getLayoutParams().width = this.mPageContext.getPageActivity().getResources().getDimensionPixelSize(e.C0210e.tbds26);
                TiebaStatic.log("c12676");
            }
            if (i == 0) {
                this.bcN.setVisibility(0);
            } else {
                this.bcN.setVisibility(8);
            }
            al.c(this.bcQ, e.f.btn_story_live);
            al.h(this.aLy, e.d.cp_cont_f);
        }
    }
}
