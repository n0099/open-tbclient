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
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.h.f;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.tabfeed.data.SpecialColumnItemData;
import java.util.List;
/* loaded from: classes2.dex */
public class HomePageTabFeedCollegeSecondListAdapter extends RecyclerView.Adapter {
    private List<SpecialColumnItemData> kfh;
    private Context mContext;
    private int mIconResId;
    private f<SpecialColumnItemData> kfi = null;
    private final int TYPE_NORMAL = 1;
    private final int TYPE_VIDEO = 2;
    private final int TYPE_LIVE = 3;
    private final int TYPE_LIVE_RE = 4;

    public HomePageTabFeedCollegeSecondListAdapter(Context context, List<SpecialColumnItemData> list) {
        this.mContext = context;
        this.kfh = list;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        if (i == 1 || i == 2) {
            return new b(LayoutInflater.from(this.mContext).inflate(R.layout.layout_item_colleage_second_photo, (ViewGroup) null));
        }
        if (i == 3 || i == 4) {
            return new a(LayoutInflater.from(this.mContext).inflate(R.layout.layout_item_colleage_second_live, (ViewGroup) null));
        }
        return null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        SpecialColumnItemData specialColumnItemData = this.kfh.get(i);
        if (specialColumnItemData.specialType == 1) {
            return 1;
        }
        if (specialColumnItemData.specialType == 2) {
            return 2;
        }
        if (specialColumnItemData.specialType == 3) {
            return 3;
        }
        if (specialColumnItemData.specialType == 4) {
            return 4;
        }
        return super.getItemViewType(i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, final int i) {
        final SpecialColumnItemData BH = BH(i);
        if (viewHolder instanceof b) {
            ((b) viewHolder).a(BH);
        } else if (viewHolder instanceof a) {
            ((a) viewHolder).a(BH);
        }
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.tabfeed.college.HomePageTabFeedCollegeSecondListAdapter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (HomePageTabFeedCollegeSecondListAdapter.this.kfi != null) {
                    HomePageTabFeedCollegeSecondListAdapter.this.kfi.a(view, BH, i, i);
                }
            }
        });
        c(viewHolder);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class b extends RecyclerView.ViewHolder {
        public TextView ffo;
        public TextView kfl;
        public ImageView kfo;
        public View kfp;
        public TextView kfr;
        public TextView kfs;
        public TbImageView kft;
        public RelativeLayout kfu;

        public b(View view) {
            super(view);
            this.ffo = (TextView) view.findViewById(R.id.tv_title);
            this.kft = (TbImageView) view.findViewById(R.id.tb_imageview_pic);
            this.kfr = (TextView) view.findViewById(R.id.tv_left_watch);
            this.kfs = (TextView) view.findViewById(R.id.tv_left_agree);
            this.kfo = (ImageView) view.findViewById(R.id.video_play_iv);
            this.kfl = (TextView) view.findViewById(R.id.text_tv);
            this.kfp = view.findViewById(R.id.gradient_cover);
            this.kfu = (RelativeLayout) view.findViewById(R.id.rl_photo_view);
        }

        void a(SpecialColumnItemData specialColumnItemData) {
            if (specialColumnItemData != null) {
                this.ffo.setText(specialColumnItemData.title);
                this.kft.setConrers(15);
                this.kft.setRadius(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10));
                this.kft.setDrawCorner(true);
                this.kft.setPlaceHolder(2);
                this.kft.startLoad(specialColumnItemData.image, 10, false);
                this.kft.setGifIconSupport(false);
                this.kfs.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.person_view_item_live_zan_num), at.numberUniformFormatExtra(specialColumnItemData.agree_num)));
                this.kfl.setText(specialColumnItemData.text);
                if (specialColumnItemData.specialType == 2) {
                    this.kfo.setVisibility(0);
                    this.kfp.setVisibility(0);
                    this.kfp.setAlpha(0.5f);
                    this.kfl.setVisibility(0);
                    HomePageTabFeedCollegeSecondListAdapter.this.mIconResId = R.drawable.ic_icon_pure_video_play12_svg;
                    this.kfr.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.person_play_num), at.numberUniformFormatExtra(specialColumnItemData.freq_num)));
                    com.baidu.tbadk.core.util.f.a.btb().oJ(0).m(R.color.CAM_X0607, R.color.CAM_X0611).oQ(l.getDimens(HomePageTabFeedCollegeSecondListAdapter.this.mContext, R.dimen.tbds10)).bz(this.kfp);
                    return;
                }
                this.kfp.setVisibility(8);
                this.kfo.setVisibility(8);
                this.kfl.setVisibility(8);
                HomePageTabFeedCollegeSecondListAdapter.this.mIconResId = 0;
                this.kfr.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.person_view_num), at.numberUniformFormatExtra(specialColumnItemData.freq_num)));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a extends RecyclerView.ViewHolder {
        public TextView kfl;
        public TextView kfm;
        public TbImageView kfn;
        public ImageView kfo;
        public View kfp;
        public LinearLayout kfq;

        public a(View view) {
            super(view);
            this.kfn = (TbImageView) view.findViewById(R.id.iv_imageView);
            this.kfo = (ImageView) view.findViewById(R.id.video_play_iv);
            this.kfl = (TextView) view.findViewById(R.id.text_tv);
            this.kfm = (TextView) view.findViewById(R.id.tv_content);
            this.kfp = view.findViewById(R.id.gradient_cover);
            this.kfq = (LinearLayout) view.findViewById(R.id.ll_live_main);
        }

        void a(SpecialColumnItemData specialColumnItemData) {
            if (specialColumnItemData != null) {
                this.kfm.setText(specialColumnItemData.title);
                this.kfn.setConrers(15);
                this.kfn.setRadius(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10));
                this.kfn.setDrawCorner(true);
                this.kfn.setPlaceHolder(2);
                this.kfn.startLoad(specialColumnItemData.image, 10, false);
                this.kfl.setText(specialColumnItemData.text);
                this.kfo.setVisibility(0);
                HomePageTabFeedCollegeSecondListAdapter.this.mIconResId = R.drawable.ic_icon_pure_common_live12_svg;
                this.kfp.setAlpha(0.5f);
                com.baidu.tbadk.core.util.f.a.btb().oJ(0).oQ(l.getDimens(HomePageTabFeedCollegeSecondListAdapter.this.mContext, R.dimen.tbds10)).m(R.color.CAM_X0607, R.color.CAM_X0611).bz(this.kfp);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return x.getCount(this.kfh);
    }

    private SpecialColumnItemData BH(int i) {
        return (SpecialColumnItemData) x.getItem(this.kfh, i);
    }

    private void c(RecyclerView.ViewHolder viewHolder) {
        if (viewHolder instanceof b) {
            ao.setViewTextColor(((b) viewHolder).ffo, R.color.CAM_X0105);
            ao.setViewTextColor(((b) viewHolder).kfr, R.color.CAM_X0109);
            ao.setViewTextColor(((b) viewHolder).kfs, R.color.CAM_X0109);
            ao.setViewTextColor(((b) viewHolder).kfl, R.color.CAM_X0101);
            SvgManager.bsx().a(((b) viewHolder).kfo, this.mIconResId, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL);
            com.baidu.tbadk.core.util.f.a.m(((b) viewHolder).kfu, R.color.CAM_X0205, R.color.CAM_X0204);
        } else if (viewHolder instanceof a) {
            ao.setViewTextColor(((a) viewHolder).kfm, R.color.CAM_X0105);
            ao.setViewTextColor(((a) viewHolder).kfl, R.color.CAM_X0101);
            SvgManager.bsx().a(((a) viewHolder).kfo, this.mIconResId, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL);
            com.baidu.tbadk.core.util.f.a.m(((a) viewHolder).kfq, R.color.CAM_X0205, R.color.CAM_X0204);
        }
    }

    public void a(f<SpecialColumnItemData> fVar) {
        this.kfi = fVar;
    }
}
