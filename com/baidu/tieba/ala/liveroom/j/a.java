package com.baidu.tieba.ala.liveroom.j;

import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.c.f;
import com.baidu.live.data.n;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.ViewHelper;
import com.baidu.live.tbadk.statics.AlaStaticItem;
import com.baidu.live.tbadk.statics.AlaStaticsManager;
import com.baidu.live.tbadk.statics.HKStaticManager;
import com.baidu.live.tbadk.statics.SdkStaticKeys;
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import com.baidu.live.u.a;
import com.baidu.live.view.PriorityVerticalLinearLayout;
import com.baidu.live.x.b;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a extends com.baidu.tieba.ala.liveroom.a {
    private b fGN;
    private ViewGroup faV;
    private com.baidu.live.liveroom.a.a fyI;
    private String otherParams;

    public a(TbPageContext tbPageContext, com.baidu.live.liveroom.a.a aVar) {
        super(tbPageContext);
        this.fyI = aVar;
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void ah(ViewGroup viewGroup) {
        super.ah(viewGroup);
        d(viewGroup, null);
    }

    public void d(ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        CustomResponsedMessage runTask;
        if (com.baidu.live.v.a.En().aQu.uT()) {
            if (this.fGN == null && (runTask = MessageManager.getInstance().runTask(2913034, b.class, getPageContext().getPageActivity())) != null && runTask.getData() != null) {
                this.fGN = (b) runTask.getData();
            }
            if (this.fGN != null) {
                this.fGN.EA();
            }
            e(viewGroup, layoutParams);
        }
    }

    private void e(ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        View view;
        if (viewGroup != null) {
            this.faV = viewGroup;
            if (this.fGN != null && (view = this.fGN.getView()) != null) {
                view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.j.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin()) {
                            AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.CLICK_FLOWER);
                            alaStaticItem.addParams("feed_id", HKStaticManager.FEED_ID);
                            alaStaticItem.addParams("live_id", HKStaticManager.LIVE_ID);
                            alaStaticItem.addParams("other_params", a.this.Cq());
                            AlaStaticsManager.getInst().onStatic(alaStaticItem);
                        }
                        a.this.bvy();
                        if (TbadkCoreApplication.isLogin()) {
                            if (a.this.fyI != null) {
                                a.this.fyI.cr(8);
                            }
                            a.this.bvA();
                            return;
                        }
                        ViewHelper.skipToLoginActivity(a.this.getPageContext().getPageActivity());
                    }
                });
                if (viewGroup.indexOfChild(view) < 0) {
                    if (layoutParams == null) {
                        layoutParams = bvz();
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
    public void bvy() {
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem("1396", "click", "liveroom", "petal_clk"));
    }

    private ViewGroup.LayoutParams bvz() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(11);
        layoutParams.rightMargin = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds24);
        layoutParams.topMargin = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds196);
        return layoutParams;
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void uf() {
        super.uf();
        if (this.fGN != null) {
            View view = this.fGN.getView();
            if (view != null && view.getParent() != null) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            this.fGN.EB();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void onDestroy() {
        if (this.fGN != null) {
            View view = this.fGN.getView();
            if (view != null && view.getParent() != null) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            this.fGN.onDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bvA() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new f(getPageContext().getPageActivity())));
    }

    public void A(JSONObject jSONObject) {
        if (this.fGN != null) {
            this.fGN.B(jSONObject);
        }
    }

    public void s(n nVar) {
        if (!TbadkCoreApplication.isLogin()) {
            bvB();
        }
        if (this.fGN != null && this.fGN.getView() != null && nVar != null && nVar.aqN != null) {
            this.fGN.a(nVar.aqN);
        }
    }

    public void setCanVisible(boolean z) {
        if (this.fGN != null) {
            this.fGN.setCanVisible(z);
        }
    }

    public void bvB() {
        if (this.fGN != null && this.fGN.getView() != null) {
            this.fGN.getView().setVisibility(8);
        }
    }

    public String Cq() {
        return this.otherParams;
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }
}
