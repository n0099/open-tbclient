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
    private TextView ccZ;
    private View cvM;
    private View cvN;
    private HeadImageView cvO;
    private ImageView cvP;
    private TbPageContext mPageContext;

    public a(View view, TbPageContext tbPageContext) {
        super(view);
        this.mPageContext = tbPageContext;
        this.cvM = view.findViewById(R.id.ala_follow_left_space);
        this.cvN = view.findViewById(R.id.ala_follow_right_space);
        this.cvO = (HeadImageView) view.findViewById(R.id.ala_follow_head_img);
        this.cvO.setDefaultResource(R.drawable.icon_default_avatar100_bg);
        this.cvO.setIsRound(true);
        this.cvO.setAutoChangeStyle(false);
        this.cvO.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.cvP = (ImageView) view.findViewById(R.id.ala_follow_living_img);
        this.ccZ = (TextView) view.findViewById(R.id.ala_follow_user_name);
    }

    public void a(int i, com.baidu.tbadk.data.a aVar) {
        if (aVar != null) {
            this.cvO.setImageDrawable(null);
            if (aVar.cqk == -100) {
                if (aVar.cqm > 0) {
                    am.c(this.cvO, aVar.cqm);
                } else {
                    am.c(this.cvO, (int) R.drawable.icon_default_avatar100_bg);
                }
                this.cvO.setDrawBorder(false);
                if (!TextUtils.isEmpty(aVar.cql)) {
                    this.ccZ.setText(aVar.cql);
                }
                this.cvP.setVisibility(8);
                this.cvN.getLayoutParams().width = this.mPageContext.getPageActivity().getResources().getDimensionPixelSize(R.dimen.tbds62);
                TiebaStatic.log("c12678");
            } else {
                if (aVar.cqj != null) {
                    this.cvO.startLoad(aVar.cqj.liveCover, 10, false);
                    this.cvO.setDrawBorder(true);
                    this.cvO.setBorderWidth(1);
                    this.cvO.setBorderColor(this.mPageContext.getPageActivity().getResources().getColor(R.color.black_alpha15));
                    String str = aVar.cqj.userName;
                    if (!TextUtils.isEmpty(str)) {
                        if (k.bk(str) > 8) {
                            str = aq.j(str, 8, "...");
                        }
                        this.ccZ.setText(str);
                    }
                }
                this.cvP.setVisibility(0);
                this.cvN.getLayoutParams().width = this.mPageContext.getPageActivity().getResources().getDimensionPixelSize(R.dimen.tbds62);
                TiebaStatic.log("c12676");
            }
            if (i == 0) {
                this.cvM.setVisibility(0);
            } else {
                this.cvM.setVisibility(8);
            }
            am.c(this.cvP, (int) R.drawable.btn_story_live);
            am.j(this.ccZ, R.color.cp_cont_f);
        }
    }
}
