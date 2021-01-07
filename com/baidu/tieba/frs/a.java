package com.baidu.tieba.frs;

import android.util.SparseArray;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.FrsTabInfo;
/* loaded from: classes.dex */
public class a {
    private final List<bz> jdM;
    private boolean jdN;
    private int jdO;
    private List<FrsTabInfo> jdP;
    private SparseArray<FrsTabInfo> jdQ;
    private av jdR;
    private String mForumId;

    private a() {
        this.jdO = -1;
        this.jdM = new ArrayList();
    }

    public static a cDR() {
        return C0739a.jdS;
    }

    public boolean cDS() {
        return this.jdN;
    }

    public void setForumId(String str) {
        this.mForumId = str;
    }

    public String getForumId() {
        return this.mForumId;
    }

    public void zO(int i) {
        this.jdO = i;
    }

    public int cDT() {
        return this.jdO;
    }

    public void dm(List<FrsTabInfo> list) {
        this.jdP = new ArrayList(list);
        this.jdQ = new SparseArray<>();
        for (FrsTabInfo frsTabInfo : this.jdP) {
            if (frsTabInfo != null) {
                this.jdQ.append(frsTabInfo.tab_id.intValue(), frsTabInfo);
            }
        }
    }

    public List<FrsTabInfo> cDU() {
        return this.jdP;
    }

    public List<bz> cDV() {
        return this.jdM;
    }

    public boolean zP(int i) {
        return this.jdQ.get(i) != null && this.jdQ.get(i).is_general_tab.intValue() == 1;
    }

    public void a(av avVar) {
        this.jdR = avVar;
    }

    public void X(boolean z, boolean z2) {
        this.jdN = z;
        if (this.jdR != null) {
            this.jdR.e(this.jdN, z2, 2);
        }
    }

    public boolean al(bz bzVar) {
        if (bzVar == null) {
            return false;
        }
        if (this.jdM.size() > 29) {
            if (this.jdR != null) {
                this.jdR.zX(2);
                return false;
            }
            return false;
        }
        this.jdM.add(bzVar);
        if (this.jdR != null) {
            this.jdR.co(this.jdM.size(), 2);
        }
        return true;
    }

    public void am(bz bzVar) {
        this.jdM.remove(bzVar);
        if (this.jdR != null) {
            this.jdR.co(this.jdM.size(), 2);
        }
    }

    public void cn(int i, int i2) {
        try {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_FRS_MOVE_AREA);
            JSONArray jSONArray = new JSONArray();
            for (bz bzVar : cDR().cDV()) {
                if (bzVar != null) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("thread_id", bzVar.getId());
                    jSONObject.put("from_tab_id", bzVar.getTabId());
                    jSONObject.put("to_tab_id", i2);
                    jSONArray.put(jSONObject);
                }
            }
            httpMessage.addParam("threads", jSONArray.toString());
            httpMessage.addParam("forum_id", cDR().getForumId());
            MessageManager.getInstance().sendMessage(httpMessage);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void cDW() {
        if (!com.baidu.tbadk.core.util.x.isEmpty(this.jdM)) {
            this.jdM.clear();
            if (this.jdR != null) {
                this.jdR.co(this.jdM.size(), 2);
            }
        }
    }

    public void clearData() {
        for (bz bzVar : this.jdM) {
            if (bzVar != null) {
                bzVar.jD(false);
            }
        }
        this.jdM.clear();
        if (this.jdR != null) {
            this.jdR.co(0, 2);
        }
    }

    public void reset() {
        X(false, false);
        clearData();
    }

    public void destory() {
        this.mForumId = null;
        this.jdO = -1;
        if (this.jdP != null) {
            this.jdP.clear();
        }
        if (this.jdQ != null) {
            this.jdQ.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.frs.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0739a {
        private static a jdS = new a();
    }
}
