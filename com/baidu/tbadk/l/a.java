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
    private TextView bUa;
    private View cmo;
    private View cmp;
    private HeadImageView cmq;
    private ImageView cmr;
    private TbPageContext mPageContext;

    public a(View view, TbPageContext tbPageContext) {
        super(view);
        this.mPageContext = tbPageContext;
        this.cmo = view.findViewById(d.g.ala_follow_left_space);
        this.cmp = view.findViewById(d.g.ala_follow_right_space);
        this.cmq = (HeadImageView) view.findViewById(d.g.ala_follow_head_img);
        this.cmq.setDefaultResource(d.f.icon_default_avatar100_bg);
        this.cmq.setIsRound(true);
        this.cmq.setAutoChangeStyle(false);
        this.cmq.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.cmr = (ImageView) view.findViewById(d.g.ala_follow_living_img);
        this.bUa = (TextView) view.findViewById(d.g.ala_follow_user_name);
    }

    public void a(int i, com.baidu.tbadk.data.a aVar) {
        if (aVar != null) {
            this.cmq.setImageDrawable(null);
            if (aVar.cgO == -100) {
                if (aVar.cgQ > 0) {
                    al.c(this.cmq, aVar.cgQ);
                } else {
                    al.c(this.cmq, d.f.icon_default_avatar100_bg);
                }
                this.cmq.setDrawBorder(false);
                if (!TextUtils.isEmpty(aVar.cgP)) {
                    this.bUa.setText(aVar.cgP);
                }
                this.cmr.setVisibility(8);
                this.cmp.getLayoutParams().width = this.mPageContext.getPageActivity().getResources().getDimensionPixelSize(d.e.tbds44);
                TiebaStatic.log("c12678");
            } else {
                if (aVar.cgN != null) {
                    this.cmq.startLoad(aVar.cgN.liveCover, 10, false);
                    this.cmq.setDrawBorder(true);
                    this.cmq.setBorderWidth(1);
                    this.cmq.setBorderColor(this.mPageContext.getPageActivity().getResources().getColor(d.C0277d.black_alpha15));
                    String str = aVar.cgN.userName;
                    if (!TextUtils.isEmpty(str)) {
                        if (k.bz(str) > 8) {
                            str = ap.g(str, 8, "...");
                        }
                        this.bUa.setText(str);
                    }
                }
                this.cmr.setVisibility(0);
                this.cmp.getLayoutParams().width = this.mPageContext.getPageActivity().getResources().getDimensionPixelSize(d.e.tbds26);
                TiebaStatic.log("c12676");
            }
            if (i == 0) {
                this.cmo.setVisibility(0);
            } else {
                this.cmo.setVisibility(8);
            }
            al.c(this.cmr, d.f.btn_story_live);
            al.j(this.bUa, d.C0277d.cp_cont_f);
        }
    }
}
