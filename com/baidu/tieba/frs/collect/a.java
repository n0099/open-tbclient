package com.baidu.tieba.frs.collect;

import android.text.TextUtils;
import com.baidu.adp.widget.ListView.u;
import com.baidu.tbadk.core.TbadkCoreApplication;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class a {
    private ArrayList<u> SO = new ArrayList<>();
    private int bmQ;
    MyCollectFrsActivity bmb;
    private long mForumId;

    public a(MyCollectFrsActivity myCollectFrsActivity, long j) {
        this.bmb = myCollectFrsActivity;
        this.mForumId = j;
    }

    public int QL() {
        return this.bmQ;
    }

    public void gD(int i) {
        this.bmQ = i;
    }

    public void QM() {
        this.bmQ = 0;
        Y(0, 0);
    }

    public void Me() {
        Y(0, 0);
    }

    public void QN() {
        Y(this.bmQ, 1);
    }

    private void Y(int i, int i2) {
        this.bmQ = i;
        GetUserForumStoreRequestMessage getUserForumStoreRequestMessage = new GetUserForumStoreRequestMessage();
        getUserForumStoreRequestMessage.setType(i2);
        getUserForumStoreRequestMessage.setUserId(getUserId());
        getUserForumStoreRequestMessage.setForumId(this.mForumId);
        getUserForumStoreRequestMessage.setOffset(this.bmQ);
        this.bmb.sendMessage(getUserForumStoreRequestMessage);
    }

    private long getUserId() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (TextUtils.isEmpty(currentAccount)) {
            return -1L;
        }
        return com.baidu.adp.lib.h.b.c(currentAccount, -1L);
    }

    public ArrayList<u> qN() {
        return this.SO;
    }

    public void setData(List<u> list) {
        if (list != null && !list.isEmpty()) {
            this.SO.addAll(list);
        }
    }

    public void clearData() {
        this.SO.clear();
    }
}
