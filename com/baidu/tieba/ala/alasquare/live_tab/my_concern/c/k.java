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
    private o glp;
    private LinearLayout gmA;
    private com.baidu.tieba.ala.alasquare.a.c gme;
    private HeadImageView gmx;
    private TextView gmy;
    private TextView gmz;
    private View mRootView;
    private TbPageContext<?> mTbPageContext;
    private String userId;
    private boolean gmB = false;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.k.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                if (k.this.gme != null && k.this.gme.ghO != null && view == k.this.mRootView && k.this.glp != null) {
                    k.this.glp.a(k.this.gme);
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
        this.gmA = (LinearLayout) this.mRootView.findViewById(R.id.tab_sub_wrapper);
        this.gmx = (HeadImageView) this.mRootView.findViewById(R.id.iv_anchor_avatar);
        this.gmy = (TextView) this.mRootView.findViewById(R.id.tv_anchor_name);
        this.gmz = (TextView) this.mRootView.findViewById(R.id.tv_live_aud_num);
        this.mRootView.setOnClickListener(this.mOnClickListener);
        this.gmx.setBorderWidth(com.baidu.adp.lib.util.l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds1));
        this.gmx.setIsRound(true);
        this.gmx.setDefaultResource(R.drawable.icon_default_avatar100_bg);
        this.gmx.setAutoChangeStyle(true);
        this.gmx.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.gmA.setLayoutParams(new LinearLayout.LayoutParams((com.baidu.adp.lib.util.l.getEquipmentWidth(this.mTbPageContext.getPageActivity()) - (this.mTbPageContext.getPageActivity().getResources().getDimensionPixelSize(R.dimen.tbds44) * 2)) / 3, this.mTbPageContext.getPageActivity().getResources().getDimensionPixelSize(R.dimen.tbds366)));
        onChangeSkinType(tbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        ap.setViewTextColor(this.gmy, (int) R.color.cp_cont_b);
        ap.setViewTextColor(this.gmz, (int) R.color.cp_cont_d);
        if (i == 1) {
            this.gmx.setBorderColor(this.mTbPageContext.getResources().getColor(R.color.cp_btn_c_1));
        } else {
            this.gmx.setBorderColor(this.mTbPageContext.getResources().getColor(R.color.cp_btn_c));
        }
        Drawable drawable = ap.getDrawable(this.mTbPageContext.getResources(), (int) R.drawable.tab_icon_living_seeding);
        drawable.setBounds(0, 0, this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds18), this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds18));
        this.gmz.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
        this.gmz.setCompoundDrawablePadding(this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds8));
    }

    public void b(com.baidu.tieba.ala.alasquare.a.c cVar) {
        if (cVar == null || cVar.ghO == null || cVar.ghO.bmA() == null) {
            getView().setVisibility(4);
            return;
        }
        getView().setVisibility(0);
        this.gme = cVar;
        this.gmB = cVar.ghQ;
        this.userId = cVar.ghO.bmA().getUserId();
        this.gmx.startLoad(cVar.ghO.bmA().getPortrait(), 25, false, false);
        String name_show = cVar.ghO.bmA().getName_show();
        if (!StringUtils.isNull(name_show)) {
            if (com.baidu.adp.lib.util.k.byteLength(name_show) > 16) {
                name_show = at.cutChineseAndEnglishWithSuffix(name_show, 16, StringHelper.STRING_MORE);
            }
            this.gmy.setText(name_show);
        }
        if (cVar.ghO.bmU() != null) {
            this.gmz.setText(String.format(this.mTbPageContext.getPageActivity().getResources().getString(R.string.live_tab_audience_watch_label), at.dw(cVar.ghO.bmU().audience_count)));
        }
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    public View getView() {
        return this.mRootView;
    }

    public void a(o oVar) {
        this.glp = oVar;
    }
}
