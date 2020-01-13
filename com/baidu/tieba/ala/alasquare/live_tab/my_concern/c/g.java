package com.baidu.tieba.ala.alasquare.live_tab.my_concern.c;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class g extends com.baidu.tieba.card.a<com.baidu.tieba.ala.alasquare.live_tab.my_concern.data.a> {
    private TextView ejP;
    private TbImageView ejQ;
    private TbImageView ejR;
    private com.baidu.tieba.ala.alasquare.live_tab.my_concern.data.a ejS;
    private View mRoot;
    private TextView mTitle;

    public g(TbPageContext tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        this.mRoot = getView();
        this.mTitle = (TextView) getView().findViewById(R.id.id_tab_live_sub_notification_title);
        this.ejP = (TextView) getView().findViewById(R.id.id_tab_live_sub_notification_close_go_to_open);
        this.ejQ = (TbImageView) getView().findViewById(R.id.id_tab_live_sub_notification_close_btn);
        this.ejR = (TbImageView) getView().findViewById(R.id.id_tab_live_sub_notification_bg_img);
        this.ejR.setAutoChangeStyle(true);
        this.ejR.setDefaultResource(17170445);
        this.ejR.setDefaultErrorResource(17170445);
        this.ejR.setDefaultBgResource(17170445);
        this.ejQ.setOnClickListener(this);
        this.ejP.setOnClickListener(this);
        onChangeSkinType(tbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        am.setBackgroundResource(this.mRoot, R.color.cp_bg_line_d);
        am.setViewTextColor(this.mTitle, (int) R.color.cp_cont_a);
        am.setViewTextColor(this.ejP, (int) R.color.cp_cont_a);
        am.setImageResource(this.ejQ, R.drawable.icon_tab_live_close_n);
        am.setBackgroundResource(this.ejP, R.drawable.tab_sub_notification_btn_bg_selecor);
        am.setImageResource(this.ejR, R.drawable.bg_tab_live_notification);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.tab_sub_notification_layout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.ala.alasquare.live_tab.my_concern.data.a aVar) {
        this.ejS = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (bta() != null) {
            bta().a(view, this.ejS);
        }
    }
}
