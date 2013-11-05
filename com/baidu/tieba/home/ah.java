package com.baidu.tieba.home;

import com.baidu.tieba.util.be;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
class ah implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ SearchActivity f1334a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(SearchActivity searchActivity) {
        this.f1334a = searchActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        String str;
        String str2;
        String str3;
        aq aqVar;
        aq aqVar2;
        try {
            str = this.f1334a.D;
            if (str != null) {
                str2 = this.f1334a.D;
                if (str2.length() > 0) {
                    StringBuffer stringBuffer = new StringBuffer(30);
                    stringBuffer.append(com.baidu.tieba.data.h.f1165a);
                    stringBuffer.append("c/f/forum/sug");
                    str3 = this.f1334a.D;
                    BasicNameValuePair basicNameValuePair = new BasicNameValuePair("q", str3.trim());
                    this.f1334a.b();
                    this.f1334a.B = new aq(this.f1334a, stringBuffer.toString(), basicNameValuePair, true);
                    aqVar = this.f1334a.B;
                    aqVar.setPriority(3);
                    aqVar2 = this.f1334a.B;
                    aqVar2.execute(stringBuffer.toString(), basicNameValuePair);
                }
            }
        } catch (Exception e) {
            be.b(getClass().getName(), "mSuggestRunnble.run", "error = " + e.getMessage());
        }
    }
}
