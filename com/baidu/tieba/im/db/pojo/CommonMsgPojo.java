package com.baidu.tieba.im.db.pojo;

import android.text.TextUtils;
import com.baidu.adp.lib.util.h;
import com.baidu.gson.Gson;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tieba.im.chat.x;
import com.baidu.tieba.im.data.MsgLocalData;
import com.baidu.tieba.im.f.q;
import com.baidu.tieba.im.message.a.a;
import com.baidu.tieba.im.message.a.b;
import com.baidu.tieba.im.message.a.c;
import com.baidu.tieba.im.message.a.f;
import java.io.Serializable;
/* loaded from: classes.dex */
public class CommonMsgPojo implements Serializable {
    public static final int DELETEED = 1;
    public static final int READED = 0;
    public static final int UNREAD = 1;
    public static final int UN_DELETE = 0;
    private static final long serialVersionUID = -7522120557807426716L;
    private String content;
    private long create_time;
    private String ext;
    private String gid;
    Gson gson;
    private boolean isPrivate;
    boolean isSelf;
    private int is_delete;
    private long mid;
    private int msg_status;
    private int msg_type;
    private int read_flag;
    private long rid;
    private String toUid;
    private String to_user_info;
    private UserData to_user_info_data;
    private String uid;
    private String user_info;
    private UserData user_info_data;

    public boolean isPrivate() {
        return this.isPrivate;
    }

    public void setPrivate(boolean z) {
        this.isPrivate = z;
    }

    public CommonMsgPojo() {
        this.gid = "";
        this.uid = "";
        this.toUid = "";
        this.user_info = "";
        this.to_user_info = "";
        this.user_info_data = null;
        this.to_user_info_data = null;
        this.content = "";
        this.ext = "";
        this.isPrivate = false;
        this.gson = new Gson();
    }

    public CommonMsgPojo(a aVar) {
        this.gid = "";
        this.uid = "";
        this.toUid = "";
        this.user_info = "";
        this.to_user_info = "";
        this.user_info_data = null;
        this.to_user_info_data = null;
        this.content = "";
        this.ext = "";
        this.isPrivate = false;
        this.gson = new Gson();
        if (aVar != null) {
            if (aVar instanceof b) {
                this.gid = ((b) aVar).i();
            } else {
                this.gid = String.valueOf(x.a);
            }
            this.mid = aVar.w();
            if (aVar.r() != null) {
                this.uid = aVar.r().getUserId();
            }
            this.toUid = String.valueOf(aVar.l());
            this.user_info_data = aVar.r();
            this.to_user_info_data = aVar.s();
            this.to_user_info = this.gson.toJson(aVar.s());
            this.create_time = aVar.A();
            this.msg_type = aVar.t();
            if (aVar.y() != null) {
                this.msg_status = aVar.y().getStatus().shortValue();
            }
            this.content = aVar.v();
            this.is_delete = 0;
            this.rid = aVar.u();
            checkRidAndSelf();
        }
    }

    public int getIs_delete() {
        return this.is_delete;
    }

    public void setIs_delete(int i) {
        this.is_delete = i;
    }

    public int getRead_flag() {
        return this.read_flag;
    }

    public void setRead_flag(int i) {
        this.read_flag = i;
    }

    public boolean isSelf() {
        return this.isSelf;
    }

    public void setSelf(boolean z) {
        this.isSelf = z;
    }

    public long getRid() {
        return this.rid;
    }

