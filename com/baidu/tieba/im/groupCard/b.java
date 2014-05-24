package com.baidu.tieba.im.groupCard;

import android.app.Activity;
import android.graphics.Bitmap;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.LocalViewSize;
import com.baidu.tbadk.editortool.ab;
/* loaded from: classes.dex */
public class b extends com.baidu.adp.base.b {
    private static Long f = 0L;
    private static final Long g = 300000L;
    private final long a;
    private final GroupCardActivity b;
    private ab c = null;
    private c d = null;
    private String e;

    public static void a() {
        f = 0L;
    }

    public b(long j, GroupCardActivity groupCardActivity) {
        this.e = String.valueOf(TbConfig.SERVER_ADDRESS) + "c/p/groupShareImg?group_id=";
        this.a = j;
        this.e = String.valueOf(this.e) + this.a;
        this.e = String.valueOf(this.e) + "&w=" + LocalViewSize.a().b();
        this.b = groupCardActivity;
    }

    @Override // com.baidu.adp.base.b
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.b
    public boolean cancelLoadData() {
        return false;
    }

    public com.baidu.adp.widget.a.a a(Activity activity, int i, int i2, com.baidu.tbadk.imageManager.d dVar) {
        this.c = new ab(activity);
        if (System.currentTimeMillis() - f.longValue() > g.longValue()) {
            f = Long.valueOf(System.currentTimeMillis());
        }
        this.c.b("&t=" + f);
        this.c.b(true);
        this.c.a(i, i2);
        return this.c.a(this.e, dVar, false);
    }

    public void a(Bitmap bitmap) {
        this.d = new c(this, bitmap);
        this.d.execute(new String[0]);
    }
}
