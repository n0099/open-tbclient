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
    private a fOQ;
    private int fOR;
    private TbPageContext mTbPageContext;

    public d(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        this.fOR = 28;
        this.mTbPageContext = tbPageContext;
        this.fOQ = new a(this);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        ap.setViewTextColor(this.fOQ.fOU, R.color.cp_cont_b);
        ap.setViewTextColor(this.fOQ.fOV, R.color.cp_cont_d);
        ap.setViewTextColor(this.fOQ.fOW, R.color.cp_cont_d);
        ap.setViewTextColor(this.fOQ.fMy, R.color.common_color_10140);
        ap.setViewTextColor(this.fOQ.fMr, R.color.cp_cont_d);
        ap.getDrawable(this.mContext.getResources(), R.drawable.icon_video_direct_seeding).setBounds(0, 0, this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds8), this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds8));
        this.fOQ.fMr.setCompoundDrawablesWithIntrinsicBounds(ap.getDrawable(this.mContext.getResources(), R.drawable.icon_living_seeding), (Drawable) null, (Drawable) null, (Drawable) null);
        ap.setBackgroundColor(this.fOQ.eis, R.color.cp_bg_line_c);
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
                this.fOQ.fOT.startLoad(fVar.mUserData.getPortrait(), 12, false);
            }
            if (!StringUtils.isNull(fVar.mUserData.getName_show())) {
                this.fOQ.fOU.setText(fVar.mUserData.getName_show());
            }
            if (fVar.fNC) {
                if (fVar.mUserData.hadConcerned()) {
                    this.fOQ.fMy.setVisibility(8);
                    this.fOQ.fOW.setVisibility(0);
                } else {
                    this.fOQ.fMy.setVisibility(0);
                    this.fOQ.fOW.setVisibility(8);
                }
            } else {
                this.fOQ.fMy.setVisibility(8);
                this.fOQ.fOW.setVisibility(8);
            }
            this.fOQ.fMy.setTag(fVar.mUserData);
        }
        if (fVar.fNB != null) {
            this.fOQ.dBl.setTag(fVar.fNB);
            if (!StringUtils.isNull(fVar.fNB.description)) {
                String str = fVar.fNB.description;
                int i = this.fOR;
                if (fVar.fNC) {
                    i -= 9;
                }
                this.fOQ.fOV.setText(k.byteLength(str) > i ? at.cutChineseAndEnglishWithSuffix(str, i, StringHelper.STRING_MORE) : str);
            }
        }
        if (fVar.fNC) {
            TiebaStatic.log(new aq("c12895"));
        } else {
            TiebaStatic.log(new aq("c12893"));
        }
        this.fOQ.fMy.setTag(fVar.mUserData);
        onChangeSkinType(getTbPageContext(), TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    /* loaded from: classes4.dex */
    public class a extends af.a {
        public View dBl;
        public View eis;
        public TextView fMr;
        public TextView fMy;
        public d fOS;
        public TbImageView fOT;
        public TextView fOU;
        public TextView fOV;
        public TextView fOW;
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
                        d.this.fOQ.fMy.setVisibility(8);
                        d.this.fOQ.fOW.setVisibility(0);
                        TiebaStatic.log(new aq("c12897"));
                    }
                }
            };
            this.fOS = dVar;
            this.dBl = dVar.getView();
            this.fOT = (TbImageView) this.dBl.findViewById(R.id.protrait);
            this.fOT.setDefaultResource(R.drawable.icon_default_avatar100_bg);
            this.fOT.setIsRound(true);
            this.fOT.setAutoChangeStyle(false);
            this.fOT.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.fOU = (TextView) this.dBl.findViewById(R.id.live_title);
            this.fMr = (TextView) this.dBl.findViewById(R.id.living_tag);
            this.eis = this.dBl.findViewById(R.id.devider_line);
            Drawable drawable = ap.getDrawable(d.this.mContext.getResources(), R.drawable.icon_living_seeding);
            drawable.setBounds(0, 0, d.this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds8), d.this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds8));
            this.fMr.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
            this.fOV = (TextView) this.dBl.findViewById(R.id.user_name);
            this.fMy = (TextView) this.dBl.findViewById(R.id.follow_btn);
            this.fOW = (TextView) this.dBl.findViewById(R.id.followed_btn);
            this.fMy.setOnClickListener(this.mOnClickListener);
        }
    }
}
