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
/* loaded from: classes16.dex */
public class d extends c {
    private RelativeLayout ifK;
    private TextView ifL;
    private TextView ifM;
    private TextView ifN;

    public d(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        View view = getView();
        this.ifK = (RelativeLayout) view.findViewById(R.id.lottery_info_layout);
        this.ifL = (TextView) view.findViewById(R.id.lottery_time_tv);
        this.ifM = (TextView) view.findViewById(R.id.lottery_join_count_tv);
        this.ifN = (TextView) view.findViewById(R.id.lottery_btn);
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
            if (y.getCount(bwVar.beN()) > 1) {
                ArrayList<MediaData> arrayList = new ArrayList<>();
                arrayList.add(bwVar.beN().get(0));
                bwVar.G(arrayList);
            }
            super.a(bwVar);
            this.hjL.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.frs.entelechy.view.d.1
                @Override // com.baidu.tbadk.widget.layout.d
                public void b(View view, int i, boolean z) {
                    if (d.this.afJ != null && d.this.Hu()) {
                        be.bju().b(d.this.mTbPageContext, new String[]{d.this.afJ.getActUrl()});
                    }
                }
            });
            com.baidu.tbadk.core.data.a aVar = (com.baidu.tbadk.core.data.a) y.getItem(bwVar.beO(), 0);
            if (aVar != null) {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy.MM.dd");
                this.ifL.setText(StringUtils.string(getContext().getResources().getString(R.string.lottery_time), "  ", simpleDateFormat.format(new Date(TimeUnit.SECONDS.toMillis(aVar.bcr()))), Constants.ACCEPT_TIME_SEPARATOR_SERVER, simpleDateFormat.format(new Date(TimeUnit.SECONDS.toMillis(aVar.bcs())))));
                this.ifM.setText(String.format(getContext().getResources().getString(R.string.lottery_join_num), String.valueOf(aVar.bct())));
                this.ifN.setText(R.string.lottery_btn_text);
                this.gja.setCommentNumEnable(false);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.view.c
    protected void ne(boolean z) {
        if (this.afJ != null && Hu()) {
            be.bju().b(this.mTbPageContext, new String[]{this.afJ.getActUrl()});
        }
    }

    protected boolean Hu() {
        if (TbadkCoreApplication.isLogin()) {
            return true;
        }
        bg.skipToLoginActivity(this.mTbPageContext.getPageActivity());
        return false;
    }

    @Override // com.baidu.tieba.frs.entelechy.view.c, com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundColor(this.ifK, R.color.cp_bg_line_e);
            ap.setViewTextColor(this.ifL, (int) R.color.cp_cont_f);
            ap.setViewTextColor(this.ifM, (int) R.color.cp_cont_f);
            ap.setViewTextColor(this.ifN, (int) R.color.cp_link_tip_a);
            ap.setBackgroundResource(this.ifN, R.drawable.bg_card_frs_lottery_btn);
        }
        super.onChangeSkinType(tbPageContext, i);
    }
}
