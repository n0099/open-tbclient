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
    private LinearLayout hif;
    private TextView hig;
    private LinearLayout hih;
    private e hii;
    private f hij;
    private f hik;
    private com.baidu.tieba.e.a hil;
    private com.baidu.tieba.e.b him;
    private com.baidu.tieba.e.b hin;
    private View hio;
    private View hip;
    private a hiq;
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
        this.hif = (LinearLayout) view.findViewById(R.id.card_frs_game_head_line_layout);
        this.hig = (TextView) view.findViewById(R.id.frs_game_head_line_title);
        this.hih = (LinearLayout) view.findViewById(R.id.frs_game_head_line_container);
        this.hio = view.findViewById(R.id.divider_line_1);
        this.hip = view.findViewById(R.id.divider_line_2);
        int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds44);
        if (this.hii == null) {
            this.hii = new e(this.mTbPageContext, null, null);
        }
        this.hii.x(0, 0, 0, 0);
        this.hii.vr(8);
        this.hii.vs(8);
        if (this.hii.getView().getParent() != null) {
            ((ViewGroup) this.hii.getView().getParent()).removeView(this.hii.getView());
        }
        this.hii.getView().setOnClickListener(this);
        this.hii.getView().setVisibility(8);
        this.hih.addView(this.hii.getView());
        if (this.hij == null) {
            this.hij = new f(this.mTbPageContext);
        }
        this.hij.vs(8);
        this.hij.y(0, dimensionPixelSize, 0, 0);
        if (this.hij.getView().getParent() != null) {
            ((ViewGroup) this.hij.getView().getParent()).removeView(this.hij.getView());
        }
        this.hij.getView().setOnClickListener(this);
        this.hij.getView().setVisibility(8);
        this.hih.addView(this.hij.getView());
        if (this.hik == null) {
            this.hik = new f(this.mTbPageContext);
        }
        this.hik.vs(8);
        this.hik.y(0, dimensionPixelSize, 0, 0);
        if (this.hik.getView().getParent() != null) {
            ((ViewGroup) this.hik.getView().getParent()).removeView(this.hik.getView());
        }
        this.hik.getView().setOnClickListener(this);
        this.hik.getView().setVisibility(8);
        this.hih.addView(this.hik.getView());
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        ap.setBackgroundResource(getView(), R.color.cp_bg_line_d);
        ap.setViewTextColor(this.hig, R.color.cp_cont_f, 1);
        ap.setBackgroundResource(this.hio, R.color.cp_bg_line_e);
        ap.setBackgroundResource(this.hip, R.color.cp_bg_line_e);
        if (this.hii != null) {
            this.hii.onChangeSkinType(tbPageContext, i);
        }
        if (this.hij != null) {
            this.hij.onChangeSkinType(tbPageContext, i);
        }
        if (this.hik != null) {
            this.hik.onChangeSkinType(tbPageContext, i);
        }
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.card_frs_game_head_line_view_item;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.e.d dVar) {
        if (dVar != null && dVar.cdr() != null) {
            if (!TextUtils.isEmpty(dVar.cdr().title)) {
                this.hig.setText(dVar.cdr().title);
            }
            List<bw> list = dVar.cdr().sub_nodes;
            if (com.baidu.tbadk.core.util.y.getCount(list) >= 1) {
                this.hil = new com.baidu.tieba.e.a();
                this.hil.setData(list.get(0));
                this.hii.getView().setVisibility(0);
                this.hii.a(this.hil);
            }
            if (com.baidu.tbadk.core.util.y.getCount(list) >= 2) {
                this.him = new com.baidu.tieba.e.b();
                this.him.setData(list.get(1));
                this.hij.getView().setVisibility(0);
                this.hij.a(this.him);
                this.hij.vt(8);
            }
            if (com.baidu.tbadk.core.util.y.getCount(list) >= 3) {
                this.hin = new com.baidu.tieba.e.b();
                this.hin.setData(list.get(2));
                this.hik.getView().setVisibility(0);
                this.hik.a(this.hin);
                this.hik.vt(8);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TiebaStatic.log(new aq("c13047").ai("obj_locate", 6).dD("fid", this.mForumId));
        if (view == this.hii.getView()) {
            if (this.hil != null) {
                if (this.hiq != null) {
                    this.hiq.b(view, this.hil);
                }
                W(this.hil.bce());
            }
        } else if (view == this.hij.getView()) {
            if (this.him != null) {
                if (this.hiq != null) {
                    this.hiq.b(view, this.him);
                }
                W(this.him.bce());
            }
        } else if (view == this.hik.getView() && this.hin != null) {
            if (this.hiq != null) {
                this.hiq.b(view, this.hin);
            }
            W(this.hin.bce());
        }
    }

    private void W(bw bwVar) {
        PbActivityConfig createFromThreadCfg = new PbActivityConfig(getTbPageContext().getPageActivity()).createFromThreadCfg(bwVar, null, m.beq(), RequestResponseCode.REQUEST_FRS_TO_PB, true, false, false);
        createFromThreadCfg.setForumId(String.valueOf(bwVar.getFid()));
        createFromThreadCfg.setForumName(bwVar.beI());
        createFromThreadCfg.setStartFrom(0);
        m.GY(bwVar.getTid());
        getTbPageContext().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
    }

    public void a(a aVar) {
        this.hiq = aVar;
    }
}
