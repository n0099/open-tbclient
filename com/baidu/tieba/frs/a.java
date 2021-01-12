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
    private final List<bz> iZf;
    private boolean iZg;
    private int iZh;
    private List<FrsTabInfo> iZi;
    private SparseArray<FrsTabInfo> iZj;
    private av iZk;
    private String mForumId;

    private a() {
        this.iZh = -1;
        this.iZf = new ArrayList();
    }

    public static a czZ() {
        return C0722a.iZl;
    }

    public boolean cAa() {
        return this.iZg;
    }

    public void setForumId(String str) {
        this.mForumId = str;
    }

    public String getForumId() {
        return this.mForumId;
    }

    public void yi(int i) {
        this.iZh = i;
    }

    public int cAb() {
        return this.iZh;
    }

    public void dm(List<FrsTabInfo> list) {
        this.iZi = new ArrayList(list);
        this.iZj = new SparseArray<>();
        for (FrsTabInfo frsTabInfo : this.iZi) {
            if (frsTabInfo != null) {
                this.iZj.append(frsTabInfo.tab_id.intValue(), frsTabInfo);
            }
        }
    }

    public List<FrsTabInfo> cAc() {
        return this.iZi;
    }

    public List<bz> cAd() {
        return this.iZf;
    }

    public boolean yj(int i) {
        return this.iZj.get(i) != null && this.iZj.get(i).is_general_tab.intValue() == 1;
    }

    public void a(av avVar) {
        this.iZk = avVar;
    }

    public void X(boolean z, boolean z2) {
        this.iZg = z;
        if (this.iZk != null) {
            this.iZk.e(this.iZg, z2, 2);
        }
    }

    public boolean al(bz bzVar) {
        if (bzVar == null) {
            return false;
        }
        if (this.iZf.size() > 29) {
            if (this.iZk != null) {
                this.iZk.yr(2);
                return false;
            }
            return false;
        }
        this.iZf.add(bzVar);
        if (this.iZk != null) {
            this.iZk.co(this.iZf.size(), 2);
        }
        return true;
    }

    public void am(bz bzVar) {
        this.iZf.remove(bzVar);
        if (this.iZk != null) {
            this.iZk.co(this.iZf.size(), 2);
        }
    }

    public void cn(int i, int i2) {
        try {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_FRS_MOVE_AREA);
            JSONArray jSONArray = new JSONArray();
            for (bz bzVar : czZ().cAd()) {
                if (bzVar != null) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("thread_id", bzVar.getId());
                    jSONObject.put("from_tab_id", bzVar.getTabId());
                    jSONObject.put("to_tab_id", i2);
                    jSONArray.put(jSONObject);
                }
            }
            httpMessage.addParam("threads", jSONArray.toString());
            httpMessage.addParam("forum_id", czZ().getForumId());
            MessageManager.getInstance().sendMessage(httpMessage);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void cAe() {
        if (!com.baidu.tbadk.core.util.x.isEmpty(this.iZf)) {
            this.iZf.clear();
            if (this.iZk != null) {
                this.iZk.co(this.iZf.size(), 2);
            }
        }
    }

    public void clearData() {
        for (bz bzVar : this.iZf) {
            if (bzVar != null) {
                bzVar.jz(false);
            }
        }
        this.iZf.clear();
        if (this.iZk != null) {
            this.iZk.co(0, 2);
        }
    }

    public void reset() {
        X(false, false);
        clearData();
    }

    public void destory() {
        this.mForumId = null;
        this.iZh = -1;
        if (this.iZi != null) {
            this.iZi.clear();
        }
        if (this.iZj != null) {
            this.iZj.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.frs.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0722a {
        private static a iZl = new a();
    }
}
