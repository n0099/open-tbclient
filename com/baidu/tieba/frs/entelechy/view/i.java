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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.d;
import com.xiaomi.mipush.sdk.Constants;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.TimeUnit;
/* loaded from: classes3.dex */
public class i extends e {
    private TextView dfA;
    private RelativeLayout dfx;
    private TextView dfy;
    private TextView dfz;

    public i(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        View view2 = getView();
        this.dfx = (RelativeLayout) view2.findViewById(d.g.lottery_info_layout);
        this.dfy = (TextView) view2.findViewById(d.g.lottery_time_tv);
        this.dfz = (TextView) view2.findViewById(d.g.lottery_join_count_tv);
        this.dfA = (TextView) view2.findViewById(d.g.lottery_btn);
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
            if (v.v(bdVar.sa()) > 1) {
                ArrayList<MediaData> arrayList = new ArrayList<>();
                arrayList.add(bdVar.sa().get(0));
                bdVar.j(arrayList);
            }
            super.a(bdVar);
            this.coX.setImageClickListener(new com.baidu.tbadk.widget.layout.c() { // from class: com.baidu.tieba.frs.entelechy.view.i.1
                @Override // com.baidu.tbadk.widget.layout.c
                public void c(View view2, int i, boolean z) {
                    if (i.this.alf != null && i.this.SO()) {
                        ax.wg().c(i.this.mTbPageContext, new String[]{i.this.alf.getActUrl()});
                    }
                }
            });
            com.baidu.tbadk.core.data.a aVar = (com.baidu.tbadk.core.data.a) v.c(bdVar.sb(), 0);
            if (aVar != null) {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy.MM.dd");
                this.dfy.setText(StringUtils.string(getContext().getResources().getString(d.k.lottery_time), "  ", simpleDateFormat.format(new Date(TimeUnit.SECONDS.toMillis(aVar.qo()))), Constants.ACCEPT_TIME_SEPARATOR_SERVER, simpleDateFormat.format(new Date(TimeUnit.SECONDS.toMillis(aVar.qp())))));
                this.dfz.setText(String.format(getContext().getResources().getString(d.k.lottery_join_num), String.valueOf(aVar.qq())));
                this.dfA.setText(d.k.lottery_btn_text);
                this.bwk.setCommentNumEnable(false);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.view.e
    protected void en(boolean z) {
        if (this.alf != null && SO()) {
            ax.wg().c(this.mTbPageContext, new String[]{this.alf.getActUrl()});
        }
    }

    protected boolean SO() {
        if (TbadkCoreApplication.isLogin()) {
            return true;
        }
        az.aJ(this.mTbPageContext.getPageActivity());
        return false;
    }

    @Override // com.baidu.tieba.frs.entelechy.view.e, com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ak.j(this.dfx, d.C0126d.cp_bg_line_e);
            ak.h(this.dfy, d.C0126d.cp_cont_f);
            ak.h(this.dfz, d.C0126d.cp_cont_f);
            ak.h(this.dfA, d.C0126d.cp_link_tip_a);
            ak.i(this.dfA, d.f.bg_card_frs_lottery_btn);
        }
        super.d(tbPageContext, i);
    }
}
