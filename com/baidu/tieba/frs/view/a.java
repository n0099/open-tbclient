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
    protected TbImageView beb;
    protected TextView bec;
    private BdListView eje;
    private C0232a ejf;
    private TextView ejg;
    private View mDivider;
    private com.baidu.adp.base.e mPageContext;
    private TextView mTitleView;

    /* loaded from: classes6.dex */
    public static class b {
        public View divider;
        public TextView ejk;
        public TextView ejl;
        public TextView ejm;
        public ImageView ejn;
        public TbImageView ejo;
        public TextView ejp;
        public TextView ejq;
        public ImageView ejr;
        public View rootView;
    }

    public a(com.baidu.adp.base.e eVar, View.OnClickListener onClickListener) {
        super(LayoutInflater.from(eVar.getContext()).inflate(e.h.forbid_detail_view_layout, (ViewGroup) null));
        this.mPageContext = eVar;
        this.beb = (TbImageView) this.attachedView.findViewById(e.g.net_refresh_image);
        this.bec = (TextView) this.attachedView.findViewById(e.g.net_refresh_desc);
        this.mDivider = this.attachedView.findViewById(e.g.divider);
        this.eje = (BdListView) this.attachedView.findViewById(e.g.recommend_bar_listview);
        this.attachedView.setOnClickListener(null);
        this.mTitleView = (TextView) this.attachedView.findViewById(e.g.content_title);
        this.ejg = (TextView) this.attachedView.findViewById(e.g.local_tip_tv);
    }

    public void iC(String str) {
        if (str == null) {
            this.bec.setVisibility(8);
            return;
        }
        this.bec.setVisibility(0);
        this.bec.setText(str);
    }

    public void bU(List<RecmForumInfo> list) {
        if (list != null) {
            this.ejf = new C0232a(list);
            this.eje.setAdapter((ListAdapter) this.ejf);
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
        this.beb.setImageResource(0);
    }

    public void onChangeSkinType() {
        if (isViewAttached()) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            al.c(this.beb, e.f.pic_emotion_01);
            al.b(this.bec, e.d.cp_cont_d, 1, skinType);
            al.j(this.attachedView, e.d.cp_bg_line_d);
            al.j(this.mDivider, e.d.cp_bg_line_c);
            al.b(this.mTitleView, e.d.cp_cont_d, 1, skinType);
            al.b(this.ejg, e.d.cp_cont_f, 1, skinType);
            if (this.ejf != null) {
                this.ejf.notifyDataSetChanged();
            }
        }
    }

    /* renamed from: com.baidu.tieba.frs.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class C0232a extends BaseAdapter {
        private List<RecmForumInfo> ejh;

        public C0232a(List<RecmForumInfo> list) {
            this.ejh = list;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return this.ejh.size();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.widget.Adapter
        /* renamed from: nZ */
        public RecmForumInfo getItem(int i) {
            return this.ejh.get(i);
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
                bVar2.ejk = (TextView) view.findViewById(e.g.forum_name);
                bVar2.ejm = (TextView) view.findViewById(e.g.follow_tv);
                bVar2.ejl = (TextView) view.findViewById(e.g.thread_tv);
                bVar2.ejn = (ImageView) view.findViewById(e.g.arrow_item_img);
                bVar2.ejo = (TbImageView) view.findViewById(e.g.headview);
                bVar2.ejp = (TextView) view.findViewById(e.g.follow_title);
                bVar2.ejq = (TextView) view.findViewById(e.g.thread_title);
                bVar2.divider = view.findViewById(e.g.divider_line);
                bVar2.ejr = (ImageView) view.findViewById(e.g.content_img);
                view.setTag(bVar2);
                bVar = bVar2;
            } else {
                bVar = (b) view.getTag();
            }
            if (getItem(i) != null) {
                bVar.ejk.setText(ao.d(getItem(i).forum_name, 14, "..."));
                bVar.ejo.startLoad(getItem(i).avatar, 10, false);
                bVar.ejm.setText(ao.Q(getItem(i).member_count.intValue()));
                bVar.ejl.setText(ao.Q(getItem(i).post_num.intValue()));
                bVar.rootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.a.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (!StringUtils.isNull(C0232a.this.getItem(i).forum_name)) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(a.this.mPageContext.getContext()).createNormalCfg(C0232a.this.getItem(i).forum_name, null)));
                        }
                    }
                });
                al.h(bVar.ejk, e.d.cp_cont_b);
                al.h(bVar.ejm, e.d.cp_cont_d);
                al.h(bVar.ejl, e.d.cp_cont_d);
                al.h(bVar.ejq, e.d.cp_cont_d);
                al.h(bVar.ejp, e.d.cp_cont_d);
                al.i(bVar.divider, e.d.cp_bg_line_c);
                al.c(bVar.ejn, e.f.icon_arrow_gray_right_n);
                al.i(view, e.f.addresslist_item_bg);
                al.i(bVar.ejr, e.f.picture_content_frame);
            }
            return view;
        }
    }
}
