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
    private a glm;
    private int gln;
    private TbPageContext mTbPageContext;

    public d(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        this.gln = 28;
        this.mTbPageContext = tbPageContext;
        this.glm = new a(this);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        ap.setViewTextColor(this.glm.glq, R.color.cp_cont_b);
        ap.setViewTextColor(this.glm.glr, R.color.cp_cont_d);
        ap.setViewTextColor(this.glm.gls, R.color.cp_cont_d);
        ap.setViewTextColor(this.glm.giU, R.color.common_color_10140);
        ap.setViewTextColor(this.glm.giN, R.color.cp_cont_d);
        ap.getDrawable(this.mContext.getResources(), R.drawable.icon_video_direct_seeding).setBounds(0, 0, this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds8), this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds8));
        this.glm.giN.setCompoundDrawablesWithIntrinsicBounds(ap.getDrawable(this.mContext.getResources(), R.drawable.icon_living_seeding), (Drawable) null, (Drawable) null, (Drawable) null);
        ap.setBackgroundColor(this.glm.eCZ, R.color.cp_bg_line_c);
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
                this.glm.glp.startLoad(fVar.mUserData.getPortrait(), 12, false);
            }
            if (!StringUtils.isNull(fVar.mUserData.getName_show())) {
                this.glm.glq.setText(fVar.mUserData.getName_show());
            }
            if (fVar.gjY) {
                if (fVar.mUserData.hadConcerned()) {
                    this.glm.giU.setVisibility(8);
                    this.glm.gls.setVisibility(0);
                } else {
                    this.glm.giU.setVisibility(0);
                    this.glm.gls.setVisibility(8);
                }
            } else {
                this.glm.giU.setVisibility(8);
                this.glm.gls.setVisibility(8);
            }
            this.glm.giU.setTag(fVar.mUserData);
        }
        if (fVar.gjX != null) {
            this.glm.dVJ.setTag(fVar.gjX);
            if (!StringUtils.isNull(fVar.gjX.description)) {
                String str = fVar.gjX.description;
                int i = this.gln;
                if (fVar.gjY) {
                    i -= 9;
                }
                this.glm.glr.setText(k.byteLength(str) > i ? at.cutChineseAndEnglishWithSuffix(str, i, StringHelper.STRING_MORE) : str);
            }
        }
        if (fVar.gjY) {
            TiebaStatic.log(new aq("c12895"));
        } else {
            TiebaStatic.log(new aq("c12893"));
        }
        this.glm.giU.setTag(fVar.mUserData);
        onChangeSkinType(getTbPageContext(), TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    /* loaded from: classes4.dex */
    public class a extends af.a {
        public View dVJ;
        public View eCZ;
        public TextView giN;
        public TextView giU;
        public d glo;
        public TbImageView glp;
        public TextView glq;
        public TextView glr;
        public TextView gls;
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
                        d.this.glm.giU.setVisibility(8);
                        d.this.glm.gls.setVisibility(0);
                        TiebaStatic.log(new aq("c12897"));
                    }
                }
            };
            this.glo = dVar;
            this.dVJ = dVar.getView();
            this.glp = (TbImageView) this.dVJ.findViewById(R.id.protrait);
            this.glp.setDefaultResource(R.drawable.icon_default_avatar100_bg);
            this.glp.setIsRound(true);
            this.glp.setAutoChangeStyle(false);
            this.glp.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.glq = (TextView) this.dVJ.findViewById(R.id.live_title);
            this.giN = (TextView) this.dVJ.findViewById(R.id.living_tag);
            this.eCZ = this.dVJ.findViewById(R.id.devider_line);
            Drawable drawable = ap.getDrawable(d.this.mContext.getResources(), R.drawable.icon_living_seeding);
            drawable.setBounds(0, 0, d.this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds8), d.this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds8));
            this.giN.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
            this.glr = (TextView) this.dVJ.findViewById(R.id.user_name);
            this.giU = (TextView) this.dVJ.findViewById(R.id.follow_btn);
            this.gls = (TextView) this.dVJ.findViewById(R.id.followed_btn);
            this.giU.setOnClickListener(this.mOnClickListener);
        }
    }
}
