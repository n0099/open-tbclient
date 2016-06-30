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
public class k implements com.baidu.tbadk.core.flow.a.d<com.baidu.tbadk.core.data.p> {
    final /* synthetic */ c bTP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(c cVar) {
        this.bTP = cVar;
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
        bi.us().c(this.bTP.Dp, new String[]{str});
        String str4 = "";
        String str5 = "";
        if (this.bTP.bET != null) {
            str4 = this.bTP.bET.getForumId();
            str5 = this.bTP.bET.getForumName();
        }
        if (i <= 0) {
            hashMap2 = c.bTH;
            str3 = this.bTP.NQ;
            a.C0077a a = com.baidu.tieba.tbadkCore.d.a.a("ad_tpoint", "PT", "FRS", (String) hashMap2.get(1), "ad_plat", "CLICK", str3, str4, str5, null);
            a.bM("obj_url", str);
            a.save();
            return;
        }
        i2 = this.bTP.bTJ;
        if (i2 > 1) {
            i3 = this.bTP.bTJ;
            if (i > i3) {
                i4 = this.bTP.bTJ;
                i %= i4;
            }
            hashMap = c.bTH;
            str2 = this.bTP.NQ;
            a.C0077a a2 = com.baidu.tieba.tbadkCore.d.a.a("ad_tpoint", "PT", "FRS", (String) hashMap.get(Integer.valueOf(i)), "ad_plat", "CLICK", str2, str4, str5, null);
            a2.bM("obj_url", str);
            a2.save();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.flow.a.d
    public void a(int i, com.baidu.tbadk.core.data.p pVar) {
        int i2;
        Drawable drawable;
        int i3;
        int i4;
        HashSet hashSet;
        HashMap hashMap;
        String str;
        int i5;
        if (this.bTP.bSS != null) {
            String str2 = "";
            if (this.bTP.bET != null) {
                str2 = this.bTP.bET.getForumId();
            }
            if (i > 0) {
                i3 = this.bTP.bTJ;
                if (i3 > 1) {
                    i4 = this.bTP.bTJ;
                    if (i > i4) {
                        i5 = this.bTP.bTJ;
                        i %= i5;
                    }
                    hashSet = c.bTI;
                    if (hashSet.add(Integer.valueOf(i))) {
                        hashMap = c.bTH;
                        str = this.bTP.NQ;
                        a.C0077a a = com.baidu.tieba.tbadkCore.d.a.a("ad_tpoint", "PT", "FRS", (String) hashMap.get(Integer.valueOf(i)), "ad_plat", "VIEW_TRUE", str, str2, "", null);
                        if (pVar != null) {
                            a.bM("obj_url", pVar.getLinkUrl());
                        }
                        a.save();
                    }
                }
            }
            if (pVar == null || StringUtils.isNull(pVar.getTitle(), true)) {
                this.bTP.bSS.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                this.bTP.bSS.setText("");
                return;
            }
            TextView textView = this.bTP.bSS;
            i2 = this.bTP.drawablePadding;
            textView.setCompoundDrawablePadding(i2);
            TextView textView2 = this.bTP.bSS;
            drawable = this.bTP.bST;
            textView2.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
            this.bTP.bSS.setText(pVar.getTitle());
        }
    }
}
