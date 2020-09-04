package com.baidu.tieba.ala.alasquare.live_tab.my_concern.c;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class g extends com.baidu.tieba.card.b<com.baidu.tieba.ala.alasquare.live_tab.my_concern.data.a> {
    private TextView fGR;
    private TbImageView fGS;
    private TbImageView fGT;
    private com.baidu.tieba.ala.alasquare.live_tab.my_concern.data.a fGU;
    private View mRoot;
    private TextView mTitle;

    public g(TbPageContext tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        this.mRoot = getView();
        this.mTitle = (TextView) getView().findViewById(R.id.id_tab_live_sub_notification_title);
        this.fGR = (TextView) getView().findViewById(R.id.id_tab_live_sub_notification_close_go_to_open);
        this.fGS = (TbImageView) getView().findViewById(R.id.id_tab_live_sub_notification_close_btn);
        this.fGT = (TbImageView) getView().findViewById(R.id.id_tab_live_sub_notification_bg_img);
        this.fGT.setAutoChangeStyle(true);
        this.fGT.setDefaultResource(17170445);
        this.fGT.setDefaultErrorResource(17170445);
        this.fGT.setDefaultBgResource(17170445);
        this.fGS.setOnClickListener(this);
        this.fGR.setOnClickListener(this);
        onChangeSkinType(tbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        ap.setBackgroundResource(this.mRoot, R.color.cp_bg_line_d);
        ap.setViewTextColor(this.mTitle, (int) R.color.cp_cont_a);
        ap.setViewTextColor(this.fGR, (int) R.color.cp_cont_a);
        ap.setImageResource(this.fGS, R.drawable.icon_tab_live_close_n);
        ap.setBackgroundResource(this.fGR, R.drawable.tab_sub_notification_btn_bg_selecor);
        ap.setImageResource(this.fGT, R.drawable.bg_tab_live_notification);
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.tab_sub_notification_layout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.ala.alasquare.live_tab.my_concern.data.a aVar) {
        this.fGU = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (cbA() != null) {
            cbA().a(view, this.fGU);
        }
    }
}
