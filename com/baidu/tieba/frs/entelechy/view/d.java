package com.baidu.tieba.frs.entelechy.view;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.R;
import com.xiaomi.mipush.sdk.Constants;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.TimeUnit;
/* loaded from: classes22.dex */
public class d extends c {
    private RelativeLayout iBL;
    private TextView iBM;
    private TextView iBN;
    private TextView iBO;

    public d(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        View view = getView();
        this.iBL = (RelativeLayout) view.findViewById(R.id.lottery_info_layout);
        this.iBM = (TextView) view.findViewById(R.id.lottery_time_tv);
        this.iBN = (TextView) view.findViewById(R.id.lottery_join_count_tv);
        this.iBO = (TextView) view.findViewById(R.id.lottery_btn);
    }

    @Override // com.baidu.tieba.frs.entelechy.view.c, com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.card_frs_lottery_new_frame;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tieba.frs.entelechy.view.c, com.baidu.tieba.card.b
    public void a(bw bwVar) {
        if (bwVar != null) {
            if (y.getCount(bwVar.biq()) > 1) {
                ArrayList<MediaData> arrayList = new ArrayList<>();
                arrayList.add(bwVar.biq().get(0));
                bwVar.G(arrayList);
            }
            super.a(bwVar);
            this.hFM.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.frs.entelechy.view.d.1
                @Override // com.baidu.tbadk.widget.layout.d
                public void b(View view, int i, boolean z) {
                    if (d.this.agw != null && d.this.IS()) {
                        be.bmY().b(d.this.mTbPageContext, new String[]{d.this.agw.getActUrl()});
                    }
                }
            });
            com.baidu.tbadk.core.data.a aVar = (com.baidu.tbadk.core.data.a) y.getItem(bwVar.bir(), 0);
            if (aVar != null) {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy.MM.dd");
                this.iBM.setText(StringUtils.string(getContext().getResources().getString(R.string.lottery_time), "  ", simpleDateFormat.format(new Date(TimeUnit.SECONDS.toMillis(aVar.bfU()))), Constants.ACCEPT_TIME_SEPARATOR_SERVER, simpleDateFormat.format(new Date(TimeUnit.SECONDS.toMillis(aVar.bfV())))));
                this.iBN.setText(String.format(getContext().getResources().getString(R.string.lottery_join_num), String.valueOf(aVar.bfW())));
                this.iBO.setText(R.string.lottery_btn_text);
                this.gAE.setCommentNumEnable(false);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.view.c
    protected void nR(boolean z) {
        if (this.agw != null && IS()) {
            be.bmY().b(this.mTbPageContext, new String[]{this.agw.getActUrl()});
        }
    }

    protected boolean IS() {
        if (TbadkCoreApplication.isLogin()) {
            return true;
        }
        bg.skipToLoginActivity(this.mTbPageContext.getPageActivity());
        return false;
    }

    @Override // com.baidu.tieba.frs.entelechy.view.c, com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundColor(this.iBL, R.color.cp_bg_line_e);
            ap.setViewTextColor(this.iBM, (int) R.color.cp_cont_f);
            ap.setViewTextColor(this.iBN, (int) R.color.cp_cont_f);
            ap.setViewTextColor(this.iBO, (int) R.color.cp_link_tip_a);
            ap.setBackgroundResource(this.iBO, R.drawable.bg_card_frs_lottery_btn);
        }
        super.onChangeSkinType(tbPageContext, i);
    }
}
