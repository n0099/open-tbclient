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
/* loaded from: classes22.dex */
public class a extends RecyclerView.Adapter {
    private List<SpecialColumnItemData> jpO;
    private Context mContext;
    private int mIconResId;
    private f<SpecialColumnItemData> jpP = null;
    private final int TYPE_NORMAL = 1;
    private final int TYPE_VIDEO = 2;
    private final int TYPE_LIVE = 3;
    private final int TYPE_LIVE_RE = 4;

    public a(Context context, List<SpecialColumnItemData> list) {
        this.mContext = context;
        this.jpO = list;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        if (i == 1 || i == 2) {
            return new b(LayoutInflater.from(this.mContext).inflate(R.layout.layout_item_colleage_second_photo, (ViewGroup) null));
        }
        if (i == 3 || i == 4) {
            return new C0714a(LayoutInflater.from(this.mContext).inflate(R.layout.layout_item_colleage_second_live, (ViewGroup) null));
        }
        return null;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        SpecialColumnItemData specialColumnItemData = this.jpO.get(i);
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
        final SpecialColumnItemData Bh = Bh(i);
        if (viewHolder instanceof b) {
            ((b) viewHolder).a(Bh);
        } else if (viewHolder instanceof C0714a) {
            ((C0714a) viewHolder).a(Bh);
        }
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.tabfeed.college.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.jpP != null) {
                    a.this.jpP.a(view, Bh, i, i);
                }
            }
        });
        c(viewHolder);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes22.dex */
    public class b extends RecyclerView.ViewHolder {
        public TextView eFN;
        public TextView jpS;
        public ImageView jpV;
        public View jpW;
        public TextView jpY;
        public TextView jpZ;
        public TbImageView jqa;
        public RelativeLayout jqb;

        public b(View view) {
            super(view);
            this.eFN = (TextView) view.findViewById(R.id.tv_title);
            this.jqa = (TbImageView) view.findViewById(R.id.tb_imageview_pic);
            this.jpY = (TextView) view.findViewById(R.id.tv_left_watch);
            this.jpZ = (TextView) view.findViewById(R.id.tv_left_agree);
            this.jpV = (ImageView) view.findViewById(R.id.video_play_iv);
            this.jpS = (TextView) view.findViewById(R.id.text_tv);
            this.jpW = view.findViewById(R.id.gradient_cover);
            this.jqb = (RelativeLayout) view.findViewById(R.id.rl_photo_view);
        }

        void a(SpecialColumnItemData specialColumnItemData) {
            if (specialColumnItemData != null) {
                this.eFN.setText(specialColumnItemData.title);
                this.jqa.setConrers(15);
                this.jqa.setRadius(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10));
                this.jqa.setDrawCorner(true);
                this.jqa.setPlaceHolder(2);
                this.jqa.startLoad(specialColumnItemData.image, 10, false);
                this.jqa.setGifIconSupport(false);
                this.jpZ.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.person_view_item_live_zan_num), at.numberUniformFormatExtra(specialColumnItemData.agree_num)));
                this.jpS.setText(specialColumnItemData.text);
                if (specialColumnItemData.specialType == 2) {
                    this.jpV.setVisibility(0);
                    this.jpW.setVisibility(0);
                    this.jpW.setAlpha(0.5f);
                    this.jpS.setVisibility(0);
                    a.this.mIconResId = R.drawable.ic_icon_pure_video_play12_svg;
                    this.jpY.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.person_play_num), at.numberUniformFormatExtra(specialColumnItemData.freq_num)));
                    com.baidu.tbadk.core.util.e.a.bnv().oO(0).i(R.color.cp_mask_b_alpha50, R.color.cp_mask_b).oT(l.getDimens(a.this.mContext, R.dimen.tbds10)).bf(this.jpW);
                    return;
                }
                this.jpW.setVisibility(8);
                this.jpV.setVisibility(8);
                this.jpS.setVisibility(8);
                a.this.mIconResId = 0;
                this.jpY.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.person_view_num), at.numberUniformFormatExtra(specialColumnItemData.freq_num)));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.homepage.tabfeed.college.a$a  reason: collision with other inner class name */
    /* loaded from: classes22.dex */
    public class C0714a extends RecyclerView.ViewHolder {
        public TextView jpS;
        public TextView jpT;
        public TbImageView jpU;
        public ImageView jpV;
        public View jpW;
        public LinearLayout jpX;

        public C0714a(View view) {
            super(view);
            this.jpU = (TbImageView) view.findViewById(R.id.iv_imageView);
            this.jpV = (ImageView) view.findViewById(R.id.video_play_iv);
            this.jpS = (TextView) view.findViewById(R.id.text_tv);
            this.jpT = (TextView) view.findViewById(R.id.tv_content);
            this.jpW = view.findViewById(R.id.gradient_cover);
            this.jpX = (LinearLayout) view.findViewById(R.id.ll_live_main);
        }

        void a(SpecialColumnItemData specialColumnItemData) {
            if (specialColumnItemData != null) {
                this.jpT.setText(specialColumnItemData.title);
                this.jpU.setConrers(15);
                this.jpU.setRadius(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10));
                this.jpU.setDrawCorner(true);
                this.jpU.setPlaceHolder(2);
                this.jpU.startLoad(specialColumnItemData.image, 10, false);
                this.jpS.setText(specialColumnItemData.text);
                this.jpV.setVisibility(0);
                a.this.mIconResId = R.drawable.ic_icon_pure_common_live12_svg;
                this.jpW.setAlpha(0.5f);
                com.baidu.tbadk.core.util.e.a.bnv().oO(0).oT(l.getDimens(a.this.mContext, R.dimen.tbds10)).i(R.color.cp_mask_b_alpha50, R.color.cp_mask_b).bf(this.jpW);
            }
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        return y.getCount(this.jpO);
    }

    private SpecialColumnItemData Bh(int i) {
        return (SpecialColumnItemData) y.getItem(this.jpO, i);
    }

    private void c(RecyclerView.ViewHolder viewHolder) {
        if (viewHolder instanceof b) {
            ap.setViewTextColor(((b) viewHolder).eFN, R.color.cp_cont_b);
            ap.setViewTextColor(((b) viewHolder).jpY, R.color.cp_cont_d);
            ap.setViewTextColor(((b) viewHolder).jpZ, R.color.cp_cont_d);
            ap.setViewTextColor(((b) viewHolder).jpS, R.color.cp_cont_a);
            SvgManager.bmU().a(((b) viewHolder).jpV, this.mIconResId, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL);
            com.baidu.tbadk.core.util.e.a.g(((b) viewHolder).jqb, R.color.cp_bg_line_e, R.color.cp_bg_line_c);
        } else if (viewHolder instanceof C0714a) {
            ap.setViewTextColor(((C0714a) viewHolder).jpT, R.color.cp_cont_b);
            ap.setViewTextColor(((C0714a) viewHolder).jpS, R.color.cp_cont_a);
            SvgManager.bmU().a(((C0714a) viewHolder).jpV, this.mIconResId, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL);
            com.baidu.tbadk.core.util.e.a.g(((C0714a) viewHolder).jpX, R.color.cp_bg_line_e, R.color.cp_bg_line_c);
        }
    }

    public void a(f<SpecialColumnItemData> fVar) {
        this.jpP = fVar;
    }
}
