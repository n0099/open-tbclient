package com.baidu.tieba.enterForum.square;

import android.view.View;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.enterForum.square.a.h;
import com.baidu.tieba.n;
import tbclient.GetForumClassList.DataRes;
/* loaded from: classes.dex */
public class b {
    private BaseFragmentActivity aJl;
    private com.baidu.tieba.enterForum.home.e aUk;
    private String aUo;
    private e aVl;
    private a aVm;
    public h aVn = null;
    private boolean aVo = false;
    private final com.baidu.adp.framework.listener.a aVp = new c(this, CmdConfigHttp.CMD_FORUM_CLASS_LIST, 309089);

    public View getView() {
        return this.aVm.getView();
    }

    public b(com.baidu.tieba.enterForum.home.e eVar) {
        this.aUk = eVar;
        this.aJl = eVar.getBaseFragmentActivity();
        this.aVl = new e(this.aJl);
        initUI();
        initListener();
    }

    private void initListener() {
        this.aUk.registerListener(this.aVp);
    }

    private void initUI() {
        this.aVm = new a(this.aUk);
        this.aVm.mPullView.a(new d(this));
        this.aVn = new h(this.aUk.getPageContext(), this.aVm.aVi, this.aUk.getUniqueId());
    }

    public void ca(boolean z) {
        if (this.aVm != null && this.aUk != null) {
            if (z) {
                if (DV() && this.aUk.isPrimary() && this.aUk.isResumed()) {
                    Kn();
                    return;
                }
                fw(n.j.no_data_text);
                this.aVm.KK();
                return;
            }
            fw(n.j.neterror);
            this.aVm.KK();
        }
    }

    public void Kn() {
        String str = this.aUo;
        this.aUo = TbadkCoreApplication.getCurrentAccount();
        if (DV() || (this.aUo != null && !this.aUo.equals(str))) {
            this.aVm.nb();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.aVm != null) {
            this.aVm.onChangeSkinType(i);
        }
        if (this.aVn != null) {
            this.aVn.cK(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fw(int i) {
        if (DV()) {
            this.aVm.fv(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(DataRes dataRes) {
        if (dataRes == null || this.aVn == null) {
            fw(n.j.no_data_text);
            return;
        }
        this.aVm.hideNoDataView();
        this.aVn.b(dataRes);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean d(ResponsedMessage<?> responsedMessage) {
        return (responsedMessage == null || responsedMessage.getOrginalMessage() == null || !(responsedMessage.getOrginalMessage().getExtra() instanceof ForumClassRequestNetMessage)) ? false : true;
    }

    public void onDestroy() {
        if (this.aVn != null) {
            this.aVn.onDestroy();
        }
    }

    public void onPause() {
        if (this.aVn != null) {
            this.aVn.onPause();
        }
    }

    public void onResume() {
        if (this.aVn != null) {
            this.aVn.onResume();
        }
    }

    public boolean DV() {
        if (this.aVn == null || this.aVn.getData() == null) {
            return true;
        }
        return this.aVn.getData().isEmpty();
    }
}
