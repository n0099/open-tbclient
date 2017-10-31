package com.baidu.tieba.im.settingcache;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.r;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.util.h;
import com.baidu.tbadk.util.u;
import com.baidu.tbadk.util.v;
import com.baidu.tieba.im.pushNotify.ChatSetting;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public abstract class a {
    protected HashMap<String, ChatSetting> dLK = new HashMap<>();

    public abstract void a(ChatSetting chatSetting);

    public abstract void a(ChatSetting chatSetting, h<Void> hVar);

    protected abstract l<String> aBs();

    public abstract ChatSetting bd(String str, String str2);

    public void m(Class<? extends ChatSetting> cls) {
        String str;
        synchronized (this.dLK) {
            this.dLK.clear();
        }
        String str2 = "";
        if (TbadkCoreApplication.getCurrentAccountObj() != null) {
            str2 = TbadkCoreApplication.getCurrentAccountObj().getID();
        }
        if (str2 != null && str2.length() != 0) {
            String str3 = str2 + "@";
            synchronized (this.dLK) {
                l<String> aBs = aBs();
                List<l.b<String>> b = r.b(aBs);
                if (b != null) {
                    for (l.b<String> bVar : b) {
                        String str4 = bVar.key;
                        if (str4 != null && str4.startsWith(str3) && (str = aBs.get(str4)) != null) {
                            this.dLK.put(str4, (ChatSetting) OrmObject.objectWithJsonStr(str, cls));
                        }
                    }
                }
            }
        }
    }

    public void h(String str, String str2, boolean z) {
        ChatSetting bd = bd(str, str2);
        if (bd != null) {
            bd.setAcceptNotify(z);
            a(bd);
        }
    }

    public void a(String str, String str2, boolean z, h<Void> hVar) {
        ChatSetting bd = bd(str, str2);
        if (bd != null) {
            bd.setAcceptNotify(z);
            a(bd, hVar);
        }
    }

    public boolean be(String str, String str2) {
        ChatSetting bd = bd(str, str2);
        if (bd == null) {
            return false;
        }
        return bd.isAcceptNotify();
    }

    public void a(final String str, final String str2, h<Boolean> hVar) {
        v.b(new u<Boolean>() { // from class: com.baidu.tieba.im.settingcache.a.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.baidu.tbadk.util.u
            public Boolean doInBackground() {
                ChatSetting bd = a.this.bd(str, str2);
                if (bd == null) {
                    return false;
                }
                return Boolean.valueOf(bd.isAcceptNotify());
            }
        }, hVar);
    }
}
