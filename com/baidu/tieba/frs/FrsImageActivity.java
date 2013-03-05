package com.baidu.tieba.frs;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tieba.R;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.a.au;
import com.baidu.tieba.account.LoginActivity;
import com.baidu.tieba.view.FrsWaterFallItem;
import com.baidu.tieba.view.ImageViewDrawer;
import com.baidu.tieba.view.WaterFallView;
import com.baidu.tieba.write.WriteActivity;
import com.baidu.tieba.write.WriteImageActivity;
import com.baidu.tieba.write.bb;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class FrsImageActivity extends com.baidu.tieba.e {
    private int c = 0;
    private WaterFallView d = null;
    private String e = null;
    private ao f = null;
    private ap g = null;
    private ProgressBar h = null;
    private View.OnClickListener i = null;
    private View.OnClickListener j = null;
    private Button k = null;
    private com.baidu.tieba.c.a l = null;
    private com.baidu.tieba.c.d m = null;
    private com.baidu.tieba.c.d n = null;
    private com.baidu.tieba.view.am o = null;
    private TextView p = null;
    private com.baidu.tieba.b.d q = null;
    private int r = 0;
    private int s = 0;
    private an t = an.GONE;
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
    private RelativeLayout E = null;
    private LinearLayout F = null;
    private LinearLayout G = null;

    public static void a(Context context, String str, String str2, int i) {
        if (str != null && str.length() > 0) {
            Intent intent = new Intent(context, FrsImageActivity.class);
            intent.putExtra("name", str);
            intent.putExtra("from", str2);
            intent.putExtra("add_search", i);
            context.startActivity(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.frs_image_activity);
        i();
        a(bundle);
    }

    private void i() {
        this.E = (RelativeLayout) findViewById(R.id.frs);
        this.F = (LinearLayout) findViewById(R.id.title);
        this.G = (LinearLayout) findViewById(R.id.bottoms);
        this.i = new af(this);
        this.j = new ag(this);
        this.m = new ah(this);
        this.n = new ai(this);
        this.o = new aj(this);
        this.d = (WaterFallView) findViewById(R.id.water_fall);
        d(this.d.getLineWidth());
        this.h = (ProgressBar) findViewById(R.id.progress);
        this.k = (Button) findViewById(R.id.back);
        this.k.setOnClickListener(this.i);
        this.d.setOnScrollListener(this.o);
        this.p = (TextView) findViewById(R.id.title_text);
        this.r = com.baidu.tieba.c.ai.c(this, 11.0f);
        this.s = com.baidu.tieba.c.ai.c(this, 10.0f);
        this.x = (Button) findViewById(R.id.frs_bt_post);
        this.x.setOnClickListener(this.i);
        this.y = (Button) findViewById(R.id.frs_bt_refresh);
        this.y.setOnClickListener(this.i);
        this.z = (Button) findViewById(R.id.frs_bt_camera);
        this.z.setOnClickListener(this.i);
        a(an.GONE);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e
    public void b(int i) {
        super.b(i);
        com.baidu.tieba.c.ae.a(this.E, i);
        com.baidu.tieba.c.ae.c(this.p, i);
        com.baidu.tieba.c.ae.c((TextView) this.k, i);
        com.baidu.tieba.c.ae.e((TextView) this.k, i);
        com.baidu.tieba.c.ae.c(this.F, i);
        com.baidu.tieba.c.ae.b((TextView) this.y, i);
        com.baidu.tieba.c.ae.b((TextView) this.z, i);
        com.baidu.tieba.c.ae.b((TextView) this.x, i);
        if (this.w != null) {
            this.w.a(i);
        }
        if (i == 1) {
            this.G.setBackgroundResource(R.drawable.maintab_toolbar_bg_1);
            this.d.setBackgroundColor(getResources().getColor(R.color.skin_1_common_bg));
            this.y.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, getResources().getDrawable(R.drawable.frs_pb_bottom_btn_refresh_1), (Drawable) null, (Drawable) null);
            this.z.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, getResources().getDrawable(R.drawable.frs_bottom_camera_1), (Drawable) null, (Drawable) null);
            this.x.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, getResources().getDrawable(R.drawable.frs_bottom_write_1), (Drawable) null, (Drawable) null);
            this.y.setTextColor(getResources().getColorStateList(R.color.text_blue_selector_color_1));
            this.z.setTextColor(getResources().getColorStateList(R.color.text_blue_selector_color_1));
            this.x.setTextColor(getResources().getColorStateList(R.color.text_blue_selector_color_1));
            return;
        }
        this.G.setBackgroundResource(R.drawable.maintab_toolbar_bg);
        this.d.setBackgroundColor(-1776412);
        this.y.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, getResources().getDrawable(R.drawable.frs_pb_bottom_btn_refresh), (Drawable) null, (Drawable) null);
        this.z.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, getResources().getDrawable(R.drawable.frs_bottom_camera), (Drawable) null, (Drawable) null);
        this.x.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, getResources().getDrawable(R.drawable.frs_bottom_write), (Drawable) null, (Drawable) null);
        this.y.setTextColor(getResources().getColorStateList(R.color.text_blue_selector_color));
        this.z.setTextColor(getResources().getColorStateList(R.color.text_blue_selector_color));
        this.x.setTextColor(getResources().getColorStateList(R.color.text_blue_selector_color));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, android.app.Activity
    public void onResume() {
        super.onResume();
        k();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.l != null) {
            this.l.b();
        }
    }

    private AlertDialog j() {
        if (this.A != null) {
            return this.A;
        }
        String[] strArr = {getString(R.string.take_photo), getString(R.string.album)};
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(getString(R.string.operation));
        builder.setItems(strArr, new ak(this));
        AlertDialog create = builder.create();
        create.setCanceledOnTouchOutside(true);
        return create;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(int i) {
        String x = TiebaApplication.x();
        if (x == null || x.length() <= 0) {
            if (this.q != null && this.q.e() != null) {
                this.q.e().a(1);
            }
            if (i == 0) {
                LoginActivity.a((Activity) this, getString(R.string.login_to_use), true, 1100001);
            } else {
                LoginActivity.a((Activity) this, getString(R.string.login_to_use), true, 1100016);
            }
        } else if (this.q != null) {
            if (i == 0) {
                WriteActivity.a(this, this.q.a().b(), this.q.a().c(), this.q.e(), false, null);
            } else {
                j().show();
            }
        }
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case 1100001:
                    c(0);
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
                    j().show();
                    return;
                case 1200001:
                    if (this.q != null && this.q.a() != null) {
                        WriteImageActivity.a(this, 1200001, 12000010, null, this.q.a().b(), this.q.a().c(), this.q.e());
                        return;
                    }
                    return;
                case 1200002:
                    if (this.q != null && this.q.a() != null && intent != null && intent.getData() != null) {
                        WriteImageActivity.a(this, 1200002, 1200008, intent.getData(), this.q.a().b(), this.q.a().c(), this.q.e());
                        return;
                    }
                    return;
                case 1200008:
                case 12000010:
                    if (this.q != null && this.q.a() != null) {
                        if (intent == null || intent.getStringExtra("filename") == null) {
                            WriteActivity.a(this, this.q.a().b(), this.q.a().c(), null, true, null);
                            return;
                        } else {
                            WriteActivity.a(this, this.q.a().b(), this.q.a().c(), null, true, intent.getStringExtra("filename"));
                            return;
                        }
                    }
                    return;
                default:
                    return;
            }
        } else if (i2 == 0) {
            switch (i) {
                case 1200008:
                    bb.b(this);
                    return;
                case 12000010:
                    bb.a(this);
                    return;
                default:
                    return;
            }
        }
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        this.v = bundle.getInt("current_page");
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("current_page", this.v);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        boolean z;
        com.baidu.tieba.c.z c = com.baidu.tieba.c.w.c(this);
        this.l.a();
        if (c == com.baidu.tieba.c.z.WIFI || c == com.baidu.tieba.c.z.ThreeG) {
            z = true;
        } else {
            z = false;
        }
        int b = com.baidu.tieba.c.ai.b((Context) this) * 2;
        this.l.a(z);
        int d = com.baidu.tieba.a.i.d() >> 1;
        int i = 1;
        while (true) {
            int i2 = i;
            if (i2 <= 2) {
                LinearLayout a = this.d.a(i2);
                int childCount = a.getChildCount();
                int b2 = this.d.b(i2);
                int c2 = this.d.c(i2);
                if (b2 >= 0 && c2 >= 0) {
                    int i3 = 0;
                    int i4 = b2;
                    int i5 = 0;
                    while (true) {
                        if ((i4 <= c2 || z) && i4 < childCount) {
                            FrsWaterFallItem frsWaterFallItem = (FrsWaterFallItem) a.getChildAt(i4);
                            if (frsWaterFallItem != null) {
                                au auVar = (au) frsWaterFallItem.getTag();
                                i3 += auVar.b().d() * auVar.b().e() * 2;
                                if (i3 > d) {
                                    break;
                                }
                                if (i2 == 1) {
                                    this.l.a(auVar.b().c(), this.m);
                                } else {
                                    this.l.a(auVar.b().c(), this.n);
                                }
                                int d2 = auVar.b().d() + i5;
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
            } else {
                return;
            }
        }
    }

    private void d(int i) {
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this).inflate(R.layout.water_fall_item, (ViewGroup) null);
        linearLayout.measure(View.MeasureSpec.makeMeasureSpec(i, 1073741824), 0);
        this.c = linearLayout.findViewById(R.id.image).getMeasuredWidth();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.f != null) {
            this.f.a();
        }
        if (this.g != null) {
            this.g.a();
        }
        if (this.w != null) {
            this.w.e();
        }
    }

    private void l() {
        if (this.d.getHeader() == null && this.q != null) {
            this.w = new com.baidu.tieba.view.l(this, com.baidu.tieba.view.o.FRS_IMAGE, this.e, this.q.a().b());
            this.w.a(this.b);
            this.w.a(this.q.a().d(), this.q.a().h(), this.q.a().e());
            this.w.b(this.q.a().f().b());
            if (this.q.a().f().a() == -2) {
                this.w.a(false);
            }
            this.d.a(this.w.c());
        }
    }

    private View m() {
        View footer = this.d.getFooter();
        if (footer == null) {
            View inflate = LayoutInflater.from(this).inflate(R.layout.water_page, (ViewGroup) null);
            this.d.c(inflate);
            inflate.setOnClickListener(new al(this));
            return inflate;
        }
        return footer;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public View n() {
        View header2 = this.d.getHeader2();
        if (header2 == null) {
            View inflate = LayoutInflater.from(this).inflate(R.layout.water_page, (ViewGroup) null);
            inflate.setVisibility(0);
            inflate.setBackgroundColor(getResources().getColor(R.color.backgroundcolor));
            TextView textView = (TextView) inflate.findViewById(R.id.page_text);
            textView.setText(R.string.pre_page);
            textView.setVisibility(0);
            ((ImageView) inflate.findViewById(R.id.divider)).setVisibility(0);
            ((ProgressBar) inflate.findViewById(R.id.progress)).setVisibility(8);
            this.d.b(inflate);
            inflate.setOnClickListener(new am(this));
            return inflate;
        }
        return header2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
        this.d.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(an anVar) {
        View m = m();
        TextView textView = (TextView) m.findViewById(R.id.page_text);
        ProgressBar progressBar = (ProgressBar) m.findViewById(R.id.progress);
        ImageView imageView = (ImageView) m.findViewById(R.id.divider);
        if (anVar == an.NEXT) {
            m.setVisibility(0);
            textView.setText(R.string.next_page);
            textView.setVisibility(0);
            imageView.setVisibility(0);
            progressBar.setVisibility(4);
        } else if (anVar == an.LOADING) {
            m.setVisibility(0);
            textView.setVisibility(4);
            progressBar.setVisibility(0);
            imageView.setVisibility(8);
        } else if (anVar == an.NORMAL) {
            m.setVisibility(0);
            textView.setVisibility(4);
            progressBar.setVisibility(4);
            imageView.setVisibility(8);
        } else if (anVar == an.NO_ITEM) {
            m.setVisibility(0);
            textView.setText(R.string.frs_no_image);
            textView.setVisibility(0);
            progressBar.setVisibility(8);
            imageView.setVisibility(8);
        } else {
            m.setVisibility(8);
        }
        this.t = anVar;
        com.baidu.tieba.c.ae.b(textView, this.b);
    }

    private void a(Bundle bundle) {
        this.l = new com.baidu.tieba.c.a(this);
        this.l.a(this.c, 600);
        this.l.a("_water");
        this.l.d(true);
        Intent intent = getIntent();
        this.B = intent.getStringExtra("from");
        this.C = intent.getIntExtra("add_search", 0);
        this.e = intent.getStringExtra("name");
        this.p.setText(this.e);
        if (bundle != null) {
            this.v = bundle.getInt("current_page");
        }
        if (this.v < 1) {
            this.v = 1;
        }
        e(this.v);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(int i) {
        if (this.f == null) {
            if (this.g != null) {
                this.g.a();
            }
            this.f = new ao(this, i);
            this.f.execute(new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(int i) {
        if (this.f == null && this.g == null && this.q != null && this.q.c().size() > i && this.t == an.NORMAL) {
            this.g = new ap(this, i);
            this.g.execute(new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ArrayList arrayList) {
        int i;
        if (arrayList != null) {
            try {
                int size = arrayList.size();
                for (int i2 = 0; i2 < size; i2++) {
                    au auVar = (au) arrayList.get(i2);
                    if (auVar != null) {
                        int a = auVar.b().a();
                        int b = auVar.b().b();
                        if (a >= 100 && b >= 50) {
                            if (a > this.c) {
                                float f = this.c / a;
                                a = this.c;
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
                            frsWaterFallItem.a(this.b);
                            ImageViewDrawer imageViewDrawer = (ImageViewDrawer) frsWaterFallItem.findViewById(R.id.image);
                            ViewGroup.LayoutParams layoutParams = imageViewDrawer.getLayoutParams();
                            layoutParams.height = height;
                            imageViewDrawer.setLayoutParams(layoutParams);
                            frsWaterFallItem.setTag(auVar);
                            imageViewDrawer.setImageSearchUrl(String.valueOf(auVar.b().c()) + "_water");
                            imageViewDrawer.setDefaultId(R.drawable.image_default);
                            imageViewDrawer.setNightDefaultId(R.drawable.image_default_1);
                            imageViewDrawer.setTag(auVar.b().c());
                            frsWaterFallItem.setOnClickListener(this.j);
                            int a3 = com.baidu.tieba.c.ai.a(this, 5.0f);
                            int paddingBottom = height + this.r + this.s + (a3 * 3) + frsWaterFallItem.getPaddingBottom();
                            frsWaterFallItem.a(this.r, this.s, a3);
                            this.d.a(frsWaterFallItem, paddingBottom);
                            auVar.b().a(paddingBottom);
                            auVar.b().b(i);
                        }
                    }
                }
                l();
            } catch (Exception e) {
                com.baidu.tieba.c.ag.b(getClass().getName(), "setData", e.getMessage());
            }
        }
    }
}
