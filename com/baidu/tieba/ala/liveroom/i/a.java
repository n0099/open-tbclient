package com.baidu.tieba.ala.liveroom.i;

import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.b.d;
import com.baidu.live.data.i;
import com.baidu.live.k.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.ViewHelper;
import com.baidu.live.tbadk.statics.AlaStaticItem;
import com.baidu.live.tbadk.statics.AlaStaticsManager;
import com.baidu.live.tbadk.statics.HKStaticManager;
import com.baidu.live.tbadk.statics.SdkStaticKeys;
import com.baidu.tieba.ala.liveroom.b;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class a extends com.baidu.tieba.ala.liveroom.a {
    private b dYQ;
    private ViewGroup dYV;
    private com.baidu.live.m.b egD;
    private String otherParams;

    public a(TbPageContext tbPageContext, b bVar) {
        super(tbPageContext);
        this.dYQ = bVar;
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void Z(ViewGroup viewGroup) {
        super.Z(viewGroup);
        a(viewGroup, null);
    }

    public void a(ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        CustomResponsedMessage runTask;
        if (com.baidu.live.l.a.uA().ajX.oo()) {
            if (this.egD == null && (runTask = MessageManager.getInstance().runTask(2913034, com.baidu.live.m.b.class, getPageContext().getPageActivity())) != null && runTask.getData() != null) {
                this.egD = (com.baidu.live.m.b) runTask.getData();
            }
            if (this.egD != null) {
                this.egD.uM();
            }
            b(viewGroup, layoutParams);
        }
    }

    private void b(ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        View view;
        if (viewGroup != null) {
            this.dYV = viewGroup;
            if (this.egD != null && (view = this.egD.getView()) != null) {
                view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.i.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.CLICK_FLOWER);
                        alaStaticItem.addParams("feed_id", HKStaticManager.FEED_ID);
                        alaStaticItem.addParams("live_id", HKStaticManager.LIVE_ID);
                        alaStaticItem.addParams("other_params", a.this.tm());
                        AlaStaticsManager.getInst().onStatic(alaStaticItem);
                        if (TbadkCoreApplication.isLogin()) {
                            if (a.this.dYQ != null) {
                                a.this.dYQ.na(8);
                            }
                            a.this.aRV();
                            return;
                        }
                        ViewHelper.skipToLoginActivity(a.this.getPageContext().getPageActivity());
                    }
                });
                if (viewGroup.indexOfChild(view) < 0) {
                    if (layoutParams == null) {
                        layoutParams = aRU();
                    }
                    viewGroup.addView(view, layoutParams);
                }
            }
        }
    }

    private ViewGroup.LayoutParams aRU() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(11);
        layoutParams.rightMargin = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds24);
        layoutParams.topMargin = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds196);
        return layoutParams;
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void nA() {
        super.nA();
        if (this.egD != null) {
            View view = this.egD.getView();
            if (view != null && view.getParent() != null) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            this.egD.uN();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void onDestroy() {
        if (this.egD != null) {
            View view = this.egD.getView();
            if (view != null && view.getParent() != null) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            this.egD.onDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aRV() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new d(getPageContext().getPageActivity())));
    }

    public void x(JSONObject jSONObject) {
        if (this.egD != null) {
            this.egD.y(jSONObject);
        }
    }

    public void k(i iVar) {
        if (!TbadkCoreApplication.isLogin()) {
            aRW();
        }
        if (this.egD != null && this.egD.getView() != null && iVar != null && iVar.PU != null) {
            this.egD.a(iVar.PU);
        }
    }

    public void setCanVisible(boolean z) {
        if (this.egD != null) {
            this.egD.setCanVisible(z);
        }
    }

    public void aRW() {
        if (this.egD != null && this.egD.getView() != null) {
            this.egD.getView().setVisibility(8);
        }
    }

    public String tm() {
        return this.otherParams;
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }
}
