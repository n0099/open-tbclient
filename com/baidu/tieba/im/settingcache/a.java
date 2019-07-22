package com.baidu.tieba.im.settingcache;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.r;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.util.aa;
import com.baidu.tbadk.util.k;
import com.baidu.tbadk.util.z;
import com.baidu.tieba.im.pushNotify.ChatSetting;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public abstract class a {
    protected HashMap<String, ChatSetting> gPT = new HashMap<>();

    public abstract void a(ChatSetting chatSetting);

    public abstract void a(ChatSetting chatSetting, k<Void> kVar);

    protected abstract l<String> bGp();

    /* renamed from: do  reason: not valid java name */
    public abstract ChatSetting mo22do(String str, String str2);

    public void t(Class<? extends ChatSetting> cls) {
        String str;
        synchronized (this.gPT) {
            this.gPT.clear();
        }
        String str2 = "";
        if (TbadkCoreApplication.getCurrentAccountObj() != null) {
            str2 = TbadkCoreApplication.getCurrentAccountObj().getID();
        }
        if (str2 != null && str2.length() != 0) {
            String str3 = str2 + "@";
            synchronized (this.gPT) {
                l<String> bGp = bGp();
                List<l.b<String>> b = r.b(bGp);
                if (b != null) {
                    for (l.b<String> bVar : b) {
                        String str4 = bVar.key;
                        if (str4 != null && str4.startsWith(str3) && (str = bGp.get(str4)) != null) {
                            this.gPT.put(str4, (ChatSetting) OrmObject.objectWithJsonStr(str, cls));
                        }
                    }
                }
            }
        }
    }

    public void w(String str, String str2, boolean z) {
        ChatSetting mo22do = mo22do(str, str2);
        if (mo22do != null) {
            mo22do.setAcceptNotify(z);
            a(mo22do);
        }
    }

    public void a(String str, String str2, boolean z, k<Void> kVar) {
        ChatSetting mo22do = mo22do(str, str2);
        if (mo22do != null) {
            mo22do.setAcceptNotify(z);
            a(mo22do, kVar);
        }
    }

    public boolean dp(String str, String str2) {
        ChatSetting mo22do = mo22do(str, str2);
        if (mo22do == null) {
            return false;
        }
        return mo22do.isAcceptNotify();
    }

    public void a(final String str, final String str2, k<Boolean> kVar) {
        aa.b(new z<Boolean>() { // from class: com.baidu.tieba.im.settingcache.a.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.baidu.tbadk.util.z
            public Boolean doInBackground() {
                ChatSetting mo22do = a.this.mo22do(str, str2);
                if (mo22do == null) {
                    return false;
                }
                return Boolean.valueOf(mo22do.isAcceptNotify());
            }
        }, kVar);
    }
}
