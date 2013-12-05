package com.baidu.tieba.home;

import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
class al implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ SearchActivity f1451a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(SearchActivity searchActivity) {
        this.f1451a = searchActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        String str;
        String str2;
        String str3;
        au auVar;
        au auVar2;
        try {
            str = this.f1451a.A;
            if (str != null) {
                str2 = this.f1451a.A;
                if (str2.length() > 0) {
                    StringBuffer stringBuffer = new StringBuffer(30);
                    stringBuffer.append(com.baidu.tieba.data.h.f1248a);
                    stringBuffer.append("c/f/forum/sug");
                    str3 = this.f1451a.A;
                    BasicNameValuePair basicNameValuePair = new BasicNameValuePair("q", str3.trim());
                    this.f1451a.a();
                    this.f1451a.y = new au(this.f1451a, stringBuffer.toString(), basicNameValuePair, true);
                    auVar = this.f1451a.y;
                    auVar.setPriority(3);
                    auVar2 = this.f1451a.y;
                    auVar2.execute(stringBuffer.toString(), basicNameValuePair);
                }
            }
        } catch (Exception e) {
            com.baidu.tieba.util.bd.b(getClass().getName(), "mSuggestRunnble.run", "error = " + e.getMessage());
        }
    }
}
