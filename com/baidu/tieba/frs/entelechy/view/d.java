package com.baidu.tieba.frs.entelechy.view;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.R;
import com.xiaomi.mipush.sdk.Constants;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.TimeUnit;
/* loaded from: classes2.dex */
public class d extends c {
    private RelativeLayout jnH;
    private TextView jnI;
    private TextView jnJ;
    private TextView jnK;

    public d(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        View view = getView();
        this.jnH = (RelativeLayout) view.findViewById(R.id.lottery_info_layout);
        this.jnI = (TextView) view.findViewById(R.id.lottery_time_tv);
        this.jnJ = (TextView) view.findViewById(R.id.lottery_join_count_tv);
        this.jnK = (TextView) view.findViewById(R.id.lottery_btn);
    }

    @Override // com.baidu.tieba.frs.entelechy.view.c, com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.card_frs_lottery_new_frame;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tieba.frs.entelechy.view.c, com.baidu.tieba.card.b
    public void a(bz bzVar) {
        if (bzVar != null) {
            if (x.getCount(bzVar.bnG()) > 1) {
                ArrayList<MediaData> arrayList = new ArrayList<>();
                arrayList.add(bzVar.bnG().get(0));
                bzVar.B(arrayList);
            }
            super.a(bzVar);
            this.irt.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.frs.entelechy.view.d.1
                @Override // com.baidu.tbadk.widget.layout.d
                public void c(View view, int i, boolean z) {
                    if (d.this.ahu != null && d.this.GJ()) {
                        be.bsB().b(d.this.mTbPageContext, new String[]{d.this.ahu.getActUrl()});
                    }
                }
            });
            com.baidu.tbadk.core.data.b bVar = (com.baidu.tbadk.core.data.b) x.getItem(bzVar.bnH(), 0);
            if (bVar != null) {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy.MM.dd");
                this.jnI.setText(StringUtils.string(getContext().getResources().getString(R.string.lottery_time), "  ", simpleDateFormat.format(new Date(TimeUnit.SECONDS.toMillis(bVar.blh()))), Constants.ACCEPT_TIME_SEPARATOR_SERVER, simpleDateFormat.format(new Date(TimeUnit.SECONDS.toMillis(bVar.bli())))));
                this.jnJ.setText(String.format(getContext().getResources().getString(R.string.lottery_join_num), String.valueOf(bVar.blj())));
                this.jnK.setText(R.string.lottery_btn_text);
                this.hiT.setCommentNumEnable(false);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.view.c
    protected void pl(boolean z) {
        if (this.ahu != null && GJ()) {
            be.bsB().b(this.mTbPageContext, new String[]{this.ahu.getActUrl()});
        }
    }

    protected boolean GJ() {
        if (TbadkCoreApplication.isLogin()) {
            return true;
        }
        bg.skipToLoginActivity(this.mTbPageContext.getPageActivity());
        return false;
    }

    @Override // com.baidu.tieba.frs.entelechy.view.c, com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ao.setBackgroundColor(this.jnH, R.color.CAM_X0205);
            ao.setViewTextColor(this.jnI, R.color.CAM_X0106);
            ao.setViewTextColor(this.jnJ, R.color.CAM_X0106);
            ao.setViewTextColor(this.jnK, R.color.CAM_X0302);
            ao.setBackgroundResource(this.jnK, R.drawable.bg_card_frs_lottery_btn);
        }
        super.onChangeSkinType(tbPageContext, i);
    }
}
