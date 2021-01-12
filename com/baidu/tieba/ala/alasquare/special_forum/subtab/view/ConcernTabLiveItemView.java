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
/* loaded from: classes9.dex */
public class ConcernTabLiveItemView extends com.baidu.tieba.card.b<f> {
    private ViewHolder gFo;
    private int gFp;
    private TbPageContext mTbPageContext;

    public ConcernTabLiveItemView(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        this.gFp = 28;
        this.mTbPageContext = tbPageContext;
        this.gFo = new ViewHolder(this);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        ao.setViewTextColor(this.gFo.gFs, R.color.CAM_X0105);
        ao.setViewTextColor(this.gFo.gFt, R.color.CAM_X0109);
        ao.setViewTextColor(this.gFo.gFu, R.color.CAM_X0109);
        ao.setViewTextColor(this.gFo.gCX, R.color.common_color_10140);
        ao.setViewTextColor(this.gFo.gCP, R.color.CAM_X0109);
        ao.getDrawable(this.mContext.getResources(), R.drawable.icon_video_direct_seeding).setBounds(0, 0, this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds8), this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds8));
        this.gFo.gCP.setCompoundDrawablesWithIntrinsicBounds(ao.getDrawable(this.mContext.getResources(), R.drawable.icon_living_seeding), (Drawable) null, (Drawable) null, (Drawable) null);
        ao.setBackgroundColor(this.gFo.bPy, R.color.CAM_X0204);
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
                this.gFo.gFr.startLoad(fVar.mUserData.getPortrait(), 12, false);
            }
            if (!StringUtils.isNull(fVar.mUserData.getName_show())) {
                this.gFo.gFs.setText(fVar.mUserData.getName_show());
            }
            if (fVar.gEa) {
                if (fVar.mUserData.hadConcerned()) {
                    this.gFo.gCX.setVisibility(8);
                    this.gFo.gFu.setVisibility(0);
                } else {
                    this.gFo.gCX.setVisibility(0);
                    this.gFo.gFu.setVisibility(8);
                }
            } else {
                this.gFo.gCX.setVisibility(8);
                this.gFo.gFu.setVisibility(8);
            }
            this.gFo.gCX.setTag(fVar.mUserData);
        }
        if (fVar.gDZ != null) {
            this.gFo.elg.setTag(fVar.gDZ);
            if (!StringUtils.isNull(fVar.gDZ.description)) {
                String str = fVar.gDZ.description;
                int i = this.gFp;
                if (fVar.gEa) {
                    i -= 9;
                }
                this.gFo.gFt.setText(k.byteLength(str) > i ? at.cutChineseAndEnglishWithSuffix(str, i, StringHelper.STRING_MORE) : str);
            }
        }
        if (fVar.gEa) {
            TiebaStatic.log(new aq("c12895"));
        } else {
            TiebaStatic.log(new aq("c12893"));
        }
        this.gFo.gCX.setTag(fVar.mUserData);
        onChangeSkinType(getTbPageContext(), TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    /* loaded from: classes9.dex */
    public class ViewHolder extends TypeAdapter.ViewHolder {
        public View bPy;
        public View elg;
        public TextView gCP;
        public TextView gCX;
        public ConcernTabLiveItemView gFq;
        public TbImageView gFr;
        public TextView gFs;
        public TextView gFt;
        public TextView gFu;
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
                        ConcernTabLiveItemView.this.gFo.gCX.setVisibility(8);
                        ConcernTabLiveItemView.this.gFo.gFu.setVisibility(0);
                        TiebaStatic.log(new aq("c12897"));
                    }
                }
            };
            this.gFq = concernTabLiveItemView;
            this.elg = concernTabLiveItemView.getView();
            this.gFr = (TbImageView) this.elg.findViewById(R.id.protrait);
            this.gFr.setDefaultResource(R.drawable.icon_default_avatar100_bg);
            this.gFr.setIsRound(true);
            this.gFr.setAutoChangeStyle(false);
            this.gFr.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.gFs = (TextView) this.elg.findViewById(R.id.live_title);
            this.gCP = (TextView) this.elg.findViewById(R.id.living_tag);
            this.bPy = this.elg.findViewById(R.id.devider_line);
            Drawable drawable = ao.getDrawable(ConcernTabLiveItemView.this.mContext.getResources(), R.drawable.icon_living_seeding);
            drawable.setBounds(0, 0, ConcernTabLiveItemView.this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds8), ConcernTabLiveItemView.this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds8));
            this.gCP.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
            this.gFt = (TextView) this.elg.findViewById(R.id.user_name);
            this.gCX = (TextView) this.elg.findViewById(R.id.follow_btn);
            this.gFu = (TextView) this.elg.findViewById(R.id.followed_btn);
            this.gCX.setOnClickListener(this.mOnClickListener);
        }
    }
}
