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
    private o fVw;
    private HeadImageView fWF;
    private TextView fWG;
    private TextView fWH;
    private LinearLayout fWI;
    private com.baidu.tieba.ala.alasquare.a.c fWm;
    private View mRootView;
    private TbPageContext<?> mTbPageContext;
    private String userId;
    private boolean fWJ = false;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.k.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                if (k.this.fWm != null && k.this.fWm.fRW != null && view == k.this.mRootView && k.this.fVw != null) {
                    k.this.fVw.a(k.this.fWm);
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
        this.fWI = (LinearLayout) this.mRootView.findViewById(R.id.tab_sub_wrapper);
        this.fWF = (HeadImageView) this.mRootView.findViewById(R.id.iv_anchor_avatar);
        this.fWG = (TextView) this.mRootView.findViewById(R.id.tv_anchor_name);
        this.fWH = (TextView) this.mRootView.findViewById(R.id.tv_live_aud_num);
        this.mRootView.setOnClickListener(this.mOnClickListener);
        this.fWF.setBorderWidth(com.baidu.adp.lib.util.l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds1));
        this.fWF.setIsRound(true);
        this.fWF.setDefaultResource(R.drawable.icon_default_avatar100_bg);
        this.fWF.setAutoChangeStyle(true);
        this.fWF.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.fWI.setLayoutParams(new LinearLayout.LayoutParams((com.baidu.adp.lib.util.l.getEquipmentWidth(this.mTbPageContext.getPageActivity()) - (this.mTbPageContext.getPageActivity().getResources().getDimensionPixelSize(R.dimen.tbds44) * 2)) / 3, this.mTbPageContext.getPageActivity().getResources().getDimensionPixelSize(R.dimen.tbds366)));
        onChangeSkinType(tbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        ap.setViewTextColor(this.fWG, R.color.cp_cont_b);
        ap.setViewTextColor(this.fWH, R.color.cp_cont_d);
        if (i == 1) {
            this.fWF.setBorderColor(this.mTbPageContext.getResources().getColor(R.color.cp_btn_c_1));
        } else {
            this.fWF.setBorderColor(this.mTbPageContext.getResources().getColor(R.color.cp_btn_c));
        }
        Drawable drawable = ap.getDrawable(this.mTbPageContext.getResources(), R.drawable.tab_icon_living_seeding);
        drawable.setBounds(0, 0, this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds18), this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds18));
        this.fWH.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
        this.fWH.setCompoundDrawablePadding(this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds8));
    }

    public void b(com.baidu.tieba.ala.alasquare.a.c cVar) {
        if (cVar == null || cVar.fRW == null || cVar.fRW.bih() == null) {
            getView().setVisibility(4);
            return;
        }
        getView().setVisibility(0);
        this.fWm = cVar;
        this.fWJ = cVar.fRY;
        this.userId = cVar.fRW.bih().getUserId();
        this.fWF.startLoad(cVar.fRW.bih().getPortrait(), 25, false, false);
        String name_show = cVar.fRW.bih().getName_show();
        if (!StringUtils.isNull(name_show)) {
            if (com.baidu.adp.lib.util.k.byteLength(name_show) > 16) {
                name_show = at.cutChineseAndEnglishWithSuffix(name_show, 16, StringHelper.STRING_MORE);
            }
            this.fWG.setText(name_show);
        }
        if (cVar.fRW.biB() != null) {
            this.fWH.setText(String.format(this.mTbPageContext.getPageActivity().getResources().getString(R.string.live_tab_audience_watch_label), at.cY(cVar.fRW.biB().audience_count)));
        }
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    public View getView() {
        return this.mRootView;
    }

    public void a(o oVar) {
        this.fVw = oVar;
    }
}
