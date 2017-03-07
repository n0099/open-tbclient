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
    private View.OnClickListener alM;
    private View.OnClickListener amj;
    private TbImageView bbC;
    private TextView bbD;
    private RelativeLayout bbE;
    private FrameLayout bbH;
    private View bbI;
    private ThreadLiveAndRecordUserInfoLayout cvc;
    private d cvd;

    public e(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.amj = new f(this);
        this.alM = new g(this);
        initView();
    }

    private void initView() {
        this.bbE = (RelativeLayout) getView().findViewById(w.h.rlAlaLivePane);
        ViewGroup.LayoutParams layoutParams = this.bbE.getLayoutParams();
        layoutParams.height = com.baidu.adp.lib.util.k.ag(this.mContext) * 1;
        this.bbE.setLayoutParams(layoutParams);
        getView().setOnClickListener(this);
        this.bbH = (FrameLayout) getView().findViewById(w.h.flAlaLiveTitlePane);
        this.bbC = (TbImageView) getView().findViewById(w.h.imgAlaLiveView);
        this.bbC.setDefaultErrorResource(0);
        this.bbC.setDefaultBgResource(w.g.pic_bg_video_frs);
        this.bbD = (TextView) getView().findViewById(w.h.tvAlaLiveTitle);
        this.cvc = (ThreadLiveAndRecordUserInfoLayout) getView().findViewById(w.h.layoutAlaUserCard);
        this.cvc.setForumAfterClickListener(this.alM);
        this.cvc.setUserAfterClickListener(this.amj);
        this.cvc.setBarNameClickEnabled(true);
        this.bbI = getView().findViewById(w.h.dividerBottom);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return w.j.card_ala_live_feed_view;
    }

    public void i(BdUniqueId bdUniqueId) {
        if (bdUniqueId == null || this.cvc == null) {
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    /* renamed from: a */
    public void onBindDataToView(d dVar) {
        if (dVar != null && dVar.bbv != null && dVar.bbv.si() != null) {
            this.cvd = dVar;
            this.bbD.setText(dVar.bbv.getTitle());
            this.bbC.c(dVar.bbv.si().cover, 10, false);
            this.cvc.k(dVar.bbv);
            onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.m9getInst().getSkinType());
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aq.j(this.bbE, w.g.addresslist_item_bg);
            aq.i((View) this.bbD, w.e.cp_cont_i);
            aq.j(this.bbI, w.e.cp_bg_line_d);
            this.cvc.onChangeSkinType(tbPageContext, i);
            this.mSkinType = i;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == getView()) {
            if (MessageManager.getInstance().findTask(CmdConfigCustom.CMD_ALA_LIVE_ROOM_START) == null) {
                com.baidu.adp.lib.util.k.G(this.mContext, this.mContext.getString(w.l.plugin_config_not_found));
            } else if (com.baidu.adp.lib.util.i.he()) {
                j(this.mTbPageContext);
            } else {
                com.baidu.adp.lib.util.k.G(this.mContext, this.mContext.getString(w.l.neterror));
            }
        }
    }

    public void j(TbPageContext<?> tbPageContext) {
        if (tbPageContext != null && this.cvd != null && this.cvd.bbv != null && this.cvd.bbv.getAuthor() != null && this.cvd.bbv.si() != null) {
            boolean z = false;
            String str = "";
            if (TbadkCoreApplication.getCurrentAccountInfo() != null) {
                String userId = this.cvd.bbv.getAuthor().getUserId();
                str = TbadkCoreApplication.getCurrentAccount();
                z = TextUtils.equals(userId, str);
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.setLiveID(this.cvd.bbv.si().live_id);
            alaLiveInfoCoreData.setGroupID(this.cvd.bbv.si().group_id);
            alaLiveInfoCoreData.setHslUrl(this.cvd.bbv.si().hls_url);
            alaLiveInfoCoreData.setLiveCover(this.cvd.bbv.si().cover);
            alaLiveInfoCoreData.setLiveTitle(this.cvd.bbv.si().description);
            alaLiveInfoCoreData.setRtmpUrl(this.cvd.bbv.si().rtmp_url);
            alaLiveInfoCoreData.setSessionID(this.cvd.bbv.si().session_id);
            alaLiveInfoCoreData.setUserName(this.cvd.bbv.si().Ug.user_name);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(tbPageContext.getPageActivity(), alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_HOME_LIVE_PLAY, str, z)));
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            as asVar = new as("c11827");
            asVar.Z("tid", this.cvd.bbv.getTid());
            asVar.Z(SapiAccountManager.SESSION_UID, currentAccount);
            TiebaStatic.log(asVar);
        }
    }
}
