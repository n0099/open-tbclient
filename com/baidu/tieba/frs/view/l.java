package com.baidu.tieba.frs.view;

import android.graphics.drawable.Drawable;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tieba.tbadkCore.d.a;
import java.util.HashMap;
import java.util.HashSet;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements com.baidu.tbadk.core.flow.a.d<com.baidu.tbadk.core.data.r> {
    final /* synthetic */ c bRo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(c cVar) {
        this.bRo = cVar;
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
        bc.vz().c(this.bRo.Gf, new String[]{str});
        String str4 = "";
        String str5 = "";
        if (this.bRo.bzH != null) {
            str4 = this.bRo.bzH.getForumId();
            str5 = this.bRo.bzH.getForumName();
        }
        if (i <= 0) {
            hashMap2 = c.bRe;
            str3 = this.bRo.Rc;
            a.C0074a a = com.baidu.tieba.tbadkCore.d.a.a("ad_tpoint", "PT", "FRS", (String) hashMap2.get(1), "ad_plat", "CLICK", str3, str4, str5, null);
            a.bY("obj_url", str);
            a.save();
            return;
        }
        i2 = this.bRo.bRg;
        if (i2 > 1) {
            i3 = this.bRo.bRg;
            if (i > i3) {
                i4 = this.bRo.bRg;
                i %= i4;
            }
            hashMap = c.bRe;
            str2 = this.bRo.Rc;
            a.C0074a a2 = com.baidu.tieba.tbadkCore.d.a.a("ad_tpoint", "PT", "FRS", (String) hashMap.get(Integer.valueOf(i)), "ad_plat", "CLICK", str2, str4, str5, null);
            a2.bY("obj_url", str);
            a2.save();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.flow.a.d
    public void a(int i, com.baidu.tbadk.core.data.r rVar) {
        int i2;
        Drawable drawable;
        int i3;
        int i4;
        HashSet hashSet;
        HashMap hashMap;
        String str;
        int i5;
        if (this.bRo.bQn != null) {
            String str2 = "";
            if (this.bRo.bzH != null) {
                str2 = this.bRo.bzH.getForumId();
            }
            if (i > 0) {
                i3 = this.bRo.bRg;
                if (i3 > 1) {
                    i4 = this.bRo.bRg;
                    if (i > i4) {
                        i5 = this.bRo.bRg;
                        i %= i5;
                    }
                    hashSet = c.bRf;
                    if (hashSet.add(Integer.valueOf(i))) {
                        hashMap = c.bRe;
                        str = this.bRo.Rc;
                        a.C0074a a = com.baidu.tieba.tbadkCore.d.a.a("ad_tpoint", "PT", "FRS", (String) hashMap.get(Integer.valueOf(i)), "ad_plat", "VIEW_TRUE", str, str2, "", null);
                        if (rVar != null) {
                            a.bY("obj_url", rVar.getLinkUrl());
                        }
                        a.save();
                    }
                }
            }
            if (rVar == null || StringUtils.isNull(rVar.getTitle(), true)) {
                this.bRo.bQn.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                this.bRo.bQn.setText("");
                return;
            }
            TextView textView = this.bRo.bQn;
            i2 = this.bRo.drawablePadding;
            textView.setCompoundDrawablePadding(i2);
            TextView textView2 = this.bRo.bQn;
            drawable = this.bRo.bQo;
            textView2.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
            this.bRo.bQn.setText(rVar.getTitle());
        }
    }
}
