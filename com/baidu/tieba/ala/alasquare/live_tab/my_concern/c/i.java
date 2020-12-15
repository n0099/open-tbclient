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
    private TextView guj;
    private HeadImageView guk;
    private TextView gul;
    private com.baidu.tieba.ala.alasquare.live_tab.my_concern.data.b gum;
    private RelativeLayout gun;
    private TextView mName;
    private View mRoot;

    public i(TbPageContext tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        this.mRoot = getView();
        this.gun = (RelativeLayout) getView().findViewById(R.id.id_tab_live_sub_offline_item_wrapper);
        this.mName = (TextView) getView().findViewById(R.id.id_tab_live_sub_offline_item_name);
        this.guj = (TextView) getView().findViewById(R.id.id_tab_live_sub_offline_item_description);
        this.guk = (HeadImageView) getView().findViewById(R.id.id_tab_live_sub_offline_item_avatar);
        this.guk.setAutoChangeStyle(true);
        this.guk.setIsRound(true);
        this.guk.setDrawBorder(true);
        this.guk.setPlaceHolder(1);
        this.guk.setBorderWidth(com.baidu.adp.lib.util.l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds1));
        this.guk.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.gul = (TextView) getView().findViewById(R.id.id_tab_live_sub_offline_item_time);
        this.gun.setOnClickListener(this);
        onChangeSkinType(tbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        ap.setBackgroundResource(this.mRoot, R.color.CAM_X0201);
        ap.setViewTextColor(this.mName, (int) R.color.CAM_X0105);
        ap.setViewTextColor(this.guj, (int) R.color.CAM_X0108);
        ap.setViewTextColor(this.gul, (int) R.color.CAM_X0108);
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
            this.gum = bVar;
            String str = bVar.user_nickname;
            if (StringUtils.isNull(str)) {
                str = StringUtils.isNull(bVar.user_name) ? "" : bVar.user_name;
            }
            this.mName.setText(str);
            this.guj.setText(StringUtils.isNull(bVar.gtp) ? "" : bVar.gtp);
            this.guk.startLoad(bVar.portrait, 10, false);
            this.gul.setText(StringUtils.isNull(bVar.remark) ? "" : bVar.remark);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (crJ() != null) {
            crJ().a(view, this.gum);
        }
    }
}
