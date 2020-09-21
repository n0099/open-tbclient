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
/* loaded from: classes21.dex */
public class a extends com.baidu.tbadk.k.a {
    protected TbImageView eSe;
    private com.baidu.adp.base.e eid;
    private BdListView iET;
    private C0690a iEU;
    private TextView iEV;
    private View mDivider;
    private TextView mTitleView;
    protected TextView subTextView;

    /* loaded from: classes21.dex */
    public static class b {
        public View eis;
        public TextView iEZ;
        public TextView iFa;
        public TextView iFb;
        public ImageView iFc;
        public TbImageView iFd;
        public TextView iFe;
        public TextView iFf;
        public ImageView iFg;
        public View rootView;
    }

    public a(com.baidu.adp.base.e eVar, View.OnClickListener onClickListener) {
        super(LayoutInflater.from(eVar.getContext()).inflate(R.layout.forbid_detail_view_layout, (ViewGroup) null));
        this.eid = eVar;
        this.eSe = (TbImageView) this.attachedView.findViewById(R.id.net_refresh_image);
        this.subTextView = (TextView) this.attachedView.findViewById(R.id.net_refresh_desc);
        this.mDivider = this.attachedView.findViewById(R.id.divider);
        this.iET = (BdListView) this.attachedView.findViewById(R.id.recommend_bar_listview);
        this.attachedView.setOnClickListener(null);
        this.mTitleView = (TextView) this.attachedView.findViewById(R.id.content_title);
        this.iEV = (TextView) this.attachedView.findViewById(R.id.local_tip_tv);
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
            this.iEU = new C0690a(list);
            this.iET.setAdapter((ListAdapter) this.iEU);
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
        this.eSe.setImageResource(0);
    }

    public void onChangeSkinType() {
        if (isViewAttached()) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            ap.setImageResource(this.eSe, R.drawable.new_pic_emotion_01);
            ap.setViewTextColor(this.subTextView, R.color.cp_cont_d, 1, skinType);
            ap.setBackgroundColor(this.attachedView, R.color.cp_bg_line_d);
            ap.setBackgroundColor(this.mDivider, R.color.cp_bg_line_c);
            ap.setViewTextColor(this.mTitleView, R.color.cp_cont_d, 1, skinType);
            ap.setViewTextColor(this.iEV, R.color.cp_cont_f, 1, skinType);
            if (this.iEU != null) {
                this.iEU.notifyDataSetChanged();
            }
        }
    }

    /* renamed from: com.baidu.tieba.frs.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes21.dex */
    public class C0690a extends BaseAdapter {
        private List<RecmForumInfo> iEW;

        public C0690a(List<RecmForumInfo> list) {
            this.iEW = list;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return this.iEW.size();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.widget.Adapter
        /* renamed from: zH */
        public RecmForumInfo getItem(int i) {
            return this.iEW.get(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(final int i, View view, ViewGroup viewGroup) {
            b bVar;
            if (view == null) {
                view = LayoutInflater.from(a.this.eid.getPageActivity()).inflate(R.layout.recommend_view, (ViewGroup) null);
                b bVar2 = new b();
                bVar2.rootView = view.findViewById(R.id.root_view);
                bVar2.iEZ = (TextView) view.findViewById(R.id.forum_name);
                bVar2.iFb = (TextView) view.findViewById(R.id.follow_tv);
                bVar2.iFa = (TextView) view.findViewById(R.id.thread_tv);
                bVar2.iFc = (ImageView) view.findViewById(R.id.arrow_item_img);
                bVar2.iFd = (TbImageView) view.findViewById(R.id.headview);
                bVar2.iFe = (TextView) view.findViewById(R.id.follow_title);
                bVar2.iFf = (TextView) view.findViewById(R.id.thread_title);
                bVar2.eis = view.findViewById(R.id.divider_line);
                bVar2.iFg = (ImageView) view.findViewById(R.id.content_img);
                view.setTag(bVar2);
                bVar = bVar2;
            } else {
                bVar = (b) view.getTag();
            }
            if (getItem(i) != null) {
                bVar.iEZ.setText(at.cutChineseAndEnglishWithSuffix(getItem(i).forum_name, 14, StringHelper.STRING_MORE));
                bVar.iFd.startLoad(getItem(i).avatar, 10, false);
                bVar.iFb.setText(at.numberUniformFormat(getItem(i).member_count.intValue()));
                bVar.iFa.setText(at.numberUniformFormat(getItem(i).post_num.intValue()));
                bVar.rootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.a.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (!StringUtils.isNull(C0690a.this.getItem(i).forum_name)) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(a.this.eid.getContext()).createNormalCfg(C0690a.this.getItem(i).forum_name, null)));
                        }
                    }
                });
                ap.setViewTextColor(bVar.iEZ, R.color.cp_cont_b);
                ap.setViewTextColor(bVar.iFb, R.color.cp_cont_d);
                ap.setViewTextColor(bVar.iFa, R.color.cp_cont_d);
                ap.setViewTextColor(bVar.iFf, R.color.cp_cont_d);
                ap.setViewTextColor(bVar.iFe, R.color.cp_cont_d);
                ap.setBackgroundResource(bVar.eis, R.color.cp_bg_line_c);
                SvgManager.bkl().a(bVar.iFc, R.drawable.icon_pure_list_arrow16_right_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL);
                ap.setBackgroundResource(view, R.drawable.addresslist_item_bg);
                ap.setBackgroundResource(bVar.iFg, R.drawable.picture_content_frame);
            }
            return view;
        }
    }
}
