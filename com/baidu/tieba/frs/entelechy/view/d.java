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
    private RelativeLayout fFn;
    private TextView fFo;
    private TextView fFp;
    private TextView fFq;

    public d(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        View view = getView();
        this.fFn = (RelativeLayout) view.findViewById(R.id.lottery_info_layout);
        this.fFo = (TextView) view.findViewById(R.id.lottery_time_tv);
        this.fFp = (TextView) view.findViewById(R.id.lottery_join_count_tv);
        this.fFq = (TextView) view.findViewById(R.id.lottery_btn);
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
            if (v.getCount(bhVar.aiO()) > 1) {
                ArrayList<MediaData> arrayList = new ArrayList<>();
                arrayList.add(bhVar.aiO().get(0));
                bhVar.v(arrayList);
            }
            super.a(bhVar);
            this.eMr.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.frs.entelechy.view.d.1
                @Override // com.baidu.tbadk.widget.layout.d
                public void b(View view, int i, boolean z) {
                    if (d.this.Fs != null && d.this.rB()) {
                        ba.amO().b(d.this.mTbPageContext, new String[]{d.this.Fs.getActUrl()});
                    }
                }
            });
            com.baidu.tbadk.core.data.b bVar = (com.baidu.tbadk.core.data.b) v.getItem(bhVar.aiP(), 0);
            if (bVar != null) {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy.MM.dd");
                this.fFo.setText(StringUtils.string(getContext().getResources().getString(R.string.lottery_time), "  ", simpleDateFormat.format(new Date(TimeUnit.SECONDS.toMillis(bVar.agL()))), Constants.ACCEPT_TIME_SEPARATOR_SERVER, simpleDateFormat.format(new Date(TimeUnit.SECONDS.toMillis(bVar.agM())))));
                this.fFp.setText(String.format(getContext().getResources().getString(R.string.lottery_join_num), String.valueOf(bVar.agN())));
                this.fFq.setText(R.string.lottery_btn_text);
                this.dSA.setCommentNumEnable(false);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.view.c
    protected void iF(boolean z) {
        if (this.Fs != null && rB()) {
            ba.amO().b(this.mTbPageContext, new String[]{this.Fs.getActUrl()});
        }
    }

    protected boolean rB() {
        if (TbadkCoreApplication.isLogin()) {
            return true;
        }
        bc.skipToLoginActivity(this.mTbPageContext.getPageActivity());
        return false;
    }

    @Override // com.baidu.tieba.frs.entelechy.view.c, com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundColor(this.fFn, R.color.cp_bg_line_e);
            am.setViewTextColor(this.fFo, (int) R.color.cp_cont_f);
            am.setViewTextColor(this.fFp, (int) R.color.cp_cont_f);
            am.setViewTextColor(this.fFq, (int) R.color.cp_link_tip_a);
            am.setBackgroundResource(this.fFq, R.drawable.bg_card_frs_lottery_btn);
        }
        super.onChangeSkinType(tbPageContext, i);
    }
}
