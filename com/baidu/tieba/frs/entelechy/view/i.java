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
import com.baidu.tbadk.core.util.am;
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
    private RelativeLayout dvN;
    private TextView dvO;
    private TextView dvP;
    private TextView dvQ;

    public i(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        View view = getView();
        this.dvN = (RelativeLayout) view.findViewById(d.g.lottery_info_layout);
        this.dvO = (TextView) view.findViewById(d.g.lottery_time_tv);
        this.dvP = (TextView) view.findViewById(d.g.lottery_join_count_tv);
        this.dvQ = (TextView) view.findViewById(d.g.lottery_btn);
    }

    @Override // com.baidu.tieba.frs.entelechy.view.e, com.baidu.tieba.card.a
    public int getLayout() {
        return d.h.card_frs_lottery_new_frame;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.frs.entelechy.view.e, com.baidu.tieba.card.a
    /* renamed from: E */
    public void a(bb bbVar) {
        if (bbVar != null) {
            if (w.y(bbVar.vv()) > 1) {
                ArrayList<MediaData> arrayList = new ArrayList<>();
                arrayList.add(bbVar.vv().get(0));
                bbVar.n(arrayList);
            }
            super.a(bbVar);
            this.cze.setImageClickListener(new com.baidu.tbadk.widget.layout.c() { // from class: com.baidu.tieba.frs.entelechy.view.i.1
                @Override // com.baidu.tbadk.widget.layout.c
                public void c(View view, int i, boolean z) {
                    if (i.this.atD != null && i.this.WV()) {
                        ay.zK().c(i.this.mTbPageContext, new String[]{i.this.atD.getActUrl()});
                    }
                }
            });
            com.baidu.tbadk.core.data.a aVar = (com.baidu.tbadk.core.data.a) w.d(bbVar.vw(), 0);
            if (aVar != null) {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy.MM.dd");
                this.dvO.setText(StringUtils.string(getContext().getResources().getString(d.j.lottery_time), "  ", simpleDateFormat.format(new Date(TimeUnit.SECONDS.toMillis(aVar.tB()))), Constants.ACCEPT_TIME_SEPARATOR_SERVER, simpleDateFormat.format(new Date(TimeUnit.SECONDS.toMillis(aVar.tC())))));
                this.dvP.setText(String.format(getContext().getResources().getString(d.j.lottery_join_num), String.valueOf(aVar.tD())));
                this.dvQ.setText(d.j.lottery_btn_text);
                this.bHO.setCommentNumEnable(false);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.view.e
    protected void es(boolean z) {
        if (this.atD != null && WV()) {
            ay.zK().c(this.mTbPageContext, new String[]{this.atD.getActUrl()});
        }
    }

    protected boolean WV() {
        if (TbadkCoreApplication.isLogin()) {
            return true;
        }
        ba.aU(this.mTbPageContext.getPageActivity());
        return false;
    }

    @Override // com.baidu.tieba.frs.entelechy.view.e, com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.j(this.dvN, d.C0140d.cp_bg_line_e);
            am.h(this.dvO, d.C0140d.cp_cont_f);
            am.h(this.dvP, d.C0140d.cp_cont_f);
            am.h(this.dvQ, d.C0140d.cp_link_tip_a);
            am.i(this.dvQ, d.f.bg_card_frs_lottery_btn);
        }
        super.d(tbPageContext, i);
    }
}
