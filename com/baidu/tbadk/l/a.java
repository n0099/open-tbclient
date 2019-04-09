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
    private TextView bUb;
    private View cmp;
    private View cmq;
    private HeadImageView cmr;
    private ImageView cms;
    private TbPageContext mPageContext;

    public a(View view, TbPageContext tbPageContext) {
        super(view);
        this.mPageContext = tbPageContext;
        this.cmp = view.findViewById(d.g.ala_follow_left_space);
        this.cmq = view.findViewById(d.g.ala_follow_right_space);
        this.cmr = (HeadImageView) view.findViewById(d.g.ala_follow_head_img);
        this.cmr.setDefaultResource(d.f.icon_default_avatar100_bg);
        this.cmr.setIsRound(true);
        this.cmr.setAutoChangeStyle(false);
        this.cmr.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.cms = (ImageView) view.findViewById(d.g.ala_follow_living_img);
        this.bUb = (TextView) view.findViewById(d.g.ala_follow_user_name);
    }

    public void a(int i, com.baidu.tbadk.data.a aVar) {
        if (aVar != null) {
            this.cmr.setImageDrawable(null);
            if (aVar.cgP == -100) {
                if (aVar.cgR > 0) {
                    al.c(this.cmr, aVar.cgR);
                } else {
                    al.c(this.cmr, d.f.icon_default_avatar100_bg);
                }
                this.cmr.setDrawBorder(false);
                if (!TextUtils.isEmpty(aVar.cgQ)) {
                    this.bUb.setText(aVar.cgQ);
                }
                this.cms.setVisibility(8);
                this.cmq.getLayoutParams().width = this.mPageContext.getPageActivity().getResources().getDimensionPixelSize(d.e.tbds44);
                TiebaStatic.log("c12678");
            } else {
                if (aVar.cgO != null) {
                    this.cmr.startLoad(aVar.cgO.liveCover, 10, false);
                    this.cmr.setDrawBorder(true);
                    this.cmr.setBorderWidth(1);
                    this.cmr.setBorderColor(this.mPageContext.getPageActivity().getResources().getColor(d.C0277d.black_alpha15));
                    String str = aVar.cgO.userName;
                    if (!TextUtils.isEmpty(str)) {
                        if (k.bz(str) > 8) {
                            str = ap.g(str, 8, "...");
                        }
                        this.bUb.setText(str);
                    }
                }
                this.cms.setVisibility(0);
                this.cmq.getLayoutParams().width = this.mPageContext.getPageActivity().getResources().getDimensionPixelSize(d.e.tbds26);
                TiebaStatic.log("c12676");
            }
            if (i == 0) {
                this.cmp.setVisibility(0);
            } else {
                this.cmp.setVisibility(8);
            }
            al.c(this.cms, d.f.btn_story_live);
            al.j(this.bUb, d.C0277d.cp_cont_f);
        }
    }
}
