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
/* loaded from: classes6.dex */
public class d extends com.baidu.tieba.card.b<com.baidu.tieba.ala.alasquare.special_forum.data.f> {
    private a gyR;
    private int gyS;
    private TbPageContext mTbPageContext;

    public d(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        this.gyS = 28;
        this.mTbPageContext = tbPageContext;
        this.gyR = new a(this);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        ap.setViewTextColor(this.gyR.gyV, (int) R.color.CAM_X0105);
        ap.setViewTextColor(this.gyR.gyW, (int) R.color.CAM_X0109);
        ap.setViewTextColor(this.gyR.gyX, (int) R.color.CAM_X0109);
        ap.setViewTextColor(this.gyR.gwz, (int) R.color.common_color_10140);
        ap.setViewTextColor(this.gyR.gws, (int) R.color.CAM_X0109);
        ap.getDrawable(this.mContext.getResources(), (int) R.drawable.icon_video_direct_seeding).setBounds(0, 0, this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds8), this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds8));
        this.gyR.gws.setCompoundDrawablesWithIntrinsicBounds(ap.getDrawable(this.mContext.getResources(), (int) R.drawable.icon_living_seeding), (Drawable) null, (Drawable) null, (Drawable) null);
        ap.setBackgroundColor(this.gyR.eOv, R.color.CAM_X0204);
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
                this.gyR.gyU.startLoad(fVar.mUserData.getPortrait(), 12, false);
            }
            if (!StringUtils.isNull(fVar.mUserData.getName_show())) {
                this.gyR.gyV.setText(fVar.mUserData.getName_show());
            }
            if (fVar.gxD) {
                if (fVar.mUserData.hadConcerned()) {
                    this.gyR.gwz.setVisibility(8);
                    this.gyR.gyX.setVisibility(0);
                } else {
                    this.gyR.gwz.setVisibility(0);
                    this.gyR.gyX.setVisibility(8);
                }
            } else {
                this.gyR.gwz.setVisibility(8);
                this.gyR.gyX.setVisibility(8);
            }
            this.gyR.gwz.setTag(fVar.mUserData);
        }
        if (fVar.gxC != null) {
            this.gyR.egT.setTag(fVar.gxC);
            if (!StringUtils.isNull(fVar.gxC.description)) {
                String str = fVar.gxC.description;
                int i = this.gyS;
                if (fVar.gxD) {
                    i -= 9;
                }
                this.gyR.gyW.setText(k.byteLength(str) > i ? au.cutChineseAndEnglishWithSuffix(str, i, StringHelper.STRING_MORE) : str);
            }
        }
        if (fVar.gxD) {
            TiebaStatic.log(new ar("c12895"));
        } else {
            TiebaStatic.log(new ar("c12893"));
        }
        this.gyR.gwz.setTag(fVar.mUserData);
        onChangeSkinType(getTbPageContext(), TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    /* loaded from: classes6.dex */
    public class a extends af.a {
        public View eOv;
        public View egT;
        public TextView gws;
        public TextView gwz;
        public d gyT;
        public TbImageView gyU;
        public TextView gyV;
        public TextView gyW;
        public TextView gyX;
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
                        d.this.gyR.gwz.setVisibility(8);
                        d.this.gyR.gyX.setVisibility(0);
                        TiebaStatic.log(new ar("c12897"));
                    }
                }
            };
            this.gyT = dVar;
            this.egT = dVar.getView();
            this.gyU = (TbImageView) this.egT.findViewById(R.id.protrait);
            this.gyU.setDefaultResource(R.drawable.icon_default_avatar100_bg);
            this.gyU.setIsRound(true);
            this.gyU.setAutoChangeStyle(false);
            this.gyU.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.gyV = (TextView) this.egT.findViewById(R.id.live_title);
            this.gws = (TextView) this.egT.findViewById(R.id.living_tag);
            this.eOv = this.egT.findViewById(R.id.devider_line);
            Drawable drawable = ap.getDrawable(d.this.mContext.getResources(), (int) R.drawable.icon_living_seeding);
            drawable.setBounds(0, 0, d.this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds8), d.this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds8));
            this.gws.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
            this.gyW = (TextView) this.egT.findViewById(R.id.user_name);
            this.gwz = (TextView) this.egT.findViewById(R.id.follow_btn);
            this.gyX = (TextView) this.egT.findViewById(R.id.followed_btn);
            this.gwz.setOnClickListener(this.mOnClickListener);
        }
    }
}
