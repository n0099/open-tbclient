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
    protected TbImageView bvg;
    protected TextView bvh;
    private View cdQ;
    private BdListView dOt;
    private a dOu;
    private TextView dOv;
    private com.baidu.adp.base.e mPageContext;
    private TextView mTitleView;

    /* renamed from: com.baidu.tieba.frs.view.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0115b {
        public TextView dOA;
        public TextView dOB;
        public ImageView dOC;
        public TbImageView dOD;
        public TextView dOE;
        public TextView dOF;
        public ImageView dOG;
        public TextView dOz;
        public View divider;
        public View rootView;
    }

    public b(com.baidu.adp.base.e eVar, View.OnClickListener onClickListener) {
        super(LayoutInflater.from(eVar.getContext()).inflate(d.h.forbid_detail_view_layout, (ViewGroup) null));
        this.mPageContext = eVar;
        this.bvg = (TbImageView) this.buY.findViewById(d.g.net_refresh_image);
        this.bvh = (TextView) this.buY.findViewById(d.g.net_refresh_desc);
        this.cdQ = this.buY.findViewById(d.g.divider);
        this.dOt = (BdListView) this.buY.findViewById(d.g.recommend_bar_listview);
        this.buY.setOnClickListener(null);
        this.mTitleView = (TextView) this.buY.findViewById(d.g.content_title);
        this.dOv = (TextView) this.buY.findViewById(d.g.local_tip_tv);
    }

    public void gE(String str) {
        if (str == null) {
            this.bvh.setVisibility(8);
            return;
        }
        this.bvh.setVisibility(0);
        this.bvh.setText(str);
    }

    public void by(List<RecmForumInfo> list) {
        if (list != null) {
            this.dOu = new a(list);
            this.dOt.setAdapter((ListAdapter) this.dOu);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.j.a
    public void Mo() {
        super.Mo();
        onChangeSkinType();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.j.a
    public void Mp() {
        super.Mp();
        this.bvg.setImageResource(0);
    }

    public void onChangeSkinType() {
        if (Mn()) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            aj.c(this.bvg, d.f.pic_emotion_01);
            aj.b(this.bvh, d.C0108d.cp_cont_d, 1, skinType);
            aj.t(this.buY, d.C0108d.cp_bg_line_d);
            aj.t(this.cdQ, d.C0108d.cp_bg_line_c);
            aj.b(this.mTitleView, d.C0108d.cp_cont_d, 1, skinType);
            aj.b(this.dOv, d.C0108d.cp_cont_f, 1, skinType);
            if (this.dOu != null) {
                this.dOu.notifyDataSetChanged();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class a extends BaseAdapter {
        private List<RecmForumInfo> dOw;

        public a(List<RecmForumInfo> list) {
            this.dOw = list;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return this.dOw.size();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.widget.Adapter
        /* renamed from: nZ */
        public RecmForumInfo getItem(int i) {
            return this.dOw.get(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(final int i, View view, ViewGroup viewGroup) {
            C0115b c0115b;
            if (view == null) {
                view = LayoutInflater.from(b.this.mPageContext.getPageActivity()).inflate(d.h.recommend_view, (ViewGroup) null);
                C0115b c0115b2 = new C0115b();
                c0115b2.rootView = view.findViewById(d.g.root_view);
                c0115b2.dOz = (TextView) view.findViewById(d.g.forum_name);
                c0115b2.dOB = (TextView) view.findViewById(d.g.follow_tv);
                c0115b2.dOA = (TextView) view.findViewById(d.g.thread_tv);
                c0115b2.dOC = (ImageView) view.findViewById(d.g.arrow_item_img);
                c0115b2.dOD = (TbImageView) view.findViewById(d.g.headview);
                c0115b2.dOE = (TextView) view.findViewById(d.g.follow_title);
                c0115b2.dOF = (TextView) view.findViewById(d.g.thread_title);
                c0115b2.divider = view.findViewById(d.g.divider_line);
                c0115b2.dOG = (ImageView) view.findViewById(d.g.content_img);
                view.setTag(c0115b2);
                c0115b = c0115b2;
            } else {
                c0115b = (C0115b) view.getTag();
            }
            if (getItem(i) != null) {
                c0115b.dOz.setText(am.e(getItem(i).forum_name, 14, "..."));
                c0115b.dOD.startLoad(getItem(i).avatar, 10, false);
                c0115b.dOB.setText(am.C(getItem(i).member_count.intValue()));
                c0115b.dOA.setText(am.C(getItem(i).post_num.intValue()));
                c0115b.rootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.b.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (!StringUtils.isNull(a.this.getItem(i).forum_name)) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(b.this.mPageContext.getContext()).createNormalCfg(a.this.getItem(i).forum_name, null)));
                        }
                    }
                });
                aj.r(c0115b.dOz, d.C0108d.cp_cont_b);
                aj.r(c0115b.dOB, d.C0108d.cp_cont_d);
                aj.r(c0115b.dOA, d.C0108d.cp_cont_d);
                aj.r(c0115b.dOF, d.C0108d.cp_cont_d);
                aj.r(c0115b.dOE, d.C0108d.cp_cont_d);
                aj.s(c0115b.divider, d.C0108d.cp_bg_line_c);
                aj.c(c0115b.dOC, d.f.icon_arrow_gray_right_n);
                aj.s(view, d.f.addresslist_item_bg);
                aj.s(c0115b.dOG, d.f.picture_content_frame);
            }
            return view;
        }
    }
}
