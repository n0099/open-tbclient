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
/* loaded from: classes4.dex */
public class i extends com.baidu.tieba.card.b<com.baidu.tieba.ala.alasquare.live_tab.my_concern.data.b> {
    private TextView fGW;
    private HeadImageView fGX;
    private TextView fGY;
    private com.baidu.tieba.ala.alasquare.live_tab.my_concern.data.b fGZ;
    private RelativeLayout fHa;
    private TextView mName;
    private View mRoot;

    public i(TbPageContext tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        this.mRoot = getView();
        this.fHa = (RelativeLayout) getView().findViewById(R.id.id_tab_live_sub_offline_item_wrapper);
        this.mName = (TextView) getView().findViewById(R.id.id_tab_live_sub_offline_item_name);
        this.fGW = (TextView) getView().findViewById(R.id.id_tab_live_sub_offline_item_description);
        this.fGX = (HeadImageView) getView().findViewById(R.id.id_tab_live_sub_offline_item_avatar);
        this.fGX.setAutoChangeStyle(true);
        this.fGX.setIsRound(true);
        this.fGX.setDrawBorder(true);
        this.fGX.setDefaultResource(R.drawable.icon_default_avatar100_bg);
        this.fGX.setDefaultBgResource(17170445);
        this.fGX.setBorderWidth(com.baidu.adp.lib.util.l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds1));
        this.fGX.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.fGY = (TextView) getView().findViewById(R.id.id_tab_live_sub_offline_item_time);
        this.fHa.setOnClickListener(this);
        onChangeSkinType(tbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        ap.setBackgroundResource(this.mRoot, R.color.cp_bg_line_d);
        ap.setViewTextColor(this.mName, (int) R.color.cp_cont_b);
        ap.setViewTextColor(this.fGW, (int) R.color.cp_cont_c);
        ap.setViewTextColor(this.fGY, (int) R.color.cp_cont_c);
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
            this.fGZ = bVar;
            String str = bVar.user_nickname;
            if (StringUtils.isNull(str)) {
                str = StringUtils.isNull(bVar.user_name) ? "" : bVar.user_name;
            }
            this.mName.setText(str);
            this.fGW.setText(StringUtils.isNull(bVar.fGb) ? "" : bVar.fGb);
            this.fGX.startLoad(bVar.portrait, 10, false);
            this.fGY.setText(StringUtils.isNull(bVar.remark) ? "" : bVar.remark);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (cbA() != null) {
            cbA().a(view, this.fGZ);
        }
    }
}
