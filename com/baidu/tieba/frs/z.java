package com.baidu.tieba.frs;

import android.graphics.Color;
import android.os.AsyncTask;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z extends AsyncTask {
    ArrayList a;
    final /* synthetic */ FrsActivity b;
    private String d;
    private int e;
    private com.baidu.tieba.c.t c = null;
    private volatile long f = 0;

    public z(FrsActivity frsActivity, String str, ArrayList arrayList, int i) {
        this.b = frsActivity;
        this.d = null;
        this.e = 3;
        this.a = null;
        this.d = str;
        this.a = arrayList;
        this.e = i;
    }

    @Override // android.os.AsyncTask
    protected void onPreExecute() {
        aa aaVar;
        aa aaVar2;
        aa aaVar3;
        aa aaVar4;
        this.b.x();
        this.f = System.nanoTime();
        switch (this.e) {
            case 1:
                aaVar3 = this.b.y;
                aaVar3.b(true);
                aaVar4 = this.b.y;
                aaVar4.notifyDataSetChanged();
                return;
            case 2:
                aaVar = this.b.y;
                aaVar.c(true);
                aaVar2 = this.b.y;
                aaVar2.notifyDataSetChanged();
                return;
            case 3:
                this.b.a(true);
                return;
            default:
                return;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public com.baidu.tieba.b.c doInBackground(Object... objArr) {
        com.baidu.tieba.b.c cVar;
        Exception e;
        long j;
        long j2;
        int i;
        int i2;
        long j3;
        long j4;
        try {
            this.c = new com.baidu.tieba.c.t(this.d);
            this.c.a(this.a);
            j = FrsActivity.P;
            if (j != 0) {
                com.baidu.tieba.c.t tVar = this.c;
                j4 = FrsActivity.P;
                tVar.a("ctime", String.valueOf(j4));
            }
            j2 = FrsActivity.Q;
            if (j2 != 0) {
                com.baidu.tieba.c.t tVar2 = this.c;
                j3 = FrsActivity.Q;
                tVar2.a("data_size", String.valueOf(j3));
            }
            i = FrsActivity.R;
            if (i != 0) {
                com.baidu.tieba.c.t tVar3 = this.c;
                i2 = FrsActivity.R;
                tVar3.a("net_error", String.valueOf(i2));
            }
            this.c.a(this.b);
            String i3 = this.c.i();
            if (!this.c.b()) {
                cVar = null;
            } else {
                com.baidu.tieba.b.c cVar2 = new com.baidu.tieba.b.c();
                try {
                    cVar2.a(i3);
                    cVar = cVar2;
                } catch (Exception e2) {
                    e = e2;
                    cVar = cVar2;
                    com.baidu.tieba.c.ag.b(getClass().getName(), "", "FrsAsyncTask.doInBackground error = " + e.getMessage());
                    return cVar;
                }
            }
            try {
                if (this.c.c()) {
                    FrsActivity.P = 0L;
                    FrsActivity.Q = 0L;
                    FrsActivity.R = 0;
                } else {
                    FrsActivity.R = 1;
                }
            } catch (Exception e3) {
                e = e3;
                com.baidu.tieba.c.ag.b(getClass().getName(), "", "FrsAsyncTask.doInBackground error = " + e.getMessage());
                return cVar;
            }
        } catch (Exception e4) {
            cVar = null;
            e = e4;
        }
        return cVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public void onPostExecute(com.baidu.tieba.b.c cVar) {
        aa aaVar;
        aa aaVar2;
        aa aaVar3;
        aa aaVar4;
        switch (this.e) {
            case 1:
                aaVar3 = this.b.y;
                aaVar3.b(false);
                aaVar4 = this.b.y;
                aaVar4.notifyDataSetChanged();
                break;
            case 2:
                aaVar = this.b.y;
                aaVar.c(false);
                aaVar2 = this.b.y;
                aaVar2.notifyDataSetChanged();
                break;
            case 3:
                this.b.a(false);
                break;
        }
        if (cVar != null) {
            this.b.A = cVar;
            this.b.B();
            FrsActivity.P = (System.nanoTime() - this.f) / 1000000;
            if (this.c != null) {
                FrsActivity.Q = this.c.a();
            }
        } else {
            b();
        }
        this.b.z = null;
        this.b.J = null;
        System.gc();
    }

    @Override // android.os.AsyncTask
    protected void onCancelled() {
        super.onCancelled();
    }

    public void a() {
        if (this.c != null) {
            this.c.g();
        }
        super.cancel(true);
    }

    private void b() {
        boolean z;
        LinearLayout linearLayout;
        TextView textView;
        String str;
        String str2;
        LinearLayout linearLayout2;
        TextView textView2;
        LinearLayout linearLayout3;
        LinearLayout linearLayout4;
        TextView textView3;
        ImageView imageView;
        ListView listView;
        Button button;
        Button button2;
        Button button3;
        Button button4;
        LinearLayout linearLayout5;
        z = this.b.e;
        if (z) {
            if (this.c != null) {
                if (this.c.c()) {
                    if (this.c.d() == 3) {
                        this.b.n = false;
                        textView = this.b.C;
                        textView.setText(R.string.frs_noforum);
                        FrsActivity frsActivity = this.b;
                        str = this.b.g;
                        frsActivity.g = str.replace(" ", "");
                        str2 = this.b.g;
                        if (str2.length() > 31) {
                            str2 = String.valueOf(str2.substring(0, 31)) + "...";
                        }
                        SpannableString spannableString = new SpannableString(String.valueOf(str2) + this.b.getString(R.string.frs_remind_noforum));
                        spannableString.setSpan(new ForegroundColorSpan(Color.rgb(229, 4, 0)), 0, str2.length(), 33);
                        linearLayout2 = this.b.D;
                        linearLayout2.setVisibility(0);
                        textView2 = this.b.E;
                        textView2.setText(spannableString);
                        linearLayout3 = this.b.t;
                        linearLayout3.setVisibility(0);
                        linearLayout4 = this.b.t;
                        linearLayout4.setClickable(false);
                        textView3 = this.b.s;
                        textView3.setText(R.string.frs_create_forum);
                        imageView = this.b.F;
                        imageView.setVisibility(8);
                        listView = this.b.x;
                        listView.setVisibility(8);
                        button = this.b.v;
                        button.setVisibility(4);
                        button2 = this.b.v;
                        button2.setClickable(false);
                        button3 = this.b.u;
                        button3.setVisibility(4);
                        button4 = this.b.u;
                        button4.setClickable(false);
                        linearLayout5 = this.b.N;
                        linearLayout5.setVisibility(8);
                        return;
                    }
                    this.b.b(this.c.f());
                    return;
                }
                this.b.b(this.c.f());
                return;
            }
            return;
        }
        this.b.b(this.c.f());
        linearLayout = this.b.t;
        linearLayout.setClickable(true);
    }
}
