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
    private RelativeLayout iUe;
    private TextView iUf;
    private TextView iUg;
    private TextView iUh;

    public d(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        View view = getView();
        this.iUe = (RelativeLayout) view.findViewById(R.id.lottery_info_layout);
        this.iUf = (TextView) view.findViewById(R.id.lottery_time_tv);
        this.iUg = (TextView) view.findViewById(R.id.lottery_join_count_tv);
        this.iUh = (TextView) view.findViewById(R.id.lottery_btn);
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
            if (y.getCount(bwVar.bmJ()) > 1) {
                ArrayList<MediaData> arrayList = new ArrayList<>();
                arrayList.add(bwVar.bmJ().get(0));
                bwVar.G(arrayList);
            }
            super.a(bwVar);
            this.hYg.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.frs.entelechy.view.d.1
                @Override // com.baidu.tbadk.widget.layout.d
                public void b(View view, int i, boolean z) {
                    if (d.this.agx != null && d.this.JM()) {
                        be.brr().b(d.this.mTbPageContext, new String[]{d.this.agx.getActUrl()});
                    }
                }
            });
            com.baidu.tbadk.core.data.a aVar = (com.baidu.tbadk.core.data.a) y.getItem(bwVar.bmK(), 0);
            if (aVar != null) {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy.MM.dd");
                this.iUf.setText(StringUtils.string(getContext().getResources().getString(R.string.lottery_time), "  ", simpleDateFormat.format(new Date(TimeUnit.SECONDS.toMillis(aVar.bkn()))), Constants.ACCEPT_TIME_SEPARATOR_SERVER, simpleDateFormat.format(new Date(TimeUnit.SECONDS.toMillis(aVar.bko())))));
                this.iUg.setText(String.format(getContext().getResources().getString(R.string.lottery_join_num), String.valueOf(aVar.bkp())));
                this.iUh.setText(R.string.lottery_btn_text);
                this.gSR.setCommentNumEnable(false);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.view.c
    protected void os(boolean z) {
        if (this.agx != null && JM()) {
            be.brr().b(this.mTbPageContext, new String[]{this.agx.getActUrl()});
        }
    }

    protected boolean JM() {
        if (TbadkCoreApplication.isLogin()) {
            return true;
        }
        bg.skipToLoginActivity(this.mTbPageContext.getPageActivity());
        return false;
    }

    @Override // com.baidu.tieba.frs.entelechy.view.c, com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundColor(this.iUe, R.color.cp_bg_line_e);
            ap.setViewTextColor(this.iUf, (int) R.color.cp_cont_f);
            ap.setViewTextColor(this.iUg, (int) R.color.cp_cont_f);
            ap.setViewTextColor(this.iUh, (int) R.color.cp_link_tip_a);
            ap.setBackgroundResource(this.iUh, R.drawable.bg_card_frs_lottery_btn);
        }
        super.onChangeSkinType(tbPageContext, i);
    }
}
