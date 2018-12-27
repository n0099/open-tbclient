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
    protected TbImageView bdr;
    protected TextView bds;
    private TextView eiA;
    private BdListView eiy;
    private C0232a eiz;
    private View mDivider;
    private com.baidu.adp.base.e mPageContext;
    private TextView mTitleView;

    /* loaded from: classes6.dex */
    public static class b {
        public View divider;
        public TextView eiE;
        public TextView eiF;
        public TextView eiG;
        public ImageView eiH;
        public TbImageView eiI;
        public TextView eiJ;
        public TextView eiK;
        public ImageView eiL;
        public View rootView;
    }

    public a(com.baidu.adp.base.e eVar, View.OnClickListener onClickListener) {
        super(LayoutInflater.from(eVar.getContext()).inflate(e.h.forbid_detail_view_layout, (ViewGroup) null));
        this.mPageContext = eVar;
        this.bdr = (TbImageView) this.attachedView.findViewById(e.g.net_refresh_image);
        this.bds = (TextView) this.attachedView.findViewById(e.g.net_refresh_desc);
        this.mDivider = this.attachedView.findViewById(e.g.divider);
        this.eiy = (BdListView) this.attachedView.findViewById(e.g.recommend_bar_listview);
        this.attachedView.setOnClickListener(null);
        this.mTitleView = (TextView) this.attachedView.findViewById(e.g.content_title);
        this.eiA = (TextView) this.attachedView.findViewById(e.g.local_tip_tv);
    }

    public void io(String str) {
        if (str == null) {
            this.bds.setVisibility(8);
            return;
        }
        this.bds.setVisibility(0);
        this.bds.setText(str);
    }

    public void bT(List<RecmForumInfo> list) {
        if (list != null) {
            this.eiz = new C0232a(list);
            this.eiy.setAdapter((ListAdapter) this.eiz);
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
        this.bdr.setImageResource(0);
    }

    public void onChangeSkinType() {
        if (isViewAttached()) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            al.c(this.bdr, e.f.pic_emotion_01);
            al.b(this.bds, e.d.cp_cont_d, 1, skinType);
            al.j(this.attachedView, e.d.cp_bg_line_d);
            al.j(this.mDivider, e.d.cp_bg_line_c);
            al.b(this.mTitleView, e.d.cp_cont_d, 1, skinType);
            al.b(this.eiA, e.d.cp_cont_f, 1, skinType);
            if (this.eiz != null) {
                this.eiz.notifyDataSetChanged();
            }
        }
    }

    /* renamed from: com.baidu.tieba.frs.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class C0232a extends BaseAdapter {
        private List<RecmForumInfo> eiB;

        public C0232a(List<RecmForumInfo> list) {
            this.eiB = list;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return this.eiB.size();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.widget.Adapter
        /* renamed from: nY */
        public RecmForumInfo getItem(int i) {
            return this.eiB.get(i);
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
                bVar2.eiE = (TextView) view.findViewById(e.g.forum_name);
                bVar2.eiG = (TextView) view.findViewById(e.g.follow_tv);
                bVar2.eiF = (TextView) view.findViewById(e.g.thread_tv);
                bVar2.eiH = (ImageView) view.findViewById(e.g.arrow_item_img);
                bVar2.eiI = (TbImageView) view.findViewById(e.g.headview);
                bVar2.eiJ = (TextView) view.findViewById(e.g.follow_title);
                bVar2.eiK = (TextView) view.findViewById(e.g.thread_title);
                bVar2.divider = view.findViewById(e.g.divider_line);
                bVar2.eiL = (ImageView) view.findViewById(e.g.content_img);
                view.setTag(bVar2);
                bVar = bVar2;
            } else {
                bVar = (b) view.getTag();
            }
            if (getItem(i) != null) {
                bVar.eiE.setText(ao.d(getItem(i).forum_name, 14, "..."));
                bVar.eiI.startLoad(getItem(i).avatar, 10, false);
                bVar.eiG.setText(ao.Q(getItem(i).member_count.intValue()));
                bVar.eiF.setText(ao.Q(getItem(i).post_num.intValue()));
                bVar.rootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.a.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (!StringUtils.isNull(C0232a.this.getItem(i).forum_name)) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(a.this.mPageContext.getContext()).createNormalCfg(C0232a.this.getItem(i).forum_name, null)));
                        }
                    }
                });
                al.h(bVar.eiE, e.d.cp_cont_b);
                al.h(bVar.eiG, e.d.cp_cont_d);
                al.h(bVar.eiF, e.d.cp_cont_d);
                al.h(bVar.eiK, e.d.cp_cont_d);
                al.h(bVar.eiJ, e.d.cp_cont_d);
                al.i(bVar.divider, e.d.cp_bg_line_c);
                al.c(bVar.eiH, e.f.icon_arrow_gray_right_n);
                al.i(view, e.f.addresslist_item_bg);
                al.i(bVar.eiL, e.f.picture_content_frame);
            }
            return view;
        }
    }
}
