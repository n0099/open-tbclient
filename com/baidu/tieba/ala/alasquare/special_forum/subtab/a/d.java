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
    private a gqZ;
    private int gra;
    private TbPageContext mTbPageContext;

    public d(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        this.gra = 28;
        this.mTbPageContext = tbPageContext;
        this.gqZ = new a(this);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        ap.setViewTextColor(this.gqZ.grd, (int) R.color.cp_cont_b);
        ap.setViewTextColor(this.gqZ.gre, (int) R.color.cp_cont_d);
        ap.setViewTextColor(this.gqZ.grf, (int) R.color.cp_cont_d);
        ap.setViewTextColor(this.gqZ.goH, (int) R.color.common_color_10140);
        ap.setViewTextColor(this.gqZ.goA, (int) R.color.cp_cont_d);
        ap.getDrawable(this.mContext.getResources(), (int) R.drawable.icon_video_direct_seeding).setBounds(0, 0, this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds8), this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds8));
        this.gqZ.goA.setCompoundDrawablesWithIntrinsicBounds(ap.getDrawable(this.mContext.getResources(), (int) R.drawable.icon_living_seeding), (Drawable) null, (Drawable) null, (Drawable) null);
        ap.setBackgroundColor(this.gqZ.eIO, R.color.cp_bg_line_c);
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
                this.gqZ.grc.startLoad(fVar.mUserData.getPortrait(), 12, false);
            }
            if (!StringUtils.isNull(fVar.mUserData.getName_show())) {
                this.gqZ.grd.setText(fVar.mUserData.getName_show());
            }
            if (fVar.gpL) {
                if (fVar.mUserData.hadConcerned()) {
                    this.gqZ.goH.setVisibility(8);
                    this.gqZ.grf.setVisibility(0);
                } else {
                    this.gqZ.goH.setVisibility(0);
                    this.gqZ.grf.setVisibility(8);
                }
            } else {
                this.gqZ.goH.setVisibility(8);
                this.gqZ.grf.setVisibility(8);
            }
            this.gqZ.goH.setTag(fVar.mUserData);
        }
        if (fVar.gpK != null) {
            this.gqZ.ebB.setTag(fVar.gpK);
            if (!StringUtils.isNull(fVar.gpK.description)) {
                String str = fVar.gpK.description;
                int i = this.gra;
                if (fVar.gpL) {
                    i -= 9;
                }
                this.gqZ.gre.setText(k.byteLength(str) > i ? at.cutChineseAndEnglishWithSuffix(str, i, StringHelper.STRING_MORE) : str);
            }
        }
        if (fVar.gpL) {
            TiebaStatic.log(new aq("c12895"));
        } else {
            TiebaStatic.log(new aq("c12893"));
        }
        this.gqZ.goH.setTag(fVar.mUserData);
        onChangeSkinType(getTbPageContext(), TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    /* loaded from: classes4.dex */
    public class a extends af.a {
        public View eIO;
        public View ebB;
        public TextView goA;
        public TextView goH;
        public d grb;
        public TbImageView grc;
        public TextView grd;
        public TextView gre;
        public TextView grf;
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
                        d.this.gqZ.goH.setVisibility(8);
                        d.this.gqZ.grf.setVisibility(0);
                        TiebaStatic.log(new aq("c12897"));
                    }
                }
            };
            this.grb = dVar;
            this.ebB = dVar.getView();
            this.grc = (TbImageView) this.ebB.findViewById(R.id.protrait);
            this.grc.setDefaultResource(R.drawable.icon_default_avatar100_bg);
            this.grc.setIsRound(true);
            this.grc.setAutoChangeStyle(false);
            this.grc.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.grd = (TextView) this.ebB.findViewById(R.id.live_title);
            this.goA = (TextView) this.ebB.findViewById(R.id.living_tag);
            this.eIO = this.ebB.findViewById(R.id.devider_line);
            Drawable drawable = ap.getDrawable(d.this.mContext.getResources(), (int) R.drawable.icon_living_seeding);
            drawable.setBounds(0, 0, d.this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds8), d.this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds8));
            this.goA.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
            this.gre = (TextView) this.ebB.findViewById(R.id.user_name);
            this.goH = (TextView) this.ebB.findViewById(R.id.follow_btn);
            this.grf = (TextView) this.ebB.findViewById(R.id.followed_btn);
            this.goH.setOnClickListener(this.mOnClickListener);
        }
    }
}
