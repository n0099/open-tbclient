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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class k {
    private o fuw;
    private HeadImageView fvG;
    private TextView fvH;
    private TextView fvI;
    private LinearLayout fvJ;
    private com.baidu.tieba.ala.alasquare.a.c fvm;
    private View mRootView;
    private TbPageContext<?> mTbPageContext;
    private String userId;
    private boolean fvK = false;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.k.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                if (k.this.fvm != null && k.this.fvm.frb != null && view == k.this.mRootView && k.this.fuw != null) {
                    k.this.fuw.a(k.this.fvm);
                    return;
                }
                return;
            }
            com.baidu.adp.lib.util.l.showLongToast(k.this.mTbPageContext.getPageActivity(), k.this.mTbPageContext.getPageActivity().getString(R.string.no_network_guide));
        }
    };

    public k(TbPageContext<?> tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.mRootView = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.tab_sub_recommend_item_view, (ViewGroup) null);
        this.fvJ = (LinearLayout) this.mRootView.findViewById(R.id.tab_sub_wrapper);
        this.fvG = (HeadImageView) this.mRootView.findViewById(R.id.iv_anchor_avatar);
        this.fvH = (TextView) this.mRootView.findViewById(R.id.tv_anchor_name);
        this.fvI = (TextView) this.mRootView.findViewById(R.id.tv_live_aud_num);
        this.mRootView.setOnClickListener(this.mOnClickListener);
        this.fvG.setBorderWidth(com.baidu.adp.lib.util.l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds1));
        this.fvG.setIsRound(true);
        this.fvG.setDefaultResource(R.drawable.icon_default_avatar100_bg);
        this.fvG.setAutoChangeStyle(true);
        this.fvG.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.fvJ.setLayoutParams(new LinearLayout.LayoutParams((com.baidu.adp.lib.util.l.getEquipmentWidth(this.mTbPageContext.getPageActivity()) - (this.mTbPageContext.getPageActivity().getResources().getDimensionPixelSize(R.dimen.tbds44) * 2)) / 3, this.mTbPageContext.getPageActivity().getResources().getDimensionPixelSize(R.dimen.tbds366)));
        onChangeSkinType(tbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        ao.setViewTextColor(this.fvH, R.color.cp_cont_b);
        ao.setViewTextColor(this.fvI, R.color.cp_cont_d);
        if (i == 1) {
            this.fvG.setBorderColor(this.mTbPageContext.getResources().getColor(R.color.cp_btn_c_1));
        } else {
            this.fvG.setBorderColor(this.mTbPageContext.getResources().getColor(R.color.cp_btn_c));
        }
        Drawable drawable = ao.getDrawable(this.mTbPageContext.getResources(), R.drawable.tab_icon_living_seeding);
        drawable.setBounds(0, 0, this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds18), this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds18));
        this.fvI.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
        this.fvI.setCompoundDrawablePadding(this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds8));
    }

    public void b(com.baidu.tieba.ala.alasquare.a.c cVar) {
        if (cVar == null || cVar.frb == null || cVar.frb.aWl() == null) {
            getView().setVisibility(4);
            return;
        }
        getView().setVisibility(0);
        this.fvm = cVar;
        this.fvK = cVar.fre;
        this.userId = cVar.frb.aWl().getUserId();
        this.fvG.startLoad(cVar.frb.aWl().getPortrait(), 25, false, false);
        String name_show = cVar.frb.aWl().getName_show();
        if (!StringUtils.isNull(name_show)) {
            if (com.baidu.adp.lib.util.k.byteLength(name_show) > 16) {
                name_show = as.cutChineseAndEnglishWithSuffix(name_show, 16, StringHelper.STRING_MORE);
            }
            this.fvH.setText(name_show);
        }
        if (cVar.frb.aWF() != null) {
            this.fvI.setText(String.format(this.mTbPageContext.getPageActivity().getResources().getString(R.string.live_tab_audience_watch_label), as.cE(cVar.frb.aWF().audience_count)));
        }
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    public View getView() {
        return this.mRootView;
    }

    public void a(o oVar) {
        this.fuw = oVar;
    }
}
