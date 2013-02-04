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
public class aa extends AsyncTask {
    ArrayList a;
    final /* synthetic */ FrsActivity b;
    private String d;
    private int e;
    private com.baidu.tieba.c.t c = null;
    private volatile long f = 0;

    public aa(FrsActivity frsActivity, String str, ArrayList arrayList, int i) {
        this.b = frsActivity;
        this.d = null;
        this.e = 3;
        this.a = null;
        this.d = str;
        this.a = arrayList;
        this.e = i;
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
        z = this.b.d;
        if (!z) {
            this.b.b(this.c.f());
            linearLayout = this.b.r;
            linearLayout.setClickable(true);
        } else if (this.c != null) {
            if (!this.c.c()) {
                this.b.b(this.c.f());
            } else if (this.c.d() != 3) {
                this.b.b(this.c.f());
            } else {
                this.b.m = false;
                textView = this.b.A;
                textView.setText(R.string.frs_noforum);
                FrsActivity frsActivity = this.b;
                str = this.b.f;
                frsActivity.f = str.replace(" ", "");
                str2 = this.b.f;
                if (str2.length() > 31) {
                    str2 = String.valueOf(str2.substring(0, 31)) + "...";
                }
                SpannableString spannableString = new SpannableString(String.valueOf(str2) + this.b.getString(R.string.frs_remind_noforum));
                spannableString.setSpan(new ForegroundColorSpan(Color.rgb(229, 4, 0)), 0, str2.length(), 33);
                linearLayout2 = this.b.B;
                linearLayout2.setVisibility(0);
                textView2 = this.b.C;
                textView2.setText(spannableString);
                linearLayout3 = this.b.r;
                linearLayout3.setVisibility(0);
                linearLayout4 = this.b.r;
                linearLayout4.setClickable(false);
                textView3 = this.b.q;
                textView3.setText(R.string.frs_create_forum);
                imageView = this.b.D;
                imageView.setVisibility(8);
                listView = this.b.v;
                listView.setVisibility(8);
                button = this.b.t;
                button.setVisibility(4);
                button2 = this.b.t;
                button2.setClickable(false);
                button3 = this.b.s;
                button3.setVisibility(4);
                button4 = this.b.s;
                button4.setClickable(false);
                linearLayout5 = this.b.M;
                linearLayout5.setVisibility(8);
            }
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
            j = FrsActivity.N;
            if (j != 0) {
                com.baidu.tieba.c.t tVar = this.c;
                j4 = FrsActivity.N;
                tVar.a("ctime", String.valueOf(j4));
            }
            j2 = FrsActivity.O;
            if (j2 != 0) {
                com.baidu.tieba.c.t tVar2 = this.c;
                j3 = FrsActivity.O;
                tVar2.a("data_size", String.valueOf(j3));
            }
            i = FrsActivity.P;
            if (i != 0) {
                com.baidu.tieba.c.t tVar3 = this.c;
                i2 = FrsActivity.P;
                tVar3.a("net_error", String.valueOf(i2));
            }
            this.c.a(this.b);
            String i3 = this.c.i();
            if (this.c.b()) {
                com.baidu.tieba.b.c cVar2 = new com.baidu.tieba.b.c();
                try {
                    cVar2.a(i3);
                    cVar = cVar2;
                } catch (Exception e2) {
                    e = e2;
                    cVar = cVar2;
                    com.baidu.tieba.c.ae.b(getClass().getName(), "", "FrsAsyncTask.doInBackground error = " + e.getMessage());
                    return cVar;
                }
            } else {
                cVar = null;
            }
            try {
                if (this.c.c()) {
                    FrsActivity.N = 0L;
                    FrsActivity.O = 0L;
                    FrsActivity.P = 0;
                } else {
                    FrsActivity.P = 1;
                }
            } catch (Exception e3) {
                e = e3;
                com.baidu.tieba.c.ae.b(getClass().getName(), "", "FrsAsyncTask.doInBackground error = " + e.getMessage());
                return cVar;
            }
        } catch (Exception e4) {
            cVar = null;
            e = e4;
        }
        return cVar;
    }

    public void a() {
        if (this.c != null) {
            this.c.g();
        }
        super.cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public void onPostExecute(com.baidu.tieba.b.c cVar) {
        ab abVar;
        ab abVar2;
        ab abVar3;
        ab abVar4;
        switch (this.e) {
            case 1:
                abVar3 = this.b.w;
                abVar3.b(false);
                abVar4 = this.b.w;
                abVar4.notifyDataSetChanged();
                break;
            case 2:
                abVar = this.b.w;
                abVar.c(false);
                abVar2 = this.b.w;
                abVar2.notifyDataSetChanged();
                break;
            case 3:
                this.b.a(false);
                break;
        }
        if (cVar == null) {
            b();
        } else {
            this.b.y = cVar;
            this.b.A();
            FrsActivity.N = (System.nanoTime() - this.f) / 1000000;
            if (this.c != null) {
                FrsActivity.O = this.c.a();
            }
        }
        this.b.x = null;
        this.b.H = null;
        System.gc();
    }

    @Override // android.os.AsyncTask
    protected void onCancelled() {
        super.onCancelled();
    }

    @Override // android.os.AsyncTask
    protected void onPreExecute() {
        ab abVar;
        ab abVar2;
        ab abVar3;
        ab abVar4;
        this.b.w();
        this.f = System.nanoTime();
        switch (this.e) {
            case 1:
                abVar3 = this.b.w;
                abVar3.b(true);
                abVar4 = this.b.w;
                abVar4.notifyDataSetChanged();
                return;
            case 2:
                abVar = this.b.w;
                abVar.c(true);
                abVar2 = this.b.w;
                abVar2.notifyDataSetChanged();
                return;
            case 3:
                this.b.a(true);
                return;
            default:
                return;
        }
    }
}
