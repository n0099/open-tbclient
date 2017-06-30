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
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class e extends com.baidu.tieba.card.a<d> {
    private View.OnClickListener amF;
    private View.OnClickListener amS;
    private TbImageView bdr;
    private TextView bds;
    private RelativeLayout bdt;
    private FrameLayout bdw;
    private View bdx;
    private ThreadLiveAndRecordUserInfoLayout cGU;
    private d cGV;

    public e(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.amS = new f(this);
        this.amF = new g(this);
        initView();
    }

    private void initView() {
        this.bdt = (RelativeLayout) getView().findViewById(w.h.rlAlaLivePane);
        ViewGroup.LayoutParams layoutParams = this.bdt.getLayoutParams();
        layoutParams.height = com.baidu.adp.lib.util.k.af(this.mContext) * 1;
        this.bdt.setLayoutParams(layoutParams);
        getView().setOnClickListener(this);
        this.bdw = (FrameLayout) getView().findViewById(w.h.flAlaLiveTitlePane);
        this.bdr = (TbImageView) getView().findViewById(w.h.imgAlaLiveView);
        this.bdr.setDefaultErrorResource(0);
        this.bdr.setDefaultBgResource(w.g.pic_bg_video_frs);
        this.bds = (TextView) getView().findViewById(w.h.tvAlaLiveTitle);
        this.cGU = (ThreadLiveAndRecordUserInfoLayout) getView().findViewById(w.h.layoutAlaUserCard);
        this.cGU.setForumAfterClickListener(this.amF);
        this.cGU.setUserAfterClickListener(this.amS);
        this.cGU.setBarNameClickEnabled(true);
        this.bdx = getView().findViewById(w.h.dividerBottom);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return w.j.card_ala_live_feed_view;
    }

    public void i(BdUniqueId bdUniqueId) {
        if (bdUniqueId == null || this.cGU == null) {
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(d dVar) {
        if (dVar != null && dVar.bai != null && dVar.bai.rJ() != null) {
            this.cGV = dVar;
            this.bds.setText(dVar.bai.getTitle());
            this.bdr.c(dVar.bai.rJ().cover, 10, false);
            this.cGU.t(dVar.bai);
            d(this.mTbPageContext, TbadkCoreApplication.m9getInst().getSkinType());
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            as.j(this.bdt, w.g.addresslist_item_bg);
            as.i(this.bds, w.e.cp_cont_i);
            as.j(this.bdx, w.e.cp_bg_line_d);
            this.cGU.d(tbPageContext, i);
            this.mSkinType = i;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == getView()) {
            if (MessageManager.getInstance().findTask(CmdConfigCustom.CMD_ALA_LIVE_ROOM_START) == null) {
                com.baidu.adp.lib.util.k.F(this.mContext, this.mContext.getString(w.l.plugin_config_not_found));
            } else if (com.baidu.adp.lib.util.i.hj()) {
                h(this.mTbPageContext);
            } else {
                com.baidu.adp.lib.util.k.F(this.mContext, this.mContext.getString(w.l.no_network_guide));
            }
        }
    }

    public void h(TbPageContext<?> tbPageContext) {
        if (tbPageContext != null && this.cGV != null && this.cGV.bai != null && this.cGV.bai.getAuthor() != null && this.cGV.bai.rJ() != null) {
            boolean z = false;
            String str = "";
            if (TbadkCoreApplication.getCurrentAccountInfo() != null) {
                String userId = this.cGV.bai.getAuthor().getUserId();
                str = TbadkCoreApplication.getCurrentAccount();
                z = TextUtils.equals(userId, str);
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(this.cGV.bai.rJ());
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(tbPageContext.getPageActivity(), alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_HOME_LIVE_PLAY, str, z, "")));
            int i = this.cGV.bai.rJ().live_type;
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            au auVar = new au("c11827");
            auVar.Z("tid", this.cGV.bai.getTid());
            auVar.Z(SapiAccountManager.SESSION_UID, currentAccount);
            auVar.r("obj_type", i);
            TiebaStatic.log(auVar);
        }
    }
}
