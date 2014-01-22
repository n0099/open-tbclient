package com.baidu.tieba.data;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class UserData extends MetaData {
    public static final int FEMALE = 2;
    public static final int MALE = 1;
    private static final long serialVersionUID = 3385133494210688796L;
    private String bawu_type;
    private int have_attention;
    private int is_bawu;
    private String password = null;
    private int is_like = 0;
    private boolean isManager = false;
    private String ip = null;
    private String BDUSS = null;
    private int level_id = 0;
    private int fans_num = 0;
    private int concern_num = 0;
    private int like_bars = 0;
    private int sex = 1;
    private String intro = null;
    private int posts_num = 0;

    public UserData() {
        setHave_attention(0);
        this.is_bawu = 0;
        this.bawu_type = null;
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

    @Override // com.baidu.tieba.data.MetaData
    public void parserJson(String str) {
        super.parserJson(str);
        try {
            parserJson(new JSONObject(str));
        } catch (Exception e) {
            com.baidu.adp.lib.g.e.b("PostData", "parserJson", "error = " + e.getMessage());
        }
    }

    @Override // com.baidu.tieba.data.MetaData
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
                if (jSONObject.optInt("is_manager", 0) == 1) {
                    this.isManager = true;
                } else {
                    this.isManager = false;
                }
            }
        } catch (Exception e) {
            com.baidu.adp.lib.g.e.b("PostData", "parserJson", "error = " + e.getMessage());
        }
    }

    @Override // com.baidu.tieba.data.MetaData
    public void logPrint() {
        super.logPrint();
        com.baidu.adp.lib.g.e.d(getClass().getName(), "logPrint", "ip = " + this.ip);
        com.baidu.adp.lib.g.e.d(getClass().getName(), "logPrint", "BDUSS = " + this.BDUSS);
        com.baidu.adp.lib.g.e.d(getClass().getName(), "logPrint", "level_id = " + String.valueOf(this.level_id));
        com.baidu.adp.lib.g.e.d(getClass().getName(), "logPrint", "fans_num = " + String.valueOf(this.fans_num));
        com.baidu.adp.lib.g.e.d(getClass().getName(), "logPrint", "concern_num = " + String.valueOf(this.concern_num));
        com.baidu.adp.lib.g.e.d(getClass().getName(), "logPrint", "sex = " + String.valueOf(this.sex));
        com.baidu.adp.lib.g.e.d(getClass().getName(), "logPrint", "intro = " + this.intro);
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

    public void setSex(int i) {
        this.sex = i;
    }

    public int getSex() {
        return this.sex;
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

    @Override // com.baidu.tieba.data.MetaData
    public String toString() {
        return "UserData{ip='" + this.ip + "', level_id=" + this.level_id + ", BDUSS='" + this.BDUSS + "', fans_num=" + this.fans_num + ", concern_num=" + this.concern_num + ", like_bars=" + this.like_bars + ", sex=" + this.sex + ", intro='" + this.intro + "', have_attention=" + this.have_attention + ", password='" + this.password + "', is_like=" + this.is_like + ", posts_num=" + this.posts_num + ", is_bawu=" + this.is_bawu + ", bawu_type='" + this.bawu_type + "', isManager=" + this.isManager + "}:" + super.toString();
    }
}
