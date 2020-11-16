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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class d extends com.baidu.tieba.card.b<com.baidu.tieba.ala.alasquare.special_forum.data.f> {
    private a gqG;
    private int gqH;
    private TbPageContext mTbPageContext;

    public d(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        this.gqH = 28;
        this.mTbPageContext = tbPageContext;
        this.gqG = new a(this);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        ap.setViewTextColor(this.gqG.gqK, R.color.CAM_X0105);
        ap.setViewTextColor(this.gqG.gqL, R.color.CAM_X0109);
        ap.setViewTextColor(this.gqG.gqM, R.color.CAM_X0109);
        ap.setViewTextColor(this.gqG.goo, R.color.common_color_10140);
        ap.setViewTextColor(this.gqG.goh, R.color.CAM_X0109);
        ap.getDrawable(this.mContext.getResources(), R.drawable.icon_video_direct_seeding).setBounds(0, 0, this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds8), this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds8));
        this.gqG.goh.setCompoundDrawablesWithIntrinsicBounds(ap.getDrawable(this.mContext.getResources(), R.drawable.icon_living_seeding), (Drawable) null, (Drawable) null, (Drawable) null);
        ap.setBackgroundColor(this.gqG.eHl, R.color.CAM_X0204);
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
                this.gqG.gqJ.startLoad(fVar.mUserData.getPortrait(), 12, false);
            }
            if (!StringUtils.isNull(fVar.mUserData.getName_show())) {
                this.gqG.gqK.setText(fVar.mUserData.getName_show());
            }
            if (fVar.gps) {
                if (fVar.mUserData.hadConcerned()) {
                    this.gqG.goo.setVisibility(8);
                    this.gqG.gqM.setVisibility(0);
                } else {
                    this.gqG.goo.setVisibility(0);
                    this.gqG.gqM.setVisibility(8);
                }
            } else {
                this.gqG.goo.setVisibility(8);
                this.gqG.gqM.setVisibility(8);
            }
            this.gqG.goo.setTag(fVar.mUserData);
        }
        if (fVar.gpr != null) {
            this.gqG.dZT.setTag(fVar.gpr);
            if (!StringUtils.isNull(fVar.gpr.description)) {
                String str = fVar.gpr.description;
                int i = this.gqH;
                if (fVar.gps) {
                    i -= 9;
                }
                this.gqG.gqL.setText(k.byteLength(str) > i ? au.cutChineseAndEnglishWithSuffix(str, i, StringHelper.STRING_MORE) : str);
            }
        }
        if (fVar.gps) {
            TiebaStatic.log(new ar("c12895"));
        } else {
            TiebaStatic.log(new ar("c12893"));
        }
        this.gqG.goo.setTag(fVar.mUserData);
        onChangeSkinType(getTbPageContext(), TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    /* loaded from: classes4.dex */
    public class a extends af.a {
        public View dZT;
        public View eHl;
        public TextView goh;
        public TextView goo;
        public d gqI;
        public TbImageView gqJ;
        public TextView gqK;
        public TextView gqL;
        public TextView gqM;
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
                        d.this.gqG.goo.setVisibility(8);
                        d.this.gqG.gqM.setVisibility(0);
                        TiebaStatic.log(new ar("c12897"));
                    }
                }
            };
            this.gqI = dVar;
            this.dZT = dVar.getView();
            this.gqJ = (TbImageView) this.dZT.findViewById(R.id.protrait);
            this.gqJ.setDefaultResource(R.drawable.icon_default_avatar100_bg);
            this.gqJ.setIsRound(true);
            this.gqJ.setAutoChangeStyle(false);
            this.gqJ.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.gqK = (TextView) this.dZT.findViewById(R.id.live_title);
            this.goh = (TextView) this.dZT.findViewById(R.id.living_tag);
            this.eHl = this.dZT.findViewById(R.id.devider_line);
            Drawable drawable = ap.getDrawable(d.this.mContext.getResources(), R.drawable.icon_living_seeding);
            drawable.setBounds(0, 0, d.this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds8), d.this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds8));
            this.goh.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
            this.gqL = (TextView) this.dZT.findViewById(R.id.user_name);
            this.goo = (TextView) this.dZT.findViewById(R.id.follow_btn);
            this.gqM = (TextView) this.dZT.findViewById(R.id.followed_btn);
            this.goo.setOnClickListener(this.mOnClickListener);
        }
    }
}
