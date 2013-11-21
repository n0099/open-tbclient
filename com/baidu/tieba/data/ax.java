package com.baidu.tieba.data;

import com.baidu.tieba.util.bg;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ax {

    /* renamed from: a  reason: collision with root package name */
    private boolean f1184a = false;
    private String b = null;
    private String c = null;
    private long d = 0;
    private int e = 0;
    private int f = 0;
    private int g = 0;
    private int h = 0;
    private String i = null;
    private String j = null;
    private ArrayList<al> k = new ArrayList<>();

    public void a(JSONObject jSONObject) {
        try {
            if (jSONObject == null) {
                this.f1184a = false;
                return;
            }
            this.f1184a = true;
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
                    al alVar = new al();
                    alVar.a(optJSONArray.getJSONObject(i));
                    this.k.add(alVar);
                }
            }
        } catch (Exception e) {
            bg.b("SupperBoyData", "parserJson", "error = " + e.getMessage());
        }
    }

    public void a(int i) {
        this.g = i;
    }

    public void b(int i) {
        this.h = i;
    }
}
