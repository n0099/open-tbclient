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
    private int hRA;
    private List<FrsTabInfo> hRB;
    private SparseArray<FrsTabInfo> hRC;
    private ay hRD;
    private final List<bw> hRy;
    private boolean hRz;
    private String mForumId;

    private a() {
        this.hRA = -1;
        this.hRy = new ArrayList();
    }

    public static a ckM() {
        return C0679a.hRE;
    }

    public boolean ckN() {
        return this.hRz;
    }

    public void setForumId(String str) {
        this.mForumId = str;
    }

    public String getForumId() {
        return this.mForumId;
    }

    public void wN(int i) {
        this.hRA = i;
    }

    public int ckO() {
        return this.hRA;
    }

    public void cB(List<FrsTabInfo> list) {
        this.hRB = new ArrayList(list);
        this.hRC = new SparseArray<>();
        for (FrsTabInfo frsTabInfo : this.hRB) {
            if (frsTabInfo != null) {
                this.hRC.append(frsTabInfo.tab_id.intValue(), frsTabInfo);
            }
        }
    }

    public List<FrsTabInfo> ckP() {
        return this.hRB;
    }

    public List<bw> ckQ() {
        return this.hRy;
    }

    public boolean wO(int i) {
        return this.hRC.get(i) != null && this.hRC.get(i).is_general_tab.intValue() == 1;
    }

    public void a(ay ayVar) {
        this.hRD = ayVar;
    }

    public void R(boolean z, boolean z2) {
        this.hRz = z;
        if (this.hRD != null) {
            this.hRD.d(this.hRz, z2, 2);
        }
    }

    public boolean ai(bw bwVar) {
        if (bwVar == null) {
            return false;
        }
        if (this.hRy.size() > 29) {
            if (this.hRD != null) {
                this.hRD.wW(2);
                return false;
            }
            return false;
        }
        this.hRy.add(bwVar);
        if (this.hRD != null) {
            this.hRD.cf(this.hRy.size(), 2);
        }
        return true;
    }

    public void aj(bw bwVar) {
        this.hRy.remove(bwVar);
        if (this.hRD != null) {
            this.hRD.cf(this.hRy.size(), 2);
        }
    }

    public void cd(int i, int i2) {
        try {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_FRS_MOVE_AREA);
            JSONArray jSONArray = new JSONArray();
            for (bw bwVar : ckM().ckQ()) {
                if (bwVar != null) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("thread_id", bwVar.getId());
                    jSONObject.put("from_tab_id", bwVar.getTabId());
                    jSONObject.put("to_tab_id", i2);
                    jSONArray.put(jSONObject);
                }
            }
            httpMessage.addParam("threads", jSONArray.toString());
            httpMessage.addParam("forum_id", ckM().getForumId());
            MessageManager.getInstance().sendMessage(httpMessage);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void ckR() {
        if (!com.baidu.tbadk.core.util.y.isEmpty(this.hRy)) {
            this.hRy.clear();
            if (this.hRD != null) {
                this.hRD.cf(this.hRy.size(), 2);
            }
        }
    }

    public void clearData() {
        for (bw bwVar : this.hRy) {
            if (bwVar != null) {
                bwVar.ic(false);
            }
        }
        this.hRy.clear();
        if (this.hRD != null) {
            this.hRD.cf(0, 2);
        }
    }

    public void reset() {
        R(false, false);
        clearData();
    }

    public void destory() {
        this.mForumId = null;
        this.hRA = -1;
        if (this.hRB != null) {
            this.hRB.clear();
        }
        if (this.hRC != null) {
            this.hRC.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.frs.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0679a {
        private static a hRE = new a();
    }
}
