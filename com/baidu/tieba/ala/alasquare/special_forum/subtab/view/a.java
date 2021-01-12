package com.baidu.tieba.ala.alasquare.special_forum.subtab.view;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.alasquare.subtablist.view.f;
/* loaded from: classes9.dex */
public class a {
    private com.baidu.tieba.ala.alasquare.a.a gCi;
    private TextView gCu;
    private TbImageView gEY;
    private RelativeLayout gEZ;
    private RelativeLayout gFa;
    private TbImageView gFb;
    private TextView gFc;
    private String gFd;
    private f gFe;
    private View mRootView;
    private TbPageContext<?> mTbPageContext;
    private TextView mTitle;
    private int mSkinType = 3;
    private int[] gFg = {TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha0), TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha40)};
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.view.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (j.isNetWorkAvailable()) {
                if (a.this.gCi != null && a.this.gFe != null) {
                    a.this.gFe.c(a.this.gCi);
                    return;
                }
                return;
            }
            l.showToast(a.this.mTbPageContext.getPageActivity(), a.this.mTbPageContext.getPageActivity().getString(R.string.neterror));
        }
    };
    private String gFf = TbadkCoreApplication.getInst().getResources().getString(R.string.special_game_tab_title);

    public a(TbPageContext<?> tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.mRootView = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(R.layout.ala_special_game_live_item_view, (ViewGroup) null, false);
        this.gFa = (RelativeLayout) this.mRootView.findViewById(R.id.gameUserNameWrapper);
        this.gEY = (TbImageView) this.mRootView.findViewById(R.id.gameTopImg);
        this.gEY.setPlaceHolder(2);
        this.gEZ = (RelativeLayout) this.mRootView.findViewById(R.id.gameTopImgLayout);
        this.mRootView.setOnClickListener(this.mOnClickListener);
        this.gFb = (TbImageView) this.mRootView.findViewById(R.id.gameTopLabel);
        this.gFc = (TextView) this.mRootView.findViewById(R.id.gameTopAuthorName);
        this.gCu = (TextView) this.mRootView.findViewById(R.id.gameTopAudienceCount);
        this.mTitle = (TextView) this.mRootView.findViewById(R.id.gameLiveItemTitle);
        this.gFa.setBackgroundDrawable(new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, this.gFg));
        int equipmentWidth = l.getEquipmentWidth(this.mRootView.getContext());
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gEZ.getLayoutParams();
        layoutParams.width = (equipmentWidth - (this.mTbPageContext.getResources().getDimensionPixelSize(R.dimen.tbds6) * 3)) / 2;
        layoutParams.height = (int) (layoutParams.width * 0.558f);
        this.gEZ.setLayoutParams(layoutParams);
    }

    public View getView() {
        return this.mRootView;
    }

    public void b(f fVar) {
        this.gFe = fVar;
    }

    public void a(com.baidu.tieba.ala.alasquare.a.a aVar) {
        a(aVar, this.gFf);
    }

    public void a(com.baidu.tieba.ala.alasquare.a.a aVar, String str) {
        if (aVar == null || aVar.gvN == null) {
            getView().setVisibility(4);
            return;
        }
        this.gCi = aVar;
        getView().setVisibility(0);
        this.gEY.startLoad(aVar.gvN.liveInfo.cover, 10, false);
        this.gCu.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.square_sub_live_audience_label, at.numberUniformFormatExtra(aVar.gvN.liveInfo.audienceCount)));
        this.gFc.setText(aVar.gvN.liveAuthor.name);
        this.mTitle.setText(aVar.gvN.title);
        if (TbadkCoreApplication.getInst().getSkinType() == 4) {
            this.gFd = aVar.gvN.recom_extra_img_dark;
        } else if (TbadkCoreApplication.getInst().getSkinType() == 1) {
            this.gFd = aVar.gvN.recom_extra_img_night;
        } else {
            this.gFd = aVar.gvN.recom_extra_img;
        }
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
        TiebaStatic.log(new aq("c12903").dW("entryname", str));
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ao.setViewTextColor(this.gCu, R.color.CAM_X0101);
            ao.setViewTextColor(this.gFc, R.color.CAM_X0101);
            ao.setViewTextColor(this.mTitle, R.color.CAM_X0105);
            if (!StringUtils.isNull(this.gFd)) {
                this.gFb.setVisibility(0);
                this.gFb.startLoad(this.gFd, 10, false);
            } else {
                this.gFb.setVisibility(8);
            }
            Drawable drawable = ao.getDrawable(this.mTbPageContext.getResources(), R.drawable.tab_icon_living_seeding);
            drawable.setBounds(0, 0, this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds15), this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds15));
            this.gCu.setCompoundDrawablePadding(this.mTbPageContext.getResources().getDimensionPixelSize(R.dimen.tbds14));
            this.gCu.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
            this.mSkinType = i;
        }
    }
}
