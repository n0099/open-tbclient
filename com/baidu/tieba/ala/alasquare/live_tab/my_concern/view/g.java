package com.baidu.tieba.ala.alasquare.live_tab.my_concern.view;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.k;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
/* loaded from: classes10.dex */
public class g {
    private com.baidu.tieba.ala.alasquare.a.e gEV;
    private i gEg;
    private HeadImageView gFo;
    private TextView gFp;
    private TextView gFq;
    private LinearLayout gFr;
    private boolean gFs = false;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.my_concern.view.g.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (j.isNetWorkAvailable()) {
                if (g.this.gEV != null && g.this.gEV.gAx != null && view == g.this.mRootView && g.this.gEg != null) {
                    g.this.gEg.a(g.this.gEV);
                    return;
                }
                return;
            }
            l.showLongToast(g.this.mTbPageContext.getPageActivity(), g.this.mTbPageContext.getPageActivity().getString(R.string.no_network_guide));
        }
    };
    private View mRootView;
    private TbPageContext<?> mTbPageContext;
    private String userId;

    public g(TbPageContext<?> tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.mRootView = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.tab_sub_recommend_item_view, (ViewGroup) null);
        this.gFr = (LinearLayout) this.mRootView.findViewById(R.id.tab_sub_wrapper);
        this.gFo = (HeadImageView) this.mRootView.findViewById(R.id.iv_anchor_avatar);
        this.gFp = (TextView) this.mRootView.findViewById(R.id.tv_anchor_name);
        this.gFq = (TextView) this.mRootView.findViewById(R.id.tv_live_aud_num);
        this.mRootView.setOnClickListener(this.mOnClickListener);
        this.gFo.setBorderWidth(l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds1));
        this.gFo.setIsRound(true);
        this.gFo.setPlaceHolder(1);
        this.gFo.setAutoChangeStyle(true);
        this.gFo.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.gFr.setLayoutParams(new LinearLayout.LayoutParams((l.getEquipmentWidth(this.mTbPageContext.getPageActivity()) - (this.mTbPageContext.getPageActivity().getResources().getDimensionPixelSize(R.dimen.tbds44) * 2)) / 3, this.mTbPageContext.getPageActivity().getResources().getDimensionPixelSize(R.dimen.tbds366)));
        onChangeSkinType(tbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        ao.setViewTextColor(this.gFp, R.color.CAM_X0105);
        ao.setViewTextColor(this.gFq, R.color.CAM_X0109);
        if (i == 1) {
            this.gFo.setBorderColor(this.mTbPageContext.getResources().getColor(R.color.CAM_X0903_1));
        } else {
            this.gFo.setBorderColor(this.mTbPageContext.getResources().getColor(R.color.CAM_X0903));
        }
        Drawable drawable = ao.getDrawable(this.mTbPageContext.getResources(), R.drawable.tab_icon_living_seeding);
        drawable.setBounds(0, 0, this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds18), this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds18));
        this.gFq.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
        this.gFq.setCompoundDrawablePadding(this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds8));
    }

    public void b(com.baidu.tieba.ala.alasquare.a.e eVar) {
        if (eVar == null || eVar.gAx == null || eVar.gAx.brq() == null) {
            getView().setVisibility(4);
            return;
        }
        getView().setVisibility(0);
        this.gEV = eVar;
        this.gFs = eVar.gAG;
        this.userId = eVar.gAx.brq().getUserId();
        this.gFo.startLoad(eVar.gAx.brq().getPortrait(), 25, false, false);
        String name_show = eVar.gAx.brq().getName_show();
        if (!StringUtils.isNull(name_show)) {
            if (k.byteLength(name_show) > 16) {
                name_show = at.cutChineseAndEnglishWithSuffix(name_show, 16, StringHelper.STRING_MORE);
            }
            this.gFp.setText(name_show);
        }
        if (eVar.gAx.brJ() != null) {
            this.gFq.setText(String.format(this.mTbPageContext.getPageActivity().getResources().getString(R.string.live_tab_audience_watch_label), at.dV(eVar.gAx.brJ().audience_count)));
        }
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    public View getView() {
        return this.mRootView;
    }

    public void a(i iVar) {
        this.gEg = iVar;
    }
}
