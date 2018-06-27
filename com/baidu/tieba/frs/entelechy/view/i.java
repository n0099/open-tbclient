package com.baidu.tieba.frs.entelechy.view;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.bc;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.core.util.bb;
import com.baidu.tbadk.core.util.w;
import com.baidu.tieba.d;
import com.xiaomi.mipush.sdk.Constants;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.TimeUnit;
/* loaded from: classes3.dex */
public class i extends e {
    private RelativeLayout dsZ;
    private TextView dta;
    private TextView dtb;
    private TextView dtc;

    public i(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        View view = getView();
        this.dsZ = (RelativeLayout) view.findViewById(d.g.lottery_info_layout);
        this.dta = (TextView) view.findViewById(d.g.lottery_time_tv);
        this.dtb = (TextView) view.findViewById(d.g.lottery_join_count_tv);
        this.dtc = (TextView) view.findViewById(d.g.lottery_btn);
    }

    @Override // com.baidu.tieba.frs.entelechy.view.e, com.baidu.tieba.card.a
    public int getLayout() {
        return d.i.card_frs_lottery_new_frame;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.frs.entelechy.view.e, com.baidu.tieba.card.a
    /* renamed from: C */
    public void a(bc bcVar) {
        if (bcVar != null) {
            if (w.z(bcVar.vG()) > 1) {
                ArrayList<MediaData> arrayList = new ArrayList<>();
                arrayList.add(bcVar.vG().get(0));
                bcVar.n(arrayList);
            }
            super.a(bcVar);
            this.cwB.setImageClickListener(new com.baidu.tbadk.widget.layout.c() { // from class: com.baidu.tieba.frs.entelechy.view.i.1
                @Override // com.baidu.tbadk.widget.layout.c
                public void c(View view, int i, boolean z) {
                    if (i.this.atZ != null && i.this.WM()) {
                        az.zV().c(i.this.mTbPageContext, new String[]{i.this.atZ.getActUrl()});
                    }
                }
            });
            com.baidu.tbadk.core.data.a aVar = (com.baidu.tbadk.core.data.a) w.d(bcVar.vH(), 0);
            if (aVar != null) {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy.MM.dd");
                this.dta.setText(StringUtils.string(getContext().getResources().getString(d.k.lottery_time), "  ", simpleDateFormat.format(new Date(TimeUnit.SECONDS.toMillis(aVar.tP()))), Constants.ACCEPT_TIME_SEPARATOR_SERVER, simpleDateFormat.format(new Date(TimeUnit.SECONDS.toMillis(aVar.tQ())))));
                this.dtb.setText(String.format(getContext().getResources().getString(d.k.lottery_join_num), String.valueOf(aVar.tR())));
                this.dtc.setText(d.k.lottery_btn_text);
                this.bGZ.setCommentNumEnable(false);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.view.e
    protected void er(boolean z) {
        if (this.atZ != null && WM()) {
            az.zV().c(this.mTbPageContext, new String[]{this.atZ.getActUrl()});
        }
    }

    protected boolean WM() {
        if (TbadkCoreApplication.isLogin()) {
            return true;
        }
        bb.aT(this.mTbPageContext.getPageActivity());
        return false;
    }

    @Override // com.baidu.tieba.frs.entelechy.view.e, com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.j(this.dsZ, d.C0142d.cp_bg_line_e);
            am.h(this.dta, d.C0142d.cp_cont_f);
            am.h(this.dtb, d.C0142d.cp_cont_f);
            am.h(this.dtc, d.C0142d.cp_link_tip_a);
            am.i(this.dtc, d.f.bg_card_frs_lottery_btn);
        }
        super.d(tbPageContext, i);
    }
}
