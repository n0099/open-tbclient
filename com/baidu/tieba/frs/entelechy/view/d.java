package com.baidu.tieba.frs.entelechy.view;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.by;
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
/* loaded from: classes22.dex */
public class d extends c {
    private RelativeLayout jfO;
    private TextView jfP;
    private TextView jfQ;
    private TextView jfR;

    public d(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        View view = getView();
        this.jfO = (RelativeLayout) view.findViewById(R.id.lottery_info_layout);
        this.jfP = (TextView) view.findViewById(R.id.lottery_time_tv);
        this.jfQ = (TextView) view.findViewById(R.id.lottery_join_count_tv);
        this.jfR = (TextView) view.findViewById(R.id.lottery_btn);
    }

    @Override // com.baidu.tieba.frs.entelechy.view.c, com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.card_frs_lottery_new_frame;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tieba.frs.entelechy.view.c, com.baidu.tieba.card.b
    public void a(by byVar) {
        if (byVar != null) {
            if (y.getCount(byVar.boY()) > 1) {
                ArrayList<MediaData> arrayList = new ArrayList<>();
                arrayList.add(byVar.boY().get(0));
                byVar.G(arrayList);
            }
            super.a(byVar);
            this.ijF.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.frs.entelechy.view.d.1
                @Override // com.baidu.tbadk.widget.layout.d
                public void b(View view, int i, boolean z) {
                    if (d.this.ahA != null && d.this.Le()) {
                        bf.bua().b(d.this.mTbPageContext, new String[]{d.this.ahA.getActUrl()});
                    }
                }
            });
            com.baidu.tbadk.core.data.b bVar = (com.baidu.tbadk.core.data.b) y.getItem(byVar.boZ(), 0);
            if (bVar != null) {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy.MM.dd");
                this.jfP.setText(StringUtils.string(getContext().getResources().getString(R.string.lottery_time), "  ", simpleDateFormat.format(new Date(TimeUnit.SECONDS.toMillis(bVar.bmz()))), Constants.ACCEPT_TIME_SEPARATOR_SERVER, simpleDateFormat.format(new Date(TimeUnit.SECONDS.toMillis(bVar.bmA())))));
                this.jfQ.setText(String.format(getContext().getResources().getString(R.string.lottery_join_num), String.valueOf(bVar.bmB())));
                this.jfR.setText(R.string.lottery_btn_text);
                this.hbN.setCommentNumEnable(false);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.view.c
    protected void oR(boolean z) {
        if (this.ahA != null && Le()) {
            bf.bua().b(this.mTbPageContext, new String[]{this.ahA.getActUrl()});
        }
    }

    protected boolean Le() {
        if (TbadkCoreApplication.isLogin()) {
            return true;
        }
        bh.skipToLoginActivity(this.mTbPageContext.getPageActivity());
        return false;
    }

    @Override // com.baidu.tieba.frs.entelechy.view.c, com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundColor(this.jfO, R.color.CAM_X0205);
            ap.setViewTextColor(this.jfP, (int) R.color.CAM_X0106);
            ap.setViewTextColor(this.jfQ, (int) R.color.CAM_X0106);
            ap.setViewTextColor(this.jfR, (int) R.color.CAM_X0302);
            ap.setBackgroundResource(this.jfR, R.drawable.bg_card_frs_lottery_btn);
        }
        super.onChangeSkinType(tbPageContext, i);
    }
}
