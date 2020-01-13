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
import com.baidu.live.data.f;
import com.baidu.live.data.g;
import com.baidu.live.data.l;
import com.baidu.live.r.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.atomdata.AlaPersonCardActivityConfig;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.log.LogManager;
import com.baidu.live.tieba.horizonallist.widget.AdapterView;
import com.baidu.live.view.AlphaGradientHListView;
/* loaded from: classes2.dex */
public class c {
    private l aiW;
    private boolean ePA;
    private com.baidu.tieba.ala.liveroom.b ePv;
    private a ePw;
    public FrameLayout ePx;
    private AlphaGradientHListView ePy;
    private String ePz;
    private ViewGroup erT;
    private String mGroupId;
    private String mLiveId;
    private TbPageContext mTbPageContext;
    private String otherParams;
    private AdapterView.c ePB = new AdapterView.c() { // from class: com.baidu.tieba.ala.liveroom.audiencelist.c.1
        @Override // com.baidu.live.tieba.horizonallist.widget.AdapterView.c
        public void a(AdapterView<?> adapterView, View view, int i, long j) {
            f fVar = (f) c.this.ePw.getItem(i);
            if (fVar != null) {
                if (c.this.ePv != null) {
                    c.this.ePv.pr(5);
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(c.this.getPageContext().getPageActivity(), String.valueOf(fVar.Wf.userId), fVar.Wf.userName, fVar.Wf.portrait, fVar.Wf.sex, fVar.Wf.levelId, null, null, 0L, fVar.Wf.fansCount, fVar.Wf.followCount, fVar.Wf.userStatus, c.this.mGroupId, c.this.mLiveId, c.this.ePA, c.this.ePz, fVar.Wf.appId, fVar.Wf.userName, c.this.otherParams)));
                LogManager.getCommonLogger().doClickTopRightAuthorLog(c.this.aiW.mLiveInfo.feed_id, i, c.this.vz());
            }
        }
    };
    CustomMessageListener erA = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.liveroom.audiencelist.c.2
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

    public c(TbPageContext tbPageContext, com.baidu.tieba.ala.liveroom.b bVar, boolean z) {
        this.mTbPageContext = tbPageContext;
        this.ePv = bVar;
        this.ePA = z;
        MessageManager.getInstance().registerListener(this.erA);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TbPageContext getPageContext() {
        return this.mTbPageContext;
    }

    public void a(String str, String str2, String str3, l lVar) {
        this.mGroupId = str;
        this.mLiveId = str2;
        this.ePz = str3;
        this.aiW = lVar;
    }

    public void c(ViewGroup viewGroup, int i, int i2) {
        if (viewGroup != null) {
            if (this.ePx == null) {
                this.ePx = (FrameLayout) LayoutInflater.from(getPageContext().getPageActivity()).inflate(a.h.ala_live_audience_list_layout, (ViewGroup) null);
            }
            if (this.erT != null && this.erT.indexOfChild(this.ePx) > 0) {
                this.erT.removeView(this.ePx);
            }
            this.erT = viewGroup;
            this.ePx.setId(a.g.ala_liveroom_audience);
            this.ePy = (AlphaGradientHListView) this.ePx.findViewById(a.g.ala_live_guest_listview);
            this.ePy.setDividerWidth(BdUtilHelper.getDimens(getPageContext().getPageActivity(), a.e.sdk_ds0));
            this.ePw = new a(getPageContext().getPageActivity());
            this.ePy.setAdapter((ListAdapter) this.ePw);
            this.ePy.setSelector(getPageContext().getPageActivity().getResources().getDrawable(a.f.sdk_transparent_bg));
            this.ePy.setOnItemClickListener(this.ePB);
            this.ePy.setColor(getPageContext().getResources().getColor(a.d.sdk_white_alpha100), getPageContext().getResources().getColor(a.d.sdk_white_alpha0));
            this.ePy.setNeedAlphaShade(true);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, BdUtilHelper.getDimens(getPageContext().getPageActivity(), a.e.sdk_ds82));
            layoutParams.addRule(1, i);
            layoutParams.addRule(8, i);
            layoutParams.addRule(0, i2);
            layoutParams.leftMargin = BdUtilHelper.getDimens(getPageContext().getPageActivity(), a.e.sdk_ds10);
            layoutParams.rightMargin = BdUtilHelper.dip2px(getPageContext().getPageActivity(), -6.0f);
            this.erT.addView(this.ePx, layoutParams);
        }
    }

    public void bN(int i) {
        if (i != 2 && i == 1) {
        }
    }

    public void f(g gVar) {
        if (this.ePw != null) {
            this.ePw.e(gVar);
            this.ePw.notifyDataSetChanged();
        }
    }

    public boolean c(f fVar) {
        if (this.ePw == null || !this.ePw.b(fVar)) {
            return false;
        }
        this.ePw.notifyDataSetChanged();
        return true;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.erA);
    }

    public String vz() {
        return this.otherParams;
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }
}
