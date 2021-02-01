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
    private final List<cb> jeM;
    private boolean jeN;
    private int jeO;
    private List<FrsTabInfo> jeP;
    private SparseArray<FrsTabInfo> jeQ;
    private av jeR;
    private String mForumId;

    private a() {
        this.jeO = -1;
        this.jeM = new ArrayList();
    }

    public static a cBk() {
        return C0722a.jeS;
    }

    public boolean cBl() {
        return this.jeN;
    }

    public void setForumId(String str) {
        this.mForumId = str;
    }

    public String getForumId() {
        return this.mForumId;
    }

    public void ys(int i) {
        this.jeO = i;
    }

    public int cBm() {
        return this.jeO;
    }

    public void dh(List<FrsTabInfo> list) {
        this.jeP = new ArrayList(list);
        this.jeQ = new SparseArray<>();
        for (FrsTabInfo frsTabInfo : this.jeP) {
            if (frsTabInfo != null) {
                this.jeQ.append(frsTabInfo.tab_id.intValue(), frsTabInfo);
            }
        }
    }

    public List<FrsTabInfo> cBn() {
        return this.jeP;
    }

    public List<cb> cBo() {
        return this.jeM;
    }

    public boolean yt(int i) {
        return this.jeQ.get(i) != null && this.jeQ.get(i).is_general_tab.intValue() == 1;
    }

    public void a(av avVar) {
        this.jeR = avVar;
    }

    public void X(boolean z, boolean z2) {
        this.jeN = z;
        if (this.jeR != null) {
            this.jeR.g(this.jeN, z2, 2);
        }
    }

    public boolean am(cb cbVar) {
        if (cbVar == null) {
            return false;
        }
        if (this.jeM.size() > 29) {
            if (this.jeR != null) {
                this.jeR.yB(2);
                return false;
            }
            return false;
        }
        this.jeM.add(cbVar);
        if (this.jeR != null) {
            this.jeR.cl(this.jeM.size(), 2);
        }
        return true;
    }

    public void an(cb cbVar) {
        this.jeM.remove(cbVar);
        if (this.jeR != null) {
            this.jeR.cl(this.jeM.size(), 2);
        }
    }

    public void ck(int i, int i2) {
        try {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_FRS_MOVE_AREA);
            JSONArray jSONArray = new JSONArray();
            for (cb cbVar : cBk().cBo()) {
                if (cbVar != null) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("thread_id", cbVar.getId());
                    jSONObject.put("from_tab_id", cbVar.getTabId());
                    jSONObject.put("to_tab_id", i2);
                    jSONArray.put(jSONObject);
                }
            }
            httpMessage.addParam("threads", jSONArray.toString());
            httpMessage.addParam("forum_id", cBk().getForumId());
            MessageManager.getInstance().sendMessage(httpMessage);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void cBp() {
        if (!com.baidu.tbadk.core.util.y.isEmpty(this.jeM)) {
            this.jeM.clear();
            if (this.jeR != null) {
                this.jeR.cl(this.jeM.size(), 2);
            }
        }
    }

    public void clearData() {
        for (cb cbVar : this.jeM) {
            if (cbVar != null) {
                cbVar.jB(false);
            }
        }
        this.jeM.clear();
        if (this.jeR != null) {
            this.jeR.cl(0, 2);
        }
    }

    public void reset() {
        X(false, false);
        clearData();
    }

    public void destory() {
        this.mForumId = null;
        this.jeO = -1;
        if (this.jeP != null) {
            this.jeP.clear();
        }
        if (this.jeQ != null) {
            this.jeQ.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.frs.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0722a {
        private static a jeS = new a();
    }
}
