package com.baidu.tieba.ala.data;

import android.text.TextUtils;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.live.adp.lib.safe.JavaTypesHelper;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.mobstat.Config;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class g extends n {
    public String avatar;
    public int cSl;
    public String ezL;
    public String ezM;
    public ArrayList<a> ezN;
    public String is_follow;
    public long live_id;
    public String point;
    public int rank;
    public long room_id;
    public long user_id;
    public String user_name;
    public String user_nickname;

    @Override // com.baidu.tieba.ala.data.n
    public void parserJson(JSONObject jSONObject) {
        this.user_id = JavaTypesHelper.toLong(jSONObject.optString("user_id"), 0L);
        this.rank = JavaTypesHelper.toInt(jSONObject.optString("rank"), 0);
        this.cSl = JavaTypesHelper.toInt(jSONObject.optString("is_live"), 0);
        this.live_id = JavaTypesHelper.toLong(jSONObject.optString("live_id"), 0L);
        this.point = jSONObject.optString(Config.EVENT_HEAT_POINT);
        this.ezL = jSONObject.optString("point_behind");
        this.user_nickname = jSONObject.optString("user_nickname");
        if (!TextUtils.isEmpty(jSONObject.optString("bd_portrait"))) {
            this.avatar = jSONObject.optString("bd_portrait");
        } else if (!TextUtils.isEmpty(jSONObject.optString(TableDefine.PaSubscribeColumns.COLUMN_AVATAR))) {
            this.avatar = jSONObject.optString(TableDefine.PaSubscribeColumns.COLUMN_AVATAR);
        }
        this.is_follow = jSONObject.optString("is_follow");
        this.user_name = jSONObject.optString("user_name");
        this.ezM = jSONObject.optString("rule_url");
        this.room_id = jSONObject.optInt("room_id");
        JSONArray optJSONArray = jSONObject.optJSONArray("bro_list");
        if (optJSONArray != null) {
            this.ezN = new ArrayList<>();
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                a aVar = new a();
                aVar.parserJson(optJSONObject);
                this.ezN.add(aVar);
            }
        }
    }

    public String getName_show() {
        return !StringHelper.isEmpty(this.user_nickname) ? this.user_nickname : this.user_name;
    }

    /* loaded from: classes3.dex */
    public class a {
        public String ezO;
        public long ezP;
        public String portrait;
        public String userId;
        public String userName;

        public a() {
        }

        public void parserJson(JSONObject jSONObject) {
            if (jSONObject != null) {
                this.userId = jSONObject.optString("user_id");
                this.userName = jSONObject.optString("user_name");
                this.ezO = jSONObject.optString("user_nickname");
                this.portrait = jSONObject.optString("bd_portrait");
                this.ezP = jSONObject.optLong("charm_value");
            }
        }

        public String getName_show() {
            return !StringHelper.isEmpty(this.ezO) ? this.ezO : this.userName;
        }
    }
}
