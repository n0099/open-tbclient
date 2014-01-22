package com.baidu.tieba.im.model;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.sapi2.shell.SapiErrorCode;
import com.baidu.tieba.im.chat.LocalViewSize;
import com.baidu.tieba.im.data.MemberData;
import com.baidu.tieba.im.data.PhotoUrlData;
import com.baidu.tieba.im.message.br;
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
    private br f;
    private com.baidu.tieba.im.message.ai g;
    private com.baidu.tieba.im.message.ai h;
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

    private com.baidu.tieba.im.message.ai c(long j, int i) {
        com.baidu.tieba.im.message.ai aiVar = new com.baidu.tieba.im.message.ai();
        aiVar.a(j);
        LocalViewSize.ImageSize c = LocalViewSize.a().c();
        LocalViewSize.ImageSize d = LocalViewSize.a().d();
        aiVar.c(d.height);
        aiVar.d(d.width);
        aiVar.a(c.height);
        aiVar.b(c.width);
        if (i == 4) {
            aiVar.a("forumgroup_recommend");
        } else if (i == 5) {
            aiVar.a("forumgroup_hot");
        } else if (i == 6) {
            aiVar.a("forumgroup_official");
        } else if (i == 3) {
            aiVar.a("grouptalk");
        } else if (i == 1) {
            aiVar.a("usergroup");
        } else if (i == 7) {
            aiVar.a("invitetalk");
        } else {
            aiVar.a("");
        }
        return aiVar;
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

    public void a(br brVar) {
        this.i = null;
        this.f = brVar;
    }

    public br g() {
        return this.f;
    }

    public ArrayList<String> h() {
        if (this.f == null || this.f.c() == null || this.f.c().size() <= 0) {
            return null;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        for (PhotoUrlData photoUrlData : this.f.c()) {
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
        if (this.f == null || this.f.c() == null || this.f.c().size() <= 0) {
            return "";
        }
        int size = this.f.c().size();
        List<PhotoUrlData> c = this.f.c();
        int i = 1;
        while (i < size) {
            if (c.get(i) == null) {
                str = str2;
            } else if (c.get(i).getPicId().equals(picId)) {
                str = str2;
            } else {
                str = str2 + c.get(i).getPicId();
                if (i != size - 1) {
                    str = str + ",";
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
        if (this.f == null || this.f.c() == null || this.f.c().size() <= 0) {
            return picId;
        }
        List<PhotoUrlData> c = this.f.c();
        int size = c.size();
        String str = "";
        for (int i = 1; i < size; i++) {
            if (c.get(i) != null) {
                str = str + c.get(i).getPicId() + ",";
            }
        }
        return str + picId;
    }

    public void i() {
        if (this.f != null && this.f.c() != null && this.f.c().size() > 0 && this.i != null) {
            for (PhotoUrlData photoUrlData : this.f.c()) {
                if (photoUrlData != null && photoUrlData.getPicId().equals(this.i.getPicId())) {
                    this.f.c().remove(photoUrlData);
                    return;
                }
            }
        }
    }

    public void j() {
        if (this.f != null && this.i != null) {
            if (this.f.c() == null) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(this.i);
                this.f.b(arrayList);
                return;
            }
            if (this.f.c().size() > 0 && this.f.c().get(0) != null && TextUtils.isEmpty(this.f.c().get(0).getPicId())) {
                this.f.c().remove(0);
            }
            PhotoUrlData photoUrlData = new PhotoUrlData();
            photoUrlData.setBigurl(this.i.getBigurl());
            photoUrlData.setPicId(this.i.getPicId());
            photoUrlData.setSmallurl(this.i.getSmallurl());
            this.f.c().add(photoUrlData);
        }
    }

    public void k() {
        if (this.f != null && this.f.c() != null && this.f.c().size() > 0 && this.i != null) {
            Iterator<PhotoUrlData> it = this.f.c().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                PhotoUrlData next = it.next();
                if (next != null && next.getPicId().equals(this.i.getPicId())) {
                    this.f.c().remove(next);
                    break;
                }
            }
            if (this.f.c().size() > 0 && this.f.c().get(0) != null && TextUtils.isEmpty(this.f.c().get(0).getPicId())) {
                this.f.c().remove(0);
            }
            PhotoUrlData photoUrlData = new PhotoUrlData();
            photoUrlData.setBigurl(this.i.getBigurl());
            photoUrlData.setPicId(this.i.getPicId());
            photoUrlData.setSmallurl(this.i.getSmallurl());
            this.f.c().add(0, photoUrlData);
        }
    }

    public void b(long j, int i) {
        this.h = c(j, i);
        this.h.e(SapiErrorCode.NOT_INIT);
        com.baidu.tieba.im.messageCenter.e.a().a(this.h);
    }

    public boolean a(String str) {
        if (str != null && this.f != null && this.f.b() != null && this.f.b().size() > 0) {
            for (MemberData memberData : this.f.b()) {
                if (str.equals(String.valueOf(memberData.getUserId()))) {
                    this.f.b().remove(memberData);
                    return true;
                }
            }
        }
        return false;
    }

    public com.baidu.tieba.im.message.q l() {
        return this.h;
    }

    public com.baidu.tieba.im.message.q m() {
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
