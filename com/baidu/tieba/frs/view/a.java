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
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import java.util.List;
import tbclient.FrsPage.RecmForumInfo;
/* loaded from: classes22.dex */
public class a extends com.baidu.tbadk.k.a {
    private com.baidu.adp.base.e eul;
    protected TbImageView fem;
    private BdListView iTJ;
    private C0708a iTK;
    private TextView iTL;
    private View mDivider;
    private TextView mTitleView;
    protected TextView subTextView;

    /* loaded from: classes22.dex */
    public static class b {
        public View euA;
        public TextView iTP;
        public TextView iTQ;
        public TextView iTR;
        public ImageView iTS;
        public TbImageView iTT;
        public TextView iTU;
        public TextView iTV;
        public ImageView iTW;
        public View rootView;
    }

    public a(com.baidu.adp.base.e eVar, View.OnClickListener onClickListener) {
        super(LayoutInflater.from(eVar.getContext()).inflate(R.layout.forbid_detail_view_layout, (ViewGroup) null));
        this.eul = eVar;
        this.fem = (TbImageView) this.attachedView.findViewById(R.id.net_refresh_image);
        this.subTextView = (TextView) this.attachedView.findViewById(R.id.net_refresh_desc);
        this.mDivider = this.attachedView.findViewById(R.id.divider);
        this.iTJ = (BdListView) this.attachedView.findViewById(R.id.recommend_bar_listview);
        this.attachedView.setOnClickListener(null);
        this.mTitleView = (TextView) this.attachedView.findViewById(R.id.content_title);
        this.iTL = (TextView) this.attachedView.findViewById(R.id.local_tip_tv);
    }

    public void setSubText(String str) {
        if (str == null) {
            this.subTextView.setVisibility(8);
            return;
        }
        this.subTextView.setVisibility(0);
        this.subTextView.setText(str);
    }

    public void setListData(List<RecmForumInfo> list) {
        if (list != null) {
            this.iTK = new C0708a(list);
            this.iTJ.setAdapter((ListAdapter) this.iTK);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.k.a
    public void onViewAttached() {
        super.onViewAttached();
        onChangeSkinType();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.k.a
    public void onViewDettached() {
        super.onViewDettached();
        this.fem.setImageResource(0);
    }

    public void onChangeSkinType() {
        if (isViewAttached()) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            ap.setImageResource(this.fem, R.drawable.new_pic_emotion_01);
            ap.setViewTextColor(this.subTextView, R.color.cp_cont_d, 1, skinType);
            ap.setBackgroundColor(this.attachedView, R.color.cp_bg_line_d);
            ap.setBackgroundColor(this.mDivider, R.color.cp_bg_line_c);
            ap.setViewTextColor(this.mTitleView, R.color.cp_cont_d, 1, skinType);
            ap.setViewTextColor(this.iTL, R.color.cp_cont_f, 1, skinType);
            if (this.iTK != null) {
                this.iTK.notifyDataSetChanged();
            }
        }
    }

    /* renamed from: com.baidu.tieba.frs.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes22.dex */
    public class C0708a extends BaseAdapter {
        private List<RecmForumInfo> iTM;

        public C0708a(List<RecmForumInfo> list) {
            this.iTM = list;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return this.iTM.size();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.widget.Adapter
        /* renamed from: An */
        public RecmForumInfo getItem(int i) {
            return this.iTM.get(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(final int i, View view, ViewGroup viewGroup) {
            b bVar;
            if (view == null) {
                view = LayoutInflater.from(a.this.eul.getPageActivity()).inflate(R.layout.recommend_view, (ViewGroup) null);
                b bVar2 = new b();
                bVar2.rootView = view.findViewById(R.id.root_view);
                bVar2.iTP = (TextView) view.findViewById(R.id.forum_name);
                bVar2.iTR = (TextView) view.findViewById(R.id.follow_tv);
                bVar2.iTQ = (TextView) view.findViewById(R.id.thread_tv);
                bVar2.iTS = (ImageView) view.findViewById(R.id.arrow_item_img);
                bVar2.iTT = (TbImageView) view.findViewById(R.id.headview);
                bVar2.iTU = (TextView) view.findViewById(R.id.follow_title);
                bVar2.iTV = (TextView) view.findViewById(R.id.thread_title);
                bVar2.euA = view.findViewById(R.id.divider_line);
                bVar2.iTW = (ImageView) view.findViewById(R.id.content_img);
                view.setTag(bVar2);
                bVar = bVar2;
            } else {
                bVar = (b) view.getTag();
            }
            if (getItem(i) != null) {
                bVar.iTP.setText(at.cutChineseAndEnglishWithSuffix(getItem(i).forum_name, 14, StringHelper.STRING_MORE));
                bVar.iTT.startLoad(getItem(i).avatar, 10, false);
                bVar.iTR.setText(at.numberUniformFormat(getItem(i).member_count.intValue()));
                bVar.iTQ.setText(at.numberUniformFormat(getItem(i).post_num.intValue()));
                bVar.rootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.a.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (!StringUtils.isNull(C0708a.this.getItem(i).forum_name)) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(a.this.eul.getContext()).createNormalCfg(C0708a.this.getItem(i).forum_name, null)));
                        }
                    }
                });
                ap.setViewTextColor(bVar.iTP, R.color.cp_cont_b);
                ap.setViewTextColor(bVar.iTR, R.color.cp_cont_d);
                ap.setViewTextColor(bVar.iTQ, R.color.cp_cont_d);
                ap.setViewTextColor(bVar.iTV, R.color.cp_cont_d);
                ap.setViewTextColor(bVar.iTU, R.color.cp_cont_d);
                ap.setBackgroundResource(bVar.euA, R.color.cp_bg_line_c);
                SvgManager.bmU().a(bVar.iTS, R.drawable.icon_pure_list_arrow16_right_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL);
                ap.setBackgroundResource(view, R.drawable.addresslist_item_bg);
                ap.setBackgroundResource(bVar.iTW, R.drawable.picture_content_frame);
            }
            return view;
        }
    }
}
