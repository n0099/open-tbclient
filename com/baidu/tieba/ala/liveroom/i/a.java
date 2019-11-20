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
    private b dXZ;
    private ViewGroup dYe;
    private com.baidu.live.m.b efM;
    private String otherParams;

    public a(TbPageContext tbPageContext, b bVar) {
        super(tbPageContext);
        this.dXZ = bVar;
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void Z(ViewGroup viewGroup) {
        super.Z(viewGroup);
        a(viewGroup, null);
    }

    public void a(ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        CustomResponsedMessage runTask;
        if (com.baidu.live.l.a.uB().ajF.oo()) {
            if (this.efM == null && (runTask = MessageManager.getInstance().runTask(2913034, com.baidu.live.m.b.class, getPageContext().getPageActivity())) != null && runTask.getData() != null) {
                this.efM = (com.baidu.live.m.b) runTask.getData();
            }
            if (this.efM != null) {
                this.efM.uN();
            }
            b(viewGroup, layoutParams);
        }
    }

    private void b(ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        View view;
        if (viewGroup != null) {
            this.dYe = viewGroup;
            if (this.efM != null && (view = this.efM.getView()) != null) {
                view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.i.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.CLICK_FLOWER);
                        alaStaticItem.addParams("feed_id", HKStaticManager.FEED_ID);
                        alaStaticItem.addParams("live_id", HKStaticManager.LIVE_ID);
                        alaStaticItem.addParams("other_params", a.this.tn());
                        AlaStaticsManager.getInst().onStatic(alaStaticItem);
                        if (TbadkCoreApplication.isLogin()) {
                            if (a.this.dXZ != null) {
                                a.this.dXZ.mZ(8);
                            }
                            a.this.aRT();
                            return;
                        }
                        ViewHelper.skipToLoginActivity(a.this.getPageContext().getPageActivity());
                    }
                });
                if (viewGroup.indexOfChild(view) < 0) {
                    if (layoutParams == null) {
                        layoutParams = aRS();
                    }
                    viewGroup.addView(view, layoutParams);
                }
            }
        }
    }

    private ViewGroup.LayoutParams aRS() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(11);
        layoutParams.rightMargin = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds24);
        layoutParams.topMargin = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds196);
        return layoutParams;
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void nA() {
        super.nA();
        if (this.efM != null) {
            View view = this.efM.getView();
            if (view != null && view.getParent() != null) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            this.efM.uO();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void onDestroy() {
        if (this.efM != null) {
            View view = this.efM.getView();
            if (view != null && view.getParent() != null) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            this.efM.onDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aRT() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new d(getPageContext().getPageActivity())));
    }

    public void y(JSONObject jSONObject) {
        if (this.efM != null) {
            this.efM.z(jSONObject);
        }
    }

    public void k(i iVar) {
        if (!TbadkCoreApplication.isLogin()) {
            aRU();
        }
        if (this.efM != null && this.efM.getView() != null && iVar != null && iVar.Pp != null) {
            this.efM.a(iVar.Pp);
        }
    }

    public void setCanVisible(boolean z) {
        if (this.efM != null) {
            this.efM.setCanVisible(z);
        }
    }

    public void aRU() {
        if (this.efM != null && this.efM.getView() != null) {
            this.efM.getView().setVisibility(8);
        }
    }

    public String tn() {
        return this.otherParams;
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }
}
