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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.h.f;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.tabfeed.data.SpecialColumnItemData;
import java.util.List;
/* loaded from: classes2.dex */
public class HomePageTabFeedCollegeSecondListAdapter extends RecyclerView.Adapter {
    private List<SpecialColumnItemData> kpF;
    private Context mContext;
    private int mIconResId;
    private f<SpecialColumnItemData> kpG = null;
    private final int TYPE_NORMAL = 1;
    private final int TYPE_VIDEO = 2;
    private final int TYPE_LIVE = 3;
    private final int TYPE_LIVE_RE = 4;

    public HomePageTabFeedCollegeSecondListAdapter(Context context, List<SpecialColumnItemData> list) {
        this.mContext = context;
        this.kpF = list;
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
        SpecialColumnItemData specialColumnItemData = this.kpF.get(i);
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
        final SpecialColumnItemData Cc = Cc(i);
        if (viewHolder instanceof b) {
            ((b) viewHolder).a(Cc);
        } else if (viewHolder instanceof a) {
            ((a) viewHolder).a(Cc);
        }
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.tabfeed.college.HomePageTabFeedCollegeSecondListAdapter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (HomePageTabFeedCollegeSecondListAdapter.this.kpG != null) {
                    HomePageTabFeedCollegeSecondListAdapter.this.kpG.a(view, Cc, i, i);
                }
            }
        });
        c(viewHolder);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class b extends RecyclerView.ViewHolder {
        public TextView fjg;
        public TextView kpJ;
        public ImageView kpM;
        public View kpN;
        public TextView kpP;
        public TextView kpQ;
        public TbImageView kpR;
        public RelativeLayout kpS;

        public b(View view) {
            super(view);
            this.fjg = (TextView) view.findViewById(R.id.tv_title);
            this.kpR = (TbImageView) view.findViewById(R.id.tb_imageview_pic);
            this.kpP = (TextView) view.findViewById(R.id.tv_left_watch);
            this.kpQ = (TextView) view.findViewById(R.id.tv_left_agree);
            this.kpM = (ImageView) view.findViewById(R.id.video_play_iv);
            this.kpJ = (TextView) view.findViewById(R.id.text_tv);
            this.kpN = view.findViewById(R.id.gradient_cover);
            this.kpS = (RelativeLayout) view.findViewById(R.id.rl_photo_view);
        }

        void a(SpecialColumnItemData specialColumnItemData) {
            if (specialColumnItemData != null) {
                this.fjg.setText(specialColumnItemData.title);
                this.kpR.setConrers(15);
                this.kpR.setRadius(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10));
                this.kpR.setDrawCorner(true);
                this.kpR.setPlaceHolder(2);
                this.kpR.startLoad(specialColumnItemData.image, 10, false);
                this.kpR.setGifIconSupport(false);
                this.kpQ.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.person_view_item_live_zan_num), au.numberUniformFormatExtra(specialColumnItemData.agree_num)));
                this.kpJ.setText(specialColumnItemData.text);
                if (specialColumnItemData.specialType == 2) {
                    this.kpM.setVisibility(0);
                    this.kpN.setVisibility(0);
                    this.kpN.setAlpha(0.5f);
                    this.kpJ.setVisibility(0);
                    HomePageTabFeedCollegeSecondListAdapter.this.mIconResId = R.drawable.ic_icon_pure_video_play12_svg;
                    this.kpP.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.person_play_num), au.numberUniformFormatExtra(specialColumnItemData.freq_num)));
                    com.baidu.tbadk.core.util.f.a.bty().oP(0).m(R.color.CAM_X0607, R.color.CAM_X0611).oW(l.getDimens(HomePageTabFeedCollegeSecondListAdapter.this.mContext, R.dimen.tbds10)).bv(this.kpN);
                    return;
                }
                this.kpN.setVisibility(8);
                this.kpM.setVisibility(8);
                this.kpJ.setVisibility(8);
                HomePageTabFeedCollegeSecondListAdapter.this.mIconResId = 0;
                this.kpP.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.person_view_num), au.numberUniformFormatExtra(specialColumnItemData.freq_num)));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a extends RecyclerView.ViewHolder {
        public TextView kpJ;
        public TextView kpK;
        public TbImageView kpL;
        public ImageView kpM;
        public View kpN;
        public LinearLayout kpO;

        public a(View view) {
            super(view);
            this.kpL = (TbImageView) view.findViewById(R.id.iv_imageView);
            this.kpM = (ImageView) view.findViewById(R.id.video_play_iv);
            this.kpJ = (TextView) view.findViewById(R.id.text_tv);
            this.kpK = (TextView) view.findViewById(R.id.tv_content);
            this.kpN = view.findViewById(R.id.gradient_cover);
            this.kpO = (LinearLayout) view.findViewById(R.id.ll_live_main);
        }

        void a(SpecialColumnItemData specialColumnItemData) {
            if (specialColumnItemData != null) {
                this.kpK.setText(specialColumnItemData.title);
                this.kpL.setConrers(15);
                this.kpL.setRadius(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10));
                this.kpL.setDrawCorner(true);
                this.kpL.setPlaceHolder(2);
                this.kpL.startLoad(specialColumnItemData.image, 10, false);
                this.kpJ.setText(specialColumnItemData.text);
                this.kpM.setVisibility(0);
                HomePageTabFeedCollegeSecondListAdapter.this.mIconResId = R.drawable.ic_icon_pure_common_live12_svg;
                this.kpN.setAlpha(0.5f);
                com.baidu.tbadk.core.util.f.a.bty().oP(0).oW(l.getDimens(HomePageTabFeedCollegeSecondListAdapter.this.mContext, R.dimen.tbds10)).m(R.color.CAM_X0607, R.color.CAM_X0611).bv(this.kpN);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return y.getCount(this.kpF);
    }

    private SpecialColumnItemData Cc(int i) {
        return (SpecialColumnItemData) y.getItem(this.kpF, i);
    }

    private void c(RecyclerView.ViewHolder viewHolder) {
        if (viewHolder instanceof b) {
            ap.setViewTextColor(((b) viewHolder).fjg, R.color.CAM_X0105);
            ap.setViewTextColor(((b) viewHolder).kpP, R.color.CAM_X0109);
            ap.setViewTextColor(((b) viewHolder).kpQ, R.color.CAM_X0109);
            ap.setViewTextColor(((b) viewHolder).kpJ, R.color.CAM_X0101);
            SvgManager.bsU().a(((b) viewHolder).kpM, this.mIconResId, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL);
            com.baidu.tbadk.core.util.f.a.m(((b) viewHolder).kpS, R.color.CAM_X0205, R.color.CAM_X0204);
        } else if (viewHolder instanceof a) {
            ap.setViewTextColor(((a) viewHolder).kpK, R.color.CAM_X0105);
            ap.setViewTextColor(((a) viewHolder).kpJ, R.color.CAM_X0101);
            SvgManager.bsU().a(((a) viewHolder).kpM, this.mIconResId, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL);
            com.baidu.tbadk.core.util.f.a.m(((a) viewHolder).kpO, R.color.CAM_X0205, R.color.CAM_X0204);
        }
    }

    public void a(f<SpecialColumnItemData> fVar) {
        this.kpG = fVar;
    }
}
