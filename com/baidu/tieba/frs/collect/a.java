package com.baidu.tieba.frs.collect;

import android.text.TextUtils;
import com.baidu.adp.widget.ListView.u;
import com.baidu.tbadk.core.TbadkCoreApplication;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class a {
    private ArrayList<u> SS = new ArrayList<>();
    MyCollectFrsActivity bfn;
    private int bgc;
    private long mForumId;

    public a(MyCollectFrsActivity myCollectFrsActivity, long j) {
        this.bfn = myCollectFrsActivity;
        this.mForumId = j;
    }

    public int Or() {
        return this.bgc;
    }

    public void gn(int i) {
        this.bgc = i;
    }

    public void firstLoadData() {
        this.bgc = 0;
        Y(0, 0);
    }

    public void JU() {
        Y(0, 0);
    }

    public void Os() {
        Y(this.bgc, 1);
    }

    private void Y(int i, int i2) {
        this.bgc = i;
        GetUserForumStoreRequestMessage getUserForumStoreRequestMessage = new GetUserForumStoreRequestMessage();
        getUserForumStoreRequestMessage.setType(i2);
        getUserForumStoreRequestMessage.setUserId(getUserId());
        getUserForumStoreRequestMessage.setForumId(this.mForumId);
        getUserForumStoreRequestMessage.setOffset(this.bgc);
        this.bfn.sendMessage(getUserForumStoreRequestMessage);
    }

    public long getUserId() {
        TbadkCoreApplication.m411getInst();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (TextUtils.isEmpty(currentAccount)) {
            return -1L;
        }
        return Long.valueOf(currentAccount).longValue();
    }

    public ArrayList<u> qJ() {
        return this.SS;
    }

    public void setData(List<u> list) {
        if (list != null && !list.isEmpty()) {
            this.SS.addAll(list);
        }
    }

    public void clearData() {
        this.SS.clear();
    }
}
