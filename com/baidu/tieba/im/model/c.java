package com.baidu.tieba.im.model;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.tieba.im.chat.LocalViewSize;
import com.baidu.tieba.im.data.MemberData;
import com.baidu.tieba.im.data.PhotoUrlData;
import com.baidu.tieba.im.message.Message;
import com.baidu.tieba.im.message.RequestGroupInfoMessage;
import com.baidu.tieba.im.message.ResponseGroupInfoMessage;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class c extends com.baidu.adp.a.d {

    /* renamed from: a  reason: collision with root package name */
    private long f1746a;
    private int b;
    private ResponseGroupInfoMessage c;
    private RequestGroupInfoMessage d;
    private RequestGroupInfoMessage e;
    private PhotoUrlData f;
    private boolean g;

    public void a(PhotoUrlData photoUrlData) {
        this.f = photoUrlData;
    }

    public long a() {
        return this.f1746a;
    }

    public int b() {
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
        this.f1746a = intent.getLongExtra("group_id", 0L);
        this.b = intent.getIntExtra("activity_from", 0);
    }

    public void a(Bundle bundle) {
        this.f1746a = bundle.getLong("group_id", 0L);
        this.b = bundle.getInt("activity_from", 0);
    }

    private RequestGroupInfoMessage c(long j, int i) {
        RequestGroupInfoMessage requestGroupInfoMessage = new RequestGroupInfoMessage();
        requestGroupInfoMessage.setGroupId(j);
        LocalViewSize.ImageSize c = LocalViewSize.a().c();
        LocalViewSize.ImageSize d = LocalViewSize.a().d();
        requestGroupInfoMessage.setBigHeight(d.height);
        requestGroupInfoMessage.setBigWidth(d.width);
        requestGroupInfoMessage.setSmallHeight(c.height);
        requestGroupInfoMessage.setSmallWidth(c.width);
        if (i == 4) {
            requestGroupInfoMessage.setFrom("forumgroup_recommend");
        } else if (i == 5) {
            requestGroupInfoMessage.setFrom("forumgroup_hot");
        } else if (i == 6) {
            requestGroupInfoMessage.setFrom("forumgroup_official");
        } else if (i == 3) {
            requestGroupInfoMessage.setFrom("grouptalk");
        } else if (i == 1) {
            requestGroupInfoMessage.setFrom("usergroup");
        } else {
            requestGroupInfoMessage.setFrom("");
        }
        return requestGroupInfoMessage;
    }

    public void a(long j, int i) {
        this.d = c(j, i);
        com.baidu.adp.lib.h.d.a(this.d.toMap().toString());
        com.baidu.tieba.im.messageCenter.f.a().a(this.d);
    }

    public void c() {
        if (this.d != null) {
            com.baidu.tieba.im.messageCenter.f.a().b(this.d);
        }
        if (this.e != null) {
            com.baidu.tieba.im.messageCenter.f.a().b(this.d);
        }
    }

    public void b(Bundle bundle) {
        bundle.putLong("group_id", this.f1746a);
        bundle.putInt("activity_from", this.b);
    }

    public void a(ResponseGroupInfoMessage responseGroupInfoMessage) {
        this.f = null;
        this.c = responseGroupInfoMessage;
    }

    public ResponseGroupInfoMessage d() {
        return this.c;
    }

    public ArrayList<String> e() {
        if (this.c == null || this.c.getPhotos() == null || this.c.getPhotos().size() <= 0) {
            return null;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        for (PhotoUrlData photoUrlData : this.c.getPhotos()) {
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
        this.f = photoUrlData;
        if (this.c == null || this.c.getPhotos() == null || this.c.getPhotos().size() <= 0) {
            return "";
        }
        int size = this.c.getPhotos().size();
        List<PhotoUrlData> photos = this.c.getPhotos();
        int i = 1;
        while (i < size) {
            if (photos.get(i) == null) {
                str = str2;
            } else if (photos.get(i).getPicId().equals(picId)) {
                str = str2;
            } else {
                str = str2 + photos.get(i).getPicId();
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
        this.f = photoUrlData;
        if (this.c == null || this.c.getPhotos() == null || this.c.getPhotos().size() <= 0) {
            return picId;
        }
        List<PhotoUrlData> photos = this.c.getPhotos();
        int size = photos.size();
        String str = "";
        for (int i = 1; i < size; i++) {
            if (photos.get(i) != null) {
                str = str + photos.get(i).getPicId() + ",";
            }
        }
        return str + picId;
    }

    public void f() {
        if (this.c != null && this.c.getPhotos() != null && this.c.getPhotos().size() > 0 && this.f != null) {
            for (PhotoUrlData photoUrlData : this.c.getPhotos()) {
                if (photoUrlData != null && photoUrlData.getPicId().equals(this.f.getPicId())) {
                    this.c.getPhotos().remove(photoUrlData);
                    return;
                }
            }
        }
    }

    public void g() {
        if (this.c != null && this.f != null) {
            if (this.c.getPhotos() == null) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(this.f);
                this.c.setPhotos(arrayList);
                return;
            }
            if (this.c.getPhotos().size() > 0 && this.c.getPhotos().get(0) != null && TextUtils.isEmpty(this.c.getPhotos().get(0).getPicId())) {
                this.c.getPhotos().remove(0);
            }
            PhotoUrlData photoUrlData = new PhotoUrlData();
            photoUrlData.setBigurl(this.f.getBigurl());
            photoUrlData.setPicId(this.f.getPicId());
            photoUrlData.setSmallurl(this.f.getSmallurl());
            this.c.getPhotos().add(photoUrlData);
        }
    }

    public void h() {
        if (this.c != null && this.c.getPhotos() != null && this.c.getPhotos().size() > 0 && this.f != null) {
            Iterator<PhotoUrlData> it = this.c.getPhotos().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                PhotoUrlData next = it.next();
                if (next != null && next.getPicId().equals(this.f.getPicId())) {
                    this.c.getPhotos().remove(next);
                    break;
                }
            }
            if (this.c.getPhotos().size() > 0 && this.c.getPhotos().get(0) != null && TextUtils.isEmpty(this.c.getPhotos().get(0).getPicId())) {
                this.c.getPhotos().remove(0);
            }
            PhotoUrlData photoUrlData = new PhotoUrlData();
            photoUrlData.setBigurl(this.f.getBigurl());
            photoUrlData.setPicId(this.f.getPicId());
            photoUrlData.setSmallurl(this.f.getSmallurl());
            this.c.getPhotos().add(0, photoUrlData);
        }
    }

    public void b(long j, int i) {
        this.e = c(j, i);
        this.e.setCmd(-102);
        com.baidu.tieba.im.messageCenter.f.a().a(this.e);
    }

    public boolean a(String str) {
        if (str != null && this.c != null && this.c.getMembers() != null && this.c.getMembers().size() > 0) {
            for (MemberData memberData : this.c.getMembers()) {
                if (str.equals(String.valueOf(memberData.getUserId()))) {
                    this.c.getMembers().remove(memberData);
                    return true;
                }
            }
        }
        return false;
    }

    public Message i() {
        return this.e;
    }

    public Message j() {
        return this.d;
    }

    public boolean k() {
        return this.g;
    }

    public void a(boolean z) {
        this.g = z;
    }
}
