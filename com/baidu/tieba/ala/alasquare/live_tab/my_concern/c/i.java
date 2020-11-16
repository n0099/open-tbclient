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
    private TextView glY;
    private HeadImageView glZ;
    private TextView gma;
    private com.baidu.tieba.ala.alasquare.live_tab.my_concern.data.b gmb;
    private RelativeLayout gmc;
    private TextView mName;
    private View mRoot;

    public i(TbPageContext tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        this.mRoot = getView();
        this.gmc = (RelativeLayout) getView().findViewById(R.id.id_tab_live_sub_offline_item_wrapper);
        this.mName = (TextView) getView().findViewById(R.id.id_tab_live_sub_offline_item_name);
        this.glY = (TextView) getView().findViewById(R.id.id_tab_live_sub_offline_item_description);
        this.glZ = (HeadImageView) getView().findViewById(R.id.id_tab_live_sub_offline_item_avatar);
        this.glZ.setAutoChangeStyle(true);
        this.glZ.setIsRound(true);
        this.glZ.setDrawBorder(true);
        this.glZ.setPlaceHolder(1);
        this.glZ.setBorderWidth(com.baidu.adp.lib.util.l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds1));
        this.glZ.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.gma = (TextView) getView().findViewById(R.id.id_tab_live_sub_offline_item_time);
        this.gmc.setOnClickListener(this);
        onChangeSkinType(tbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        ap.setBackgroundResource(this.mRoot, R.color.CAM_X0201);
        ap.setViewTextColor(this.mName, R.color.CAM_X0105);
        ap.setViewTextColor(this.glY, R.color.CAM_X0108);
        ap.setViewTextColor(this.gma, R.color.CAM_X0108);
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
            this.gmb = bVar;
            String str = bVar.user_nickname;
            if (StringUtils.isNull(str)) {
                str = StringUtils.isNull(bVar.user_name) ? "" : bVar.user_name;
            }
            this.mName.setText(str);
            this.glY.setText(StringUtils.isNull(bVar.gle) ? "" : bVar.gle);
            this.glZ.startLoad(bVar.portrait, 10, false);
            this.gma.setText(StringUtils.isNull(bVar.remark) ? "" : bVar.remark);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (cnv() != null) {
            cnv().a(view, this.gmb);
        }
    }
}
