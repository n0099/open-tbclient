package com.baidu.tieba.frs.view;

import android.graphics.drawable.Drawable;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tieba.tbadkCore.d.a;
import java.util.HashMap;
import java.util.HashSet;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements com.baidu.tbadk.core.flow.a.d<com.baidu.tbadk.core.data.n> {
    final /* synthetic */ c bwe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(c cVar) {
        this.bwe = cVar;
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
        bg.us().c(this.bwe.Do, new String[]{str});
        String str4 = "";
        String str5 = "";
        if (this.bwe.bjB != null) {
            str4 = this.bwe.bjB.getForumId();
            str5 = this.bwe.bjB.getForumName();
        }
        if (i <= 0) {
            hashMap2 = c.bvW;
            str3 = this.bwe.NS;
            a.C0075a a = com.baidu.tieba.tbadkCore.d.a.a("ad_tpoint", "PT", "FRS", (String) hashMap2.get(1), "ad_plat", "CLICK", str3, str4, str5, null);
            a.bK("obj_url", str);
            a.save();
            return;
        }
        i2 = this.bwe.bvY;
        if (i2 > 1) {
            i3 = this.bwe.bvY;
            if (i > i3) {
                i4 = this.bwe.bvY;
                i %= i4;
            }
            hashMap = c.bvW;
            str2 = this.bwe.NS;
            a.C0075a a2 = com.baidu.tieba.tbadkCore.d.a.a("ad_tpoint", "PT", "FRS", (String) hashMap.get(Integer.valueOf(i)), "ad_plat", "CLICK", str2, str4, str5, null);
            a2.bK("obj_url", str);
            a2.save();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.flow.a.d
    public void a(int i, com.baidu.tbadk.core.data.n nVar) {
        int i2;
        Drawable drawable;
        int i3;
        int i4;
        HashSet hashSet;
        HashMap hashMap;
        String str;
        int i5;
        if (this.bwe.bvl != null) {
            String str2 = "";
            if (this.bwe.bjB != null) {
                str2 = this.bwe.bjB.getForumId();
            }
            if (i > 0) {
                i3 = this.bwe.bvY;
                if (i3 > 1) {
                    i4 = this.bwe.bvY;
                    if (i > i4) {
                        i5 = this.bwe.bvY;
                        i %= i5;
                    }
                    hashSet = c.bvX;
                    if (hashSet.add(Integer.valueOf(i))) {
                        hashMap = c.bvW;
                        str = this.bwe.NS;
                        a.C0075a a = com.baidu.tieba.tbadkCore.d.a.a("ad_tpoint", "PT", "FRS", (String) hashMap.get(Integer.valueOf(i)), "ad_plat", "VIEW_TRUE", str, str2, "", null);
                        if (nVar != null) {
                            a.bK("obj_url", nVar.getLinkUrl());
                        }
                        a.save();
                    }
                }
            }
            if (nVar == null || StringUtils.isNull(nVar.getTitle(), true)) {
                this.bwe.bvl.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                this.bwe.bvl.setText("");
                return;
            }
            TextView textView = this.bwe.bvl;
            i2 = this.bwe.drawablePadding;
            textView.setCompoundDrawablePadding(i2);
            TextView textView2 = this.bwe.bvl;
            drawable = this.bwe.bvm;
            textView2.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
            this.bwe.bvl.setText(nVar.getTitle());
        }
    }
}
