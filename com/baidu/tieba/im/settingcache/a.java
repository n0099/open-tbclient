package com.baidu.tieba.im.settingcache;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.cache.o;
import com.baidu.adp.lib.util.s;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.util.t;
import com.baidu.tieba.im.pushNotify.ChatSetting;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public abstract class a {
    protected HashMap<String, ChatSetting> dgy = new HashMap<>();

    public abstract void a(ChatSetting chatSetting);

    public abstract void a(ChatSetting chatSetting, com.baidu.tbadk.util.f<Void> fVar);

    protected abstract o<String> atC();

    public abstract ChatSetting bc(String str, String str2);

    public void t(Class<? extends ChatSetting> cls) {
        String str;
        synchronized (this.dgy) {
            this.dgy.clear();
        }
        String str2 = "";
        if (TbadkCoreApplication.getCurrentAccountObj() != null) {
            str2 = TbadkCoreApplication.getCurrentAccountObj().getID();
        }
        if (str2 != null && str2.length() != 0) {
            String str3 = String.valueOf(str2) + "@";
            synchronized (this.dgy) {
                o<String> atC = atC();
                List<o.c<String>> b = s.b(atC);
                if (b != null) {
                    for (o.c<String> cVar : b) {
                        String str4 = cVar.key;
                        if (str4 != null && str4.startsWith(str3) && (str = atC.get(str4)) != null) {
                            this.dgy.put(str4, (ChatSetting) OrmObject.objectWithJsonStr(str, cls));
                        }
                    }
                }
            }
        }
    }

    public void g(String str, String str2, boolean z) {
        ChatSetting bc = bc(str, str2);
        if (bc != null) {
            bc.setAcceptNotify(z);
            a(bc);
        }
    }

    public void a(String str, String str2, boolean z, com.baidu.tbadk.util.f<Void> fVar) {
        ChatSetting bc = bc(str, str2);
        if (bc != null) {
            bc.setAcceptNotify(z);
            a(bc, fVar);
        }
    }

    public boolean bd(String str, String str2) {
        ChatSetting bc = bc(str, str2);
        if (bc == null) {
            return false;
        }
        return bc.isAcceptNotify();
    }

    public void a(String str, String str2, com.baidu.tbadk.util.f<Boolean> fVar) {
        t.b(new b(this, str, str2), fVar);
    }
}
