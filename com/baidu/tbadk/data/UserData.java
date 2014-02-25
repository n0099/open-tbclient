package com.baidu.tbadk.data;

import com.baidu.adp.lib.util.f;
import java.io.Serializable;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class UserData extends MetaData {
    private static final long serialVersionUID = -1871115639893992930L;
    private String BDUSS;
    private String bawu_type;
    private int concern_num;
    private int fans_num;
    private int have_attention;
    private long inTime;
    private String intro;
    private String ip;
    private boolean isManager;
    private int is_bawu;
    private int is_like;
    private long lastReplyTime;
    private String lat;
    private int level_id;
    private int like_bars;
    private String lng;
    private long loginTime;
    private String password;
    private Permission permission;
    private String position;
    private int posts_num;
    private int sex;
    private String tb_age;

    public String getTb_age() {
        return this.tb_age;
    }

    public void setTb_age(String str) {
        this.tb_age = str;
    }

    public UserData() {
        this.password = null;
        this.is_like = 0;
        this.isManager = false;
        this.ip = null;
        this.BDUSS = null;
        this.level_id = 0;
        this.fans_num = 0;
        this.concern_num = 0;
        this.like_bars = 0;
        this.sex = 1;
        this.intro = null;
        this.posts_num = 0;
        setHave_attention(0);
        this.is_bawu = 0;
        this.bawu_type = null;
        this.tb_age = "";
    }

    public UserData(long j, String str, String str2, int i) {
        this.password = null;
        this.is_like = 0;
        this.isManager = false;
        setUserId(String.valueOf(j));
        setUserName(str);
        setPortrait(str2);
        this.sex = i;
    }

    public void setIp(String str) {
        this.ip = str;
    }

    public int getIsLike() {
        return this.is_like;
    }

    public boolean getIsManager() {
        return this.isManager;
    }

    public String getIp() {
        return this.ip;
    }

    public String getPassword() {
        return this.password;
    }

    @Override // com.baidu.tbadk.data.MetaData
    public void parserJson(String str) {
        super.parserJson(str);
        try {
            parserJson(new JSONObject(str));
        } catch (Exception e) {
            f.b("PostData", "parserJson", "error = " + e.getMessage());
        }
    }

    @Override // com.baidu.tbadk.data.MetaData
    public void parserJson(JSONObject jSONObject) {
        try {
            super.parserJson(jSONObject);
            if (jSONObject != null) {
                this.ip = jSONObject.optString("ip");
                this.BDUSS = jSONObject.optString("BDUSS");
                this.level_id = jSONObject.optInt("level_id", 0);
                this.fans_num = jSONObject.optInt("fans_num");
                this.concern_num = jSONObject.optInt("concern_num");
                this.sex = jSONObject.optInt("sex", 1);
                this.like_bars = jSONObject.optInt("my_like_num");
                this.intro = jSONObject.optString("intro");
                this.have_attention = jSONObject.optInt("has_concerned");
                this.password = jSONObject.optString("passwd");
                this.is_like = jSONObject.optInt("is_like", 0);
                this.posts_num = jSONObject.optInt("post_num", 0);
                this.is_bawu = jSONObject.optInt("is_bawu", 0);
                this.bawu_type = jSONObject.optString("bawu_type");
                this.tb_age = jSONObject.optString("tb_age");
                if (jSONObject.optInt("is_manager", 0) == 1) {
                    this.isManager = true;
                } else {
                    this.isManager = false;
                }
            }
        } catch (Exception e) {
            f.b("PostData", "parserJson", "error = " + e.getMessage());
        }
    }

    @Override // com.baidu.tbadk.data.MetaData
    public void logPrint() {
        super.logPrint();
        f.d(getClass().getName(), "logPrint", "ip = " + this.ip);
        f.d(getClass().getName(), "logPrint", "BDUSS = " + this.BDUSS);
        f.d(getClass().getName(), "logPrint", "level_id = " + String.valueOf(this.level_id));
        f.d(getClass().getName(), "logPrint", "fans_num = " + String.valueOf(this.fans_num));
        f.d(getClass().getName(), "logPrint", "concern_num = " + String.valueOf(this.concern_num));
        f.d(getClass().getName(), "logPrint", "sex = " + String.valueOf(this.sex));
        f.d(getClass().getName(), "logPrint", "intro = " + this.intro);
    }

    public void setFans_num(int i) {
        this.fans_num = i;
    }

    public int getFans_num() {
        return this.fans_num;
    }

    public void setConcern_num(int i) {
        this.concern_num = i;
    }

    public int getConcern_num() {
        return this.concern_num;
    }

    public void setIntro(String str) {
        this.intro = str;
    }

    public String getIntro() {
        return this.intro;
    }

    public String getPosition() {
        return this.position;
    }

    public void setPosition(String str) {
        this.position = str;
    }

    public String getLng() {
        return this.lng;
    }

    public void setLng(String str) {
        this.lng = str;
    }

    public String getLat() {
        return this.lat;
    }

    public void setLat(String str) {
        this.lat = str;
    }

    public long getInTime() {
        return this.inTime;
    }

    public void setInTime(long j) {
        this.inTime = j;
    }

    public long getLoginTime() {
        return this.loginTime;
    }

    public void setLoginTime(long j) {
        this.loginTime = j;
    }

    public long getLastReplyTime() {
        return this.lastReplyTime;
    }

    public void setLastReplyTime(long j) {
        this.lastReplyTime = j;
    }

    public void setSex(int i) {
        this.sex = i;
    }

    public int getSex() {
        return this.sex;
    }

    public Permission getPermission() {
        return this.permission;
    }

    public void setPermission(Permission permission) {
        this.permission = permission;
    }

    public void setBDUSS(String str) {
        this.BDUSS = str;
    }

    public String getBDUSS() {
        return this.BDUSS;
    }

    public int getLevel_id() {
        return this.level_id;
    }

    public void setLevel_id(int i) {
        this.level_id = i;
    }

    public void setLike_bars(int i) {
        this.like_bars = i;
    }

    public int getLike_bars() {
        return this.like_bars;
    }

    public void setPosts_num(int i) {
        this.posts_num = i;
    }

    public int getPosts_num() {
        return this.posts_num;
    }

    public void setHave_attention(int i) {
        this.have_attention = i;
    }

    public int getHave_attention() {
        return this.have_attention;
    }

    public int getIs_bawu() {
        return this.is_bawu;
    }

    public String getBawu_type() {
        return this.bawu_type;
    }

    @Override // com.baidu.tbadk.data.MetaData
    public String toString() {
        return "UserData{ip='" + this.ip + "', level_id=" + this.level_id + ", BDUSS='" + this.BDUSS + "', fans_num=" + this.fans_num + ", concern_num=" + this.concern_num + ", like_bars=" + this.like_bars + ", sex=" + this.sex + ", intro='" + this.intro + "', have_attention=" + this.have_attention + ", password='" + this.password + "', is_like=" + this.is_like + ", posts_num=" + this.posts_num + ", is_bawu=" + this.is_bawu + ", bawu_type='" + this.bawu_type + "', isManager=" + this.isManager + "}:" + super.toString();
    }

    /* loaded from: classes.dex */
    public class Permission implements Serializable {
        private static final long serialVersionUID = -661968182172681650L;
        private int isGroupManager;
        private int isGroupOwner;

        public boolean getIsGroupOwner() {
            return this.isGroupOwner == 1;
        }

        public void setIsGroupOwner(int i) {
            this.isGroupOwner = i;
        }

        public boolean getIsGroupManager() {
            return this.isGroupManager == 1;
        }

        public void setIsGroupManager(int i) {
            this.isGroupManager = i;
        }

        public boolean isController() {
            return getIsGroupManager() || getIsGroupOwner();
        }
    }
}
