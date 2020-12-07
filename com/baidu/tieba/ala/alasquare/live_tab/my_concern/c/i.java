package com.baidu.tieba.ala.alasquare.live_tab.my_concern.c;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
/* loaded from: classes6.dex */
public class i extends com.baidu.tieba.card.b<com.baidu.tieba.ala.alasquare.live_tab.my_concern.data.b> {
    private TextView guh;
    private HeadImageView gui;
    private TextView guj;
    private com.baidu.tieba.ala.alasquare.live_tab.my_concern.data.b guk;
    private RelativeLayout gul;
    private TextView mName;
    private View mRoot;

    public i(TbPageContext tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        this.mRoot = getView();
        this.gul = (RelativeLayout) getView().findViewById(R.id.id_tab_live_sub_offline_item_wrapper);
        this.mName = (TextView) getView().findViewById(R.id.id_tab_live_sub_offline_item_name);
        this.guh = (TextView) getView().findViewById(R.id.id_tab_live_sub_offline_item_description);
        this.gui = (HeadImageView) getView().findViewById(R.id.id_tab_live_sub_offline_item_avatar);
        this.gui.setAutoChangeStyle(true);
        this.gui.setIsRound(true);
        this.gui.setDrawBorder(true);
        this.gui.setPlaceHolder(1);
        this.gui.setBorderWidth(com.baidu.adp.lib.util.l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds1));
        this.gui.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.guj = (TextView) getView().findViewById(R.id.id_tab_live_sub_offline_item_time);
        this.gul.setOnClickListener(this);
        onChangeSkinType(tbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        ap.setBackgroundResource(this.mRoot, R.color.CAM_X0201);
        ap.setViewTextColor(this.mName, R.color.CAM_X0105);
        ap.setViewTextColor(this.guh, R.color.CAM_X0108);
        ap.setViewTextColor(this.guj, R.color.CAM_X0108);
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.tab_sub_live_offline_item_view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    /* renamed from: b */
    public void a(com.baidu.tieba.ala.alasquare.live_tab.my_concern.data.b bVar) {
        if (bVar != null) {
            this.guk = bVar;
            String str = bVar.user_nickname;
            if (StringUtils.isNull(str)) {
                str = StringUtils.isNull(bVar.user_name) ? "" : bVar.user_name;
            }
            this.mName.setText(str);
            this.guh.setText(StringUtils.isNull(bVar.gtn) ? "" : bVar.gtn);
            this.gui.startLoad(bVar.portrait, 10, false);
            this.guj.setText(StringUtils.isNull(bVar.remark) ? "" : bVar.remark);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (crI() != null) {
            crI().a(view, this.guk);
        }
    }
}
