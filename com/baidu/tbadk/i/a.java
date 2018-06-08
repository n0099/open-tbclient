package com.baidu.tbadk.i;

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
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class a extends q.a {
    private View aPd;
    private View aPe;
    private HeadImageView aPf;
    private ImageView aPg;
    private TextView ayt;
    private TbPageContext mPageContext;

    public a(View view, TbPageContext tbPageContext) {
        super(view);
        this.mPageContext = tbPageContext;
        this.aPd = view.findViewById(d.g.ala_follow_left_space);
        this.aPe = view.findViewById(d.g.ala_follow_right_space);
        this.aPf = (HeadImageView) view.findViewById(d.g.ala_follow_head_img);
        this.aPf.setDefaultResource(d.f.icon_default_avatar100_bg);
        this.aPf.setIsRound(true);
        this.aPf.setAutoChangeStyle(false);
        this.aPf.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.aPg = (ImageView) view.findViewById(d.g.ala_follow_living_img);
        this.ayt = (TextView) view.findViewById(d.g.ala_follow_user_name);
    }

    public void a(int i, com.baidu.tbadk.data.a aVar) {
        if (aVar != null) {
            this.aPf.setImageDrawable(null);
            if (aVar.aJB == -100) {
                if (aVar.aJD > 0) {
                    al.c(this.aPf, aVar.aJD);
                } else {
                    al.c(this.aPf, d.f.icon_default_avatar100_bg);
                }
                this.aPf.setDrawBorder(false);
                if (!TextUtils.isEmpty(aVar.aJC)) {
                    this.ayt.setText(aVar.aJC);
                }
                this.aPg.setVisibility(8);
                this.aPe.getLayoutParams().width = this.mPageContext.getPageActivity().getResources().getDimensionPixelSize(d.e.tbds44);
                TiebaStatic.log("c12678");
            } else {
                if (aVar.aJA != null) {
                    this.aPf.startLoad(aVar.aJA.liveCover, 10, false);
                    this.aPf.setDrawBorder(true);
                    this.aPf.setBorderWidth(1);
                    this.aPf.setBorderColor(this.mPageContext.getPageActivity().getResources().getColor(d.C0141d.black_alpha15));
                    String str = aVar.aJA.userName;
                    if (!TextUtils.isEmpty(str)) {
                        if (k.bg(str) > 8) {
                            str = ao.e(str, 8, "...");
                        }
                        this.ayt.setText(str);
                    }
                }
                this.aPg.setVisibility(0);
                this.aPe.getLayoutParams().width = this.mPageContext.getPageActivity().getResources().getDimensionPixelSize(d.e.tbds26);
                TiebaStatic.log("c12676");
            }
            if (i == 0) {
                this.aPd.setVisibility(0);
            } else {
                this.aPd.setVisibility(8);
            }
            al.c(this.aPg, d.f.btn_story_live);
            al.h(this.ayt, d.C0141d.cp_cont_f);
        }
    }
}
