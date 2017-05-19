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
    private View.OnClickListener alY;
    private View.OnClickListener amk;
    private TbImageView bcI;
    private TextView bcJ;
    private RelativeLayout bcK;
    private FrameLayout bcN;
    private View bcO;
    private ThreadLiveAndRecordUserInfoLayout csQ;
    private d csR;

    public e(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.amk = new f(this);
        this.alY = new g(this);
        initView();
    }

    private void initView() {
        this.bcK = (RelativeLayout) getView().findViewById(w.h.rlAlaLivePane);
        ViewGroup.LayoutParams layoutParams = this.bcK.getLayoutParams();
        layoutParams.height = com.baidu.adp.lib.util.k.af(this.mContext) * 1;
        this.bcK.setLayoutParams(layoutParams);
        getView().setOnClickListener(this);
        this.bcN = (FrameLayout) getView().findViewById(w.h.flAlaLiveTitlePane);
        this.bcI = (TbImageView) getView().findViewById(w.h.imgAlaLiveView);
        this.bcI.setDefaultErrorResource(0);
        this.bcI.setDefaultBgResource(w.g.pic_bg_video_frs);
        this.bcJ = (TextView) getView().findViewById(w.h.tvAlaLiveTitle);
        this.csQ = (ThreadLiveAndRecordUserInfoLayout) getView().findViewById(w.h.layoutAlaUserCard);
        this.csQ.setForumAfterClickListener(this.alY);
        this.csQ.setUserAfterClickListener(this.amk);
        this.csQ.setBarNameClickEnabled(true);
        this.bcO = getView().findViewById(w.h.dividerBottom);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return w.j.card_ala_live_feed_view;
    }

    public void i(BdUniqueId bdUniqueId) {
        if (bdUniqueId == null || this.csQ == null) {
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    /* renamed from: a */
    public void onBindDataToView(d dVar) {
        if (dVar != null && dVar.bcB != null && dVar.bcB.rQ() != null) {
            this.csR = dVar;
            this.bcJ.setText(dVar.bcB.getTitle());
            this.bcI.c(dVar.bcB.rQ().cover, 10, false);
            this.csQ.p(dVar.bcB);
            onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.m9getInst().getSkinType());
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aq.j(this.bcK, w.g.addresslist_item_bg);
            aq.i(this.bcJ, w.e.cp_cont_i);
            aq.j(this.bcO, w.e.cp_bg_line_d);
            this.csQ.onChangeSkinType(tbPageContext, i);
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
        if (tbPageContext != null && this.csR != null && this.csR.bcB != null && this.csR.bcB.getAuthor() != null && this.csR.bcB.rQ() != null) {
            boolean z = false;
            String str = "";
            if (TbadkCoreApplication.getCurrentAccountInfo() != null) {
                String userId = this.csR.bcB.getAuthor().getUserId();
                str = TbadkCoreApplication.getCurrentAccount();
                z = TextUtils.equals(userId, str);
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.setLiveID(this.csR.bcB.rQ().live_id);
            alaLiveInfoCoreData.setGroupID(this.csR.bcB.rQ().group_id);
            alaLiveInfoCoreData.setHslUrl(this.csR.bcB.rQ().hls_url);
            alaLiveInfoCoreData.setLiveCover(this.csR.bcB.rQ().cover);
            alaLiveInfoCoreData.setLiveTitle(this.csR.bcB.rQ().description);
            alaLiveInfoCoreData.setRtmpUrl(this.csR.bcB.rQ().rtmp_url);
            alaLiveInfoCoreData.setSessionID(this.csR.bcB.rQ().session_id);
            alaLiveInfoCoreData.setUserName(this.csR.bcB.rQ().TU.user_name);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(tbPageContext.getPageActivity(), alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_HOME_LIVE_PLAY, str, z, "")));
            int i = this.csR.bcB.rQ().live_type;
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            as asVar = new as("c11827");
            asVar.aa("tid", this.csR.bcB.getTid());
            asVar.aa(SapiAccountManager.SESSION_UID, currentAccount);
            asVar.s("obj_type", i);
            TiebaStatic.log(asVar);
        }
    }
}
