package com.baidu.tbadk.j;

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
import com.baidu.tieba.e;
/* loaded from: classes.dex */
public class a extends q.a {
    private TextView aBX;
    private View aTo;
    private View aTp;
    private HeadImageView aTq;
    private ImageView aTr;
    private TbPageContext mPageContext;

    public a(View view, TbPageContext tbPageContext) {
        super(view);
        this.mPageContext = tbPageContext;
        this.aTo = view.findViewById(e.g.ala_follow_left_space);
        this.aTp = view.findViewById(e.g.ala_follow_right_space);
        this.aTq = (HeadImageView) view.findViewById(e.g.ala_follow_head_img);
        this.aTq.setDefaultResource(e.f.icon_default_avatar100_bg);
        this.aTq.setIsRound(true);
        this.aTq.setAutoChangeStyle(false);
        this.aTq.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.aTr = (ImageView) view.findViewById(e.g.ala_follow_living_img);
        this.aBX = (TextView) view.findViewById(e.g.ala_follow_user_name);
    }

    public void a(int i, com.baidu.tbadk.data.a aVar) {
        if (aVar != null) {
            this.aTq.setImageDrawable(null);
            if (aVar.aNR == -100) {
                if (aVar.aNT > 0) {
                    al.c(this.aTq, aVar.aNT);
                } else {
                    al.c(this.aTq, e.f.icon_default_avatar100_bg);
                }
                this.aTq.setDrawBorder(false);
                if (!TextUtils.isEmpty(aVar.aNS)) {
                    this.aBX.setText(aVar.aNS);
                }
                this.aTr.setVisibility(8);
                this.aTp.getLayoutParams().width = this.mPageContext.getPageActivity().getResources().getDimensionPixelSize(e.C0141e.tbds44);
                TiebaStatic.log("c12678");
            } else {
                if (aVar.aNQ != null) {
                    this.aTq.startLoad(aVar.aNQ.liveCover, 10, false);
                    this.aTq.setDrawBorder(true);
                    this.aTq.setBorderWidth(1);
                    this.aTq.setBorderColor(this.mPageContext.getPageActivity().getResources().getColor(e.d.black_alpha15));
                    String str = aVar.aNQ.userName;
                    if (!TextUtils.isEmpty(str)) {
                        if (k.bA(str) > 8) {
                            str = ao.d(str, 8, "...");
                        }
                        this.aBX.setText(str);
                    }
                }
                this.aTr.setVisibility(0);
                this.aTp.getLayoutParams().width = this.mPageContext.getPageActivity().getResources().getDimensionPixelSize(e.C0141e.tbds26);
                TiebaStatic.log("c12676");
            }
            if (i == 0) {
                this.aTo.setVisibility(0);
            } else {
                this.aTo.setVisibility(8);
            }
            al.c(this.aTr, e.f.btn_story_live);
            al.h(this.aBX, e.d.cp_cont_f);
        }
    }
}
