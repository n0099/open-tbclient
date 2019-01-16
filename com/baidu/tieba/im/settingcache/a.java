package com.baidu.tieba.im.settingcache;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.r;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.util.h;
import com.baidu.tbadk.util.x;
import com.baidu.tbadk.util.y;
import com.baidu.tieba.im.pushNotify.ChatSetting;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public abstract class a {
    protected HashMap<String, ChatSetting> fcz = new HashMap<>();

    public abstract void a(ChatSetting chatSetting);

    public abstract void a(ChatSetting chatSetting, h<Void> hVar);

    protected abstract l<String> aVu();

    public abstract ChatSetting bS(String str, String str2);

    public void p(Class<? extends ChatSetting> cls) {
        String str;
        synchronized (this.fcz) {
            this.fcz.clear();
        }
        String str2 = "";
        if (TbadkCoreApplication.getCurrentAccountObj() != null) {
            str2 = TbadkCoreApplication.getCurrentAccountObj().getID();
        }
        if (str2 != null && str2.length() != 0) {
            String str3 = str2 + "@";
            synchronized (this.fcz) {
                l<String> aVu = aVu();
                List<l.b<String>> b = r.b(aVu);
                if (b != null) {
                    for (l.b<String> bVar : b) {
                        String str4 = bVar.key;
                        if (str4 != null && str4.startsWith(str3) && (str = aVu.get(str4)) != null) {
                            this.fcz.put(str4, (ChatSetting) OrmObject.objectWithJsonStr(str, cls));
                        }
                    }
                }
            }
        }
    }

    public void i(String str, String str2, boolean z) {
        ChatSetting bS = bS(str, str2);
        if (bS != null) {
            bS.setAcceptNotify(z);
            a(bS);
        }
    }

    public void a(String str, String str2, boolean z, h<Void> hVar) {
        ChatSetting bS = bS(str, str2);
        if (bS != null) {
            bS.setAcceptNotify(z);
            a(bS, hVar);
        }
    }

    public boolean bT(String str, String str2) {
        ChatSetting bS = bS(str, str2);
        if (bS == null) {
            return false;
        }
        return bS.isAcceptNotify();
    }

    public void a(final String str, final String str2, h<Boolean> hVar) {
        y.b(new x<Boolean>() { // from class: com.baidu.tieba.im.settingcache.a.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.baidu.tbadk.util.x
            public Boolean doInBackground() {
                ChatSetting bS = a.this.bS(str, str2);
                if (bS == null) {
                    return false;
                }
                return Boolean.valueOf(bS.isAcceptNotify());
            }
        }, hVar);
    }
}