    public void setRid(long j) {
        this.rid = j;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0030  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0118  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public a toChatMessage() {
        Exception e;
        long j;
        long j2;
        long j3;
        a fVar;
        UserData r;
        UserData s;
        OldUserData oldUserData;
        long j4;
        OldUserData oldUserData2;
        long j5 = 0;
        try {
            j = (this.uid == null || this.uid.length() <= 0) ? 0L : Long.parseLong(this.uid);
            try {
            } catch (Exception e2) {
                e = e2;
                e.printStackTrace();
                j2 = j;
                j3 = 0;
                if (TextUtils.isEmpty(this.toUid)) {
                }
                fVar.f(this.mid);
                fVar.g(j2);
                fVar.c(j3);
                fVar.e(this.rid);
                if (this.user_info_data == null) {
                }
                fVar.a(this.user_info_data);
                if (this.to_user_info_data == null) {
                }
                fVar.b(this.to_user_info_data);
                fVar.b((UserData) this.gson.fromJson(this.to_user_info, (Class<Object>) UserData.class));
                fVar.h(this.create_time);
                fVar.e((int) ((short) this.msg_type));
                MsgLocalData msgLocalData = new MsgLocalData();
                msgLocalData.setStatus(Short.valueOf((short) this.msg_status));
                fVar.a(msgLocalData);
                fVar.d(this.content);
                r = fVar.r();
                if (r != null) {
                }
                s = fVar.s();
                if (s != null) {
                }
                q.f(fVar);
                return fVar;
            }
        } catch (Exception e3) {
            e = e3;
            j = 0;
        }
        if (this.toUid != null && this.toUid.length() > 0) {
            j3 = Long.parseLong(this.toUid);
            j2 = j;
            if (TextUtils.isEmpty(this.toUid)) {
                fVar = new c();
                ((c) fVar).a(this.gid);
            } else {
                fVar = new f();
            }
            fVar.f(this.mid);
            fVar.g(j2);
            fVar.c(j3);
            fVar.e(this.rid);
            if (this.user_info_data == null) {
                this.user_info_data = (UserData) this.gson.fromJson(this.user_info, (Class<Object>) UserData.class);
            }
            fVar.a(this.user_info_data);
            if (this.to_user_info_data == null) {
                this.to_user_info_data = (UserData) this.gson.fromJson(this.to_user_info, (Class<Object>) UserData.class);
            }
            fVar.b(this.to_user_info_data);
            fVar.b((UserData) this.gson.fromJson(this.to_user_info, (Class<Object>) UserData.class));
            fVar.h(this.create_time);
            fVar.e((int) ((short) this.msg_type));
            MsgLocalData msgLocalData2 = new MsgLocalData();
            msgLocalData2.setStatus(Short.valueOf((short) this.msg_status));
            fVar.a(msgLocalData2);
            fVar.d(this.content);
            r = fVar.r();
            if (r != null) {
                if (h.b(r.getUserId()) && (oldUserData2 = (OldUserData) new Gson().fromJson(this.user_info, (Class<Object>) OldUserData.class)) != null) {
                    oldUserData2.setToUserData(r);
                }
                try {
                    j4 = Long.parseLong(r.getUserId());
                } catch (Exception e4) {
                    com.baidu.adp.lib.util.f.b("error" + e4.getMessage());
                    j4 = 0;
                }
                fVar.g(j4);
            }
            s = fVar.s();
            if (s != null) {
                if (h.b(s.getUserId()) && (oldUserData = (OldUserData) new Gson().fromJson(this.to_user_info, (Class<Object>) OldUserData.class)) != null) {
                    oldUserData.setToUserData(s);
                }
                try {
                    j5 = Long.parseLong(s.getUserId());
                } catch (Exception e5) {
                    com.baidu.adp.lib.util.f.b("error" + e5.getMessage());
                }
                fVar.c(j5);
            }
            q.f(fVar);
            return fVar;
        }
        j2 = j;
        j3 = 0;
        if (TextUtils.isEmpty(this.toUid)) {
        }
        fVar.f(this.mid);
        fVar.g(j2);
        fVar.c(j3);
        fVar.e(this.rid);
        if (this.user_info_data == null) {
        }
        fVar.a(this.user_info_data);
        if (this.to_user_info_data == null) {
        }
        fVar.b(this.to_user_info_data);
        fVar.b((UserData) this.gson.fromJson(this.to_user_info, (Class<Object>) UserData.class));
        fVar.h(this.create_time);
        fVar.e((int) ((short) this.msg_type));
        MsgLocalData msgLocalData22 = new MsgLocalData();
        msgLocalData22.setStatus(Short.valueOf((short) this.msg_status));
        fVar.a(msgLocalData22);
        fVar.d(this.content);
        r = fVar.r();
        if (r != null) {
        }
        s = fVar.s();
        if (s != null) {
        }
        q.f(fVar);
        return fVar;
    }

    public String getGid() {
        return this.gid;
    }

    public void setGid(String str) {
        this.gid = str;
    }

    public long getMid() {
        return this.mid;
    }

    public void setMid(long j) {
        this.mid = j;
    }

    public String getUid() {
        return this.uid;
    }

    public void setUid(String str) {
        this.uid = str;
    }

    public void setToUid(String str) {
        this.toUid = str;
    }

    public String getToUid() {
        return this.toUid;
    }

    public String getUser_info() {
        if (this.user_info == null || (this.user_info.length() <= 0 && this.user_info_data != null)) {
            this.user_info = this.gson.toJson(this.user_info_data);
        }
        return this.user_info;
    }

    public void setUser_info(String str) {
        this.user_info = str;
        this.user_info_data = null;
    }

    public String getToUser_info() {
        if (this.to_user_info == null || (this.to_user_info.length() <= 0 && this.to_user_info_data != null)) {
            this.to_user_info = this.gson.toJson(this.to_user_info_data);
        }
        return this.to_user_info;
    }

    public void setToUser_info(String str) {
        this.to_user_info = str;
        this.to_user_info_data = null;
    }

    public long getCreate_time() {
        return this.create_time;
    }

    public void setCreate_time(long j) {
        this.create_time = j;
    }

    public int getMsg_type() {
        return this.msg_type;
    }

    public void setMsg_type(int i) {
        this.msg_type = i;
    }

    public int getMsg_status() {
        return this.msg_status;
    }

    public void setMsg_status(int i) {
        this.msg_status = i;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public String getExt() {
        return this.ext;
    }

    public void setExt(String str) {
        this.ext = str;
    }

    public void checkRidAndSelf() {
        if (!TextUtils.isEmpty(TbadkApplication.E())) {
            if (TbadkApplication.E().equals(this.uid)) {
                this.isSelf = true;
            }
        } else {
            this.isSelf = false;
        }
        if (!this.isSelf) {
            this.rid = this.mid;
        } else if (this.rid == 0) {
            this.rid = this.mid;
        }
    }
}
