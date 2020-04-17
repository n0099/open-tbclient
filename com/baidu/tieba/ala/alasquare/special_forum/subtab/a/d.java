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
    private a eWM;
    private int eWN;
    private TbPageContext mTbPageContext;

    public d(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        this.eWN = 28;
        this.mTbPageContext = tbPageContext;
        this.eWM = new a(this);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        am.setViewTextColor(this.eWM.eWQ, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.eWM.eWR, (int) R.color.cp_cont_d);
        am.setViewTextColor(this.eWM.eWS, (int) R.color.cp_cont_d);
        am.setViewTextColor(this.eWM.eUt, (int) R.color.common_color_10140);
        am.setViewTextColor(this.eWM.eUm, (int) R.color.cp_cont_d);
        am.getDrawable(this.mContext.getResources(), (int) R.drawable.icon_video_direct_seeding).setBounds(0, 0, this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds8), this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds8));
        this.eWM.eUm.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(this.mContext.getResources(), (int) R.drawable.icon_living_seeding), (Drawable) null, (Drawable) null, (Drawable) null);
        am.setBackgroundColor(this.eWM.dvs, R.color.cp_bg_line_c);
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
                this.eWM.eWP.startLoad(fVar.mUserData.getPortrait(), 12, false);
            }
            if (!StringUtils.isNull(fVar.mUserData.getName_show())) {
                this.eWM.eWQ.setText(fVar.mUserData.getName_show());
            }
            if (fVar.eVy) {
                if (fVar.mUserData.hadConcerned()) {
                    this.eWM.eUt.setVisibility(8);
                    this.eWM.eWS.setVisibility(0);
                } else {
                    this.eWM.eUt.setVisibility(0);
                    this.eWM.eWS.setVisibility(8);
                }
            } else {
                this.eWM.eUt.setVisibility(8);
                this.eWM.eWS.setVisibility(8);
            }
            this.eWM.eUt.setTag(fVar.mUserData);
        }
        if (fVar.eVx != null) {
            this.eWM.cTp.setTag(fVar.eVx);
            if (!StringUtils.isNull(fVar.eVx.description)) {
                String str = fVar.eVx.description;
                int i = this.eWN;
                if (fVar.eVy) {
                    i -= 9;
                }
                this.eWM.eWR.setText(k.byteLength(str) > i ? aq.cutChineseAndEnglishWithSuffix(str, i, StringHelper.STRING_MORE) : str);
            }
        }
        if (fVar.eVy) {
            TiebaStatic.log(new an("c12895"));
        } else {
            TiebaStatic.log(new an("c12893"));
        }
        this.eWM.eUt.setTag(fVar.mUserData);
        onChangeSkinType(getTbPageContext(), TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    /* loaded from: classes3.dex */
    public class a extends y.a {
        public View cTp;
        public View dvs;
        public TextView eUm;
        public TextView eUt;
        public d eWO;
        public TbImageView eWP;
        public TextView eWQ;
        public TextView eWR;
        public TextView eWS;
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
                        d.this.eWM.eUt.setVisibility(8);
                        d.this.eWM.eWS.setVisibility(0);
                        TiebaStatic.log(new an("c12897"));
                    }
                }
            };
            this.eWO = dVar;
            this.cTp = dVar.getView();
            this.eWP = (TbImageView) this.cTp.findViewById(R.id.protrait);
            this.eWP.setDefaultResource(R.drawable.icon_default_avatar100_bg);
            this.eWP.setIsRound(true);
            this.eWP.setAutoChangeStyle(false);
            this.eWP.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.eWQ = (TextView) this.cTp.findViewById(R.id.live_title);
            this.eUm = (TextView) this.cTp.findViewById(R.id.living_tag);
            this.dvs = this.cTp.findViewById(R.id.devider_line);
            Drawable drawable = am.getDrawable(d.this.mContext.getResources(), (int) R.drawable.icon_living_seeding);
            drawable.setBounds(0, 0, d.this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds8), d.this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds8));
            this.eUm.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
            this.eWR = (TextView) this.cTp.findViewById(R.id.user_name);
            this.eUt = (TextView) this.cTp.findViewById(R.id.follow_btn);
            this.eWS = (TextView) this.cTp.findViewById(R.id.followed_btn);
            this.eUt.setOnClickListener(this.mOnClickListener);
        }
    }
}
