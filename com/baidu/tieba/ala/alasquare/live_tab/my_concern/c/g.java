package com.baidu.tieba.ala.alasquare.live_tab.my_concern.c;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class g extends com.baidu.tieba.card.b<com.baidu.tieba.ala.alasquare.live_tab.my_concern.data.a> {
    private TextView fvv;
    private TbImageView fvw;
    private TbImageView fvx;
    private com.baidu.tieba.ala.alasquare.live_tab.my_concern.data.a fvy;
    private View mRoot;
    private TextView mTitle;

    public g(TbPageContext tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        this.mRoot = getView();
        this.mTitle = (TextView) getView().findViewById(R.id.id_tab_live_sub_notification_title);
        this.fvv = (TextView) getView().findViewById(R.id.id_tab_live_sub_notification_close_go_to_open);
        this.fvw = (TbImageView) getView().findViewById(R.id.id_tab_live_sub_notification_close_btn);
        this.fvx = (TbImageView) getView().findViewById(R.id.id_tab_live_sub_notification_bg_img);
        this.fvx.setAutoChangeStyle(true);
        this.fvx.setDefaultResource(17170445);
        this.fvx.setDefaultErrorResource(17170445);
        this.fvx.setDefaultBgResource(17170445);
        this.fvw.setOnClickListener(this);
        this.fvv.setOnClickListener(this);
        onChangeSkinType(tbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        ao.setBackgroundResource(this.mRoot, R.color.cp_bg_line_d);
        ao.setViewTextColor(this.mTitle, R.color.cp_cont_a);
        ao.setViewTextColor(this.fvv, R.color.cp_cont_a);
        ao.setImageResource(this.fvw, R.drawable.icon_tab_live_close_n);
        ao.setBackgroundResource(this.fvv, R.drawable.tab_sub_notification_btn_bg_selecor);
        ao.setImageResource(this.fvx, R.drawable.bg_tab_live_notification);
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.tab_sub_notification_layout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.ala.alasquare.live_tab.my_concern.data.a aVar) {
        this.fvy = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (bRn() != null) {
            bRn().a(view, this.fvy);
        }
    }
}
