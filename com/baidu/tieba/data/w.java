package com.baidu.tieba.data;

import android.content.Context;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.data.AntiData;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class w {
    private AntiData alm;
    private LinkedList<v> aln;
    private String alj = null;
    private String fid = null;
    private int alk = 0;
    private Context mContext = null;
    private String alo = null;
    private String alp = null;
    private String tid = null;
    private String title = null;
    private int aky = 0;

    public String zt() {
        return this.alo;
    }

    public String zu() {
        return this.alp;
    }

    public w() {
        this.alm = null;
        this.aln = null;
        this.aln = new LinkedList<>();
        this.alm = new AntiData();
    }

    public void s(String str, boolean z) {
        try {
            a(new JSONObject(str), Boolean.valueOf(z));
        } catch (Exception e) {
            BdLog.detailException(e);
        }
    }

    public LinkedList<v> zv() {
        return this.aln;
    }

    public int zw() {
        return this.alk;
    }

    public void a(JSONObject jSONObject, Boolean bool) {
        if (jSONObject != null) {
            try {
                this.aky = jSONObject.optInt("is_new_url", 0);
                JSONObject optJSONObject = jSONObject.optJSONObject("forum");
                if (optJSONObject != null) {
                    this.alj = optJSONObject.optString("name");
                    this.fid = optJSONObject.optString("id");
                }
                this.alk = jSONObject.optInt("pic_amount", 0);
                JSONArray optJSONArray = jSONObject.optJSONArray("pic_list");
                if (optJSONArray != null) {
                    if (bool.booleanValue()) {
                        for (int i = 0; i < optJSONArray.length(); i++) {
                            v vVar = new v(this.mContext);
                            vVar.paserJson(optJSONArray.optJSONObject(i));
                            int index = vVar.getIndex();
                            if (index >= 1 && index <= this.alk) {
                                this.aln.addLast(vVar);
                            }
                        }
                    } else {
                        for (int length = optJSONArray.length() - 1; length >= 0; length--) {
                            v vVar2 = new v(this.mContext);
                            vVar2.paserJson(optJSONArray.getJSONObject(length));
                            int index2 = vVar2.getIndex();
                            if (index2 >= 1 && index2 <= this.alk) {
                                this.aln.addFirst(vVar2);
                            }
                        }
                    }
                }
                JSONObject optJSONObject2 = jSONObject.optJSONArray("album_list").optJSONObject(0);
                this.alo = optJSONObject2.optString("tid");
                this.alp = optJSONObject2.optString("title");
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
