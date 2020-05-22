package com.baidu.tieba.ala.alasquare.live_tab.my_concern.c;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class g extends com.baidu.tieba.card.b<com.baidu.tieba.ala.alasquare.live_tab.my_concern.data.a> {
    private TextView feP;
    private TbImageView feQ;
    private TbImageView feR;
    private com.baidu.tieba.ala.alasquare.live_tab.my_concern.data.a feS;
    private View mRoot;
    private TextView mTitle;

    public g(TbPageContext tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        this.mRoot = getView();
        this.mTitle = (TextView) getView().findViewById(R.id.id_tab_live_sub_notification_title);
        this.feP = (TextView) getView().findViewById(R.id.id_tab_live_sub_notification_close_go_to_open);
        this.feQ = (TbImageView) getView().findViewById(R.id.id_tab_live_sub_notification_close_btn);
        this.feR = (TbImageView) getView().findViewById(R.id.id_tab_live_sub_notification_bg_img);
        this.feR.setAutoChangeStyle(true);
        this.feR.setDefaultResource(17170445);
        this.feR.setDefaultErrorResource(17170445);
        this.feR.setDefaultBgResource(17170445);
        this.feQ.setOnClickListener(this);
        this.feP.setOnClickListener(this);
        onChangeSkinType(tbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        am.setBackgroundResource(this.mRoot, R.color.cp_bg_line_d);
        am.setViewTextColor(this.mTitle, (int) R.color.cp_cont_a);
        am.setViewTextColor(this.feP, (int) R.color.cp_cont_a);
        am.setImageResource(this.feQ, R.drawable.icon_tab_live_close_n);
        am.setBackgroundResource(this.feP, R.drawable.tab_sub_notification_btn_bg_selecor);
        am.setImageResource(this.feR, R.drawable.bg_tab_live_notification);
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.tab_sub_notification_layout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.ala.alasquare.live_tab.my_concern.data.a aVar) {
        this.feS = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (bKS() != null) {
            bKS().a(view, this.feS);
        }
    }
}
