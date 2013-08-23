package com.baidu.tieba.home;

import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
class aq implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ SearchActivity f1162a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aq(SearchActivity searchActivity) {
        this.f1162a = searchActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        String str;
        String str2;
        String str3;
        az azVar;
        az azVar2;
        try {
            str = this.f1162a.D;
            if (str != null) {
                str2 = this.f1162a.D;
                if (str2.length() > 0) {
                    StringBuffer stringBuffer = new StringBuffer(30);
                    stringBuffer.append(com.baidu.tieba.data.g.f1014a);
                    stringBuffer.append("c/f/forum/sug");
                    str3 = this.f1162a.D;
                    BasicNameValuePair basicNameValuePair = new BasicNameValuePair("q", str3.trim());
                    this.f1162a.b();
                    this.f1162a.B = new az(this.f1162a, stringBuffer.toString(), basicNameValuePair, true);
                    azVar = this.f1162a.B;
                    azVar.setPriority(3);
                    azVar2 = this.f1162a.B;
                    azVar2.execute(stringBuffer.toString(), basicNameValuePair);
                }
            }
        } catch (Exception e) {
            com.baidu.tieba.util.aq.b(getClass().getName(), "mSuggestRunnble.run", "error = " + e.getMessage());
        }
    }
}
