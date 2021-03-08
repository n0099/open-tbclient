package com.baidu.tieba.frs;

import android.util.SparseArray;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.FrsTabInfo;
/* loaded from: classes.dex */
public class a {
    private final List<cb> jgJ;
    private boolean jgK;
    private int jgL;
    private List<FrsTabInfo> jgM;
    private SparseArray<FrsTabInfo> jgN;
    private av jgO;
    private String mForumId;

    private a() {
        this.jgL = -1;
        this.jgJ = new ArrayList();
    }

    public static a cBx() {
        return C0729a.jgP;
    }

    public boolean cBy() {
        return this.jgK;
    }

    public void setForumId(String str) {
        this.mForumId = str;
    }

    public String getForumId() {
        return this.mForumId;
    }

    public void yt(int i) {
        this.jgL = i;
    }

    public int cBz() {
        return this.jgL;
    }

    public void dh(List<FrsTabInfo> list) {
        this.jgM = new ArrayList(list);
        this.jgN = new SparseArray<>();
        for (FrsTabInfo frsTabInfo : this.jgM) {
            if (frsTabInfo != null) {
                this.jgN.append(frsTabInfo.tab_id.intValue(), frsTabInfo);
            }
        }
    }

    public List<FrsTabInfo> cBA() {
        return this.jgM;
    }

    public List<cb> cBB() {
        return this.jgJ;
    }

    public boolean yu(int i) {
        return this.jgN.get(i) != null && this.jgN.get(i).is_general_tab.intValue() == 1;
    }

    public void a(av avVar) {
        this.jgO = avVar;
    }

    public void X(boolean z, boolean z2) {
        this.jgK = z;
        if (this.jgO != null) {
            this.jgO.g(this.jgK, z2, 2);
        }
    }

    public boolean am(cb cbVar) {
        if (cbVar == null) {
            return false;
        }
        if (this.jgJ.size() > 29) {
            if (this.jgO != null) {
                this.jgO.yC(2);
                return false;
            }
            return false;
        }
        this.jgJ.add(cbVar);
        if (this.jgO != null) {
            this.jgO.cm(this.jgJ.size(), 2);
        }
        return true;
    }

    public void an(cb cbVar) {
        this.jgJ.remove(cbVar);
        if (this.jgO != null) {
            this.jgO.cm(this.jgJ.size(), 2);
        }
    }

    public void cl(int i, int i2) {
        try {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_FRS_MOVE_AREA);
            JSONArray jSONArray = new JSONArray();
            for (cb cbVar : cBx().cBB()) {
                if (cbVar != null) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("thread_id", cbVar.getId());
                    jSONObject.put("from_tab_id", cbVar.getTabId());
                    jSONObject.put("to_tab_id", i2);
                    jSONArray.put(jSONObject);
                }
            }
            httpMessage.addParam("threads", jSONArray.toString());
            httpMessage.addParam("forum_id", cBx().getForumId());
            MessageManager.getInstance().sendMessage(httpMessage);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void cBC() {
        if (!com.baidu.tbadk.core.util.y.isEmpty(this.jgJ)) {
            this.jgJ.clear();
            if (this.jgO != null) {
                this.jgO.cm(this.jgJ.size(), 2);
            }
        }
    }

    public void clearData() {
        for (cb cbVar : this.jgJ) {
            if (cbVar != null) {
                cbVar.jB(false);
            }
        }
        this.jgJ.clear();
        if (this.jgO != null) {
            this.jgO.cm(0, 2);
        }
    }

    public void reset() {
        X(false, false);
        clearData();
    }

    public void destory() {
        this.mForumId = null;
        this.jgL = -1;
        if (this.jgM != null) {
            this.jgM.clear();
        }
        if (this.jgN != null) {
            this.jgN.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.frs.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0729a {
        private static a jgP = new a();
    }
}
