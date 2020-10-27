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
    private List<SpecialColumnItemData> jCo;
    private Context mContext;
    private int mIconResId;
    private f<SpecialColumnItemData> jCp = null;
    private final int TYPE_NORMAL = 1;
    private final int TYPE_VIDEO = 2;
    private final int TYPE_LIVE = 3;
    private final int TYPE_LIVE_RE = 4;

    public a(Context context, List<SpecialColumnItemData> list) {
        this.mContext = context;
        this.jCo = list;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        if (i == 1 || i == 2) {
            return new b(LayoutInflater.from(this.mContext).inflate(R.layout.layout_item_colleage_second_photo, (ViewGroup) null));
        }
        if (i == 3 || i == 4) {
            return new C0730a(LayoutInflater.from(this.mContext).inflate(R.layout.layout_item_colleage_second_live, (ViewGroup) null));
        }
        return null;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        SpecialColumnItemData specialColumnItemData = this.jCo.get(i);
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
        final SpecialColumnItemData BA = BA(i);
        if (viewHolder instanceof b) {
            ((b) viewHolder).a(BA);
        } else if (viewHolder instanceof C0730a) {
            ((C0730a) viewHolder).a(BA);
        }
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.tabfeed.college.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.jCp != null) {
                    a.this.jCp.a(view, BA, i, i);
                }
            }
        });
        c(viewHolder);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes22.dex */
    public class b extends RecyclerView.ViewHolder {
        public TextView eOj;
        public TbImageView jCA;
        public RelativeLayout jCB;
        public TextView jCs;
        public ImageView jCv;
        public View jCw;
        public TextView jCy;
        public TextView jCz;

        public b(View view) {
            super(view);
            this.eOj = (TextView) view.findViewById(R.id.tv_title);
            this.jCA = (TbImageView) view.findViewById(R.id.tb_imageview_pic);
            this.jCy = (TextView) view.findViewById(R.id.tv_left_watch);
            this.jCz = (TextView) view.findViewById(R.id.tv_left_agree);
            this.jCv = (ImageView) view.findViewById(R.id.video_play_iv);
            this.jCs = (TextView) view.findViewById(R.id.text_tv);
            this.jCw = view.findViewById(R.id.gradient_cover);
            this.jCB = (RelativeLayout) view.findViewById(R.id.rl_photo_view);
        }

        void a(SpecialColumnItemData specialColumnItemData) {
            if (specialColumnItemData != null) {
                this.eOj.setText(specialColumnItemData.title);
                this.jCA.setConrers(15);
                this.jCA.setRadius(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10));
                this.jCA.setDrawCorner(true);
                this.jCA.setPlaceHolder(2);
                this.jCA.startLoad(specialColumnItemData.image, 10, false);
                this.jCA.setGifIconSupport(false);
                this.jCz.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.person_view_item_live_zan_num), at.numberUniformFormatExtra(specialColumnItemData.agree_num)));
                this.jCs.setText(specialColumnItemData.text);
                if (specialColumnItemData.specialType == 2) {
                    this.jCv.setVisibility(0);
                    this.jCw.setVisibility(0);
                    this.jCw.setAlpha(0.5f);
                    this.jCs.setVisibility(0);
                    a.this.mIconResId = R.drawable.ic_icon_pure_video_play12_svg;
                    this.jCy.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.person_play_num), at.numberUniformFormatExtra(specialColumnItemData.freq_num)));
                    com.baidu.tbadk.core.util.e.a.bpo().oZ(0).i(R.color.cp_mask_b_alpha50, R.color.cp_mask_b).pe(l.getDimens(a.this.mContext, R.dimen.tbds10)).bg(this.jCw);
                    return;
                }
                this.jCw.setVisibility(8);
                this.jCv.setVisibility(8);
                this.jCs.setVisibility(8);
                a.this.mIconResId = 0;
                this.jCy.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.person_view_num), at.numberUniformFormatExtra(specialColumnItemData.freq_num)));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.homepage.tabfeed.college.a$a  reason: collision with other inner class name */
    /* loaded from: classes22.dex */
    public class C0730a extends RecyclerView.ViewHolder {
        public TextView jCs;
        public TextView jCt;
        public TbImageView jCu;
        public ImageView jCv;
        public View jCw;
        public LinearLayout jCx;

        public C0730a(View view) {
            super(view);
            this.jCu = (TbImageView) view.findViewById(R.id.iv_imageView);
            this.jCv = (ImageView) view.findViewById(R.id.video_play_iv);
            this.jCs = (TextView) view.findViewById(R.id.text_tv);
            this.jCt = (TextView) view.findViewById(R.id.tv_content);
            this.jCw = view.findViewById(R.id.gradient_cover);
            this.jCx = (LinearLayout) view.findViewById(R.id.ll_live_main);
        }

        void a(SpecialColumnItemData specialColumnItemData) {
            if (specialColumnItemData != null) {
                this.jCt.setText(specialColumnItemData.title);
                this.jCu.setConrers(15);
                this.jCu.setRadius(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10));
                this.jCu.setDrawCorner(true);
                this.jCu.setPlaceHolder(2);
                this.jCu.startLoad(specialColumnItemData.image, 10, false);
                this.jCs.setText(specialColumnItemData.text);
                this.jCv.setVisibility(0);
                a.this.mIconResId = R.drawable.ic_icon_pure_common_live12_svg;
                this.jCw.setAlpha(0.5f);
                com.baidu.tbadk.core.util.e.a.bpo().oZ(0).pe(l.getDimens(a.this.mContext, R.dimen.tbds10)).i(R.color.cp_mask_b_alpha50, R.color.cp_mask_b).bg(this.jCw);
            }
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        return y.getCount(this.jCo);
    }

    private SpecialColumnItemData BA(int i) {
        return (SpecialColumnItemData) y.getItem(this.jCo, i);
    }

    private void c(RecyclerView.ViewHolder viewHolder) {
        if (viewHolder instanceof b) {
            ap.setViewTextColor(((b) viewHolder).eOj, R.color.cp_cont_b);
            ap.setViewTextColor(((b) viewHolder).jCy, R.color.cp_cont_d);
            ap.setViewTextColor(((b) viewHolder).jCz, R.color.cp_cont_d);
            ap.setViewTextColor(((b) viewHolder).jCs, R.color.cp_cont_a);
            SvgManager.boN().a(((b) viewHolder).jCv, this.mIconResId, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL);
            com.baidu.tbadk.core.util.e.a.g(((b) viewHolder).jCB, R.color.cp_bg_line_e, R.color.cp_bg_line_c);
        } else if (viewHolder instanceof C0730a) {
            ap.setViewTextColor(((C0730a) viewHolder).jCt, R.color.cp_cont_b);
            ap.setViewTextColor(((C0730a) viewHolder).jCs, R.color.cp_cont_a);
            SvgManager.boN().a(((C0730a) viewHolder).jCv, this.mIconResId, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL);
            com.baidu.tbadk.core.util.e.a.g(((C0730a) viewHolder).jCx, R.color.cp_bg_line_e, R.color.cp_bg_line_c);
        }
    }

    public void a(f<SpecialColumnItemData> fVar) {
        this.jCp = fVar;
    }
}
