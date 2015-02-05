package com.baidu.tieba.im.floatwindow.view;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.UserData;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public class ap {
    private HashMap<String, Integer> bas = new HashMap<>();
    private as bat;

    public void a(as asVar) {
        this.bat = asVar;
    }

    public void at(List<UserData> list) {
        if (list != null && !list.isEmpty()) {
            for (UserData userData : list) {
                if (userData != null) {
                    if (userData.getIsFriend() == 1) {
                        this.bas.put(userData.getUserId(), 1);
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
        return gG(userData.getUserId());
    }

    public boolean gE(String str) {
        int gG = gG(str);
        return gG == 1 || gG == 3;
    }

    public int gG(String str) {
        if (!StringUtils.isNull(str) && this.bas.containsKey(str)) {
            return this.bas.get(str).intValue();
        }
        return 0;
    }

    public void F(String str, int i) {
        if (!StringUtils.isNull(str)) {
            this.bas.put(str, Integer.valueOf(i));
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
        com.baidu.tieba.im.data.b X = com.baidu.tieba.im.db.m.MZ().X(j);
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
