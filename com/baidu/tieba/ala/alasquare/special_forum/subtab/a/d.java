package com.baidu.tieba.ala.alasquare.special_forum.subtab.a;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.k;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.af;
import com.baidu.ala.data.AlaAttentionData;
import com.baidu.ala.view.AlaAttentionManager;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class d extends com.baidu.tieba.card.b<com.baidu.tieba.ala.alasquare.special_forum.data.f> {
    private a gbi;
    private int gbj;
    private TbPageContext mTbPageContext;

    public d(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        this.gbj = 28;
        this.mTbPageContext = tbPageContext;
        this.gbi = new a(this);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        ap.setViewTextColor(this.gbi.gbm, R.color.cp_cont_b);
        ap.setViewTextColor(this.gbi.gbn, R.color.cp_cont_d);
        ap.setViewTextColor(this.gbi.gbo, R.color.cp_cont_d);
        ap.setViewTextColor(this.gbi.fYP, R.color.common_color_10140);
        ap.setViewTextColor(this.gbi.fYI, R.color.cp_cont_d);
        ap.getDrawable(this.mContext.getResources(), R.drawable.icon_video_direct_seeding).setBounds(0, 0, this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds8), this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds8));
        this.gbi.fYI.setCompoundDrawablesWithIntrinsicBounds(ap.getDrawable(this.mContext.getResources(), R.drawable.icon_living_seeding), (Drawable) null, (Drawable) null, (Drawable) null);
        ap.setBackgroundColor(this.gbi.euA, R.color.cp_bg_line_c);
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.special_bar_concern_live_item;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.ala.alasquare.special_forum.data.f fVar) {
        if (fVar.mUserData != null) {
            if (!StringUtils.isNull(fVar.mUserData.getPortrait())) {
                this.gbi.gbl.startLoad(fVar.mUserData.getPortrait(), 12, false);
            }
            if (!StringUtils.isNull(fVar.mUserData.getName_show())) {
                this.gbi.gbm.setText(fVar.mUserData.getName_show());
            }
            if (fVar.fZT) {
                if (fVar.mUserData.hadConcerned()) {
                    this.gbi.fYP.setVisibility(8);
                    this.gbi.gbo.setVisibility(0);
                } else {
                    this.gbi.fYP.setVisibility(0);
                    this.gbi.gbo.setVisibility(8);
                }
            } else {
                this.gbi.fYP.setVisibility(8);
                this.gbi.gbo.setVisibility(8);
            }
            this.gbi.fYP.setTag(fVar.mUserData);
        }
        if (fVar.fZS != null) {
            this.gbi.dNm.setTag(fVar.fZS);
            if (!StringUtils.isNull(fVar.fZS.description)) {
                String str = fVar.fZS.description;
                int i = this.gbj;
                if (fVar.fZT) {
                    i -= 9;
                }
                this.gbi.gbn.setText(k.byteLength(str) > i ? at.cutChineseAndEnglishWithSuffix(str, i, StringHelper.STRING_MORE) : str);
            }
        }
        if (fVar.fZT) {
            TiebaStatic.log(new aq("c12895"));
        } else {
            TiebaStatic.log(new aq("c12893"));
        }
        this.gbi.fYP.setTag(fVar.mUserData);
        onChangeSkinType(getTbPageContext(), TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    /* loaded from: classes4.dex */
    public class a extends af.a {
        public View dNm;
        public View euA;
        public TextView fYI;
        public TextView fYP;
        public d gbk;
        public TbImageView gbl;
        public TextView gbm;
        public TextView gbn;
        public TextView gbo;
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
                        d.this.gbi.fYP.setVisibility(8);
                        d.this.gbi.gbo.setVisibility(0);
                        TiebaStatic.log(new aq("c12897"));
                    }
                }
            };
            this.gbk = dVar;
            this.dNm = dVar.getView();
            this.gbl = (TbImageView) this.dNm.findViewById(R.id.protrait);
            this.gbl.setDefaultResource(R.drawable.icon_default_avatar100_bg);
            this.gbl.setIsRound(true);
            this.gbl.setAutoChangeStyle(false);
            this.gbl.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.gbm = (TextView) this.dNm.findViewById(R.id.live_title);
            this.fYI = (TextView) this.dNm.findViewById(R.id.living_tag);
            this.euA = this.dNm.findViewById(R.id.devider_line);
            Drawable drawable = ap.getDrawable(d.this.mContext.getResources(), R.drawable.icon_living_seeding);
            drawable.setBounds(0, 0, d.this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds8), d.this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds8));
            this.fYI.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
            this.gbn = (TextView) this.dNm.findViewById(R.id.user_name);
            this.fYP = (TextView) this.dNm.findViewById(R.id.follow_btn);
            this.gbo = (TextView) this.dNm.findViewById(R.id.followed_btn);
            this.fYP.setOnClickListener(this.mOnClickListener);
        }
    }
}
