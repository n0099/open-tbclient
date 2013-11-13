package com.baidu.tieba.home;

import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
class aq implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ SearchActivity f1410a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aq(SearchActivity searchActivity) {
        this.f1410a = searchActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        String str;
        String str2;
        String str3;
        az azVar;
        az azVar2;
        try {
            str = this.f1410a.A;
            if (str != null) {
                str2 = this.f1410a.A;
                if (str2.length() > 0) {
                    StringBuffer stringBuffer = new StringBuffer(30);
                    stringBuffer.append(com.baidu.tieba.data.h.f1196a);
                    stringBuffer.append("c/f/forum/sug");
                    str3 = this.f1410a.A;
                    BasicNameValuePair basicNameValuePair = new BasicNameValuePair("q", str3.trim());
                    this.f1410a.a();
                    this.f1410a.y = new az(this.f1410a, stringBuffer.toString(), basicNameValuePair, true);
                    azVar = this.f1410a.y;
                    azVar.setPriority(3);
                    azVar2 = this.f1410a.y;
                    azVar2.execute(stringBuffer.toString(), basicNameValuePair);
                }
            }
        } catch (Exception e) {
            com.baidu.tieba.util.bg.b(getClass().getName(), "mSuggestRunnble.run", "error = " + e.getMessage());
        }
    }
}
