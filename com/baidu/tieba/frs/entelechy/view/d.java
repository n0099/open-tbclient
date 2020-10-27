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
    private RelativeLayout iOh;
    private TextView iOi;
    private TextView iOj;
    private TextView iOk;

    public d(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        View view = getView();
        this.iOh = (RelativeLayout) view.findViewById(R.id.lottery_info_layout);
        this.iOi = (TextView) view.findViewById(R.id.lottery_time_tv);
        this.iOj = (TextView) view.findViewById(R.id.lottery_join_count_tv);
        this.iOk = (TextView) view.findViewById(R.id.lottery_btn);
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
            if (y.getCount(bwVar.bkj()) > 1) {
                ArrayList<MediaData> arrayList = new ArrayList<>();
                arrayList.add(bwVar.bkj().get(0));
                bwVar.G(arrayList);
            }
            super.a(bwVar);
            this.hSj.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.frs.entelechy.view.d.1
                @Override // com.baidu.tbadk.widget.layout.d
                public void b(View view, int i, boolean z) {
                    if (d.this.agx != null && d.this.Jl()) {
                        be.boR().b(d.this.mTbPageContext, new String[]{d.this.agx.getActUrl()});
                    }
                }
            });
            com.baidu.tbadk.core.data.a aVar = (com.baidu.tbadk.core.data.a) y.getItem(bwVar.bkk(), 0);
            if (aVar != null) {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy.MM.dd");
                this.iOi.setText(StringUtils.string(getContext().getResources().getString(R.string.lottery_time), "  ", simpleDateFormat.format(new Date(TimeUnit.SECONDS.toMillis(aVar.bhN()))), Constants.ACCEPT_TIME_SEPARATOR_SERVER, simpleDateFormat.format(new Date(TimeUnit.SECONDS.toMillis(aVar.bhO())))));
                this.iOj.setText(String.format(getContext().getResources().getString(R.string.lottery_join_num), String.valueOf(aVar.bhP())));
                this.iOk.setText(R.string.lottery_btn_text);
                this.gMs.setCommentNumEnable(false);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.view.c
    protected void oj(boolean z) {
        if (this.agx != null && Jl()) {
            be.boR().b(this.mTbPageContext, new String[]{this.agx.getActUrl()});
        }
    }

    protected boolean Jl() {
        if (TbadkCoreApplication.isLogin()) {
            return true;
        }
        bg.skipToLoginActivity(this.mTbPageContext.getPageActivity());
        return false;
    }

    @Override // com.baidu.tieba.frs.entelechy.view.c, com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundColor(this.iOh, R.color.cp_bg_line_e);
            ap.setViewTextColor(this.iOi, (int) R.color.cp_cont_f);
            ap.setViewTextColor(this.iOj, (int) R.color.cp_cont_f);
            ap.setViewTextColor(this.iOk, (int) R.color.cp_link_tip_a);
            ap.setBackgroundResource(this.iOk, R.drawable.bg_card_frs_lottery_btn);
        }
        super.onChangeSkinType(tbPageContext, i);
    }
}
