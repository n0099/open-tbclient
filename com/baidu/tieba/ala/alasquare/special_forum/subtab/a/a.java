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
    private com.baidu.tieba.ala.alasquare.a.a gvP;
    private TextView gvX;
    private TbImageView gyB;
    private RelativeLayout gyC;
    private RelativeLayout gyD;
    private TbImageView gyE;
    private TextView gyF;
    private String gyG;
    private com.baidu.tieba.ala.alasquare.subtablist.c.h gyH;
    private View mRootView;
    private TbPageContext<?> mTbPageContext;
    private TextView mTitle;
    private int mSkinType = 3;
    private int[] gyJ = {TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha0), TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha40)};
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.a.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                if (a.this.gvP != null && a.this.gyH != null) {
                    a.this.gyH.c(a.this.gvP);
                    return;
                }
                return;
            }
            l.showToast(a.this.mTbPageContext.getPageActivity(), a.this.mTbPageContext.getPageActivity().getString(R.string.neterror));
        }
    };
    private String gyI = TbadkCoreApplication.getInst().getResources().getString(R.string.special_game_tab_title);

    public a(TbPageContext<?> tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.mRootView = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(R.layout.ala_special_game_live_item_view, (ViewGroup) null, false);
        this.gyD = (RelativeLayout) this.mRootView.findViewById(R.id.gameUserNameWrapper);
        this.gyB = (TbImageView) this.mRootView.findViewById(R.id.gameTopImg);
        this.gyB.setPlaceHolder(2);
        this.gyC = (RelativeLayout) this.mRootView.findViewById(R.id.gameTopImgLayout);
        this.mRootView.setOnClickListener(this.mOnClickListener);
        this.gyE = (TbImageView) this.mRootView.findViewById(R.id.gameTopLabel);
        this.gyF = (TextView) this.mRootView.findViewById(R.id.gameTopAuthorName);
        this.gvX = (TextView) this.mRootView.findViewById(R.id.gameTopAudienceCount);
        this.mTitle = (TextView) this.mRootView.findViewById(R.id.gameLiveItemTitle);
        this.gyD.setBackgroundDrawable(new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, this.gyJ));
        int equipmentWidth = l.getEquipmentWidth(this.mRootView.getContext());
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gyC.getLayoutParams();
        layoutParams.width = (equipmentWidth - (this.mTbPageContext.getResources().getDimensionPixelSize(R.dimen.tbds6) * 3)) / 2;
        layoutParams.height = (int) (layoutParams.width * 0.558f);
        this.gyC.setLayoutParams(layoutParams);
    }

    public View getView() {
        return this.mRootView;
    }

    public void b(com.baidu.tieba.ala.alasquare.subtablist.c.h hVar) {
        this.gyH = hVar;
    }

    public void a(com.baidu.tieba.ala.alasquare.a.a aVar) {
        a(aVar, this.gyI);
    }

    public void a(com.baidu.tieba.ala.alasquare.a.a aVar, String str) {
        if (aVar == null || aVar.gpE == null) {
            getView().setVisibility(4);
            return;
        }
        this.gvP = aVar;
        getView().setVisibility(0);
        this.gyB.startLoad(aVar.gpE.liveInfo.cover, 10, false);
        this.gvX.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.square_sub_live_audience_label, au.numberUniformFormatExtra(aVar.gpE.liveInfo.audienceCount)));
        this.gyF.setText(aVar.gpE.liveAuthor.name);
        this.mTitle.setText(aVar.gpE.title);
        if (TbadkCoreApplication.getInst().getSkinType() == 4) {
            this.gyG = aVar.gpE.recom_extra_img_dark;
        } else if (TbadkCoreApplication.getInst().getSkinType() == 1) {
            this.gyG = aVar.gpE.recom_extra_img_night;
        } else {
            this.gyG = aVar.gpE.recom_extra_img;
        }
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
        TiebaStatic.log(new ar("c12903").dY("entryname", str));
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setViewTextColor(this.gvX, (int) R.color.CAM_X0101);
            ap.setViewTextColor(this.gyF, (int) R.color.CAM_X0101);
            ap.setViewTextColor(this.mTitle, (int) R.color.CAM_X0105);
            if (!StringUtils.isNull(this.gyG)) {
                this.gyE.setVisibility(0);
                this.gyE.startLoad(this.gyG, 10, false);
            } else {
                this.gyE.setVisibility(8);
            }
            Drawable drawable = ap.getDrawable(this.mTbPageContext.getResources(), (int) R.drawable.tab_icon_living_seeding);
            drawable.setBounds(0, 0, this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds15), this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds15));
            this.gvX.setCompoundDrawablePadding(this.mTbPageContext.getResources().getDimensionPixelSize(R.dimen.tbds14));
            this.gvX.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
            this.mSkinType = i;
        }
    }
}
