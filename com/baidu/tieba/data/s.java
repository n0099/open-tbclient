package com.baidu.tieba.data;

import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.UserData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public class s {
    private int c;
    private HashMap<String, MetaData> a = new HashMap<>();
    private List<FriendFeedThreadData> b = new ArrayList();
    private List<UserData> d = new ArrayList();

    public HashMap<String, MetaData> a() {
        return this.a;
    }

    public List<FriendFeedThreadData> b() {
        return this.b;
    }

    public void a(List<FriendFeedThreadData> list) {
        this.b = list;
    }

    public void a(int i) {
        this.c = i;
    }

    public boolean c() {
        return this.c == 1;
    }
}
