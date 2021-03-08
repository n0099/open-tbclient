package com.baidu.tieba.ala.alasquare.special_forum.subtab.view;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.k;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.TypeAdapter;
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
import com.baidu.tieba.ala.alasquare.special_forum.data.f;
/* loaded from: classes9.dex */
public class ConcernTabLiveItemView extends com.baidu.tieba.card.b<f> {
    private ViewHolder gJV;
    private int gJW;
    private TbPageContext mTbPageContext;

    public ConcernTabLiveItemView(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        this.gJW = 28;
        this.mTbPageContext = tbPageContext;
        this.gJV = new ViewHolder(this);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        ap.setViewTextColor(this.gJV.gJZ, R.color.CAM_X0105);
        ap.setViewTextColor(this.gJV.gKa, R.color.CAM_X0109);
        ap.setViewTextColor(this.gJV.gKb, R.color.CAM_X0109);
        ap.setViewTextColor(this.gJV.gHE, R.color.common_color_10140);
        ap.setViewTextColor(this.gJV.gHw, R.color.CAM_X0109);
        ap.getDrawable(this.mContext.getResources(), R.drawable.icon_video_direct_seeding).setBounds(0, 0, this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds8), this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds8));
        this.gJV.gHw.setCompoundDrawablesWithIntrinsicBounds(ap.getDrawable(this.mContext.getResources(), R.drawable.icon_living_seeding), (Drawable) null, (Drawable) null, (Drawable) null);
        ap.setBackgroundColor(this.gJV.bUO, R.color.CAM_X0204);
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.special_bar_concern_live_item;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(f fVar) {
        if (fVar.mUserData != null) {
            if (!StringUtils.isNull(fVar.mUserData.getPortrait())) {
                this.gJV.gJY.startLoad(fVar.mUserData.getPortrait(), 12, false);
            }
            if (!StringUtils.isNull(fVar.mUserData.getName_show())) {
                this.gJV.gJZ.setText(fVar.mUserData.getName_show());
            }
            if (fVar.gIH) {
                if (fVar.mUserData.hadConcerned()) {
                    this.gJV.gHE.setVisibility(8);
                    this.gJV.gKb.setVisibility(0);
                } else {
                    this.gJV.gHE.setVisibility(0);
                    this.gJV.gKb.setVisibility(8);
                }
            } else {
                this.gJV.gHE.setVisibility(8);
                this.gJV.gKb.setVisibility(8);
            }
            this.gJV.gHE.setTag(fVar.mUserData);
        }
        if (fVar.gIG != null) {
            this.gJV.eoR.setTag(fVar.gIG);
            if (!StringUtils.isNull(fVar.gIG.description)) {
                String str = fVar.gIG.description;
                int i = this.gJW;
                if (fVar.gIH) {
                    i -= 9;
                }
                this.gJV.gKa.setText(k.byteLength(str) > i ? au.cutChineseAndEnglishWithSuffix(str, i, StringHelper.STRING_MORE) : str);
            }
        }
        if (fVar.gIH) {
            TiebaStatic.log(new ar("c12895"));
        } else {
            TiebaStatic.log(new ar("c12893"));
        }
        this.gJV.gHE.setTag(fVar.mUserData);
        onChangeSkinType(getTbPageContext(), TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    /* loaded from: classes9.dex */
    public class ViewHolder extends TypeAdapter.ViewHolder {
        public View bUO;
        public View eoR;
        public TextView gHE;
        public TextView gHw;
        public ConcernTabLiveItemView gJX;
        public TbImageView gJY;
        public TextView gJZ;
        public TextView gKa;
        public TextView gKb;
        private View.OnClickListener mOnClickListener;

        public ViewHolder(ConcernTabLiveItemView concernTabLiveItemView) {
            super(concernTabLiveItemView.getView());
            this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.view.ConcernTabLiveItemView.ViewHolder.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (view.getId() == R.id.follow_btn && (view.getTag() instanceof UserData)) {
                        if (!l.isNetOk()) {
                            ConcernTabLiveItemView.this.mTbPageContext.showToast(R.string.neterror);
                            return;
                        }
                        UserData userData = (UserData) view.getTag();
                        AlaAttentionManager.getInstance().updateAttention(String.valueOf(userData.getUserId()), new AlaAttentionData(userData.getPortrait(), String.valueOf(userData.getUserId()), "1", true, null));
                        ConcernTabLiveItemView.this.gJV.gHE.setVisibility(8);
                        ConcernTabLiveItemView.this.gJV.gKb.setVisibility(0);
                        TiebaStatic.log(new ar("c12897"));
                    }
                }
            };
            this.gJX = concernTabLiveItemView;
            this.eoR = concernTabLiveItemView.getView();
            this.gJY = (TbImageView) this.eoR.findViewById(R.id.protrait);
            this.gJY.setDefaultResource(R.drawable.icon_default_avatar100_bg);
            this.gJY.setIsRound(true);
            this.gJY.setAutoChangeStyle(false);
            this.gJY.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.gJZ = (TextView) this.eoR.findViewById(R.id.live_title);
            this.gHw = (TextView) this.eoR.findViewById(R.id.living_tag);
            this.bUO = this.eoR.findViewById(R.id.devider_line);
            Drawable drawable = ap.getDrawable(ConcernTabLiveItemView.this.mContext.getResources(), R.drawable.icon_living_seeding);
            drawable.setBounds(0, 0, ConcernTabLiveItemView.this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds8), ConcernTabLiveItemView.this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds8));
            this.gHw.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
            this.gKa = (TextView) this.eoR.findViewById(R.id.user_name);
            this.gHE = (TextView) this.eoR.findViewById(R.id.follow_btn);
            this.gKb = (TextView) this.eoR.findViewById(R.id.followed_btn);
            this.gHE.setOnClickListener(this.mOnClickListener);
        }
    }
}
