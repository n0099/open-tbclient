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
    private TextView ejb;
    private TbImageView ejc;
    private TbImageView ejd;
    private com.baidu.tieba.ala.alasquare.live_tab.my_concern.data.a eje;
    private View mRoot;
    private TextView mTitle;

    public g(TbPageContext tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        this.mRoot = getView();
        this.mTitle = (TextView) getView().findViewById(R.id.id_tab_live_sub_notification_title);
        this.ejb = (TextView) getView().findViewById(R.id.id_tab_live_sub_notification_close_go_to_open);
        this.ejc = (TbImageView) getView().findViewById(R.id.id_tab_live_sub_notification_close_btn);
        this.ejd = (TbImageView) getView().findViewById(R.id.id_tab_live_sub_notification_bg_img);
        this.ejd.setAutoChangeStyle(true);
        this.ejd.setDefaultResource(17170445);
        this.ejd.setDefaultErrorResource(17170445);
        this.ejd.setDefaultBgResource(17170445);
        this.ejc.setOnClickListener(this);
        this.ejb.setOnClickListener(this);
        onChangeSkinType(tbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        am.setBackgroundResource(this.mRoot, R.color.cp_bg_line_d);
        am.setViewTextColor(this.mTitle, (int) R.color.cp_cont_a);
        am.setViewTextColor(this.ejb, (int) R.color.cp_cont_a);
        am.setImageResource(this.ejc, R.drawable.icon_tab_live_close_n);
        am.setBackgroundResource(this.ejb, R.drawable.tab_sub_notification_btn_bg_selecor);
        am.setImageResource(this.ejd, R.drawable.bg_tab_live_notification);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.tab_sub_notification_layout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.ala.alasquare.live_tab.my_concern.data.a aVar) {
        this.eje = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (brY() != null) {
            brY().a(view, this.eje);
        }
    }
}
