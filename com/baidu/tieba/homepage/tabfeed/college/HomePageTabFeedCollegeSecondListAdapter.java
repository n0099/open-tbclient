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
import d.a.m0.m.f;
import java.util.List;
/* loaded from: classes4.dex */
public class HomePageTabFeedCollegeSecondListAdapter extends RecyclerView.Adapter {

    /* renamed from: a  reason: collision with root package name */
    public Context f16503a;

    /* renamed from: b  reason: collision with root package name */
    public List<SpecialColumnItemData> f16504b;

    /* renamed from: c  reason: collision with root package name */
    public f<SpecialColumnItemData> f16505c = null;

    /* renamed from: d  reason: collision with root package name */
    public int f16506d;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SpecialColumnItemData f16507e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f16508f;

        public a(SpecialColumnItemData specialColumnItemData, int i2) {
            this.f16507e = specialColumnItemData;
            this.f16508f = i2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (HomePageTabFeedCollegeSecondListAdapter.this.f16505c != null) {
                f fVar = HomePageTabFeedCollegeSecondListAdapter.this.f16505c;
                SpecialColumnItemData specialColumnItemData = this.f16507e;
                int i2 = this.f16508f;
                fVar.a(view, specialColumnItemData, i2, i2);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b extends RecyclerView.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public TextView f16510a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f16511b;

        /* renamed from: c  reason: collision with root package name */
        public TbImageView f16512c;

        /* renamed from: d  reason: collision with root package name */
        public ImageView f16513d;

        /* renamed from: e  reason: collision with root package name */
        public View f16514e;

        /* renamed from: f  reason: collision with root package name */
        public LinearLayout f16515f;

        public b(View view) {
            super(view);
            this.f16512c = (TbImageView) view.findViewById(R.id.iv_imageView);
            this.f16513d = (ImageView) view.findViewById(R.id.video_play_iv);
            this.f16510a = (TextView) view.findViewById(R.id.text_tv);
            this.f16511b = (TextView) view.findViewById(R.id.tv_content);
            this.f16514e = view.findViewById(R.id.gradient_cover);
            this.f16515f = (LinearLayout) view.findViewById(R.id.ll_live_main);
        }

        public void a(SpecialColumnItemData specialColumnItemData) {
            if (specialColumnItemData == null) {
                return;
            }
            this.f16511b.setText(specialColumnItemData.title);
            this.f16512c.setConrers(15);
            this.f16512c.setRadius(l.g(TbadkCoreApplication.getInst(), R.dimen.tbds10));
            this.f16512c.setDrawCorner(true);
            this.f16512c.setPlaceHolder(2);
            this.f16512c.V(specialColumnItemData.image, 10, false);
            this.f16510a.setText(specialColumnItemData.text);
            this.f16513d.setVisibility(0);
            HomePageTabFeedCollegeSecondListAdapter.this.f16506d = R.drawable.ic_icon_pure_common_live12_svg;
            this.f16514e.setAlpha(0.5f);
            TBSelector.makeDrawableSelector().setShape(0).cornerRadius(l.g(HomePageTabFeedCollegeSecondListAdapter.this.f16503a, R.dimen.tbds10)).gradientLinear(R.color.CAM_X0607, R.color.CAM_X0611).into(this.f16514e);
        }
    }

    /* loaded from: classes4.dex */
    public class c extends RecyclerView.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public TextView f16517a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f16518b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f16519c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f16520d;

        /* renamed from: e  reason: collision with root package name */
        public TbImageView f16521e;

        /* renamed from: f  reason: collision with root package name */
        public ImageView f16522f;

        /* renamed from: g  reason: collision with root package name */
        public View f16523g;

        /* renamed from: h  reason: collision with root package name */
        public RelativeLayout f16524h;

        public c(View view) {
            super(view);
            this.f16517a = (TextView) view.findViewById(R.id.tv_title);
            this.f16521e = (TbImageView) view.findViewById(R.id.tb_imageview_pic);
            this.f16518b = (TextView) view.findViewById(R.id.tv_left_watch);
            this.f16519c = (TextView) view.findViewById(R.id.tv_left_agree);
            this.f16522f = (ImageView) view.findViewById(R.id.video_play_iv);
            this.f16520d = (TextView) view.findViewById(R.id.text_tv);
            this.f16523g = view.findViewById(R.id.gradient_cover);
            this.f16524h = (RelativeLayout) view.findViewById(R.id.rl_photo_view);
        }

        public void a(SpecialColumnItemData specialColumnItemData) {
            if (specialColumnItemData == null) {
                return;
            }
            this.f16517a.setText(specialColumnItemData.title);
            this.f16521e.setConrers(15);
            this.f16521e.setRadius(l.g(TbadkCoreApplication.getInst(), R.dimen.tbds10));
            this.f16521e.setDrawCorner(true);
            this.f16521e.setPlaceHolder(2);
            this.f16521e.V(specialColumnItemData.image, 10, false);
            this.f16521e.setGifIconSupport(false);
            this.f16519c.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.person_view_item_live_zan_num), StringHelper.numberUniformFormatExtra(specialColumnItemData.agree_num)));
            this.f16520d.setText(specialColumnItemData.text);
            if (specialColumnItemData.specialType == 2) {
                this.f16522f.setVisibility(0);
                this.f16523g.setVisibility(0);
                this.f16523g.setAlpha(0.5f);
                this.f16520d.setVisibility(0);
                HomePageTabFeedCollegeSecondListAdapter.this.f16506d = R.drawable.ic_icon_pure_video_play12_svg;
                this.f16518b.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.person_play_num), StringHelper.numberUniformFormatExtra(specialColumnItemData.freq_num)));
                TBSelector.makeDrawableSelector().setShape(0).gradientLinear(R.color.CAM_X0607, R.color.CAM_X0611).cornerRadius(l.g(HomePageTabFeedCollegeSecondListAdapter.this.f16503a, R.dimen.tbds10)).into(this.f16523g);
                return;
            }
            this.f16523g.setVisibility(8);
            this.f16522f.setVisibility(8);
            this.f16520d.setVisibility(8);
            HomePageTabFeedCollegeSecondListAdapter.this.f16506d = 0;
            this.f16518b.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.person_view_num), StringHelper.numberUniformFormatExtra(specialColumnItemData.freq_num)));
        }
    }

    public HomePageTabFeedCollegeSecondListAdapter(Context context, List<SpecialColumnItemData> list) {
        this.f16503a = context;
        this.f16504b = list;
    }

    public final void f(RecyclerView.ViewHolder viewHolder) {
        if (viewHolder instanceof c) {
            c cVar = (c) viewHolder;
            SkinManager.setViewTextColor(cVar.f16517a, R.color.CAM_X0105);
            SkinManager.setViewTextColor(cVar.f16518b, R.color.CAM_X0109);
            SkinManager.setViewTextColor(cVar.f16519c, R.color.CAM_X0109);
            SkinManager.setViewTextColor(cVar.f16520d, R.color.CAM_X0101);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(cVar.f16522f, this.f16506d, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL);
            TBSelector.setViewBackgroundColorWithPressedState(cVar.f16524h, R.color.CAM_X0205, R.color.CAM_X0204);
        } else if (viewHolder instanceof b) {
            b bVar = (b) viewHolder;
            SkinManager.setViewTextColor(bVar.f16511b, R.color.CAM_X0105);
            SkinManager.setViewTextColor(bVar.f16510a, R.color.CAM_X0101);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(bVar.f16513d, this.f16506d, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL);
            TBSelector.setViewBackgroundColorWithPressedState(bVar.f16515f, R.color.CAM_X0205, R.color.CAM_X0204);
        }
    }

    public final SpecialColumnItemData g(int i2) {
        return (SpecialColumnItemData) ListUtils.getItem(this.f16504b, i2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return ListUtils.getCount(this.f16504b);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i2) {
        int i3 = this.f16504b.get(i2).specialType;
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
        this.f16505c = fVar;
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
            return new c(LayoutInflater.from(this.f16503a).inflate(R.layout.layout_item_colleage_second_photo, (ViewGroup) null));
        }
        if (i2 == 3 || i2 == 4) {
            return new b(LayoutInflater.from(this.f16503a).inflate(R.layout.layout_item_colleage_second_live, (ViewGroup) null));
        }
        return null;
    }
}
