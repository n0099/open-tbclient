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
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class c extends com.baidu.tieba.card.a<b> {
    private View.OnClickListener anD;
    private View.OnClickListener ann;
    private TbImageView bfd;
    private TextView bfe;
    private RelativeLayout bff;
    private FrameLayout bfi;
    private View bfj;
    private ThreadLiveAndRecordUserInfoLayout cOe;
    private b cOf;

    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.anD = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.alalivelist.view.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.VZ() != null) {
                    c.this.VZ().a(view, c.this.cOf);
                }
            }
        };
        this.ann = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.alalivelist.view.c.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.VZ() != null) {
                    c.this.VZ().a(view, c.this.cOf);
                }
            }
        };
        initView();
    }

    private void initView() {
        this.bff = (RelativeLayout) getView().findViewById(d.h.rlAlaLivePane);
        ViewGroup.LayoutParams layoutParams = this.bff.getLayoutParams();
        layoutParams.height = k.af(this.mContext) * 1;
        this.bff.setLayoutParams(layoutParams);
        getView().setOnClickListener(this);
        this.bfi = (FrameLayout) getView().findViewById(d.h.flAlaLiveTitlePane);
        this.bfd = (TbImageView) getView().findViewById(d.h.imgAlaLiveView);
        this.bfd.setDefaultErrorResource(0);
        this.bfd.setDefaultBgResource(d.g.pic_bg_video_frs);
        this.bfe = (TextView) getView().findViewById(d.h.tvAlaLiveTitle);
        this.cOe = (ThreadLiveAndRecordUserInfoLayout) getView().findViewById(d.h.layoutAlaUserCard);
        this.cOe.setForumAfterClickListener(this.ann);
        this.cOe.setUserAfterClickListener(this.anD);
        this.cOe.setBarNameClickEnabled(true);
        this.bfj = getView().findViewById(d.h.dividerBottom);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.j.card_ala_live_feed_view;
    }

    public void i(BdUniqueId bdUniqueId) {
        if (bdUniqueId == null || this.cOe == null) {
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(b bVar) {
        if (bVar != null && bVar.bbB != null && bVar.bbB.rN() != null) {
            this.cOf = bVar;
            this.bfe.setText(bVar.bbB.getTitle());
            this.bfd.c(bVar.bbB.rN().cover, 10, false);
            this.cOe.x(bVar.bbB);
            d(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ai.j(this.bff, d.g.addresslist_item_bg);
            ai.i(this.bfe, d.e.cp_cont_i);
            ai.j(this.bfj, d.e.cp_bg_line_d);
            this.cOe.d(tbPageContext, i);
            this.mSkinType = i;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == getView()) {
            if (MessageManager.getInstance().findTask(CmdConfigCustom.CMD_ALA_LIVE_ROOM_START) == null) {
                k.F(this.mContext, this.mContext.getString(d.l.plugin_config_not_found));
            } else if (i.hh()) {
                i(this.mTbPageContext);
            } else {
                k.F(this.mContext, this.mContext.getString(d.l.no_network_guide));
            }
        }
    }

    public void i(TbPageContext<?> tbPageContext) {
        if (tbPageContext != null && this.cOf != null && this.cOf.bbB != null && this.cOf.bbB.getAuthor() != null && this.cOf.bbB.rN() != null) {
            boolean z = false;
            String str = "";
            if (TbadkCoreApplication.getCurrentAccountInfo() != null) {
                String userId = this.cOf.bbB.getAuthor().getUserId();
                str = TbadkCoreApplication.getCurrentAccount();
                z = TextUtils.equals(userId, str);
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(this.cOf.bbB.rN());
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(tbPageContext.getPageActivity(), alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_HOME_LIVE_PLAY, str, z, "")));
            int i = this.cOf.bbB.rN().live_type;
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            aj ajVar = new aj("c11827");
            ajVar.aa("tid", this.cOf.bbB.getTid());
            ajVar.aa(SapiAccountManager.SESSION_UID, currentAccount);
            ajVar.r("obj_type", i);
            TiebaStatic.log(ajVar);
        }
    }
}
