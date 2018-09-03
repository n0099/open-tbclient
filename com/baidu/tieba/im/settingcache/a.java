package com.baidu.tieba.im.settingcache;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.r;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.util.g;
import com.baidu.tbadk.util.u;
import com.baidu.tbadk.util.v;
import com.baidu.tieba.im.pushNotify.ChatSetting;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public abstract class a {
    protected HashMap<String, ChatSetting> eBN = new HashMap<>();

    public abstract void a(ChatSetting chatSetting);

    public abstract void a(ChatSetting chatSetting, g<Void> gVar);

    protected abstract l<String> aNp();

    public abstract ChatSetting bs(String str, String str2);

    public void m(Class<? extends ChatSetting> cls) {
        String str;
        synchronized (this.eBN) {
            this.eBN.clear();
        }
        String str2 = "";
        if (TbadkCoreApplication.getCurrentAccountObj() != null) {
            str2 = TbadkCoreApplication.getCurrentAccountObj().getID();
        }
        if (str2 != null && str2.length() != 0) {
            String str3 = str2 + "@";
            synchronized (this.eBN) {
                l<String> aNp = aNp();
                List<l.b<String>> b = r.b(aNp);
                if (b != null) {
                    for (l.b<String> bVar : b) {
                        String str4 = bVar.key;
                        if (str4 != null && str4.startsWith(str3) && (str = aNp.get(str4)) != null) {
                            this.eBN.put(str4, (ChatSetting) OrmObject.objectWithJsonStr(str, cls));
                        }
                    }
                }
            }
        }
    }

    public void h(String str, String str2, boolean z) {
        ChatSetting bs = bs(str, str2);
        if (bs != null) {
            bs.setAcceptNotify(z);
            a(bs);
        }
    }

    public void a(String str, String str2, boolean z, g<Void> gVar) {
        ChatSetting bs = bs(str, str2);
        if (bs != null) {
            bs.setAcceptNotify(z);
            a(bs, gVar);
        }
    }

    public boolean bt(String str, String str2) {
        ChatSetting bs = bs(str, str2);
        if (bs == null) {
            return false;
        }
        return bs.isAcceptNotify();
    }

    public void a(final String str, final String str2, g<Boolean> gVar) {
        v.b(new u<Boolean>() { // from class: com.baidu.tieba.im.settingcache.a.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.baidu.tbadk.util.u
            public Boolean doInBackground() {
                ChatSetting bs = a.this.bs(str, str2);
                if (bs == null) {
                    return false;
                }
                return Boolean.valueOf(bs.isAcceptNotify());
            }
        }, gVar);
    }
}
