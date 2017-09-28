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
    private View.OnClickListener anJ;
    private View.OnClickListener anr;
    private TbImageView bia;
    private TextView bib;
    private RelativeLayout bic;
    private FrameLayout bih;
    private View bii;
    private ThreadLiveAndRecordUserInfoLayout cVb;
    private b cVc;

    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.anJ = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.alalivelist.view.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.Xr() != null) {
                    c.this.Xr().a(view, c.this.cVc);
                }
            }
        };
        this.anr = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.alalivelist.view.c.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.Xr() != null) {
                    c.this.Xr().a(view, c.this.cVc);
                }
            }
        };
        initView();
    }

    private void initView() {
        this.bic = (RelativeLayout) getView().findViewById(d.h.rlAlaLivePane);
        ViewGroup.LayoutParams layoutParams = this.bic.getLayoutParams();
        layoutParams.height = l.ad(this.mContext) * 1;
        this.bic.setLayoutParams(layoutParams);
        getView().setOnClickListener(this);
        this.bih = (FrameLayout) getView().findViewById(d.h.flAlaLiveTitlePane);
        this.bia = (TbImageView) getView().findViewById(d.h.imgAlaLiveView);
        this.bia.setDefaultErrorResource(0);
        this.bia.setDefaultBgResource(d.g.pic_bg_video_frs);
        this.bib = (TextView) getView().findViewById(d.h.tvAlaLiveTitle);
        this.cVb = (ThreadLiveAndRecordUserInfoLayout) getView().findViewById(d.h.layoutAlaUserCard);
        this.cVb.setForumAfterClickListener(this.anr);
        this.cVb.setUserAfterClickListener(this.anJ);
        this.cVb.setBarNameClickEnabled(true);
        this.bii = getView().findViewById(d.h.dividerBottom);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.j.card_ala_live_feed_view;
    }

    public void h(BdUniqueId bdUniqueId) {
        if (bdUniqueId == null || this.cVb == null) {
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(b bVar) {
        if (bVar != null && bVar.bes != null && bVar.bes.rN() != null) {
            this.cVc = bVar;
            this.bib.setText(bVar.bes.getTitle());
            this.bia.c(bVar.bes.rN().cover, 10, false);
            this.cVb.w(bVar.bes);
            d(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.j(this.bic, d.g.addresslist_item_bg);
            aj.i(this.bib, d.e.cp_cont_i);
            aj.j(this.bii, d.e.cp_bg_line_d);
            this.cVb.d(tbPageContext, i);
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
        if (tbPageContext != null && this.cVc != null && this.cVc.bes != null && this.cVc.bes.getAuthor() != null && this.cVc.bes.rN() != null) {
            boolean z = false;
            String str = "";
            if (TbadkCoreApplication.getCurrentAccountInfo() != null) {
                String userId = this.cVc.bes.getAuthor().getUserId();
                str = TbadkCoreApplication.getCurrentAccount();
                z = TextUtils.equals(userId, str);
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(this.cVc.bes.rN());
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(tbPageContext.getPageActivity(), alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_HOME_LIVE_PLAY, str, z, "")));
            int i = this.cVc.bes.rN().live_type;
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            ak akVar = new ak("c11827");
            akVar.ad("tid", this.cVc.bes.getTid());
            akVar.ad(SapiAccountManager.SESSION_UID, currentAccount);
            akVar.r("obj_type", i);
            TiebaStatic.log(akVar);
        }
    }
}
