package com.baidu.tbadk.l;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.lib.util.k;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class a extends v.a {
    private TextView bTY;
    private View cmm;
    private View cmn;
    private HeadImageView cmo;
    private ImageView cmp;
    private TbPageContext mPageContext;

    public a(View view, TbPageContext tbPageContext) {
        super(view);
        this.mPageContext = tbPageContext;
        this.cmm = view.findViewById(d.g.ala_follow_left_space);
        this.cmn = view.findViewById(d.g.ala_follow_right_space);
        this.cmo = (HeadImageView) view.findViewById(d.g.ala_follow_head_img);
        this.cmo.setDefaultResource(d.f.icon_default_avatar100_bg);
        this.cmo.setIsRound(true);
        this.cmo.setAutoChangeStyle(false);
        this.cmo.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.cmp = (ImageView) view.findViewById(d.g.ala_follow_living_img);
        this.bTY = (TextView) view.findViewById(d.g.ala_follow_user_name);
    }

    public void a(int i, com.baidu.tbadk.data.a aVar) {
        if (aVar != null) {
            this.cmo.setImageDrawable(null);
            if (aVar.cgM == -100) {
                if (aVar.cgO > 0) {
                    al.c(this.cmo, aVar.cgO);
                } else {
                    al.c(this.cmo, d.f.icon_default_avatar100_bg);
                }
                this.cmo.setDrawBorder(false);
                if (!TextUtils.isEmpty(aVar.cgN)) {
                    this.bTY.setText(aVar.cgN);
                }
                this.cmp.setVisibility(8);
                this.cmn.getLayoutParams().width = this.mPageContext.getPageActivity().getResources().getDimensionPixelSize(d.e.tbds44);
                TiebaStatic.log("c12678");
            } else {
                if (aVar.cgL != null) {
                    this.cmo.startLoad(aVar.cgL.liveCover, 10, false);
                    this.cmo.setDrawBorder(true);
                    this.cmo.setBorderWidth(1);
                    this.cmo.setBorderColor(this.mPageContext.getPageActivity().getResources().getColor(d.C0277d.black_alpha15));
                    String str = aVar.cgL.userName;
                    if (!TextUtils.isEmpty(str)) {
                        if (k.bz(str) > 8) {
                            str = ap.g(str, 8, "...");
                        }
                        this.bTY.setText(str);
                    }
                }
                this.cmp.setVisibility(0);
                this.cmn.getLayoutParams().width = this.mPageContext.getPageActivity().getResources().getDimensionPixelSize(d.e.tbds26);
                TiebaStatic.log("c12676");
            }
            if (i == 0) {
                this.cmm.setVisibility(0);
            } else {
                this.cmm.setVisibility(8);
            }
            al.c(this.cmp, d.f.btn_story_live);
            al.j(this.bTY, d.C0277d.cp_cont_f);
        }
    }
}
