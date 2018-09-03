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
import com.baidu.tieba.f;
import java.util.List;
import tbclient.FrsPage.RecmForumInfo;
/* loaded from: classes2.dex */
public class a extends com.baidu.tbadk.k.a {
    protected TbImageView aRm;
    protected TextView aRn;
    private View bHR;
    private BdListView dIF;
    private C0159a dIG;
    private TextView dIH;
    private com.baidu.adp.base.e mPageContext;
    private TextView mTitleView;

    /* loaded from: classes2.dex */
    public static class b {
        public TextView dIL;
        public TextView dIM;
        public TextView dIN;
        public ImageView dIO;
        public TbImageView dIP;
        public TextView dIQ;
        public TextView dIR;
        public ImageView dIS;
        public View divider;
        public View rootView;
    }

    public a(com.baidu.adp.base.e eVar, View.OnClickListener onClickListener) {
        super(LayoutInflater.from(eVar.getContext()).inflate(f.h.forbid_detail_view_layout, (ViewGroup) null));
        this.mPageContext = eVar;
        this.aRm = (TbImageView) this.aRe.findViewById(f.g.net_refresh_image);
        this.aRn = (TextView) this.aRe.findViewById(f.g.net_refresh_desc);
        this.bHR = this.aRe.findViewById(f.g.divider);
        this.dIF = (BdListView) this.aRe.findViewById(f.g.recommend_bar_listview);
        this.aRe.setOnClickListener(null);
        this.mTitleView = (TextView) this.aRe.findViewById(f.g.content_title);
        this.dIH = (TextView) this.aRe.findViewById(f.g.local_tip_tv);
    }

    public void hk(String str) {
        if (str == null) {
            this.aRn.setVisibility(8);
            return;
        }
        this.aRn.setVisibility(0);
        this.aRn.setText(str);
    }

    public void bB(List<RecmForumInfo> list) {
        if (list != null) {
            this.dIG = new C0159a(list);
            this.dIF.setAdapter((ListAdapter) this.dIG);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.k.a
    public void Jd() {
        super.Jd();
        onChangeSkinType();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.k.a
    public void Je() {
        super.Je();
        this.aRm.setImageResource(0);
    }

    public void onChangeSkinType() {
        if (Jc()) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            am.c(this.aRm, f.C0146f.pic_emotion_01);
            am.b(this.aRn, f.d.cp_cont_d, 1, skinType);
            am.j(this.aRe, f.d.cp_bg_line_d);
            am.j(this.bHR, f.d.cp_bg_line_c);
            am.b(this.mTitleView, f.d.cp_cont_d, 1, skinType);
            am.b(this.dIH, f.d.cp_cont_f, 1, skinType);
            if (this.dIG != null) {
                this.dIG.notifyDataSetChanged();
            }
        }
    }

    /* renamed from: com.baidu.tieba.frs.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0159a extends BaseAdapter {
        private List<RecmForumInfo> dII;

        public C0159a(List<RecmForumInfo> list) {
            this.dII = list;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return this.dII.size();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.widget.Adapter
        /* renamed from: mb */
        public RecmForumInfo getItem(int i) {
            return this.dII.get(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(final int i, View view, ViewGroup viewGroup) {
            b bVar;
            if (view == null) {
                view = LayoutInflater.from(a.this.mPageContext.getPageActivity()).inflate(f.h.recommend_view, (ViewGroup) null);
                b bVar2 = new b();
                bVar2.rootView = view.findViewById(f.g.root_view);
                bVar2.dIL = (TextView) view.findViewById(f.g.forum_name);
                bVar2.dIN = (TextView) view.findViewById(f.g.follow_tv);
                bVar2.dIM = (TextView) view.findViewById(f.g.thread_tv);
                bVar2.dIO = (ImageView) view.findViewById(f.g.arrow_item_img);
                bVar2.dIP = (TbImageView) view.findViewById(f.g.headview);
                bVar2.dIQ = (TextView) view.findViewById(f.g.follow_title);
                bVar2.dIR = (TextView) view.findViewById(f.g.thread_title);
                bVar2.divider = view.findViewById(f.g.divider_line);
                bVar2.dIS = (ImageView) view.findViewById(f.g.content_img);
                view.setTag(bVar2);
                bVar = bVar2;
            } else {
                bVar = (b) view.getTag();
            }
            if (getItem(i) != null) {
                bVar.dIL.setText(ap.d(getItem(i).forum_name, 14, "..."));
                bVar.dIP.startLoad(getItem(i).avatar, 10, false);
                bVar.dIN.setText(ap.A(getItem(i).member_count.intValue()));
                bVar.dIM.setText(ap.A(getItem(i).post_num.intValue()));
                bVar.rootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.a.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (!StringUtils.isNull(C0159a.this.getItem(i).forum_name)) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(a.this.mPageContext.getContext()).createNormalCfg(C0159a.this.getItem(i).forum_name, null)));
                        }
                    }
                });
                am.h(bVar.dIL, f.d.cp_cont_b);
                am.h(bVar.dIN, f.d.cp_cont_d);
                am.h(bVar.dIM, f.d.cp_cont_d);
                am.h(bVar.dIR, f.d.cp_cont_d);
                am.h(bVar.dIQ, f.d.cp_cont_d);
                am.i(bVar.divider, f.d.cp_bg_line_c);
                am.c(bVar.dIO, f.C0146f.icon_arrow_gray_right_n);
                am.i(view, f.C0146f.addresslist_item_bg);
                am.i(bVar.dIS, f.C0146f.picture_content_frame);
            }
            return view;
        }
    }
}
