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
    private TextView cbV;
    private ImageView cuA;
    private View cux;
    private View cuy;
    private HeadImageView cuz;
    private TbPageContext mPageContext;

    public a(View view, TbPageContext tbPageContext) {
        super(view);
        this.mPageContext = tbPageContext;
        this.cux = view.findViewById(R.id.ala_follow_left_space);
        this.cuy = view.findViewById(R.id.ala_follow_right_space);
        this.cuz = (HeadImageView) view.findViewById(R.id.ala_follow_head_img);
        this.cuz.setDefaultResource(R.drawable.icon_default_avatar100_bg);
        this.cuz.setIsRound(true);
        this.cuz.setAutoChangeStyle(false);
        this.cuz.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.cuA = (ImageView) view.findViewById(R.id.ala_follow_living_img);
        this.cbV = (TextView) view.findViewById(R.id.ala_follow_user_name);
    }

    public void a(int i, com.baidu.tbadk.data.a aVar) {
        if (aVar != null) {
            this.cuz.setImageDrawable(null);
            if (aVar.coW == -100) {
                if (aVar.coY > 0) {
                    al.c(this.cuz, aVar.coY);
                } else {
                    al.c(this.cuz, (int) R.drawable.icon_default_avatar100_bg);
                }
                this.cuz.setDrawBorder(false);
                if (!TextUtils.isEmpty(aVar.coX)) {
                    this.cbV.setText(aVar.coX);
                }
                this.cuA.setVisibility(8);
                this.cuy.getLayoutParams().width = this.mPageContext.getPageActivity().getResources().getDimensionPixelSize(R.dimen.tbds62);
                TiebaStatic.log("c12678");
            } else {
                if (aVar.coV != null) {
                    this.cuz.startLoad(aVar.coV.liveCover, 10, false);
                    this.cuz.setDrawBorder(true);
                    this.cuz.setBorderWidth(1);
                    this.cuz.setBorderColor(this.mPageContext.getPageActivity().getResources().getColor(R.color.black_alpha15));
                    String str = aVar.coV.userName;
                    if (!TextUtils.isEmpty(str)) {
                        if (k.bj(str) > 8) {
                            str = ap.j(str, 8, "...");
                        }
                        this.cbV.setText(str);
                    }
                }
                this.cuA.setVisibility(0);
                this.cuy.getLayoutParams().width = this.mPageContext.getPageActivity().getResources().getDimensionPixelSize(R.dimen.tbds62);
                TiebaStatic.log("c12676");
            }
            if (i == 0) {
                this.cux.setVisibility(0);
            } else {
                this.cux.setVisibility(8);
            }
            al.c(this.cuA, (int) R.drawable.btn_story_live);
            al.j(this.cbV, R.color.cp_cont_f);
        }
    }
}
