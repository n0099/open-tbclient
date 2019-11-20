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
    private View cIi;
    private View cIj;
    private HeadImageView cIk;
    private ImageView cIl;
    private TextView crw;
    private TbPageContext mPageContext;

    public a(View view, TbPageContext tbPageContext) {
        super(view);
        this.mPageContext = tbPageContext;
        this.cIi = view.findViewById(R.id.ala_follow_left_space);
        this.cIj = view.findViewById(R.id.ala_follow_right_space);
        this.cIk = (HeadImageView) view.findViewById(R.id.ala_follow_head_img);
        this.cIk.setDefaultResource(R.drawable.icon_default_avatar100_bg);
        this.cIk.setIsRound(true);
        this.cIk.setAutoChangeStyle(false);
        this.cIk.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.cIl = (ImageView) view.findViewById(R.id.ala_follow_living_img);
        this.crw = (TextView) view.findViewById(R.id.ala_follow_user_name);
    }

    public void a(int i, com.baidu.tbadk.data.a aVar) {
        if (aVar != null) {
            this.cIk.setImageDrawable(null);
            if (aVar.cCT == -100) {
                if (aVar.cCV > 0) {
                    am.setImageResource(this.cIk, aVar.cCV);
                } else {
                    am.setImageResource(this.cIk, R.drawable.icon_default_avatar100_bg);
                }
                this.cIk.setDrawBorder(false);
                if (!TextUtils.isEmpty(aVar.cCU)) {
                    this.crw.setText(aVar.cCU);
                }
                this.cIl.setVisibility(8);
                this.cIj.getLayoutParams().width = this.mPageContext.getPageActivity().getResources().getDimensionPixelSize(R.dimen.tbds62);
                TiebaStatic.log(TbadkCoreStatisticKey.ALA_FOLLOW_LIVE_SQUARE_ITEM_SHOW);
            } else {
                if (aVar.cCS != null) {
                    this.cIk.startLoad(aVar.cCS.liveCover, 10, false);
                    this.cIk.setDrawBorder(true);
                    this.cIk.setBorderWidth(1);
                    this.cIk.setBorderColor(this.mPageContext.getPageActivity().getResources().getColor(R.color.black_alpha15));
                    String str = aVar.cCS.userName;
                    if (!TextUtils.isEmpty(str)) {
                        if (k.byteLength(str) > 8) {
                            str = aq.cutChineseAndEnglishWithSuffix(str, 8, StringHelper.STRING_MORE);
                        }
                        this.crw.setText(str);
                    }
                }
                this.cIl.setVisibility(0);
                this.cIj.getLayoutParams().width = this.mPageContext.getPageActivity().getResources().getDimensionPixelSize(R.dimen.tbds62);
                TiebaStatic.log(TbadkCoreStatisticKey.ALA_FOLLOW_LIVE_LIVE_ITEM_SHOW);
            }
            if (i == 0) {
                this.cIi.setVisibility(0);
            } else {
                this.cIi.setVisibility(8);
            }
            am.setImageResource(this.cIl, R.drawable.btn_story_live);
            am.setViewTextColor(this.crw, (int) R.color.cp_cont_f);
        }
    }
}
