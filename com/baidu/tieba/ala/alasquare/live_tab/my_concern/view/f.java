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
/* loaded from: classes10.dex */
public class f extends com.baidu.tieba.card.b<com.baidu.tieba.ala.alasquare.live_tab.my_concern.data.b> {
    private TextView gFi;
    private HeadImageView gFj;
    private TextView gFk;
    private com.baidu.tieba.ala.alasquare.live_tab.my_concern.data.b gFl;
    private RelativeLayout gFm;
    private TextView mName;
    private View mRoot;

    public f(TbPageContext tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        this.mRoot = getView();
        this.gFm = (RelativeLayout) getView().findViewById(R.id.id_tab_live_sub_offline_item_wrapper);
        this.mName = (TextView) getView().findViewById(R.id.id_tab_live_sub_offline_item_name);
        this.gFi = (TextView) getView().findViewById(R.id.id_tab_live_sub_offline_item_description);
        this.gFj = (HeadImageView) getView().findViewById(R.id.id_tab_live_sub_offline_item_avatar);
        this.gFj.setAutoChangeStyle(true);
        this.gFj.setIsRound(true);
        this.gFj.setDrawBorder(true);
        this.gFj.setPlaceHolder(1);
        this.gFj.setBorderWidth(l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds1));
        this.gFj.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.gFk = (TextView) getView().findViewById(R.id.id_tab_live_sub_offline_item_time);
        this.gFm.setOnClickListener(this);
        onChangeSkinType(tbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        ao.setBackgroundResource(this.mRoot, R.color.CAM_X0201);
        ao.setViewTextColor(this.mName, R.color.CAM_X0105);
        ao.setViewTextColor(this.gFi, R.color.CAM_X0108);
        ao.setViewTextColor(this.gFk, R.color.CAM_X0108);
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
            this.gFl = bVar;
            String str = bVar.user_nickname;
            if (StringUtils.isNull(str)) {
                str = StringUtils.isNull(bVar.user_name) ? "" : bVar.user_name;
            }
            this.mName.setText(str);
            this.gFi.setText(StringUtils.isNull(bVar.gEo) ? "" : bVar.gEo);
            this.gFj.startLoad(bVar.portrait, 10, false);
            this.gFk.setText(StringUtils.isNull(bVar.remark) ? "" : bVar.remark);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (cuD() != null) {
            cuD().a(view, this.gFl);
        }
    }
}
