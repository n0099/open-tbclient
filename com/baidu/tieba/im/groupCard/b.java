package com.baidu.tieba.im.groupCard;

import com.baidu.adp.base.e;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.LocalViewSize;
/* loaded from: classes.dex */
public class b extends e {
    private static Long e = 0L;
    private static final Long f = 300000L;
    private final long a;
    private final GroupCardActivity b;
    private c c;
    private String d;

    public static void a() {
        e = 0L;
    }

    public b(long j, GroupCardActivity groupCardActivity) {
        super(groupCardActivity);
        this.c = null;
        this.d = String.valueOf(TbConfig.SERVER_ADDRESS) + "c/p/groupShareImg?group_id=";
        this.a = j;
        this.d = String.valueOf(this.d) + this.a;
        this.d = String.valueOf(this.d) + "&w=" + LocalViewSize.a().b();
        this.b = groupCardActivity;
    }

    @Override // com.baidu.adp.base.e
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        return false;
    }

    public String a(int i, int i2) {
        if (System.currentTimeMillis() - e.longValue() > f.longValue()) {
            e = Long.valueOf(System.currentTimeMillis());
        }
        return String.valueOf(this.d) + "&t=" + e;
    }

    public void b() {
        this.c = new c(this);
        this.c.execute(new String[0]);
    }
}
