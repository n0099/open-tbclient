package com.baidu.tieba.im.db.pojo;

import android.text.TextUtils;
import com.baidu.adp.lib.util.f;
import com.baidu.gson.Gson;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.UserData;
import com.baidu.tieba.im.chat.q;
import com.baidu.tieba.im.data.MsgLocalData;
import com.baidu.tieba.im.message.b;
import com.baidu.tieba.im.message.g;
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

    /* JADX WARN: Removed duplicated region for block: B:15:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00b6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public g toChatMessage() {
        Exception e;
        long j;
        long j2;
        UserData g;
        UserData h;
        long j3;
        long j4 = 0;
        g gVar = new g();
        try {
            j = (this.uid == null || this.uid.length() <= 0) ? 0L : Long.parseLong(this.uid);
            try {
            } catch (Exception e2) {
                e = e2;
                e.printStackTrace();
                j2 = 0;
                gVar.b(this.gid);
                gVar.d(this.mid);
                gVar.e(j);
                gVar.b(j2);
                gVar.c(this.rid);
                if (this.user_info_data == null) {
                }
                gVar.a(this.user_info_data);
                if (this.to_user_info_data == null) {
                }
                gVar.b(this.to_user_info_data);
                gVar.b((UserData) this.gson.fromJson(this.to_user_info, (Class<Object>) UserData.class));
                gVar.f(this.create_time);
                gVar.b((int) ((short) this.msg_type));
                MsgLocalData msgLocalData = new MsgLocalData();
                msgLocalData.setStatus(Short.valueOf((short) this.msg_status));
                gVar.a(msgLocalData);
                gVar.a(this.content);
                g = gVar.g();
                if (g != null) {
                }
                h = gVar.h();
                if (h != null) {
                }
                l.g(gVar);
                return gVar;
            }
        } catch (Exception e3) {
            e = e3;
            j = 0;
        }
        if (this.toUid != null && this.toUid.length() > 0) {
            j2 = Long.parseLong(this.toUid);
            gVar.b(this.gid);
            gVar.d(this.mid);
            gVar.e(j);
            gVar.b(j2);
            gVar.c(this.rid);
            if (this.user_info_data == null) {
                this.user_info_data = (UserData) this.gson.fromJson(this.user_info, (Class<Object>) UserData.class);
            }
            gVar.a(this.user_info_data);
            if (this.to_user_info_data == null) {
                this.to_user_info_data = (UserData) this.gson.fromJson(this.to_user_info, (Class<Object>) UserData.class);
            }
            gVar.b(this.to_user_info_data);
            gVar.b((UserData) this.gson.fromJson(this.to_user_info, (Class<Object>) UserData.class));
            gVar.f(this.create_time);
            gVar.b((int) ((short) this.msg_type));
            MsgLocalData msgLocalData2 = new MsgLocalData();
            msgLocalData2.setStatus(Short.valueOf((short) this.msg_status));
            gVar.a(msgLocalData2);
            gVar.a(this.content);
            g = gVar.g();
            if (g != null) {
                try {
                    j3 = Long.parseLong(g.getUserId());
                } catch (Exception e4) {
                    f.b("error" + e4.getMessage());
                    j3 = 0;
                }
                gVar.e(j3);
            }
            h = gVar.h();
            if (h != null) {
                try {
                    j4 = Long.parseLong(h.getUserId());
                } catch (Exception e5) {
                    f.b("error" + e5.getMessage());
                }
                gVar.b(j4);
            }
            l.g(gVar);
            return gVar;
        }
        j2 = 0;
        gVar.b(this.gid);
        gVar.d(this.mid);
        gVar.e(j);
        gVar.b(j2);
        gVar.c(this.rid);
        if (this.user_info_data == null) {
        }
        gVar.a(this.user_info_data);
        if (this.to_user_info_data == null) {
        }
        gVar.b(this.to_user_info_data);
        gVar.b((UserData) this.gson.fromJson(this.to_user_info, (Class<Object>) UserData.class));
        gVar.f(this.create_time);
        gVar.b((int) ((short) this.msg_type));
        MsgLocalData msgLocalData22 = new MsgLocalData();
        msgLocalData22.setStatus(Short.valueOf((short) this.msg_status));
        gVar.a(msgLocalData22);
        gVar.a(this.content);
        g = gVar.g();
        if (g != null) {
        }
        h = gVar.h();
        if (h != null) {
        }
        l.g(gVar);
        return gVar;
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
        if (!TextUtils.isEmpty(TiebaApplication.A())) {
            if (TiebaApplication.A().equals(this.uid)) {
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
