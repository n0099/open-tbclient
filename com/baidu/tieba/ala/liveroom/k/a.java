package com.baidu.tieba.ala.liveroom.k;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.c.g;
import com.baidu.live.data.q;
import com.baidu.live.pendantview.PendantChildView;
import com.baidu.live.pendantview.PendantParentView;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.ViewHelper;
import com.baidu.live.tbadk.statics.AlaStaticItem;
import com.baidu.live.tbadk.statics.AlaStaticsManager;
import com.baidu.live.tbadk.statics.HKStaticManager;
import com.baidu.live.tbadk.statics.SdkStaticKeys;
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticLiveKey;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import com.baidu.live.x.b;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a extends com.baidu.tieba.ala.liveroom.a {
    private ViewGroup fIb;
    private com.baidu.live.liveroom.a.a fXS;
    private b ghP;
    private String otherParams;

    public a(TbPageContext tbPageContext, com.baidu.live.liveroom.a.a aVar) {
        super(tbPageContext);
        this.fXS = aVar;
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void aq(ViewGroup viewGroup) {
        super.aq(viewGroup);
        a(viewGroup, (LinearLayout.LayoutParams) null);
    }

    public void a(ViewGroup viewGroup, LinearLayout.LayoutParams layoutParams) {
        CustomResponsedMessage runTask;
        if (com.baidu.live.v.a.Hm().aZp.wD() && (viewGroup instanceof PendantParentView)) {
            if (this.ghP == null && (runTask = MessageManager.getInstance().runTask(2913034, b.class, getPageContext().getPageActivity())) != null && runTask.getData() != null) {
                this.ghP = (b) runTask.getData();
            }
            if (this.ghP != null) {
                this.ghP.HE();
            }
            a((PendantParentView) viewGroup, layoutParams);
        }
    }

    private void a(PendantParentView pendantParentView, LinearLayout.LayoutParams layoutParams) {
        PendantChildView HD;
        if (pendantParentView != null) {
            this.fIb = pendantParentView;
            if (this.ghP != null && (HD = this.ghP.HD()) != null) {
                HD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.k.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin()) {
                            AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.CLICK_FLOWER);
                            alaStaticItem.addParams("feed_id", HKStaticManager.FEED_ID);
                            alaStaticItem.addParams("live_id", HKStaticManager.LIVE_ID);
                            alaStaticItem.addParams("other_params", a.this.Ep());
                            AlaStaticsManager.getInst().onStatic(alaStaticItem);
                        }
                        a.this.bEG();
                        if (TbadkCoreApplication.isLogin()) {
                            if (a.this.fXS != null) {
                                a.this.fXS.cG(8);
                            }
                            a.this.bEI();
                            return;
                        }
                        ViewHelper.skipToLoginActivity(a.this.getPageContext().getPageActivity());
                    }
                });
                if (pendantParentView.indexOfChild(HD) < 0) {
                    if (layoutParams == null) {
                        layoutParams = bEH();
                    }
                    pendantParentView.a(HD, layoutParams);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bEG() {
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "petal_clk"));
    }

    private LinearLayout.LayoutParams bEH() {
        return new LinearLayout.LayoutParams(-2, -2);
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void vH() {
        super.vH();
        if (this.ghP != null) {
            PendantChildView HD = this.ghP.HD();
            if (HD != null && HD.getParent() != null) {
                ((ViewGroup) HD.getParent()).removeView(HD);
            }
            this.ghP.HF();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void onDestroy() {
        if (this.ghP != null) {
            PendantChildView HD = this.ghP.HD();
            if (HD != null && HD.getParent() != null) {
                ((ViewGroup) HD.getParent()).removeView(HD);
            }
            this.ghP.onDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bEI() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new g(getPageContext().getPageActivity())));
    }

    public void G(JSONObject jSONObject) {
        if (this.ghP != null) {
            this.ghP.L(jSONObject);
        }
    }

    public void u(q qVar) {
        if (!TbadkCoreApplication.isLogin()) {
            bEJ();
        }
        if (this.ghP != null && this.ghP.HD() != null && qVar != null && qVar.axS != null) {
            this.ghP.a(qVar.axS);
        }
    }

    public void setCanVisible(boolean z) {
        if (this.ghP != null) {
            this.ghP.setCanVisible(z);
        }
    }

    public void bEJ() {
        if (this.ghP != null && this.ghP.HD() != null) {
            this.ghP.HD().setVisibility(8);
        }
    }

    public String Ep() {
        return this.otherParams;
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }
}
