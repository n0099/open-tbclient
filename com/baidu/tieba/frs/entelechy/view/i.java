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
    private RelativeLayout dKu;
    private TextView dKv;
    private TextView dKw;
    private TextView dKx;

    public i(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        View view = getView();
        this.dKu = (RelativeLayout) view.findViewById(e.g.lottery_info_layout);
        this.dKv = (TextView) view.findViewById(e.g.lottery_time_tv);
        this.dKw = (TextView) view.findViewById(e.g.lottery_join_count_tv);
        this.dKx = (TextView) view.findViewById(e.g.lottery_btn);
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
            if (v.I(bbVar.yG()) > 1) {
                ArrayList<MediaData> arrayList = new ArrayList<>();
                arrayList.add(bbVar.yG().get(0));
                bbVar.n(arrayList);
            }
            super.a(bbVar);
            this.cNn.setImageClickListener(new com.baidu.tbadk.widget.layout.c() { // from class: com.baidu.tieba.frs.entelechy.view.i.1
                @Override // com.baidu.tbadk.widget.layout.c
                public void b(View view, int i, boolean z) {
                    if (i.this.aAQ != null && i.this.act()) {
                        ay.CU().c(i.this.mTbPageContext, new String[]{i.this.aAQ.getActUrl()});
                    }
                }
            });
            com.baidu.tbadk.core.data.a aVar = (com.baidu.tbadk.core.data.a) v.d(bbVar.yH(), 0);
            if (aVar != null) {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy.MM.dd");
                this.dKv.setText(StringUtils.string(getContext().getResources().getString(e.j.lottery_time), "  ", simpleDateFormat.format(new Date(TimeUnit.SECONDS.toMillis(aVar.wM()))), Constants.ACCEPT_TIME_SEPARATOR_SERVER, simpleDateFormat.format(new Date(TimeUnit.SECONDS.toMillis(aVar.wN())))));
                this.dKw.setText(String.format(getContext().getResources().getString(e.j.lottery_join_num), String.valueOf(aVar.wO())));
                this.dKx.setText(e.j.lottery_btn_text);
                this.bWf.setCommentNumEnable(false);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.view.e
    protected void fb(boolean z) {
        if (this.aAQ != null && act()) {
            ay.CU().c(this.mTbPageContext, new String[]{this.aAQ.getActUrl()});
        }
    }

    protected boolean act() {
        if (TbadkCoreApplication.isLogin()) {
            return true;
        }
        ba.bH(this.mTbPageContext.getPageActivity());
        return false;
    }

    @Override // com.baidu.tieba.frs.entelechy.view.e, com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.j(this.dKu, e.d.cp_bg_line_e);
            al.h(this.dKv, e.d.cp_cont_f);
            al.h(this.dKw, e.d.cp_cont_f);
            al.h(this.dKx, e.d.cp_link_tip_a);
            al.i(this.dKx, e.f.bg_card_frs_lottery_btn);
        }
        super.d(tbPageContext, i);
    }
}
