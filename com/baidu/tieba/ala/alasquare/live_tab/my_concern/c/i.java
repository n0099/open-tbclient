package com.baidu.tieba.ala.alasquare.live_tab.my_concern.c;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class i extends com.baidu.tieba.card.a<com.baidu.tieba.ala.alasquare.live_tab.my_concern.data.b> {
    private TextView eot;
    private HeadImageView eou;
    private TextView eov;
    private com.baidu.tieba.ala.alasquare.live_tab.my_concern.data.b eow;
    private RelativeLayout eox;
    private TextView mName;
    private View mRoot;

    public i(TbPageContext tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        this.mRoot = getView();
        this.eox = (RelativeLayout) getView().findViewById(R.id.id_tab_live_sub_offline_item_wrapper);
        this.mName = (TextView) getView().findViewById(R.id.id_tab_live_sub_offline_item_name);
        this.eot = (TextView) getView().findViewById(R.id.id_tab_live_sub_offline_item_description);
        this.eou = (HeadImageView) getView().findViewById(R.id.id_tab_live_sub_offline_item_avatar);
        this.eou.setAutoChangeStyle(true);
        this.eou.setIsRound(true);
        this.eou.setDrawBorder(true);
        this.eou.setDefaultResource(R.drawable.icon_default_avatar100_bg);
        this.eou.setDefaultBgResource(17170445);
        this.eou.setBorderWidth(com.baidu.adp.lib.util.l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds1));
        this.eou.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.eov = (TextView) getView().findViewById(R.id.id_tab_live_sub_offline_item_time);
        this.eox.setOnClickListener(this);
        onChangeSkinType(tbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        am.setBackgroundResource(this.mRoot, R.color.cp_bg_line_d);
        am.setViewTextColor(this.mName, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.eot, (int) R.color.cp_cont_c);
        am.setViewTextColor(this.eov, (int) R.color.cp_cont_c);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.tab_sub_live_offline_item_view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    /* renamed from: b */
    public void a(com.baidu.tieba.ala.alasquare.live_tab.my_concern.data.b bVar) {
        if (bVar != null) {
            this.eow = bVar;
            String str = bVar.user_nickname;
            if (StringUtils.isNull(str)) {
                str = StringUtils.isNull(bVar.user_name) ? "" : bVar.user_name;
            }
            this.mName.setText(str);
            this.eot.setText(StringUtils.isNull(bVar.enw) ? "" : bVar.enw);
            this.eou.startLoad(bVar.portrait, 10, false);
            this.eov.setText(StringUtils.isNull(bVar.remark) ? "" : bVar.remark);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (buH() != null) {
            buH().a(view, this.eow);
        }
    }
}
