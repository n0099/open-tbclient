package com.baidu.tieba.home;

import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
class ah implements Runnable {
    final /* synthetic */ SearchActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(SearchActivity searchActivity) {
        this.a = searchActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        String str;
        String str2;
        String str3;
        aw awVar;
        try {
            str = this.a.x;
            if (str != null) {
                str2 = this.a.x;
                if (str2.length() > 0) {
                    StringBuffer stringBuffer = new StringBuffer(30);
                    stringBuffer.append("http://c.tieba.baidu.com/");
                    stringBuffer.append("c/f/forum/sug");
                    str3 = this.a.x;
                    BasicNameValuePair basicNameValuePair = new BasicNameValuePair("q", str3.trim());
                    this.a.i();
                    this.a.v = new aw(this.a, stringBuffer.toString(), basicNameValuePair, true);
                    awVar = this.a.v;
                    awVar.execute(stringBuffer.toString(), basicNameValuePair);
                }
            }
        } catch (Exception e) {
            com.baidu.tieba.c.ag.b(getClass().getName(), "mSuggestRunnble.run", "error = " + e.getMessage());
        }
    }
}
