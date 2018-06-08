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
import com.baidu.tieba.d;
import java.util.List;
import tbclient.FrsPage.RecmForumInfo;
/* loaded from: classes2.dex */
public class a extends com.baidu.tbadk.j.a {
    protected TbImageView aQt;
    protected TextView aQu;
    private View bFh;
    private BdListView dCH;
    private C0159a dCI;
    private TextView dCJ;
    private com.baidu.adp.base.e mPageContext;
    private TextView mTitleView;

    /* loaded from: classes2.dex */
    public static class b {
        public TextView dCN;
        public TextView dCO;
        public TextView dCP;
        public ImageView dCQ;
        public TbImageView dCR;
        public TextView dCS;
        public TextView dCT;
        public ImageView dCU;
        public View divider;
        public View rootView;
    }

    public a(com.baidu.adp.base.e eVar, View.OnClickListener onClickListener) {
        super(LayoutInflater.from(eVar.getContext()).inflate(d.i.forbid_detail_view_layout, (ViewGroup) null));
        this.mPageContext = eVar;
        this.aQt = (TbImageView) this.aQl.findViewById(d.g.net_refresh_image);
        this.aQu = (TextView) this.aQl.findViewById(d.g.net_refresh_desc);
        this.bFh = this.aQl.findViewById(d.g.divider);
        this.dCH = (BdListView) this.aQl.findViewById(d.g.recommend_bar_listview);
        this.aQl.setOnClickListener(null);
        this.mTitleView = (TextView) this.aQl.findViewById(d.g.content_title);
        this.dCJ = (TextView) this.aQl.findViewById(d.g.local_tip_tv);
    }

    public void setSubText(String str) {
        if (str == null) {
            this.aQu.setVisibility(8);
            return;
        }
        this.aQu.setVisibility(0);
        this.aQu.setText(str);
    }

    public void by(List<RecmForumInfo> list) {
        if (list != null) {
            this.dCI = new C0159a(list);
            this.dCH.setAdapter((ListAdapter) this.dCI);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.j.a
    public void IQ() {
        super.IQ();
        onChangeSkinType();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.j.a
    public void IR() {
        super.IR();
        this.aQt.setImageResource(0);
    }

    public void onChangeSkinType() {
        if (IP()) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            al.c(this.aQt, d.f.pic_emotion_01);
            al.b(this.aQu, d.C0141d.cp_cont_d, 1, skinType);
            al.j(this.aQl, d.C0141d.cp_bg_line_d);
            al.j(this.bFh, d.C0141d.cp_bg_line_c);
            al.b(this.mTitleView, d.C0141d.cp_cont_d, 1, skinType);
            al.b(this.dCJ, d.C0141d.cp_cont_f, 1, skinType);
            if (this.dCI != null) {
                this.dCI.notifyDataSetChanged();
            }
        }
    }

    /* renamed from: com.baidu.tieba.frs.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0159a extends BaseAdapter {
        private List<RecmForumInfo> dCK;

        public C0159a(List<RecmForumInfo> list) {
            this.dCK = list;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return this.dCK.size();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.widget.Adapter
        /* renamed from: lI */
        public RecmForumInfo getItem(int i) {
            return this.dCK.get(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(final int i, View view, ViewGroup viewGroup) {
            b bVar;
            if (view == null) {
                view = LayoutInflater.from(a.this.mPageContext.getPageActivity()).inflate(d.i.recommend_view, (ViewGroup) null);
                b bVar2 = new b();
                bVar2.rootView = view.findViewById(d.g.root_view);
                bVar2.dCN = (TextView) view.findViewById(d.g.forum_name);
                bVar2.dCP = (TextView) view.findViewById(d.g.follow_tv);
                bVar2.dCO = (TextView) view.findViewById(d.g.thread_tv);
                bVar2.dCQ = (ImageView) view.findViewById(d.g.arrow_item_img);
                bVar2.dCR = (TbImageView) view.findViewById(d.g.headview);
                bVar2.dCS = (TextView) view.findViewById(d.g.follow_title);
                bVar2.dCT = (TextView) view.findViewById(d.g.thread_title);
                bVar2.divider = view.findViewById(d.g.divider_line);
                bVar2.dCU = (ImageView) view.findViewById(d.g.content_img);
                view.setTag(bVar2);
                bVar = bVar2;
            } else {
                bVar = (b) view.getTag();
            }
            if (getItem(i) != null) {
                bVar.dCN.setText(ao.e(getItem(i).forum_name, 14, "..."));
                bVar.dCR.startLoad(getItem(i).avatar, 10, false);
                bVar.dCP.setText(ao.y(getItem(i).member_count.intValue()));
                bVar.dCO.setText(ao.y(getItem(i).post_num.intValue()));
                bVar.rootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.a.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (!StringUtils.isNull(C0159a.this.getItem(i).forum_name)) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(a.this.mPageContext.getContext()).createNormalCfg(C0159a.this.getItem(i).forum_name, null)));
                        }
                    }
                });
                al.h(bVar.dCN, d.C0141d.cp_cont_b);
                al.h(bVar.dCP, d.C0141d.cp_cont_d);
                al.h(bVar.dCO, d.C0141d.cp_cont_d);
                al.h(bVar.dCT, d.C0141d.cp_cont_d);
                al.h(bVar.dCS, d.C0141d.cp_cont_d);
                al.i(bVar.divider, d.C0141d.cp_bg_line_c);
                al.c(bVar.dCQ, d.f.icon_arrow_gray_right_n);
                al.i(view, d.f.addresslist_item_bg);
                al.i(bVar.dCU, d.f.picture_content_frame);
            }
            return view;
        }
    }
}
