package com.baidu.tieba;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Vibrator;
import android.support.v4.view.ViewPager;
import android.util.SparseArray;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AbsoluteLayout;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.baidu.tieba.a.bb;
import com.baidu.tieba.view.HeartButton;
import com.slidingmenu.lib.R;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class LabelActivity extends e {
    public static String c = "allthread";
    private FrameLayout K;
    private ViewPager d;
    private Button e;
    private HeartButton f;
    private Button g;
    private List j;
    private List k;
    private List l;
    private List m;
    private List n;
    private LabelAdapter p;
    private com.baidu.tieba.c.af q;
    private SparseArray r;
    private Bitmap s;
    private ImageView h = null;
    private RelativeLayout i = null;
    private View o = null;
    private LinearLayout t = null;
    private Vibrator u = null;
    private Animation v = null;
    private Animation w = null;
    private Animation x = null;
    private Animation y = null;
    private final int z = 0;
    private final int A = 1;
    private final int B = 0;
    private final int C = 1;
    private final int D = 2;
    private long E = 0;
    private long F = 0;
    private final int G = 50;
    private AlertDialog H = null;
    private View I = null;
    private ah J = null;
    private ProgressBar L = null;
    private w M = null;
    private x N = null;
    private boolean O = true;
    private Handler P = new Handler(new o(this));
    private final android.support.v4.view.aj Q = new p(this);
    private final View.OnClickListener R = new q(this);
    private View.OnTouchListener S = new r(this);

    public void startDropSmallBall(View view) {
        try {
            if (this.q != null && this.q.h().size() >= 50) {
                a(getString(R.string.too_much_tags));
                return;
            }
            com.baidu.tieba.view.ah ahVar = (com.baidu.tieba.view.ah) view;
            if (ahVar.getTag(R.id.label_smallball_checked) == null || ((Integer) ahVar.getTag(R.id.label_smallball_checked)).intValue() != 1) {
                ahVar.setTag(R.id.label_smallball_checked, 1);
                com.baidu.tieba.a.ab abVar = (com.baidu.tieba.a.ab) ahVar.getTag(R.id.label_ball_data);
                AbsoluteLayout.LayoutParams layoutParams = new AbsoluteLayout.LayoutParams(abVar.f(), abVar.g(), abVar.d(), abVar.e());
                com.baidu.tieba.view.ah ahVar2 = new com.baidu.tieba.view.ah(this);
                ahVar2.setType(1);
                ((ViewGroup) this.j.get(this.d.getCurrentItem())).addView(ahVar2, layoutParams);
                this.n.add(ahVar2);
                if (this.m != null && this.m.size() > 0 && this.m.contains(ahVar)) {
                    this.m.remove(ahVar);
                    ahVar.setTag(null);
                }
                ahVar2.setTag(R.id.label_parabola_computer, new y(this, abVar.d(), abVar.e(), com.baidu.tieba.d.ag.a(this, 35.0f), this.d.getHeight() - com.baidu.tieba.d.ag.a(this, 50.0f), 700L));
                String i = abVar.i();
                if (i != null && i.length() > 0) {
                    bb bbVar = new bb();
                    bbVar.a(abVar.j());
                    bbVar.b(i);
                    if (this.q != null && this.q.h() != null) {
                        this.q.a(bbVar);
                    }
                    if (i.length() > 4) {
                        i = i.substring(0, 4);
                    }
                    ahVar2.setText(i);
                    ahVar2.setTextSize(com.baidu.tieba.d.ag.a(this, 14.0f));
                }
                ahVar2.a(c(abVar.h()), this.s);
                ahVar2.invalidate();
                this.F = System.currentTimeMillis();
                this.P.sendMessage(this.P.obtainMessage(1));
                ahVar.setText("");
                ahVar.setOnTouchListener(null);
                ahVar.a();
                ahVar.invalidate();
                d();
            }
        } catch (Exception e) {
            com.baidu.tieba.d.ae.b(LabelActivity.class.getName(), "startDropSmallBall", e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view) {
        if (this.q != null && this.q.h().size() >= 50) {
            a(getString(R.string.too_much_tags));
            return;
        }
        com.baidu.tieba.view.ah ahVar = (com.baidu.tieba.view.ah) view;
        ahVar.setTag(R.id.label_ball_state, 1);
        AbsoluteLayout.LayoutParams layoutParams = (AbsoluteLayout.LayoutParams) ahVar.getLayoutParams();
        ahVar.setTag(R.id.label_parabola_computer, new y(this, layoutParams.x, layoutParams.y, com.baidu.tieba.d.ag.a(this, 35.0f), this.d.getHeight() - com.baidu.tieba.d.ag.a(this, 60.0f), 700L));
        com.baidu.tieba.a.aa aaVar = (com.baidu.tieba.a.aa) ahVar.getTag(R.id.label_ball_data);
        if (aaVar != null) {
            List b = aaVar.b();
            if (b != null && b.size() > 0) {
                a(b, (ViewGroup) this.j.get(aaVar.c()));
                p();
            }
            bb bbVar = new bb();
            bbVar.a(aaVar.j());
            bbVar.b(aaVar.i());
            if (this.q != null && this.q.h() != null) {
                this.q.a(bbVar);
            }
        }
        this.E = System.currentTimeMillis();
        this.P.sendMessage(this.P.obtainMessage(0));
    }

    public static void a(Activity activity, int i, String str) {
        Intent intent = new Intent(activity, LabelActivity.class);
        intent.putExtra("from", str);
        activity.startActivityForResult(intent, i);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("from", c);
    }

    @Override // com.baidu.tieba.e, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.u = (Vibrator) getSystemService("vibrator");
        com.baidu.tieba.d.ae.a(getClass().getName(), "onCreate", null);
        setContentView(R.layout.label_activity);
        if (bundle != null) {
            c = bundle.getString("from");
        }
        String stringExtra = getIntent().getStringExtra("from");
        if (stringExtra != null && stringExtra.length() > 0) {
            c = stringExtra;
        }
        this.k = new ArrayList();
        this.l = new ArrayList();
        this.m = new ArrayList();
        this.n = new ArrayList();
        this.r = new SparseArray();
        this.s = BitmapFactory.decodeResource(getResources(), R.drawable.ring);
        m();
        a(true);
    }

    @Override // com.baidu.tieba.e, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        switch (i) {
            case 4:
                s();
                return true;
            default:
                return super.onKeyDown(i, keyEvent);
        }
    }

    private Bitmap c(int i) {
        if (this.r == null) {
            return null;
        }
        if (this.r.get(i) != null) {
            SoftReference softReference = (SoftReference) this.r.get(i);
            if (softReference != null && softReference.get() != null) {
                return (Bitmap) softReference.get();
            }
            Bitmap decodeResource = BitmapFactory.decodeResource(getResources(), i);
            this.r.put(i, new SoftReference(decodeResource));
            return decodeResource;
        }
        Bitmap decodeResource2 = BitmapFactory.decodeResource(getResources(), i);
        this.r.put(i, new SoftReference(decodeResource2));
        return decodeResource2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(com.baidu.tieba.view.ah ahVar, long j) {
        if (ahVar != null) {
            try {
                if (ahVar.getTag(R.id.label_parabola_computer) != null && (ahVar.getTag(R.id.label_parabola_computer) instanceof y)) {
                    y yVar = (y) ahVar.getTag(R.id.label_parabola_computer);
                    ahVar.setGradual(1.0f - yVar.a());
                    AbsoluteLayout.LayoutParams layoutParams = (AbsoluteLayout.LayoutParams) ahVar.getLayoutParams();
                    yVar.a(j);
                    layoutParams.x = yVar.b();
                    layoutParams.y = yVar.c();
                    if (layoutParams.y >= yVar.d()) {
                        a(ahVar);
                        c(true);
                        return true;
                    }
                    ahVar.setLayoutParams(layoutParams);
                    ahVar.invalidate();
                }
            } catch (Exception e) {
                return false;
            }
        }
        return false;
    }

    private void d() {
        ((ViewGroup) this.j.get(this.d.getCurrentItem())).invalidate();
    }

    private void m() {
        this.v = AnimationUtils.loadAnimation(this, R.anim.ball_alpha);
        this.w = AnimationUtils.loadAnimation(this, R.anim.big_ball_alpha);
        this.y = AnimationUtils.loadAnimation(this, R.anim.ball_shake);
        this.j = new ArrayList();
        for (int i = 0; i < 3; i++) {
            this.j.add(new AbsoluteLayout(this));
        }
        this.p = new LabelAdapter(this.j);
        this.L = (ProgressBar) findViewById(R.id.progress);
        this.K = (FrameLayout) findViewById(R.id.progress_container);
        b(false);
        this.e = (Button) findViewById(R.id.refresh);
        this.e.setOnClickListener(new s(this));
        this.d = (ViewPager) findViewById(R.id.viewPager);
        this.d.setAdapter(this.p);
        this.d.setOnPageChangeListener(this.Q);
        this.f = (HeartButton) findViewById(R.id.heart);
        this.f.setOnClickListener(new t(this));
        this.g = (Button) findViewById(R.id.next);
        if (c.equals("allthread")) {
            this.g.setBackgroundDrawable(getResources().getDrawable(R.drawable.tag_finish_button));
        }
        this.g.setOnClickListener(new u(this));
        this.t = (LinearLayout) findViewById(R.id.tagsGroup);
        this.x = AnimationUtils.loadAnimation(this, R.anim.heart_shake);
        this.i = (RelativeLayout) findViewById(R.id.parent);
        if (c.equals("guide")) {
            this.h = new ImageView(this);
            this.h.setBackgroundResource(R.drawable.tag_mask);
            this.i.addView(this.h, new LinearLayout.LayoutParams(-1, -1));
            this.h.setOnClickListener(new v(this));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b() {
        this.i.removeView(this.h);
        this.h = null;
    }

    private void a(com.baidu.tieba.view.ah ahVar) {
        try {
            ahVar.setAnimation(null);
            if (ahVar.getParent() != null && (ahVar.getParent() instanceof ViewGroup)) {
                ((ViewGroup) ahVar.getParent()).removeView(ahVar);
            }
        } catch (Exception e) {
            com.baidu.tieba.d.ae.b(getClass().getName(), "removeBallView", e.toString());
        }
    }

    private void n() {
        this.P.removeMessages(0);
        this.P.removeMessages(1);
        if (this.l != null && this.l.size() > 0) {
            for (com.baidu.tieba.view.ah ahVar : this.l) {
                a(ahVar);
            }
            this.l.clear();
        }
        if (this.n != null && this.n.size() > 0) {
            for (com.baidu.tieba.view.ah ahVar2 : this.n) {
                a(ahVar2);
            }
            this.n.clear();
        }
        if (this.k != null && this.k.size() > 0) {
            for (com.baidu.tieba.view.ah ahVar3 : this.k) {
                a(ahVar3);
            }
            this.k.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
        boolean z = false;
        if (this.q != null && this.q.a() != null && this.q.a().size() > 0) {
            n();
            List<com.baidu.tieba.a.aa> a = this.q.a();
            if (a != null && a.size() > 0) {
                boolean z2 = false;
                for (com.baidu.tieba.a.aa aaVar : a) {
                    if (aaVar.a() || aaVar.c() == 0) {
                        a(aaVar.b(), (ViewGroup) this.j.get(aaVar.c()));
                        z2 = true;
                    } else {
                        AbsoluteLayout.LayoutParams layoutParams = new AbsoluteLayout.LayoutParams(aaVar.f(), aaVar.g(), aaVar.d(), aaVar.e());
                        com.baidu.tieba.view.ah ahVar = new com.baidu.tieba.view.ah(this);
                        ahVar.setType(0);
                        int c2 = aaVar.c();
                        if (c2 < this.j.size() && c2 >= 0) {
                            ((ViewGroup) this.j.get(aaVar.c())).addView(ahVar, layoutParams);
                            this.k.add(ahVar);
                            String i = aaVar.i();
                            if (i != null && i.length() > 0) {
                                if (i.length() > 4) {
                                    i = i.substring(0, 4);
                                }
                                ahVar.setText(i);
                                ahVar.setTextSize(com.baidu.tieba.d.ag.a(this, 18.0f));
                            }
                            ahVar.setTag(R.id.label_ball_data, aaVar);
                            ahVar.setTag(R.id.label_ball_state, 0);
                            ahVar.a(c(aaVar.h()), this.s);
                            ahVar.setOnTouchListener(this.S);
                            ahVar.invalidate();
                            ahVar.setAnimation(this.w);
                        }
                    }
                }
                this.w.start();
                z = z2;
            }
            List b = this.q.b();
            if (b != null && b.size() > 0) {
                a(b, (ViewGroup) null);
                z = true;
            }
            if (z) {
                p();
            }
            d();
        }
    }

    private void p() {
        if (!this.v.hasEnded()) {
            this.v = AnimationUtils.loadAnimation(this, R.anim.ball_alpha);
        }
        if (this.m != null && this.m.size() > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.m.size()) {
                    ((com.baidu.tieba.view.ah) this.m.get(i2)).startAnimation(this.v);
                    i = i2 + 1;
                } else {
                    this.m.clear();
                    return;
                }
            }
        }
    }

    private void a(List list, ViewGroup viewGroup) {
        if (list != null && list.size() != 0) {
            Iterator it = list.iterator();
            int i = 0;
            while (it.hasNext()) {
                com.baidu.tieba.a.ab abVar = (com.baidu.tieba.a.ab) it.next();
                int i2 = i + 1;
                if (i2 <= 3) {
                    ViewGroup.LayoutParams layoutParams = new AbsoluteLayout.LayoutParams(abVar.f(), abVar.g(), abVar.d(), abVar.e());
                    com.baidu.tieba.view.ah ahVar = new com.baidu.tieba.view.ah(this);
                    ahVar.setType(1);
                    if (this.d.getCurrentItem() == abVar.c()) {
                        ahVar.a(0);
                    }
                    if (viewGroup == null) {
                        ((ViewGroup) this.j.get(abVar.c())).addView(ahVar, layoutParams);
                    } else {
                        viewGroup.addView(ahVar, layoutParams);
                    }
                    this.l.add(ahVar);
                    this.m.add(ahVar);
                    String i3 = abVar.i();
                    if (i3 != null && i3.length() > 0) {
                        if (i3.length() > 4) {
                            i3 = i3.substring(0, 4);
                        }
                        ahVar.setText(i3);
                        ahVar.setTextSize(com.baidu.tieba.d.ag.a(this, 14.0f));
                    }
                    ahVar.setTag(R.id.label_ball_data, abVar);
                    ahVar.a(c(abVar.h()), this.s);
                    ahVar.setOnTouchListener(this.S);
                    ahVar.invalidate();
                    i = i2;
                } else {
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, android.app.Activity
    public void onPause() {
        super.onPause();
        u();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, android.app.Activity
    public void onResume() {
        super.onResume();
        v();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, android.app.Activity
    public void onDestroy() {
        Bitmap bitmap;
        int i = 0;
        super.onDestroy();
        try {
            t();
            this.w.setRepeatCount(0);
            this.v.setRepeatCount(0);
            n();
            if (this.s != null && !this.s.isRecycled()) {
                this.s.recycle();
            }
            if (this.r != null) {
                while (true) {
                    int i2 = i;
                    if (i2 >= this.r.size()) {
                        break;
                    }
                    SoftReference softReference = (SoftReference) this.r.get(i2);
                    if (softReference != null && (bitmap = (Bitmap) softReference.get()) != null && !bitmap.isRecycled()) {
                        bitmap.recycle();
                    }
                    i = i2 + 1;
                }
                this.r.clear();
            }
            if (this.M != null) {
                this.M.cancel();
                this.M = null;
            }
            if (this.N != null) {
                this.N.cancel();
                this.N = null;
            }
            b(false);
            System.gc();
        } catch (Exception e) {
            com.baidu.tieba.d.ae.b(getClass().getName(), "onDestroy", e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.q != null && this.O) {
            com.baidu.tieba.d.k.a(this.q.f(), 12);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q() {
        boolean z = true;
        if (this.q != null) {
            String[] d = this.q.d();
            if (d != null && d.length == 2 && ((d[0] != null && d[0].length() > 0) || (d[1] != null && d[1].length() > 0))) {
                if (this.N != null) {
                    this.N.cancel();
                    this.N = null;
                }
                b(false);
                String C = TiebaApplication.C();
                if (C == null || C.length() <= 0) {
                    z = false;
                }
                this.N = new x(this, z, d);
                this.N.setPriority(3);
                this.N.execute(new String[0]);
                return;
            }
            this.O = false;
            s();
            return;
        }
        this.O = false;
        s();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        StringBuffer stringBuffer = new StringBuffer(30);
        stringBuffer.append(com.baidu.tieba.a.i.e);
        String C = TiebaApplication.C();
        if (z && C != null && C.length() > 0) {
            stringBuffer.append("c/s/tag/rand_and_user_tag");
        } else {
            stringBuffer.append("c/s/tag/rand_tag");
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(new BasicNameValuePair("level1_limit", "12"));
        arrayList.add(new BasicNameValuePair("level2_limit", "3"));
        r();
        this.M = new w(this, stringBuffer.toString(), z, arrayList);
        this.M.setPriority(3);
        this.M.execute(stringBuffer.toString(), Boolean.valueOf(z), arrayList);
    }

    private void r() {
        if (this.M != null) {
            this.M.cancel();
            this.M = null;
        }
        b(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z) {
        if (z) {
            this.L.setVisibility(0);
            this.K.setVisibility(0);
            return;
        }
        this.L.setVisibility(8);
        this.K.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s() {
        setResult(-1);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c() {
        if (this.q != null) {
            if (this.q.h().size() == 0) {
                a(getString(R.string.tag_is_null));
            } else if (this.H == null) {
                this.H = new AlertDialog.Builder(this).create();
                this.H.setCanceledOnTouchOutside(true);
                this.I = getLayoutInflater().inflate(R.layout.tag_setting_dialog, (ViewGroup) null);
                this.J = new ah(this, this.q);
                this.J.a(this.R);
                ((GridView) this.I.findViewById(R.id.tag_grid_view)).setAdapter((ListAdapter) this.J);
                this.H.show();
                this.H.setContentView(this.I);
                int b = com.baidu.tieba.d.ag.b((Context) this);
                int a = com.baidu.tieba.d.ag.a((Context) this);
                int[] iArr = new int[2];
                this.f.getLocationInWindow(iArr);
                WindowManager.LayoutParams attributes = this.H.getWindow().getAttributes();
                attributes.gravity = 17;
                attributes.width = a - com.baidu.tieba.d.ag.a(this, 28.0f);
                attributes.height = (b * 250) / 480;
                attributes.y = ((iArr[1] - (b / 2)) - (attributes.height / 2)) - com.baidu.tieba.d.ag.a(this, 20.0f);
                this.H.getWindow().setAttributes(attributes);
            } else {
                if (this.J != null) {
                    this.J.notifyDataSetChanged();
                }
                this.H.show();
            }
        }
    }

    private void t() {
        if (this.J != null) {
            this.J.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(boolean z) {
        if (this.q != null && this.f != null) {
            int ratio = ((int) (this.f.getRatio() * 10.0f)) / 2;
            int size = this.q.h().size();
            if (z) {
                this.f.startAnimation(this.x);
            }
            if (size < 11 || size >= 50 || ratio < 11 || ratio >= 50) {
                if (size < 4) {
                    this.f.setRatio(0.2f * size);
                }
                if (size >= 4 && size < 11) {
                    this.f.setRatio(0.6f + ((size - 3) * 0.05f));
                }
                if (size >= 11) {
                    this.f.setRatio(1.0f);
                }
            }
        }
    }

    private void u() {
        if (this.k != null) {
            for (com.baidu.tieba.view.ah ahVar : this.k) {
                if (ahVar != null) {
                    ahVar.setAnimation(null);
                }
            }
        }
        this.w.setRepeatCount(0);
    }

    private void v() {
        if (this.k != null) {
            for (com.baidu.tieba.view.ah ahVar : this.k) {
                if (ahVar != null) {
                    ahVar.setAnimation(this.w);
                }
            }
        }
        this.w.setRepeatCount(-1);
        this.w.start();
    }
}
