package com.baidu.tieba.im.db.pojo;

import android.text.TextUtils;
import com.baidu.adp.lib.h.e;
import com.baidu.gson.Gson;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.UserData;
import com.baidu.tieba.im.chat.a;
import com.baidu.tieba.im.data.MsgLocalData;
import com.baidu.tieba.im.message.b;
import com.baidu.tieba.im.message.d;
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
            if (bVar instanceof d) {
                this.gid = ((d) bVar).s();
            } else {
                this.gid = String.valueOf(a.a);
            }
            this.mid = bVar.k();
            this.uid = bVar.f().getId();
            this.toUid = String.valueOf(bVar.b());
            this.user_info_data = bVar.f();
            this.to_user_info_data = bVar.g();
            this.create_time = bVar.o();
            this.msg_type = bVar.h();
            this.msg_status = bVar.m().getStatus().shortValue();
            this.content = bVar.j();
            this.is_delete = 0;
            this.rid = bVar.i();
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

    /* JADX WARN: Removed duplicated region for block: B:16:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00aa  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public d toChatMessage() {
        Exception exc;
        long j;
        long j2;
        UserData f;
        UserData g;
        long j3;
        long j4 = 0;
        d dVar = new d();
        try {
            long parseLong = (this.uid == null || this.uid.length() <= 0) ? 0L : Long.parseLong(this.uid);
            try {
                long j5 = parseLong;
                j2 = (this.toUid == null || this.toUid.length() <= 0) ? 0L : Long.parseLong(this.toUid);
                j = j5;
            } catch (Exception e) {
                j = parseLong;
                exc = e;
                exc.printStackTrace();
                j2 = 0;
                dVar.b(this.gid);
                dVar.c(this.mid);
                dVar.d(j);
                dVar.a(j2);
                dVar.b(this.rid);
                if (this.user_info_data == null) {
                }
                dVar.a(this.user_info_data);
                if (this.to_user_info_data == null) {
                }
                dVar.b(this.to_user_info_data);
                dVar.e(this.create_time);
                dVar.b((int) ((short) this.msg_type));
                MsgLocalData msgLocalData = new MsgLocalData();
                msgLocalData.setStatus(Short.valueOf((short) this.msg_status));
                dVar.a(msgLocalData);
                dVar.a(this.content);
                f = dVar.f();
                if (f != null) {
                }
                g = dVar.g();
                if (g != null) {
                }
                com.baidu.tieba.im.d.d.e(dVar);
                return dVar;
            }
        } catch (Exception e2) {
            exc = e2;
            j = 0;
        }
        dVar.b(this.gid);
        dVar.c(this.mid);
        dVar.d(j);
        dVar.a(j2);
        dVar.b(this.rid);
        if (this.user_info_data == null) {
            this.user_info_data = (UserData) this.gson.fromJson(this.user_info, (Class<Object>) UserData.class);
        }
        dVar.a(this.user_info_data);
        if (this.to_user_info_data == null) {
            this.to_user_info_data = (UserData) this.gson.fromJson(this.to_user_info, (Class<Object>) UserData.class);
        }
        dVar.b(this.to_user_info_data);
        dVar.e(this.create_time);
        dVar.b((int) ((short) this.msg_type));
        MsgLocalData msgLocalData2 = new MsgLocalData();
        msgLocalData2.setStatus(Short.valueOf((short) this.msg_status));
        dVar.a(msgLocalData2);
        dVar.a(this.content);
        f = dVar.f();
        if (f != null) {
            try {
                j3 = Long.parseLong(f.getId());
            } catch (Exception e3) {
                e.a("error" + e3.getMessage());
                j3 = 0;
            }
            dVar.d(j3);
        }
        g = dVar.g();
        if (g != null) {
            try {
                j4 = Long.parseLong(g.getId());
            } catch (Exception e4) {
                e.a("error" + e4.getMessage());
            }
            dVar.a(j4);
        }
        com.baidu.tieba.im.d.d.e(dVar);
        return dVar;
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
        if (this.user_info == null || (this.user_info.length() < 1 && this.user_info_data != null)) {
            this.user_info = this.gson.toJson(this.user_info_data);
        }
        return this.user_info;
    }

    public void setUser_info(String str) {
        this.user_info = str;
        this.user_info_data = null;
    }

    public String getToUser_info() {
        if (this.to_user_info == null || (this.to_user_info.length() < 1 && this.to_user_info_data != null)) {
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
        if (!TextUtils.isEmpty(TiebaApplication.B())) {
            if (TiebaApplication.B().equals(this.uid)) {
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
