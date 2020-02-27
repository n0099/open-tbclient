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
    private AlphaGradientHListView eTA;
    private String eTB;
    private boolean eTC;
    private com.baidu.live.liveroom.a.a eTx;
    private a eTy;
    public FrameLayout eTz;
    private ViewGroup ewd;
    private String mGroupId;
    private String mLiveId;
    private TbPageContext mTbPageContext;
    private String otherParams;
    private AdapterView.c eTD = new AdapterView.c() { // from class: com.baidu.tieba.ala.liveroom.audiencelist.c.1
        @Override // com.baidu.live.tieba.horizonallist.widget.AdapterView.c
        public void a(AdapterView<?> adapterView, View view, int i, long j) {
            g gVar = (g) c.this.eTy.getItem(i);
            if (gVar != null) {
                if (c.this.eTx != null) {
                    c.this.eTx.cc(5);
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(c.this.getPageContext().getPageActivity(), String.valueOf(gVar.XQ.userId), gVar.XQ.userName, gVar.XQ.portrait, gVar.XQ.sex, gVar.XQ.levelId, null, null, 0L, gVar.XQ.fansCount, gVar.XQ.followCount, gVar.XQ.userStatus, c.this.mGroupId, c.this.mLiveId, c.this.eTC, c.this.eTB, gVar.XQ.appId, gVar.XQ.userName, c.this.otherParams)));
                LogManager.getCommonLogger().doClickTopRightAuthorLog(c.this.ald.mLiveInfo.feed_id, i, c.this.xx());
            }
        }
    };
    CustomMessageListener evK = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.liveroom.audiencelist.c.2
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
        this.eTx = aVar;
        this.eTC = z;
        MessageManager.getInstance().registerListener(this.evK);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TbPageContext getPageContext() {
        return this.mTbPageContext;
    }

    public void a(String str, String str2, String str3, m mVar) {
        this.mGroupId = str;
        this.mLiveId = str2;
        this.eTB = str3;
        this.ald = mVar;
    }

    public void c(ViewGroup viewGroup, int i, int i2) {
        if (viewGroup != null) {
            if (this.eTz == null) {
                this.eTz = (FrameLayout) LayoutInflater.from(getPageContext().getPageActivity()).inflate(a.h.ala_live_audience_list_layout, (ViewGroup) null);
            }
            if (this.ewd != null && this.ewd.indexOfChild(this.eTz) > 0) {
                this.ewd.removeView(this.eTz);
            }
            this.ewd = viewGroup;
            this.eTz.setId(a.g.ala_liveroom_audience);
            this.eTA = (AlphaGradientHListView) this.eTz.findViewById(a.g.ala_live_guest_listview);
            this.eTA.setDividerWidth(BdUtilHelper.getDimens(getPageContext().getPageActivity(), a.e.sdk_ds0));
            this.eTy = new a(getPageContext().getPageActivity());
            this.eTA.setAdapter((ListAdapter) this.eTy);
            this.eTA.setSelector(getPageContext().getPageActivity().getResources().getDrawable(a.f.sdk_transparent_bg));
            this.eTA.setOnItemClickListener(this.eTD);
            this.eTA.setColor(getPageContext().getResources().getColor(a.d.sdk_white_alpha100), getPageContext().getResources().getColor(a.d.sdk_white_alpha0));
            this.eTA.setNeedAlphaShade(true);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, BdUtilHelper.getDimens(getPageContext().getPageActivity(), a.e.sdk_ds82));
            layoutParams.addRule(1, i);
            layoutParams.addRule(8, i);
            layoutParams.addRule(0, i2);
            layoutParams.leftMargin = BdUtilHelper.getDimens(getPageContext().getPageActivity(), a.e.sdk_ds10);
            layoutParams.rightMargin = BdUtilHelper.dip2px(getPageContext().getPageActivity(), -6.0f);
            this.ewd.addView(this.eTz, layoutParams);
        }
    }

    public void bW(int i) {
    }

    public void f(h hVar) {
        if (this.eTy != null) {
            this.eTy.e(hVar);
            this.eTy.notifyDataSetChanged();
        }
    }

    public boolean c(g gVar) {
        if (this.eTy == null || !this.eTy.b(gVar)) {
            return false;
        }
        this.eTy.notifyDataSetChanged();
        return true;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.evK);
    }

    public String xx() {
        return this.otherParams;
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }
}
