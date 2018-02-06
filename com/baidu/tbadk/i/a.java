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
    private TextView bfg;
    private View bws;
    private View bwt;
    private HeadImageView bwu;
    private ImageView bwv;
    private TbPageContext mPageContext;

    public a(View view, TbPageContext tbPageContext) {
        super(view);
        this.mPageContext = tbPageContext;
        this.bws = view.findViewById(d.g.ala_follow_left_space);
        this.bwt = view.findViewById(d.g.ala_follow_right_space);
        this.bwu = (HeadImageView) view.findViewById(d.g.ala_follow_head_img);
        this.bwu.setDefaultResource(d.f.icon_default_avatar100_bg);
        this.bwu.setIsRound(true);
        this.bwu.setAutoChangeStyle(false);
        this.bwu.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.bwv = (ImageView) view.findViewById(d.g.ala_follow_living_img);
        this.bfg = (TextView) view.findViewById(d.g.ala_follow_user_name);
    }

    public void a(int i, com.baidu.tbadk.data.a aVar) {
        if (aVar != null) {
            this.bwu.setImageDrawable(null);
            if (aVar.bqQ == -100) {
                if (aVar.bqS > 0) {
                    aj.c(this.bwu, aVar.bqS);
                } else {
                    aj.c(this.bwu, d.f.icon_default_avatar100_bg);
                }
                this.bwu.setDrawBorder(false);
                if (!TextUtils.isEmpty(aVar.bqR)) {
                    this.bfg.setText(aVar.bqR);
                }
                this.bwv.setVisibility(8);
                this.bwt.getLayoutParams().width = this.mPageContext.getPageActivity().getResources().getDimensionPixelSize(d.e.tbds44);
                TiebaStatic.log("c12678");
            } else {
                if (aVar.bqP != null) {
                    this.bwu.startLoad(aVar.bqP.liveCover, 10, false);
                    this.bwu.setDrawBorder(true);
                    this.bwu.setBorderWidth(1);
                    this.bwu.setBorderColor(this.mPageContext.getPageActivity().getResources().getColor(d.C0140d.black_alpha15));
                    String str = aVar.bqP.userName;
                    if (!TextUtils.isEmpty(str)) {
                        if (k.aX(str) > 8) {
                            str = am.e(str, 8, "...");
                        }
                        this.bfg.setText(str);
                    }
                }
                this.bwv.setVisibility(0);
                this.bwt.getLayoutParams().width = this.mPageContext.getPageActivity().getResources().getDimensionPixelSize(d.e.tbds26);
                TiebaStatic.log("c12676");
            }
            if (i == 0) {
                this.bws.setVisibility(0);
            } else {
                this.bws.setVisibility(8);
            }
            aj.c(this.bwv, d.f.btn_story_live);
            aj.r(this.bfg, d.C0140d.cp_cont_f);
        }
    }
}
