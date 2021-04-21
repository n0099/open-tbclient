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
    public HListView f15532e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f15533f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f15534g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f15535h;
    public TextView i;
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
        public TbPageContext f15537f;

        /* renamed from: e  reason: collision with root package name */
        public List<EmotionPackageData.SingleEmotionData> f15536e = new ArrayList();

        /* renamed from: g  reason: collision with root package name */
        public boolean f15538g = false;

        /* renamed from: h  reason: collision with root package name */
        public boolean f15539h = false;

        /* renamed from: com.baidu.tieba.faceshop.forumpackage.view.ForumEmotionItemView$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public static class C0190a {

            /* renamed from: a  reason: collision with root package name */
            public View f15540a;

            /* renamed from: b  reason: collision with root package name */
            public TbImageView f15541b;

            /* renamed from: c  reason: collision with root package name */
            public TextView f15542c;

            /* renamed from: d  reason: collision with root package name */
            public View f15543d;

            public C0190a(View view) {
                this.f15540a = view;
                view.setEnabled(false);
                this.f15541b = (TbImageView) this.f15540a.findViewById(R.id.emotion_img);
                this.f15542c = (TextView) this.f15540a.findViewById(R.id.emotion_single_bar_icon);
                View findViewById = this.f15540a.findViewById(R.id.emotion_cover_view);
                this.f15543d = findViewById;
                findViewById.setVisibility(8);
            }

            public void a(EmotionPackageData.SingleEmotionData singleEmotionData, boolean z, boolean z2, int i) {
                if (singleEmotionData == null) {
                    return;
                }
                if (!TextUtils.isEmpty(singleEmotionData.thumbnail)) {
                    this.f15541b.setDefaultResource(R.drawable.img_default_100);
                    this.f15541b.W(singleEmotionData.thumbnail, 10, false);
                }
                if (z) {
                    this.f15542c.setVisibility(0);
                } else {
                    this.f15542c.setVisibility(8);
                }
                if (i == 7 && z2) {
                    this.f15543d.setVisibility(0);
                } else {
                    this.f15543d.setVisibility(8);
                }
            }
        }

        public a(TbPageContext tbPageContext) {
            this.f15537f = tbPageContext;
        }

        public void a(List<EmotionPackageData.SingleEmotionData> list, boolean z) {
            if (ListUtils.isEmpty(list)) {
                return;
            }
            this.f15538g = z;
            if (list.size() > 8) {
                this.f15536e = list.subList(0, 8);
                this.f15539h = true;
            } else {
                this.f15536e = list;
                this.f15539h = false;
            }
            notifyDataSetChanged();
        }

        @Override // android.widget.Adapter
        public int getCount() {
            List<EmotionPackageData.SingleEmotionData> list = this.f15536e;
            if (list == null) {
                return 0;
            }
            return list.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            List<EmotionPackageData.SingleEmotionData> list = this.f15536e;
            if (list == null) {
                return null;
            }
            return list.get(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            C0190a c0190a;
            if (view == null) {
                view = LayoutInflater.from(this.f15537f.getPageActivity()).inflate(R.layout.emotion_item_layout, (ViewGroup) null);
                c0190a = new C0190a(view);
                view.setTag(c0190a);
            } else {
                c0190a = (C0190a) view.getTag();
            }
            c0190a.a(this.f15536e.get(i), i == 0 && this.f15538g, this.f15539h, i);
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
        this.f15532e = (HListView) findViewById(R.id.forum_emotion_item_list);
        this.l = findViewById(R.id.forum_emotion_list_head);
        this.m = (TextView) findViewById(R.id.forum_emotion_filter);
        this.n = (ViewGroup) findViewById(R.id.forum_emotion_filter_dropdown);
        this.j = (TextView) findViewById(R.id.forum_emotion_rank);
        this.f15533f = (TextView) findViewById(R.id.forum_emotion_title_tv);
        this.f15534g = (TextView) findViewById(R.id.forum_emotion_download_num_tv);
        this.f15535h = (TextView) findViewById(R.id.forum_emotion_share_num_tv);
        this.i = (TextView) findViewById(R.id.forum_emotion_download_tv);
        this.k = findViewById(R.id.line);
        this.o = (TextView) findViewById(R.id.forum_emotion_board_title);
        this.f15532e.setDividerWidth(getContext().getResources().getDimensionPixelSize(R.dimen.ds20));
        this.f15532e.setSelector(this.q.getResources().getDrawable(R.drawable.transparent_bg));
        a aVar = new a(this.q);
        this.p = aVar;
        this.f15532e.setAdapter((ListAdapter) aVar);
    }

    public void b(int i) {
        SkinManager.setViewTextColor(this.f15533f, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.f15534g, R.color.CAM_X0109);
        SkinManager.setViewTextColor(this.f15535h, R.color.CAM_X0109);
        SkinManager.setViewTextColor(this.i, R.color.CAM_X0109);
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
        return this.i;
    }

    public TextView getDownloadNumView() {
        return this.f15534g;
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
        return this.f15532e;
    }

    public TextView getRankView() {
        return this.j;
    }

    public TextView getShareNumView() {
        return this.f15535h;
    }

    public TextView getTitleView() {
        return this.f15533f;
    }
}
