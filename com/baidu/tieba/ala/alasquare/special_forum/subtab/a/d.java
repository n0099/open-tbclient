package com.baidu.tieba.ala.alasquare.special_forum.subtab.a;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.k;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.ad;
import com.baidu.ala.data.AlaAttentionData;
import com.baidu.ala.view.AlaAttentionManager;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class d extends com.baidu.tieba.card.b<com.baidu.tieba.ala.alasquare.special_forum.data.f> {
    private a fAg;
    private int fAh;
    private TbPageContext mTbPageContext;

    public d(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        this.fAh = 28;
        this.mTbPageContext = tbPageContext;
        this.fAg = new a(this);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        ao.setViewTextColor(this.fAg.fAk, R.color.cp_cont_b);
        ao.setViewTextColor(this.fAg.fAl, R.color.cp_cont_d);
        ao.setViewTextColor(this.fAg.fAm, R.color.cp_cont_d);
        ao.setViewTextColor(this.fAg.fxN, R.color.common_color_10140);
        ao.setViewTextColor(this.fAg.fxG, R.color.cp_cont_d);
        ao.getDrawable(this.mContext.getResources(), R.drawable.icon_video_direct_seeding).setBounds(0, 0, this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds8), this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds8));
        this.fAg.fxG.setCompoundDrawablesWithIntrinsicBounds(ao.getDrawable(this.mContext.getResources(), R.drawable.icon_living_seeding), (Drawable) null, (Drawable) null, (Drawable) null);
        ao.setBackgroundColor(this.fAg.dWz, R.color.cp_bg_line_c);
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
                this.fAg.fAj.startLoad(fVar.mUserData.getPortrait(), 12, false);
            }
            if (!StringUtils.isNull(fVar.mUserData.getName_show())) {
                this.fAg.fAk.setText(fVar.mUserData.getName_show());
            }
            if (fVar.fyS) {
                if (fVar.mUserData.hadConcerned()) {
                    this.fAg.fxN.setVisibility(8);
                    this.fAg.fAm.setVisibility(0);
                } else {
                    this.fAg.fxN.setVisibility(0);
                    this.fAg.fAm.setVisibility(8);
                }
            } else {
                this.fAg.fxN.setVisibility(8);
                this.fAg.fAm.setVisibility(8);
            }
            this.fAg.fxN.setTag(fVar.mUserData);
        }
        if (fVar.fyR != null) {
            this.fAg.dpe.setTag(fVar.fyR);
            if (!StringUtils.isNull(fVar.fyR.description)) {
                String str = fVar.fyR.description;
                int i = this.fAh;
                if (fVar.fyS) {
                    i -= 9;
                }
                this.fAg.fAl.setText(k.byteLength(str) > i ? as.cutChineseAndEnglishWithSuffix(str, i, StringHelper.STRING_MORE) : str);
            }
        }
        if (fVar.fyS) {
            TiebaStatic.log(new ap("c12895"));
        } else {
            TiebaStatic.log(new ap("c12893"));
        }
        this.fAg.fxN.setTag(fVar.mUserData);
        onChangeSkinType(getTbPageContext(), TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    /* loaded from: classes4.dex */
    public class a extends ad.a {
        public View dWz;
        public View dpe;
        public d fAi;
        public TbImageView fAj;
        public TextView fAk;
        public TextView fAl;
        public TextView fAm;
        public TextView fxG;
        public TextView fxN;
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
                        d.this.fAg.fxN.setVisibility(8);
                        d.this.fAg.fAm.setVisibility(0);
                        TiebaStatic.log(new ap("c12897"));
                    }
                }
            };
            this.fAi = dVar;
            this.dpe = dVar.getView();
            this.fAj = (TbImageView) this.dpe.findViewById(R.id.protrait);
            this.fAj.setDefaultResource(R.drawable.icon_default_avatar100_bg);
            this.fAj.setIsRound(true);
            this.fAj.setAutoChangeStyle(false);
            this.fAj.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.fAk = (TextView) this.dpe.findViewById(R.id.live_title);
            this.fxG = (TextView) this.dpe.findViewById(R.id.living_tag);
            this.dWz = this.dpe.findViewById(R.id.devider_line);
            Drawable drawable = ao.getDrawable(d.this.mContext.getResources(), R.drawable.icon_living_seeding);
            drawable.setBounds(0, 0, d.this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds8), d.this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds8));
            this.fxG.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
            this.fAl = (TextView) this.dpe.findViewById(R.id.user_name);
            this.fxN = (TextView) this.dpe.findViewById(R.id.follow_btn);
            this.fAm = (TextView) this.dpe.findViewById(R.id.followed_btn);
            this.fxN.setOnClickListener(this.mOnClickListener);
        }
    }
}
