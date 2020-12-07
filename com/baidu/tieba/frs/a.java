package com.baidu.tieba.frs;

import android.util.SparseArray;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.tbadk.core.data.by;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.FrsTabInfo;
/* loaded from: classes.dex */
public class a {
    private int iRA;
    private List<FrsTabInfo> iRB;
    private SparseArray<FrsTabInfo> iRC;
    private ay iRD;
    private final List<by> iRy;
    private boolean iRz;
    private String mForumId;

    private a() {
        this.iRA = -1;
        this.iRy = new ArrayList();
    }

    public static a cAW() {
        return C0739a.iRE;
    }

    public boolean cAX() {
        return this.iRz;
    }

    public void setForumId(String str) {
        this.mForumId = str;
    }

    public String getForumId() {
        return this.mForumId;
    }

    public void zB(int i) {
        this.iRA = i;
    }

    public int cAY() {
        return this.iRA;
    }

    public void df(List<FrsTabInfo> list) {
        this.iRB = new ArrayList(list);
        this.iRC = new SparseArray<>();
        for (FrsTabInfo frsTabInfo : this.iRB) {
            if (frsTabInfo != null) {
                this.iRC.append(frsTabInfo.tab_id.intValue(), frsTabInfo);
            }
        }
    }

    public List<FrsTabInfo> cAZ() {
        return this.iRB;
    }

    public List<by> cBa() {
        return this.iRy;
    }

    public boolean zC(int i) {
        return this.iRC.get(i) != null && this.iRC.get(i).is_general_tab.intValue() == 1;
    }

    public void a(ay ayVar) {
        this.iRD = ayVar;
    }

    public void V(boolean z, boolean z2) {
        this.iRz = z;
        if (this.iRD != null) {
            this.iRD.d(this.iRz, z2, 2);
        }
    }

    public boolean al(by byVar) {
        if (byVar == null) {
            return false;
        }
        if (this.iRy.size() > 29) {
            if (this.iRD != null) {
                this.iRD.zK(2);
                return false;
            }
            return false;
        }
        this.iRy.add(byVar);
        if (this.iRD != null) {
            this.iRD.cq(this.iRy.size(), 2);
        }
        return true;
    }

    public void am(by byVar) {
        this.iRy.remove(byVar);
        if (this.iRD != null) {
            this.iRD.cq(this.iRy.size(), 2);
        }
    }

    public void co(int i, int i2) {
        try {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_FRS_MOVE_AREA);
            JSONArray jSONArray = new JSONArray();
            for (by byVar : cAW().cBa()) {
                if (byVar != null) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("thread_id", byVar.getId());
                    jSONObject.put("from_tab_id", byVar.getTabId());
                    jSONObject.put("to_tab_id", i2);
                    jSONArray.put(jSONObject);
                }
            }
            httpMessage.addParam("threads", jSONArray.toString());
            httpMessage.addParam("forum_id", cAW().getForumId());
            MessageManager.getInstance().sendMessage(httpMessage);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void cBb() {
        if (!com.baidu.tbadk.core.util.y.isEmpty(this.iRy)) {
            this.iRy.clear();
            if (this.iRD != null) {
                this.iRD.cq(this.iRy.size(), 2);
            }
        }
    }

    public void clearData() {
        for (by byVar : this.iRy) {
            if (byVar != null) {
                byVar.jh(false);
            }
        }
        this.iRy.clear();
        if (this.iRD != null) {
            this.iRD.cq(0, 2);
        }
    }

    public void reset() {
        V(false, false);
        clearData();
    }

    public void destory() {
        this.mForumId = null;
        this.iRA = -1;
        if (this.iRB != null) {
            this.iRB.clear();
        }
        if (this.iRC != null) {
            this.iRC.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.frs.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0739a {
        private static a iRE = new a();
    }
}
