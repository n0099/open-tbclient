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
/* loaded from: classes7.dex */
public class d extends c {
    private RelativeLayout gwQ;
    private TextView gwR;
    private TextView gwS;
    private TextView gwT;

    public d(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        View view = getView();
        this.gwQ = (RelativeLayout) view.findViewById(R.id.lottery_info_layout);
        this.gwR = (TextView) view.findViewById(R.id.lottery_time_tv);
        this.gwS = (TextView) view.findViewById(R.id.lottery_join_count_tv);
        this.gwT = (TextView) view.findViewById(R.id.lottery_btn);
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
            if (v.getCount(bjVar.aAh()) > 1) {
                ArrayList<MediaData> arrayList = new ArrayList<>();
                arrayList.add(bjVar.aAh().get(0));
                bjVar.x(arrayList);
            }
            super.a(bjVar);
            this.fHq.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.frs.entelechy.view.d.1
                @Override // com.baidu.tbadk.widget.layout.d
                public void b(View view, int i, boolean z) {
                    if (d.this.Kn != null && d.this.tH()) {
                        ba.aEt().b(d.this.mTbPageContext, new String[]{d.this.Kn.getActUrl()});
                    }
                }
            });
            com.baidu.tbadk.core.data.b bVar = (com.baidu.tbadk.core.data.b) v.getItem(bjVar.aAi(), 0);
            if (bVar != null) {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy.MM.dd");
                this.gwR.setText(StringUtils.string(getContext().getResources().getString(R.string.lottery_time), "  ", simpleDateFormat.format(new Date(TimeUnit.SECONDS.toMillis(bVar.axV()))), Constants.ACCEPT_TIME_SEPARATOR_SERVER, simpleDateFormat.format(new Date(TimeUnit.SECONDS.toMillis(bVar.axW())))));
                this.gwS.setText(String.format(getContext().getResources().getString(R.string.lottery_join_num), String.valueOf(bVar.axX())));
                this.gwT.setText(R.string.lottery_btn_text);
                this.eJr.setCommentNumEnable(false);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.view.c
    protected void kh(boolean z) {
        if (this.Kn != null && tH()) {
            ba.aEt().b(this.mTbPageContext, new String[]{this.Kn.getActUrl()});
        }
    }

    protected boolean tH() {
        if (TbadkCoreApplication.isLogin()) {
            return true;
        }
        bc.skipToLoginActivity(this.mTbPageContext.getPageActivity());
        return false;
    }

    @Override // com.baidu.tieba.frs.entelechy.view.c, com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundColor(this.gwQ, R.color.cp_bg_line_e);
            am.setViewTextColor(this.gwR, (int) R.color.cp_cont_f);
            am.setViewTextColor(this.gwS, (int) R.color.cp_cont_f);
            am.setViewTextColor(this.gwT, (int) R.color.cp_link_tip_a);
            am.setBackgroundResource(this.gwT, R.drawable.bg_card_frs_lottery_btn);
        }
        super.onChangeSkinType(tbPageContext, i);
    }
}
