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
    private List<SpecialColumnItemData> jIl;
    private Context mContext;
    private int mIconResId;
    private f<SpecialColumnItemData> jIm = null;
    private final int TYPE_NORMAL = 1;
    private final int TYPE_VIDEO = 2;
    private final int TYPE_LIVE = 3;
    private final int TYPE_LIVE_RE = 4;

    public a(Context context, List<SpecialColumnItemData> list) {
        this.mContext = context;
        this.jIl = list;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        if (i == 1 || i == 2) {
            return new b(LayoutInflater.from(this.mContext).inflate(R.layout.layout_item_colleage_second_photo, (ViewGroup) null));
        }
        if (i == 3 || i == 4) {
            return new C0744a(LayoutInflater.from(this.mContext).inflate(R.layout.layout_item_colleage_second_live, (ViewGroup) null));
        }
        return null;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        SpecialColumnItemData specialColumnItemData = this.jIl.get(i);
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
        final SpecialColumnItemData BN = BN(i);
        if (viewHolder instanceof b) {
            ((b) viewHolder).a(BN);
        } else if (viewHolder instanceof C0744a) {
            ((C0744a) viewHolder).a(BN);
        }
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.tabfeed.college.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.jIm != null) {
                    a.this.jIm.a(view, BN, i, i);
                }
            }
        });
        c(viewHolder);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes22.dex */
    public class b extends RecyclerView.ViewHolder {
        public TextView eTY;
        public TextView jIp;
        public ImageView jIs;
        public View jIt;
        public TextView jIv;
        public TextView jIw;
        public TbImageView jIx;
        public RelativeLayout jIy;

        public b(View view) {
            super(view);
            this.eTY = (TextView) view.findViewById(R.id.tv_title);
            this.jIx = (TbImageView) view.findViewById(R.id.tb_imageview_pic);
            this.jIv = (TextView) view.findViewById(R.id.tv_left_watch);
            this.jIw = (TextView) view.findViewById(R.id.tv_left_agree);
            this.jIs = (ImageView) view.findViewById(R.id.video_play_iv);
            this.jIp = (TextView) view.findViewById(R.id.text_tv);
            this.jIt = view.findViewById(R.id.gradient_cover);
            this.jIy = (RelativeLayout) view.findViewById(R.id.rl_photo_view);
        }

        void a(SpecialColumnItemData specialColumnItemData) {
            if (specialColumnItemData != null) {
                this.eTY.setText(specialColumnItemData.title);
                this.jIx.setConrers(15);
                this.jIx.setRadius(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10));
                this.jIx.setDrawCorner(true);
                this.jIx.setPlaceHolder(2);
                this.jIx.startLoad(specialColumnItemData.image, 10, false);
                this.jIx.setGifIconSupport(false);
                this.jIw.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.person_view_item_live_zan_num), at.numberUniformFormatExtra(specialColumnItemData.agree_num)));
                this.jIp.setText(specialColumnItemData.text);
                if (specialColumnItemData.specialType == 2) {
                    this.jIs.setVisibility(0);
                    this.jIt.setVisibility(0);
                    this.jIt.setAlpha(0.5f);
                    this.jIp.setVisibility(0);
                    a.this.mIconResId = R.drawable.ic_icon_pure_video_play12_svg;
                    this.jIv.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.person_play_num), at.numberUniformFormatExtra(specialColumnItemData.freq_num)));
                    com.baidu.tbadk.core.util.e.a.brO().pj(0).i(R.color.cp_mask_b_alpha50, R.color.cp_mask_b).pp(l.getDimens(a.this.mContext, R.dimen.tbds10)).bk(this.jIt);
                    return;
                }
                this.jIt.setVisibility(8);
                this.jIs.setVisibility(8);
                this.jIp.setVisibility(8);
                a.this.mIconResId = 0;
                this.jIv.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.person_view_num), at.numberUniformFormatExtra(specialColumnItemData.freq_num)));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.homepage.tabfeed.college.a$a  reason: collision with other inner class name */
    /* loaded from: classes22.dex */
    public class C0744a extends RecyclerView.ViewHolder {
        public TextView jIp;
        public TextView jIq;
        public TbImageView jIr;
        public ImageView jIs;
        public View jIt;
        public LinearLayout jIu;

        public C0744a(View view) {
            super(view);
            this.jIr = (TbImageView) view.findViewById(R.id.iv_imageView);
            this.jIs = (ImageView) view.findViewById(R.id.video_play_iv);
            this.jIp = (TextView) view.findViewById(R.id.text_tv);
            this.jIq = (TextView) view.findViewById(R.id.tv_content);
            this.jIt = view.findViewById(R.id.gradient_cover);
            this.jIu = (LinearLayout) view.findViewById(R.id.ll_live_main);
        }

        void a(SpecialColumnItemData specialColumnItemData) {
            if (specialColumnItemData != null) {
                this.jIq.setText(specialColumnItemData.title);
                this.jIr.setConrers(15);
                this.jIr.setRadius(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10));
                this.jIr.setDrawCorner(true);
                this.jIr.setPlaceHolder(2);
                this.jIr.startLoad(specialColumnItemData.image, 10, false);
                this.jIp.setText(specialColumnItemData.text);
                this.jIs.setVisibility(0);
                a.this.mIconResId = R.drawable.ic_icon_pure_common_live12_svg;
                this.jIt.setAlpha(0.5f);
                com.baidu.tbadk.core.util.e.a.brO().pj(0).pp(l.getDimens(a.this.mContext, R.dimen.tbds10)).i(R.color.cp_mask_b_alpha50, R.color.cp_mask_b).bk(this.jIt);
            }
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        return y.getCount(this.jIl);
    }

    private SpecialColumnItemData BN(int i) {
        return (SpecialColumnItemData) y.getItem(this.jIl, i);
    }

    private void c(RecyclerView.ViewHolder viewHolder) {
        if (viewHolder instanceof b) {
            ap.setViewTextColor(((b) viewHolder).eTY, R.color.cp_cont_b);
            ap.setViewTextColor(((b) viewHolder).jIv, R.color.cp_cont_d);
            ap.setViewTextColor(((b) viewHolder).jIw, R.color.cp_cont_d);
            ap.setViewTextColor(((b) viewHolder).jIp, R.color.cp_cont_a);
            SvgManager.brn().a(((b) viewHolder).jIs, this.mIconResId, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL);
            com.baidu.tbadk.core.util.e.a.g(((b) viewHolder).jIy, R.color.cp_bg_line_e, R.color.cp_bg_line_c);
        } else if (viewHolder instanceof C0744a) {
            ap.setViewTextColor(((C0744a) viewHolder).jIq, R.color.cp_cont_b);
            ap.setViewTextColor(((C0744a) viewHolder).jIp, R.color.cp_cont_a);
            SvgManager.brn().a(((C0744a) viewHolder).jIs, this.mIconResId, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL);
            com.baidu.tbadk.core.util.e.a.g(((C0744a) viewHolder).jIu, R.color.cp_bg_line_e, R.color.cp_bg_line_c);
        }
    }

    public void a(f<SpecialColumnItemData> fVar) {
        this.jIm = fVar;
    }
}
