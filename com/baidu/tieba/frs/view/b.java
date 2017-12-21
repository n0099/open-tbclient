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
/* loaded from: classes.dex */
public class b extends com.baidu.tbadk.j.a {
    protected TbImageView aHt;
    protected TextView aHu;
    private View bqw;
    private BdListView dch;
    private a dci;
    private TextView dcj;
    private com.baidu.adp.base.e mPageContext;
    private TextView mTitleView;

    /* renamed from: com.baidu.tieba.frs.view.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0103b {
        public TextView dcn;
        public TextView dco;
        public TextView dcp;
        public ImageView dcq;
        public TbImageView dcr;
        public TextView dcs;
        public TextView dct;
        public ImageView dcv;
        public View divider;
        public View rootView;
    }

    public b(com.baidu.adp.base.e eVar, View.OnClickListener onClickListener) {
        super(LayoutInflater.from(eVar.getContext()).inflate(d.h.forbid_detail_view_layout, (ViewGroup) null));
        this.mPageContext = eVar;
        this.aHt = (TbImageView) this.aHl.findViewById(d.g.net_refresh_image);
        this.aHu = (TextView) this.aHl.findViewById(d.g.net_refresh_desc);
        this.bqw = this.aHl.findViewById(d.g.divider);
        this.dch = (BdListView) this.aHl.findViewById(d.g.recommend_bar_listview);
        this.aHl.setOnClickListener(null);
        this.mTitleView = (TextView) this.aHl.findViewById(d.g.content_title);
        this.dcj = (TextView) this.aHl.findViewById(d.g.local_tip_tv);
    }

    public void gB(String str) {
        if (str == null) {
            this.aHu.setVisibility(8);
            return;
        }
        this.aHu.setVisibility(0);
        this.aHu.setText(str);
    }

    public void bn(List<RecmForumInfo> list) {
        if (list != null) {
            this.dci = new a(list);
            this.dch.setAdapter((ListAdapter) this.dci);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.j.a
    public void EP() {
        super.EP();
        onChangeSkinType();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.j.a
    public void EQ() {
        super.EQ();
        this.aHt.setImageResource(0);
    }

    public void onChangeSkinType() {
        if (EO()) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            aj.c(this.aHt, d.f.pic_emotion_01);
            aj.b(this.aHu, d.C0095d.cp_cont_d, 1, skinType);
            aj.k(this.aHl, d.C0095d.cp_bg_line_d);
            aj.k(this.bqw, d.C0095d.cp_bg_line_c);
            aj.b(this.mTitleView, d.C0095d.cp_cont_d, 1, skinType);
            aj.b(this.dcj, d.C0095d.cp_cont_f, 1, skinType);
            if (this.dci != null) {
                this.dci.notifyDataSetChanged();
            }
        }
    }

    /* loaded from: classes.dex */
    public class a extends BaseAdapter {
        private List<RecmForumInfo> dck;

        public a(List<RecmForumInfo> list) {
            this.dck = list;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return this.dck.size();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.widget.Adapter
        /* renamed from: lh */
        public RecmForumInfo getItem(int i) {
            return this.dck.get(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(final int i, View view, ViewGroup viewGroup) {
            C0103b c0103b;
            if (view == null) {
                view = LayoutInflater.from(b.this.mPageContext.getPageActivity()).inflate(d.h.recommend_view, (ViewGroup) null);
                C0103b c0103b2 = new C0103b();
                c0103b2.rootView = view.findViewById(d.g.root_view);
                c0103b2.dcn = (TextView) view.findViewById(d.g.forum_name);
                c0103b2.dcp = (TextView) view.findViewById(d.g.follow_tv);
                c0103b2.dco = (TextView) view.findViewById(d.g.thread_tv);
                c0103b2.dcq = (ImageView) view.findViewById(d.g.arrow_item_img);
                c0103b2.dcr = (TbImageView) view.findViewById(d.g.headview);
                c0103b2.dcs = (TextView) view.findViewById(d.g.follow_title);
                c0103b2.dct = (TextView) view.findViewById(d.g.thread_title);
                c0103b2.divider = view.findViewById(d.g.divider_line);
                c0103b2.dcv = (ImageView) view.findViewById(d.g.content_img);
                view.setTag(c0103b2);
                c0103b = c0103b2;
            } else {
                c0103b = (C0103b) view.getTag();
            }
            if (getItem(i) != null) {
                c0103b.dcn.setText(am.e(getItem(i).forum_name, 14, "..."));
                c0103b.dcr.startLoad(getItem(i).avatar, 10, false);
                c0103b.dcp.setText(am.u(getItem(i).member_count.intValue()));
                c0103b.dco.setText(am.u(getItem(i).post_num.intValue()));
                c0103b.rootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.b.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (!StringUtils.isNull(a.this.getItem(i).forum_name)) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(b.this.mPageContext.getContext()).createNormalCfg(a.this.getItem(i).forum_name, null)));
                        }
                    }
                });
                aj.i(c0103b.dcn, d.C0095d.cp_cont_b);
                aj.i(c0103b.dcp, d.C0095d.cp_cont_d);
                aj.i(c0103b.dco, d.C0095d.cp_cont_d);
                aj.i(c0103b.dct, d.C0095d.cp_cont_d);
                aj.i(c0103b.dcs, d.C0095d.cp_cont_d);
                aj.j(c0103b.divider, d.C0095d.cp_bg_line_c);
                aj.c(c0103b.dcq, d.f.icon_arrow_gray_right_n);
                aj.j(view, d.f.addresslist_item_bg);
                aj.j(c0103b.dcv, d.f.picture_content_frame);
            }
            return view;
        }
    }
}
