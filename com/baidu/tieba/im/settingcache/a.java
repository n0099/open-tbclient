package com.baidu.tieba.im.settingcache;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.r;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.util.h;
import com.baidu.tbadk.util.v;
import com.baidu.tbadk.util.w;
import com.baidu.tieba.im.pushNotify.ChatSetting;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public abstract class a {
    protected HashMap<String, ChatSetting> exZ = new HashMap<>();

    public abstract void a(ChatSetting chatSetting);

    public abstract void a(ChatSetting chatSetting, h<Void> hVar);

    protected abstract l<String> aMs();

    public abstract ChatSetting bu(String str, String str2);

    public void m(Class<? extends ChatSetting> cls) {
        String str;
        synchronized (this.exZ) {
            this.exZ.clear();
        }
        String str2 = "";
        if (TbadkCoreApplication.getCurrentAccountObj() != null) {
            str2 = TbadkCoreApplication.getCurrentAccountObj().getID();
        }
        if (str2 != null && str2.length() != 0) {
            String str3 = str2 + "@";
            synchronized (this.exZ) {
                l<String> aMs = aMs();
                List<l.b<String>> b = r.b(aMs);
                if (b != null) {
                    for (l.b<String> bVar : b) {
                        String str4 = bVar.key;
                        if (str4 != null && str4.startsWith(str3) && (str = aMs.get(str4)) != null) {
                            this.exZ.put(str4, (ChatSetting) OrmObject.objectWithJsonStr(str, cls));
                        }
                    }
                }
            }
        }
    }

    public void i(String str, String str2, boolean z) {
        ChatSetting bu = bu(str, str2);
        if (bu != null) {
            bu.setAcceptNotify(z);
            a(bu);
        }
    }

    public void a(String str, String str2, boolean z, h<Void> hVar) {
        ChatSetting bu = bu(str, str2);
        if (bu != null) {
            bu.setAcceptNotify(z);
            a(bu, hVar);
        }
    }

    public boolean bv(String str, String str2) {
        ChatSetting bu = bu(str, str2);
        if (bu == null) {
            return false;
        }
        return bu.isAcceptNotify();
    }

    public void a(final String str, final String str2, h<Boolean> hVar) {
        w.b(new v<Boolean>() { // from class: com.baidu.tieba.im.settingcache.a.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.baidu.tbadk.util.v
            public Boolean doInBackground() {
                ChatSetting bu = a.this.bu(str, str2);
                if (bu == null) {
                    return false;
                }
                return Boolean.valueOf(bu.isAcceptNotify());
            }
        }, hVar);
    }
}
