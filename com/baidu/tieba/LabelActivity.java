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
    public static String f614a = "allthread";
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
    private com.baidu.tieba.model.ai q;
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
    private ao J = null;
    private ProgressBar L = null;
    private z M = null;
    private aa N = null;
    private boolean O = true;
    private Handler P = new Handler(new r(this));
    private final bq Q = new s(this);
    private final View.OnClickListener R = new t(this);
    private View.OnTouchListener S = new u(this);

    public void startDropSmallBall(View view) {
        try {
            if (this.q != null && this.q.h().size() >= 50) {
                a(getString(R.string.too_much_tags));
                return;
            }
            com.baidu.tieba.view.ag agVar = (com.baidu.tieba.view.ag) view;
            if (agVar.getTag(R.id.label_smallball_checked) == null || ((Integer) agVar.getTag(R.id.label_smallball_checked)).intValue() != 1) {
                agVar.setTag(R.id.label_smallball_checked, 1);
                com.baidu.tieba.data.z zVar = (com.baidu.tieba.data.z) agVar.getTag(R.id.label_ball_data);
                AbsoluteLayout.LayoutParams layoutParams = new AbsoluteLayout.LayoutParams(zVar.f(), zVar.g(), zVar.d(), zVar.e());
                com.baidu.tieba.view.ag agVar2 = new com.baidu.tieba.view.ag(this);
                agVar2.setType(1);
                ((ViewGroup) this.j.get(this.b.getCurrentItem())).addView(agVar2, layoutParams);
                this.n.add(agVar2);
                if (this.m != null && this.m.size() > 0 && this.m.contains(agVar)) {
                    this.m.remove(agVar);
                    agVar.setTag(null);
                }
                agVar2.setTag(R.id.label_parabola_computer, new ab(this, zVar.d(), zVar.e(), com.baidu.tieba.util.ab.a(this, 35.0f), this.b.getHeight() - com.baidu.tieba.util.ab.a(this, 50.0f), 700L));
                String i = zVar.i();
                if (i != null && i.length() > 0) {
                    com.baidu.tieba.data.az azVar = new com.baidu.tieba.data.az();
                    azVar.a(zVar.j());
                    azVar.b(i);
                    if (this.q != null && this.q.h() != null) {
                        this.q.a(azVar);
                    }
                    if (i.length() > 4) {
                        i = i.substring(0, 4);
                    }
                    agVar2.setText(i);
                    agVar2.setTextSize(com.baidu.tieba.util.ab.a(this, 14.0f));
                }
                agVar2.a(b(zVar.h()), this.s);
                agVar2.invalidate();
                this.F = System.currentTimeMillis();
                this.P.sendMessage(this.P.obtainMessage(1));
                agVar.setText("");
                agVar.setOnTouchListener(null);
                agVar.a();
                agVar.invalidate();
                d();
            }
        } catch (Exception e) {
            com.baidu.tieba.util.z.b(LabelActivity.class.getName(), "startDropSmallBall", e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view) {
        if (this.q != null && this.q.h().size() >= 50) {
            a(getString(R.string.too_much_tags));
            return;
        }
        com.baidu.tieba.view.ag agVar = (com.baidu.tieba.view.ag) view;
        agVar.setTag(R.id.label_ball_state, 1);
        AbsoluteLayout.LayoutParams layoutParams = (AbsoluteLayout.LayoutParams) agVar.getLayoutParams();
        agVar.setTag(R.id.label_parabola_computer, new ab(this, layoutParams.x, layoutParams.y, com.baidu.tieba.util.ab.a(this, 35.0f), this.b.getHeight() - com.baidu.tieba.util.ab.a(this, 60.0f), 700L));
        com.baidu.tieba.data.y yVar = (com.baidu.tieba.data.y) agVar.getTag(R.id.label_ball_data);
        if (yVar != null) {
            List b = yVar.b();
            if (b != null && b.size() > 0) {
                a(b, (ViewGroup) this.j.get(yVar.c()));
                p();
            }
            com.baidu.tieba.data.az azVar = new com.baidu.tieba.data.az();
            azVar.a(yVar.j());
            azVar.b(yVar.i());
            if (this.q != null && this.q.h() != null) {
                this.q.a(azVar);
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
        bundle.putString("from", f614a);
    }

    @Override // com.baidu.tieba.g, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.u = (Vibrator) getSystemService("vibrator");
        com.baidu.tieba.util.z.a(getClass().getName(), "onCreate", null);
        setContentView(R.layout.label_activity);
        if (bundle != null) {
            f614a = bundle.getString("from");
        }
        String stringExtra = getIntent().getStringExtra("from");
        if (stringExtra != null && stringExtra.length() > 0) {
            f614a = stringExtra;
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

    @Override // com.baidu.tieba.g, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        switch (i) {
            case 4:
                s();
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
    public boolean a(com.baidu.tieba.view.ag agVar, long j) {
        if (agVar != null) {
            try {
                if (agVar.getTag(R.id.label_parabola_computer) != null && (agVar.getTag(R.id.label_parabola_computer) instanceof ab)) {
                    ab abVar = (ab) agVar.getTag(R.id.label_parabola_computer);
                    agVar.setGradual(1.0f - abVar.a());
                    AbsoluteLayout.LayoutParams layoutParams = (AbsoluteLayout.LayoutParams) agVar.getLayoutParams();
                    abVar.a(j);
                    layoutParams.x = abVar.b();
                    layoutParams.y = abVar.c();
                    if (layoutParams.y >= abVar.d()) {
                        a(agVar);
                        c(true);
                        return true;
                    }
                    agVar.setLayoutParams(layoutParams);
                    agVar.invalidate();
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
        this.c = (Button) findViewById(R.id.refresh);
        this.c.setOnClickListener(new v(this));
        this.b = (ViewPager) findViewById(R.id.viewPager);
        this.b.setAdapter(this.p);
        this.b.setOnPageChangeListener(this.Q);
        this.d = (HeartButton) findViewById(R.id.heart);
        this.d.setOnClickListener(new w(this));
        this.e = (Button) findViewById(R.id.next);
        if (f614a.equals("allthread")) {
            this.e.setBackgroundDrawable(getResources().getDrawable(R.drawable.tag_finish_button));
        }
        this.e.setOnClickListener(new x(this));
        this.t = (LinearLayout) findViewById(R.id.tagsGroup);
        this.x = AnimationUtils.loadAnimation(this, R.anim.heart_shake);
        this.g = (RelativeLayout) findViewById(R.id.parent);
        if (f614a.equals("guide")) {
            this.f = new ImageView(this);
            this.f.setBackgroundResource(R.drawable.tag_mask);
            this.g.addView(this.f, new LinearLayout.LayoutParams(-1, -1));
            this.f.setOnClickListener(new y(this));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b() {
        this.g.removeView(this.f);
        this.f = null;
    }

    private void a(com.baidu.tieba.view.ag agVar) {
        try {
            agVar.setAnimation(null);
            if (agVar.getParent() != null && (agVar.getParent() instanceof ViewGroup)) {
                ((ViewGroup) agVar.getParent()).removeView(agVar);
            }
        } catch (Exception e) {
            com.baidu.tieba.util.z.b(getClass().getName(), "removeBallView", e.toString());
        }
    }

    private void n() {
        this.P.removeMessages(0);
        this.P.removeMessages(1);
        if (this.l != null && this.l.size() > 0) {
            for (com.baidu.tieba.view.ag agVar : this.l) {
                a(agVar);
            }
            this.l.clear();
        }
        if (this.n != null && this.n.size() > 0) {
            for (com.baidu.tieba.view.ag agVar2 : this.n) {
                a(agVar2);
            }
            this.n.clear();
        }
        if (this.k != null && this.k.size() > 0) {
            for (com.baidu.tieba.view.ag agVar3 : this.k) {
                a(agVar3);
            }
            this.k.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
        boolean z = false;
        if (this.q != null && this.q.a() != null && this.q.a().size() > 0) {
            n();
            List<com.baidu.tieba.data.y> a2 = this.q.a();
            if (a2 != null && a2.size() > 0) {
                boolean z2 = false;
                for (com.baidu.tieba.data.y yVar : a2) {
                    if (yVar.a() || yVar.c() == 0) {
                        a(yVar.b(), (ViewGroup) this.j.get(yVar.c()));
                        z2 = true;
                    } else {
                        AbsoluteLayout.LayoutParams layoutParams = new AbsoluteLayout.LayoutParams(yVar.f(), yVar.g(), yVar.d(), yVar.e());
                        com.baidu.tieba.view.ag agVar = new com.baidu.tieba.view.ag(this);
                        agVar.setType(0);
                        int c = yVar.c();
                        if (c < this.j.size() && c >= 0) {
                            ((ViewGroup) this.j.get(yVar.c())).addView(agVar, layoutParams);
                            this.k.add(agVar);
                            String i = yVar.i();
                            if (i != null && i.length() > 0) {
                                if (i.length() > 4) {
                                    i = i.substring(0, 4);
                                }
                                agVar.setText(i);
                                agVar.setTextSize(com.baidu.tieba.util.ab.a(this, 18.0f));
                            }
                            agVar.setTag(R.id.label_ball_data, yVar);
                            agVar.setTag(R.id.label_ball_state, 0);
                            agVar.a(b(yVar.h()), this.s);
                            agVar.setOnTouchListener(this.S);
                            agVar.invalidate();
                            agVar.setAnimation(this.w);
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
                    ((com.baidu.tieba.view.ag) this.m.get(i2)).startAnimation(this.v);
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
                com.baidu.tieba.data.z zVar = (com.baidu.tieba.data.z) it.next();
                int i2 = i + 1;
                if (i2 <= 3) {
                    ViewGroup.LayoutParams layoutParams = new AbsoluteLayout.LayoutParams(zVar.f(), zVar.g(), zVar.d(), zVar.e());
                    com.baidu.tieba.view.ag agVar = new com.baidu.tieba.view.ag(this);
                    agVar.setType(1);
                    if (this.b.getCurrentItem() == zVar.c()) {
                        agVar.a(0);
                    }
                    if (viewGroup == null) {
                        ((ViewGroup) this.j.get(zVar.c())).addView(agVar, layoutParams);
                    } else {
                        viewGroup.addView(agVar, layoutParams);
                    }
                    this.l.add(agVar);
                    this.m.add(agVar);
                    String i3 = zVar.i();
                    if (i3 != null && i3.length() > 0) {
                        if (i3.length() > 4) {
                            i3 = i3.substring(0, 4);
                        }
                        agVar.setText(i3);
                        agVar.setTextSize(com.baidu.tieba.util.ab.a(this, 14.0f));
                    }
                    agVar.setTag(R.id.label_ball_data, zVar);
                    agVar.a(b(zVar.h()), this.s);
                    agVar.setOnTouchListener(this.S);
                    agVar.invalidate();
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
        u();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.g, android.app.Activity
    public void onResume() {
        super.onResume();
        v();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.g, android.app.Activity
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
            com.baidu.tieba.util.z.b(getClass().getName(), "onDestroy", e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.g, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.q != null && this.O) {
            DatabaseService.a(this.q.f(), 12);
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
                String E = TiebaApplication.E();
                if (E == null || E.length() <= 0) {
                    z = false;
                }
                this.N = new aa(this, z, d);
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
        stringBuffer.append(com.baidu.tieba.data.g.f787a);
        String E = TiebaApplication.E();
        if (z && E != null && E.length() > 0) {
            stringBuffer.append("c/s/tag/rand_and_user_tag");
        } else {
            stringBuffer.append("c/s/tag/rand_tag");
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(new BasicNameValuePair("level1_limit", "12"));
        arrayList.add(new BasicNameValuePair("level2_limit", "3"));
        r();
        this.M = new z(this, stringBuffer.toString(), z, arrayList);
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
                this.J = new ao(this, this.q);
                this.J.a(this.R);
                ((GridView) this.I.findViewById(R.id.tag_grid_view)).setAdapter((ListAdapter) this.J);
                this.H.show();
                this.H.setContentView(this.I);
                int b = com.baidu.tieba.util.ab.b((Context) this);
                int a2 = com.baidu.tieba.util.ab.a((Context) this);
                int[] iArr = new int[2];
                this.d.getLocationInWindow(iArr);
                WindowManager.LayoutParams attributes = this.H.getWindow().getAttributes();
                attributes.gravity = 17;
                attributes.width = a2 - com.baidu.tieba.util.ab.a(this, 28.0f);
                attributes.height = (b * 250) / 480;
                attributes.y = ((iArr[1] - (b / 2)) - (attributes.height / 2)) - com.baidu.tieba.util.ab.a(this, 20.0f);
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
        if (this.q != null && this.d != null) {
            int ratio = ((int) (this.d.getRatio() * 10.0f)) / 2;
            int size = this.q.h().size();
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

    private void u() {
        if (this.k != null) {
            for (com.baidu.tieba.view.ag agVar : this.k) {
                if (agVar != null) {
                    agVar.setAnimation(null);
                }
            }
        }
        this.w.setRepeatCount(0);
    }

    private void v() {
        if (this.k != null) {
            for (com.baidu.tieba.view.ag agVar : this.k) {
                if (agVar != null) {
                    agVar.setAnimation(this.w);
                }
            }
        }
        this.w.setRepeatCount(-1);
        this.w.start();
    }
}
