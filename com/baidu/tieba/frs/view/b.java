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
    protected TbImageView aHq;
    protected TextView aHr;
    private View bqs;
    private BdListView dcd;
    private a dce;
    private TextView dcf;
    private com.baidu.adp.base.e mPageContext;
    private TextView mTitleView;

    /* renamed from: com.baidu.tieba.frs.view.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0104b {
        public TextView dcj;
        public TextView dck;
        public TextView dcl;
        public ImageView dcm;
        public TbImageView dcn;
        public TextView dco;
        public TextView dcp;
        public ImageView dcq;
        public View divider;
        public View rootView;
    }

    public b(com.baidu.adp.base.e eVar, View.OnClickListener onClickListener) {
        super(LayoutInflater.from(eVar.getContext()).inflate(d.h.forbid_detail_view_layout, (ViewGroup) null));
        this.mPageContext = eVar;
        this.aHq = (TbImageView) this.aHi.findViewById(d.g.net_refresh_image);
        this.aHr = (TextView) this.aHi.findViewById(d.g.net_refresh_desc);
        this.bqs = this.aHi.findViewById(d.g.divider);
        this.dcd = (BdListView) this.aHi.findViewById(d.g.recommend_bar_listview);
        this.aHi.setOnClickListener(null);
        this.mTitleView = (TextView) this.aHi.findViewById(d.g.content_title);
        this.dcf = (TextView) this.aHi.findViewById(d.g.local_tip_tv);
    }

    public void gB(String str) {
        if (str == null) {
            this.aHr.setVisibility(8);
            return;
        }
        this.aHr.setVisibility(0);
        this.aHr.setText(str);
    }

    public void bn(List<RecmForumInfo> list) {
        if (list != null) {
            this.dce = new a(list);
            this.dcd.setAdapter((ListAdapter) this.dce);
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
        this.aHq.setImageResource(0);
    }

    public void onChangeSkinType() {
        if (EO()) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            aj.c(this.aHq, d.f.pic_emotion_01);
            aj.b(this.aHr, d.C0096d.cp_cont_d, 1, skinType);
            aj.k(this.aHi, d.C0096d.cp_bg_line_d);
            aj.k(this.bqs, d.C0096d.cp_bg_line_c);
            aj.b(this.mTitleView, d.C0096d.cp_cont_d, 1, skinType);
            aj.b(this.dcf, d.C0096d.cp_cont_f, 1, skinType);
            if (this.dce != null) {
                this.dce.notifyDataSetChanged();
            }
        }
    }

    /* loaded from: classes.dex */
    public class a extends BaseAdapter {
        private List<RecmForumInfo> dcg;

        public a(List<RecmForumInfo> list) {
            this.dcg = list;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return this.dcg.size();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.widget.Adapter
        /* renamed from: lh */
        public RecmForumInfo getItem(int i) {
            return this.dcg.get(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(final int i, View view, ViewGroup viewGroup) {
            C0104b c0104b;
            if (view == null) {
                view = LayoutInflater.from(b.this.mPageContext.getPageActivity()).inflate(d.h.recommend_view, (ViewGroup) null);
                C0104b c0104b2 = new C0104b();
                c0104b2.rootView = view.findViewById(d.g.root_view);
                c0104b2.dcj = (TextView) view.findViewById(d.g.forum_name);
                c0104b2.dcl = (TextView) view.findViewById(d.g.follow_tv);
                c0104b2.dck = (TextView) view.findViewById(d.g.thread_tv);
                c0104b2.dcm = (ImageView) view.findViewById(d.g.arrow_item_img);
                c0104b2.dcn = (TbImageView) view.findViewById(d.g.headview);
                c0104b2.dco = (TextView) view.findViewById(d.g.follow_title);
                c0104b2.dcp = (TextView) view.findViewById(d.g.thread_title);
                c0104b2.divider = view.findViewById(d.g.divider_line);
                c0104b2.dcq = (ImageView) view.findViewById(d.g.content_img);
                view.setTag(c0104b2);
                c0104b = c0104b2;
            } else {
                c0104b = (C0104b) view.getTag();
            }
            if (getItem(i) != null) {
                c0104b.dcj.setText(am.e(getItem(i).forum_name, 14, "..."));
                c0104b.dcn.startLoad(getItem(i).avatar, 10, false);
                c0104b.dcl.setText(am.u(getItem(i).member_count.intValue()));
                c0104b.dck.setText(am.u(getItem(i).post_num.intValue()));
                c0104b.rootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.b.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (!StringUtils.isNull(a.this.getItem(i).forum_name)) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(b.this.mPageContext.getContext()).createNormalCfg(a.this.getItem(i).forum_name, null)));
                        }
                    }
                });
                aj.i(c0104b.dcj, d.C0096d.cp_cont_b);
                aj.i(c0104b.dcl, d.C0096d.cp_cont_d);
                aj.i(c0104b.dck, d.C0096d.cp_cont_d);
                aj.i(c0104b.dcp, d.C0096d.cp_cont_d);
                aj.i(c0104b.dco, d.C0096d.cp_cont_d);
                aj.j(c0104b.divider, d.C0096d.cp_bg_line_c);
                aj.c(c0104b.dcm, d.f.icon_arrow_gray_right_n);
                aj.j(view, d.f.addresslist_item_bg);
                aj.j(c0104b.dcq, d.f.picture_content_frame);
            }
            return view;
        }
    }
}
