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
/* loaded from: classes6.dex */
public class i extends com.baidu.tieba.card.a<com.baidu.tieba.ala.alasquare.live_tab.my_concern.data.b> {
    private TextView dye;
    private HeadImageView dyf;
    private TextView dyg;
    private com.baidu.tieba.ala.alasquare.live_tab.my_concern.data.b dyh;
    private RelativeLayout dyi;
    private TextView mName;
    private View mRoot;

    public i(TbPageContext tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        this.mRoot = getView();
        this.dyi = (RelativeLayout) getView().findViewById(R.id.id_tab_live_sub_offline_item_wrapper);
        this.mName = (TextView) getView().findViewById(R.id.id_tab_live_sub_offline_item_name);
        this.dye = (TextView) getView().findViewById(R.id.id_tab_live_sub_offline_item_description);
        this.dyf = (HeadImageView) getView().findViewById(R.id.id_tab_live_sub_offline_item_avatar);
        this.dyf.setAutoChangeStyle(true);
        this.dyf.setIsRound(true);
        this.dyf.setDrawBorder(true);
        this.dyf.setDefaultResource(R.drawable.icon_default_avatar100_bg);
        this.dyf.setDefaultBgResource(17170445);
        this.dyf.setBorderWidth(com.baidu.adp.lib.util.l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds1));
        this.dyf.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.dyg = (TextView) getView().findViewById(R.id.id_tab_live_sub_offline_item_time);
        this.dyi.setOnClickListener(this);
        onChangeSkinType(tbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        am.setBackgroundResource(this.mRoot, R.color.cp_bg_line_d);
        am.setViewTextColor(this.mName, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.dye, (int) R.color.cp_cont_c);
        am.setViewTextColor(this.dyg, (int) R.color.cp_cont_c);
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
            this.dyh = bVar;
            String str = bVar.user_nickname;
            if (StringUtils.isNull(str)) {
                str = StringUtils.isNull(bVar.user_name) ? "" : bVar.user_name;
            }
            this.mName.setText(str);
            this.dye.setText(StringUtils.isNull(bVar.dxi) ? "" : bVar.dxi);
            this.dyf.startLoad(bVar.portrait, 10, false);
            this.dyg.setText(StringUtils.isNull(bVar.remark) ? "" : bVar.remark);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (aZV() != null) {
            aZV().a(view, this.dyh);
        }
    }
}
