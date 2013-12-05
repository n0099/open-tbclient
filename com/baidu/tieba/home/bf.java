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
import com.baidu.tieba.view.HeadImageView;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class bf extends BaseAdapter implements AbsListView.OnScrollListener, bw {
    private t b;
    private Context c;
    private LayoutInflater d;
    private volatile boolean e;
    private com.baidu.tieba.util.i f;
    private boolean j;
    private TextView k;

    /* renamed from: a  reason: collision with root package name */
    private ArrayList<u> f1470a = new ArrayList<>();
    private HashMap<String, bu> g = new HashMap<>();
    private ColorDrawable h = new ColorDrawable(-13881543);
    private ColorDrawable i = new ColorDrawable(-1775893);

    public bf(Context context, TextView textView) {
        this.c = context;
        this.k = textView;
        this.d = (LayoutInflater) this.c.getSystemService("layout_inflater");
        this.f = new com.baidu.tieba.util.i(this.c);
    }

    public void a(t tVar) {
        this.b = tVar;
        this.f1470a = tVar.j();
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
        return this.f1470a.size() * 2;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (i % 2 == 0) {
            return this.f1470a.get(i / 2);
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
            bj bjVar = new bj(this);
            bjVar.f1474a = (HeadImageView) inflate.findViewById(R.id.signallforum_item_avatar);
            bjVar.f1474a.setIsRound(false);
            bjVar.f1474a.setGifIconSupport(false);
            bjVar.c = (TextView) inflate.findViewById(R.id.signallforum_item_name);
            bjVar.d = (TextView) inflate.findViewById(R.id.signallforum_item_level);
            bjVar.e = (TextView) inflate.findViewById(R.id.signallforum_item_exp);
            bjVar.f = (FrameLayout) inflate.findViewById(R.id.signallforum_item_res_container);
            bjVar.g = (TextView) inflate.findViewById(R.id.signallforum_item_days);
            bjVar.h = (RelativeLayout) inflate.findViewById(R.id.signallforum_item_resign_container);
            bjVar.i = (ImageView) inflate.findViewById(R.id.signallforum_item_resign_icon);
            bjVar.j = (ProgressBar) inflate.findViewById(R.id.signallforum_item_resign_progress);
            bjVar.k = (TextView) inflate.findViewById(R.id.signallforum_item_resign_text);
            bjVar.l = (TextView) inflate.findViewById(R.id.signallforum_item_error);
            bjVar.b = (LinearLayout) inflate.findViewById(R.id.signallforum_item_level_container);
            bjVar.m = (TextView) inflate.findViewById(R.id.signallforum_item_increaseexp);
            inflate.setTag(bjVar);
            return inflate;
        }
        View view = new View(this.c);
        view.setLayoutParams(new AbsListView.LayoutParams(-1, com.baidu.adp.lib.h.g.a(this.c, 1.0f)));
        return view;
    }

    private void a(View view, View view2, int i) {
        com.baidu.tieba.j jVar = (com.baidu.tieba.j) this.c;
        jVar.getLayoutMode().a(TiebaApplication.h().an() == 1);
        jVar.getLayoutMode().a(view);
        bj bjVar = (bj) view.getTag();
        u uVar = (u) getItem(i);
        bjVar.c.setText(uVar.b());
        bjVar.d.setText(uVar.f() + "");
        bjVar.d.setBackgroundResource(com.baidu.tieba.util.m.b(uVar.f()));
        bjVar.e.setText(uVar.g() + "/" + uVar.h());
        bjVar.m.clearAnimation();
        bjVar.f.clearAnimation();
        if (uVar.i()) {
            bjVar.b.setVisibility(0);
            bjVar.l.setVisibility(8);
            bjVar.g.setVisibility(0);
            bjVar.h.setVisibility(8);
            bjVar.g.setText(String.format(this.c.getString(R.string.signallforum_days), Integer.valueOf(uVar.e())));
            if (uVar.o()) {
                bjVar.e.setText(this.c.getString(R.string.signallforum_uplevel));
                bjVar.m.setVisibility(8);
            } else {
                bjVar.e.setText(uVar.g() + "/" + uVar.h());
                bjVar.m.setVisibility(0);
            }
            int m = uVar.m();
            if (m > 0) {
                bjVar.m.setVisibility(0);
                bjVar.m.setText("+" + m);
            } else {
                bjVar.m.setVisibility(8);
            }
            if (!uVar.l()) {
                bi biVar = new bi(bjVar.f);
                biVar.setDuration(800L);
                biVar.setFillAfter(true);
                biVar.setInterpolator(new DecelerateInterpolator());
                bjVar.f.startAnimation(biVar);
                if (m > 0) {
                    AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                    alphaAnimation.setDuration(800L);
                    alphaAnimation.setFillAfter(true);
                    alphaAnimation.setInterpolator(new DecelerateInterpolator());
                    bjVar.m.startAnimation(alphaAnimation);
                }
                uVar.d(true);
            }
        } else if (uVar.j()) {
            String n = uVar.n();
            if (!TextUtils.isEmpty(n)) {
                bjVar.b.setVisibility(8);
                bjVar.l.setVisibility(0);
                bjVar.m.setVisibility(8);
                bjVar.l.setText(n);
            } else {
                bjVar.b.setVisibility(0);
                bjVar.l.setVisibility(8);
                bjVar.m.setVisibility(8);
            }
            bjVar.g.setVisibility(8);
            bjVar.h.setVisibility(0);
            if (uVar.k()) {
                bjVar.i.setVisibility(4);
                bjVar.j.setVisibility(0);
                bjVar.k.setText(R.string.signallforum_resigning);
            } else {
                bjVar.i.setVisibility(0);
                bjVar.j.setVisibility(4);
                bjVar.k.setText(R.string.signallforum_resign);
            }
            bjVar.h.setOnClickListener(new bg(this, uVar, bjVar));
        } else {
            bjVar.g.setVisibility(8);
            bjVar.h.setVisibility(8);
            bjVar.m.setVisibility(8);
            bjVar.b.setVisibility(0);
            bjVar.l.setVisibility(8);
        }
        String c = uVar.c();
        bjVar.f1474a.setTag(c);
        if (this.f.d(c) != null) {
            bjVar.f1474a.invalidate();
        } else if (!this.e) {
            this.f.a(uVar.c(), new bh(this, view2));
        }
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        int itemViewType = getItemViewType(i);
        View a2 = view == null ? a(itemViewType) : view;
        if (itemViewType == 1) {
            if (TiebaApplication.h().an() == 1) {
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

    @Override // com.baidu.tieba.home.bw
    public void a(SignData signData) {
        String forumId = signData.getForumId();
        this.g.remove(forumId);
        a(forumId, true, signData, null);
    }

    @Override // com.baidu.tieba.home.bw
    public void a(String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            com.baidu.adp.lib.h.g.a(this.c, str2);
        }
        this.g.remove(str);
        a(str, false, null, str2);
    }

    private void a(String str, boolean z, SignData signData, String str2) {
        int size = this.f1470a.size();
        for (int i = 0; i < size; i++) {
            u uVar = this.f1470a.get(i);
            if ((uVar.a() + "").equals(str)) {
                uVar.a(z);
                uVar.b(!z);
                uVar.c(false);
                if (z) {
                    uVar.b(signData.getCountSignNum());
                    uVar.d(signData.getBonusPoint());
                    uVar.a(1);
                    TiebaApplication.h().a(uVar.b(), signData.getBonusPoint(), -1);
                    ArrayList<u> m = this.b.m();
                    if (m.contains(uVar)) {
                        m.remove(uVar);
                        this.b.l().add(uVar);
                    }
                    int size2 = this.b.j().size();
                    int size3 = this.b.l().size();
                    this.k.setText(String.format(this.c.getString(R.string.signallforum_res), Integer.valueOf(size3), Integer.valueOf(size2 - size3)));
                } else {
                    uVar.a(str2);
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
        for (Map.Entry<String, bu> entry : this.g.entrySet()) {
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
