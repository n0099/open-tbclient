package com.baidu.tieba.ala.alasquare.live_tab.my_concern.view;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class f extends com.baidu.tieba.card.b<com.baidu.tieba.ala.alasquare.live_tab.my_concern.data.b> {
    private TextView gAC;
    private HeadImageView gAD;
    private TextView gAE;
    private com.baidu.tieba.ala.alasquare.live_tab.my_concern.data.b gAF;
    private RelativeLayout gAG;
    private TextView mName;
    private View mRoot;

    public f(TbPageContext tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        this.mRoot = getView();
        this.gAG = (RelativeLayout) getView().findViewById(R.id.id_tab_live_sub_offline_item_wrapper);
        this.mName = (TextView) getView().findViewById(R.id.id_tab_live_sub_offline_item_name);
        this.gAC = (TextView) getView().findViewById(R.id.id_tab_live_sub_offline_item_description);
        this.gAD = (HeadImageView) getView().findViewById(R.id.id_tab_live_sub_offline_item_avatar);
        this.gAD.setAutoChangeStyle(true);
        this.gAD.setIsRound(true);
        this.gAD.setDrawBorder(true);
        this.gAD.setPlaceHolder(1);
        this.gAD.setBorderWidth(l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds1));
        this.gAD.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.gAE = (TextView) getView().findViewById(R.id.id_tab_live_sub_offline_item_time);
        this.gAG.setOnClickListener(this);
        onChangeSkinType(tbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        ao.setBackgroundResource(this.mRoot, R.color.CAM_X0201);
        ao.setViewTextColor(this.mName, R.color.CAM_X0105);
        ao.setViewTextColor(this.gAC, R.color.CAM_X0108);
        ao.setViewTextColor(this.gAE, R.color.CAM_X0108);
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
            this.gAF = bVar;
            String str = bVar.user_nickname;
            if (StringUtils.isNull(str)) {
                str = StringUtils.isNull(bVar.user_name) ? "" : bVar.user_name;
            }
            this.mName.setText(str);
            this.gAC.setText(StringUtils.isNull(bVar.gzH) ? "" : bVar.gzH);
            this.gAD.startLoad(bVar.portrait, 10, false);
            this.gAE.setText(StringUtils.isNull(bVar.remark) ? "" : bVar.remark);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (cqL() != null) {
            cqL().a(view, this.gAF);
        }
    }
}
