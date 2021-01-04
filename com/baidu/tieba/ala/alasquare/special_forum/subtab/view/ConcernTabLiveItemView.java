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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.alasquare.special_forum.data.f;
/* loaded from: classes10.dex */
public class ConcernTabLiveItemView extends com.baidu.tieba.card.b<f> {
    private ViewHolder gJU;
    private int gJV;
    private TbPageContext mTbPageContext;

    public ConcernTabLiveItemView(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        this.gJV = 28;
        this.mTbPageContext = tbPageContext;
        this.gJU = new ViewHolder(this);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        ao.setViewTextColor(this.gJU.gJY, R.color.CAM_X0105);
        ao.setViewTextColor(this.gJU.gJZ, R.color.CAM_X0109);
        ao.setViewTextColor(this.gJU.gKa, R.color.CAM_X0109);
        ao.setViewTextColor(this.gJU.gHD, R.color.common_color_10140);
        ao.setViewTextColor(this.gJU.gHv, R.color.CAM_X0109);
        ao.getDrawable(this.mContext.getResources(), R.drawable.icon_video_direct_seeding).setBounds(0, 0, this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds8), this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds8));
        this.gJU.gHv.setCompoundDrawablesWithIntrinsicBounds(ao.getDrawable(this.mContext.getResources(), R.drawable.icon_living_seeding), (Drawable) null, (Drawable) null, (Drawable) null);
        ao.setBackgroundColor(this.gJU.bUk, R.color.CAM_X0204);
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
                this.gJU.gJX.startLoad(fVar.mUserData.getPortrait(), 12, false);
            }
            if (!StringUtils.isNull(fVar.mUserData.getName_show())) {
                this.gJU.gJY.setText(fVar.mUserData.getName_show());
            }
            if (fVar.gIG) {
                if (fVar.mUserData.hadConcerned()) {
                    this.gJU.gHD.setVisibility(8);
                    this.gJU.gKa.setVisibility(0);
                } else {
                    this.gJU.gHD.setVisibility(0);
                    this.gJU.gKa.setVisibility(8);
                }
            } else {
                this.gJU.gHD.setVisibility(8);
                this.gJU.gKa.setVisibility(8);
            }
            this.gJU.gHD.setTag(fVar.mUserData);
        }
        if (fVar.gIF != null) {
            this.gJU.epV.setTag(fVar.gIF);
            if (!StringUtils.isNull(fVar.gIF.description)) {
                String str = fVar.gIF.description;
                int i = this.gJV;
                if (fVar.gIG) {
                    i -= 9;
                }
                this.gJU.gJZ.setText(k.byteLength(str) > i ? at.cutChineseAndEnglishWithSuffix(str, i, StringHelper.STRING_MORE) : str);
            }
        }
        if (fVar.gIG) {
            TiebaStatic.log(new aq("c12895"));
        } else {
            TiebaStatic.log(new aq("c12893"));
        }
        this.gJU.gHD.setTag(fVar.mUserData);
        onChangeSkinType(getTbPageContext(), TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    /* loaded from: classes10.dex */
    public class ViewHolder extends TypeAdapter.ViewHolder {
        public View bUk;
        public View epV;
        public TextView gHD;
        public TextView gHv;
        public ConcernTabLiveItemView gJW;
        public TbImageView gJX;
        public TextView gJY;
        public TextView gJZ;
        public TextView gKa;
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
                        ConcernTabLiveItemView.this.gJU.gHD.setVisibility(8);
                        ConcernTabLiveItemView.this.gJU.gKa.setVisibility(0);
                        TiebaStatic.log(new aq("c12897"));
                    }
                }
            };
            this.gJW = concernTabLiveItemView;
            this.epV = concernTabLiveItemView.getView();
            this.gJX = (TbImageView) this.epV.findViewById(R.id.protrait);
            this.gJX.setDefaultResource(R.drawable.icon_default_avatar100_bg);
            this.gJX.setIsRound(true);
            this.gJX.setAutoChangeStyle(false);
            this.gJX.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.gJY = (TextView) this.epV.findViewById(R.id.live_title);
            this.gHv = (TextView) this.epV.findViewById(R.id.living_tag);
            this.bUk = this.epV.findViewById(R.id.devider_line);
            Drawable drawable = ao.getDrawable(ConcernTabLiveItemView.this.mContext.getResources(), R.drawable.icon_living_seeding);
            drawable.setBounds(0, 0, ConcernTabLiveItemView.this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds8), ConcernTabLiveItemView.this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds8));
            this.gHv.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
            this.gJZ = (TextView) this.epV.findViewById(R.id.user_name);
            this.gHD = (TextView) this.epV.findViewById(R.id.follow_btn);
            this.gKa = (TextView) this.epV.findViewById(R.id.followed_btn);
            this.gHD.setOnClickListener(this.mOnClickListener);
        }
    }
}
