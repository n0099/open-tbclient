package com.baidu.tieba.home;

import com.baidu.tieba.util.av;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
class ac implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ SearchActivity f1194a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(SearchActivity searchActivity) {
        this.f1194a = searchActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        String str;
        String str2;
        String str3;
        al alVar;
        al alVar2;
        try {
            str = this.f1194a.D;
            if (str != null) {
                str2 = this.f1194a.D;
                if (str2.length() > 0) {
                    StringBuffer stringBuffer = new StringBuffer(30);
                    stringBuffer.append(com.baidu.tieba.data.g.f1032a);
                    stringBuffer.append("c/f/forum/sug");
                    str3 = this.f1194a.D;
                    BasicNameValuePair basicNameValuePair = new BasicNameValuePair("q", str3.trim());
                    this.f1194a.b();
                    this.f1194a.B = new al(this.f1194a, stringBuffer.toString(), basicNameValuePair, true);
                    alVar = this.f1194a.B;
                    alVar.setPriority(3);
                    alVar2 = this.f1194a.B;
                    alVar2.execute(stringBuffer.toString(), basicNameValuePair);
                }
            }
        } catch (Exception e) {
            av.b(getClass().getName(), "mSuggestRunnble.run", "error = " + e.getMessage());
        }
    }
}
