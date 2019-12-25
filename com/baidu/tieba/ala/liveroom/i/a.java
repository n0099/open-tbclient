package com.baidu.tieba.ala.liveroom.i;

import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.c.f;
import com.baidu.live.data.k;
import com.baidu.live.q.a;
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
/* loaded from: classes2.dex */
public class a extends com.baidu.tieba.ala.liveroom.a {
    private b eNX;
    private com.baidu.live.s.b eVG;
    private ViewGroup eqG;
    private String otherParams;

    public a(TbPageContext tbPageContext, b bVar) {
        super(tbPageContext);
        this.eNX = bVar;
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void Z(ViewGroup viewGroup) {
        super.Z(viewGroup);
        c(viewGroup, null);
    }

    public void c(ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        CustomResponsedMessage runTask;
        if (com.baidu.live.r.a.wA().arE.pJ()) {
            if (this.eVG == null && (runTask = MessageManager.getInstance().runTask(2913034, com.baidu.live.s.b.class, getPageContext().getPageActivity())) != null && runTask.getData() != null) {
                this.eVG = (com.baidu.live.s.b) runTask.getData();
            }
            if (this.eVG != null) {
                this.eVG.wL();
            }
            d(viewGroup, layoutParams);
        }
    }

    private void d(ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        View view;
        if (viewGroup != null) {
            this.eqG = viewGroup;
            if (this.eVG != null && (view = this.eVG.getView()) != null) {
                view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.i.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.CLICK_FLOWER);
                        alaStaticItem.addParams("feed_id", HKStaticManager.FEED_ID);
                        alaStaticItem.addParams("live_id", HKStaticManager.LIVE_ID);
                        alaStaticItem.addParams("other_params", a.this.vi());
                        AlaStaticsManager.getInst().onStatic(alaStaticItem);
                        if (TbadkCoreApplication.isLogin()) {
                            if (a.this.eNX != null) {
                                a.this.eNX.pq(8);
                            }
                            a.this.bjt();
                            return;
                        }
                        ViewHelper.skipToLoginActivity(a.this.getPageContext().getPageActivity());
                    }
                });
                if (viewGroup.indexOfChild(view) < 0) {
                    if (layoutParams == null) {
                        layoutParams = bjs();
                    }
                    viewGroup.addView(view, layoutParams);
                }
            }
        }
    }

    private ViewGroup.LayoutParams bjs() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(11);
        layoutParams.rightMargin = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds24);
        layoutParams.topMargin = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds196);
        return layoutParams;
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void oS() {
        super.oS();
        if (this.eVG != null) {
            View view = this.eVG.getView();
            if (view != null && view.getParent() != null) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            this.eVG.wM();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void onDestroy() {
        if (this.eVG != null) {
            View view = this.eVG.getView();
            if (view != null && view.getParent() != null) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            this.eVG.onDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bjt() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new f(getPageContext().getPageActivity())));
    }

    public void u(JSONObject jSONObject) {
        if (this.eVG != null) {
            this.eVG.v(jSONObject);
        }
    }

    public void m(k kVar) {
        if (!TbadkCoreApplication.isLogin()) {
            bju();
        }
        if (this.eVG != null && this.eVG.getView() != null && kVar != null && kVar.Wk != null) {
            this.eVG.a(kVar.Wk);
        }
    }

    public void setCanVisible(boolean z) {
        if (this.eVG != null) {
            this.eVG.setCanVisible(z);
        }
    }

    public void bju() {
        if (this.eVG != null && this.eVG.getView() != null) {
            this.eVG.getView().setVisibility(8);
        }
    }

    public String vi() {
        return this.otherParams;
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }
}
