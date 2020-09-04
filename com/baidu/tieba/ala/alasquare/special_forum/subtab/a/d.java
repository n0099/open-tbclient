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
    private a fLC;
    private int fLD;
    private TbPageContext mTbPageContext;

    public d(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        this.fLD = 28;
        this.mTbPageContext = tbPageContext;
        this.fLC = new a(this);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        ap.setViewTextColor(this.fLC.fLG, (int) R.color.cp_cont_b);
        ap.setViewTextColor(this.fLC.fLH, (int) R.color.cp_cont_d);
        ap.setViewTextColor(this.fLC.fLI, (int) R.color.cp_cont_d);
        ap.setViewTextColor(this.fLC.fJj, (int) R.color.common_color_10140);
        ap.setViewTextColor(this.fLC.fJc, (int) R.color.cp_cont_d);
        ap.getDrawable(this.mContext.getResources(), (int) R.drawable.icon_video_direct_seeding).setBounds(0, 0, this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds8), this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds8));
        this.fLC.fJc.setCompoundDrawablesWithIntrinsicBounds(ap.getDrawable(this.mContext.getResources(), (int) R.drawable.icon_living_seeding), (Drawable) null, (Drawable) null, (Drawable) null);
        ap.setBackgroundColor(this.fLC.egd, R.color.cp_bg_line_c);
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
                this.fLC.fLF.startLoad(fVar.mUserData.getPortrait(), 12, false);
            }
            if (!StringUtils.isNull(fVar.mUserData.getName_show())) {
                this.fLC.fLG.setText(fVar.mUserData.getName_show());
            }
            if (fVar.fKo) {
                if (fVar.mUserData.hadConcerned()) {
                    this.fLC.fJj.setVisibility(8);
                    this.fLC.fLI.setVisibility(0);
                } else {
                    this.fLC.fJj.setVisibility(0);
                    this.fLC.fLI.setVisibility(8);
                }
            } else {
                this.fLC.fJj.setVisibility(8);
                this.fLC.fLI.setVisibility(8);
            }
            this.fLC.fJj.setTag(fVar.mUserData);
        }
        if (fVar.fKn != null) {
            this.fLC.dzk.setTag(fVar.fKn);
            if (!StringUtils.isNull(fVar.fKn.description)) {
                String str = fVar.fKn.description;
                int i = this.fLD;
                if (fVar.fKo) {
                    i -= 9;
                }
                this.fLC.fLH.setText(k.byteLength(str) > i ? at.cutChineseAndEnglishWithSuffix(str, i, StringHelper.STRING_MORE) : str);
            }
        }
        if (fVar.fKo) {
            TiebaStatic.log(new aq("c12895"));
        } else {
            TiebaStatic.log(new aq("c12893"));
        }
        this.fLC.fJj.setTag(fVar.mUserData);
        onChangeSkinType(getTbPageContext(), TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    /* loaded from: classes4.dex */
    public class a extends af.a {
        public View dzk;
        public View egd;
        public TextView fJc;
        public TextView fJj;
        public d fLE;
        public TbImageView fLF;
        public TextView fLG;
        public TextView fLH;
        public TextView fLI;
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
                        d.this.fLC.fJj.setVisibility(8);
                        d.this.fLC.fLI.setVisibility(0);
                        TiebaStatic.log(new aq("c12897"));
                    }
                }
            };
            this.fLE = dVar;
            this.dzk = dVar.getView();
            this.fLF = (TbImageView) this.dzk.findViewById(R.id.protrait);
            this.fLF.setDefaultResource(R.drawable.icon_default_avatar100_bg);
            this.fLF.setIsRound(true);
            this.fLF.setAutoChangeStyle(false);
            this.fLF.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.fLG = (TextView) this.dzk.findViewById(R.id.live_title);
            this.fJc = (TextView) this.dzk.findViewById(R.id.living_tag);
            this.egd = this.dzk.findViewById(R.id.devider_line);
            Drawable drawable = ap.getDrawable(d.this.mContext.getResources(), (int) R.drawable.icon_living_seeding);
            drawable.setBounds(0, 0, d.this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds8), d.this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds8));
            this.fJc.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
            this.fLH = (TextView) this.dzk.findViewById(R.id.user_name);
            this.fJj = (TextView) this.dzk.findViewById(R.id.follow_btn);
            this.fLI = (TextView) this.dzk.findViewById(R.id.followed_btn);
            this.fJj.setOnClickListener(this.mOnClickListener);
        }
    }
}
