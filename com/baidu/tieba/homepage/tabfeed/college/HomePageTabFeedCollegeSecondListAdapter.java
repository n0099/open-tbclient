package com.baidu.tieba.homepage.tabfeed.college;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.tbselector.TBSelector;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.tabfeed.data.SpecialColumnItemData;
import d.a.c.e.p.l;
import d.a.j0.m.f;
import java.util.List;
/* loaded from: classes4.dex */
public class HomePageTabFeedCollegeSecondListAdapter extends RecyclerView.Adapter {

    /* renamed from: a  reason: collision with root package name */
    public Context f16593a;

    /* renamed from: b  reason: collision with root package name */
    public List<SpecialColumnItemData> f16594b;

    /* renamed from: c  reason: collision with root package name */
    public f<SpecialColumnItemData> f16595c = null;

    /* renamed from: d  reason: collision with root package name */
    public int f16596d;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SpecialColumnItemData f16597e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f16598f;

        public a(SpecialColumnItemData specialColumnItemData, int i2) {
            this.f16597e = specialColumnItemData;
            this.f16598f = i2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (HomePageTabFeedCollegeSecondListAdapter.this.f16595c != null) {
                f fVar = HomePageTabFeedCollegeSecondListAdapter.this.f16595c;
                SpecialColumnItemData specialColumnItemData = this.f16597e;
                int i2 = this.f16598f;
                fVar.a(view, specialColumnItemData, i2, i2);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b extends RecyclerView.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public TextView f16600a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f16601b;

        /* renamed from: c  reason: collision with root package name */
        public TbImageView f16602c;

        /* renamed from: d  reason: collision with root package name */
        public ImageView f16603d;

        /* renamed from: e  reason: collision with root package name */
        public View f16604e;

        /* renamed from: f  reason: collision with root package name */
        public LinearLayout f16605f;

        public b(View view) {
            super(view);
            this.f16602c = (TbImageView) view.findViewById(R.id.iv_imageView);
            this.f16603d = (ImageView) view.findViewById(R.id.video_play_iv);
            this.f16600a = (TextView) view.findViewById(R.id.text_tv);
            this.f16601b = (TextView) view.findViewById(R.id.tv_content);
            this.f16604e = view.findViewById(R.id.gradient_cover);
            this.f16605f = (LinearLayout) view.findViewById(R.id.ll_live_main);
        }

        public void a(SpecialColumnItemData specialColumnItemData) {
            if (specialColumnItemData == null) {
                return;
            }
            this.f16601b.setText(specialColumnItemData.title);
            this.f16602c.setConrers(15);
            this.f16602c.setRadius(l.g(TbadkCoreApplication.getInst(), R.dimen.tbds10));
            this.f16602c.setDrawCorner(true);
            this.f16602c.setPlaceHolder(2);
            this.f16602c.V(specialColumnItemData.image, 10, false);
            this.f16600a.setText(specialColumnItemData.text);
            this.f16603d.setVisibility(0);
            HomePageTabFeedCollegeSecondListAdapter.this.f16596d = R.drawable.ic_icon_pure_common_live12_svg;
            this.f16604e.setAlpha(0.5f);
            TBSelector.makeDrawableSelector().setShape(0).cornerRadius(l.g(HomePageTabFeedCollegeSecondListAdapter.this.f16593a, R.dimen.tbds10)).gradientLinear(R.color.CAM_X0607, R.color.CAM_X0611).into(this.f16604e);
        }
    }

    /* loaded from: classes4.dex */
    public class c extends RecyclerView.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public TextView f16607a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f16608b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f16609c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f16610d;

        /* renamed from: e  reason: collision with root package name */
        public TbImageView f16611e;

        /* renamed from: f  reason: collision with root package name */
        public ImageView f16612f;

        /* renamed from: g  reason: collision with root package name */
        public View f16613g;

        /* renamed from: h  reason: collision with root package name */
        public RelativeLayout f16614h;

        public c(View view) {
            super(view);
            this.f16607a = (TextView) view.findViewById(R.id.tv_title);
            this.f16611e = (TbImageView) view.findViewById(R.id.tb_imageview_pic);
            this.f16608b = (TextView) view.findViewById(R.id.tv_left_watch);
            this.f16609c = (TextView) view.findViewById(R.id.tv_left_agree);
            this.f16612f = (ImageView) view.findViewById(R.id.video_play_iv);
            this.f16610d = (TextView) view.findViewById(R.id.text_tv);
            this.f16613g = view.findViewById(R.id.gradient_cover);
            this.f16614h = (RelativeLayout) view.findViewById(R.id.rl_photo_view);
        }

        public void a(SpecialColumnItemData specialColumnItemData) {
            if (specialColumnItemData == null) {
                return;
            }
            this.f16607a.setText(specialColumnItemData.title);
            this.f16611e.setConrers(15);
            this.f16611e.setRadius(l.g(TbadkCoreApplication.getInst(), R.dimen.tbds10));
            this.f16611e.setDrawCorner(true);
            this.f16611e.setPlaceHolder(2);
            this.f16611e.V(specialColumnItemData.image, 10, false);
            this.f16611e.setGifIconSupport(false);
            this.f16609c.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.person_view_item_live_zan_num), StringHelper.numberUniformFormatExtra(specialColumnItemData.agree_num)));
            this.f16610d.setText(specialColumnItemData.text);
            if (specialColumnItemData.specialType == 2) {
                this.f16612f.setVisibility(0);
                this.f16613g.setVisibility(0);
                this.f16613g.setAlpha(0.5f);
                this.f16610d.setVisibility(0);
                HomePageTabFeedCollegeSecondListAdapter.this.f16596d = R.drawable.ic_icon_pure_video_play12_svg;
                this.f16608b.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.person_play_num), StringHelper.numberUniformFormatExtra(specialColumnItemData.freq_num)));
                TBSelector.makeDrawableSelector().setShape(0).gradientLinear(R.color.CAM_X0607, R.color.CAM_X0611).cornerRadius(l.g(HomePageTabFeedCollegeSecondListAdapter.this.f16593a, R.dimen.tbds10)).into(this.f16613g);
                return;
            }
            this.f16613g.setVisibility(8);
            this.f16612f.setVisibility(8);
            this.f16610d.setVisibility(8);
            HomePageTabFeedCollegeSecondListAdapter.this.f16596d = 0;
            this.f16608b.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.person_view_num), StringHelper.numberUniformFormatExtra(specialColumnItemData.freq_num)));
        }
    }

    public HomePageTabFeedCollegeSecondListAdapter(Context context, List<SpecialColumnItemData> list) {
        this.f16593a = context;
        this.f16594b = list;
    }

    public final void f(RecyclerView.ViewHolder viewHolder) {
        if (viewHolder instanceof c) {
            c cVar = (c) viewHolder;
            SkinManager.setViewTextColor(cVar.f16607a, R.color.CAM_X0105);
            SkinManager.setViewTextColor(cVar.f16608b, R.color.CAM_X0109);
            SkinManager.setViewTextColor(cVar.f16609c, R.color.CAM_X0109);
            SkinManager.setViewTextColor(cVar.f16610d, R.color.CAM_X0101);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(cVar.f16612f, this.f16596d, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL);
            TBSelector.setViewBackgroundColorWithPressedState(cVar.f16614h, R.color.CAM_X0205, R.color.CAM_X0204);
        } else if (viewHolder instanceof b) {
            b bVar = (b) viewHolder;
            SkinManager.setViewTextColor(bVar.f16601b, R.color.CAM_X0105);
            SkinManager.setViewTextColor(bVar.f16600a, R.color.CAM_X0101);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(bVar.f16603d, this.f16596d, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL);
            TBSelector.setViewBackgroundColorWithPressedState(bVar.f16605f, R.color.CAM_X0205, R.color.CAM_X0204);
        }
    }

    public final SpecialColumnItemData g(int i2) {
        return (SpecialColumnItemData) ListUtils.getItem(this.f16594b, i2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return ListUtils.getCount(this.f16594b);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i2) {
        int i3 = this.f16594b.get(i2).specialType;
        if (i3 == 1) {
            return 1;
        }
        if (i3 == 2) {
            return 2;
        }
        if (i3 == 3) {
            return 3;
        }
        if (i3 == 4) {
            return 4;
        }
        return super.getItemViewType(i2);
    }

    public void h(f<SpecialColumnItemData> fVar) {
        this.f16595c = fVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i2) {
        SpecialColumnItemData g2 = g(i2);
        if (viewHolder instanceof c) {
            ((c) viewHolder).a(g2);
        } else if (viewHolder instanceof b) {
            ((b) viewHolder).a(g2);
        }
        viewHolder.itemView.setOnClickListener(new a(g2, i2));
        f(viewHolder);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i2) {
        if (i2 == 1 || i2 == 2) {
            return new c(LayoutInflater.from(this.f16593a).inflate(R.layout.layout_item_colleage_second_photo, (ViewGroup) null));
        }
        if (i2 == 3 || i2 == 4) {
            return new b(LayoutInflater.from(this.f16593a).inflate(R.layout.layout_item_colleage_second_live, (ViewGroup) null));
        }
        return null;
    }
}
