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
    private m ald;
    public FrameLayout eTA;
    private AlphaGradientHListView eTB;
    private String eTC;
    private boolean eTD;
    private com.baidu.live.liveroom.a.a eTy;
    private a eTz;
    private ViewGroup ewe;
    private String mGroupId;
    private String mLiveId;
    private TbPageContext mTbPageContext;
    private String otherParams;
    private AdapterView.c eTE = new AdapterView.c() { // from class: com.baidu.tieba.ala.liveroom.audiencelist.c.1
        @Override // com.baidu.live.tieba.horizonallist.widget.AdapterView.c
        public void a(AdapterView<?> adapterView, View view, int i, long j) {
            g gVar = (g) c.this.eTz.getItem(i);
            if (gVar != null) {
                if (c.this.eTy != null) {
                    c.this.eTy.cc(5);
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(c.this.getPageContext().getPageActivity(), String.valueOf(gVar.XQ.userId), gVar.XQ.userName, gVar.XQ.portrait, gVar.XQ.sex, gVar.XQ.levelId, null, null, 0L, gVar.XQ.fansCount, gVar.XQ.followCount, gVar.XQ.userStatus, c.this.mGroupId, c.this.mLiveId, c.this.eTD, c.this.eTC, gVar.XQ.appId, gVar.XQ.userName, c.this.otherParams)));
                LogManager.getCommonLogger().doClickTopRightAuthorLog(c.this.ald.mLiveInfo.feed_id, i, c.this.xx());
            }
        }
    };
    CustomMessageListener evL = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.liveroom.audiencelist.c.2
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
        this.eTy = aVar;
        this.eTD = z;
        MessageManager.getInstance().registerListener(this.evL);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TbPageContext getPageContext() {
        return this.mTbPageContext;
    }

    public void a(String str, String str2, String str3, m mVar) {
        this.mGroupId = str;
        this.mLiveId = str2;
        this.eTC = str3;
        this.ald = mVar;
    }

    public void c(ViewGroup viewGroup, int i, int i2) {
        if (viewGroup != null) {
            if (this.eTA == null) {
                this.eTA = (FrameLayout) LayoutInflater.from(getPageContext().getPageActivity()).inflate(a.h.ala_live_audience_list_layout, (ViewGroup) null);
            }
            if (this.ewe != null && this.ewe.indexOfChild(this.eTA) > 0) {
                this.ewe.removeView(this.eTA);
            }
            this.ewe = viewGroup;
            this.eTA.setId(a.g.ala_liveroom_audience);
            this.eTB = (AlphaGradientHListView) this.eTA.findViewById(a.g.ala_live_guest_listview);
            this.eTB.setDividerWidth(BdUtilHelper.getDimens(getPageContext().getPageActivity(), a.e.sdk_ds0));
            this.eTz = new a(getPageContext().getPageActivity());
            this.eTB.setAdapter((ListAdapter) this.eTz);
            this.eTB.setSelector(getPageContext().getPageActivity().getResources().getDrawable(a.f.sdk_transparent_bg));
            this.eTB.setOnItemClickListener(this.eTE);
            this.eTB.setColor(getPageContext().getResources().getColor(a.d.sdk_white_alpha100), getPageContext().getResources().getColor(a.d.sdk_white_alpha0));
            this.eTB.setNeedAlphaShade(true);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, BdUtilHelper.getDimens(getPageContext().getPageActivity(), a.e.sdk_ds82));
            layoutParams.addRule(1, i);
            layoutParams.addRule(8, i);
            layoutParams.addRule(0, i2);
            layoutParams.leftMargin = BdUtilHelper.getDimens(getPageContext().getPageActivity(), a.e.sdk_ds10);
            layoutParams.rightMargin = BdUtilHelper.dip2px(getPageContext().getPageActivity(), -6.0f);
            this.ewe.addView(this.eTA, layoutParams);
        }
    }

    public void bW(int i) {
    }

    public void f(h hVar) {
        if (this.eTz != null) {
            this.eTz.e(hVar);
            this.eTz.notifyDataSetChanged();
        }
    }

    public boolean c(g gVar) {
        if (this.eTz == null || !this.eTz.b(gVar)) {
            return false;
        }
        this.eTz.notifyDataSetChanged();
        return true;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.evL);
    }

    public String xx() {
        return this.otherParams;
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }
}
