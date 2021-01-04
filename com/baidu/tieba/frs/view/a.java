package com.baidu.tieba.frs.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.adp.base.f;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import java.util.List;
import tbclient.FrsPage.RecmForumInfo;
/* loaded from: classes2.dex */
public class a extends com.baidu.tbadk.l.a {
    private View dDI;
    private f eXW;
    protected TbImageView fJg;
    private BdListView jMR;
    private C0748a jMS;
    private TextView jMT;
    private TextView mTitleView;
    protected TextView subTextView;

    /* loaded from: classes2.dex */
    public static class b {
        public View bUk;
        public TextView jMX;
        public TextView jMY;
        public TextView jMZ;
        public ImageView jNa;
        public TbImageView jNb;
        public TextView jNc;
        public TextView jNd;
        public ImageView jNe;
        public View rootView;
    }

    public a(f fVar, View.OnClickListener onClickListener) {
        super(LayoutInflater.from(fVar.getContext()).inflate(R.layout.forbid_detail_view_layout, (ViewGroup) null));
        this.eXW = fVar;
        this.fJg = (TbImageView) this.attachedView.findViewById(R.id.net_refresh_image);
        this.subTextView = (TextView) this.attachedView.findViewById(R.id.net_refresh_desc);
        this.dDI = this.attachedView.findViewById(R.id.divider);
        this.jMR = (BdListView) this.attachedView.findViewById(R.id.recommend_bar_listview);
        this.attachedView.setOnClickListener(null);
        this.mTitleView = (TextView) this.attachedView.findViewById(R.id.content_title);
        this.jMT = (TextView) this.attachedView.findViewById(R.id.local_tip_tv);
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
            this.jMS = new C0748a(list);
            this.jMR.setAdapter((ListAdapter) this.jMS);
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
        this.fJg.setImageResource(0);
    }

    public void onChangeSkinType() {
        if (isViewAttached()) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            ao.setImageResource(this.fJg, R.drawable.new_pic_emotion_01);
            ao.setViewTextColor(this.subTextView, R.color.CAM_X0109, 1, skinType);
            ao.setBackgroundColor(this.attachedView, R.color.CAM_X0201);
            ao.setBackgroundColor(this.dDI, R.color.CAM_X0204);
            ao.setViewTextColor(this.mTitleView, R.color.CAM_X0109, 1, skinType);
            ao.setViewTextColor(this.jMT, R.color.CAM_X0106, 1, skinType);
            if (this.jMS != null) {
                this.jMS.notifyDataSetChanged();
            }
        }
    }

    /* renamed from: com.baidu.tieba.frs.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0748a extends BaseAdapter {
        private List<RecmForumInfo> jMU;

        public C0748a(List<RecmForumInfo> list) {
            this.jMU = list;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return this.jMU.size();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.widget.Adapter
        /* renamed from: Cs */
        public RecmForumInfo getItem(int i) {
            return this.jMU.get(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(final int i, View view, ViewGroup viewGroup) {
            b bVar;
            if (view == null) {
                view = LayoutInflater.from(a.this.eXW.getPageActivity()).inflate(R.layout.recommend_view, (ViewGroup) null);
                b bVar2 = new b();
                bVar2.rootView = view.findViewById(R.id.root_view);
                bVar2.jMX = (TextView) view.findViewById(R.id.forum_name);
                bVar2.jMZ = (TextView) view.findViewById(R.id.follow_tv);
                bVar2.jMY = (TextView) view.findViewById(R.id.thread_tv);
                bVar2.jNa = (ImageView) view.findViewById(R.id.arrow_item_img);
                bVar2.jNb = (TbImageView) view.findViewById(R.id.headview);
                bVar2.jNc = (TextView) view.findViewById(R.id.follow_title);
                bVar2.jNd = (TextView) view.findViewById(R.id.thread_title);
                bVar2.bUk = view.findViewById(R.id.divider_line);
                bVar2.jNe = (ImageView) view.findViewById(R.id.content_img);
                view.setTag(bVar2);
                bVar = bVar2;
            } else {
                bVar = (b) view.getTag();
            }
            if (getItem(i) != null) {
                bVar.jMX.setText(at.cutChineseAndEnglishWithSuffix(getItem(i).forum_name, 14, StringHelper.STRING_MORE));
                bVar.jNb.startLoad(getItem(i).avatar, 10, false);
                bVar.jMZ.setText(at.numberUniformFormat(getItem(i).member_count.intValue()));
                bVar.jMY.setText(at.numberUniformFormat(getItem(i).post_num.intValue()));
                bVar.rootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.a.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (!StringUtils.isNull(C0748a.this.getItem(i).forum_name)) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(a.this.eXW.getContext()).createNormalCfg(C0748a.this.getItem(i).forum_name, null)));
                        }
                    }
                });
                ao.setViewTextColor(bVar.jMX, R.color.CAM_X0105);
                ao.setViewTextColor(bVar.jMZ, R.color.CAM_X0109);
                ao.setViewTextColor(bVar.jMY, R.color.CAM_X0109);
                ao.setViewTextColor(bVar.jNd, R.color.CAM_X0109);
                ao.setViewTextColor(bVar.jNc, R.color.CAM_X0109);
                ao.setBackgroundResource(bVar.bUk, R.color.CAM_X0204);
                SvgManager.bwq().a(bVar.jNa, R.drawable.icon_pure_list_arrow16_right_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL);
                ao.setBackgroundResource(view, R.drawable.addresslist_item_bg);
                ao.setBackgroundResource(bVar.jNe, R.drawable.picture_content_frame);
            }
            return view;
        }
    }
}
