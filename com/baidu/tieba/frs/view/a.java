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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import java.util.List;
import tbclient.FrsPage.RecmForumInfo;
/* loaded from: classes2.dex */
public class a extends com.baidu.tbadk.l.a {
    private View dBb;
    private f eVB;
    protected TbImageView fGL;
    private BdListView jPi;
    private C0739a jPj;
    private TextView jPk;
    private TextView mTitleView;
    protected TextView subTextView;

    /* loaded from: classes2.dex */
    public static class b {
        public View bTo;
        public TextView jPo;
        public TextView jPp;
        public TextView jPq;
        public ImageView jPr;
        public TbImageView jPs;
        public TextView jPt;
        public TextView jPu;
        public ImageView jPv;
        public View rootView;
    }

    public a(f fVar, View.OnClickListener onClickListener) {
        super(LayoutInflater.from(fVar.getContext()).inflate(R.layout.forbid_detail_view_layout, (ViewGroup) null));
        this.eVB = fVar;
        this.fGL = (TbImageView) this.attachedView.findViewById(R.id.net_refresh_image);
        this.subTextView = (TextView) this.attachedView.findViewById(R.id.net_refresh_desc);
        this.dBb = this.attachedView.findViewById(R.id.divider);
        this.jPi = (BdListView) this.attachedView.findViewById(R.id.recommend_bar_listview);
        this.attachedView.setOnClickListener(null);
        this.mTitleView = (TextView) this.attachedView.findViewById(R.id.content_title);
        this.jPk = (TextView) this.attachedView.findViewById(R.id.local_tip_tv);
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
            this.jPj = new C0739a(list);
            this.jPi.setAdapter((ListAdapter) this.jPj);
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
        this.fGL.setImageResource(0);
    }

    public void onChangeSkinType() {
        if (isViewAttached()) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            ap.setImageResource(this.fGL, R.drawable.new_pic_emotion_01);
            ap.setViewTextColor(this.subTextView, R.color.CAM_X0109, 1, skinType);
            ap.setBackgroundColor(this.attachedView, R.color.CAM_X0201);
            ap.setBackgroundColor(this.dBb, R.color.CAM_X0204);
            ap.setViewTextColor(this.mTitleView, R.color.CAM_X0109, 1, skinType);
            ap.setViewTextColor(this.jPk, R.color.CAM_X0106, 1, skinType);
            if (this.jPj != null) {
                this.jPj.notifyDataSetChanged();
            }
        }
    }

    /* renamed from: com.baidu.tieba.frs.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0739a extends BaseAdapter {
        private List<RecmForumInfo> jPl;

        public C0739a(List<RecmForumInfo> list) {
            this.jPl = list;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return this.jPl.size();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.widget.Adapter
        /* renamed from: Bb */
        public RecmForumInfo getItem(int i) {
            return this.jPl.get(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(final int i, View view, ViewGroup viewGroup) {
            b bVar;
            if (view == null) {
                view = LayoutInflater.from(a.this.eVB.getPageActivity()).inflate(R.layout.recommend_view, (ViewGroup) null);
                b bVar2 = new b();
                bVar2.rootView = view.findViewById(R.id.root_view);
                bVar2.jPo = (TextView) view.findViewById(R.id.forum_name);
                bVar2.jPq = (TextView) view.findViewById(R.id.follow_tv);
                bVar2.jPp = (TextView) view.findViewById(R.id.thread_tv);
                bVar2.jPr = (ImageView) view.findViewById(R.id.arrow_item_img);
                bVar2.jPs = (TbImageView) view.findViewById(R.id.headview);
                bVar2.jPt = (TextView) view.findViewById(R.id.follow_title);
                bVar2.jPu = (TextView) view.findViewById(R.id.thread_title);
                bVar2.bTo = view.findViewById(R.id.divider_line);
                bVar2.jPv = (ImageView) view.findViewById(R.id.content_img);
                view.setTag(bVar2);
                bVar = bVar2;
            } else {
                bVar = (b) view.getTag();
            }
            if (getItem(i) != null) {
                bVar.jPo.setText(au.cutChineseAndEnglishWithSuffix(getItem(i).forum_name, 14, StringHelper.STRING_MORE));
                bVar.jPs.startLoad(getItem(i).avatar, 10, false);
                bVar.jPq.setText(au.numberUniformFormat(getItem(i).member_count.intValue()));
                bVar.jPp.setText(au.numberUniformFormat(getItem(i).post_num.intValue()));
                bVar.rootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.a.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (!StringUtils.isNull(C0739a.this.getItem(i).forum_name)) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(a.this.eVB.getContext()).createNormalCfg(C0739a.this.getItem(i).forum_name, null)));
                        }
                    }
                });
                ap.setViewTextColor(bVar.jPo, R.color.CAM_X0105);
                ap.setViewTextColor(bVar.jPq, R.color.CAM_X0109);
                ap.setViewTextColor(bVar.jPp, R.color.CAM_X0109);
                ap.setViewTextColor(bVar.jPu, R.color.CAM_X0109);
                ap.setViewTextColor(bVar.jPt, R.color.CAM_X0109);
                ap.setBackgroundResource(bVar.bTo, R.color.CAM_X0204);
                SvgManager.bsR().a(bVar.jPr, R.drawable.icon_pure_list_arrow16_right_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL);
                ap.setBackgroundResource(view, R.drawable.addresslist_item_bg);
                ap.setBackgroundResource(bVar.jPv, R.drawable.picture_content_frame);
            }
            return view;
        }
    }
}
