package com.baidu.tieba.frs.view;

import android.graphics.drawable.Drawable;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.bi;
import com.baidu.tieba.tbadkCore.d.a;
import java.util.HashMap;
import java.util.HashSet;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements com.baidu.tbadk.core.flow.a.d<com.baidu.tbadk.core.data.r> {
    final /* synthetic */ c cgZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(c cVar) {
        this.cgZ = cVar;
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
        bi.vx().c(this.cgZ.Gd, new String[]{str});
        String str4 = "";
        String str5 = "";
        if (this.cgZ.bRp != null) {
            str4 = this.cgZ.bRp.getForumId();
            str5 = this.cgZ.bRp.getForumName();
        }
        if (i <= 0) {
            hashMap2 = c.cgQ;
            str3 = this.cgZ.QF;
            a.C0076a a = com.baidu.tieba.tbadkCore.d.a.a("ad_tpoint", "PT", "FRS", (String) hashMap2.get(1), "ad_plat", "CLICK", str3, str4, str5, null);
            a.bS("obj_url", str);
            a.save();
            return;
        }
        i2 = this.cgZ.cgS;
        if (i2 > 1) {
            i3 = this.cgZ.cgS;
            if (i > i3) {
                i4 = this.cgZ.cgS;
                i %= i4;
            }
            hashMap = c.cgQ;
            str2 = this.cgZ.QF;
            a.C0076a a2 = com.baidu.tieba.tbadkCore.d.a.a("ad_tpoint", "PT", "FRS", (String) hashMap.get(Integer.valueOf(i)), "ad_plat", "CLICK", str2, str4, str5, null);
            a2.bS("obj_url", str);
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
        if (this.cgZ.cgb != null) {
            String str2 = "";
            if (this.cgZ.bRp != null) {
                str2 = this.cgZ.bRp.getForumId();
            }
            if (i > 0) {
                i3 = this.cgZ.cgS;
                if (i3 > 1) {
                    i4 = this.cgZ.cgS;
                    if (i > i4) {
                        i5 = this.cgZ.cgS;
                        i %= i5;
                    }
                    hashSet = c.cgR;
                    if (hashSet.add(Integer.valueOf(i))) {
                        hashMap = c.cgQ;
                        str = this.cgZ.QF;
                        a.C0076a a = com.baidu.tieba.tbadkCore.d.a.a("ad_tpoint", "PT", "FRS", (String) hashMap.get(Integer.valueOf(i)), "ad_plat", "VIEW_TRUE", str, str2, "", null);
                        if (rVar != null) {
                            a.bS("obj_url", rVar.getLinkUrl());
                        }
                        a.save();
                    }
                }
            }
            if (rVar == null || StringUtils.isNull(rVar.getTitle(), true)) {
                this.cgZ.cgb.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                this.cgZ.cgb.setText("");
                return;
            }
            TextView textView = this.cgZ.cgb;
            i2 = this.cgZ.drawablePadding;
            textView.setCompoundDrawablePadding(i2);
            TextView textView2 = this.cgZ.cgb;
            drawable = this.cgZ.cgc;
            textView2.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
            this.cgZ.cgb.setText(rVar.getTitle());
        }
    }
}
