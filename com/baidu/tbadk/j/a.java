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
    private TextView aLx;
    private View bcM;
    private View bcN;
    private HeadImageView bcO;
    private ImageView bcP;
    private TbPageContext mPageContext;

    public a(View view, TbPageContext tbPageContext) {
        super(view);
        this.mPageContext = tbPageContext;
        this.bcM = view.findViewById(e.g.ala_follow_left_space);
        this.bcN = view.findViewById(e.g.ala_follow_right_space);
        this.bcO = (HeadImageView) view.findViewById(e.g.ala_follow_head_img);
        this.bcO.setDefaultResource(e.f.icon_default_avatar100_bg);
        this.bcO.setIsRound(true);
        this.bcO.setAutoChangeStyle(false);
        this.bcO.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.bcP = (ImageView) view.findViewById(e.g.ala_follow_living_img);
        this.aLx = (TextView) view.findViewById(e.g.ala_follow_user_name);
    }

    public void a(int i, com.baidu.tbadk.data.a aVar) {
        if (aVar != null) {
            this.bcO.setImageDrawable(null);
            if (aVar.aXr == -100) {
                if (aVar.aXt > 0) {
                    al.c(this.bcO, aVar.aXt);
                } else {
                    al.c(this.bcO, e.f.icon_default_avatar100_bg);
                }
                this.bcO.setDrawBorder(false);
                if (!TextUtils.isEmpty(aVar.aXs)) {
                    this.aLx.setText(aVar.aXs);
                }
                this.bcP.setVisibility(8);
                this.bcN.getLayoutParams().width = this.mPageContext.getPageActivity().getResources().getDimensionPixelSize(e.C0210e.tbds44);
                TiebaStatic.log("c12678");
            } else {
                if (aVar.aXq != null) {
                    this.bcO.startLoad(aVar.aXq.liveCover, 10, false);
                    this.bcO.setDrawBorder(true);
                    this.bcO.setBorderWidth(1);
                    this.bcO.setBorderColor(this.mPageContext.getPageActivity().getResources().getColor(e.d.black_alpha15));
                    String str = aVar.aXq.userName;
                    if (!TextUtils.isEmpty(str)) {
                        if (k.bz(str) > 8) {
                            str = ao.d(str, 8, "...");
                        }
                        this.aLx.setText(str);
                    }
                }
                this.bcP.setVisibility(0);
                this.bcN.getLayoutParams().width = this.mPageContext.getPageActivity().getResources().getDimensionPixelSize(e.C0210e.tbds26);
                TiebaStatic.log("c12676");
            }
            if (i == 0) {
                this.bcM.setVisibility(0);
            } else {
                this.bcM.setVisibility(8);
            }
            al.c(this.bcP, e.f.btn_story_live);
            al.h(this.aLx, e.d.cp_cont_f);
        }
    }
}
