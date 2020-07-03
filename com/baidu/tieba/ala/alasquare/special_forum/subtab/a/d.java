package com.baidu.tieba.ala.alasquare.special_forum.subtab.a;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.k;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.ad;
import com.baidu.ala.data.AlaAttentionData;
import com.baidu.ala.view.AlaAttentionManager;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class d extends com.baidu.tieba.card.b<com.baidu.tieba.ala.alasquare.special_forum.data.f> {
    private a fuZ;
    private int fva;
    private TbPageContext mTbPageContext;

    public d(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        this.fva = 28;
        this.mTbPageContext = tbPageContext;
        this.fuZ = new a(this);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        an.setViewTextColor(this.fuZ.fvd, (int) R.color.cp_cont_b);
        an.setViewTextColor(this.fuZ.fve, (int) R.color.cp_cont_d);
        an.setViewTextColor(this.fuZ.fvf, (int) R.color.cp_cont_d);
        an.setViewTextColor(this.fuZ.fsF, (int) R.color.common_color_10140);
        an.setViewTextColor(this.fuZ.fsy, (int) R.color.cp_cont_d);
        an.getDrawable(this.mContext.getResources(), (int) R.drawable.icon_video_direct_seeding).setBounds(0, 0, this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds8), this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds8));
        this.fuZ.fsy.setCompoundDrawablesWithIntrinsicBounds(an.getDrawable(this.mContext.getResources(), (int) R.drawable.icon_living_seeding), (Drawable) null, (Drawable) null, (Drawable) null);
        an.setBackgroundColor(this.fuZ.dQh, R.color.cp_bg_line_c);
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
                this.fuZ.fvc.startLoad(fVar.mUserData.getPortrait(), 12, false);
            }
            if (!StringUtils.isNull(fVar.mUserData.getName_show())) {
                this.fuZ.fvd.setText(fVar.mUserData.getName_show());
            }
            if (fVar.ftL) {
                if (fVar.mUserData.hadConcerned()) {
                    this.fuZ.fsF.setVisibility(8);
                    this.fuZ.fvf.setVisibility(0);
                } else {
                    this.fuZ.fsF.setVisibility(0);
                    this.fuZ.fvf.setVisibility(8);
                }
            } else {
                this.fuZ.fsF.setVisibility(8);
                this.fuZ.fvf.setVisibility(8);
            }
            this.fuZ.fsF.setTag(fVar.mUserData);
        }
        if (fVar.ftK != null) {
            this.fuZ.djj.setTag(fVar.ftK);
            if (!StringUtils.isNull(fVar.ftK.description)) {
                String str = fVar.ftK.description;
                int i = this.fva;
                if (fVar.ftL) {
                    i -= 9;
                }
                this.fuZ.fve.setText(k.byteLength(str) > i ? ar.cutChineseAndEnglishWithSuffix(str, i, StringHelper.STRING_MORE) : str);
            }
        }
        if (fVar.ftL) {
            TiebaStatic.log(new ao("c12895"));
        } else {
            TiebaStatic.log(new ao("c12893"));
        }
        this.fuZ.fsF.setTag(fVar.mUserData);
        onChangeSkinType(getTbPageContext(), TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    /* loaded from: classes3.dex */
    public class a extends ad.a {
        public View dQh;
        public View djj;
        public TextView fsF;
        public TextView fsy;
        public d fvb;
        public TbImageView fvc;
        public TextView fvd;
        public TextView fve;
        public TextView fvf;
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
                        d.this.fuZ.fsF.setVisibility(8);
                        d.this.fuZ.fvf.setVisibility(0);
                        TiebaStatic.log(new ao("c12897"));
                    }
                }
            };
            this.fvb = dVar;
            this.djj = dVar.getView();
            this.fvc = (TbImageView) this.djj.findViewById(R.id.protrait);
            this.fvc.setDefaultResource(R.drawable.icon_default_avatar100_bg);
            this.fvc.setIsRound(true);
            this.fvc.setAutoChangeStyle(false);
            this.fvc.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.fvd = (TextView) this.djj.findViewById(R.id.live_title);
            this.fsy = (TextView) this.djj.findViewById(R.id.living_tag);
            this.dQh = this.djj.findViewById(R.id.devider_line);
            Drawable drawable = an.getDrawable(d.this.mContext.getResources(), (int) R.drawable.icon_living_seeding);
            drawable.setBounds(0, 0, d.this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds8), d.this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds8));
            this.fsy.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
            this.fve = (TextView) this.djj.findViewById(R.id.user_name);
            this.fsF = (TextView) this.djj.findViewById(R.id.follow_btn);
            this.fvf = (TextView) this.djj.findViewById(R.id.followed_btn);
            this.fsF.setOnClickListener(this.mOnClickListener);
        }
    }
}
