package com.baidu.tieba.ala.alasquare.live_tab.my_concern.c;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
/* loaded from: classes6.dex */
public class k {
    private com.baidu.tieba.ala.alasquare.a.c gtU;
    private o gtf;
    private HeadImageView gun;
    private TextView guo;
    private TextView gup;
    private LinearLayout guq;
    private boolean gur = false;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.k.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                if (k.this.gtU != null && k.this.gtU.gpF != null && view == k.this.mRootView && k.this.gtf != null) {
                    k.this.gtf.a(k.this.gtU);
                    return;
                }
                return;
            }
            com.baidu.adp.lib.util.l.showLongToast(k.this.mTbPageContext.getPageActivity(), k.this.mTbPageContext.getPageActivity().getString(R.string.no_network_guide));
        }
    };
    private View mRootView;
    private TbPageContext<?> mTbPageContext;
    private String userId;

    public k(TbPageContext<?> tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.mRootView = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.tab_sub_recommend_item_view, (ViewGroup) null);
        this.guq = (LinearLayout) this.mRootView.findViewById(R.id.tab_sub_wrapper);
        this.gun = (HeadImageView) this.mRootView.findViewById(R.id.iv_anchor_avatar);
        this.guo = (TextView) this.mRootView.findViewById(R.id.tv_anchor_name);
        this.gup = (TextView) this.mRootView.findViewById(R.id.tv_live_aud_num);
        this.mRootView.setOnClickListener(this.mOnClickListener);
        this.gun.setBorderWidth(com.baidu.adp.lib.util.l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds1));
        this.gun.setIsRound(true);
        this.gun.setPlaceHolder(1);
        this.gun.setAutoChangeStyle(true);
        this.gun.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.guq.setLayoutParams(new LinearLayout.LayoutParams((com.baidu.adp.lib.util.l.getEquipmentWidth(this.mTbPageContext.getPageActivity()) - (this.mTbPageContext.getPageActivity().getResources().getDimensionPixelSize(R.dimen.tbds44) * 2)) / 3, this.mTbPageContext.getPageActivity().getResources().getDimensionPixelSize(R.dimen.tbds366)));
        onChangeSkinType(tbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        ap.setViewTextColor(this.guo, (int) R.color.CAM_X0105);
        ap.setViewTextColor(this.gup, (int) R.color.CAM_X0109);
        if (i == 1) {
            this.gun.setBorderColor(this.mTbPageContext.getResources().getColor(R.color.CAM_X0903_1));
        } else {
            this.gun.setBorderColor(this.mTbPageContext.getResources().getColor(R.color.CAM_X0903));
        }
        Drawable drawable = ap.getDrawable(this.mTbPageContext.getResources(), (int) R.drawable.tab_icon_living_seeding);
        drawable.setBounds(0, 0, this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds18), this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds18));
        this.gup.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
        this.gup.setCompoundDrawablePadding(this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds8));
    }

    public void b(com.baidu.tieba.ala.alasquare.a.c cVar) {
        if (cVar == null || cVar.gpF == null || cVar.gpF.boP() == null) {
            getView().setVisibility(4);
            return;
        }
        getView().setVisibility(0);
        this.gtU = cVar;
        this.gur = cVar.gpH;
        this.userId = cVar.gpF.boP().getUserId();
        this.gun.startLoad(cVar.gpF.boP().getPortrait(), 25, false, false);
        String name_show = cVar.gpF.boP().getName_show();
        if (!StringUtils.isNull(name_show)) {
            if (com.baidu.adp.lib.util.k.byteLength(name_show) > 16) {
                name_show = au.cutChineseAndEnglishWithSuffix(name_show, 16, StringHelper.STRING_MORE);
            }
            this.guo.setText(name_show);
        }
        if (cVar.gpF.bpj() != null) {
            this.gup.setText(String.format(this.mTbPageContext.getPageActivity().getResources().getString(R.string.live_tab_audience_watch_label), au.dV(cVar.gpF.bpj().audience_count)));
        }
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    public View getView() {
        return this.mRootView;
    }

    public void a(o oVar) {
        this.gtf = oVar;
    }
}
