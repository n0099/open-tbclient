package com.baidu.tieba.home;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.view.ImageViewDrawer;
import com.baidu.tieba.view.PageIndex;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class RecommendPagerAdapter extends android.support.v4.view.ae implements com.baidu.tbadk.a.d, com.baidu.tieba.view.z {
    boolean b;
    boolean c;
    public com.baidu.tieba.util.a e;
    LayoutInflater f;
    private Activity g;
    private m h;
    private com.baidu.tieba.data.ba i;
    private ArrayList j;

    /* renamed from: a  reason: collision with root package name */
    int f1109a = 0;
    ArrayList d = new ArrayList();
    private View k = null;

    public RecommendPagerAdapter(Activity activity, m mVar) {
        this.h = mVar;
        this.g = activity;
        this.e = new com.baidu.tieba.util.a(activity);
        this.e.a((int) activity.getResources().getDimension(R.dimen.iamge_icon_width_height), (int) activity.getResources().getDimension(R.dimen.iamge_icon_width_height));
        this.f = LayoutInflater.from(activity);
    }

    public void a(com.baidu.tieba.data.ba baVar, ArrayList arrayList) {
        View view;
        int i;
        View view2 = null;
        a();
        this.i = baVar;
        this.j = arrayList;
        if (baVar != null) {
            this.b = true;
            this.f1109a++;
        }
        if (arrayList != null && arrayList.size() > 0) {
            this.c = true;
            this.f1109a += arrayList.size();
        }
        if (this.f1109a > 0) {
            if (this.c) {
                View inflate = this.f.inflate(R.layout.viewpager_recommend, (ViewGroup) null);
                a(inflate, (com.baidu.tieba.data.bb) arrayList.get(arrayList.size() - 1), this.f1109a, this.f1109a);
                view = inflate;
            } else if (this.b) {
                view = this.f.inflate(R.layout.viewpager_forum, (ViewGroup) null);
                a(view, baVar, this.f1109a, this.f1109a);
            } else {
                view = null;
            }
            this.d.add(view);
            if (this.b) {
                View inflate2 = this.f.inflate(R.layout.viewpager_forum, (ViewGroup) null);
                i = 2;
                a(inflate2, baVar, 1, this.f1109a);
                this.d.add(inflate2);
            } else {
                i = 1;
            }
            int i2 = 0;
            int i3 = i;
            while (this.c && i2 < arrayList.size()) {
                View inflate3 = this.f.inflate(R.layout.viewpager_recommend, (ViewGroup) null);
                a(inflate3, (com.baidu.tieba.data.bb) arrayList.get(i2), i3, this.f1109a);
                this.d.add(inflate3);
                i2++;
                i3++;
            }
            if (this.b) {
                view2 = this.f.inflate(R.layout.viewpager_forum, (ViewGroup) null);
                a(view2, baVar, 1, this.f1109a);
            } else if (this.c) {
                view2 = this.f.inflate(R.layout.viewpager_recommend, (ViewGroup) null);
                a(view2, (com.baidu.tieba.data.bb) arrayList.get(0), 1, this.f1109a);
            }
            this.d.add(view2);
            notifyDataSetChanged();
        }
    }

    @Override // android.support.v4.view.ae
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        viewGroup.removeView((View) this.d.get(i));
    }

    @Override // android.support.v4.view.ae
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        viewGroup.addView((View) this.d.get(i));
        return this.d.get(i);
    }

    private void a(View view, com.baidu.tieba.data.bb bbVar, int i, int i2) {
        boolean z = TiebaApplication.f().au() == 1;
        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.bg_rel);
        relativeLayout.setBackgroundResource(z ? R.drawable.bg_up_down_bar_1 : R.drawable.bg_up_down_bar);
        relativeLayout.setOnClickListener(new ac(this, bbVar));
        TextView textView = (TextView) view.findViewById(R.id.suggent_tag);
        int paddingLeft = textView.getPaddingLeft();
        textView.setBackgroundResource(z ? R.drawable.bg_black_banner_up_1 : R.drawable.bg_recommend_up);
        textView.setPadding(paddingLeft, 0, 0, 0);
        textView.setTextColor(-4669241);
        if (TextUtils.isEmpty(bbVar.b())) {
            textView.setText(R.string.tag_suggect_no_tag);
        } else {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(String.format(TiebaApplication.f().getBaseContext().getResources().getString(R.string.tag_suggect), bbVar.b()));
            spannableStringBuilder.setSpan(new ForegroundColorSpan(-10765999), 2, bbVar.b().length() + 2, 18);
            textView.setText(spannableStringBuilder);
        }
        ImageViewDrawer imageViewDrawer = (ImageViewDrawer) view.findViewById(R.id.avator);
        imageViewDrawer.setTag(bbVar.f());
        this.e.a(bbVar.f(), new ad(this, imageViewDrawer));
        TextView textView2 = (TextView) view.findViewById(R.id.forum_name_tx);
        textView2.setText(bbVar.e());
        textView2.setTextColor(z ? -8682095 : -13289151);
        TextView textView3 = (TextView) view.findViewById(R.id.member);
        textView3.setText(bbVar.h());
        textView3.setTextColor(z ? -6707535 : -6644336);
        textView3.setCompoundDrawablesWithIntrinsicBounds(this.g.getResources().getDrawable(z ? R.drawable.ico_people_1 : R.drawable.icon_recommend_user_1), (Drawable) null, (Drawable) null, (Drawable) null);
        TextView textView4 = (TextView) view.findViewById(R.id.count);
        textView4.setText(bbVar.c());
        textView4.setTextColor(z ? -6707535 : -6644336);
        textView4.setCompoundDrawablesWithIntrinsicBounds(this.g.getResources().getDrawable(z ? R.drawable.ico_discuss_1 : R.drawable.icon_recommend_message), (Drawable) null, (Drawable) null, (Drawable) null);
        TextView textView5 = (TextView) view.findViewById(R.id.desc);
        textView5.setText(bbVar.g());
        textView5.setTextColor(z ? -8682095 : -8552573);
        ImageView imageView = (ImageView) view.findViewById(R.id.like);
        if (bbVar.a() == 1) {
            imageView.setImageResource(R.drawable.icon_heart_s_1);
        } else {
            imageView.setImageResource(R.drawable.icon_heart_n_1);
            imageView.setOnClickListener(new ae(this, bbVar, imageView));
        }
        ((PageIndex) view.findViewById(R.id.page_num)).a(i, i2);
    }

    private void a(View view, com.baidu.tieba.data.ba baVar, int i, int i2) {
        boolean z = TiebaApplication.f().au() == 1;
        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.bg_rel);
        relativeLayout.setBackgroundResource(z ? R.drawable.bg_up_down_bar_1 : R.drawable.bg_up_down_bar);
        relativeLayout.setOnClickListener(new ag(this, baVar));
        ImageView[] imageViewArr = {(ImageView) view.findViewById(R.id.star1), (ImageView) view.findViewById(R.id.star2), (ImageView) view.findViewById(R.id.star3), (ImageView) view.findViewById(R.id.star4), (ImageView) view.findViewById(R.id.star5)};
        for (int i3 = 0; i3 < 5; i3++) {
            if (i3 < baVar.b()) {
                if (z) {
                    imageViewArr[i3].setImageResource(R.drawable.icon_star_n_1);
                } else {
                    imageViewArr[i3].setImageResource(R.drawable.icon_star_n);
                }
            } else if (z) {
                imageViewArr[i3].setImageResource(R.drawable.icon_star_s_1);
            } else {
                imageViewArr[i3].setImageResource(R.drawable.icon_star_s);
            }
        }
        ((LinearLayout) view.findViewById(R.id.advice_ly)).setBackgroundResource(z ? R.drawable.bg_black_banner_up_1 : R.drawable.bg_recommend_up);
        TextView textView = (TextView) view.findViewById(R.id.forum_name_tx);
        textView.setText(baVar.a());
        textView.setTextColor(z ? -8682095 : -13289151);
        TextView textView2 = (TextView) view.findViewById(R.id.daily_icon);
        textView2.setBackgroundResource(z ? R.drawable.icon_daily_sentence_1 : R.drawable.icon_daily_sentence);
        textView2.setTextColor(-1);
        ((RelativeLayout) view.findViewById(R.id.avator_bg)).setBackgroundResource(z ? R.drawable.bg_recommend_portrait_1 : R.drawable.bg_recommend_portrait);
        ImageViewDrawer imageViewDrawer = (ImageViewDrawer) view.findViewById(R.id.avator);
        imageViewDrawer.setTag(baVar.d());
        this.e.a(baVar.d(), new ah(this, imageViewDrawer));
        TextView textView3 = (TextView) view.findViewById(R.id.forum_memeber);
        textView3.setText(baVar.e());
        textView3.setTextColor(z ? -6707535 : -6644336);
        textView3.setCompoundDrawablesWithIntrinsicBounds(this.g.getResources().getDrawable(z ? R.drawable.ico_people_1 : R.drawable.ico_people), (Drawable) null, (Drawable) null, (Drawable) null);
        TextView textView4 = (TextView) view.findViewById(R.id.thread_count);
        textView4.setText(baVar.f());
        textView4.setTextColor(z ? -6707535 : -6644336);
        textView4.setCompoundDrawablesWithIntrinsicBounds(this.g.getResources().getDrawable(z ? R.drawable.ico_discuss_1 : R.drawable.ico_discuss), (Drawable) null, (Drawable) null, (Drawable) null);
        TextView textView5 = (TextView) view.findViewById(R.id.recommend_reason);
        textView5.setText(baVar.c());
        textView5.setTextColor(z ? -8682095 : -8552573);
        ((PageIndex) view.findViewById(R.id.page_num)).a(i, i2);
    }

    @Override // android.support.v4.view.ae
    public int getCount() {
        return this.d.size();
    }

    @Override // android.support.v4.view.ae
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    private void a() {
        this.d.clear();
        this.f1109a = 0;
        this.b = false;
        this.c = false;
        this.i = null;
        this.j = null;
        notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.view.z
    public void c() {
        if (this.e != null) {
            this.e.b();
        }
    }

    @Override // com.baidu.tieba.view.z
    public void a(View view, int i, int i2) {
        this.k = view;
        if (this.e != null) {
            if (this.i != null) {
                this.e.a(this.i.d(), this);
            }
            if (this.j != null) {
                int i3 = 0;
                while (true) {
                    int i4 = i3;
                    if (i4 < this.j.size()) {
                        this.e.a(((com.baidu.tieba.data.bb) this.j.get(i4)).f(), this);
                        i3 = i4 + 1;
                    } else {
                        return;
                    }
                }
            }
        }
    }

    @Override // com.baidu.tbadk.a.d
    public void a(com.baidu.adp.widget.a.b bVar, String str, boolean z) {
        View findViewWithTag;
        if (this.k != null && (findViewWithTag = this.k.findViewWithTag(str)) != null) {
            findViewWithTag.invalidate();
        }
    }
}
