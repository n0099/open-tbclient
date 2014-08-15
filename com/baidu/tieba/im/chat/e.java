package com.baidu.tieba.im.chat;

import android.text.TextUtils;
import android.widget.TextView;
import com.baidu.tbadk.coreExtra.view.MultiImageView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements bs {
    final /* synthetic */ AbsMsgImageActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(AbsMsgImageActivity absMsgImageActivity) {
        this.a = absMsgImageActivity;
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x0015, code lost:
        if (r0 != false) goto L40;
     */
    @Override // com.baidu.tieba.im.chat.bs
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(LinkedHashMap<String, String> linkedHashMap) {
        LinkedHashMap linkedHashMap2;
        LinkedHashMap linkedHashMap3;
        LinkedHashMap linkedHashMap4;
        String str;
        LinkedHashMap linkedHashMap5;
        boolean z;
        LinkedHashMap linkedHashMap6;
        TextView textView;
        MultiImageView multiImageView;
        MultiImageView multiImageView2;
        MultiImageView multiImageView3;
        LinkedHashMap linkedHashMap7;
        MultiImageView multiImageView4;
        int i;
        int i2;
        String str2;
        LinkedHashMap linkedHashMap8;
        String str3;
        String str4;
        boolean z2;
        this.a.b = linkedHashMap;
        linkedHashMap2 = this.a.b;
        if (linkedHashMap2 != null) {
            z2 = this.a.x;
        }
        this.a.b = new LinkedHashMap();
        linkedHashMap3 = this.a.b;
        if (linkedHashMap3.isEmpty()) {
            str2 = this.a.r;
            if (!TextUtils.isEmpty(str2)) {
                linkedHashMap8 = this.a.b;
                str3 = this.a.t;
                str4 = this.a.r;
                linkedHashMap8.put(str3, str4);
            }
        }
        linkedHashMap4 = this.a.b;
        if (linkedHashMap4.size() != 0) {
            str = this.a.t;
            linkedHashMap5 = this.a.b;
            Iterator it = linkedHashMap5.keySet().iterator();
            int i3 = 0;
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                String str5 = (String) it.next();
                if (!TextUtils.isEmpty(str5) && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str5) && str5.equals(str)) {
                    this.a.c = i3;
                    z = true;
                    break;
                }
                i3++;
            }
            AbsMsgImageActivity absMsgImageActivity = this.a;
            linkedHashMap6 = this.a.b;
            absMsgImageActivity.q = linkedHashMap6.size();
            if (!z) {
                AbsMsgImageActivity absMsgImageActivity2 = this.a;
                i2 = this.a.q;
                absMsgImageActivity2.c = i2 - 1;
            }
            textView = this.a.h;
            textView.setVisibility(0);
            this.a.b();
            multiImageView = this.a.j;
            multiImageView.setIsFromCDN(true);
            multiImageView2 = this.a.j;
            multiImageView2.setAllowLocalUrl(true);
            multiImageView3 = this.a.j;
            linkedHashMap7 = this.a.b;
            multiImageView3.setUrlData(new ArrayList<>(linkedHashMap7.values()));
            multiImageView4 = this.a.j;
            i = this.a.c;
            multiImageView4.a(i, false);
            return;
        }
        this.a.finish();
    }
}
