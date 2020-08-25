package com.baidu.tieba.enterForum.hotuserrank;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdRecyclerView;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.util.ae;
import com.baidu.tieba.R;
import com.baidu.tieba.enterForum.hotuserrank.view.HotUserRankLikeButton;
import com.baidu.tieba.enterForum.hotuserrank.view.UserHeadCoverView;
import com.baidu.tieba.view.DynamicUserLikeButton;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes16.dex */
public class c {
    private PbListView fDW;
    private BdRecyclerView hcC;
    private com.baidu.tieba.enterForum.hotuserrank.a hxl;
    private String mCategory;
    private long mForumId;
    private List<com.baidu.tieba.enterForum.hotuserrank.a.b> mDataList = new ArrayList();
    private BdRecyclerView.a Vy = new BdRecyclerView.a() { // from class: com.baidu.tieba.enterForum.hotuserrank.c.1
        @Override // com.baidu.adp.widget.ListView.BdRecyclerView.a
        public void a(ViewGroup viewGroup, View view, Object obj, int i, long j) {
            com.baidu.tieba.enterForum.hotuserrank.a.b bVar = (com.baidu.tieba.enterForum.hotuserrank.a.b) c.this.mDataList.get(i);
            if (bVar != null && bVar.hxH != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(c.this.hcC.getContext(), bVar.hxH.getUserId(), bVar.hxH.getName_show())));
                if (!TextUtils.isEmpty(c.this.mCategory)) {
                    aq aqVar = new aq("c13660");
                    aqVar.u("uid", TbadkCoreApplication.getCurrentAccountId());
                    aqVar.dD("resource_id", c.this.mCategory);
                    aqVar.dD("friend_uid", bVar.rankNum);
                    TiebaStatic.log(aqVar);
                    return;
                }
                aq aqVar2 = new aq("c13668");
                aqVar2.dD("uid", bVar.hxH.getUserId());
                aqVar2.u("fid", c.this.mForumId);
                TiebaStatic.log(aqVar2);
            }
        }
    };
    private RecyclerView.Adapter mAdapter = new RecyclerView.Adapter<a>() { // from class: com.baidu.tieba.enterForum.hotuserrank.c.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.support.v7.widget.RecyclerView.Adapter
        /* renamed from: r */
        public a onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            a aVar = new a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.hot_user_rank_item_view, (ViewGroup) null));
            aVar.we(0);
            aVar.setCategory(c.this.mCategory);
            aVar.setForumId(c.this.mForumId);
            return aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.support.v7.widget.RecyclerView.Adapter
        /* renamed from: a */
        public void onBindViewHolder(a aVar, int i) {
            aVar.a((com.baidu.tieba.enterForum.hotuserrank.a.b) c.this.mDataList.get(i));
        }

        @Override // android.support.v7.widget.RecyclerView.Adapter
        public int getItemCount() {
            return c.this.mDataList.size();
        }
    };

    public c(View view, String str, long j) {
        this.mCategory = str;
        this.mForumId = j;
        this.hcC = (BdRecyclerView) view;
        this.hcC.setLayoutManager(new LinearLayoutManager(view.getContext()));
        this.hcC.setAdapter(this.mAdapter);
        View inflate = LayoutInflater.from(view.getContext()).inflate(R.layout.hot_user_rank_top_user, (ViewGroup) null);
        this.hxl = new com.baidu.tieba.enterForum.hotuserrank.a(inflate, this.mCategory, this.mForumId);
        inflate.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
        this.hcC.addHeaderView(inflate);
        this.fDW = new PbListView(view.getContext());
        this.fDW.createView();
        this.fDW.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.fDW.setLineGone();
        this.fDW.setTextColor(ap.getColor(R.color.cp_cont_j));
        this.fDW.setTextSize(R.dimen.tbfontsize33);
        this.fDW.setNoMoreTextColorId(R.color.cp_cont_e);
        this.hcC.setNextPage(this.fDW);
        this.hcC.setOnItemClickListener(this.Vy);
    }

    public void b(com.baidu.tieba.enterForum.hotuserrank.a.a aVar, boolean z) {
        this.hxl.a(aVar, z);
    }

    public void cl(List<com.baidu.tieba.enterForum.hotuserrank.a.b> list) {
        if (list != null) {
            this.mDataList.clear();
            this.mDataList.addAll(list);
            this.mAdapter.notifyDataSetChanged();
        }
    }

    public void setOnSrollToBottomListener(BdListView.e eVar) {
        this.hcC.setOnSrollToBottomListener(eVar);
    }

    public void bGR() {
        this.fDW.setTopExtraViewGone();
        this.fDW.startLoadData();
        this.fDW.setText(this.hcC.getContext().getString(R.string.list_loading));
        this.fDW.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
    }

    public void Hw(String str) {
        String string;
        this.fDW.oN(l.getDimens(this.hcC.getContext(), R.dimen.tbds96));
        if (!TextUtils.isEmpty(str)) {
            string = String.format(this.hcC.getContext().getString(R.string.hot_user_rank_list_no_more), str);
        } else {
            string = this.hcC.getContext().getString(R.string.forum_hot_user_rank_list_no_more);
        }
        this.fDW.ao(string, l.getDimens(this.hcC.getContext(), R.dimen.tbds156));
        this.fDW.endLoadData();
        this.fDW.showEmptyView(l.getDimens(this.hcC.getContext(), R.dimen.tbds44));
    }

    public void onChangeSkinType(int i) {
        this.hxl.onChangeSkinType(i);
        this.mAdapter.notifyDataSetChanged();
        if (this.fDW != null) {
            this.fDW.setTextColor(ap.getColor(R.color.cp_cont_d));
            this.fDW.changeSkin(i);
        }
    }

    /* loaded from: classes16.dex */
    public static class a extends RecyclerView.ViewHolder {
        private com.baidu.tbadk.core.view.userLike.c ajc;
        private TextView dTQ;
        private TextView hxn;
        private HeadImageView hxo;
        private UserHeadCoverView hxp;
        private TextView hxq;
        private ImageView hxr;
        private TextView hxs;
        private HotUserRankLikeButton hxt;
        private int hxu;
        private boolean hxv;
        private String mCategory;
        private long mForumId;
        private TbPageContext mPageContext;
        private int mSkinType;

        public a(View view) {
            super(view);
            this.mSkinType = 3;
            this.mCategory = "";
            this.hxu = 0;
            this.mPageContext = eV(view.getContext());
            this.hxn = (TextView) view.findViewById(R.id.rank_num);
            this.hxn.getPaint().setFakeBoldText(true);
            this.hxo = (HeadImageView) view.findViewById(R.id.head_icon);
            this.hxo.setIsRound(true);
            this.hxo.setPlaceHolder(2);
            this.hxo.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.hxp = (UserHeadCoverView) view.findViewById(R.id.head_cover);
            this.dTQ = (TextView) view.findViewById(R.id.user_name);
            this.hxq = (TextView) view.findViewById(R.id.user_intro);
            this.hxr = (ImageView) view.findViewById(R.id.grade);
            this.hxs = (TextView) view.findViewById(R.id.user_influence);
            this.hxt = (HotUserRankLikeButton) view.findViewById(R.id.like_button);
        }

        public void a(final com.baidu.tieba.enterForum.hotuserrank.a.b bVar) {
            int i;
            if (bVar != null) {
                if (!TextUtils.isEmpty(bVar.rankNum)) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hxn.getLayoutParams();
                    int dimension = (int) this.mPageContext.getResources().getDimension(R.dimen.tbds44);
                    this.hxn.setText(bVar.rankNum);
                    if (this.hxu == 1) {
                        dimension = (int) this.mPageContext.getResources().getDimension(R.dimen.tbds26);
                        layoutParams.width = (int) this.mPageContext.getResources().getDimension(R.dimen.tbds129);
                    }
                    layoutParams.setMargins(dimension, 0, 0, 0);
                    this.hxn.setLayoutParams(layoutParams);
                }
                int i2 = R.color.cp_cont_b;
                if ("1".equals(this.hxn.getText())) {
                    i = R.color.cp_other_h;
                } else if ("2".equals(this.hxn.getText())) {
                    i = R.color.cp_other_i;
                } else if ("3".equals(this.hxn.getText())) {
                    i = R.color.cp_other_j;
                } else {
                    i = R.color.cp_cont_b;
                }
                ap.setViewTextColor(this.hxn, i);
                this.hxo.startLoad(bVar.hxE, 10, false);
                this.hxp.setData(bVar);
                String str = bVar.userName;
                if (ae.getTextLengthWithEmoji(str) > 12) {
                    str = ae.subStringWithEmoji(str, 10) + StringHelper.STRING_MORE;
                }
                this.dTQ.setText(str);
                this.hxv = bVar.hxv;
                if (bVar.hxv) {
                    ap.setViewTextColor(this.dTQ, R.color.cp_cont_h);
                }
                if (TextUtils.isEmpty(bVar.hxF)) {
                    this.hxq.setVisibility(8);
                } else {
                    this.hxq.setVisibility(0);
                    this.hxq.setText(at.aj(bVar.hxF, 26));
                }
                if (bVar.hxH.getLevel_id() == 0) {
                    this.hxr.setVisibility(8);
                } else {
                    this.hxr.setVisibility(0);
                    ap.setImageResource(this.hxr, BitmapHelper.getGradeResourceIdInEnterForum(bVar.hxH.getLevel_id()));
                }
                if (TextUtils.isEmpty(bVar.hxG)) {
                    this.hxs.setVisibility(8);
                } else {
                    this.hxs.setVisibility(0);
                    this.hxs.setText(bVar.hxG);
                }
                if (this.ajc == null && this.mPageContext != null) {
                    this.ajc = new com.baidu.tbadk.core.view.userLike.c(this.mPageContext, this.hxt);
                    this.ajc.m(this.mPageContext.getUniqueId());
                }
                this.ajc.a(bVar.hxH);
                this.hxt.setOnClickEvent(new DynamicUserLikeButton.a() { // from class: com.baidu.tieba.enterForum.hotuserrank.c.a.1
                    @Override // com.baidu.tieba.view.DynamicUserLikeButton.a
                    public void bZ(View view) {
                        if (!TextUtils.isEmpty(a.this.mCategory)) {
                            aq aqVar = new aq("c13661");
                            aqVar.u("uid", TbadkCoreApplication.getCurrentAccountId());
                            aqVar.dD("resource_id", a.this.mCategory);
                            aqVar.dD("friend_uid", bVar.rankNum);
                            aqVar.ai("obj_type", bVar.hxH.getIsLike() ? 2 : 1);
                            TiebaStatic.log(aqVar);
                            return;
                        }
                        aq aqVar2 = new aq("c13672");
                        aqVar2.dD("obj_id", bVar.hxH.getUserId());
                        aqVar2.u("uid", TbadkCoreApplication.getCurrentAccountId());
                        aqVar2.dD("resource_id", a.this.mCategory);
                        aqVar2.u("fid", a.this.mForumId);
                        aqVar2.dD("friend_uid", bVar.rankNum);
                        aqVar2.ai("obj_type", bVar.hxH.getIsLike() ? 2 : 1);
                        TiebaStatic.log(aqVar2);
                    }
                });
                if (bVar.hxH != null && bVar.hxH.getUserId() != null && bVar.hxH.getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                    this.hxt.setVisibility(8);
                } else {
                    this.hxt.setVisibility(0);
                }
                onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            }
        }

        private TbPageContext eV(Context context) {
            if (context instanceof BaseActivity) {
                return ((BaseActivity) context).getPageContext();
            }
            if (context instanceof BaseFragmentActivity) {
                return ((BaseFragmentActivity) context).getPageContext();
            }
            return null;
        }

        public void onChangeSkinType(int i) {
            if (this.mSkinType != i) {
                this.mSkinType = i;
                if (!this.hxv) {
                    ap.setViewTextColor(this.dTQ, R.color.cp_cont_b);
                } else {
                    ap.setViewTextColor(this.dTQ, R.color.cp_cont_h);
                }
                ap.setViewTextColor(this.hxq, R.color.cp_cont_d);
                ap.setViewTextColor(this.hxs, R.color.cp_cont_d);
                this.hxt.onChangeSkinType(this.mSkinType);
            }
        }

        public void setCategory(String str) {
            this.mCategory = str;
        }

        public void setForumId(long j) {
            this.mForumId = j;
        }

        public void we(int i) {
            this.hxu = i;
        }

        public void cfT() {
            this.hxq.setVisibility(8);
            this.hxt.setVisibility(8);
        }
    }
}
