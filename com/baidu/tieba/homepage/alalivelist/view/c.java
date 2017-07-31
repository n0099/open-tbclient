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
    private View.OnClickListener aoG;
    private View.OnClickListener aoW;
    private TbImageView bgn;
    private TextView bgo;
    private RelativeLayout bgp;
    private FrameLayout bgt;
    private View bgu;
    private b cPA;
    private ThreadLiveAndRecordUserInfoLayout cPz;

    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.aoW = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.alalivelist.view.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.We() != null) {
                    c.this.We().a(view, c.this.cPA);
                }
            }
        };
        this.aoG = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.alalivelist.view.c.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.We() != null) {
                    c.this.We().a(view, c.this.cPA);
                }
            }
        };
        initView();
    }

    private void initView() {
        this.bgp = (RelativeLayout) getView().findViewById(d.h.rlAlaLivePane);
        ViewGroup.LayoutParams layoutParams = this.bgp.getLayoutParams();
        layoutParams.height = k.ag(this.mContext) * 1;
        this.bgp.setLayoutParams(layoutParams);
        getView().setOnClickListener(this);
        this.bgt = (FrameLayout) getView().findViewById(d.h.flAlaLiveTitlePane);
        this.bgn = (TbImageView) getView().findViewById(d.h.imgAlaLiveView);
        this.bgn.setDefaultErrorResource(0);
        this.bgn.setDefaultBgResource(d.g.pic_bg_video_frs);
        this.bgo = (TextView) getView().findViewById(d.h.tvAlaLiveTitle);
        this.cPz = (ThreadLiveAndRecordUserInfoLayout) getView().findViewById(d.h.layoutAlaUserCard);
        this.cPz.setForumAfterClickListener(this.aoG);
        this.cPz.setUserAfterClickListener(this.aoW);
        this.cPz.setBarNameClickEnabled(true);
        this.bgu = getView().findViewById(d.h.dividerBottom);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.j.card_ala_live_feed_view;
    }

    public void i(BdUniqueId bdUniqueId) {
        if (bdUniqueId == null || this.cPz == null) {
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(b bVar) {
        if (bVar != null && bVar.bcL != null && bVar.bcL.rX() != null) {
            this.cPA = bVar;
            this.bgo.setText(bVar.bcL.getTitle());
            this.bgn.c(bVar.bcL.rX().cover, 10, false);
            this.cPz.x(bVar.bcL);
            d(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ai.j(this.bgp, d.g.addresslist_item_bg);
            ai.i(this.bgo, d.e.cp_cont_i);
            ai.j(this.bgu, d.e.cp_bg_line_d);
            this.cPz.d(tbPageContext, i);
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
        if (tbPageContext != null && this.cPA != null && this.cPA.bcL != null && this.cPA.bcL.getAuthor() != null && this.cPA.bcL.rX() != null) {
            boolean z = false;
            String str = "";
            if (TbadkCoreApplication.getCurrentAccountInfo() != null) {
                String userId = this.cPA.bcL.getAuthor().getUserId();
                str = TbadkCoreApplication.getCurrentAccount();
                z = TextUtils.equals(userId, str);
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(this.cPA.bcL.rX());
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(tbPageContext.getPageActivity(), alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_HOME_LIVE_PLAY, str, z, "")));
            int i = this.cPA.bcL.rX().live_type;
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            aj ajVar = new aj("c11827");
            ajVar.aa("tid", this.cPA.bcL.getTid());
            ajVar.aa(SapiAccountManager.SESSION_UID, currentAccount);
            ajVar.r("obj_type", i);
            TiebaStatic.log(ajVar);
        }
    }
}
