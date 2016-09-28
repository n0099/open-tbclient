package com.baidu.tieba.frs.view;

import android.graphics.drawable.Drawable;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.bh;
import com.baidu.tieba.tbadkCore.d.a;
import java.util.HashMap;
import java.util.HashSet;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements com.baidu.tbadk.core.flow.a.d<com.baidu.tbadk.core.data.r> {
    final /* synthetic */ c cgX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(c cVar) {
        this.cgX = cVar;
    }

    @Override // com.baidu.tbadk.core.flow.a.d
    public void g(int i, String str) {
        int i2;
        int i3;
        HashMap hashMap;
        String str2;
        int i4;
        HashMap hashMap2;
        String str3;
        bh.vL().c(this.cgX.Gd, new String[]{str});
        String str4 = "";
        String str5 = "";
        if (this.cgX.bRi != null) {
            str4 = this.cgX.bRi.getForumId();
            str5 = this.cgX.bRi.getForumName();
        }
        if (i <= 0) {
            hashMap2 = c.cgO;
            str3 = this.cgX.QJ;
            a.C0079a a = com.baidu.tieba.tbadkCore.d.a.a("ad_tpoint", "PT", "FRS", (String) hashMap2.get(1), "ad_plat", "CLICK", str3, str4, str5, null);
            a.bT("obj_url", str);
            a.save();
            return;
        }
        i2 = this.cgX.cgQ;
        if (i2 > 1) {
            i3 = this.cgX.cgQ;
            if (i > i3) {
                i4 = this.cgX.cgQ;
                i %= i4;
            }
            hashMap = c.cgO;
            str2 = this.cgX.QJ;
            a.C0079a a2 = com.baidu.tieba.tbadkCore.d.a.a("ad_tpoint", "PT", "FRS", (String) hashMap.get(Integer.valueOf(i)), "ad_plat", "CLICK", str2, str4, str5, null);
            a2.bT("obj_url", str);
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
        if (this.cgX.cfY != null) {
            String str2 = "";
            if (this.cgX.bRi != null) {
                str2 = this.cgX.bRi.getForumId();
            }
            if (i > 0) {
                i3 = this.cgX.cgQ;
                if (i3 > 1) {
                    i4 = this.cgX.cgQ;
                    if (i > i4) {
                        i5 = this.cgX.cgQ;
                        i %= i5;
                    }
                    hashSet = c.cgP;
                    if (hashSet.add(Integer.valueOf(i))) {
                        hashMap = c.cgO;
                        str = this.cgX.QJ;
                        a.C0079a a = com.baidu.tieba.tbadkCore.d.a.a("ad_tpoint", "PT", "FRS", (String) hashMap.get(Integer.valueOf(i)), "ad_plat", "VIEW_TRUE", str, str2, "", null);
                        if (rVar != null) {
                            a.bT("obj_url", rVar.getLinkUrl());
                        }
                        a.save();
                    }
                }
            }
            if (rVar == null || StringUtils.isNull(rVar.getTitle(), true)) {
                this.cgX.cfY.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                this.cgX.cfY.setText("");
                return;
            }
            TextView textView = this.cgX.cfY;
            i2 = this.cgX.drawablePadding;
            textView.setCompoundDrawablePadding(i2);
            TextView textView2 = this.cgX.cfY;
            drawable = this.cgX.cfZ;
            textView2.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
            this.cgX.cfY.setText(rVar.getTitle());
        }
    }
}
