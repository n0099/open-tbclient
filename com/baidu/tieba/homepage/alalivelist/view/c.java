package com.baidu.tieba.homepage.alalivelist.view;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.i;
import com.baidu.adp.lib.util.k;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class c extends com.baidu.tieba.card.a<b> {
    private View.OnClickListener aoe;
    private View.OnClickListener aow;
    private TbImageView bgq;
    private TextView bgr;
    private RelativeLayout bgt;
    private FrameLayout bgw;
    private View bgx;
    private ThreadLiveAndRecordUserInfoLayout cXO;
    private b cXP;

    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.aow = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.alalivelist.view.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.XA() != null) {
                    c.this.XA().a(view, c.this.cXP);
                }
            }
        };
        this.aoe = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.alalivelist.view.c.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.XA() != null) {
                    c.this.XA().a(view, c.this.cXP);
                }
            }
        };
        initView();
    }

    private void initView() {
        this.bgt = (RelativeLayout) getView().findViewById(d.h.rlAlaLivePane);
        ViewGroup.LayoutParams layoutParams = this.bgt.getLayoutParams();
        layoutParams.height = k.ad(this.mContext) * 1;
        this.bgt.setLayoutParams(layoutParams);
        getView().setOnClickListener(this);
        this.bgw = (FrameLayout) getView().findViewById(d.h.flAlaLiveTitlePane);
        this.bgq = (TbImageView) getView().findViewById(d.h.imgAlaLiveView);
        this.bgq.setDefaultErrorResource(0);
        this.bgq.setDefaultBgResource(d.g.pic_bg_video_frs);
        this.bgr = (TextView) getView().findViewById(d.h.tvAlaLiveTitle);
        this.cXO = (ThreadLiveAndRecordUserInfoLayout) getView().findViewById(d.h.layoutAlaUserCard);
        this.cXO.setForumAfterClickListener(this.aoe);
        this.cXO.setUserAfterClickListener(this.aow);
        this.cXO.setBarNameClickEnabled(true);
        this.bgx = getView().findViewById(d.h.dividerBottom);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.j.card_ala_live_feed_view;
    }

    public void i(BdUniqueId bdUniqueId) {
        if (bdUniqueId == null || this.cXO == null) {
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(b bVar) {
        if (bVar != null && bVar.bcJ != null && bVar.bcJ.rT() != null) {
            this.cXP = bVar;
            this.bgr.setText(bVar.bcJ.getTitle());
            this.bgq.c(bVar.bcJ.rT().cover, 10, false);
            this.cXO.A(bVar.bcJ);
            d(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.j(this.bgt, d.g.addresslist_item_bg);
            aj.i(this.bgr, d.e.cp_cont_i);
            aj.j(this.bgx, d.e.cp_bg_line_d);
            this.cXO.d(tbPageContext, i);
            this.mSkinType = i;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == getView()) {
            if (MessageManager.getInstance().findTask(CmdConfigCustom.CMD_ALA_LIVE_ROOM_START) == null) {
                k.F(this.mContext, this.mContext.getString(d.l.plugin_config_not_found));
            } else if (i.hi()) {
                i(this.mTbPageContext);
            } else {
                k.F(this.mContext, this.mContext.getString(d.l.no_network_guide));
            }
        }
    }

    public void i(TbPageContext<?> tbPageContext) {
        if (tbPageContext != null && this.cXP != null && this.cXP.bcJ != null && this.cXP.bcJ.getAuthor() != null && this.cXP.bcJ.rT() != null) {
            boolean z = false;
            String str = "";
            if (TbadkCoreApplication.getCurrentAccountInfo() != null) {
                String userId = this.cXP.bcJ.getAuthor().getUserId();
                str = TbadkCoreApplication.getCurrentAccount();
                z = TextUtils.equals(userId, str);
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(this.cXP.bcJ.rT());
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(tbPageContext.getPageActivity(), alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_HOME_LIVE_PLAY, str, z, "")));
            int i = this.cXP.bcJ.rT().live_type;
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            ak akVar = new ak("c11827");
            akVar.ad("tid", this.cXP.bcJ.getTid());
            akVar.ad(SapiAccountManager.SESSION_UID, currentAccount);
            akVar.r("obj_type", i);
            TiebaStatic.log(akVar);
        }
    }
}
