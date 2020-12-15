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
    private final List<by> iRA;
    private boolean iRB;
    private int iRC;
    private List<FrsTabInfo> iRD;
    private SparseArray<FrsTabInfo> iRE;
    private ay iRF;
    private String mForumId;

    private a() {
        this.iRC = -1;
        this.iRA = new ArrayList();
    }

    public static a cAX() {
        return C0739a.iRG;
    }

    public boolean cAY() {
        return this.iRB;
    }

    public void setForumId(String str) {
        this.mForumId = str;
    }

    public String getForumId() {
        return this.mForumId;
    }

    public void zB(int i) {
        this.iRC = i;
    }

    public int cAZ() {
        return this.iRC;
    }

    public void df(List<FrsTabInfo> list) {
        this.iRD = new ArrayList(list);
        this.iRE = new SparseArray<>();
        for (FrsTabInfo frsTabInfo : this.iRD) {
            if (frsTabInfo != null) {
                this.iRE.append(frsTabInfo.tab_id.intValue(), frsTabInfo);
            }
        }
    }

    public List<FrsTabInfo> cBa() {
        return this.iRD;
    }

    public List<by> cBb() {
        return this.iRA;
    }

    public boolean zC(int i) {
        return this.iRE.get(i) != null && this.iRE.get(i).is_general_tab.intValue() == 1;
    }

    public void a(ay ayVar) {
        this.iRF = ayVar;
    }

    public void V(boolean z, boolean z2) {
        this.iRB = z;
        if (this.iRF != null) {
            this.iRF.d(this.iRB, z2, 2);
        }
    }

    public boolean al(by byVar) {
        if (byVar == null) {
            return false;
        }
        if (this.iRA.size() > 29) {
            if (this.iRF != null) {
                this.iRF.zK(2);
                return false;
            }
            return false;
        }
        this.iRA.add(byVar);
        if (this.iRF != null) {
            this.iRF.cq(this.iRA.size(), 2);
        }
        return true;
    }

    public void am(by byVar) {
        this.iRA.remove(byVar);
        if (this.iRF != null) {
            this.iRF.cq(this.iRA.size(), 2);
        }
    }

    public void co(int i, int i2) {
        try {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_FRS_MOVE_AREA);
            JSONArray jSONArray = new JSONArray();
            for (by byVar : cAX().cBb()) {
                if (byVar != null) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("thread_id", byVar.getId());
                    jSONObject.put("from_tab_id", byVar.getTabId());
                    jSONObject.put("to_tab_id", i2);
                    jSONArray.put(jSONObject);
                }
            }
            httpMessage.addParam("threads", jSONArray.toString());
            httpMessage.addParam("forum_id", cAX().getForumId());
            MessageManager.getInstance().sendMessage(httpMessage);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void cBc() {
        if (!com.baidu.tbadk.core.util.y.isEmpty(this.iRA)) {
            this.iRA.clear();
            if (this.iRF != null) {
                this.iRF.cq(this.iRA.size(), 2);
            }
        }
    }

    public void clearData() {
        for (by byVar : this.iRA) {
            if (byVar != null) {
                byVar.jh(false);
            }
        }
        this.iRA.clear();
        if (this.iRF != null) {
            this.iRF.cq(0, 2);
        }
    }

    public void reset() {
        V(false, false);
        clearData();
    }

    public void destory() {
        this.mForumId = null;
        this.iRC = -1;
        if (this.iRD != null) {
            this.iRD.clear();
        }
        if (this.iRE != null) {
            this.iRE.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.frs.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0739a {
        private static a iRG = new a();
    }
}
