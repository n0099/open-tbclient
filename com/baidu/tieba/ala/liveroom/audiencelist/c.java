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
import com.baidu.live.data.m;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.atomdata.AlaPersonCardActivityConfig;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.log.LogManager;
import com.baidu.live.tieba.horizonallist.widget.AdapterView;
import com.baidu.live.u.a;
import com.baidu.live.view.AlphaGradientHListView;
/* loaded from: classes3.dex */
public class c {
    private m alp;
    private com.baidu.live.liveroom.a.a eUj;
    private a eUk;
    public FrameLayout eUl;
    private AlphaGradientHListView eUm;
    private String eUn;
    private boolean eUo;
    private ViewGroup ewN;
    private String mGroupId;
    private String mLiveId;
    private TbPageContext mTbPageContext;
    private String otherParams;
    private AdapterView.c eUp = new AdapterView.c() { // from class: com.baidu.tieba.ala.liveroom.audiencelist.c.1
        @Override // com.baidu.live.tieba.horizonallist.widget.AdapterView.c
        public void a(AdapterView<?> adapterView, View view, int i, long j) {
            g gVar = (g) c.this.eUk.getItem(i);
            if (gVar != null) {
                if (c.this.eUj != null) {
                    c.this.eUj.cc(5);
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(c.this.getPageContext().getPageActivity(), String.valueOf(gVar.Ya.userId), gVar.Ya.userName, gVar.Ya.portrait, gVar.Ya.sex, gVar.Ya.levelId, null, null, 0L, gVar.Ya.fansCount, gVar.Ya.followCount, gVar.Ya.userStatus, c.this.mGroupId, c.this.mLiveId, c.this.eUo, c.this.eUn, gVar.Ya.appId, gVar.Ya.userName, c.this.otherParams)));
                LogManager.getCommonLogger().doClickTopRightAuthorLog(c.this.alp.mLiveInfo.feed_id, i, c.this.xC());
            }
        }
    };
    CustomMessageListener ewu = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.liveroom.audiencelist.c.2
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
        this.eUj = aVar;
        this.eUo = z;
        MessageManager.getInstance().registerListener(this.ewu);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TbPageContext getPageContext() {
        return this.mTbPageContext;
    }

    public void a(String str, String str2, String str3, m mVar) {
        this.mGroupId = str;
        this.mLiveId = str2;
        this.eUn = str3;
        this.alp = mVar;
    }

    public void c(ViewGroup viewGroup, int i, int i2) {
        if (viewGroup != null) {
            if (this.eUl == null) {
                this.eUl = (FrameLayout) LayoutInflater.from(getPageContext().getPageActivity()).inflate(a.h.ala_live_audience_list_layout, (ViewGroup) null);
            }
            if (this.ewN != null && this.ewN.indexOfChild(this.eUl) > 0) {
                this.ewN.removeView(this.eUl);
            }
            this.ewN = viewGroup;
            this.eUl.setId(a.g.ala_liveroom_audience);
            this.eUm = (AlphaGradientHListView) this.eUl.findViewById(a.g.ala_live_guest_listview);
            this.eUm.setDividerWidth(BdUtilHelper.getDimens(getPageContext().getPageActivity(), a.e.sdk_ds0));
            this.eUk = new a(getPageContext().getPageActivity());
            this.eUm.setAdapter((ListAdapter) this.eUk);
            this.eUm.setSelector(getPageContext().getPageActivity().getResources().getDrawable(a.f.sdk_transparent_bg));
            this.eUm.setOnItemClickListener(this.eUp);
            this.eUm.setColor(getPageContext().getResources().getColor(a.d.sdk_white_alpha100), getPageContext().getResources().getColor(a.d.sdk_white_alpha0));
            this.eUm.setNeedAlphaShade(true);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, BdUtilHelper.getDimens(getPageContext().getPageActivity(), a.e.sdk_ds82));
            layoutParams.addRule(1, i);
            layoutParams.addRule(8, i);
            layoutParams.addRule(0, i2);
            layoutParams.leftMargin = BdUtilHelper.getDimens(getPageContext().getPageActivity(), a.e.sdk_ds10);
            layoutParams.rightMargin = BdUtilHelper.dip2px(getPageContext().getPageActivity(), -6.0f);
            this.ewN.addView(this.eUl, layoutParams);
        }
    }

    public void bW(int i) {
    }

    public void f(h hVar) {
        if (this.eUk != null) {
            this.eUk.e(hVar);
            this.eUk.notifyDataSetChanged();
        }
    }

    public boolean c(g gVar) {
        if (this.eUk == null || !this.eUk.b(gVar)) {
            return false;
        }
        this.eUk.notifyDataSetChanged();
        return true;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.ewu);
    }

    public String xC() {
        return this.otherParams;
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }
}
