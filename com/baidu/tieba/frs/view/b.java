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
    protected TbImageView bxy;
    protected TextView bxz;
    private View chO;
    private BdListView dXl;
    private a dXm;
    private TextView dXn;
    private com.baidu.adp.base.e mPageContext;
    private TextView mTitleView;

    /* renamed from: com.baidu.tieba.frs.view.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0160b {
        public TextView dXr;
        public TextView dXs;
        public TextView dXt;
        public ImageView dXu;
        public TbImageView dXv;
        public TextView dXw;
        public TextView dXx;
        public ImageView dXy;
        public View divider;
        public View rootView;
    }

    public b(com.baidu.adp.base.e eVar, View.OnClickListener onClickListener) {
        super(LayoutInflater.from(eVar.getContext()).inflate(d.h.forbid_detail_view_layout, (ViewGroup) null));
        this.mPageContext = eVar;
        this.bxy = (TbImageView) this.bxq.findViewById(d.g.net_refresh_image);
        this.bxz = (TextView) this.bxq.findViewById(d.g.net_refresh_desc);
        this.chO = this.bxq.findViewById(d.g.divider);
        this.dXl = (BdListView) this.bxq.findViewById(d.g.recommend_bar_listview);
        this.bxq.setOnClickListener(null);
        this.mTitleView = (TextView) this.bxq.findViewById(d.g.content_title);
        this.dXn = (TextView) this.bxq.findViewById(d.g.local_tip_tv);
    }

    public void gW(String str) {
        if (str == null) {
            this.bxz.setVisibility(8);
            return;
        }
        this.bxz.setVisibility(0);
        this.bxz.setText(str);
    }

    public void by(List<RecmForumInfo> list) {
        if (list != null) {
            this.dXm = new a(list);
            this.dXl.setAdapter((ListAdapter) this.dXm);
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
        this.bxy.setImageResource(0);
    }

    public void onChangeSkinType() {
        if (MJ()) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            aj.c(this.bxy, d.f.pic_emotion_01);
            aj.b(this.bxz, d.C0141d.cp_cont_d, 1, skinType);
            aj.t(this.bxq, d.C0141d.cp_bg_line_d);
            aj.t(this.chO, d.C0141d.cp_bg_line_c);
            aj.b(this.mTitleView, d.C0141d.cp_cont_d, 1, skinType);
            aj.b(this.dXn, d.C0141d.cp_cont_f, 1, skinType);
            if (this.dXm != null) {
                this.dXm.notifyDataSetChanged();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class a extends BaseAdapter {
        private List<RecmForumInfo> dXo;

        public a(List<RecmForumInfo> list) {
            this.dXo = list;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return this.dXo.size();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.widget.Adapter
        /* renamed from: oc */
        public RecmForumInfo getItem(int i) {
            return this.dXo.get(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(final int i, View view, ViewGroup viewGroup) {
            C0160b c0160b;
            if (view == null) {
                view = LayoutInflater.from(b.this.mPageContext.getPageActivity()).inflate(d.h.recommend_view, (ViewGroup) null);
                C0160b c0160b2 = new C0160b();
                c0160b2.rootView = view.findViewById(d.g.root_view);
                c0160b2.dXr = (TextView) view.findViewById(d.g.forum_name);
                c0160b2.dXt = (TextView) view.findViewById(d.g.follow_tv);
                c0160b2.dXs = (TextView) view.findViewById(d.g.thread_tv);
                c0160b2.dXu = (ImageView) view.findViewById(d.g.arrow_item_img);
                c0160b2.dXv = (TbImageView) view.findViewById(d.g.headview);
                c0160b2.dXw = (TextView) view.findViewById(d.g.follow_title);
                c0160b2.dXx = (TextView) view.findViewById(d.g.thread_title);
                c0160b2.divider = view.findViewById(d.g.divider_line);
                c0160b2.dXy = (ImageView) view.findViewById(d.g.content_img);
                view.setTag(c0160b2);
                c0160b = c0160b2;
            } else {
                c0160b = (C0160b) view.getTag();
            }
            if (getItem(i) != null) {
                c0160b.dXr.setText(am.e(getItem(i).forum_name, 14, "..."));
                c0160b.dXv.startLoad(getItem(i).avatar, 10, false);
                c0160b.dXt.setText(am.C(getItem(i).member_count.intValue()));
                c0160b.dXs.setText(am.C(getItem(i).post_num.intValue()));
                c0160b.rootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.b.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (!StringUtils.isNull(a.this.getItem(i).forum_name)) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(b.this.mPageContext.getContext()).createNormalCfg(a.this.getItem(i).forum_name, null)));
                        }
                    }
                });
                aj.r(c0160b.dXr, d.C0141d.cp_cont_b);
                aj.r(c0160b.dXt, d.C0141d.cp_cont_d);
                aj.r(c0160b.dXs, d.C0141d.cp_cont_d);
                aj.r(c0160b.dXx, d.C0141d.cp_cont_d);
                aj.r(c0160b.dXw, d.C0141d.cp_cont_d);
                aj.s(c0160b.divider, d.C0141d.cp_bg_line_c);
                aj.c(c0160b.dXu, d.f.icon_arrow_gray_right_n);
                aj.s(view, d.f.addresslist_item_bg);
                aj.s(c0160b.dXy, d.f.picture_content_frame);
            }
            return view;
        }
    }
}
