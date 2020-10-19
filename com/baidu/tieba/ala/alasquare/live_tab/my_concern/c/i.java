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
    private HeadImageView fWA;
    private TextView fWB;
    private com.baidu.tieba.ala.alasquare.live_tab.my_concern.data.b fWC;
    private RelativeLayout fWD;
    private TextView fWz;
    private TextView mName;
    private View mRoot;

    public i(TbPageContext tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        this.mRoot = getView();
        this.fWD = (RelativeLayout) getView().findViewById(R.id.id_tab_live_sub_offline_item_wrapper);
        this.mName = (TextView) getView().findViewById(R.id.id_tab_live_sub_offline_item_name);
        this.fWz = (TextView) getView().findViewById(R.id.id_tab_live_sub_offline_item_description);
        this.fWA = (HeadImageView) getView().findViewById(R.id.id_tab_live_sub_offline_item_avatar);
        this.fWA.setAutoChangeStyle(true);
        this.fWA.setIsRound(true);
        this.fWA.setDrawBorder(true);
        this.fWA.setDefaultResource(R.drawable.icon_default_avatar100_bg);
        this.fWA.setDefaultBgResource(17170445);
        this.fWA.setBorderWidth(com.baidu.adp.lib.util.l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds1));
        this.fWA.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.fWB = (TextView) getView().findViewById(R.id.id_tab_live_sub_offline_item_time);
        this.fWD.setOnClickListener(this);
        onChangeSkinType(tbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        ap.setBackgroundResource(this.mRoot, R.color.cp_bg_line_d);
        ap.setViewTextColor(this.mName, R.color.cp_cont_b);
        ap.setViewTextColor(this.fWz, R.color.cp_cont_c);
        ap.setViewTextColor(this.fWB, R.color.cp_cont_c);
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
            this.fWC = bVar;
            String str = bVar.user_nickname;
            if (StringUtils.isNull(str)) {
                str = StringUtils.isNull(bVar.user_name) ? "" : bVar.user_name;
            }
            this.mName.setText(str);
            this.fWz.setText(StringUtils.isNull(bVar.fVE) ? "" : bVar.fVE);
            this.fWA.startLoad(bVar.portrait, 10, false);
            this.fWB.setText(StringUtils.isNull(bVar.remark) ? "" : bVar.remark);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (cil() != null) {
            cil().a(view, this.fWC);
        }
    }
}
