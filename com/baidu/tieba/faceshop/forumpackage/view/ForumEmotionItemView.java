package com.baidu.tieba.faceshop.forumpackage.view;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.faceshop.EmotionPackageData;
import com.baidu.tieba.horizonalList.widget.HListView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class ForumEmotionItemView extends LinearLayout {

    /* renamed from: e  reason: collision with root package name */
    public HListView f15005e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f15006f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f15007g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f15008h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f15009i;
    public TextView j;
    public View k;
    public View l;
    public TextView m;
    public ViewGroup n;
    public TextView o;
    public a p;
    public TbPageContext q;

    /* loaded from: classes4.dex */
    public static class a extends BaseAdapter {

        /* renamed from: f  reason: collision with root package name */
        public TbPageContext f15011f;

        /* renamed from: e  reason: collision with root package name */
        public List<EmotionPackageData.SingleEmotionData> f15010e = new ArrayList();

        /* renamed from: g  reason: collision with root package name */
        public boolean f15012g = false;

        /* renamed from: h  reason: collision with root package name */
        public boolean f15013h = false;

        /* renamed from: com.baidu.tieba.faceshop.forumpackage.view.ForumEmotionItemView$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public static class C0172a {

            /* renamed from: a  reason: collision with root package name */
            public View f15014a;

            /* renamed from: b  reason: collision with root package name */
            public TbImageView f15015b;

            /* renamed from: c  reason: collision with root package name */
            public TextView f15016c;

            /* renamed from: d  reason: collision with root package name */
            public View f15017d;

            public C0172a(View view) {
                this.f15014a = view;
                view.setEnabled(false);
                this.f15015b = (TbImageView) this.f15014a.findViewById(R.id.emotion_img);
                this.f15016c = (TextView) this.f15014a.findViewById(R.id.emotion_single_bar_icon);
                View findViewById = this.f15014a.findViewById(R.id.emotion_cover_view);
                this.f15017d = findViewById;
                findViewById.setVisibility(8);
            }

            public void a(EmotionPackageData.SingleEmotionData singleEmotionData, boolean z, boolean z2, int i2) {
                if (singleEmotionData == null) {
                    return;
                }
                if (!TextUtils.isEmpty(singleEmotionData.thumbnail)) {
                    this.f15015b.setDefaultResource(R.drawable.img_default_100);
                    this.f15015b.V(singleEmotionData.thumbnail, 10, false);
                }
                if (z) {
                    this.f15016c.setVisibility(0);
                } else {
                    this.f15016c.setVisibility(8);
                }
                if (i2 == 7 && z2) {
                    this.f15017d.setVisibility(0);
                } else {
                    this.f15017d.setVisibility(8);
                }
            }
        }

        public a(TbPageContext tbPageContext) {
            this.f15011f = tbPageContext;
        }

        public void a(List<EmotionPackageData.SingleEmotionData> list, boolean z) {
            if (ListUtils.isEmpty(list)) {
                return;
            }
            this.f15012g = z;
            if (list.size() > 8) {
                this.f15010e = list.subList(0, 8);
                this.f15013h = true;
            } else {
                this.f15010e = list;
                this.f15013h = false;
            }
            notifyDataSetChanged();
        }

        @Override // android.widget.Adapter
        public int getCount() {
            List<EmotionPackageData.SingleEmotionData> list = this.f15010e;
            if (list == null) {
                return 0;
            }
            return list.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i2) {
            List<EmotionPackageData.SingleEmotionData> list = this.f15010e;
            if (list == null) {
                return null;
            }
            return list.get(i2);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i2) {
            return i2;
        }

        @Override // android.widget.Adapter
        public View getView(int i2, View view, ViewGroup viewGroup) {
            C0172a c0172a;
            if (view == null) {
                view = LayoutInflater.from(this.f15011f.getPageActivity()).inflate(R.layout.emotion_item_layout, (ViewGroup) null);
                c0172a = new C0172a(view);
                view.setTag(c0172a);
            } else {
                c0172a = (C0172a) view.getTag();
            }
            c0172a.a(this.f15010e.get(i2), i2 == 0 && this.f15012g, this.f15013h, i2);
            return view;
        }
    }

    public ForumEmotionItemView(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity());
        this.q = tbPageContext;
        a();
    }

    public final void a() {
        LayoutInflater.from(getContext()).inflate(R.layout.forum_emotion_list_item_layout, this);
        this.f15005e = (HListView) findViewById(R.id.forum_emotion_item_list);
        this.l = findViewById(R.id.forum_emotion_list_head);
        this.m = (TextView) findViewById(R.id.forum_emotion_filter);
        this.n = (ViewGroup) findViewById(R.id.forum_emotion_filter_dropdown);
        this.j = (TextView) findViewById(R.id.forum_emotion_rank);
        this.f15006f = (TextView) findViewById(R.id.forum_emotion_title_tv);
        this.f15007g = (TextView) findViewById(R.id.forum_emotion_download_num_tv);
        this.f15008h = (TextView) findViewById(R.id.forum_emotion_share_num_tv);
        this.f15009i = (TextView) findViewById(R.id.forum_emotion_download_tv);
        this.k = findViewById(R.id.line);
        this.o = (TextView) findViewById(R.id.forum_emotion_board_title);
        this.f15005e.setDividerWidth(getContext().getResources().getDimensionPixelSize(R.dimen.ds20));
        this.f15005e.setSelector(this.q.getResources().getDrawable(R.drawable.transparent_bg));
        a aVar = new a(this.q);
        this.p = aVar;
        this.f15005e.setAdapter((ListAdapter) aVar);
    }

    public void b(int i2) {
        SkinManager.setViewTextColor(this.f15006f, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.f15007g, R.color.CAM_X0109);
        SkinManager.setViewTextColor(this.f15008h, R.color.CAM_X0109);
        SkinManager.setViewTextColor(this.f15009i, R.color.CAM_X0109);
        SkinManager.setViewTextColor(this.j, R.color.CAM_X0105);
        SkinManager.setBackgroundColor(this.k, R.color.CAM_X0204);
        SkinManager.setViewTextColor(this.n.getChildAt(0), R.color.CAM_X0107);
        SkinManager.setBackgroundColor(this.n.getChildAt(0), R.color.CAM_X0201);
        SkinManager.setViewTextColor(this.n.getChildAt(1), R.color.CAM_X0107);
        SkinManager.setBackgroundColor(this.n.getChildAt(1), R.color.CAM_X0201);
        SkinManager.setViewTextColor(this.o, R.color.CAM_X0107);
        SkinManager.setViewTextColor(this.m, R.color.CAM_X0107);
    }

    public a getAdapter() {
        return this.p;
    }

    public TextView getDownLoadView() {
        return this.f15009i;
    }

    public TextView getDownloadNumView() {
        return this.f15007g;
    }

    public ViewGroup getFilterDropDownView() {
        return this.n;
    }

    public TextView getFilterView() {
        return this.m;
    }

    public View getHeaderView() {
        return this.l;
    }

    public View getLineView() {
        return this.k;
    }

    public HListView getListView() {
        return this.f15005e;
    }

    public TextView getRankView() {
        return this.j;
    }

    public TextView getShareNumView() {
        return this.f15008h;
    }

    public TextView getTitleView() {
        return this.f15006f;
    }
}
