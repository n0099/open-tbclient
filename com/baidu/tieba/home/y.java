package com.baidu.tieba.home;

import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
class y implements Runnable {
    final /* synthetic */ SearchActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(SearchActivity searchActivity) {
        this.a = searchActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        String str;
        String str2;
        String str3;
        ao aoVar;
        ao aoVar2;
        try {
            str = this.a.A;
            if (str != null) {
                str2 = this.a.A;
                if (str2.length() > 0) {
                    StringBuffer stringBuffer = new StringBuffer(30);
                    stringBuffer.append(com.baidu.tieba.a.i.e);
                    stringBuffer.append("c/f/forum/sug");
                    str3 = this.a.A;
                    BasicNameValuePair basicNameValuePair = new BasicNameValuePair("q", str3.trim());
                    this.a.b();
                    this.a.y = new ao(this.a, stringBuffer.toString(), basicNameValuePair, true);
                    aoVar = this.a.y;
                    aoVar.setPriority(3);
                    aoVar2 = this.a.y;
                    aoVar2.execute(stringBuffer.toString(), basicNameValuePair);
                }
            }
        } catch (Exception e) {
            com.baidu.tieba.d.ae.b(getClass().getName(), "mSuggestRunnble.run", "error = " + e.getMessage());
        }
    }
}
