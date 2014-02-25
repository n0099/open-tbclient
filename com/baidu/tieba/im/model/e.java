package com.baidu.tieba.im.model;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.sapi2.shell.SapiErrorCode;
import com.baidu.tieba.im.chat.LocalViewSize;
import com.baidu.tieba.im.data.MemberData;
import com.baidu.tieba.im.data.PhotoUrlData;
import com.baidu.tieba.im.message.ca;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class e extends com.baidu.adp.a.d {
    private long a;
    private int b;
    private int c;
    private long d;
    private String e;
    private ca f;
    private com.baidu.tieba.im.message.ao g;
    private com.baidu.tieba.im.message.ao h;
    private PhotoUrlData i;
    private boolean j;

    public void a(PhotoUrlData photoUrlData) {
        this.i = photoUrlData;
    }

    public int a() {
        return this.c;
    }

    public long b() {
        return this.d;
    }

    public String c() {
        return this.e;
    }

    public long d() {
        return this.a;
    }

    public int e() {
        return this.b;
    }

    @Override // com.baidu.adp.a.d
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.a.d
    public boolean cancelLoadData() {
        return false;
    }

    public void a(Intent intent) {
        this.a = intent.getLongExtra("group_id", 0L);
        this.b = intent.getIntExtra("activity_from", 0);
        this.c = intent.getIntExtra("join_type", 0);
        this.d = intent.getLongExtra("inviter_user_id", 0L);
        this.e = intent.getStringExtra("default_invite_msg");
    }

    public void a(Bundle bundle) {
        this.a = bundle.getLong("group_id", 0L);
        this.b = bundle.getInt("activity_from", 0);
        this.c = bundle.getInt("join_type");
        this.d = bundle.getLong("inviter_user_id");
        this.e = bundle.getString("default_invite_msg");
    }

    private com.baidu.tieba.im.message.ao c(long j, int i) {
        com.baidu.tieba.im.message.ao aoVar = new com.baidu.tieba.im.message.ao();
        aoVar.a(j);
        LocalViewSize.ImageSize c = LocalViewSize.a().c();
        LocalViewSize.ImageSize d = LocalViewSize.a().d();
        aoVar.c(d.height);
        aoVar.d(d.width);
        aoVar.a(c.height);
        aoVar.b(c.width);
        if (i == 4) {
            aoVar.a("forumgroup_recommend");
        } else if (i == 5) {
            aoVar.a("forumgroup_hot");
        } else if (i == 6) {
            aoVar.a("forumgroup_official");
        } else if (i == 3) {
            aoVar.a("grouptalk");
        } else if (i == 1) {
            aoVar.a("usergroup");
        } else if (i == 7) {
            aoVar.a("invitetalk");
        } else {
            aoVar.a("");
        }
        return aoVar;
    }

    public void a(long j, int i) {
        this.g = c(j, i);
        com.baidu.tieba.im.messageCenter.e.a().a(this.g);
    }

    public void f() {
        if (this.g != null) {
            com.baidu.tieba.im.messageCenter.e.a().b(this.g);
        }
        if (this.h != null) {
            com.baidu.tieba.im.messageCenter.e.a().b(this.h);
        }
    }

    public void b(Bundle bundle) {
        bundle.putLong("group_id", this.a);
        bundle.putInt("activity_from", this.b);
        bundle.putInt("join_type", this.c);
        bundle.putLong("inviter_user_id", this.d);
        bundle.putString("default_invite_msg", this.e);
    }

    public void a(ca caVar) {
        this.i = null;
        this.f = caVar;
    }

    public ca g() {
        return this.f;
    }

    public ArrayList<String> h() {
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

    public String b(PhotoUrlData photoUrlData) {
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
            if (d.get(i) == null) {
                str = str2;
            } else if (d.get(i).getPicId().equals(picId)) {
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

    public String c(PhotoUrlData photoUrlData) {
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

    public void i() {
        if (this.f != null && this.f.d() != null && this.f.d().size() > 0 && this.i != null) {
            for (PhotoUrlData photoUrlData : this.f.d()) {
                if (photoUrlData != null && photoUrlData.getPicId().equals(this.i.getPicId())) {
                    this.f.d().remove(photoUrlData);
                    return;
                }
            }
        }
    }

    public void j() {
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

    public void k() {
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

    public void b(long j, int i) {
        this.h = c(j, i);
        this.h.e(SapiErrorCode.NOT_INIT);
        com.baidu.tieba.im.messageCenter.e.a().a(this.h);
    }

    public boolean a(String str) {
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

    public com.baidu.tieba.im.message.s l() {
        return this.h;
    }

    public com.baidu.tieba.im.message.s m() {
        return this.g;
    }

    public boolean n() {
        return this.j;
    }

    public void a(boolean z) {
        this.j = z;
    }

    public void b(String str) {
        com.baidu.tieba.im.message.d dVar = new com.baidu.tieba.im.message.d();
        dVar.a(str);
        com.baidu.tieba.im.messageCenter.e.a().a(dVar);
    }
}
