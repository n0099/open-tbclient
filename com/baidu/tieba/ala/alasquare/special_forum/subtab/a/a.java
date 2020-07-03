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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class a {
    private com.baidu.tieba.ala.alasquare.a.a frV;
    private TextView fsd;
    private TbImageView fuJ;
    private RelativeLayout fuK;
    private RelativeLayout fuL;
    private TbImageView fuM;
    private TextView fuN;
    private String fuO;
    private com.baidu.tieba.ala.alasquare.subtablist.c.h fuP;
    private View mRootView;
    private TbPageContext<?> mTbPageContext;
    private TextView mTitle;
    private int mSkinType = 3;
    private int[] fuR = {TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha0), TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha40)};
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.a.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                if (a.this.frV != null && a.this.fuP != null) {
                    a.this.fuP.c(a.this.frV);
                    return;
                }
                return;
            }
            l.showToast(a.this.mTbPageContext.getPageActivity(), a.this.mTbPageContext.getPageActivity().getString(R.string.neterror));
        }
    };
    private String fuQ = TbadkCoreApplication.getInst().getResources().getString(R.string.special_game_tab_title);

    public a(TbPageContext<?> tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.mRootView = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(R.layout.ala_special_game_live_item_view, (ViewGroup) null, false);
        this.fuL = (RelativeLayout) this.mRootView.findViewById(R.id.gameUserNameWrapper);
        this.fuJ = (TbImageView) this.mRootView.findViewById(R.id.gameTopImg);
        this.fuJ.setPlaceHolder(2);
        this.fuK = (RelativeLayout) this.mRootView.findViewById(R.id.gameTopImgLayout);
        this.mRootView.setOnClickListener(this.mOnClickListener);
        this.fuM = (TbImageView) this.mRootView.findViewById(R.id.gameTopLabel);
        this.fuN = (TextView) this.mRootView.findViewById(R.id.gameTopAuthorName);
        this.fsd = (TextView) this.mRootView.findViewById(R.id.gameTopAudienceCount);
        this.mTitle = (TextView) this.mRootView.findViewById(R.id.gameLiveItemTitle);
        this.fuL.setBackgroundDrawable(new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, this.fuR));
        int equipmentWidth = l.getEquipmentWidth(this.mRootView.getContext());
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fuK.getLayoutParams();
        layoutParams.width = (equipmentWidth - (this.mTbPageContext.getResources().getDimensionPixelSize(R.dimen.tbds6) * 3)) / 2;
        layoutParams.height = (int) (layoutParams.width * 0.558f);
        this.fuK.setLayoutParams(layoutParams);
    }

    public View getView() {
        return this.mRootView;
    }

    public void b(com.baidu.tieba.ala.alasquare.subtablist.c.h hVar) {
        this.fuP = hVar;
    }

    public void a(com.baidu.tieba.ala.alasquare.a.a aVar) {
        a(aVar, this.fuQ);
    }

    public void a(com.baidu.tieba.ala.alasquare.a.a aVar, String str) {
        if (aVar == null || aVar.flQ == null) {
            getView().setVisibility(4);
            return;
        }
        this.frV = aVar;
        getView().setVisibility(0);
        this.fuJ.startLoad(aVar.flQ.liveInfo.cover, 10, false);
        this.fsd.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.square_sub_live_audience_label, ar.numberUniformFormatExtra(aVar.flQ.liveInfo.audienceCount)));
        this.fuN.setText(aVar.flQ.liveAuthor.name);
        this.mTitle.setText(aVar.flQ.title);
        if (TbadkCoreApplication.getInst().getSkinType() == 4) {
            this.fuO = aVar.flQ.recom_extra_img_dark;
        } else if (TbadkCoreApplication.getInst().getSkinType() == 1) {
            this.fuO = aVar.flQ.recom_extra_img_night;
        } else {
            this.fuO = aVar.flQ.recom_extra_img;
        }
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
        TiebaStatic.log(new ao("c12903").dk("entryname", str));
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            an.setViewTextColor(this.fsd, (int) R.color.cp_cont_a);
            an.setViewTextColor(this.fuN, (int) R.color.cp_cont_a);
            an.setViewTextColor(this.mTitle, (int) R.color.cp_cont_b);
            if (!StringUtils.isNull(this.fuO)) {
                this.fuM.setVisibility(0);
                this.fuM.startLoad(this.fuO, 10, false);
            } else {
                this.fuM.setVisibility(8);
            }
            Drawable drawable = an.getDrawable(this.mTbPageContext.getResources(), (int) R.drawable.tab_icon_living_seeding);
            drawable.setBounds(0, 0, this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds15), this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds15));
            this.fsd.setCompoundDrawablePadding(this.mTbPageContext.getResources().getDimensionPixelSize(R.dimen.tbds14));
            this.fsd.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
            this.mSkinType = i;
        }
    }
}
