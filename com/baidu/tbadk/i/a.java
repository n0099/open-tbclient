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
    private TextView beT;
    private View bwf;
    private View bwg;
    private HeadImageView bwh;
    private ImageView bwi;
    private TbPageContext mPageContext;

    public a(View view, TbPageContext tbPageContext) {
        super(view);
        this.mPageContext = tbPageContext;
        this.bwf = view.findViewById(d.g.ala_follow_left_space);
        this.bwg = view.findViewById(d.g.ala_follow_right_space);
        this.bwh = (HeadImageView) view.findViewById(d.g.ala_follow_head_img);
        this.bwh.setDefaultResource(d.f.icon_default_avatar100_bg);
        this.bwh.setIsRound(true);
        this.bwh.setAutoChangeStyle(false);
        this.bwh.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.bwi = (ImageView) view.findViewById(d.g.ala_follow_living_img);
        this.beT = (TextView) view.findViewById(d.g.ala_follow_user_name);
    }

    public void a(int i, com.baidu.tbadk.data.a aVar) {
        if (aVar != null) {
            this.bwh.setImageDrawable(null);
            if (aVar.bqD == -100) {
                if (aVar.bqF > 0) {
                    aj.c(this.bwh, aVar.bqF);
                } else {
                    aj.c(this.bwh, d.f.icon_default_avatar100_bg);
                }
                this.bwh.setDrawBorder(false);
                if (!TextUtils.isEmpty(aVar.bqE)) {
                    this.beT.setText(aVar.bqE);
                }
                this.bwi.setVisibility(8);
                this.bwg.getLayoutParams().width = this.mPageContext.getPageActivity().getResources().getDimensionPixelSize(d.e.tbds44);
                TiebaStatic.log("c12678");
            } else {
                if (aVar.bqC != null) {
                    this.bwh.startLoad(aVar.bqC.liveCover, 10, false);
                    this.bwh.setDrawBorder(true);
                    this.bwh.setBorderWidth(1);
                    this.bwh.setBorderColor(this.mPageContext.getPageActivity().getResources().getColor(d.C0141d.black_alpha15));
                    String str = aVar.bqC.userName;
                    if (!TextUtils.isEmpty(str)) {
                        if (k.aX(str) > 8) {
                            str = am.e(str, 8, "...");
                        }
                        this.beT.setText(str);
                    }
                }
                this.bwi.setVisibility(0);
                this.bwg.getLayoutParams().width = this.mPageContext.getPageActivity().getResources().getDimensionPixelSize(d.e.tbds26);
                TiebaStatic.log("c12676");
            }
            if (i == 0) {
                this.bwf.setVisibility(0);
            } else {
                this.bwf.setVisibility(8);
            }
            aj.c(this.bwi, d.f.btn_story_live);
            aj.r(this.beT, d.C0141d.cp_cont_f);
        }
    }
}
