package com.baidu.tieba.frs.view;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.b.af;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class b implements View.OnClickListener {
    final /* synthetic */ a a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.a = aVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        TextView textView;
        com.baidu.tbadk.core.data.f fVar;
        com.baidu.tbadk.core.data.f fVar2;
        com.baidu.tbadk.core.data.f fVar3;
        com.baidu.tbadk.core.data.f fVar4;
        com.baidu.tbadk.core.data.f fVar5;
        com.baidu.tbadk.core.data.f fVar6;
        Context context;
        Context context2;
        Context context3;
        Context context4;
        Pattern pattern;
        Context context5;
        Context context6;
        Context context7;
        Context context8;
        Context context9;
        Context context10;
        Context context11;
        d dVar;
        d dVar2;
        textView = this.a.c;
        if (view != textView) {
            fVar = this.a.f;
            String c = fVar.c();
            fVar2 = this.a.f;
            if (fVar2 != null) {
                fVar3 = this.a.f;
                if (fVar3.a() == 1) {
                    context11 = this.a.d;
                    com.baidu.adp.framework.c.a().a(new com.baidu.adp.framework.message.a(2001001, new com.baidu.tbadk.core.b.i(context11, c, false, "frs_banner")));
                    return;
                }
                fVar4 = this.a.f;
                if (fVar4.a() != 2) {
                    fVar5 = this.a.f;
                    if (fVar5.a() == 3) {
                        context4 = this.a.d;
                        com.baidu.tbadk.browser.a.a(context4, c);
                        return;
                    }
                    fVar6 = this.a.f;
                    if (fVar6.a() == 4) {
                        context = this.a.d;
                        if (context instanceof com.baidu.tbadk.a) {
                            context2 = this.a.d;
                            context3 = this.a.d;
                            ((com.baidu.tbadk.a) context2).sendMessage(new com.baidu.adp.framework.message.a(2003000, new com.baidu.tbadk.core.b.l(context3).a(c, "frs_banner")));
                            return;
                        }
                        return;
                    }
                    return;
                } else if (c.contains("tieba.baidu.com")) {
                    pattern = a.i;
                    Matcher matcher = pattern.matcher(c);
                    if (matcher.find()) {
                        try {
                            String group = matcher.group(2);
                            context5 = this.a.d;
                            if (context5 instanceof com.baidu.tbadk.core.e) {
                                context9 = this.a.d;
                                context10 = this.a.d;
                                ((com.baidu.tbadk.core.e) context9).a(new com.baidu.adp.framework.message.a(2004001, new af(context10).a(group, null, "frs_banner")));
                            } else {
                                context6 = this.a.d;
                                if (context6 instanceof com.baidu.tbadk.a) {
                                    context7 = this.a.d;
                                    context8 = this.a.d;
                                    ((com.baidu.tbadk.a) context7).sendMessage(new com.baidu.adp.framework.message.a(2004001, new af(context8).a(group, null, "frs_banner")));
                                }
                            }
                            return;
                        } catch (Exception e) {
                            com.baidu.adp.lib.util.f.b(getClass().getName(), "onClick", e.toString());
                            return;
                        }
                    }
                    return;
                } else {
                    return;
                }
            }
            return;
        }
        this.a.g = true;
        this.a.setVisibility(8);
        com.baidu.tieba.p.c();
        com.baidu.tieba.p.a(System.currentTimeMillis());
        dVar = this.a.h;
        if (dVar != null) {
            dVar2 = this.a.h;
            dVar2.a(true);
        }
    }
}
