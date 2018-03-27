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
    private TextView beW;
    private View bwi;
    private View bwj;
    private HeadImageView bwk;
    private ImageView bwl;
    private TbPageContext mPageContext;

    public a(View view, TbPageContext tbPageContext) {
        super(view);
        this.mPageContext = tbPageContext;
        this.bwi = view.findViewById(d.g.ala_follow_left_space);
        this.bwj = view.findViewById(d.g.ala_follow_right_space);
        this.bwk = (HeadImageView) view.findViewById(d.g.ala_follow_head_img);
        this.bwk.setDefaultResource(d.f.icon_default_avatar100_bg);
        this.bwk.setIsRound(true);
        this.bwk.setAutoChangeStyle(false);
        this.bwk.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.bwl = (ImageView) view.findViewById(d.g.ala_follow_living_img);
        this.beW = (TextView) view.findViewById(d.g.ala_follow_user_name);
    }

    public void a(int i, com.baidu.tbadk.data.a aVar) {
        if (aVar != null) {
            this.bwk.setImageDrawable(null);
            if (aVar.bqG == -100) {
                if (aVar.bqI > 0) {
                    aj.c(this.bwk, aVar.bqI);
                } else {
                    aj.c(this.bwk, d.f.icon_default_avatar100_bg);
                }
                this.bwk.setDrawBorder(false);
                if (!TextUtils.isEmpty(aVar.bqH)) {
                    this.beW.setText(aVar.bqH);
                }
                this.bwl.setVisibility(8);
                this.bwj.getLayoutParams().width = this.mPageContext.getPageActivity().getResources().getDimensionPixelSize(d.e.tbds44);
                TiebaStatic.log("c12678");
            } else {
                if (aVar.bqF != null) {
                    this.bwk.startLoad(aVar.bqF.liveCover, 10, false);
                    this.bwk.setDrawBorder(true);
                    this.bwk.setBorderWidth(1);
                    this.bwk.setBorderColor(this.mPageContext.getPageActivity().getResources().getColor(d.C0141d.black_alpha15));
                    String str = aVar.bqF.userName;
                    if (!TextUtils.isEmpty(str)) {
                        if (k.aX(str) > 8) {
                            str = am.e(str, 8, "...");
                        }
                        this.beW.setText(str);
                    }
                }
                this.bwl.setVisibility(0);
                this.bwj.getLayoutParams().width = this.mPageContext.getPageActivity().getResources().getDimensionPixelSize(d.e.tbds26);
                TiebaStatic.log("c12676");
            }
            if (i == 0) {
                this.bwi.setVisibility(0);
            } else {
                this.bwi.setVisibility(8);
            }
            aj.c(this.bwl, d.f.btn_story_live);
            aj.r(this.beW, d.C0141d.cp_cont_f);
        }
    }
}
