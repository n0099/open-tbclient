package com.baidu.tieba.frs.entelechy.view;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.bj;
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
/* loaded from: classes9.dex */
public class d extends c {
    private RelativeLayout hjF;
    private TextView hjG;
    private TextView hjH;
    private TextView hjI;

    public d(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        View view = getView();
        this.hjF = (RelativeLayout) view.findViewById(R.id.lottery_info_layout);
        this.hjG = (TextView) view.findViewById(R.id.lottery_time_tv);
        this.hjH = (TextView) view.findViewById(R.id.lottery_join_count_tv);
        this.hjI = (TextView) view.findViewById(R.id.lottery_btn);
    }

    @Override // com.baidu.tieba.frs.entelechy.view.c, com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.card_frs_lottery_new_frame;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tieba.frs.entelechy.view.c, com.baidu.tieba.card.a
    public void a(bj bjVar) {
        if (bjVar != null) {
            if (v.getCount(bjVar.aKM()) > 1) {
                ArrayList<MediaData> arrayList = new ArrayList<>();
                arrayList.add(bjVar.aKM().get(0));
                bjVar.z(arrayList);
            }
            super.a(bjVar);
            this.gpx.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.frs.entelechy.view.d.1
                @Override // com.baidu.tbadk.widget.layout.d
                public void b(View view, int i, boolean z) {
                    if (d.this.adJ != null && d.this.zz()) {
                        ba.aOV().b(d.this.mTbPageContext, new String[]{d.this.adJ.getActUrl()});
                    }
                }
            });
            com.baidu.tbadk.core.data.b bVar = (com.baidu.tbadk.core.data.b) v.getItem(bjVar.aKN(), 0);
            if (bVar != null) {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy.MM.dd");
                this.hjG.setText(StringUtils.string(getContext().getResources().getString(R.string.lottery_time), "  ", simpleDateFormat.format(new Date(TimeUnit.SECONDS.toMillis(bVar.aIz()))), Constants.ACCEPT_TIME_SEPARATOR_SERVER, simpleDateFormat.format(new Date(TimeUnit.SECONDS.toMillis(bVar.aIA())))));
                this.hjH.setText(String.format(getContext().getResources().getString(R.string.lottery_join_num), String.valueOf(bVar.aIB())));
                this.hjI.setText(R.string.lottery_btn_text);
                this.fsw.setCommentNumEnable(false);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.view.c
    protected void lr(boolean z) {
        if (this.adJ != null && zz()) {
            ba.aOV().b(this.mTbPageContext, new String[]{this.adJ.getActUrl()});
        }
    }

    protected boolean zz() {
        if (TbadkCoreApplication.isLogin()) {
            return true;
        }
        bc.skipToLoginActivity(this.mTbPageContext.getPageActivity());
        return false;
    }

    @Override // com.baidu.tieba.frs.entelechy.view.c, com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundColor(this.hjF, R.color.cp_bg_line_e);
            am.setViewTextColor(this.hjG, (int) R.color.cp_cont_f);
            am.setViewTextColor(this.hjH, (int) R.color.cp_cont_f);
            am.setViewTextColor(this.hjI, (int) R.color.cp_link_tip_a);
            am.setBackgroundResource(this.hjI, R.drawable.bg_card_frs_lottery_btn);
        }
        super.onChangeSkinType(tbPageContext, i);
    }
}
