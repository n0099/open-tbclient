package com.baidu.tbadk.l;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.lib.util.k;
import com.baidu.adp.widget.ListView.v;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class a extends v.a {
    private View cIZ;
    private View cJa;
    private HeadImageView cJb;
    private ImageView cJc;
    private TextView csn;
    private TbPageContext mPageContext;

    public a(View view, TbPageContext tbPageContext) {
        super(view);
        this.mPageContext = tbPageContext;
        this.cIZ = view.findViewById(R.id.ala_follow_left_space);
        this.cJa = view.findViewById(R.id.ala_follow_right_space);
        this.cJb = (HeadImageView) view.findViewById(R.id.ala_follow_head_img);
        this.cJb.setDefaultResource(R.drawable.icon_default_avatar100_bg);
        this.cJb.setIsRound(true);
        this.cJb.setAutoChangeStyle(false);
        this.cJb.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.cJc = (ImageView) view.findViewById(R.id.ala_follow_living_img);
        this.csn = (TextView) view.findViewById(R.id.ala_follow_user_name);
    }

    public void a(int i, com.baidu.tbadk.data.a aVar) {
        if (aVar != null) {
            this.cJb.setImageDrawable(null);
            if (aVar.cDK == -100) {
                if (aVar.cDM > 0) {
                    am.setImageResource(this.cJb, aVar.cDM);
                } else {
                    am.setImageResource(this.cJb, R.drawable.icon_default_avatar100_bg);
                }
                this.cJb.setDrawBorder(false);
                if (!TextUtils.isEmpty(aVar.cDL)) {
                    this.csn.setText(aVar.cDL);
                }
                this.cJc.setVisibility(8);
                this.cJa.getLayoutParams().width = this.mPageContext.getPageActivity().getResources().getDimensionPixelSize(R.dimen.tbds62);
                TiebaStatic.log(TbadkCoreStatisticKey.ALA_FOLLOW_LIVE_SQUARE_ITEM_SHOW);
            } else {
                if (aVar.cDJ != null) {
                    this.cJb.startLoad(aVar.cDJ.liveCover, 10, false);
                    this.cJb.setDrawBorder(true);
                    this.cJb.setBorderWidth(1);
                    this.cJb.setBorderColor(this.mPageContext.getPageActivity().getResources().getColor(R.color.black_alpha15));
                    String str = aVar.cDJ.userName;
                    if (!TextUtils.isEmpty(str)) {
                        if (k.byteLength(str) > 8) {
                            str = aq.cutChineseAndEnglishWithSuffix(str, 8, StringHelper.STRING_MORE);
                        }
                        this.csn.setText(str);
                    }
                }
                this.cJc.setVisibility(0);
                this.cJa.getLayoutParams().width = this.mPageContext.getPageActivity().getResources().getDimensionPixelSize(R.dimen.tbds62);
                TiebaStatic.log(TbadkCoreStatisticKey.ALA_FOLLOW_LIVE_LIVE_ITEM_SHOW);
            }
            if (i == 0) {
                this.cIZ.setVisibility(0);
            } else {
                this.cIZ.setVisibility(8);
            }
            am.setImageResource(this.cJc, R.drawable.btn_story_live);
            am.setViewTextColor(this.csn, (int) R.color.cp_cont_f);
        }
    }
}
