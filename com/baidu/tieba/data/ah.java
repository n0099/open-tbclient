package com.baidu.tieba.data;

import android.content.Context;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.tbadk.core.data.AdditionData;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.UserData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.App;
import tbclient.PbPage.DataRes;
import tbclient.Post;
import tbclient.User;
/* loaded from: classes.dex */
public class ah {
    private int aky;
    private boolean alY = true;
    private ArrayList<com.baidu.tieba.d.a.f> ama = new ArrayList<>();
    private ForumData alQ = new ForumData();
    private com.baidu.tbadk.core.data.q alR = new com.baidu.tbadk.core.data.q();
    private ArrayList<ak> alS = new ArrayList<>();
    private HashMap<String, MetaData> userMap = new HashMap<>();
    private com.baidu.tbadk.core.data.m alT = new com.baidu.tbadk.core.data.m();
    private AntiData zQ = new AntiData();
    private ab alU = new ab();
    private int alW = 0;
    private boolean alV = false;
    private final UserData alX = new UserData();
    private AdditionData alZ = new AdditionData();

    public boolean zK() {
        return this.alY;
    }

    public void br(boolean z) {
        this.alY = z;
    }

    public ah() {
        this.aky = 0;
        this.aky = 0;
    }

    public boolean isValid() {
        return this.alS != null && this.alS.size() > 0;
    }

    public String[] N(Context context) {
        String str = "";
        if (isValid()) {
            ak akVar = this.alS.get(0);
            com.baidu.tbadk.core.util.as An = akVar.An();
            r1 = An != null ? An.AI : null;
            str = akVar.R(context);
            if (this.alR != null && this.alR.getAnchorInfoData() != null && this.alR.getAnchorInfoData().getGroup_id() != 0) {
                str = "[" + context.getString(com.baidu.tieba.y.msglist_live) + "] " + str;
            }
        }
        return new String[]{r1, str};
    }

    public ForumData zL() {
        return this.alQ;
    }

    public com.baidu.tbadk.core.data.q zM() {
        return this.alR;
    }

    public ArrayList<ak> zN() {
        return this.alS;
    }

    public com.baidu.tbadk.core.data.m zO() {
        return this.alT;
    }

    public void a(com.baidu.tbadk.core.data.m mVar, int i) {
        this.alT.aP(mVar.kf());
        this.alT.aO(mVar.kd());
        this.alT.aN(mVar.kc());
        this.alT.aQ(mVar.kg());
        if (i == 0) {
            this.alT = mVar;
        } else if (i == 1) {
            this.alT.aR(mVar.kh());
        } else if (i == 2) {
            this.alT.aS(mVar.ki());
        }
    }

    public AntiData jZ() {
        return this.zQ;
    }

    public UserData getUserData() {
        return this.alX;
    }

    public boolean zP() {
        return this.alR.kC() != 0;
    }

    public void bs(boolean z) {
        if (this.alR != null) {
            if (z) {
                this.alR.aV(1);
            } else {
                this.alR.aV(0);
            }
        }
    }

    public String zQ() {
        if (this.alR != null) {
            return this.alR.kD();
        }
        return null;
    }

    public void ew(String str) {
        if (this.alR != null) {
            this.alR.bb(str);
        }
    }

    public void parserJson(String str) {
        try {
            a(new JSONObject(str), (Context) null);
        } catch (Exception e) {
            BdLog.detailException(e);
        }
    }

