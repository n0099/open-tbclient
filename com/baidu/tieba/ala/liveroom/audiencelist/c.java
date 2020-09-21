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
import com.baidu.live.data.m;
import com.baidu.live.data.n;
import com.baidu.live.data.u;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.atomdata.AlaPersonCardActivityConfig;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.log.LogManager;
import com.baidu.live.tieba.horizonallist.widget.AdapterView;
import com.baidu.live.view.AlphaGradientHListView;
/* loaded from: classes4.dex */
public class c {
    private u aAP;
    private ViewGroup gcM;
    private a gsA;
    public FrameLayout gsB;
    public FrameLayout gsC;
    private AlphaGradientHListView gsD;
    private String gsE;
    private boolean gsF;
    private com.baidu.live.liveroom.a.a gsz;
    private String mGroupId;
    private String mLiveId;
    private TbPageContext mTbPageContext;
    private String otherParams;
    private AdapterView.c gsG = new AdapterView.c() { // from class: com.baidu.tieba.ala.liveroom.audiencelist.c.1
        @Override // com.baidu.live.tieba.horizonallist.widget.AdapterView.c
        public void a(AdapterView<?> adapterView, View view, int i, long j) {
            m mVar = (m) c.this.gsA.getItem(i);
            if (mVar != null) {
                if (c.this.gsz != null) {
                    c.this.gsz.eC(5);
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(c.this.getPageContext().getPageActivity(), String.valueOf(mVar.aEz.userId), mVar.aEz.userName, mVar.aEz.portrait, mVar.aEz.sex, mVar.aEz.levelId, null, null, 0L, mVar.aEz.fansCount, mVar.aEz.followCount, mVar.aEz.userStatus, c.this.mGroupId, c.this.mLiveId, c.this.gsF, c.this.gsE, mVar.aEz.appId, mVar.aEz.userName, c.this.otherParams)));
                LogManager.getCommonLogger().doClickTopRightAuthorLog(c.this.aAP.mLiveInfo.feed_id, i, c.this.KD());
            }
        }
    };
    CustomMessageListener fTe = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.liveroom.audiencelist.c.2
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
        this.gsz = aVar;
        this.gsF = z;
        MessageManager.getInstance().registerListener(this.fTe);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TbPageContext getPageContext() {
        return this.mTbPageContext;
    }

    public void a(String str, String str2, String str3, u uVar) {
        this.mGroupId = str;
        this.mLiveId = str2;
        this.gsE = str3;
        this.aAP = uVar;
    }

    public void c(ViewGroup viewGroup, int i, int i2) {
        if (viewGroup != null) {
            if (this.gsB == null) {
                this.gsB = (FrameLayout) LayoutInflater.from(getPageContext().getPageActivity()).inflate(a.h.ala_live_audience_list_layout, (ViewGroup) null);
            }
            if (this.gcM != null && this.gcM.indexOfChild(this.gsB) > 0) {
                this.gcM.removeView(this.gsB);
            }
            this.gcM = viewGroup;
            this.gsB.setId(a.g.ala_liveroom_audience);
            this.gsC = (FrameLayout) this.gsB.findViewById(a.g.content_layout);
            this.gsD = (AlphaGradientHListView) this.gsB.findViewById(a.g.ala_live_guest_listview);
            this.gsD.setDividerWidth(BdUtilHelper.getDimens(getPageContext().getPageActivity(), a.e.sdk_ds0));
            this.gsA = new a(getPageContext().getPageActivity());
            this.gsD.setAdapter((ListAdapter) this.gsA);
            this.gsD.setSelector(getPageContext().getPageActivity().getResources().getDrawable(a.f.sdk_transparent_bg));
            this.gsD.setOnItemClickListener(this.gsG);
            this.gsD.setColor(getPageContext().getResources().getColor(a.d.sdk_white_alpha100), getPageContext().getResources().getColor(a.d.sdk_white_alpha0));
            this.gsD.setNeedAlphaShade(true);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, BdUtilHelper.getDimens(getPageContext().getPageActivity(), a.e.sdk_ds82));
            layoutParams.addRule(1, i);
            layoutParams.addRule(8, i);
            layoutParams.addRule(0, i2);
            layoutParams.leftMargin = BdUtilHelper.getDimens(getPageContext().getPageActivity(), a.e.sdk_ds10);
            layoutParams.rightMargin = BdUtilHelper.dip2px(getPageContext().getPageActivity(), -6.0f);
            this.gcM.addView(this.gsB, layoutParams);
        }
    }

    public void dD(int i) {
    }

    public void e(n nVar) {
        if (this.gsA != null) {
            this.gsA.d(nVar);
            this.gsA.notifyDataSetChanged();
        }
    }

    public boolean c(m mVar) {
        if (this.gsA == null || !this.gsA.b(mVar)) {
            return false;
        }
        this.gsA.notifyDataSetChanged();
        return true;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.fTe);
    }

    public String KD() {
        return this.otherParams;
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }
}
