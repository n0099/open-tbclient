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
    protected HashMap<String, ChatSetting> eIu = new HashMap<>();

    public abstract void a(ChatSetting chatSetting);

    public abstract void a(ChatSetting chatSetting, h<Void> hVar);

    protected abstract l<String> aKm();

    public abstract ChatSetting bh(String str, String str2);

    public void m(Class<? extends ChatSetting> cls) {
        String str;
        synchronized (this.eIu) {
            this.eIu.clear();
        }
        String str2 = "";
        if (TbadkCoreApplication.getCurrentAccountObj() != null) {
            str2 = TbadkCoreApplication.getCurrentAccountObj().getID();
        }
        if (str2 != null && str2.length() != 0) {
            String str3 = str2 + "@";
            synchronized (this.eIu) {
                l<String> aKm = aKm();
                List<l.b<String>> b = r.b(aKm);
                if (b != null) {
                    for (l.b<String> bVar : b) {
                        String str4 = bVar.key;
                        if (str4 != null && str4.startsWith(str3) && (str = aKm.get(str4)) != null) {
                            this.eIu.put(str4, (ChatSetting) OrmObject.objectWithJsonStr(str, cls));
                        }
                    }
                }
            }
        }
    }

    public void h(String str, String str2, boolean z) {
        ChatSetting bh = bh(str, str2);
        if (bh != null) {
            bh.setAcceptNotify(z);
            a(bh);
        }
    }

    public void a(String str, String str2, boolean z, h<Void> hVar) {
        ChatSetting bh = bh(str, str2);
        if (bh != null) {
            bh.setAcceptNotify(z);
            a(bh, hVar);
        }
    }

    public boolean bi(String str, String str2) {
        ChatSetting bh = bh(str, str2);
        if (bh == null) {
            return false;
        }
        return bh.isAcceptNotify();
    }

    public void a(final String str, final String str2, h<Boolean> hVar) {
        v.b(new u<Boolean>() { // from class: com.baidu.tieba.im.settingcache.a.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.baidu.tbadk.util.u
            public Boolean doInBackground() {
                ChatSetting bh = a.this.bh(str, str2);
                if (bh == null) {
                    return false;
                }
                return Boolean.valueOf(bh.isAcceptNotify());
            }
        }, hVar);
    }
}
