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
/* loaded from: classes22.dex */
public class a extends com.baidu.tbadk.k.a {
    private com.baidu.adp.base.e eCK;
    protected TbImageView fmL;
    private BdListView jgf;
    private C0724a jgg;
    private TextView jgh;
    private View mDivider;
    private TextView mTitleView;
    protected TextView subTextView;

    /* loaded from: classes22.dex */
    public static class b {
        public View eCZ;
        public TextView jgl;
        public TextView jgm;
        public TextView jgn;
        public ImageView jgo;
        public TbImageView jgp;
        public TextView jgq;
        public TextView jgr;
        public ImageView jgs;
        public View rootView;
    }

    public a(com.baidu.adp.base.e eVar, View.OnClickListener onClickListener) {
        super(LayoutInflater.from(eVar.getContext()).inflate(R.layout.forbid_detail_view_layout, (ViewGroup) null));
        this.eCK = eVar;
        this.fmL = (TbImageView) this.attachedView.findViewById(R.id.net_refresh_image);
        this.subTextView = (TextView) this.attachedView.findViewById(R.id.net_refresh_desc);
        this.mDivider = this.attachedView.findViewById(R.id.divider);
        this.jgf = (BdListView) this.attachedView.findViewById(R.id.recommend_bar_listview);
        this.attachedView.setOnClickListener(null);
        this.mTitleView = (TextView) this.attachedView.findViewById(R.id.content_title);
        this.jgh = (TextView) this.attachedView.findViewById(R.id.local_tip_tv);
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
            this.jgg = new C0724a(list);
            this.jgf.setAdapter((ListAdapter) this.jgg);
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
        this.fmL.setImageResource(0);
    }

    public void onChangeSkinType() {
        if (isViewAttached()) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            ap.setImageResource(this.fmL, R.drawable.new_pic_emotion_01);
            ap.setViewTextColor(this.subTextView, R.color.cp_cont_d, 1, skinType);
            ap.setBackgroundColor(this.attachedView, R.color.cp_bg_line_d);
            ap.setBackgroundColor(this.mDivider, R.color.cp_bg_line_c);
            ap.setViewTextColor(this.mTitleView, R.color.cp_cont_d, 1, skinType);
            ap.setViewTextColor(this.jgh, R.color.cp_cont_f, 1, skinType);
            if (this.jgg != null) {
                this.jgg.notifyDataSetChanged();
            }
        }
    }

    /* renamed from: com.baidu.tieba.frs.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes22.dex */
    public class C0724a extends BaseAdapter {
        private List<RecmForumInfo> jgi;

        public C0724a(List<RecmForumInfo> list) {
            this.jgi = list;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return this.jgi.size();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.widget.Adapter
        /* renamed from: AG */
        public RecmForumInfo getItem(int i) {
            return this.jgi.get(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(final int i, View view, ViewGroup viewGroup) {
            b bVar;
            if (view == null) {
                view = LayoutInflater.from(a.this.eCK.getPageActivity()).inflate(R.layout.recommend_view, (ViewGroup) null);
                b bVar2 = new b();
                bVar2.rootView = view.findViewById(R.id.root_view);
                bVar2.jgl = (TextView) view.findViewById(R.id.forum_name);
                bVar2.jgn = (TextView) view.findViewById(R.id.follow_tv);
                bVar2.jgm = (TextView) view.findViewById(R.id.thread_tv);
                bVar2.jgo = (ImageView) view.findViewById(R.id.arrow_item_img);
                bVar2.jgp = (TbImageView) view.findViewById(R.id.headview);
                bVar2.jgq = (TextView) view.findViewById(R.id.follow_title);
                bVar2.jgr = (TextView) view.findViewById(R.id.thread_title);
                bVar2.eCZ = view.findViewById(R.id.divider_line);
                bVar2.jgs = (ImageView) view.findViewById(R.id.content_img);
                view.setTag(bVar2);
                bVar = bVar2;
            } else {
                bVar = (b) view.getTag();
            }
            if (getItem(i) != null) {
                bVar.jgl.setText(at.cutChineseAndEnglishWithSuffix(getItem(i).forum_name, 14, StringHelper.STRING_MORE));
                bVar.jgp.startLoad(getItem(i).avatar, 10, false);
                bVar.jgn.setText(at.numberUniformFormat(getItem(i).member_count.intValue()));
                bVar.jgm.setText(at.numberUniformFormat(getItem(i).post_num.intValue()));
                bVar.rootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.a.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (!StringUtils.isNull(C0724a.this.getItem(i).forum_name)) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(a.this.eCK.getContext()).createNormalCfg(C0724a.this.getItem(i).forum_name, null)));
                        }
                    }
                });
                ap.setViewTextColor(bVar.jgl, R.color.cp_cont_b);
                ap.setViewTextColor(bVar.jgn, R.color.cp_cont_d);
                ap.setViewTextColor(bVar.jgm, R.color.cp_cont_d);
                ap.setViewTextColor(bVar.jgr, R.color.cp_cont_d);
                ap.setViewTextColor(bVar.jgq, R.color.cp_cont_d);
                ap.setBackgroundResource(bVar.eCZ, R.color.cp_bg_line_c);
                SvgManager.boN().a(bVar.jgo, R.drawable.icon_pure_list_arrow16_right_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL);
                ap.setBackgroundResource(view, R.drawable.addresslist_item_bg);
                ap.setBackgroundResource(bVar.jgs, R.drawable.picture_content_frame);
            }
            return view;
        }
    }
}
