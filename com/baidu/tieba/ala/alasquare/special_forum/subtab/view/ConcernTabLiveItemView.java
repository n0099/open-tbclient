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
/* loaded from: classes10.dex */
public class ConcernTabLiveItemView extends com.baidu.tieba.card.b<f> {
    private ViewHolder gIm;
    private int gIn;
    private TbPageContext mTbPageContext;

    public ConcernTabLiveItemView(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        this.gIn = 28;
        this.mTbPageContext = tbPageContext;
        this.gIm = new ViewHolder(this);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        ap.setViewTextColor(this.gIm.gIq, R.color.CAM_X0105);
        ap.setViewTextColor(this.gIm.gIr, R.color.CAM_X0109);
        ap.setViewTextColor(this.gIm.gIs, R.color.CAM_X0109);
        ap.setViewTextColor(this.gIm.gFV, R.color.common_color_10140);
        ap.setViewTextColor(this.gIm.gFN, R.color.CAM_X0109);
        ap.getDrawable(this.mContext.getResources(), R.drawable.icon_video_direct_seeding).setBounds(0, 0, this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds8), this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds8));
        this.gIm.gFN.setCompoundDrawablesWithIntrinsicBounds(ap.getDrawable(this.mContext.getResources(), R.drawable.icon_living_seeding), (Drawable) null, (Drawable) null, (Drawable) null);
        ap.setBackgroundColor(this.gIm.bTo, R.color.CAM_X0204);
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
                this.gIm.gIp.startLoad(fVar.mUserData.getPortrait(), 12, false);
            }
            if (!StringUtils.isNull(fVar.mUserData.getName_show())) {
                this.gIm.gIq.setText(fVar.mUserData.getName_show());
            }
            if (fVar.gGY) {
                if (fVar.mUserData.hadConcerned()) {
                    this.gIm.gFV.setVisibility(8);
                    this.gIm.gIs.setVisibility(0);
                } else {
                    this.gIm.gFV.setVisibility(0);
                    this.gIm.gIs.setVisibility(8);
                }
            } else {
                this.gIm.gFV.setVisibility(8);
                this.gIm.gIs.setVisibility(8);
            }
            this.gIm.gFV.setTag(fVar.mUserData);
        }
        if (fVar.gGX != null) {
            this.gIm.eno.setTag(fVar.gGX);
            if (!StringUtils.isNull(fVar.gGX.description)) {
                String str = fVar.gGX.description;
                int i = this.gIn;
                if (fVar.gGY) {
                    i -= 9;
                }
                this.gIm.gIr.setText(k.byteLength(str) > i ? au.cutChineseAndEnglishWithSuffix(str, i, StringHelper.STRING_MORE) : str);
            }
        }
        if (fVar.gGY) {
            TiebaStatic.log(new ar("c12895"));
        } else {
            TiebaStatic.log(new ar("c12893"));
        }
        this.gIm.gFV.setTag(fVar.mUserData);
        onChangeSkinType(getTbPageContext(), TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    /* loaded from: classes10.dex */
    public class ViewHolder extends TypeAdapter.ViewHolder {
        public View bTo;
        public View eno;
        public TextView gFN;
        public TextView gFV;
        public ConcernTabLiveItemView gIo;
        public TbImageView gIp;
        public TextView gIq;
        public TextView gIr;
        public TextView gIs;
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
                        ConcernTabLiveItemView.this.gIm.gFV.setVisibility(8);
                        ConcernTabLiveItemView.this.gIm.gIs.setVisibility(0);
                        TiebaStatic.log(new ar("c12897"));
                    }
                }
            };
            this.gIo = concernTabLiveItemView;
            this.eno = concernTabLiveItemView.getView();
            this.gIp = (TbImageView) this.eno.findViewById(R.id.protrait);
            this.gIp.setDefaultResource(R.drawable.icon_default_avatar100_bg);
            this.gIp.setIsRound(true);
            this.gIp.setAutoChangeStyle(false);
            this.gIp.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.gIq = (TextView) this.eno.findViewById(R.id.live_title);
            this.gFN = (TextView) this.eno.findViewById(R.id.living_tag);
            this.bTo = this.eno.findViewById(R.id.devider_line);
            Drawable drawable = ap.getDrawable(ConcernTabLiveItemView.this.mContext.getResources(), R.drawable.icon_living_seeding);
            drawable.setBounds(0, 0, ConcernTabLiveItemView.this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds8), ConcernTabLiveItemView.this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds8));
            this.gFN.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
            this.gIr = (TextView) this.eno.findViewById(R.id.user_name);
            this.gFV = (TextView) this.eno.findViewById(R.id.follow_btn);
            this.gIs = (TextView) this.eno.findViewById(R.id.followed_btn);
            this.gFV.setOnClickListener(this.mOnClickListener);
        }
    }
}
