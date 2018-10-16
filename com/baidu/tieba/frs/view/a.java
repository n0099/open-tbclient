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
    protected TbImageView aZd;
    protected TextView aZe;
    private BdListView dXK;
    private C0195a dXL;
    private TextView dXM;
    private View mDivider;
    private com.baidu.adp.base.e mPageContext;
    private TextView mTitleView;

    /* loaded from: classes6.dex */
    public static class b {
        public TextView dXQ;
        public TextView dXR;
        public TextView dXS;
        public ImageView dXT;
        public TbImageView dXU;
        public TextView dXV;
        public TextView dXW;
        public ImageView dXX;
        public View divider;
        public View rootView;
    }

    public a(com.baidu.adp.base.e eVar, View.OnClickListener onClickListener) {
        super(LayoutInflater.from(eVar.getContext()).inflate(e.h.forbid_detail_view_layout, (ViewGroup) null));
        this.mPageContext = eVar;
        this.aZd = (TbImageView) this.aYV.findViewById(e.g.net_refresh_image);
        this.aZe = (TextView) this.aYV.findViewById(e.g.net_refresh_desc);
        this.mDivider = this.aYV.findViewById(e.g.divider);
        this.dXK = (BdListView) this.aYV.findViewById(e.g.recommend_bar_listview);
        this.aYV.setOnClickListener(null);
        this.mTitleView = (TextView) this.aYV.findViewById(e.g.content_title);
        this.dXM = (TextView) this.aYV.findViewById(e.g.local_tip_tv);
    }

    public void hU(String str) {
        if (str == null) {
            this.aZe.setVisibility(8);
            return;
        }
        this.aZe.setVisibility(0);
        this.aZe.setText(str);
    }

    public void bS(List<RecmForumInfo> list) {
        if (list != null) {
            this.dXL = new C0195a(list);
            this.dXK.setAdapter((ListAdapter) this.dXL);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.k.a
    public void Mr() {
        super.Mr();
        onChangeSkinType();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.k.a
    public void Ms() {
        super.Ms();
        this.aZd.setImageResource(0);
    }

    public void onChangeSkinType() {
        if (Mq()) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            al.c(this.aZd, e.f.pic_emotion_01);
            al.b(this.aZe, e.d.cp_cont_d, 1, skinType);
            al.j(this.aYV, e.d.cp_bg_line_d);
            al.j(this.mDivider, e.d.cp_bg_line_c);
            al.b(this.mTitleView, e.d.cp_cont_d, 1, skinType);
            al.b(this.dXM, e.d.cp_cont_f, 1, skinType);
            if (this.dXL != null) {
                this.dXL.notifyDataSetChanged();
            }
        }
    }

    /* renamed from: com.baidu.tieba.frs.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class C0195a extends BaseAdapter {
        private List<RecmForumInfo> dXN;

        public C0195a(List<RecmForumInfo> list) {
            this.dXN = list;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return this.dXN.size();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.widget.Adapter
        /* renamed from: nd */
        public RecmForumInfo getItem(int i) {
            return this.dXN.get(i);
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
                bVar2.dXQ = (TextView) view.findViewById(e.g.forum_name);
                bVar2.dXS = (TextView) view.findViewById(e.g.follow_tv);
                bVar2.dXR = (TextView) view.findViewById(e.g.thread_tv);
                bVar2.dXT = (ImageView) view.findViewById(e.g.arrow_item_img);
                bVar2.dXU = (TbImageView) view.findViewById(e.g.headview);
                bVar2.dXV = (TextView) view.findViewById(e.g.follow_title);
                bVar2.dXW = (TextView) view.findViewById(e.g.thread_title);
                bVar2.divider = view.findViewById(e.g.divider_line);
                bVar2.dXX = (ImageView) view.findViewById(e.g.content_img);
                view.setTag(bVar2);
                bVar = bVar2;
            } else {
                bVar = (b) view.getTag();
            }
            if (getItem(i) != null) {
                bVar.dXQ.setText(ao.d(getItem(i).forum_name, 14, "..."));
                bVar.dXU.startLoad(getItem(i).avatar, 10, false);
                bVar.dXS.setText(ao.G(getItem(i).member_count.intValue()));
                bVar.dXR.setText(ao.G(getItem(i).post_num.intValue()));
                bVar.rootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.a.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (!StringUtils.isNull(C0195a.this.getItem(i).forum_name)) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(a.this.mPageContext.getContext()).createNormalCfg(C0195a.this.getItem(i).forum_name, null)));
                        }
                    }
                });
                al.h(bVar.dXQ, e.d.cp_cont_b);
                al.h(bVar.dXS, e.d.cp_cont_d);
                al.h(bVar.dXR, e.d.cp_cont_d);
                al.h(bVar.dXW, e.d.cp_cont_d);
                al.h(bVar.dXV, e.d.cp_cont_d);
                al.i(bVar.divider, e.d.cp_bg_line_c);
                al.c(bVar.dXT, e.f.icon_arrow_gray_right_n);
                al.i(view, e.f.addresslist_item_bg);
                al.i(bVar.dXX, e.f.picture_content_frame);
            }
            return view;
        }
    }
}
