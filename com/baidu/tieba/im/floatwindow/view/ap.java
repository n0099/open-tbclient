package com.baidu.tieba.im.floatwindow.view;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.UserData;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public class ap {
    private HashMap<String, Integer> aYW = new HashMap<>();
    private as aYX;

    public void a(as asVar) {
        this.aYX = asVar;
    }

    public void ar(List<UserData> list) {
        if (list != null && !list.isEmpty()) {
            for (UserData userData : list) {
                if (userData != null) {
                    if (userData.getIsFriend() == 1) {
                        this.aYW.put(userData.getUserId(), 1);
                    } else {
                        com.baidu.tieba.im.i.a(new aq(this, userData), new ar(this, userData));
                    }
                }
            }
        }
    }

    public int b(UserData userData) {
        if (userData == null) {
            return 0;
        }
        return gE(userData.getUserId());
    }

    public boolean gC(String str) {
        int gE = gE(str);
        return gE == 1 || gE == 3;
    }

    public int gE(String str) {
        if (!StringUtils.isNull(str) && this.aYW.containsKey(str)) {
            return this.aYW.get(str).intValue();
        }
        return 0;
    }

    public void F(String str, int i) {
        if (!StringUtils.isNull(str)) {
            this.aYW.put(str, Integer.valueOf(i));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int c(UserData userData) {
        if (userData == null) {
            return 0;
        }
        return Y(userData.getUserIdLong());
    }

    private int Y(long j) {
        com.baidu.tieba.im.data.b X = com.baidu.tieba.im.db.m.MI().X(j);
        if (X == null || X.getStatus() == 0) {
            return 0;
        }
        if (X.getStatus() == 3) {
            return 2;
        }
        if (X.getStatus() == 2) {
            return 3;
        }
        return X.getStatus() == 1 ? 4 : 0;
    }
}
