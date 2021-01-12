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
    private View dyW;
    private f eTl;
    protected TbImageView fEz;
    private BdListView jIl;
    private C0738a jIm;
    private TextView jIn;
    private TextView mTitleView;
    protected TextView subTextView;

    /* loaded from: classes2.dex */
    public static class b {
        public View bPy;
        public TextView jIr;
        public TextView jIs;
        public TextView jIt;
        public ImageView jIu;
        public TbImageView jIv;
        public TextView jIw;
        public TextView jIx;
        public ImageView jIy;
        public View rootView;
    }

    public a(f fVar, View.OnClickListener onClickListener) {
        super(LayoutInflater.from(fVar.getContext()).inflate(R.layout.forbid_detail_view_layout, (ViewGroup) null));
        this.eTl = fVar;
        this.fEz = (TbImageView) this.attachedView.findViewById(R.id.net_refresh_image);
        this.subTextView = (TextView) this.attachedView.findViewById(R.id.net_refresh_desc);
        this.dyW = this.attachedView.findViewById(R.id.divider);
        this.jIl = (BdListView) this.attachedView.findViewById(R.id.recommend_bar_listview);
        this.attachedView.setOnClickListener(null);
        this.mTitleView = (TextView) this.attachedView.findViewById(R.id.content_title);
        this.jIn = (TextView) this.attachedView.findViewById(R.id.local_tip_tv);
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
            this.jIm = new C0738a(list);
            this.jIl.setAdapter((ListAdapter) this.jIm);
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
        this.fEz.setImageResource(0);
    }

    public void onChangeSkinType() {
        if (isViewAttached()) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            ao.setImageResource(this.fEz, R.drawable.new_pic_emotion_01);
            ao.setViewTextColor(this.subTextView, R.color.CAM_X0109, 1, skinType);
            ao.setBackgroundColor(this.attachedView, R.color.CAM_X0201);
            ao.setBackgroundColor(this.dyW, R.color.CAM_X0204);
            ao.setViewTextColor(this.mTitleView, R.color.CAM_X0109, 1, skinType);
            ao.setViewTextColor(this.jIn, R.color.CAM_X0106, 1, skinType);
            if (this.jIm != null) {
                this.jIm.notifyDataSetChanged();
            }
        }
    }

    /* renamed from: com.baidu.tieba.frs.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0738a extends BaseAdapter {
        private List<RecmForumInfo> jIo;

        public C0738a(List<RecmForumInfo> list) {
            this.jIo = list;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return this.jIo.size();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.widget.Adapter
        /* renamed from: AM */
        public RecmForumInfo getItem(int i) {
            return this.jIo.get(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(final int i, View view, ViewGroup viewGroup) {
            b bVar;
            if (view == null) {
                view = LayoutInflater.from(a.this.eTl.getPageActivity()).inflate(R.layout.recommend_view, (ViewGroup) null);
                b bVar2 = new b();
                bVar2.rootView = view.findViewById(R.id.root_view);
                bVar2.jIr = (TextView) view.findViewById(R.id.forum_name);
                bVar2.jIt = (TextView) view.findViewById(R.id.follow_tv);
                bVar2.jIs = (TextView) view.findViewById(R.id.thread_tv);
                bVar2.jIu = (ImageView) view.findViewById(R.id.arrow_item_img);
                bVar2.jIv = (TbImageView) view.findViewById(R.id.headview);
                bVar2.jIw = (TextView) view.findViewById(R.id.follow_title);
                bVar2.jIx = (TextView) view.findViewById(R.id.thread_title);
                bVar2.bPy = view.findViewById(R.id.divider_line);
                bVar2.jIy = (ImageView) view.findViewById(R.id.content_img);
                view.setTag(bVar2);
                bVar = bVar2;
            } else {
                bVar = (b) view.getTag();
            }
            if (getItem(i) != null) {
                bVar.jIr.setText(at.cutChineseAndEnglishWithSuffix(getItem(i).forum_name, 14, StringHelper.STRING_MORE));
                bVar.jIv.startLoad(getItem(i).avatar, 10, false);
                bVar.jIt.setText(at.numberUniformFormat(getItem(i).member_count.intValue()));
                bVar.jIs.setText(at.numberUniformFormat(getItem(i).post_num.intValue()));
                bVar.rootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.a.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (!StringUtils.isNull(C0738a.this.getItem(i).forum_name)) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(a.this.eTl.getContext()).createNormalCfg(C0738a.this.getItem(i).forum_name, null)));
                        }
                    }
                });
                ao.setViewTextColor(bVar.jIr, R.color.CAM_X0105);
                ao.setViewTextColor(bVar.jIt, R.color.CAM_X0109);
                ao.setViewTextColor(bVar.jIs, R.color.CAM_X0109);
                ao.setViewTextColor(bVar.jIx, R.color.CAM_X0109);
                ao.setViewTextColor(bVar.jIw, R.color.CAM_X0109);
                ao.setBackgroundResource(bVar.bPy, R.color.CAM_X0204);
                SvgManager.bsx().a(bVar.jIu, R.drawable.icon_pure_list_arrow16_right_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL);
                ao.setBackgroundResource(view, R.drawable.addresslist_item_bg);
                ao.setBackgroundResource(bVar.jIy, R.drawable.picture_content_frame);
            }
            return view;
        }
    }
}
