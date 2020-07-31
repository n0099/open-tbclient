package com.baidu.tieba.ala.alasquare.live_tab.my_concern.c;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class i extends com.baidu.tieba.card.b<com.baidu.tieba.ala.alasquare.live_tab.my_concern.data.b> {
    private TextView fvA;
    private HeadImageView fvB;
    private TextView fvC;
    private com.baidu.tieba.ala.alasquare.live_tab.my_concern.data.b fvD;
    private RelativeLayout fvE;
    private TextView mName;
    private View mRoot;

    public i(TbPageContext tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        this.mRoot = getView();
        this.fvE = (RelativeLayout) getView().findViewById(R.id.id_tab_live_sub_offline_item_wrapper);
        this.mName = (TextView) getView().findViewById(R.id.id_tab_live_sub_offline_item_name);
        this.fvA = (TextView) getView().findViewById(R.id.id_tab_live_sub_offline_item_description);
        this.fvB = (HeadImageView) getView().findViewById(R.id.id_tab_live_sub_offline_item_avatar);
        this.fvB.setAutoChangeStyle(true);
        this.fvB.setIsRound(true);
        this.fvB.setDrawBorder(true);
        this.fvB.setDefaultResource(R.drawable.icon_default_avatar100_bg);
        this.fvB.setDefaultBgResource(17170445);
        this.fvB.setBorderWidth(com.baidu.adp.lib.util.l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds1));
        this.fvB.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.fvC = (TextView) getView().findViewById(R.id.id_tab_live_sub_offline_item_time);
        this.fvE.setOnClickListener(this);
        onChangeSkinType(tbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        ao.setBackgroundResource(this.mRoot, R.color.cp_bg_line_d);
        ao.setViewTextColor(this.mName, R.color.cp_cont_b);
        ao.setViewTextColor(this.fvA, R.color.cp_cont_c);
        ao.setViewTextColor(this.fvC, R.color.cp_cont_c);
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.tab_sub_live_offline_item_view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    /* renamed from: b */
    public void a(com.baidu.tieba.ala.alasquare.live_tab.my_concern.data.b bVar) {
        if (bVar != null) {
            this.fvD = bVar;
            String str = bVar.user_nickname;
            if (StringUtils.isNull(str)) {
                str = StringUtils.isNull(bVar.user_name) ? "" : bVar.user_name;
            }
            this.mName.setText(str);
            this.fvA.setText(StringUtils.isNull(bVar.fuE) ? "" : bVar.fuE);
            this.fvB.startLoad(bVar.portrait, 10, false);
            this.fvC.setText(StringUtils.isNull(bVar.remark) ? "" : bVar.remark);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (bRn() != null) {
            bRn().a(view, this.fvD);
        }
    }
}
