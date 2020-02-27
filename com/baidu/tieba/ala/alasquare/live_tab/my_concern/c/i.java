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
    private TextView eoe;
    private HeadImageView eog;
    private TextView eoh;
    private com.baidu.tieba.ala.alasquare.live_tab.my_concern.data.b eoi;
    private RelativeLayout eoj;
    private TextView mName;
    private View mRoot;

    public i(TbPageContext tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        this.mRoot = getView();
        this.eoj = (RelativeLayout) getView().findViewById(R.id.id_tab_live_sub_offline_item_wrapper);
        this.mName = (TextView) getView().findViewById(R.id.id_tab_live_sub_offline_item_name);
        this.eoe = (TextView) getView().findViewById(R.id.id_tab_live_sub_offline_item_description);
        this.eog = (HeadImageView) getView().findViewById(R.id.id_tab_live_sub_offline_item_avatar);
        this.eog.setAutoChangeStyle(true);
        this.eog.setIsRound(true);
        this.eog.setDrawBorder(true);
        this.eog.setDefaultResource(R.drawable.icon_default_avatar100_bg);
        this.eog.setDefaultBgResource(17170445);
        this.eog.setBorderWidth(com.baidu.adp.lib.util.l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds1));
        this.eog.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.eoh = (TextView) getView().findViewById(R.id.id_tab_live_sub_offline_item_time);
        this.eoj.setOnClickListener(this);
        onChangeSkinType(tbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        am.setBackgroundResource(this.mRoot, R.color.cp_bg_line_d);
        am.setViewTextColor(this.mName, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.eoe, (int) R.color.cp_cont_c);
        am.setViewTextColor(this.eoh, (int) R.color.cp_cont_c);
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
            this.eoi = bVar;
            String str = bVar.user_nickname;
            if (StringUtils.isNull(str)) {
                str = StringUtils.isNull(bVar.user_name) ? "" : bVar.user_name;
            }
            this.mName.setText(str);
            this.eoe.setText(StringUtils.isNull(bVar.enh) ? "" : bVar.enh);
            this.eog.startLoad(bVar.portrait, 10, false);
            this.eoh.setText(StringUtils.isNull(bVar.remark) ? "" : bVar.remark);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (buE() != null) {
            buE().a(view, this.eoi);
        }
    }
}
