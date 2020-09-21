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
    private int hYA;
    private List<FrsTabInfo> hYB;
    private SparseArray<FrsTabInfo> hYC;
    private ay hYD;
    private final List<bw> hYy;
    private boolean hYz;
    private String mForumId;

    private a() {
        this.hYA = -1;
        this.hYy = new ArrayList();
    }

    public static a cnZ() {
        return C0676a.hYE;
    }

    public boolean coa() {
        return this.hYz;
    }

    public void setForumId(String str) {
        this.mForumId = str;
    }

    public String getForumId() {
        return this.mForumId;
    }

    public void xm(int i) {
        this.hYA = i;
    }

    public int cob() {
        return this.hYA;
    }

    public void cH(List<FrsTabInfo> list) {
        this.hYB = new ArrayList(list);
        this.hYC = new SparseArray<>();
        for (FrsTabInfo frsTabInfo : this.hYB) {
            if (frsTabInfo != null) {
                this.hYC.append(frsTabInfo.tab_id.intValue(), frsTabInfo);
            }
        }
    }

    public List<FrsTabInfo> coc() {
        return this.hYB;
    }

    public List<bw> cod() {
        return this.hYy;
    }

    public boolean xn(int i) {
        return this.hYC.get(i) != null && this.hYC.get(i).is_general_tab.intValue() == 1;
    }

    public void a(ay ayVar) {
        this.hYD = ayVar;
    }

    public void T(boolean z, boolean z2) {
        this.hYz = z;
        if (this.hYD != null) {
            this.hYD.d(this.hYz, z2, 2);
        }
    }

    public boolean aj(bw bwVar) {
        if (bwVar == null) {
            return false;
        }
        if (this.hYy.size() > 29) {
            if (this.hYD != null) {
                this.hYD.xv(2);
                return false;
            }
            return false;
        }
        this.hYy.add(bwVar);
        if (this.hYD != null) {
            this.hYD.ci(this.hYy.size(), 2);
        }
        return true;
    }

    public void ak(bw bwVar) {
        this.hYy.remove(bwVar);
        if (this.hYD != null) {
            this.hYD.ci(this.hYy.size(), 2);
        }
    }

    public void cg(int i, int i2) {
        try {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_FRS_MOVE_AREA);
            JSONArray jSONArray = new JSONArray();
            for (bw bwVar : cnZ().cod()) {
                if (bwVar != null) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("thread_id", bwVar.getId());
                    jSONObject.put("from_tab_id", bwVar.getTabId());
                    jSONObject.put("to_tab_id", i2);
                    jSONArray.put(jSONObject);
                }
            }
            httpMessage.addParam("threads", jSONArray.toString());
            httpMessage.addParam("forum_id", cnZ().getForumId());
            MessageManager.getInstance().sendMessage(httpMessage);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void coe() {
        if (!com.baidu.tbadk.core.util.y.isEmpty(this.hYy)) {
            this.hYy.clear();
            if (this.hYD != null) {
                this.hYD.ci(this.hYy.size(), 2);
            }
        }
    }

    public void clearData() {
        for (bw bwVar : this.hYy) {
            if (bwVar != null) {
                bwVar.hZ(false);
            }
        }
        this.hYy.clear();
        if (this.hYD != null) {
            this.hYD.ci(0, 2);
        }
    }

    public void reset() {
        T(false, false);
        clearData();
    }

    public void destory() {
        this.mForumId = null;
        this.hYA = -1;
        if (this.hYB != null) {
            this.hYB.clear();
        }
        if (this.hYC != null) {
            this.hYC.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.frs.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0676a {
        private static a hYE = new a();
    }
}
