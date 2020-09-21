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
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.h.f;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.tabfeed.data.SpecialColumnItemData;
import java.util.List;
/* loaded from: classes21.dex */
public class a extends RecyclerView.Adapter {
    private List<SpecialColumnItemData> jaP;
    private Context mContext;
    private int mIconResId;
    private f<SpecialColumnItemData> jaQ = null;
    private final int TYPE_NORMAL = 1;
    private final int TYPE_VIDEO = 2;
    private final int TYPE_LIVE = 3;
    private final int TYPE_LIVE_RE = 4;

    public a(Context context, List<SpecialColumnItemData> list) {
        this.mContext = context;
        this.jaP = list;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        if (i == 1 || i == 2) {
            return new b(LayoutInflater.from(this.mContext).inflate(R.layout.layout_item_colleage_second_photo, (ViewGroup) null));
        }
        if (i == 3 || i == 4) {
            return new C0696a(LayoutInflater.from(this.mContext).inflate(R.layout.layout_item_colleage_second_live, (ViewGroup) null));
        }
        return null;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        SpecialColumnItemData specialColumnItemData = this.jaP.get(i);
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
        final SpecialColumnItemData AB = AB(i);
        if (viewHolder instanceof b) {
            ((b) viewHolder).a(AB);
        } else if (viewHolder instanceof C0696a) {
            ((C0696a) viewHolder).a(AB);
        }
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.tabfeed.college.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.jaQ != null) {
                    a.this.jaQ.a(view, AB, i, i);
                }
            }
        });
        c(viewHolder);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes21.dex */
    public class b extends RecyclerView.ViewHolder {
        public TextView etD;
        public TextView jaT;
        public ImageView jaW;
        public View jaX;
        public TextView jaZ;
        public TextView jba;
        public TbImageView jbb;
        public RelativeLayout jbc;

        public b(View view) {
            super(view);
            this.etD = (TextView) view.findViewById(R.id.tv_title);
            this.jbb = (TbImageView) view.findViewById(R.id.tb_imageview_pic);
            this.jaZ = (TextView) view.findViewById(R.id.tv_left_watch);
            this.jba = (TextView) view.findViewById(R.id.tv_left_agree);
            this.jaW = (ImageView) view.findViewById(R.id.video_play_iv);
            this.jaT = (TextView) view.findViewById(R.id.text_tv);
            this.jaX = view.findViewById(R.id.gradient_cover);
            this.jbc = (RelativeLayout) view.findViewById(R.id.rl_photo_view);
        }

        void a(SpecialColumnItemData specialColumnItemData) {
            if (specialColumnItemData != null) {
                this.etD.setText(specialColumnItemData.title);
                this.jbb.setConrers(15);
                this.jbb.setRadius(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10));
                this.jbb.setDrawCorner(true);
                this.jbb.setPlaceHolder(2);
                this.jbb.startLoad(specialColumnItemData.image, 10, false);
                this.jbb.setGifIconSupport(false);
                this.jba.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.person_view_item_live_zan_num), at.numberUniformFormatExtra(specialColumnItemData.agree_num)));
                this.jaT.setText(specialColumnItemData.text);
                if (specialColumnItemData.specialType == 2) {
                    this.jaW.setVisibility(0);
                    this.jaX.setVisibility(0);
                    this.jaX.setAlpha(0.5f);
                    this.jaT.setVisibility(0);
                    a.this.mIconResId = R.drawable.ic_icon_pure_video_play12_svg;
                    this.jaZ.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.person_play_num), at.numberUniformFormatExtra(specialColumnItemData.freq_num)));
                    com.baidu.tbadk.core.util.e.a.bkL().oq(0).i(R.color.cp_mask_b_alpha50, R.color.cp_mask_b).ov(l.getDimens(a.this.mContext, R.dimen.tbds10)).bb(this.jaX);
                    return;
                }
                this.jaX.setVisibility(8);
                this.jaW.setVisibility(8);
                this.jaT.setVisibility(8);
                a.this.mIconResId = 0;
                this.jaZ.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.person_view_num), at.numberUniformFormatExtra(specialColumnItemData.freq_num)));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.homepage.tabfeed.college.a$a  reason: collision with other inner class name */
    /* loaded from: classes21.dex */
    public class C0696a extends RecyclerView.ViewHolder {
        public TextView jaT;
        public TextView jaU;
        public TbImageView jaV;
        public ImageView jaW;
        public View jaX;
        public LinearLayout jaY;

        public C0696a(View view) {
            super(view);
            this.jaV = (TbImageView) view.findViewById(R.id.iv_imageView);
            this.jaW = (ImageView) view.findViewById(R.id.video_play_iv);
            this.jaT = (TextView) view.findViewById(R.id.text_tv);
            this.jaU = (TextView) view.findViewById(R.id.tv_content);
            this.jaX = view.findViewById(R.id.gradient_cover);
            this.jaY = (LinearLayout) view.findViewById(R.id.ll_live_main);
        }

        void a(SpecialColumnItemData specialColumnItemData) {
            if (specialColumnItemData != null) {
                this.jaU.setText(specialColumnItemData.title);
                this.jaV.setConrers(15);
                this.jaV.setRadius(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10));
                this.jaV.setDrawCorner(true);
                this.jaV.setPlaceHolder(2);
                this.jaV.startLoad(specialColumnItemData.image, 10, false);
                this.jaT.setText(specialColumnItemData.text);
                this.jaW.setVisibility(0);
                a.this.mIconResId = R.drawable.ic_icon_pure_common_live12_svg;
                this.jaX.setAlpha(0.5f);
                com.baidu.tbadk.core.util.e.a.bkL().oq(0).ov(l.getDimens(a.this.mContext, R.dimen.tbds10)).i(R.color.cp_mask_b_alpha50, R.color.cp_mask_b).bb(this.jaX);
            }
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        return y.getCount(this.jaP);
    }

    private SpecialColumnItemData AB(int i) {
        return (SpecialColumnItemData) y.getItem(this.jaP, i);
    }

    private void c(RecyclerView.ViewHolder viewHolder) {
        if (viewHolder instanceof b) {
            ap.setViewTextColor(((b) viewHolder).etD, R.color.cp_cont_b);
            ap.setViewTextColor(((b) viewHolder).jaZ, R.color.cp_cont_d);
            ap.setViewTextColor(((b) viewHolder).jba, R.color.cp_cont_d);
            ap.setViewTextColor(((b) viewHolder).jaT, R.color.cp_cont_a);
            SvgManager.bkl().a(((b) viewHolder).jaW, this.mIconResId, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL);
            com.baidu.tbadk.core.util.e.a.g(((b) viewHolder).jbc, R.color.cp_bg_line_e, R.color.cp_bg_line_c);
        } else if (viewHolder instanceof C0696a) {
            ap.setViewTextColor(((C0696a) viewHolder).jaU, R.color.cp_cont_b);
            ap.setViewTextColor(((C0696a) viewHolder).jaT, R.color.cp_cont_a);
            SvgManager.bkl().a(((C0696a) viewHolder).jaW, this.mIconResId, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL);
            com.baidu.tbadk.core.util.e.a.g(((C0696a) viewHolder).jaY, R.color.cp_bg_line_e, R.color.cp_bg_line_c);
        }
    }

    public void a(f<SpecialColumnItemData> fVar) {
        this.jaQ = fVar;
    }
}
