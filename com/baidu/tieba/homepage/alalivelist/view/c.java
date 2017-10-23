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
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
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
    private View.OnClickListener anf;
    private View.OnClickListener anx;
    private TbImageView bhM;
    private TextView bhN;
    private RelativeLayout bhO;
    private FrameLayout bhR;
    private View bhS;
    private ThreadLiveAndRecordUserInfoLayout cUP;
    private b cUQ;

    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.anx = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.alalivelist.view.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.Xn() != null) {
                    c.this.Xn().a(view, c.this.cUQ);
                }
            }
        };
        this.anf = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.alalivelist.view.c.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.Xn() != null) {
                    c.this.Xn().a(view, c.this.cUQ);
                }
            }
        };
        initView();
    }

    private void initView() {
        this.bhO = (RelativeLayout) getView().findViewById(d.h.rlAlaLivePane);
        ViewGroup.LayoutParams layoutParams = this.bhO.getLayoutParams();
        layoutParams.height = l.ad(this.mContext) * 1;
        this.bhO.setLayoutParams(layoutParams);
        getView().setOnClickListener(this);
        this.bhR = (FrameLayout) getView().findViewById(d.h.flAlaLiveTitlePane);
        this.bhM = (TbImageView) getView().findViewById(d.h.imgAlaLiveView);
        this.bhM.setDefaultErrorResource(0);
        this.bhM.setDefaultBgResource(d.g.pic_bg_video_frs);
        this.bhN = (TextView) getView().findViewById(d.h.tvAlaLiveTitle);
        this.cUP = (ThreadLiveAndRecordUserInfoLayout) getView().findViewById(d.h.layoutAlaUserCard);
        this.cUP.setForumAfterClickListener(this.anf);
        this.cUP.setUserAfterClickListener(this.anx);
        this.cUP.setBarNameClickEnabled(true);
        this.bhS = getView().findViewById(d.h.dividerBottom);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.j.card_ala_live_feed_view;
    }

    public void h(BdUniqueId bdUniqueId) {
        if (bdUniqueId == null || this.cUP == null) {
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(b bVar) {
        if (bVar != null && bVar.bee != null && bVar.bee.rG() != null) {
            this.cUQ = bVar;
            this.bhN.setText(bVar.bee.getTitle());
            this.bhM.c(bVar.bee.rG().cover, 10, false);
            this.cUP.w(bVar.bee);
            d(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.j(this.bhO, d.g.addresslist_item_bg);
            aj.i(this.bhN, d.e.cp_cont_i);
            aj.j(this.bhS, d.e.cp_bg_line_d);
            this.cUP.d(tbPageContext, i);
            this.mSkinType = i;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == getView()) {
            if (MessageManager.getInstance().findTask(CmdConfigCustom.CMD_ALA_LIVE_ROOM_START) == null) {
                l.F(this.mContext, this.mContext.getString(d.l.plugin_config_not_found));
            } else if (j.hh()) {
                h(this.mTbPageContext);
            } else {
                l.F(this.mContext, this.mContext.getString(d.l.no_network_guide));
            }
        }
    }

    public void h(TbPageContext<?> tbPageContext) {
        if (tbPageContext != null && this.cUQ != null && this.cUQ.bee != null && this.cUQ.bee.getAuthor() != null && this.cUQ.bee.rG() != null) {
            boolean z = false;
            String str = "";
            if (TbadkCoreApplication.getCurrentAccountInfo() != null) {
                String userId = this.cUQ.bee.getAuthor().getUserId();
                str = TbadkCoreApplication.getCurrentAccount();
                z = TextUtils.equals(userId, str);
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(this.cUQ.bee.rG());
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(tbPageContext.getPageActivity(), alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_HOME_LIVE_PLAY, str, z, "")));
            int i = this.cUQ.bee.rG().live_type;
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            ak akVar = new ak("c11827");
            akVar.ac("tid", this.cUQ.bee.getTid());
            akVar.ac(SapiAccountManager.SESSION_UID, currentAccount);
            akVar.r("obj_type", i);
            TiebaStatic.log(akVar);
        }
    }
}
