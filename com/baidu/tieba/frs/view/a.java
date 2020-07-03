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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import java.util.List;
import tbclient.FrsPage.RecmForumInfo;
/* loaded from: classes9.dex */
public class a extends com.baidu.tbadk.k.a {
    private com.baidu.adp.base.e dPR;
    protected TbImageView eys;
    private BdListView idj;
    private C0632a idk;
    private TextView idm;
    private View mDivider;
    private TextView mTitleView;
    protected TextView subTextView;

    /* loaded from: classes9.dex */
    public static class b {
        public View dQh;
        public ImageView idA;
        public TextView idq;
        public TextView idr;
        public TextView idu;
        public ImageView idv;
        public TbImageView idw;
        public TextView idy;
        public TextView idz;
        public View rootView;
    }

    public a(com.baidu.adp.base.e eVar, View.OnClickListener onClickListener) {
        super(LayoutInflater.from(eVar.getContext()).inflate(R.layout.forbid_detail_view_layout, (ViewGroup) null));
        this.dPR = eVar;
        this.eys = (TbImageView) this.attachedView.findViewById(R.id.net_refresh_image);
        this.subTextView = (TextView) this.attachedView.findViewById(R.id.net_refresh_desc);
        this.mDivider = this.attachedView.findViewById(R.id.divider);
        this.idj = (BdListView) this.attachedView.findViewById(R.id.recommend_bar_listview);
        this.attachedView.setOnClickListener(null);
        this.mTitleView = (TextView) this.attachedView.findViewById(R.id.content_title);
        this.idm = (TextView) this.attachedView.findViewById(R.id.local_tip_tv);
    }

    public void setSubText(String str) {
        if (str == null) {
            this.subTextView.setVisibility(8);
            return;
        }
        this.subTextView.setVisibility(0);
        this.subTextView.setText(str);
    }

    public void cM(List<RecmForumInfo> list) {
        if (list != null) {
            this.idk = new C0632a(list);
            this.idj.setAdapter((ListAdapter) this.idk);
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
        this.eys.setImageResource(0);
    }

    public void onChangeSkinType() {
        if (isViewAttached()) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            an.setImageResource(this.eys, R.drawable.new_pic_emotion_01);
            an.setViewTextColor(this.subTextView, R.color.cp_cont_d, 1, skinType);
            an.setBackgroundColor(this.attachedView, R.color.cp_bg_line_d);
            an.setBackgroundColor(this.mDivider, R.color.cp_bg_line_c);
            an.setViewTextColor(this.mTitleView, R.color.cp_cont_d, 1, skinType);
            an.setViewTextColor(this.idm, R.color.cp_cont_f, 1, skinType);
            if (this.idk != null) {
                this.idk.notifyDataSetChanged();
            }
        }
    }

    /* renamed from: com.baidu.tieba.frs.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class C0632a extends BaseAdapter {
        private List<RecmForumInfo> idn;

        public C0632a(List<RecmForumInfo> list) {
            this.idn = list;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return this.idn.size();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.widget.Adapter
        /* renamed from: wx */
        public RecmForumInfo getItem(int i) {
            return this.idn.get(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(final int i, View view, ViewGroup viewGroup) {
            b bVar;
            if (view == null) {
                view = LayoutInflater.from(a.this.dPR.getPageActivity()).inflate(R.layout.recommend_view, (ViewGroup) null);
                b bVar2 = new b();
                bVar2.rootView = view.findViewById(R.id.root_view);
                bVar2.idq = (TextView) view.findViewById(R.id.forum_name);
                bVar2.idu = (TextView) view.findViewById(R.id.follow_tv);
                bVar2.idr = (TextView) view.findViewById(R.id.thread_tv);
                bVar2.idv = (ImageView) view.findViewById(R.id.arrow_item_img);
                bVar2.idw = (TbImageView) view.findViewById(R.id.headview);
                bVar2.idy = (TextView) view.findViewById(R.id.follow_title);
                bVar2.idz = (TextView) view.findViewById(R.id.thread_title);
                bVar2.dQh = view.findViewById(R.id.divider_line);
                bVar2.idA = (ImageView) view.findViewById(R.id.content_img);
                view.setTag(bVar2);
                bVar = bVar2;
            } else {
                bVar = (b) view.getTag();
            }
            if (getItem(i) != null) {
                bVar.idq.setText(ar.cutChineseAndEnglishWithSuffix(getItem(i).forum_name, 14, StringHelper.STRING_MORE));
                bVar.idw.startLoad(getItem(i).avatar, 10, false);
                bVar.idu.setText(ar.numberUniformFormat(getItem(i).member_count.intValue()));
                bVar.idr.setText(ar.numberUniformFormat(getItem(i).post_num.intValue()));
                bVar.rootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.a.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (!StringUtils.isNull(C0632a.this.getItem(i).forum_name)) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(a.this.dPR.getContext()).createNormalCfg(C0632a.this.getItem(i).forum_name, null)));
                        }
                    }
                });
                an.setViewTextColor(bVar.idq, (int) R.color.cp_cont_b);
                an.setViewTextColor(bVar.idu, (int) R.color.cp_cont_d);
                an.setViewTextColor(bVar.idr, (int) R.color.cp_cont_d);
                an.setViewTextColor(bVar.idz, (int) R.color.cp_cont_d);
                an.setViewTextColor(bVar.idy, (int) R.color.cp_cont_d);
                an.setBackgroundResource(bVar.dQh, R.color.cp_bg_line_c);
                SvgManager.aWQ().a(bVar.idv, R.drawable.icon_pure_list_arrow16_right_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL);
                an.setBackgroundResource(view, R.drawable.addresslist_item_bg);
                an.setBackgroundResource(bVar.idA, R.drawable.picture_content_frame);
            }
            return view;
        }
    }
}
