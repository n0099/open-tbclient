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
    private TextView gmm;
    private TbImageView gmn;
    private TbImageView gmo;
    private com.baidu.tieba.ala.alasquare.live_tab.my_concern.data.a gmp;
    private View mRoot;
    private TextView mTitle;

    public g(TbPageContext tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        this.mRoot = getView();
        this.mTitle = (TextView) getView().findViewById(R.id.id_tab_live_sub_notification_title);
        this.gmm = (TextView) getView().findViewById(R.id.id_tab_live_sub_notification_close_go_to_open);
        this.gmn = (TbImageView) getView().findViewById(R.id.id_tab_live_sub_notification_close_btn);
        this.gmo = (TbImageView) getView().findViewById(R.id.id_tab_live_sub_notification_bg_img);
        this.gmo.setAutoChangeStyle(true);
        this.gmo.setDefaultResource(17170445);
        this.gmo.setDefaultErrorResource(17170445);
        this.gmo.setDefaultBgResource(17170445);
        this.gmn.setOnClickListener(this);
        this.gmm.setOnClickListener(this);
        onChangeSkinType(tbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        ap.setBackgroundResource(this.mRoot, R.color.cp_bg_line_d);
        ap.setViewTextColor(this.mTitle, (int) R.color.cp_cont_a);
        ap.setViewTextColor(this.gmm, (int) R.color.cp_cont_a);
        ap.setImageResource(this.gmn, R.drawable.icon_tab_live_close_n);
        ap.setBackgroundResource(this.gmm, R.drawable.tab_sub_notification_btn_bg_selecor);
        ap.setImageResource(this.gmo, R.drawable.bg_tab_live_notification);
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.tab_sub_notification_layout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.ala.alasquare.live_tab.my_concern.data.a aVar) {
        this.gmp = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (cnT() != null) {
            cnT().a(view, this.gmp);
        }
    }
}
