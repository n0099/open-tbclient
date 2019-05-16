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
import com.baidu.tieba.R;
import com.xiaomi.mipush.sdk.Constants;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.TimeUnit;
/* loaded from: classes4.dex */
public class d extends c {
    private RelativeLayout fzm;
    private TextView fzn;
    private TextView fzo;
    private TextView fzp;

    public d(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        View view = getView();
        this.fzm = (RelativeLayout) view.findViewById(R.id.lottery_info_layout);
        this.fzn = (TextView) view.findViewById(R.id.lottery_time_tv);
        this.fzo = (TextView) view.findViewById(R.id.lottery_join_count_tv);
        this.fzp = (TextView) view.findViewById(R.id.lottery_btn);
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
            if (v.Z(bgVar.adF()) > 1) {
                ArrayList<MediaData> arrayList = new ArrayList<>();
                arrayList.add(bgVar.adF().get(0));
                bgVar.s(arrayList);
            }
            super.a(bgVar);
            this.exN.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.frs.entelechy.view.d.1
                @Override // com.baidu.tbadk.widget.layout.d
                public void a(View view, int i, boolean z) {
                    if (d.this.VK != null && d.this.aLi()) {
                        ba.aiz().c(d.this.mTbPageContext, new String[]{d.this.VK.getActUrl()});
                    }
                }
            });
            com.baidu.tbadk.core.data.b bVar = (com.baidu.tbadk.core.data.b) v.c(bgVar.adG(), 0);
            if (bVar != null) {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy.MM.dd");
                this.fzn.setText(StringUtils.string(getContext().getResources().getString(R.string.lottery_time), "  ", simpleDateFormat.format(new Date(TimeUnit.SECONDS.toMillis(bVar.abA()))), Constants.ACCEPT_TIME_SEPARATOR_SERVER, simpleDateFormat.format(new Date(TimeUnit.SECONDS.toMillis(bVar.abB())))));
                this.fzo.setText(String.format(getContext().getResources().getString(R.string.lottery_join_num), String.valueOf(bVar.abC())));
                this.fzp.setText(R.string.lottery_btn_text);
                this.dBe.setCommentNumEnable(false);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.view.c
    protected void iq(boolean z) {
        if (this.VK != null && aLi()) {
            ba.aiz().c(this.mTbPageContext, new String[]{this.VK.getActUrl()});
        }
    }

    protected boolean aLi() {
        if (TbadkCoreApplication.isLogin()) {
            return true;
        }
        bc.cD(this.mTbPageContext.getPageActivity());
        return false;
    }

    @Override // com.baidu.tieba.frs.entelechy.view.c, com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.l(this.fzm, R.color.cp_bg_line_e);
            al.j(this.fzn, R.color.cp_cont_f);
            al.j(this.fzo, R.color.cp_cont_f);
            al.j(this.fzp, R.color.cp_link_tip_a);
            al.k(this.fzp, R.drawable.bg_card_frs_lottery_btn);
        }
        super.onChangeSkinType(tbPageContext, i);
    }
}
