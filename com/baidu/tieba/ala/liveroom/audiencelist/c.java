package com.baidu.tieba.ala.liveroom.audiencelist;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.data.q;
import com.baidu.live.data.r;
import com.baidu.live.data.x;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.atomdata.AlaPersonCardActivityConfig;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.log.LogManager;
import com.baidu.live.tieba.horizonallist.widget.AdapterView;
import com.baidu.live.view.AlphaGradientHListView;
/* loaded from: classes11.dex */
public class c {
    private x aGe;
    private ViewGroup bRX;
    private com.baidu.live.liveroom.a.a huc;
    private a hud;
    public FrameLayout hue;
    public FrameLayout huf;
    private AlphaGradientHListView hug;
    private String huh;
    private boolean hui;
    private String mGroupId;
    private String mLiveId;
    private TbPageContext mTbPageContext;
    private String otherParams;
    private int hsH = a.C0203a.anim_fade_in_and_out;
    private AdapterView.c huj = new AdapterView.c() { // from class: com.baidu.tieba.ala.liveroom.audiencelist.c.1
        @Override // com.baidu.live.tieba.horizonallist.widget.AdapterView.c
        public void a(AdapterView<?> adapterView, View view, int i, long j) {
            q qVar = (q) c.this.hud.getItem(i);
            if (qVar != null && qVar.aKu.disableClick == 0) {
                if (c.this.huc != null) {
                    c.this.huc.ff(5);
                }
                AlaPersonCardActivityConfig alaPersonCardActivityConfig = new AlaPersonCardActivityConfig(c.this.getPageContext().getPageActivity(), String.valueOf(qVar.aKu.userId), qVar.aKu.userName, qVar.aKu.portrait, qVar.aKu.sex, qVar.aKu.levelId, null, null, 0L, qVar.aKu.fansCount, qVar.aKu.followCount, qVar.aKu.userStatus, c.this.mGroupId, c.this.mLiveId, c.this.hui, c.this.huh, qVar.aKu.appId, qVar.aKu.userName);
                alaPersonCardActivityConfig.setOtherParams(c.this.otherParams);
                alaPersonCardActivityConfig.setExtInfo(qVar.aKu.extInfoJson);
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, alaPersonCardActivityConfig));
                LogManager.getCommonLogger().doClickTopRightAuthorLog(c.this.aGe.mLiveInfo.feed_id, i, c.this.NL());
            }
        }
    };
    CustomMessageListener gPs = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.liveroom.audiencelist.c.2
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
        this.huc = aVar;
        this.hui = z;
        MessageManager.getInstance().registerListener(this.gPs);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TbPageContext getPageContext() {
        return this.mTbPageContext;
    }

    public void a(String str, String str2, String str3, x xVar) {
        this.mGroupId = str;
        this.mLiveId = str2;
        this.huh = str3;
        this.aGe = xVar;
    }

    public void c(ViewGroup viewGroup, int i, int i2) {
        if (viewGroup != null) {
            if (this.hue == null) {
                this.hue = (FrameLayout) LayoutInflater.from(getPageContext().getPageActivity()).inflate(a.g.ala_live_audience_list_layout, (ViewGroup) null);
            }
            if (this.bRX != null && this.bRX.indexOfChild(this.hue) > 0) {
                this.bRX.removeView(this.hue);
            }
            this.bRX = viewGroup;
            this.hue.setId(a.f.ala_liveroom_audience);
            this.huf = (FrameLayout) this.hue.findViewById(a.f.content_layout);
            this.hug = (AlphaGradientHListView) this.hue.findViewById(a.f.ala_live_guest_listview);
            this.hug.setDividerWidth(BdUtilHelper.getDimens(getPageContext().getPageActivity(), a.d.sdk_ds0));
            this.hud = new a(getPageContext().getPageActivity());
            this.hug.setAdapter((ListAdapter) this.hud);
            this.hug.setSelector(getPageContext().getPageActivity().getResources().getDrawable(a.e.sdk_transparent_bg));
            this.hug.setOnItemClickListener(this.huj);
            this.hug.setColor(getPageContext().getResources().getColor(a.c.sdk_white_alpha100), getPageContext().getResources().getColor(a.c.sdk_white_alpha0));
            this.hug.setNeedAlphaShade(true);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, BdUtilHelper.getDimens(getPageContext().getPageActivity(), a.d.sdk_ds82));
            layoutParams.addRule(1, i);
            layoutParams.addRule(8, i);
            layoutParams.addRule(0, i2);
            layoutParams.leftMargin = BdUtilHelper.getDimens(getPageContext().getPageActivity(), a.d.sdk_ds10);
            layoutParams.rightMargin = BdUtilHelper.dip2px(getPageContext().getPageActivity(), -6.0f);
            cfn();
            this.bRX.addView(this.hue, layoutParams);
        }
    }

    public void dU(int i) {
    }

    public void e(r rVar) {
        if (this.hud != null) {
            this.hud.d(rVar);
            this.hud.notifyDataSetChanged();
        }
    }

    public boolean c(q qVar) {
        if (this.hud == null || !this.hud.b(qVar)) {
            return false;
        }
        this.hud.notifyDataSetChanged();
        return true;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.gPs);
    }

    public String NL() {
        return this.otherParams;
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    public void cfn() {
        if (this.hug != null) {
            Animation loadAnimation = AnimationUtils.loadAnimation(getPageContext().getPageActivity(), this.hsH);
            loadAnimation.setFillEnabled(true);
            loadAnimation.setFillAfter(true);
            this.hug.setAnimation(loadAnimation);
        }
    }
}
