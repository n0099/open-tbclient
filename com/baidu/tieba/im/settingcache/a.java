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
    protected HashMap<String, ChatSetting> dUI = new HashMap<>();

    public abstract void a(ChatSetting chatSetting);

    public abstract void a(ChatSetting chatSetting, h<Void> hVar);

    protected abstract l<String> aDe();

    public abstract ChatSetting bi(String str, String str2);

    public void m(Class<? extends ChatSetting> cls) {
        String str;
        synchronized (this.dUI) {
            this.dUI.clear();
        }
        String str2 = "";
        if (TbadkCoreApplication.getCurrentAccountObj() != null) {
            str2 = TbadkCoreApplication.getCurrentAccountObj().getID();
        }
        if (str2 != null && str2.length() != 0) {
            String str3 = str2 + "@";
            synchronized (this.dUI) {
                l<String> aDe = aDe();
                List<l.b<String>> b = r.b(aDe);
                if (b != null) {
                    for (l.b<String> bVar : b) {
                        String str4 = bVar.key;
                        if (str4 != null && str4.startsWith(str3) && (str = aDe.get(str4)) != null) {
                            this.dUI.put(str4, (ChatSetting) OrmObject.objectWithJsonStr(str, cls));
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

    public void a(String str, String str2, boolean z, h<Void> hVar) {
        ChatSetting bi = bi(str, str2);
        if (bi != null) {
            bi.setAcceptNotify(z);
            a(bi, hVar);
        }
    }

    public boolean bj(String str, String str2) {
        ChatSetting bi = bi(str, str2);
        if (bi == null) {
            return false;
        }
        return bi.isAcceptNotify();
    }

    public void a(final String str, final String str2, h<Boolean> hVar) {
        v.b(new u<Boolean>() { // from class: com.baidu.tieba.im.settingcache.a.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.baidu.tbadk.util.u
            public Boolean doInBackground() {
                ChatSetting bi = a.this.bi(str, str2);
                if (bi == null) {
                    return false;
                }
                return Boolean.valueOf(bi.isAcceptNotify());
            }
        }, hVar);
    }
}
