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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class a {
    private com.baidu.tieba.ala.alasquare.a.a gnX;
    private TextView gof;
    private TbImageView gqJ;
    private RelativeLayout gqK;
    private RelativeLayout gqL;
    private TbImageView gqM;
    private TextView gqN;
    private String gqO;
    private com.baidu.tieba.ala.alasquare.subtablist.c.h gqP;
    private View mRootView;
    private TbPageContext<?> mTbPageContext;
    private TextView mTitle;
    private int mSkinType = 3;
    private int[] gqR = {TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha0), TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha40)};
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.a.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                if (a.this.gnX != null && a.this.gqP != null) {
                    a.this.gqP.c(a.this.gnX);
                    return;
                }
                return;
            }
            l.showToast(a.this.mTbPageContext.getPageActivity(), a.this.mTbPageContext.getPageActivity().getString(R.string.neterror));
        }
    };
    private String gqQ = TbadkCoreApplication.getInst().getResources().getString(R.string.special_game_tab_title);

    public a(TbPageContext<?> tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.mRootView = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(R.layout.ala_special_game_live_item_view, (ViewGroup) null, false);
        this.gqL = (RelativeLayout) this.mRootView.findViewById(R.id.gameUserNameWrapper);
        this.gqJ = (TbImageView) this.mRootView.findViewById(R.id.gameTopImg);
        this.gqJ.setPlaceHolder(2);
        this.gqK = (RelativeLayout) this.mRootView.findViewById(R.id.gameTopImgLayout);
        this.mRootView.setOnClickListener(this.mOnClickListener);
        this.gqM = (TbImageView) this.mRootView.findViewById(R.id.gameTopLabel);
        this.gqN = (TextView) this.mRootView.findViewById(R.id.gameTopAuthorName);
        this.gof = (TextView) this.mRootView.findViewById(R.id.gameTopAudienceCount);
        this.mTitle = (TextView) this.mRootView.findViewById(R.id.gameLiveItemTitle);
        this.gqL.setBackgroundDrawable(new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, this.gqR));
        int equipmentWidth = l.getEquipmentWidth(this.mRootView.getContext());
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gqK.getLayoutParams();
        layoutParams.width = (equipmentWidth - (this.mTbPageContext.getResources().getDimensionPixelSize(R.dimen.tbds6) * 3)) / 2;
        layoutParams.height = (int) (layoutParams.width * 0.558f);
        this.gqK.setLayoutParams(layoutParams);
    }

    public View getView() {
        return this.mRootView;
    }

    public void b(com.baidu.tieba.ala.alasquare.subtablist.c.h hVar) {
        this.gqP = hVar;
    }

    public void a(com.baidu.tieba.ala.alasquare.a.a aVar) {
        a(aVar, this.gqQ);
    }

    public void a(com.baidu.tieba.ala.alasquare.a.a aVar, String str) {
        if (aVar == null || aVar.ghL == null) {
            getView().setVisibility(4);
            return;
        }
        this.gnX = aVar;
        getView().setVisibility(0);
        this.gqJ.startLoad(aVar.ghL.liveInfo.cover, 10, false);
        this.gof.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.square_sub_live_audience_label, at.numberUniformFormatExtra(aVar.ghL.liveInfo.audienceCount)));
        this.gqN.setText(aVar.ghL.liveAuthor.name);
        this.mTitle.setText(aVar.ghL.title);
        if (TbadkCoreApplication.getInst().getSkinType() == 4) {
            this.gqO = aVar.ghL.recom_extra_img_dark;
        } else if (TbadkCoreApplication.getInst().getSkinType() == 1) {
            this.gqO = aVar.ghL.recom_extra_img_night;
        } else {
            this.gqO = aVar.ghL.recom_extra_img;
        }
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
        TiebaStatic.log(new aq("c12903").dR("entryname", str));
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setViewTextColor(this.gof, (int) R.color.cp_cont_a);
            ap.setViewTextColor(this.gqN, (int) R.color.cp_cont_a);
            ap.setViewTextColor(this.mTitle, (int) R.color.cp_cont_b);
            if (!StringUtils.isNull(this.gqO)) {
                this.gqM.setVisibility(0);
                this.gqM.startLoad(this.gqO, 10, false);
            } else {
                this.gqM.setVisibility(8);
            }
            Drawable drawable = ap.getDrawable(this.mTbPageContext.getResources(), (int) R.drawable.tab_icon_living_seeding);
            drawable.setBounds(0, 0, this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds15), this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds15));
            this.gof.setCompoundDrawablePadding(this.mTbPageContext.getResources().getDimensionPixelSize(R.dimen.tbds14));
            this.gof.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
            this.mSkinType = i;
        }
    }
}
