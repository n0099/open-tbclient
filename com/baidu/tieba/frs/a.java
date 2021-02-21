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
    private final List<cb> jfa;
    private boolean jfb;
    private int jfc;
    private List<FrsTabInfo> jfd;
    private SparseArray<FrsTabInfo> jfe;
    private av jff;
    private String mForumId;

    private a() {
        this.jfc = -1;
        this.jfa = new ArrayList();
    }

    public static a cBr() {
        return C0723a.jfg;
    }

    public boolean cBs() {
        return this.jfb;
    }

    public void setForumId(String str) {
        this.mForumId = str;
    }

    public String getForumId() {
        return this.mForumId;
    }

    public void ys(int i) {
        this.jfc = i;
    }

    public int cBt() {
        return this.jfc;
    }

    public void dh(List<FrsTabInfo> list) {
        this.jfd = new ArrayList(list);
        this.jfe = new SparseArray<>();
        for (FrsTabInfo frsTabInfo : this.jfd) {
            if (frsTabInfo != null) {
                this.jfe.append(frsTabInfo.tab_id.intValue(), frsTabInfo);
            }
        }
    }

    public List<FrsTabInfo> cBu() {
        return this.jfd;
    }

    public List<cb> cBv() {
        return this.jfa;
    }

    public boolean yt(int i) {
        return this.jfe.get(i) != null && this.jfe.get(i).is_general_tab.intValue() == 1;
    }

    public void a(av avVar) {
        this.jff = avVar;
    }

    public void X(boolean z, boolean z2) {
        this.jfb = z;
        if (this.jff != null) {
            this.jff.g(this.jfb, z2, 2);
        }
    }

    public boolean am(cb cbVar) {
        if (cbVar == null) {
            return false;
        }
        if (this.jfa.size() > 29) {
            if (this.jff != null) {
                this.jff.yB(2);
                return false;
            }
            return false;
        }
        this.jfa.add(cbVar);
        if (this.jff != null) {
            this.jff.cm(this.jfa.size(), 2);
        }
        return true;
    }

    public void an(cb cbVar) {
        this.jfa.remove(cbVar);
        if (this.jff != null) {
            this.jff.cm(this.jfa.size(), 2);
        }
    }

    public void cl(int i, int i2) {
        try {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_FRS_MOVE_AREA);
            JSONArray jSONArray = new JSONArray();
            for (cb cbVar : cBr().cBv()) {
                if (cbVar != null) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("thread_id", cbVar.getId());
                    jSONObject.put("from_tab_id", cbVar.getTabId());
                    jSONObject.put("to_tab_id", i2);
                    jSONArray.put(jSONObject);
                }
            }
            httpMessage.addParam("threads", jSONArray.toString());
            httpMessage.addParam("forum_id", cBr().getForumId());
            MessageManager.getInstance().sendMessage(httpMessage);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void cBw() {
        if (!com.baidu.tbadk.core.util.y.isEmpty(this.jfa)) {
            this.jfa.clear();
            if (this.jff != null) {
                this.jff.cm(this.jfa.size(), 2);
            }
        }
    }

    public void clearData() {
        for (cb cbVar : this.jfa) {
            if (cbVar != null) {
                cbVar.jB(false);
            }
        }
        this.jfa.clear();
        if (this.jff != null) {
            this.jff.cm(0, 2);
        }
    }

    public void reset() {
        X(false, false);
        clearData();
    }

    public void destory() {
        this.mForumId = null;
        this.jfc = -1;
        if (this.jfd != null) {
            this.jfd.clear();
        }
        if (this.jfe != null) {
            this.jfe.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.frs.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0723a {
        private static a jfg = new a();
    }
}
