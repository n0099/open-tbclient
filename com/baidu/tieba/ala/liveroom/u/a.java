package com.baidu.tieba.ala.liveroom.u;

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
/* loaded from: classes4.dex */
public class a {
    private q avf;
    private View.OnClickListener eve = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.u.a.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.gwk != null && view == a.this.gwk.getView() && !UtilHelper.isFastDoubleClick()) {
                if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin()) {
                    AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.RENAME_CLICK);
                    alaStaticItem.addParams("other_params", a.this.otherParams);
                    AlaStaticsManager.getInst().onStatic(alaStaticItem);
                }
                if (!com.baidu.live.s.a.GQ().GR().c(a.this.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_SDK_RENAME)) {
                    a.this.gwl = new c(a.this.mTbPageContext.getPageActivity(), a.this.mTbPageContext, a.this.avf, a.this.otherParams);
                    a.this.gwl.show();
                }
            }
        }
    };
    private ViewGroup fNw;
    protected b gwk;
    private c gwl;
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
        this.avf = qVar;
        if (this.gwk == null) {
            this.gwk = new b(getPageContext(), qVar.ayV, this.eve);
        }
        if (this.fNw != null && this.fNw.indexOfChild(this.gwk.getView()) > 0) {
            this.fNw.removeView(this.gwk.getView());
        }
        this.fNw = viewGroup;
        this.gwk.getView().setId(a.g.guide_rename_view);
        this.gwk.getView().setVisibility(0);
        initTasks();
        bMo();
        return true;
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    private void bMo() {
        com.baidu.live.s.a.GQ().a(new com.baidu.live.s.c() { // from class: com.baidu.tieba.ala.liveroom.u.a.1
        });
    }

    private void DV(String str) {
        if (this.avf != null) {
            bMp();
            if (this.gwl != null && this.gwl.isShowing()) {
                this.gwl.onSuccess();
            }
            if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin()) {
                AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.REMANE_SUC);
                alaStaticItem.addParams("other_params", this.otherParams);
                AlaStaticsManager.getInst().onStatic(alaStaticItem);
            }
            if (this.mTbPageContext != null) {
                this.mTbPageContext.showToast(this.mTbPageContext.getPageActivity().getResources().getString(a.i.sdk_rename_success_toast));
            }
            if (this.avf != null && this.avf.mLiveInfo != null) {
                m(this.avf.mLiveInfo.live_id, 1);
            }
        }
    }

    private void DW(String str) {
        if (this.gwl != null && this.gwl.isShowing()) {
            this.gwl.onFail();
        }
        if (!TextUtils.isEmpty(str)) {
            this.mTbPageContext.showToast(str);
        } else {
            this.mTbPageContext.showToast(this.mTbPageContext.getPageActivity().getResources().getString(a.i.sdk_rename_fail_toast));
        }
    }

    public void O(Intent intent) {
        if (intent == null) {
            DW(this.mTbPageContext.getPageActivity().getResources().getString(a.i.sdk_rename_fail_toast));
        } else if (intent.getBooleanExtra("isModifySuccess", false)) {
            DV(this.mTbPageContext.getPageActivity().getResources().getString(a.i.sdk_rename_success_toast));
        } else {
            DW(this.mTbPageContext.getPageActivity().getResources().getString(a.i.sdk_rename_fail_toast));
        }
    }

    public void e(ViewGroup viewGroup, q qVar) {
        if (d(viewGroup, qVar)) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(12);
            layoutParams.setMargins(getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds18), 0, getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds180), 0);
            layoutParams.bottomMargin = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_tbds130) + getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds18);
            viewGroup.addView(this.gwk.getView(), layoutParams);
        }
    }

    public void bMp() {
        if (this.fNw != null && this.fNw.indexOfChild(this.gwk.getView()) > 0) {
            this.fNw.removeView(this.gwk.getView());
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

    public void m(long j, int i) {
        HttpMessage httpMessage = new HttpMessage(1021125);
        httpMessage.addParam("live_id", j);
        httpMessage.addParam("no_cache", i);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void destroy() {
        MessageManager.getInstance().unRegisterTask(1021125);
    }
}
