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
    private n aDK;
    private ViewGroup faV;
    private com.baidu.live.liveroom.a.a fyI;
    private a fyJ;
    public FrameLayout fyK;
    private AlphaGradientHListView fyL;
    private String fyM;
    private boolean fyN;
    private String mGroupId;
    private String mLiveId;
    private TbPageContext mTbPageContext;
    private String otherParams;
    private AdapterView.c fyO = new AdapterView.c() { // from class: com.baidu.tieba.ala.liveroom.audiencelist.c.1
        @Override // com.baidu.live.tieba.horizonallist.widget.AdapterView.c
        public void a(AdapterView<?> adapterView, View view, int i, long j) {
            g gVar = (g) c.this.fyJ.getItem(i);
            if (gVar != null) {
                if (c.this.fyI != null) {
                    c.this.fyI.cr(5);
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(c.this.getPageContext().getPageActivity(), String.valueOf(gVar.aqk.userId), gVar.aqk.userName, gVar.aqk.portrait, gVar.aqk.sex, gVar.aqk.levelId, null, null, 0L, gVar.aqk.fansCount, gVar.aqk.followCount, gVar.aqk.userStatus, c.this.mGroupId, c.this.mLiveId, c.this.fyN, c.this.fyM, gVar.aqk.appId, gVar.aqk.userName, c.this.otherParams)));
                LogManager.getCommonLogger().doClickTopRightAuthorLog(c.this.aDK.mLiveInfo.feed_id, i, c.this.Cq());
            }
        }
    };
    CustomMessageListener faq = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.liveroom.audiencelist.c.2
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
        this.fyI = aVar;
        this.fyN = z;
        MessageManager.getInstance().registerListener(this.faq);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TbPageContext getPageContext() {
        return this.mTbPageContext;
    }

    public void a(String str, String str2, String str3, n nVar) {
        this.mGroupId = str;
        this.mLiveId = str2;
        this.fyM = str3;
        this.aDK = nVar;
    }

    public void c(ViewGroup viewGroup, int i, int i2) {
        if (viewGroup != null) {
            if (this.fyK == null) {
                this.fyK = (FrameLayout) LayoutInflater.from(getPageContext().getPageActivity()).inflate(a.h.ala_live_audience_list_layout, (ViewGroup) null);
            }
            if (this.faV != null && this.faV.indexOfChild(this.fyK) > 0) {
                this.faV.removeView(this.fyK);
            }
            this.faV = viewGroup;
            this.fyK.setId(a.g.ala_liveroom_audience);
            this.fyL = (AlphaGradientHListView) this.fyK.findViewById(a.g.ala_live_guest_listview);
            this.fyL.setDividerWidth(BdUtilHelper.getDimens(getPageContext().getPageActivity(), a.e.sdk_ds0));
            this.fyJ = new a(getPageContext().getPageActivity());
            this.fyL.setAdapter((ListAdapter) this.fyJ);
            this.fyL.setSelector(getPageContext().getPageActivity().getResources().getDrawable(a.f.sdk_transparent_bg));
            this.fyL.setOnItemClickListener(this.fyO);
            this.fyL.setColor(getPageContext().getResources().getColor(a.d.sdk_white_alpha100), getPageContext().getResources().getColor(a.d.sdk_white_alpha0));
            this.fyL.setNeedAlphaShade(true);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, BdUtilHelper.getDimens(getPageContext().getPageActivity(), a.e.sdk_ds82));
            layoutParams.addRule(1, i);
            layoutParams.addRule(8, i);
            layoutParams.addRule(0, i2);
            layoutParams.leftMargin = BdUtilHelper.getDimens(getPageContext().getPageActivity(), a.e.sdk_ds10);
            layoutParams.rightMargin = BdUtilHelper.dip2px(getPageContext().getPageActivity(), -6.0f);
            this.faV.addView(this.fyK, layoutParams);
        }
    }

    public void cl(int i) {
    }

    public void e(h hVar) {
        if (this.fyJ != null) {
            this.fyJ.d(hVar);
            this.fyJ.notifyDataSetChanged();
        }
    }

    public boolean c(g gVar) {
        if (this.fyJ == null || !this.fyJ.b(gVar)) {
            return false;
        }
        this.fyJ.notifyDataSetChanged();
        return true;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.faq);
    }

    public String Cq() {
        return this.otherParams;
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }
}
