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
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class e extends com.baidu.tieba.card.a<d> {
    private View.OnClickListener ama;
    private View.OnClickListener amx;
    private FrameLayout bbA;
    private View bbB;
    private TbImageView bbv;
    private TextView bbw;
    private RelativeLayout bbx;
    private ThreadLiveAndRecordUserInfoLayout ctC;
    private d ctD;

    public e(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.amx = new f(this);
        this.ama = new g(this);
        initView();
    }

    private void initView() {
        this.bbx = (RelativeLayout) getView().findViewById(w.h.rlAlaLivePane);
        ViewGroup.LayoutParams layoutParams = this.bbx.getLayoutParams();
        layoutParams.height = com.baidu.adp.lib.util.k.af(this.mContext) * 1;
        this.bbx.setLayoutParams(layoutParams);
        getView().setOnClickListener(this);
        this.bbA = (FrameLayout) getView().findViewById(w.h.flAlaLiveTitlePane);
        this.bbv = (TbImageView) getView().findViewById(w.h.imgAlaLiveView);
        this.bbv.setDefaultErrorResource(0);
        this.bbv.setDefaultBgResource(w.g.pic_bg_video_frs);
        this.bbw = (TextView) getView().findViewById(w.h.tvAlaLiveTitle);
        this.ctC = (ThreadLiveAndRecordUserInfoLayout) getView().findViewById(w.h.layoutAlaUserCard);
        this.ctC.setForumAfterClickListener(this.ama);
        this.ctC.setUserAfterClickListener(this.amx);
        this.ctC.setBarNameClickEnabled(true);
        this.bbB = getView().findViewById(w.h.dividerBottom);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return w.j.card_ala_live_feed_view;
    }

    public void i(BdUniqueId bdUniqueId) {
        if (bdUniqueId == null || this.ctC == null) {
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    /* renamed from: a */
    public void onBindDataToView(d dVar) {
        if (dVar != null && dVar.bbo != null && dVar.bbo.sG() != null) {
            this.ctD = dVar;
            this.bbw.setText(dVar.bbo.getTitle());
            this.bbv.c(dVar.bbo.sG().cover, 10, false);
            this.ctC.k(dVar.bbo);
            onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.m9getInst().getSkinType());
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aq.j(this.bbx, w.g.addresslist_item_bg);
            aq.i(this.bbw, w.e.cp_cont_i);
            aq.j(this.bbB, w.e.cp_bg_line_d);
            this.ctC.onChangeSkinType(tbPageContext, i);
            this.mSkinType = i;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == getView()) {
            if (MessageManager.getInstance().findTask(CmdConfigCustom.CMD_ALA_LIVE_ROOM_START) == null) {
                com.baidu.adp.lib.util.k.E(this.mContext, this.mContext.getString(w.l.plugin_config_not_found));
            } else if (com.baidu.adp.lib.util.i.hj()) {
                j(this.mTbPageContext);
            } else {
                com.baidu.adp.lib.util.k.E(this.mContext, this.mContext.getString(w.l.neterror));
            }
        }
    }

    public void j(TbPageContext<?> tbPageContext) {
        if (tbPageContext != null && this.ctD != null && this.ctD.bbo != null && this.ctD.bbo.getAuthor() != null && this.ctD.bbo.sG() != null) {
            boolean z = false;
            String str = "";
            if (TbadkCoreApplication.getCurrentAccountInfo() != null) {
                String userId = this.ctD.bbo.getAuthor().getUserId();
                str = TbadkCoreApplication.getCurrentAccount();
                z = TextUtils.equals(userId, str);
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.setLiveID(this.ctD.bbo.sG().live_id);
            alaLiveInfoCoreData.setGroupID(this.ctD.bbo.sG().group_id);
            alaLiveInfoCoreData.setHslUrl(this.ctD.bbo.sG().hls_url);
            alaLiveInfoCoreData.setLiveCover(this.ctD.bbo.sG().cover);
            alaLiveInfoCoreData.setLiveTitle(this.ctD.bbo.sG().description);
            alaLiveInfoCoreData.setRtmpUrl(this.ctD.bbo.sG().rtmp_url);
            alaLiveInfoCoreData.setSessionID(this.ctD.bbo.sG().session_id);
            alaLiveInfoCoreData.setUserName(this.ctD.bbo.sG().Uz.user_name);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(tbPageContext.getPageActivity(), alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_HOME_LIVE_PLAY, str, z)));
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            as asVar = new as("c11827");
            asVar.aa("tid", this.ctD.bbo.getTid());
            asVar.aa(SapiAccountManager.SESSION_UID, currentAccount);
            TiebaStatic.log(asVar);
        }
    }
}
