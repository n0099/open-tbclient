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
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import java.util.List;
import tbclient.FrsPage.RecmForumInfo;
/* loaded from: classes21.dex */
public class a extends com.baidu.tbadk.k.a {
    private com.baidu.adp.base.e eGT;
    protected TbImageView frM;
    private BdListView jmO;
    private C0739a jmP;
    private TextView jmQ;
    private View mDivider;
    private TextView mTitleView;
    protected TextView subTextView;

    /* loaded from: classes21.dex */
    public static class b {
        public View eHl;
        public TextView jmU;
        public TextView jmV;
        public TextView jmW;
        public ImageView jmX;
        public TbImageView jmY;
        public TextView jmZ;
        public TextView jna;
        public ImageView jnb;
        public View rootView;
    }

    public a(com.baidu.adp.base.e eVar, View.OnClickListener onClickListener) {
        super(LayoutInflater.from(eVar.getContext()).inflate(R.layout.forbid_detail_view_layout, (ViewGroup) null));
        this.eGT = eVar;
        this.frM = (TbImageView) this.attachedView.findViewById(R.id.net_refresh_image);
        this.subTextView = (TextView) this.attachedView.findViewById(R.id.net_refresh_desc);
        this.mDivider = this.attachedView.findViewById(R.id.divider);
        this.jmO = (BdListView) this.attachedView.findViewById(R.id.recommend_bar_listview);
        this.attachedView.setOnClickListener(null);
        this.mTitleView = (TextView) this.attachedView.findViewById(R.id.content_title);
        this.jmQ = (TextView) this.attachedView.findViewById(R.id.local_tip_tv);
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
            this.jmP = new C0739a(list);
            this.jmO.setAdapter((ListAdapter) this.jmP);
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
        this.frM.setImageResource(0);
    }

    public void onChangeSkinType() {
        if (isViewAttached()) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            ap.setImageResource(this.frM, R.drawable.new_pic_emotion_01);
            ap.setViewTextColor(this.subTextView, R.color.CAM_X0109, 1, skinType);
            ap.setBackgroundColor(this.attachedView, R.color.CAM_X0201);
            ap.setBackgroundColor(this.mDivider, R.color.CAM_X0204);
            ap.setViewTextColor(this.mTitleView, R.color.CAM_X0109, 1, skinType);
            ap.setViewTextColor(this.jmQ, R.color.CAM_X0106, 1, skinType);
            if (this.jmP != null) {
                this.jmP.notifyDataSetChanged();
            }
        }
    }

    /* renamed from: com.baidu.tieba.frs.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes21.dex */
    public class C0739a extends BaseAdapter {
        private List<RecmForumInfo> jmR;

        public C0739a(List<RecmForumInfo> list) {
            this.jmR = list;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return this.jmR.size();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.widget.Adapter
        /* renamed from: Br */
        public RecmForumInfo getItem(int i) {
            return this.jmR.get(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(final int i, View view, ViewGroup viewGroup) {
            b bVar;
            if (view == null) {
                view = LayoutInflater.from(a.this.eGT.getPageActivity()).inflate(R.layout.recommend_view, (ViewGroup) null);
                b bVar2 = new b();
                bVar2.rootView = view.findViewById(R.id.root_view);
                bVar2.jmU = (TextView) view.findViewById(R.id.forum_name);
                bVar2.jmW = (TextView) view.findViewById(R.id.follow_tv);
                bVar2.jmV = (TextView) view.findViewById(R.id.thread_tv);
                bVar2.jmX = (ImageView) view.findViewById(R.id.arrow_item_img);
                bVar2.jmY = (TbImageView) view.findViewById(R.id.headview);
                bVar2.jmZ = (TextView) view.findViewById(R.id.follow_title);
                bVar2.jna = (TextView) view.findViewById(R.id.thread_title);
                bVar2.eHl = view.findViewById(R.id.divider_line);
                bVar2.jnb = (ImageView) view.findViewById(R.id.content_img);
                view.setTag(bVar2);
                bVar = bVar2;
            } else {
                bVar = (b) view.getTag();
            }
            if (getItem(i) != null) {
                bVar.jmU.setText(au.cutChineseAndEnglishWithSuffix(getItem(i).forum_name, 14, StringHelper.STRING_MORE));
                bVar.jmY.startLoad(getItem(i).avatar, 10, false);
                bVar.jmW.setText(au.numberUniformFormat(getItem(i).member_count.intValue()));
                bVar.jmV.setText(au.numberUniformFormat(getItem(i).post_num.intValue()));
                bVar.rootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.a.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (!StringUtils.isNull(C0739a.this.getItem(i).forum_name)) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(a.this.eGT.getContext()).createNormalCfg(C0739a.this.getItem(i).forum_name, null)));
                        }
                    }
                });
                ap.setViewTextColor(bVar.jmU, R.color.CAM_X0105);
                ap.setViewTextColor(bVar.jmW, R.color.CAM_X0109);
                ap.setViewTextColor(bVar.jmV, R.color.CAM_X0109);
                ap.setViewTextColor(bVar.jna, R.color.CAM_X0109);
                ap.setViewTextColor(bVar.jmZ, R.color.CAM_X0109);
                ap.setBackgroundResource(bVar.eHl, R.color.CAM_X0204);
                SvgManager.bqB().a(bVar.jmX, R.drawable.icon_pure_list_arrow16_right_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL);
                ap.setBackgroundResource(view, R.drawable.addresslist_item_bg);
                ap.setBackgroundResource(bVar.jnb, R.drawable.picture_content_frame);
            }
            return view;
        }
    }
}
