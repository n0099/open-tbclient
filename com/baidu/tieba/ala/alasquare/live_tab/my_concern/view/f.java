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
/* loaded from: classes9.dex */
public class f extends com.baidu.tieba.card.b<com.baidu.tieba.ala.alasquare.live_tab.my_concern.data.b> {
    private TextView gFj;
    private HeadImageView gFk;
    private TextView gFl;
    private com.baidu.tieba.ala.alasquare.live_tab.my_concern.data.b gFm;
    private RelativeLayout gFn;
    private TextView mName;
    private View mRoot;

    public f(TbPageContext tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        this.mRoot = getView();
        this.gFn = (RelativeLayout) getView().findViewById(R.id.id_tab_live_sub_offline_item_wrapper);
        this.mName = (TextView) getView().findViewById(R.id.id_tab_live_sub_offline_item_name);
        this.gFj = (TextView) getView().findViewById(R.id.id_tab_live_sub_offline_item_description);
        this.gFk = (HeadImageView) getView().findViewById(R.id.id_tab_live_sub_offline_item_avatar);
        this.gFk.setAutoChangeStyle(true);
        this.gFk.setIsRound(true);
        this.gFk.setDrawBorder(true);
        this.gFk.setPlaceHolder(1);
        this.gFk.setBorderWidth(l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds1));
        this.gFk.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.gFl = (TextView) getView().findViewById(R.id.id_tab_live_sub_offline_item_time);
        this.gFn.setOnClickListener(this);
        onChangeSkinType(tbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        ap.setBackgroundResource(this.mRoot, R.color.CAM_X0201);
        ap.setViewTextColor(this.mName, R.color.CAM_X0105);
        ap.setViewTextColor(this.gFj, R.color.CAM_X0108);
        ap.setViewTextColor(this.gFl, R.color.CAM_X0108);
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
            this.gFm = bVar;
            String str = bVar.user_nickname;
            if (StringUtils.isNull(str)) {
                str = StringUtils.isNull(bVar.user_name) ? "" : bVar.user_name;
            }
            this.mName.setText(str);
            this.gFj.setText(StringUtils.isNull(bVar.gEo) ? "" : bVar.gEo);
            this.gFk.startLoad(bVar.portrait, 10, false);
            this.gFl.setText(StringUtils.isNull(bVar.remark) ? "" : bVar.remark);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (csi() != null) {
            csi().a(view, this.gFm);
        }
    }
}
