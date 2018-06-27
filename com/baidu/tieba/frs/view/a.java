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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import java.util.List;
import tbclient.FrsPage.RecmForumInfo;
/* loaded from: classes2.dex */
public class a extends com.baidu.tbadk.j.a {
    protected TbImageView aRp;
    protected TextView aRq;
    private View bHc;
    private BdListView dFU;
    private C0161a dFV;
    private TextView dFW;
    private com.baidu.adp.base.e mPageContext;
    private TextView mTitleView;

    /* loaded from: classes2.dex */
    public static class b {
        public TextView dGa;
        public TextView dGb;
        public TextView dGc;
        public ImageView dGd;
        public TbImageView dGe;
        public TextView dGf;
        public TextView dGg;
        public ImageView dGh;
        public View divider;
        public View rootView;
    }

    public a(com.baidu.adp.base.e eVar, View.OnClickListener onClickListener) {
        super(LayoutInflater.from(eVar.getContext()).inflate(d.i.forbid_detail_view_layout, (ViewGroup) null));
        this.mPageContext = eVar;
        this.aRp = (TbImageView) this.aRh.findViewById(d.g.net_refresh_image);
        this.aRq = (TextView) this.aRh.findViewById(d.g.net_refresh_desc);
        this.bHc = this.aRh.findViewById(d.g.divider);
        this.dFU = (BdListView) this.aRh.findViewById(d.g.recommend_bar_listview);
        this.aRh.setOnClickListener(null);
        this.mTitleView = (TextView) this.aRh.findViewById(d.g.content_title);
        this.dFW = (TextView) this.aRh.findViewById(d.g.local_tip_tv);
    }

    public void setSubText(String str) {
        if (str == null) {
            this.aRq.setVisibility(8);
            return;
        }
        this.aRq.setVisibility(0);
        this.aRq.setText(str);
    }

    public void bC(List<RecmForumInfo> list) {
        if (list != null) {
            this.dFV = new C0161a(list);
            this.dFU.setAdapter((ListAdapter) this.dFV);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.j.a
    public void Ji() {
        super.Ji();
        onChangeSkinType();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.j.a
    public void Jj() {
        super.Jj();
        this.aRp.setImageResource(0);
    }

    public void onChangeSkinType() {
        if (Jh()) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            am.c(this.aRp, d.f.pic_emotion_01);
            am.b(this.aRq, d.C0142d.cp_cont_d, 1, skinType);
            am.j(this.aRh, d.C0142d.cp_bg_line_d);
            am.j(this.bHc, d.C0142d.cp_bg_line_c);
            am.b(this.mTitleView, d.C0142d.cp_cont_d, 1, skinType);
            am.b(this.dFW, d.C0142d.cp_cont_f, 1, skinType);
            if (this.dFV != null) {
                this.dFV.notifyDataSetChanged();
            }
        }
    }

    /* renamed from: com.baidu.tieba.frs.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0161a extends BaseAdapter {
        private List<RecmForumInfo> dFX;

        public C0161a(List<RecmForumInfo> list) {
            this.dFX = list;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return this.dFX.size();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.widget.Adapter
        /* renamed from: lP */
        public RecmForumInfo getItem(int i) {
            return this.dFX.get(i);
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
                bVar2.dGa = (TextView) view.findViewById(d.g.forum_name);
                bVar2.dGc = (TextView) view.findViewById(d.g.follow_tv);
                bVar2.dGb = (TextView) view.findViewById(d.g.thread_tv);
                bVar2.dGd = (ImageView) view.findViewById(d.g.arrow_item_img);
                bVar2.dGe = (TbImageView) view.findViewById(d.g.headview);
                bVar2.dGf = (TextView) view.findViewById(d.g.follow_title);
                bVar2.dGg = (TextView) view.findViewById(d.g.thread_title);
                bVar2.divider = view.findViewById(d.g.divider_line);
                bVar2.dGh = (ImageView) view.findViewById(d.g.content_img);
                view.setTag(bVar2);
                bVar = bVar2;
            } else {
                bVar = (b) view.getTag();
            }
            if (getItem(i) != null) {
                bVar.dGa.setText(ap.e(getItem(i).forum_name, 14, "..."));
                bVar.dGe.startLoad(getItem(i).avatar, 10, false);
                bVar.dGc.setText(ap.z(getItem(i).member_count.intValue()));
                bVar.dGb.setText(ap.z(getItem(i).post_num.intValue()));
                bVar.rootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.a.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (!StringUtils.isNull(C0161a.this.getItem(i).forum_name)) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(a.this.mPageContext.getContext()).createNormalCfg(C0161a.this.getItem(i).forum_name, null)));
                        }
                    }
                });
                am.h(bVar.dGa, d.C0142d.cp_cont_b);
                am.h(bVar.dGc, d.C0142d.cp_cont_d);
                am.h(bVar.dGb, d.C0142d.cp_cont_d);
                am.h(bVar.dGg, d.C0142d.cp_cont_d);
                am.h(bVar.dGf, d.C0142d.cp_cont_d);
                am.i(bVar.divider, d.C0142d.cp_bg_line_c);
                am.c(bVar.dGd, d.f.icon_arrow_gray_right_n);
                am.i(view, d.f.addresslist_item_bg);
                am.i(bVar.dGh, d.f.picture_content_frame);
            }
            return view;
        }
    }
}
