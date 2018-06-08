package com.baidu.tieba.frs.entelechy.view;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.w;
import com.baidu.tieba.d;
import com.xiaomi.mipush.sdk.Constants;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.TimeUnit;
/* loaded from: classes3.dex */
public class i extends e {
    private RelativeLayout dpQ;
    private TextView dpR;
    private TextView dpS;
    private TextView dpT;

    public i(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        View view = getView();
        this.dpQ = (RelativeLayout) view.findViewById(d.g.lottery_info_layout);
        this.dpR = (TextView) view.findViewById(d.g.lottery_time_tv);
        this.dpS = (TextView) view.findViewById(d.g.lottery_join_count_tv);
        this.dpT = (TextView) view.findViewById(d.g.lottery_btn);
    }

    @Override // com.baidu.tieba.frs.entelechy.view.e, com.baidu.tieba.card.a
    public int getLayout() {
        return d.i.card_frs_lottery_new_frame;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.frs.entelechy.view.e, com.baidu.tieba.card.a
    /* renamed from: A */
    public void a(bd bdVar) {
        if (bdVar != null) {
            if (w.y(bdVar.vw()) > 1) {
                ArrayList<MediaData> arrayList = new ArrayList<>();
                arrayList.add(bdVar.vw().get(0));
                bdVar.j(arrayList);
            }
            super.a(bdVar);
            this.cyH.setImageClickListener(new com.baidu.tbadk.widget.layout.c() { // from class: com.baidu.tieba.frs.entelechy.view.i.1
                @Override // com.baidu.tbadk.widget.layout.c
                public void c(View view, int i, boolean z) {
                    if (i.this.atn != null && i.this.Wr()) {
                        ay.zG().c(i.this.mTbPageContext, new String[]{i.this.atn.getActUrl()});
                    }
                }
            });
            com.baidu.tbadk.core.data.a aVar = (com.baidu.tbadk.core.data.a) w.c(bdVar.vx(), 0);
            if (aVar != null) {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy.MM.dd");
                this.dpR.setText(StringUtils.string(getContext().getResources().getString(d.k.lottery_time), "  ", simpleDateFormat.format(new Date(TimeUnit.SECONDS.toMillis(aVar.tJ()))), Constants.ACCEPT_TIME_SEPARATOR_SERVER, simpleDateFormat.format(new Date(TimeUnit.SECONDS.toMillis(aVar.tK())))));
                this.dpS.setText(String.format(getContext().getResources().getString(d.k.lottery_join_num), String.valueOf(aVar.tL())));
                this.dpT.setText(d.k.lottery_btn_text);
                this.bFe.setCommentNumEnable(false);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.view.e
    protected void es(boolean z) {
        if (this.atn != null && Wr()) {
            ay.zG().c(this.mTbPageContext, new String[]{this.atn.getActUrl()});
        }
    }

    protected boolean Wr() {
        if (TbadkCoreApplication.isLogin()) {
            return true;
        }
        ba.aT(this.mTbPageContext.getPageActivity());
        return false;
    }

    @Override // com.baidu.tieba.frs.entelechy.view.e, com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.j(this.dpQ, d.C0141d.cp_bg_line_e);
            al.h(this.dpR, d.C0141d.cp_cont_f);
            al.h(this.dpS, d.C0141d.cp_cont_f);
            al.h(this.dpT, d.C0141d.cp_link_tip_a);
            al.i(this.dpT, d.f.bg_card_frs_lottery_btn);
        }
        super.d(tbPageContext, i);
    }
}
