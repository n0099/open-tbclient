package com.baidu.tieba.im.model;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.tbadk.core.util.LocalViewSize;
import com.baidu.tbadk.coreExtra.data.PhotoUrlData;
import com.baidu.tieba.im.data.MemberData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public final class l extends com.baidu.adp.a.e {
    private long a;
    private int b;
    private int c;
    private long d;
    private String e;
    private com.baidu.tieba.im.message.bk f;
    private com.baidu.tieba.im.message.ak g;
    private com.baidu.tieba.im.message.aj h;
    private PhotoUrlData i;
    private boolean j;

    public final void a(PhotoUrlData photoUrlData) {
        this.i = photoUrlData;
    }

    public final int a() {
        return this.c;
    }

    public final long b() {
        return this.d;
    }

    public final String c() {
        return this.e;
    }

    public final long d() {
        return this.a;
    }

    public final int e() {
        return this.b;
    }

    @Override // com.baidu.adp.a.e
    protected final boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.a.e
    public final boolean cancelLoadData() {
        return false;
    }

    public final void a(Intent intent) {
        this.a = intent.getLongExtra("group_id", 0L);
        this.b = intent.getIntExtra("activity_from", 0);
        this.c = intent.getIntExtra("join_type", 0);
        this.d = intent.getLongExtra("inviter_user_id", 0L);
        this.e = intent.getStringExtra("default_invite_msg");
    }

    public final void a(Bundle bundle) {
        this.a = bundle.getLong("group_id", 0L);
        this.b = bundle.getInt("activity_from", 0);
        this.c = bundle.getInt("join_type");
        this.d = bundle.getLong("inviter_user_id");
        this.e = bundle.getString("default_invite_msg");
    }

    public final void a(long j, int i) {
        com.baidu.tieba.im.message.ak akVar = new com.baidu.tieba.im.message.ak();
        akVar.b(j);
        LocalViewSize.ImageSize c = LocalViewSize.a().c();
        LocalViewSize.ImageSize d = LocalViewSize.a().d();
        akVar.f(d.height);
        akVar.h(d.width);
        akVar.d(c.height);
        akVar.e(c.width);
        if (i == 4) {
            akVar.a("forumgroup_recommend");
        } else if (i == 5) {
            akVar.a("forumgroup_hot");
        } else if (i == 6) {
            akVar.a("forumgroup_official");
        } else if (i == 3) {
            akVar.a("grouptalk");
        } else if (i == 1) {
            akVar.a("usergroup");
        } else if (i == 7) {
            akVar.a("invitetalk");
        } else {
            akVar.a("");
        }
        this.g = akVar;
        super.sendMessage(this.g);
    }

    @Override // com.baidu.adp.a.e
    public final void cancelMessage() {
        super.cancelMessage();
    }

    public final void b(Bundle bundle) {
        bundle.putLong("group_id", this.a);
        bundle.putInt("activity_from", this.b);
        bundle.putInt("join_type", this.c);
        bundle.putLong("inviter_user_id", this.d);
        bundle.putString("default_invite_msg", this.e);
    }

    public final void a(com.baidu.tieba.im.message.bk bkVar) {
        this.i = null;
        this.f = bkVar;
    }

    public final com.baidu.tieba.im.message.bk f() {
        return this.f;
    }

    public final ArrayList<String> g() {
        if (this.f == null || this.f.d() == null || this.f.d().size() <= 0) {
            return null;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        for (PhotoUrlData photoUrlData : this.f.d()) {
            if (photoUrlData != null) {
                arrayList.add(photoUrlData.getBigurl());
            }
        }
        return arrayList;
    }

    public final String b(PhotoUrlData photoUrlData) {
        String str;
        String str2 = "";
        if (photoUrlData == null) {
            return null;
        }
        String picId = photoUrlData.getPicId();
        if (TextUtils.isEmpty(picId)) {
            return null;
        }
        this.i = photoUrlData;
        if (this.f == null || this.f.d() == null || this.f.d().size() <= 0) {
            return "";
        }
        int size = this.f.d().size();
        List<PhotoUrlData> d = this.f.d();
        int i = 1;
        while (i < size) {
            if (d.get(i) == null || d.get(i).getPicId().equals(picId)) {
                str = str2;
            } else {
                str = String.valueOf(str2) + d.get(i).getPicId();
                if (i != size - 1) {
                    str = String.valueOf(str) + ",";
                }
            }
            i++;
            str2 = str;
        }
        return str2;
    }

    public final String c(PhotoUrlData photoUrlData) {
        if (photoUrlData == null) {
            return null;
        }
        String picId = photoUrlData.getPicId();
        if (TextUtils.isEmpty(picId)) {
            return null;
        }
        this.i = photoUrlData;
        if (this.f == null || this.f.d() == null || this.f.d().size() <= 0) {
            return picId;
        }
        List<PhotoUrlData> d = this.f.d();
        int size = d.size();
        String str = "";
        for (int i = 1; i < size; i++) {
            if (d.get(i) != null) {
                str = String.valueOf(str) + d.get(i).getPicId() + ",";
            }
        }
        return String.valueOf(str) + picId;
    }

    public final void h() {
        if (this.f != null && this.f.d() != null && this.f.d().size() > 0 && this.i != null) {
            for (PhotoUrlData photoUrlData : this.f.d()) {
                if (photoUrlData != null && photoUrlData.getPicId().equals(this.i.getPicId())) {
                    this.f.d().remove(photoUrlData);
                    return;
                }
            }
        }
    }

    public final void i() {
        if (this.f != null && this.i != null) {
            if (this.f.d() == null) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(this.i);
                this.f.b(arrayList);
                return;
            }
            if (this.f.d().size() > 0 && this.f.d().get(0) != null && TextUtils.isEmpty(this.f.d().get(0).getPicId())) {
                this.f.d().remove(0);
            }
            PhotoUrlData photoUrlData = new PhotoUrlData();
            photoUrlData.setBigurl(this.i.getBigurl());
            photoUrlData.setPicId(this.i.getPicId());
            photoUrlData.setSmallurl(this.i.getSmallurl());
            this.f.d().add(photoUrlData);
        }
    }

    public final void j() {
        if (this.f != null && this.f.d() != null && this.f.d().size() > 0 && this.i != null) {
            Iterator<PhotoUrlData> it = this.f.d().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                PhotoUrlData next = it.next();
                if (next != null && next.getPicId().equals(this.i.getPicId())) {
                    this.f.d().remove(next);
                    break;
                }
            }
            if (this.f.d().size() > 0 && this.f.d().get(0) != null && TextUtils.isEmpty(this.f.d().get(0).getPicId())) {
                this.f.d().remove(0);
            }
            PhotoUrlData photoUrlData = new PhotoUrlData();
            photoUrlData.setBigurl(this.i.getBigurl());
            photoUrlData.setPicId(this.i.getPicId());
            photoUrlData.setSmallurl(this.i.getSmallurl());
            this.f.d().add(0, photoUrlData);
        }
    }

    public final void b(long j, int i) {
        if (this.h == null) {
            com.baidu.tieba.im.message.aj ajVar = new com.baidu.tieba.im.message.aj();
            ajVar.a(j);
            LocalViewSize.ImageSize c = LocalViewSize.a().c();
            LocalViewSize.ImageSize d = LocalViewSize.a().d();
            ajVar.e(d.height);
            ajVar.f(d.width);
            ajVar.c(c.height);
            ajVar.d(c.width);
            if (i == 4) {
                ajVar.a("forumgroup_recommend");
            } else if (i == 5) {
                ajVar.a("forumgroup_hot");
            } else if (i == 6) {
                ajVar.a("forumgroup_official");
            } else if (i == 3) {
                ajVar.a("grouptalk");
            } else if (i == 1) {
                ajVar.a("usergroup");
            } else if (i == 7) {
                ajVar.a("invitetalk");
            } else {
                ajVar.a("");
            }
            this.h = ajVar;
        }
        super.sendMessage(this.h);
    }

    public final boolean a(String str) {
        if (str != null && this.f != null && this.f.c() != null && this.f.c().size() > 0) {
            for (MemberData memberData : this.f.c()) {
                if (str.equals(String.valueOf(memberData.getUserId()))) {
                    this.f.c().remove(memberData);
                    return true;
                }
            }
        }
        return false;
    }

    public final com.baidu.adp.framework.message.d<?> k() {
        return this.g;
    }

    public final boolean l() {
        return this.j;
    }

    public final void a(boolean z) {
        this.j = z;
    }

    public final void b(String str) {
        com.baidu.tieba.im.message.a aVar = new com.baidu.tieba.im.message.a();
        aVar.a((com.baidu.tieba.im.message.a) str);
        super.sendMessage(aVar);
    }
}
