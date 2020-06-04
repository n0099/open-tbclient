package com.baidu.tieba.frs.entelechy.view;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.bk;
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
    private RelativeLayout hyE;
    private TextView hyF;
    private TextView hyG;
    private TextView hyH;

    public d(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        View view = getView();
        this.hyE = (RelativeLayout) view.findViewById(R.id.lottery_info_layout);
        this.hyF = (TextView) view.findViewById(R.id.lottery_time_tv);
        this.hyG = (TextView) view.findViewById(R.id.lottery_join_count_tv);
        this.hyH = (TextView) view.findViewById(R.id.lottery_btn);
    }

    @Override // com.baidu.tieba.frs.entelechy.view.c, com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.card_frs_lottery_new_frame;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tieba.frs.entelechy.view.c, com.baidu.tieba.card.b
    public void a(bk bkVar) {
        if (bkVar != null) {
            if (v.getCount(bkVar.aQH()) > 1) {
                ArrayList<MediaData> arrayList = new ArrayList<>();
                arrayList.add(bkVar.aQH().get(0));
                bkVar.z(arrayList);
            }
            super.a(bkVar);
            this.gEx.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.frs.entelechy.view.d.1
                @Override // com.baidu.tbadk.widget.layout.d
                public void b(View view, int i, boolean z) {
                    if (d.this.aee != null && d.this.AP()) {
                        ba.aVa().b(d.this.mTbPageContext, new String[]{d.this.aee.getActUrl()});
                    }
                }
            });
            com.baidu.tbadk.core.data.a aVar = (com.baidu.tbadk.core.data.a) v.getItem(bkVar.aQI(), 0);
            if (aVar != null) {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy.MM.dd");
                this.hyF.setText(StringUtils.string(getContext().getResources().getString(R.string.lottery_time), "  ", simpleDateFormat.format(new Date(TimeUnit.SECONDS.toMillis(aVar.aOu()))), Constants.ACCEPT_TIME_SEPARATOR_SERVER, simpleDateFormat.format(new Date(TimeUnit.SECONDS.toMillis(aVar.aOv())))));
                this.hyG.setText(String.format(getContext().getResources().getString(R.string.lottery_join_num), String.valueOf(aVar.aOw())));
                this.hyH.setText(R.string.lottery_btn_text);
                this.fGz.setCommentNumEnable(false);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.view.c
    protected void lN(boolean z) {
        if (this.aee != null && AP()) {
            ba.aVa().b(this.mTbPageContext, new String[]{this.aee.getActUrl()});
        }
    }

    protected boolean AP() {
        if (TbadkCoreApplication.isLogin()) {
            return true;
        }
        bc.skipToLoginActivity(this.mTbPageContext.getPageActivity());
        return false;
    }

    @Override // com.baidu.tieba.frs.entelechy.view.c, com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundColor(this.hyE, R.color.cp_bg_line_e);
            am.setViewTextColor(this.hyF, (int) R.color.cp_cont_f);
            am.setViewTextColor(this.hyG, (int) R.color.cp_cont_f);
            am.setViewTextColor(this.hyH, (int) R.color.cp_link_tip_a);
            am.setBackgroundResource(this.hyH, R.drawable.bg_card_frs_lottery_btn);
        }
        super.onChangeSkinType(tbPageContext, i);
    }
}
