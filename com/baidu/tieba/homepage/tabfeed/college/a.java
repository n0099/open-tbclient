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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.h.f;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.tabfeed.data.SpecialColumnItemData;
import java.util.List;
/* loaded from: classes16.dex */
public class a extends RecyclerView.Adapter {
    private List<SpecialColumnItemData> iDf;
    private Context mContext;
    private int mIconResId;
    private f<SpecialColumnItemData> iDg = null;
    private final int TYPE_NORMAL = 1;
    private final int TYPE_VIDEO = 2;
    private final int TYPE_LIVE = 3;
    private final int TYPE_LIVE_RE = 4;

    public a(Context context, List<SpecialColumnItemData> list) {
        this.mContext = context;
        this.iDf = list;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        if (i == 1 || i == 2) {
            return new b(LayoutInflater.from(this.mContext).inflate(R.layout.layout_item_colleage_second_photo, (ViewGroup) null));
        }
        if (i == 3 || i == 4) {
            return new C0648a(LayoutInflater.from(this.mContext).inflate(R.layout.layout_item_colleage_second_live, (ViewGroup) null));
        }
        return null;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        SpecialColumnItemData specialColumnItemData = this.iDf.get(i);
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
        final SpecialColumnItemData xG = xG(i);
        if (viewHolder instanceof b) {
            ((b) viewHolder).a(xG);
        } else if (viewHolder instanceof C0648a) {
            ((C0648a) viewHolder).a(xG);
        }
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.tabfeed.college.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.iDg != null) {
                    a.this.iDg.a(view, xG, i, i);
                }
            }
        });
        c(viewHolder);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes16.dex */
    public class b extends RecyclerView.ViewHolder {
        public TextView ehD;
        public TextView iDj;
        public ImageView iDm;
        public View iDn;
        public TextView iDp;
        public TextView iDq;
        public TbImageView iDr;
        public RelativeLayout iDs;

        public b(View view) {
            super(view);
            this.ehD = (TextView) view.findViewById(R.id.tv_title);
            this.iDr = (TbImageView) view.findViewById(R.id.tb_imageview_pic);
            this.iDp = (TextView) view.findViewById(R.id.tv_left_watch);
            this.iDq = (TextView) view.findViewById(R.id.tv_left_agree);
            this.iDm = (ImageView) view.findViewById(R.id.video_play_iv);
            this.iDj = (TextView) view.findViewById(R.id.text_tv);
            this.iDn = view.findViewById(R.id.gradient_cover);
            this.iDs = (RelativeLayout) view.findViewById(R.id.rl_photo_view);
        }

        void a(SpecialColumnItemData specialColumnItemData) {
            if (specialColumnItemData != null) {
                this.ehD.setText(specialColumnItemData.title);
                this.iDr.setConrers(15);
                this.iDr.setRadius(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10));
                this.iDr.setDrawCorner(true);
                this.iDr.setPlaceHolder(2);
                this.iDr.startLoad(specialColumnItemData.image, 10, false);
                this.iDr.setGifIconSupport(false);
                this.iDq.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.person_view_item_live_zan_num), as.numberUniformFormatExtra(specialColumnItemData.agree_num)));
                this.iDj.setText(specialColumnItemData.text);
                if (specialColumnItemData.specialType == 2) {
                    this.iDm.setVisibility(0);
                    this.iDn.setVisibility(0);
                    this.iDn.setAlpha(0.5f);
                    this.iDj.setVisibility(0);
                    a.this.mIconResId = R.drawable.ic_icon_pure_video_play12_svg;
                    this.iDp.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.person_play_num), as.numberUniformFormatExtra(specialColumnItemData.freq_num)));
                    com.baidu.tbadk.core.util.e.a.bbr().ma(0).i(R.color.cp_mask_b_alpha50, R.color.cp_mask_b).mf(l.getDimens(a.this.mContext, R.dimen.tbds10)).aX(this.iDn);
                    return;
                }
                this.iDn.setVisibility(8);
                this.iDm.setVisibility(8);
                this.iDj.setVisibility(8);
                a.this.mIconResId = 0;
                this.iDp.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.person_view_num), as.numberUniformFormatExtra(specialColumnItemData.freq_num)));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.homepage.tabfeed.college.a$a  reason: collision with other inner class name */
    /* loaded from: classes16.dex */
    public class C0648a extends RecyclerView.ViewHolder {
        public TextView iDj;
        public TextView iDk;
        public TbImageView iDl;
        public ImageView iDm;
        public View iDn;
        public LinearLayout iDo;

        public C0648a(View view) {
            super(view);
            this.iDl = (TbImageView) view.findViewById(R.id.iv_imageView);
            this.iDm = (ImageView) view.findViewById(R.id.video_play_iv);
            this.iDj = (TextView) view.findViewById(R.id.text_tv);
            this.iDk = (TextView) view.findViewById(R.id.tv_content);
            this.iDn = view.findViewById(R.id.gradient_cover);
            this.iDo = (LinearLayout) view.findViewById(R.id.ll_live_main);
        }

        void a(SpecialColumnItemData specialColumnItemData) {
            if (specialColumnItemData != null) {
                this.iDk.setText(specialColumnItemData.title);
                this.iDl.setConrers(15);
                this.iDl.setRadius(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10));
                this.iDl.setDrawCorner(true);
                this.iDl.setPlaceHolder(2);
                this.iDl.startLoad(specialColumnItemData.image, 10, false);
                this.iDj.setText(specialColumnItemData.text);
                this.iDm.setVisibility(0);
                a.this.mIconResId = R.drawable.ic_icon_pure_common_live12_svg;
                this.iDn.setAlpha(0.5f);
                com.baidu.tbadk.core.util.e.a.bbr().ma(0).mf(l.getDimens(a.this.mContext, R.dimen.tbds10)).i(R.color.cp_mask_b_alpha50, R.color.cp_mask_b).aX(this.iDn);
            }
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        return x.getCount(this.iDf);
    }

    private SpecialColumnItemData xG(int i) {
        return (SpecialColumnItemData) x.getItem(this.iDf, i);
    }

    private void c(RecyclerView.ViewHolder viewHolder) {
        if (viewHolder instanceof b) {
            ao.setViewTextColor(((b) viewHolder).ehD, R.color.cp_cont_b);
            ao.setViewTextColor(((b) viewHolder).iDp, R.color.cp_cont_d);
            ao.setViewTextColor(((b) viewHolder).iDq, R.color.cp_cont_d);
            ao.setViewTextColor(((b) viewHolder).iDj, R.color.cp_cont_a);
            SvgManager.baR().a(((b) viewHolder).iDm, this.mIconResId, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL);
            com.baidu.tbadk.core.util.e.a.h(((b) viewHolder).iDs, R.color.cp_bg_line_e, R.color.cp_bg_line_c);
        } else if (viewHolder instanceof C0648a) {
            ao.setViewTextColor(((C0648a) viewHolder).iDk, R.color.cp_cont_b);
            ao.setViewTextColor(((C0648a) viewHolder).iDj, R.color.cp_cont_a);
            SvgManager.baR().a(((C0648a) viewHolder).iDm, this.mIconResId, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL);
            com.baidu.tbadk.core.util.e.a.h(((C0648a) viewHolder).iDo, R.color.cp_bg_line_e, R.color.cp_bg_line_c);
        }
    }

    public void a(f<SpecialColumnItemData> fVar) {
        this.iDg = fVar;
    }
}
