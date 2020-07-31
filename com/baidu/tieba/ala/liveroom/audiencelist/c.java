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
/* loaded from: classes4.dex */
public class c {
    private q avf;
    private ViewGroup fNw;
    private com.baidu.live.liveroom.a.a gcZ;
    private a gda;
    public FrameLayout gdb;
    public FrameLayout gdc;
    private AlphaGradientHListView gdd;
    private String gde;
    private boolean gdf;
    private String mGroupId;
    private String mLiveId;
    private TbPageContext mTbPageContext;
    private String otherParams;
    private AdapterView.c gdg = new AdapterView.c() { // from class: com.baidu.tieba.ala.liveroom.audiencelist.c.1
        @Override // com.baidu.live.tieba.horizonallist.widget.AdapterView.c
        public void a(AdapterView<?> adapterView, View view, int i, long j) {
            j jVar = (j) c.this.gda.getItem(i);
            if (jVar != null) {
                if (c.this.gcZ != null) {
                    c.this.gcZ.cI(5);
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(c.this.getPageContext().getPageActivity(), String.valueOf(jVar.ayC.userId), jVar.ayC.userName, jVar.ayC.portrait, jVar.ayC.sex, jVar.ayC.levelId, null, null, 0L, jVar.ayC.fansCount, jVar.ayC.followCount, jVar.ayC.userStatus, c.this.mGroupId, c.this.mLiveId, c.this.gdf, c.this.gde, jVar.ayC.appId, jVar.ayC.userName, c.this.otherParams)));
                LogManager.getCommonLogger().doClickTopRightAuthorLog(c.this.avf.mLiveInfo.feed_id, i, c.this.Et());
            }
        }
    };
    CustomMessageListener fEy = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.liveroom.audiencelist.c.2
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
        this.gcZ = aVar;
        this.gdf = z;
        MessageManager.getInstance().registerListener(this.fEy);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TbPageContext getPageContext() {
        return this.mTbPageContext;
    }

    public void a(String str, String str2, String str3, q qVar) {
        this.mGroupId = str;
        this.mLiveId = str2;
        this.gde = str3;
        this.avf = qVar;
    }

    public void c(ViewGroup viewGroup, int i, int i2) {
        if (viewGroup != null) {
            if (this.gdb == null) {
                this.gdb = (FrameLayout) LayoutInflater.from(getPageContext().getPageActivity()).inflate(a.h.ala_live_audience_list_layout, (ViewGroup) null);
            }
            if (this.fNw != null && this.fNw.indexOfChild(this.gdb) > 0) {
                this.fNw.removeView(this.gdb);
            }
            this.fNw = viewGroup;
            this.gdb.setId(a.g.ala_liveroom_audience);
            this.gdc = (FrameLayout) this.gdb.findViewById(a.g.content_layout);
            this.gdd = (AlphaGradientHListView) this.gdb.findViewById(a.g.ala_live_guest_listview);
            this.gdd.setDividerWidth(BdUtilHelper.getDimens(getPageContext().getPageActivity(), a.e.sdk_ds0));
            this.gda = new a(getPageContext().getPageActivity());
            this.gdd.setAdapter((ListAdapter) this.gda);
            this.gdd.setSelector(getPageContext().getPageActivity().getResources().getDrawable(a.f.sdk_transparent_bg));
            this.gdd.setOnItemClickListener(this.gdg);
            this.gdd.setColor(getPageContext().getResources().getColor(a.d.sdk_white_alpha100), getPageContext().getResources().getColor(a.d.sdk_white_alpha0));
            this.gdd.setNeedAlphaShade(true);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, BdUtilHelper.getDimens(getPageContext().getPageActivity(), a.e.sdk_ds82));
            layoutParams.addRule(1, i);
            layoutParams.addRule(8, i);
            layoutParams.addRule(0, i2);
            layoutParams.leftMargin = BdUtilHelper.getDimens(getPageContext().getPageActivity(), a.e.sdk_ds10);
            layoutParams.rightMargin = BdUtilHelper.dip2px(getPageContext().getPageActivity(), -6.0f);
            this.fNw.addView(this.gdb, layoutParams);
        }
    }

    public void bN(int i) {
    }

    public void e(k kVar) {
        if (this.gda != null) {
            this.gda.d(kVar);
            this.gda.notifyDataSetChanged();
        }
    }

    public boolean c(j jVar) {
        if (this.gda == null || !this.gda.b(jVar)) {
            return false;
        }
        this.gda.notifyDataSetChanged();
        return true;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.fEy);
    }

    public String Et() {
        return this.otherParams;
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }
}
