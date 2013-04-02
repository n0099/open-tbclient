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
import com.baidu.tieba.a.aw;
import com.baidu.tieba.view.HeartButton;
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
    private com.baidu.tieba.b.f q;
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
    private ai J = null;
    private ProgressBar L = null;
    private v M = null;
    private w N = null;
    private boolean O = true;
    private Handler P = new Handler(new n(this));
    private final android.support.v4.view.aj Q = new o(this);
    private final View.OnClickListener R = new p(this);
    private View.OnTouchListener S = new q(this);

    public void startDropSmallBall(View view) {
        try {
            if (this.q != null && this.q.h().size() >= 50) {
                b(getString(R.string.too_much_tags));
                return;
            }
            com.baidu.tieba.view.ab abVar = (com.baidu.tieba.view.ab) view;
            if (abVar.getTag(R.id.label_smallball_checked) == null || ((Integer) abVar.getTag(R.id.label_smallball_checked)).intValue() != 1) {
                abVar.setTag(R.id.label_smallball_checked, 1);
                com.baidu.tieba.a.z zVar = (com.baidu.tieba.a.z) abVar.getTag(R.id.label_ball_data);
                AbsoluteLayout.LayoutParams layoutParams = new AbsoluteLayout.LayoutParams(zVar.f(), zVar.g(), zVar.d(), zVar.e());
                com.baidu.tieba.view.ab abVar2 = new com.baidu.tieba.view.ab(this);
                abVar2.setType(1);
                ((ViewGroup) this.j.get(this.d.getCurrentItem())).addView(abVar2, layoutParams);
                this.n.add(abVar2);
                if (this.m != null && this.m.size() > 0 && this.m.contains(abVar)) {
                    this.m.remove(abVar);
                    abVar.setTag(null);
                }
                abVar2.setTag(R.id.label_parabola_computer, new x(this, zVar.d(), zVar.e(), com.baidu.tieba.c.ai.a(this, 35.0f), this.d.getHeight() - com.baidu.tieba.c.ai.a(this, 50.0f), 700L));
                String i = zVar.i();
                if (i != null && i.length() > 0) {
                    aw awVar = new aw();
                    awVar.a(zVar.j());
                    awVar.b(i);
                    if (this.q != null && this.q.h() != null) {
                        this.q.a(awVar);
                    }
                    if (i.length() > 4) {
                        i = i.substring(0, 4);
                    }
                    abVar2.setText(i);
                    abVar2.setTextSize(com.baidu.tieba.c.ai.a(this, 14.0f));
                }
                abVar2.a(c(zVar.h()), this.s);
                abVar2.invalidate();
                this.F = System.currentTimeMillis();
                this.P.sendMessage(this.P.obtainMessage(1));
                abVar.setText("");
                abVar.setOnTouchListener(null);
                abVar.a();
                abVar.invalidate();
                k();
            }
        } catch (Exception e) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view) {
        if (this.q != null && this.q.h().size() >= 50) {
            b(getString(R.string.too_much_tags));
            return;
        }
        com.baidu.tieba.view.ab abVar = (com.baidu.tieba.view.ab) view;
        abVar.setTag(R.id.label_ball_state, 1);
        AbsoluteLayout.LayoutParams layoutParams = (AbsoluteLayout.LayoutParams) abVar.getLayoutParams();
        abVar.setTag(R.id.label_parabola_computer, new x(this, layoutParams.x, layoutParams.y, com.baidu.tieba.c.ai.a(this, 35.0f), this.d.getHeight() - com.baidu.tieba.c.ai.a(this, 60.0f), 700L));
        com.baidu.tieba.a.y yVar = (com.baidu.tieba.a.y) abVar.getTag(R.id.label_ball_data);
        if (yVar != null) {
            List b = yVar.b();
            if (b != null && b.size() > 0) {
                a(b, (ViewGroup) this.j.get(yVar.c()));
                o();
            }
            aw awVar = new aw();
            awVar.a(yVar.j());
            awVar.b(yVar.i());
            if (this.q != null && this.q.h() != null) {
                this.q.a(awVar);
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

    @Override // com.baidu.tieba.e, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.u = (Vibrator) getSystemService("vibrator");
        com.baidu.tieba.c.ag.a(getClass().getName(), "onCreate", null);
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
        l();
        a(true);
    }

    @Override // com.baidu.tieba.e, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        switch (i) {
            case 4:
                r();
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
    public boolean a(com.baidu.tieba.view.ab abVar, long j) {
        if (abVar != null) {
            try {
                if (abVar.getTag(R.id.label_parabola_computer) != null && (abVar.getTag(R.id.label_parabola_computer) instanceof x)) {
                    x xVar = (x) abVar.getTag(R.id.label_parabola_computer);
                    abVar.setGradual(1.0f - xVar.a());
                    AbsoluteLayout.LayoutParams layoutParams = (AbsoluteLayout.LayoutParams) abVar.getLayoutParams();
                    xVar.a(j);
                    layoutParams.x = xVar.b();
                    layoutParams.y = xVar.c();
                    if (layoutParams.y >= xVar.d()) {
                        a(abVar);
                        c(true);
                        return true;
                    }
                    abVar.setLayoutParams(layoutParams);
                    abVar.invalidate();
                }
            } catch (Exception e) {
                return false;
            }
        }
        return false;
    }

    private void k() {
        ((ViewGroup) this.j.get(this.d.getCurrentItem())).invalidate();
    }

    private void l() {
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
        this.e.setOnClickListener(new r(this));
        this.d = (ViewPager) findViewById(R.id.viewPager);
        this.d.setAdapter(this.p);
        this.d.setOnPageChangeListener(this.Q);
        this.f = (HeartButton) findViewById(R.id.heart);
        this.f.setOnClickListener(new s(this));
        this.g = (Button) findViewById(R.id.next);
        if (c.equals("allthread")) {
            this.g.setBackgroundDrawable(getResources().getDrawable(R.drawable.tag_finish_button));
        }
        this.g.setOnClickListener(new t(this));
        this.t = (LinearLayout) findViewById(R.id.tagsGroup);
        this.x = AnimationUtils.loadAnimation(this, R.anim.heart_shake);
        this.i = (RelativeLayout) findViewById(R.id.parent);
        if (c.equals("guide")) {
            this.h = new ImageView(this);
            this.h.setBackgroundResource(R.drawable.tag_mask);
            this.i.addView(this.h, new LinearLayout.LayoutParams(-1, -1));
            this.h.setOnClickListener(new u(this));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void i() {
        this.i.removeView(this.h);
        this.h = null;
    }

    private void a(com.baidu.tieba.view.ab abVar) {
        try {
            abVar.setAnimation(null);
            if (abVar.getParent() != null && (abVar.getParent() instanceof ViewGroup)) {
                ((ViewGroup) abVar.getParent()).removeView(abVar);
            }
        } catch (Exception e) {
            com.baidu.tieba.c.ag.b(getClass().getName(), "removeBallView", e.toString());
        }
    }

    private void m() {
        this.P.removeMessages(0);
        this.P.removeMessages(1);
        if (this.l != null && this.l.size() > 0) {
            for (com.baidu.tieba.view.ab abVar : this.l) {
                a(abVar);
            }
            this.l.clear();
        }
        if (this.n != null && this.n.size() > 0) {
            for (com.baidu.tieba.view.ab abVar2 : this.n) {
                a(abVar2);
            }
            this.n.clear();
        }
        if (this.k != null && this.k.size() > 0) {
            for (com.baidu.tieba.view.ab abVar3 : this.k) {
                a(abVar3);
            }
            this.k.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        boolean z = false;
        if (this.q != null && this.q.a() != null && this.q.a().size() > 0) {
            m();
            List<com.baidu.tieba.a.y> a = this.q.a();
            if (a != null && a.size() > 0) {
                boolean z2 = false;
                for (com.baidu.tieba.a.y yVar : a) {
                    if (yVar.a() || yVar.c() == 0) {
                        a(yVar.b(), (ViewGroup) this.j.get(yVar.c()));
                        z2 = true;
                    } else {
                        AbsoluteLayout.LayoutParams layoutParams = new AbsoluteLayout.LayoutParams(yVar.f(), yVar.g(), yVar.d(), yVar.e());
                        com.baidu.tieba.view.ab abVar = new com.baidu.tieba.view.ab(this);
                        abVar.setType(0);
                        int c2 = yVar.c();
                        if (c2 < this.j.size() && c2 >= 0) {
                            ((ViewGroup) this.j.get(yVar.c())).addView(abVar, layoutParams);
                            this.k.add(abVar);
                            String i = yVar.i();
                            if (i != null && i.length() > 0) {
                                if (i.length() > 4) {
                                    i = i.substring(0, 4);
                                }
                                abVar.setText(i);
                                abVar.setTextSize(com.baidu.tieba.c.ai.a(this, 18.0f));
                            }
                            abVar.setTag(R.id.label_ball_data, yVar);
                            abVar.setTag(R.id.label_ball_state, 0);
                            abVar.a(c(yVar.h()), this.s);
                            abVar.setOnTouchListener(this.S);
                            abVar.invalidate();
                            abVar.setAnimation(this.w);
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
                o();
            }
            k();
        }
    }

    private void o() {
        if (!this.v.hasEnded()) {
            this.v = AnimationUtils.loadAnimation(this, R.anim.ball_alpha);
        }
        if (this.m != null && this.m.size() > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.m.size()) {
                    ((com.baidu.tieba.view.ab) this.m.get(i2)).startAnimation(this.v);
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
            while (it.hasNext()) {
                com.baidu.tieba.a.z zVar = (com.baidu.tieba.a.z) it.next();
                ViewGroup.LayoutParams layoutParams = new AbsoluteLayout.LayoutParams(zVar.f(), zVar.g(), zVar.d(), zVar.e());
                com.baidu.tieba.view.ab abVar = new com.baidu.tieba.view.ab(this);
                abVar.setType(1);
                if (this.d.getCurrentItem() == zVar.c()) {
                    abVar.a(0);
                }
                if (viewGroup == null) {
                    ((ViewGroup) this.j.get(zVar.c())).addView(abVar, layoutParams);
                } else {
                    viewGroup.addView(abVar, layoutParams);
                }
                this.l.add(abVar);
                this.m.add(abVar);
                String i = zVar.i();
                if (i != null && i.length() > 0) {
                    if (i.length() > 4) {
                        i = i.substring(0, 4);
                    }
                    abVar.setText(i);
                    abVar.setTextSize(com.baidu.tieba.c.ai.a(this, 14.0f));
                }
                abVar.setTag(R.id.label_ball_data, zVar);
                abVar.a(c(zVar.h()), this.s);
                abVar.setOnTouchListener(this.S);
                abVar.invalidate();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, android.app.Activity
    public void onPause() {
        super.onPause();
        t();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, android.app.Activity
    public void onResume() {
        super.onResume();
        u();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, android.app.Activity
    public void onDestroy() {
        int i = 0;
        super.onDestroy();
        try {
            s();
            this.w.setRepeatCount(0);
            this.v.setRepeatCount(0);
            m();
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
                    if (softReference != null) {
                        ((Bitmap) softReference.get()).recycle();
                    }
                    i = i2 + 1;
                }
                this.r.clear();
            }
            if (this.M != null) {
                this.M.a();
                this.M = null;
            }
            if (this.N != null) {
                this.N.a();
                this.N = null;
            }
            b(false);
            System.gc();
        } catch (Exception e) {
            com.baidu.tieba.c.ag.b(getClass().getName(), "onDestroy", e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.q != null && this.O) {
            com.baidu.tieba.c.k.a(this.q.f(), 12);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
        boolean z = true;
        if (this.q != null) {
            String[] d = this.q.d();
            if (d != null && d.length == 2 && ((d[0] != null && d[0].length() > 0) || (d[1] != null && d[1].length() > 0))) {
                if (this.N != null) {
                    this.N.a();
                    this.N = null;
                }
                b(false);
                String y = TiebaApplication.y();
                if (y == null || y.length() <= 0) {
                    z = false;
                }
                this.N = new w(this, z, d);
                this.N.execute(new String[0]);
                return;
            }
            this.O = false;
            r();
            return;
        }
        this.O = false;
        r();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        StringBuffer stringBuffer = new StringBuffer(30);
        stringBuffer.append("http://c.tieba.baidu.com/");
        String y = TiebaApplication.y();
        if (z && y != null && y.length() > 0) {
            stringBuffer.append("c/s/tag/rand_and_user_tag");
        } else {
            stringBuffer.append("c/s/tag/rand_tag");
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(new BasicNameValuePair("level1_limit", "12"));
        arrayList.add(new BasicNameValuePair("level2_limit", "3"));
        q();
        this.M = new v(this, stringBuffer.toString(), z, arrayList);
        this.M.execute(stringBuffer.toString(), Boolean.valueOf(z), arrayList);
    }

    private void q() {
        if (this.M != null) {
            this.M.a();
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
    public void r() {
        setResult(-1);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void j() {
        if (this.q != null) {
            if (this.q.h().size() == 0) {
                b(getString(R.string.tag_is_null));
            } else if (this.H == null) {
                this.H = new AlertDialog.Builder(this).create();
                this.H.setCanceledOnTouchOutside(true);
                this.I = getLayoutInflater().inflate(R.layout.tag_setting_dialog, (ViewGroup) null);
                this.J = new ai(this, this.q);
                this.J.a(this.R);
                ((GridView) this.I.findViewById(R.id.tag_grid_view)).setAdapter((ListAdapter) this.J);
                this.H.show();
                this.H.setContentView(this.I);
                int b = com.baidu.tieba.c.ai.b((Context) this);
                int a = com.baidu.tieba.c.ai.a((Context) this);
                int[] iArr = new int[2];
                this.f.getLocationInWindow(iArr);
                WindowManager.LayoutParams attributes = this.H.getWindow().getAttributes();
                attributes.gravity = 17;
                attributes.width = a - com.baidu.tieba.c.ai.a(this, 28.0f);
                attributes.height = (b * 250) / 480;
                attributes.y = ((iArr[1] - (b / 2)) - (attributes.height / 2)) - com.baidu.tieba.c.ai.a(this, 20.0f);
                this.H.getWindow().setAttributes(attributes);
            } else {
                if (this.J != null) {
                    this.J.notifyDataSetChanged();
                }
                this.H.show();
            }
        }
    }

    private void s() {
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

    private void t() {
        if (this.k != null) {
            for (com.baidu.tieba.view.ab abVar : this.k) {
                if (abVar != null) {
                    abVar.setAnimation(null);
                }
            }
        }
        this.w.setRepeatCount(0);
    }

    private void u() {
        if (this.k != null) {
            for (com.baidu.tieba.view.ab abVar : this.k) {
                if (abVar != null) {
                    abVar.setAnimation(this.w);
                }
            }
        }
        this.w.setRepeatCount(-1);
        this.w.start();
    }
}
