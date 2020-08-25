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
    private TextView fID;
    private com.baidu.tieba.ala.alasquare.a.a fIv;
    private TbImageView fLi;
    private RelativeLayout fLj;
    private RelativeLayout fLk;
    private TbImageView fLl;
    private TextView fLm;
    private String fLn;
    private com.baidu.tieba.ala.alasquare.subtablist.c.h fLo;
    private View mRootView;
    private TbPageContext<?> mTbPageContext;
    private TextView mTitle;
    private int mSkinType = 3;
    private int[] fLq = {TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha0), TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha40)};
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.a.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                if (a.this.fIv != null && a.this.fLo != null) {
                    a.this.fLo.c(a.this.fIv);
                    return;
                }
                return;
            }
            l.showToast(a.this.mTbPageContext.getPageActivity(), a.this.mTbPageContext.getPageActivity().getString(R.string.neterror));
        }
    };
    private String fLp = TbadkCoreApplication.getInst().getResources().getString(R.string.special_game_tab_title);

    public a(TbPageContext<?> tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.mRootView = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(R.layout.ala_special_game_live_item_view, (ViewGroup) null, false);
        this.fLk = (RelativeLayout) this.mRootView.findViewById(R.id.gameUserNameWrapper);
        this.fLi = (TbImageView) this.mRootView.findViewById(R.id.gameTopImg);
        this.fLi.setPlaceHolder(2);
        this.fLj = (RelativeLayout) this.mRootView.findViewById(R.id.gameTopImgLayout);
        this.mRootView.setOnClickListener(this.mOnClickListener);
        this.fLl = (TbImageView) this.mRootView.findViewById(R.id.gameTopLabel);
        this.fLm = (TextView) this.mRootView.findViewById(R.id.gameTopAuthorName);
        this.fID = (TextView) this.mRootView.findViewById(R.id.gameTopAudienceCount);
        this.mTitle = (TextView) this.mRootView.findViewById(R.id.gameLiveItemTitle);
        this.fLk.setBackgroundDrawable(new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, this.fLq));
        int equipmentWidth = l.getEquipmentWidth(this.mRootView.getContext());
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fLj.getLayoutParams();
        layoutParams.width = (equipmentWidth - (this.mTbPageContext.getResources().getDimensionPixelSize(R.dimen.tbds6) * 3)) / 2;
        layoutParams.height = (int) (layoutParams.width * 0.558f);
        this.fLj.setLayoutParams(layoutParams);
    }

    public View getView() {
        return this.mRootView;
    }

    public void b(com.baidu.tieba.ala.alasquare.subtablist.c.h hVar) {
        this.fLo = hVar;
    }

    public void a(com.baidu.tieba.ala.alasquare.a.a aVar) {
        a(aVar, this.fLp);
    }

    public void a(com.baidu.tieba.ala.alasquare.a.a aVar, String str) {
        if (aVar == null || aVar.fCu == null) {
            getView().setVisibility(4);
            return;
        }
        this.fIv = aVar;
        getView().setVisibility(0);
        this.fLi.startLoad(aVar.fCu.liveInfo.cover, 10, false);
        this.fID.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.square_sub_live_audience_label, at.numberUniformFormatExtra(aVar.fCu.liveInfo.audienceCount)));
        this.fLm.setText(aVar.fCu.liveAuthor.name);
        this.mTitle.setText(aVar.fCu.title);
        if (TbadkCoreApplication.getInst().getSkinType() == 4) {
            this.fLn = aVar.fCu.recom_extra_img_dark;
        } else if (TbadkCoreApplication.getInst().getSkinType() == 1) {
            this.fLn = aVar.fCu.recom_extra_img_night;
        } else {
            this.fLn = aVar.fCu.recom_extra_img;
        }
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
        TiebaStatic.log(new aq("c12903").dD("entryname", str));
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setViewTextColor(this.fID, (int) R.color.cp_cont_a);
            ap.setViewTextColor(this.fLm, (int) R.color.cp_cont_a);
            ap.setViewTextColor(this.mTitle, (int) R.color.cp_cont_b);
            if (!StringUtils.isNull(this.fLn)) {
                this.fLl.setVisibility(0);
                this.fLl.startLoad(this.fLn, 10, false);
            } else {
                this.fLl.setVisibility(8);
            }
            Drawable drawable = ap.getDrawable(this.mTbPageContext.getResources(), (int) R.drawable.tab_icon_living_seeding);
            drawable.setBounds(0, 0, this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds15), this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds15));
            this.fID.setCompoundDrawablePadding(this.mTbPageContext.getResources().getDimensionPixelSize(R.dimen.tbds14));
            this.fID.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
            this.mSkinType = i;
        }
    }
}
