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
    protected HashMap<String, ChatSetting> deV = new HashMap<>();

    public abstract void a(ChatSetting chatSetting);

    public abstract void a(ChatSetting chatSetting, com.baidu.tbadk.util.f<Void> fVar);

    protected abstract o<String> atv();

    public abstract ChatSetting bg(String str, String str2);

    public void m(Class<? extends ChatSetting> cls) {
        String str;
        synchronized (this.deV) {
            this.deV.clear();
        }
        String str2 = "";
        if (TbadkCoreApplication.getCurrentAccountObj() != null) {
            str2 = TbadkCoreApplication.getCurrentAccountObj().getID();
        }
        if (str2 != null && str2.length() != 0) {
            String str3 = String.valueOf(str2) + "@";
            synchronized (this.deV) {
                o<String> atv = atv();
                List<o.c<String>> b = s.b(atv);
                if (b != null) {
                    for (o.c<String> cVar : b) {
                        String str4 = cVar.key;
                        if (str4 != null && str4.startsWith(str3) && (str = atv.get(str4)) != null) {
                            this.deV.put(str4, (ChatSetting) OrmObject.objectWithJsonStr(str, cls));
                        }
                    }
                }
            }
        }
    }

    public void h(String str, String str2, boolean z) {
        ChatSetting bg = bg(str, str2);
        if (bg != null) {
            bg.setAcceptNotify(z);
            a(bg);
        }
    }

    public void a(String str, String str2, boolean z, com.baidu.tbadk.util.f<Void> fVar) {
        ChatSetting bg = bg(str, str2);
        if (bg != null) {
            bg.setAcceptNotify(z);
            a(bg, fVar);
        }
    }

    public boolean bh(String str, String str2) {
        ChatSetting bg = bg(str, str2);
        if (bg == null) {
            return false;
        }
        return bg.isAcceptNotify();
    }

    public void a(String str, String str2, com.baidu.tbadk.util.f<Boolean> fVar) {
        t.b(new b(this, str, str2), fVar);
    }
}
