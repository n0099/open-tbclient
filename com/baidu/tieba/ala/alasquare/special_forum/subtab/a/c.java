package com.baidu.tieba.ala.alasquare.special_forum.subtab.a;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.k;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.v;
import com.baidu.ala.data.AlaAttentionData;
import com.baidu.ala.view.AlaAttentionManager;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class c extends com.baidu.tieba.card.a<com.baidu.tieba.ala.alasquare.special_forum.data.f> {
    private a enj;
    private int enk;
    private TbPageContext mTbPageContext;

    public c(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        this.enk = 28;
        this.mTbPageContext = tbPageContext;
        this.enj = new a(this);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        am.setViewTextColor(this.enj.enn, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.enj.eno, (int) R.color.cp_cont_d);
        am.setViewTextColor(this.enj.enp, (int) R.color.cp_cont_d);
        am.setViewTextColor(this.enj.elc, (int) R.color.common_color_10140);
        am.setViewTextColor(this.enj.ekV, (int) R.color.cp_cont_d);
        am.getDrawable(this.mContext.getResources(), (int) R.drawable.icon_video_direct_seeding).setBounds(0, 0, this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds8), this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds8));
        this.enj.ekV.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(this.mContext.getResources(), (int) R.drawable.icon_living_seeding), (Drawable) null, (Drawable) null, (Drawable) null);
        am.setBackgroundColor(this.enj.cRG, R.color.cp_bg_line_c);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.special_bar_concern_live_item;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.ala.alasquare.special_forum.data.f fVar) {
        if (fVar.mUserData != null) {
            if (!StringUtils.isNull(fVar.mUserData.getPortrait())) {
                this.enj.enm.startLoad(fVar.mUserData.getPortrait(), 12, false);
            }
            if (!StringUtils.isNull(fVar.mUserData.getName_show())) {
                this.enj.enn.setText(fVar.mUserData.getName_show());
            }
            if (fVar.emh) {
                if (fVar.mUserData.hadConcerned()) {
                    this.enj.elc.setVisibility(8);
                    this.enj.enp.setVisibility(0);
                } else {
                    this.enj.elc.setVisibility(0);
                    this.enj.enp.setVisibility(8);
                }
            } else {
                this.enj.elc.setVisibility(8);
                this.enj.enp.setVisibility(8);
            }
            this.enj.elc.setTag(fVar.mUserData);
        }
        if (fVar.emg != null) {
            this.enj.cpR.setTag(fVar.emg);
            if (!StringUtils.isNull(fVar.emg.description)) {
                String str = fVar.emg.description;
                int i = this.enk;
                if (fVar.emh) {
                    i -= 9;
                }
                this.enj.eno.setText(k.byteLength(str) > i ? aq.cutChineseAndEnglishWithSuffix(str, i, StringHelper.STRING_MORE) : str);
            }
        }
        if (fVar.emh) {
            TiebaStatic.log(new an("c12895"));
        } else {
            TiebaStatic.log(new an("c12893"));
        }
        this.enj.elc.setTag(fVar.mUserData);
        onChangeSkinType(getTbPageContext(), TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    /* loaded from: classes2.dex */
    public class a extends v.a {
        public View cRG;
        public View cpR;
        public TextView ekV;
        public TextView elc;
        public c enl;
        public TbImageView enm;
        public TextView enn;
        public TextView eno;
        public TextView enp;
        private View.OnClickListener mOnClickListener;

        public a(c cVar) {
            super(cVar.getView());
            this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.a.c.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (view.getId() == R.id.follow_btn && (view.getTag() instanceof UserData)) {
                        if (!l.isNetOk()) {
                            c.this.mTbPageContext.showToast(R.string.neterror);
                            return;
                        }
                        UserData userData = (UserData) view.getTag();
                        AlaAttentionManager.getInstance().updateAttention(String.valueOf(userData.getUserId()), new AlaAttentionData(userData.getPortrait(), String.valueOf(userData.getUserId()), "1", true, null));
                        c.this.enj.elc.setVisibility(8);
                        c.this.enj.enp.setVisibility(0);
                        TiebaStatic.log(new an("c12897"));
                    }
                }
            };
            this.enl = cVar;
            this.cpR = cVar.getView();
            this.enm = (TbImageView) this.cpR.findViewById(R.id.protrait);
            this.enm.setDefaultResource(R.drawable.icon_default_avatar100_bg);
            this.enm.setIsRound(true);
            this.enm.setAutoChangeStyle(false);
            this.enm.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.enn = (TextView) this.cpR.findViewById(R.id.live_title);
            this.ekV = (TextView) this.cpR.findViewById(R.id.living_tag);
            this.cRG = this.cpR.findViewById(R.id.devider_line);
            Drawable drawable = am.getDrawable(c.this.mContext.getResources(), (int) R.drawable.icon_living_seeding);
            drawable.setBounds(0, 0, c.this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds8), c.this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds8));
            this.ekV.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
            this.eno = (TextView) this.cpR.findViewById(R.id.user_name);
            this.elc = (TextView) this.cpR.findViewById(R.id.follow_btn);
            this.enp = (TextView) this.cpR.findViewById(R.id.followed_btn);
            this.elc.setOnClickListener(this.mOnClickListener);
        }
    }
}
