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
    private a esG;
    private int esH;
    private TbPageContext mTbPageContext;

    public d(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        this.esH = 28;
        this.mTbPageContext = tbPageContext;
        this.esG = new a(this);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        am.setViewTextColor(this.esG.esK, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.esG.esL, (int) R.color.cp_cont_d);
        am.setViewTextColor(this.esG.esM, (int) R.color.cp_cont_d);
        am.setViewTextColor(this.esG.eqm, (int) R.color.common_color_10140);
        am.setViewTextColor(this.esG.eqf, (int) R.color.cp_cont_d);
        am.getDrawable(this.mContext.getResources(), (int) R.drawable.icon_video_direct_seeding).setBounds(0, 0, this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds8), this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds8));
        this.esG.eqf.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(this.mContext.getResources(), (int) R.drawable.icon_living_seeding), (Drawable) null, (Drawable) null, (Drawable) null);
        am.setBackgroundColor(this.esG.cVS, R.color.cp_bg_line_c);
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
                this.esG.esJ.startLoad(fVar.mUserData.getPortrait(), 12, false);
            }
            if (!StringUtils.isNull(fVar.mUserData.getName_show())) {
                this.esG.esK.setText(fVar.mUserData.getName_show());
            }
            if (fVar.ers) {
                if (fVar.mUserData.hadConcerned()) {
                    this.esG.eqm.setVisibility(8);
                    this.esG.esM.setVisibility(0);
                } else {
                    this.esG.eqm.setVisibility(0);
                    this.esG.esM.setVisibility(8);
                }
            } else {
                this.esG.eqm.setVisibility(8);
                this.esG.esM.setVisibility(8);
            }
            this.esG.eqm.setTag(fVar.mUserData);
        }
        if (fVar.erq != null) {
            this.esG.cue.setTag(fVar.erq);
            if (!StringUtils.isNull(fVar.erq.description)) {
                String str = fVar.erq.description;
                int i = this.esH;
                if (fVar.ers) {
                    i -= 9;
                }
                this.esG.esL.setText(k.byteLength(str) > i ? aq.cutChineseAndEnglishWithSuffix(str, i, StringHelper.STRING_MORE) : str);
            }
        }
        if (fVar.ers) {
            TiebaStatic.log(new an("c12895"));
        } else {
            TiebaStatic.log(new an("c12893"));
        }
        this.esG.eqm.setTag(fVar.mUserData);
        onChangeSkinType(getTbPageContext(), TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    /* loaded from: classes3.dex */
    public class a extends v.a {
        public View cVS;
        public View cue;
        public TextView eqf;
        public TextView eqm;
        public d esI;
        public TbImageView esJ;
        public TextView esK;
        public TextView esL;
        public TextView esM;
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
                        d.this.esG.eqm.setVisibility(8);
                        d.this.esG.esM.setVisibility(0);
                        TiebaStatic.log(new an("c12897"));
                    }
                }
            };
            this.esI = dVar;
            this.cue = dVar.getView();
            this.esJ = (TbImageView) this.cue.findViewById(R.id.protrait);
            this.esJ.setDefaultResource(R.drawable.icon_default_avatar100_bg);
            this.esJ.setIsRound(true);
            this.esJ.setAutoChangeStyle(false);
            this.esJ.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.esK = (TextView) this.cue.findViewById(R.id.live_title);
            this.eqf = (TextView) this.cue.findViewById(R.id.living_tag);
            this.cVS = this.cue.findViewById(R.id.devider_line);
            Drawable drawable = am.getDrawable(d.this.mContext.getResources(), (int) R.drawable.icon_living_seeding);
            drawable.setBounds(0, 0, d.this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds8), d.this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds8));
            this.eqf.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
            this.esL = (TextView) this.cue.findViewById(R.id.user_name);
            this.eqm = (TextView) this.cue.findViewById(R.id.follow_btn);
            this.esM = (TextView) this.cue.findViewById(R.id.followed_btn);
            this.eqm.setOnClickListener(this.mOnClickListener);
        }
    }
}
