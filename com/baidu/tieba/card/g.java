package com.baidu.tieba.card;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.by;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.BaseCardInfo;
import java.util.List;
/* loaded from: classes22.dex */
public class g extends b<com.baidu.tieba.f.d> {
    private LinearLayout ihW;
    private TextView ihX;
    private LinearLayout ihY;
    private e ihZ;
    private f iia;
    private f iib;
    private com.baidu.tieba.f.a iic;
    private com.baidu.tieba.f.b iid;
    private com.baidu.tieba.f.b iie;
    private View iif;
    private View iig;
    private a iih;
    private String mForumId;

    /* loaded from: classes22.dex */
    public interface a {
        void b(View view, BaseCardInfo baseCardInfo);
    }

    public g(TbPageContext<?> tbPageContext, String str) {
        super(tbPageContext);
        this.mForumId = str;
        init(getView());
    }

    private void init(View view) {
        this.ihW = (LinearLayout) view.findViewById(R.id.card_frs_game_head_line_layout);
        this.ihX = (TextView) view.findViewById(R.id.frs_game_head_line_title);
        this.ihY = (LinearLayout) view.findViewById(R.id.frs_game_head_line_container);
        this.iif = view.findViewById(R.id.divider_line_1);
        this.iig = view.findViewById(R.id.divider_line_2);
        int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds44);
        if (this.ihZ == null) {
            this.ihZ = new e(this.mTbPageContext, null, null);
        }
        this.ihZ.D(0, 0, 0, 0);
        this.ihZ.yg(8);
        this.ihZ.yh(8);
        if (this.ihZ.getView().getParent() != null) {
            ((ViewGroup) this.ihZ.getView().getParent()).removeView(this.ihZ.getView());
        }
        this.ihZ.getView().setOnClickListener(this);
        this.ihZ.getView().setVisibility(8);
        this.ihY.addView(this.ihZ.getView());
        if (this.iia == null) {
            this.iia = new f(this.mTbPageContext);
        }
        this.iia.yh(8);
        this.iia.E(0, dimensionPixelSize, 0, 0);
        if (this.iia.getView().getParent() != null) {
            ((ViewGroup) this.iia.getView().getParent()).removeView(this.iia.getView());
        }
        this.iia.getView().setOnClickListener(this);
        this.iia.getView().setVisibility(8);
        this.ihY.addView(this.iia.getView());
        if (this.iib == null) {
            this.iib = new f(this.mTbPageContext);
        }
        this.iib.yh(8);
        this.iib.E(0, dimensionPixelSize, 0, 0);
        if (this.iib.getView().getParent() != null) {
            ((ViewGroup) this.iib.getView().getParent()).removeView(this.iib.getView());
        }
        this.iib.getView().setOnClickListener(this);
        this.iib.getView().setVisibility(8);
        this.ihY.addView(this.iib.getView());
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        ap.setBackgroundResource(getView(), R.color.CAM_X0201);
        ap.setViewTextColor(this.ihX, R.color.CAM_X0106, 1);
        ap.setBackgroundResource(this.iif, R.color.CAM_X0205);
        ap.setBackgroundResource(this.iig, R.color.CAM_X0205);
        if (this.ihZ != null) {
            this.ihZ.onChangeSkinType(tbPageContext, i);
        }
        if (this.iia != null) {
            this.iia.onChangeSkinType(tbPageContext, i);
        }
        if (this.iib != null) {
            this.iib.onChangeSkinType(tbPageContext, i);
        }
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.card_frs_game_head_line_view_item;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.f.d dVar) {
        if (dVar != null && dVar.ctC() != null) {
            if (!TextUtils.isEmpty(dVar.ctC().title)) {
                this.ihX.setText(dVar.ctC().title);
            }
            List<by> list = dVar.ctC().sub_nodes;
            if (com.baidu.tbadk.core.util.y.getCount(list) >= 1) {
                this.iic = new com.baidu.tieba.f.a();
                this.iic.setData(list.get(0));
                this.ihZ.getView().setVisibility(0);
                this.ihZ.a(this.iic);
            }
            if (com.baidu.tbadk.core.util.y.getCount(list) >= 2) {
                this.iid = new com.baidu.tieba.f.b();
                this.iid.setData(list.get(1));
                this.iia.getView().setVisibility(0);
                this.iia.a(this.iid);
                this.iia.yi(8);
            }
            if (com.baidu.tbadk.core.util.y.getCount(list) >= 3) {
                this.iie = new com.baidu.tieba.f.b();
                this.iie.setData(list.get(2));
                this.iib.getView().setVisibility(0);
                this.iib.a(this.iie);
                this.iib.yi(8);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TiebaStatic.log(new ar("c13047").al("obj_locate", 6).dY("fid", this.mForumId));
        if (view == this.ihZ.getView()) {
            if (this.iic != null) {
                if (this.iih != null) {
                    this.iih.b(view, this.iic);
                }
                Z(this.iic.bmn());
            }
        } else if (view == this.iia.getView()) {
            if (this.iid != null) {
                if (this.iih != null) {
                    this.iih.b(view, this.iid);
                }
                Z(this.iid.bmn());
            }
        } else if (view == this.iib.getView() && this.iie != null) {
            if (this.iih != null) {
                this.iih.b(view, this.iie);
            }
            Z(this.iie.bmn());
        }
    }

    private void Z(by byVar) {
        PbActivityConfig createFromThreadCfg = new PbActivityConfig(getTbPageContext().getPageActivity()).createFromThreadCfg(byVar, null, n.boB(), RequestResponseCode.REQUEST_FRS_TO_PB, true, false, false);
        createFromThreadCfg.setForumId(String.valueOf(byVar.getFid()));
        createFromThreadCfg.setForumName(byVar.boT());
        createFromThreadCfg.setStartFrom(0);
        n.Jq(byVar.getTid());
        getTbPageContext().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
    }

    public void a(a aVar) {
        this.iih = aVar;
    }
}
