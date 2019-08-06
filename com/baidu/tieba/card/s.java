package com.baidu.tieba.card;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.bb;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.o;
/* loaded from: classes4.dex */
public class s extends a<o> {
    private View eDo;
    private String eDq;
    private HeadImageView eEp;
    private TextView eEq;
    private TextView eEr;
    private TbImageView eEs;
    private TextView eEt;
    private o eEu;
    private int eEv;
    private String eEw;
    private String eEx;
    private View mRootView;

    public s(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.eEv = tbPageContext.getResources().getDimensionPixelSize(R.dimen.ds70);
        init(getView());
    }

    public void Q(String str, String str2, String str3) {
        this.eDq = str;
        this.eEw = str2;
        this.eEx = str3;
    }

    private void init(View view) {
        this.mRootView = view.findViewById(R.id.root_view);
        this.eEp = (HeadImageView) view.findViewById(R.id.promotion_head_img);
        this.eEq = (TextView) view.findViewById(R.id.promotion_name);
        this.eEr = (TextView) view.findViewById(R.id.promotion_desc);
        this.eEs = (TbImageView) view.findViewById(R.id.promotion_img);
        this.eEt = (TextView) view.findViewById(R.id.promotion_icon);
        this.eDo = view.findViewById(R.id.top_line);
        this.eEp.setOnClickListener(this);
        this.eEq.setOnClickListener(this);
        this.eEt.setOnClickListener(this);
        this.mRootView.setOnClickListener(this);
        this.eEp.setDefaultResource(17170445);
        this.eEp.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.eEp.setRadius(this.eEv);
        this.eEs.setDrawBorder(true);
        this.eEs.setBorderWidth(1);
        this.eEs.setDefaultBgResource(com.baidu.tbadk.util.e.Qr());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if ((view == this.eEp || view == this.eEq || view == this.eEt) && !StringUtils.isNull(this.eEu.eGW)) {
            TiebaStatic.log(new an(this.eEw).bT(VideoPlayActivityConfig.OBJ_ID, String.valueOf(this.eEu.eGU)));
            bb.ajE().c(getTbPageContext(), new String[]{this.eEu.eGW});
        } else if ((view == this.mRootView || view == this.eEr || view == this.eEs) && !StringUtils.isNull(this.eEu.eGZ)) {
            TiebaStatic.log(new an(this.eEx).bT(VideoPlayActivityConfig.OBJ_ID, String.valueOf(this.eEu.eGU)));
            bb.ajE().c(getTbPageContext(), new String[]{this.eEu.eGZ});
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.k(this.mRootView, R.drawable.addresslist_item_bg);
            am.k(this.eEt, R.drawable.label_bg_gray);
            am.k(this.eDo, R.color.cp_bg_line_b);
            am.f(this.eEq, R.color.cp_cont_b, 1);
            am.f(this.eEt, R.color.cp_cont_d, 1);
            am.f(this.eEr, R.color.cp_cont_b, 1);
            this.eEp.setDefaultBgResource(com.baidu.tbadk.util.e.Qr());
            this.eEs.setDefaultBgResource(com.baidu.tbadk.util.e.Qr());
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.card_promotion_item;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(o oVar) {
        if (oVar == null) {
            this.mRootView.setVisibility(8);
            return;
        }
        if (this.mRootView.getVisibility() != 0) {
            this.mRootView.setVisibility(0);
        }
        this.eEu = oVar;
        this.eEp.startLoad(oVar.eGV, 10, false);
        this.eEq.setText(UtilHelper.getFixedText(oVar.userName, 7, true));
        if (StringUtils.isNull(oVar.eHb)) {
            this.eEt.setVisibility(8);
        } else {
            this.eEt.setVisibility(0);
            this.eEt.setText(oVar.eHb);
        }
        this.eEr.setText(oVar.eGX);
        if (com.baidu.tbadk.core.i.aca().ace()) {
            this.eEs.setVisibility(0);
            this.eEs.startLoad(oVar.eGY, 10, false);
            return;
        }
        this.eEs.setVisibility(8);
    }
}
