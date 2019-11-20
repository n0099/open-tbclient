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
/* loaded from: classes6.dex */
public class c extends com.baidu.tieba.card.a<com.baidu.tieba.ala.alasquare.special_forum.data.f> {
    private a dCk;
    private int dCl;
    private TbPageContext mTbPageContext;

    public c(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        this.dCl = 28;
        this.mTbPageContext = tbPageContext;
        this.dCk = new a(this);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        am.setViewTextColor(this.dCk.dCo, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.dCk.dCp, (int) R.color.cp_cont_d);
        am.setViewTextColor(this.dCk.dCq, (int) R.color.cp_cont_d);
        am.setViewTextColor(this.dCk.dAd, (int) R.color.common_color_10140);
        am.setViewTextColor(this.dCk.dzV, (int) R.color.cp_cont_d);
        am.getDrawable(this.mContext.getResources(), (int) R.drawable.icon_video_direct_seeding).setBounds(0, 0, this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds8), this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds8));
        this.dCk.dzV.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(this.mContext.getResources(), (int) R.drawable.icon_living_seeding), (Drawable) null, (Drawable) null, (Drawable) null);
        am.setBackgroundColor(this.dCk.cfh, R.color.cp_bg_line_c);
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
                this.dCk.dCn.startLoad(fVar.mUserData.getPortrait(), 12, false);
            }
            if (!StringUtils.isNull(fVar.mUserData.getName_show())) {
                this.dCk.dCo.setText(fVar.mUserData.getName_show());
            }
            if (fVar.dBj) {
                if (fVar.mUserData.hadConcerned()) {
                    this.dCk.dAd.setVisibility(8);
                    this.dCk.dCq.setVisibility(0);
                } else {
                    this.dCk.dAd.setVisibility(0);
                    this.dCk.dCq.setVisibility(8);
                }
            } else {
                this.dCk.dAd.setVisibility(8);
                this.dCk.dCq.setVisibility(8);
            }
            this.dCk.dAd.setTag(fVar.mUserData);
        }
        if (fVar.dBi != null) {
            this.dCk.bFk.setTag(fVar.dBi);
            if (!StringUtils.isNull(fVar.dBi.description)) {
                String str = fVar.dBi.description;
                int i = this.dCl;
                if (fVar.dBj) {
                    i -= 9;
                }
                this.dCk.dCp.setText(k.byteLength(str) > i ? aq.cutChineseAndEnglishWithSuffix(str, i, StringHelper.STRING_MORE) : str);
            }
        }
        if (fVar.dBj) {
            TiebaStatic.log(new an("c12895"));
        } else {
            TiebaStatic.log(new an("c12893"));
        }
        this.dCk.dAd.setTag(fVar.mUserData);
        onChangeSkinType(getTbPageContext(), TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    /* loaded from: classes6.dex */
    public class a extends v.a {
        public View bFk;
        public View cfh;
        public TextView dAd;
        public c dCm;
        public TbImageView dCn;
        public TextView dCo;
        public TextView dCp;
        public TextView dCq;
        public TextView dzV;
        private View.OnClickListener mOnClickListener;

        public a(c cVar) {
            super(cVar.getView());
            this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.a.c.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (view.getId() == R.id.follow_btn && (view.getTag() instanceof UserData)) {
                        if (!l.isNetOk()) {
                            c.this.mTbPageContext.showToast(R.string.neterror);
                            return;
                        }
                        UserData userData = (UserData) view.getTag();
                        AlaAttentionManager.getInstance().updateAttention(String.valueOf(userData.getUserId()), new AlaAttentionData(userData.getPortrait(), String.valueOf(userData.getUserId()), "1", true, null));
                        c.this.dCk.dAd.setVisibility(8);
                        c.this.dCk.dCq.setVisibility(0);
                        TiebaStatic.log(new an("c12897"));
                    }
                }
            };
            this.dCm = cVar;
            this.bFk = cVar.getView();
            this.dCn = (TbImageView) this.bFk.findViewById(R.id.protrait);
            this.dCn.setDefaultResource(R.drawable.icon_default_avatar100_bg);
            this.dCn.setIsRound(true);
            this.dCn.setAutoChangeStyle(false);
            this.dCn.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.dCo = (TextView) this.bFk.findViewById(R.id.live_title);
            this.dzV = (TextView) this.bFk.findViewById(R.id.living_tag);
            this.cfh = this.bFk.findViewById(R.id.devider_line);
            Drawable drawable = am.getDrawable(c.this.mContext.getResources(), (int) R.drawable.icon_living_seeding);
            drawable.setBounds(0, 0, c.this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds8), c.this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds8));
            this.dzV.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
            this.dCp = (TextView) this.bFk.findViewById(R.id.user_name);
            this.dAd = (TextView) this.bFk.findViewById(R.id.follow_btn);
            this.dCq = (TextView) this.bFk.findViewById(R.id.followed_btn);
            this.dAd.setOnClickListener(this.mOnClickListener);
        }
    }
}
