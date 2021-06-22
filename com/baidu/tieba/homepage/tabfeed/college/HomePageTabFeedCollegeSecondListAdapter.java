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
import d.a.n0.m.f;
import java.util.List;
/* loaded from: classes4.dex */
public class HomePageTabFeedCollegeSecondListAdapter extends RecyclerView.Adapter {

    /* renamed from: a  reason: collision with root package name */
    public Context f16654a;

    /* renamed from: b  reason: collision with root package name */
    public List<SpecialColumnItemData> f16655b;

    /* renamed from: c  reason: collision with root package name */
    public f<SpecialColumnItemData> f16656c = null;

    /* renamed from: d  reason: collision with root package name */
    public int f16657d;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SpecialColumnItemData f16658e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f16659f;

        public a(SpecialColumnItemData specialColumnItemData, int i2) {
            this.f16658e = specialColumnItemData;
            this.f16659f = i2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (HomePageTabFeedCollegeSecondListAdapter.this.f16656c != null) {
                f fVar = HomePageTabFeedCollegeSecondListAdapter.this.f16656c;
                SpecialColumnItemData specialColumnItemData = this.f16658e;
                int i2 = this.f16659f;
                fVar.a(view, specialColumnItemData, i2, i2);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b extends RecyclerView.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public TextView f16661a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f16662b;

        /* renamed from: c  reason: collision with root package name */
        public TbImageView f16663c;

        /* renamed from: d  reason: collision with root package name */
        public ImageView f16664d;

        /* renamed from: e  reason: collision with root package name */
        public View f16665e;

        /* renamed from: f  reason: collision with root package name */
        public LinearLayout f16666f;

        public b(View view) {
            super(view);
            this.f16663c = (TbImageView) view.findViewById(R.id.iv_imageView);
            this.f16664d = (ImageView) view.findViewById(R.id.video_play_iv);
            this.f16661a = (TextView) view.findViewById(R.id.text_tv);
            this.f16662b = (TextView) view.findViewById(R.id.tv_content);
            this.f16665e = view.findViewById(R.id.gradient_cover);
            this.f16666f = (LinearLayout) view.findViewById(R.id.ll_live_main);
        }

        public void a(SpecialColumnItemData specialColumnItemData) {
            if (specialColumnItemData == null) {
                return;
            }
            this.f16662b.setText(specialColumnItemData.title);
            this.f16663c.setConrers(15);
            this.f16663c.setRadius(l.g(TbadkCoreApplication.getInst(), R.dimen.tbds10));
            this.f16663c.setDrawCorner(true);
            this.f16663c.setPlaceHolder(2);
            this.f16663c.U(specialColumnItemData.image, 10, false);
            this.f16661a.setText(specialColumnItemData.text);
            this.f16664d.setVisibility(0);
            HomePageTabFeedCollegeSecondListAdapter.this.f16657d = R.drawable.ic_icon_pure_common_live12_svg;
            this.f16665e.setAlpha(0.5f);
            TBSelector.makeDrawableSelector().setShape(0).cornerRadius(l.g(HomePageTabFeedCollegeSecondListAdapter.this.f16654a, R.dimen.tbds10)).gradientLinear(R.color.CAM_X0607, R.color.CAM_X0611).into(this.f16665e);
        }
    }

    /* loaded from: classes4.dex */
    public class c extends RecyclerView.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public TextView f16668a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f16669b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f16670c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f16671d;

        /* renamed from: e  reason: collision with root package name */
        public TbImageView f16672e;

        /* renamed from: f  reason: collision with root package name */
        public ImageView f16673f;

        /* renamed from: g  reason: collision with root package name */
        public View f16674g;

        /* renamed from: h  reason: collision with root package name */
        public RelativeLayout f16675h;

        public c(View view) {
            super(view);
            this.f16668a = (TextView) view.findViewById(R.id.tv_title);
            this.f16672e = (TbImageView) view.findViewById(R.id.tb_imageview_pic);
            this.f16669b = (TextView) view.findViewById(R.id.tv_left_watch);
            this.f16670c = (TextView) view.findViewById(R.id.tv_left_agree);
            this.f16673f = (ImageView) view.findViewById(R.id.video_play_iv);
            this.f16671d = (TextView) view.findViewById(R.id.text_tv);
            this.f16674g = view.findViewById(R.id.gradient_cover);
            this.f16675h = (RelativeLayout) view.findViewById(R.id.rl_photo_view);
        }

        public void a(SpecialColumnItemData specialColumnItemData) {
            if (specialColumnItemData == null) {
                return;
            }
            this.f16668a.setText(specialColumnItemData.title);
            this.f16672e.setConrers(15);
            this.f16672e.setRadius(l.g(TbadkCoreApplication.getInst(), R.dimen.tbds10));
            this.f16672e.setDrawCorner(true);
            this.f16672e.setPlaceHolder(2);
            this.f16672e.U(specialColumnItemData.image, 10, false);
            this.f16672e.setGifIconSupport(false);
            this.f16670c.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.person_view_item_live_zan_num), StringHelper.numberUniformFormatExtra(specialColumnItemData.agree_num)));
            this.f16671d.setText(specialColumnItemData.text);
            if (specialColumnItemData.specialType == 2) {
                this.f16673f.setVisibility(0);
                this.f16674g.setVisibility(0);
                this.f16674g.setAlpha(0.5f);
                this.f16671d.setVisibility(0);
                HomePageTabFeedCollegeSecondListAdapter.this.f16657d = R.drawable.ic_icon_pure_video_play12_svg;
                this.f16669b.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.person_play_num), StringHelper.numberUniformFormatExtra(specialColumnItemData.freq_num)));
                TBSelector.makeDrawableSelector().setShape(0).gradientLinear(R.color.CAM_X0607, R.color.CAM_X0611).cornerRadius(l.g(HomePageTabFeedCollegeSecondListAdapter.this.f16654a, R.dimen.tbds10)).into(this.f16674g);
                return;
            }
            this.f16674g.setVisibility(8);
            this.f16673f.setVisibility(8);
            this.f16671d.setVisibility(8);
            HomePageTabFeedCollegeSecondListAdapter.this.f16657d = 0;
            this.f16669b.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.person_view_num), StringHelper.numberUniformFormatExtra(specialColumnItemData.freq_num)));
        }
    }

    public HomePageTabFeedCollegeSecondListAdapter(Context context, List<SpecialColumnItemData> list) {
        this.f16654a = context;
        this.f16655b = list;
    }

    public final void f(RecyclerView.ViewHolder viewHolder) {
        if (viewHolder instanceof c) {
            c cVar = (c) viewHolder;
            SkinManager.setViewTextColor(cVar.f16668a, R.color.CAM_X0105);
            SkinManager.setViewTextColor(cVar.f16669b, R.color.CAM_X0109);
            SkinManager.setViewTextColor(cVar.f16670c, R.color.CAM_X0109);
            SkinManager.setViewTextColor(cVar.f16671d, R.color.CAM_X0101);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(cVar.f16673f, this.f16657d, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL);
            TBSelector.setViewBackgroundColorWithPressedState(cVar.f16675h, R.color.CAM_X0205, R.color.CAM_X0204);
        } else if (viewHolder instanceof b) {
            b bVar = (b) viewHolder;
            SkinManager.setViewTextColor(bVar.f16662b, R.color.CAM_X0105);
            SkinManager.setViewTextColor(bVar.f16661a, R.color.CAM_X0101);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(bVar.f16664d, this.f16657d, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL);
            TBSelector.setViewBackgroundColorWithPressedState(bVar.f16666f, R.color.CAM_X0205, R.color.CAM_X0204);
        }
    }

    public final SpecialColumnItemData g(int i2) {
        return (SpecialColumnItemData) ListUtils.getItem(this.f16655b, i2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return ListUtils.getCount(this.f16655b);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i2) {
        int i3 = this.f16655b.get(i2).specialType;
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
        this.f16656c = fVar;
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
            return new c(LayoutInflater.from(this.f16654a).inflate(R.layout.layout_item_colleage_second_photo, (ViewGroup) null));
        }
        if (i2 == 3 || i2 == 4) {
            return new b(LayoutInflater.from(this.f16654a).inflate(R.layout.layout_item_colleage_second_live, (ViewGroup) null));
        }
        return null;
    }
}
