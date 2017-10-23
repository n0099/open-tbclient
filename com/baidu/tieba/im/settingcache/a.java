package com.baidu.tieba.im.settingcache;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.r;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.util.g;
import com.baidu.tbadk.util.s;
import com.baidu.tbadk.util.t;
import com.baidu.tieba.im.pushNotify.ChatSetting;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public abstract class a {
    protected HashMap<String, ChatSetting> dDW = new HashMap<>();

    public abstract void a(ChatSetting chatSetting);

    public abstract void a(ChatSetting chatSetting, g<Void> gVar);

    protected abstract l<String> ayX();

    public abstract ChatSetting bi(String str, String str2);

    public void m(Class<? extends ChatSetting> cls) {
        String str;
        synchronized (this.dDW) {
            this.dDW.clear();
        }
        String str2 = "";
        if (TbadkCoreApplication.getCurrentAccountObj() != null) {
            str2 = TbadkCoreApplication.getCurrentAccountObj().getID();
        }
        if (str2 != null && str2.length() != 0) {
            String str3 = str2 + "@";
            synchronized (this.dDW) {
                l<String> ayX = ayX();
                List<l.b<String>> b = r.b(ayX);
                if (b != null) {
                    for (l.b<String> bVar : b) {
                        String str4 = bVar.key;
                        if (str4 != null && str4.startsWith(str3) && (str = ayX.get(str4)) != null) {
                            this.dDW.put(str4, (ChatSetting) OrmObject.objectWithJsonStr(str, cls));
                        }
                    }
                }
            }
        }
    }

    public void h(String str, String str2, boolean z) {
        ChatSetting bi = bi(str, str2);
        if (bi != null) {
            bi.setAcceptNotify(z);
            a(bi);
        }
    }

    public void a(String str, String str2, boolean z, g<Void> gVar) {
        ChatSetting bi = bi(str, str2);
        if (bi != null) {
            bi.setAcceptNotify(z);
            a(bi, gVar);
        }
    }

    public boolean bj(String str, String str2) {
        ChatSetting bi = bi(str, str2);
        if (bi == null) {
            return false;
        }
        return bi.isAcceptNotify();
    }

    public void a(final String str, final String str2, g<Boolean> gVar) {
        t.b(new s<Boolean>() { // from class: com.baidu.tieba.im.settingcache.a.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.baidu.tbadk.util.s
            public Boolean doInBackground() {
                ChatSetting bi = a.this.bi(str, str2);
                if (bi == null) {
                    return false;
                }
                return Boolean.valueOf(bi.isAcceptNotify());
            }
        }, gVar);
    }
}
