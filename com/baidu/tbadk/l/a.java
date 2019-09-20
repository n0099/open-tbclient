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
    private TextView cdZ;
    private View cwP;
    private View cwQ;
    private HeadImageView cwR;
    private ImageView cwS;
    private TbPageContext mPageContext;

    public a(View view, TbPageContext tbPageContext) {
        super(view);
        this.mPageContext = tbPageContext;
        this.cwP = view.findViewById(R.id.ala_follow_left_space);
        this.cwQ = view.findViewById(R.id.ala_follow_right_space);
        this.cwR = (HeadImageView) view.findViewById(R.id.ala_follow_head_img);
        this.cwR.setDefaultResource(R.drawable.icon_default_avatar100_bg);
        this.cwR.setIsRound(true);
        this.cwR.setAutoChangeStyle(false);
        this.cwR.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.cwS = (ImageView) view.findViewById(R.id.ala_follow_living_img);
        this.cdZ = (TextView) view.findViewById(R.id.ala_follow_user_name);
    }

    public void a(int i, com.baidu.tbadk.data.a aVar) {
        if (aVar != null) {
            this.cwR.setImageDrawable(null);
            if (aVar.crm == -100) {
                if (aVar.cro > 0) {
                    am.c(this.cwR, aVar.cro);
                } else {
                    am.c(this.cwR, (int) R.drawable.icon_default_avatar100_bg);
                }
                this.cwR.setDrawBorder(false);
                if (!TextUtils.isEmpty(aVar.crn)) {
                    this.cdZ.setText(aVar.crn);
                }
                this.cwS.setVisibility(8);
                this.cwQ.getLayoutParams().width = this.mPageContext.getPageActivity().getResources().getDimensionPixelSize(R.dimen.tbds62);
                TiebaStatic.log("c12678");
            } else {
                if (aVar.crl != null) {
                    this.cwR.startLoad(aVar.crl.liveCover, 10, false);
                    this.cwR.setDrawBorder(true);
                    this.cwR.setBorderWidth(1);
                    this.cwR.setBorderColor(this.mPageContext.getPageActivity().getResources().getColor(R.color.black_alpha15));
                    String str = aVar.crl.userName;
                    if (!TextUtils.isEmpty(str)) {
                        if (k.bk(str) > 8) {
                            str = aq.j(str, 8, "...");
                        }
                        this.cdZ.setText(str);
                    }
                }
                this.cwS.setVisibility(0);
                this.cwQ.getLayoutParams().width = this.mPageContext.getPageActivity().getResources().getDimensionPixelSize(R.dimen.tbds62);
                TiebaStatic.log("c12676");
            }
            if (i == 0) {
                this.cwP.setVisibility(0);
            } else {
                this.cwP.setVisibility(8);
            }
            am.c(this.cwS, (int) R.drawable.btn_story_live);
            am.j(this.cdZ, R.color.cp_cont_f);
        }
    }
}
