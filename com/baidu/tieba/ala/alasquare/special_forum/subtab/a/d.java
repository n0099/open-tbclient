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
    private a fLy;
    private int fLz;
    private TbPageContext mTbPageContext;

    public d(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        this.fLz = 28;
        this.mTbPageContext = tbPageContext;
        this.fLy = new a(this);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        ap.setViewTextColor(this.fLy.fLC, (int) R.color.cp_cont_b);
        ap.setViewTextColor(this.fLy.fLD, (int) R.color.cp_cont_d);
        ap.setViewTextColor(this.fLy.fLE, (int) R.color.cp_cont_d);
        ap.setViewTextColor(this.fLy.fJf, (int) R.color.common_color_10140);
        ap.setViewTextColor(this.fLy.fIY, (int) R.color.cp_cont_d);
        ap.getDrawable(this.mContext.getResources(), (int) R.drawable.icon_video_direct_seeding).setBounds(0, 0, this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds8), this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds8));
        this.fLy.fIY.setCompoundDrawablesWithIntrinsicBounds(ap.getDrawable(this.mContext.getResources(), (int) R.drawable.icon_living_seeding), (Drawable) null, (Drawable) null, (Drawable) null);
        ap.setBackgroundColor(this.fLy.efZ, R.color.cp_bg_line_c);
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
                this.fLy.fLB.startLoad(fVar.mUserData.getPortrait(), 12, false);
            }
            if (!StringUtils.isNull(fVar.mUserData.getName_show())) {
                this.fLy.fLC.setText(fVar.mUserData.getName_show());
            }
            if (fVar.fKk) {
                if (fVar.mUserData.hadConcerned()) {
                    this.fLy.fJf.setVisibility(8);
                    this.fLy.fLE.setVisibility(0);
                } else {
                    this.fLy.fJf.setVisibility(0);
                    this.fLy.fLE.setVisibility(8);
                }
            } else {
                this.fLy.fJf.setVisibility(8);
                this.fLy.fLE.setVisibility(8);
            }
            this.fLy.fJf.setTag(fVar.mUserData);
        }
        if (fVar.fKj != null) {
            this.fLy.dzg.setTag(fVar.fKj);
            if (!StringUtils.isNull(fVar.fKj.description)) {
                String str = fVar.fKj.description;
                int i = this.fLz;
                if (fVar.fKk) {
                    i -= 9;
                }
                this.fLy.fLD.setText(k.byteLength(str) > i ? at.cutChineseAndEnglishWithSuffix(str, i, StringHelper.STRING_MORE) : str);
            }
        }
        if (fVar.fKk) {
            TiebaStatic.log(new aq("c12895"));
        } else {
            TiebaStatic.log(new aq("c12893"));
        }
        this.fLy.fJf.setTag(fVar.mUserData);
        onChangeSkinType(getTbPageContext(), TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    /* loaded from: classes4.dex */
    public class a extends af.a {
        public View dzg;
        public View efZ;
        public TextView fIY;
        public TextView fJf;
        public d fLA;
        public TbImageView fLB;
        public TextView fLC;
        public TextView fLD;
        public TextView fLE;
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
                        d.this.fLy.fJf.setVisibility(8);
                        d.this.fLy.fLE.setVisibility(0);
                        TiebaStatic.log(new aq("c12897"));
                    }
                }
            };
            this.fLA = dVar;
            this.dzg = dVar.getView();
            this.fLB = (TbImageView) this.dzg.findViewById(R.id.protrait);
            this.fLB.setDefaultResource(R.drawable.icon_default_avatar100_bg);
            this.fLB.setIsRound(true);
            this.fLB.setAutoChangeStyle(false);
            this.fLB.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.fLC = (TextView) this.dzg.findViewById(R.id.live_title);
            this.fIY = (TextView) this.dzg.findViewById(R.id.living_tag);
            this.efZ = this.dzg.findViewById(R.id.devider_line);
            Drawable drawable = ap.getDrawable(d.this.mContext.getResources(), (int) R.drawable.icon_living_seeding);
            drawable.setBounds(0, 0, d.this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds8), d.this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds8));
            this.fIY.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
            this.fLD = (TextView) this.dzg.findViewById(R.id.user_name);
            this.fJf = (TextView) this.dzg.findViewById(R.id.follow_btn);
            this.fLE = (TextView) this.dzg.findViewById(R.id.followed_btn);
            this.fJf.setOnClickListener(this.mOnClickListener);
        }
    }
}
