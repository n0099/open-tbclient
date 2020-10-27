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
    private TextView ggD;
    private HeadImageView ggE;
    private TextView ggF;
    private com.baidu.tieba.ala.alasquare.live_tab.my_concern.data.b ggG;
    private RelativeLayout ggH;
    private TextView mName;
    private View mRoot;

    public i(TbPageContext tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        this.mRoot = getView();
        this.ggH = (RelativeLayout) getView().findViewById(R.id.id_tab_live_sub_offline_item_wrapper);
        this.mName = (TextView) getView().findViewById(R.id.id_tab_live_sub_offline_item_name);
        this.ggD = (TextView) getView().findViewById(R.id.id_tab_live_sub_offline_item_description);
        this.ggE = (HeadImageView) getView().findViewById(R.id.id_tab_live_sub_offline_item_avatar);
        this.ggE.setAutoChangeStyle(true);
        this.ggE.setIsRound(true);
        this.ggE.setDrawBorder(true);
        this.ggE.setDefaultResource(R.drawable.icon_default_avatar100_bg);
        this.ggE.setDefaultBgResource(17170445);
        this.ggE.setBorderWidth(com.baidu.adp.lib.util.l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds1));
        this.ggE.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.ggF = (TextView) getView().findViewById(R.id.id_tab_live_sub_offline_item_time);
        this.ggH.setOnClickListener(this);
        onChangeSkinType(tbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        ap.setBackgroundResource(this.mRoot, R.color.cp_bg_line_d);
        ap.setViewTextColor(this.mName, R.color.cp_cont_b);
        ap.setViewTextColor(this.ggD, R.color.cp_cont_c);
        ap.setViewTextColor(this.ggF, R.color.cp_cont_c);
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
            this.ggG = bVar;
            String str = bVar.user_nickname;
            if (StringUtils.isNull(str)) {
                str = StringUtils.isNull(bVar.user_name) ? "" : bVar.user_name;
            }
            this.mName.setText(str);
            this.ggD.setText(StringUtils.isNull(bVar.gfI) ? "" : bVar.gfI);
            this.ggE.startLoad(bVar.portrait, 10, false);
            this.ggF.setText(StringUtils.isNull(bVar.remark) ? "" : bVar.remark);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (cls() != null) {
            cls().a(view, this.ggG);
        }
    }
}
