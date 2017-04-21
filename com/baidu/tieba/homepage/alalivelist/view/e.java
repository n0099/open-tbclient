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
    private TbImageView bcr;
    private TextView bcs;
    private RelativeLayout bct;
    private FrameLayout bcw;
    private View bcx;
    private ThreadLiveAndRecordUserInfoLayout cvT;
    private d cvU;

    public e(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.amx = new f(this);
        this.ama = new g(this);
        initView();
    }

    private void initView() {
        this.bct = (RelativeLayout) getView().findViewById(w.h.rlAlaLivePane);
        ViewGroup.LayoutParams layoutParams = this.bct.getLayoutParams();
        layoutParams.height = com.baidu.adp.lib.util.k.af(this.mContext) * 1;
        this.bct.setLayoutParams(layoutParams);
        getView().setOnClickListener(this);
        this.bcw = (FrameLayout) getView().findViewById(w.h.flAlaLiveTitlePane);
        this.bcr = (TbImageView) getView().findViewById(w.h.imgAlaLiveView);
        this.bcr.setDefaultErrorResource(0);
        this.bcr.setDefaultBgResource(w.g.pic_bg_video_frs);
        this.bcs = (TextView) getView().findViewById(w.h.tvAlaLiveTitle);
        this.cvT = (ThreadLiveAndRecordUserInfoLayout) getView().findViewById(w.h.layoutAlaUserCard);
        this.cvT.setForumAfterClickListener(this.ama);
        this.cvT.setUserAfterClickListener(this.amx);
        this.cvT.setBarNameClickEnabled(true);
        this.bcx = getView().findViewById(w.h.dividerBottom);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return w.j.card_ala_live_feed_view;
    }

    public void i(BdUniqueId bdUniqueId) {
        if (bdUniqueId == null || this.cvT == null) {
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    /* renamed from: a */
    public void onBindDataToView(d dVar) {
        if (dVar != null && dVar.bck != null && dVar.bck.sG() != null) {
            this.cvU = dVar;
            this.bcs.setText(dVar.bck.getTitle());
            this.bcr.c(dVar.bck.sG().cover, 10, false);
            this.cvT.k(dVar.bck);
            onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.m9getInst().getSkinType());
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aq.j(this.bct, w.g.addresslist_item_bg);
            aq.i(this.bcs, w.e.cp_cont_i);
            aq.j(this.bcx, w.e.cp_bg_line_d);
            this.cvT.onChangeSkinType(tbPageContext, i);
            this.mSkinType = i;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == getView()) {
            if (MessageManager.getInstance().findTask(CmdConfigCustom.CMD_ALA_LIVE_ROOM_START) == null) {
                com.baidu.adp.lib.util.k.E(this.mContext, this.mContext.getString(w.l.plugin_config_not_found));
            } else if (com.baidu.adp.lib.util.i.hk()) {
                j(this.mTbPageContext);
            } else {
                com.baidu.adp.lib.util.k.E(this.mContext, this.mContext.getString(w.l.no_network_guide));
            }
        }
    }

    public void j(TbPageContext<?> tbPageContext) {
        if (tbPageContext != null && this.cvU != null && this.cvU.bck != null && this.cvU.bck.getAuthor() != null && this.cvU.bck.sG() != null) {
            boolean z = false;
            String str = "";
            if (TbadkCoreApplication.getCurrentAccountInfo() != null) {
                String userId = this.cvU.bck.getAuthor().getUserId();
                str = TbadkCoreApplication.getCurrentAccount();
                z = TextUtils.equals(userId, str);
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.setLiveID(this.cvU.bck.sG().live_id);
            alaLiveInfoCoreData.setGroupID(this.cvU.bck.sG().group_id);
            alaLiveInfoCoreData.setHslUrl(this.cvU.bck.sG().hls_url);
            alaLiveInfoCoreData.setLiveCover(this.cvU.bck.sG().cover);
            alaLiveInfoCoreData.setLiveTitle(this.cvU.bck.sG().description);
            alaLiveInfoCoreData.setRtmpUrl(this.cvU.bck.sG().rtmp_url);
            alaLiveInfoCoreData.setSessionID(this.cvU.bck.sG().session_id);
            alaLiveInfoCoreData.setUserName(this.cvU.bck.sG().UC.user_name);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(tbPageContext.getPageActivity(), alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_HOME_LIVE_PLAY, str, z)));
            int i = this.cvU.bck.sG().live_type;
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            as asVar = new as("c11827");
            asVar.aa("tid", this.cvU.bck.getTid());
            asVar.aa(SapiAccountManager.SESSION_UID, currentAccount);
            asVar.s("obj_type", i);
            TiebaStatic.log(asVar);
        }
    }
}
