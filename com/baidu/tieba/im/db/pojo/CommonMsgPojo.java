package com.baidu.tieba.im.db.pojo;

import android.text.TextUtils;
import com.baidu.adp.lib.util.e;
import com.baidu.gson.Gson;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.UserData;
import com.baidu.tieba.im.chat.q;
import com.baidu.tieba.im.data.MsgLocalData;
import com.baidu.tieba.im.message.b;
import com.baidu.tieba.im.message.g;
import com.baidu.tieba.im.message.w;
import com.baidu.tieba.im.util.l;
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

    public CommonMsgPojo(b bVar) {
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
        if (bVar != null) {
            if (bVar instanceof g) {
                this.gid = ((g) bVar).u();
            } else {
                this.gid = String.valueOf(q.a);
            }
            this.mid = bVar.l();
            if (bVar.g() != null) {
                this.uid = bVar.g().getUserId();
            }
            this.toUid = String.valueOf(bVar.c());
            this.user_info_data = bVar.g();
            this.to_user_info_data = bVar.h();
            this.to_user_info = this.gson.toJson(bVar.h());
            this.create_time = bVar.p();
            this.msg_type = bVar.i();
            if (bVar.n() != null) {
                this.msg_status = bVar.n().getStatus().shortValue();
            }
            this.content = bVar.k();
            this.is_delete = 0;
            this.rid = bVar.j();
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
    public b toChatMessage() {
        Exception e;
        long j;
        long j2;
        long j3;
        b wVar;
        UserData g;
        UserData h;
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
                wVar.d(this.mid);
                wVar.e(j2);
                wVar.b(j3);
                wVar.c(this.rid);
                if (this.user_info_data == null) {
                }
                wVar.a(this.user_info_data);
                if (this.to_user_info_data == null) {
                }
                wVar.b(this.to_user_info_data);
                wVar.b((UserData) this.gson.fromJson(this.to_user_info, (Class<Object>) UserData.class));
                wVar.f(this.create_time);
                wVar.b((int) ((short) this.msg_type));
                MsgLocalData msgLocalData = new MsgLocalData();
                msgLocalData.setStatus(Short.valueOf((short) this.msg_status));
                wVar.a(msgLocalData);
                wVar.a(this.content);
                g = wVar.g();
                if (g != null) {
                }
                h = wVar.h();
                if (h != null) {
                }
                l.f(wVar);
                return wVar;
            }
        } catch (Exception e3) {
            e = e3;
            j = 0;
        }
        if (this.toUid != null && this.toUid.length() > 0) {
            j3 = Long.parseLong(this.toUid);
            j2 = j;
            if (TextUtils.isEmpty(this.toUid)) {
                wVar = new g();
                ((g) wVar).b(this.gid);
            } else {
                wVar = new w();
            }
            wVar.d(this.mid);
            wVar.e(j2);
            wVar.b(j3);
            wVar.c(this.rid);
            if (this.user_info_data == null) {
                this.user_info_data = (UserData) this.gson.fromJson(this.user_info, (Class<Object>) UserData.class);
            }
            wVar.a(this.user_info_data);
            if (this.to_user_info_data == null) {
                this.to_user_info_data = (UserData) this.gson.fromJson(this.to_user_info, (Class<Object>) UserData.class);
            }
            wVar.b(this.to_user_info_data);
            wVar.b((UserData) this.gson.fromJson(this.to_user_info, (Class<Object>) UserData.class));
            wVar.f(this.create_time);
            wVar.b((int) ((short) this.msg_type));
            MsgLocalData msgLocalData2 = new MsgLocalData();
            msgLocalData2.setStatus(Short.valueOf((short) this.msg_status));
            wVar.a(msgLocalData2);
            wVar.a(this.content);
            g = wVar.g();
            if (g != null) {
                if (com.baidu.adp.lib.util.g.b(g.getUserId()) && (oldUserData2 = (OldUserData) new Gson().fromJson(this.user_info, (Class<Object>) OldUserData.class)) != null) {
                    oldUserData2.setToUserData(g);
                }
                try {
                    j4 = Long.parseLong(g.getUserId());
                } catch (Exception e4) {
                    e.b("error" + e4.getMessage());
                    j4 = 0;
                }
                wVar.e(j4);
            }
            h = wVar.h();
            if (h != null) {
                if (com.baidu.adp.lib.util.g.b(h.getUserId()) && (oldUserData = (OldUserData) new Gson().fromJson(this.to_user_info, (Class<Object>) OldUserData.class)) != null) {
                    oldUserData.setToUserData(h);
                }
                try {
                    j5 = Long.parseLong(h.getUserId());
                } catch (Exception e5) {
                    e.b("error" + e5.getMessage());
                }
                wVar.b(j5);
            }
            l.f(wVar);
            return wVar;
        }
        j2 = j;
        j3 = 0;
        if (TextUtils.isEmpty(this.toUid)) {
        }
        wVar.d(this.mid);
        wVar.e(j2);
        wVar.b(j3);
        wVar.c(this.rid);
        if (this.user_info_data == null) {
        }
        wVar.a(this.user_info_data);
        if (this.to_user_info_data == null) {
        }
        wVar.b(this.to_user_info_data);
        wVar.b((UserData) this.gson.fromJson(this.to_user_info, (Class<Object>) UserData.class));
        wVar.f(this.create_time);
        wVar.b((int) ((short) this.msg_type));
        MsgLocalData msgLocalData22 = new MsgLocalData();
        msgLocalData22.setStatus(Short.valueOf((short) this.msg_status));
        wVar.a(msgLocalData22);
        wVar.a(this.content);
        g = wVar.g();
        if (g != null) {
        }
        h = wVar.h();
        if (h != null) {
        }
        l.f(wVar);
        return wVar;
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
        if (!TextUtils.isEmpty(TiebaApplication.v())) {
            if (TiebaApplication.v().equals(this.uid)) {
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

    public String toString() {
        return "GroupMsgPojo [gid=" + this.gid + ", mid=" + this.mid + ", uid=" + this.uid + ", user_info=" + this.user_info + ", to_user_info=" + this.to_user_info + ", create_time=" + this.create_time + ", msg_type=" + this.msg_type + ", msg_status=" + this.msg_status + ", content=" + this.content + ", ext=" + this.ext + ", read_flag=" + this.read_flag + ", isSelf=" + this.isSelf + ", rid=" + this.rid + ", touid=" + this.toUid + "]";
    }
}
