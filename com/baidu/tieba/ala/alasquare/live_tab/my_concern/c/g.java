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
public class g extends com.baidu.tieba.card.a<com.baidu.tieba.ala.alasquare.live_tab.my_concern.data.a> {
    private TextView eoo;
    private TbImageView eop;
    private TbImageView eoq;
    private com.baidu.tieba.ala.alasquare.live_tab.my_concern.data.a eor;
    private View mRoot;
    private TextView mTitle;

    public g(TbPageContext tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        this.mRoot = getView();
        this.mTitle = (TextView) getView().findViewById(R.id.id_tab_live_sub_notification_title);
        this.eoo = (TextView) getView().findViewById(R.id.id_tab_live_sub_notification_close_go_to_open);
        this.eop = (TbImageView) getView().findViewById(R.id.id_tab_live_sub_notification_close_btn);
        this.eoq = (TbImageView) getView().findViewById(R.id.id_tab_live_sub_notification_bg_img);
        this.eoq.setAutoChangeStyle(true);
        this.eoq.setDefaultResource(17170445);
        this.eoq.setDefaultErrorResource(17170445);
        this.eoq.setDefaultBgResource(17170445);
        this.eop.setOnClickListener(this);
        this.eoo.setOnClickListener(this);
        onChangeSkinType(tbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        am.setBackgroundResource(this.mRoot, R.color.cp_bg_line_d);
        am.setViewTextColor(this.mTitle, (int) R.color.cp_cont_a);
        am.setViewTextColor(this.eoo, (int) R.color.cp_cont_a);
        am.setImageResource(this.eop, R.drawable.icon_tab_live_close_n);
        am.setBackgroundResource(this.eoo, R.drawable.tab_sub_notification_btn_bg_selecor);
        am.setImageResource(this.eoq, R.drawable.bg_tab_live_notification);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.tab_sub_notification_layout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.ala.alasquare.live_tab.my_concern.data.a aVar) {
        this.eor = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (buH() != null) {
            buH().a(view, this.eor);
        }
    }
}
