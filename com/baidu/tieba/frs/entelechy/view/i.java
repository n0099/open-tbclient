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
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.core.util.w;
import com.baidu.tieba.f;
import com.xiaomi.mipush.sdk.Constants;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.TimeUnit;
/* loaded from: classes3.dex */
public class i extends e {
    private RelativeLayout dvK;
    private TextView dvL;
    private TextView dvM;
    private TextView dvN;

    public i(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        View view = getView();
        this.dvK = (RelativeLayout) view.findViewById(f.g.lottery_info_layout);
        this.dvL = (TextView) view.findViewById(f.g.lottery_time_tv);
        this.dvM = (TextView) view.findViewById(f.g.lottery_join_count_tv);
        this.dvN = (TextView) view.findViewById(f.g.lottery_btn);
    }

    @Override // com.baidu.tieba.frs.entelechy.view.e, com.baidu.tieba.card.a
    public int getLayout() {
        return f.h.card_frs_lottery_new_frame;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.frs.entelechy.view.e, com.baidu.tieba.card.a
    /* renamed from: E */
    public void a(bb bbVar) {
        if (bbVar != null) {
            if (w.y(bbVar.vu()) > 1) {
                ArrayList<MediaData> arrayList = new ArrayList<>();
                arrayList.add(bbVar.vu().get(0));
                bbVar.n(arrayList);
            }
            super.a(bbVar);
            this.czb.setImageClickListener(new com.baidu.tbadk.widget.layout.c() { // from class: com.baidu.tieba.frs.entelechy.view.i.1
                @Override // com.baidu.tbadk.widget.layout.c
                public void b(View view, int i, boolean z) {
                    if (i.this.atE != null && i.this.WY()) {
                        az.zI().c(i.this.mTbPageContext, new String[]{i.this.atE.getActUrl()});
                    }
                }
            });
            com.baidu.tbadk.core.data.a aVar = (com.baidu.tbadk.core.data.a) w.d(bbVar.vv(), 0);
            if (aVar != null) {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy.MM.dd");
                this.dvL.setText(StringUtils.string(getContext().getResources().getString(f.j.lottery_time), "  ", simpleDateFormat.format(new Date(TimeUnit.SECONDS.toMillis(aVar.tA()))), Constants.ACCEPT_TIME_SEPARATOR_SERVER, simpleDateFormat.format(new Date(TimeUnit.SECONDS.toMillis(aVar.tB())))));
                this.dvM.setText(String.format(getContext().getResources().getString(f.j.lottery_join_num), String.valueOf(aVar.tC())));
                this.dvN.setText(f.j.lottery_btn_text);
                this.bHO.setCommentNumEnable(false);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.view.e
    protected void es(boolean z) {
        if (this.atE != null && WY()) {
            az.zI().c(this.mTbPageContext, new String[]{this.atE.getActUrl()});
        }
    }

    protected boolean WY() {
        if (TbadkCoreApplication.isLogin()) {
            return true;
        }
        com.baidu.tbadk.core.util.bb.aT(this.mTbPageContext.getPageActivity());
        return false;
    }

    @Override // com.baidu.tieba.frs.entelechy.view.e, com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.j(this.dvK, f.d.cp_bg_line_e);
            am.h(this.dvL, f.d.cp_cont_f);
            am.h(this.dvM, f.d.cp_cont_f);
            am.h(this.dvN, f.d.cp_link_tip_a);
            am.i(this.dvN, f.C0146f.bg_card_frs_lottery_btn);
        }
        super.d(tbPageContext, i);
    }
}
