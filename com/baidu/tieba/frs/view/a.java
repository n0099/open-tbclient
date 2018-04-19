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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import java.util.List;
import tbclient.FrsPage.RecmForumInfo;
/* loaded from: classes2.dex */
public class a extends com.baidu.tbadk.j.a {
    protected TbImageView aHV;
    protected TextView aHW;
    private View bwn;
    private BdListView dsp;
    private C0144a dsq;
    private TextView dsr;
    private com.baidu.adp.base.e mPageContext;
    private TextView mTitleView;

    /* loaded from: classes2.dex */
    public static class b {
        public View divider;
        public TextView dsA;
        public TextView dsB;
        public ImageView dsC;
        public TextView dsv;
        public TextView dsw;
        public TextView dsx;
        public ImageView dsy;
        public TbImageView dsz;
        public View rootView;
    }

    public a(com.baidu.adp.base.e eVar, View.OnClickListener onClickListener) {
        super(LayoutInflater.from(eVar.getContext()).inflate(d.i.forbid_detail_view_layout, (ViewGroup) null));
        this.mPageContext = eVar;
        this.aHV = (TbImageView) this.aHN.findViewById(d.g.net_refresh_image);
        this.aHW = (TextView) this.aHN.findViewById(d.g.net_refresh_desc);
        this.bwn = this.aHN.findViewById(d.g.divider);
        this.dsp = (BdListView) this.aHN.findViewById(d.g.recommend_bar_listview);
        this.aHN.setOnClickListener(null);
        this.mTitleView = (TextView) this.aHN.findViewById(d.g.content_title);
        this.dsr = (TextView) this.aHN.findViewById(d.g.local_tip_tv);
    }

    public void setSubText(String str) {
        if (str == null) {
            this.aHW.setVisibility(8);
            return;
        }
        this.aHW.setVisibility(0);
        this.aHW.setText(str);
    }

    public void bs(List<RecmForumInfo> list) {
        if (list != null) {
            this.dsq = new C0144a(list);
            this.dsp.setAdapter((ListAdapter) this.dsq);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.j.a
    public void Fn() {
        super.Fn();
        onChangeSkinType();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.j.a
    public void Fo() {
        super.Fo();
        this.aHV.setImageResource(0);
    }

    public void onChangeSkinType() {
        if (Fm()) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            ak.c(this.aHV, d.f.pic_emotion_01);
            ak.b(this.aHW, d.C0126d.cp_cont_d, 1, skinType);
            ak.j(this.aHN, d.C0126d.cp_bg_line_d);
            ak.j(this.bwn, d.C0126d.cp_bg_line_c);
            ak.b(this.mTitleView, d.C0126d.cp_cont_d, 1, skinType);
            ak.b(this.dsr, d.C0126d.cp_cont_f, 1, skinType);
            if (this.dsq != null) {
                this.dsq.notifyDataSetChanged();
            }
        }
    }

    /* renamed from: com.baidu.tieba.frs.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0144a extends BaseAdapter {
        private List<RecmForumInfo> dss;

        public C0144a(List<RecmForumInfo> list) {
            this.dss = list;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return this.dss.size();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.widget.Adapter
        /* renamed from: lC */
        public RecmForumInfo getItem(int i) {
            return this.dss.get(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(final int i, View view2, ViewGroup viewGroup) {
            b bVar;
            if (view2 == null) {
                view2 = LayoutInflater.from(a.this.mPageContext.getPageActivity()).inflate(d.i.recommend_view, (ViewGroup) null);
                b bVar2 = new b();
                bVar2.rootView = view2.findViewById(d.g.root_view);
                bVar2.dsv = (TextView) view2.findViewById(d.g.forum_name);
                bVar2.dsx = (TextView) view2.findViewById(d.g.follow_tv);
                bVar2.dsw = (TextView) view2.findViewById(d.g.thread_tv);
                bVar2.dsy = (ImageView) view2.findViewById(d.g.arrow_item_img);
                bVar2.dsz = (TbImageView) view2.findViewById(d.g.headview);
                bVar2.dsA = (TextView) view2.findViewById(d.g.follow_title);
                bVar2.dsB = (TextView) view2.findViewById(d.g.thread_title);
                bVar2.divider = view2.findViewById(d.g.divider_line);
                bVar2.dsC = (ImageView) view2.findViewById(d.g.content_img);
                view2.setTag(bVar2);
                bVar = bVar2;
            } else {
                bVar = (b) view2.getTag();
            }
            if (getItem(i) != null) {
                bVar.dsv.setText(an.e(getItem(i).forum_name, 14, "..."));
                bVar.dsz.startLoad(getItem(i).avatar, 10, false);
                bVar.dsx.setText(an.v(getItem(i).member_count.intValue()));
                bVar.dsw.setText(an.v(getItem(i).post_num.intValue()));
                bVar.rootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.a.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view3) {
                        if (!StringUtils.isNull(C0144a.this.getItem(i).forum_name)) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(a.this.mPageContext.getContext()).createNormalCfg(C0144a.this.getItem(i).forum_name, null)));
                        }
                    }
                });
                ak.h(bVar.dsv, d.C0126d.cp_cont_b);
                ak.h(bVar.dsx, d.C0126d.cp_cont_d);
                ak.h(bVar.dsw, d.C0126d.cp_cont_d);
                ak.h(bVar.dsB, d.C0126d.cp_cont_d);
                ak.h(bVar.dsA, d.C0126d.cp_cont_d);
                ak.i(bVar.divider, d.C0126d.cp_bg_line_c);
                ak.c(bVar.dsy, d.f.icon_arrow_gray_right_n);
                ak.i(view2, d.f.addresslist_item_bg);
                ak.i(bVar.dsC, d.f.picture_content_frame);
            }
            return view2;
        }
    }
}
