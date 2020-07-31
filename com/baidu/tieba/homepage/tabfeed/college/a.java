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
    private List<SpecialColumnItemData> iDd;
    private Context mContext;
    private int mIconResId;
    private f<SpecialColumnItemData> iDe = null;
    private final int TYPE_NORMAL = 1;
    private final int TYPE_VIDEO = 2;
    private final int TYPE_LIVE = 3;
    private final int TYPE_LIVE_RE = 4;

    public a(Context context, List<SpecialColumnItemData> list) {
        this.mContext = context;
        this.iDd = list;
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
        SpecialColumnItemData specialColumnItemData = this.iDd.get(i);
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
                if (a.this.iDe != null) {
                    a.this.iDe.a(view, xG, i, i);
                }
            }
        });
        c(viewHolder);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes16.dex */
    public class b extends RecyclerView.ViewHolder {
        public TextView ehD;
        public TextView iDh;
        public ImageView iDk;
        public View iDl;
        public TextView iDn;
        public TextView iDo;
        public TbImageView iDp;
        public RelativeLayout iDq;

        public b(View view) {
            super(view);
            this.ehD = (TextView) view.findViewById(R.id.tv_title);
            this.iDp = (TbImageView) view.findViewById(R.id.tb_imageview_pic);
            this.iDn = (TextView) view.findViewById(R.id.tv_left_watch);
            this.iDo = (TextView) view.findViewById(R.id.tv_left_agree);
            this.iDk = (ImageView) view.findViewById(R.id.video_play_iv);
            this.iDh = (TextView) view.findViewById(R.id.text_tv);
            this.iDl = view.findViewById(R.id.gradient_cover);
            this.iDq = (RelativeLayout) view.findViewById(R.id.rl_photo_view);
        }

        void a(SpecialColumnItemData specialColumnItemData) {
            if (specialColumnItemData != null) {
                this.ehD.setText(specialColumnItemData.title);
                this.iDp.setConrers(15);
                this.iDp.setRadius(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10));
                this.iDp.setDrawCorner(true);
                this.iDp.setPlaceHolder(2);
                this.iDp.startLoad(specialColumnItemData.image, 10, false);
                this.iDp.setGifIconSupport(false);
                this.iDo.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.person_view_item_live_zan_num), as.numberUniformFormatExtra(specialColumnItemData.agree_num)));
                this.iDh.setText(specialColumnItemData.text);
                if (specialColumnItemData.specialType == 2) {
                    this.iDk.setVisibility(0);
                    this.iDl.setVisibility(0);
                    this.iDl.setAlpha(0.5f);
                    this.iDh.setVisibility(0);
                    a.this.mIconResId = R.drawable.ic_icon_pure_video_play12_svg;
                    this.iDn.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.person_play_num), as.numberUniformFormatExtra(specialColumnItemData.freq_num)));
                    com.baidu.tbadk.core.util.e.a.bbr().ma(0).i(R.color.cp_mask_b_alpha50, R.color.cp_mask_b).mf(l.getDimens(a.this.mContext, R.dimen.tbds10)).aX(this.iDl);
                    return;
                }
                this.iDl.setVisibility(8);
                this.iDk.setVisibility(8);
                this.iDh.setVisibility(8);
                a.this.mIconResId = 0;
                this.iDn.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.person_view_num), as.numberUniformFormatExtra(specialColumnItemData.freq_num)));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.homepage.tabfeed.college.a$a  reason: collision with other inner class name */
    /* loaded from: classes16.dex */
    public class C0648a extends RecyclerView.ViewHolder {
        public TextView iDh;
        public TextView iDi;
        public TbImageView iDj;
        public ImageView iDk;
        public View iDl;
        public LinearLayout iDm;

        public C0648a(View view) {
            super(view);
            this.iDj = (TbImageView) view.findViewById(R.id.iv_imageView);
            this.iDk = (ImageView) view.findViewById(R.id.video_play_iv);
            this.iDh = (TextView) view.findViewById(R.id.text_tv);
            this.iDi = (TextView) view.findViewById(R.id.tv_content);
            this.iDl = view.findViewById(R.id.gradient_cover);
            this.iDm = (LinearLayout) view.findViewById(R.id.ll_live_main);
        }

        void a(SpecialColumnItemData specialColumnItemData) {
            if (specialColumnItemData != null) {
                this.iDi.setText(specialColumnItemData.title);
                this.iDj.setConrers(15);
                this.iDj.setRadius(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10));
                this.iDj.setDrawCorner(true);
                this.iDj.setPlaceHolder(2);
                this.iDj.startLoad(specialColumnItemData.image, 10, false);
                this.iDh.setText(specialColumnItemData.text);
                this.iDk.setVisibility(0);
                a.this.mIconResId = R.drawable.ic_icon_pure_common_live12_svg;
                this.iDl.setAlpha(0.5f);
                com.baidu.tbadk.core.util.e.a.bbr().ma(0).mf(l.getDimens(a.this.mContext, R.dimen.tbds10)).i(R.color.cp_mask_b_alpha50, R.color.cp_mask_b).aX(this.iDl);
            }
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        return x.getCount(this.iDd);
    }

    private SpecialColumnItemData xG(int i) {
        return (SpecialColumnItemData) x.getItem(this.iDd, i);
    }

    private void c(RecyclerView.ViewHolder viewHolder) {
        if (viewHolder instanceof b) {
            ao.setViewTextColor(((b) viewHolder).ehD, R.color.cp_cont_b);
            ao.setViewTextColor(((b) viewHolder).iDn, R.color.cp_cont_d);
            ao.setViewTextColor(((b) viewHolder).iDo, R.color.cp_cont_d);
            ao.setViewTextColor(((b) viewHolder).iDh, R.color.cp_cont_a);
            SvgManager.baR().a(((b) viewHolder).iDk, this.mIconResId, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL);
            com.baidu.tbadk.core.util.e.a.h(((b) viewHolder).iDq, R.color.cp_bg_line_e, R.color.cp_bg_line_c);
        } else if (viewHolder instanceof C0648a) {
            ao.setViewTextColor(((C0648a) viewHolder).iDi, R.color.cp_cont_b);
            ao.setViewTextColor(((C0648a) viewHolder).iDh, R.color.cp_cont_a);
            SvgManager.baR().a(((C0648a) viewHolder).iDk, this.mIconResId, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL);
            com.baidu.tbadk.core.util.e.a.h(((C0648a) viewHolder).iDm, R.color.cp_bg_line_e, R.color.cp_bg_line_c);
        }
    }

    public void a(f<SpecialColumnItemData> fVar) {
        this.iDe = fVar;
    }
}
