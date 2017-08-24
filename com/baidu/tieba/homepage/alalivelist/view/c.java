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
    private View.OnClickListener aoH;
    private View.OnClickListener aoX;
    private TbImageView bgo;
    private TextView bgp;
    private RelativeLayout bgq;
    private FrameLayout bgu;
    private View bgv;
    private ThreadLiveAndRecordUserInfoLayout cRw;
    private b cRx;

    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.aoX = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.alalivelist.view.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.Wx() != null) {
                    c.this.Wx().a(view, c.this.cRx);
                }
            }
        };
        this.aoH = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.alalivelist.view.c.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.Wx() != null) {
                    c.this.Wx().a(view, c.this.cRx);
                }
            }
        };
        initView();
    }

    private void initView() {
        this.bgq = (RelativeLayout) getView().findViewById(d.h.rlAlaLivePane);
        ViewGroup.LayoutParams layoutParams = this.bgq.getLayoutParams();
        layoutParams.height = k.ag(this.mContext) * 1;
        this.bgq.setLayoutParams(layoutParams);
        getView().setOnClickListener(this);
        this.bgu = (FrameLayout) getView().findViewById(d.h.flAlaLiveTitlePane);
        this.bgo = (TbImageView) getView().findViewById(d.h.imgAlaLiveView);
        this.bgo.setDefaultErrorResource(0);
        this.bgo.setDefaultBgResource(d.g.pic_bg_video_frs);
        this.bgp = (TextView) getView().findViewById(d.h.tvAlaLiveTitle);
        this.cRw = (ThreadLiveAndRecordUserInfoLayout) getView().findViewById(d.h.layoutAlaUserCard);
        this.cRw.setForumAfterClickListener(this.aoH);
        this.cRw.setUserAfterClickListener(this.aoX);
        this.cRw.setBarNameClickEnabled(true);
        this.bgv = getView().findViewById(d.h.dividerBottom);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.j.card_ala_live_feed_view;
    }

    public void i(BdUniqueId bdUniqueId) {
        if (bdUniqueId == null || this.cRw == null) {
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(b bVar) {
        if (bVar != null && bVar.bcN != null && bVar.bcN.rY() != null) {
            this.cRx = bVar;
            this.bgp.setText(bVar.bcN.getTitle());
            this.bgo.c(bVar.bcN.rY().cover, 10, false);
            this.cRw.x(bVar.bcN);
            d(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ai.j(this.bgq, d.g.addresslist_item_bg);
            ai.i(this.bgp, d.e.cp_cont_i);
            ai.j(this.bgv, d.e.cp_bg_line_d);
            this.cRw.d(tbPageContext, i);
            this.mSkinType = i;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == getView()) {
            if (MessageManager.getInstance().findTask(CmdConfigCustom.CMD_ALA_LIVE_ROOM_START) == null) {
                k.F(this.mContext, this.mContext.getString(d.l.plugin_config_not_found));
            } else if (i.hr()) {
                i(this.mTbPageContext);
            } else {
                k.F(this.mContext, this.mContext.getString(d.l.no_network_guide));
            }
        }
    }

    public void i(TbPageContext<?> tbPageContext) {
        if (tbPageContext != null && this.cRx != null && this.cRx.bcN != null && this.cRx.bcN.getAuthor() != null && this.cRx.bcN.rY() != null) {
            boolean z = false;
            String str = "";
            if (TbadkCoreApplication.getCurrentAccountInfo() != null) {
                String userId = this.cRx.bcN.getAuthor().getUserId();
                str = TbadkCoreApplication.getCurrentAccount();
                z = TextUtils.equals(userId, str);
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(this.cRx.bcN.rY());
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(tbPageContext.getPageActivity(), alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_HOME_LIVE_PLAY, str, z, "")));
            int i = this.cRx.bcN.rY().live_type;
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            aj ajVar = new aj("c11827");
            ajVar.aa("tid", this.cRx.bcN.getTid());
            ajVar.aa(SapiAccountManager.SESSION_UID, currentAccount);
            ajVar.r("obj_type", i);
            TiebaStatic.log(ajVar);
        }
    }
}
