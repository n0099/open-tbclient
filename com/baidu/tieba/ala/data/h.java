package com.baidu.tieba.ala.data;

import android.text.TextUtils;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.live.adp.lib.safe.JavaTypesHelper;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.mobstat.Config;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class h extends r {
    public String avatar;
    public int eRx;
    public String gSE;
    public String gSF;
    public String gSG;
    public ArrayList<a> gSH;
    public String is_follow;
    public long live_id;
    public int rank;
    public long room_id;
    public long user_id;
    public String user_name;
    public String user_nickname;

    @Override // com.baidu.tieba.ala.data.r
    public void parserJson(JSONObject jSONObject) {
        this.user_id = JavaTypesHelper.toLong(jSONObject.optString("user_id"), 0L);
        this.rank = JavaTypesHelper.toInt(jSONObject.optString("rank"), 0);
        this.eRx = JavaTypesHelper.toInt(jSONObject.optString("is_live"), 0);
        this.live_id = JavaTypesHelper.toLong(jSONObject.optString("live_id"), 0L);
        this.gSE = jSONObject.optString(Config.EVENT_HEAT_POINT);
        this.gSF = jSONObject.optString("point_behind");
        this.user_nickname = jSONObject.optString("user_nickname");
        if (!TextUtils.isEmpty(jSONObject.optString("bd_portrait"))) {
            this.avatar = jSONObject.optString("bd_portrait");
        } else if (!TextUtils.isEmpty(jSONObject.optString(TableDefine.PaSubscribeColumns.COLUMN_AVATAR))) {
            this.avatar = jSONObject.optString(TableDefine.PaSubscribeColumns.COLUMN_AVATAR);
        }
        this.is_follow = jSONObject.optString("is_follow");
        this.user_name = jSONObject.optString("user_name");
        this.gSG = jSONObject.optString("rule_url");
        this.room_id = jSONObject.optLong("room_id");
        JSONArray optJSONArray = jSONObject.optJSONArray("bro_list");
        if (optJSONArray != null) {
            this.gSH = new ArrayList<>();
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                a aVar = new a();
                aVar.parserJson(optJSONObject);
                this.gSH.add(aVar);
            }
        }
    }

    public String getName_show() {
        return !StringHelper.isEmpty(this.user_nickname) ? this.user_nickname : this.user_name;
    }

    /* loaded from: classes11.dex */
    public class a {
        public long aVC;
        public String portrait;
        public String userId;
        public String userName;
        public String userNickName;

        public a() {
        }

        public void parserJson(JSONObject jSONObject) {
            if (jSONObject != null) {
                this.userId = jSONObject.optString("user_id");
                this.userName = jSONObject.optString("user_name");
                this.userNickName = jSONObject.optString("user_nickname");
                this.portrait = jSONObject.optString("bd_portrait");
                this.aVC = jSONObject.optLong("charm_value");
            }
        }

        public String getName_show() {
            return !StringHelper.isEmpty(this.userNickName) ? this.userNickName : this.userName;
        }
    }
}
