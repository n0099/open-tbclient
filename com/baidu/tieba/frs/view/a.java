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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import java.util.List;
import tbclient.FrsPage.RecmForumInfo;
/* loaded from: classes16.dex */
public class a extends com.baidu.tbadk.k.a {
    private com.baidu.adp.base.e dWk;
    protected TbImageView eEI;
    private BdListView ijn;
    private C0642a ijo;
    private TextView ijp;
    private View mDivider;
    private TextView mTitleView;
    protected TextView subTextView;

    /* loaded from: classes16.dex */
    public static class b {
        public View dWz;
        public ImageView ijA;
        public TextView ijt;
        public TextView iju;
        public TextView ijv;
        public ImageView ijw;
        public TbImageView ijx;
        public TextView ijy;
        public TextView ijz;
        public View rootView;
    }

    public a(com.baidu.adp.base.e eVar, View.OnClickListener onClickListener) {
        super(LayoutInflater.from(eVar.getContext()).inflate(R.layout.forbid_detail_view_layout, (ViewGroup) null));
        this.dWk = eVar;
        this.eEI = (TbImageView) this.attachedView.findViewById(R.id.net_refresh_image);
        this.subTextView = (TextView) this.attachedView.findViewById(R.id.net_refresh_desc);
        this.mDivider = this.attachedView.findViewById(R.id.divider);
        this.ijn = (BdListView) this.attachedView.findViewById(R.id.recommend_bar_listview);
        this.attachedView.setOnClickListener(null);
        this.mTitleView = (TextView) this.attachedView.findViewById(R.id.content_title);
        this.ijp = (TextView) this.attachedView.findViewById(R.id.local_tip_tv);
    }

    public void setSubText(String str) {
        if (str == null) {
            this.subTextView.setVisibility(8);
            return;
        }
        this.subTextView.setVisibility(0);
        this.subTextView.setText(str);
    }

    public void cR(List<RecmForumInfo> list) {
        if (list != null) {
            this.ijo = new C0642a(list);
            this.ijn.setAdapter((ListAdapter) this.ijo);
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
        this.eEI.setImageResource(0);
    }

    public void onChangeSkinType() {
        if (isViewAttached()) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            ao.setImageResource(this.eEI, R.drawable.new_pic_emotion_01);
            ao.setViewTextColor(this.subTextView, R.color.cp_cont_d, 1, skinType);
            ao.setBackgroundColor(this.attachedView, R.color.cp_bg_line_d);
            ao.setBackgroundColor(this.mDivider, R.color.cp_bg_line_c);
            ao.setViewTextColor(this.mTitleView, R.color.cp_cont_d, 1, skinType);
            ao.setViewTextColor(this.ijp, R.color.cp_cont_f, 1, skinType);
            if (this.ijo != null) {
                this.ijo.notifyDataSetChanged();
            }
        }
    }

    /* renamed from: com.baidu.tieba.frs.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes16.dex */
    public class C0642a extends BaseAdapter {
        private List<RecmForumInfo> ijq;

        public C0642a(List<RecmForumInfo> list) {
            this.ijq = list;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return this.ijq.size();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.widget.Adapter
        /* renamed from: wP */
        public RecmForumInfo getItem(int i) {
            return this.ijq.get(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(final int i, View view, ViewGroup viewGroup) {
            b bVar;
            if (view == null) {
                view = LayoutInflater.from(a.this.dWk.getPageActivity()).inflate(R.layout.recommend_view, (ViewGroup) null);
                b bVar2 = new b();
                bVar2.rootView = view.findViewById(R.id.root_view);
                bVar2.ijt = (TextView) view.findViewById(R.id.forum_name);
                bVar2.ijv = (TextView) view.findViewById(R.id.follow_tv);
                bVar2.iju = (TextView) view.findViewById(R.id.thread_tv);
                bVar2.ijw = (ImageView) view.findViewById(R.id.arrow_item_img);
                bVar2.ijx = (TbImageView) view.findViewById(R.id.headview);
                bVar2.ijy = (TextView) view.findViewById(R.id.follow_title);
                bVar2.ijz = (TextView) view.findViewById(R.id.thread_title);
                bVar2.dWz = view.findViewById(R.id.divider_line);
                bVar2.ijA = (ImageView) view.findViewById(R.id.content_img);
                view.setTag(bVar2);
                bVar = bVar2;
            } else {
                bVar = (b) view.getTag();
            }
            if (getItem(i) != null) {
                bVar.ijt.setText(as.cutChineseAndEnglishWithSuffix(getItem(i).forum_name, 14, StringHelper.STRING_MORE));
                bVar.ijx.startLoad(getItem(i).avatar, 10, false);
                bVar.ijv.setText(as.numberUniformFormat(getItem(i).member_count.intValue()));
                bVar.iju.setText(as.numberUniformFormat(getItem(i).post_num.intValue()));
                bVar.rootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.a.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (!StringUtils.isNull(C0642a.this.getItem(i).forum_name)) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(a.this.dWk.getContext()).createNormalCfg(C0642a.this.getItem(i).forum_name, null)));
                        }
                    }
                });
                ao.setViewTextColor(bVar.ijt, R.color.cp_cont_b);
                ao.setViewTextColor(bVar.ijv, R.color.cp_cont_d);
                ao.setViewTextColor(bVar.iju, R.color.cp_cont_d);
                ao.setViewTextColor(bVar.ijz, R.color.cp_cont_d);
                ao.setViewTextColor(bVar.ijy, R.color.cp_cont_d);
                ao.setBackgroundResource(bVar.dWz, R.color.cp_bg_line_c);
                SvgManager.baR().a(bVar.ijw, R.drawable.icon_pure_list_arrow16_right_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL);
                ao.setBackgroundResource(view, R.drawable.addresslist_item_bg);
                ao.setBackgroundResource(bVar.ijA, R.drawable.picture_content_frame);
            }
            return view;
        }
    }
}
