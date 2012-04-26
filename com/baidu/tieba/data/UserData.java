package com.baidu.tieba.data;

import com.baidu.tieba.util.NetWork;
import com.baidu.tieba.util.TiebaLog;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class UserData extends MetaData {
    public static final int FEMALE = 2;
    public static final int MALE = 1;
    private int have_attention;
    private String ip = null;
    private String BDUSS = null;
    private int level_id = 0;
    private int fans_num = 0;
    private int concern_num = 0;
    private int like_bars = 0;
    private int sex = 1;
    private String intro = null;

    public UserData() {
        setHave_attention(0);
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getIp() {
        return this.ip;
    }

    @Override // com.baidu.tieba.data.MetaData
    public void parserJson(String data) {
        try {
            JSONObject json = new JSONObject(data);
            parserJson(json);
        } catch (Exception ex) {
            TiebaLog.e("PostData", "parserJson", "error = " + ex.getMessage());
        }
    }

    @Override // com.baidu.tieba.data.MetaData
    public void parserJson(JSONObject json) {
        try {
            super.parserJson(json);
            if (json != null) {
                this.ip = json.optString("ip");
                this.BDUSS = json.optString(NetWork.BDUSS);
                this.level_id = json.optInt("level_id", 0);
                this.fans_num = json.optInt("fans_num");
                this.concern_num = json.optInt("concern_num");
                this.sex = json.optInt("sex", 1);
                this.like_bars = json.optInt("like_forum_num");
                this.intro = json.optString("intro");
                this.have_attention = json.optInt("has_concerned");
            }
        } catch (Exception ex) {
            TiebaLog.e("PostData", "parserJson", "error = " + ex.getMessage());
        }
    }

    @Override // com.baidu.tieba.data.MetaData
    public void logPrint() {
        super.logPrint();
        TiebaLog.v(getClass().getName(), "logPrint", "ip = " + this.ip);
        TiebaLog.v(getClass().getName(), "logPrint", "BDUSS = " + this.BDUSS);
        TiebaLog.v(getClass().getName(), "logPrint", "level_id = " + String.valueOf(this.level_id));
        TiebaLog.v(getClass().getName(), "logPrint", "fans_num = " + String.valueOf(this.fans_num));
        TiebaLog.v(getClass().getName(), "logPrint", "concern_num = " + String.valueOf(this.concern_num));
        TiebaLog.v(getClass().getName(), "logPrint", "sex = " + String.valueOf(this.sex));
        TiebaLog.v(getClass().getName(), "logPrint", "intro = " + this.intro);
    }

    public void setFans_num(int fans_num) {
        this.fans_num = fans_num;
    }

    public int getFans_num() {
        return this.fans_num;
    }

    public void setConcern_num(int concern_num) {
        this.concern_num = concern_num;
    }

    public int getConcern_num() {
        return this.concern_num;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String getIntro() {
        return this.intro;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public int getSex() {
        return this.sex;
    }

    public void setBDUSS(String bDUSS) {
        this.BDUSS = bDUSS;
    }

    public String getBDUSS() {
        return this.BDUSS;
    }

    public int getLevel_id() {
        return this.level_id;
    }

    public void setLevel_id(int level_id) {
        this.level_id = level_id;
    }

    public void setLike_bars(int like_bars) {
        this.like_bars = like_bars;
    }

    public int getLike_bars() {
        return this.like_bars;
    }

    public void setHave_attention(int have_attention) {
        this.have_attention = have_attention;
    }

    public int getHave_attention() {
        return this.have_attention;
    }
}
