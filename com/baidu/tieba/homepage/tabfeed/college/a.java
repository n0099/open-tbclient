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
/* loaded from: classes21.dex */
public class a extends RecyclerView.Adapter {
    private List<SpecialColumnItemData> jIW;
    private Context mContext;
    private int mIconResId;
    private f<SpecialColumnItemData> jIX = null;
    private final int TYPE_NORMAL = 1;
    private final int TYPE_VIDEO = 2;
    private final int TYPE_LIVE = 3;
    private final int TYPE_LIVE_RE = 4;

    public a(Context context, List<SpecialColumnItemData> list) {
        this.mContext = context;
        this.jIW = list;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        if (i == 1 || i == 2) {
            return new b(LayoutInflater.from(this.mContext).inflate(R.layout.layout_item_colleage_second_photo, (ViewGroup) null));
        }
        if (i == 3 || i == 4) {
            return new C0747a(LayoutInflater.from(this.mContext).inflate(R.layout.layout_item_colleage_second_live, (ViewGroup) null));
        }
        return null;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        SpecialColumnItemData specialColumnItemData = this.jIW.get(i);
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
        final SpecialColumnItemData Cl = Cl(i);
        if (viewHolder instanceof b) {
            ((b) viewHolder).a(Cl);
        } else if (viewHolder instanceof C0747a) {
            ((C0747a) viewHolder).a(Cl);
        }
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.tabfeed.college.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.jIX != null) {
                    a.this.jIX.a(view, Cl, i, i);
                }
            }
        });
        c(viewHolder);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes21.dex */
    public class b extends RecyclerView.ViewHolder {
        public TextView eTa;
        public TextView jJa;
        public ImageView jJd;
        public View jJe;
        public TextView jJg;
        public TextView jJh;
        public TbImageView jJi;
        public RelativeLayout jJj;

        public b(View view) {
            super(view);
            this.eTa = (TextView) view.findViewById(R.id.tv_title);
            this.jJi = (TbImageView) view.findViewById(R.id.tb_imageview_pic);
            this.jJg = (TextView) view.findViewById(R.id.tv_left_watch);
            this.jJh = (TextView) view.findViewById(R.id.tv_left_agree);
            this.jJd = (ImageView) view.findViewById(R.id.video_play_iv);
            this.jJa = (TextView) view.findViewById(R.id.text_tv);
            this.jJe = view.findViewById(R.id.gradient_cover);
            this.jJj = (RelativeLayout) view.findViewById(R.id.rl_photo_view);
        }

        void a(SpecialColumnItemData specialColumnItemData) {
            if (specialColumnItemData != null) {
                this.eTa.setText(specialColumnItemData.title);
                this.jJi.setConrers(15);
                this.jJi.setRadius(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10));
                this.jJi.setDrawCorner(true);
                this.jJi.setPlaceHolder(2);
                this.jJi.startLoad(specialColumnItemData.image, 10, false);
                this.jJi.setGifIconSupport(false);
                this.jJh.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.person_view_item_live_zan_num), au.numberUniformFormatExtra(specialColumnItemData.agree_num)));
                this.jJa.setText(specialColumnItemData.text);
                if (specialColumnItemData.specialType == 2) {
                    this.jJd.setVisibility(0);
                    this.jJe.setVisibility(0);
                    this.jJe.setAlpha(0.5f);
                    this.jJa.setVisibility(0);
                    a.this.mIconResId = R.drawable.ic_icon_pure_video_play12_svg;
                    this.jJg.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.person_play_num), au.numberUniformFormatExtra(specialColumnItemData.freq_num)));
                    com.baidu.tbadk.core.util.e.a.brc().pF(0).l(R.color.CAM_X0607, R.color.CAM_X0611).pM(l.getDimens(a.this.mContext, R.dimen.tbds10)).bn(this.jJe);
                    return;
                }
                this.jJe.setVisibility(8);
                this.jJd.setVisibility(8);
                this.jJa.setVisibility(8);
                a.this.mIconResId = 0;
                this.jJg.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.person_view_num), au.numberUniformFormatExtra(specialColumnItemData.freq_num)));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.homepage.tabfeed.college.a$a  reason: collision with other inner class name */
    /* loaded from: classes21.dex */
    public class C0747a extends RecyclerView.ViewHolder {
        public TextView jJa;
        public TextView jJb;
        public TbImageView jJc;
        public ImageView jJd;
        public View jJe;
        public LinearLayout jJf;

        public C0747a(View view) {
            super(view);
            this.jJc = (TbImageView) view.findViewById(R.id.iv_imageView);
            this.jJd = (ImageView) view.findViewById(R.id.video_play_iv);
            this.jJa = (TextView) view.findViewById(R.id.text_tv);
            this.jJb = (TextView) view.findViewById(R.id.tv_content);
            this.jJe = view.findViewById(R.id.gradient_cover);
            this.jJf = (LinearLayout) view.findViewById(R.id.ll_live_main);
        }

        void a(SpecialColumnItemData specialColumnItemData) {
            if (specialColumnItemData != null) {
                this.jJb.setText(specialColumnItemData.title);
                this.jJc.setConrers(15);
                this.jJc.setRadius(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10));
                this.jJc.setDrawCorner(true);
                this.jJc.setPlaceHolder(2);
                this.jJc.startLoad(specialColumnItemData.image, 10, false);
                this.jJa.setText(specialColumnItemData.text);
                this.jJd.setVisibility(0);
                a.this.mIconResId = R.drawable.ic_icon_pure_common_live12_svg;
                this.jJe.setAlpha(0.5f);
                com.baidu.tbadk.core.util.e.a.brc().pF(0).pM(l.getDimens(a.this.mContext, R.dimen.tbds10)).l(R.color.CAM_X0607, R.color.CAM_X0611).bn(this.jJe);
            }
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        return y.getCount(this.jIW);
    }

    private SpecialColumnItemData Cl(int i) {
        return (SpecialColumnItemData) y.getItem(this.jIW, i);
    }

    private void c(RecyclerView.ViewHolder viewHolder) {
        if (viewHolder instanceof b) {
            ap.setViewTextColor(((b) viewHolder).eTa, R.color.CAM_X0105);
            ap.setViewTextColor(((b) viewHolder).jJg, R.color.CAM_X0109);
            ap.setViewTextColor(((b) viewHolder).jJh, R.color.CAM_X0109);
            ap.setViewTextColor(((b) viewHolder).jJa, R.color.CAM_X0101);
            SvgManager.bqB().a(((b) viewHolder).jJd, this.mIconResId, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL);
            com.baidu.tbadk.core.util.e.a.h(((b) viewHolder).jJj, R.color.CAM_X0205, R.color.CAM_X0204);
        } else if (viewHolder instanceof C0747a) {
            ap.setViewTextColor(((C0747a) viewHolder).jJb, R.color.CAM_X0105);
            ap.setViewTextColor(((C0747a) viewHolder).jJa, R.color.CAM_X0101);
            SvgManager.bqB().a(((C0747a) viewHolder).jJd, this.mIconResId, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL);
            com.baidu.tbadk.core.util.e.a.h(((C0747a) viewHolder).jJf, R.color.CAM_X0205, R.color.CAM_X0204);
        }
    }

    public void a(f<SpecialColumnItemData> fVar) {
        this.jIX = fVar;
    }
}
