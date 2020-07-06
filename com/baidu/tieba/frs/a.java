package com.baidu.tieba.frs;

import android.util.SparseArray;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.tbadk.core.data.bu;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.FrsTabInfo;
/* loaded from: classes.dex */
public class a {
    private final List<bu> hyq;
    private boolean hyr;
    private int hys;
    private List<FrsTabInfo> hyt;
    private SparseArray<FrsTabInfo> hyu;
    private aw hyv;
    private String mForumId;

    private a() {
        this.hys = -1;
        this.hyq = new ArrayList();
    }

    public static a bWW() {
        return C0619a.hyw;
    }

    public boolean bWX() {
        return this.hyr;
    }

    public void setForumId(String str) {
        this.mForumId = str;
    }

    public String getForumId() {
        return this.mForumId;
    }

    public void ug(int i) {
        this.hys = i;
    }

    public int bWY() {
        return this.hys;
    }

    public void cu(List<FrsTabInfo> list) {
        this.hyt = new ArrayList(list);
        this.hyu = new SparseArray<>();
        for (FrsTabInfo frsTabInfo : this.hyt) {
            if (frsTabInfo != null) {
                this.hyu.append(frsTabInfo.tab_id.intValue(), frsTabInfo);
            }
        }
    }

    public List<FrsTabInfo> bWZ() {
        return this.hyt;
    }

    public List<bu> bXa() {
        return this.hyq;
    }

    public boolean uh(int i) {
        return this.hyu.get(i) != null && this.hyu.get(i).is_general_tab.intValue() == 1;
    }

    public void a(aw awVar) {
        this.hyv = awVar;
    }

    public void M(boolean z, boolean z2) {
        this.hyr = z;
        if (this.hyv != null) {
            this.hyv.d(this.hyr, z2, 2);
        }
    }

    public boolean al(bu buVar) {
        if (buVar == null) {
            return false;
        }
        if (this.hyq.size() > 29) {
            if (this.hyv != null) {
                this.hyv.up(2);
                return false;
            }
            return false;
        }
        this.hyq.add(buVar);
        if (this.hyv != null) {
            this.hyv.bT(this.hyq.size(), 2);
        }
        return true;
    }

    public void am(bu buVar) {
        this.hyq.remove(buVar);
        if (this.hyv != null) {
            this.hyv.bT(this.hyq.size(), 2);
        }
    }

    public void bS(int i, int i2) {
        try {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_FRS_MOVE_AREA);
            JSONArray jSONArray = new JSONArray();
            for (bu buVar : bWW().bXa()) {
                if (buVar != null) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("thread_id", buVar.getId());
                    jSONObject.put("from_tab_id", buVar.getTabId());
                    jSONObject.put("to_tab_id", i2);
                    jSONArray.put(jSONObject);
                }
            }
            httpMessage.addParam("threads", jSONArray.toString());
            httpMessage.addParam("forum_id", bWW().getForumId());
            MessageManager.getInstance().sendMessage(httpMessage);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void bXb() {
        if (!com.baidu.tbadk.core.util.w.isEmpty(this.hyq)) {
            this.hyq.clear();
            if (this.hyv != null) {
                this.hyv.bT(this.hyq.size(), 2);
            }
        }
    }

    public void clearData() {
        for (bu buVar : this.hyq) {
            if (buVar != null) {
                buVar.hb(false);
            }
        }
        this.hyq.clear();
        if (this.hyv != null) {
            this.hyv.bT(0, 2);
        }
    }

    public void reset() {
        M(false, false);
        clearData();
    }

    public void destory() {
        this.mForumId = null;
        this.hys = -1;
        if (this.hyt != null) {
            this.hyt.clear();
        }
        if (this.hyu != null) {
            this.hyu.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.frs.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0619a {
        private static a hyw = new a();
    }
}
