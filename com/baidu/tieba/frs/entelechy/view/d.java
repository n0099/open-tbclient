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
    private RelativeLayout fjf;
    private TextView fjg;
    private TextView fjh;
    private TextView fji;

    public d(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        View view = getView();
        this.fjf = (RelativeLayout) view.findViewById(d.g.lottery_info_layout);
        this.fjg = (TextView) view.findViewById(d.g.lottery_time_tv);
        this.fjh = (TextView) view.findViewById(d.g.lottery_join_count_tv);
        this.fji = (TextView) view.findViewById(d.g.lottery_btn);
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
            if (v.S(bgVar.Zb()) > 1) {
                ArrayList<MediaData> arrayList = new ArrayList<>();
                arrayList.add(bgVar.Zb().get(0));
                bgVar.p(arrayList);
            }
            super.a(bgVar);
            this.ein.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.frs.entelechy.view.d.1
                @Override // com.baidu.tbadk.widget.layout.d
                public void a(View view, int i, boolean z) {
                    if (d.this.XS != null && d.this.aFa()) {
                        ba.adD().c(d.this.mTbPageContext, new String[]{d.this.XS.getActUrl()});
                    }
                }
            });
            com.baidu.tbadk.core.data.b bVar = (com.baidu.tbadk.core.data.b) v.c(bgVar.Zc(), 0);
            if (bVar != null) {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy.MM.dd");
                this.fjg.setText(StringUtils.string(getContext().getResources().getString(d.j.lottery_time), "  ", simpleDateFormat.format(new Date(TimeUnit.SECONDS.toMillis(bVar.WW()))), Constants.ACCEPT_TIME_SEPARATOR_SERVER, simpleDateFormat.format(new Date(TimeUnit.SECONDS.toMillis(bVar.WX())))));
                this.fjh.setText(String.format(getContext().getResources().getString(d.j.lottery_join_num), String.valueOf(bVar.WY())));
                this.fji.setText(d.j.lottery_btn_text);
                this.dqv.setCommentNumEnable(false);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.view.c
    protected void hL(boolean z) {
        if (this.XS != null && aFa()) {
            ba.adD().c(this.mTbPageContext, new String[]{this.XS.getActUrl()});
        }
    }

    protected boolean aFa() {
        if (TbadkCoreApplication.isLogin()) {
            return true;
        }
        bc.cY(this.mTbPageContext.getPageActivity());
        return false;
    }

    @Override // com.baidu.tieba.frs.entelechy.view.c, com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.l(this.fjf, d.C0277d.cp_bg_line_e);
            al.j(this.fjg, d.C0277d.cp_cont_f);
            al.j(this.fjh, d.C0277d.cp_cont_f);
            al.j(this.fji, d.C0277d.cp_link_tip_a);
            al.k(this.fji, d.f.bg_card_frs_lottery_btn);
        }
        super.onChangeSkinType(tbPageContext, i);
    }
}
