package com.baidu.tieba.im.groupCard;

import android.app.Activity;
import android.graphics.Bitmap;
import com.baidu.adp.a.e;
import com.baidu.tbadk.core.data.n;
import com.baidu.tbadk.core.util.LocalViewSize;
import com.baidu.tbadk.editortool.aa;
/* loaded from: classes.dex */
public final class b extends e {
    private static Long f = 0L;
    private static final Long g = 300000L;
    private final long a;
    private final GroupCardActivity b;
    private aa c = null;
    private c d = null;
    private String e;

    public static void a() {
        f = 0L;
    }

    public b(long j, GroupCardActivity groupCardActivity) {
        this.e = String.valueOf(n.a) + "c/p/groupShareImg?group_id=";
        this.a = j;
        this.e = String.valueOf(this.e) + this.a;
        this.e = String.valueOf(this.e) + "&w=" + LocalViewSize.a().b();
        this.b = groupCardActivity;
    }

    @Override // com.baidu.adp.a.e
    protected final boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.a.e
    public final boolean cancelLoadData() {
        return false;
    }

    public final com.baidu.adp.widget.ImageView.b a(Activity activity, int i, int i2, com.baidu.tbadk.imageManager.d dVar) {
        this.c = new aa(activity);
        if (System.currentTimeMillis() - f.longValue() > g.longValue()) {
            f = Long.valueOf(System.currentTimeMillis());
        }
        this.c.f = "&t=" + f;
        this.c.e = true;
        this.c.a(i, i2);
        return this.c.a(this.e, dVar, false);
    }

    public final void a(Bitmap bitmap) {
        this.d = new c(this, bitmap);
        this.d.execute(new String[0]);
    }
}
