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
    private a gyP;
    private int gyQ;
    private TbPageContext mTbPageContext;

    public d(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        this.gyQ = 28;
        this.mTbPageContext = tbPageContext;
        this.gyP = new a(this);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        ap.setViewTextColor(this.gyP.gyT, (int) R.color.CAM_X0105);
        ap.setViewTextColor(this.gyP.gyU, (int) R.color.CAM_X0109);
        ap.setViewTextColor(this.gyP.gyV, (int) R.color.CAM_X0109);
        ap.setViewTextColor(this.gyP.gwx, (int) R.color.common_color_10140);
        ap.setViewTextColor(this.gyP.gwq, (int) R.color.CAM_X0109);
        ap.getDrawable(this.mContext.getResources(), (int) R.drawable.icon_video_direct_seeding).setBounds(0, 0, this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds8), this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds8));
        this.gyP.gwq.setCompoundDrawablesWithIntrinsicBounds(ap.getDrawable(this.mContext.getResources(), (int) R.drawable.icon_living_seeding), (Drawable) null, (Drawable) null, (Drawable) null);
        ap.setBackgroundColor(this.gyP.eOv, R.color.CAM_X0204);
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
                this.gyP.gyS.startLoad(fVar.mUserData.getPortrait(), 12, false);
            }
            if (!StringUtils.isNull(fVar.mUserData.getName_show())) {
                this.gyP.gyT.setText(fVar.mUserData.getName_show());
            }
            if (fVar.gxB) {
                if (fVar.mUserData.hadConcerned()) {
                    this.gyP.gwx.setVisibility(8);
                    this.gyP.gyV.setVisibility(0);
                } else {
                    this.gyP.gwx.setVisibility(0);
                    this.gyP.gyV.setVisibility(8);
                }
            } else {
                this.gyP.gwx.setVisibility(8);
                this.gyP.gyV.setVisibility(8);
            }
            this.gyP.gwx.setTag(fVar.mUserData);
        }
        if (fVar.gxA != null) {
            this.gyP.egT.setTag(fVar.gxA);
            if (!StringUtils.isNull(fVar.gxA.description)) {
                String str = fVar.gxA.description;
                int i = this.gyQ;
                if (fVar.gxB) {
                    i -= 9;
                }
                this.gyP.gyU.setText(k.byteLength(str) > i ? au.cutChineseAndEnglishWithSuffix(str, i, StringHelper.STRING_MORE) : str);
            }
        }
        if (fVar.gxB) {
            TiebaStatic.log(new ar("c12895"));
        } else {
            TiebaStatic.log(new ar("c12893"));
        }
        this.gyP.gwx.setTag(fVar.mUserData);
        onChangeSkinType(getTbPageContext(), TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    /* loaded from: classes6.dex */
    public class a extends af.a {
        public View eOv;
        public View egT;
        public TextView gwq;
        public TextView gwx;
        public d gyR;
        public TbImageView gyS;
        public TextView gyT;
        public TextView gyU;
        public TextView gyV;
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
                        d.this.gyP.gwx.setVisibility(8);
                        d.this.gyP.gyV.setVisibility(0);
                        TiebaStatic.log(new ar("c12897"));
                    }
                }
            };
            this.gyR = dVar;
            this.egT = dVar.getView();
            this.gyS = (TbImageView) this.egT.findViewById(R.id.protrait);
            this.gyS.setDefaultResource(R.drawable.icon_default_avatar100_bg);
            this.gyS.setIsRound(true);
            this.gyS.setAutoChangeStyle(false);
            this.gyS.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.gyT = (TextView) this.egT.findViewById(R.id.live_title);
            this.gwq = (TextView) this.egT.findViewById(R.id.living_tag);
            this.eOv = this.egT.findViewById(R.id.devider_line);
            Drawable drawable = ap.getDrawable(d.this.mContext.getResources(), (int) R.drawable.icon_living_seeding);
            drawable.setBounds(0, 0, d.this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds8), d.this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds8));
            this.gwq.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
            this.gyU = (TextView) this.egT.findViewById(R.id.user_name);
            this.gwx = (TextView) this.egT.findViewById(R.id.follow_btn);
            this.gyV = (TextView) this.egT.findViewById(R.id.followed_btn);
            this.gwx.setOnClickListener(this.mOnClickListener);
        }
    }
}
