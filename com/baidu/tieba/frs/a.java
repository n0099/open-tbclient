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
    private final List<bw> iFS;
    private boolean iFT;
    private int iFU;
    private List<FrsTabInfo> iFV;
    private SparseArray<FrsTabInfo> iFW;
    private ay iFX;
    private String mForumId;

    private a() {
        this.iFU = -1;
        this.iFS = new ArrayList();
    }

    public static a cxf() {
        return C0724a.iFY;
    }

    public boolean cxg() {
        return this.iFT;
    }

    public void setForumId(String str) {
        this.mForumId = str;
    }

    public String getForumId() {
        return this.mForumId;
    }

    public void yy(int i) {
        this.iFU = i;
    }

    public int cxh() {
        return this.iFU;
    }

    public void db(List<FrsTabInfo> list) {
        this.iFV = new ArrayList(list);
        this.iFW = new SparseArray<>();
        for (FrsTabInfo frsTabInfo : this.iFV) {
            if (frsTabInfo != null) {
                this.iFW.append(frsTabInfo.tab_id.intValue(), frsTabInfo);
            }
        }
    }

    public List<FrsTabInfo> cxi() {
        return this.iFV;
    }

    public List<bw> cxj() {
        return this.iFS;
    }

    public boolean yz(int i) {
        return this.iFW.get(i) != null && this.iFW.get(i).is_general_tab.intValue() == 1;
    }

    public void a(ay ayVar) {
        this.iFX = ayVar;
    }

    public void V(boolean z, boolean z2) {
        this.iFT = z;
        if (this.iFX != null) {
            this.iFX.d(this.iFT, z2, 2);
        }
    }

    public boolean aj(bw bwVar) {
        if (bwVar == null) {
            return false;
        }
        if (this.iFS.size() > 29) {
            if (this.iFX != null) {
                this.iFX.yH(2);
                return false;
            }
            return false;
        }
        this.iFS.add(bwVar);
        if (this.iFX != null) {
            this.iFX.cm(this.iFS.size(), 2);
        }
        return true;
    }

    public void ak(bw bwVar) {
        this.iFS.remove(bwVar);
        if (this.iFX != null) {
            this.iFX.cm(this.iFS.size(), 2);
        }
    }

    public void ck(int i, int i2) {
        try {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_FRS_MOVE_AREA);
            JSONArray jSONArray = new JSONArray();
            for (bw bwVar : cxf().cxj()) {
                if (bwVar != null) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("thread_id", bwVar.getId());
                    jSONObject.put("from_tab_id", bwVar.getTabId());
                    jSONObject.put("to_tab_id", i2);
                    jSONArray.put(jSONObject);
                }
            }
            httpMessage.addParam("threads", jSONArray.toString());
            httpMessage.addParam("forum_id", cxf().getForumId());
            MessageManager.getInstance().sendMessage(httpMessage);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void cxk() {
        if (!com.baidu.tbadk.core.util.y.isEmpty(this.iFS)) {
            this.iFS.clear();
            if (this.iFX != null) {
                this.iFX.cm(this.iFS.size(), 2);
            }
        }
    }

    public void clearData() {
        for (bw bwVar : this.iFS) {
            if (bwVar != null) {
                bwVar.iR(false);
            }
        }
        this.iFS.clear();
        if (this.iFX != null) {
            this.iFX.cm(0, 2);
        }
    }

    public void reset() {
        V(false, false);
        clearData();
    }

    public void destory() {
        this.mForumId = null;
        this.iFU = -1;
        if (this.iFV != null) {
            this.iFV.clear();
        }
        if (this.iFW != null) {
            this.iFW.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.frs.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0724a {
        private static a iFY = new a();
    }
}
