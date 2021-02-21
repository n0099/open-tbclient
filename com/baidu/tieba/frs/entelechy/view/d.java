package com.baidu.tieba.frs.entelechy.view;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.core.util.bh;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.R;
import com.xiaomi.mipush.sdk.Constants;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.TimeUnit;
/* loaded from: classes2.dex */
public class d extends c {
    private RelativeLayout jtB;
    private TextView jtC;
    private TextView jtD;
    private TextView jtE;

    public d(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        View view = getView();
        this.jtB = (RelativeLayout) view.findViewById(R.id.lottery_info_layout);
        this.jtC = (TextView) view.findViewById(R.id.lottery_time_tv);
        this.jtD = (TextView) view.findViewById(R.id.lottery_join_count_tv);
        this.jtE = (TextView) view.findViewById(R.id.lottery_btn);
    }

    @Override // com.baidu.tieba.frs.entelechy.view.c, com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.card_frs_lottery_new_frame;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tieba.frs.entelechy.view.c, com.baidu.tieba.card.b
    public void a(cb cbVar) {
        if (cbVar != null) {
            if (y.getCount(cbVar.bnZ()) > 1) {
                ArrayList<MediaData> arrayList = new ArrayList<>();
                arrayList.add(cbVar.bnZ().get(0));
                cbVar.B(arrayList);
            }
            super.a(cbVar);
            this.ixl.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.frs.entelechy.view.d.1
                @Override // com.baidu.tbadk.widget.layout.d
                public void c(View view, int i, boolean z) {
                    if (d.this.ahi != null && d.this.HZ()) {
                        bf.bsV().b(d.this.mTbPageContext, new String[]{d.this.ahi.getActUrl()});
                    }
                }
            });
            com.baidu.tbadk.core.data.b bVar = (com.baidu.tbadk.core.data.b) y.getItem(cbVar.boa(), 0);
            if (bVar != null) {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy.MM.dd");
                this.jtC.setText(StringUtils.string(getContext().getResources().getString(R.string.lottery_time), "  ", simpleDateFormat.format(new Date(TimeUnit.SECONDS.toMillis(bVar.blz()))), Constants.ACCEPT_TIME_SEPARATOR_SERVER, simpleDateFormat.format(new Date(TimeUnit.SECONDS.toMillis(bVar.blA())))));
                this.jtD.setText(String.format(getContext().getResources().getString(R.string.lottery_join_num), String.valueOf(bVar.blB())));
                this.jtE.setText(R.string.lottery_btn_text);
                this.hnu.setCommentNumEnable(false);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.view.c
    protected void pv(boolean z) {
        if (this.ahi != null && HZ()) {
            bf.bsV().b(this.mTbPageContext, new String[]{this.ahi.getActUrl()});
        }
    }

    protected boolean HZ() {
        if (TbadkCoreApplication.isLogin()) {
            return true;
        }
        bh.skipToLoginActivity(this.mTbPageContext.getPageActivity());
        return false;
    }

    @Override // com.baidu.tieba.frs.entelechy.view.c, com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundColor(this.jtB, R.color.CAM_X0205);
            ap.setViewTextColor(this.jtC, R.color.CAM_X0106);
            ap.setViewTextColor(this.jtD, R.color.CAM_X0106);
            ap.setViewTextColor(this.jtE, R.color.CAM_X0302);
            ap.setBackgroundResource(this.jtE, R.drawable.bg_card_frs_lottery_btn);
        }
        super.onChangeSkinType(tbPageContext, i);
    }
}
