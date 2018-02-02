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
    protected TbImageView bvy;
    protected TextView bvz;
    private View cef;
    private BdListView dTC;
    private a dTD;
    private TextView dTE;
    private com.baidu.adp.base.e mPageContext;
    private TextView mTitleView;

    /* renamed from: com.baidu.tieba.frs.view.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0115b {
        public TextView dTI;
        public TextView dTJ;
        public TextView dTK;
        public ImageView dTL;
        public TbImageView dTM;
        public TextView dTN;
        public TextView dTO;
        public ImageView dTP;
        public View divider;
        public View rootView;
    }

    public b(com.baidu.adp.base.e eVar, View.OnClickListener onClickListener) {
        super(LayoutInflater.from(eVar.getContext()).inflate(d.h.forbid_detail_view_layout, (ViewGroup) null));
        this.mPageContext = eVar;
        this.bvy = (TbImageView) this.bvq.findViewById(d.g.net_refresh_image);
        this.bvz = (TextView) this.bvq.findViewById(d.g.net_refresh_desc);
        this.cef = this.bvq.findViewById(d.g.divider);
        this.dTC = (BdListView) this.bvq.findViewById(d.g.recommend_bar_listview);
        this.bvq.setOnClickListener(null);
        this.mTitleView = (TextView) this.bvq.findViewById(d.g.content_title);
        this.dTE = (TextView) this.bvq.findViewById(d.g.local_tip_tv);
    }

    public void gN(String str) {
        if (str == null) {
            this.bvz.setVisibility(8);
            return;
        }
        this.bvz.setVisibility(0);
        this.bvz.setText(str);
    }

    public void bw(List<RecmForumInfo> list) {
        if (list != null) {
            this.dTD = new a(list);
            this.dTC.setAdapter((ListAdapter) this.dTD);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.j.a
    public void Me() {
        super.Me();
        onChangeSkinType();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.j.a
    public void Mf() {
        super.Mf();
        this.bvy.setImageResource(0);
    }

    public void onChangeSkinType() {
        if (Md()) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            aj.c(this.bvy, d.f.pic_emotion_01);
            aj.b(this.bvz, d.C0108d.cp_cont_d, 1, skinType);
            aj.t(this.bvq, d.C0108d.cp_bg_line_d);
            aj.t(this.cef, d.C0108d.cp_bg_line_c);
            aj.b(this.mTitleView, d.C0108d.cp_cont_d, 1, skinType);
            aj.b(this.dTE, d.C0108d.cp_cont_f, 1, skinType);
            if (this.dTD != null) {
                this.dTD.notifyDataSetChanged();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class a extends BaseAdapter {
        private List<RecmForumInfo> dTF;

        public a(List<RecmForumInfo> list) {
            this.dTF = list;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return this.dTF.size();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.widget.Adapter
        /* renamed from: oc */
        public RecmForumInfo getItem(int i) {
            return this.dTF.get(i);
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
                c0115b2.dTI = (TextView) view.findViewById(d.g.forum_name);
                c0115b2.dTK = (TextView) view.findViewById(d.g.follow_tv);
                c0115b2.dTJ = (TextView) view.findViewById(d.g.thread_tv);
                c0115b2.dTL = (ImageView) view.findViewById(d.g.arrow_item_img);
                c0115b2.dTM = (TbImageView) view.findViewById(d.g.headview);
                c0115b2.dTN = (TextView) view.findViewById(d.g.follow_title);
                c0115b2.dTO = (TextView) view.findViewById(d.g.thread_title);
                c0115b2.divider = view.findViewById(d.g.divider_line);
                c0115b2.dTP = (ImageView) view.findViewById(d.g.content_img);
                view.setTag(c0115b2);
                c0115b = c0115b2;
            } else {
                c0115b = (C0115b) view.getTag();
            }
            if (getItem(i) != null) {
                c0115b.dTI.setText(am.e(getItem(i).forum_name, 14, "..."));
                c0115b.dTM.startLoad(getItem(i).avatar, 10, false);
                c0115b.dTK.setText(am.C(getItem(i).member_count.intValue()));
                c0115b.dTJ.setText(am.C(getItem(i).post_num.intValue()));
                c0115b.rootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.b.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (!StringUtils.isNull(a.this.getItem(i).forum_name)) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(b.this.mPageContext.getContext()).createNormalCfg(a.this.getItem(i).forum_name, null)));
                        }
                    }
                });
                aj.r(c0115b.dTI, d.C0108d.cp_cont_b);
                aj.r(c0115b.dTK, d.C0108d.cp_cont_d);
                aj.r(c0115b.dTJ, d.C0108d.cp_cont_d);
                aj.r(c0115b.dTO, d.C0108d.cp_cont_d);
                aj.r(c0115b.dTN, d.C0108d.cp_cont_d);
                aj.s(c0115b.divider, d.C0108d.cp_bg_line_c);
                aj.c(c0115b.dTL, d.f.icon_arrow_gray_right_n);
                aj.s(view, d.f.addresslist_item_bg);
                aj.s(c0115b.dTP, d.f.picture_content_frame);
            }
            return view;
        }
    }
}
