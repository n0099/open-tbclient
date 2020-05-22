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
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.atomdata.AlaPersonCardActivityConfig;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.log.LogManager;
import com.baidu.live.tieba.horizonallist.widget.AdapterView;
import com.baidu.live.u.a;
import com.baidu.live.view.AlphaGradientHListView;
/* loaded from: classes3.dex */
public class c {
    private q aJj;
    private com.baidu.live.liveroom.a.a fMJ;
    private a fMK;
    public FrameLayout fML;
    public FrameLayout fMM;
    private AlphaGradientHListView fMN;
    private String fMO;
    private boolean fMP;
    private AdapterView.c fMQ = new AdapterView.c() { // from class: com.baidu.tieba.ala.liveroom.audiencelist.c.1
        @Override // com.baidu.live.tieba.horizonallist.widget.AdapterView.c
        public void a(AdapterView<?> adapterView, View view, int i, long j) {
            j jVar = (j) c.this.fMK.getItem(i);
            if (jVar != null) {
                if (c.this.fMJ != null) {
                    c.this.fMJ.cy(5);
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(c.this.getPageContext().getPageActivity(), String.valueOf(jVar.avj.userId), jVar.avj.userName, jVar.avj.portrait, jVar.avj.sex, jVar.avj.levelId, null, null, 0L, jVar.avj.fansCount, jVar.avj.followCount, jVar.avj.userStatus, c.this.mGroupId, c.this.mLiveId, c.this.fMP, c.this.fMO, jVar.avj.appId, jVar.avj.userName, c.this.otherParams)));
                LogManager.getCommonLogger().doClickTopRightAuthorLog(c.this.aJj.mLiveInfo.feed_id, i, c.this.DN());
            }
        }
    };
    CustomMessageListener fnT = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.liveroom.audiencelist.c.2
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
    private ViewGroup fox;
    private String mGroupId;
    private String mLiveId;
    private TbPageContext mTbPageContext;
    private String otherParams;

    public c(TbPageContext tbPageContext, com.baidu.live.liveroom.a.a aVar, boolean z) {
        this.mTbPageContext = tbPageContext;
        this.fMJ = aVar;
        this.fMP = z;
        MessageManager.getInstance().registerListener(this.fnT);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TbPageContext getPageContext() {
        return this.mTbPageContext;
    }

    public void a(String str, String str2, String str3, q qVar) {
        this.mGroupId = str;
        this.mLiveId = str2;
        this.fMO = str3;
        this.aJj = qVar;
    }

    public void c(ViewGroup viewGroup, int i, int i2) {
        if (viewGroup != null) {
            if (this.fML == null) {
                this.fML = (FrameLayout) LayoutInflater.from(getPageContext().getPageActivity()).inflate(a.h.ala_live_audience_list_layout, (ViewGroup) null);
            }
            if (this.fox != null && this.fox.indexOfChild(this.fML) > 0) {
                this.fox.removeView(this.fML);
            }
            this.fox = viewGroup;
            this.fML.setId(a.g.ala_liveroom_audience);
            this.fMM = (FrameLayout) this.fML.findViewById(a.g.content_layout);
            this.fMN = (AlphaGradientHListView) this.fML.findViewById(a.g.ala_live_guest_listview);
            this.fMN.setDividerWidth(BdUtilHelper.getDimens(getPageContext().getPageActivity(), a.e.sdk_ds0));
            this.fMK = new a(getPageContext().getPageActivity());
            this.fMN.setAdapter((ListAdapter) this.fMK);
            this.fMN.setSelector(getPageContext().getPageActivity().getResources().getDrawable(a.f.sdk_transparent_bg));
            this.fMN.setOnItemClickListener(this.fMQ);
            this.fMN.setColor(getPageContext().getResources().getColor(a.d.sdk_white_alpha100), getPageContext().getResources().getColor(a.d.sdk_white_alpha0));
            this.fMN.setNeedAlphaShade(true);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, BdUtilHelper.getDimens(getPageContext().getPageActivity(), a.e.sdk_ds82));
            layoutParams.addRule(1, i);
            layoutParams.addRule(8, i);
            layoutParams.addRule(0, i2);
            layoutParams.leftMargin = BdUtilHelper.getDimens(getPageContext().getPageActivity(), a.e.sdk_ds10);
            layoutParams.rightMargin = BdUtilHelper.dip2px(getPageContext().getPageActivity(), -6.0f);
            this.fox.addView(this.fML, layoutParams);
        }
    }

    public void cs(int i) {
    }

    public void e(k kVar) {
        if (this.fMK != null) {
            this.fMK.d(kVar);
            this.fMK.notifyDataSetChanged();
        }
    }

    public boolean c(j jVar) {
        if (this.fMK == null || !this.fMK.b(jVar)) {
            return false;
        }
        this.fMK.notifyDataSetChanged();
        return true;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.fnT);
    }

    public String DN() {
        return this.otherParams;
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }
}
