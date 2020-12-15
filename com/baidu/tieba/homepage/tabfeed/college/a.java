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
    private List<SpecialColumnItemData> jWB;
    private Context mContext;
    private int mIconResId;
    private f<SpecialColumnItemData> jWC = null;
    private final int TYPE_NORMAL = 1;
    private final int TYPE_VIDEO = 2;
    private final int TYPE_LIVE = 3;
    private final int TYPE_LIVE_RE = 4;

    public a(Context context, List<SpecialColumnItemData> list) {
        this.mContext = context;
        this.jWB = list;
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
        SpecialColumnItemData specialColumnItemData = this.jWB.get(i);
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
                if (a.this.jWC != null) {
                    a.this.jWC.a(view, Da, i, i);
                }
            }
        });
        c(viewHolder);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes22.dex */
    public class b extends RecyclerView.ViewHolder {
        public TextView fav;
        public TextView jWF;
        public ImageView jWI;
        public View jWJ;
        public TextView jWL;
        public TextView jWM;
        public TbImageView jWN;
        public RelativeLayout jWO;

        public b(View view) {
            super(view);
            this.fav = (TextView) view.findViewById(R.id.tv_title);
            this.jWN = (TbImageView) view.findViewById(R.id.tb_imageview_pic);
            this.jWL = (TextView) view.findViewById(R.id.tv_left_watch);
            this.jWM = (TextView) view.findViewById(R.id.tv_left_agree);
            this.jWI = (ImageView) view.findViewById(R.id.video_play_iv);
            this.jWF = (TextView) view.findViewById(R.id.text_tv);
            this.jWJ = view.findViewById(R.id.gradient_cover);
            this.jWO = (RelativeLayout) view.findViewById(R.id.rl_photo_view);
        }

        void a(SpecialColumnItemData specialColumnItemData) {
            if (specialColumnItemData != null) {
                this.fav.setText(specialColumnItemData.title);
                this.jWN.setConrers(15);
                this.jWN.setRadius(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10));
                this.jWN.setDrawCorner(true);
                this.jWN.setPlaceHolder(2);
                this.jWN.startLoad(specialColumnItemData.image, 10, false);
                this.jWN.setGifIconSupport(false);
                this.jWM.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.person_view_item_live_zan_num), au.numberUniformFormatExtra(specialColumnItemData.agree_num)));
                this.jWF.setText(specialColumnItemData.text);
                if (specialColumnItemData.specialType == 2) {
                    this.jWI.setVisibility(0);
                    this.jWJ.setVisibility(0);
                    this.jWJ.setAlpha(0.5f);
                    this.jWF.setVisibility(0);
                    a.this.mIconResId = R.drawable.ic_icon_pure_video_play12_svg;
                    this.jWL.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.person_play_num), au.numberUniformFormatExtra(specialColumnItemData.freq_num)));
                    com.baidu.tbadk.core.util.e.a.buz().qf(0).l(R.color.CAM_X0607, R.color.CAM_X0611).qm(l.getDimens(a.this.mContext, R.dimen.tbds10)).bq(this.jWJ);
                    return;
                }
                this.jWJ.setVisibility(8);
                this.jWI.setVisibility(8);
                this.jWF.setVisibility(8);
                a.this.mIconResId = 0;
                this.jWL.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.person_view_num), au.numberUniformFormatExtra(specialColumnItemData.freq_num)));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.homepage.tabfeed.college.a$a  reason: collision with other inner class name */
    /* loaded from: classes22.dex */
    public class C0763a extends RecyclerView.ViewHolder {
        public TextView jWF;
        public TextView jWG;
        public TbImageView jWH;
        public ImageView jWI;
        public View jWJ;
        public LinearLayout jWK;

        public C0763a(View view) {
            super(view);
            this.jWH = (TbImageView) view.findViewById(R.id.iv_imageView);
            this.jWI = (ImageView) view.findViewById(R.id.video_play_iv);
            this.jWF = (TextView) view.findViewById(R.id.text_tv);
            this.jWG = (TextView) view.findViewById(R.id.tv_content);
            this.jWJ = view.findViewById(R.id.gradient_cover);
            this.jWK = (LinearLayout) view.findViewById(R.id.ll_live_main);
        }

        void a(SpecialColumnItemData specialColumnItemData) {
            if (specialColumnItemData != null) {
                this.jWG.setText(specialColumnItemData.title);
                this.jWH.setConrers(15);
                this.jWH.setRadius(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10));
                this.jWH.setDrawCorner(true);
                this.jWH.setPlaceHolder(2);
                this.jWH.startLoad(specialColumnItemData.image, 10, false);
                this.jWF.setText(specialColumnItemData.text);
                this.jWI.setVisibility(0);
                a.this.mIconResId = R.drawable.ic_icon_pure_common_live12_svg;
                this.jWJ.setAlpha(0.5f);
                com.baidu.tbadk.core.util.e.a.buz().qf(0).qm(l.getDimens(a.this.mContext, R.dimen.tbds10)).l(R.color.CAM_X0607, R.color.CAM_X0611).bq(this.jWJ);
            }
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        return y.getCount(this.jWB);
    }

    private SpecialColumnItemData Da(int i) {
        return (SpecialColumnItemData) y.getItem(this.jWB, i);
    }

    private void c(RecyclerView.ViewHolder viewHolder) {
        if (viewHolder instanceof b) {
            ap.setViewTextColor(((b) viewHolder).fav, R.color.CAM_X0105);
            ap.setViewTextColor(((b) viewHolder).jWL, R.color.CAM_X0109);
            ap.setViewTextColor(((b) viewHolder).jWM, R.color.CAM_X0109);
            ap.setViewTextColor(((b) viewHolder).jWF, R.color.CAM_X0101);
            SvgManager.btW().a(((b) viewHolder).jWI, this.mIconResId, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL);
            com.baidu.tbadk.core.util.e.a.g(((b) viewHolder).jWO, R.color.CAM_X0205, R.color.CAM_X0204);
        } else if (viewHolder instanceof C0763a) {
            ap.setViewTextColor(((C0763a) viewHolder).jWG, R.color.CAM_X0105);
            ap.setViewTextColor(((C0763a) viewHolder).jWF, R.color.CAM_X0101);
            SvgManager.btW().a(((C0763a) viewHolder).jWI, this.mIconResId, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL);
            com.baidu.tbadk.core.util.e.a.g(((C0763a) viewHolder).jWK, R.color.CAM_X0205, R.color.CAM_X0204);
        }
    }

    public void a(f<SpecialColumnItemData> fVar) {
        this.jWC = fVar;
    }
}
