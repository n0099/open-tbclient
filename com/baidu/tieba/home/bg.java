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
public class bg extends BaseAdapter implements AbsListView.OnScrollListener, by {
    private u b;
    private Context c;
    private LayoutInflater d;
    private volatile boolean e;
    private com.baidu.tieba.util.i f;
    private boolean j;
    private TextView k;
    private ArrayList<v> a = new ArrayList<>();
    private HashMap<String, bw> g = new HashMap<>();
    private ColorDrawable h = new ColorDrawable(-13881543);
    private ColorDrawable i = new ColorDrawable(-1775893);

    public bg(Context context, TextView textView) {
        this.c = context;
        this.k = textView;
        this.d = (LayoutInflater) this.c.getSystemService("layout_inflater");
        this.f = new com.baidu.tieba.util.i(this.c);
    }

    public void a(u uVar) {
        this.b = uVar;
        this.a = uVar.j();
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
        return this.a.size() * 2;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (i % 2 == 0) {
            return this.a.get(i / 2);
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
            bk bkVar = new bk(this);
            bkVar.a = (HeadImageView) inflate.findViewById(R.id.signallforum_item_avatar);
            bkVar.a.setIsRound(false);
            bkVar.a.setGifIconSupport(false);
            bkVar.c = (TextView) inflate.findViewById(R.id.signallforum_item_name);
            bkVar.d = (TextView) inflate.findViewById(R.id.signallforum_item_level);
            bkVar.e = (TextView) inflate.findViewById(R.id.signallforum_item_exp);
            bkVar.f = (FrameLayout) inflate.findViewById(R.id.signallforum_item_res_container);
            bkVar.g = (TextView) inflate.findViewById(R.id.signallforum_item_days);
            bkVar.h = (RelativeLayout) inflate.findViewById(R.id.signallforum_item_resign_container);
            bkVar.i = (ImageView) inflate.findViewById(R.id.signallforum_item_resign_icon);
            bkVar.j = (ProgressBar) inflate.findViewById(R.id.signallforum_item_resign_progress);
            bkVar.k = (TextView) inflate.findViewById(R.id.signallforum_item_resign_text);
            bkVar.l = (TextView) inflate.findViewById(R.id.signallforum_item_error);
            bkVar.b = (LinearLayout) inflate.findViewById(R.id.signallforum_item_level_container);
            bkVar.m = (TextView) inflate.findViewById(R.id.signallforum_item_increaseexp);
            inflate.setTag(bkVar);
            return inflate;
        }
        View view = new View(this.c);
        view.setLayoutParams(new AbsListView.LayoutParams(-1, com.baidu.adp.lib.g.g.a(this.c, 1.0f)));
        return view;
    }

