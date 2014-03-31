package com.baidu.tbadk.data;

import com.baidu.adp.lib.util.f;
import java.io.Serializable;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class UserData extends MetaData {
    private static final long serialVersionUID = -1871115639893992930L;
    private String BDUSS;
    private String bimg_url;
    private int concern_num;
    private int fans_num;
    private int have_attention;
    private long inTime;
    private String intro;
    private String ip;
    private boolean isManager;
    private long lastReplyTime;
    private String lat;
    private int like_bars;
    private String lng;
    private long loginTime;
    private String password;
    private Permission permission;
    private String position;
    private int posts_num;
    private int sex;
    private String tb_age;
    private int userType;

    public String getTb_age() {
        return this.tb_age;
    }

    public void setTb_age(String str) {
        this.tb_age = str;
    }

    public UserData() {
        this.password = null;
        this.isManager = false;
        this.ip = null;
        this.BDUSS = null;
        this.fans_num = 0;
        this.concern_num = 0;
        this.like_bars = 0;
        this.sex = 1;
        this.intro = null;
        this.posts_num = 0;
        setHave_attention(0);
        this.tb_age = "";
    }

    public UserData(long j, String str, String str2, int i) {
        this.password = null;
        this.isManager = false;
        setUserId(String.valueOf(j));
        setUserName(str);
        setPortrait(str2);
        this.sex = i;
    }

    public void setIp(String str) {
        this.ip = str;
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
                this.fans_num = jSONObject.optInt("fans_num");
                this.concern_num = jSONObject.optInt("concern_num");
                this.sex = jSONObject.optInt("sex", 1);
                this.like_bars = jSONObject.optInt("my_like_num");
                this.intro = jSONObject.optString("intro");
                this.have_attention = jSONObject.optInt("has_concerned");
                this.password = jSONObject.optString("passwd");
                this.posts_num = jSONObject.optInt("post_num", 0);
                this.tb_age = jSONObject.optString("tb_age");
                if (jSONObject.optInt("is_manager", 0) == 1) {
                    this.isManager = true;
                } else {
                    this.isManager = false;
                }
                this.bimg_url = jSONObject.optString("bimg_url");
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

    public int getUserType() {
        return this.userType;
    }

    public void setUserType(int i) {
        this.userType = i;
    }

    public String getBimg_url() {
        return this.bimg_url;
    }

    @Override // com.baidu.tbadk.data.MetaData
    public String toString() {
        return "UserData [ip=" + this.ip + ", BDUSS=" + this.BDUSS + ", fans_num=" + this.fans_num + ", concern_num=" + this.concern_num + ", like_bars=" + this.like_bars + ", sex=" + this.sex + ", intro=" + this.intro + ", have_attention=" + this.have_attention + ", password=" + this.password + ", posts_num=" + this.posts_num + ", isManager=" + this.isManager + ", position=" + this.position + ", lng=" + this.lng + ", lat=" + this.lat + ", inTime=" + this.inTime + ", loginTime=" + this.loginTime + ", lastReplyTime=" + this.lastReplyTime + ", userType=" + this.userType + ", permission=" + this.permission + ", tb_age=" + this.tb_age + "]";
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
