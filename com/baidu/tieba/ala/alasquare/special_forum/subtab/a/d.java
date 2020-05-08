package com.baidu.tieba.ala.alasquare.special_forum.subtab.a;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.k;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.y;
import com.baidu.ala.data.AlaAttentionData;
import com.baidu.ala.view.AlaAttentionManager;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class d extends com.baidu.tieba.card.a<com.baidu.tieba.ala.alasquare.special_forum.data.f> {
    private a eWR;
    private int eWS;
    private TbPageContext mTbPageContext;

    public d(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        this.eWS = 28;
        this.mTbPageContext = tbPageContext;
        this.eWR = new a(this);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        am.setViewTextColor(this.eWR.eWV, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.eWR.eWW, (int) R.color.cp_cont_d);
        am.setViewTextColor(this.eWR.eWX, (int) R.color.cp_cont_d);
        am.setViewTextColor(this.eWR.eUy, (int) R.color.common_color_10140);
        am.setViewTextColor(this.eWR.eUr, (int) R.color.cp_cont_d);
        am.getDrawable(this.mContext.getResources(), (int) R.drawable.icon_video_direct_seeding).setBounds(0, 0, this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds8), this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds8));
        this.eWR.eUr.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(this.mContext.getResources(), (int) R.drawable.icon_living_seeding), (Drawable) null, (Drawable) null, (Drawable) null);
        am.setBackgroundColor(this.eWR.dvw, R.color.cp_bg_line_c);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.special_bar_concern_live_item;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.ala.alasquare.special_forum.data.f fVar) {
        if (fVar.mUserData != null) {
            if (!StringUtils.isNull(fVar.mUserData.getPortrait())) {
                this.eWR.eWU.startLoad(fVar.mUserData.getPortrait(), 12, false);
            }
            if (!StringUtils.isNull(fVar.mUserData.getName_show())) {
                this.eWR.eWV.setText(fVar.mUserData.getName_show());
            }
            if (fVar.eVD) {
                if (fVar.mUserData.hadConcerned()) {
                    this.eWR.eUy.setVisibility(8);
                    this.eWR.eWX.setVisibility(0);
                } else {
                    this.eWR.eUy.setVisibility(0);
                    this.eWR.eWX.setVisibility(8);
                }
            } else {
                this.eWR.eUy.setVisibility(8);
                this.eWR.eWX.setVisibility(8);
            }
            this.eWR.eUy.setTag(fVar.mUserData);
        }
        if (fVar.eVC != null) {
            this.eWR.cTu.setTag(fVar.eVC);
            if (!StringUtils.isNull(fVar.eVC.description)) {
                String str = fVar.eVC.description;
                int i = this.eWS;
                if (fVar.eVD) {
                    i -= 9;
                }
                this.eWR.eWW.setText(k.byteLength(str) > i ? aq.cutChineseAndEnglishWithSuffix(str, i, StringHelper.STRING_MORE) : str);
            }
        }
        if (fVar.eVD) {
            TiebaStatic.log(new an("c12895"));
        } else {
            TiebaStatic.log(new an("c12893"));
        }
        this.eWR.eUy.setTag(fVar.mUserData);
        onChangeSkinType(getTbPageContext(), TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    /* loaded from: classes3.dex */
    public class a extends y.a {
        public View cTu;
        public View dvw;
        public TextView eUr;
        public TextView eUy;
        public d eWT;
        public TbImageView eWU;
        public TextView eWV;
        public TextView eWW;
        public TextView eWX;
        private View.OnClickListener mOnClickListener;

        public a(d dVar) {
            super(dVar.getView());
            this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.a.d.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (view.getId() == R.id.follow_btn && (view.getTag() instanceof UserData)) {
                        if (!l.isNetOk()) {
                            d.this.mTbPageContext.showToast(R.string.neterror);
                            return;
                        }
                        UserData userData = (UserData) view.getTag();
                        AlaAttentionManager.getInstance().updateAttention(String.valueOf(userData.getUserId()), new AlaAttentionData(userData.getPortrait(), String.valueOf(userData.getUserId()), "1", true, null));
                        d.this.eWR.eUy.setVisibility(8);
                        d.this.eWR.eWX.setVisibility(0);
                        TiebaStatic.log(new an("c12897"));
                    }
                }
            };
            this.eWT = dVar;
            this.cTu = dVar.getView();
            this.eWU = (TbImageView) this.cTu.findViewById(R.id.protrait);
            this.eWU.setDefaultResource(R.drawable.icon_default_avatar100_bg);
            this.eWU.setIsRound(true);
            this.eWU.setAutoChangeStyle(false);
            this.eWU.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.eWV = (TextView) this.cTu.findViewById(R.id.live_title);
            this.eUr = (TextView) this.cTu.findViewById(R.id.living_tag);
            this.dvw = this.cTu.findViewById(R.id.devider_line);
            Drawable drawable = am.getDrawable(d.this.mContext.getResources(), (int) R.drawable.icon_living_seeding);
            drawable.setBounds(0, 0, d.this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds8), d.this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds8));
            this.eUr.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
            this.eWW = (TextView) this.cTu.findViewById(R.id.user_name);
            this.eUy = (TextView) this.cTu.findViewById(R.id.follow_btn);
            this.eWX = (TextView) this.cTu.findViewById(R.id.followed_btn);
            this.eUy.setOnClickListener(this.mOnClickListener);
        }
    }
}
