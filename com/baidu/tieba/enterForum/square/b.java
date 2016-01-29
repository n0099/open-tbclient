package com.baidu.tieba.enterForum.square;

import android.view.View;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.enterForum.square.a.h;
import com.baidu.tieba.t;
import tbclient.GetForumClassList.DataRes;
/* loaded from: classes.dex */
public class b {
    private BaseFragmentActivity aKq;
    private com.baidu.tieba.enterForum.home.e aWr;
    private String aWv;
    public h aXA = null;
    private boolean aXB = false;
    private final com.baidu.adp.framework.listener.a aXC = new c(this, CmdConfigHttp.CMD_FORUM_CLASS_LIST, 309089);
    private e aXy;
    private a aXz;

    public View getView() {
        return this.aXz.getView();
    }

    public b(com.baidu.tieba.enterForum.home.e eVar) {
        this.aWr = eVar;
        this.aKq = eVar.getBaseFragmentActivity();
        this.aXy = new e(this.aKq);
        qD();
        pm();
    }

    private void pm() {
        this.aWr.registerListener(this.aXC);
    }

    private void qD() {
        this.aXz = new a(this.aWr);
        this.aXz.mPullView.a(new d(this));
        this.aXA = new h(this.aWr.getPageContext(), this.aXz.aXu, this.aWr.getUniqueId());
    }

    public void bY(boolean z) {
        if (this.aXz != null && this.aWr != null) {
            if (z) {
                if (Fq() && this.aWr.isPrimary() && this.aWr.isResumed()) {
                    Me();
                    return;
                }
                fV(t.j.no_data_text);
                this.aXz.MB();
                return;
            }
            fV(t.j.neterror);
            this.aXz.MB();
        }
    }

    public void Me() {
        String str = this.aWv;
        this.aWv = TbadkCoreApplication.getCurrentAccount();
        if (Fq() || (this.aWv != null && !this.aWv.equals(str))) {
            this.aXz.ns();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.aXz != null) {
            this.aXz.onChangeSkinType(i);
        }
        if (this.aXA != null) {
            this.aXA.db(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fV(int i) {
        if (Fq()) {
            this.aXz.fU(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(DataRes dataRes) {
        if (dataRes == null || this.aXA == null) {
            fV(t.j.no_data_text);
            return;
        }
        this.aXz.hideNoDataView();
        this.aXA.b(dataRes);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean d(ResponsedMessage<?> responsedMessage) {
        return (responsedMessage == null || responsedMessage.getOrginalMessage() == null || !(responsedMessage.getOrginalMessage().getExtra() instanceof ForumClassRequestNetMessage)) ? false : true;
    }

    public void onDestroy() {
        if (this.aXA != null) {
            this.aXA.onDestroy();
        }
    }

    public void onPause() {
        if (this.aXA != null) {
            this.aXA.onPause();
        }
    }

    public void onResume() {
        if (this.aXA != null) {
            this.aXA.onResume();
        }
    }

    public boolean Fq() {
        if (this.aXA == null || this.aXA.getData() == null) {
            return true;
        }
        return this.aXA.getData().isEmpty();
    }
}
