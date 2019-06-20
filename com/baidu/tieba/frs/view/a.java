package com.baidu.tieba.frs.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import java.util.List;
import tbclient.FrsPage.RecmForumInfo;
/* loaded from: classes4.dex */
public class a extends com.baidu.tbadk.m.a {
    private View aMY;
    protected TbImageView cvI;
    protected TextView cvJ;
    private BdListView fOZ;
    private C0318a fPa;
    private TextView fPb;
    private com.baidu.adp.base.e mPageContext;
    private TextView mTitleView;

    /* loaded from: classes4.dex */
    public static class b {
        public View divider;
        public TextView fPf;
        public TextView fPg;
        public TextView fPh;
        public ImageView fPi;
        public TbImageView fPj;
        public TextView fPk;
        public TextView fPl;
        public ImageView fPm;
        public View rootView;
    }

    public a(com.baidu.adp.base.e eVar, View.OnClickListener onClickListener) {
        super(LayoutInflater.from(eVar.getContext()).inflate(R.layout.forbid_detail_view_layout, (ViewGroup) null));
        this.mPageContext = eVar;
        this.cvI = (TbImageView) this.attachedView.findViewById(R.id.net_refresh_image);
        this.cvJ = (TextView) this.attachedView.findViewById(R.id.net_refresh_desc);
        this.aMY = this.attachedView.findViewById(R.id.divider);
        this.fOZ = (BdListView) this.attachedView.findViewById(R.id.recommend_bar_listview);
        this.attachedView.setOnClickListener(null);
        this.mTitleView = (TextView) this.attachedView.findViewById(R.id.content_title);
        this.fPb = (TextView) this.attachedView.findViewById(R.id.local_tip_tv);
    }

    public void qw(String str) {
        if (str == null) {
            this.cvJ.setVisibility(8);
            return;
        }
        this.cvJ.setVisibility(0);
        this.cvJ.setText(str);
    }

    public void co(List<RecmForumInfo> list) {
        if (list != null) {
            this.fPa = new C0318a(list);
            this.fOZ.setAdapter((ListAdapter) this.fPa);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.m.a
    public void onViewAttached() {
        super.onViewAttached();
        onChangeSkinType();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.m.a
    public void onViewDettached() {
        super.onViewDettached();
        this.cvI.setImageResource(0);
    }

    public void onChangeSkinType() {
        if (isViewAttached()) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            al.c(this.cvI, (int) R.drawable.new_pic_emotion_01);
            al.c(this.cvJ, R.color.cp_cont_d, 1, skinType);
            al.l(this.attachedView, R.color.cp_bg_line_d);
            al.l(this.aMY, R.color.cp_bg_line_c);
            al.c(this.mTitleView, R.color.cp_cont_d, 1, skinType);
            al.c(this.fPb, R.color.cp_cont_f, 1, skinType);
            if (this.fPa != null) {
                this.fPa.notifyDataSetChanged();
            }
        }
    }

    /* renamed from: com.baidu.tieba.frs.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C0318a extends BaseAdapter {
        private List<RecmForumInfo> fPc;

        public C0318a(List<RecmForumInfo> list) {
            this.fPc = list;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return this.fPc.size();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.widget.Adapter
        /* renamed from: sU */
        public RecmForumInfo getItem(int i) {
            return this.fPc.get(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(final int i, View view, ViewGroup viewGroup) {
            b bVar;
            if (view == null) {
                view = LayoutInflater.from(a.this.mPageContext.getPageActivity()).inflate(R.layout.recommend_view, (ViewGroup) null);
                b bVar2 = new b();
                bVar2.rootView = view.findViewById(R.id.root_view);
                bVar2.fPf = (TextView) view.findViewById(R.id.forum_name);
                bVar2.fPh = (TextView) view.findViewById(R.id.follow_tv);
                bVar2.fPg = (TextView) view.findViewById(R.id.thread_tv);
                bVar2.fPi = (ImageView) view.findViewById(R.id.arrow_item_img);
                bVar2.fPj = (TbImageView) view.findViewById(R.id.headview);
                bVar2.fPk = (TextView) view.findViewById(R.id.follow_title);
                bVar2.fPl = (TextView) view.findViewById(R.id.thread_title);
                bVar2.divider = view.findViewById(R.id.divider_line);
                bVar2.fPm = (ImageView) view.findViewById(R.id.content_img);
                view.setTag(bVar2);
                bVar = bVar2;
            } else {
                bVar = (b) view.getTag();
            }
            if (getItem(i) != null) {
                bVar.fPf.setText(ap.j(getItem(i).forum_name, 14, "..."));
                bVar.fPj.startLoad(getItem(i).avatar, 10, false);
                bVar.fPh.setText(ap.aG(getItem(i).member_count.intValue()));
                bVar.fPg.setText(ap.aG(getItem(i).post_num.intValue()));
                bVar.rootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.a.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (!StringUtils.isNull(C0318a.this.getItem(i).forum_name)) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(a.this.mPageContext.getContext()).createNormalCfg(C0318a.this.getItem(i).forum_name, null)));
                        }
                    }
                });
                al.j(bVar.fPf, R.color.cp_cont_b);
                al.j(bVar.fPh, R.color.cp_cont_d);
                al.j(bVar.fPg, R.color.cp_cont_d);
                al.j(bVar.fPl, R.color.cp_cont_d);
                al.j(bVar.fPk, R.color.cp_cont_d);
                al.k(bVar.divider, R.color.cp_bg_line_c);
                al.c(bVar.fPi, (int) R.drawable.icon_arrow_gray_right_n);
                al.k(view, R.drawable.addresslist_item_bg);
                al.k(bVar.fPm, R.drawable.picture_content_frame);
            }
            return view;
        }
    }
}
