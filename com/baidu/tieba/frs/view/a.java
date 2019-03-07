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
    private View aLa;
    protected TbImageView cnx;
    protected TextView cny;
    private BdListView fyp;
    private C0249a fyq;
    private TextView fyr;
    private com.baidu.adp.base.e mPageContext;
    private TextView mTitleView;

    /* loaded from: classes4.dex */
    public static class b {
        public View divider;
        public TextView fyA;
        public TextView fyB;
        public ImageView fyC;
        public TextView fyv;
        public TextView fyw;
        public TextView fyx;
        public ImageView fyy;
        public TbImageView fyz;
        public View rootView;
    }

    public a(com.baidu.adp.base.e eVar, View.OnClickListener onClickListener) {
        super(LayoutInflater.from(eVar.getContext()).inflate(d.h.forbid_detail_view_layout, (ViewGroup) null));
        this.mPageContext = eVar;
        this.cnx = (TbImageView) this.attachedView.findViewById(d.g.net_refresh_image);
        this.cny = (TextView) this.attachedView.findViewById(d.g.net_refresh_desc);
        this.aLa = this.attachedView.findViewById(d.g.divider);
        this.fyp = (BdListView) this.attachedView.findViewById(d.g.recommend_bar_listview);
        this.attachedView.setOnClickListener(null);
        this.mTitleView = (TextView) this.attachedView.findViewById(d.g.content_title);
        this.fyr = (TextView) this.attachedView.findViewById(d.g.local_tip_tv);
    }

    public void po(String str) {
        if (str == null) {
            this.cny.setVisibility(8);
            return;
        }
        this.cny.setVisibility(0);
        this.cny.setText(str);
    }

    public void cj(List<RecmForumInfo> list) {
        if (list != null) {
            this.fyq = new C0249a(list);
            this.fyp.setAdapter((ListAdapter) this.fyq);
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
        this.cnx.setImageResource(0);
    }

    public void onChangeSkinType() {
        if (isViewAttached()) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            al.c(this.cnx, d.f.new_pic_emotion_01);
            al.c(this.cny, d.C0236d.cp_cont_d, 1, skinType);
            al.l(this.attachedView, d.C0236d.cp_bg_line_d);
            al.l(this.aLa, d.C0236d.cp_bg_line_c);
            al.c(this.mTitleView, d.C0236d.cp_cont_d, 1, skinType);
            al.c(this.fyr, d.C0236d.cp_cont_f, 1, skinType);
            if (this.fyq != null) {
                this.fyq.notifyDataSetChanged();
            }
        }
    }

    /* renamed from: com.baidu.tieba.frs.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C0249a extends BaseAdapter {
        private List<RecmForumInfo> fys;

        public C0249a(List<RecmForumInfo> list) {
            this.fys = list;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return this.fys.size();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.widget.Adapter
        /* renamed from: rQ */
        public RecmForumInfo getItem(int i) {
            return this.fys.get(i);
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
                bVar2.fyv = (TextView) view.findViewById(d.g.forum_name);
                bVar2.fyx = (TextView) view.findViewById(d.g.follow_tv);
                bVar2.fyw = (TextView) view.findViewById(d.g.thread_tv);
                bVar2.fyy = (ImageView) view.findViewById(d.g.arrow_item_img);
                bVar2.fyz = (TbImageView) view.findViewById(d.g.headview);
                bVar2.fyA = (TextView) view.findViewById(d.g.follow_title);
                bVar2.fyB = (TextView) view.findViewById(d.g.thread_title);
                bVar2.divider = view.findViewById(d.g.divider_line);
                bVar2.fyC = (ImageView) view.findViewById(d.g.content_img);
                view.setTag(bVar2);
                bVar = bVar2;
            } else {
                bVar = (b) view.getTag();
            }
            if (getItem(i) != null) {
                bVar.fyv.setText(ap.g(getItem(i).forum_name, 14, "..."));
                bVar.fyz.startLoad(getItem(i).avatar, 10, false);
                bVar.fyx.setText(ap.as(getItem(i).member_count.intValue()));
                bVar.fyw.setText(ap.as(getItem(i).post_num.intValue()));
                bVar.rootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.a.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (!StringUtils.isNull(C0249a.this.getItem(i).forum_name)) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(a.this.mPageContext.getContext()).createNormalCfg(C0249a.this.getItem(i).forum_name, null)));
                        }
                    }
                });
                al.j(bVar.fyv, d.C0236d.cp_cont_b);
                al.j(bVar.fyx, d.C0236d.cp_cont_d);
                al.j(bVar.fyw, d.C0236d.cp_cont_d);
                al.j(bVar.fyB, d.C0236d.cp_cont_d);
                al.j(bVar.fyA, d.C0236d.cp_cont_d);
                al.k(bVar.divider, d.C0236d.cp_bg_line_c);
                al.c(bVar.fyy, d.f.icon_arrow_gray_right_n);
                al.k(view, d.f.addresslist_item_bg);
                al.k(bVar.fyC, d.f.picture_content_frame);
            }
            return view;
        }
    }
}
