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
    private View.OnClickListener alO;
    private View.OnClickListener ama;
    private TbImageView bbo;
    private TextView bbp;
    private RelativeLayout bbq;
    private FrameLayout bbt;
    private View bbu;
    private ThreadLiveAndRecordUserInfoLayout czi;
    private d czj;

    public e(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.ama = new f(this);
        this.alO = new g(this);
        initView();
    }

    private void initView() {
        this.bbq = (RelativeLayout) getView().findViewById(w.h.rlAlaLivePane);
        ViewGroup.LayoutParams layoutParams = this.bbq.getLayoutParams();
        layoutParams.height = com.baidu.adp.lib.util.k.af(this.mContext) * 1;
        this.bbq.setLayoutParams(layoutParams);
        getView().setOnClickListener(this);
        this.bbt = (FrameLayout) getView().findViewById(w.h.flAlaLiveTitlePane);
        this.bbo = (TbImageView) getView().findViewById(w.h.imgAlaLiveView);
        this.bbo.setDefaultErrorResource(0);
        this.bbo.setDefaultBgResource(w.g.pic_bg_video_frs);
        this.bbp = (TextView) getView().findViewById(w.h.tvAlaLiveTitle);
        this.czi = (ThreadLiveAndRecordUserInfoLayout) getView().findViewById(w.h.layoutAlaUserCard);
        this.czi.setForumAfterClickListener(this.alO);
        this.czi.setUserAfterClickListener(this.ama);
        this.czi.setBarNameClickEnabled(true);
        this.bbu = getView().findViewById(w.h.dividerBottom);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return w.j.card_ala_live_feed_view;
    }

    public void i(BdUniqueId bdUniqueId) {
        if (bdUniqueId == null || this.czi == null) {
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(d dVar) {
        if (dVar != null && dVar.aYA != null && dVar.aYA.rM() != null) {
            this.czj = dVar;
            this.bbp.setText(dVar.aYA.getTitle());
            this.bbo.c(dVar.aYA.rM().cover, 10, false);
            this.czi.r(dVar.aYA);
            d(this.mTbPageContext, TbadkCoreApplication.m9getInst().getSkinType());
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aq.j(this.bbq, w.g.addresslist_item_bg);
            aq.i(this.bbp, w.e.cp_cont_i);
            aq.j(this.bbu, w.e.cp_bg_line_d);
            this.czi.d(tbPageContext, i);
            this.mSkinType = i;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == getView()) {
            if (MessageManager.getInstance().findTask(CmdConfigCustom.CMD_ALA_LIVE_ROOM_START) == null) {
                com.baidu.adp.lib.util.k.E(this.mContext, this.mContext.getString(w.l.plugin_config_not_found));
            } else if (com.baidu.adp.lib.util.i.hk()) {
                h(this.mTbPageContext);
            } else {
                com.baidu.adp.lib.util.k.E(this.mContext, this.mContext.getString(w.l.no_network_guide));
            }
        }
    }

    public void h(TbPageContext<?> tbPageContext) {
        if (tbPageContext != null && this.czj != null && this.czj.aYA != null && this.czj.aYA.getAuthor() != null && this.czj.aYA.rM() != null) {
            boolean z = false;
            String str = "";
            if (TbadkCoreApplication.getCurrentAccountInfo() != null) {
                String userId = this.czj.aYA.getAuthor().getUserId();
                str = TbadkCoreApplication.getCurrentAccount();
                z = TextUtils.equals(userId, str);
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.setLiveID(this.czj.aYA.rM().live_id);
            alaLiveInfoCoreData.setGroupID(this.czj.aYA.rM().group_id);
            alaLiveInfoCoreData.setHslUrl(this.czj.aYA.rM().hls_url);
            alaLiveInfoCoreData.setLiveCover(this.czj.aYA.rM().cover);
            alaLiveInfoCoreData.setLiveTitle(this.czj.aYA.rM().description);
            alaLiveInfoCoreData.setRtmpUrl(this.czj.aYA.rM().rtmp_url);
            alaLiveInfoCoreData.setSessionID(this.czj.aYA.rM().session_id);
            alaLiveInfoCoreData.setUserName(this.czj.aYA.rM().TG.user_name);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(tbPageContext.getPageActivity(), alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_HOME_LIVE_PLAY, str, z, "")));
            int i = this.czj.aYA.rM().live_type;
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            as asVar = new as("c11827");
            asVar.Z("tid", this.czj.aYA.getTid());
            asVar.Z(SapiAccountManager.SESSION_UID, currentAccount);
            asVar.r("obj_type", i);
            TiebaStatic.log(asVar);
        }
    }
}
