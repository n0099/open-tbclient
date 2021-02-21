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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
/* loaded from: classes10.dex */
public class g {
    private i gCx;
    private HeadImageView gDG;
    private TextView gDH;
    private TextView gDI;
    private LinearLayout gDJ;
    private com.baidu.tieba.ala.alasquare.a.e gDm;
    private View mRootView;
    private TbPageContext<?> mTbPageContext;
    private String userId;
    private boolean gDK = false;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.my_concern.view.g.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (j.isNetWorkAvailable()) {
                if (g.this.gDm != null && g.this.gDm.gyO != null && view == g.this.mRootView && g.this.gCx != null) {
                    g.this.gCx.a(g.this.gDm);
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
        this.gDJ = (LinearLayout) this.mRootView.findViewById(R.id.tab_sub_wrapper);
        this.gDG = (HeadImageView) this.mRootView.findViewById(R.id.iv_anchor_avatar);
        this.gDH = (TextView) this.mRootView.findViewById(R.id.tv_anchor_name);
        this.gDI = (TextView) this.mRootView.findViewById(R.id.tv_live_aud_num);
        this.mRootView.setOnClickListener(this.mOnClickListener);
        this.gDG.setBorderWidth(l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds1));
        this.gDG.setIsRound(true);
        this.gDG.setPlaceHolder(1);
        this.gDG.setAutoChangeStyle(true);
        this.gDG.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.gDJ.setLayoutParams(new LinearLayout.LayoutParams((l.getEquipmentWidth(this.mTbPageContext.getPageActivity()) - (this.mTbPageContext.getPageActivity().getResources().getDimensionPixelSize(R.dimen.tbds44) * 2)) / 3, this.mTbPageContext.getPageActivity().getResources().getDimensionPixelSize(R.dimen.tbds366)));
        onChangeSkinType(tbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        ap.setViewTextColor(this.gDH, R.color.CAM_X0105);
        ap.setViewTextColor(this.gDI, R.color.CAM_X0109);
        if (i == 1) {
            this.gDG.setBorderColor(this.mTbPageContext.getResources().getColor(R.color.CAM_X0903_1));
        } else {
            this.gDG.setBorderColor(this.mTbPageContext.getResources().getColor(R.color.CAM_X0903));
        }
        Drawable drawable = ap.getDrawable(this.mTbPageContext.getResources(), R.drawable.tab_icon_living_seeding);
        drawable.setBounds(0, 0, this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds18), this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds18));
        this.gDI.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
        this.gDI.setCompoundDrawablePadding(this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds8));
    }

    public void b(com.baidu.tieba.ala.alasquare.a.e eVar) {
        if (eVar == null || eVar.gyO == null || eVar.gyO.bnQ() == null) {
            getView().setVisibility(4);
            return;
        }
        getView().setVisibility(0);
        this.gDm = eVar;
        this.gDK = eVar.gyX;
        this.userId = eVar.gyO.bnQ().getUserId();
        this.gDG.startLoad(eVar.gyO.bnQ().getPortrait(), 25, false, false);
        String name_show = eVar.gyO.bnQ().getName_show();
        if (!StringUtils.isNull(name_show)) {
            if (k.byteLength(name_show) > 16) {
                name_show = au.cutChineseAndEnglishWithSuffix(name_show, 16, StringHelper.STRING_MORE);
            }
            this.gDH.setText(name_show);
        }
        if (eVar.gyO.boj() != null) {
            this.gDI.setText(String.format(this.mTbPageContext.getPageActivity().getResources().getString(R.string.live_tab_audience_watch_label), au.eb(eVar.gyO.boj().audience_count)));
        }
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    public View getView() {
        return this.mRootView;
    }

    public void a(i iVar) {
        this.gCx = iVar;
    }
}
