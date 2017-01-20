package com.baidu.tieba.frs.view;

import android.graphics.drawable.Drawable;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tieba.tbadkCore.d.a;
import java.util.HashMap;
import java.util.HashSet;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements com.baidu.tbadk.core.flow.a.d<com.baidu.tbadk.core.data.s> {
    final /* synthetic */ c bXS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(c cVar) {
        this.bXS = cVar;
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
        ba.vt().c(this.bXS.Fp, new String[]{str});
        String str4 = "";
        String str5 = "";
        if (this.bXS.bHh != null) {
            str4 = this.bXS.bHh.getForumId();
            str5 = this.bXS.bHh.getForumName();
        }
        if (i <= 0) {
            hashMap2 = c.bXI;
            str3 = this.bXS.Ql;
            a.C0076a a = com.baidu.tieba.tbadkCore.d.a.a("ad_tpoint", "PT", "FRS", (String) hashMap2.get(1), "ad_plat", "CLICK", str3, str4, str5, null);
            a.ch("obj_url", str);
            a.save();
            return;
        }
        i2 = this.bXS.bXK;
        if (i2 > 1) {
            i3 = this.bXS.bXK;
            if (i > i3) {
                i4 = this.bXS.bXK;
                i %= i4;
            }
            hashMap = c.bXI;
            str2 = this.bXS.Ql;
            a.C0076a a2 = com.baidu.tieba.tbadkCore.d.a.a("ad_tpoint", "PT", "FRS", (String) hashMap.get(Integer.valueOf(i)), "ad_plat", "CLICK", str2, str4, str5, null);
            a2.ch("obj_url", str);
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
        if (this.bXS.bWR != null) {
            String str2 = "";
            if (this.bXS.bHh != null) {
                str2 = this.bXS.bHh.getForumId();
            }
            if (i > 0) {
                i3 = this.bXS.bXK;
                if (i3 > 1) {
                    i4 = this.bXS.bXK;
                    if (i > i4) {
                        i5 = this.bXS.bXK;
                        i %= i5;
                    }
                    hashSet = c.bXJ;
                    if (hashSet.add(Integer.valueOf(i))) {
                        hashMap = c.bXI;
                        str = this.bXS.Ql;
                        a.C0076a a = com.baidu.tieba.tbadkCore.d.a.a("ad_tpoint", "PT", "FRS", (String) hashMap.get(Integer.valueOf(i)), "ad_plat", "VIEW_TRUE", str, str2, "", null);
                        if (sVar != null) {
                            a.ch("obj_url", sVar.getLinkUrl());
                        }
                        a.save();
                    }
                }
            }
            if (sVar == null || StringUtils.isNull(sVar.getTitle(), true)) {
                this.bXS.bWR.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                this.bXS.bWR.setText("");
                return;
            }
            TextView textView = this.bXS.bWR;
            i2 = this.bXS.drawablePadding;
            textView.setCompoundDrawablePadding(i2);
            TextView textView2 = this.bXS.bWR;
            drawable = this.bXS.bWS;
            textView2.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
            this.bXS.bWR.setText(sVar.getTitle());
        }
    }
}
