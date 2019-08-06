package com.baidu.tieba.frs.entelechy.view;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.bb;
import com.baidu.tbadk.core.util.bd;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.R;
import com.xiaomi.mipush.sdk.Constants;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.TimeUnit;
/* loaded from: classes4.dex */
public class d extends c {
    private RelativeLayout fEZ;
    private TextView fFa;
    private TextView fFb;
    private TextView fFc;

    public d(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        View view = getView();
        this.fEZ = (RelativeLayout) view.findViewById(R.id.lottery_info_layout);
        this.fFa = (TextView) view.findViewById(R.id.lottery_time_tv);
        this.fFb = (TextView) view.findViewById(R.id.lottery_join_count_tv);
        this.fFc = (TextView) view.findViewById(R.id.lottery_btn);
    }

    @Override // com.baidu.tieba.frs.entelechy.view.c, com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.card_frs_lottery_new_frame;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tieba.frs.entelechy.view.c, com.baidu.tieba.card.a
    public void a(bh bhVar) {
        if (bhVar != null) {
            if (v.Z(bhVar.aeI()) > 1) {
                ArrayList<MediaData> arrayList = new ArrayList<>();
                arrayList.add(bhVar.aeI().get(0));
                bhVar.s(arrayList);
            }
            super.a(bhVar);
            this.eCT.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.frs.entelechy.view.d.1
                @Override // com.baidu.tbadk.widget.layout.d
                public void a(View view, int i, boolean z) {
                    if (d.this.We != null && d.this.aMS()) {
                        bb.ajE().c(d.this.mTbPageContext, new String[]{d.this.We.getActUrl()});
                    }
                }
            });
            com.baidu.tbadk.core.data.b bVar = (com.baidu.tbadk.core.data.b) v.c(bhVar.aeJ(), 0);
            if (bVar != null) {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy.MM.dd");
                this.fFa.setText(StringUtils.string(getContext().getResources().getString(R.string.lottery_time), "  ", simpleDateFormat.format(new Date(TimeUnit.SECONDS.toMillis(bVar.acD()))), Constants.ACCEPT_TIME_SEPARATOR_SERVER, simpleDateFormat.format(new Date(TimeUnit.SECONDS.toMillis(bVar.acE())))));
                this.fFb.setText(String.format(getContext().getResources().getString(R.string.lottery_join_num), String.valueOf(bVar.acF())));
                this.fFc.setText(R.string.lottery_btn_text);
                this.dEI.setCommentNumEnable(false);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.view.c
    protected void iz(boolean z) {
        if (this.We != null && aMS()) {
            bb.ajE().c(this.mTbPageContext, new String[]{this.We.getActUrl()});
        }
    }

    protected boolean aMS() {
        if (TbadkCoreApplication.isLogin()) {
            return true;
        }
        bd.cE(this.mTbPageContext.getPageActivity());
        return false;
    }

    @Override // com.baidu.tieba.frs.entelechy.view.c, com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.l(this.fEZ, R.color.cp_bg_line_e);
            am.j(this.fFa, R.color.cp_cont_f);
            am.j(this.fFb, R.color.cp_cont_f);
            am.j(this.fFc, R.color.cp_link_tip_a);
            am.k(this.fFc, R.drawable.bg_card_frs_lottery_btn);
        }
        super.onChangeSkinType(tbPageContext, i);
    }
}
