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
    private TextView eSh;
    private TbImageView eSi;
    private TbImageView eSj;
    private com.baidu.tieba.ala.alasquare.live_tab.my_concern.data.a eSk;
    private View mRoot;
    private TextView mTitle;

    public g(TbPageContext tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        this.mRoot = getView();
        this.mTitle = (TextView) getView().findViewById(R.id.id_tab_live_sub_notification_title);
        this.eSh = (TextView) getView().findViewById(R.id.id_tab_live_sub_notification_close_go_to_open);
        this.eSi = (TbImageView) getView().findViewById(R.id.id_tab_live_sub_notification_close_btn);
        this.eSj = (TbImageView) getView().findViewById(R.id.id_tab_live_sub_notification_bg_img);
        this.eSj.setAutoChangeStyle(true);
        this.eSj.setDefaultResource(17170445);
        this.eSj.setDefaultErrorResource(17170445);
        this.eSj.setDefaultBgResource(17170445);
        this.eSi.setOnClickListener(this);
        this.eSh.setOnClickListener(this);
        onChangeSkinType(tbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        am.setBackgroundResource(this.mRoot, R.color.cp_bg_line_d);
        am.setViewTextColor(this.mTitle, (int) R.color.cp_cont_a);
        am.setViewTextColor(this.eSh, (int) R.color.cp_cont_a);
        am.setImageResource(this.eSi, R.drawable.icon_tab_live_close_n);
        am.setBackgroundResource(this.eSh, R.drawable.tab_sub_notification_btn_bg_selecor);
        am.setImageResource(this.eSj, R.drawable.bg_tab_live_notification);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.tab_sub_notification_layout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.ala.alasquare.live_tab.my_concern.data.a aVar) {
        this.eSk = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (bEx() != null) {
            bEx().a(view, this.eSk);
        }
    }
}