    private void a(View view, View view2, int i) {
        com.baidu.tieba.j jVar = (com.baidu.tieba.j) this.c;
        jVar.getLayoutMode().a(TiebaApplication.h().al() == 1);
        jVar.getLayoutMode().a(view);
        bk bkVar = (bk) view.getTag();
        v vVar = (v) getItem(i);
        bkVar.c.setText(vVar.b());
        bkVar.d.setText(vVar.f() + "");
        bkVar.d.setBackgroundResource(com.baidu.tieba.util.n.b(vVar.f()));
        bkVar.e.setText(vVar.g() + "/" + vVar.h());
        bkVar.m.clearAnimation();
        bkVar.f.clearAnimation();
        if (vVar.i()) {
            bkVar.b.setVisibility(0);
            bkVar.l.setVisibility(8);
            bkVar.g.setVisibility(0);
            bkVar.h.setVisibility(8);
            bkVar.g.setText(String.format(this.c.getString(R.string.signallforum_days), Integer.valueOf(vVar.e())));
            if (vVar.o()) {
                bkVar.e.setText(this.c.getString(R.string.signallforum_uplevel));
                bkVar.m.setVisibility(8);
            } else {
                bkVar.e.setText(vVar.g() + "/" + vVar.h());
                bkVar.m.setVisibility(0);
            }
            int m = vVar.m();
            if (m > 0) {
                bkVar.m.setVisibility(0);
                bkVar.m.setText("+" + m);
            } else {
                bkVar.m.setVisibility(8);
            }
            if (!vVar.l()) {
                bj bjVar = new bj(bkVar.f);
                bjVar.setDuration(800L);
                bjVar.setFillAfter(true);
                bjVar.setInterpolator(new DecelerateInterpolator());
                bkVar.f.startAnimation(bjVar);
                if (m > 0) {
                    AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                    alphaAnimation.setDuration(800L);
                    alphaAnimation.setFillAfter(true);
                    alphaAnimation.setInterpolator(new DecelerateInterpolator());
                    bkVar.m.startAnimation(alphaAnimation);
                }
                vVar.d(true);
            }
        } else if (vVar.j()) {
            String n = vVar.n();
            if (!TextUtils.isEmpty(n)) {
                bkVar.b.setVisibility(8);
                bkVar.l.setVisibility(0);
                bkVar.m.setVisibility(8);
                bkVar.l.setText(n);
            } else {
                bkVar.b.setVisibility(0);
                bkVar.l.setVisibility(8);
                bkVar.m.setVisibility(8);
            }
            bkVar.g.setVisibility(8);
            bkVar.h.setVisibility(0);
            if (vVar.k()) {
                bkVar.i.setVisibility(4);
                bkVar.j.setVisibility(0);
                bkVar.k.setText(R.string.signallforum_resigning);
            } else {
                bkVar.i.setVisibility(0);
                bkVar.j.setVisibility(4);
                bkVar.k.setText(R.string.signallforum_resign);
            }
            bkVar.h.setOnClickListener(new bh(this, vVar, bkVar));
        } else {
            bkVar.g.setVisibility(8);
            bkVar.h.setVisibility(8);
            bkVar.m.setVisibility(8);
            bkVar.b.setVisibility(0);
            bkVar.l.setVisibility(8);
        }
        String c = vVar.c();
        bkVar.a.setTag(c);
        if (this.f.d(c) != null) {
            bkVar.a.invalidate();
        } else if (!this.e) {
            this.f.b(vVar.c(), new bi(this, view2));
        }
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        int itemViewType = getItemViewType(i);
        View a = view == null ? a(itemViewType) : view;
        if (itemViewType == 1) {
            if (TiebaApplication.h().al() == 1) {
                a.setBackgroundDrawable(this.h);
            } else {
                a.setBackgroundDrawable(this.i);
            }
        } else {
            a(a, viewGroup, i);
        }
        return a;
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

    @Override // com.baidu.tieba.home.by
    public void a(SignData signData) {
        String forumId = signData.getForumId();
        synchronized (this) {
            this.g.remove(forumId);
        }
        a(forumId, true, signData, null);
    }

    @Override // com.baidu.tieba.home.by
    public void a(String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            com.baidu.adp.lib.g.g.a(this.c, str2);
        }
        synchronized (this) {
            this.g.remove(str);
        }
        a(str, false, null, str2);
    }

    private void a(String str, boolean z, SignData signData, String str2) {
        int size = this.a.size();
        for (int i = 0; i < size; i++) {
            v vVar = this.a.get(i);
            if ((vVar.a() + "").equals(str)) {
                vVar.a(z);
                vVar.b(!z);
                vVar.c(false);
                if (z) {
                    vVar.b(signData.getCountSignNum());
                    vVar.d(signData.getBonusPoint());
                    vVar.a(1);
                    TiebaApplication.h().a(vVar.b(), signData.getBonusPoint(), -1);
                    ArrayList<v> m = this.b.m();
                    if (m.contains(vVar)) {
                        m.remove(vVar);
                        this.b.l().add(vVar);
                    }
                    int size2 = this.b.j().size();
                    int size3 = this.b.l().size();
                    this.k.setText(String.format(this.c.getString(R.string.signallforum_res), Integer.valueOf(size3), Integer.valueOf(size2 - size3)));
                } else {
                    vVar.a(str2);
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
        synchronized (this) {
            try {
                for (Map.Entry<String, bw> entry : this.g.entrySet()) {
                    entry.getValue().a();
                }
                this.g.clear();
            }
        }
    }

    public void b() {
        if (this.f != null) {
            this.f.d();
        }
    }
}
