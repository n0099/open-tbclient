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
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import java.util.List;
import tbclient.FrsPage.RecmForumInfo;
/* loaded from: classes2.dex */
public class b extends com.baidu.tbadk.j.a {
    protected TbImageView bxI;
    protected TextView bxJ;
    private View chX;
    private BdListView dXr;
    private a dXs;
    private TextView dXt;
    private com.baidu.adp.base.e mPageContext;
    private TextView mTitleView;

    /* renamed from: com.baidu.tieba.frs.view.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0159b {
        public ImageView dXA;
        public TbImageView dXB;
        public TextView dXC;
        public TextView dXD;
        public ImageView dXE;
        public TextView dXx;
        public TextView dXy;
        public TextView dXz;
        public View divider;
        public View rootView;
    }

    public b(com.baidu.adp.base.e eVar, View.OnClickListener onClickListener) {
        super(LayoutInflater.from(eVar.getContext()).inflate(d.h.forbid_detail_view_layout, (ViewGroup) null));
        this.mPageContext = eVar;
        this.bxI = (TbImageView) this.bxA.findViewById(d.g.net_refresh_image);
        this.bxJ = (TextView) this.bxA.findViewById(d.g.net_refresh_desc);
        this.chX = this.bxA.findViewById(d.g.divider);
        this.dXr = (BdListView) this.bxA.findViewById(d.g.recommend_bar_listview);
        this.bxA.setOnClickListener(null);
        this.mTitleView = (TextView) this.bxA.findViewById(d.g.content_title);
        this.dXt = (TextView) this.bxA.findViewById(d.g.local_tip_tv);
    }

    public void gW(String str) {
        if (str == null) {
            this.bxJ.setVisibility(8);
            return;
        }
        this.bxJ.setVisibility(0);
        this.bxJ.setText(str);
    }

    public void by(List<RecmForumInfo> list) {
        if (list != null) {
            this.dXs = new a(list);
            this.dXr.setAdapter((ListAdapter) this.dXs);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.j.a
    public void MK() {
        super.MK();
        onChangeSkinType();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.j.a
    public void ML() {
        super.ML();
        this.bxI.setImageResource(0);
    }

    public void onChangeSkinType() {
        if (MJ()) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            aj.c(this.bxI, d.f.pic_emotion_01);
            aj.b(this.bxJ, d.C0140d.cp_cont_d, 1, skinType);
            aj.t(this.bxA, d.C0140d.cp_bg_line_d);
            aj.t(this.chX, d.C0140d.cp_bg_line_c);
            aj.b(this.mTitleView, d.C0140d.cp_cont_d, 1, skinType);
            aj.b(this.dXt, d.C0140d.cp_cont_f, 1, skinType);
            if (this.dXs != null) {
                this.dXs.notifyDataSetChanged();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class a extends BaseAdapter {
        private List<RecmForumInfo> dXu;

        public a(List<RecmForumInfo> list) {
            this.dXu = list;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return this.dXu.size();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.widget.Adapter
        /* renamed from: oc */
        public RecmForumInfo getItem(int i) {
            return this.dXu.get(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(final int i, View view, ViewGroup viewGroup) {
            C0159b c0159b;
            if (view == null) {
                view = LayoutInflater.from(b.this.mPageContext.getPageActivity()).inflate(d.h.recommend_view, (ViewGroup) null);
                C0159b c0159b2 = new C0159b();
                c0159b2.rootView = view.findViewById(d.g.root_view);
                c0159b2.dXx = (TextView) view.findViewById(d.g.forum_name);
                c0159b2.dXz = (TextView) view.findViewById(d.g.follow_tv);
                c0159b2.dXy = (TextView) view.findViewById(d.g.thread_tv);
                c0159b2.dXA = (ImageView) view.findViewById(d.g.arrow_item_img);
                c0159b2.dXB = (TbImageView) view.findViewById(d.g.headview);
                c0159b2.dXC = (TextView) view.findViewById(d.g.follow_title);
                c0159b2.dXD = (TextView) view.findViewById(d.g.thread_title);
                c0159b2.divider = view.findViewById(d.g.divider_line);
                c0159b2.dXE = (ImageView) view.findViewById(d.g.content_img);
                view.setTag(c0159b2);
                c0159b = c0159b2;
            } else {
                c0159b = (C0159b) view.getTag();
            }
            if (getItem(i) != null) {
                c0159b.dXx.setText(am.e(getItem(i).forum_name, 14, "..."));
                c0159b.dXB.startLoad(getItem(i).avatar, 10, false);
                c0159b.dXz.setText(am.C(getItem(i).member_count.intValue()));
                c0159b.dXy.setText(am.C(getItem(i).post_num.intValue()));
                c0159b.rootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.b.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (!StringUtils.isNull(a.this.getItem(i).forum_name)) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(b.this.mPageContext.getContext()).createNormalCfg(a.this.getItem(i).forum_name, null)));
                        }
                    }
                });
                aj.r(c0159b.dXx, d.C0140d.cp_cont_b);
                aj.r(c0159b.dXz, d.C0140d.cp_cont_d);
                aj.r(c0159b.dXy, d.C0140d.cp_cont_d);
                aj.r(c0159b.dXD, d.C0140d.cp_cont_d);
                aj.r(c0159b.dXC, d.C0140d.cp_cont_d);
                aj.s(c0159b.divider, d.C0140d.cp_bg_line_c);
                aj.c(c0159b.dXA, d.f.icon_arrow_gray_right_n);
                aj.s(view, d.f.addresslist_item_bg);
                aj.s(c0159b.dXE, d.f.picture_content_frame);
            }
            return view;
        }
    }
}
