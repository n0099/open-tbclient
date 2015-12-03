package com.baidu.tieba.enterForum.square;

import android.view.View;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.enterForum.square.a.h;
import com.baidu.tieba.n;
import tbclient.GetForumClassList.DataRes;
/* loaded from: classes.dex */
public class b {
    private BaseFragmentActivity aHN;
    private com.baidu.tieba.enterForum.home.e aQt;
    private e aRv;
    private a aRw;
    private int mSkinType = 3;
    public h aRx = null;
    private boolean aRy = false;
    private final com.baidu.adp.framework.listener.a aRz = new c(this, CmdConfigHttp.CMD_FORUM_CLASS_LIST, 309089);

    public View getView() {
        return this.aRw.getView();
    }

    public b(com.baidu.tieba.enterForum.home.e eVar) {
        this.aQt = eVar;
        this.aHN = eVar.getBaseFragmentActivity();
        this.aRv = new e(this.aHN);
        initUI();
        initListener();
    }

    private void initListener() {
        this.aHN.registerListener(this.aRz);
    }

    private void initUI() {
        this.aRw = new a(this.aQt);
        this.aRw.mPullView.a(new d(this));
        this.aRx = new h(this.aQt.getPageContext(), this.aRw.aRs);
    }

    public void bZ(boolean z) {
        if (this.aRw != null && this.aQt != null) {
            if (z) {
                if (Eg() && this.aQt.isPrimary() && this.aQt.isResumed()) {
                    JU();
                    return;
                }
                fB(n.i.no_data_text);
                this.aRw.Kr();
                return;
            }
            fB(n.i.neterror);
            this.aRw.Kr();
        }
    }

    public void JU() {
        this.aRw.nD();
    }

    public void onChangeSkinType(int i) {
        if (this.aRw != null) {
            this.aRw.onChangeSkinType(i);
        }
        if (this.aRx != null) {
            this.aRx.cZ(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fB(int i) {
        if (Eg()) {
            this.aRw.fA(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(DataRes dataRes) {
        if (dataRes == null || this.aRx == null) {
            fB(n.i.no_data_text);
            return;
        }
        this.aRw.hideNoDataView();
        this.aRx.b(dataRes);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean d(ResponsedMessage<?> responsedMessage) {
        return (responsedMessage == null || responsedMessage.getOrginalMessage() == null || !(responsedMessage.getOrginalMessage().getExtra() instanceof ForumClassRequestNetMessage)) ? false : true;
    }

    public void onDestroy() {
        if (this.aRx != null) {
            this.aRx.onDestroy();
        }
    }

    public void onPause() {
        if (this.aRx != null) {
            this.aRx.onPause();
        }
    }

    public void onResume() {
        if (this.aRx != null) {
            this.aRx.onResume();
        }
    }

    public boolean Eg() {
        if (this.aRx == null || this.aRx.getData() == null) {
            return true;
        }
        return this.aRx.getData().isEmpty();
    }
}
