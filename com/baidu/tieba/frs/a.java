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
    private ay iAa;
    private final List<bw> izV;
    private boolean izW;
    private int izX;
    private List<FrsTabInfo> izY;
    private SparseArray<FrsTabInfo> izZ;
    private String mForumId;

    private a() {
        this.izX = -1;
        this.izV = new ArrayList();
    }

    public static a cuE() {
        return C0710a.iAb;
    }

    public boolean cuF() {
        return this.izW;
    }

    public void setForumId(String str) {
        this.mForumId = str;
    }

    public String getForumId() {
        return this.mForumId;
    }

    public void yl(int i) {
        this.izX = i;
    }

    public int cuG() {
        return this.izX;
    }

    public void cT(List<FrsTabInfo> list) {
        this.izY = new ArrayList(list);
        this.izZ = new SparseArray<>();
        for (FrsTabInfo frsTabInfo : this.izY) {
            if (frsTabInfo != null) {
                this.izZ.append(frsTabInfo.tab_id.intValue(), frsTabInfo);
            }
        }
    }

    public List<FrsTabInfo> cuH() {
        return this.izY;
    }

    public List<bw> cuI() {
        return this.izV;
    }

    public boolean ym(int i) {
        return this.izZ.get(i) != null && this.izZ.get(i).is_general_tab.intValue() == 1;
    }

    public void a(ay ayVar) {
        this.iAa = ayVar;
    }

    public void V(boolean z, boolean z2) {
        this.izW = z;
        if (this.iAa != null) {
            this.iAa.d(this.izW, z2, 2);
        }
    }

    public boolean aj(bw bwVar) {
        if (bwVar == null) {
            return false;
        }
        if (this.izV.size() > 29) {
            if (this.iAa != null) {
                this.iAa.yu(2);
                return false;
            }
            return false;
        }
        this.izV.add(bwVar);
        if (this.iAa != null) {
            this.iAa.ck(this.izV.size(), 2);
        }
        return true;
    }

    public void ak(bw bwVar) {
        this.izV.remove(bwVar);
        if (this.iAa != null) {
            this.iAa.ck(this.izV.size(), 2);
        }
    }

    public void ci(int i, int i2) {
        try {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_FRS_MOVE_AREA);
            JSONArray jSONArray = new JSONArray();
            for (bw bwVar : cuE().cuI()) {
                if (bwVar != null) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("thread_id", bwVar.getId());
                    jSONObject.put("from_tab_id", bwVar.getTabId());
                    jSONObject.put("to_tab_id", i2);
                    jSONArray.put(jSONObject);
                }
            }
            httpMessage.addParam("threads", jSONArray.toString());
            httpMessage.addParam("forum_id", cuE().getForumId());
            MessageManager.getInstance().sendMessage(httpMessage);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void cuJ() {
        if (!com.baidu.tbadk.core.util.y.isEmpty(this.izV)) {
            this.izV.clear();
            if (this.iAa != null) {
                this.iAa.ck(this.izV.size(), 2);
            }
        }
    }

    public void clearData() {
        for (bw bwVar : this.izV) {
            if (bwVar != null) {
                bwVar.iI(false);
            }
        }
        this.izV.clear();
        if (this.iAa != null) {
            this.iAa.ck(0, 2);
        }
    }

    public void reset() {
        V(false, false);
        clearData();
    }

    public void destory() {
        this.mForumId = null;
        this.izX = -1;
        if (this.izY != null) {
            this.izY.clear();
        }
        if (this.izZ != null) {
            this.izZ.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.frs.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0710a {
        private static a iAb = new a();
    }
}
