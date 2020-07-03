package com.baidu.tieba.ala.alasquare.live_tab.my_concern.c;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class g extends com.baidu.tieba.card.b<com.baidu.tieba.ala.alasquare.live_tab.my_concern.data.a> {
    private TextView fql;
    private TbImageView fqm;
    private TbImageView fqn;
    private com.baidu.tieba.ala.alasquare.live_tab.my_concern.data.a fqo;
    private View mRoot;
    private TextView mTitle;

    public g(TbPageContext tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        this.mRoot = getView();
        this.mTitle = (TextView) getView().findViewById(R.id.id_tab_live_sub_notification_title);
        this.fql = (TextView) getView().findViewById(R.id.id_tab_live_sub_notification_close_go_to_open);
        this.fqm = (TbImageView) getView().findViewById(R.id.id_tab_live_sub_notification_close_btn);
        this.fqn = (TbImageView) getView().findViewById(R.id.id_tab_live_sub_notification_bg_img);
        this.fqn.setAutoChangeStyle(true);
        this.fqn.setDefaultResource(17170445);
        this.fqn.setDefaultErrorResource(17170445);
        this.fqn.setDefaultBgResource(17170445);
        this.fqm.setOnClickListener(this);
        this.fql.setOnClickListener(this);
        onChangeSkinType(tbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        an.setBackgroundResource(this.mRoot, R.color.cp_bg_line_d);
        an.setViewTextColor(this.mTitle, (int) R.color.cp_cont_a);
        an.setViewTextColor(this.fql, (int) R.color.cp_cont_a);
        an.setImageResource(this.fqm, R.drawable.icon_tab_live_close_n);
        an.setBackgroundResource(this.fql, R.drawable.tab_sub_notification_btn_bg_selecor);
        an.setImageResource(this.fqn, R.drawable.bg_tab_live_notification);
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.tab_sub_notification_layout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.ala.alasquare.live_tab.my_concern.data.a aVar) {
        this.fqo = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (bOc() != null) {
            bOc().a(view, this.fqo);
        }
    }
}
