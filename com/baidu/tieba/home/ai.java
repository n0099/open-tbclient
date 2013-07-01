package com.baidu.tieba.home;

import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
class ai implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ SearchActivity f897a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(SearchActivity searchActivity) {
        this.f897a = searchActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        String str;
        String str2;
        String str3;
        ay ayVar;
        ay ayVar2;
        try {
            str = this.f897a.A;
            if (str != null) {
                str2 = this.f897a.A;
                if (str2.length() > 0) {
                    StringBuffer stringBuffer = new StringBuffer(30);
                    stringBuffer.append(com.baidu.tieba.data.g.f787a);
                    stringBuffer.append("c/f/forum/sug");
                    str3 = this.f897a.A;
                    BasicNameValuePair basicNameValuePair = new BasicNameValuePair("q", str3.trim());
                    this.f897a.b();
                    this.f897a.y = new ay(this.f897a, stringBuffer.toString(), basicNameValuePair, true);
                    ayVar = this.f897a.y;
                    ayVar.setPriority(3);
                    ayVar2 = this.f897a.y;
                    ayVar2.execute(stringBuffer.toString(), basicNameValuePair);
                }
            }
        } catch (Exception e) {
            com.baidu.tieba.util.z.b(getClass().getName(), "mSuggestRunnble.run", "error = " + e.getMessage());
        }
    }
}
