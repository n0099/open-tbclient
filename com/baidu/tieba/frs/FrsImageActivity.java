package com.baidu.tieba.frs;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.tieba.R;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.a.at;
import com.baidu.tieba.account.LoginActivity;
import com.baidu.tieba.view.FrsWaterFallItem;
import com.baidu.tieba.view.ImageViewDrawer;
import com.baidu.tieba.view.WaterFallView;
import com.baidu.tieba.write.WriteActivity;
import com.baidu.tieba.write.WriteImageActivity;
import com.baidu.tieba.write.ba;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class FrsImageActivity extends com.baidu.tieba.e {
    private int b = 0;
    private WaterFallView c = null;
    private String d = null;
    private ap e = null;
    private aq f = null;
    private ProgressBar g = null;
    private View.OnClickListener h = null;
    private View.OnClickListener i = null;
    private Button j = null;
    private Button k = null;
    private com.baidu.tieba.c.a l = null;
    private com.baidu.tieba.c.d m = null;
    private com.baidu.tieba.c.d n = null;
    private com.baidu.tieba.view.an o = null;
    private TextView p = null;
    private com.baidu.tieba.b.d q = null;
    private int r = 0;
    private int s = 0;
    private ao t = ao.GONE;
    private int u = 0;
    private int v = 1;
    private com.baidu.tieba.view.l w = null;
    private Button x = null;
    private Button y = null;
    private Button z = null;
    private AlertDialog A = null;
    private String B = null;
    private int C = 0;
    private Rect D = new Rect();

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i) {
        String u = TiebaApplication.u();
        if (u != null && u.length() > 0) {
            if (this.q != null) {
                if (i == 0) {
                    WriteActivity.a(this, this.q.a().b(), this.q.a().c(), this.q.e(), false, null);
                    return;
                } else {
                    h().show();
                    return;
                }
            }
            return;
        }
        if (this.q != null && this.q.e() != null) {
            this.q.e().a(1);
        }
        if (i == 0) {
            LoginActivity.a((Activity) this, getString(R.string.login_to_use), true, 1100001);
        } else {
            LoginActivity.a((Activity) this, getString(R.string.login_to_use), true, 1100016);
        }
    }

    public static void a(Context context, String str, String str2, int i) {
        if (str == null || str.length() <= 0) {
            return;
        }
        Intent intent = new Intent(context, FrsImageActivity.class);
        intent.putExtra("name", str);
        intent.putExtra("from", str2);
        intent.putExtra("add_search", i);
        context.startActivity(intent);
    }

    private void a(Bundle bundle) {
        this.l = new com.baidu.tieba.c.a(this);
        this.l.a(this.b, 600);
        this.l.a("_water");
        this.l.d(true);
        Intent intent = getIntent();
        this.B = intent.getStringExtra("from");
        this.C = intent.getIntExtra("add_search", 0);
        this.d = intent.getStringExtra("name");
        this.p.setText(this.d);
        if (bundle != null) {
            this.v = bundle.getInt("current_page");
        }
        if (this.v < 1) {
            this.v = 1;
        }
        c(this.v);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ao aoVar) {
        View k = k();
        TextView textView = (TextView) k.findViewById(R.id.page_text);
        ProgressBar progressBar = (ProgressBar) k.findViewById(R.id.progress);
        ImageView imageView = (ImageView) k.findViewById(R.id.divider);
        if (aoVar == ao.NEXT) {
            k.setVisibility(0);
            textView.setText(R.string.next_page);
            textView.setVisibility(0);
            imageView.setVisibility(0);
            progressBar.setVisibility(4);
        } else if (aoVar == ao.LOADING) {
            k.setVisibility(0);
            textView.setVisibility(4);
            progressBar.setVisibility(0);
            imageView.setVisibility(8);
        } else if (aoVar == ao.NORMAL) {
            k.setVisibility(0);
            textView.setVisibility(4);
            progressBar.setVisibility(4);
            imageView.setVisibility(8);
        } else if (aoVar == ao.NO_ITEM) {
            k.setVisibility(0);
            textView.setText(R.string.frs_no_image);
            textView.setVisibility(0);
            progressBar.setVisibility(8);
            imageView.setVisibility(8);
        } else {
            k.setVisibility(8);
        }
        this.t = aoVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ArrayList arrayList) {
        int i;
        if (arrayList == null) {
            return;
        }
        try {
            int size = arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                at atVar = (at) arrayList.get(i2);
                if (atVar != null) {
                    int a = atVar.b().a();
                    int b = atVar.b().b();
                    if (a >= 100 && b >= 50) {
                        if (a > this.b) {
                            float f = this.b / a;
                            a = this.b;
                            b = (int) (b * f);
                        }
                        if (b > 600) {
                            i = (int) ((600.0f / b) * a);
                            b = 600;
                        } else {
                            i = a;
                        }
                        Bitmap a2 = com.baidu.tieba.c.e.a((int) R.drawable.image_default);
                        int height = b < a2.getHeight() ? a2.getHeight() : b;
                        FrsWaterFallItem frsWaterFallItem = (FrsWaterFallItem) LayoutInflater.from(this).inflate(R.layout.water_fall_item, (ViewGroup) null);
                        ImageViewDrawer imageViewDrawer = (ImageViewDrawer) frsWaterFallItem.findViewById(R.id.image);
                        ViewGroup.LayoutParams layoutParams = imageViewDrawer.getLayoutParams();
                        layoutParams.height = height;
                        imageViewDrawer.setLayoutParams(layoutParams);
                        frsWaterFallItem.setTag(atVar);
                        imageViewDrawer.setImageSearchUrl(String.valueOf(atVar.b().c()) + "_water");
                        imageViewDrawer.setDefaultId(R.drawable.image_default);
                        imageViewDrawer.setTag(atVar.b().c());
                        frsWaterFallItem.setOnClickListener(this.i);
                        int a3 = com.baidu.tieba.c.ag.a((Context) this, 5.0f);
                        int paddingBottom = height + this.r + this.s + (a3 * 3) + frsWaterFallItem.getPaddingBottom();
                        frsWaterFallItem.a(this.r, this.s, a3);
                        this.c.a(frsWaterFallItem, paddingBottom);
                        atVar.b().a(paddingBottom);
                        atVar.b().b(i);
                    }
                }
            }
            j();
        } catch (Exception e) {
            com.baidu.tieba.c.ae.b(getClass().getName(), "setData", e.getMessage());
        }
    }

    private void b(int i) {
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this).inflate(R.layout.water_fall_item, (ViewGroup) null);
        linearLayout.measure(View.MeasureSpec.makeMeasureSpec(i, 1073741824), 0);
        this.b = linearLayout.findViewById(R.id.image).getMeasuredWidth();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(int i) {
        if (this.e != null) {
            return;
        }
        if (this.f != null) {
            this.f.a();
        }
        this.e = new ap(this, i);
        this.e.execute(new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(int i) {
        if (this.e == null && this.f == null && this.q != null && this.q.c().size() > i && this.t == ao.NORMAL) {
            this.f = new aq(this, i);
            this.f.execute(new Object[0]);
        }
    }

    private void g() {
        this.h = new ag(this);
        this.i = new ah(this);
        this.m = new ai(this);
        this.n = new aj(this);
        this.o = new ak(this);
        this.c = (WaterFallView) findViewById(R.id.water_fall);
        b(this.c.getLineWidth());
        this.g = (ProgressBar) findViewById(R.id.progress);
        this.j = (Button) findViewById(R.id.back);
        this.j.setOnClickListener(this.h);
        this.k = (Button) findViewById(R.id.go_home);
        this.k.setOnClickListener(this.h);
        this.c.setOnScrollListener(this.o);
        this.p = (TextView) findViewById(R.id.title_text);
        this.r = com.baidu.tieba.c.ag.c(this, 11.0f);
        this.s = com.baidu.tieba.c.ag.c(this, 10.0f);
        this.x = (Button) findViewById(R.id.frs_bt_post);
        this.x.setOnClickListener(this.h);
        this.y = (Button) findViewById(R.id.frs_bt_refresh);
        this.y.setOnClickListener(this.h);
        this.z = (Button) findViewById(R.id.frs_bt_camera);
        this.z.setOnClickListener(this.h);
        a(ao.GONE);
    }

    private AlertDialog h() {
        if (this.A != null) {
            return this.A;
        }
        String[] strArr = {getString(R.string.take_photo), getString(R.string.album)};
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(getString(R.string.operation));
        builder.setItems(strArr, new al(this));
        AlertDialog create = builder.create();
        create.setCanceledOnTouchOutside(true);
        return create;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        com.baidu.tieba.c.z c = com.baidu.tieba.c.w.c(this);
        this.l.a();
        boolean z = c == com.baidu.tieba.c.z.WIFI || c == com.baidu.tieba.c.z.ThreeG;
        int b = com.baidu.tieba.c.ag.b((Context) this) * 2;
        this.l.a(z);
        int d = com.baidu.tieba.a.h.d() >> 1;
        int i = 1;
        while (true) {
            int i2 = i;
            if (i2 > 2) {
                return;
            }
            LinearLayout a = this.c.a(i2);
            int childCount = a.getChildCount();
            int b2 = this.c.b(i2);
            int c2 = this.c.c(i2);
            if (b2 >= 0 && c2 >= 0) {
                int i3 = 0;
                int i4 = b2;
                int i5 = 0;
                while (true) {
                    if ((i4 <= c2 || z) && i4 < childCount) {
                        FrsWaterFallItem frsWaterFallItem = (FrsWaterFallItem) a.getChildAt(i4);
                        if (frsWaterFallItem != null) {
                            at atVar = (at) frsWaterFallItem.getTag();
                            i3 += atVar.b().d() * atVar.b().e() * 2;
                            if (i3 > d) {
                                break;
                            }
                            if (i2 == 1) {
                                this.l.a(atVar.b().c(), this.m);
                            } else {
                                this.l.a(atVar.b().c(), this.n);
                            }
                            int d2 = atVar.b().d() + i5;
                            int i6 = i4 + 1;
                            if (i6 <= c2 || d2 < b) {
                                i4 = i6;
                                i5 = d2;
                            }
                        }
                    }
                }
            }
            i = i2 + 1;
        }
    }

    private void j() {
        if (this.c.getHeader() != null || this.q == null) {
            return;
        }
        this.w = new com.baidu.tieba.view.l(this, com.baidu.tieba.view.o.FRS_IMAGE, this.d, this.q.a().b());
        this.w.a(this.q.a().d(), this.q.a().h(), this.q.a().e());
        this.w.a(this.q.a().f().b());
        if (this.q.a().f().a() == -2) {
            this.w.a(false);
        }
        this.c.a(this.w.c());
    }

    private View k() {
        View footer = this.c.getFooter();
        if (footer == null) {
            View inflate = LayoutInflater.from(this).inflate(R.layout.water_page, (ViewGroup) null);
            this.c.c(inflate);
            inflate.setOnClickListener(new am(this));
            return inflate;
        }
        return footer;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public View l() {
        View header2 = this.c.getHeader2();
        if (header2 == null) {
            View inflate = LayoutInflater.from(this).inflate(R.layout.water_page, (ViewGroup) null);
            inflate.setVisibility(0);
            inflate.setBackgroundColor(getResources().getColor(R.color.backgroundcolor));
            TextView textView = (TextView) inflate.findViewById(R.id.page_text);
            textView.setText(R.string.pre_page);
            textView.setVisibility(0);
            ((ImageView) inflate.findViewById(R.id.divider)).setVisibility(0);
            ((ProgressBar) inflate.findViewById(R.id.progress)).setVisibility(8);
            this.c.b(inflate);
            inflate.setOnClickListener(new an(this));
            return inflate;
        }
        return header2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        this.c.a();
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 != -1) {
            if (i2 == 0) {
                switch (i) {
                    case 1200008:
                        ba.b(this);
                        return;
                    case 12000010:
                        ba.a(this);
                        return;
                    default:
                        return;
                }
            }
            return;
        }
        switch (i) {
            case 1100001:
                a(0);
                return;
            case 1100002:
                if (this.w != null) {
                    this.w.a();
                    return;
                }
                return;
            case 1100014:
                if (this.w != null) {
                    this.w.b();
                    return;
                }
                return;
            case 1100016:
                h().show();
                return;
            case 1200001:
                if (this.q == null || this.q.a() == null) {
                    return;
                }
                WriteImageActivity.a(this, 1200001, 12000010, null, this.q.a().b(), this.q.a().c(), this.q.e());
                return;
            case 1200002:
                if (this.q == null || this.q.a() == null) {
                    return;
                }
                if (intent == null || intent.getData() == null) {
                    ba.b(this);
                    return;
                } else {
                    WriteImageActivity.a(this, 1200002, 1200008, intent.getData(), this.q.a().b(), this.q.a().c(), this.q.e());
                    return;
                }
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.frs_image_activity);
        g();
        a(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.e != null) {
            this.e.a();
        }
        if (this.f != null) {
            this.f.a();
        }
        if (this.w != null) {
            this.w.e();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.l != null) {
            this.l.b();
        }
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        this.v = bundle.getInt("current_page");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, android.app.Activity
    public void onResume() {
        super.onResume();
        i();
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("current_page", this.v);
    }
}
