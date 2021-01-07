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
    private List<SpecialColumnItemData> kjN;
    private Context mContext;
    private int mIconResId;
    private f<SpecialColumnItemData> kjO = null;
    private final int TYPE_NORMAL = 1;
    private final int TYPE_VIDEO = 2;
    private final int TYPE_LIVE = 3;
    private final int TYPE_LIVE_RE = 4;

    public HomePageTabFeedCollegeSecondListAdapter(Context context, List<SpecialColumnItemData> list) {
        this.mContext = context;
        this.kjN = list;
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
        SpecialColumnItemData specialColumnItemData = this.kjN.get(i);
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
        final SpecialColumnItemData Do = Do(i);
        if (viewHolder instanceof b) {
            ((b) viewHolder).a(Do);
        } else if (viewHolder instanceof a) {
            ((a) viewHolder).a(Do);
        }
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.tabfeed.college.HomePageTabFeedCollegeSecondListAdapter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (HomePageTabFeedCollegeSecondListAdapter.this.kjO != null) {
                    HomePageTabFeedCollegeSecondListAdapter.this.kjO.a(view, Do, i, i);
                }
            }
        });
        c(viewHolder);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class b extends RecyclerView.ViewHolder {
        public TextView fjZ;
        public TextView kjR;
        public ImageView kjU;
        public View kjV;
        public TextView kjX;
        public TextView kjY;
        public TbImageView kjZ;
        public RelativeLayout kka;

        public b(View view) {
            super(view);
            this.fjZ = (TextView) view.findViewById(R.id.tv_title);
            this.kjZ = (TbImageView) view.findViewById(R.id.tb_imageview_pic);
            this.kjX = (TextView) view.findViewById(R.id.tv_left_watch);
            this.kjY = (TextView) view.findViewById(R.id.tv_left_agree);
            this.kjU = (ImageView) view.findViewById(R.id.video_play_iv);
            this.kjR = (TextView) view.findViewById(R.id.text_tv);
            this.kjV = view.findViewById(R.id.gradient_cover);
            this.kka = (RelativeLayout) view.findViewById(R.id.rl_photo_view);
        }

        void a(SpecialColumnItemData specialColumnItemData) {
            if (specialColumnItemData != null) {
                this.fjZ.setText(specialColumnItemData.title);
                this.kjZ.setConrers(15);
                this.kjZ.setRadius(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10));
                this.kjZ.setDrawCorner(true);
                this.kjZ.setPlaceHolder(2);
                this.kjZ.startLoad(specialColumnItemData.image, 10, false);
                this.kjZ.setGifIconSupport(false);
                this.kjY.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.person_view_item_live_zan_num), at.numberUniformFormatExtra(specialColumnItemData.agree_num)));
                this.kjR.setText(specialColumnItemData.text);
                if (specialColumnItemData.specialType == 2) {
                    this.kjU.setVisibility(0);
                    this.kjV.setVisibility(0);
                    this.kjV.setAlpha(0.5f);
                    this.kjR.setVisibility(0);
                    HomePageTabFeedCollegeSecondListAdapter.this.mIconResId = R.drawable.ic_icon_pure_video_play12_svg;
                    this.kjX.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.person_play_num), at.numberUniformFormatExtra(specialColumnItemData.freq_num)));
                    com.baidu.tbadk.core.util.f.a.bwV().qq(0).m(R.color.CAM_X0607, R.color.CAM_X0611).qx(l.getDimens(HomePageTabFeedCollegeSecondListAdapter.this.mContext, R.dimen.tbds10)).bz(this.kjV);
                    return;
                }
                this.kjV.setVisibility(8);
                this.kjU.setVisibility(8);
                this.kjR.setVisibility(8);
                HomePageTabFeedCollegeSecondListAdapter.this.mIconResId = 0;
                this.kjX.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.person_view_num), at.numberUniformFormatExtra(specialColumnItemData.freq_num)));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a extends RecyclerView.ViewHolder {
        public TextView kjR;
        public TextView kjS;
        public TbImageView kjT;
        public ImageView kjU;
        public View kjV;
        public LinearLayout kjW;

        public a(View view) {
            super(view);
            this.kjT = (TbImageView) view.findViewById(R.id.iv_imageView);
            this.kjU = (ImageView) view.findViewById(R.id.video_play_iv);
            this.kjR = (TextView) view.findViewById(R.id.text_tv);
            this.kjS = (TextView) view.findViewById(R.id.tv_content);
            this.kjV = view.findViewById(R.id.gradient_cover);
            this.kjW = (LinearLayout) view.findViewById(R.id.ll_live_main);
        }

        void a(SpecialColumnItemData specialColumnItemData) {
            if (specialColumnItemData != null) {
                this.kjS.setText(specialColumnItemData.title);
                this.kjT.setConrers(15);
                this.kjT.setRadius(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10));
                this.kjT.setDrawCorner(true);
                this.kjT.setPlaceHolder(2);
                this.kjT.startLoad(specialColumnItemData.image, 10, false);
                this.kjR.setText(specialColumnItemData.text);
                this.kjU.setVisibility(0);
                HomePageTabFeedCollegeSecondListAdapter.this.mIconResId = R.drawable.ic_icon_pure_common_live12_svg;
                this.kjV.setAlpha(0.5f);
                com.baidu.tbadk.core.util.f.a.bwV().qq(0).qx(l.getDimens(HomePageTabFeedCollegeSecondListAdapter.this.mContext, R.dimen.tbds10)).m(R.color.CAM_X0607, R.color.CAM_X0611).bz(this.kjV);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return x.getCount(this.kjN);
    }

    private SpecialColumnItemData Do(int i) {
        return (SpecialColumnItemData) x.getItem(this.kjN, i);
    }

    private void c(RecyclerView.ViewHolder viewHolder) {
        if (viewHolder instanceof b) {
            ao.setViewTextColor(((b) viewHolder).fjZ, R.color.CAM_X0105);
            ao.setViewTextColor(((b) viewHolder).kjX, R.color.CAM_X0109);
            ao.setViewTextColor(((b) viewHolder).kjY, R.color.CAM_X0109);
            ao.setViewTextColor(((b) viewHolder).kjR, R.color.CAM_X0101);
            SvgManager.bwr().a(((b) viewHolder).kjU, this.mIconResId, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL);
            com.baidu.tbadk.core.util.f.a.m(((b) viewHolder).kka, R.color.CAM_X0205, R.color.CAM_X0204);
        } else if (viewHolder instanceof a) {
            ao.setViewTextColor(((a) viewHolder).kjS, R.color.CAM_X0105);
            ao.setViewTextColor(((a) viewHolder).kjR, R.color.CAM_X0101);
            SvgManager.bwr().a(((a) viewHolder).kjU, this.mIconResId, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL);
            com.baidu.tbadk.core.util.f.a.m(((a) viewHolder).kjW, R.color.CAM_X0205, R.color.CAM_X0204);
        }
    }

    public void a(f<SpecialColumnItemData> fVar) {
        this.kjO = fVar;
    }
}
