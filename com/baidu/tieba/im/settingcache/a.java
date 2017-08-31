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
    protected HashMap<String, ChatSetting> dHa = new HashMap<>();

    public abstract void a(ChatSetting chatSetting);

    public abstract void a(ChatSetting chatSetting, h<Void> hVar);

    protected abstract l<String> aAe();

    public abstract ChatSetting bq(String str, String str2);

    public void m(Class<? extends ChatSetting> cls) {
        String str;
        synchronized (this.dHa) {
            this.dHa.clear();
        }
        String str2 = "";
        if (TbadkCoreApplication.getCurrentAccountObj() != null) {
            str2 = TbadkCoreApplication.getCurrentAccountObj().getID();
        }
        if (str2 != null && str2.length() != 0) {
            String str3 = str2 + "@";
            synchronized (this.dHa) {
                l<String> aAe = aAe();
                List<l.b<String>> b = q.b(aAe);
                if (b != null) {
                    for (l.b<String> bVar : b) {
                        String str4 = bVar.key;
                        if (str4 != null && str4.startsWith(str3) && (str = aAe.get(str4)) != null) {
                            this.dHa.put(str4, (ChatSetting) OrmObject.objectWithJsonStr(str, cls));
                        }
                    }
                }
            }
        }
    }

    public void h(String str, String str2, boolean z) {
        ChatSetting bq = bq(str, str2);
        if (bq != null) {
            bq.setAcceptNotify(z);
            a(bq);
        }
    }

    public void a(String str, String str2, boolean z, h<Void> hVar) {
        ChatSetting bq = bq(str, str2);
        if (bq != null) {
            bq.setAcceptNotify(z);
            a(bq, hVar);
        }
    }

    public boolean br(String str, String str2) {
        ChatSetting bq = bq(str, str2);
        if (bq == null) {
            return false;
        }
        return bq.isAcceptNotify();
    }

    public void a(final String str, final String str2, h<Boolean> hVar) {
        u.b(new t<Boolean>() { // from class: com.baidu.tieba.im.settingcache.a.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.baidu.tbadk.util.t
            public Boolean doInBackground() {
                ChatSetting bq = a.this.bq(str, str2);
                if (bq == null) {
                    return false;
                }
                return Boolean.valueOf(bq.isAcceptNotify());
            }
        }, hVar);
    }
}
