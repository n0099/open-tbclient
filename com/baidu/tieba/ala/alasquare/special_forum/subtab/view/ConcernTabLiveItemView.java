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
    private ViewHolder gHY;
    private int gHZ;
    private TbPageContext mTbPageContext;

    public ConcernTabLiveItemView(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        this.gHZ = 28;
        this.mTbPageContext = tbPageContext;
        this.gHY = new ViewHolder(this);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        ap.setViewTextColor(this.gHY.gIc, R.color.CAM_X0105);
        ap.setViewTextColor(this.gHY.gId, R.color.CAM_X0109);
        ap.setViewTextColor(this.gHY.gIe, R.color.CAM_X0109);
        ap.setViewTextColor(this.gHY.gFH, R.color.common_color_10140);
        ap.setViewTextColor(this.gHY.gFz, R.color.CAM_X0109);
        ap.getDrawable(this.mContext.getResources(), R.drawable.icon_video_direct_seeding).setBounds(0, 0, this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds8), this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds8));
        this.gHY.gFz.setCompoundDrawablesWithIntrinsicBounds(ap.getDrawable(this.mContext.getResources(), R.drawable.icon_living_seeding), (Drawable) null, (Drawable) null, (Drawable) null);
        ap.setBackgroundColor(this.gHY.bTo, R.color.CAM_X0204);
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
                this.gHY.gIb.startLoad(fVar.mUserData.getPortrait(), 12, false);
            }
            if (!StringUtils.isNull(fVar.mUserData.getName_show())) {
                this.gHY.gIc.setText(fVar.mUserData.getName_show());
            }
            if (fVar.gGK) {
                if (fVar.mUserData.hadConcerned()) {
                    this.gHY.gFH.setVisibility(8);
                    this.gHY.gIe.setVisibility(0);
                } else {
                    this.gHY.gFH.setVisibility(0);
                    this.gHY.gIe.setVisibility(8);
                }
            } else {
                this.gHY.gFH.setVisibility(8);
                this.gHY.gIe.setVisibility(8);
            }
            this.gHY.gFH.setTag(fVar.mUserData);
        }
        if (fVar.gGJ != null) {
            this.gHY.eno.setTag(fVar.gGJ);
            if (!StringUtils.isNull(fVar.gGJ.description)) {
                String str = fVar.gGJ.description;
                int i = this.gHZ;
                if (fVar.gGK) {
                    i -= 9;
                }
                this.gHY.gId.setText(k.byteLength(str) > i ? au.cutChineseAndEnglishWithSuffix(str, i, StringHelper.STRING_MORE) : str);
            }
        }
        if (fVar.gGK) {
            TiebaStatic.log(new ar("c12895"));
        } else {
            TiebaStatic.log(new ar("c12893"));
        }
        this.gHY.gFH.setTag(fVar.mUserData);
        onChangeSkinType(getTbPageContext(), TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    /* loaded from: classes10.dex */
    public class ViewHolder extends TypeAdapter.ViewHolder {
        public View bTo;
        public View eno;
        public TextView gFH;
        public TextView gFz;
        public ConcernTabLiveItemView gIa;
        public TbImageView gIb;
        public TextView gIc;
        public TextView gId;
        public TextView gIe;
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
                        ConcernTabLiveItemView.this.gHY.gFH.setVisibility(8);
                        ConcernTabLiveItemView.this.gHY.gIe.setVisibility(0);
                        TiebaStatic.log(new ar("c12897"));
                    }
                }
            };
            this.gIa = concernTabLiveItemView;
            this.eno = concernTabLiveItemView.getView();
            this.gIb = (TbImageView) this.eno.findViewById(R.id.protrait);
            this.gIb.setDefaultResource(R.drawable.icon_default_avatar100_bg);
            this.gIb.setIsRound(true);
            this.gIb.setAutoChangeStyle(false);
            this.gIb.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.gIc = (TextView) this.eno.findViewById(R.id.live_title);
            this.gFz = (TextView) this.eno.findViewById(R.id.living_tag);
            this.bTo = this.eno.findViewById(R.id.devider_line);
            Drawable drawable = ap.getDrawable(ConcernTabLiveItemView.this.mContext.getResources(), R.drawable.icon_living_seeding);
            drawable.setBounds(0, 0, ConcernTabLiveItemView.this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds8), ConcernTabLiveItemView.this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds8));
            this.gFz.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
            this.gId = (TextView) this.eno.findViewById(R.id.user_name);
            this.gFH = (TextView) this.eno.findViewById(R.id.follow_btn);
            this.gIe = (TextView) this.eno.findViewById(R.id.followed_btn);
            this.gFH.setOnClickListener(this.mOnClickListener);
        }
    }
}
