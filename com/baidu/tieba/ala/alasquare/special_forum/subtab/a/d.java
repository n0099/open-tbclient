package com.baidu.tieba.ala.alasquare.special_forum.subtab.a;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.k;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.v;
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
    private a esH;
    private int esI;
    private TbPageContext mTbPageContext;

    public d(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        this.esI = 28;
        this.mTbPageContext = tbPageContext;
        this.esH = new a(this);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        am.setViewTextColor(this.esH.esL, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.esH.esM, (int) R.color.cp_cont_d);
        am.setViewTextColor(this.esH.esN, (int) R.color.cp_cont_d);
        am.setViewTextColor(this.esH.eqn, (int) R.color.common_color_10140);
        am.setViewTextColor(this.esH.eqg, (int) R.color.cp_cont_d);
        am.getDrawable(this.mContext.getResources(), (int) R.drawable.icon_video_direct_seeding).setBounds(0, 0, this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds8), this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds8));
        this.esH.eqg.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(this.mContext.getResources(), (int) R.drawable.icon_living_seeding), (Drawable) null, (Drawable) null, (Drawable) null);
        am.setBackgroundColor(this.esH.cVT, R.color.cp_bg_line_c);
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
                this.esH.esK.startLoad(fVar.mUserData.getPortrait(), 12, false);
            }
            if (!StringUtils.isNull(fVar.mUserData.getName_show())) {
                this.esH.esL.setText(fVar.mUserData.getName_show());
            }
            if (fVar.ert) {
                if (fVar.mUserData.hadConcerned()) {
                    this.esH.eqn.setVisibility(8);
                    this.esH.esN.setVisibility(0);
                } else {
                    this.esH.eqn.setVisibility(0);
                    this.esH.esN.setVisibility(8);
                }
            } else {
                this.esH.eqn.setVisibility(8);
                this.esH.esN.setVisibility(8);
            }
            this.esH.eqn.setTag(fVar.mUserData);
        }
        if (fVar.ers != null) {
            this.esH.cuf.setTag(fVar.ers);
            if (!StringUtils.isNull(fVar.ers.description)) {
                String str = fVar.ers.description;
                int i = this.esI;
                if (fVar.ert) {
                    i -= 9;
                }
                this.esH.esM.setText(k.byteLength(str) > i ? aq.cutChineseAndEnglishWithSuffix(str, i, StringHelper.STRING_MORE) : str);
            }
        }
        if (fVar.ert) {
            TiebaStatic.log(new an("c12895"));
        } else {
            TiebaStatic.log(new an("c12893"));
        }
        this.esH.eqn.setTag(fVar.mUserData);
        onChangeSkinType(getTbPageContext(), TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    /* loaded from: classes3.dex */
    public class a extends v.a {
        public View cVT;
        public View cuf;
        public TextView eqg;
        public TextView eqn;
        public d esJ;
        public TbImageView esK;
        public TextView esL;
        public TextView esM;
        public TextView esN;
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
                        d.this.esH.eqn.setVisibility(8);
                        d.this.esH.esN.setVisibility(0);
                        TiebaStatic.log(new an("c12897"));
                    }
                }
            };
            this.esJ = dVar;
            this.cuf = dVar.getView();
            this.esK = (TbImageView) this.cuf.findViewById(R.id.protrait);
            this.esK.setDefaultResource(R.drawable.icon_default_avatar100_bg);
            this.esK.setIsRound(true);
            this.esK.setAutoChangeStyle(false);
            this.esK.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.esL = (TextView) this.cuf.findViewById(R.id.live_title);
            this.eqg = (TextView) this.cuf.findViewById(R.id.living_tag);
            this.cVT = this.cuf.findViewById(R.id.devider_line);
            Drawable drawable = am.getDrawable(d.this.mContext.getResources(), (int) R.drawable.icon_living_seeding);
            drawable.setBounds(0, 0, d.this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds8), d.this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds8));
            this.eqg.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
            this.esM = (TextView) this.cuf.findViewById(R.id.user_name);
            this.eqn = (TextView) this.cuf.findViewById(R.id.follow_btn);
            this.esN = (TextView) this.cuf.findViewById(R.id.followed_btn);
            this.eqn.setOnClickListener(this.mOnClickListener);
        }
    }
}
