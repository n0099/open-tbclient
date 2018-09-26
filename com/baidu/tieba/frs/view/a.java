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
import com.baidu.tieba.e;
import java.util.List;
import tbclient.FrsPage.RecmForumInfo;
/* loaded from: classes2.dex */
public class a extends com.baidu.tbadk.k.a {
    protected TbImageView aUE;
    protected TextView aUF;
    private View bNG;
    private BdListView dPP;
    private C0161a dPQ;
    private TextView dPR;
    private com.baidu.adp.base.e mPageContext;
    private TextView mTitleView;

    /* loaded from: classes2.dex */
    public static class b {
        public TextView dPV;
        public TextView dPW;
        public TextView dPX;
        public ImageView dPY;
        public TbImageView dPZ;
        public TextView dQa;
        public TextView dQb;
        public ImageView dQc;
        public View divider;
        public View rootView;
    }

    public a(com.baidu.adp.base.e eVar, View.OnClickListener onClickListener) {
        super(LayoutInflater.from(eVar.getContext()).inflate(e.h.forbid_detail_view_layout, (ViewGroup) null));
        this.mPageContext = eVar;
        this.aUE = (TbImageView) this.aUw.findViewById(e.g.net_refresh_image);
        this.aUF = (TextView) this.aUw.findViewById(e.g.net_refresh_desc);
        this.bNG = this.aUw.findViewById(e.g.divider);
        this.dPP = (BdListView) this.aUw.findViewById(e.g.recommend_bar_listview);
        this.aUw.setOnClickListener(null);
        this.mTitleView = (TextView) this.aUw.findViewById(e.g.content_title);
        this.dPR = (TextView) this.aUw.findViewById(e.g.local_tip_tv);
    }

    public void hG(String str) {
        if (str == null) {
            this.aUF.setVisibility(8);
            return;
        }
        this.aUF.setVisibility(0);
        this.aUF.setText(str);
    }

    public void bC(List<RecmForumInfo> list) {
        if (list != null) {
            this.dPQ = new C0161a(list);
            this.dPP.setAdapter((ListAdapter) this.dPQ);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.k.a
    public void Kt() {
        super.Kt();
        onChangeSkinType();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.k.a
    public void Ku() {
        super.Ku();
        this.aUE.setImageResource(0);
    }

    public void onChangeSkinType() {
        if (Ks()) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            al.c(this.aUE, e.f.pic_emotion_01);
            al.b(this.aUF, e.d.cp_cont_d, 1, skinType);
            al.j(this.aUw, e.d.cp_bg_line_d);
            al.j(this.bNG, e.d.cp_bg_line_c);
            al.b(this.mTitleView, e.d.cp_cont_d, 1, skinType);
            al.b(this.dPR, e.d.cp_cont_f, 1, skinType);
            if (this.dPQ != null) {
                this.dPQ.notifyDataSetChanged();
            }
        }
    }

    /* renamed from: com.baidu.tieba.frs.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0161a extends BaseAdapter {
        private List<RecmForumInfo> dPS;

        public C0161a(List<RecmForumInfo> list) {
            this.dPS = list;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return this.dPS.size();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.widget.Adapter
        /* renamed from: mF */
        public RecmForumInfo getItem(int i) {
            return this.dPS.get(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(final int i, View view, ViewGroup viewGroup) {
            b bVar;
            if (view == null) {
                view = LayoutInflater.from(a.this.mPageContext.getPageActivity()).inflate(e.h.recommend_view, (ViewGroup) null);
                b bVar2 = new b();
                bVar2.rootView = view.findViewById(e.g.root_view);
                bVar2.dPV = (TextView) view.findViewById(e.g.forum_name);
                bVar2.dPX = (TextView) view.findViewById(e.g.follow_tv);
                bVar2.dPW = (TextView) view.findViewById(e.g.thread_tv);
                bVar2.dPY = (ImageView) view.findViewById(e.g.arrow_item_img);
                bVar2.dPZ = (TbImageView) view.findViewById(e.g.headview);
                bVar2.dQa = (TextView) view.findViewById(e.g.follow_title);
                bVar2.dQb = (TextView) view.findViewById(e.g.thread_title);
                bVar2.divider = view.findViewById(e.g.divider_line);
                bVar2.dQc = (ImageView) view.findViewById(e.g.content_img);
                view.setTag(bVar2);
                bVar = bVar2;
            } else {
                bVar = (b) view.getTag();
            }
            if (getItem(i) != null) {
                bVar.dPV.setText(ao.d(getItem(i).forum_name, 14, "..."));
                bVar.dPZ.startLoad(getItem(i).avatar, 10, false);
                bVar.dPX.setText(ao.E(getItem(i).member_count.intValue()));
                bVar.dPW.setText(ao.E(getItem(i).post_num.intValue()));
                bVar.rootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.a.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (!StringUtils.isNull(C0161a.this.getItem(i).forum_name)) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(a.this.mPageContext.getContext()).createNormalCfg(C0161a.this.getItem(i).forum_name, null)));
                        }
                    }
                });
                al.h(bVar.dPV, e.d.cp_cont_b);
                al.h(bVar.dPX, e.d.cp_cont_d);
                al.h(bVar.dPW, e.d.cp_cont_d);
                al.h(bVar.dQb, e.d.cp_cont_d);
                al.h(bVar.dQa, e.d.cp_cont_d);
                al.i(bVar.divider, e.d.cp_bg_line_c);
                al.c(bVar.dPY, e.f.icon_arrow_gray_right_n);
                al.i(view, e.f.addresslist_item_bg);
                al.i(bVar.dQc, e.f.picture_content_frame);
            }
            return view;
        }
    }
}
