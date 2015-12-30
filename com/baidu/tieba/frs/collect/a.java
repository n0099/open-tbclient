package com.baidu.tieba.frs.collect;

import android.text.TextUtils;
import com.baidu.adp.widget.ListView.u;
import com.baidu.tbadk.core.TbadkCoreApplication;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class a {
    private ArrayList<u> Ts = new ArrayList<>();
    private int bjU;
    MyCollectFrsActivity bjg;
    private long mForumId;

    public a(MyCollectFrsActivity myCollectFrsActivity, long j) {
        this.bjg = myCollectFrsActivity;
        this.mForumId = j;
    }

    public int OJ() {
        return this.bjU;
    }

    public void gg(int i) {
        this.bjU = i;
    }

    public void firstLoadData() {
        this.bjU = 0;
        Y(0, 0);
    }

    public void Kn() {
        Y(0, 0);
    }

    public void OK() {
        Y(this.bjU, 1);
    }

    private void Y(int i, int i2) {
        this.bjU = i;
        GetUserForumStoreRequestMessage getUserForumStoreRequestMessage = new GetUserForumStoreRequestMessage();
        getUserForumStoreRequestMessage.setType(i2);
        getUserForumStoreRequestMessage.setUserId(getUserId());
        getUserForumStoreRequestMessage.setForumId(this.mForumId);
        getUserForumStoreRequestMessage.setOffset(this.bjU);
        this.bjg.sendMessage(getUserForumStoreRequestMessage);
    }

    public long getUserId() {
        TbadkCoreApplication.m411getInst();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (TextUtils.isEmpty(currentAccount)) {
            return -1L;
        }
        return Long.valueOf(currentAccount).longValue();
    }

    public ArrayList<u> qs() {
        return this.Ts;
    }

    public void setData(List<u> list) {
        if (list != null && !list.isEmpty()) {
            this.Ts.addAll(list);
        }
    }

    public void clearData() {
        this.Ts.clear();
    }
}
