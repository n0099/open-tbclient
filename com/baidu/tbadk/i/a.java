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
    private TextView bdn;
    private View bui;
    private View buj;
    private HeadImageView buk;
    private ImageView bul;
    private TbPageContext mPageContext;

    public a(View view, TbPageContext tbPageContext) {
        super(view);
        this.mPageContext = tbPageContext;
        this.bui = view.findViewById(d.g.ala_follow_left_space);
        this.buj = view.findViewById(d.g.ala_follow_right_space);
        this.buk = (HeadImageView) view.findViewById(d.g.ala_follow_head_img);
        this.buk.setDefaultResource(d.f.icon_default_avatar100_bg);
        this.buk.setIsRound(true);
        this.buk.setAutoChangeStyle(false);
        this.buk.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.bul = (ImageView) view.findViewById(d.g.ala_follow_living_img);
        this.bdn = (TextView) view.findViewById(d.g.ala_follow_user_name);
    }

    public void a(int i, com.baidu.tbadk.data.a aVar) {
        if (aVar != null) {
            this.buk.setImageDrawable(null);
            if (aVar.boC == -100) {
                if (aVar.boE > 0) {
                    aj.c(this.buk, aVar.boE);
                } else {
                    aj.c(this.buk, d.f.icon_default_avatar100_bg);
                }
                this.buk.setDrawBorder(false);
                if (!TextUtils.isEmpty(aVar.boD)) {
                    this.bdn.setText(aVar.boD);
                }
                this.bul.setVisibility(8);
                this.buj.getLayoutParams().width = this.mPageContext.getPageActivity().getResources().getDimensionPixelSize(d.e.tbds44);
                TiebaStatic.log("c12678");
            } else {
                if (aVar.boB != null) {
                    this.buk.startLoad(aVar.boB.liveCover, 10, false);
                    this.buk.setDrawBorder(true);
                    this.buk.setBorderWidth(1);
                    this.buk.setBorderColor(this.mPageContext.getPageActivity().getResources().getColor(d.C0108d.black_alpha15));
                    String str = aVar.boB.userName;
                    if (!TextUtils.isEmpty(str)) {
                        if (k.aX(str) > 8) {
                            str = am.e(str, 8, "...");
                        }
                        this.bdn.setText(str);
                    }
                }
                this.bul.setVisibility(0);
                this.buj.getLayoutParams().width = this.mPageContext.getPageActivity().getResources().getDimensionPixelSize(d.e.tbds26);
                TiebaStatic.log("c12676");
            }
            if (i == 0) {
                this.bui.setVisibility(0);
            } else {
                this.bui.setVisibility(8);
            }
            aj.c(this.bul, d.f.btn_story_live);
            aj.r(this.bdn, d.C0108d.cp_cont_f);
        }
    }
}
