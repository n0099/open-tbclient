package com.baidu.tieba.im.settingcache;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.cache.o;
import com.baidu.adp.lib.util.s;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.util.w;
import com.baidu.tieba.im.pushNotify.ChatSetting;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public abstract class a {
    protected HashMap<String, ChatSetting> dbn = new HashMap<>();

    public abstract void a(ChatSetting chatSetting);

    public abstract void a(ChatSetting chatSetting, com.baidu.tbadk.util.g<Void> gVar);

    protected abstract o<String> arq();

    public abstract ChatSetting bf(String str, String str2);

    public void m(Class<? extends ChatSetting> cls) {
        String str;
        synchronized (this.dbn) {
            this.dbn.clear();
        }
        String str2 = "";
        if (TbadkCoreApplication.getCurrentAccountObj() != null) {
            str2 = TbadkCoreApplication.getCurrentAccountObj().getID();
        }
        if (str2 != null && str2.length() != 0) {
            String str3 = String.valueOf(str2) + "@";
            synchronized (this.dbn) {
                o<String> arq = arq();
                List<o.c<String>> b = s.b(arq);
                if (b != null) {
                    for (o.c<String> cVar : b) {
                        String str4 = cVar.key;
                        if (str4 != null && str4.startsWith(str3) && (str = arq.get(str4)) != null) {
                            this.dbn.put(str4, (ChatSetting) OrmObject.objectWithJsonStr(str, cls));
                        }
                    }
                }
            }
        }
    }

    public void g(String str, String str2, boolean z) {
        ChatSetting bf = bf(str, str2);
        if (bf != null) {
            bf.setAcceptNotify(z);
            a(bf);
        }
    }

    public void a(String str, String str2, boolean z, com.baidu.tbadk.util.g<Void> gVar) {
        ChatSetting bf = bf(str, str2);
        if (bf != null) {
            bf.setAcceptNotify(z);
            a(bf, gVar);
        }
    }

    public boolean bg(String str, String str2) {
        ChatSetting bf = bf(str, str2);
        if (bf == null) {
            return false;
        }
        return bf.isAcceptNotify();
    }

    public void a(String str, String str2, com.baidu.tbadk.util.g<Boolean> gVar) {
        w.b(new b(this, str, str2), gVar);
    }
}
