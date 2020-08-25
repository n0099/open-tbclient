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
    private TextView fGN;
    private TbImageView fGO;
    private TbImageView fGP;
    private com.baidu.tieba.ala.alasquare.live_tab.my_concern.data.a fGQ;
    private View mRoot;
    private TextView mTitle;

    public g(TbPageContext tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        this.mRoot = getView();
        this.mTitle = (TextView) getView().findViewById(R.id.id_tab_live_sub_notification_title);
        this.fGN = (TextView) getView().findViewById(R.id.id_tab_live_sub_notification_close_go_to_open);
        this.fGO = (TbImageView) getView().findViewById(R.id.id_tab_live_sub_notification_close_btn);
        this.fGP = (TbImageView) getView().findViewById(R.id.id_tab_live_sub_notification_bg_img);
        this.fGP.setAutoChangeStyle(true);
        this.fGP.setDefaultResource(17170445);
        this.fGP.setDefaultErrorResource(17170445);
        this.fGP.setDefaultBgResource(17170445);
        this.fGO.setOnClickListener(this);
        this.fGN.setOnClickListener(this);
        onChangeSkinType(tbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        ap.setBackgroundResource(this.mRoot, R.color.cp_bg_line_d);
        ap.setViewTextColor(this.mTitle, (int) R.color.cp_cont_a);
        ap.setViewTextColor(this.fGN, (int) R.color.cp_cont_a);
        ap.setImageResource(this.fGO, R.drawable.icon_tab_live_close_n);
        ap.setBackgroundResource(this.fGN, R.drawable.tab_sub_notification_btn_bg_selecor);
        ap.setImageResource(this.fGP, R.drawable.bg_tab_live_notification);
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.tab_sub_notification_layout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.ala.alasquare.live_tab.my_concern.data.a aVar) {
        this.fGQ = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (cbz() != null) {
            cbz().a(view, this.fGQ);
        }
    }
}
