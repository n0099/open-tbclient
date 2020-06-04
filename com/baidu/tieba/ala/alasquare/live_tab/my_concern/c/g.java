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
    private TextView ffa;
    private TbImageView ffb;
    private TbImageView ffc;
    private com.baidu.tieba.ala.alasquare.live_tab.my_concern.data.a ffd;
    private View mRoot;
    private TextView mTitle;

    public g(TbPageContext tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        this.mRoot = getView();
        this.mTitle = (TextView) getView().findViewById(R.id.id_tab_live_sub_notification_title);
        this.ffa = (TextView) getView().findViewById(R.id.id_tab_live_sub_notification_close_go_to_open);
        this.ffb = (TbImageView) getView().findViewById(R.id.id_tab_live_sub_notification_close_btn);
        this.ffc = (TbImageView) getView().findViewById(R.id.id_tab_live_sub_notification_bg_img);
        this.ffc.setAutoChangeStyle(true);
        this.ffc.setDefaultResource(17170445);
        this.ffc.setDefaultErrorResource(17170445);
        this.ffc.setDefaultBgResource(17170445);
        this.ffb.setOnClickListener(this);
        this.ffa.setOnClickListener(this);
        onChangeSkinType(tbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        am.setBackgroundResource(this.mRoot, R.color.cp_bg_line_d);
        am.setViewTextColor(this.mTitle, (int) R.color.cp_cont_a);
        am.setViewTextColor(this.ffa, (int) R.color.cp_cont_a);
        am.setImageResource(this.ffb, R.drawable.icon_tab_live_close_n);
        am.setBackgroundResource(this.ffa, R.drawable.tab_sub_notification_btn_bg_selecor);
        am.setImageResource(this.ffc, R.drawable.bg_tab_live_notification);
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.tab_sub_notification_layout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.ala.alasquare.live_tab.my_concern.data.a aVar) {
        this.ffd = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (bKU() != null) {
            bKU().a(view, this.ffd);
        }
    }
}
