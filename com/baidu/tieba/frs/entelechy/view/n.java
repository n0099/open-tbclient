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
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.d;
import com.xiaomi.mipush.sdk.Constants;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.TimeUnit;
/* loaded from: classes3.dex */
public class n extends l {
    private RelativeLayout dNb;
    private TextView dNc;
    private TextView dNd;
    private TextView dNe;

    public n(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        View view = getView();
        this.dNb = (RelativeLayout) view.findViewById(d.g.lottery_info_layout);
        this.dNc = (TextView) view.findViewById(d.g.lottery_time_tv);
        this.dNd = (TextView) view.findViewById(d.g.lottery_join_count_tv);
        this.dNe = (TextView) view.findViewById(d.g.lottery_btn);
    }

    @Override // com.baidu.tieba.frs.entelechy.view.l, com.baidu.tieba.card.a
    public int getLayout() {
        return d.h.card_frs_lottery_new_frame;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.frs.entelechy.view.l, com.baidu.tieba.card.a
    /* renamed from: B */
    public void a(bd bdVar) {
        if (bdVar != null) {
            if (v.D(bdVar.zy()) > 1) {
                ArrayList<MediaData> arrayList = new ArrayList<>();
                arrayList.add(bdVar.zy().get(0));
                bdVar.k(arrayList);
            }
            super.a(bdVar);
            this.cXf.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.frs.entelechy.view.n.1
                @Override // com.baidu.tbadk.widget.layout.d
                public void f(View view, int i, boolean z) {
                    if (n.this.aZM != null && n.this.aaq()) {
                        aw.Du().c(n.this.mTbPageContext, new String[]{n.this.aZM.getActUrl()});
                    }
                }
            });
            com.baidu.tbadk.core.data.a aVar = (com.baidu.tbadk.core.data.a) v.f(bdVar.zz(), 0);
            if (aVar != null) {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy.MM.dd");
                this.dNc.setText(StringUtils.string(getContext().getResources().getString(d.j.lottery_time), "  ", simpleDateFormat.format(new Date(TimeUnit.SECONDS.toMillis(aVar.xF()))), Constants.ACCEPT_TIME_SEPARATOR_SERVER, simpleDateFormat.format(new Date(TimeUnit.SECONDS.toMillis(aVar.xG())))));
                this.dNd.setText(String.format(getContext().getResources().getString(d.j.lottery_join_num), String.valueOf(aVar.xH())));
                this.dNe.setText(d.j.lottery_btn_text);
                this.cmk.setCommentNumEnable(false);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.view.l
    protected void eI(boolean z) {
        if (this.aZM != null && aaq()) {
            aw.Du().c(this.mTbPageContext, new String[]{this.aZM.getActUrl()});
        }
    }

    protected boolean aaq() {
        if (TbadkCoreApplication.isLogin()) {
            return true;
        }
        ay.aZ(this.mTbPageContext.getPageActivity());
        return false;
    }

    @Override // com.baidu.tieba.frs.entelechy.view.l, com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.t(this.dNb, d.C0140d.cp_bg_line_e);
            aj.r(this.dNc, d.C0140d.cp_cont_f);
            aj.r(this.dNd, d.C0140d.cp_cont_f);
            aj.r(this.dNe, d.C0140d.cp_link_tip_a);
            aj.s(this.dNe, d.f.bg_card_frs_lottery_btn);
        }
        super.d(tbPageContext, i);
    }
}
