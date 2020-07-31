package com.baidu.tieba.frs;

import android.util.SparseArray;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.FrsTabInfo;
/* loaded from: classes.dex */
public class a {
    private final List<bv> hEe;
    private boolean hEf;
    private int hEg;
    private List<FrsTabInfo> hEh;
    private SparseArray<FrsTabInfo> hEi;
    private aw hEj;
    private String mForumId;

    private a() {
        this.hEg = -1;
        this.hEe = new ArrayList();
    }

    public static a cap() {
        return C0628a.hEk;
    }

    public boolean caq() {
        return this.hEf;
    }

    public void setForumId(String str) {
        this.mForumId = str;
    }

    public String getForumId() {
        return this.mForumId;
    }

    public void uy(int i) {
        this.hEg = i;
    }

    public int car() {
        return this.hEg;
    }

    public void cz(List<FrsTabInfo> list) {
        this.hEh = new ArrayList(list);
        this.hEi = new SparseArray<>();
        for (FrsTabInfo frsTabInfo : this.hEh) {
            if (frsTabInfo != null) {
                this.hEi.append(frsTabInfo.tab_id.intValue(), frsTabInfo);
            }
        }
    }

    public List<FrsTabInfo> cas() {
        return this.hEh;
    }

    public List<bv> cat() {
        return this.hEe;
    }

    public boolean uz(int i) {
        return this.hEi.get(i) != null && this.hEi.get(i).is_general_tab.intValue() == 1;
    }

    public void a(aw awVar) {
        this.hEj = awVar;
    }

    public void N(boolean z, boolean z2) {
        this.hEf = z;
        if (this.hEj != null) {
            this.hEj.d(this.hEf, z2, 2);
        }
    }

    public boolean ai(bv bvVar) {
        if (bvVar == null) {
            return false;
        }
        if (this.hEe.size() > 29) {
            if (this.hEj != null) {
                this.hEj.uH(2);
                return false;
            }
            return false;
        }
        this.hEe.add(bvVar);
        if (this.hEj != null) {
            this.hEj.bX(this.hEe.size(), 2);
        }
        return true;
    }

    public void aj(bv bvVar) {
        this.hEe.remove(bvVar);
        if (this.hEj != null) {
            this.hEj.bX(this.hEe.size(), 2);
        }
    }

    public void bV(int i, int i2) {
        try {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_FRS_MOVE_AREA);
            JSONArray jSONArray = new JSONArray();
            for (bv bvVar : cap().cat()) {
                if (bvVar != null) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("thread_id", bvVar.getId());
                    jSONObject.put("from_tab_id", bvVar.getTabId());
                    jSONObject.put("to_tab_id", i2);
                    jSONArray.put(jSONObject);
                }
            }
            httpMessage.addParam("threads", jSONArray.toString());
            httpMessage.addParam("forum_id", cap().getForumId());
            MessageManager.getInstance().sendMessage(httpMessage);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void cau() {
        if (!com.baidu.tbadk.core.util.x.isEmpty(this.hEe)) {
            this.hEe.clear();
            if (this.hEj != null) {
                this.hEj.bX(this.hEe.size(), 2);
            }
        }
    }

    public void clearData() {
        for (bv bvVar : this.hEe) {
            if (bvVar != null) {
                bvVar.hF(false);
            }
        }
        this.hEe.clear();
        if (this.hEj != null) {
            this.hEj.bX(0, 2);
        }
    }

    public void reset() {
        N(false, false);
        clearData();
    }

    public void destory() {
        this.mForumId = null;
        this.hEg = -1;
        if (this.hEh != null) {
            this.hEh.clear();
        }
        if (this.hEi != null) {
            this.hEi.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.frs.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0628a {
        private static a hEk = new a();
    }
}
