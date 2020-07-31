package com.baidu.tieba.ala.alasquare.special_forum.subtab.a;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class a {
    private com.baidu.tieba.ala.alasquare.a.a fxd;
    private TextView fxl;
    private TbImageView fzQ;
    private RelativeLayout fzR;
    private RelativeLayout fzS;
    private TbImageView fzT;
    private TextView fzU;
    private String fzV;
    private com.baidu.tieba.ala.alasquare.subtablist.c.h fzW;
    private View mRootView;
    private TbPageContext<?> mTbPageContext;
    private TextView mTitle;
    private int mSkinType = 3;
    private int[] fzY = {TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha0), TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha40)};
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.a.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                if (a.this.fxd != null && a.this.fzW != null) {
                    a.this.fzW.c(a.this.fxd);
                    return;
                }
                return;
            }
            l.showToast(a.this.mTbPageContext.getPageActivity(), a.this.mTbPageContext.getPageActivity().getString(R.string.neterror));
        }
    };
    private String fzX = TbadkCoreApplication.getInst().getResources().getString(R.string.special_game_tab_title);

    public a(TbPageContext<?> tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.mRootView = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(R.layout.ala_special_game_live_item_view, (ViewGroup) null, false);
        this.fzS = (RelativeLayout) this.mRootView.findViewById(R.id.gameUserNameWrapper);
        this.fzQ = (TbImageView) this.mRootView.findViewById(R.id.gameTopImg);
        this.fzQ.setPlaceHolder(2);
        this.fzR = (RelativeLayout) this.mRootView.findViewById(R.id.gameTopImgLayout);
        this.mRootView.setOnClickListener(this.mOnClickListener);
        this.fzT = (TbImageView) this.mRootView.findViewById(R.id.gameTopLabel);
        this.fzU = (TextView) this.mRootView.findViewById(R.id.gameTopAuthorName);
        this.fxl = (TextView) this.mRootView.findViewById(R.id.gameTopAudienceCount);
        this.mTitle = (TextView) this.mRootView.findViewById(R.id.gameLiveItemTitle);
        this.fzS.setBackgroundDrawable(new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, this.fzY));
        int equipmentWidth = l.getEquipmentWidth(this.mRootView.getContext());
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fzR.getLayoutParams();
        layoutParams.width = (equipmentWidth - (this.mTbPageContext.getResources().getDimensionPixelSize(R.dimen.tbds6) * 3)) / 2;
        layoutParams.height = (int) (layoutParams.width * 0.558f);
        this.fzR.setLayoutParams(layoutParams);
    }

    public View getView() {
        return this.mRootView;
    }

    public void b(com.baidu.tieba.ala.alasquare.subtablist.c.h hVar) {
        this.fzW = hVar;
    }

    public void a(com.baidu.tieba.ala.alasquare.a.a aVar) {
        a(aVar, this.fzX);
    }

    public void a(com.baidu.tieba.ala.alasquare.a.a aVar, String str) {
        if (aVar == null || aVar.fqY == null) {
            getView().setVisibility(4);
            return;
        }
        this.fxd = aVar;
        getView().setVisibility(0);
        this.fzQ.startLoad(aVar.fqY.liveInfo.cover, 10, false);
        this.fxl.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.square_sub_live_audience_label, as.numberUniformFormatExtra(aVar.fqY.liveInfo.audienceCount)));
        this.fzU.setText(aVar.fqY.liveAuthor.name);
        this.mTitle.setText(aVar.fqY.title);
        if (TbadkCoreApplication.getInst().getSkinType() == 4) {
            this.fzV = aVar.fqY.recom_extra_img_dark;
        } else if (TbadkCoreApplication.getInst().getSkinType() == 1) {
            this.fzV = aVar.fqY.recom_extra_img_night;
        } else {
            this.fzV = aVar.fqY.recom_extra_img;
        }
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
        TiebaStatic.log(new ap("c12903").dn("entryname", str));
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ao.setViewTextColor(this.fxl, R.color.cp_cont_a);
            ao.setViewTextColor(this.fzU, R.color.cp_cont_a);
            ao.setViewTextColor(this.mTitle, R.color.cp_cont_b);
            if (!StringUtils.isNull(this.fzV)) {
                this.fzT.setVisibility(0);
                this.fzT.startLoad(this.fzV, 10, false);
            } else {
                this.fzT.setVisibility(8);
            }
            Drawable drawable = ao.getDrawable(this.mTbPageContext.getResources(), R.drawable.tab_icon_living_seeding);
            drawable.setBounds(0, 0, this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds15), this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds15));
            this.fxl.setCompoundDrawablePadding(this.mTbPageContext.getResources().getDimensionPixelSize(R.dimen.tbds14));
            this.fxl.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
            this.mSkinType = i;
        }
    }
}
