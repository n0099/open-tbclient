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
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class k {
    private o fFP;
    private com.baidu.tieba.ala.alasquare.a.c fGF;
    private HeadImageView fGY;
    private TextView fGZ;
    private TextView fHa;
    private LinearLayout fHb;
    private boolean fHc = false;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.k.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                if (k.this.fGF != null && k.this.fGF.fCx != null && view == k.this.mRootView && k.this.fFP != null) {
                    k.this.fFP.a(k.this.fGF);
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
        this.fHb = (LinearLayout) this.mRootView.findViewById(R.id.tab_sub_wrapper);
        this.fGY = (HeadImageView) this.mRootView.findViewById(R.id.iv_anchor_avatar);
        this.fGZ = (TextView) this.mRootView.findViewById(R.id.tv_anchor_name);
        this.fHa = (TextView) this.mRootView.findViewById(R.id.tv_live_aud_num);
        this.mRootView.setOnClickListener(this.mOnClickListener);
        this.fGY.setBorderWidth(com.baidu.adp.lib.util.l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds1));
        this.fGY.setIsRound(true);
        this.fGY.setDefaultResource(R.drawable.icon_default_avatar100_bg);
        this.fGY.setAutoChangeStyle(true);
        this.fGY.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.fHb.setLayoutParams(new LinearLayout.LayoutParams((com.baidu.adp.lib.util.l.getEquipmentWidth(this.mTbPageContext.getPageActivity()) - (this.mTbPageContext.getPageActivity().getResources().getDimensionPixelSize(R.dimen.tbds44) * 2)) / 3, this.mTbPageContext.getPageActivity().getResources().getDimensionPixelSize(R.dimen.tbds366)));
        onChangeSkinType(tbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        ap.setViewTextColor(this.fGZ, (int) R.color.cp_cont_b);
        ap.setViewTextColor(this.fHa, (int) R.color.cp_cont_d);
        if (i == 1) {
            this.fGY.setBorderColor(this.mTbPageContext.getResources().getColor(R.color.cp_btn_c_1));
        } else {
            this.fGY.setBorderColor(this.mTbPageContext.getResources().getColor(R.color.cp_btn_c));
        }
        Drawable drawable = ap.getDrawable(this.mTbPageContext.getResources(), (int) R.drawable.tab_icon_living_seeding);
        drawable.setBounds(0, 0, this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds18), this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds18));
        this.fHa.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
        this.fHa.setCompoundDrawablePadding(this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds8));
    }

    public void b(com.baidu.tieba.ala.alasquare.a.c cVar) {
        if (cVar == null || cVar.fCx == null || cVar.fCx.beE() == null) {
            getView().setVisibility(4);
            return;
        }
        getView().setVisibility(0);
        this.fGF = cVar;
        this.fHc = cVar.fCz;
        this.userId = cVar.fCx.beE().getUserId();
        this.fGY.startLoad(cVar.fCx.beE().getPortrait(), 25, false, false);
        String name_show = cVar.fCx.beE().getName_show();
        if (!StringUtils.isNull(name_show)) {
            if (com.baidu.adp.lib.util.k.byteLength(name_show) > 16) {
                name_show = at.cutChineseAndEnglishWithSuffix(name_show, 16, StringHelper.STRING_MORE);
            }
            this.fGZ.setText(name_show);
        }
        if (cVar.fCx.beY() != null) {
            this.fHa.setText(String.format(this.mTbPageContext.getPageActivity().getResources().getString(R.string.live_tab_audience_watch_label), at.cP(cVar.fCx.beY().audience_count)));
        }
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    public View getView() {
        return this.mRootView;
    }

    public void a(o oVar) {
        this.fFP = oVar;
    }
}
