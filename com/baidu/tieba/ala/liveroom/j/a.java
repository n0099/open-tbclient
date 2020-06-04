package com.baidu.tieba.ala.liveroom.j;

import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.c.f;
import com.baidu.live.data.q;
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
import com.baidu.live.u.a;
import com.baidu.live.view.PriorityVerticalLinearLayout;
import com.baidu.live.x.b;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a extends com.baidu.tieba.ala.liveroom.a {
    private com.baidu.live.liveroom.a.a fMU;
    private b fUT;
    private ViewGroup foI;
    private String otherParams;

    public a(TbPageContext tbPageContext, com.baidu.live.liveroom.a.a aVar) {
        super(tbPageContext);
        this.fMU = aVar;
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void ao(ViewGroup viewGroup) {
        super.ao(viewGroup);
        d(viewGroup, null);
    }

    public void d(ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        CustomResponsedMessage runTask;
        if (com.baidu.live.v.a.Ge().aWF.wf()) {
            if (this.fUT == null && (runTask = MessageManager.getInstance().runTask(2913034, b.class, getPageContext().getPageActivity())) != null && runTask.getData() != null) {
                this.fUT = (b) runTask.getData();
            }
            if (this.fUT != null) {
                this.fUT.Gr();
            }
            e(viewGroup, layoutParams);
        }
    }

    private void e(ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        View view;
        if (viewGroup != null) {
            this.foI = viewGroup;
            if (this.fUT != null && (view = this.fUT.getView()) != null) {
                view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.j.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin()) {
                            AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.CLICK_FLOWER);
                            alaStaticItem.addParams("feed_id", HKStaticManager.FEED_ID);
                            alaStaticItem.addParams("live_id", HKStaticManager.LIVE_ID);
                            alaStaticItem.addParams("other_params", a.this.DN());
                            AlaStaticsManager.getInst().onStatic(alaStaticItem);
                        }
                        a.this.bBz();
                        if (TbadkCoreApplication.isLogin()) {
                            if (a.this.fMU != null) {
                                a.this.fMU.cA(8);
                            }
                            a.this.bBB();
                            return;
                        }
                        ViewHelper.skipToLoginActivity(a.this.getPageContext().getPageActivity());
                    }
                });
                if (viewGroup.indexOfChild(view) < 0) {
                    if (layoutParams == null) {
                        layoutParams = bBA();
                    }
                    if (viewGroup instanceof PriorityVerticalLinearLayout) {
                        view.setTag(a.g.sdk_pvl_layout_priority_tag_key, 2);
                    }
                    viewGroup.addView(view, layoutParams);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bBz() {
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "petal_clk"));
    }

    private ViewGroup.LayoutParams bBA() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(11);
        layoutParams.rightMargin = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds24);
        layoutParams.topMargin = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds196);
        return layoutParams;
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void vm() {
        super.vm();
        if (this.fUT != null) {
            View view = this.fUT.getView();
            if (view != null && view.getParent() != null) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            this.fUT.Gs();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void onDestroy() {
        if (this.fUT != null) {
            View view = this.fUT.getView();
            if (view != null && view.getParent() != null) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            this.fUT.onDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bBB() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new f(getPageContext().getPageActivity())));
    }

    public void E(JSONObject jSONObject) {
        if (this.fUT != null) {
            this.fUT.G(jSONObject);
        }
    }

    public void s(q qVar) {
        if (!TbadkCoreApplication.isLogin()) {
            bBC();
        }
        if (this.fUT != null && this.fUT.getView() != null && qVar != null && qVar.avM != null) {
            this.fUT.a(qVar.avM);
        }
    }

    public void setCanVisible(boolean z) {
        if (this.fUT != null) {
            this.fUT.setCanVisible(z);
        }
    }

    public void bBC() {
        if (this.fUT != null && this.fUT.getView() != null) {
            this.fUT.getView().setVisibility(8);
        }
    }

    public String DN() {
        return this.otherParams;
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }
}
