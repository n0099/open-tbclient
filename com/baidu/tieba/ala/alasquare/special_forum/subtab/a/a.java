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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class a {
    private TextView fgE;
    private com.baidu.tieba.ala.alasquare.a.a fgw;
    private TbImageView fjl;
    private RelativeLayout fjm;
    private RelativeLayout fjn;
    private TbImageView fjo;
    private TextView fjp;
    private String fjq;
    private com.baidu.tieba.ala.alasquare.subtablist.c.h fjr;
    private View mRootView;
    private TbPageContext<?> mTbPageContext;
    private TextView mTitle;
    private int mSkinType = 3;
    private int[] fjt = {TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha0), TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha40)};
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.a.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                if (a.this.fgw != null && a.this.fjr != null) {
                    a.this.fjr.c(a.this.fgw);
                    return;
                }
                return;
            }
            l.showToast(a.this.mTbPageContext.getPageActivity(), a.this.mTbPageContext.getPageActivity().getString(R.string.neterror));
        }
    };
    private String fjs = TbadkCoreApplication.getInst().getResources().getString(R.string.special_game_tab_title);

    public a(TbPageContext<?> tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.mRootView = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(R.layout.ala_special_game_live_item_view, (ViewGroup) null, false);
        this.fjn = (RelativeLayout) this.mRootView.findViewById(R.id.gameUserNameWrapper);
        this.fjl = (TbImageView) this.mRootView.findViewById(R.id.gameTopImg);
        this.fjl.setPlaceHolder(2);
        this.fjm = (RelativeLayout) this.mRootView.findViewById(R.id.gameTopImgLayout);
        this.mRootView.setOnClickListener(this.mOnClickListener);
        this.fjo = (TbImageView) this.mRootView.findViewById(R.id.gameTopLabel);
        this.fjp = (TextView) this.mRootView.findViewById(R.id.gameTopAuthorName);
        this.fgE = (TextView) this.mRootView.findViewById(R.id.gameTopAudienceCount);
        this.mTitle = (TextView) this.mRootView.findViewById(R.id.gameLiveItemTitle);
        this.fjn.setBackgroundDrawable(new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, this.fjt));
        int equipmentWidth = l.getEquipmentWidth(this.mRootView.getContext());
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fjm.getLayoutParams();
        layoutParams.width = (equipmentWidth - (this.mTbPageContext.getResources().getDimensionPixelSize(R.dimen.tbds6) * 3)) / 2;
        layoutParams.height = (int) (layoutParams.width * 0.558f);
        this.fjm.setLayoutParams(layoutParams);
    }

    public View getView() {
        return this.mRootView;
    }

    public void b(com.baidu.tieba.ala.alasquare.subtablist.c.h hVar) {
        this.fjr = hVar;
    }

    public void a(com.baidu.tieba.ala.alasquare.a.a aVar) {
        a(aVar, this.fjs);
    }

    public void a(com.baidu.tieba.ala.alasquare.a.a aVar, String str) {
        if (aVar == null || aVar.fav == null) {
            getView().setVisibility(4);
            return;
        }
        this.fgw = aVar;
        getView().setVisibility(0);
        this.fjl.startLoad(aVar.fav.liveInfo.cover, 10, false);
        this.fgE.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.square_sub_live_audience_label, aq.numberUniformFormatExtra(aVar.fav.liveInfo.audienceCount)));
        this.fjp.setText(aVar.fav.liveAuthor.name);
        this.mTitle.setText(aVar.fav.title);
        if (TbadkCoreApplication.getInst().getSkinType() == 4) {
            this.fjq = aVar.fav.recom_extra_img_dark;
        } else if (TbadkCoreApplication.getInst().getSkinType() == 1) {
            this.fjq = aVar.fav.recom_extra_img_night;
        } else {
            this.fjq = aVar.fav.recom_extra_img;
        }
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
        TiebaStatic.log(new an("c12903").dh("entryname", str));
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setViewTextColor(this.fgE, (int) R.color.cp_cont_a);
            am.setViewTextColor(this.fjp, (int) R.color.cp_cont_a);
            am.setViewTextColor(this.mTitle, (int) R.color.cp_cont_b);
            if (!StringUtils.isNull(this.fjq)) {
                this.fjo.setVisibility(0);
                this.fjo.startLoad(this.fjq, 10, false);
            } else {
                this.fjo.setVisibility(8);
            }
            Drawable drawable = am.getDrawable(this.mTbPageContext.getResources(), (int) R.drawable.tab_icon_living_seeding);
            drawable.setBounds(0, 0, this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds15), this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds15));
            this.fgE.setCompoundDrawablePadding(this.mTbPageContext.getResources().getDimensionPixelSize(R.dimen.tbds14));
            this.fgE.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
            this.mSkinType = i;
        }
    }
}
