package com.baidu.tbadk.i;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.lib.util.k;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class a extends q.a {
    private View aPZ;
    private View aQa;
    private HeadImageView aQb;
    private ImageView aQc;
    private TextView azm;
    private TbPageContext mPageContext;

    public a(View view, TbPageContext tbPageContext) {
        super(view);
        this.mPageContext = tbPageContext;
        this.aPZ = view.findViewById(d.g.ala_follow_left_space);
        this.aQa = view.findViewById(d.g.ala_follow_right_space);
        this.aQb = (HeadImageView) view.findViewById(d.g.ala_follow_head_img);
        this.aQb.setDefaultResource(d.f.icon_default_avatar100_bg);
        this.aQb.setIsRound(true);
        this.aQb.setAutoChangeStyle(false);
        this.aQb.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.aQc = (ImageView) view.findViewById(d.g.ala_follow_living_img);
        this.azm = (TextView) view.findViewById(d.g.ala_follow_user_name);
    }

    public void a(int i, com.baidu.tbadk.data.a aVar) {
        if (aVar != null) {
            this.aQb.setImageDrawable(null);
            if (aVar.aKy == -100) {
                if (aVar.aKA > 0) {
                    am.c(this.aQb, aVar.aKA);
                } else {
                    am.c(this.aQb, d.f.icon_default_avatar100_bg);
                }
                this.aQb.setDrawBorder(false);
                if (!TextUtils.isEmpty(aVar.aKz)) {
                    this.azm.setText(aVar.aKz);
                }
                this.aQc.setVisibility(8);
                this.aQa.getLayoutParams().width = this.mPageContext.getPageActivity().getResources().getDimensionPixelSize(d.e.tbds44);
                TiebaStatic.log("c12678");
            } else {
                if (aVar.aKx != null) {
                    this.aQb.startLoad(aVar.aKx.liveCover, 10, false);
                    this.aQb.setDrawBorder(true);
                    this.aQb.setBorderWidth(1);
                    this.aQb.setBorderColor(this.mPageContext.getPageActivity().getResources().getColor(d.C0142d.black_alpha15));
                    String str = aVar.aKx.userName;
                    if (!TextUtils.isEmpty(str)) {
                        if (k.bi(str) > 8) {
                            str = ap.e(str, 8, "...");
                        }
                        this.azm.setText(str);
                    }
                }
                this.aQc.setVisibility(0);
                this.aQa.getLayoutParams().width = this.mPageContext.getPageActivity().getResources().getDimensionPixelSize(d.e.tbds26);
                TiebaStatic.log("c12676");
            }
            if (i == 0) {
                this.aPZ.setVisibility(0);
            } else {
                this.aPZ.setVisibility(8);
            }
            am.c(this.aQc, d.f.btn_story_live);
            am.h(this.azm, d.C0142d.cp_cont_f);
        }
    }
}
