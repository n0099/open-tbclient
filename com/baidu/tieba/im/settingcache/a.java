package com.baidu.tieba.im.settingcache;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.r;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.util.h;
import com.baidu.tbadk.util.w;
import com.baidu.tbadk.util.x;
import com.baidu.tieba.im.pushNotify.ChatSetting;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public abstract class a {
    protected HashMap<String, ChatSetting> eJe = new HashMap<>();

    public abstract void a(ChatSetting chatSetting);

    public abstract void a(ChatSetting chatSetting, h<Void> hVar);

    protected abstract l<String> aPE();

    public abstract ChatSetting bA(String str, String str2);

    public void p(Class<? extends ChatSetting> cls) {
        String str;
        synchronized (this.eJe) {
            this.eJe.clear();
        }
        String str2 = "";
        if (TbadkCoreApplication.getCurrentAccountObj() != null) {
            str2 = TbadkCoreApplication.getCurrentAccountObj().getID();
        }
        if (str2 != null && str2.length() != 0) {
            String str3 = str2 + "@";
            synchronized (this.eJe) {
                l<String> aPE = aPE();
                List<l.b<String>> b = r.b(aPE);
                if (b != null) {
                    for (l.b<String> bVar : b) {
                        String str4 = bVar.key;
                        if (str4 != null && str4.startsWith(str3) && (str = aPE.get(str4)) != null) {
                            this.eJe.put(str4, (ChatSetting) OrmObject.objectWithJsonStr(str, cls));
                        }
                    }
                }
            }
        }
    }

    public void h(String str, String str2, boolean z) {
        ChatSetting bA = bA(str, str2);
        if (bA != null) {
            bA.setAcceptNotify(z);
            a(bA);
        }
    }

    public void a(String str, String str2, boolean z, h<Void> hVar) {
        ChatSetting bA = bA(str, str2);
        if (bA != null) {
            bA.setAcceptNotify(z);
            a(bA, hVar);
        }
    }

    public boolean bB(String str, String str2) {
        ChatSetting bA = bA(str, str2);
        if (bA == null) {
            return false;
        }
        return bA.isAcceptNotify();
    }

    public void a(final String str, final String str2, h<Boolean> hVar) {
        x.b(new w<Boolean>() { // from class: com.baidu.tieba.im.settingcache.a.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.baidu.tbadk.util.w
            public Boolean doInBackground() {
                ChatSetting bA = a.this.bA(str, str2);
                if (bA == null) {
                    return false;
                }
                return Boolean.valueOf(bA.isAcceptNotify());
            }
        }, hVar);
    }
}
