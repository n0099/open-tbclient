package com.baidu.tieba.ala.alasquare.live_tab.my_concern.view;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class e extends com.baidu.tieba.card.b<com.baidu.tieba.ala.alasquare.live_tab.my_concern.data.a> {
    private TextView gFe;
    private TbImageView gFf;
    private TbImageView gFg;
    private com.baidu.tieba.ala.alasquare.live_tab.my_concern.data.a gFh;
    private View mRoot;
    private TextView mTitle;

    public e(TbPageContext tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        this.mRoot = getView();
        this.mTitle = (TextView) getView().findViewById(R.id.id_tab_live_sub_notification_title);
        this.gFe = (TextView) getView().findViewById(R.id.id_tab_live_sub_notification_close_go_to_open);
        this.gFf = (TbImageView) getView().findViewById(R.id.id_tab_live_sub_notification_close_btn);
        this.gFg = (TbImageView) getView().findViewById(R.id.id_tab_live_sub_notification_bg_img);
        this.gFg.setAutoChangeStyle(true);
        this.gFg.setDefaultResource(17170445);
        this.gFg.setDefaultBgResource(17170445);
        this.gFf.setOnClickListener(this);
        this.gFe.setOnClickListener(this);
        onChangeSkinType(tbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        ap.setBackgroundResource(this.mRoot, R.color.CAM_X0201);
        ap.setViewTextColor(this.mTitle, R.color.CAM_X0101);
        ap.setViewTextColor(this.gFe, R.color.CAM_X0101);
        ap.setImageResource(this.gFf, R.drawable.icon_tab_live_close_n);
        ap.setBackgroundResource(this.gFe, R.drawable.tab_sub_notification_btn_bg_selecor);
        ap.setImageResource(this.gFg, R.drawable.bg_tab_live_notification);
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.tab_sub_notification_layout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.ala.alasquare.live_tab.my_concern.data.a aVar) {
        this.gFh = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (csi() != null) {
            csi().a(view, this.gFh);
        }
    }
}
