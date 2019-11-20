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
/* loaded from: classes6.dex */
public class k {
    private com.baidu.tieba.ala.alasquare.a.b dxQ;
    private o dxa;
    private HeadImageView dyk;
    private TextView dyl;
    private TextView dym;
    private LinearLayout dyn;
    private boolean dyo = false;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.k.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                if (k.this.dxQ != null && k.this.dxQ.dur != null && view == k.this.mRootView && k.this.dxa != null) {
                    k.this.dxa.a(k.this.dxQ);
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
        this.dyn = (LinearLayout) this.mRootView.findViewById(R.id.tab_sub_wrapper);
        this.dyk = (HeadImageView) this.mRootView.findViewById(R.id.iv_anchor_avatar);
        this.dyl = (TextView) this.mRootView.findViewById(R.id.tv_anchor_name);
        this.dym = (TextView) this.mRootView.findViewById(R.id.tv_live_aud_num);
        this.mRootView.setOnClickListener(this.mOnClickListener);
        this.dyk.setBorderWidth(com.baidu.adp.lib.util.l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds1));
        this.dyk.setIsRound(true);
        this.dyk.setDefaultResource(R.drawable.icon_default_avatar100_bg);
        this.dyk.setAutoChangeStyle(true);
        this.dyk.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.dyn.setLayoutParams(new LinearLayout.LayoutParams((com.baidu.adp.lib.util.l.getEquipmentWidth(this.mTbPageContext.getPageActivity()) - (this.mTbPageContext.getPageActivity().getResources().getDimensionPixelSize(R.dimen.tbds44) * 2)) / 3, this.mTbPageContext.getPageActivity().getResources().getDimensionPixelSize(R.dimen.tbds366)));
        onChangeSkinType(tbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        am.setViewTextColor(this.dyl, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.dym, (int) R.color.cp_cont_d);
        if (i == 1) {
            this.dyk.setBorderColor(this.mTbPageContext.getResources().getColor(R.color.cp_btn_c_1));
        } else {
            this.dyk.setBorderColor(this.mTbPageContext.getResources().getColor(R.color.cp_btn_c));
        }
        Drawable drawable = am.getDrawable(this.mTbPageContext.getResources(), (int) R.drawable.tab_icon_living_seeding);
        drawable.setBounds(0, 0, this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds18), this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds18));
        this.dym.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
        this.dym.setCompoundDrawablePadding(this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds8));
    }

    public void b(com.baidu.tieba.ala.alasquare.a.b bVar) {
        if (bVar == null || bVar.dur == null || bVar.dur.aiE() == null) {
            getView().setVisibility(4);
            return;
        }
        getView().setVisibility(0);
        this.dxQ = bVar;
        this.dyo = bVar.dut;
        this.userId = bVar.dur.aiE().getUserId();
        this.dyk.startLoad(bVar.dur.aiE().getPortrait(), 25, false, false);
        String name_show = bVar.dur.aiE().getName_show();
        if (!StringUtils.isNull(name_show)) {
            if (com.baidu.adp.lib.util.k.byteLength(name_show) > 16) {
                name_show = aq.cutChineseAndEnglishWithSuffix(name_show, 16, StringHelper.STRING_MORE);
            }
            this.dyl.setText(name_show);
        }
        if (bVar.dur.aiX() != null) {
            this.dym.setText(String.format(this.mTbPageContext.getPageActivity().getResources().getString(R.string.live_tab_audience_watch_label), aq.aS(bVar.dur.aiX().audience_count)));
        }
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    public View getView() {
        return this.mRootView;
    }

    public void a(o oVar) {
        this.dxa = oVar;
    }
}
