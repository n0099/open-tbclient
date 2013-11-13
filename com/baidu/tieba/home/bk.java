package com.baidu.tieba.home;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.DecelerateInterpolator;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.SignData;
import com.baidu.tieba.util.UtilHelper;
import com.baidu.tieba.view.HeadImageView;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class bk extends BaseAdapter implements AbsListView.OnScrollListener, cb {
    private y b;
    private Context c;
    private LayoutInflater d;
    private volatile boolean e;
    private com.baidu.tieba.util.i f;
    private boolean j;
    private TextView k;

    /* renamed from: a  reason: collision with root package name */
    private ArrayList<z> f1429a = new ArrayList<>();
    private HashMap<String, bz> g = new HashMap<>();
    private ColorDrawable h = new ColorDrawable(-13881543);
    private ColorDrawable i = new ColorDrawable(-1775893);

    public bk(Context context, TextView textView) {
        this.c = context;
        this.k = textView;
        this.d = (LayoutInflater) this.c.getSystemService("layout_inflater");
        this.f = new com.baidu.tieba.util.i(this.c);
    }

    public void a(y yVar) {
        this.b = yVar;
        this.f1429a = yVar.j();
        notifyDataSetChanged();
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        return i % 2 == 0 ? 0 : 1;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f1429a.size() * 2;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (i % 2 == 0) {
            return this.f1429a.get(i / 2);
        }
        return -1;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    private View a(int i) {
        if (i == 0) {
            View inflate = this.d.inflate(R.layout.signallforum_item, (ViewGroup) null);
            bo boVar = new bo(this);
            boVar.f1433a = (HeadImageView) inflate.findViewById(R.id.signallforum_item_avatar);
            boVar.f1433a.setIsRound(false);
            boVar.f1433a.setGifIconSupport(false);
            boVar.c = (TextView) inflate.findViewById(R.id.signallforum_item_name);
            boVar.d = (TextView) inflate.findViewById(R.id.signallforum_item_level);
            boVar.e = (TextView) inflate.findViewById(R.id.signallforum_item_exp);
            boVar.f = (FrameLayout) inflate.findViewById(R.id.signallforum_item_res_container);
            boVar.g = (TextView) inflate.findViewById(R.id.signallforum_item_days);
            boVar.h = (RelativeLayout) inflate.findViewById(R.id.signallforum_item_resign_container);
            boVar.i = (ImageView) inflate.findViewById(R.id.signallforum_item_resign_icon);
            boVar.j = (ProgressBar) inflate.findViewById(R.id.signallforum_item_resign_progress);
            boVar.k = (TextView) inflate.findViewById(R.id.signallforum_item_resign_text);
            boVar.l = (TextView) inflate.findViewById(R.id.signallforum_item_error);
            boVar.b = (LinearLayout) inflate.findViewById(R.id.signallforum_item_level_container);
            boVar.m = (TextView) inflate.findViewById(R.id.signallforum_item_increaseexp);
            inflate.setTag(boVar);
            return inflate;
        }
        View view = new View(this.c);
        view.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.a(this.c, 1.0f)));
        return view;
    }

    private void a(View view, View view2, int i) {
        com.baidu.tieba.j jVar = (com.baidu.tieba.j) this.c;
        jVar.getLayoutMode().a(TiebaApplication.g().ap() == 1);
        jVar.getLayoutMode().a(view);
        bo boVar = (bo) view.getTag();
        z zVar = (z) getItem(i);
        boVar.c.setText(zVar.b());
        boVar.d.setText(zVar.f() + "");
        boVar.d.setBackgroundResource(com.baidu.tieba.util.m.b(zVar.f()));
        boVar.e.setText(zVar.g() + "/" + zVar.h());
        boVar.m.clearAnimation();
        boVar.f.clearAnimation();
        if (zVar.i()) {
            boVar.b.setVisibility(0);
            boVar.l.setVisibility(8);
            boVar.g.setVisibility(0);
            boVar.h.setVisibility(8);
            boVar.g.setText(String.format(this.c.getString(R.string.signallforum_days), Integer.valueOf(zVar.e())));
            if (zVar.o()) {
                boVar.e.setText(this.c.getString(R.string.signallforum_uplevel));
                boVar.m.setVisibility(8);
            } else {
                boVar.e.setText(zVar.g() + "/" + zVar.h());
                boVar.m.setVisibility(0);
            }
            int m = zVar.m();
            if (m > 0) {
                boVar.m.setVisibility(0);
                boVar.m.setText("+" + m);
            } else {
                boVar.m.setVisibility(8);
            }
            if (!zVar.l()) {
                bn bnVar = new bn(boVar.f);
                bnVar.setDuration(800L);
                bnVar.setFillAfter(true);
                bnVar.setInterpolator(new DecelerateInterpolator());
                boVar.f.startAnimation(bnVar);
                if (m > 0) {
                    AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                    alphaAnimation.setDuration(800L);
                    alphaAnimation.setFillAfter(true);
                    alphaAnimation.setInterpolator(new DecelerateInterpolator());
                    boVar.m.startAnimation(alphaAnimation);
                }
                zVar.d(true);
            }
        } else if (zVar.j()) {
            String n = zVar.n();
            if (!TextUtils.isEmpty(n)) {
                boVar.b.setVisibility(8);
                boVar.l.setVisibility(0);
                boVar.m.setVisibility(8);
                boVar.l.setText(n);
            } else {
                boVar.b.setVisibility(0);
                boVar.l.setVisibility(8);
                boVar.m.setVisibility(8);
            }
            boVar.g.setVisibility(8);
            boVar.h.setVisibility(0);
            if (zVar.k()) {
                boVar.i.setVisibility(4);
                boVar.j.setVisibility(0);
                boVar.k.setText(R.string.signallforum_resigning);
            } else {
                boVar.i.setVisibility(0);
                boVar.j.setVisibility(4);
                boVar.k.setText(R.string.signallforum_resign);
            }
            boVar.h.setOnClickListener(new bl(this, zVar, boVar));
        } else {
            boVar.g.setVisibility(8);
            boVar.h.setVisibility(8);
            boVar.m.setVisibility(8);
            boVar.b.setVisibility(0);
            boVar.l.setVisibility(8);
        }
        String c = zVar.c();
        boVar.f1433a.setTag(c);
        if (this.f.d(c) != null) {
            boVar.f1433a.invalidate();
        } else if (!this.e) {
            this.f.a(zVar.c(), new bm(this, view2));
        }
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        int itemViewType = getItemViewType(i);
        View a2 = view == null ? a(itemViewType) : view;
        if (itemViewType == 1) {
            if (TiebaApplication.g().ap() == 1) {
                a2.setBackgroundDrawable(this.h);
            } else {
                a2.setBackgroundDrawable(this.i);
            }
        } else {
            a(a2, viewGroup, i);
        }
        return a2;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 0) {
            this.e = false;
            notifyDataSetChanged();
            return;
        }
        this.e = true;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }

    @Override // com.baidu.tieba.home.cb
    public void a(SignData signData) {
        String forumId = signData.getForumId();
        this.g.remove(forumId);
        a(forumId, true, signData, null);
    }

    @Override // com.baidu.tieba.home.cb
    public void a(String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            UtilHelper.a(this.c, str2);
        }
        this.g.remove(str);
        a(str, false, null, str2);
    }

    private void a(String str, boolean z, SignData signData, String str2) {
        int size = this.f1429a.size();
        for (int i = 0; i < size; i++) {
            z zVar = this.f1429a.get(i);
            if ((zVar.a() + "").equals(str)) {
                zVar.a(z);
                zVar.b(!z);
                zVar.c(false);
                if (z) {
                    zVar.b(signData.getCountSignNum());
                    zVar.d(signData.getBonusPoint());
                    zVar.a(1);
                    TiebaApplication.g().a(zVar.b(), signData.getBonusPoint());
                    ArrayList<z> m = this.b.m();
                    if (m.contains(zVar)) {
                        m.remove(zVar);
                        this.b.l().add(zVar);
                    }
                    int size2 = this.b.j().size();
                    int size3 = this.b.l().size();
                    this.k.setText(String.format(this.c.getString(R.string.signallforum_res), Integer.valueOf(size3), Integer.valueOf(size2 - size3)));
                } else {
                    zVar.a(str2);
                }
                if (!this.j) {
                    notifyDataSetChanged();
                    return;
                }
                return;
            }
        }
    }

    public void a() {
        this.j = true;
        for (Map.Entry<String, bz> entry : this.g.entrySet()) {
            entry.getValue().a();
        }
        this.g.clear();
    }

    public void b() {
        if (this.f != null) {
            this.f.b();
        }
    }
}
