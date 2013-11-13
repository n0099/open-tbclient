package com.baidu.tieba.im.groupCard;

import android.app.Activity;
import android.graphics.Bitmap;
import com.baidu.adp.widget.ImageView.e;
import com.baidu.tieba.data.h;
import com.baidu.tieba.im.chat.LocalViewSize;
import com.baidu.tieba.util.i;
/* loaded from: classes.dex */
public class b extends com.baidu.adp.a.d {
    private static Long f = 0L;
    private static final Long g = 300000L;

    /* renamed from: a  reason: collision with root package name */
    private long f1672a;
    private GroupCardActivity b;
    private i c = null;
    private c d = null;
    private String e = h.f1196a + "c/p/groupShareImg?group_id=";

    public static void a() {
        f = 0L;
    }

    public b(long j, GroupCardActivity groupCardActivity) {
        this.f1672a = j;
        this.e += this.f1672a;
        this.e += "&w=" + LocalViewSize.a().b();
        this.b = groupCardActivity;
    }

    @Override // com.baidu.adp.a.d
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.a.d
    public boolean cancelLoadData() {
        return false;
    }

    public e a(Activity activity, int i, int i2, com.baidu.tbadk.imageManager.c cVar) {
        this.c = new i(activity);
        if (System.currentTimeMillis() - f.longValue() > g.longValue()) {
            f = Long.valueOf(System.currentTimeMillis());
        }
        this.c.b("&t=" + f);
        this.c.b(true);
        this.c.a(i, i2);
        return this.c.a(this.e, cVar);
    }

    public void a(Bitmap bitmap) {
        this.d = new c(this, bitmap);
        this.d.execute(new String[0]);
    }
}
