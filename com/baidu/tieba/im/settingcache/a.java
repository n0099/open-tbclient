package com.baidu.tieba.im.settingcache;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.r;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.util.ae;
import com.baidu.tbadk.util.af;
import com.baidu.tbadk.util.m;
import com.baidu.tieba.im.pushNotify.ChatSetting;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public abstract class a {
    protected HashMap<String, ChatSetting> kOo = new HashMap<>();

    public abstract void a(ChatSetting chatSetting);

    public abstract void a(ChatSetting chatSetting, m<Void> mVar);

    protected abstract l<String> cYe();

    public abstract ChatSetting fx(String str, String str2);

    public void r(Class<? extends ChatSetting> cls) {
        String str;
        synchronized (this.kOo) {
            this.kOo.clear();
        }
        String str2 = "";
        if (TbadkCoreApplication.getCurrentAccountObj() != null) {
            str2 = TbadkCoreApplication.getCurrentAccountObj().getID();
        }
        if (str2 != null && str2.length() != 0) {
            String str3 = str2 + "@";
            synchronized (this.kOo) {
                l<String> cYe = cYe();
                List<l.b<String>> b = r.b(cYe);
                if (b != null) {
                    for (l.b<String> bVar : b) {
                        String str4 = bVar.key;
                        if (str4 != null && str4.startsWith(str3) && (str = cYe.get(str4)) != null) {
                            this.kOo.put(str4, (ChatSetting) OrmObject.objectWithJsonStr(str, cls));
                        }
                    }
                }
            }
        }
    }

    public void D(String str, String str2, boolean z) {
        ChatSetting fx = fx(str, str2);
        if (fx != null) {
            fx.setAcceptNotify(z);
            a(fx);
        }
    }

    public void a(String str, String str2, boolean z, m<Void> mVar) {
        ChatSetting fx = fx(str, str2);
        if (fx != null) {
            fx.setAcceptNotify(z);
            a(fx, mVar);
        }
    }

    public boolean fy(String str, String str2) {
        ChatSetting fx = fx(str, str2);
        if (fx == null) {
            return false;
        }
        return fx.isAcceptNotify();
    }

    public void a(final String str, final String str2, m<Boolean> mVar) {
        af.b(new ae<Boolean>() { // from class: com.baidu.tieba.im.settingcache.a.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.baidu.tbadk.util.ae
            public Boolean doInBackground() {
                ChatSetting fx = a.this.fx(str, str2);
                if (fx == null) {
                    return false;
                }
                return Boolean.valueOf(fx.isAcceptNotify());
            }
        }, mVar);
    }
}
