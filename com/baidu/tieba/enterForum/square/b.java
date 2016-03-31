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
    private BaseFragmentActivity aNm;
    private com.baidu.tieba.enterForum.home.e bba;
    private String bbe;
    private e bch;
    private a bci;
    public h bcj = null;
    private boolean bck = false;
    private final com.baidu.adp.framework.listener.a bcl = new c(this, CmdConfigHttp.CMD_FORUM_CLASS_LIST, 309089);

    public View getView() {
        return this.bci.getView();
    }

    public b(com.baidu.tieba.enterForum.home.e eVar) {
        this.bba = eVar;
        this.aNm = eVar.getBaseFragmentActivity();
        this.bch = new e(this.aNm);
        pU();
        pf();
    }

    private void pf() {
        this.bba.registerListener(this.bcl);
    }

    private void pU() {
        this.bci = new a(this.bba);
        this.bci.mPullView.a(new d(this));
        this.bcj = new h(this.bba.getPageContext(), this.bci.bcd, this.bba.getUniqueId());
    }

    public void ck(boolean z) {
        if (this.bci != null && this.bba != null) {
            if (z) {
                if (Gd() && this.bba.isPrimary() && this.bba.isResumed()) {
                    NS();
                    return;
                }
                gl(t.j.no_data_text);
                this.bci.Op();
                return;
            }
            gl(t.j.neterror);
            this.bci.Op();
        }
    }

    public void NS() {
        String str = this.bbe;
        this.bbe = TbadkCoreApplication.getCurrentAccount();
        if (Gd() || (this.bbe != null && !this.bbe.equals(str))) {
            this.bci.nk();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.bci != null) {
            this.bci.onChangeSkinType(i);
        }
        if (this.bcj != null) {
            this.bcj.de(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gl(int i) {
        if (Gd()) {
            this.bci.gk(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(DataRes dataRes) {
        if (dataRes == null || this.bcj == null) {
            gl(t.j.no_data_text);
            return;
        }
        this.bci.hideNoDataView();
        this.bcj.b(dataRes);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean d(ResponsedMessage<?> responsedMessage) {
        return (responsedMessage == null || responsedMessage.getOrginalMessage() == null || !(responsedMessage.getOrginalMessage().getExtra() instanceof ForumClassRequestNetMessage)) ? false : true;
    }

    public void onDestroy() {
        if (this.bcj != null) {
            this.bcj.onDestroy();
        }
    }

    public void onPause() {
        if (this.bcj != null) {
            this.bcj.onPause();
        }
    }

    public void onResume() {
        if (this.bcj != null) {
            this.bcj.onResume();
        }
    }

    public boolean Gd() {
        if (this.bcj == null || this.bcj.getData() == null) {
            return true;
        }
        return this.bcj.getData().isEmpty();
    }
}
