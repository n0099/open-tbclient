package com.baidu.tieba.ala.alasquare.live_tab.my_concern.view;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class e extends com.baidu.tieba.card.b<com.baidu.tieba.ala.alasquare.live_tab.my_concern.data.a> {
    private com.baidu.tieba.ala.alasquare.live_tab.my_concern.data.a gAA;
    private TextView gAx;
    private TbImageView gAy;
    private TbImageView gAz;
    private View mRoot;
    private TextView mTitle;

    public e(TbPageContext tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        this.mRoot = getView();
        this.mTitle = (TextView) getView().findViewById(R.id.id_tab_live_sub_notification_title);
        this.gAx = (TextView) getView().findViewById(R.id.id_tab_live_sub_notification_close_go_to_open);
        this.gAy = (TbImageView) getView().findViewById(R.id.id_tab_live_sub_notification_close_btn);
        this.gAz = (TbImageView) getView().findViewById(R.id.id_tab_live_sub_notification_bg_img);
        this.gAz.setAutoChangeStyle(true);
        this.gAz.setDefaultResource(17170445);
        this.gAz.setDefaultBgResource(17170445);
        this.gAy.setOnClickListener(this);
        this.gAx.setOnClickListener(this);
        onChangeSkinType(tbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        ao.setBackgroundResource(this.mRoot, R.color.CAM_X0201);
        ao.setViewTextColor(this.mTitle, R.color.CAM_X0101);
        ao.setViewTextColor(this.gAx, R.color.CAM_X0101);
        ao.setImageResource(this.gAy, R.drawable.icon_tab_live_close_n);
        ao.setBackgroundResource(this.gAx, R.drawable.tab_sub_notification_btn_bg_selecor);
        ao.setImageResource(this.gAz, R.drawable.bg_tab_live_notification);
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.tab_sub_notification_layout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.ala.alasquare.live_tab.my_concern.data.a aVar) {
        this.gAA = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (cqL() != null) {
            cqL().a(view, this.gAA);
        }
    }
}
