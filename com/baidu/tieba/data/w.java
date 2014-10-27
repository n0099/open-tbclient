package com.baidu.tieba.data;

import android.content.Context;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.data.AntiData;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class w {
    private AntiData alc;
    private LinkedList<v> ald;
    private String ala = null;
    private String fid = null;
    private int alb = 0;
    private Context mContext = null;
    private String ale = null;
    private String alf = null;
    private String tid = null;
    private String title = null;
    private int akp = 0;

    public String zr() {
        return this.ale;
    }

    public String zs() {
        return this.alf;
    }

    public w() {
        this.alc = null;
        this.ald = null;
        this.ald = new LinkedList<>();
        this.alc = new AntiData();
    }

    public void s(String str, boolean z) {
        try {
            a(new JSONObject(str), Boolean.valueOf(z));
        } catch (Exception e) {
            BdLog.detailException(e);
        }
    }

    public LinkedList<v> zt() {
        return this.ald;
    }

    public int zu() {
        return this.alb;
    }

    public void a(JSONObject jSONObject, Boolean bool) {
        if (jSONObject != null) {
            try {
                this.akp = jSONObject.optInt("is_new_url", 0);
                JSONObject optJSONObject = jSONObject.optJSONObject("forum");
                if (optJSONObject != null) {
                    this.ala = optJSONObject.optString("name");
                    this.fid = optJSONObject.optString("id");
                }
                this.alb = jSONObject.optInt("pic_amount", 0);
                JSONArray optJSONArray = jSONObject.optJSONArray("pic_list");
                if (optJSONArray != null) {
                    if (bool.booleanValue()) {
                        for (int i = 0; i < optJSONArray.length(); i++) {
                            v vVar = new v(this.mContext);
                            vVar.paserJson(optJSONArray.optJSONObject(i));
                            int index = vVar.getIndex();
                            if (index >= 1 && index <= this.alb) {
                                this.ald.addLast(vVar);
                            }
                        }
                    } else {
                        for (int length = optJSONArray.length() - 1; length >= 0; length--) {
                            v vVar2 = new v(this.mContext);
                            vVar2.paserJson(optJSONArray.getJSONObject(length));
                            int index2 = vVar2.getIndex();
                            if (index2 >= 1 && index2 <= this.alb) {
                                this.ald.addFirst(vVar2);
                            }
                        }
                    }
                }
                JSONObject optJSONObject2 = jSONObject.optJSONArray("album_list").optJSONObject(0);
                this.ale = optJSONObject2.optString("tid");
                this.alf = optJSONObject2.optString("title");
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
