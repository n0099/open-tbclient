package com.baidu.tieba.frs.view;

import android.graphics.drawable.Drawable;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tieba.tbadkCore.d.a;
import java.util.HashMap;
import java.util.HashSet;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements com.baidu.tbadk.core.flow.a.d<com.baidu.tbadk.core.data.s> {
    final /* synthetic */ c cme;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(c cVar) {
        this.cme = cVar;
    }

    @Override // com.baidu.tbadk.core.flow.a.d
    public void f(int i, String str) {
        int i2;
        int i3;
        HashMap hashMap;
        String str2;
        int i4;
        HashMap hashMap2;
        String str3;
        bf.vP().c(this.cme.Gf, new String[]{str});
        String str4 = "";
        String str5 = "";
        if (this.cme.bTA != null) {
            str4 = this.cme.bTA.getForumId();
            str5 = this.cme.bTA.getForumName();
        }
        if (i <= 0) {
            hashMap2 = c.clT;
            str3 = this.cme.Rf;
            a.C0080a a = com.baidu.tieba.tbadkCore.d.a.a("ad_tpoint", "PT", "FRS", (String) hashMap2.get(1), "ad_plat", "CLICK", str3, str4, str5, null);
            a.bV("obj_url", str);
            a.save();
            return;
        }
        i2 = this.cme.clV;
        if (i2 > 1) {
            i3 = this.cme.clV;
            if (i > i3) {
                i4 = this.cme.clV;
                i %= i4;
            }
            hashMap = c.clT;
            str2 = this.cme.Rf;
            a.C0080a a2 = com.baidu.tieba.tbadkCore.d.a.a("ad_tpoint", "PT", "FRS", (String) hashMap.get(Integer.valueOf(i)), "ad_plat", "CLICK", str2, str4, str5, null);
            a2.bV("obj_url", str);
            a2.save();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.flow.a.d
    public void a(int i, com.baidu.tbadk.core.data.s sVar) {
        int i2;
        Drawable drawable;
        int i3;
        int i4;
        HashSet hashSet;
        HashMap hashMap;
        String str;
        int i5;
        if (this.cme.clc != null) {
            String str2 = "";
            if (this.cme.bTA != null) {
                str2 = this.cme.bTA.getForumId();
            }
            if (i > 0) {
                i3 = this.cme.clV;
                if (i3 > 1) {
                    i4 = this.cme.clV;
                    if (i > i4) {
                        i5 = this.cme.clV;
                        i %= i5;
                    }
                    hashSet = c.clU;
                    if (hashSet.add(Integer.valueOf(i))) {
                        hashMap = c.clT;
                        str = this.cme.Rf;
                        a.C0080a a = com.baidu.tieba.tbadkCore.d.a.a("ad_tpoint", "PT", "FRS", (String) hashMap.get(Integer.valueOf(i)), "ad_plat", "VIEW_TRUE", str, str2, "", null);
                        if (sVar != null) {
                            a.bV("obj_url", sVar.getLinkUrl());
                        }
                        a.save();
                    }
                }
            }
            if (sVar == null || StringUtils.isNull(sVar.getTitle(), true)) {
                this.cme.clc.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                this.cme.clc.setText("");
                return;
            }
            TextView textView = this.cme.clc;
            i2 = this.cme.drawablePadding;
            textView.setCompoundDrawablePadding(i2);
            TextView textView2 = this.cme.clc;
            drawable = this.cme.cld;
            textView2.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
            this.cme.clc.setText(sVar.getTitle());
        }
    }
}
