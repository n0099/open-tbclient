package com.baidu.tieba.frs;

import android.util.SparseArray;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.FrsTabInfo;
/* loaded from: classes.dex */
public class a {
    private boolean inA;
    private int inB;
    private List<FrsTabInfo> inC;
    private SparseArray<FrsTabInfo> inD;
    private ay inE;
    private final List<bw> inz;
    private String mForumId;

    private a() {
        this.inB = -1;
        this.inz = new ArrayList();
    }

    public static a crx() {
        return C0694a.inF;
    }

    public boolean cry() {
        return this.inA;
    }

    public void setForumId(String str) {
        this.mForumId = str;
    }

    public String getForumId() {
        return this.mForumId;
    }

    public void xS(int i) {
        this.inB = i;
    }

    public int crz() {
        return this.inB;
    }

    public void cK(List<FrsTabInfo> list) {
        this.inC = new ArrayList(list);
        this.inD = new SparseArray<>();
        for (FrsTabInfo frsTabInfo : this.inC) {
            if (frsTabInfo != null) {
                this.inD.append(frsTabInfo.tab_id.intValue(), frsTabInfo);
            }
        }
    }

    public List<FrsTabInfo> crA() {
        return this.inC;
    }

    public List<bw> crB() {
        return this.inz;
    }

    public boolean xT(int i) {
        return this.inD.get(i) != null && this.inD.get(i).is_general_tab.intValue() == 1;
    }

    public void a(ay ayVar) {
        this.inE = ayVar;
    }

    public void S(boolean z, boolean z2) {
        this.inA = z;
        if (this.inE != null) {
            this.inE.d(this.inA, z2, 2);
        }
    }

    public boolean aj(bw bwVar) {
        if (bwVar == null) {
            return false;
        }
        if (this.inz.size() > 29) {
            if (this.inE != null) {
                this.inE.yb(2);
                return false;
            }
            return false;
        }
        this.inz.add(bwVar);
        if (this.inE != null) {
            this.inE.ci(this.inz.size(), 2);
        }
        return true;
    }

    public void ak(bw bwVar) {
        this.inz.remove(bwVar);
        if (this.inE != null) {
            this.inE.ci(this.inz.size(), 2);
        }
    }

    public void cg(int i, int i2) {
        try {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_FRS_MOVE_AREA);
            JSONArray jSONArray = new JSONArray();
            for (bw bwVar : crx().crB()) {
                if (bwVar != null) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("thread_id", bwVar.getId());
                    jSONObject.put("from_tab_id", bwVar.getTabId());
                    jSONObject.put("to_tab_id", i2);
                    jSONArray.put(jSONObject);
                }
            }
            httpMessage.addParam("threads", jSONArray.toString());
            httpMessage.addParam("forum_id", crx().getForumId());
            MessageManager.getInstance().sendMessage(httpMessage);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void crC() {
        if (!com.baidu.tbadk.core.util.y.isEmpty(this.inz)) {
            this.inz.clear();
            if (this.inE != null) {
                this.inE.ci(this.inz.size(), 2);
            }
        }
    }

    public void clearData() {
        for (bw bwVar : this.inz) {
            if (bwVar != null) {
                bwVar.iv(false);
            }
        }
        this.inz.clear();
        if (this.inE != null) {
            this.inE.ci(0, 2);
        }
    }

    public void reset() {
        S(false, false);
        clearData();
    }

    public void destory() {
        this.mForumId = null;
        this.inB = -1;
        if (this.inC != null) {
            this.inC.clear();
        }
        if (this.inD != null) {
            this.inD.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.frs.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0694a {
        private static a inF = new a();
    }
}
