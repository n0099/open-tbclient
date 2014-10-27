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
    private int akp;
    private boolean alP = true;
    private ArrayList<com.baidu.tieba.d.a.f> alR = new ArrayList<>();
    private ForumData alH = new ForumData();
    private com.baidu.tbadk.core.data.q alI = new com.baidu.tbadk.core.data.q();
    private ArrayList<ak> alJ = new ArrayList<>();
    private HashMap<String, MetaData> userMap = new HashMap<>();
    private com.baidu.tbadk.core.data.m alK = new com.baidu.tbadk.core.data.m();
    private AntiData zQ = new AntiData();
    private ab alL = new ab();
    private int alN = 0;
    private boolean alM = false;
    private final UserData alO = new UserData();
    private AdditionData alQ = new AdditionData();

    public boolean zI() {
        return this.alP;
    }

    public void br(boolean z) {
        this.alP = z;
    }

    public ah() {
        this.akp = 0;
        this.akp = 0;
    }

    public boolean isValid() {
        return this.alJ != null && this.alJ.size() > 0;
    }

    public String[] N(Context context) {
        String str = "";
        if (isValid()) {
            ak akVar = this.alJ.get(0);
            com.baidu.tbadk.core.util.as Al = akVar.Al();
            r1 = Al != null ? Al.AI : null;
            str = akVar.R(context);
            if (this.alI != null && this.alI.getAnchorInfoData() != null && this.alI.getAnchorInfoData().getGroup_id() != 0) {
                str = "[" + context.getString(com.baidu.tieba.y.msglist_live) + "] " + str;
            }
        }
        return new String[]{r1, str};
    }

    public ForumData zJ() {
        return this.alH;
    }

    public com.baidu.tbadk.core.data.q zK() {
        return this.alI;
    }

    public ArrayList<ak> zL() {
        return this.alJ;
    }

    public com.baidu.tbadk.core.data.m zM() {
        return this.alK;
    }

    public void a(com.baidu.tbadk.core.data.m mVar, int i) {
        this.alK.aP(mVar.kf());
        this.alK.aO(mVar.kd());
        this.alK.aN(mVar.kc());
        this.alK.aQ(mVar.kg());
        if (i == 0) {
            this.alK = mVar;
        } else if (i == 1) {
            this.alK.aR(mVar.kh());
        } else if (i == 2) {
            this.alK.aS(mVar.ki());
        }
    }

    public AntiData jZ() {
        return this.zQ;
    }

    public UserData getUserData() {
        return this.alO;
    }

    public boolean zN() {
        return this.alI.kC() != 0;
    }

    public void bs(boolean z) {
        if (this.alI != null) {
            if (z) {
                this.alI.aV(1);
            } else {
                this.alI.aV(0);
            }
        }
    }

    public String zO() {
        if (this.alI != null) {
            return this.alI.kD();
        }
        return null;
    }

    public void ew(String str) {
        if (this.alI != null) {
            this.alI.bb(str);
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
                this.alH.parserJson(jSONObject.optJSONObject("forum"));
                this.alI.setUserMap(this.userMap);
                this.alI.parserJson(jSONObject.optJSONObject("thread"));
                JSONArray optJSONArray3 = jSONObject.optJSONArray("post_list");
                if (optJSONArray3 != null) {
                    for (int i2 = 0; i2 < optJSONArray3.length(); i2++) {
                        ak akVar = new ak();
                        akVar.setUserMap(this.userMap);
                        akVar.a(optJSONArray3.optJSONObject(i2), context);
                        this.alJ.add(akVar);
                    }
                }
                this.alK.parserJson(jSONObject.optJSONObject("page"));
                this.zQ.parserJson(jSONObject.optJSONObject("anti"));
                this.alL.parserJson(jSONObject.optJSONObject("location"));
                this.alM = jSONObject.optInt("has_floor") == 1;
                JSONObject optJSONObject = jSONObject.optJSONObject("user");
                if (optJSONObject != null) {
                    this.alN = optJSONObject.optInt("is_manager", 0);
                }
                this.alO.parserJson(optJSONObject);
                this.alQ.parserJson(jSONObject.optJSONObject("add_post"));
                this.alI.setReply_num(this.alI.getReply_num() > 0 ? this.alI.getReply_num() - 1 : 0);
                JSONObject optJSONObject2 = jSONObject.optJSONObject("banner_list");
                if (optJSONObject2 != null && (optJSONArray = optJSONObject2.optJSONArray(SapiUtils.QR_LOGIN_LP_APP)) != null && optJSONArray.length() > 0) {
                    int length = optJSONArray.length();
                    for (int i3 = 0; i3 < length; i3++) {
                        com.baidu.tieba.d.a.f fVar = new com.baidu.tieba.d.a.f();
                        fVar.parserJson(optJSONArray.getJSONObject(i3));
                        if (!this.alR.contains(fVar)) {
                            this.alR.add(fVar);
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
                this.alH.parserProtobuf(dataRes.forum);
                this.alI.setUserMap(this.userMap);
                this.alI.a(dataRes.thread);
                List<Post> list2 = dataRes.post_list;
                if (list2 != null && list2.size() > 0) {
                    for (Post post : dataRes.post_list) {
                        ak akVar = new ak();
                        akVar.setUserMap(this.userMap);
                        akVar.a(post, context);
                        this.alJ.add(akVar);
                    }
                }
                this.alK.a(dataRes.page);
                this.zQ.parserProtobuf(dataRes.anti);
                this.alL.a(dataRes.location);
                this.alM = dataRes.has_floor.intValue() == 1;
                if (dataRes.user != null) {
                    this.alN = dataRes.user.is_manager.intValue();
                }
                this.alO.parserProtobuf(dataRes.user);
                this.alQ.parserProtoBuf(dataRes.add_post);
                this.alI.setReply_num(this.alI.getReply_num() > 0 ? this.alI.getReply_num() - 1 : 0);
                if (dataRes.banner_list != null) {
                    for (App app : dataRes.banner_list.app) {
                        com.baidu.tieba.d.a.f fVar = new com.baidu.tieba.d.a.f();
                        fVar.b(app);
                        if (!this.alR.contains(fVar)) {
                            this.alR.add(fVar);
                        }
                    }
                }
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public boolean zP() {
        return this.alM;
    }

    public int zQ() {
        return this.alN;
    }

    public int yU() {
        return this.akp;
    }

    public void ee(int i) {
        this.akp = i;
    }

    public AdditionData zR() {
        return this.alQ;
    }

    public ArrayList<com.baidu.tieba.d.a.f> zS() {
        return this.alR;
    }
}
