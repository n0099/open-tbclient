package com.baidu.tbadk.l;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.lib.util.k;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class a extends v.a {
    private TextView cdg;
    private View cvT;
    private View cvU;
    private HeadImageView cvV;
    private ImageView cvW;
    private TbPageContext mPageContext;

    public a(View view, TbPageContext tbPageContext) {
        super(view);
        this.mPageContext = tbPageContext;
        this.cvT = view.findViewById(R.id.ala_follow_left_space);
        this.cvU = view.findViewById(R.id.ala_follow_right_space);
        this.cvV = (HeadImageView) view.findViewById(R.id.ala_follow_head_img);
        this.cvV.setDefaultResource(R.drawable.icon_default_avatar100_bg);
        this.cvV.setIsRound(true);
        this.cvV.setAutoChangeStyle(false);
        this.cvV.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.cvW = (ImageView) view.findViewById(R.id.ala_follow_living_img);
        this.cdg = (TextView) view.findViewById(R.id.ala_follow_user_name);
    }

    public void a(int i, com.baidu.tbadk.data.a aVar) {
        if (aVar != null) {
            this.cvV.setImageDrawable(null);
            if (aVar.cqr == -100) {
                if (aVar.cqt > 0) {
                    am.c(this.cvV, aVar.cqt);
                } else {
                    am.c(this.cvV, (int) R.drawable.icon_default_avatar100_bg);
                }
                this.cvV.setDrawBorder(false);
                if (!TextUtils.isEmpty(aVar.cqs)) {
                    this.cdg.setText(aVar.cqs);
                }
                this.cvW.setVisibility(8);
                this.cvU.getLayoutParams().width = this.mPageContext.getPageActivity().getResources().getDimensionPixelSize(R.dimen.tbds62);
                TiebaStatic.log("c12678");
            } else {
                if (aVar.cqq != null) {
                    this.cvV.startLoad(aVar.cqq.liveCover, 10, false);
                    this.cvV.setDrawBorder(true);
                    this.cvV.setBorderWidth(1);
                    this.cvV.setBorderColor(this.mPageContext.getPageActivity().getResources().getColor(R.color.black_alpha15));
                    String str = aVar.cqq.userName;
                    if (!TextUtils.isEmpty(str)) {
                        if (k.bk(str) > 8) {
                            str = aq.j(str, 8, "...");
                        }
                        this.cdg.setText(str);
                    }
                }
                this.cvW.setVisibility(0);
                this.cvU.getLayoutParams().width = this.mPageContext.getPageActivity().getResources().getDimensionPixelSize(R.dimen.tbds62);
                TiebaStatic.log("c12676");
            }
            if (i == 0) {
                this.cvT.setVisibility(0);
            } else {
                this.cvT.setVisibility(8);
            }
            am.c(this.cvW, (int) R.drawable.btn_story_live);
            am.j(this.cdg, R.color.cp_cont_f);
        }
    }
}
