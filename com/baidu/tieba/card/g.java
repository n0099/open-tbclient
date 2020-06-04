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
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes9.dex */
public class g extends b<com.baidu.tieba.e.d> {
    private LinearLayout gCQ;
    private TextView gCR;
    private LinearLayout gCS;
    private e gCT;
    private f gCU;
    private f gCV;
    private com.baidu.tieba.e.a gCW;
    private com.baidu.tieba.e.b gCX;
    private com.baidu.tieba.e.b gCY;
    private View gCZ;
    private View gDa;
    private a gDb;
    private String mForumId;

    /* loaded from: classes9.dex */
    public interface a {
        void b(View view, com.baidu.tieba.card.data.b bVar);
    }

    public g(TbPageContext<?> tbPageContext, String str) {
        super(tbPageContext);
        this.mForumId = str;
        init(getView());
    }

    private void init(View view) {
        this.gCQ = (LinearLayout) view.findViewById(R.id.card_frs_game_head_line_layout);
        this.gCR = (TextView) view.findViewById(R.id.frs_game_head_line_title);
        this.gCS = (LinearLayout) view.findViewById(R.id.frs_game_head_line_container);
        this.gCZ = view.findViewById(R.id.divider_line_1);
        this.gDa = view.findViewById(R.id.divider_line_2);
        int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds44);
        if (this.gCT == null) {
            this.gCT = new e(this.mTbPageContext, null, null);
        }
        this.gCT.w(0, 0, 0, 0);
        this.gCT.sm(8);
        this.gCT.sn(8);
        if (this.gCT.getView().getParent() != null) {
            ((ViewGroup) this.gCT.getView().getParent()).removeView(this.gCT.getView());
        }
        this.gCT.getView().setOnClickListener(this);
        this.gCT.getView().setVisibility(8);
        this.gCS.addView(this.gCT.getView());
        if (this.gCU == null) {
            this.gCU = new f(this.mTbPageContext);
        }
        this.gCU.sn(8);
        this.gCU.x(0, dimensionPixelSize, 0, 0);
        if (this.gCU.getView().getParent() != null) {
            ((ViewGroup) this.gCU.getView().getParent()).removeView(this.gCU.getView());
        }
        this.gCU.getView().setOnClickListener(this);
        this.gCU.getView().setVisibility(8);
        this.gCS.addView(this.gCU.getView());
        if (this.gCV == null) {
            this.gCV = new f(this.mTbPageContext);
        }
        this.gCV.sn(8);
        this.gCV.x(0, dimensionPixelSize, 0, 0);
        if (this.gCV.getView().getParent() != null) {
            ((ViewGroup) this.gCV.getView().getParent()).removeView(this.gCV.getView());
        }
        this.gCV.getView().setOnClickListener(this);
        this.gCV.getView().setVisibility(8);
        this.gCS.addView(this.gCV.getView());
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        am.setBackgroundResource(getView(), R.color.cp_bg_line_d);
        am.setViewTextColor(this.gCR, R.color.cp_cont_f, 1);
        am.setBackgroundResource(this.gCZ, R.color.cp_bg_line_e);
        am.setBackgroundResource(this.gDa, R.color.cp_bg_line_e);
        if (this.gCT != null) {
            this.gCT.onChangeSkinType(tbPageContext, i);
        }
        if (this.gCU != null) {
            this.gCU.onChangeSkinType(tbPageContext, i);
        }
        if (this.gCV != null) {
            this.gCV.onChangeSkinType(tbPageContext, i);
        }
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.card_frs_game_head_line_view_item;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.e.d dVar) {
        if (dVar != null && dVar.bMO() != null) {
            if (!TextUtils.isEmpty(dVar.bMO().title)) {
                this.gCR.setText(dVar.bMO().title);
            }
            List<bk> list = dVar.bMO().sub_nodes;
            if (com.baidu.tbadk.core.util.v.getCount(list) >= 1) {
                this.gCW = new com.baidu.tieba.e.a();
                this.gCW.setData(list.get(0));
                this.gCT.getView().setVisibility(0);
                this.gCT.a(this.gCW);
            }
            if (com.baidu.tbadk.core.util.v.getCount(list) >= 2) {
                this.gCX = new com.baidu.tieba.e.b();
                this.gCX.setData(list.get(1));
                this.gCU.getView().setVisibility(0);
                this.gCU.a(this.gCX);
                this.gCU.so(8);
            }
            if (com.baidu.tbadk.core.util.v.getCount(list) >= 3) {
                this.gCY = new com.baidu.tieba.e.b();
                this.gCY.setData(list.get(2));
                this.gCV.getView().setVisibility(0);
                this.gCV.a(this.gCY);
                this.gCV.so(8);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TiebaStatic.log(new an("c13047").ag("obj_locate", 6).dh("fid", this.mForumId));
        if (view == this.gCT.getView()) {
            if (this.gCW != null) {
                if (this.gDb != null) {
                    this.gDb.b(view, this.gCW);
                }
                Y(this.gCW.aOi());
            }
        } else if (view == this.gCU.getView()) {
            if (this.gCX != null) {
                if (this.gDb != null) {
                    this.gDb.b(view, this.gCX);
                }
                Y(this.gCX.aOi());
            }
        } else if (view == this.gCV.getView() && this.gCY != null) {
            if (this.gDb != null) {
                this.gDb.b(view, this.gCY);
            }
            Y(this.gCY.aOi());
        }
    }

    private void Y(bk bkVar) {
        PbActivityConfig createFromThreadCfg = new PbActivityConfig(getTbPageContext().getPageActivity()).createFromThreadCfg(bkVar, null, m.aQj(), RequestResponseCode.REQUEST_FRS_TO_PB, true, false, false);
        createFromThreadCfg.setForumId(String.valueOf(bkVar.getFid()));
        createFromThreadCfg.setForumName(bkVar.aQC());
        createFromThreadCfg.setStartFrom(0);
        m.Dn(bkVar.getTid());
        getTbPageContext().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
    }

    public void a(a aVar) {
        this.gDb = aVar;
    }
}
