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
    private a etr;
    private int ets;
    private TbPageContext mTbPageContext;

    public d(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        this.ets = 28;
        this.mTbPageContext = tbPageContext;
        this.etr = new a(this);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        am.setViewTextColor(this.etr.etv, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.etr.etw, (int) R.color.cp_cont_d);
        am.setViewTextColor(this.etr.etx, (int) R.color.cp_cont_d);
        am.setViewTextColor(this.etr.eqW, (int) R.color.common_color_10140);
        am.setViewTextColor(this.etr.eqP, (int) R.color.cp_cont_d);
        am.getDrawable(this.mContext.getResources(), (int) R.drawable.icon_video_direct_seeding).setBounds(0, 0, this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds8), this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds8));
        this.etr.eqP.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(this.mContext.getResources(), (int) R.drawable.icon_living_seeding), (Drawable) null, (Drawable) null, (Drawable) null);
        am.setBackgroundColor(this.etr.cWh, R.color.cp_bg_line_c);
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
                this.etr.etu.startLoad(fVar.mUserData.getPortrait(), 12, false);
            }
            if (!StringUtils.isNull(fVar.mUserData.getName_show())) {
                this.etr.etv.setText(fVar.mUserData.getName_show());
            }
            if (fVar.esc) {
                if (fVar.mUserData.hadConcerned()) {
                    this.etr.eqW.setVisibility(8);
                    this.etr.etx.setVisibility(0);
                } else {
                    this.etr.eqW.setVisibility(0);
                    this.etr.etx.setVisibility(8);
                }
            } else {
                this.etr.eqW.setVisibility(8);
                this.etr.etx.setVisibility(8);
            }
            this.etr.eqW.setTag(fVar.mUserData);
        }
        if (fVar.esb != null) {
            this.etr.cus.setTag(fVar.esb);
            if (!StringUtils.isNull(fVar.esb.description)) {
                String str = fVar.esb.description;
                int i = this.ets;
                if (fVar.esc) {
                    i -= 9;
                }
                this.etr.etw.setText(k.byteLength(str) > i ? aq.cutChineseAndEnglishWithSuffix(str, i, StringHelper.STRING_MORE) : str);
            }
        }
        if (fVar.esc) {
            TiebaStatic.log(new an("c12895"));
        } else {
            TiebaStatic.log(new an("c12893"));
        }
        this.etr.eqW.setTag(fVar.mUserData);
        onChangeSkinType(getTbPageContext(), TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    /* loaded from: classes3.dex */
    public class a extends v.a {
        public View cWh;
        public View cus;
        public TextView eqP;
        public TextView eqW;
        public d ett;
        public TbImageView etu;
        public TextView etv;
        public TextView etw;
        public TextView etx;
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
                        d.this.etr.eqW.setVisibility(8);
                        d.this.etr.etx.setVisibility(0);
                        TiebaStatic.log(new an("c12897"));
                    }
                }
            };
            this.ett = dVar;
            this.cus = dVar.getView();
            this.etu = (TbImageView) this.cus.findViewById(R.id.protrait);
            this.etu.setDefaultResource(R.drawable.icon_default_avatar100_bg);
            this.etu.setIsRound(true);
            this.etu.setAutoChangeStyle(false);
            this.etu.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.etv = (TextView) this.cus.findViewById(R.id.live_title);
            this.eqP = (TextView) this.cus.findViewById(R.id.living_tag);
            this.cWh = this.cus.findViewById(R.id.devider_line);
            Drawable drawable = am.getDrawable(d.this.mContext.getResources(), (int) R.drawable.icon_living_seeding);
            drawable.setBounds(0, 0, d.this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds8), d.this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds8));
            this.eqP.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
            this.etw = (TextView) this.cus.findViewById(R.id.user_name);
            this.eqW = (TextView) this.cus.findViewById(R.id.follow_btn);
            this.etx = (TextView) this.cus.findViewById(R.id.followed_btn);
            this.eqW.setOnClickListener(this.mOnClickListener);
        }
    }
}
