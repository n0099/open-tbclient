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
/* loaded from: classes3.dex */
public class HomePageTabFeedCollegeSecondListAdapter extends RecyclerView.Adapter {

    /* renamed from: a  reason: collision with root package name */
    public Context f17317a;

    /* renamed from: b  reason: collision with root package name */
    public List<SpecialColumnItemData> f17318b;

    /* renamed from: c  reason: collision with root package name */
    public f<SpecialColumnItemData> f17319c = null;

    /* renamed from: d  reason: collision with root package name */
    public int f17320d;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SpecialColumnItemData f17321e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f17322f;

        public a(SpecialColumnItemData specialColumnItemData, int i) {
            this.f17321e = specialColumnItemData;
            this.f17322f = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (HomePageTabFeedCollegeSecondListAdapter.this.f17319c != null) {
                f fVar = HomePageTabFeedCollegeSecondListAdapter.this.f17319c;
                SpecialColumnItemData specialColumnItemData = this.f17321e;
                int i = this.f17322f;
                fVar.a(view, specialColumnItemData, i, i);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b extends RecyclerView.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public TextView f17324a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f17325b;

        /* renamed from: c  reason: collision with root package name */
        public TbImageView f17326c;

        /* renamed from: d  reason: collision with root package name */
        public ImageView f17327d;

        /* renamed from: e  reason: collision with root package name */
        public View f17328e;

        /* renamed from: f  reason: collision with root package name */
        public LinearLayout f17329f;

        public b(View view) {
            super(view);
            this.f17326c = (TbImageView) view.findViewById(R.id.iv_imageView);
            this.f17327d = (ImageView) view.findViewById(R.id.video_play_iv);
            this.f17324a = (TextView) view.findViewById(R.id.text_tv);
            this.f17325b = (TextView) view.findViewById(R.id.tv_content);
            this.f17328e = view.findViewById(R.id.gradient_cover);
            this.f17329f = (LinearLayout) view.findViewById(R.id.ll_live_main);
        }

        public void a(SpecialColumnItemData specialColumnItemData) {
            if (specialColumnItemData == null) {
                return;
            }
            this.f17325b.setText(specialColumnItemData.title);
            this.f17326c.setConrers(15);
            this.f17326c.setRadius(l.g(TbadkCoreApplication.getInst(), R.dimen.tbds10));
            this.f17326c.setDrawCorner(true);
            this.f17326c.setPlaceHolder(2);
            this.f17326c.W(specialColumnItemData.image, 10, false);
            this.f17324a.setText(specialColumnItemData.text);
            this.f17327d.setVisibility(0);
            HomePageTabFeedCollegeSecondListAdapter.this.f17320d = R.drawable.ic_icon_pure_common_live12_svg;
            this.f17328e.setAlpha(0.5f);
            TBSelector.makeDrawableSelector().setShape(0).cornerRadius(l.g(HomePageTabFeedCollegeSecondListAdapter.this.f17317a, R.dimen.tbds10)).gradientLinear(R.color.CAM_X0607, R.color.CAM_X0611).into(this.f17328e);
        }
    }

    /* loaded from: classes3.dex */
    public class c extends RecyclerView.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public TextView f17331a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f17332b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f17333c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f17334d;

        /* renamed from: e  reason: collision with root package name */
        public TbImageView f17335e;

        /* renamed from: f  reason: collision with root package name */
        public ImageView f17336f;

        /* renamed from: g  reason: collision with root package name */
        public View f17337g;

        /* renamed from: h  reason: collision with root package name */
        public RelativeLayout f17338h;

        public c(View view) {
            super(view);
            this.f17331a = (TextView) view.findViewById(R.id.tv_title);
            this.f17335e = (TbImageView) view.findViewById(R.id.tb_imageview_pic);
            this.f17332b = (TextView) view.findViewById(R.id.tv_left_watch);
            this.f17333c = (TextView) view.findViewById(R.id.tv_left_agree);
            this.f17336f = (ImageView) view.findViewById(R.id.video_play_iv);
            this.f17334d = (TextView) view.findViewById(R.id.text_tv);
            this.f17337g = view.findViewById(R.id.gradient_cover);
            this.f17338h = (RelativeLayout) view.findViewById(R.id.rl_photo_view);
        }

        public void a(SpecialColumnItemData specialColumnItemData) {
            if (specialColumnItemData == null) {
                return;
            }
            this.f17331a.setText(specialColumnItemData.title);
            this.f17335e.setConrers(15);
            this.f17335e.setRadius(l.g(TbadkCoreApplication.getInst(), R.dimen.tbds10));
            this.f17335e.setDrawCorner(true);
            this.f17335e.setPlaceHolder(2);
            this.f17335e.W(specialColumnItemData.image, 10, false);
            this.f17335e.setGifIconSupport(false);
            this.f17333c.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.person_view_item_live_zan_num), StringHelper.numberUniformFormatExtra(specialColumnItemData.agree_num)));
            this.f17334d.setText(specialColumnItemData.text);
            if (specialColumnItemData.specialType == 2) {
                this.f17336f.setVisibility(0);
                this.f17337g.setVisibility(0);
                this.f17337g.setAlpha(0.5f);
                this.f17334d.setVisibility(0);
                HomePageTabFeedCollegeSecondListAdapter.this.f17320d = R.drawable.ic_icon_pure_video_play12_svg;
                this.f17332b.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.person_play_num), StringHelper.numberUniformFormatExtra(specialColumnItemData.freq_num)));
                TBSelector.makeDrawableSelector().setShape(0).gradientLinear(R.color.CAM_X0607, R.color.CAM_X0611).cornerRadius(l.g(HomePageTabFeedCollegeSecondListAdapter.this.f17317a, R.dimen.tbds10)).into(this.f17337g);
                return;
            }
            this.f17337g.setVisibility(8);
            this.f17336f.setVisibility(8);
            this.f17334d.setVisibility(8);
            HomePageTabFeedCollegeSecondListAdapter.this.f17320d = 0;
            this.f17332b.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.person_view_num), StringHelper.numberUniformFormatExtra(specialColumnItemData.freq_num)));
        }
    }

    public HomePageTabFeedCollegeSecondListAdapter(Context context, List<SpecialColumnItemData> list) {
        this.f17317a = context;
        this.f17318b = list;
    }

    public final void f(RecyclerView.ViewHolder viewHolder) {
        if (viewHolder instanceof c) {
            c cVar = (c) viewHolder;
            SkinManager.setViewTextColor(cVar.f17331a, R.color.CAM_X0105);
            SkinManager.setViewTextColor(cVar.f17332b, R.color.CAM_X0109);
            SkinManager.setViewTextColor(cVar.f17333c, R.color.CAM_X0109);
            SkinManager.setViewTextColor(cVar.f17334d, R.color.CAM_X0101);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(cVar.f17336f, this.f17320d, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL);
            TBSelector.setViewBackgroundColorWithPressedState(cVar.f17338h, R.color.CAM_X0205, R.color.CAM_X0204);
        } else if (viewHolder instanceof b) {
            b bVar = (b) viewHolder;
            SkinManager.setViewTextColor(bVar.f17325b, R.color.CAM_X0105);
            SkinManager.setViewTextColor(bVar.f17324a, R.color.CAM_X0101);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(bVar.f17327d, this.f17320d, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL);
            TBSelector.setViewBackgroundColorWithPressedState(bVar.f17329f, R.color.CAM_X0205, R.color.CAM_X0204);
        }
    }

    public final SpecialColumnItemData g(int i) {
        return (SpecialColumnItemData) ListUtils.getItem(this.f17318b, i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return ListUtils.getCount(this.f17318b);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        int i2 = this.f17318b.get(i).specialType;
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
        this.f17319c = fVar;
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
            return new c(LayoutInflater.from(this.f17317a).inflate(R.layout.layout_item_colleage_second_photo, (ViewGroup) null));
        }
        if (i == 3 || i == 4) {
            return new b(LayoutInflater.from(this.f17317a).inflate(R.layout.layout_item_colleage_second_live, (ViewGroup) null));
        }
        return null;
    }
}
