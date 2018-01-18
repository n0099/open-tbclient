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
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import java.util.List;
import tbclient.FrsPage.RecmForumInfo;
/* loaded from: classes2.dex */
public class b extends com.baidu.tbadk.j.a {
    protected TbImageView bvp;
    protected TextView bvq;
    private View cdX;
    private BdListView dTh;
    private a dTi;
    private TextView dTj;
    private com.baidu.adp.base.e mPageContext;
    private TextView mTitleView;

    /* renamed from: com.baidu.tieba.frs.view.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0114b {
        public TextView dTn;
        public TextView dTo;
        public TextView dTp;
        public ImageView dTq;
        public TbImageView dTr;
        public TextView dTs;
        public TextView dTt;
        public ImageView dTu;
        public View divider;
        public View rootView;
    }

    public b(com.baidu.adp.base.e eVar, View.OnClickListener onClickListener) {
        super(LayoutInflater.from(eVar.getContext()).inflate(d.h.forbid_detail_view_layout, (ViewGroup) null));
        this.mPageContext = eVar;
        this.bvp = (TbImageView) this.bvh.findViewById(d.g.net_refresh_image);
        this.bvq = (TextView) this.bvh.findViewById(d.g.net_refresh_desc);
        this.cdX = this.bvh.findViewById(d.g.divider);
        this.dTh = (BdListView) this.bvh.findViewById(d.g.recommend_bar_listview);
        this.bvh.setOnClickListener(null);
        this.mTitleView = (TextView) this.bvh.findViewById(d.g.content_title);
        this.dTj = (TextView) this.bvh.findViewById(d.g.local_tip_tv);
    }

    public void gF(String str) {
        if (str == null) {
            this.bvq.setVisibility(8);
            return;
        }
        this.bvq.setVisibility(0);
        this.bvq.setText(str);
    }

    public void bw(List<RecmForumInfo> list) {
        if (list != null) {
            this.dTi = new a(list);
            this.dTh.setAdapter((ListAdapter) this.dTi);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.j.a
    public void Mc() {
        super.Mc();
        onChangeSkinType();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.j.a
    public void Md() {
        super.Md();
        this.bvp.setImageResource(0);
    }

    public void onChangeSkinType() {
        if (Mb()) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            aj.c(this.bvp, d.f.pic_emotion_01);
            aj.b(this.bvq, d.C0107d.cp_cont_d, 1, skinType);
            aj.t(this.bvh, d.C0107d.cp_bg_line_d);
            aj.t(this.cdX, d.C0107d.cp_bg_line_c);
            aj.b(this.mTitleView, d.C0107d.cp_cont_d, 1, skinType);
            aj.b(this.dTj, d.C0107d.cp_cont_f, 1, skinType);
            if (this.dTi != null) {
                this.dTi.notifyDataSetChanged();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class a extends BaseAdapter {
        private List<RecmForumInfo> dTk;

        public a(List<RecmForumInfo> list) {
            this.dTk = list;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return this.dTk.size();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.widget.Adapter
        /* renamed from: oc */
        public RecmForumInfo getItem(int i) {
            return this.dTk.get(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(final int i, View view, ViewGroup viewGroup) {
            C0114b c0114b;
            if (view == null) {
                view = LayoutInflater.from(b.this.mPageContext.getPageActivity()).inflate(d.h.recommend_view, (ViewGroup) null);
                C0114b c0114b2 = new C0114b();
                c0114b2.rootView = view.findViewById(d.g.root_view);
                c0114b2.dTn = (TextView) view.findViewById(d.g.forum_name);
                c0114b2.dTp = (TextView) view.findViewById(d.g.follow_tv);
                c0114b2.dTo = (TextView) view.findViewById(d.g.thread_tv);
                c0114b2.dTq = (ImageView) view.findViewById(d.g.arrow_item_img);
                c0114b2.dTr = (TbImageView) view.findViewById(d.g.headview);
                c0114b2.dTs = (TextView) view.findViewById(d.g.follow_title);
                c0114b2.dTt = (TextView) view.findViewById(d.g.thread_title);
                c0114b2.divider = view.findViewById(d.g.divider_line);
                c0114b2.dTu = (ImageView) view.findViewById(d.g.content_img);
                view.setTag(c0114b2);
                c0114b = c0114b2;
            } else {
                c0114b = (C0114b) view.getTag();
            }
            if (getItem(i) != null) {
                c0114b.dTn.setText(am.e(getItem(i).forum_name, 14, "..."));
                c0114b.dTr.startLoad(getItem(i).avatar, 10, false);
                c0114b.dTp.setText(am.C(getItem(i).member_count.intValue()));
                c0114b.dTo.setText(am.C(getItem(i).post_num.intValue()));
                c0114b.rootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.b.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (!StringUtils.isNull(a.this.getItem(i).forum_name)) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(b.this.mPageContext.getContext()).createNormalCfg(a.this.getItem(i).forum_name, null)));
                        }
                    }
                });
                aj.r(c0114b.dTn, d.C0107d.cp_cont_b);
                aj.r(c0114b.dTp, d.C0107d.cp_cont_d);
                aj.r(c0114b.dTo, d.C0107d.cp_cont_d);
                aj.r(c0114b.dTt, d.C0107d.cp_cont_d);
                aj.r(c0114b.dTs, d.C0107d.cp_cont_d);
                aj.s(c0114b.divider, d.C0107d.cp_bg_line_c);
                aj.c(c0114b.dTq, d.f.icon_arrow_gray_right_n);
                aj.s(view, d.f.addresslist_item_bg);
                aj.s(c0114b.dTu, d.f.picture_content_frame);
            }
            return view;
        }
    }
}
