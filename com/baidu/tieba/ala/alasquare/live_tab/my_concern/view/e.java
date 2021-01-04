package com.baidu.tieba.ala.alasquare.live_tab.my_concern.view;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes10.dex */
public class e extends com.baidu.tieba.card.b<com.baidu.tieba.ala.alasquare.live_tab.my_concern.data.a> {
    private TextView gFd;
    private TbImageView gFe;
    private TbImageView gFf;
    private com.baidu.tieba.ala.alasquare.live_tab.my_concern.data.a gFg;
    private View mRoot;
    private TextView mTitle;

    public e(TbPageContext tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        this.mRoot = getView();
        this.mTitle = (TextView) getView().findViewById(R.id.id_tab_live_sub_notification_title);
        this.gFd = (TextView) getView().findViewById(R.id.id_tab_live_sub_notification_close_go_to_open);
        this.gFe = (TbImageView) getView().findViewById(R.id.id_tab_live_sub_notification_close_btn);
        this.gFf = (TbImageView) getView().findViewById(R.id.id_tab_live_sub_notification_bg_img);
        this.gFf.setAutoChangeStyle(true);
        this.gFf.setDefaultResource(17170445);
        this.gFf.setDefaultBgResource(17170445);
        this.gFe.setOnClickListener(this);
        this.gFd.setOnClickListener(this);
        onChangeSkinType(tbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        ao.setBackgroundResource(this.mRoot, R.color.CAM_X0201);
        ao.setViewTextColor(this.mTitle, R.color.CAM_X0101);
        ao.setViewTextColor(this.gFd, R.color.CAM_X0101);
        ao.setImageResource(this.gFe, R.drawable.icon_tab_live_close_n);
        ao.setBackgroundResource(this.gFd, R.drawable.tab_sub_notification_btn_bg_selecor);
        ao.setImageResource(this.gFf, R.drawable.bg_tab_live_notification);
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.tab_sub_notification_layout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.ala.alasquare.live_tab.my_concern.data.a aVar) {
        this.gFg = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (cuC() != null) {
            cuC().a(view, this.gFg);
        }
    }
}
