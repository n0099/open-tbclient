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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class k {
    private o enn;
    private TextView eoA;
    private TextView eoB;
    private LinearLayout eoC;
    private com.baidu.tieba.ala.alasquare.a.c eoe;
    private HeadImageView eoz;
    private View mRootView;
    private TbPageContext<?> mTbPageContext;
    private String userId;
    private boolean eoD = false;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.k.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                if (k.this.eoe != null && k.this.eoe.ejW != null && view == k.this.mRootView && k.this.enn != null) {
                    k.this.enn.a(k.this.eoe);
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
        this.eoC = (LinearLayout) this.mRootView.findViewById(R.id.tab_sub_wrapper);
        this.eoz = (HeadImageView) this.mRootView.findViewById(R.id.iv_anchor_avatar);
        this.eoA = (TextView) this.mRootView.findViewById(R.id.tv_anchor_name);
        this.eoB = (TextView) this.mRootView.findViewById(R.id.tv_live_aud_num);
        this.mRootView.setOnClickListener(this.mOnClickListener);
        this.eoz.setBorderWidth(com.baidu.adp.lib.util.l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds1));
        this.eoz.setIsRound(true);
        this.eoz.setDefaultResource(R.drawable.icon_default_avatar100_bg);
        this.eoz.setAutoChangeStyle(true);
        this.eoz.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.eoC.setLayoutParams(new LinearLayout.LayoutParams((com.baidu.adp.lib.util.l.getEquipmentWidth(this.mTbPageContext.getPageActivity()) - (this.mTbPageContext.getPageActivity().getResources().getDimensionPixelSize(R.dimen.tbds44) * 2)) / 3, this.mTbPageContext.getPageActivity().getResources().getDimensionPixelSize(R.dimen.tbds366)));
        onChangeSkinType(tbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        am.setViewTextColor(this.eoA, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.eoB, (int) R.color.cp_cont_d);
        if (i == 1) {
            this.eoz.setBorderColor(this.mTbPageContext.getResources().getColor(R.color.cp_btn_c_1));
        } else {
            this.eoz.setBorderColor(this.mTbPageContext.getResources().getColor(R.color.cp_btn_c));
        }
        Drawable drawable = am.getDrawable(this.mTbPageContext.getResources(), (int) R.drawable.tab_icon_living_seeding);
        drawable.setBounds(0, 0, this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds18), this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds18));
        this.eoB.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
        this.eoB.setCompoundDrawablePadding(this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds8));
    }

    public void b(com.baidu.tieba.ala.alasquare.a.c cVar) {
        if (cVar == null || cVar.ejW == null || cVar.ejW.aCo() == null) {
            getView().setVisibility(4);
            return;
        }
        getView().setVisibility(0);
        this.eoe = cVar;
        this.eoD = cVar.ejY;
        this.userId = cVar.ejW.aCo().getUserId();
        this.eoz.startLoad(cVar.ejW.aCo().getPortrait(), 25, false, false);
        String name_show = cVar.ejW.aCo().getName_show();
        if (!StringUtils.isNull(name_show)) {
            if (com.baidu.adp.lib.util.k.byteLength(name_show) > 16) {
                name_show = aq.cutChineseAndEnglishWithSuffix(name_show, 16, StringHelper.STRING_MORE);
            }
            this.eoA.setText(name_show);
        }
        if (cVar.ejW.aCH() != null) {
            this.eoB.setText(String.format(this.mTbPageContext.getPageActivity().getResources().getString(R.string.live_tab_audience_watch_label), aq.bE(cVar.ejW.aCH().audience_count)));
        }
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    public View getView() {
        return this.mRootView;
    }

    public void a(o oVar) {
        this.enn = oVar;
    }
}
