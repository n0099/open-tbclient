package com.baidu.tieba.ala.liveroom.s;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.data.n;
import com.baidu.live.message.GetUserInfoHttpResponseMessage;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.statics.AlaStaticItem;
import com.baidu.live.tbadk.statics.AlaStaticsManager;
import com.baidu.live.tbadk.statics.SdkStaticKeys;
import com.baidu.live.tbadk.task.TbHttpMessageTask;
import com.baidu.live.u.a;
/* loaded from: classes3.dex */
public class a {
    private n aDK;
    private View.OnClickListener dRK = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.s.a.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.fOZ != null && view == a.this.fOZ.getView() && !UtilHelper.isFastDoubleClick()) {
                if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin()) {
                    AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.RENAME_CLICK);
                    alaStaticItem.addParams("other_params", a.this.otherParams);
                    AlaStaticsManager.getInst().onStatic(alaStaticItem);
                }
                if (!com.baidu.live.r.a.Ej().Ek().c(a.this.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_SDK_RENAME)) {
                    a.this.fPa = new c(a.this.mTbPageContext.getPageActivity(), a.this.mTbPageContext, a.this.aDK, a.this.otherParams);
                    a.this.fPa.show();
                }
            }
        }
    };
    protected b fOZ;
    private c fPa;
    private ViewGroup faV;
    protected TbPageContext mTbPageContext;
    private String otherParams;

    public a(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TbPageContext getPageContext() {
        return this.mTbPageContext;
    }

    protected boolean d(ViewGroup viewGroup, n nVar) {
        if (viewGroup == null) {
            return false;
        }
        this.aDK = nVar;
        if (this.fOZ == null) {
            this.fOZ = new b(getPageContext(), nVar.aqD, this.dRK);
        }
        if (this.faV != null && this.faV.indexOfChild(this.fOZ.getView()) > 0) {
            this.faV.removeView(this.fOZ.getView());
        }
        this.faV = viewGroup;
        this.fOZ.getView().setId(a.g.guide_rename_view);
        this.fOZ.getView().setVisibility(0);
        initTasks();
        bzN();
        return true;
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    private void bzN() {
        com.baidu.live.r.a.Ej().a(new com.baidu.live.r.c() { // from class: com.baidu.tieba.ala.liveroom.s.a.1
        });
    }

    private void Ba(String str) {
        if (this.aDK != null) {
            bzO();
            if (this.fPa != null && this.fPa.isShowing()) {
                this.fPa.onSuccess();
            }
            if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin()) {
                AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.REMANE_SUC);
                alaStaticItem.addParams("other_params", this.otherParams);
                AlaStaticsManager.getInst().onStatic(alaStaticItem);
            }
            if (this.mTbPageContext != null) {
                this.mTbPageContext.showToast(this.mTbPageContext.getPageActivity().getResources().getString(a.i.sdk_rename_success_toast));
            }
            if (this.aDK != null && this.aDK.mLiveInfo != null) {
                k(this.aDK.mLiveInfo.live_id, 1);
            }
        }
    }

    private void Bb(String str) {
        if (this.fPa != null && this.fPa.isShowing()) {
            this.fPa.onFail();
        }
        if (!TextUtils.isEmpty(str)) {
            this.mTbPageContext.showToast(str);
        } else {
            this.mTbPageContext.showToast(this.mTbPageContext.getPageActivity().getResources().getString(a.i.sdk_rename_fail_toast));
        }
    }

    public void Q(Intent intent) {
        if (intent == null) {
            Bb(this.mTbPageContext.getPageActivity().getResources().getString(a.i.sdk_rename_fail_toast));
        } else if (intent.getBooleanExtra("isModifySuccess", false)) {
            Ba(this.mTbPageContext.getPageActivity().getResources().getString(a.i.sdk_rename_success_toast));
        } else {
            Bb(this.mTbPageContext.getPageActivity().getResources().getString(a.i.sdk_rename_fail_toast));
        }
    }

    public void e(ViewGroup viewGroup, n nVar) {
        if (d(viewGroup, nVar)) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(12);
            layoutParams.setMargins(getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds18), 0, getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds180), 0);
            layoutParams.bottomMargin = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_tbds130) + getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds18);
            viewGroup.addView(this.fOZ.getView(), layoutParams);
        }
    }

    public void bzO() {
        if (this.faV != null && this.faV.indexOfChild(this.fOZ.getView()) > 0) {
            this.faV.removeView(this.fOZ.getView());
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
