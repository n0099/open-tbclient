package com.baidu.tieba.im.settingcache;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.r;
import com.baidu.searchbox.ugc.model.UgcConstant;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.util.ad;
import com.baidu.tbadk.util.ae;
import com.baidu.tbadk.util.m;
import com.baidu.tieba.im.pushNotify.ChatSetting;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public abstract class a {
    protected HashMap<String, ChatSetting> jWz = new HashMap<>();

    public abstract void a(ChatSetting chatSetting);

    public abstract void a(ChatSetting chatSetting, m<Void> mVar);

    protected abstract l<String> cPv();

    public abstract ChatSetting fn(String str, String str2);

    public void y(Class<? extends ChatSetting> cls) {
        String str;
        synchronized (this.jWz) {
            this.jWz.clear();
        }
        String str2 = "";
        if (TbadkCoreApplication.getCurrentAccountObj() != null) {
            str2 = TbadkCoreApplication.getCurrentAccountObj().getID();
        }
        if (str2 != null && str2.length() != 0) {
            String str3 = str2 + UgcConstant.AT_RULE_TAG;
            synchronized (this.jWz) {
                l<String> cPv = cPv();
                List<l.b<String>> b = r.b(cPv);
                if (b != null) {
                    for (l.b<String> bVar : b) {
                        String str4 = bVar.key;
                        if (str4 != null && str4.startsWith(str3) && (str = cPv.get(str4)) != null) {
                            this.jWz.put(str4, (ChatSetting) OrmObject.objectWithJsonStr(str, cls));
                        }
                    }
                }
            }
        }
    }

    public void z(String str, String str2, boolean z) {
        ChatSetting fn = fn(str, str2);
        if (fn != null) {
            fn.setAcceptNotify(z);
            a(fn);
        }
    }

    public void a(String str, String str2, boolean z, m<Void> mVar) {
        ChatSetting fn = fn(str, str2);
        if (fn != null) {
            fn.setAcceptNotify(z);
            a(fn, mVar);
        }
    }

    public boolean fo(String str, String str2) {
        ChatSetting fn = fn(str, str2);
        if (fn == null) {
            return false;
        }
        return fn.isAcceptNotify();
    }

    public void a(final String str, final String str2, m<Boolean> mVar) {
        ae.b(new ad<Boolean>() { // from class: com.baidu.tieba.im.settingcache.a.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.baidu.tbadk.util.ad
            public Boolean doInBackground() {
                ChatSetting fn = a.this.fn(str, str2);
                if (fn == null) {
                    return false;
                }
                return Boolean.valueOf(fn.isAcceptNotify());
            }
        }, mVar);
    }
}
