package com.baidu.tieba.im.settingcache;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.r;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.util.j;
import com.baidu.tbadk.util.y;
import com.baidu.tbadk.util.z;
import com.baidu.tieba.im.pushNotify.ChatSetting;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public abstract class a {
    protected HashMap<String, ChatSetting> gSF = new HashMap<>();

    public abstract void a(ChatSetting chatSetting);

    public abstract void a(ChatSetting chatSetting, j<Void> jVar);

    protected abstract l<String> bHr();

    public abstract ChatSetting dq(String str, String str2);

    public void t(Class<? extends ChatSetting> cls) {
        String str;
        synchronized (this.gSF) {
            this.gSF.clear();
        }
        String str2 = "";
        if (TbadkCoreApplication.getCurrentAccountObj() != null) {
            str2 = TbadkCoreApplication.getCurrentAccountObj().getID();
        }
        if (str2 != null && str2.length() != 0) {
            String str3 = str2 + "@";
            synchronized (this.gSF) {
                l<String> bHr = bHr();
                List<l.b<String>> b = r.b(bHr);
                if (b != null) {
                    for (l.b<String> bVar : b) {
                        String str4 = bVar.key;
                        if (str4 != null && str4.startsWith(str3) && (str = bHr.get(str4)) != null) {
                            this.gSF.put(str4, (ChatSetting) OrmObject.objectWithJsonStr(str, cls));
                        }
                    }
                }
            }
        }
    }

    public void x(String str, String str2, boolean z) {
        ChatSetting dq = dq(str, str2);
        if (dq != null) {
            dq.setAcceptNotify(z);
            a(dq);
        }
    }

    public void a(String str, String str2, boolean z, j<Void> jVar) {
        ChatSetting dq = dq(str, str2);
        if (dq != null) {
            dq.setAcceptNotify(z);
            a(dq, jVar);
        }
    }

    public boolean dr(String str, String str2) {
        ChatSetting dq = dq(str, str2);
        if (dq == null) {
            return false;
        }
        return dq.isAcceptNotify();
    }

    public void a(final String str, final String str2, j<Boolean> jVar) {
        z.b(new y<Boolean>() { // from class: com.baidu.tieba.im.settingcache.a.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.baidu.tbadk.util.y
            public Boolean doInBackground() {
                ChatSetting dq = a.this.dq(str, str2);
                if (dq == null) {
                    return false;
                }
                return Boolean.valueOf(dq.isAcceptNotify());
            }
        }, jVar);
    }
}
