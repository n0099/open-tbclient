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
/* loaded from: classes6.dex */
public class a extends com.baidu.tbadk.k.a {
    private com.baidu.adp.base.e cRq;
    protected TbImageView dwI;
    private BdListView gJG;
    private C0504a gJH;
    private TextView gJI;
    private View mDivider;
    private TextView mTitleView;
    protected TextView subTextView;

    /* loaded from: classes6.dex */
    public static class b {
        public View cRG;
        public TextView gJM;
        public TextView gJN;
        public TextView gJO;
        public ImageView gJP;
        public TbImageView gJQ;
        public TextView gJR;
        public TextView gJS;
        public ImageView gJT;
        public View rootView;
    }

    public a(com.baidu.adp.base.e eVar, View.OnClickListener onClickListener) {
        super(LayoutInflater.from(eVar.getContext()).inflate(R.layout.forbid_detail_view_layout, (ViewGroup) null));
        this.cRq = eVar;
        this.dwI = (TbImageView) this.attachedView.findViewById(R.id.net_refresh_image);
        this.subTextView = (TextView) this.attachedView.findViewById(R.id.net_refresh_desc);
        this.mDivider = this.attachedView.findViewById(R.id.divider);
        this.gJG = (BdListView) this.attachedView.findViewById(R.id.recommend_bar_listview);
        this.attachedView.setOnClickListener(null);
        this.mTitleView = (TextView) this.attachedView.findViewById(R.id.content_title);
        this.gJI = (TextView) this.attachedView.findViewById(R.id.local_tip_tv);
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
            this.gJH = new C0504a(list);
            this.gJG.setAdapter((ListAdapter) this.gJH);
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
        this.dwI.setImageResource(0);
    }

    public void onChangeSkinType() {
        if (isViewAttached()) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            am.setImageResource(this.dwI, R.drawable.new_pic_emotion_01);
            am.setViewTextColor(this.subTextView, R.color.cp_cont_d, 1, skinType);
            am.setBackgroundColor(this.attachedView, R.color.cp_bg_line_d);
            am.setBackgroundColor(this.mDivider, R.color.cp_bg_line_c);
            am.setViewTextColor(this.mTitleView, R.color.cp_cont_d, 1, skinType);
            am.setViewTextColor(this.gJI, R.color.cp_cont_f, 1, skinType);
            if (this.gJH != null) {
                this.gJH.notifyDataSetChanged();
            }
        }
    }

    /* renamed from: com.baidu.tieba.frs.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class C0504a extends BaseAdapter {
        private List<RecmForumInfo> gJJ;

        public C0504a(List<RecmForumInfo> list) {
            this.gJJ = list;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return this.gJJ.size();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.widget.Adapter
        /* renamed from: ut */
        public RecmForumInfo getItem(int i) {
            return this.gJJ.get(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(final int i, View view, ViewGroup viewGroup) {
            b bVar;
            if (view == null) {
                view = LayoutInflater.from(a.this.cRq.getPageActivity()).inflate(R.layout.recommend_view, (ViewGroup) null);
                b bVar2 = new b();
                bVar2.rootView = view.findViewById(R.id.root_view);
                bVar2.gJM = (TextView) view.findViewById(R.id.forum_name);
                bVar2.gJO = (TextView) view.findViewById(R.id.follow_tv);
                bVar2.gJN = (TextView) view.findViewById(R.id.thread_tv);
                bVar2.gJP = (ImageView) view.findViewById(R.id.arrow_item_img);
                bVar2.gJQ = (TbImageView) view.findViewById(R.id.headview);
                bVar2.gJR = (TextView) view.findViewById(R.id.follow_title);
                bVar2.gJS = (TextView) view.findViewById(R.id.thread_title);
                bVar2.cRG = view.findViewById(R.id.divider_line);
                bVar2.gJT = (ImageView) view.findViewById(R.id.content_img);
                view.setTag(bVar2);
                bVar = bVar2;
            } else {
                bVar = (b) view.getTag();
            }
            if (getItem(i) != null) {
                bVar.gJM.setText(aq.cutChineseAndEnglishWithSuffix(getItem(i).forum_name, 14, StringHelper.STRING_MORE));
                bVar.gJQ.startLoad(getItem(i).avatar, 10, false);
                bVar.gJO.setText(aq.numberUniformFormat(getItem(i).member_count.intValue()));
                bVar.gJN.setText(aq.numberUniformFormat(getItem(i).post_num.intValue()));
                bVar.rootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.a.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (!StringUtils.isNull(C0504a.this.getItem(i).forum_name)) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(a.this.cRq.getContext()).createNormalCfg(C0504a.this.getItem(i).forum_name, null)));
                        }
                    }
                });
                am.setViewTextColor(bVar.gJM, (int) R.color.cp_cont_b);
                am.setViewTextColor(bVar.gJO, (int) R.color.cp_cont_d);
                am.setViewTextColor(bVar.gJN, (int) R.color.cp_cont_d);
                am.setViewTextColor(bVar.gJS, (int) R.color.cp_cont_d);
                am.setViewTextColor(bVar.gJR, (int) R.color.cp_cont_d);
                am.setBackgroundResource(bVar.cRG, R.color.cp_bg_line_c);
                SvgManager.aDW().a(bVar.gJP, R.drawable.icon_pure_list_arrow16_right_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL);
                am.setBackgroundResource(view, R.drawable.addresslist_item_bg);
                am.setBackgroundResource(bVar.gJT, R.drawable.picture_content_frame);
            }
            return view;
        }
    }
}
