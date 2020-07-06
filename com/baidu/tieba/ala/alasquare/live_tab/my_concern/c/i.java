package com.baidu.tieba.ala.alasquare.live_tab.my_concern.c;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class i extends com.baidu.tieba.card.b<com.baidu.tieba.ala.alasquare.live_tab.my_concern.data.b> {
    private TextView fqq;
    private HeadImageView fqr;
    private TextView fqs;
    private com.baidu.tieba.ala.alasquare.live_tab.my_concern.data.b fqt;
    private RelativeLayout fqu;
    private TextView mName;
    private View mRoot;

    public i(TbPageContext tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        this.mRoot = getView();
        this.fqu = (RelativeLayout) getView().findViewById(R.id.id_tab_live_sub_offline_item_wrapper);
        this.mName = (TextView) getView().findViewById(R.id.id_tab_live_sub_offline_item_name);
        this.fqq = (TextView) getView().findViewById(R.id.id_tab_live_sub_offline_item_description);
        this.fqr = (HeadImageView) getView().findViewById(R.id.id_tab_live_sub_offline_item_avatar);
        this.fqr.setAutoChangeStyle(true);
        this.fqr.setIsRound(true);
        this.fqr.setDrawBorder(true);
        this.fqr.setDefaultResource(R.drawable.icon_default_avatar100_bg);
        this.fqr.setDefaultBgResource(17170445);
        this.fqr.setBorderWidth(com.baidu.adp.lib.util.l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds1));
        this.fqr.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.fqs = (TextView) getView().findViewById(R.id.id_tab_live_sub_offline_item_time);
        this.fqu.setOnClickListener(this);
        onChangeSkinType(tbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        an.setBackgroundResource(this.mRoot, R.color.cp_bg_line_d);
        an.setViewTextColor(this.mName, (int) R.color.cp_cont_b);
        an.setViewTextColor(this.fqq, (int) R.color.cp_cont_c);
        an.setViewTextColor(this.fqs, (int) R.color.cp_cont_c);
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
            this.fqt = bVar;
            String str = bVar.user_nickname;
            if (StringUtils.isNull(str)) {
                str = StringUtils.isNull(bVar.user_name) ? "" : bVar.user_name;
            }
            this.mName.setText(str);
            this.fqq.setText(StringUtils.isNull(bVar.fpu) ? "" : bVar.fpu);
            this.fqr.startLoad(bVar.portrait, 10, false);
            this.fqs.setText(StringUtils.isNull(bVar.remark) ? "" : bVar.remark);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (bOd() != null) {
            bOd().a(view, this.fqt);
        }
    }
}
