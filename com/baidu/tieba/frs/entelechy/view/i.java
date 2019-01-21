package com.baidu.tieba.frs.entelechy.view;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.e;
import com.xiaomi.mipush.sdk.Constants;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.TimeUnit;
/* loaded from: classes3.dex */
public class i extends e {
    private TextView dVA;
    private TextView dVB;
    private TextView dVC;
    private RelativeLayout dVz;

    public i(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        View view = getView();
        this.dVz = (RelativeLayout) view.findViewById(e.g.lottery_info_layout);
        this.dVA = (TextView) view.findViewById(e.g.lottery_time_tv);
        this.dVB = (TextView) view.findViewById(e.g.lottery_join_count_tv);
        this.dVC = (TextView) view.findViewById(e.g.lottery_btn);
    }

    @Override // com.baidu.tieba.frs.entelechy.view.e, com.baidu.tieba.card.a
    public int getLayout() {
        return e.h.card_frs_lottery_new_frame;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.frs.entelechy.view.e, com.baidu.tieba.card.a
    /* renamed from: F */
    public void a(bb bbVar) {
        if (bbVar != null) {
            if (v.H(bbVar.Ae()) > 1) {
                ArrayList<MediaData> arrayList = new ArrayList<>();
                arrayList.add(bbVar.Ae().get(0));
                bbVar.n(arrayList);
            }
            super.a(bbVar);
            this.cYC.setImageClickListener(new com.baidu.tbadk.widget.layout.c() { // from class: com.baidu.tieba.frs.entelechy.view.i.1
                @Override // com.baidu.tbadk.widget.layout.c
                public void b(View view, int i, boolean z) {
                    if (i.this.aFJ != null && i.this.aef()) {
                        ay.Es().c(i.this.mTbPageContext, new String[]{i.this.aFJ.getActUrl()});
                    }
                }
            });
            com.baidu.tbadk.core.data.a aVar = (com.baidu.tbadk.core.data.a) v.d(bbVar.Af(), 0);
            if (aVar != null) {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy.MM.dd");
                this.dVA.setText(StringUtils.string(getContext().getResources().getString(e.j.lottery_time), "  ", simpleDateFormat.format(new Date(TimeUnit.SECONDS.toMillis(aVar.yl()))), Constants.ACCEPT_TIME_SEPARATOR_SERVER, simpleDateFormat.format(new Date(TimeUnit.SECONDS.toMillis(aVar.ym())))));
                this.dVB.setText(String.format(getContext().getResources().getString(e.j.lottery_join_num), String.valueOf(aVar.yn())));
                this.dVC.setText(e.j.lottery_btn_text);
                this.cby.setCommentNumEnable(false);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.view.e
    protected void fs(boolean z) {
        if (this.aFJ != null && aef()) {
            ay.Es().c(this.mTbPageContext, new String[]{this.aFJ.getActUrl()});
        }
    }

    protected boolean aef() {
        if (TbadkCoreApplication.isLogin()) {
            return true;
        }
        ba.bI(this.mTbPageContext.getPageActivity());
        return false;
    }

    @Override // com.baidu.tieba.frs.entelechy.view.e, com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.j(this.dVz, e.d.cp_bg_line_e);
            al.h(this.dVA, e.d.cp_cont_f);
            al.h(this.dVB, e.d.cp_cont_f);
            al.h(this.dVC, e.d.cp_link_tip_a);
            al.i(this.dVC, e.f.bg_card_frs_lottery_btn);
        }
        super.d(tbPageContext, i);
    }
}
