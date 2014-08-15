package com.baidu.tieba.im.model;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.adp.framework.message.Message;
import com.baidu.tbadk.core.util.LocalViewSize;
import com.baidu.tbadk.coreExtra.data.PhotoUrlData;
import com.baidu.tieba.im.data.MemberData;
import com.baidu.tieba.im.message.ClearGroupInfoCacheMessage;
import com.baidu.tieba.im.message.RequestGroupInfoLocalMessage;
import com.baidu.tieba.im.message.RequestGroupInfoMessage;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class k extends com.baidu.adp.base.e {
    private long a;
    private int b;
    private int c;
    private long d;
    private String e;
    private com.baidu.tieba.im.message.j f;
    private RequestGroupInfoMessage g;
    private RequestGroupInfoLocalMessage h;
    private PhotoUrlData i;
    private boolean j;

    public k(Context context) {
        super(context);
    }

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

    @Override // com.baidu.adp.base.e
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        return false;
    }

    public void a(Intent intent) {
        this.a = intent.getLongExtra(com.baidu.tbadk.core.frameworkData.a.GROUP_ID, 0L);
        this.b = intent.getIntExtra("activity_from", 0);
        this.c = intent.getIntExtra("join_type", 0);
        this.d = intent.getLongExtra("inviter_user_id", 0L);
        this.e = intent.getStringExtra("default_invite_msg");
    }

    public void a(Bundle bundle) {
        this.a = bundle.getLong(com.baidu.tbadk.core.frameworkData.a.GROUP_ID, 0L);
        this.b = bundle.getInt("activity_from", 0);
        this.c = bundle.getInt("join_type");
        this.d = bundle.getLong("inviter_user_id");
        this.e = bundle.getString("default_invite_msg");
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
        } else if (i == 7) {
            requestGroupInfoMessage.setFrom("invitetalk");
        } else {
            requestGroupInfoMessage.setFrom("");
        }
        return requestGroupInfoMessage;
    }

    private RequestGroupInfoLocalMessage d(long j, int i) {
        RequestGroupInfoLocalMessage requestGroupInfoLocalMessage = new RequestGroupInfoLocalMessage();
        requestGroupInfoLocalMessage.setGroupId(j);
        LocalViewSize.ImageSize c = LocalViewSize.a().c();
        LocalViewSize.ImageSize d = LocalViewSize.a().d();
        requestGroupInfoLocalMessage.setBigHeight(d.height);
        requestGroupInfoLocalMessage.setBigWidth(d.width);
        requestGroupInfoLocalMessage.setSmallHeight(c.height);
        requestGroupInfoLocalMessage.setSmallWidth(c.width);
        if (i == 4) {
            requestGroupInfoLocalMessage.setFrom("forumgroup_recommend");
        } else if (i == 5) {
            requestGroupInfoLocalMessage.setFrom("forumgroup_hot");
        } else if (i == 6) {
            requestGroupInfoLocalMessage.setFrom("forumgroup_official");
        } else if (i == 3) {
            requestGroupInfoLocalMessage.setFrom("grouptalk");
        } else if (i == 1) {
            requestGroupInfoLocalMessage.setFrom("usergroup");
        } else if (i == 7) {
            requestGroupInfoLocalMessage.setFrom("invitetalk");
        } else {
            requestGroupInfoLocalMessage.setFrom("");
        }
        return requestGroupInfoLocalMessage;
    }

    public void a(long j, int i) {
        this.g = c(j, i);
        super.sendMessage(this.g);
    }

    @Override // com.baidu.adp.base.e
    public void cancelMessage() {
        super.cancelMessage();
    }

    public void b(Bundle bundle) {
        bundle.putLong(com.baidu.tbadk.core.frameworkData.a.GROUP_ID, this.a);
        bundle.putInt("activity_from", this.b);
        bundle.putInt("join_type", this.c);
        bundle.putLong("inviter_user_id", this.d);
        bundle.putString("default_invite_msg", this.e);
    }

    public void a(com.baidu.tieba.im.message.j jVar) {
        this.i = null;
        this.f = jVar;
    }

    public com.baidu.tieba.im.message.j f() {
        return this.f;
    }

    public ArrayList<String> g() {
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
        StringBuilder sb = new StringBuilder();
        if (photoUrlData == null) {
            return null;
        }
        String picId = photoUrlData.getPicId();
        if (TextUtils.isEmpty(picId)) {
            return null;
        }
        this.i = photoUrlData;
        if (this.f != null && this.f.d() != null && this.f.d().size() > 0) {
            int size = this.f.d().size();
            List<PhotoUrlData> d = this.f.d();
            for (int i = 1; i < size; i++) {
                if (d.get(i) != null && !picId.equals(d.get(i).getPicId())) {
                    sb.append(d.get(i).getPicId());
                    if (i != size - 1) {
                        sb.append(",");
                    }
                }
            }
        }
        return sb.toString();
    }

    public String c(PhotoUrlData photoUrlData) {
        StringBuilder sb = new StringBuilder();
        if (photoUrlData == null) {
            return null;
        }
        String picId = photoUrlData.getPicId();
        if (TextUtils.isEmpty(picId)) {
            return null;
        }
        this.i = photoUrlData;
        if (this.f != null && this.f.d() != null && this.f.d().size() > 0) {
            List<PhotoUrlData> d = this.f.d();
            int size = d.size();
            for (int i = 1; i < size; i++) {
                if (d.get(i) != null) {
                    sb.append(d.get(i).getPicId());
                    sb.append(",");
                }
            }
            sb.append(picId);
        } else {
            sb.append(picId);
        }
        return sb.toString();
    }

    public void h() {
        if (this.f != null && this.f.d() != null && this.f.d().size() > 0 && this.i != null) {
            for (PhotoUrlData photoUrlData : this.f.d()) {
                if (photoUrlData != null && photoUrlData.getPicId().equals(this.i.getPicId())) {
                    this.f.d().remove(photoUrlData);
                    return;
                }
            }
        }
    }

    public void i() {
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

    public void j() {
        if (this.f != null && this.f.d() != null && this.f.d().size() > 0 && this.i != null) {
            int i = 0;
            while (true) {
                if (i >= this.f.d().size()) {
                    i = -1;
                    break;
                } else if (this.f.d().get(i) == null || this.f.d().get(i).getPicId() == null || !this.f.d().get(i).getPicId().equals(this.i.getPicId())) {
                    i++;
                } else {
                    this.f.d().remove(i);
                    break;
                }
            }
            if (this.f.d().size() > 0 && this.f.d().get(0) != null && TextUtils.isEmpty(this.f.d().get(0).getPicId())) {
                this.f.d().remove(0);
            }
            this.f.d().add(i, this.f.d().get(0));
            this.f.d().remove(0);
            PhotoUrlData photoUrlData = new PhotoUrlData();
            photoUrlData.setBigurl(this.i.getBigurl());
            photoUrlData.setPicId(this.i.getPicId());
            photoUrlData.setSmallurl(this.i.getSmallurl());
            this.f.d().add(0, photoUrlData);
        }
    }

    public void b(long j, int i) {
        if (this.h == null) {
            this.h = d(j, i);
        }
        super.sendMessage(this.h);
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

    public Message<?> k() {
        return this.g;
    }

    public boolean l() {
        return this.j;
    }

    public void a(boolean z) {
        this.j = z;
    }

    public void b(String str) {
        ClearGroupInfoCacheMessage clearGroupInfoCacheMessage = new ClearGroupInfoCacheMessage();
        clearGroupInfoCacheMessage.setData(str);
        super.sendMessage(clearGroupInfoCacheMessage);
    }
}
