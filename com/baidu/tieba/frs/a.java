package com.baidu.tieba.frs;

import android.util.SparseArray;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.tbadk.core.data.bx;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.FrsTabInfo;
/* loaded from: classes.dex */
public class a {
    private final List<bx> iGG;
    private boolean iGH;
    private int iGI;
    private List<FrsTabInfo> iGJ;
    private SparseArray<FrsTabInfo> iGK;
    private ay iGL;
    private String mForumId;

    private a() {
        this.iGI = -1;
        this.iGG = new ArrayList();
    }

    public static a cwH() {
        return C0725a.iGM;
    }

    public boolean cwI() {
        return this.iGH;
    }

    public void setForumId(String str) {
        this.mForumId = str;
    }

    public String getForumId() {
        return this.mForumId;
    }

    public void yW(int i) {
        this.iGI = i;
    }

    public int cwJ() {
        return this.iGI;
    }

    public void db(List<FrsTabInfo> list) {
        this.iGJ = new ArrayList(list);
        this.iGK = new SparseArray<>();
        for (FrsTabInfo frsTabInfo : this.iGJ) {
            if (frsTabInfo != null) {
                this.iGK.append(frsTabInfo.tab_id.intValue(), frsTabInfo);
            }
        }
    }

    public List<FrsTabInfo> cwK() {
        return this.iGJ;
    }

    public List<bx> cwL() {
        return this.iGG;
    }

    public boolean yX(int i) {
        return this.iGK.get(i) != null && this.iGK.get(i).is_general_tab.intValue() == 1;
    }

    public void a(ay ayVar) {
        this.iGL = ayVar;
    }

    public void V(boolean z, boolean z2) {
        this.iGH = z;
        if (this.iGL != null) {
            this.iGL.d(this.iGH, z2, 2);
        }
    }

    public boolean al(bx bxVar) {
        if (bxVar == null) {
            return false;
        }
        if (this.iGG.size() > 29) {
            if (this.iGL != null) {
                this.iGL.zf(2);
                return false;
            }
            return false;
        }
        this.iGG.add(bxVar);
        if (this.iGL != null) {
            this.iGL.cm(this.iGG.size(), 2);
        }
        return true;
    }

    public void am(bx bxVar) {
        this.iGG.remove(bxVar);
        if (this.iGL != null) {
            this.iGL.cm(this.iGG.size(), 2);
        }
    }

    public void ck(int i, int i2) {
        try {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_FRS_MOVE_AREA);
            JSONArray jSONArray = new JSONArray();
            for (bx bxVar : cwH().cwL()) {
                if (bxVar != null) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("thread_id", bxVar.getId());
                    jSONObject.put("from_tab_id", bxVar.getTabId());
                    jSONObject.put("to_tab_id", i2);
                    jSONArray.put(jSONObject);
                }
            }
            httpMessage.addParam("threads", jSONArray.toString());
            httpMessage.addParam("forum_id", cwH().getForumId());
            MessageManager.getInstance().sendMessage(httpMessage);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void cwM() {
        if (!com.baidu.tbadk.core.util.y.isEmpty(this.iGG)) {
            this.iGG.clear();
            if (this.iGL != null) {
                this.iGL.cm(this.iGG.size(), 2);
            }
        }
    }

    public void clearData() {
        for (bx bxVar : this.iGG) {
            if (bxVar != null) {
                bxVar.iS(false);
            }
        }
        this.iGG.clear();
        if (this.iGL != null) {
            this.iGL.cm(0, 2);
        }
    }

    public void reset() {
        V(false, false);
        clearData();
    }

    public void destory() {
        this.mForumId = null;
        this.iGI = -1;
        if (this.iGJ != null) {
            this.iGJ.clear();
        }
        if (this.iGK != null) {
            this.iGK.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.frs.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0725a {
        private static a iGM = new a();
    }
}
