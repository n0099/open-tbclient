package com.baidu.tieba.frs.view;

import android.graphics.drawable.Drawable;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.bb;
import com.baidu.tieba.tbadkCore.d.a;
import java.util.HashMap;
import java.util.HashSet;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements com.baidu.tbadk.core.flow.a.d<com.baidu.tbadk.core.data.t> {
    final /* synthetic */ c cgf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(c cVar) {
        this.cgf = cVar;
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
        bb.wn().c(this.cgf.aaY, new String[]{str});
        String str4 = "";
        String str5 = "";
        if (this.cgf.bQw != null) {
            str4 = this.cgf.bQw.getForumId();
            str5 = this.cgf.bQw.getForumName();
        }
        if (i <= 0) {
            hashMap2 = c.cfW;
            str3 = this.cgf.VR;
            a.C0074a a = com.baidu.tieba.tbadkCore.d.a.a("ad_tpoint", "PT", "FRS", (String) hashMap2.get(1), "ad_plat", "CLICK", str3, str4, str5, null);
            a.cb("obj_url", str);
            a.save();
            return;
        }
        i2 = this.cgf.cfY;
        if (i2 > 1) {
            i3 = this.cgf.cfY;
            if (i > i3) {
                i4 = this.cgf.cfY;
                i %= i4;
            }
            hashMap = c.cfW;
            str2 = this.cgf.VR;
            a.C0074a a2 = com.baidu.tieba.tbadkCore.d.a.a("ad_tpoint", "PT", "FRS", (String) hashMap.get(Integer.valueOf(i)), "ad_plat", "CLICK", str2, str4, str5, null);
            a2.cb("obj_url", str);
            a2.save();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.flow.a.d
    public void a(int i, com.baidu.tbadk.core.data.t tVar) {
        int i2;
        Drawable drawable;
        int i3;
        int i4;
        HashSet hashSet;
        HashMap hashMap;
        String str;
        int i5;
        if (this.cgf.cfh != null) {
            String str2 = "";
            if (this.cgf.bQw != null) {
                str2 = this.cgf.bQw.getForumId();
            }
            if (i > 0) {
                i3 = this.cgf.cfY;
                if (i3 > 1) {
                    i4 = this.cgf.cfY;
                    if (i > i4) {
                        i5 = this.cgf.cfY;
                        i %= i5;
                    }
                    hashSet = c.cfX;
                    if (hashSet.add(Integer.valueOf(i))) {
                        hashMap = c.cfW;
                        str = this.cgf.VR;
                        a.C0074a a = com.baidu.tieba.tbadkCore.d.a.a("ad_tpoint", "PT", "FRS", (String) hashMap.get(Integer.valueOf(i)), "ad_plat", "VIEW_TRUE", str, str2, "", null);
                        if (tVar != null) {
                            a.cb("obj_url", tVar.getLinkUrl());
                        }
                        a.save();
                    }
                }
            }
            if (tVar == null || StringUtils.isNull(tVar.getTitle(), true)) {
                this.cgf.cfh.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                this.cgf.cfh.setText("");
                return;
            }
            TextView textView = this.cgf.cfh;
            i2 = this.cgf.drawablePadding;
            textView.setCompoundDrawablePadding(i2);
            TextView textView2 = this.cgf.cfh;
            drawable = this.cgf.cfi;
            textView2.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
            this.cgf.cfh.setText(tVar.getTitle());
        }
    }
}
