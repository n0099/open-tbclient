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
/* loaded from: classes9.dex */
public class g {
    private HeadImageView gAI;
    private TextView gAJ;
    private TextView gAK;
    private LinearLayout gAL;
    private com.baidu.tieba.ala.alasquare.a.e gAo;
    private i gzz;
    private View mRootView;
    private TbPageContext<?> mTbPageContext;
    private String userId;
    private boolean gAM = false;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.my_concern.view.g.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (j.isNetWorkAvailable()) {
                if (g.this.gAo != null && g.this.gAo.gvQ != null && view == g.this.mRootView && g.this.gzz != null) {
                    g.this.gzz.a(g.this.gAo);
                    return;
                }
                return;
            }
            l.showLongToast(g.this.mTbPageContext.getPageActivity(), g.this.mTbPageContext.getPageActivity().getString(R.string.no_network_guide));
        }
    };

    public g(TbPageContext<?> tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.mRootView = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.tab_sub_recommend_item_view, (ViewGroup) null);
        this.gAL = (LinearLayout) this.mRootView.findViewById(R.id.tab_sub_wrapper);
        this.gAI = (HeadImageView) this.mRootView.findViewById(R.id.iv_anchor_avatar);
        this.gAJ = (TextView) this.mRootView.findViewById(R.id.tv_anchor_name);
        this.gAK = (TextView) this.mRootView.findViewById(R.id.tv_live_aud_num);
        this.mRootView.setOnClickListener(this.mOnClickListener);
        this.gAI.setBorderWidth(l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds1));
        this.gAI.setIsRound(true);
        this.gAI.setPlaceHolder(1);
        this.gAI.setAutoChangeStyle(true);
        this.gAI.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.gAL.setLayoutParams(new LinearLayout.LayoutParams((l.getEquipmentWidth(this.mTbPageContext.getPageActivity()) - (this.mTbPageContext.getPageActivity().getResources().getDimensionPixelSize(R.dimen.tbds44) * 2)) / 3, this.mTbPageContext.getPageActivity().getResources().getDimensionPixelSize(R.dimen.tbds366)));
        onChangeSkinType(tbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        ao.setViewTextColor(this.gAJ, R.color.CAM_X0105);
        ao.setViewTextColor(this.gAK, R.color.CAM_X0109);
        if (i == 1) {
            this.gAI.setBorderColor(this.mTbPageContext.getResources().getColor(R.color.CAM_X0903_1));
        } else {
            this.gAI.setBorderColor(this.mTbPageContext.getResources().getColor(R.color.CAM_X0903));
        }
        Drawable drawable = ao.getDrawable(this.mTbPageContext.getResources(), R.drawable.tab_icon_living_seeding);
        drawable.setBounds(0, 0, this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds18), this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds18));
        this.gAK.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
        this.gAK.setCompoundDrawablePadding(this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds8));
    }

    public void b(com.baidu.tieba.ala.alasquare.a.e eVar) {
        if (eVar == null || eVar.gvQ == null || eVar.gvQ.bnx() == null) {
            getView().setVisibility(4);
            return;
        }
        getView().setVisibility(0);
        this.gAo = eVar;
        this.gAM = eVar.gvZ;
        this.userId = eVar.gvQ.bnx().getUserId();
        this.gAI.startLoad(eVar.gvQ.bnx().getPortrait(), 25, false, false);
        String name_show = eVar.gvQ.bnx().getName_show();
        if (!StringUtils.isNull(name_show)) {
            if (k.byteLength(name_show) > 16) {
                name_show = at.cutChineseAndEnglishWithSuffix(name_show, 16, StringHelper.STRING_MORE);
            }
            this.gAJ.setText(name_show);
        }
        if (eVar.gvQ.bnQ() != null) {
            this.gAK.setText(String.format(this.mTbPageContext.getPageActivity().getResources().getString(R.string.live_tab_audience_watch_label), at.dV(eVar.gvQ.bnQ().audience_count)));
        }
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    public View getView() {
        return this.mRootView;
    }

    public void a(i iVar) {
        this.gzz = iVar;
    }
}
