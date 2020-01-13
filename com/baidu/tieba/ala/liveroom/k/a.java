package com.baidu.tieba.ala.liveroom.k;

import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.c.f;
import com.baidu.live.data.l;
import com.baidu.live.r.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.ViewHelper;
import com.baidu.live.tbadk.statics.AlaStaticItem;
import com.baidu.live.tbadk.statics.AlaStaticsManager;
import com.baidu.live.tbadk.statics.HKStaticManager;
import com.baidu.live.tbadk.statics.SdkStaticKeys;
import com.baidu.live.view.PriorityVerticalLinearLayout;
import com.baidu.tieba.ala.liveroom.b;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a extends com.baidu.tieba.ala.liveroom.a {
    private b ePv;
    private com.baidu.live.u.b eYg;
    private ViewGroup erT;
    private String otherParams;

    public a(TbPageContext tbPageContext, b bVar) {
        super(tbPageContext);
        this.ePv = bVar;
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void ad(ViewGroup viewGroup) {
        super.ad(viewGroup);
        d(viewGroup, null);
    }

    public void d(ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        CustomResponsedMessage runTask;
        if (com.baidu.live.s.a.wR().asq.pN()) {
            if (this.eYg == null && (runTask = MessageManager.getInstance().runTask(2913034, com.baidu.live.u.b.class, getPageContext().getPageActivity())) != null && runTask.getData() != null) {
                this.eYg = (com.baidu.live.u.b) runTask.getData();
            }
            if (this.eYg != null) {
                this.eYg.xc();
            }
            e(viewGroup, layoutParams);
        }
    }

    private void e(ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        View view;
        if (viewGroup != null) {
            this.erT = viewGroup;
            if (this.eYg != null && (view = this.eYg.getView()) != null) {
                view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.k.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin()) {
                            AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.CLICK_FLOWER);
                            alaStaticItem.addParams("feed_id", HKStaticManager.FEED_ID);
                            alaStaticItem.addParams("live_id", HKStaticManager.LIVE_ID);
                            alaStaticItem.addParams("other_params", a.this.vz());
                            AlaStaticsManager.getInst().onStatic(alaStaticItem);
                        }
                        if (TbadkCoreApplication.isLogin()) {
                            if (a.this.ePv != null) {
                                a.this.ePv.pr(8);
                            }
                            a.this.bkp();
                            return;
                        }
                        ViewHelper.skipToLoginActivity(a.this.getPageContext().getPageActivity());
                    }
                });
                if (viewGroup.indexOfChild(view) < 0) {
                    if (layoutParams == null) {
                        layoutParams = bko();
                    }
                    if (viewGroup instanceof PriorityVerticalLinearLayout) {
                        view.setTag(a.g.sdk_pvl_layout_priority_tag_key, 2);
                    }
                    viewGroup.addView(view, layoutParams);
                }
            }
        }
    }

    private ViewGroup.LayoutParams bko() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(11);
        layoutParams.rightMargin = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds24);
        layoutParams.topMargin = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds196);
        return layoutParams;
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void oZ() {
        super.oZ();
        if (this.eYg != null) {
            View view = this.eYg.getView();
            if (view != null && view.getParent() != null) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            this.eYg.xd();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void onDestroy() {
        if (this.eYg != null) {
            View view = this.eYg.getView();
            if (view != null && view.getParent() != null) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            this.eYg.onDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bkp() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new f(getPageContext().getPageActivity())));
    }

    public void u(JSONObject jSONObject) {
        if (this.eYg != null) {
            this.eYg.v(jSONObject);
        }
    }

    public void o(l lVar) {
        if (!TbadkCoreApplication.isLogin()) {
            bkq();
        }
        if (this.eYg != null && this.eYg.getView() != null && lVar != null && lVar.WB != null) {
            this.eYg.a(lVar.WB);
        }
    }

    public void setCanVisible(boolean z) {
        if (this.eYg != null) {
            this.eYg.setCanVisible(z);
        }
    }

    public void bkq() {
        if (this.eYg != null && this.eYg.getView() != null) {
            this.eYg.getView().setVisibility(8);
        }
    }

    public String vz() {
        return this.otherParams;
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }
}
