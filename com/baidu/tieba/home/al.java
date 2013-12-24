package com.baidu.tieba.home;

import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
class al implements Runnable {
    final /* synthetic */ SearchActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(SearchActivity searchActivity) {
        this.a = searchActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        String str;
        String str2;
        String str3;
        au auVar;
        au auVar2;
        try {
            str = this.a.A;
            if (str != null) {
                str2 = this.a.A;
                if (str2.length() > 0) {
                    StringBuffer stringBuffer = new StringBuffer(30);
                    stringBuffer.append(com.baidu.tieba.data.h.a);
                    stringBuffer.append("c/f/forum/sug");
                    str3 = this.a.A;
                    BasicNameValuePair basicNameValuePair = new BasicNameValuePair("q", str3.trim());
                    this.a.a();
                    this.a.y = new au(this.a, stringBuffer.toString(), basicNameValuePair, true);
                    auVar = this.a.y;
                    auVar.setPriority(3);
                    auVar2 = this.a.y;
                    auVar2.execute(stringBuffer.toString(), basicNameValuePair);
                }
            }
        } catch (Exception e) {
            com.baidu.tieba.util.be.b(getClass().getName(), "mSuggestRunnble.run", "error = " + e.getMessage());
        }
    }
}
