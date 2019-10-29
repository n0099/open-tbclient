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
    private a dDb;
    private int dDc;
    private TbPageContext mTbPageContext;

    public c(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        this.dDc = 28;
        this.mTbPageContext = tbPageContext;
        this.dDb = new a(this);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        am.setViewTextColor(this.dDb.dDf, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.dDb.dDg, (int) R.color.cp_cont_d);
        am.setViewTextColor(this.dDb.dDh, (int) R.color.cp_cont_d);
        am.setViewTextColor(this.dDb.dAU, (int) R.color.common_color_10140);
        am.setViewTextColor(this.dDb.dAM, (int) R.color.cp_cont_d);
        am.getDrawable(this.mContext.getResources(), (int) R.drawable.icon_video_direct_seeding).setBounds(0, 0, this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds8), this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds8));
        this.dDb.dAM.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(this.mContext.getResources(), (int) R.drawable.icon_living_seeding), (Drawable) null, (Drawable) null, (Drawable) null);
        am.setBackgroundColor(this.dDb.cfY, R.color.cp_bg_line_c);
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
                this.dDb.dDe.startLoad(fVar.mUserData.getPortrait(), 12, false);
            }
            if (!StringUtils.isNull(fVar.mUserData.getName_show())) {
                this.dDb.dDf.setText(fVar.mUserData.getName_show());
            }
            if (fVar.dCa) {
                if (fVar.mUserData.hadConcerned()) {
                    this.dDb.dAU.setVisibility(8);
                    this.dDb.dDh.setVisibility(0);
                } else {
                    this.dDb.dAU.setVisibility(0);
                    this.dDb.dDh.setVisibility(8);
                }
            } else {
                this.dDb.dAU.setVisibility(8);
                this.dDb.dDh.setVisibility(8);
            }
            this.dDb.dAU.setTag(fVar.mUserData);
        }
        if (fVar.dBZ != null) {
            this.dDb.bGb.setTag(fVar.dBZ);
            if (!StringUtils.isNull(fVar.dBZ.description)) {
                String str = fVar.dBZ.description;
                int i = this.dDc;
                if (fVar.dCa) {
                    i -= 9;
                }
                this.dDb.dDg.setText(k.byteLength(str) > i ? aq.cutChineseAndEnglishWithSuffix(str, i, StringHelper.STRING_MORE) : str);
            }
        }
        if (fVar.dCa) {
            TiebaStatic.log(new an("c12895"));
        } else {
            TiebaStatic.log(new an("c12893"));
        }
        this.dDb.dAU.setTag(fVar.mUserData);
        onChangeSkinType(getTbPageContext(), TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    /* loaded from: classes6.dex */
    public class a extends v.a {
        public View bGb;
        public View cfY;
        public TextView dAM;
        public TextView dAU;
        public c dDd;
        public TbImageView dDe;
        public TextView dDf;
        public TextView dDg;
        public TextView dDh;
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
                        c.this.dDb.dAU.setVisibility(8);
                        c.this.dDb.dDh.setVisibility(0);
                        TiebaStatic.log(new an("c12897"));
                    }
                }
            };
            this.dDd = cVar;
            this.bGb = cVar.getView();
            this.dDe = (TbImageView) this.bGb.findViewById(R.id.protrait);
            this.dDe.setDefaultResource(R.drawable.icon_default_avatar100_bg);
            this.dDe.setIsRound(true);
            this.dDe.setAutoChangeStyle(false);
            this.dDe.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.dDf = (TextView) this.bGb.findViewById(R.id.live_title);
            this.dAM = (TextView) this.bGb.findViewById(R.id.living_tag);
            this.cfY = this.bGb.findViewById(R.id.devider_line);
            Drawable drawable = am.getDrawable(c.this.mContext.getResources(), (int) R.drawable.icon_living_seeding);
            drawable.setBounds(0, 0, c.this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds8), c.this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds8));
            this.dAM.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
            this.dDg = (TextView) this.bGb.findViewById(R.id.user_name);
            this.dAU = (TextView) this.bGb.findViewById(R.id.follow_btn);
            this.dDh = (TextView) this.bGb.findViewById(R.id.followed_btn);
            this.dAU.setOnClickListener(this.mOnClickListener);
        }
    }
}
