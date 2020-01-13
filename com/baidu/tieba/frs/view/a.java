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
/* loaded from: classes7.dex */
public class a extends com.baidu.tbadk.k.a {
    private com.baidu.adp.base.e cRA;
    protected TbImageView dwQ;
    private BdListView gMT;
    private C0508a gMU;
    private TextView gMV;
    private View mDivider;
    private TextView mTitleView;
    protected TextView subTextView;

    /* loaded from: classes7.dex */
    public static class b {
        public View cRQ;
        public TextView gMZ;
        public TextView gNa;
        public TextView gNb;
        public ImageView gNc;
        public TbImageView gNd;
        public TextView gNe;
        public TextView gNf;
        public ImageView gNg;
        public View rootView;
    }

    public a(com.baidu.adp.base.e eVar, View.OnClickListener onClickListener) {
        super(LayoutInflater.from(eVar.getContext()).inflate(R.layout.forbid_detail_view_layout, (ViewGroup) null));
        this.cRA = eVar;
        this.dwQ = (TbImageView) this.attachedView.findViewById(R.id.net_refresh_image);
        this.subTextView = (TextView) this.attachedView.findViewById(R.id.net_refresh_desc);
        this.mDivider = this.attachedView.findViewById(R.id.divider);
        this.gMT = (BdListView) this.attachedView.findViewById(R.id.recommend_bar_listview);
        this.attachedView.setOnClickListener(null);
        this.mTitleView = (TextView) this.attachedView.findViewById(R.id.content_title);
        this.gMV = (TextView) this.attachedView.findViewById(R.id.local_tip_tv);
    }

    public void setSubText(String str) {
        if (str == null) {
            this.subTextView.setVisibility(8);
            return;
        }
        this.subTextView.setVisibility(0);
        this.subTextView.setText(str);
    }

    public void cx(List<RecmForumInfo> list) {
        if (list != null) {
            this.gMU = new C0508a(list);
            this.gMT.setAdapter((ListAdapter) this.gMU);
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
        this.dwQ.setImageResource(0);
    }

    public void onChangeSkinType() {
        if (isViewAttached()) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            am.setImageResource(this.dwQ, R.drawable.new_pic_emotion_01);
            am.setViewTextColor(this.subTextView, R.color.cp_cont_d, 1, skinType);
            am.setBackgroundColor(this.attachedView, R.color.cp_bg_line_d);
            am.setBackgroundColor(this.mDivider, R.color.cp_bg_line_c);
            am.setViewTextColor(this.mTitleView, R.color.cp_cont_d, 1, skinType);
            am.setViewTextColor(this.gMV, R.color.cp_cont_f, 1, skinType);
            if (this.gMU != null) {
                this.gMU.notifyDataSetChanged();
            }
        }
    }

    /* renamed from: com.baidu.tieba.frs.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C0508a extends BaseAdapter {
        private List<RecmForumInfo> gMW;

        public C0508a(List<RecmForumInfo> list) {
            this.gMW = list;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return this.gMW.size();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.widget.Adapter
        /* renamed from: uy */
        public RecmForumInfo getItem(int i) {
            return this.gMW.get(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(final int i, View view, ViewGroup viewGroup) {
            b bVar;
            if (view == null) {
                view = LayoutInflater.from(a.this.cRA.getPageActivity()).inflate(R.layout.recommend_view, (ViewGroup) null);
                b bVar2 = new b();
                bVar2.rootView = view.findViewById(R.id.root_view);
                bVar2.gMZ = (TextView) view.findViewById(R.id.forum_name);
                bVar2.gNb = (TextView) view.findViewById(R.id.follow_tv);
                bVar2.gNa = (TextView) view.findViewById(R.id.thread_tv);
                bVar2.gNc = (ImageView) view.findViewById(R.id.arrow_item_img);
                bVar2.gNd = (TbImageView) view.findViewById(R.id.headview);
                bVar2.gNe = (TextView) view.findViewById(R.id.follow_title);
                bVar2.gNf = (TextView) view.findViewById(R.id.thread_title);
                bVar2.cRQ = view.findViewById(R.id.divider_line);
                bVar2.gNg = (ImageView) view.findViewById(R.id.content_img);
                view.setTag(bVar2);
                bVar = bVar2;
            } else {
                bVar = (b) view.getTag();
            }
            if (getItem(i) != null) {
                bVar.gMZ.setText(aq.cutChineseAndEnglishWithSuffix(getItem(i).forum_name, 14, StringHelper.STRING_MORE));
                bVar.gNd.startLoad(getItem(i).avatar, 10, false);
                bVar.gNb.setText(aq.numberUniformFormat(getItem(i).member_count.intValue()));
                bVar.gNa.setText(aq.numberUniformFormat(getItem(i).post_num.intValue()));
                bVar.rootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.a.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (!StringUtils.isNull(C0508a.this.getItem(i).forum_name)) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(a.this.cRA.getContext()).createNormalCfg(C0508a.this.getItem(i).forum_name, null)));
                        }
                    }
                });
                am.setViewTextColor(bVar.gMZ, (int) R.color.cp_cont_b);
                am.setViewTextColor(bVar.gNb, (int) R.color.cp_cont_d);
                am.setViewTextColor(bVar.gNa, (int) R.color.cp_cont_d);
                am.setViewTextColor(bVar.gNf, (int) R.color.cp_cont_d);
                am.setViewTextColor(bVar.gNe, (int) R.color.cp_cont_d);
                am.setBackgroundResource(bVar.cRQ, R.color.cp_bg_line_c);
                SvgManager.aEp().a(bVar.gNc, R.drawable.icon_pure_list_arrow16_right_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL);
                am.setBackgroundResource(view, R.drawable.addresslist_item_bg);
                am.setBackgroundResource(bVar.gNg, R.drawable.picture_content_frame);
            }
            return view;
        }
    }
}
