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
    private View.OnClickListener aoc;
    private View.OnClickListener aou;
    private TbImageView bgn;
    private TextView bgo;
    private RelativeLayout bgp;
    private FrameLayout bgt;
    private View bgu;
    private ThreadLiveAndRecordUserInfoLayout cYI;
    private b cYJ;

    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.aou = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.alalivelist.view.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.XL() != null) {
                    c.this.XL().a(view, c.this.cYJ);
                }
            }
        };
        this.aoc = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.alalivelist.view.c.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.XL() != null) {
                    c.this.XL().a(view, c.this.cYJ);
                }
            }
        };
        initView();
    }

    private void initView() {
        this.bgp = (RelativeLayout) getView().findViewById(d.h.rlAlaLivePane);
        ViewGroup.LayoutParams layoutParams = this.bgp.getLayoutParams();
        layoutParams.height = k.ae(this.mContext) * 1;
        this.bgp.setLayoutParams(layoutParams);
        getView().setOnClickListener(this);
        this.bgt = (FrameLayout) getView().findViewById(d.h.flAlaLiveTitlePane);
        this.bgn = (TbImageView) getView().findViewById(d.h.imgAlaLiveView);
        this.bgn.setDefaultErrorResource(0);
        this.bgn.setDefaultBgResource(d.g.pic_bg_video_frs);
        this.bgo = (TextView) getView().findViewById(d.h.tvAlaLiveTitle);
        this.cYI = (ThreadLiveAndRecordUserInfoLayout) getView().findViewById(d.h.layoutAlaUserCard);
        this.cYI.setForumAfterClickListener(this.aoc);
        this.cYI.setUserAfterClickListener(this.aou);
        this.cYI.setBarNameClickEnabled(true);
        this.bgu = getView().findViewById(d.h.dividerBottom);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.j.card_ala_live_feed_view;
    }

    public void i(BdUniqueId bdUniqueId) {
        if (bdUniqueId == null || this.cYI == null) {
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(b bVar) {
        if (bVar != null && bVar.bcG != null && bVar.bcG.rT() != null) {
            this.cYJ = bVar;
            this.bgo.setText(bVar.bcG.getTitle());
            this.bgn.c(bVar.bcG.rT().cover, 10, false);
            this.cYI.A(bVar.bcG);
            d(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.j(this.bgp, d.g.addresslist_item_bg);
            aj.i(this.bgo, d.e.cp_cont_i);
            aj.j(this.bgu, d.e.cp_bg_line_d);
            this.cYI.d(tbPageContext, i);
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
        if (tbPageContext != null && this.cYJ != null && this.cYJ.bcG != null && this.cYJ.bcG.getAuthor() != null && this.cYJ.bcG.rT() != null) {
            boolean z = false;
            String str = "";
            if (TbadkCoreApplication.getCurrentAccountInfo() != null) {
                String userId = this.cYJ.bcG.getAuthor().getUserId();
                str = TbadkCoreApplication.getCurrentAccount();
                z = TextUtils.equals(userId, str);
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(this.cYJ.bcG.rT());
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(tbPageContext.getPageActivity(), alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_HOME_LIVE_PLAY, str, z, "")));
            int i = this.cYJ.bcG.rT().live_type;
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            ak akVar = new ak("c11827");
            akVar.ad("tid", this.cYJ.bcG.getTid());
            akVar.ad(SapiAccountManager.SESSION_UID, currentAccount);
            akVar.r("obj_type", i);
            TiebaStatic.log(akVar);
        }
    }
}
