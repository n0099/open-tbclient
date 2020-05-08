package com.baidu.tieba.im.settingcache;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.r;
import com.baidu.searchbox.ugc.model.UgcConstant;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.util.ab;
import com.baidu.tbadk.util.ac;
import com.baidu.tbadk.util.l;
import com.baidu.tieba.im.pushNotify.ChatSetting;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public abstract class a {
    protected HashMap<String, ChatSetting> ive = new HashMap<>();

    public abstract void a(ChatSetting chatSetting);

    public abstract void a(ChatSetting chatSetting, l<Void> lVar);

    protected abstract com.baidu.adp.lib.cache.l<String> ciQ();

    public abstract ChatSetting dS(String str, String str2);

    public void y(Class<? extends ChatSetting> cls) {
        String str;
        synchronized (this.ive) {
            this.ive.clear();
        }
        String str2 = "";
        if (TbadkCoreApplication.getCurrentAccountObj() != null) {
            str2 = TbadkCoreApplication.getCurrentAccountObj().getID();
        }
        if (str2 != null && str2.length() != 0) {
            String str3 = str2 + UgcConstant.AT_RULE_TAG;
            synchronized (this.ive) {
                com.baidu.adp.lib.cache.l<String> ciQ = ciQ();
                List<l.b<String>> b = r.b(ciQ);
                if (b != null) {
                    for (l.b<String> bVar : b) {
                        String str4 = bVar.key;
                        if (str4 != null && str4.startsWith(str3) && (str = ciQ.get(str4)) != null) {
                            this.ive.put(str4, (ChatSetting) OrmObject.objectWithJsonStr(str, cls));
                        }
                    }
                }
            }
        }
    }

    public void x(String str, String str2, boolean z) {
        ChatSetting dS = dS(str, str2);
        if (dS != null) {
            dS.setAcceptNotify(z);
            a(dS);
        }
    }

    public void a(String str, String str2, boolean z, com.baidu.tbadk.util.l<Void> lVar) {
        ChatSetting dS = dS(str, str2);
        if (dS != null) {
            dS.setAcceptNotify(z);
            a(dS, lVar);
        }
    }

    public boolean dT(String str, String str2) {
        ChatSetting dS = dS(str, str2);
        if (dS == null) {
            return false;
        }
        return dS.isAcceptNotify();
    }

    public void a(final String str, final String str2, com.baidu.tbadk.util.l<Boolean> lVar) {
        ac.b(new ab<Boolean>() { // from class: com.baidu.tieba.im.settingcache.a.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.baidu.tbadk.util.ab
            public Boolean doInBackground() {
                ChatSetting dS = a.this.dS(str, str2);
                if (dS == null) {
                    return false;
                }
                return Boolean.valueOf(dS.isAcceptNotify());
            }
        }, lVar);
    }
}
