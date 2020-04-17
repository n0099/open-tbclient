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
import com.baidu.live.data.g;
import com.baidu.live.data.h;
import com.baidu.live.data.n;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.atomdata.AlaPersonCardActivityConfig;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.log.LogManager;
import com.baidu.live.tieba.horizonallist.widget.AdapterView;
import com.baidu.live.u.a;
import com.baidu.live.view.AlphaGradientHListView;
/* loaded from: classes3.dex */
public class c {
    private n aDE;
    private ViewGroup faQ;
    private com.baidu.live.liveroom.a.a fyD;
    private a fyE;
    public FrameLayout fyF;
    private AlphaGradientHListView fyG;
    private String fyH;
    private boolean fyI;
    private String mGroupId;
    private String mLiveId;
    private TbPageContext mTbPageContext;
    private String otherParams;
    private AdapterView.c fyJ = new AdapterView.c() { // from class: com.baidu.tieba.ala.liveroom.audiencelist.c.1
        @Override // com.baidu.live.tieba.horizonallist.widget.AdapterView.c
        public void a(AdapterView<?> adapterView, View view, int i, long j) {
            g gVar = (g) c.this.fyE.getItem(i);
            if (gVar != null) {
                if (c.this.fyD != null) {
                    c.this.fyD.cr(5);
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(c.this.getPageContext().getPageActivity(), String.valueOf(gVar.aqe.userId), gVar.aqe.userName, gVar.aqe.portrait, gVar.aqe.sex, gVar.aqe.levelId, null, null, 0L, gVar.aqe.fansCount, gVar.aqe.followCount, gVar.aqe.userStatus, c.this.mGroupId, c.this.mLiveId, c.this.fyI, c.this.fyH, gVar.aqe.appId, gVar.aqe.userName, c.this.otherParams)));
                LogManager.getCommonLogger().doClickTopRightAuthorLog(c.this.aDE.mLiveInfo.feed_id, i, c.this.Cr());
            }
        }
    };
    CustomMessageListener fal = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.liveroom.audiencelist.c.2
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
        this.fyD = aVar;
        this.fyI = z;
        MessageManager.getInstance().registerListener(this.fal);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TbPageContext getPageContext() {
        return this.mTbPageContext;
    }

    public void a(String str, String str2, String str3, n nVar) {
        this.mGroupId = str;
        this.mLiveId = str2;
        this.fyH = str3;
        this.aDE = nVar;
    }

    public void c(ViewGroup viewGroup, int i, int i2) {
        if (viewGroup != null) {
            if (this.fyF == null) {
                this.fyF = (FrameLayout) LayoutInflater.from(getPageContext().getPageActivity()).inflate(a.h.ala_live_audience_list_layout, (ViewGroup) null);
            }
            if (this.faQ != null && this.faQ.indexOfChild(this.fyF) > 0) {
                this.faQ.removeView(this.fyF);
            }
            this.faQ = viewGroup;
            this.fyF.setId(a.g.ala_liveroom_audience);
            this.fyG = (AlphaGradientHListView) this.fyF.findViewById(a.g.ala_live_guest_listview);
            this.fyG.setDividerWidth(BdUtilHelper.getDimens(getPageContext().getPageActivity(), a.e.sdk_ds0));
            this.fyE = new a(getPageContext().getPageActivity());
            this.fyG.setAdapter((ListAdapter) this.fyE);
            this.fyG.setSelector(getPageContext().getPageActivity().getResources().getDrawable(a.f.sdk_transparent_bg));
            this.fyG.setOnItemClickListener(this.fyJ);
            this.fyG.setColor(getPageContext().getResources().getColor(a.d.sdk_white_alpha100), getPageContext().getResources().getColor(a.d.sdk_white_alpha0));
            this.fyG.setNeedAlphaShade(true);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, BdUtilHelper.getDimens(getPageContext().getPageActivity(), a.e.sdk_ds82));
            layoutParams.addRule(1, i);
            layoutParams.addRule(8, i);
            layoutParams.addRule(0, i2);
            layoutParams.leftMargin = BdUtilHelper.getDimens(getPageContext().getPageActivity(), a.e.sdk_ds10);
            layoutParams.rightMargin = BdUtilHelper.dip2px(getPageContext().getPageActivity(), -6.0f);
            this.faQ.addView(this.fyF, layoutParams);
        }
    }

    public void cl(int i) {
    }

    public void e(h hVar) {
        if (this.fyE != null) {
            this.fyE.d(hVar);
            this.fyE.notifyDataSetChanged();
        }
    }

    public boolean c(g gVar) {
        if (this.fyE == null || !this.fyE.b(gVar)) {
            return false;
        }
        this.fyE.notifyDataSetChanged();
        return true;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.fal);
    }

    public String Cr() {
        return this.otherParams;
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }
}
