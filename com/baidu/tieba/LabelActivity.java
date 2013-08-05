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
import android.support.v4.view.bq;
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
import com.baidu.tieba.data.bl;
import com.baidu.tieba.util.DatabaseService;
import com.baidu.tieba.view.HeartButton;
import com.slidingmenu.lib.R;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class LabelActivity extends g {

    /* renamed from: a  reason: collision with root package name */
    public static String f821a = "allthread";
    private FrameLayout K;
    private ViewPager b;
    private Button c;
    private HeartButton d;
    private Button e;
    private List j;
    private List k;
    private List l;
    private List m;
    private List n;
    private LabelAdapter p;
    private com.baidu.tieba.model.aq q;
    private SparseArray r;
    private Bitmap s;
    private ImageView f = null;
    private RelativeLayout g = null;
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
    private aq J = null;
    private ProgressBar L = null;
    private ab M = null;
    private ac N = null;
    private boolean O = true;
    private Handler P = new Handler(new t(this));
    private final bq Q = new u(this);
    private final View.OnClickListener R = new v(this);
    private View.OnTouchListener S = new w(this);

    public void startDropSmallBall(View view) {
        try {
            if (this.q != null && this.q.i().size() >= 50) {
                a(getString(R.string.too_much_tags));
                return;
            }
            com.baidu.tieba.view.as asVar = (com.baidu.tieba.view.as) view;
            if (asVar.getTag(R.id.label_smallball_checked) == null || ((Integer) asVar.getTag(R.id.label_smallball_checked)).intValue() != 1) {
                asVar.setTag(R.id.label_smallball_checked, 1);
                com.baidu.tieba.data.ah ahVar = (com.baidu.tieba.data.ah) asVar.getTag(R.id.label_ball_data);
                AbsoluteLayout.LayoutParams layoutParams = new AbsoluteLayout.LayoutParams(ahVar.f(), ahVar.g(), ahVar.d(), ahVar.e());
                com.baidu.tieba.view.as asVar2 = new com.baidu.tieba.view.as(this);
                asVar2.setType(1);
                ((ViewGroup) this.j.get(this.b.getCurrentItem())).addView(asVar2, layoutParams);
                this.n.add(asVar2);
                if (this.m != null && this.m.size() > 0 && this.m.contains(asVar)) {
                    this.m.remove(asVar);
                    asVar.setTag(null);
                }
                asVar2.setTag(R.id.label_parabola_computer, new ad(this, ahVar.d(), ahVar.e(), com.baidu.tieba.util.am.a((Context) this, 35.0f), this.b.getHeight() - com.baidu.tieba.util.am.a((Context) this, 50.0f), 700L));
                String i = ahVar.i();
                if (i != null && i.length() > 0) {
                    bl blVar = new bl();
                    blVar.a(ahVar.j());
                    blVar.b(i);
                    if (this.q != null && this.q.i() != null) {
                        this.q.a(blVar);
                    }
                    if (i.length() > 4) {
                        i = i.substring(0, 4);
                    }
                    asVar2.setText(i);
                    asVar2.setTextSize(com.baidu.tieba.util.am.a((Context) this, 14.0f));
                }
                asVar2.a(b(ahVar.h()), this.s);
                asVar2.invalidate();
                this.F = System.currentTimeMillis();
                this.P.sendMessage(this.P.obtainMessage(1));
                asVar.setText("");
                asVar.setOnTouchListener(null);
                asVar.a();
                asVar.invalidate();
                d();
            }
        } catch (Exception e) {
            com.baidu.tieba.util.aj.b(LabelActivity.class.getName(), "startDropSmallBall", e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view) {
        if (this.q != null && this.q.i().size() >= 50) {
            a(getString(R.string.too_much_tags));
            return;
        }
        com.baidu.tieba.view.as asVar = (com.baidu.tieba.view.as) view;
        asVar.setTag(R.id.label_ball_state, 1);
        AbsoluteLayout.LayoutParams layoutParams = (AbsoluteLayout.LayoutParams) asVar.getLayoutParams();
        asVar.setTag(R.id.label_parabola_computer, new ad(this, layoutParams.x, layoutParams.y, com.baidu.tieba.util.am.a((Context) this, 35.0f), this.b.getHeight() - com.baidu.tieba.util.am.a((Context) this, 60.0f), 700L));
        com.baidu.tieba.data.ag agVar = (com.baidu.tieba.data.ag) asVar.getTag(R.id.label_ball_data);
        if (agVar != null) {
            List b = agVar.b();
            if (b != null && b.size() > 0) {
                a(b, (ViewGroup) this.j.get(agVar.c()));
                n();
            }
            bl blVar = new bl();
            blVar.a(agVar.j());
            blVar.b(agVar.i());
            if (this.q != null && this.q.i() != null) {
                this.q.a(blVar);
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
        bundle.putString("from", f821a);
    }

    @Override // com.baidu.tieba.g, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.u = (Vibrator) getSystemService("vibrator");
        com.baidu.tieba.util.aj.a(getClass().getName(), "onCreate", null);
        setContentView(R.layout.label_activity);
        if (bundle != null) {
            f821a = bundle.getString("from");
        }
        String stringExtra = getIntent().getStringExtra("from");
        if (stringExtra != null && stringExtra.length() > 0) {
            f821a = stringExtra;
        }
        this.k = new ArrayList();
        this.l = new ArrayList();
        this.m = new ArrayList();
        this.n = new ArrayList();
        this.r = new SparseArray();
        this.s = BitmapFactory.decodeResource(getResources(), R.drawable.ring);
        k();
        a(true);
    }

    @Override // com.baidu.tieba.g, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        switch (i) {
            case 4:
                q();
                return true;
            default:
                return super.onKeyDown(i, keyEvent);
        }
    }

    private Bitmap b(int i) {
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
    public boolean a(com.baidu.tieba.view.as asVar, long j) {
        if (asVar != null) {
            try {
                if (asVar.getTag(R.id.label_parabola_computer) != null && (asVar.getTag(R.id.label_parabola_computer) instanceof ad)) {
                    ad adVar = (ad) asVar.getTag(R.id.label_parabola_computer);
                    asVar.setGradual(1.0f - adVar.a());
                    AbsoluteLayout.LayoutParams layoutParams = (AbsoluteLayout.LayoutParams) asVar.getLayoutParams();
                    adVar.a(j);
                    layoutParams.x = adVar.b();
                    layoutParams.y = adVar.c();
                    if (layoutParams.y >= adVar.d()) {
                        a(asVar);
                        c(true);
                        return true;
                    }
                    asVar.setLayoutParams(layoutParams);
                    asVar.invalidate();
                }
            } catch (Exception e) {
                return false;
            }
        }
        return false;
    }

    private void d() {
        ((ViewGroup) this.j.get(this.b.getCurrentItem())).invalidate();
    }

    private void k() {
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
        this.c = (Button) findViewById(R.id.refresh);
        this.c.setOnClickListener(new x(this));
        this.b = (ViewPager) findViewById(R.id.viewPager);
        this.b.setAdapter(this.p);
        this.b.setOnPageChangeListener(this.Q);
        this.d = (HeartButton) findViewById(R.id.heart);
        this.d.setOnClickListener(new y(this));
        this.e = (Button) findViewById(R.id.next);
        if (f821a.equals("allthread")) {
            this.e.setBackgroundDrawable(getResources().getDrawable(R.drawable.tag_finish_button));
        }
        this.e.setOnClickListener(new z(this));
        this.t = (LinearLayout) findViewById(R.id.tagsGroup);
        this.x = AnimationUtils.loadAnimation(this, R.anim.heart_shake);
        this.g = (RelativeLayout) findViewById(R.id.parent);
        if (f821a.equals("guide")) {
            this.f = new ImageView(this);
            this.f.setBackgroundResource(R.drawable.tag_mask);
            this.g.addView(this.f, new LinearLayout.LayoutParams(-1, -1));
            this.f.setOnClickListener(new aa(this));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b() {
        this.g.removeView(this.f);
        this.f = null;
    }

    private void a(com.baidu.tieba.view.as asVar) {
        try {
            asVar.setAnimation(null);
            if (asVar.getParent() != null && (asVar.getParent() instanceof ViewGroup)) {
                ((ViewGroup) asVar.getParent()).removeView(asVar);
            }
        } catch (Exception e) {
            com.baidu.tieba.util.aj.b(getClass().getName(), "removeBallView", e.toString());
        }
    }

    private void l() {
        this.P.removeMessages(0);
        this.P.removeMessages(1);
        if (this.l != null && this.l.size() > 0) {
            for (com.baidu.tieba.view.as asVar : this.l) {
                a(asVar);
            }
            this.l.clear();
        }
        if (this.n != null && this.n.size() > 0) {
            for (com.baidu.tieba.view.as asVar2 : this.n) {
                a(asVar2);
            }
            this.n.clear();
        }
        if (this.k != null && this.k.size() > 0) {
            for (com.baidu.tieba.view.as asVar3 : this.k) {
                a(asVar3);
            }
            this.k.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        boolean z = false;
        if (this.q != null && this.q.a() != null && this.q.a().size() > 0) {
            l();
            List<com.baidu.tieba.data.ag> a2 = this.q.a();
            if (a2 != null && a2.size() > 0) {
                boolean z2 = false;
                for (com.baidu.tieba.data.ag agVar : a2) {
                    if (agVar.a() || agVar.c() == 0) {
                        a(agVar.b(), (ViewGroup) this.j.get(agVar.c()));
                        z2 = true;
                    } else {
                        AbsoluteLayout.LayoutParams layoutParams = new AbsoluteLayout.LayoutParams(agVar.f(), agVar.g(), agVar.d(), agVar.e());
                        com.baidu.tieba.view.as asVar = new com.baidu.tieba.view.as(this);
                        asVar.setType(0);
                        int c = agVar.c();
                        if (c < this.j.size() && c >= 0) {
                            ((ViewGroup) this.j.get(agVar.c())).addView(asVar, layoutParams);
                            this.k.add(asVar);
                            String i = agVar.i();
                            if (i != null && i.length() > 0) {
                                if (i.length() > 4) {
                                    i = i.substring(0, 4);
                                }
                                asVar.setText(i);
                                asVar.setTextSize(com.baidu.tieba.util.am.a((Context) this, 18.0f));
                            }
                            asVar.setTag(R.id.label_ball_data, agVar);
                            asVar.setTag(R.id.label_ball_state, 0);
                            asVar.a(b(agVar.h()), this.s);
                            asVar.setOnTouchListener(this.S);
                            asVar.invalidate();
                            asVar.setAnimation(this.w);
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
                n();
            }
            d();
        }
    }

    private void n() {
        if (!this.v.hasEnded()) {
            this.v = AnimationUtils.loadAnimation(this, R.anim.ball_alpha);
        }
        if (this.m != null && this.m.size() > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.m.size()) {
                    ((com.baidu.tieba.view.as) this.m.get(i2)).startAnimation(this.v);
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
                com.baidu.tieba.data.ah ahVar = (com.baidu.tieba.data.ah) it.next();
                int i2 = i + 1;
                if (i2 <= 3) {
                    ViewGroup.LayoutParams layoutParams = new AbsoluteLayout.LayoutParams(ahVar.f(), ahVar.g(), ahVar.d(), ahVar.e());
                    com.baidu.tieba.view.as asVar = new com.baidu.tieba.view.as(this);
                    asVar.setType(1);
                    if (this.b.getCurrentItem() == ahVar.c()) {
                        asVar.a(0);
                    }
                    if (viewGroup == null) {
                        ((ViewGroup) this.j.get(ahVar.c())).addView(asVar, layoutParams);
                    } else {
                        viewGroup.addView(asVar, layoutParams);
                    }
                    this.l.add(asVar);
                    this.m.add(asVar);
                    String i3 = ahVar.i();
                    if (i3 != null && i3.length() > 0) {
                        if (i3.length() > 4) {
                            i3 = i3.substring(0, 4);
                        }
                        asVar.setText(i3);
                        asVar.setTextSize(com.baidu.tieba.util.am.a((Context) this, 14.0f));
                    }
                    asVar.setTag(R.id.label_ball_data, ahVar);
                    asVar.a(b(ahVar.h()), this.s);
                    asVar.setOnTouchListener(this.S);
                    asVar.invalidate();
                    i = i2;
                } else {
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.g, android.app.Activity
    public void onPause() {
        super.onPause();
        s();
        if (this.q != null && this.O) {
            DatabaseService.a(this.q.g(), 12);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.g, android.app.Activity
    public void onResume() {
        super.onResume();
        t();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.g, android.app.Activity
    public void onDestroy() {
        Bitmap bitmap;
        int i = 0;
        super.onDestroy();
        try {
            r();
            this.w.setRepeatCount(0);
            this.v.setRepeatCount(0);
            l();
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
            com.baidu.tieba.util.aj.b(getClass().getName(), "onDestroy", e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.g, android.app.Activity
    public void onStop() {
        super.onStop();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
        String E = TiebaApplication.E();
        boolean z = E != null && E.length() > 0;
        if (this.q != null) {
            String[] d = this.q.d();
            if (d != null && d.length == 2) {
                if ((d[0] != null && d[0].length() > 0) || (d[1] != null && d[1].length() > 0)) {
                    if (this.N != null) {
                        this.N.cancel();
                        this.N = null;
                    }
                    b(false);
                    this.N = new ac(this, z, d);
                    this.N.setPriority(3);
                    this.N.execute(new String[0]);
                    return;
                }
                String g = this.q.g();
                if ((!z && g == null) || g.length() == 0) {
                    DatabaseService.a("", 12);
                }
                this.O = false;
                q();
                return;
            }
            this.O = false;
            q();
            return;
        }
        this.O = false;
        q();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        StringBuffer stringBuffer = new StringBuffer(30);
        stringBuffer.append(com.baidu.tieba.data.g.f1013a);
        String E = TiebaApplication.E();
        if (z && E != null && E.length() > 0) {
            stringBuffer.append("c/s/tag/rand_and_user_tag");
        } else {
            stringBuffer.append("c/s/tag/rand_tag");
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(new BasicNameValuePair("level1_limit", "12"));
        arrayList.add(new BasicNameValuePair("level2_limit", "3"));
        p();
        this.M = new ab(this, stringBuffer.toString(), z, arrayList);
        this.M.setPriority(3);
        this.M.execute(stringBuffer.toString(), Boolean.valueOf(z), arrayList);
    }

    private void p() {
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
    public void q() {
        setResult(-1);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c() {
        if (this.q != null) {
            if (this.q.i().size() == 0) {
                a(getString(R.string.tag_is_null));
            } else if (this.H == null) {
                this.H = new AlertDialog.Builder(this).create();
                this.H.setCanceledOnTouchOutside(true);
                this.I = getLayoutInflater().inflate(R.layout.tag_setting_dialog, (ViewGroup) null);
                this.J = new aq(this, this.q);
                this.J.a(this.R);
                ((GridView) this.I.findViewById(R.id.tag_grid_view)).setAdapter((ListAdapter) this.J);
                this.H.show();
                this.H.setContentView(this.I);
                int b = com.baidu.tieba.util.am.b((Context) this);
                int a2 = com.baidu.tieba.util.am.a((Context) this);
                int[] iArr = new int[2];
                this.d.getLocationInWindow(iArr);
                WindowManager.LayoutParams attributes = this.H.getWindow().getAttributes();
                attributes.gravity = 17;
                attributes.width = a2 - com.baidu.tieba.util.am.a((Context) this, 28.0f);
                attributes.height = (b * 250) / 480;
                attributes.y = ((iArr[1] - (b / 2)) - (attributes.height / 2)) - com.baidu.tieba.util.am.a((Context) this, 20.0f);
                this.H.getWindow().setAttributes(attributes);
            } else {
                if (this.J != null) {
                    this.J.notifyDataSetChanged();
                }
                this.H.show();
            }
        }
    }

    private void r() {
        if (this.J != null) {
            this.J.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(boolean z) {
        if (this.q != null && this.d != null) {
            int ratio = ((int) (this.d.getRatio() * 10.0f)) / 2;
            int size = this.q.i().size();
            if (z) {
                this.d.startAnimation(this.x);
            }
            if (size < 11 || size >= 50 || ratio < 11 || ratio >= 50) {
                if (size < 4) {
                    this.d.setRatio(0.2f * size);
                }
                if (size >= 4 && size < 11) {
                    this.d.setRatio(0.6f + ((size - 3) * 0.05f));
                }
                if (size >= 11) {
                    this.d.setRatio(1.0f);
                }
            }
        }
    }

    private void s() {
        if (this.k != null) {
            for (com.baidu.tieba.view.as asVar : this.k) {
                if (asVar != null) {
                    asVar.setAnimation(null);
                }
            }
        }
        this.w.setRepeatCount(0);
    }

    private void t() {
        if (this.k != null) {
            for (com.baidu.tieba.view.as asVar : this.k) {
                if (asVar != null) {
                    asVar.setAnimation(this.w);
                }
            }
        }
        this.w.setRepeatCount(-1);
        this.w.start();
    }
}
