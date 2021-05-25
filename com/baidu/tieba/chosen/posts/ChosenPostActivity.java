package com.baidu.tieba.chosen.posts;

import android.os.Bundle;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import d.a.m0.g0.c.a;
import d.a.n0.a0.a.b;
import d.a.n0.a0.a.c.d;
/* loaded from: classes4.dex */
public class ChosenPostActivity extends BaseActivity<ChosenPostActivity> implements a {
    public static final int EVENT_ID_PICTURE_CLICK = 4096;
    public static final int EVENT_ID_RELOAD_DATA = 4100;
    public static final int EVENT_ID_REQUEST_BOTTOM = 4098;
    public static final int EVENT_ID_REQUEST_PULL = 4097;
    public static final int EVENT_ID_SEND_CACHE = 4099;
    public static final int EVENT_ID_UNLIKE = 4101;
    public static final int EVENT_ID_UNLIKE_RESULT = 4102;
    public ChosenPostModelController mModelController;
    public b mViewController;
    public ViewEventCenter mViewEventController;

    private void handlePictureClick(d.a.m0.g0.c.b bVar) {
        d.a.m0.g0.b.a a2 = bVar.a();
        if (a2 instanceof d) {
            sendMessage(((d) a2).a(getPageContext().getPageActivity()));
        }
    }

    public ViewEventCenter getEventCenter() {
        if (this.mViewEventController == null) {
            this.mViewEventController = new ViewEventCenter();
        }
        return this.mViewEventController;
    }

    public ChosenPostModelController getModelController() {
        if (this.mModelController == null) {
            this.mModelController = new ChosenPostModelController(this);
        }
        return this.mModelController;
    }

    public b getViewController() {
        if (this.mViewController == null) {
            this.mViewController = new b(this);
        }
        return this.mViewController;
    }

    @Override // d.a.m0.g0.c.a
    public boolean isEventMustSelf() {
        return false;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i2) {
        super.onChangeSkinType(i2);
        getViewController().p(getPageContext(), i2);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getEventCenter().addEventDelegate(this);
        this.mModelController = getModelController();
        this.mViewController = getViewController();
        if (getIntent() != null) {
            this.mModelController.x(getIntent().getExtras());
        } else if (bundle != null) {
            this.mModelController.x(bundle);
        } else {
            this.mModelController.x(null);
        }
        setContentView(this.mViewController.q());
        this.mViewController.s();
        this.mViewController.p(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        adjustResizeForSoftInput();
    }

    @Override // d.a.m0.g0.c.a
    public boolean onEventDispatch(d.a.m0.g0.c.b bVar) {
        if (bVar.b() == 4096) {
            handlePictureClick(bVar);
        }
        return getViewController().r(bVar) || getModelController().z(bVar);
    }

    public void onServerError(ErrorData errorData) {
        if (errorData == null || StringUtils.isNull(errorData.error_msg)) {
            return;
        }
        showToast(errorData.error_msg);
    }
}
