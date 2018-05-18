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
    protected TbImageView aHW;
    protected TextView aHX;
    private View bxe;
    private BdListView dtu;
    private C0144a dtv;
    private TextView dtw;
    private com.baidu.adp.base.e mPageContext;
    private TextView mTitleView;

    /* loaded from: classes2.dex */
    public static class b {
        public View divider;
        public TextView dtA;
        public TextView dtB;
        public TextView dtC;
        public ImageView dtD;
        public TbImageView dtE;
        public TextView dtF;
        public TextView dtG;
        public ImageView dtH;
        public View rootView;
    }

    public a(com.baidu.adp.base.e eVar, View.OnClickListener onClickListener) {
        super(LayoutInflater.from(eVar.getContext()).inflate(d.i.forbid_detail_view_layout, (ViewGroup) null));
        this.mPageContext = eVar;
        this.aHW = (TbImageView) this.aHO.findViewById(d.g.net_refresh_image);
        this.aHX = (TextView) this.aHO.findViewById(d.g.net_refresh_desc);
        this.bxe = this.aHO.findViewById(d.g.divider);
        this.dtu = (BdListView) this.aHO.findViewById(d.g.recommend_bar_listview);
        this.aHO.setOnClickListener(null);
        this.mTitleView = (TextView) this.aHO.findViewById(d.g.content_title);
        this.dtw = (TextView) this.aHO.findViewById(d.g.local_tip_tv);
    }

    public void setSubText(String str) {
        if (str == null) {
            this.aHX.setVisibility(8);
            return;
        }
        this.aHX.setVisibility(0);
        this.aHX.setText(str);
    }

    public void bv(List<RecmForumInfo> list) {
        if (list != null) {
            this.dtv = new C0144a(list);
            this.dtu.setAdapter((ListAdapter) this.dtv);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.j.a
    public void Fl() {
        super.Fl();
        onChangeSkinType();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.j.a
    public void Fm() {
        super.Fm();
        this.aHW.setImageResource(0);
    }

    public void onChangeSkinType() {
        if (Fk()) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            ak.c(this.aHW, d.f.pic_emotion_01);
            ak.b(this.aHX, d.C0126d.cp_cont_d, 1, skinType);
            ak.j(this.aHO, d.C0126d.cp_bg_line_d);
            ak.j(this.bxe, d.C0126d.cp_bg_line_c);
            ak.b(this.mTitleView, d.C0126d.cp_cont_d, 1, skinType);
            ak.b(this.dtw, d.C0126d.cp_cont_f, 1, skinType);
            if (this.dtv != null) {
                this.dtv.notifyDataSetChanged();
            }
        }
    }

    /* renamed from: com.baidu.tieba.frs.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0144a extends BaseAdapter {
        private List<RecmForumInfo> dtx;

        public C0144a(List<RecmForumInfo> list) {
            this.dtx = list;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return this.dtx.size();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.widget.Adapter
        /* renamed from: lB */
        public RecmForumInfo getItem(int i) {
            return this.dtx.get(i);
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
                bVar2.dtA = (TextView) view2.findViewById(d.g.forum_name);
                bVar2.dtC = (TextView) view2.findViewById(d.g.follow_tv);
                bVar2.dtB = (TextView) view2.findViewById(d.g.thread_tv);
                bVar2.dtD = (ImageView) view2.findViewById(d.g.arrow_item_img);
                bVar2.dtE = (TbImageView) view2.findViewById(d.g.headview);
                bVar2.dtF = (TextView) view2.findViewById(d.g.follow_title);
                bVar2.dtG = (TextView) view2.findViewById(d.g.thread_title);
                bVar2.divider = view2.findViewById(d.g.divider_line);
                bVar2.dtH = (ImageView) view2.findViewById(d.g.content_img);
                view2.setTag(bVar2);
                bVar = bVar2;
            } else {
                bVar = (b) view2.getTag();
            }
            if (getItem(i) != null) {
                bVar.dtA.setText(an.e(getItem(i).forum_name, 14, "..."));
                bVar.dtE.startLoad(getItem(i).avatar, 10, false);
                bVar.dtC.setText(an.v(getItem(i).member_count.intValue()));
                bVar.dtB.setText(an.v(getItem(i).post_num.intValue()));
                bVar.rootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.a.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view3) {
                        if (!StringUtils.isNull(C0144a.this.getItem(i).forum_name)) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(a.this.mPageContext.getContext()).createNormalCfg(C0144a.this.getItem(i).forum_name, null)));
                        }
                    }
                });
                ak.h(bVar.dtA, d.C0126d.cp_cont_b);
                ak.h(bVar.dtC, d.C0126d.cp_cont_d);
                ak.h(bVar.dtB, d.C0126d.cp_cont_d);
                ak.h(bVar.dtG, d.C0126d.cp_cont_d);
                ak.h(bVar.dtF, d.C0126d.cp_cont_d);
                ak.i(bVar.divider, d.C0126d.cp_bg_line_c);
                ak.c(bVar.dtD, d.f.icon_arrow_gray_right_n);
                ak.i(view2, d.f.addresslist_item_bg);
                ak.i(bVar.dtH, d.f.picture_content_frame);
            }
            return view2;
        }
    }
}
