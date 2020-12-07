package com.baidu.tieba.homepage.tabfeed.college;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
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
/* loaded from: classes22.dex */
public class a extends RecyclerView.Adapter {
    private List<SpecialColumnItemData> jWz;
    private Context mContext;
    private int mIconResId;
    private f<SpecialColumnItemData> jWA = null;
    private final int TYPE_NORMAL = 1;
    private final int TYPE_VIDEO = 2;
    private final int TYPE_LIVE = 3;
    private final int TYPE_LIVE_RE = 4;

    public a(Context context, List<SpecialColumnItemData> list) {
        this.mContext = context;
        this.jWz = list;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        if (i == 1 || i == 2) {
            return new b(LayoutInflater.from(this.mContext).inflate(R.layout.layout_item_colleage_second_photo, (ViewGroup) null));
        }
        if (i == 3 || i == 4) {
            return new C0763a(LayoutInflater.from(this.mContext).inflate(R.layout.layout_item_colleage_second_live, (ViewGroup) null));
        }
        return null;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        SpecialColumnItemData specialColumnItemData = this.jWz.get(i);
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

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, final int i) {
        final SpecialColumnItemData Da = Da(i);
        if (viewHolder instanceof b) {
            ((b) viewHolder).a(Da);
        } else if (viewHolder instanceof C0763a) {
            ((C0763a) viewHolder).a(Da);
        }
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.tabfeed.college.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.jWA != null) {
                    a.this.jWA.a(view, Da, i, i);
                }
            }
        });
        c(viewHolder);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes22.dex */
    public class b extends RecyclerView.ViewHolder {
        public TextView fav;
        public TextView jWD;
        public ImageView jWG;
        public View jWH;
        public TextView jWJ;
        public TextView jWK;
        public TbImageView jWL;
        public RelativeLayout jWM;

        public b(View view) {
            super(view);
            this.fav = (TextView) view.findViewById(R.id.tv_title);
            this.jWL = (TbImageView) view.findViewById(R.id.tb_imageview_pic);
            this.jWJ = (TextView) view.findViewById(R.id.tv_left_watch);
            this.jWK = (TextView) view.findViewById(R.id.tv_left_agree);
            this.jWG = (ImageView) view.findViewById(R.id.video_play_iv);
            this.jWD = (TextView) view.findViewById(R.id.text_tv);
            this.jWH = view.findViewById(R.id.gradient_cover);
            this.jWM = (RelativeLayout) view.findViewById(R.id.rl_photo_view);
        }

        void a(SpecialColumnItemData specialColumnItemData) {
            if (specialColumnItemData != null) {
                this.fav.setText(specialColumnItemData.title);
                this.jWL.setConrers(15);
                this.jWL.setRadius(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10));
                this.jWL.setDrawCorner(true);
                this.jWL.setPlaceHolder(2);
                this.jWL.startLoad(specialColumnItemData.image, 10, false);
                this.jWL.setGifIconSupport(false);
                this.jWK.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.person_view_item_live_zan_num), au.numberUniformFormatExtra(specialColumnItemData.agree_num)));
                this.jWD.setText(specialColumnItemData.text);
                if (specialColumnItemData.specialType == 2) {
                    this.jWG.setVisibility(0);
                    this.jWH.setVisibility(0);
                    this.jWH.setAlpha(0.5f);
                    this.jWD.setVisibility(0);
                    a.this.mIconResId = R.drawable.ic_icon_pure_video_play12_svg;
                    this.jWJ.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.person_play_num), au.numberUniformFormatExtra(specialColumnItemData.freq_num)));
                    com.baidu.tbadk.core.util.e.a.buz().qf(0).l(R.color.CAM_X0607, R.color.CAM_X0611).qm(l.getDimens(a.this.mContext, R.dimen.tbds10)).bq(this.jWH);
                    return;
                }
                this.jWH.setVisibility(8);
                this.jWG.setVisibility(8);
                this.jWD.setVisibility(8);
                a.this.mIconResId = 0;
                this.jWJ.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.person_view_num), au.numberUniformFormatExtra(specialColumnItemData.freq_num)));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.homepage.tabfeed.college.a$a  reason: collision with other inner class name */
    /* loaded from: classes22.dex */
    public class C0763a extends RecyclerView.ViewHolder {
        public TextView jWD;
        public TextView jWE;
        public TbImageView jWF;
        public ImageView jWG;
        public View jWH;
        public LinearLayout jWI;

        public C0763a(View view) {
            super(view);
            this.jWF = (TbImageView) view.findViewById(R.id.iv_imageView);
            this.jWG = (ImageView) view.findViewById(R.id.video_play_iv);
            this.jWD = (TextView) view.findViewById(R.id.text_tv);
            this.jWE = (TextView) view.findViewById(R.id.tv_content);
            this.jWH = view.findViewById(R.id.gradient_cover);
            this.jWI = (LinearLayout) view.findViewById(R.id.ll_live_main);
        }

        void a(SpecialColumnItemData specialColumnItemData) {
            if (specialColumnItemData != null) {
                this.jWE.setText(specialColumnItemData.title);
                this.jWF.setConrers(15);
                this.jWF.setRadius(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10));
                this.jWF.setDrawCorner(true);
                this.jWF.setPlaceHolder(2);
                this.jWF.startLoad(specialColumnItemData.image, 10, false);
                this.jWD.setText(specialColumnItemData.text);
                this.jWG.setVisibility(0);
                a.this.mIconResId = R.drawable.ic_icon_pure_common_live12_svg;
                this.jWH.setAlpha(0.5f);
                com.baidu.tbadk.core.util.e.a.buz().qf(0).qm(l.getDimens(a.this.mContext, R.dimen.tbds10)).l(R.color.CAM_X0607, R.color.CAM_X0611).bq(this.jWH);
            }
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        return y.getCount(this.jWz);
    }

    private SpecialColumnItemData Da(int i) {
        return (SpecialColumnItemData) y.getItem(this.jWz, i);
    }

    private void c(RecyclerView.ViewHolder viewHolder) {
        if (viewHolder instanceof b) {
            ap.setViewTextColor(((b) viewHolder).fav, R.color.CAM_X0105);
            ap.setViewTextColor(((b) viewHolder).jWJ, R.color.CAM_X0109);
            ap.setViewTextColor(((b) viewHolder).jWK, R.color.CAM_X0109);
            ap.setViewTextColor(((b) viewHolder).jWD, R.color.CAM_X0101);
            SvgManager.btW().a(((b) viewHolder).jWG, this.mIconResId, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL);
            com.baidu.tbadk.core.util.e.a.g(((b) viewHolder).jWM, R.color.CAM_X0205, R.color.CAM_X0204);
        } else if (viewHolder instanceof C0763a) {
            ap.setViewTextColor(((C0763a) viewHolder).jWE, R.color.CAM_X0105);
            ap.setViewTextColor(((C0763a) viewHolder).jWD, R.color.CAM_X0101);
            SvgManager.btW().a(((C0763a) viewHolder).jWG, this.mIconResId, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL);
            com.baidu.tbadk.core.util.e.a.g(((C0763a) viewHolder).jWI, R.color.CAM_X0205, R.color.CAM_X0204);
        }
    }

    public void a(f<SpecialColumnItemData> fVar) {
        this.jWA = fVar;
    }
}
