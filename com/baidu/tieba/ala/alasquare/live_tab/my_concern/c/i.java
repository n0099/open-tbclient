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
    private TextView fGS;
    private HeadImageView fGT;
    private TextView fGU;
    private com.baidu.tieba.ala.alasquare.live_tab.my_concern.data.b fGV;
    private RelativeLayout fGW;
    private TextView mName;
    private View mRoot;

    public i(TbPageContext tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        this.mRoot = getView();
        this.fGW = (RelativeLayout) getView().findViewById(R.id.id_tab_live_sub_offline_item_wrapper);
        this.mName = (TextView) getView().findViewById(R.id.id_tab_live_sub_offline_item_name);
        this.fGS = (TextView) getView().findViewById(R.id.id_tab_live_sub_offline_item_description);
        this.fGT = (HeadImageView) getView().findViewById(R.id.id_tab_live_sub_offline_item_avatar);
        this.fGT.setAutoChangeStyle(true);
        this.fGT.setIsRound(true);
        this.fGT.setDrawBorder(true);
        this.fGT.setDefaultResource(R.drawable.icon_default_avatar100_bg);
        this.fGT.setDefaultBgResource(17170445);
        this.fGT.setBorderWidth(com.baidu.adp.lib.util.l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds1));
        this.fGT.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.fGU = (TextView) getView().findViewById(R.id.id_tab_live_sub_offline_item_time);
        this.fGW.setOnClickListener(this);
        onChangeSkinType(tbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        ap.setBackgroundResource(this.mRoot, R.color.cp_bg_line_d);
        ap.setViewTextColor(this.mName, (int) R.color.cp_cont_b);
        ap.setViewTextColor(this.fGS, (int) R.color.cp_cont_c);
        ap.setViewTextColor(this.fGU, (int) R.color.cp_cont_c);
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
            this.fGV = bVar;
            String str = bVar.user_nickname;
            if (StringUtils.isNull(str)) {
                str = StringUtils.isNull(bVar.user_name) ? "" : bVar.user_name;
            }
            this.mName.setText(str);
            this.fGS.setText(StringUtils.isNull(bVar.fFX) ? "" : bVar.fFX);
            this.fGT.startLoad(bVar.portrait, 10, false);
            this.fGU.setText(StringUtils.isNull(bVar.remark) ? "" : bVar.remark);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (cbz() != null) {
            cbz().a(view, this.fGV);
        }
    }
}
