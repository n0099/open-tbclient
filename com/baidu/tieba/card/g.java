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
    private LinearLayout ihY;
    private TextView ihZ;
    private LinearLayout iia;
    private e iib;
    private f iic;
    private f iid;
    private com.baidu.tieba.f.a iie;
    private com.baidu.tieba.f.b iif;
    private com.baidu.tieba.f.b iig;
    private View iih;
    private View iii;
    private a iij;
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
        this.ihY = (LinearLayout) view.findViewById(R.id.card_frs_game_head_line_layout);
        this.ihZ = (TextView) view.findViewById(R.id.frs_game_head_line_title);
        this.iia = (LinearLayout) view.findViewById(R.id.frs_game_head_line_container);
        this.iih = view.findViewById(R.id.divider_line_1);
        this.iii = view.findViewById(R.id.divider_line_2);
        int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds44);
        if (this.iib == null) {
            this.iib = new e(this.mTbPageContext, null, null);
        }
        this.iib.D(0, 0, 0, 0);
        this.iib.yg(8);
        this.iib.yh(8);
        if (this.iib.getView().getParent() != null) {
            ((ViewGroup) this.iib.getView().getParent()).removeView(this.iib.getView());
        }
        this.iib.getView().setOnClickListener(this);
        this.iib.getView().setVisibility(8);
        this.iia.addView(this.iib.getView());
        if (this.iic == null) {
            this.iic = new f(this.mTbPageContext);
        }
        this.iic.yh(8);
        this.iic.E(0, dimensionPixelSize, 0, 0);
        if (this.iic.getView().getParent() != null) {
            ((ViewGroup) this.iic.getView().getParent()).removeView(this.iic.getView());
        }
        this.iic.getView().setOnClickListener(this);
        this.iic.getView().setVisibility(8);
        this.iia.addView(this.iic.getView());
        if (this.iid == null) {
            this.iid = new f(this.mTbPageContext);
        }
        this.iid.yh(8);
        this.iid.E(0, dimensionPixelSize, 0, 0);
        if (this.iid.getView().getParent() != null) {
            ((ViewGroup) this.iid.getView().getParent()).removeView(this.iid.getView());
        }
        this.iid.getView().setOnClickListener(this);
        this.iid.getView().setVisibility(8);
        this.iia.addView(this.iid.getView());
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        ap.setBackgroundResource(getView(), R.color.CAM_X0201);
        ap.setViewTextColor(this.ihZ, R.color.CAM_X0106, 1);
        ap.setBackgroundResource(this.iih, R.color.CAM_X0205);
        ap.setBackgroundResource(this.iii, R.color.CAM_X0205);
        if (this.iib != null) {
            this.iib.onChangeSkinType(tbPageContext, i);
        }
        if (this.iic != null) {
            this.iic.onChangeSkinType(tbPageContext, i);
        }
        if (this.iid != null) {
            this.iid.onChangeSkinType(tbPageContext, i);
        }
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.card_frs_game_head_line_view_item;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.f.d dVar) {
        if (dVar != null && dVar.ctD() != null) {
            if (!TextUtils.isEmpty(dVar.ctD().title)) {
                this.ihZ.setText(dVar.ctD().title);
            }
            List<by> list = dVar.ctD().sub_nodes;
            if (com.baidu.tbadk.core.util.y.getCount(list) >= 1) {
                this.iie = new com.baidu.tieba.f.a();
                this.iie.setData(list.get(0));
                this.iib.getView().setVisibility(0);
                this.iib.a(this.iie);
            }
            if (com.baidu.tbadk.core.util.y.getCount(list) >= 2) {
                this.iif = new com.baidu.tieba.f.b();
                this.iif.setData(list.get(1));
                this.iic.getView().setVisibility(0);
                this.iic.a(this.iif);
                this.iic.yi(8);
            }
            if (com.baidu.tbadk.core.util.y.getCount(list) >= 3) {
                this.iig = new com.baidu.tieba.f.b();
                this.iig.setData(list.get(2));
                this.iid.getView().setVisibility(0);
                this.iid.a(this.iig);
                this.iid.yi(8);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TiebaStatic.log(new ar("c13047").al("obj_locate", 6).dY("fid", this.mForumId));
        if (view == this.iib.getView()) {
            if (this.iie != null) {
                if (this.iij != null) {
                    this.iij.b(view, this.iie);
                }
                Z(this.iie.bmn());
            }
        } else if (view == this.iic.getView()) {
            if (this.iif != null) {
                if (this.iij != null) {
                    this.iij.b(view, this.iif);
                }
                Z(this.iif.bmn());
            }
        } else if (view == this.iid.getView() && this.iig != null) {
            if (this.iij != null) {
                this.iij.b(view, this.iig);
            }
            Z(this.iig.bmn());
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
        this.iij = aVar;
    }
}
