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
    private com.baidu.tieba.ala.alasquare.a.c gtW;
    private o gth;
    private HeadImageView gup;
    private TextView guq;
    private TextView gur;
    private LinearLayout gus;
    private boolean gut = false;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.k.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                if (k.this.gtW != null && k.this.gtW.gpH != null && view == k.this.mRootView && k.this.gth != null) {
                    k.this.gth.a(k.this.gtW);
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
        this.gus = (LinearLayout) this.mRootView.findViewById(R.id.tab_sub_wrapper);
        this.gup = (HeadImageView) this.mRootView.findViewById(R.id.iv_anchor_avatar);
        this.guq = (TextView) this.mRootView.findViewById(R.id.tv_anchor_name);
        this.gur = (TextView) this.mRootView.findViewById(R.id.tv_live_aud_num);
        this.mRootView.setOnClickListener(this.mOnClickListener);
        this.gup.setBorderWidth(com.baidu.adp.lib.util.l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds1));
        this.gup.setIsRound(true);
        this.gup.setPlaceHolder(1);
        this.gup.setAutoChangeStyle(true);
        this.gup.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.gus.setLayoutParams(new LinearLayout.LayoutParams((com.baidu.adp.lib.util.l.getEquipmentWidth(this.mTbPageContext.getPageActivity()) - (this.mTbPageContext.getPageActivity().getResources().getDimensionPixelSize(R.dimen.tbds44) * 2)) / 3, this.mTbPageContext.getPageActivity().getResources().getDimensionPixelSize(R.dimen.tbds366)));
        onChangeSkinType(tbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        ap.setViewTextColor(this.guq, (int) R.color.CAM_X0105);
        ap.setViewTextColor(this.gur, (int) R.color.CAM_X0109);
        if (i == 1) {
            this.gup.setBorderColor(this.mTbPageContext.getResources().getColor(R.color.CAM_X0903_1));
        } else {
            this.gup.setBorderColor(this.mTbPageContext.getResources().getColor(R.color.CAM_X0903));
        }
        Drawable drawable = ap.getDrawable(this.mTbPageContext.getResources(), (int) R.drawable.tab_icon_living_seeding);
        drawable.setBounds(0, 0, this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds18), this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds18));
        this.gur.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
        this.gur.setCompoundDrawablePadding(this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds8));
    }

    public void b(com.baidu.tieba.ala.alasquare.a.c cVar) {
        if (cVar == null || cVar.gpH == null || cVar.gpH.boP() == null) {
            getView().setVisibility(4);
            return;
        }
        getView().setVisibility(0);
        this.gtW = cVar;
        this.gut = cVar.gpJ;
        this.userId = cVar.gpH.boP().getUserId();
        this.gup.startLoad(cVar.gpH.boP().getPortrait(), 25, false, false);
        String name_show = cVar.gpH.boP().getName_show();
        if (!StringUtils.isNull(name_show)) {
            if (com.baidu.adp.lib.util.k.byteLength(name_show) > 16) {
                name_show = au.cutChineseAndEnglishWithSuffix(name_show, 16, StringHelper.STRING_MORE);
            }
            this.guq.setText(name_show);
        }
        if (cVar.gpH.bpj() != null) {
            this.gur.setText(String.format(this.mTbPageContext.getPageActivity().getResources().getString(R.string.live_tab_audience_watch_label), au.dV(cVar.gpH.bpj().audience_count)));
        }
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    public View getView() {
        return this.mRootView;
    }

    public void a(o oVar) {
        this.gth = oVar;
    }
}
