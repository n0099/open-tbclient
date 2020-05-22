package com.baidu.tieba.ala.alasquare.live_tab.my_concern.c;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class i extends com.baidu.tieba.card.b<com.baidu.tieba.ala.alasquare.live_tab.my_concern.data.b> {
    private TextView feU;
    private HeadImageView feV;
    private TextView feW;
    private com.baidu.tieba.ala.alasquare.live_tab.my_concern.data.b feX;
    private RelativeLayout feY;
    private TextView mName;
    private View mRoot;

    public i(TbPageContext tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        this.mRoot = getView();
        this.feY = (RelativeLayout) getView().findViewById(R.id.id_tab_live_sub_offline_item_wrapper);
        this.mName = (TextView) getView().findViewById(R.id.id_tab_live_sub_offline_item_name);
        this.feU = (TextView) getView().findViewById(R.id.id_tab_live_sub_offline_item_description);
        this.feV = (HeadImageView) getView().findViewById(R.id.id_tab_live_sub_offline_item_avatar);
        this.feV.setAutoChangeStyle(true);
        this.feV.setIsRound(true);
        this.feV.setDrawBorder(true);
        this.feV.setDefaultResource(R.drawable.icon_default_avatar100_bg);
        this.feV.setDefaultBgResource(17170445);
        this.feV.setBorderWidth(com.baidu.adp.lib.util.l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds1));
        this.feV.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.feW = (TextView) getView().findViewById(R.id.id_tab_live_sub_offline_item_time);
        this.feY.setOnClickListener(this);
        onChangeSkinType(tbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        am.setBackgroundResource(this.mRoot, R.color.cp_bg_line_d);
        am.setViewTextColor(this.mName, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.feU, (int) R.color.cp_cont_c);
        am.setViewTextColor(this.feW, (int) R.color.cp_cont_c);
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
            this.feX = bVar;
            String str = bVar.user_nickname;
            if (StringUtils.isNull(str)) {
                str = StringUtils.isNull(bVar.user_name) ? "" : bVar.user_name;
            }
            this.mName.setText(str);
            this.feU.setText(StringUtils.isNull(bVar.fdY) ? "" : bVar.fdY);
            this.feV.startLoad(bVar.portrait, 10, false);
            this.feW.setText(StringUtils.isNull(bVar.remark) ? "" : bVar.remark);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (bKS() != null) {
            bKS().a(view, this.feX);
        }
    }
}
