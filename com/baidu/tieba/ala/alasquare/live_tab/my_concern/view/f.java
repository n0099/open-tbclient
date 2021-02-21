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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
/* loaded from: classes10.dex */
public class f extends com.baidu.tieba.card.b<com.baidu.tieba.ala.alasquare.live_tab.my_concern.data.b> {
    private TextView gDA;
    private HeadImageView gDB;
    private TextView gDC;
    private com.baidu.tieba.ala.alasquare.live_tab.my_concern.data.b gDD;
    private RelativeLayout gDE;
    private TextView mName;
    private View mRoot;

    public f(TbPageContext tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        this.mRoot = getView();
        this.gDE = (RelativeLayout) getView().findViewById(R.id.id_tab_live_sub_offline_item_wrapper);
        this.mName = (TextView) getView().findViewById(R.id.id_tab_live_sub_offline_item_name);
        this.gDA = (TextView) getView().findViewById(R.id.id_tab_live_sub_offline_item_description);
        this.gDB = (HeadImageView) getView().findViewById(R.id.id_tab_live_sub_offline_item_avatar);
        this.gDB.setAutoChangeStyle(true);
        this.gDB.setIsRound(true);
        this.gDB.setDrawBorder(true);
        this.gDB.setPlaceHolder(1);
        this.gDB.setBorderWidth(l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds1));
        this.gDB.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.gDC = (TextView) getView().findViewById(R.id.id_tab_live_sub_offline_item_time);
        this.gDE.setOnClickListener(this);
        onChangeSkinType(tbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        ap.setBackgroundResource(this.mRoot, R.color.CAM_X0201);
        ap.setViewTextColor(this.mName, R.color.CAM_X0105);
        ap.setViewTextColor(this.gDA, R.color.CAM_X0108);
        ap.setViewTextColor(this.gDC, R.color.CAM_X0108);
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
            this.gDD = bVar;
            String str = bVar.user_nickname;
            if (StringUtils.isNull(str)) {
                str = StringUtils.isNull(bVar.user_name) ? "" : bVar.user_name;
            }
            this.mName.setText(str);
            this.gDA.setText(StringUtils.isNull(bVar.gCF) ? "" : bVar.gCF);
            this.gDB.startLoad(bVar.portrait, 10, false);
            this.gDC.setText(StringUtils.isNull(bVar.remark) ? "" : bVar.remark);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (csc() != null) {
            csc().a(view, this.gDD);
        }
    }
}
