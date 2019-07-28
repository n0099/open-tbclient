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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import java.util.List;
import tbclient.FrsPage.RecmForumInfo;
/* loaded from: classes4.dex */
public class a extends com.baidu.tbadk.m.a {
    private View aNH;
    protected TbImageView cwW;
    protected TextView cwX;
    private BdListView fTW;
    private C0321a fTX;
    private TextView fTY;
    private com.baidu.adp.base.e mPageContext;
    private TextView mTitleView;

    /* loaded from: classes4.dex */
    public static class b {
        public View divider;
        public TextView fUc;
        public TextView fUd;
        public TextView fUe;
        public ImageView fUf;
        public TbImageView fUg;
        public TextView fUh;
        public TextView fUi;
        public ImageView fUj;
        public View rootView;
    }

    public a(com.baidu.adp.base.e eVar, View.OnClickListener onClickListener) {
        super(LayoutInflater.from(eVar.getContext()).inflate(R.layout.forbid_detail_view_layout, (ViewGroup) null));
        this.mPageContext = eVar;
        this.cwW = (TbImageView) this.attachedView.findViewById(R.id.net_refresh_image);
        this.cwX = (TextView) this.attachedView.findViewById(R.id.net_refresh_desc);
        this.aNH = this.attachedView.findViewById(R.id.divider);
        this.fTW = (BdListView) this.attachedView.findViewById(R.id.recommend_bar_listview);
        this.attachedView.setOnClickListener(null);
        this.mTitleView = (TextView) this.attachedView.findViewById(R.id.content_title);
        this.fTY = (TextView) this.attachedView.findViewById(R.id.local_tip_tv);
    }

    public void qN(String str) {
        if (str == null) {
            this.cwX.setVisibility(8);
            return;
        }
        this.cwX.setVisibility(0);
        this.cwX.setText(str);
    }

    public void cp(List<RecmForumInfo> list) {
        if (list != null) {
            this.fTX = new C0321a(list);
            this.fTW.setAdapter((ListAdapter) this.fTX);
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
        this.cwW.setImageResource(0);
    }

    public void onChangeSkinType() {
        if (isViewAttached()) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            am.c(this.cwW, (int) R.drawable.new_pic_emotion_01);
            am.d(this.cwX, R.color.cp_cont_d, 1, skinType);
            am.l(this.attachedView, R.color.cp_bg_line_d);
            am.l(this.aNH, R.color.cp_bg_line_c);
            am.d(this.mTitleView, R.color.cp_cont_d, 1, skinType);
            am.d(this.fTY, R.color.cp_cont_f, 1, skinType);
            if (this.fTX != null) {
                this.fTX.notifyDataSetChanged();
            }
        }
    }

    /* renamed from: com.baidu.tieba.frs.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C0321a extends BaseAdapter {
        private List<RecmForumInfo> fTZ;

        public C0321a(List<RecmForumInfo> list) {
            this.fTZ = list;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return this.fTZ.size();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.widget.Adapter
        /* renamed from: tm */
        public RecmForumInfo getItem(int i) {
            return this.fTZ.get(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(final int i, View view, ViewGroup viewGroup) {
            b bVar;
            if (view == null) {
                view = LayoutInflater.from(a.this.mPageContext.getPageActivity()).inflate(R.layout.recommend_view, (ViewGroup) null);
                b bVar2 = new b();
                bVar2.rootView = view.findViewById(R.id.root_view);
                bVar2.fUc = (TextView) view.findViewById(R.id.forum_name);
                bVar2.fUe = (TextView) view.findViewById(R.id.follow_tv);
                bVar2.fUd = (TextView) view.findViewById(R.id.thread_tv);
                bVar2.fUf = (ImageView) view.findViewById(R.id.arrow_item_img);
                bVar2.fUg = (TbImageView) view.findViewById(R.id.headview);
                bVar2.fUh = (TextView) view.findViewById(R.id.follow_title);
                bVar2.fUi = (TextView) view.findViewById(R.id.thread_title);
                bVar2.divider = view.findViewById(R.id.divider_line);
                bVar2.fUj = (ImageView) view.findViewById(R.id.content_img);
                view.setTag(bVar2);
                bVar = bVar2;
            } else {
                bVar = (b) view.getTag();
            }
            if (getItem(i) != null) {
                bVar.fUc.setText(aq.j(getItem(i).forum_name, 14, "..."));
                bVar.fUg.startLoad(getItem(i).avatar, 10, false);
                bVar.fUe.setText(aq.aH(getItem(i).member_count.intValue()));
                bVar.fUd.setText(aq.aH(getItem(i).post_num.intValue()));
                bVar.rootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.a.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (!StringUtils.isNull(C0321a.this.getItem(i).forum_name)) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(a.this.mPageContext.getContext()).createNormalCfg(C0321a.this.getItem(i).forum_name, null)));
                        }
                    }
                });
                am.j(bVar.fUc, R.color.cp_cont_b);
                am.j(bVar.fUe, R.color.cp_cont_d);
                am.j(bVar.fUd, R.color.cp_cont_d);
                am.j(bVar.fUi, R.color.cp_cont_d);
                am.j(bVar.fUh, R.color.cp_cont_d);
                am.k(bVar.divider, R.color.cp_bg_line_c);
                am.c(bVar.fUf, (int) R.drawable.icon_arrow_gray_right_n);
                am.k(view, R.drawable.addresslist_item_bg);
                am.k(bVar.fUj, R.drawable.picture_content_frame);
            }
            return view;
        }
    }
}
