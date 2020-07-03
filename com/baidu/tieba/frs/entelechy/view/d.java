package com.baidu.tieba.frs.entelechy.view;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.bu;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.core.util.w;
import com.baidu.tieba.R;
import com.xiaomi.mipush.sdk.Constants;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.TimeUnit;
/* loaded from: classes9.dex */
public class d extends c {
    private RelativeLayout hLB;
    private TextView hLC;
    private TextView hLD;
    private TextView hLE;

    public d(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        View view = getView();
        this.hLB = (RelativeLayout) view.findViewById(R.id.lottery_info_layout);
        this.hLC = (TextView) view.findViewById(R.id.lottery_time_tv);
        this.hLD = (TextView) view.findViewById(R.id.lottery_join_count_tv);
        this.hLE = (TextView) view.findViewById(R.id.lottery_btn);
    }

    @Override // com.baidu.tieba.frs.entelechy.view.c, com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.card_frs_lottery_new_frame;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tieba.frs.entelechy.view.c, com.baidu.tieba.card.b
    public void a(bu buVar) {
        if (buVar != null) {
            if (w.getCount(buVar.aSy()) > 1) {
                ArrayList<MediaData> arrayList = new ArrayList<>();
                arrayList.add(buVar.aSy().get(0));
                buVar.z(arrayList);
            }
            super.a(buVar);
            this.gRn.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.frs.entelechy.view.d.1
                @Override // com.baidu.tbadk.widget.layout.d
                public void b(View view, int i, boolean z) {
                    if (d.this.aeK != null && d.this.Bp()) {
                        bc.aWU().b(d.this.mTbPageContext, new String[]{d.this.aeK.getActUrl()});
                    }
                }
            });
            com.baidu.tbadk.core.data.a aVar = (com.baidu.tbadk.core.data.a) w.getItem(buVar.aSz(), 0);
            if (aVar != null) {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy.MM.dd");
                this.hLC.setText(StringUtils.string(getContext().getResources().getString(R.string.lottery_time), "  ", simpleDateFormat.format(new Date(TimeUnit.SECONDS.toMillis(aVar.aQe()))), Constants.ACCEPT_TIME_SEPARATOR_SERVER, simpleDateFormat.format(new Date(TimeUnit.SECONDS.toMillis(aVar.aQf())))));
                this.hLD.setText(String.format(getContext().getResources().getString(R.string.lottery_join_num), String.valueOf(aVar.aQg())));
                this.hLE.setText(R.string.lottery_btn_text);
                this.fRI.setCommentNumEnable(false);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.view.c
    protected void lW(boolean z) {
        if (this.aeK != null && Bp()) {
            bc.aWU().b(this.mTbPageContext, new String[]{this.aeK.getActUrl()});
        }
    }

    protected boolean Bp() {
        if (TbadkCoreApplication.isLogin()) {
            return true;
        }
        be.skipToLoginActivity(this.mTbPageContext.getPageActivity());
        return false;
    }

    @Override // com.baidu.tieba.frs.entelechy.view.c, com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            an.setBackgroundColor(this.hLB, R.color.cp_bg_line_e);
            an.setViewTextColor(this.hLC, (int) R.color.cp_cont_f);
            an.setViewTextColor(this.hLD, (int) R.color.cp_cont_f);
            an.setViewTextColor(this.hLE, (int) R.color.cp_link_tip_a);
            an.setBackgroundResource(this.hLE, R.drawable.bg_card_frs_lottery_btn);
        }
        super.onChangeSkinType(tbPageContext, i);
    }
}
