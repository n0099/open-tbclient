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
import d.b.b.e.p.l;
import d.b.h0.m.f;
import java.util.List;
/* loaded from: classes4.dex */
public class HomePageTabFeedCollegeSecondListAdapter extends RecyclerView.Adapter {

    /* renamed from: a  reason: collision with root package name */
    public Context f17316a;

    /* renamed from: b  reason: collision with root package name */
    public List<SpecialColumnItemData> f17317b;

    /* renamed from: c  reason: collision with root package name */
    public f<SpecialColumnItemData> f17318c = null;

    /* renamed from: d  reason: collision with root package name */
    public int f17319d;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SpecialColumnItemData f17320e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f17321f;

        public a(SpecialColumnItemData specialColumnItemData, int i) {
            this.f17320e = specialColumnItemData;
            this.f17321f = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (HomePageTabFeedCollegeSecondListAdapter.this.f17318c != null) {
                f fVar = HomePageTabFeedCollegeSecondListAdapter.this.f17318c;
                SpecialColumnItemData specialColumnItemData = this.f17320e;
                int i = this.f17321f;
                fVar.a(view, specialColumnItemData, i, i);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b extends RecyclerView.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public TextView f17323a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f17324b;

        /* renamed from: c  reason: collision with root package name */
        public TbImageView f17325c;

        /* renamed from: d  reason: collision with root package name */
        public ImageView f17326d;

        /* renamed from: e  reason: collision with root package name */
        public View f17327e;

        /* renamed from: f  reason: collision with root package name */
        public LinearLayout f17328f;

        public b(View view) {
            super(view);
            this.f17325c = (TbImageView) view.findViewById(R.id.iv_imageView);
            this.f17326d = (ImageView) view.findViewById(R.id.video_play_iv);
            this.f17323a = (TextView) view.findViewById(R.id.text_tv);
            this.f17324b = (TextView) view.findViewById(R.id.tv_content);
            this.f17327e = view.findViewById(R.id.gradient_cover);
            this.f17328f = (LinearLayout) view.findViewById(R.id.ll_live_main);
        }

        public void a(SpecialColumnItemData specialColumnItemData) {
            if (specialColumnItemData == null) {
                return;
            }
            this.f17324b.setText(specialColumnItemData.title);
            this.f17325c.setConrers(15);
            this.f17325c.setRadius(l.g(TbadkCoreApplication.getInst(), R.dimen.tbds10));
            this.f17325c.setDrawCorner(true);
            this.f17325c.setPlaceHolder(2);
            this.f17325c.W(specialColumnItemData.image, 10, false);
            this.f17323a.setText(specialColumnItemData.text);
            this.f17326d.setVisibility(0);
            HomePageTabFeedCollegeSecondListAdapter.this.f17319d = R.drawable.ic_icon_pure_common_live12_svg;
            this.f17327e.setAlpha(0.5f);
            TBSelector.makeDrawableSelector().setShape(0).cornerRadius(l.g(HomePageTabFeedCollegeSecondListAdapter.this.f17316a, R.dimen.tbds10)).gradientLinear(R.color.CAM_X0607, R.color.CAM_X0611).into(this.f17327e);
        }
    }

    /* loaded from: classes4.dex */
    public class c extends RecyclerView.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public TextView f17330a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f17331b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f17332c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f17333d;

        /* renamed from: e  reason: collision with root package name */
        public TbImageView f17334e;

        /* renamed from: f  reason: collision with root package name */
        public ImageView f17335f;

        /* renamed from: g  reason: collision with root package name */
        public View f17336g;

        /* renamed from: h  reason: collision with root package name */
        public RelativeLayout f17337h;

        public c(View view) {
            super(view);
            this.f17330a = (TextView) view.findViewById(R.id.tv_title);
            this.f17334e = (TbImageView) view.findViewById(R.id.tb_imageview_pic);
            this.f17331b = (TextView) view.findViewById(R.id.tv_left_watch);
            this.f17332c = (TextView) view.findViewById(R.id.tv_left_agree);
            this.f17335f = (ImageView) view.findViewById(R.id.video_play_iv);
            this.f17333d = (TextView) view.findViewById(R.id.text_tv);
            this.f17336g = view.findViewById(R.id.gradient_cover);
            this.f17337h = (RelativeLayout) view.findViewById(R.id.rl_photo_view);
        }

        public void a(SpecialColumnItemData specialColumnItemData) {
            if (specialColumnItemData == null) {
                return;
            }
            this.f17330a.setText(specialColumnItemData.title);
            this.f17334e.setConrers(15);
            this.f17334e.setRadius(l.g(TbadkCoreApplication.getInst(), R.dimen.tbds10));
            this.f17334e.setDrawCorner(true);
            this.f17334e.setPlaceHolder(2);
            this.f17334e.W(specialColumnItemData.image, 10, false);
            this.f17334e.setGifIconSupport(false);
            this.f17332c.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.person_view_item_live_zan_num), StringHelper.numberUniformFormatExtra(specialColumnItemData.agree_num)));
            this.f17333d.setText(specialColumnItemData.text);
            if (specialColumnItemData.specialType == 2) {
                this.f17335f.setVisibility(0);
                this.f17336g.setVisibility(0);
                this.f17336g.setAlpha(0.5f);
                this.f17333d.setVisibility(0);
                HomePageTabFeedCollegeSecondListAdapter.this.f17319d = R.drawable.ic_icon_pure_video_play12_svg;
                this.f17331b.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.person_play_num), StringHelper.numberUniformFormatExtra(specialColumnItemData.freq_num)));
                TBSelector.makeDrawableSelector().setShape(0).gradientLinear(R.color.CAM_X0607, R.color.CAM_X0611).cornerRadius(l.g(HomePageTabFeedCollegeSecondListAdapter.this.f17316a, R.dimen.tbds10)).into(this.f17336g);
                return;
            }
            this.f17336g.setVisibility(8);
            this.f17335f.setVisibility(8);
            this.f17333d.setVisibility(8);
            HomePageTabFeedCollegeSecondListAdapter.this.f17319d = 0;
            this.f17331b.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.person_view_num), StringHelper.numberUniformFormatExtra(specialColumnItemData.freq_num)));
        }
    }

    public HomePageTabFeedCollegeSecondListAdapter(Context context, List<SpecialColumnItemData> list) {
        this.f17316a = context;
        this.f17317b = list;
    }

    public final void f(RecyclerView.ViewHolder viewHolder) {
        if (viewHolder instanceof c) {
            c cVar = (c) viewHolder;
            SkinManager.setViewTextColor(cVar.f17330a, R.color.CAM_X0105);
            SkinManager.setViewTextColor(cVar.f17331b, R.color.CAM_X0109);
            SkinManager.setViewTextColor(cVar.f17332c, R.color.CAM_X0109);
            SkinManager.setViewTextColor(cVar.f17333d, R.color.CAM_X0101);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(cVar.f17335f, this.f17319d, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL);
            TBSelector.setViewBackgroundColorWithPressedState(cVar.f17337h, R.color.CAM_X0205, R.color.CAM_X0204);
        } else if (viewHolder instanceof b) {
            b bVar = (b) viewHolder;
            SkinManager.setViewTextColor(bVar.f17324b, R.color.CAM_X0105);
            SkinManager.setViewTextColor(bVar.f17323a, R.color.CAM_X0101);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(bVar.f17326d, this.f17319d, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL);
            TBSelector.setViewBackgroundColorWithPressedState(bVar.f17328f, R.color.CAM_X0205, R.color.CAM_X0204);
        }
    }

    public final SpecialColumnItemData g(int i) {
        return (SpecialColumnItemData) ListUtils.getItem(this.f17317b, i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return ListUtils.getCount(this.f17317b);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        int i2 = this.f17317b.get(i).specialType;
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
        this.f17318c = fVar;
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
            return new c(LayoutInflater.from(this.f17316a).inflate(R.layout.layout_item_colleage_second_photo, (ViewGroup) null));
        }
        if (i == 3 || i == 4) {
            return new b(LayoutInflater.from(this.f17316a).inflate(R.layout.layout_item_colleage_second_live, (ViewGroup) null));
        }
        return null;
    }
}
