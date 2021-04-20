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
import d.b.c.e.p.l;
import d.b.h0.m.f;
import java.util.List;
/* loaded from: classes4.dex */
public class HomePageTabFeedCollegeSecondListAdapter extends RecyclerView.Adapter {

    /* renamed from: a  reason: collision with root package name */
    public Context f16994a;

    /* renamed from: b  reason: collision with root package name */
    public List<SpecialColumnItemData> f16995b;

    /* renamed from: c  reason: collision with root package name */
    public f<SpecialColumnItemData> f16996c = null;

    /* renamed from: d  reason: collision with root package name */
    public int f16997d;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SpecialColumnItemData f16998e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f16999f;

        public a(SpecialColumnItemData specialColumnItemData, int i) {
            this.f16998e = specialColumnItemData;
            this.f16999f = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (HomePageTabFeedCollegeSecondListAdapter.this.f16996c != null) {
                f fVar = HomePageTabFeedCollegeSecondListAdapter.this.f16996c;
                SpecialColumnItemData specialColumnItemData = this.f16998e;
                int i = this.f16999f;
                fVar.a(view, specialColumnItemData, i, i);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b extends RecyclerView.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public TextView f17001a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f17002b;

        /* renamed from: c  reason: collision with root package name */
        public TbImageView f17003c;

        /* renamed from: d  reason: collision with root package name */
        public ImageView f17004d;

        /* renamed from: e  reason: collision with root package name */
        public View f17005e;

        /* renamed from: f  reason: collision with root package name */
        public LinearLayout f17006f;

        public b(View view) {
            super(view);
            this.f17003c = (TbImageView) view.findViewById(R.id.iv_imageView);
            this.f17004d = (ImageView) view.findViewById(R.id.video_play_iv);
            this.f17001a = (TextView) view.findViewById(R.id.text_tv);
            this.f17002b = (TextView) view.findViewById(R.id.tv_content);
            this.f17005e = view.findViewById(R.id.gradient_cover);
            this.f17006f = (LinearLayout) view.findViewById(R.id.ll_live_main);
        }

        public void a(SpecialColumnItemData specialColumnItemData) {
            if (specialColumnItemData == null) {
                return;
            }
            this.f17002b.setText(specialColumnItemData.title);
            this.f17003c.setConrers(15);
            this.f17003c.setRadius(l.g(TbadkCoreApplication.getInst(), R.dimen.tbds10));
            this.f17003c.setDrawCorner(true);
            this.f17003c.setPlaceHolder(2);
            this.f17003c.W(specialColumnItemData.image, 10, false);
            this.f17001a.setText(specialColumnItemData.text);
            this.f17004d.setVisibility(0);
            HomePageTabFeedCollegeSecondListAdapter.this.f16997d = R.drawable.ic_icon_pure_common_live12_svg;
            this.f17005e.setAlpha(0.5f);
            TBSelector.makeDrawableSelector().setShape(0).cornerRadius(l.g(HomePageTabFeedCollegeSecondListAdapter.this.f16994a, R.dimen.tbds10)).gradientLinear(R.color.CAM_X0607, R.color.CAM_X0611).into(this.f17005e);
        }
    }

    /* loaded from: classes4.dex */
    public class c extends RecyclerView.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public TextView f17008a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f17009b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f17010c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f17011d;

        /* renamed from: e  reason: collision with root package name */
        public TbImageView f17012e;

        /* renamed from: f  reason: collision with root package name */
        public ImageView f17013f;

        /* renamed from: g  reason: collision with root package name */
        public View f17014g;

        /* renamed from: h  reason: collision with root package name */
        public RelativeLayout f17015h;

        public c(View view) {
            super(view);
            this.f17008a = (TextView) view.findViewById(R.id.tv_title);
            this.f17012e = (TbImageView) view.findViewById(R.id.tb_imageview_pic);
            this.f17009b = (TextView) view.findViewById(R.id.tv_left_watch);
            this.f17010c = (TextView) view.findViewById(R.id.tv_left_agree);
            this.f17013f = (ImageView) view.findViewById(R.id.video_play_iv);
            this.f17011d = (TextView) view.findViewById(R.id.text_tv);
            this.f17014g = view.findViewById(R.id.gradient_cover);
            this.f17015h = (RelativeLayout) view.findViewById(R.id.rl_photo_view);
        }

        public void a(SpecialColumnItemData specialColumnItemData) {
            if (specialColumnItemData == null) {
                return;
            }
            this.f17008a.setText(specialColumnItemData.title);
            this.f17012e.setConrers(15);
            this.f17012e.setRadius(l.g(TbadkCoreApplication.getInst(), R.dimen.tbds10));
            this.f17012e.setDrawCorner(true);
            this.f17012e.setPlaceHolder(2);
            this.f17012e.W(specialColumnItemData.image, 10, false);
            this.f17012e.setGifIconSupport(false);
            this.f17010c.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.person_view_item_live_zan_num), StringHelper.numberUniformFormatExtra(specialColumnItemData.agree_num)));
            this.f17011d.setText(specialColumnItemData.text);
            if (specialColumnItemData.specialType == 2) {
                this.f17013f.setVisibility(0);
                this.f17014g.setVisibility(0);
                this.f17014g.setAlpha(0.5f);
                this.f17011d.setVisibility(0);
                HomePageTabFeedCollegeSecondListAdapter.this.f16997d = R.drawable.ic_icon_pure_video_play12_svg;
                this.f17009b.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.person_play_num), StringHelper.numberUniformFormatExtra(specialColumnItemData.freq_num)));
                TBSelector.makeDrawableSelector().setShape(0).gradientLinear(R.color.CAM_X0607, R.color.CAM_X0611).cornerRadius(l.g(HomePageTabFeedCollegeSecondListAdapter.this.f16994a, R.dimen.tbds10)).into(this.f17014g);
                return;
            }
            this.f17014g.setVisibility(8);
            this.f17013f.setVisibility(8);
            this.f17011d.setVisibility(8);
            HomePageTabFeedCollegeSecondListAdapter.this.f16997d = 0;
            this.f17009b.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.person_view_num), StringHelper.numberUniformFormatExtra(specialColumnItemData.freq_num)));
        }
    }

    public HomePageTabFeedCollegeSecondListAdapter(Context context, List<SpecialColumnItemData> list) {
        this.f16994a = context;
        this.f16995b = list;
    }

    public final void f(RecyclerView.ViewHolder viewHolder) {
        if (viewHolder instanceof c) {
            c cVar = (c) viewHolder;
            SkinManager.setViewTextColor(cVar.f17008a, R.color.CAM_X0105);
            SkinManager.setViewTextColor(cVar.f17009b, R.color.CAM_X0109);
            SkinManager.setViewTextColor(cVar.f17010c, R.color.CAM_X0109);
            SkinManager.setViewTextColor(cVar.f17011d, R.color.CAM_X0101);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(cVar.f17013f, this.f16997d, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL);
            TBSelector.setViewBackgroundColorWithPressedState(cVar.f17015h, R.color.CAM_X0205, R.color.CAM_X0204);
        } else if (viewHolder instanceof b) {
            b bVar = (b) viewHolder;
            SkinManager.setViewTextColor(bVar.f17002b, R.color.CAM_X0105);
            SkinManager.setViewTextColor(bVar.f17001a, R.color.CAM_X0101);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(bVar.f17004d, this.f16997d, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL);
            TBSelector.setViewBackgroundColorWithPressedState(bVar.f17006f, R.color.CAM_X0205, R.color.CAM_X0204);
        }
    }

    public final SpecialColumnItemData g(int i) {
        return (SpecialColumnItemData) ListUtils.getItem(this.f16995b, i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return ListUtils.getCount(this.f16995b);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        int i2 = this.f16995b.get(i).specialType;
        if (i2 == 1) {
            return 1;
        }
        if (i2 == 2) {
            return 2;
        }
        if (i2 == 3) {
            return 3;
        }
        if (i2 == 4) {
            return 4;
        }
        return super.getItemViewType(i);
    }

    public void h(f<SpecialColumnItemData> fVar) {
        this.f16996c = fVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        SpecialColumnItemData g2 = g(i);
        if (viewHolder instanceof c) {
            ((c) viewHolder).a(g2);
        } else if (viewHolder instanceof b) {
            ((b) viewHolder).a(g2);
        }
        viewHolder.itemView.setOnClickListener(new a(g2, i));
        f(viewHolder);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        if (i == 1 || i == 2) {
            return new c(LayoutInflater.from(this.f16994a).inflate(R.layout.layout_item_colleage_second_photo, (ViewGroup) null));
        }
        if (i == 3 || i == 4) {
            return new b(LayoutInflater.from(this.f16994a).inflate(R.layout.layout_item_colleage_second_live, (ViewGroup) null));
        }
        return null;
    }
}
