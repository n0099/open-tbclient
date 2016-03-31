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
public class j implements com.baidu.tbadk.core.flow.a.d<com.baidu.tbadk.core.data.n> {
    final /* synthetic */ b bwr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(b bVar) {
        this.bwr = bVar;
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
        bg.wM().c(this.bwr.MX, new String[]{str});
        String str4 = "";
        String str5 = "";
        if (this.bwr.blH != null) {
            str4 = this.bwr.blH.getForumId();
            str5 = this.bwr.blH.getForumName();
        }
        if (i <= 0) {
            hashMap2 = b.bwj;
            str3 = this.bwr.bwm;
            a.C0083a a = com.baidu.tieba.tbadkCore.d.a.a("ad_tpoint", "PT", "FRS", (String) hashMap2.get(1), "ad_plat", "CLICK", str3, str4, str5, null);
            a.bF("obj_url", str);
            a.save();
            return;
        }
        i2 = this.bwr.bwl;
        if (i2 > 1) {
            i3 = this.bwr.bwl;
            if (i > i3) {
                i4 = this.bwr.bwl;
                i %= i4;
            }
            hashMap = b.bwj;
            str2 = this.bwr.bwm;
            a.C0083a a2 = com.baidu.tieba.tbadkCore.d.a.a("ad_tpoint", "PT", "FRS", (String) hashMap.get(Integer.valueOf(i)), "ad_plat", "CLICK", str2, str4, str5, null);
            a2.bF("obj_url", str);
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
        if (this.bwr.bvw != null) {
            String str2 = "";
            if (this.bwr.blH != null) {
                str2 = this.bwr.blH.getForumId();
            }
            if (i > 0) {
                i3 = this.bwr.bwl;
                if (i3 > 1) {
                    i4 = this.bwr.bwl;
                    if (i > i4) {
                        i5 = this.bwr.bwl;
                        i %= i5;
                    }
                    hashSet = b.bwk;
                    if (hashSet.add(Integer.valueOf(i))) {
                        hashMap = b.bwj;
                        str = this.bwr.bwm;
                        a.C0083a a = com.baidu.tieba.tbadkCore.d.a.a("ad_tpoint", "PT", "FRS", (String) hashMap.get(Integer.valueOf(i)), "ad_plat", "VIEW_TRUE", str, str2, "", null);
                        if (nVar != null) {
                            a.bF("obj_url", nVar.getLinkUrl());
                        }
                        a.save();
                    }
                }
            }
            if (nVar == null || StringUtils.isNull(nVar.getTitle(), true)) {
                this.bwr.bvw.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                this.bwr.bvw.setText("");
                return;
            }
            TextView textView = this.bwr.bvw;
            i2 = this.bwr.drawablePadding;
            textView.setCompoundDrawablePadding(i2);
            TextView textView2 = this.bwr.bvw;
            drawable = this.bwr.bvx;
            textView2.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
            this.bwr.bvw.setText(nVar.getTitle());
        }
    }
}
