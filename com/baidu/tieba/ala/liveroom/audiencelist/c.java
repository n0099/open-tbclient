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
import com.baidu.live.data.q;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.atomdata.AlaPersonCardActivityConfig;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.log.LogManager;
import com.baidu.live.tieba.horizonallist.widget.AdapterView;
import com.baidu.live.view.AlphaGradientHListView;
/* loaded from: classes3.dex */
public class c {
    private q aLQ;
    private ViewGroup fIb;
    private com.baidu.live.liveroom.a.a fXS;
    private a fXT;
    public FrameLayout fXU;
    public FrameLayout fXV;
    private AlphaGradientHListView fXW;
    private String fXX;
    private boolean fXY;
    private AdapterView.c fXZ = new AdapterView.c() { // from class: com.baidu.tieba.ala.liveroom.audiencelist.c.1
        @Override // com.baidu.live.tieba.horizonallist.widget.AdapterView.c
        public void a(AdapterView<?> adapterView, View view, int i, long j) {
            j jVar = (j) c.this.fXT.getItem(i);
            if (jVar != null) {
                if (c.this.fXS != null) {
                    c.this.fXS.cG(5);
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(c.this.getPageContext().getPageActivity(), String.valueOf(jVar.axp.userId), jVar.axp.userName, jVar.axp.portrait, jVar.axp.sex, jVar.axp.levelId, null, null, 0L, jVar.axp.fansCount, jVar.axp.followCount, jVar.axp.userStatus, c.this.mGroupId, c.this.mLiveId, c.this.fXY, c.this.fXX, jVar.axp.appId, jVar.axp.userName, c.this.otherParams)));
                LogManager.getCommonLogger().doClickTopRightAuthorLog(c.this.aLQ.mLiveInfo.feed_id, i, c.this.Ep());
            }
        }
    };
    CustomMessageListener fzr = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.liveroom.audiencelist.c.2
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
    private String mGroupId;
    private String mLiveId;
    private TbPageContext mTbPageContext;
    private String otherParams;

    public c(TbPageContext tbPageContext, com.baidu.live.liveroom.a.a aVar, boolean z) {
        this.mTbPageContext = tbPageContext;
        this.fXS = aVar;
        this.fXY = z;
        MessageManager.getInstance().registerListener(this.fzr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TbPageContext getPageContext() {
        return this.mTbPageContext;
    }

    public void a(String str, String str2, String str3, q qVar) {
        this.mGroupId = str;
        this.mLiveId = str2;
        this.fXX = str3;
        this.aLQ = qVar;
    }

    public void c(ViewGroup viewGroup, int i, int i2) {
        if (viewGroup != null) {
            if (this.fXU == null) {
                this.fXU = (FrameLayout) LayoutInflater.from(getPageContext().getPageActivity()).inflate(a.h.ala_live_audience_list_layout, (ViewGroup) null);
            }
            if (this.fIb != null && this.fIb.indexOfChild(this.fXU) > 0) {
                this.fIb.removeView(this.fXU);
            }
            this.fIb = viewGroup;
            this.fXU.setId(a.g.ala_liveroom_audience);
            this.fXV = (FrameLayout) this.fXU.findViewById(a.g.content_layout);
            this.fXW = (AlphaGradientHListView) this.fXU.findViewById(a.g.ala_live_guest_listview);
            this.fXW.setDividerWidth(BdUtilHelper.getDimens(getPageContext().getPageActivity(), a.e.sdk_ds0));
            this.fXT = new a(getPageContext().getPageActivity());
            this.fXW.setAdapter((ListAdapter) this.fXT);
            this.fXW.setSelector(getPageContext().getPageActivity().getResources().getDrawable(a.f.sdk_transparent_bg));
            this.fXW.setOnItemClickListener(this.fXZ);
            this.fXW.setColor(getPageContext().getResources().getColor(a.d.sdk_white_alpha100), getPageContext().getResources().getColor(a.d.sdk_white_alpha0));
            this.fXW.setNeedAlphaShade(true);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, BdUtilHelper.getDimens(getPageContext().getPageActivity(), a.e.sdk_ds82));
            layoutParams.addRule(1, i);
            layoutParams.addRule(8, i);
            layoutParams.addRule(0, i2);
            layoutParams.leftMargin = BdUtilHelper.getDimens(getPageContext().getPageActivity(), a.e.sdk_ds10);
            layoutParams.rightMargin = BdUtilHelper.dip2px(getPageContext().getPageActivity(), -6.0f);
            this.fIb.addView(this.fXU, layoutParams);
        }
    }

    public void cA(int i) {
    }

    public void e(k kVar) {
        if (this.fXT != null) {
            this.fXT.d(kVar);
            this.fXT.notifyDataSetChanged();
        }
    }

    public boolean c(j jVar) {
        if (this.fXT == null || !this.fXT.b(jVar)) {
            return false;
        }
        this.fXT.notifyDataSetChanged();
        return true;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.fzr);
    }

    public String Ep() {
        return this.otherParams;
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }
}
