package com.baidu.tieba.frs.entelechy.view;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.R;
import com.xiaomi.mipush.sdk.Constants;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.TimeUnit;
/* loaded from: classes9.dex */
public class d extends c {
    private TextView hjA;
    private TextView hjB;
    private TextView hjC;
    private RelativeLayout hjz;

    public d(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        View view = getView();
        this.hjz = (RelativeLayout) view.findViewById(R.id.lottery_info_layout);
        this.hjA = (TextView) view.findViewById(R.id.lottery_time_tv);
        this.hjB = (TextView) view.findViewById(R.id.lottery_join_count_tv);
        this.hjC = (TextView) view.findViewById(R.id.lottery_btn);
    }

    @Override // com.baidu.tieba.frs.entelechy.view.c, com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.card_frs_lottery_new_frame;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tieba.frs.entelechy.view.c, com.baidu.tieba.card.a
    public void a(bj bjVar) {
        if (bjVar != null) {
            if (v.getCount(bjVar.aKO()) > 1) {
                ArrayList<MediaData> arrayList = new ArrayList<>();
                arrayList.add(bjVar.aKO().get(0));
                bjVar.z(arrayList);
            }
            super.a(bjVar);
            this.gpr.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.frs.entelechy.view.d.1
                @Override // com.baidu.tbadk.widget.layout.d
                public void b(View view, int i, boolean z) {
                    if (d.this.adG != null && d.this.zA()) {
                        ba.aOY().b(d.this.mTbPageContext, new String[]{d.this.adG.getActUrl()});
                    }
                }
            });
            com.baidu.tbadk.core.data.b bVar = (com.baidu.tbadk.core.data.b) v.getItem(bjVar.aKP(), 0);
            if (bVar != null) {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy.MM.dd");
                this.hjA.setText(StringUtils.string(getContext().getResources().getString(R.string.lottery_time), "  ", simpleDateFormat.format(new Date(TimeUnit.SECONDS.toMillis(bVar.aIB()))), Constants.ACCEPT_TIME_SEPARATOR_SERVER, simpleDateFormat.format(new Date(TimeUnit.SECONDS.toMillis(bVar.aIC())))));
                this.hjB.setText(String.format(getContext().getResources().getString(R.string.lottery_join_num), String.valueOf(bVar.aID())));
                this.hjC.setText(R.string.lottery_btn_text);
                this.fsr.setCommentNumEnable(false);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.view.c
    protected void lr(boolean z) {
        if (this.adG != null && zA()) {
            ba.aOY().b(this.mTbPageContext, new String[]{this.adG.getActUrl()});
        }
    }

    protected boolean zA() {
        if (TbadkCoreApplication.isLogin()) {
            return true;
        }
        bc.skipToLoginActivity(this.mTbPageContext.getPageActivity());
        return false;
    }

    @Override // com.baidu.tieba.frs.entelechy.view.c, com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundColor(this.hjz, R.color.cp_bg_line_e);
            am.setViewTextColor(this.hjA, (int) R.color.cp_cont_f);
            am.setViewTextColor(this.hjB, (int) R.color.cp_cont_f);
            am.setViewTextColor(this.hjC, (int) R.color.cp_link_tip_a);
            am.setBackgroundResource(this.hjC, R.drawable.bg_card_frs_lottery_btn);
        }
        super.onChangeSkinType(tbPageContext, i);
    }
}
