package com.baidu.tieba.frs.entelechy.view;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.d;
import com.xiaomi.mipush.sdk.Constants;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.TimeUnit;
/* loaded from: classes4.dex */
public class d extends c {
    private RelativeLayout fiR;
    private TextView fiS;
    private TextView fiT;
    private TextView fiU;

    public d(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        View view = getView();
        this.fiR = (RelativeLayout) view.findViewById(d.g.lottery_info_layout);
        this.fiS = (TextView) view.findViewById(d.g.lottery_time_tv);
        this.fiT = (TextView) view.findViewById(d.g.lottery_join_count_tv);
        this.fiU = (TextView) view.findViewById(d.g.lottery_btn);
    }

    @Override // com.baidu.tieba.frs.entelechy.view.c, com.baidu.tieba.card.a
    public int getLayout() {
        return d.h.card_frs_lottery_new_frame;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tieba.frs.entelechy.view.c, com.baidu.tieba.card.a
    public void a(bg bgVar) {
        if (bgVar != null) {
            if (v.S(bgVar.YY()) > 1) {
                ArrayList<MediaData> arrayList = new ArrayList<>();
                arrayList.add(bgVar.YY().get(0));
                bgVar.p(arrayList);
            }
            super.a(bgVar);
            this.eia.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.frs.entelechy.view.d.1
                @Override // com.baidu.tbadk.widget.layout.d
                public void a(View view, int i, boolean z) {
                    if (d.this.XT != null && d.this.aEY()) {
                        ba.adA().c(d.this.mTbPageContext, new String[]{d.this.XT.getActUrl()});
                    }
                }
            });
            com.baidu.tbadk.core.data.b bVar = (com.baidu.tbadk.core.data.b) v.c(bgVar.YZ(), 0);
            if (bVar != null) {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy.MM.dd");
                this.fiS.setText(StringUtils.string(getContext().getResources().getString(d.j.lottery_time), "  ", simpleDateFormat.format(new Date(TimeUnit.SECONDS.toMillis(bVar.WT()))), Constants.ACCEPT_TIME_SEPARATOR_SERVER, simpleDateFormat.format(new Date(TimeUnit.SECONDS.toMillis(bVar.WU())))));
                this.fiT.setText(String.format(getContext().getResources().getString(d.j.lottery_join_num), String.valueOf(bVar.WV())));
                this.fiU.setText(d.j.lottery_btn_text);
                this.dqz.setCommentNumEnable(false);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.view.c
    protected void hL(boolean z) {
        if (this.XT != null && aEY()) {
            ba.adA().c(this.mTbPageContext, new String[]{this.XT.getActUrl()});
        }
    }

    protected boolean aEY() {
        if (TbadkCoreApplication.isLogin()) {
            return true;
        }
        bc.cY(this.mTbPageContext.getPageActivity());
        return false;
    }

    @Override // com.baidu.tieba.frs.entelechy.view.c, com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.l(this.fiR, d.C0277d.cp_bg_line_e);
            al.j(this.fiS, d.C0277d.cp_cont_f);
            al.j(this.fiT, d.C0277d.cp_cont_f);
            al.j(this.fiU, d.C0277d.cp_link_tip_a);
            al.k(this.fiU, d.f.bg_card_frs_lottery_btn);
        }
        super.onChangeSkinType(tbPageContext, i);
    }
}
