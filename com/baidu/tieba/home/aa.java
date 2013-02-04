package com.baidu.tieba.home;

import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
class aa implements Runnable {
    final /* synthetic */ SearchActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(SearchActivity searchActivity) {
        this.a = searchActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        String str;
        String str2;
        String str3;
        an anVar;
        try {
            str = this.a.r;
            if (str != null) {
                str2 = this.a.r;
                if (str2.length() > 0) {
                    StringBuffer stringBuffer = new StringBuffer(30);
                    stringBuffer.append("http://c.tieba.baidu.com/");
                    stringBuffer.append("c/f/forum/sug");
                    str3 = this.a.r;
                    BasicNameValuePair basicNameValuePair = new BasicNameValuePair("q", str3);
                    this.a.g();
                    this.a.q = new an(this.a, stringBuffer.toString(), basicNameValuePair, true);
                    anVar = this.a.q;
                    anVar.execute(stringBuffer.toString(), basicNameValuePair);
                }
            }
        } catch (Exception e) {
            com.baidu.tieba.c.ae.b(getClass().getName(), "mSuggestRunnble.run", "error = " + e.getMessage());
        }
    }
}
