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
/* loaded from: classes2.dex */
public class d extends com.baidu.tieba.card.a<com.baidu.tieba.ala.alasquare.special_forum.data.f> {
    private a eow;
    private int eox;
    private TbPageContext mTbPageContext;

    public d(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        this.eox = 28;
        this.mTbPageContext = tbPageContext;
        this.eow = new a(this);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        am.setViewTextColor(this.eow.eoA, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.eow.eoB, (int) R.color.cp_cont_d);
        am.setViewTextColor(this.eow.eoC, (int) R.color.cp_cont_d);
        am.setViewTextColor(this.eow.elY, (int) R.color.common_color_10140);
        am.setViewTextColor(this.eow.elR, (int) R.color.cp_cont_d);
        am.getDrawable(this.mContext.getResources(), (int) R.drawable.icon_video_direct_seeding).setBounds(0, 0, this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds8), this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds8));
        this.eow.elR.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(this.mContext.getResources(), (int) R.drawable.icon_living_seeding), (Drawable) null, (Drawable) null, (Drawable) null);
        am.setBackgroundColor(this.eow.cRQ, R.color.cp_bg_line_c);
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
                this.eow.eoz.startLoad(fVar.mUserData.getPortrait(), 12, false);
            }
            if (!StringUtils.isNull(fVar.mUserData.getName_show())) {
                this.eow.eoA.setText(fVar.mUserData.getName_show());
            }
            if (fVar.enf) {
                if (fVar.mUserData.hadConcerned()) {
                    this.eow.elY.setVisibility(8);
                    this.eow.eoC.setVisibility(0);
                } else {
                    this.eow.elY.setVisibility(0);
                    this.eow.eoC.setVisibility(8);
                }
            } else {
                this.eow.elY.setVisibility(8);
                this.eow.eoC.setVisibility(8);
            }
            this.eow.elY.setTag(fVar.mUserData);
        }
        if (fVar.ene != null) {
            this.eow.cqd.setTag(fVar.ene);
            if (!StringUtils.isNull(fVar.ene.description)) {
                String str = fVar.ene.description;
                int i = this.eox;
                if (fVar.enf) {
                    i -= 9;
                }
                this.eow.eoB.setText(k.byteLength(str) > i ? aq.cutChineseAndEnglishWithSuffix(str, i, StringHelper.STRING_MORE) : str);
            }
        }
        if (fVar.enf) {
            TiebaStatic.log(new an("c12895"));
        } else {
            TiebaStatic.log(new an("c12893"));
        }
        this.eow.elY.setTag(fVar.mUserData);
        onChangeSkinType(getTbPageContext(), TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    /* loaded from: classes2.dex */
    public class a extends v.a {
        public View cRQ;
        public View cqd;
        public TextView elR;
        public TextView elY;
        public TextView eoA;
        public TextView eoB;
        public TextView eoC;
        public d eoy;
        public TbImageView eoz;
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
                        d.this.eow.elY.setVisibility(8);
                        d.this.eow.eoC.setVisibility(0);
                        TiebaStatic.log(new an("c12897"));
                    }
                }
            };
            this.eoy = dVar;
            this.cqd = dVar.getView();
            this.eoz = (TbImageView) this.cqd.findViewById(R.id.protrait);
            this.eoz.setDefaultResource(R.drawable.icon_default_avatar100_bg);
            this.eoz.setIsRound(true);
            this.eoz.setAutoChangeStyle(false);
            this.eoz.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.eoA = (TextView) this.cqd.findViewById(R.id.live_title);
            this.elR = (TextView) this.cqd.findViewById(R.id.living_tag);
            this.cRQ = this.cqd.findViewById(R.id.devider_line);
            Drawable drawable = am.getDrawable(d.this.mContext.getResources(), (int) R.drawable.icon_living_seeding);
            drawable.setBounds(0, 0, d.this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds8), d.this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds8));
            this.elR.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
            this.eoB = (TextView) this.cqd.findViewById(R.id.user_name);
            this.elY = (TextView) this.cqd.findViewById(R.id.follow_btn);
            this.eoC = (TextView) this.cqd.findViewById(R.id.followed_btn);
            this.elY.setOnClickListener(this.mOnClickListener);
        }
    }
}
