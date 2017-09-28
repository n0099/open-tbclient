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
    protected HashMap<String, ChatSetting> dEk = new HashMap<>();

    public abstract void a(ChatSetting chatSetting);

    public abstract void a(ChatSetting chatSetting, g<Void> gVar);

    protected abstract l<String> azc();

    public abstract ChatSetting bj(String str, String str2);

    public void m(Class<? extends ChatSetting> cls) {
        String str;
        synchronized (this.dEk) {
            this.dEk.clear();
        }
        String str2 = "";
        if (TbadkCoreApplication.getCurrentAccountObj() != null) {
            str2 = TbadkCoreApplication.getCurrentAccountObj().getID();
        }
        if (str2 != null && str2.length() != 0) {
            String str3 = str2 + "@";
            synchronized (this.dEk) {
                l<String> azc = azc();
                List<l.b<String>> b = r.b(azc);
                if (b != null) {
                    for (l.b<String> bVar : b) {
                        String str4 = bVar.key;
                        if (str4 != null && str4.startsWith(str3) && (str = azc.get(str4)) != null) {
                            this.dEk.put(str4, (ChatSetting) OrmObject.objectWithJsonStr(str, cls));
                        }
                    }
                }
            }
        }
    }

    public void h(String str, String str2, boolean z) {
        ChatSetting bj = bj(str, str2);
        if (bj != null) {
            bj.setAcceptNotify(z);
            a(bj);
        }
    }

    public void a(String str, String str2, boolean z, g<Void> gVar) {
        ChatSetting bj = bj(str, str2);
        if (bj != null) {
            bj.setAcceptNotify(z);
            a(bj, gVar);
        }
    }

    public boolean bk(String str, String str2) {
        ChatSetting bj = bj(str, str2);
        if (bj == null) {
            return false;
        }
        return bj.isAcceptNotify();
    }

    public void a(final String str, final String str2, g<Boolean> gVar) {
        t.b(new s<Boolean>() { // from class: com.baidu.tieba.im.settingcache.a.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.baidu.tbadk.util.s
            public Boolean doInBackground() {
                ChatSetting bj = a.this.bj(str, str2);
                if (bj == null) {
                    return false;
                }
                return Boolean.valueOf(bj.isAcceptNotify());
            }
        }, gVar);
    }
}
