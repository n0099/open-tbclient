package com.baidu.tieba.data;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class ax {
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
    private ArrayList<ak> k = new ArrayList<>();

    public final void a(JSONObject jSONObject) {
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
                this.g = optJSONObject2.optInt("has_audio", 0);
                this.h = optJSONObject2.optInt("has_video", 0);
                this.i = optJSONObject2.optString("audio_url", null);
                this.j = optJSONObject2.optString("video_url", null);
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("pinfo");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                this.k.clear();
                for (int i = 0; i < optJSONArray.length() && i < 2; i++) {
                    ak akVar = new ak();
                    akVar.a(optJSONArray.getJSONObject(i));
                    this.k.add(akVar);
                }
            }
        } catch (Exception e) {
            com.baidu.adp.lib.util.e.b("SupperBoyData", "parserJson", "error = " + e.getMessage());
        }
    }
}
