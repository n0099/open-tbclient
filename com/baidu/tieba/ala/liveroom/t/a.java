package com.baidu.tieba.ala.liveroom.t;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.data.q;
import com.baidu.live.message.GetUserInfoHttpResponseMessage;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.statics.AlaStaticItem;
import com.baidu.live.tbadk.statics.AlaStaticsManager;
import com.baidu.live.tbadk.statics.SdkStaticKeys;
import com.baidu.live.tbadk.task.TbHttpMessageTask;
/* loaded from: classes3.dex */
public class a {
    private q aLQ;
    private View.OnClickListener eoP = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.t.a.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.gqO != null && view == a.this.gqO.getView() && !UtilHelper.isFastDoubleClick()) {
                if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin()) {
                    AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.RENAME_CLICK);
                    alaStaticItem.addParams("other_params", a.this.otherParams);
                    AlaStaticsManager.getInst().onStatic(alaStaticItem);
                }
                if (!com.baidu.live.s.a.GJ().GK().c(a.this.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_SDK_RENAME)) {
                    a.this.gqP = new c(a.this.mTbPageContext.getPageActivity(), a.this.mTbPageContext, a.this.aLQ, a.this.otherParams);
                    a.this.gqP.show();
                }
            }
        }
    };
    private ViewGroup fIb;
    protected b gqO;
    private c gqP;
    protected TbPageContext mTbPageContext;
    private String otherParams;

    public a(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TbPageContext getPageContext() {
        return this.mTbPageContext;
    }

    protected boolean d(ViewGroup viewGroup, q qVar) {
        if (viewGroup == null) {
            return false;
        }
        this.aLQ = qVar;
        if (this.gqO == null) {
            this.gqO = new b(getPageContext(), qVar.axI, this.eoP);
        }
        if (this.fIb != null && this.fIb.indexOfChild(this.gqO.getView()) > 0) {
            this.fIb.removeView(this.gqO.getView());
        }
        this.fIb = viewGroup;
        this.gqO.getView().setId(a.g.guide_rename_view);
        this.gqO.getView().setVisibility(0);
        initTasks();
        bJi();
        return true;
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    private void bJi() {
        com.baidu.live.s.a.GJ().a(new com.baidu.live.s.c() { // from class: com.baidu.tieba.ala.liveroom.t.a.1
        });
    }

    private void Dj(String str) {
        if (this.aLQ != null) {
            bJj();
            if (this.gqP != null && this.gqP.isShowing()) {
                this.gqP.onSuccess();
            }
            if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin()) {
                AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.REMANE_SUC);
                alaStaticItem.addParams("other_params", this.otherParams);
                AlaStaticsManager.getInst().onStatic(alaStaticItem);
            }
            if (this.mTbPageContext != null) {
                this.mTbPageContext.showToast(this.mTbPageContext.getPageActivity().getResources().getString(a.i.sdk_rename_success_toast));
            }
            if (this.aLQ != null && this.aLQ.mLiveInfo != null) {
                k(this.aLQ.mLiveInfo.live_id, 1);
            }
        }
    }

    private void Dk(String str) {
        if (this.gqP != null && this.gqP.isShowing()) {
            this.gqP.onFail();
        }
        if (!TextUtils.isEmpty(str)) {
            this.mTbPageContext.showToast(str);
        } else {
            this.mTbPageContext.showToast(this.mTbPageContext.getPageActivity().getResources().getString(a.i.sdk_rename_fail_toast));
        }
    }

    public void N(Intent intent) {
        if (intent == null) {
            Dk(this.mTbPageContext.getPageActivity().getResources().getString(a.i.sdk_rename_fail_toast));
        } else if (intent.getBooleanExtra("isModifySuccess", false)) {
            Dj(this.mTbPageContext.getPageActivity().getResources().getString(a.i.sdk_rename_success_toast));
        } else {
            Dk(this.mTbPageContext.getPageActivity().getResources().getString(a.i.sdk_rename_fail_toast));
        }
    }

    public void e(ViewGroup viewGroup, q qVar) {
        if (d(viewGroup, qVar)) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(12);
            layoutParams.setMargins(getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds18), 0, getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds180), 0);
            layoutParams.bottomMargin = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_tbds130) + getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds18);
            viewGroup.addView(this.gqO.getView(), layoutParams);
        }
    }

    public void bJj() {
        if (this.fIb != null && this.fIb.indexOfChild(this.gqO.getView()) > 0) {
            this.fIb.removeView(this.gqO.getView());
        }
    }

    private void initTasks() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021125, TbConfig.SERVER_ADDRESS + "ala/sdk/v1/open/getUserInfo");
        tbHttpMessageTask.setResponsedClass(GetUserInfoHttpResponseMessage.class);
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void k(long j, int i) {
        HttpMessage httpMessage = new HttpMessage(1021125);
        httpMessage.addParam("live_id", j);
        httpMessage.addParam("no_cache", i);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void destroy() {
        MessageManager.getInstance().unRegisterTask(1021125);
    }
}
