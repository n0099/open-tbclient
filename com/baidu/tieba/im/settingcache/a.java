package com.baidu.tieba.im.settingcache;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.q;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.util.h;
import com.baidu.tbadk.util.t;
import com.baidu.tbadk.util.u;
import com.baidu.tieba.im.pushNotify.ChatSetting;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public abstract class a {
    protected HashMap<String, ChatSetting> dyA = new HashMap<>();

    public abstract void a(ChatSetting chatSetting);

    public abstract void a(ChatSetting chatSetting, h<Void> hVar);

    protected abstract l<String> axN();

    public abstract ChatSetting bk(String str, String str2);

    public void m(Class<? extends ChatSetting> cls) {
        String str;
        synchronized (this.dyA) {
            this.dyA.clear();
        }
        String str2 = "";
        if (TbadkCoreApplication.getCurrentAccountObj() != null) {
            str2 = TbadkCoreApplication.getCurrentAccountObj().getID();
        }
        if (str2 != null && str2.length() != 0) {
            String str3 = str2 + "@";
            synchronized (this.dyA) {
                l<String> axN = axN();
                List<l.c<String>> b = q.b(axN);
                if (b != null) {
                    for (l.c<String> cVar : b) {
                        String str4 = cVar.key;
                        if (str4 != null && str4.startsWith(str3) && (str = axN.get(str4)) != null) {
                            this.dyA.put(str4, (ChatSetting) OrmObject.objectWithJsonStr(str, cls));
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

    public void a(String str, String str2, boolean z, h<Void> hVar) {
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

    public void a(final String str, final String str2, h<Boolean> hVar) {
        u.b(new t<Boolean>() { // from class: com.baidu.tieba.im.settingcache.a.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.baidu.tbadk.util.t
            public Boolean doInBackground() {
                ChatSetting bk = a.this.bk(str, str2);
                if (bk == null) {
                    return false;
                }
                return Boolean.valueOf(bk.isAcceptNotify());
            }
        }, hVar);
    }
}
