package com.baidu.tbadk.data;

import com.baidu.adp.lib.util.BdLog;
import java.io.Serializable;
import org.json.JSONObject;
import tbclient.User;
/* loaded from: classes.dex */
public class UserData extends MetaData {
    private static final long serialVersionUID = -1871115639893992930L;
    private String BDUSS;
    private int bimg_end_time;
    private String bimg_url;
    private int concern_num;
    private int have_attention;
    private long inTime;
    private String intro;
    private String ip;
    private int isFriend;
    private boolean isManager;
    private boolean isMask;
    private int is_mem;
    private long lastReplyTime;
    private String lat;
    private int like_bars;
    private String lng;
    private long loginTime;
    private int mFansNum;
    private int managerLevel;
    private String password;
    private Permission permission;
    private b personPrivate;
    private String position;
    private int posts_num;
    private int sex;
    private String tb_age;
    private int userType;

    public b getPersonPrivate() {
        return this.personPrivate;
    }

    public void setPersonPrivate(b bVar) {
        this.personPrivate = bVar;
    }

    public String getTb_age() {
        return this.tb_age;
    }

    public void setTb_age(String str) {
        this.tb_age = str;
    }

    public int getIsMem() {
        return this.is_mem;
    }

    public void setIsMem(int i) {
        this.is_mem = i;
    }

    public int getIsFriend() {
        return this.isFriend;
    }

    public void setIsFriend(int i) {
        this.isFriend = i;
    }

    public UserData() {
        this.password = null;
        this.isManager = false;
        this.isMask = false;
        this.ip = null;
        this.BDUSS = null;
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
        this.isMask = false;
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
    public void parserProtobuf(User user) {
        if (user != null) {
            super.parserProtobuf(user);
            this.ip = user.ip;
            this.BDUSS = user.BDUSS;
            this.concern_num = user.concern_num.intValue();
            this.mFansNum = user.fans_num.intValue();
            this.sex = user.sex.intValue();
            this.like_bars = user.my_like_num.intValue();
            this.intro = user.intro;
            this.have_attention = user.has_concerned.intValue();
            this.password = user.passwd;
            this.posts_num = user.post_num.intValue();
            this.tb_age = user.tb_age;
            this.managerLevel = user.is_manager.intValue();
            if (user.is_manager.intValue() == 1) {
                this.isManager = true;
            } else {
                this.isManager = false;
            }
            if (user.is_mem != null) {
                this.is_mem = user.is_mem.intValue();
            }
            this.bimg_url = user.bimg_url;
            this.bimg_end_time = user.bimg_end_time.intValue();
        }
    }

    public boolean isBawu() {
        return this.managerLevel == 1 || this.managerLevel == 2;
    }

    @Override // com.baidu.tbadk.data.MetaData
    public void parserJson(String str) {
        super.parserJson(str);
        try {
            parserJson(new JSONObject(str));
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    @Override // com.baidu.tbadk.data.MetaData
    public void parserJson(JSONObject jSONObject) {
        try {
            super.parserJson(jSONObject);
            if (jSONObject != null) {
                this.ip = jSONObject.optString("ip");
                this.BDUSS = jSONObject.optString("BDUSS");
                this.concern_num = jSONObject.optInt("concern_num");
                this.mFansNum = jSONObject.optInt("fans_num");
                this.sex = jSONObject.optInt("sex", 1);
                this.like_bars = jSONObject.optInt("my_like_num");
                this.intro = jSONObject.optString("intro");
                this.isFriend = jSONObject.optInt("is_friend");
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
                this.bimg_end_time = jSONObject.optInt("bimg_end_time", 0);
                this.is_mem = jSONObject.optInt("is_mem");
                JSONObject optJSONObject = jSONObject.optJSONObject("priv_sets");
                if (optJSONObject != null) {
                    this.personPrivate = new b();
                    this.personPrivate.a(optJSONObject);
                }
                if (jSONObject.optInt("is_mask") == 1) {
                    this.isMask = true;
                } else {
                    this.isMask = false;
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    @Override // com.baidu.tbadk.data.MetaData
    public void logPrint() {
        super.logPrint();
    }

    public void setConcern_num(int i) {
        this.concern_num = i;
    }

    public int getConcern_num() {
        return this.concern_num;
    }

    public int getFansNum() {
        return this.mFansNum;
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

    public void setBimg_url(String str) {
        this.bimg_url = str;
    }

    public int getBimg_end_time() {
        return this.bimg_end_time;
    }

    public boolean isMask() {
        return this.isMask;
    }

    public void setMask(boolean z) {
        this.isMask = z;
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
