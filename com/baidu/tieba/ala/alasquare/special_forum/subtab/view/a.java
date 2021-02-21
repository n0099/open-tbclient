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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.alasquare.subtablist.view.f;
/* loaded from: classes10.dex */
public class a {
    private com.baidu.tieba.ala.alasquare.a.a gFg;
    private TextView gFs;
    private TbImageView gHW;
    private RelativeLayout gHX;
    private RelativeLayout gHY;
    private TbImageView gHZ;
    private TextView gIa;
    private String gIb;
    private f gIc;
    private View mRootView;
    private TbPageContext<?> mTbPageContext;
    private TextView mTitle;
    private int mSkinType = 3;
    private int[] gIe = {TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha0), TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha40)};
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.view.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (j.isNetWorkAvailable()) {
                if (a.this.gFg != null && a.this.gIc != null) {
                    a.this.gIc.c(a.this.gFg);
                    return;
                }
                return;
            }
            l.showToast(a.this.mTbPageContext.getPageActivity(), a.this.mTbPageContext.getPageActivity().getString(R.string.neterror));
        }
    };
    private String gId = TbadkCoreApplication.getInst().getResources().getString(R.string.special_game_tab_title);

    public a(TbPageContext<?> tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.mRootView = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(R.layout.ala_special_game_live_item_view, (ViewGroup) null, false);
        this.gHY = (RelativeLayout) this.mRootView.findViewById(R.id.gameUserNameWrapper);
        this.gHW = (TbImageView) this.mRootView.findViewById(R.id.gameTopImg);
        this.gHW.setPlaceHolder(2);
        this.gHX = (RelativeLayout) this.mRootView.findViewById(R.id.gameTopImgLayout);
        this.mRootView.setOnClickListener(this.mOnClickListener);
        this.gHZ = (TbImageView) this.mRootView.findViewById(R.id.gameTopLabel);
        this.gIa = (TextView) this.mRootView.findViewById(R.id.gameTopAuthorName);
        this.gFs = (TextView) this.mRootView.findViewById(R.id.gameTopAudienceCount);
        this.mTitle = (TextView) this.mRootView.findViewById(R.id.gameLiveItemTitle);
        this.gHY.setBackgroundDrawable(new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, this.gIe));
        int equipmentWidth = l.getEquipmentWidth(this.mRootView.getContext());
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gHX.getLayoutParams();
        layoutParams.width = (equipmentWidth - (this.mTbPageContext.getResources().getDimensionPixelSize(R.dimen.tbds6) * 3)) / 2;
        layoutParams.height = (int) (layoutParams.width * 0.558f);
        this.gHX.setLayoutParams(layoutParams);
    }

    public View getView() {
        return this.mRootView;
    }

    public void b(f fVar) {
        this.gIc = fVar;
    }

    public void a(com.baidu.tieba.ala.alasquare.a.a aVar) {
        a(aVar, this.gId);
    }

    public void a(com.baidu.tieba.ala.alasquare.a.a aVar, String str) {
        if (aVar == null || aVar.gyL == null) {
            getView().setVisibility(4);
            return;
        }
        this.gFg = aVar;
        getView().setVisibility(0);
        this.gHW.startLoad(aVar.gyL.liveInfo.cover, 10, false);
        this.gFs.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.square_sub_live_audience_label, au.numberUniformFormatExtra(aVar.gyL.liveInfo.audienceCount)));
        this.gIa.setText(aVar.gyL.liveAuthor.name);
        this.mTitle.setText(aVar.gyL.title);
        if (TbadkCoreApplication.getInst().getSkinType() == 4) {
            this.gIb = aVar.gyL.recom_extra_img_dark;
        } else if (TbadkCoreApplication.getInst().getSkinType() == 1) {
            this.gIb = aVar.gyL.recom_extra_img_night;
        } else {
            this.gIb = aVar.gyL.recom_extra_img;
        }
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
        TiebaStatic.log(new ar("c12903").dR("entryname", str));
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setViewTextColor(this.gFs, R.color.CAM_X0101);
            ap.setViewTextColor(this.gIa, R.color.CAM_X0101);
            ap.setViewTextColor(this.mTitle, R.color.CAM_X0105);
            if (!StringUtils.isNull(this.gIb)) {
                this.gHZ.setVisibility(0);
                this.gHZ.startLoad(this.gIb, 10, false);
            } else {
                this.gHZ.setVisibility(8);
            }
            Drawable drawable = ap.getDrawable(this.mTbPageContext.getResources(), R.drawable.tab_icon_living_seeding);
            drawable.setBounds(0, 0, this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds15), this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds15));
            this.gFs.setCompoundDrawablePadding(this.mTbPageContext.getResources().getDimensionPixelSize(R.dimen.tbds14));
            this.gFs.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
            this.mSkinType = i;
        }
    }
}
