package com.baidu.tieba.ala.alasquare.special_forum.subtab.a;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.k;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.aa;
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
public class d extends com.baidu.tieba.card.b<com.baidu.tieba.ala.alasquare.special_forum.data.f> {
    private a fjB;
    private int fjC;
    private TbPageContext mTbPageContext;

    public d(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        this.fjC = 28;
        this.mTbPageContext = tbPageContext;
        this.fjB = new a(this);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        am.setViewTextColor(this.fjB.fjF, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.fjB.fjG, (int) R.color.cp_cont_d);
        am.setViewTextColor(this.fjB.fjH, (int) R.color.cp_cont_d);
        am.setViewTextColor(this.fjB.fhg, (int) R.color.common_color_10140);
        am.setViewTextColor(this.fjB.fgZ, (int) R.color.cp_cont_d);
        am.getDrawable(this.mContext.getResources(), (int) R.drawable.icon_video_direct_seeding).setBounds(0, 0, this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds8), this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds8));
        this.fjB.fgZ.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(this.mContext.getResources(), (int) R.drawable.icon_living_seeding), (Drawable) null, (Drawable) null, (Drawable) null);
        am.setBackgroundColor(this.fjB.dJr, R.color.cp_bg_line_c);
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
                this.fjB.fjE.startLoad(fVar.mUserData.getPortrait(), 12, false);
            }
            if (!StringUtils.isNull(fVar.mUserData.getName_show())) {
                this.fjB.fjF.setText(fVar.mUserData.getName_show());
            }
            if (fVar.fim) {
                if (fVar.mUserData.hadConcerned()) {
                    this.fjB.fhg.setVisibility(8);
                    this.fjB.fjH.setVisibility(0);
                } else {
                    this.fjB.fhg.setVisibility(0);
                    this.fjB.fjH.setVisibility(8);
                }
            } else {
                this.fjB.fhg.setVisibility(8);
                this.fjB.fjH.setVisibility(8);
            }
            this.fjB.fhg.setTag(fVar.mUserData);
        }
        if (fVar.fil != null) {
            this.fjB.dex.setTag(fVar.fil);
            if (!StringUtils.isNull(fVar.fil.description)) {
                String str = fVar.fil.description;
                int i = this.fjC;
                if (fVar.fim) {
                    i -= 9;
                }
                this.fjB.fjG.setText(k.byteLength(str) > i ? aq.cutChineseAndEnglishWithSuffix(str, i, StringHelper.STRING_MORE) : str);
            }
        }
        if (fVar.fim) {
            TiebaStatic.log(new an("c12895"));
        } else {
            TiebaStatic.log(new an("c12893"));
        }
        this.fjB.fhg.setTag(fVar.mUserData);
        onChangeSkinType(getTbPageContext(), TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    /* loaded from: classes3.dex */
    public class a extends aa.a {
        public View dJr;
        public View dex;
        public TextView fgZ;
        public TextView fhg;
        public d fjD;
        public TbImageView fjE;
        public TextView fjF;
        public TextView fjG;
        public TextView fjH;
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
                        d.this.fjB.fhg.setVisibility(8);
                        d.this.fjB.fjH.setVisibility(0);
                        TiebaStatic.log(new an("c12897"));
                    }
                }
            };
            this.fjD = dVar;
            this.dex = dVar.getView();
            this.fjE = (TbImageView) this.dex.findViewById(R.id.protrait);
            this.fjE.setDefaultResource(R.drawable.icon_default_avatar100_bg);
            this.fjE.setIsRound(true);
            this.fjE.setAutoChangeStyle(false);
            this.fjE.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.fjF = (TextView) this.dex.findViewById(R.id.live_title);
            this.fgZ = (TextView) this.dex.findViewById(R.id.living_tag);
            this.dJr = this.dex.findViewById(R.id.devider_line);
            Drawable drawable = am.getDrawable(d.this.mContext.getResources(), (int) R.drawable.icon_living_seeding);
            drawable.setBounds(0, 0, d.this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds8), d.this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds8));
            this.fgZ.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
            this.fjG = (TextView) this.dex.findViewById(R.id.user_name);
            this.fhg = (TextView) this.dex.findViewById(R.id.follow_btn);
            this.fjH = (TextView) this.dex.findViewById(R.id.followed_btn);
            this.fhg.setOnClickListener(this.mOnClickListener);
        }
    }
}
