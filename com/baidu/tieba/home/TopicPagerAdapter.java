package com.baidu.tieba.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.pb.NewPbActivity;
import com.baidu.tieba.view.ADImageViewDrawer;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class TopicPagerAdapter extends android.support.v4.view.ae implements com.baidu.tbadk.a.d, com.baidu.tieba.view.v {

    /* renamed from: a  reason: collision with root package name */
    int f887a = 0;
    ArrayList b = new ArrayList();
    LayoutInflater c;
    public int d;
    public int e;
    private com.baidu.tieba.util.a f;
    private Context g;
    private ArrayList h;
    private View i;

    public TopicPagerAdapter(Context context) {
        this.d = (com.baidu.tieba.util.ab.a(context) - com.baidu.tieba.util.ab.a(this.g, 28.0f)) / 2;
        this.e = (int) ((this.d * context.getResources().getDimension(R.dimen.ad_image_height)) / context.getResources().getDimension(R.dimen.ad_image_width));
        this.c = LayoutInflater.from(context);
        this.g = context;
        this.f = new com.baidu.tieba.util.a(context);
        this.f.a(this.d, this.e);
    }

    @Override // android.support.v4.view.ae
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        viewGroup.removeView((View) this.b.get(i));
    }

    public void a(ArrayList arrayList) {
        a();
        this.h = arrayList;
        if (arrayList != null) {
            if (arrayList.size() % 2 != 0) {
                arrayList.remove(arrayList.size() - 1);
            }
            this.f887a = arrayList.size() / 2;
        }
        if (this.f887a > 0) {
            View inflate = this.c.inflate(R.layout.viewpager_topic, (ViewGroup) null);
            a(inflate, (com.baidu.tieba.data.bd) arrayList.get((this.f887a - 1) * 2), (com.baidu.tieba.data.bd) arrayList.get(((this.f887a - 1) * 2) + 1));
            this.b.add(inflate);
            for (int i = 0; i < this.f887a; i++) {
                View inflate2 = this.c.inflate(R.layout.viewpager_topic, (ViewGroup) null);
                a(inflate2, (com.baidu.tieba.data.bd) arrayList.get(i * 2), (com.baidu.tieba.data.bd) arrayList.get((i * 2) + 1));
                this.b.add(inflate2);
            }
            View inflate3 = this.c.inflate(R.layout.viewpager_topic, (ViewGroup) null);
            a(inflate3, (com.baidu.tieba.data.bd) arrayList.get(0), (com.baidu.tieba.data.bd) arrayList.get(1));
            this.b.add(inflate3);
            notifyDataSetChanged();
        }
    }

    @Override // android.support.v4.view.ae
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        viewGroup.addView((View) this.b.get(i));
        return this.b.get(i);
    }

    private void a(View view, com.baidu.tieba.data.bd bdVar, com.baidu.tieba.data.bd bdVar2) {
        int i = R.drawable.bg_ad_banner_shadow_1;
        boolean z = TiebaApplication.f().at() == 1;
        ADImageViewDrawer aDImageViewDrawer = (ADImageViewDrawer) view.findViewById(R.id.ad1);
        aDImageViewDrawer.setTag(bdVar.f780a);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) aDImageViewDrawer.getLayoutParams();
        layoutParams.width = this.d;
        layoutParams.height = this.e;
        aDImageViewDrawer.setLayoutParams(layoutParams);
        this.f.a(bdVar.f780a, new be(this, aDImageViewDrawer));
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.layout1);
        linearLayout.setBackgroundResource(z ? R.drawable.bg_ad_banner_shadow_1 : R.drawable.bg_ad_banner_shadow);
        linearLayout.setOnClickListener(new bf(this, bdVar));
        ADImageViewDrawer aDImageViewDrawer2 = (ADImageViewDrawer) view.findViewById(R.id.ad2);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) aDImageViewDrawer2.getLayoutParams();
        layoutParams2.width = this.d;
        layoutParams2.height = this.e;
        aDImageViewDrawer2.setLayoutParams(layoutParams2);
        aDImageViewDrawer2.setTag(bdVar2.f780a);
        this.f.a(bdVar2.f780a, new bg(this, aDImageViewDrawer2));
        LinearLayout linearLayout2 = (LinearLayout) view.findViewById(R.id.layout2);
        if (!z) {
            i = R.drawable.bg_ad_banner_shadow;
        }
        linearLayout2.setBackgroundResource(i);
        linearLayout2.setOnClickListener(new bh(this, bdVar2));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(String str, String str2) {
        String lowerCase = str.toLowerCase();
        if (lowerCase.startsWith("pb:")) {
            NewPbActivity.a(this.g, lowerCase.substring(3), null, null);
        } else if (lowerCase.startsWith("opfeature:")) {
            com.baidu.tieba.util.ab.c(this.g, lowerCase.replaceFirst("opfeature:", com.baidu.loginshare.e.f));
        } else if (lowerCase.startsWith("frs:")) {
            FrsActivity.a(this.g, lowerCase.substring(4), (String) null);
        } else if (lowerCase.startsWith("topic:")) {
            ForumTopicActivity.a(this.g, lowerCase.substring(6), str2);
        }
    }

    @Override // android.support.v4.view.ae
    public int getCount() {
        return this.b.size();
    }

    @Override // android.support.v4.view.ae
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    private void a() {
        this.b.clear();
        this.f887a = 0;
        this.h = null;
        notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.view.v
    public void c() {
        if (this.f != null) {
            this.f.b();
        }
    }

    @Override // com.baidu.tieba.view.v
    public void a(View view, int i, int i2) {
        this.i = view;
        if (this.f != null && this.h != null) {
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 < this.h.size()) {
                    this.f.a(((com.baidu.tieba.data.bd) this.h.get(i4)).f780a, this);
                    i3 = i4 + 1;
                } else {
                    return;
                }
            }
        }
    }

    @Override // com.baidu.tbadk.a.d
    public void a(com.baidu.adp.widget.a.b bVar, String str, boolean z) {
        View findViewWithTag;
        if (this.i != null && (findViewWithTag = this.i.findViewWithTag(str)) != null) {
            findViewWithTag.invalidate();
        }
    }
}
