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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes6.dex */
public class a {
    private com.baidu.tieba.ala.alasquare.a.a gvN;
    private TextView gvV;
    private RelativeLayout gyA;
    private RelativeLayout gyB;
    private TbImageView gyC;
    private TextView gyD;
    private String gyE;
    private com.baidu.tieba.ala.alasquare.subtablist.c.h gyF;
    private TbImageView gyz;
    private View mRootView;
    private TbPageContext<?> mTbPageContext;
    private TextView mTitle;
    private int mSkinType = 3;
    private int[] gyH = {TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha0), TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha40)};
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.a.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                if (a.this.gvN != null && a.this.gyF != null) {
                    a.this.gyF.c(a.this.gvN);
                    return;
                }
                return;
            }
            l.showToast(a.this.mTbPageContext.getPageActivity(), a.this.mTbPageContext.getPageActivity().getString(R.string.neterror));
        }
    };
    private String gyG = TbadkCoreApplication.getInst().getResources().getString(R.string.special_game_tab_title);

    public a(TbPageContext<?> tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.mRootView = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(R.layout.ala_special_game_live_item_view, (ViewGroup) null, false);
        this.gyB = (RelativeLayout) this.mRootView.findViewById(R.id.gameUserNameWrapper);
        this.gyz = (TbImageView) this.mRootView.findViewById(R.id.gameTopImg);
        this.gyz.setPlaceHolder(2);
        this.gyA = (RelativeLayout) this.mRootView.findViewById(R.id.gameTopImgLayout);
        this.mRootView.setOnClickListener(this.mOnClickListener);
        this.gyC = (TbImageView) this.mRootView.findViewById(R.id.gameTopLabel);
        this.gyD = (TextView) this.mRootView.findViewById(R.id.gameTopAuthorName);
        this.gvV = (TextView) this.mRootView.findViewById(R.id.gameTopAudienceCount);
        this.mTitle = (TextView) this.mRootView.findViewById(R.id.gameLiveItemTitle);
        this.gyB.setBackgroundDrawable(new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, this.gyH));
        int equipmentWidth = l.getEquipmentWidth(this.mRootView.getContext());
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gyA.getLayoutParams();
        layoutParams.width = (equipmentWidth - (this.mTbPageContext.getResources().getDimensionPixelSize(R.dimen.tbds6) * 3)) / 2;
        layoutParams.height = (int) (layoutParams.width * 0.558f);
        this.gyA.setLayoutParams(layoutParams);
    }

    public View getView() {
        return this.mRootView;
    }

    public void b(com.baidu.tieba.ala.alasquare.subtablist.c.h hVar) {
        this.gyF = hVar;
    }

    public void a(com.baidu.tieba.ala.alasquare.a.a aVar) {
        a(aVar, this.gyG);
    }

    public void a(com.baidu.tieba.ala.alasquare.a.a aVar, String str) {
        if (aVar == null || aVar.gpC == null) {
            getView().setVisibility(4);
            return;
        }
        this.gvN = aVar;
        getView().setVisibility(0);
        this.gyz.startLoad(aVar.gpC.liveInfo.cover, 10, false);
        this.gvV.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.square_sub_live_audience_label, au.numberUniformFormatExtra(aVar.gpC.liveInfo.audienceCount)));
        this.gyD.setText(aVar.gpC.liveAuthor.name);
        this.mTitle.setText(aVar.gpC.title);
        if (TbadkCoreApplication.getInst().getSkinType() == 4) {
            this.gyE = aVar.gpC.recom_extra_img_dark;
        } else if (TbadkCoreApplication.getInst().getSkinType() == 1) {
            this.gyE = aVar.gpC.recom_extra_img_night;
        } else {
            this.gyE = aVar.gpC.recom_extra_img;
        }
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
        TiebaStatic.log(new ar("c12903").dY("entryname", str));
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setViewTextColor(this.gvV, (int) R.color.CAM_X0101);
            ap.setViewTextColor(this.gyD, (int) R.color.CAM_X0101);
            ap.setViewTextColor(this.mTitle, (int) R.color.CAM_X0105);
            if (!StringUtils.isNull(this.gyE)) {
                this.gyC.setVisibility(0);
                this.gyC.startLoad(this.gyE, 10, false);
            } else {
                this.gyC.setVisibility(8);
            }
            Drawable drawable = ap.getDrawable(this.mTbPageContext.getResources(), (int) R.drawable.tab_icon_living_seeding);
            drawable.setBounds(0, 0, this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds15), this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds15));
            this.gvV.setCompoundDrawablePadding(this.mTbPageContext.getResources().getDimensionPixelSize(R.dimen.tbds14));
            this.gvV.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
            this.mSkinType = i;
        }
    }
}
