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
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.SignData;
import com.baidu.tieba.view.HeadImageView;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public final class ae extends BaseAdapter implements AbsListView.OnScrollListener, av {
    private u b;
    private Context c;
    private LayoutInflater d;
    private volatile boolean e;
    private com.baidu.tieba.util.i f;
    private boolean j;
    private TextView k;
    private ArrayList<v> a = new ArrayList<>();
    private HashMap<String, au> g = new HashMap<>();
    private ColorDrawable h = new ColorDrawable(-13881543);
    private ColorDrawable i = new ColorDrawable(-1775893);

    public ae(Context context, TextView textView) {
        this.c = context;
        this.k = textView;
        this.d = (LayoutInflater) this.c.getSystemService("layout_inflater");
        this.f = new com.baidu.tieba.util.i(this.c);
    }

    public final void a(u uVar) {
        this.b = uVar;
        this.a = uVar.j();
        notifyDataSetChanged();
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public final int getViewTypeCount() {
        return 2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public final int getItemViewType(int i) {
        return i % 2 == 0 ? 0 : 1;
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        return this.a.size() * 2;
    }

    @Override // android.widget.Adapter
    public final Object getItem(int i) {
        if (i % 2 == 0) {
            return this.a.get(i / 2);
        }
        return -1;
    }

    @Override // android.widget.Adapter
    public final long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public final View getView(int i, View view, ViewGroup viewGroup) {
        View view2;
        View view3;
        int itemViewType = getItemViewType(i);
        if (view == null) {
            if (itemViewType == 0) {
                View inflate = this.d.inflate(R.layout.signallforum_item, (ViewGroup) null);
                ai aiVar = new ai(this);
                aiVar.a = (HeadImageView) inflate.findViewById(R.id.signallforum_item_avatar);
                aiVar.a.setIsRound(false);
                aiVar.a.setGifIconSupport(false);
                aiVar.c = (TextView) inflate.findViewById(R.id.signallforum_item_name);
                aiVar.d = (TextView) inflate.findViewById(R.id.signallforum_item_level);
                aiVar.e = (TextView) inflate.findViewById(R.id.signallforum_item_exp);
                aiVar.f = (FrameLayout) inflate.findViewById(R.id.signallforum_item_res_container);
                aiVar.g = (TextView) inflate.findViewById(R.id.signallforum_item_days);
                aiVar.h = (RelativeLayout) inflate.findViewById(R.id.signallforum_item_resign_container);
                aiVar.i = (ImageView) inflate.findViewById(R.id.signallforum_item_resign_icon);
                aiVar.j = (ProgressBar) inflate.findViewById(R.id.signallforum_item_resign_progress);
                aiVar.k = (TextView) inflate.findViewById(R.id.signallforum_item_resign_text);
                aiVar.l = (TextView) inflate.findViewById(R.id.signallforum_item_error);
                aiVar.b = (LinearLayout) inflate.findViewById(R.id.signallforum_item_level_container);
                aiVar.m = (TextView) inflate.findViewById(R.id.signallforum_item_increaseexp);
                inflate.setTag(aiVar);
                view3 = inflate;
            } else {
                view3 = new View(this.c);
                view3.setLayoutParams(new AbsListView.LayoutParams(-1, BdUtilHelper.a(this.c, 1.0f)));
            }
            view2 = view3;
        } else {
            view2 = view;
        }
        if (itemViewType == 1) {
            if (TiebaApplication.g().ae() == 1) {
                view2.setBackgroundDrawable(this.h);
            } else {
                view2.setBackgroundDrawable(this.i);
            }
            return view2;
        }
        com.baidu.tieba.f fVar = (com.baidu.tieba.f) this.c;
        fVar.getLayoutMode().a(TiebaApplication.g().ae() == 1);
        fVar.getLayoutMode().a(view2);
        ai aiVar2 = (ai) view2.getTag();
        v vVar = (v) getItem(i);
        aiVar2.c.setText(vVar.b());
        aiVar2.d.setText(new StringBuilder(String.valueOf(vVar.f())).toString());
        aiVar2.d.setBackgroundResource(com.baidu.tieba.util.n.b(vVar.f()));
        aiVar2.e.setText(String.valueOf(vVar.g()) + "/" + vVar.h());
        aiVar2.m.clearAnimation();
        aiVar2.f.clearAnimation();
        if (vVar.i()) {
            aiVar2.b.setVisibility(0);
            aiVar2.l.setVisibility(8);
            aiVar2.g.setVisibility(0);
            aiVar2.h.setVisibility(8);
            aiVar2.g.setText(String.format(this.c.getString(R.string.signallforum_days), Integer.valueOf(vVar.e())));
            if (vVar.o()) {
                aiVar2.e.setText(this.c.getString(R.string.signallforum_uplevel));
                aiVar2.m.setVisibility(8);
            } else {
                aiVar2.e.setText(String.valueOf(vVar.g()) + "/" + vVar.h());
                aiVar2.m.setVisibility(0);
            }
            int m = vVar.m();
            if (m > 0) {
                aiVar2.m.setVisibility(0);
                aiVar2.m.setText("+" + m);
            } else {
                aiVar2.m.setVisibility(8);
            }
            if (!vVar.l()) {
                ah ahVar = new ah(aiVar2.f);
                ahVar.setDuration(800L);
                ahVar.setFillAfter(true);
                ahVar.setInterpolator(new DecelerateInterpolator());
                aiVar2.f.startAnimation(ahVar);
                if (m > 0) {
                    AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                    alphaAnimation.setDuration(800L);
                    alphaAnimation.setFillAfter(true);
                    alphaAnimation.setInterpolator(new DecelerateInterpolator());
                    aiVar2.m.startAnimation(alphaAnimation);
                }
                vVar.d(true);
            }
        } else if (vVar.j()) {
            String n = vVar.n();
            if (TextUtils.isEmpty(n)) {
                aiVar2.b.setVisibility(0);
                aiVar2.l.setVisibility(8);
                aiVar2.m.setVisibility(8);
            } else {
                aiVar2.b.setVisibility(8);
                aiVar2.l.setVisibility(0);
                aiVar2.m.setVisibility(8);
                aiVar2.l.setText(n);
            }
            aiVar2.g.setVisibility(8);
            aiVar2.h.setVisibility(0);
            if (vVar.k()) {
                aiVar2.i.setVisibility(4);
                aiVar2.j.setVisibility(0);
                aiVar2.k.setText(R.string.signallforum_resigning);
            } else {
                aiVar2.i.setVisibility(0);
                aiVar2.j.setVisibility(4);
                aiVar2.k.setText(R.string.signallforum_resign);
            }
            aiVar2.h.setOnClickListener(new af(this, vVar, aiVar2));
        } else {
            aiVar2.g.setVisibility(8);
            aiVar2.h.setVisibility(8);
            aiVar2.m.setVisibility(8);
            aiVar2.b.setVisibility(0);
            aiVar2.l.setVisibility(8);
        }
        String c = vVar.c();
        aiVar2.a.setTag(c);
        com.baidu.tieba.util.i iVar = this.f;
        if (com.baidu.tbadk.imageManager.e.a().c(c) != null) {
            aiVar2.a.invalidate();
        } else if (!this.e) {
            this.f.b(vVar.c(), new ag(this, viewGroup));
        }
        return view2;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public final void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 0) {
            this.e = false;
            notifyDataSetChanged();
            return;
        }
        this.e = true;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }

    @Override // com.baidu.tieba.home.av
    public final void a(SignData signData) {
        String forumId = signData.getForumId();
        synchronized (this) {
            this.g.remove(forumId);
        }
        a(forumId, true, signData, null);
    }

    @Override // com.baidu.tieba.home.av
    public final void a(String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            BdUtilHelper.a(this.c, str2);
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
            if (new StringBuilder(String.valueOf(vVar.a())).toString().equals(str)) {
                vVar.a(z);
                vVar.b(!z);
                vVar.c(false);
                if (z) {
                    vVar.b(signData.getCountSignNum());
                    vVar.d(signData.getBonusPoint());
                    vVar.a(1);
                    TiebaApplication.g().a(vVar.b(), signData.getBonusPoint(), -1);
                    ArrayList<v> m = this.b.m();
                    if (m.contains(vVar)) {
                        m.remove(vVar);
                        this.b.l().add(vVar);
                    }
                    int size2 = this.b.j().size();
                    int size3 = this.b.l().size();
                    this.k.setText(this.c.getString(R.string.signallforum_res, Integer.valueOf(size3), Integer.valueOf(size2 - size3)));
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

    public final void a() {
        this.j = true;
        synchronized (this) {
            for (Map.Entry<String, au> entry : this.g.entrySet()) {
                entry.getValue().a();
            }
            this.g.clear();
        }
    }

    public final void b() {
        if (this.f != null) {
            this.f.c();
        }
    }
}
