package com.baidu.tieba.im.settingcache;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.r;
import com.baidu.searchbox.ugc.model.UgcConstant;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.util.ac;
import com.baidu.tbadk.util.ad;
import com.baidu.tbadk.util.l;
import com.baidu.tieba.im.pushNotify.ChatSetting;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes2.dex */
public abstract class a {
    protected HashMap<String, ChatSetting> jyU = new HashMap<>();

    public abstract void a(ChatSetting chatSetting);

    public abstract void a(ChatSetting chatSetting, l<Void> lVar);

    protected abstract com.baidu.adp.lib.cache.l<String> cIg();

    public abstract ChatSetting eS(String str, String str2);

    public void y(Class<? extends ChatSetting> cls) {
        String str;
        synchronized (this.jyU) {
            this.jyU.clear();
        }
        String str2 = "";
        if (TbadkCoreApplication.getCurrentAccountObj() != null) {
            str2 = TbadkCoreApplication.getCurrentAccountObj().getID();
        }
        if (str2 != null && str2.length() != 0) {
            String str3 = str2 + UgcConstant.AT_RULE_TAG;
            synchronized (this.jyU) {
                com.baidu.adp.lib.cache.l<String> cIg = cIg();
                List<l.b<String>> b = r.b(cIg);
                if (b != null) {
                    for (l.b<String> bVar : b) {
                        String str4 = bVar.key;
                        if (str4 != null && str4.startsWith(str3) && (str = cIg.get(str4)) != null) {
                            this.jyU.put(str4, (ChatSetting) OrmObject.objectWithJsonStr(str, cls));
                        }
                    }
                }
            }
        }
    }

    public void z(String str, String str2, boolean z) {
        ChatSetting eS = eS(str, str2);
        if (eS != null) {
            eS.setAcceptNotify(z);
            a(eS);
        }
    }

    public void a(String str, String str2, boolean z, com.baidu.tbadk.util.l<Void> lVar) {
        ChatSetting eS = eS(str, str2);
        if (eS != null) {
            eS.setAcceptNotify(z);
            a(eS, lVar);
        }
    }

    public boolean eT(String str, String str2) {
        ChatSetting eS = eS(str, str2);
        if (eS == null) {
            return false;
        }
        return eS.isAcceptNotify();
    }

    public void a(final String str, final String str2, com.baidu.tbadk.util.l<Boolean> lVar) {
        ad.b(new ac<Boolean>() { // from class: com.baidu.tieba.im.settingcache.a.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.baidu.tbadk.util.ac
            public Boolean doInBackground() {
                ChatSetting eS = a.this.eS(str, str2);
                if (eS == null) {
                    return false;
                }
                return Boolean.valueOf(eS.isAcceptNotify());
            }
        }, lVar);
    }
}
