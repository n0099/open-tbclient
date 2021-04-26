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
import d.a.i0.m.f;
import java.util.List;
/* loaded from: classes4.dex */
public class HomePageTabFeedCollegeSecondListAdapter extends RecyclerView.Adapter {

    /* renamed from: a  reason: collision with root package name */
    public Context f17278a;

    /* renamed from: b  reason: collision with root package name */
    public List<SpecialColumnItemData> f17279b;

    /* renamed from: c  reason: collision with root package name */
    public f<SpecialColumnItemData> f17280c = null;

    /* renamed from: d  reason: collision with root package name */
    public int f17281d;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SpecialColumnItemData f17282e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f17283f;

        public a(SpecialColumnItemData specialColumnItemData, int i2) {
            this.f17282e = specialColumnItemData;
            this.f17283f = i2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (HomePageTabFeedCollegeSecondListAdapter.this.f17280c != null) {
                f fVar = HomePageTabFeedCollegeSecondListAdapter.this.f17280c;
                SpecialColumnItemData specialColumnItemData = this.f17282e;
                int i2 = this.f17283f;
                fVar.a(view, specialColumnItemData, i2, i2);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b extends RecyclerView.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public TextView f17285a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f17286b;

        /* renamed from: c  reason: collision with root package name */
        public TbImageView f17287c;

        /* renamed from: d  reason: collision with root package name */
        public ImageView f17288d;

        /* renamed from: e  reason: collision with root package name */
        public View f17289e;

        /* renamed from: f  reason: collision with root package name */
        public LinearLayout f17290f;

        public b(View view) {
            super(view);
            this.f17287c = (TbImageView) view.findViewById(R.id.iv_imageView);
            this.f17288d = (ImageView) view.findViewById(R.id.video_play_iv);
            this.f17285a = (TextView) view.findViewById(R.id.text_tv);
            this.f17286b = (TextView) view.findViewById(R.id.tv_content);
            this.f17289e = view.findViewById(R.id.gradient_cover);
            this.f17290f = (LinearLayout) view.findViewById(R.id.ll_live_main);
        }

        public void a(SpecialColumnItemData specialColumnItemData) {
            if (specialColumnItemData == null) {
                return;
            }
            this.f17286b.setText(specialColumnItemData.title);
            this.f17287c.setConrers(15);
            this.f17287c.setRadius(l.g(TbadkCoreApplication.getInst(), R.dimen.tbds10));
            this.f17287c.setDrawCorner(true);
            this.f17287c.setPlaceHolder(2);
            this.f17287c.V(specialColumnItemData.image, 10, false);
            this.f17285a.setText(specialColumnItemData.text);
            this.f17288d.setVisibility(0);
            HomePageTabFeedCollegeSecondListAdapter.this.f17281d = R.drawable.ic_icon_pure_common_live12_svg;
            this.f17289e.setAlpha(0.5f);
            TBSelector.makeDrawableSelector().setShape(0).cornerRadius(l.g(HomePageTabFeedCollegeSecondListAdapter.this.f17278a, R.dimen.tbds10)).gradientLinear(R.color.CAM_X0607, R.color.CAM_X0611).into(this.f17289e);
        }
    }

    /* loaded from: classes4.dex */
    public class c extends RecyclerView.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public TextView f17292a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f17293b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f17294c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f17295d;

        /* renamed from: e  reason: collision with root package name */
        public TbImageView f17296e;

        /* renamed from: f  reason: collision with root package name */
        public ImageView f17297f;

        /* renamed from: g  reason: collision with root package name */
        public View f17298g;

        /* renamed from: h  reason: collision with root package name */
        public RelativeLayout f17299h;

        public c(View view) {
            super(view);
            this.f17292a = (TextView) view.findViewById(R.id.tv_title);
            this.f17296e = (TbImageView) view.findViewById(R.id.tb_imageview_pic);
            this.f17293b = (TextView) view.findViewById(R.id.tv_left_watch);
            this.f17294c = (TextView) view.findViewById(R.id.tv_left_agree);
            this.f17297f = (ImageView) view.findViewById(R.id.video_play_iv);
            this.f17295d = (TextView) view.findViewById(R.id.text_tv);
            this.f17298g = view.findViewById(R.id.gradient_cover);
            this.f17299h = (RelativeLayout) view.findViewById(R.id.rl_photo_view);
        }

        public void a(SpecialColumnItemData specialColumnItemData) {
            if (specialColumnItemData == null) {
                return;
            }
            this.f17292a.setText(specialColumnItemData.title);
            this.f17296e.setConrers(15);
            this.f17296e.setRadius(l.g(TbadkCoreApplication.getInst(), R.dimen.tbds10));
            this.f17296e.setDrawCorner(true);
            this.f17296e.setPlaceHolder(2);
            this.f17296e.V(specialColumnItemData.image, 10, false);
            this.f17296e.setGifIconSupport(false);
            this.f17294c.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.person_view_item_live_zan_num), StringHelper.numberUniformFormatExtra(specialColumnItemData.agree_num)));
            this.f17295d.setText(specialColumnItemData.text);
            if (specialColumnItemData.specialType == 2) {
                this.f17297f.setVisibility(0);
                this.f17298g.setVisibility(0);
                this.f17298g.setAlpha(0.5f);
                this.f17295d.setVisibility(0);
                HomePageTabFeedCollegeSecondListAdapter.this.f17281d = R.drawable.ic_icon_pure_video_play12_svg;
                this.f17293b.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.person_play_num), StringHelper.numberUniformFormatExtra(specialColumnItemData.freq_num)));
                TBSelector.makeDrawableSelector().setShape(0).gradientLinear(R.color.CAM_X0607, R.color.CAM_X0611).cornerRadius(l.g(HomePageTabFeedCollegeSecondListAdapter.this.f17278a, R.dimen.tbds10)).into(this.f17298g);
                return;
            }
            this.f17298g.setVisibility(8);
            this.f17297f.setVisibility(8);
            this.f17295d.setVisibility(8);
            HomePageTabFeedCollegeSecondListAdapter.this.f17281d = 0;
            this.f17293b.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.person_view_num), StringHelper.numberUniformFormatExtra(specialColumnItemData.freq_num)));
        }
    }

    public HomePageTabFeedCollegeSecondListAdapter(Context context, List<SpecialColumnItemData> list) {
        this.f17278a = context;
        this.f17279b = list;
    }

    public final void f(RecyclerView.ViewHolder viewHolder) {
        if (viewHolder instanceof c) {
            c cVar = (c) viewHolder;
            SkinManager.setViewTextColor(cVar.f17292a, R.color.CAM_X0105);
            SkinManager.setViewTextColor(cVar.f17293b, R.color.CAM_X0109);
            SkinManager.setViewTextColor(cVar.f17294c, R.color.CAM_X0109);
            SkinManager.setViewTextColor(cVar.f17295d, R.color.CAM_X0101);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(cVar.f17297f, this.f17281d, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL);
            TBSelector.setViewBackgroundColorWithPressedState(cVar.f17299h, R.color.CAM_X0205, R.color.CAM_X0204);
        } else if (viewHolder instanceof b) {
            b bVar = (b) viewHolder;
            SkinManager.setViewTextColor(bVar.f17286b, R.color.CAM_X0105);
            SkinManager.setViewTextColor(bVar.f17285a, R.color.CAM_X0101);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(bVar.f17288d, this.f17281d, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL);
            TBSelector.setViewBackgroundColorWithPressedState(bVar.f17290f, R.color.CAM_X0205, R.color.CAM_X0204);
        }
    }

    public final SpecialColumnItemData g(int i2) {
        return (SpecialColumnItemData) ListUtils.getItem(this.f17279b, i2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return ListUtils.getCount(this.f17279b);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i2) {
        int i3 = this.f17279b.get(i2).specialType;
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
        this.f17280c = fVar;
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
            return new c(LayoutInflater.from(this.f17278a).inflate(R.layout.layout_item_colleage_second_photo, (ViewGroup) null));
        }
        if (i2 == 3 || i2 == 4) {
            return new b(LayoutInflater.from(this.f17278a).inflate(R.layout.layout_item_colleage_second_live, (ViewGroup) null));
        }
        return null;
    }
}