    public void a(JSONObject jSONObject, Context context) {
        JSONArray optJSONArray;
        if (jSONObject != null) {
            try {
                JSONArray optJSONArray2 = jSONObject.optJSONArray("user_list");
                if (optJSONArray2 != null) {
                    for (int i = 0; i < optJSONArray2.length(); i++) {
                        MetaData metaData = new MetaData();
                        metaData.parserJson(optJSONArray2.optJSONObject(i));
                        if (metaData.getUserId() != null && metaData != null) {
                            this.userMap.put(metaData.getUserId(), metaData);
                        }
                    }
                }
                ee(jSONObject.optInt("is_new_url", 0));
                this.alQ.parserJson(jSONObject.optJSONObject("forum"));
                this.alR.setUserMap(this.userMap);
                this.alR.parserJson(jSONObject.optJSONObject("thread"));
                JSONArray optJSONArray3 = jSONObject.optJSONArray("post_list");
                if (optJSONArray3 != null) {
                    for (int i2 = 0; i2 < optJSONArray3.length(); i2++) {
                        ak akVar = new ak();
                        akVar.setUserMap(this.userMap);
                        akVar.a(optJSONArray3.optJSONObject(i2), context);
                        this.alS.add(akVar);
                    }
                }
                this.alT.parserJson(jSONObject.optJSONObject("page"));
                this.zQ.parserJson(jSONObject.optJSONObject("anti"));
                this.alU.parserJson(jSONObject.optJSONObject("location"));
                this.alV = jSONObject.optInt("has_floor") == 1;
                JSONObject optJSONObject = jSONObject.optJSONObject("user");
                if (optJSONObject != null) {
                    this.alW = optJSONObject.optInt("is_manager", 0);
                }
                this.alX.parserJson(optJSONObject);
                this.alZ.parserJson(jSONObject.optJSONObject("add_post"));
                this.alR.setReply_num(this.alR.getReply_num() > 0 ? this.alR.getReply_num() - 1 : 0);
                JSONObject optJSONObject2 = jSONObject.optJSONObject("banner_list");
                if (optJSONObject2 != null && (optJSONArray = optJSONObject2.optJSONArray(SapiUtils.QR_LOGIN_LP_APP)) != null && optJSONArray.length() > 0) {
                    int length = optJSONArray.length();
                    for (int i3 = 0; i3 < length; i3++) {
                        com.baidu.tieba.d.a.f fVar = new com.baidu.tieba.d.a.f();
                        fVar.parserJson(optJSONArray.getJSONObject(i3));
                        if (!this.ama.contains(fVar)) {
                            this.ama.add(fVar);
                        }
                    }
                }
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public void a(DataRes dataRes, Context context) {
        if (dataRes != null) {
            try {
                List<User> list = dataRes.user_list;
                if (list != null) {
                    for (int i = 0; i < list.size(); i++) {
                        MetaData metaData = new MetaData();
                        metaData.parserProtobuf(list.get(i));
                        String userId = metaData.getUserId();
                        if (userId != null && !userId.equals("0")) {
                            this.userMap.put(metaData.getUserId(), metaData);
                        }
                    }
                }
                ee(dataRes.is_new_url.intValue());
                this.alQ.parserProtobuf(dataRes.forum);
                this.alR.setUserMap(this.userMap);
                this.alR.a(dataRes.thread);
                List<Post> list2 = dataRes.post_list;
                if (list2 != null && list2.size() > 0) {
                    for (Post post : dataRes.post_list) {
                        ak akVar = new ak();
                        akVar.setUserMap(this.userMap);
                        akVar.a(post, context);
                        this.alS.add(akVar);
                    }
                }
                this.alT.a(dataRes.page);
                this.zQ.parserProtobuf(dataRes.anti);
                this.alU.a(dataRes.location);
                this.alV = dataRes.has_floor.intValue() == 1;
                if (dataRes.user != null) {
                    this.alW = dataRes.user.is_manager.intValue();
                }
                this.alX.parserProtobuf(dataRes.user);
                this.alZ.parserProtoBuf(dataRes.add_post);
                this.alR.setReply_num(this.alR.getReply_num() > 0 ? this.alR.getReply_num() - 1 : 0);
                if (dataRes.banner_list != null) {
                    for (App app : dataRes.banner_list.app) {
                        com.baidu.tieba.d.a.f fVar = new com.baidu.tieba.d.a.f();
                        fVar.b(app);
                        if (!this.ama.contains(fVar)) {
                            this.ama.add(fVar);
                        }
                    }
                }
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public boolean zR() {
        return this.alV;
    }

    public int zS() {
        return this.alW;
    }

    public int yW() {
        return this.aky;
    }

    public void ee(int i) {
        this.aky = i;
    }

    public AdditionData zT() {
        return this.alZ;
    }

    public ArrayList<com.baidu.tieba.d.a.f> zU() {
        return this.ama;
    }
}
