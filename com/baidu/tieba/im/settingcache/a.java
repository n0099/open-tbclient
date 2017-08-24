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
    protected HashMap<String, ChatSetting> dAx = new HashMap<>();

    public abstract void a(ChatSetting chatSetting);

    public abstract void a(ChatSetting chatSetting, h<Void> hVar);

    protected abstract l<String> ayp();

    public abstract ChatSetting bm(String str, String str2);

    public void m(Class<? extends ChatSetting> cls) {
        String str;
        synchronized (this.dAx) {
            this.dAx.clear();
        }
        String str2 = "";
        if (TbadkCoreApplication.getCurrentAccountObj() != null) {
            str2 = TbadkCoreApplication.getCurrentAccountObj().getID();
        }
        if (str2 != null && str2.length() != 0) {
            String str3 = str2 + "@";
            synchronized (this.dAx) {
                l<String> ayp = ayp();
                List<l.c<String>> b = q.b(ayp);
                if (b != null) {
                    for (l.c<String> cVar : b) {
                        String str4 = cVar.key;
                        if (str4 != null && str4.startsWith(str3) && (str = ayp.get(str4)) != null) {
                            this.dAx.put(str4, (ChatSetting) OrmObject.objectWithJsonStr(str, cls));
                        }
                    }
                }
            }
        }
    }

    public void g(String str, String str2, boolean z) {
        ChatSetting bm = bm(str, str2);
        if (bm != null) {
            bm.setAcceptNotify(z);
            a(bm);
        }
    }

    public void a(String str, String str2, boolean z, h<Void> hVar) {
        ChatSetting bm = bm(str, str2);
        if (bm != null) {
            bm.setAcceptNotify(z);
            a(bm, hVar);
        }
    }

    public boolean bn(String str, String str2) {
        ChatSetting bm = bm(str, str2);
        if (bm == null) {
            return false;
        }
        return bm.isAcceptNotify();
    }

    public void a(final String str, final String str2, h<Boolean> hVar) {
        u.b(new t<Boolean>() { // from class: com.baidu.tieba.im.settingcache.a.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.baidu.tbadk.util.t
            public Boolean doInBackground() {
                ChatSetting bm = a.this.bm(str, str2);
                if (bm == null) {
                    return false;
                }
                return Boolean.valueOf(bm.isAcceptNotify());
            }
        }, hVar);
    }
}
