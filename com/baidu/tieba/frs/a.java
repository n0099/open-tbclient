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
/* loaded from: classes2.dex */
public class a {
    private final List<bw> hRs;
    private boolean hRt;
    private int hRu;
    private List<FrsTabInfo> hRv;
    private SparseArray<FrsTabInfo> hRw;
    private ay hRx;
    private String mForumId;

    private a() {
        this.hRu = -1;
        this.hRs = new ArrayList();
    }

    public static a ckL() {
        return C0679a.hRy;
    }

    public boolean ckM() {
        return this.hRt;
    }

    public void setForumId(String str) {
        this.mForumId = str;
    }

    public String getForumId() {
        return this.mForumId;
    }

    public void wN(int i) {
        this.hRu = i;
    }

    public int ckN() {
        return this.hRu;
    }

    public void cB(List<FrsTabInfo> list) {
        this.hRv = new ArrayList(list);
        this.hRw = new SparseArray<>();
        for (FrsTabInfo frsTabInfo : this.hRv) {
            if (frsTabInfo != null) {
                this.hRw.append(frsTabInfo.tab_id.intValue(), frsTabInfo);
            }
        }
    }

    public List<FrsTabInfo> ckO() {
        return this.hRv;
    }

    public List<bw> ckP() {
        return this.hRs;
    }

    public boolean wO(int i) {
        return this.hRw.get(i) != null && this.hRw.get(i).is_general_tab.intValue() == 1;
    }

    public void a(ay ayVar) {
        this.hRx = ayVar;
    }

    public void R(boolean z, boolean z2) {
        this.hRt = z;
        if (this.hRx != null) {
            this.hRx.d(this.hRt, z2, 2);
        }
    }

    public boolean ai(bw bwVar) {
        if (bwVar == null) {
            return false;
        }
        if (this.hRs.size() > 29) {
            if (this.hRx != null) {
                this.hRx.wW(2);
                return false;
            }
            return false;
        }
        this.hRs.add(bwVar);
        if (this.hRx != null) {
            this.hRx.cf(this.hRs.size(), 2);
        }
        return true;
    }

    public void aj(bw bwVar) {
        this.hRs.remove(bwVar);
        if (this.hRx != null) {
            this.hRx.cf(this.hRs.size(), 2);
        }
    }

    public void cd(int i, int i2) {
        try {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_FRS_MOVE_AREA);
            JSONArray jSONArray = new JSONArray();
            for (bw bwVar : ckL().ckP()) {
                if (bwVar != null) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("thread_id", bwVar.getId());
                    jSONObject.put("from_tab_id", bwVar.getTabId());
                    jSONObject.put("to_tab_id", i2);
                    jSONArray.put(jSONObject);
                }
            }
            httpMessage.addParam("threads", jSONArray.toString());
            httpMessage.addParam("forum_id", ckL().getForumId());
            MessageManager.getInstance().sendMessage(httpMessage);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void ckQ() {
        if (!com.baidu.tbadk.core.util.y.isEmpty(this.hRs)) {
            this.hRs.clear();
            if (this.hRx != null) {
                this.hRx.cf(this.hRs.size(), 2);
            }
        }
    }

    public void clearData() {
        for (bw bwVar : this.hRs) {
            if (bwVar != null) {
                bwVar.ib(false);
            }
        }
        this.hRs.clear();
        if (this.hRx != null) {
            this.hRx.cf(0, 2);
        }
    }

    public void reset() {
        R(false, false);
        clearData();
    }

    public void destory() {
        this.mForumId = null;
        this.hRu = -1;
        if (this.hRv != null) {
            this.hRv.clear();
        }
        if (this.hRw != null) {
            this.hRw.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.frs.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0679a {
        private static a hRy = new a();
    }
}
