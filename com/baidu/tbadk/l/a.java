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
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class a extends v.a {
    private TextView cbW;
    private HeadImageView cuA;
    private ImageView cuB;
    private View cuy;
    private View cuz;
    private TbPageContext mPageContext;

    public a(View view, TbPageContext tbPageContext) {
        super(view);
        this.mPageContext = tbPageContext;
        this.cuy = view.findViewById(R.id.ala_follow_left_space);
        this.cuz = view.findViewById(R.id.ala_follow_right_space);
        this.cuA = (HeadImageView) view.findViewById(R.id.ala_follow_head_img);
        this.cuA.setDefaultResource(R.drawable.icon_default_avatar100_bg);
        this.cuA.setIsRound(true);
        this.cuA.setAutoChangeStyle(false);
        this.cuA.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.cuB = (ImageView) view.findViewById(R.id.ala_follow_living_img);
        this.cbW = (TextView) view.findViewById(R.id.ala_follow_user_name);
    }

    public void a(int i, com.baidu.tbadk.data.a aVar) {
        if (aVar != null) {
            this.cuA.setImageDrawable(null);
            if (aVar.coX == -100) {
                if (aVar.coZ > 0) {
                    al.c(this.cuA, aVar.coZ);
                } else {
                    al.c(this.cuA, (int) R.drawable.icon_default_avatar100_bg);
                }
                this.cuA.setDrawBorder(false);
                if (!TextUtils.isEmpty(aVar.coY)) {
                    this.cbW.setText(aVar.coY);
                }
                this.cuB.setVisibility(8);
                this.cuz.getLayoutParams().width = this.mPageContext.getPageActivity().getResources().getDimensionPixelSize(R.dimen.tbds62);
                TiebaStatic.log("c12678");
            } else {
                if (aVar.coW != null) {
                    this.cuA.startLoad(aVar.coW.liveCover, 10, false);
                    this.cuA.setDrawBorder(true);
                    this.cuA.setBorderWidth(1);
                    this.cuA.setBorderColor(this.mPageContext.getPageActivity().getResources().getColor(R.color.black_alpha15));
                    String str = aVar.coW.userName;
                    if (!TextUtils.isEmpty(str)) {
                        if (k.bj(str) > 8) {
                            str = ap.j(str, 8, "...");
                        }
                        this.cbW.setText(str);
                    }
                }
                this.cuB.setVisibility(0);
                this.cuz.getLayoutParams().width = this.mPageContext.getPageActivity().getResources().getDimensionPixelSize(R.dimen.tbds62);
                TiebaStatic.log("c12676");
            }
            if (i == 0) {
                this.cuy.setVisibility(0);
            } else {
                this.cuy.setVisibility(8);
            }
            al.c(this.cuB, (int) R.drawable.btn_story_live);
            al.j(this.cbW, R.color.cp_cont_f);
        }
    }
}
