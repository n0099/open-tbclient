package com.baidu.tieba.frs.entelechy.view;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.bx;
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
/* loaded from: classes21.dex */
public class d extends c {
    private RelativeLayout iUQ;
    private TextView iUR;
    private TextView iUS;
    private TextView iUT;

    public d(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        View view = getView();
        this.iUQ = (RelativeLayout) view.findViewById(R.id.lottery_info_layout);
        this.iUR = (TextView) view.findViewById(R.id.lottery_time_tv);
        this.iUS = (TextView) view.findViewById(R.id.lottery_join_count_tv);
        this.iUT = (TextView) view.findViewById(R.id.lottery_btn);
    }

    @Override // com.baidu.tieba.frs.entelechy.view.c, com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.card_frs_lottery_new_frame;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tieba.frs.entelechy.view.c, com.baidu.tieba.card.b
    public void a(bx bxVar) {
        if (bxVar != null) {
            if (y.getCount(bxVar.blL()) > 1) {
                ArrayList<MediaData> arrayList = new ArrayList<>();
                arrayList.add(bxVar.blL().get(0));
                bxVar.G(arrayList);
            }
            super.a(bxVar);
            this.hYG.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.frs.entelechy.view.d.1
                @Override // com.baidu.tbadk.widget.layout.d
                public void b(View view, int i, boolean z) {
                    if (d.this.agB != null && d.this.Jd()) {
                        bf.bqF().b(d.this.mTbPageContext, new String[]{d.this.agB.getActUrl()});
                    }
                }
            });
            com.baidu.tbadk.core.data.b bVar = (com.baidu.tbadk.core.data.b) y.getItem(bxVar.blM(), 0);
            if (bVar != null) {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy.MM.dd");
                this.iUR.setText(StringUtils.string(getContext().getResources().getString(R.string.lottery_time), "  ", simpleDateFormat.format(new Date(TimeUnit.SECONDS.toMillis(bVar.bjp()))), Constants.ACCEPT_TIME_SEPARATOR_SERVER, simpleDateFormat.format(new Date(TimeUnit.SECONDS.toMillis(bVar.bjq())))));
                this.iUS.setText(String.format(getContext().getResources().getString(R.string.lottery_join_num), String.valueOf(bVar.bjr())));
                this.iUT.setText(R.string.lottery_btn_text);
                this.gSy.setCommentNumEnable(false);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.view.c
    protected void ov(boolean z) {
        if (this.agB != null && Jd()) {
            bf.bqF().b(this.mTbPageContext, new String[]{this.agB.getActUrl()});
        }
    }

    protected boolean Jd() {
        if (TbadkCoreApplication.isLogin()) {
            return true;
        }
        bh.skipToLoginActivity(this.mTbPageContext.getPageActivity());
        return false;
    }

    @Override // com.baidu.tieba.frs.entelechy.view.c, com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundColor(this.iUQ, R.color.CAM_X0205);
            ap.setViewTextColor(this.iUR, (int) R.color.CAM_X0106);
            ap.setViewTextColor(this.iUS, (int) R.color.CAM_X0106);
            ap.setViewTextColor(this.iUT, (int) R.color.CAM_X0302);
            ap.setBackgroundResource(this.iUT, R.drawable.bg_card_frs_lottery_btn);
        }
        super.onChangeSkinType(tbPageContext, i);
    }
}
