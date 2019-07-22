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
    private RelativeLayout fEl;
    private TextView fEm;
    private TextView fEn;
    private TextView fEo;

    public d(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        View view = getView();
        this.fEl = (RelativeLayout) view.findViewById(R.id.lottery_info_layout);
        this.fEm = (TextView) view.findViewById(R.id.lottery_time_tv);
        this.fEn = (TextView) view.findViewById(R.id.lottery_join_count_tv);
        this.fEo = (TextView) view.findViewById(R.id.lottery_btn);
    }

    @Override // com.baidu.tieba.frs.entelechy.view.c, com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.card_frs_lottery_new_frame;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tieba.frs.entelechy.view.c, com.baidu.tieba.card.a
    public void a(bg bgVar) {
        if (bgVar != null) {
            if (v.Z(bgVar.aeH()) > 1) {
                ArrayList<MediaData> arrayList = new ArrayList<>();
                arrayList.add(bgVar.aeH().get(0));
                bgVar.s(arrayList);
            }
            super.a(bgVar);
            this.eCM.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.frs.entelechy.view.d.1
                @Override // com.baidu.tbadk.widget.layout.d
                public void a(View view, int i, boolean z) {
                    if (d.this.We != null && d.this.aMQ()) {
                        bb.ajC().c(d.this.mTbPageContext, new String[]{d.this.We.getActUrl()});
                    }
                }
            });
            com.baidu.tbadk.core.data.b bVar = (com.baidu.tbadk.core.data.b) v.c(bgVar.aeI(), 0);
            if (bVar != null) {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy.MM.dd");
                this.fEm.setText(StringUtils.string(getContext().getResources().getString(R.string.lottery_time), "  ", simpleDateFormat.format(new Date(TimeUnit.SECONDS.toMillis(bVar.acC()))), Constants.ACCEPT_TIME_SEPARATOR_SERVER, simpleDateFormat.format(new Date(TimeUnit.SECONDS.toMillis(bVar.acD())))));
                this.fEn.setText(String.format(getContext().getResources().getString(R.string.lottery_join_num), String.valueOf(bVar.acE())));
                this.fEo.setText(R.string.lottery_btn_text);
                this.dEB.setCommentNumEnable(false);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.view.c
    protected void iz(boolean z) {
        if (this.We != null && aMQ()) {
            bb.ajC().c(this.mTbPageContext, new String[]{this.We.getActUrl()});
        }
    }

    protected boolean aMQ() {
        if (TbadkCoreApplication.isLogin()) {
            return true;
        }
        bd.cE(this.mTbPageContext.getPageActivity());
        return false;
    }

    @Override // com.baidu.tieba.frs.entelechy.view.c, com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.l(this.fEl, R.color.cp_bg_line_e);
            am.j(this.fEm, R.color.cp_cont_f);
            am.j(this.fEn, R.color.cp_cont_f);
            am.j(this.fEo, R.color.cp_link_tip_a);
            am.k(this.fEo, R.drawable.bg_card_frs_lottery_btn);
        }
        super.onChangeSkinType(tbPageContext, i);
    }
}
