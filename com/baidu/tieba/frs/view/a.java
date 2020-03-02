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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import java.util.List;
import tbclient.FrsPage.RecmForumInfo;
/* loaded from: classes9.dex */
public class a extends com.baidu.tbadk.k.a {
    private com.baidu.adp.base.e cVD;
    protected TbImageView dAX;
    private BdListView gOV;
    private C0515a gOW;
    private TextView gOX;
    private View mDivider;
    private TextView mTitleView;
    protected TextView subTextView;

    /* loaded from: classes9.dex */
    public static class b {
        public View cVT;
        public TextView gPb;
        public TextView gPc;
        public TextView gPd;
        public ImageView gPe;
        public TbImageView gPf;
        public TextView gPg;
        public TextView gPh;
        public ImageView gPi;
        public View rootView;
    }

    public a(com.baidu.adp.base.e eVar, View.OnClickListener onClickListener) {
        super(LayoutInflater.from(eVar.getContext()).inflate(R.layout.forbid_detail_view_layout, (ViewGroup) null));
        this.cVD = eVar;
        this.dAX = (TbImageView) this.attachedView.findViewById(R.id.net_refresh_image);
        this.subTextView = (TextView) this.attachedView.findViewById(R.id.net_refresh_desc);
        this.mDivider = this.attachedView.findViewById(R.id.divider);
        this.gOV = (BdListView) this.attachedView.findViewById(R.id.recommend_bar_listview);
        this.attachedView.setOnClickListener(null);
        this.mTitleView = (TextView) this.attachedView.findViewById(R.id.content_title);
        this.gOX = (TextView) this.attachedView.findViewById(R.id.local_tip_tv);
    }

    public void setSubText(String str) {
        if (str == null) {
            this.subTextView.setVisibility(8);
            return;
        }
        this.subTextView.setVisibility(0);
        this.subTextView.setText(str);
    }

    public void ct(List<RecmForumInfo> list) {
        if (list != null) {
            this.gOW = new C0515a(list);
            this.gOV.setAdapter((ListAdapter) this.gOW);
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
        this.dAX.setImageResource(0);
    }

    public void onChangeSkinType() {
        if (isViewAttached()) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            am.setImageResource(this.dAX, R.drawable.new_pic_emotion_01);
            am.setViewTextColor(this.subTextView, R.color.cp_cont_d, 1, skinType);
            am.setBackgroundColor(this.attachedView, R.color.cp_bg_line_d);
            am.setBackgroundColor(this.mDivider, R.color.cp_bg_line_c);
            am.setViewTextColor(this.mTitleView, R.color.cp_cont_d, 1, skinType);
            am.setViewTextColor(this.gOX, R.color.cp_cont_f, 1, skinType);
            if (this.gOW != null) {
                this.gOW.notifyDataSetChanged();
            }
        }
    }

    /* renamed from: com.baidu.tieba.frs.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class C0515a extends BaseAdapter {
        private List<RecmForumInfo> gOY;

        public C0515a(List<RecmForumInfo> list) {
            this.gOY = list;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return this.gOY.size();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.widget.Adapter
        /* renamed from: uE */
        public RecmForumInfo getItem(int i) {
            return this.gOY.get(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(final int i, View view, ViewGroup viewGroup) {
            b bVar;
            if (view == null) {
                view = LayoutInflater.from(a.this.cVD.getPageActivity()).inflate(R.layout.recommend_view, (ViewGroup) null);
                b bVar2 = new b();
                bVar2.rootView = view.findViewById(R.id.root_view);
                bVar2.gPb = (TextView) view.findViewById(R.id.forum_name);
                bVar2.gPd = (TextView) view.findViewById(R.id.follow_tv);
                bVar2.gPc = (TextView) view.findViewById(R.id.thread_tv);
                bVar2.gPe = (ImageView) view.findViewById(R.id.arrow_item_img);
                bVar2.gPf = (TbImageView) view.findViewById(R.id.headview);
                bVar2.gPg = (TextView) view.findViewById(R.id.follow_title);
                bVar2.gPh = (TextView) view.findViewById(R.id.thread_title);
                bVar2.cVT = view.findViewById(R.id.divider_line);
                bVar2.gPi = (ImageView) view.findViewById(R.id.content_img);
                view.setTag(bVar2);
                bVar = bVar2;
            } else {
                bVar = (b) view.getTag();
            }
            if (getItem(i) != null) {
                bVar.gPb.setText(aq.cutChineseAndEnglishWithSuffix(getItem(i).forum_name, 14, StringHelper.STRING_MORE));
                bVar.gPf.startLoad(getItem(i).avatar, 10, false);
                bVar.gPd.setText(aq.numberUniformFormat(getItem(i).member_count.intValue()));
                bVar.gPc.setText(aq.numberUniformFormat(getItem(i).post_num.intValue()));
                bVar.rootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.a.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (!StringUtils.isNull(C0515a.this.getItem(i).forum_name)) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(a.this.cVD.getContext()).createNormalCfg(C0515a.this.getItem(i).forum_name, null)));
                        }
                    }
                });
                am.setViewTextColor(bVar.gPb, (int) R.color.cp_cont_b);
                am.setViewTextColor(bVar.gPd, (int) R.color.cp_cont_d);
                am.setViewTextColor(bVar.gPc, (int) R.color.cp_cont_d);
                am.setViewTextColor(bVar.gPh, (int) R.color.cp_cont_d);
                am.setViewTextColor(bVar.gPg, (int) R.color.cp_cont_d);
                am.setBackgroundResource(bVar.cVT, R.color.cp_bg_line_c);
                SvgManager.aGC().a(bVar.gPe, R.drawable.icon_pure_list_arrow16_right_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL);
                am.setBackgroundResource(view, R.drawable.addresslist_item_bg);
                am.setBackgroundResource(bVar.gPi, R.drawable.picture_content_frame);
            }
            return view;
        }
    }
}
