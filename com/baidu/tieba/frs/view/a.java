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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import java.util.List;
import tbclient.FrsPage.RecmForumInfo;
/* loaded from: classes4.dex */
public class a extends com.baidu.tbadk.m.a {
    private View aLf;
    protected TbImageView cnA;
    protected TextView cnB;
    private BdListView fyc;
    private C0300a fyd;
    private TextView fye;
    private com.baidu.adp.base.e mPageContext;
    private TextView mTitleView;

    /* loaded from: classes4.dex */
    public static class b {
        public View divider;
        public TextView fyi;
        public TextView fyj;
        public TextView fyk;
        public ImageView fyl;
        public TbImageView fym;
        public TextView fyn;
        public TextView fyo;
        public ImageView fyp;
        public View rootView;
    }

    public a(com.baidu.adp.base.e eVar, View.OnClickListener onClickListener) {
        super(LayoutInflater.from(eVar.getContext()).inflate(d.h.forbid_detail_view_layout, (ViewGroup) null));
        this.mPageContext = eVar;
        this.cnA = (TbImageView) this.attachedView.findViewById(d.g.net_refresh_image);
        this.cnB = (TextView) this.attachedView.findViewById(d.g.net_refresh_desc);
        this.aLf = this.attachedView.findViewById(d.g.divider);
        this.fyc = (BdListView) this.attachedView.findViewById(d.g.recommend_bar_listview);
        this.attachedView.setOnClickListener(null);
        this.mTitleView = (TextView) this.attachedView.findViewById(d.g.content_title);
        this.fye = (TextView) this.attachedView.findViewById(d.g.local_tip_tv);
    }

    public void pp(String str) {
        if (str == null) {
            this.cnB.setVisibility(8);
            return;
        }
        this.cnB.setVisibility(0);
        this.cnB.setText(str);
    }

    public void cg(List<RecmForumInfo> list) {
        if (list != null) {
            this.fyd = new C0300a(list);
            this.fyc.setAdapter((ListAdapter) this.fyd);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.m.a
    public void onViewAttached() {
        super.onViewAttached();
        onChangeSkinType();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.m.a
    public void onViewDettached() {
        super.onViewDettached();
        this.cnA.setImageResource(0);
    }

    public void onChangeSkinType() {
        if (isViewAttached()) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            al.c(this.cnA, d.f.new_pic_emotion_01);
            al.c(this.cnB, d.C0277d.cp_cont_d, 1, skinType);
            al.l(this.attachedView, d.C0277d.cp_bg_line_d);
            al.l(this.aLf, d.C0277d.cp_bg_line_c);
            al.c(this.mTitleView, d.C0277d.cp_cont_d, 1, skinType);
            al.c(this.fye, d.C0277d.cp_cont_f, 1, skinType);
            if (this.fyd != null) {
                this.fyd.notifyDataSetChanged();
            }
        }
    }

    /* renamed from: com.baidu.tieba.frs.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C0300a extends BaseAdapter {
        private List<RecmForumInfo> fyf;

        public C0300a(List<RecmForumInfo> list) {
            this.fyf = list;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return this.fyf.size();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.widget.Adapter
        /* renamed from: rM */
        public RecmForumInfo getItem(int i) {
            return this.fyf.get(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(final int i, View view, ViewGroup viewGroup) {
            b bVar;
            if (view == null) {
                view = LayoutInflater.from(a.this.mPageContext.getPageActivity()).inflate(d.h.recommend_view, (ViewGroup) null);
                b bVar2 = new b();
                bVar2.rootView = view.findViewById(d.g.root_view);
                bVar2.fyi = (TextView) view.findViewById(d.g.forum_name);
                bVar2.fyk = (TextView) view.findViewById(d.g.follow_tv);
                bVar2.fyj = (TextView) view.findViewById(d.g.thread_tv);
                bVar2.fyl = (ImageView) view.findViewById(d.g.arrow_item_img);
                bVar2.fym = (TbImageView) view.findViewById(d.g.headview);
                bVar2.fyn = (TextView) view.findViewById(d.g.follow_title);
                bVar2.fyo = (TextView) view.findViewById(d.g.thread_title);
                bVar2.divider = view.findViewById(d.g.divider_line);
                bVar2.fyp = (ImageView) view.findViewById(d.g.content_img);
                view.setTag(bVar2);
                bVar = bVar2;
            } else {
                bVar = (b) view.getTag();
            }
            if (getItem(i) != null) {
                bVar.fyi.setText(ap.g(getItem(i).forum_name, 14, "..."));
                bVar.fym.startLoad(getItem(i).avatar, 10, false);
                bVar.fyk.setText(ap.as(getItem(i).member_count.intValue()));
                bVar.fyj.setText(ap.as(getItem(i).post_num.intValue()));
                bVar.rootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.a.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (!StringUtils.isNull(C0300a.this.getItem(i).forum_name)) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(a.this.mPageContext.getContext()).createNormalCfg(C0300a.this.getItem(i).forum_name, null)));
                        }
                    }
                });
                al.j(bVar.fyi, d.C0277d.cp_cont_b);
                al.j(bVar.fyk, d.C0277d.cp_cont_d);
                al.j(bVar.fyj, d.C0277d.cp_cont_d);
                al.j(bVar.fyo, d.C0277d.cp_cont_d);
                al.j(bVar.fyn, d.C0277d.cp_cont_d);
                al.k(bVar.divider, d.C0277d.cp_bg_line_c);
                al.c(bVar.fyl, d.f.icon_arrow_gray_right_n);
                al.k(view, d.f.addresslist_item_bg);
                al.k(bVar.fyp, d.f.picture_content_frame);
            }
            return view;
        }
    }
}
