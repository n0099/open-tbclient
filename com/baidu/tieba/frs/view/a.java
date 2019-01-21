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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.e;
import java.util.List;
import tbclient.FrsPage.RecmForumInfo;
/* loaded from: classes6.dex */
public class a extends com.baidu.tbadk.k.a {
    protected TbImageView bec;
    protected TextView bed;
    private BdListView ejf;
    private C0232a ejg;
    private TextView ejh;
    private View mDivider;
    private com.baidu.adp.base.e mPageContext;
    private TextView mTitleView;

    /* loaded from: classes6.dex */
    public static class b {
        public View divider;
        public TextView ejl;
        public TextView ejm;
        public TextView ejn;
        public ImageView ejo;
        public TbImageView ejp;
        public TextView ejq;
        public TextView ejr;
        public ImageView ejs;
        public View rootView;
    }

    public a(com.baidu.adp.base.e eVar, View.OnClickListener onClickListener) {
        super(LayoutInflater.from(eVar.getContext()).inflate(e.h.forbid_detail_view_layout, (ViewGroup) null));
        this.mPageContext = eVar;
        this.bec = (TbImageView) this.attachedView.findViewById(e.g.net_refresh_image);
        this.bed = (TextView) this.attachedView.findViewById(e.g.net_refresh_desc);
        this.mDivider = this.attachedView.findViewById(e.g.divider);
        this.ejf = (BdListView) this.attachedView.findViewById(e.g.recommend_bar_listview);
        this.attachedView.setOnClickListener(null);
        this.mTitleView = (TextView) this.attachedView.findViewById(e.g.content_title);
        this.ejh = (TextView) this.attachedView.findViewById(e.g.local_tip_tv);
    }

    public void iC(String str) {
        if (str == null) {
            this.bed.setVisibility(8);
            return;
        }
        this.bed.setVisibility(0);
        this.bed.setText(str);
    }

    public void bU(List<RecmForumInfo> list) {
        if (list != null) {
            this.ejg = new C0232a(list);
            this.ejf.setAdapter((ListAdapter) this.ejg);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.k.a
    public void onViewAttached() {
        super.onViewAttached();
        onChangeSkinType();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.k.a
    public void onViewDettached() {
        super.onViewDettached();
        this.bec.setImageResource(0);
    }

    public void onChangeSkinType() {
        if (isViewAttached()) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            al.c(this.bec, e.f.pic_emotion_01);
            al.b(this.bed, e.d.cp_cont_d, 1, skinType);
            al.j(this.attachedView, e.d.cp_bg_line_d);
            al.j(this.mDivider, e.d.cp_bg_line_c);
            al.b(this.mTitleView, e.d.cp_cont_d, 1, skinType);
            al.b(this.ejh, e.d.cp_cont_f, 1, skinType);
            if (this.ejg != null) {
                this.ejg.notifyDataSetChanged();
            }
        }
    }

    /* renamed from: com.baidu.tieba.frs.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class C0232a extends BaseAdapter {
        private List<RecmForumInfo> eji;

        public C0232a(List<RecmForumInfo> list) {
            this.eji = list;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return this.eji.size();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.widget.Adapter
        /* renamed from: nZ */
        public RecmForumInfo getItem(int i) {
            return this.eji.get(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(final int i, View view, ViewGroup viewGroup) {
            b bVar;
            if (view == null) {
                view = LayoutInflater.from(a.this.mPageContext.getPageActivity()).inflate(e.h.recommend_view, (ViewGroup) null);
                b bVar2 = new b();
                bVar2.rootView = view.findViewById(e.g.root_view);
                bVar2.ejl = (TextView) view.findViewById(e.g.forum_name);
                bVar2.ejn = (TextView) view.findViewById(e.g.follow_tv);
                bVar2.ejm = (TextView) view.findViewById(e.g.thread_tv);
                bVar2.ejo = (ImageView) view.findViewById(e.g.arrow_item_img);
                bVar2.ejp = (TbImageView) view.findViewById(e.g.headview);
                bVar2.ejq = (TextView) view.findViewById(e.g.follow_title);
                bVar2.ejr = (TextView) view.findViewById(e.g.thread_title);
                bVar2.divider = view.findViewById(e.g.divider_line);
                bVar2.ejs = (ImageView) view.findViewById(e.g.content_img);
                view.setTag(bVar2);
                bVar = bVar2;
            } else {
                bVar = (b) view.getTag();
            }
            if (getItem(i) != null) {
                bVar.ejl.setText(ao.d(getItem(i).forum_name, 14, "..."));
                bVar.ejp.startLoad(getItem(i).avatar, 10, false);
                bVar.ejn.setText(ao.Q(getItem(i).member_count.intValue()));
                bVar.ejm.setText(ao.Q(getItem(i).post_num.intValue()));
                bVar.rootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.a.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (!StringUtils.isNull(C0232a.this.getItem(i).forum_name)) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(a.this.mPageContext.getContext()).createNormalCfg(C0232a.this.getItem(i).forum_name, null)));
                        }
                    }
                });
                al.h(bVar.ejl, e.d.cp_cont_b);
                al.h(bVar.ejn, e.d.cp_cont_d);
                al.h(bVar.ejm, e.d.cp_cont_d);
                al.h(bVar.ejr, e.d.cp_cont_d);
                al.h(bVar.ejq, e.d.cp_cont_d);
                al.i(bVar.divider, e.d.cp_bg_line_c);
                al.c(bVar.ejo, e.f.icon_arrow_gray_right_n);
                al.i(view, e.f.addresslist_item_bg);
                al.i(bVar.ejs, e.f.picture_content_frame);
            }
            return view;
        }
    }
}
