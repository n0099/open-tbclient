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
    private TextView bdf;
    private View btY;
    private View btZ;
    private HeadImageView bua;
    private ImageView bub;
    private TbPageContext mPageContext;

    public a(View view, TbPageContext tbPageContext) {
        super(view);
        this.mPageContext = tbPageContext;
        this.btY = view.findViewById(d.g.ala_follow_left_space);
        this.btZ = view.findViewById(d.g.ala_follow_right_space);
        this.bua = (HeadImageView) view.findViewById(d.g.ala_follow_head_img);
        this.bua.setDefaultResource(d.f.icon_default_avatar100_bg);
        this.bua.setIsRound(true);
        this.bua.setAutoChangeStyle(false);
        this.bua.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.bub = (ImageView) view.findViewById(d.g.ala_follow_living_img);
        this.bdf = (TextView) view.findViewById(d.g.ala_follow_user_name);
    }

    public void a(int i, com.baidu.tbadk.data.a aVar) {
        if (aVar != null) {
            this.bua.setImageDrawable(null);
            if (aVar.bot == -100) {
                if (aVar.bov > 0) {
                    aj.c(this.bua, aVar.bov);
                } else {
                    aj.c(this.bua, d.f.icon_default_avatar100_bg);
                }
                this.bua.setDrawBorder(false);
                if (!TextUtils.isEmpty(aVar.bou)) {
                    this.bdf.setText(aVar.bou);
                }
                this.bub.setVisibility(8);
                this.btZ.getLayoutParams().width = this.mPageContext.getPageActivity().getResources().getDimensionPixelSize(d.e.tbds44);
                TiebaStatic.log("c12678");
            } else {
                if (aVar.bos != null) {
                    this.bua.startLoad(aVar.bos.liveCover, 10, false);
                    this.bua.setDrawBorder(true);
                    this.bua.setBorderWidth(1);
                    this.bua.setBorderColor(this.mPageContext.getPageActivity().getResources().getColor(d.C0107d.black_alpha15));
                    String str = aVar.bos.userName;
                    if (!TextUtils.isEmpty(str)) {
                        if (k.aX(str) > 8) {
                            str = am.e(str, 8, "...");
                        }
                        this.bdf.setText(str);
                    }
                }
                this.bub.setVisibility(0);
                this.btZ.getLayoutParams().width = this.mPageContext.getPageActivity().getResources().getDimensionPixelSize(d.e.tbds26);
                TiebaStatic.log("c12676");
            }
            if (i == 0) {
                this.btY.setVisibility(0);
            } else {
                this.btY.setVisibility(8);
            }
            aj.c(this.bub, d.f.btn_story_live);
            aj.r(this.bdf, d.C0107d.cp_cont_f);
        }
    }
}
