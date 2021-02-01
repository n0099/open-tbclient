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
    private List<SpecialColumnItemData> knp;
    private Context mContext;
    private int mIconResId;
    private f<SpecialColumnItemData> knq = null;
    private final int TYPE_NORMAL = 1;
    private final int TYPE_VIDEO = 2;
    private final int TYPE_LIVE = 3;
    private final int TYPE_LIVE_RE = 4;

    public HomePageTabFeedCollegeSecondListAdapter(Context context, List<SpecialColumnItemData> list) {
        this.mContext = context;
        this.knp = list;
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
        SpecialColumnItemData specialColumnItemData = this.knp.get(i);
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
        final SpecialColumnItemData BZ = BZ(i);
        if (viewHolder instanceof b) {
            ((b) viewHolder).a(BZ);
        } else if (viewHolder instanceof a) {
            ((a) viewHolder).a(BZ);
        }
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.tabfeed.college.HomePageTabFeedCollegeSecondListAdapter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (HomePageTabFeedCollegeSecondListAdapter.this.knq != null) {
                    HomePageTabFeedCollegeSecondListAdapter.this.knq.a(view, BZ, i, i);
                }
            }
        });
        c(viewHolder);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class b extends RecyclerView.ViewHolder {
        public TextView fhE;
        public TextView knA;
        public TbImageView knB;
        public RelativeLayout knC;
        public TextView knt;
        public ImageView knw;
        public View knx;
        public TextView knz;

        public b(View view) {
            super(view);
            this.fhE = (TextView) view.findViewById(R.id.tv_title);
            this.knB = (TbImageView) view.findViewById(R.id.tb_imageview_pic);
            this.knz = (TextView) view.findViewById(R.id.tv_left_watch);
            this.knA = (TextView) view.findViewById(R.id.tv_left_agree);
            this.knw = (ImageView) view.findViewById(R.id.video_play_iv);
            this.knt = (TextView) view.findViewById(R.id.text_tv);
            this.knx = view.findViewById(R.id.gradient_cover);
            this.knC = (RelativeLayout) view.findViewById(R.id.rl_photo_view);
        }

        void a(SpecialColumnItemData specialColumnItemData) {
            if (specialColumnItemData != null) {
                this.fhE.setText(specialColumnItemData.title);
                this.knB.setConrers(15);
                this.knB.setRadius(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10));
                this.knB.setDrawCorner(true);
                this.knB.setPlaceHolder(2);
                this.knB.startLoad(specialColumnItemData.image, 10, false);
                this.knB.setGifIconSupport(false);
                this.knA.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.person_view_item_live_zan_num), au.numberUniformFormatExtra(specialColumnItemData.agree_num)));
                this.knt.setText(specialColumnItemData.text);
                if (specialColumnItemData.specialType == 2) {
                    this.knw.setVisibility(0);
                    this.knx.setVisibility(0);
                    this.knx.setAlpha(0.5f);
                    this.knt.setVisibility(0);
                    HomePageTabFeedCollegeSecondListAdapter.this.mIconResId = R.drawable.ic_icon_pure_video_play12_svg;
                    this.knz.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.person_play_num), au.numberUniformFormatExtra(specialColumnItemData.freq_num)));
                    com.baidu.tbadk.core.util.f.a.btv().oO(0).m(R.color.CAM_X0607, R.color.CAM_X0611).oV(l.getDimens(HomePageTabFeedCollegeSecondListAdapter.this.mContext, R.dimen.tbds10)).bv(this.knx);
                    return;
                }
                this.knx.setVisibility(8);
                this.knw.setVisibility(8);
                this.knt.setVisibility(8);
                HomePageTabFeedCollegeSecondListAdapter.this.mIconResId = 0;
                this.knz.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.person_view_num), au.numberUniformFormatExtra(specialColumnItemData.freq_num)));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a extends RecyclerView.ViewHolder {
        public TextView knt;
        public TextView knu;
        public TbImageView knv;
        public ImageView knw;
        public View knx;
        public LinearLayout kny;

        public a(View view) {
            super(view);
            this.knv = (TbImageView) view.findViewById(R.id.iv_imageView);
            this.knw = (ImageView) view.findViewById(R.id.video_play_iv);
            this.knt = (TextView) view.findViewById(R.id.text_tv);
            this.knu = (TextView) view.findViewById(R.id.tv_content);
            this.knx = view.findViewById(R.id.gradient_cover);
            this.kny = (LinearLayout) view.findViewById(R.id.ll_live_main);
        }

        void a(SpecialColumnItemData specialColumnItemData) {
            if (specialColumnItemData != null) {
                this.knu.setText(specialColumnItemData.title);
                this.knv.setConrers(15);
                this.knv.setRadius(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10));
                this.knv.setDrawCorner(true);
                this.knv.setPlaceHolder(2);
                this.knv.startLoad(specialColumnItemData.image, 10, false);
                this.knt.setText(specialColumnItemData.text);
                this.knw.setVisibility(0);
                HomePageTabFeedCollegeSecondListAdapter.this.mIconResId = R.drawable.ic_icon_pure_common_live12_svg;
                this.knx.setAlpha(0.5f);
                com.baidu.tbadk.core.util.f.a.btv().oO(0).oV(l.getDimens(HomePageTabFeedCollegeSecondListAdapter.this.mContext, R.dimen.tbds10)).m(R.color.CAM_X0607, R.color.CAM_X0611).bv(this.knx);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return y.getCount(this.knp);
    }

    private SpecialColumnItemData BZ(int i) {
        return (SpecialColumnItemData) y.getItem(this.knp, i);
    }

    private void c(RecyclerView.ViewHolder viewHolder) {
        if (viewHolder instanceof b) {
            ap.setViewTextColor(((b) viewHolder).fhE, R.color.CAM_X0105);
            ap.setViewTextColor(((b) viewHolder).knz, R.color.CAM_X0109);
            ap.setViewTextColor(((b) viewHolder).knA, R.color.CAM_X0109);
            ap.setViewTextColor(((b) viewHolder).knt, R.color.CAM_X0101);
            SvgManager.bsR().a(((b) viewHolder).knw, this.mIconResId, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL);
            com.baidu.tbadk.core.util.f.a.m(((b) viewHolder).knC, R.color.CAM_X0205, R.color.CAM_X0204);
        } else if (viewHolder instanceof a) {
            ap.setViewTextColor(((a) viewHolder).knu, R.color.CAM_X0105);
            ap.setViewTextColor(((a) viewHolder).knt, R.color.CAM_X0101);
            SvgManager.bsR().a(((a) viewHolder).knw, this.mIconResId, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL);
            com.baidu.tbadk.core.util.f.a.m(((a) viewHolder).kny, R.color.CAM_X0205, R.color.CAM_X0204);
        }
    }

    public void a(f<SpecialColumnItemData> fVar) {
        this.knq = fVar;
    }
}
