package com.baidu.tbadk.coreExtra.data;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class r {
    private String arY;
    private String arZ;
    private String asa;
    private String asb;
    private String asc;
    private String asd;
    private String ase;
    private String asf;
    private int asg;
    private int ash;
    private long asi;
    private int asj;
    private String asm;
    private String asn;
    private String aso;
    public int asq;
    private String ass;
    private String ast;
    private int asu;
    private String infoIconUrl;
    private String infoTargetUrl;
    private long infoTimeStamp;
    private long lastUpdateTime;
    private String uegVoiceWarning;
    private int ask = 0;
    private int asl = 0;
    private int asp = 2;
    private String asr = "";

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.arY = jSONObject.optString("drop_pic");
                this.arZ = jSONObject.optString("drop_pic_md5");
                this.asa = jSONObject.optString("drop_pic_num");
                this.asb = jSONObject.optString("drop_bg_color_day");
                this.asc = jSONObject.optString("drop_bg_color_night");
                this.asd = jSONObject.optString("apply_vip_live_room_pid");
                this.asm = jSONObject.optString("max_cache");
                this.asn = jSONObject.optString("frs_max_cache");
                this.aso = jSONObject.optString("frs_pn");
                this.ase = jSONObject.optString("tail_link");
                this.asf = jSONObject.optString("bubble_link");
                this.asg = jSONObject.optInt("xiaoying_time");
                this.lastUpdateTime = jSONObject.optLong("last_update_time", 0L);
                this.ast = jSONObject.optString("url_analyze_text");
                this.ash = jSONObject.optInt("new_resign", 0);
                this.asi = jSONObject.optLong("personalized_cache_seconds", 43200L);
                this.asj = jSONObject.optInt("personalized_max_count", 300);
                this.infoIconUrl = jSONObject.optString("info_icon_url");
                this.infoTimeStamp = jSONObject.optLong("info_time_stamp", 0L);
                this.infoTargetUrl = jSONObject.optString("info_target_url");
                this.ask = jSONObject.optInt("read_thread_switch", 0);
                this.asp = jSONObject.optInt("localvideo_open", 2);
                this.asq = jSONObject.optInt("card_show_statistic", 200);
                this.asr = jSONObject.optString("clean_smart_frs_cookie");
                com.baidu.tbadk.pageStayDuration.e.FS().fe(jSONObject.optInt("statlog_path_max", 3));
                this.asl = jSONObject.optInt("photo_cache_num", 30);
                this.uegVoiceWarning = jSONObject.optString("ueg_voice_warning");
                this.ass = jSONObject.optString("nickname_activity_link");
                this.asu = jSONObject.optInt("android_tab_show", 7);
                new WebCacheWhiteListData().saveString(jSONObject.optString("android_h5cache_whitelist"));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public String yD() {
        return this.asd;
    }

    public String yE() {
        return this.arY;
    }

    public String yF() {
        return this.arZ;
    }

    public String yG() {
        return this.asa;
    }

    public String yH() {
        return this.asb;
    }

    public String yI() {
        return this.asc;
    }

    public String yJ() {
        return this.asm;
    }

    public String yK() {
        return this.asn;
    }

    public String yL() {
        return this.aso;
    }

    public String yM() {
        return this.ase;
    }

    public String yN() {
        return this.asf;
    }

    public int yO() {
        return this.asg;
    }

    public long yP() {
        return this.lastUpdateTime;
    }

    public int yQ() {
        return this.asu;
    }

    public long yR() {
        return this.asi;
    }

    public int yS() {
        return this.asj;
    }

    public int yT() {
        return this.ash;
    }

    public String yU() {
        return this.infoIconUrl;
    }

    public String yV() {
        return this.infoTargetUrl;
    }

    public long yW() {
        return this.infoTimeStamp;
    }

    public int yX() {
        return this.ask;
    }

    public String yY() {
        return this.asr;
    }

    public boolean yZ() {
        return this.asp == 1;
    }

    public int za() {
        return this.asl;
    }

    public String getUegVoiceWarning() {
        return this.uegVoiceWarning;
    }

    public String zb() {
        return this.ass;
    }

    public String zc() {
        return this.ast;
    }
}
