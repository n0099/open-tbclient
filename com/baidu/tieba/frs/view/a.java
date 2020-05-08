package com.baidu.tieba.frs.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.adp.base.e;
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
/* loaded from: classes9.dex */
public class a extends com.baidu.tbadk.k.a {
    private e dvg;
    protected TbImageView ebo;
    private BdListView hAs;
    private C0573a hAt;
    private TextView hAu;
    private View mDivider;
    private TextView mTitleView;
    protected TextView subTextView;

    /* loaded from: classes9.dex */
    public static class b {
        public View dvw;
        public TextView hAA;
        public ImageView hAB;
        public TbImageView hAC;
        public TextView hAD;
        public TextView hAE;
        public ImageView hAF;
        public TextView hAy;
        public TextView hAz;
        public View rootView;
    }

    public a(e eVar, View.OnClickListener onClickListener) {
        super(LayoutInflater.from(eVar.getContext()).inflate(R.layout.forbid_detail_view_layout, (ViewGroup) null));
        this.dvg = eVar;
        this.ebo = (TbImageView) this.attachedView.findViewById(R.id.net_refresh_image);
        this.subTextView = (TextView) this.attachedView.findViewById(R.id.net_refresh_desc);
        this.mDivider = this.attachedView.findViewById(R.id.divider);
        this.hAs = (BdListView) this.attachedView.findViewById(R.id.recommend_bar_listview);
        this.attachedView.setOnClickListener(null);
        this.mTitleView = (TextView) this.attachedView.findViewById(R.id.content_title);
        this.hAu = (TextView) this.attachedView.findViewById(R.id.local_tip_tv);
    }

    public void setSubText(String str) {
        if (str == null) {
            this.subTextView.setVisibility(8);
            return;
        }
        this.subTextView.setVisibility(0);
        this.subTextView.setText(str);
    }

    public void cE(List<RecmForumInfo> list) {
        if (list != null) {
            this.hAt = new C0573a(list);
            this.hAs.setAdapter((ListAdapter) this.hAt);
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
        this.ebo.setImageResource(0);
    }

    public void onChangeSkinType() {
        if (isViewAttached()) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            am.setImageResource(this.ebo, R.drawable.new_pic_emotion_01);
            am.setViewTextColor(this.subTextView, R.color.cp_cont_d, 1, skinType);
            am.setBackgroundColor(this.attachedView, R.color.cp_bg_line_d);
            am.setBackgroundColor(this.mDivider, R.color.cp_bg_line_c);
            am.setViewTextColor(this.mTitleView, R.color.cp_cont_d, 1, skinType);
            am.setViewTextColor(this.hAu, R.color.cp_cont_f, 1, skinType);
            if (this.hAt != null) {
                this.hAt.notifyDataSetChanged();
            }
        }
    }

    /* renamed from: com.baidu.tieba.frs.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class C0573a extends BaseAdapter {
        private List<RecmForumInfo> hAv;

        public C0573a(List<RecmForumInfo> list) {
            this.hAv = list;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return this.hAv.size();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.widget.Adapter
        /* renamed from: vj */
        public RecmForumInfo getItem(int i) {
            return this.hAv.get(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(final int i, View view, ViewGroup viewGroup) {
            b bVar;
            if (view == null) {
                view = LayoutInflater.from(a.this.dvg.getPageActivity()).inflate(R.layout.recommend_view, (ViewGroup) null);
                b bVar2 = new b();
                bVar2.rootView = view.findViewById(R.id.root_view);
                bVar2.hAy = (TextView) view.findViewById(R.id.forum_name);
                bVar2.hAA = (TextView) view.findViewById(R.id.follow_tv);
                bVar2.hAz = (TextView) view.findViewById(R.id.thread_tv);
                bVar2.hAB = (ImageView) view.findViewById(R.id.arrow_item_img);
                bVar2.hAC = (TbImageView) view.findViewById(R.id.headview);
                bVar2.hAD = (TextView) view.findViewById(R.id.follow_title);
                bVar2.hAE = (TextView) view.findViewById(R.id.thread_title);
                bVar2.dvw = view.findViewById(R.id.divider_line);
                bVar2.hAF = (ImageView) view.findViewById(R.id.content_img);
                view.setTag(bVar2);
                bVar = bVar2;
            } else {
                bVar = (b) view.getTag();
            }
            if (getItem(i) != null) {
                bVar.hAy.setText(aq.cutChineseAndEnglishWithSuffix(getItem(i).forum_name, 14, StringHelper.STRING_MORE));
                bVar.hAC.startLoad(getItem(i).avatar, 10, false);
                bVar.hAA.setText(aq.numberUniformFormat(getItem(i).member_count.intValue()));
                bVar.hAz.setText(aq.numberUniformFormat(getItem(i).post_num.intValue()));
                bVar.rootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.a.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (!StringUtils.isNull(C0573a.this.getItem(i).forum_name)) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(a.this.dvg.getContext()).createNormalCfg(C0573a.this.getItem(i).forum_name, null)));
                        }
                    }
                });
                am.setViewTextColor(bVar.hAy, (int) R.color.cp_cont_b);
                am.setViewTextColor(bVar.hAA, (int) R.color.cp_cont_d);
                am.setViewTextColor(bVar.hAz, (int) R.color.cp_cont_d);
                am.setViewTextColor(bVar.hAE, (int) R.color.cp_cont_d);
                am.setViewTextColor(bVar.hAD, (int) R.color.cp_cont_d);
                am.setBackgroundResource(bVar.dvw, R.color.cp_bg_line_c);
                SvgManager.aOR().a(bVar.hAB, R.drawable.icon_pure_list_arrow16_right_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL);
                am.setBackgroundResource(view, R.drawable.addresslist_item_bg);
                am.setBackgroundResource(bVar.hAF, R.drawable.picture_content_frame);
            }
            return view;
        }
    }
}
