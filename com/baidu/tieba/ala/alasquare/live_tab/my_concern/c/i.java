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
public class i extends com.baidu.tieba.card.b<com.baidu.tieba.ala.alasquare.live_tab.my_concern.data.b> {
    private TextView fff;
    private HeadImageView ffg;
    private TextView ffh;
    private com.baidu.tieba.ala.alasquare.live_tab.my_concern.data.b ffi;
    private RelativeLayout ffj;
    private TextView mName;
    private View mRoot;

    public i(TbPageContext tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        this.mRoot = getView();
        this.ffj = (RelativeLayout) getView().findViewById(R.id.id_tab_live_sub_offline_item_wrapper);
        this.mName = (TextView) getView().findViewById(R.id.id_tab_live_sub_offline_item_name);
        this.fff = (TextView) getView().findViewById(R.id.id_tab_live_sub_offline_item_description);
        this.ffg = (HeadImageView) getView().findViewById(R.id.id_tab_live_sub_offline_item_avatar);
        this.ffg.setAutoChangeStyle(true);
        this.ffg.setIsRound(true);
        this.ffg.setDrawBorder(true);
        this.ffg.setDefaultResource(R.drawable.icon_default_avatar100_bg);
        this.ffg.setDefaultBgResource(17170445);
        this.ffg.setBorderWidth(com.baidu.adp.lib.util.l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds1));
        this.ffg.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.ffh = (TextView) getView().findViewById(R.id.id_tab_live_sub_offline_item_time);
        this.ffj.setOnClickListener(this);
        onChangeSkinType(tbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        am.setBackgroundResource(this.mRoot, R.color.cp_bg_line_d);
        am.setViewTextColor(this.mName, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.fff, (int) R.color.cp_cont_c);
        am.setViewTextColor(this.ffh, (int) R.color.cp_cont_c);
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
            this.ffi = bVar;
            String str = bVar.user_nickname;
            if (StringUtils.isNull(str)) {
                str = StringUtils.isNull(bVar.user_name) ? "" : bVar.user_name;
            }
            this.mName.setText(str);
            this.fff.setText(StringUtils.isNull(bVar.fej) ? "" : bVar.fej);
            this.ffg.startLoad(bVar.portrait, 10, false);
            this.ffh.setText(StringUtils.isNull(bVar.remark) ? "" : bVar.remark);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (bKU() != null) {
            bKU().a(view, this.ffi);
        }
    }
}
