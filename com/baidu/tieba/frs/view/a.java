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
/* loaded from: classes4.dex */
public class a extends com.baidu.tbadk.m.a {
    private View bhm;
    protected TbImageView cJP;
    private com.baidu.adp.base.e cfJ;
    private BdListView fVY;
    private C0421a fVZ;
    private TextView fWa;
    private TextView mTitleView;
    protected TextView subTextView;

    /* loaded from: classes4.dex */
    public static class b {
        public View cfY;
        public TextView fWe;
        public TextView fWf;
        public TextView fWg;
        public ImageView fWh;
        public TbImageView fWi;
        public TextView fWj;
        public TextView fWk;
        public ImageView fWl;
        public View rootView;
    }

    public a(com.baidu.adp.base.e eVar, View.OnClickListener onClickListener) {
        super(LayoutInflater.from(eVar.getContext()).inflate(R.layout.forbid_detail_view_layout, (ViewGroup) null));
        this.cfJ = eVar;
        this.cJP = (TbImageView) this.attachedView.findViewById(R.id.net_refresh_image);
        this.subTextView = (TextView) this.attachedView.findViewById(R.id.net_refresh_desc);
        this.bhm = this.attachedView.findViewById(R.id.divider);
        this.fVY = (BdListView) this.attachedView.findViewById(R.id.recommend_bar_listview);
        this.attachedView.setOnClickListener(null);
        this.mTitleView = (TextView) this.attachedView.findViewById(R.id.content_title);
        this.fWa = (TextView) this.attachedView.findViewById(R.id.local_tip_tv);
    }

    public void setSubText(String str) {
        if (str == null) {
            this.subTextView.setVisibility(8);
            return;
        }
        this.subTextView.setVisibility(0);
        this.subTextView.setText(str);
    }

    public void cB(List<RecmForumInfo> list) {
        if (list != null) {
            this.fVZ = new C0421a(list);
            this.fVY.setAdapter((ListAdapter) this.fVZ);
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
        this.cJP.setImageResource(0);
    }

    public void onChangeSkinType() {
        if (isViewAttached()) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            am.setImageResource(this.cJP, R.drawable.new_pic_emotion_01);
            am.setViewTextColor(this.subTextView, R.color.cp_cont_d, 1, skinType);
            am.setBackgroundColor(this.attachedView, R.color.cp_bg_line_d);
            am.setBackgroundColor(this.bhm, R.color.cp_bg_line_c);
            am.setViewTextColor(this.mTitleView, R.color.cp_cont_d, 1, skinType);
            am.setViewTextColor(this.fWa, R.color.cp_cont_f, 1, skinType);
            if (this.fVZ != null) {
                this.fVZ.notifyDataSetChanged();
            }
        }
    }

    /* renamed from: com.baidu.tieba.frs.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C0421a extends BaseAdapter {
        private List<RecmForumInfo> fWb;

        public C0421a(List<RecmForumInfo> list) {
            this.fWb = list;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return this.fWb.size();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.widget.Adapter
        /* renamed from: sm */
        public RecmForumInfo getItem(int i) {
            return this.fWb.get(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(final int i, View view, ViewGroup viewGroup) {
            b bVar;
            if (view == null) {
                view = LayoutInflater.from(a.this.cfJ.getPageActivity()).inflate(R.layout.recommend_view, (ViewGroup) null);
                b bVar2 = new b();
                bVar2.rootView = view.findViewById(R.id.root_view);
                bVar2.fWe = (TextView) view.findViewById(R.id.forum_name);
                bVar2.fWg = (TextView) view.findViewById(R.id.follow_tv);
                bVar2.fWf = (TextView) view.findViewById(R.id.thread_tv);
                bVar2.fWh = (ImageView) view.findViewById(R.id.arrow_item_img);
                bVar2.fWi = (TbImageView) view.findViewById(R.id.headview);
                bVar2.fWj = (TextView) view.findViewById(R.id.follow_title);
                bVar2.fWk = (TextView) view.findViewById(R.id.thread_title);
                bVar2.cfY = view.findViewById(R.id.divider_line);
                bVar2.fWl = (ImageView) view.findViewById(R.id.content_img);
                view.setTag(bVar2);
                bVar = bVar2;
            } else {
                bVar = (b) view.getTag();
            }
            if (getItem(i) != null) {
                bVar.fWe.setText(aq.cutChineseAndEnglishWithSuffix(getItem(i).forum_name, 14, StringHelper.STRING_MORE));
                bVar.fWi.startLoad(getItem(i).avatar, 10, false);
                bVar.fWg.setText(aq.numberUniformFormat(getItem(i).member_count.intValue()));
                bVar.fWf.setText(aq.numberUniformFormat(getItem(i).post_num.intValue()));
                bVar.rootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.a.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (!StringUtils.isNull(C0421a.this.getItem(i).forum_name)) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(a.this.cfJ.getContext()).createNormalCfg(C0421a.this.getItem(i).forum_name, null)));
                        }
                    }
                });
                am.setViewTextColor(bVar.fWe, (int) R.color.cp_cont_b);
                am.setViewTextColor(bVar.fWg, (int) R.color.cp_cont_d);
                am.setViewTextColor(bVar.fWf, (int) R.color.cp_cont_d);
                am.setViewTextColor(bVar.fWk, (int) R.color.cp_cont_d);
                am.setViewTextColor(bVar.fWj, (int) R.color.cp_cont_d);
                am.setBackgroundResource(bVar.cfY, R.color.cp_bg_line_c);
                SvgManager.amN().a(bVar.fWh, R.drawable.icon_pure_list_arrow16_right_tint_n_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL);
                am.setBackgroundResource(view, R.drawable.addresslist_item_bg);
                am.setBackgroundResource(bVar.fWl, R.drawable.picture_content_frame);
            }
            return view;
        }
    }
}
