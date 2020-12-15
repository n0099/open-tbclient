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
/* loaded from: classes22.dex */
public class a extends com.baidu.tbadk.l.a {
    private com.baidu.adp.base.e eNZ;
    protected TbImageView fzA;
    private BdListView jAs;
    private C0755a jAt;
    private TextView jAu;
    private View mDivider;
    private TextView mTitleView;
    protected TextView subTextView;

    /* loaded from: classes22.dex */
    public static class b {
        public View eOv;
        public TextView jAA;
        public ImageView jAB;
        public TbImageView jAC;
        public TextView jAD;
        public TextView jAE;
        public ImageView jAF;
        public TextView jAy;
        public TextView jAz;
        public View rootView;
    }

    public a(com.baidu.adp.base.e eVar, View.OnClickListener onClickListener) {
        super(LayoutInflater.from(eVar.getContext()).inflate(R.layout.forbid_detail_view_layout, (ViewGroup) null));
        this.eNZ = eVar;
        this.fzA = (TbImageView) this.attachedView.findViewById(R.id.net_refresh_image);
        this.subTextView = (TextView) this.attachedView.findViewById(R.id.net_refresh_desc);
        this.mDivider = this.attachedView.findViewById(R.id.divider);
        this.jAs = (BdListView) this.attachedView.findViewById(R.id.recommend_bar_listview);
        this.attachedView.setOnClickListener(null);
        this.mTitleView = (TextView) this.attachedView.findViewById(R.id.content_title);
        this.jAu = (TextView) this.attachedView.findViewById(R.id.local_tip_tv);
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
            this.jAt = new C0755a(list);
            this.jAs.setAdapter((ListAdapter) this.jAt);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.l.a
    public void onViewAttached() {
        super.onViewAttached();
        onChangeSkinType();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.l.a
    public void onViewDettached() {
        super.onViewDettached();
        this.fzA.setImageResource(0);
    }

    public void onChangeSkinType() {
        if (isViewAttached()) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            ap.setImageResource(this.fzA, R.drawable.new_pic_emotion_01);
            ap.setViewTextColor(this.subTextView, R.color.CAM_X0109, 1, skinType);
            ap.setBackgroundColor(this.attachedView, R.color.CAM_X0201);
            ap.setBackgroundColor(this.mDivider, R.color.CAM_X0204);
            ap.setViewTextColor(this.mTitleView, R.color.CAM_X0109, 1, skinType);
            ap.setViewTextColor(this.jAu, R.color.CAM_X0106, 1, skinType);
            if (this.jAt != null) {
                this.jAt.notifyDataSetChanged();
            }
        }
    }

    /* renamed from: com.baidu.tieba.frs.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes22.dex */
    public class C0755a extends BaseAdapter {
        private List<RecmForumInfo> jAv;

        public C0755a(List<RecmForumInfo> list) {
            this.jAv = list;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return this.jAv.size();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.widget.Adapter
        /* renamed from: Cg */
        public RecmForumInfo getItem(int i) {
            return this.jAv.get(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(final int i, View view, ViewGroup viewGroup) {
            b bVar;
            if (view == null) {
                view = LayoutInflater.from(a.this.eNZ.getPageActivity()).inflate(R.layout.recommend_view, (ViewGroup) null);
                b bVar2 = new b();
                bVar2.rootView = view.findViewById(R.id.root_view);
                bVar2.jAy = (TextView) view.findViewById(R.id.forum_name);
                bVar2.jAA = (TextView) view.findViewById(R.id.follow_tv);
                bVar2.jAz = (TextView) view.findViewById(R.id.thread_tv);
                bVar2.jAB = (ImageView) view.findViewById(R.id.arrow_item_img);
                bVar2.jAC = (TbImageView) view.findViewById(R.id.headview);
                bVar2.jAD = (TextView) view.findViewById(R.id.follow_title);
                bVar2.jAE = (TextView) view.findViewById(R.id.thread_title);
                bVar2.eOv = view.findViewById(R.id.divider_line);
                bVar2.jAF = (ImageView) view.findViewById(R.id.content_img);
                view.setTag(bVar2);
                bVar = bVar2;
            } else {
                bVar = (b) view.getTag();
            }
            if (getItem(i) != null) {
                bVar.jAy.setText(au.cutChineseAndEnglishWithSuffix(getItem(i).forum_name, 14, StringHelper.STRING_MORE));
                bVar.jAC.startLoad(getItem(i).avatar, 10, false);
                bVar.jAA.setText(au.numberUniformFormat(getItem(i).member_count.intValue()));
                bVar.jAz.setText(au.numberUniformFormat(getItem(i).post_num.intValue()));
                bVar.rootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.a.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (!StringUtils.isNull(C0755a.this.getItem(i).forum_name)) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(a.this.eNZ.getContext()).createNormalCfg(C0755a.this.getItem(i).forum_name, null)));
                        }
                    }
                });
                ap.setViewTextColor(bVar.jAy, R.color.CAM_X0105);
                ap.setViewTextColor(bVar.jAA, R.color.CAM_X0109);
                ap.setViewTextColor(bVar.jAz, R.color.CAM_X0109);
                ap.setViewTextColor(bVar.jAE, R.color.CAM_X0109);
                ap.setViewTextColor(bVar.jAD, R.color.CAM_X0109);
                ap.setBackgroundResource(bVar.eOv, R.color.CAM_X0204);
                SvgManager.btW().a(bVar.jAB, R.drawable.icon_pure_list_arrow16_right_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL);
                ap.setBackgroundResource(view, R.drawable.addresslist_item_bg);
                ap.setBackgroundResource(bVar.jAF, R.drawable.picture_content_frame);
            }
            return view;
        }
    }
}
