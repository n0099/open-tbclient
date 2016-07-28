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
public class k implements com.baidu.tbadk.core.flow.a.d<com.baidu.tbadk.core.data.q> {
    final /* synthetic */ c bVP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(c cVar) {
        this.bVP = cVar;
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
        bi.us().c(this.bVP.DQ, new String[]{str});
        String str4 = "";
        String str5 = "";
        if (this.bVP.bGh != null) {
            str4 = this.bVP.bGh.getForumId();
            str5 = this.bVP.bGh.getForumName();
        }
        if (i <= 0) {
            hashMap2 = c.bVH;
            str3 = this.bVP.NX;
            a.C0076a a = com.baidu.tieba.tbadkCore.d.a.a("ad_tpoint", "PT", "FRS", (String) hashMap2.get(1), "ad_plat", "CLICK", str3, str4, str5, null);
            a.bR("obj_url", str);
            a.save();
            return;
        }
        i2 = this.bVP.bVJ;
        if (i2 > 1) {
            i3 = this.bVP.bVJ;
            if (i > i3) {
                i4 = this.bVP.bVJ;
                i %= i4;
            }
            hashMap = c.bVH;
            str2 = this.bVP.NX;
            a.C0076a a2 = com.baidu.tieba.tbadkCore.d.a.a("ad_tpoint", "PT", "FRS", (String) hashMap.get(Integer.valueOf(i)), "ad_plat", "CLICK", str2, str4, str5, null);
            a2.bR("obj_url", str);
            a2.save();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.flow.a.d
    public void a(int i, com.baidu.tbadk.core.data.q qVar) {
        int i2;
        Drawable drawable;
        int i3;
        int i4;
        HashSet hashSet;
        HashMap hashMap;
        String str;
        int i5;
        if (this.bVP.bUS != null) {
            String str2 = "";
            if (this.bVP.bGh != null) {
                str2 = this.bVP.bGh.getForumId();
            }
            if (i > 0) {
                i3 = this.bVP.bVJ;
                if (i3 > 1) {
                    i4 = this.bVP.bVJ;
                    if (i > i4) {
                        i5 = this.bVP.bVJ;
                        i %= i5;
                    }
                    hashSet = c.bVI;
                    if (hashSet.add(Integer.valueOf(i))) {
                        hashMap = c.bVH;
                        str = this.bVP.NX;
                        a.C0076a a = com.baidu.tieba.tbadkCore.d.a.a("ad_tpoint", "PT", "FRS", (String) hashMap.get(Integer.valueOf(i)), "ad_plat", "VIEW_TRUE", str, str2, "", null);
                        if (qVar != null) {
                            a.bR("obj_url", qVar.getLinkUrl());
                        }
                        a.save();
                    }
                }
            }
            if (qVar == null || StringUtils.isNull(qVar.getTitle(), true)) {
                this.bVP.bUS.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                this.bVP.bUS.setText("");
                return;
            }
            TextView textView = this.bVP.bUS;
            i2 = this.bVP.drawablePadding;
            textView.setCompoundDrawablePadding(i2);
            TextView textView2 = this.bVP.bUS;
            drawable = this.bVP.bUT;
            textView2.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
            this.bVP.bUS.setText(qVar.getTitle());
        }
    }
}
