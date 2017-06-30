package com.baidu.tieba.im.settingcache;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.cache.o;
import com.baidu.adp.lib.util.s;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.util.x;
import com.baidu.tieba.im.pushNotify.ChatSetting;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public abstract class a {
    protected HashMap<String, ChatSetting> doG = new HashMap<>();

    public abstract void a(ChatSetting chatSetting);

    public abstract void a(ChatSetting chatSetting, com.baidu.tbadk.util.h<Void> hVar);

    protected abstract o<String> avZ();

    public abstract ChatSetting bk(String str, String str2);

    public void m(Class<? extends ChatSetting> cls) {
        String str;
        synchronized (this.doG) {
            this.doG.clear();
        }
        String str2 = "";
        if (TbadkCoreApplication.getCurrentAccountObj() != null) {
            str2 = TbadkCoreApplication.getCurrentAccountObj().getID();
        }
        if (str2 != null && str2.length() != 0) {
            String str3 = String.valueOf(str2) + "@";
            synchronized (this.doG) {
                o<String> avZ = avZ();
                List<o.c<String>> b = s.b(avZ);
                if (b != null) {
                    for (o.c<String> cVar : b) {
                        String str4 = cVar.key;
                        if (str4 != null && str4.startsWith(str3) && (str = avZ.get(str4)) != null) {
                            this.doG.put(str4, (ChatSetting) OrmObject.objectWithJsonStr(str, cls));
                        }
                    }
                }
            }
        }
    }

    public void g(String str, String str2, boolean z) {
        ChatSetting bk = bk(str, str2);
        if (bk != null) {
            bk.setAcceptNotify(z);
            a(bk);
        }
    }

    public void a(String str, String str2, boolean z, com.baidu.tbadk.util.h<Void> hVar) {
        ChatSetting bk = bk(str, str2);
        if (bk != null) {
            bk.setAcceptNotify(z);
            a(bk, hVar);
        }
    }

    public boolean bl(String str, String str2) {
        ChatSetting bk = bk(str, str2);
        if (bk == null) {
            return false;
        }
        return bk.isAcceptNotify();
    }

    public void a(String str, String str2, com.baidu.tbadk.util.h<Boolean> hVar) {
        x.b(new b(this, str, str2), hVar);
    }
}
