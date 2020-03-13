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
    private a esU;
    private int esV;
    private TbPageContext mTbPageContext;

    public d(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        this.esV = 28;
        this.mTbPageContext = tbPageContext;
        this.esU = new a(this);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        am.setViewTextColor(this.esU.esY, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.esU.esZ, (int) R.color.cp_cont_d);
        am.setViewTextColor(this.esU.eta, (int) R.color.cp_cont_d);
        am.setViewTextColor(this.esU.eqA, (int) R.color.common_color_10140);
        am.setViewTextColor(this.esU.eqt, (int) R.color.cp_cont_d);
        am.getDrawable(this.mContext.getResources(), (int) R.drawable.icon_video_direct_seeding).setBounds(0, 0, this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds8), this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds8));
        this.esU.eqt.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(this.mContext.getResources(), (int) R.drawable.icon_living_seeding), (Drawable) null, (Drawable) null, (Drawable) null);
        am.setBackgroundColor(this.esU.cVU, R.color.cp_bg_line_c);
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
                this.esU.esX.startLoad(fVar.mUserData.getPortrait(), 12, false);
            }
            if (!StringUtils.isNull(fVar.mUserData.getName_show())) {
                this.esU.esY.setText(fVar.mUserData.getName_show());
            }
            if (fVar.erG) {
                if (fVar.mUserData.hadConcerned()) {
                    this.esU.eqA.setVisibility(8);
                    this.esU.eta.setVisibility(0);
                } else {
                    this.esU.eqA.setVisibility(0);
                    this.esU.eta.setVisibility(8);
                }
            } else {
                this.esU.eqA.setVisibility(8);
                this.esU.eta.setVisibility(8);
            }
            this.esU.eqA.setTag(fVar.mUserData);
        }
        if (fVar.erF != null) {
            this.esU.cug.setTag(fVar.erF);
            if (!StringUtils.isNull(fVar.erF.description)) {
                String str = fVar.erF.description;
                int i = this.esV;
                if (fVar.erG) {
                    i -= 9;
                }
                this.esU.esZ.setText(k.byteLength(str) > i ? aq.cutChineseAndEnglishWithSuffix(str, i, StringHelper.STRING_MORE) : str);
            }
        }
        if (fVar.erG) {
            TiebaStatic.log(new an("c12895"));
        } else {
            TiebaStatic.log(new an("c12893"));
        }
        this.esU.eqA.setTag(fVar.mUserData);
        onChangeSkinType(getTbPageContext(), TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    /* loaded from: classes3.dex */
    public class a extends v.a {
        public View cVU;
        public View cug;
        public TextView eqA;
        public TextView eqt;
        public d esW;
        public TbImageView esX;
        public TextView esY;
        public TextView esZ;
        public TextView eta;
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
                        d.this.esU.eqA.setVisibility(8);
                        d.this.esU.eta.setVisibility(0);
                        TiebaStatic.log(new an("c12897"));
                    }
                }
            };
            this.esW = dVar;
            this.cug = dVar.getView();
            this.esX = (TbImageView) this.cug.findViewById(R.id.protrait);
            this.esX.setDefaultResource(R.drawable.icon_default_avatar100_bg);
            this.esX.setIsRound(true);
            this.esX.setAutoChangeStyle(false);
            this.esX.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.esY = (TextView) this.cug.findViewById(R.id.live_title);
            this.eqt = (TextView) this.cug.findViewById(R.id.living_tag);
            this.cVU = this.cug.findViewById(R.id.devider_line);
            Drawable drawable = am.getDrawable(d.this.mContext.getResources(), (int) R.drawable.icon_living_seeding);
            drawable.setBounds(0, 0, d.this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds8), d.this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds8));
            this.eqt.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
            this.esZ = (TextView) this.cug.findViewById(R.id.user_name);
            this.eqA = (TextView) this.cug.findViewById(R.id.follow_btn);
            this.eta = (TextView) this.cug.findViewById(R.id.followed_btn);
            this.eqA.setOnClickListener(this.mOnClickListener);
        }
    }
}
