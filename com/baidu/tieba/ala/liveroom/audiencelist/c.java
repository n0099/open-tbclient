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
    private r aAh;
    private ViewGroup fZu;
    private com.baidu.live.liveroom.a.a gph;
    private a gpi;
    public FrameLayout gpj;
    public FrameLayout gpk;
    private AlphaGradientHListView gpl;
    private String gpm;
    private boolean gpn;
    private String mGroupId;
    private String mLiveId;
    private TbPageContext mTbPageContext;
    private String otherParams;
    private AdapterView.c gpo = new AdapterView.c() { // from class: com.baidu.tieba.ala.liveroom.audiencelist.c.1
        @Override // com.baidu.live.tieba.horizonallist.widget.AdapterView.c
        public void a(AdapterView<?> adapterView, View view, int i, long j) {
            j jVar = (j) c.this.gpi.getItem(i);
            if (jVar != null) {
                if (c.this.gph != null) {
                    c.this.gph.ey(5);
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(c.this.getPageContext().getPageActivity(), String.valueOf(jVar.aDE.userId), jVar.aDE.userName, jVar.aDE.portrait, jVar.aDE.sex, jVar.aDE.levelId, null, null, 0L, jVar.aDE.fansCount, jVar.aDE.followCount, jVar.aDE.userStatus, c.this.mGroupId, c.this.mLiveId, c.this.gpn, c.this.gpm, jVar.aDE.appId, jVar.aDE.userName, c.this.otherParams)));
                LogManager.getCommonLogger().doClickTopRightAuthorLog(c.this.aAh.mLiveInfo.feed_id, i, c.this.JY());
            }
        }
    };
    CustomMessageListener fPP = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.liveroom.audiencelist.c.2
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
        this.gph = aVar;
        this.gpn = z;
        MessageManager.getInstance().registerListener(this.fPP);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TbPageContext getPageContext() {
        return this.mTbPageContext;
    }

    public void a(String str, String str2, String str3, r rVar) {
        this.mGroupId = str;
        this.mLiveId = str2;
        this.gpm = str3;
        this.aAh = rVar;
    }

    public void c(ViewGroup viewGroup, int i, int i2) {
        if (viewGroup != null) {
            if (this.gpj == null) {
                this.gpj = (FrameLayout) LayoutInflater.from(getPageContext().getPageActivity()).inflate(a.h.ala_live_audience_list_layout, (ViewGroup) null);
            }
            if (this.fZu != null && this.fZu.indexOfChild(this.gpj) > 0) {
                this.fZu.removeView(this.gpj);
            }
            this.fZu = viewGroup;
            this.gpj.setId(a.g.ala_liveroom_audience);
            this.gpk = (FrameLayout) this.gpj.findViewById(a.g.content_layout);
            this.gpl = (AlphaGradientHListView) this.gpj.findViewById(a.g.ala_live_guest_listview);
            this.gpl.setDividerWidth(BdUtilHelper.getDimens(getPageContext().getPageActivity(), a.e.sdk_ds0));
            this.gpi = new a(getPageContext().getPageActivity());
            this.gpl.setAdapter((ListAdapter) this.gpi);
            this.gpl.setSelector(getPageContext().getPageActivity().getResources().getDrawable(a.f.sdk_transparent_bg));
            this.gpl.setOnItemClickListener(this.gpo);
            this.gpl.setColor(getPageContext().getResources().getColor(a.d.sdk_white_alpha100), getPageContext().getResources().getColor(a.d.sdk_white_alpha0));
            this.gpl.setNeedAlphaShade(true);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, BdUtilHelper.getDimens(getPageContext().getPageActivity(), a.e.sdk_ds82));
            layoutParams.addRule(1, i);
            layoutParams.addRule(8, i);
            layoutParams.addRule(0, i2);
            layoutParams.leftMargin = BdUtilHelper.getDimens(getPageContext().getPageActivity(), a.e.sdk_ds10);
            layoutParams.rightMargin = BdUtilHelper.dip2px(getPageContext().getPageActivity(), -6.0f);
            this.fZu.addView(this.gpj, layoutParams);
        }
    }

    public void dz(int i) {
    }

    public void e(k kVar) {
        if (this.gpi != null) {
            this.gpi.d(kVar);
            this.gpi.notifyDataSetChanged();
        }
    }

    public boolean c(j jVar) {
        if (this.gpi == null || !this.gpi.b(jVar)) {
            return false;
        }
        this.gpi.notifyDataSetChanged();
        return true;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.fPP);
    }

    public String JY() {
        return this.otherParams;
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }
}
