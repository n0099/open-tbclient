package com.baidu.tbadk.j;

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
import com.baidu.tieba.f;
/* loaded from: classes.dex */
public class a extends q.a {
    private View aPW;
    private View aPX;
    private HeadImageView aPY;
    private ImageView aPZ;
    private TextView ayV;
    private TbPageContext mPageContext;

    public a(View view, TbPageContext tbPageContext) {
        super(view);
        this.mPageContext = tbPageContext;
        this.aPW = view.findViewById(f.g.ala_follow_left_space);
        this.aPX = view.findViewById(f.g.ala_follow_right_space);
        this.aPY = (HeadImageView) view.findViewById(f.g.ala_follow_head_img);
        this.aPY.setDefaultResource(f.C0146f.icon_default_avatar100_bg);
        this.aPY.setIsRound(true);
        this.aPY.setAutoChangeStyle(false);
        this.aPY.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.aPZ = (ImageView) view.findViewById(f.g.ala_follow_living_img);
        this.ayV = (TextView) view.findViewById(f.g.ala_follow_user_name);
    }

    public void a(int i, com.baidu.tbadk.data.a aVar) {
        if (aVar != null) {
            this.aPY.setImageDrawable(null);
            if (aVar.aKB == -100) {
                if (aVar.aKD > 0) {
                    am.c(this.aPY, aVar.aKD);
                } else {
                    am.c(this.aPY, f.C0146f.icon_default_avatar100_bg);
                }
                this.aPY.setDrawBorder(false);
                if (!TextUtils.isEmpty(aVar.aKC)) {
                    this.ayV.setText(aVar.aKC);
                }
                this.aPZ.setVisibility(8);
                this.aPX.getLayoutParams().width = this.mPageContext.getPageActivity().getResources().getDimensionPixelSize(f.e.tbds44);
                TiebaStatic.log("c12678");
            } else {
                if (aVar.aKA != null) {
                    this.aPY.startLoad(aVar.aKA.liveCover, 10, false);
                    this.aPY.setDrawBorder(true);
                    this.aPY.setBorderWidth(1);
                    this.aPY.setBorderColor(this.mPageContext.getPageActivity().getResources().getColor(f.d.black_alpha15));
                    String str = aVar.aKA.userName;
                    if (!TextUtils.isEmpty(str)) {
                        if (k.bj(str) > 8) {
                            str = ap.d(str, 8, "...");
                        }
                        this.ayV.setText(str);
                    }
                }
                this.aPZ.setVisibility(0);
                this.aPX.getLayoutParams().width = this.mPageContext.getPageActivity().getResources().getDimensionPixelSize(f.e.tbds26);
                TiebaStatic.log("c12676");
            }
            if (i == 0) {
                this.aPW.setVisibility(0);
            } else {
                this.aPW.setVisibility(8);
            }
            am.c(this.aPZ, f.C0146f.btn_story_live);
            am.h(this.ayV, f.d.cp_cont_f);
        }
    }
}
