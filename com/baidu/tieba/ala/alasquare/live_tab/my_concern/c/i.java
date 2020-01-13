package com.baidu.tieba.ala.alasquare.live_tab.my_concern.c;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class i extends com.baidu.tieba.card.a<com.baidu.tieba.ala.alasquare.live_tab.my_concern.data.b> {
    private TextView ejU;
    private HeadImageView ejV;
    private TextView ejW;
    private com.baidu.tieba.ala.alasquare.live_tab.my_concern.data.b ejX;
    private RelativeLayout ejY;
    private TextView mName;
    private View mRoot;

    public i(TbPageContext tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        this.mRoot = getView();
        this.ejY = (RelativeLayout) getView().findViewById(R.id.id_tab_live_sub_offline_item_wrapper);
        this.mName = (TextView) getView().findViewById(R.id.id_tab_live_sub_offline_item_name);
        this.ejU = (TextView) getView().findViewById(R.id.id_tab_live_sub_offline_item_description);
        this.ejV = (HeadImageView) getView().findViewById(R.id.id_tab_live_sub_offline_item_avatar);
        this.ejV.setAutoChangeStyle(true);
        this.ejV.setIsRound(true);
        this.ejV.setDrawBorder(true);
        this.ejV.setDefaultResource(R.drawable.icon_default_avatar100_bg);
        this.ejV.setDefaultBgResource(17170445);
        this.ejV.setBorderWidth(com.baidu.adp.lib.util.l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds1));
        this.ejV.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.ejW = (TextView) getView().findViewById(R.id.id_tab_live_sub_offline_item_time);
        this.ejY.setOnClickListener(this);
        onChangeSkinType(tbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        am.setBackgroundResource(this.mRoot, R.color.cp_bg_line_d);
        am.setViewTextColor(this.mName, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.ejU, (int) R.color.cp_cont_c);
        am.setViewTextColor(this.ejW, (int) R.color.cp_cont_c);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.tab_sub_live_offline_item_view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    /* renamed from: b */
    public void a(com.baidu.tieba.ala.alasquare.live_tab.my_concern.data.b bVar) {
        if (bVar != null) {
            this.ejX = bVar;
            String str = bVar.user_nickname;
            if (StringUtils.isNull(str)) {
                str = StringUtils.isNull(bVar.user_name) ? "" : bVar.user_name;
            }
            this.mName.setText(str);
            this.ejU.setText(StringUtils.isNull(bVar.eiY) ? "" : bVar.eiY);
            this.ejV.startLoad(bVar.portrait, 10, false);
            this.ejW.setText(StringUtils.isNull(bVar.remark) ? "" : bVar.remark);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (bta() != null) {
            bta().a(view, this.ejX);
        }
    }
}
