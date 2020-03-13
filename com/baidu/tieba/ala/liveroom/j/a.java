package com.baidu.tieba.ala.liveroom.j;

import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.c.f;
import com.baidu.live.data.m;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.ViewHelper;
import com.baidu.live.tbadk.statics.AlaStaticItem;
import com.baidu.live.tbadk.statics.AlaStaticsManager;
import com.baidu.live.tbadk.statics.HKStaticManager;
import com.baidu.live.tbadk.statics.SdkStaticKeys;
import com.baidu.live.u.a;
import com.baidu.live.view.PriorityVerticalLinearLayout;
import com.baidu.live.x.b;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a extends com.baidu.tieba.ala.liveroom.a {
    private com.baidu.live.liveroom.a.a eTL;
    private ViewGroup ewr;
    private b fcb;
    private String otherParams;

    public a(TbPageContext tbPageContext, com.baidu.live.liveroom.a.a aVar) {
        super(tbPageContext);
        this.eTL = aVar;
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void af(ViewGroup viewGroup) {
        super.af(viewGroup);
        d(viewGroup, null);
    }

    public void d(ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        CustomResponsedMessage runTask;
        if (com.baidu.live.v.a.zl().awC.qy()) {
            if (this.fcb == null && (runTask = MessageManager.getInstance().runTask(2913034, b.class, getPageContext().getPageActivity())) != null && runTask.getData() != null) {
                this.fcb = (b) runTask.getData();
            }
            if (this.fcb != null) {
                this.fcb.zw();
            }
            e(viewGroup, layoutParams);
        }
    }

    private void e(ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        View view;
        if (viewGroup != null) {
            this.ewr = viewGroup;
            if (this.fcb != null && (view = this.fcb.getView()) != null) {
                view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.j.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin()) {
                            AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.CLICK_FLOWER);
                            alaStaticItem.addParams("feed_id", HKStaticManager.FEED_ID);
                            alaStaticItem.addParams("live_id", HKStaticManager.LIVE_ID);
                            alaStaticItem.addParams("other_params", a.this.xx());
                            AlaStaticsManager.getInst().onStatic(alaStaticItem);
                        }
                        if (TbadkCoreApplication.isLogin()) {
                            if (a.this.eTL != null) {
                                a.this.eTL.cc(8);
                            }
                            a.this.bmg();
                            return;
                        }
                        ViewHelper.skipToLoginActivity(a.this.getPageContext().getPageActivity());
                    }
                });
                if (viewGroup.indexOfChild(view) < 0) {
                    if (layoutParams == null) {
                        layoutParams = bmf();
                    }
                    if (viewGroup instanceof PriorityVerticalLinearLayout) {
                        view.setTag(a.g.sdk_pvl_layout_priority_tag_key, 2);
                    }
                    viewGroup.addView(view, layoutParams);
                }
            }
        }
    }

    private ViewGroup.LayoutParams bmf() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(11);
        layoutParams.rightMargin = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds24);
        layoutParams.topMargin = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds196);
        return layoutParams;
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void pK() {
        super.pK();
        if (this.fcb != null) {
            View view = this.fcb.getView();
            if (view != null && view.getParent() != null) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            this.fcb.zx();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void onDestroy() {
        if (this.fcb != null) {
            View view = this.fcb.getView();
            if (view != null && view.getParent() != null) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            this.fcb.onDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bmg() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new f(getPageContext().getPageActivity())));
    }

    public void u(JSONObject jSONObject) {
        if (this.fcb != null) {
            this.fcb.v(jSONObject);
        }
    }

    public void t(m mVar) {
        if (!TbadkCoreApplication.isLogin()) {
            bmh();
        }
        if (this.fcb != null && this.fcb.getView() != null && mVar != null && mVar.Yn != null) {
            this.fcb.a(mVar.Yn);
        }
    }

    public void setCanVisible(boolean z) {
        if (this.fcb != null) {
            this.fcb.setCanVisible(z);
        }
    }

    public void bmh() {
        if (this.fcb != null && this.fcb.getView() != null) {
            this.fcb.getView().setVisibility(8);
        }
    }

    public String xx() {
        return this.otherParams;
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }
}
