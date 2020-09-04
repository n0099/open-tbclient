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
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes16.dex */
public class g extends b<com.baidu.tieba.e.d> {
    private LinearLayout hij;
    private TextView hik;
    private LinearLayout hil;
    private e him;
    private f hin;
    private f hio;
    private com.baidu.tieba.e.a hip;
    private com.baidu.tieba.e.b hiq;
    private com.baidu.tieba.e.b hir;
    private View his;
    private View hit;
    private a hiu;
    private String mForumId;

    /* loaded from: classes16.dex */
    public interface a {
        void b(View view, com.baidu.tieba.card.data.b bVar);
    }

    public g(TbPageContext<?> tbPageContext, String str) {
        super(tbPageContext);
        this.mForumId = str;
        init(getView());
    }

    private void init(View view) {
        this.hij = (LinearLayout) view.findViewById(R.id.card_frs_game_head_line_layout);
        this.hik = (TextView) view.findViewById(R.id.frs_game_head_line_title);
        this.hil = (LinearLayout) view.findViewById(R.id.frs_game_head_line_container);
        this.his = view.findViewById(R.id.divider_line_1);
        this.hit = view.findViewById(R.id.divider_line_2);
        int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds44);
        if (this.him == null) {
            this.him = new e(this.mTbPageContext, null, null);
        }
        this.him.x(0, 0, 0, 0);
        this.him.vr(8);
        this.him.vs(8);
        if (this.him.getView().getParent() != null) {
            ((ViewGroup) this.him.getView().getParent()).removeView(this.him.getView());
        }
        this.him.getView().setOnClickListener(this);
        this.him.getView().setVisibility(8);
        this.hil.addView(this.him.getView());
        if (this.hin == null) {
            this.hin = new f(this.mTbPageContext);
        }
        this.hin.vs(8);
        this.hin.y(0, dimensionPixelSize, 0, 0);
        if (this.hin.getView().getParent() != null) {
            ((ViewGroup) this.hin.getView().getParent()).removeView(this.hin.getView());
        }
        this.hin.getView().setOnClickListener(this);
        this.hin.getView().setVisibility(8);
        this.hil.addView(this.hin.getView());
        if (this.hio == null) {
            this.hio = new f(this.mTbPageContext);
        }
        this.hio.vs(8);
        this.hio.y(0, dimensionPixelSize, 0, 0);
        if (this.hio.getView().getParent() != null) {
            ((ViewGroup) this.hio.getView().getParent()).removeView(this.hio.getView());
        }
        this.hio.getView().setOnClickListener(this);
        this.hio.getView().setVisibility(8);
        this.hil.addView(this.hio.getView());
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        ap.setBackgroundResource(getView(), R.color.cp_bg_line_d);
        ap.setViewTextColor(this.hik, R.color.cp_cont_f, 1);
        ap.setBackgroundResource(this.his, R.color.cp_bg_line_e);
        ap.setBackgroundResource(this.hit, R.color.cp_bg_line_e);
        if (this.him != null) {
            this.him.onChangeSkinType(tbPageContext, i);
        }
        if (this.hin != null) {
            this.hin.onChangeSkinType(tbPageContext, i);
        }
        if (this.hio != null) {
            this.hio.onChangeSkinType(tbPageContext, i);
        }
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.card_frs_game_head_line_view_item;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.e.d dVar) {
        if (dVar != null && dVar.cds() != null) {
            if (!TextUtils.isEmpty(dVar.cds().title)) {
                this.hik.setText(dVar.cds().title);
            }
            List<bw> list = dVar.cds().sub_nodes;
            if (com.baidu.tbadk.core.util.y.getCount(list) >= 1) {
                this.hip = new com.baidu.tieba.e.a();
                this.hip.setData(list.get(0));
                this.him.getView().setVisibility(0);
                this.him.a(this.hip);
            }
            if (com.baidu.tbadk.core.util.y.getCount(list) >= 2) {
                this.hiq = new com.baidu.tieba.e.b();
                this.hiq.setData(list.get(1));
                this.hin.getView().setVisibility(0);
                this.hin.a(this.hiq);
                this.hin.vt(8);
            }
            if (com.baidu.tbadk.core.util.y.getCount(list) >= 3) {
                this.hir = new com.baidu.tieba.e.b();
                this.hir.setData(list.get(2));
                this.hio.getView().setVisibility(0);
                this.hio.a(this.hir);
                this.hio.vt(8);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TiebaStatic.log(new aq("c13047").ai("obj_locate", 6).dD("fid", this.mForumId));
        if (view == this.him.getView()) {
            if (this.hip != null) {
                if (this.hiu != null) {
                    this.hiu.b(view, this.hip);
                }
                W(this.hip.bce());
            }
        } else if (view == this.hin.getView()) {
            if (this.hiq != null) {
                if (this.hiu != null) {
                    this.hiu.b(view, this.hiq);
                }
                W(this.hiq.bce());
            }
        } else if (view == this.hio.getView() && this.hir != null) {
            if (this.hiu != null) {
                this.hiu.b(view, this.hir);
            }
            W(this.hir.bce());
        }
    }

    private void W(bw bwVar) {
        PbActivityConfig createFromThreadCfg = new PbActivityConfig(getTbPageContext().getPageActivity()).createFromThreadCfg(bwVar, null, m.beq(), RequestResponseCode.REQUEST_FRS_TO_PB, true, false, false);
        createFromThreadCfg.setForumId(String.valueOf(bwVar.getFid()));
        createFromThreadCfg.setForumName(bwVar.beI());
        createFromThreadCfg.setStartFrom(0);
        m.GZ(bwVar.getTid());
        getTbPageContext().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
    }

    public void a(a aVar) {
        this.hiu = aVar;
    }
}
