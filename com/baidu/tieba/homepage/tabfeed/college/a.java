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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.h.f;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.tabfeed.data.SpecialColumnItemData;
import java.util.List;
/* loaded from: classes9.dex */
public class a extends RecyclerView.Adapter {
    private List<SpecialColumnItemData> iwZ;
    private Context mContext;
    private int mIconResId;
    private f<SpecialColumnItemData> ixa = null;
    private final int TYPE_NORMAL = 1;
    private final int TYPE_VIDEO = 2;
    private final int TYPE_LIVE = 3;
    private final int TYPE_LIVE_RE = 4;

    public a(Context context, List<SpecialColumnItemData> list) {
        this.mContext = context;
        this.iwZ = list;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        if (i == 1 || i == 2) {
            return new b(LayoutInflater.from(this.mContext).inflate(R.layout.layout_item_colleage_second_photo, (ViewGroup) null));
        }
        if (i == 3 || i == 4) {
            return new C0638a(LayoutInflater.from(this.mContext).inflate(R.layout.layout_item_colleage_second_live, (ViewGroup) null));
        }
        return null;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        SpecialColumnItemData specialColumnItemData = this.iwZ.get(i);
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
        final SpecialColumnItemData xo = xo(i);
        if (viewHolder instanceof b) {
            ((b) viewHolder).a(xo);
        } else if (viewHolder instanceof C0638a) {
            ((C0638a) viewHolder).a(xo);
        }
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.tabfeed.college.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.ixa != null) {
                    a.this.ixa.a(view, xo, i, i);
                }
            }
        });
        c(viewHolder);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public class b extends RecyclerView.ViewHolder {
        public TextView ebr;
        public TextView ixd;
        public ImageView ixg;
        public View ixh;
        public TextView ixj;
        public TextView ixk;
        public TbImageView ixl;
        public RelativeLayout ixm;

        public b(View view) {
            super(view);
            this.ebr = (TextView) view.findViewById(R.id.tv_title);
            this.ixl = (TbImageView) view.findViewById(R.id.tb_imageview_pic);
            this.ixj = (TextView) view.findViewById(R.id.tv_left_watch);
            this.ixk = (TextView) view.findViewById(R.id.tv_left_agree);
            this.ixg = (ImageView) view.findViewById(R.id.video_play_iv);
            this.ixd = (TextView) view.findViewById(R.id.text_tv);
            this.ixh = view.findViewById(R.id.gradient_cover);
            this.ixm = (RelativeLayout) view.findViewById(R.id.rl_photo_view);
        }

        void a(SpecialColumnItemData specialColumnItemData) {
            if (specialColumnItemData != null) {
                this.ebr.setText(specialColumnItemData.title);
                this.ixl.setConrers(15);
                this.ixl.setRadius(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10));
                this.ixl.setDrawCorner(true);
                this.ixl.setPlaceHolder(2);
                this.ixl.startLoad(specialColumnItemData.image, 10, false);
                this.ixl.setGifIconSupport(false);
                this.ixk.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.person_view_item_live_zan_num), ar.numberUniformFormatExtra(specialColumnItemData.agree_num)));
                this.ixd.setText(specialColumnItemData.text);
                if (specialColumnItemData.specialType == 2) {
                    this.ixg.setVisibility(0);
                    this.ixh.setVisibility(0);
                    this.ixh.setAlpha(0.5f);
                    this.ixd.setVisibility(0);
                    a.this.mIconResId = R.drawable.ic_icon_pure_video_play12_svg;
                    this.ixj.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.person_play_num), ar.numberUniformFormatExtra(specialColumnItemData.freq_num)));
                    com.baidu.tbadk.core.util.e.a.aXq().lG(0).i(R.color.cp_mask_b_alpha50, R.color.cp_mask_b).lL(l.getDimens(a.this.mContext, R.dimen.tbds10)).aR(this.ixh);
                    return;
                }
                this.ixh.setVisibility(8);
                this.ixg.setVisibility(8);
                this.ixd.setVisibility(8);
                a.this.mIconResId = 0;
                this.ixj.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.person_view_num), ar.numberUniformFormatExtra(specialColumnItemData.freq_num)));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.homepage.tabfeed.college.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class C0638a extends RecyclerView.ViewHolder {
        public TextView ixd;
        public TextView ixe;
        public TbImageView ixf;
        public ImageView ixg;
        public View ixh;
        public LinearLayout ixi;

        public C0638a(View view) {
            super(view);
            this.ixf = (TbImageView) view.findViewById(R.id.iv_imageView);
            this.ixg = (ImageView) view.findViewById(R.id.video_play_iv);
            this.ixd = (TextView) view.findViewById(R.id.text_tv);
            this.ixe = (TextView) view.findViewById(R.id.tv_content);
            this.ixh = view.findViewById(R.id.gradient_cover);
            this.ixi = (LinearLayout) view.findViewById(R.id.ll_live_main);
        }

        void a(SpecialColumnItemData specialColumnItemData) {
            if (specialColumnItemData != null) {
                this.ixe.setText(specialColumnItemData.title);
                this.ixf.setConrers(15);
                this.ixf.setRadius(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10));
                this.ixf.setDrawCorner(true);
                this.ixf.setPlaceHolder(2);
                this.ixf.startLoad(specialColumnItemData.image, 10, false);
                this.ixd.setText(specialColumnItemData.text);
                this.ixg.setVisibility(0);
                a.this.mIconResId = R.drawable.ic_icon_pure_common_live12_svg;
                this.ixh.setAlpha(0.5f);
                com.baidu.tbadk.core.util.e.a.aXq().lG(0).lL(l.getDimens(a.this.mContext, R.dimen.tbds10)).i(R.color.cp_mask_b_alpha50, R.color.cp_mask_b).aR(this.ixh);
            }
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        return w.getCount(this.iwZ);
    }

    private SpecialColumnItemData xo(int i) {
        return (SpecialColumnItemData) w.getItem(this.iwZ, i);
    }

    private void c(RecyclerView.ViewHolder viewHolder) {
        if (viewHolder instanceof b) {
            an.setViewTextColor(((b) viewHolder).ebr, (int) R.color.cp_cont_b);
            an.setViewTextColor(((b) viewHolder).ixj, (int) R.color.cp_cont_d);
            an.setViewTextColor(((b) viewHolder).ixk, (int) R.color.cp_cont_d);
            an.setViewTextColor(((b) viewHolder).ixd, (int) R.color.cp_cont_a);
            SvgManager.aWQ().a(((b) viewHolder).ixg, this.mIconResId, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL);
            com.baidu.tbadk.core.util.e.a.f(((b) viewHolder).ixm, R.color.cp_bg_line_e, R.color.cp_bg_line_c);
        } else if (viewHolder instanceof C0638a) {
            an.setViewTextColor(((C0638a) viewHolder).ixe, (int) R.color.cp_cont_b);
            an.setViewTextColor(((C0638a) viewHolder).ixd, (int) R.color.cp_cont_a);
            SvgManager.aWQ().a(((C0638a) viewHolder).ixg, this.mIconResId, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL);
            com.baidu.tbadk.core.util.e.a.f(((C0638a) viewHolder).ixi, R.color.cp_bg_line_e, R.color.cp_bg_line_c);
        }
    }

    public void a(f<SpecialColumnItemData> fVar) {
        this.ixa = fVar;
    }
}
