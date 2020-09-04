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
/* loaded from: classes16.dex */
public class a extends RecyclerView.Adapter {
    private List<SpecialColumnItemData> iSj;
    private Context mContext;
    private int mIconResId;
    private f<SpecialColumnItemData> iSk = null;
    private final int TYPE_NORMAL = 1;
    private final int TYPE_VIDEO = 2;
    private final int TYPE_LIVE = 3;
    private final int TYPE_LIVE_RE = 4;

    public a(Context context, List<SpecialColumnItemData> list) {
        this.mContext = context;
        this.iSj = list;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        if (i == 1 || i == 2) {
            return new b(LayoutInflater.from(this.mContext).inflate(R.layout.layout_item_colleage_second_photo, (ViewGroup) null));
        }
        if (i == 3 || i == 4) {
            return new C0699a(LayoutInflater.from(this.mContext).inflate(R.layout.layout_item_colleage_second_live, (ViewGroup) null));
        }
        return null;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        SpecialColumnItemData specialColumnItemData = this.iSj.get(i);
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
        final SpecialColumnItemData Aa = Aa(i);
        if (viewHolder instanceof b) {
            ((b) viewHolder).a(Aa);
        } else if (viewHolder instanceof C0699a) {
            ((C0699a) viewHolder).a(Aa);
        }
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.tabfeed.college.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.iSk != null) {
                    a.this.iSk.a(view, Aa, i, i);
                }
            }
        });
        c(viewHolder);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes16.dex */
    public class b extends RecyclerView.ViewHolder {
        public TextView ery;
        public TextView iSn;
        public ImageView iSq;
        public View iSr;
        public TextView iSt;
        public TextView iSu;
        public TbImageView iSv;
        public RelativeLayout iSw;

        public b(View view) {
            super(view);
            this.ery = (TextView) view.findViewById(R.id.tv_title);
            this.iSv = (TbImageView) view.findViewById(R.id.tb_imageview_pic);
            this.iSt = (TextView) view.findViewById(R.id.tv_left_watch);
            this.iSu = (TextView) view.findViewById(R.id.tv_left_agree);
            this.iSq = (ImageView) view.findViewById(R.id.video_play_iv);
            this.iSn = (TextView) view.findViewById(R.id.text_tv);
            this.iSr = view.findViewById(R.id.gradient_cover);
            this.iSw = (RelativeLayout) view.findViewById(R.id.rl_photo_view);
        }

        void a(SpecialColumnItemData specialColumnItemData) {
            if (specialColumnItemData != null) {
                this.ery.setText(specialColumnItemData.title);
                this.iSv.setConrers(15);
                this.iSv.setRadius(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10));
                this.iSv.setDrawCorner(true);
                this.iSv.setPlaceHolder(2);
                this.iSv.startLoad(specialColumnItemData.image, 10, false);
                this.iSv.setGifIconSupport(false);
                this.iSu.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.person_view_item_live_zan_num), at.numberUniformFormatExtra(specialColumnItemData.agree_num)));
                this.iSn.setText(specialColumnItemData.text);
                if (specialColumnItemData.specialType == 2) {
                    this.iSq.setVisibility(0);
                    this.iSr.setVisibility(0);
                    this.iSr.setAlpha(0.5f);
                    this.iSn.setVisibility(0);
                    a.this.mIconResId = R.drawable.ic_icon_pure_video_play12_svg;
                    this.iSt.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.person_play_num), at.numberUniformFormatExtra(specialColumnItemData.freq_num)));
                    com.baidu.tbadk.core.util.e.a.bjQ().oe(0).i(R.color.cp_mask_b_alpha50, R.color.cp_mask_b).oj(l.getDimens(a.this.mContext, R.dimen.tbds10)).aZ(this.iSr);
                    return;
                }
                this.iSr.setVisibility(8);
                this.iSq.setVisibility(8);
                this.iSn.setVisibility(8);
                a.this.mIconResId = 0;
                this.iSt.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.person_view_num), at.numberUniformFormatExtra(specialColumnItemData.freq_num)));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.homepage.tabfeed.college.a$a  reason: collision with other inner class name */
    /* loaded from: classes16.dex */
    public class C0699a extends RecyclerView.ViewHolder {
        public TextView iSn;
        public TextView iSo;
        public TbImageView iSp;
        public ImageView iSq;
        public View iSr;
        public LinearLayout iSs;

        public C0699a(View view) {
            super(view);
            this.iSp = (TbImageView) view.findViewById(R.id.iv_imageView);
            this.iSq = (ImageView) view.findViewById(R.id.video_play_iv);
            this.iSn = (TextView) view.findViewById(R.id.text_tv);
            this.iSo = (TextView) view.findViewById(R.id.tv_content);
            this.iSr = view.findViewById(R.id.gradient_cover);
            this.iSs = (LinearLayout) view.findViewById(R.id.ll_live_main);
        }

        void a(SpecialColumnItemData specialColumnItemData) {
            if (specialColumnItemData != null) {
                this.iSo.setText(specialColumnItemData.title);
                this.iSp.setConrers(15);
                this.iSp.setRadius(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10));
                this.iSp.setDrawCorner(true);
                this.iSp.setPlaceHolder(2);
                this.iSp.startLoad(specialColumnItemData.image, 10, false);
                this.iSn.setText(specialColumnItemData.text);
                this.iSq.setVisibility(0);
                a.this.mIconResId = R.drawable.ic_icon_pure_common_live12_svg;
                this.iSr.setAlpha(0.5f);
                com.baidu.tbadk.core.util.e.a.bjQ().oe(0).oj(l.getDimens(a.this.mContext, R.dimen.tbds10)).i(R.color.cp_mask_b_alpha50, R.color.cp_mask_b).aZ(this.iSr);
            }
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        return y.getCount(this.iSj);
    }

    private SpecialColumnItemData Aa(int i) {
        return (SpecialColumnItemData) y.getItem(this.iSj, i);
    }

    private void c(RecyclerView.ViewHolder viewHolder) {
        if (viewHolder instanceof b) {
            ap.setViewTextColor(((b) viewHolder).ery, R.color.cp_cont_b);
            ap.setViewTextColor(((b) viewHolder).iSt, R.color.cp_cont_d);
            ap.setViewTextColor(((b) viewHolder).iSu, R.color.cp_cont_d);
            ap.setViewTextColor(((b) viewHolder).iSn, R.color.cp_cont_a);
            SvgManager.bjq().a(((b) viewHolder).iSq, this.mIconResId, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL);
            com.baidu.tbadk.core.util.e.a.g(((b) viewHolder).iSw, R.color.cp_bg_line_e, R.color.cp_bg_line_c);
        } else if (viewHolder instanceof C0699a) {
            ap.setViewTextColor(((C0699a) viewHolder).iSo, R.color.cp_cont_b);
            ap.setViewTextColor(((C0699a) viewHolder).iSn, R.color.cp_cont_a);
            SvgManager.bjq().a(((C0699a) viewHolder).iSq, this.mIconResId, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL);
            com.baidu.tbadk.core.util.e.a.g(((C0699a) viewHolder).iSs, R.color.cp_bg_line_e, R.color.cp_bg_line_c);
        }
    }

    public void a(f<SpecialColumnItemData> fVar) {
        this.iSk = fVar;
    }
}
