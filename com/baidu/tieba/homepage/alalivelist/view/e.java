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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class e extends com.baidu.tieba.card.a<d> {
    private TbImageView aVp;
    private TextView aVq;
    private RelativeLayout aVr;
    private FrameLayout aVu;
    private View aVv;
    private View.OnClickListener agO;
    private View.OnClickListener agt;
    private ThreadLiveAndRecordUserInfoLayout ctD;
    private d ctE;

    public e(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.agO = new f(this);
        this.agt = new g(this);
        initView();
    }

    private void initView() {
        this.aVr = (RelativeLayout) getView().findViewById(r.h.rlAlaLivePane);
        ViewGroup.LayoutParams layoutParams = this.aVr.getLayoutParams();
        layoutParams.height = com.baidu.adp.lib.util.k.I(this.mContext) * 1;
        this.aVr.setLayoutParams(layoutParams);
        getView().setOnClickListener(this);
        this.aVu = (FrameLayout) getView().findViewById(r.h.flAlaLiveTitlePane);
        this.aVp = (TbImageView) getView().findViewById(r.h.imgAlaLiveView);
        this.aVp.setDefaultErrorResource(0);
        this.aVp.setDefaultBgResource(r.g.pic_bg_video_frs);
        this.aVq = (TextView) getView().findViewById(r.h.tvAlaLiveTitle);
        this.ctD = (ThreadLiveAndRecordUserInfoLayout) getView().findViewById(r.h.layoutAlaUserCard);
        this.ctD.setForumAfterClickListener(this.agt);
        this.ctD.setUserAfterClickListener(this.agO);
        this.ctD.setBarNameClickEnabled(true);
        this.aVv = getView().findViewById(r.h.dividerBottom);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return r.j.card_ala_live_feed_view;
    }

    public void i(BdUniqueId bdUniqueId) {
        if (bdUniqueId == null || this.ctD == null) {
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    /* renamed from: a */
    public void onBindDataToView(d dVar) {
        if (dVar != null && dVar.aVi != null && dVar.aVi.rO() != null) {
            this.ctE = dVar;
            this.aVq.setText(dVar.aVi.getTitle());
            this.aVp.c(dVar.aVi.rO().cover, 10, false);
            this.ctD.k(dVar.aVi);
            onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.m9getInst().getSkinType());
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.j(this.aVr, r.g.addresslist_item_bg);
            ap.i((View) this.aVq, r.e.cp_cont_i);
            ap.j(this.aVv, r.g.addresslist_item_bg);
            this.ctD.onChangeSkinType(tbPageContext, i);
            this.mSkinType = i;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == getView()) {
            if (MessageManager.getInstance().findTask(CmdConfigCustom.CMD_ALA_LIVE_ROOM_START) == null) {
                com.baidu.adp.lib.util.k.m(this.mContext, this.mContext.getString(r.l.plugin_config_not_found));
            } else if (com.baidu.adp.lib.util.i.gk()) {
                j(this.mTbPageContext);
            } else {
                com.baidu.adp.lib.util.k.m(this.mContext, this.mContext.getString(r.l.neterror));
            }
        }
    }

    public void j(TbPageContext<?> tbPageContext) {
        if (tbPageContext != null && this.ctE != null && this.ctE.aVi != null && this.ctE.aVi.getAuthor() != null && this.ctE.aVi.rO() != null) {
            boolean z = false;
            String str = "";
            if (TbadkCoreApplication.getCurrentAccountInfo() != null) {
                String userId = this.ctE.aVi.getAuthor().getUserId();
                str = TbadkCoreApplication.getCurrentAccount();
                z = TextUtils.equals(userId, str);
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.setLiveID(this.ctE.aVi.rO().live_id);
            alaLiveInfoCoreData.setGroupID(this.ctE.aVi.rO().group_id);
            alaLiveInfoCoreData.setHslUrl(this.ctE.aVi.rO().hls_url);
            alaLiveInfoCoreData.setLiveCover(this.ctE.aVi.rO().cover);
            alaLiveInfoCoreData.setLiveTitle(this.ctE.aVi.rO().description);
            alaLiveInfoCoreData.setRtmpUrl(this.ctE.aVi.rO().rtmp_url);
            alaLiveInfoCoreData.setSessionID(this.ctE.aVi.rO().session_id);
            alaLiveInfoCoreData.setUserName(this.ctE.aVi.rO().Pe.user_name);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(tbPageContext.getPageActivity(), alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_HOME_LIVE_PLAY, str, z)));
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            ar arVar = new ar("c11827");
            arVar.ab("tid", this.ctE.aVi.getTid());
            arVar.ab(SapiAccountManager.SESSION_UID, currentAccount);
            TiebaStatic.log(arVar);
        }
    }
}
