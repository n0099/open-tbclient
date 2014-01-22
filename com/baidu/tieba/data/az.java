package com.baidu.tieba.data;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class az {
    private boolean a = false;
    private String b = null;
    private String c = null;
    private long d = 0;
    private int e = 0;
    private int f = 0;
    private int g = 0;
    private int h = 0;
    private String i = null;
    private String j = null;
    private ArrayList<am> k = new ArrayList<>();

    public void a(JSONObject jSONObject) {
        try {
            if (jSONObject == null) {
                this.a = false;
                return;
            }
            this.a = true;
            JSONObject optJSONObject = jSONObject.optJSONObject("player_rank_info");
            if (optJSONObject != null) {
                this.b = optJSONObject.optString("player_id", null);
                this.c = optJSONObject.optString("player_name", null);
                this.d = optJSONObject.optLong("vote_number", 0L);
                this.e = optJSONObject.optInt("player_rank");
                this.f = optJSONObject.optInt("join_type", 0);
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("media");
            if (optJSONObject2 != null) {
                a(optJSONObject2.optInt("has_audio", 0));
                b(optJSONObject2.optInt("has_video", 0));
                this.i = optJSONObject2.optString("audio_url", null);
                this.j = optJSONObject2.optString("video_url", null);
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("pinfo");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                this.k.clear();
                for (int i = 0; i < optJSONArray.length() && i < 2; i++) {
                    am amVar = new am();
                    amVar.a(optJSONArray.getJSONObject(i));
                    this.k.add(amVar);
                }
            }
        } catch (Exception e) {
            com.baidu.adp.lib.g.e.b("SupperBoyData", "parserJson", "error = " + e.getMessage());
        }
    }

    public void a(int i) {
        this.g = i;
    }

    public void b(int i) {
        this.h = i;
    }
}
