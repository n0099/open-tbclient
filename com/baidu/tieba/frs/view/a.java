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
    private com.baidu.adp.base.e cVE;
    protected TbImageView dBk;
    private BdListView gPh;
    private C0515a gPi;
    private TextView gPj;
    private View mDivider;
    private TextView mTitleView;
    protected TextView subTextView;

    /* loaded from: classes9.dex */
    public static class b {
        public View cVU;
        public TextView gPn;
        public TextView gPo;
        public TextView gPp;
        public ImageView gPq;
        public TbImageView gPr;
        public TextView gPs;
        public TextView gPt;
        public ImageView gPu;
        public View rootView;
    }

    public a(com.baidu.adp.base.e eVar, View.OnClickListener onClickListener) {
        super(LayoutInflater.from(eVar.getContext()).inflate(R.layout.forbid_detail_view_layout, (ViewGroup) null));
        this.cVE = eVar;
        this.dBk = (TbImageView) this.attachedView.findViewById(R.id.net_refresh_image);
        this.subTextView = (TextView) this.attachedView.findViewById(R.id.net_refresh_desc);
        this.mDivider = this.attachedView.findViewById(R.id.divider);
        this.gPh = (BdListView) this.attachedView.findViewById(R.id.recommend_bar_listview);
        this.attachedView.setOnClickListener(null);
        this.mTitleView = (TextView) this.attachedView.findViewById(R.id.content_title);
        this.gPj = (TextView) this.attachedView.findViewById(R.id.local_tip_tv);
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
            this.gPi = new C0515a(list);
            this.gPh.setAdapter((ListAdapter) this.gPi);
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
        this.dBk.setImageResource(0);
    }

    public void onChangeSkinType() {
        if (isViewAttached()) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            am.setImageResource(this.dBk, R.drawable.new_pic_emotion_01);
            am.setViewTextColor(this.subTextView, R.color.cp_cont_d, 1, skinType);
            am.setBackgroundColor(this.attachedView, R.color.cp_bg_line_d);
            am.setBackgroundColor(this.mDivider, R.color.cp_bg_line_c);
            am.setViewTextColor(this.mTitleView, R.color.cp_cont_d, 1, skinType);
            am.setViewTextColor(this.gPj, R.color.cp_cont_f, 1, skinType);
            if (this.gPi != null) {
                this.gPi.notifyDataSetChanged();
            }
        }
    }

    /* renamed from: com.baidu.tieba.frs.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class C0515a extends BaseAdapter {
        private List<RecmForumInfo> gPk;

        public C0515a(List<RecmForumInfo> list) {
            this.gPk = list;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return this.gPk.size();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.widget.Adapter
        /* renamed from: uE */
        public RecmForumInfo getItem(int i) {
            return this.gPk.get(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(final int i, View view, ViewGroup viewGroup) {
            b bVar;
            if (view == null) {
                view = LayoutInflater.from(a.this.cVE.getPageActivity()).inflate(R.layout.recommend_view, (ViewGroup) null);
                b bVar2 = new b();
                bVar2.rootView = view.findViewById(R.id.root_view);
                bVar2.gPn = (TextView) view.findViewById(R.id.forum_name);
                bVar2.gPp = (TextView) view.findViewById(R.id.follow_tv);
                bVar2.gPo = (TextView) view.findViewById(R.id.thread_tv);
                bVar2.gPq = (ImageView) view.findViewById(R.id.arrow_item_img);
                bVar2.gPr = (TbImageView) view.findViewById(R.id.headview);
                bVar2.gPs = (TextView) view.findViewById(R.id.follow_title);
                bVar2.gPt = (TextView) view.findViewById(R.id.thread_title);
                bVar2.cVU = view.findViewById(R.id.divider_line);
                bVar2.gPu = (ImageView) view.findViewById(R.id.content_img);
                view.setTag(bVar2);
                bVar = bVar2;
            } else {
                bVar = (b) view.getTag();
            }
            if (getItem(i) != null) {
                bVar.gPn.setText(aq.cutChineseAndEnglishWithSuffix(getItem(i).forum_name, 14, StringHelper.STRING_MORE));
                bVar.gPr.startLoad(getItem(i).avatar, 10, false);
                bVar.gPp.setText(aq.numberUniformFormat(getItem(i).member_count.intValue()));
                bVar.gPo.setText(aq.numberUniformFormat(getItem(i).post_num.intValue()));
                bVar.rootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.a.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (!StringUtils.isNull(C0515a.this.getItem(i).forum_name)) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(a.this.cVE.getContext()).createNormalCfg(C0515a.this.getItem(i).forum_name, null)));
                        }
                    }
                });
                am.setViewTextColor(bVar.gPn, (int) R.color.cp_cont_b);
                am.setViewTextColor(bVar.gPp, (int) R.color.cp_cont_d);
                am.setViewTextColor(bVar.gPo, (int) R.color.cp_cont_d);
                am.setViewTextColor(bVar.gPt, (int) R.color.cp_cont_d);
                am.setViewTextColor(bVar.gPs, (int) R.color.cp_cont_d);
                am.setBackgroundResource(bVar.cVU, R.color.cp_bg_line_c);
                SvgManager.aGC().a(bVar.gPq, R.drawable.icon_pure_list_arrow16_right_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL);
                am.setBackgroundResource(view, R.drawable.addresslist_item_bg);
                am.setBackgroundResource(bVar.gPu, R.drawable.picture_content_frame);
            }
            return view;
        }
    }
}
