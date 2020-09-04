package com.baidu.tieba.ala.liveroom.audiencelist;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.data.j;
import com.baidu.live.data.k;
import com.baidu.live.data.r;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.atomdata.AlaPersonCardActivityConfig;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.log.LogManager;
import com.baidu.live.tieba.horizonallist.widget.AdapterView;
import com.baidu.live.view.AlphaGradientHListView;
/* loaded from: classes7.dex */
public class c {
    private r aAj;
    private ViewGroup fZy;
    private com.baidu.live.liveroom.a.a gpl;
    private a gpm;
    public FrameLayout gpn;
    public FrameLayout gpo;
    private AlphaGradientHListView gpp;
    private String gpq;
    private boolean gpr;
    private String mGroupId;
    private String mLiveId;
    private TbPageContext mTbPageContext;
    private String otherParams;
    private AdapterView.c gps = new AdapterView.c() { // from class: com.baidu.tieba.ala.liveroom.audiencelist.c.1
        @Override // com.baidu.live.tieba.horizonallist.widget.AdapterView.c
        public void a(AdapterView<?> adapterView, View view, int i, long j) {
            j jVar = (j) c.this.gpm.getItem(i);
            if (jVar != null) {
                if (c.this.gpl != null) {
                    c.this.gpl.ey(5);
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(c.this.getPageContext().getPageActivity(), String.valueOf(jVar.aDG.userId), jVar.aDG.userName, jVar.aDG.portrait, jVar.aDG.sex, jVar.aDG.levelId, null, null, 0L, jVar.aDG.fansCount, jVar.aDG.followCount, jVar.aDG.userStatus, c.this.mGroupId, c.this.mLiveId, c.this.gpr, c.this.gpq, jVar.aDG.appId, jVar.aDG.userName, c.this.otherParams)));
                LogManager.getCommonLogger().doClickTopRightAuthorLog(c.this.aAj.mLiveInfo.feed_id, i, c.this.JY());
            }
        }
    };
    CustomMessageListener fPT = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.liveroom.audiencelist.c.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (str == null) {
                    str = "";
                }
                c.this.otherParams = str;
            }
        }
    };

    public c(TbPageContext tbPageContext, com.baidu.live.liveroom.a.a aVar, boolean z) {
        this.mTbPageContext = tbPageContext;
        this.gpl = aVar;
        this.gpr = z;
        MessageManager.getInstance().registerListener(this.fPT);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TbPageContext getPageContext() {
        return this.mTbPageContext;
    }

    public void a(String str, String str2, String str3, r rVar) {
        this.mGroupId = str;
        this.mLiveId = str2;
        this.gpq = str3;
        this.aAj = rVar;
    }

    public void c(ViewGroup viewGroup, int i, int i2) {
        if (viewGroup != null) {
            if (this.gpn == null) {
                this.gpn = (FrameLayout) LayoutInflater.from(getPageContext().getPageActivity()).inflate(a.h.ala_live_audience_list_layout, (ViewGroup) null);
            }
            if (this.fZy != null && this.fZy.indexOfChild(this.gpn) > 0) {
                this.fZy.removeView(this.gpn);
            }
            this.fZy = viewGroup;
            this.gpn.setId(a.g.ala_liveroom_audience);
            this.gpo = (FrameLayout) this.gpn.findViewById(a.g.content_layout);
            this.gpp = (AlphaGradientHListView) this.gpn.findViewById(a.g.ala_live_guest_listview);
            this.gpp.setDividerWidth(BdUtilHelper.getDimens(getPageContext().getPageActivity(), a.e.sdk_ds0));
            this.gpm = new a(getPageContext().getPageActivity());
            this.gpp.setAdapter((ListAdapter) this.gpm);
            this.gpp.setSelector(getPageContext().getPageActivity().getResources().getDrawable(a.f.sdk_transparent_bg));
            this.gpp.setOnItemClickListener(this.gps);
            this.gpp.setColor(getPageContext().getResources().getColor(a.d.sdk_white_alpha100), getPageContext().getResources().getColor(a.d.sdk_white_alpha0));
            this.gpp.setNeedAlphaShade(true);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, BdUtilHelper.getDimens(getPageContext().getPageActivity(), a.e.sdk_ds82));
            layoutParams.addRule(1, i);
            layoutParams.addRule(8, i);
            layoutParams.addRule(0, i2);
            layoutParams.leftMargin = BdUtilHelper.getDimens(getPageContext().getPageActivity(), a.e.sdk_ds10);
            layoutParams.rightMargin = BdUtilHelper.dip2px(getPageContext().getPageActivity(), -6.0f);
            this.fZy.addView(this.gpn, layoutParams);
        }
    }

    public void dz(int i) {
    }

    public void e(k kVar) {
        if (this.gpm != null) {
            this.gpm.d(kVar);
            this.gpm.notifyDataSetChanged();
        }
    }

    public boolean c(j jVar) {
        if (this.gpm == null || !this.gpm.b(jVar)) {
            return false;
        }
        this.gpm.notifyDataSetChanged();
        return true;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.fPT);
    }

    public String JY() {
        return this.otherParams;
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }
}
