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
    private TextView fWu;
    private TbImageView fWv;
    private TbImageView fWw;
    private com.baidu.tieba.ala.alasquare.live_tab.my_concern.data.a fWx;
    private View mRoot;
    private TextView mTitle;

    public g(TbPageContext tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        this.mRoot = getView();
        this.mTitle = (TextView) getView().findViewById(R.id.id_tab_live_sub_notification_title);
        this.fWu = (TextView) getView().findViewById(R.id.id_tab_live_sub_notification_close_go_to_open);
        this.fWv = (TbImageView) getView().findViewById(R.id.id_tab_live_sub_notification_close_btn);
        this.fWw = (TbImageView) getView().findViewById(R.id.id_tab_live_sub_notification_bg_img);
        this.fWw.setAutoChangeStyle(true);
        this.fWw.setDefaultResource(17170445);
        this.fWw.setDefaultErrorResource(17170445);
        this.fWw.setDefaultBgResource(17170445);
        this.fWv.setOnClickListener(this);
        this.fWu.setOnClickListener(this);
        onChangeSkinType(tbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        ap.setBackgroundResource(this.mRoot, R.color.cp_bg_line_d);
        ap.setViewTextColor(this.mTitle, R.color.cp_cont_a);
        ap.setViewTextColor(this.fWu, R.color.cp_cont_a);
        ap.setImageResource(this.fWv, R.drawable.icon_tab_live_close_n);
        ap.setBackgroundResource(this.fWu, R.drawable.tab_sub_notification_btn_bg_selecor);
        ap.setImageResource(this.fWw, R.drawable.bg_tab_live_notification);
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.tab_sub_notification_layout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.ala.alasquare.live_tab.my_concern.data.a aVar) {
        this.fWx = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (cil() != null) {
            cil().a(view, this.fWx);
        }
    }
}
