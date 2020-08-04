package com.baidu.tieba.frs.entelechy.view;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.bd;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.R;
import com.xiaomi.mipush.sdk.Constants;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.TimeUnit;
/* loaded from: classes16.dex */
public class d extends c {
    private RelativeLayout hRC;
    private TextView hRD;
    private TextView hRE;
    private TextView hRF;

    public d(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        View view = getView();
        this.hRC = (RelativeLayout) view.findViewById(R.id.lottery_info_layout);
        this.hRD = (TextView) view.findViewById(R.id.lottery_time_tv);
        this.hRE = (TextView) view.findViewById(R.id.lottery_join_count_tv);
        this.hRF = (TextView) view.findViewById(R.id.lottery_btn);
    }

    @Override // com.baidu.tieba.frs.entelechy.view.c, com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.card_frs_lottery_new_frame;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tieba.frs.entelechy.view.c, com.baidu.tieba.card.b
    public void a(bv bvVar) {
        if (bvVar != null) {
            if (x.getCount(bvVar.aWu()) > 1) {
                ArrayList<MediaData> arrayList = new ArrayList<>();
                arrayList.add(bvVar.aWu().get(0));
                bvVar.A(arrayList);
            }
            super.a(bvVar);
            this.gWS.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.frs.entelechy.view.d.1
                @Override // com.baidu.tbadk.widget.layout.d
                public void b(View view, int i, boolean z) {
                    if (d.this.aeA != null && d.this.BR()) {
                        bd.baV().b(d.this.mTbPageContext, new String[]{d.this.aeA.getActUrl()});
                    }
                }
            });
            com.baidu.tbadk.core.data.a aVar = (com.baidu.tbadk.core.data.a) x.getItem(bvVar.aWv(), 0);
            if (aVar != null) {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy.MM.dd");
                this.hRD.setText(StringUtils.string(getContext().getResources().getString(R.string.lottery_time), "  ", simpleDateFormat.format(new Date(TimeUnit.SECONDS.toMillis(aVar.aUa()))), Constants.ACCEPT_TIME_SEPARATOR_SERVER, simpleDateFormat.format(new Date(TimeUnit.SECONDS.toMillis(aVar.aUb())))));
                this.hRE.setText(String.format(getContext().getResources().getString(R.string.lottery_join_num), String.valueOf(aVar.aUc())));
                this.hRF.setText(R.string.lottery_btn_text);
                this.fXb.setCommentNumEnable(false);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.view.c
    protected void mB(boolean z) {
        if (this.aeA != null && BR()) {
            bd.baV().b(this.mTbPageContext, new String[]{this.aeA.getActUrl()});
        }
    }

    protected boolean BR() {
        if (TbadkCoreApplication.isLogin()) {
            return true;
        }
        bf.skipToLoginActivity(this.mTbPageContext.getPageActivity());
        return false;
    }

    @Override // com.baidu.tieba.frs.entelechy.view.c, com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ao.setBackgroundColor(this.hRC, R.color.cp_bg_line_e);
            ao.setViewTextColor(this.hRD, R.color.cp_cont_f);
            ao.setViewTextColor(this.hRE, R.color.cp_cont_f);
            ao.setViewTextColor(this.hRF, R.color.cp_link_tip_a);
            ao.setBackgroundResource(this.hRF, R.drawable.bg_card_frs_lottery_btn);
        }
        super.onChangeSkinType(tbPageContext, i);
    }
}
