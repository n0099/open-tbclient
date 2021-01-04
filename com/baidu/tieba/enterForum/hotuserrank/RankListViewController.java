package com.baidu.tieba.enterForum.hotuserrank;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.userLike.c;
import com.baidu.tbadk.util.ad;
import com.baidu.tieba.R;
import com.baidu.tieba.enterForum.hotuserrank.view.HotUserRankLikeButton;
import com.baidu.tieba.enterForum.hotuserrank.view.UserHeadCoverView;
import com.baidu.tieba.view.DynamicUserLikeButton;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class RankListViewController {
    private PbListView gCf;
    private a iJL;
    private BdRecyclerView ioP;
    private String mCategory;
    private long mForumId;
    private List<com.baidu.tieba.enterForum.hotuserrank.a.b> mDataList = new ArrayList();
    private BdRecyclerView.a Xi = new BdRecyclerView.a() { // from class: com.baidu.tieba.enterForum.hotuserrank.RankListViewController.1
        @Override // com.baidu.adp.widget.ListView.BdRecyclerView.a
        public void a(ViewGroup viewGroup, View view, Object obj, int i, long j) {
            com.baidu.tieba.enterForum.hotuserrank.a.b bVar = (com.baidu.tieba.enterForum.hotuserrank.a.b) RankListViewController.this.mDataList.get(i);
            if (bVar != null && bVar.iKf != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(RankListViewController.this.ioP.getContext(), bVar.iKf.getUserId(), bVar.iKf.getName_show())));
                if (!TextUtils.isEmpty(RankListViewController.this.mCategory)) {
                    aq aqVar = new aq("c13660");
                    aqVar.w("uid", TbadkCoreApplication.getCurrentAccountId());
                    aqVar.dX("resource_id", RankListViewController.this.mCategory);
                    aqVar.dX("friend_uid", bVar.rankNum);
                    TiebaStatic.log(aqVar);
                    return;
                }
                aq aqVar2 = new aq("c13668");
                aqVar2.dX("uid", bVar.iKf.getUserId());
                aqVar2.w("fid", RankListViewController.this.mForumId);
                TiebaStatic.log(aqVar2);
            }
        }
    };
    private RecyclerView.Adapter mAdapter = new RecyclerView.Adapter<RankListViewHolder>() { // from class: com.baidu.tieba.enterForum.hotuserrank.RankListViewController.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: z */
        public RankListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            RankListViewHolder rankListViewHolder = new RankListViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.hot_user_rank_item_view, (ViewGroup) null));
            rankListViewHolder.zf(0);
            rankListViewHolder.setCategory(RankListViewController.this.mCategory);
            rankListViewHolder.setForumId(RankListViewController.this.mForumId);
            return rankListViewHolder;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: a */
        public void onBindViewHolder(RankListViewHolder rankListViewHolder, int i) {
            rankListViewHolder.a((com.baidu.tieba.enterForum.hotuserrank.a.b) RankListViewController.this.mDataList.get(i));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return RankListViewController.this.mDataList.size();
        }
    };

    public RankListViewController(View view, String str, long j) {
        this.mCategory = str;
        this.mForumId = j;
        this.ioP = (BdRecyclerView) view;
        this.ioP.setLayoutManager(new LinearLayoutManager(view.getContext()));
        this.ioP.setAdapter(this.mAdapter);
        View inflate = LayoutInflater.from(view.getContext()).inflate(R.layout.hot_user_rank_top_user, (ViewGroup) null);
        this.iJL = new a(inflate, this.mCategory, this.mForumId);
        inflate.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
        this.ioP.addHeaderView(inflate);
        this.gCf = new PbListView(view.getContext());
        this.gCf.createView();
        this.gCf.setContainerBackgroundColorResId(R.color.CAM_X0205);
        this.gCf.setLineGone();
        this.gCf.setTextColor(ao.getColor(R.color.CAM_X0107));
        this.gCf.setTextSize(R.dimen.tbfontsize33);
        this.gCf.setNoMoreTextColorId(R.color.CAM_X0110);
        this.ioP.setNextPage(this.gCf);
        this.ioP.setOnItemClickListener(this.Xi);
    }

    public void b(com.baidu.tieba.enterForum.hotuserrank.a.a aVar, boolean z) {
        this.iJL.a(aVar, z);
    }

    public void cW(List<com.baidu.tieba.enterForum.hotuserrank.a.b> list) {
        if (list != null) {
            this.mDataList.clear();
            this.mDataList.addAll(list);
            this.mAdapter.notifyDataSetChanged();
        }
    }

    public void setOnSrollToBottomListener(BdListView.e eVar) {
        this.ioP.setOnSrollToBottomListener(eVar);
    }

    public void Zg() {
        this.gCf.setTopExtraViewGone();
        this.gCf.startLoadData();
        this.gCf.setText(this.ioP.getContext().getString(R.string.list_loading));
        this.gCf.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
    }

    public void JM(String str) {
        String string;
        this.gCf.rd(l.getDimens(this.ioP.getContext(), R.dimen.tbds96));
        if (!TextUtils.isEmpty(str)) {
            string = String.format(this.ioP.getContext().getString(R.string.hot_user_rank_list_no_more), str);
        } else {
            string = this.ioP.getContext().getString(R.string.forum_hot_user_rank_list_no_more);
        }
        this.gCf.at(string, l.getDimens(this.ioP.getContext(), R.dimen.tbds156));
        this.gCf.endLoadData();
        this.gCf.showEmptyView(l.getDimens(this.ioP.getContext(), R.dimen.tbds44));
    }

    public void onChangeSkinType(int i) {
        this.iJL.onChangeSkinType(i);
        this.mAdapter.notifyDataSetChanged();
        if (this.gCf != null) {
            this.gCf.setTextColor(ao.getColor(R.color.CAM_X0109));
            this.gCf.changeSkin(i);
        }
    }

    /* loaded from: classes2.dex */
    public static class RankListViewHolder extends RecyclerView.ViewHolder {
        private c alC;
        private TextView eLt;
        private TextView iJN;
        private HeadImageView iJO;
        private UserHeadCoverView iJP;
        private TextView iJQ;
        private ImageView iJR;
        private TextView iJS;
        private HotUserRankLikeButton iJT;
        private int iJU;
        private boolean iJV;
        private String mCategory;
        private long mForumId;
        private TbPageContext mPageContext;
        private int mSkinType;

        public RankListViewHolder(View view) {
            super(view);
            this.mSkinType = 3;
            this.mCategory = "";
            this.iJU = 0;
            this.mPageContext = gi(view.getContext());
            this.iJN = (TextView) view.findViewById(R.id.rank_num);
            this.iJN.getPaint().setFakeBoldText(true);
            this.iJO = (HeadImageView) view.findViewById(R.id.head_icon);
            this.iJO.setIsRound(true);
            this.iJO.setPlaceHolder(1);
            this.iJO.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.iJP = (UserHeadCoverView) view.findViewById(R.id.head_cover);
            this.eLt = (TextView) view.findViewById(R.id.user_name);
            this.iJQ = (TextView) view.findViewById(R.id.user_intro);
            this.iJR = (ImageView) view.findViewById(R.id.grade);
            this.iJS = (TextView) view.findViewById(R.id.user_influence);
            this.iJT = (HotUserRankLikeButton) view.findViewById(R.id.like_button);
        }

        public void a(final com.baidu.tieba.enterForum.hotuserrank.a.b bVar) {
            int i;
            if (bVar != null) {
                if (!TextUtils.isEmpty(bVar.rankNum)) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.iJN.getLayoutParams();
                    int dimension = (int) this.mPageContext.getResources().getDimension(R.dimen.tbds44);
                    this.iJN.setText(bVar.rankNum);
                    if (this.iJU == 1) {
                        dimension = (int) this.mPageContext.getResources().getDimension(R.dimen.tbds26);
                        layoutParams.width = (int) this.mPageContext.getResources().getDimension(R.dimen.tbds129);
                    }
                    layoutParams.setMargins(dimension, 0, 0, 0);
                    this.iJN.setLayoutParams(layoutParams);
                }
                int i2 = R.color.CAM_X0105;
                if ("1".equals(this.iJN.getText())) {
                    i = R.color.CAM_X0314;
                } else if ("2".equals(this.iJN.getText())) {
                    i = R.color.CAM_X0315;
                } else if ("3".equals(this.iJN.getText())) {
                    i = R.color.CAM_X0316;
                } else {
                    i = R.color.CAM_X0105;
                }
                ao.setViewTextColor(this.iJN, i);
                this.iJO.startLoad(bVar.headUrl, 10, false);
                this.iJP.setData(bVar);
                String str = bVar.userName;
                if (ad.getTextLengthWithEmoji(str) > 12) {
                    str = ad.subStringWithEmoji(str, 10) + StringHelper.STRING_MORE;
                }
                this.eLt.setText(str);
                this.iJV = bVar.iJV;
                if (bVar.iJV) {
                    ao.setViewTextColor(this.eLt, R.color.CAM_X0301);
                }
                if (TextUtils.isEmpty(bVar.iKd)) {
                    this.iJQ.setVisibility(8);
                } else {
                    this.iJQ.setVisibility(0);
                    this.iJQ.setText(at.ao(bVar.iKd, 26));
                }
                if (bVar.iKf.getLevel_id() == 0) {
                    this.iJR.setVisibility(8);
                } else {
                    this.iJR.setVisibility(0);
                    ao.setImageResource(this.iJR, BitmapHelper.getGradeResourceIdInEnterForum(bVar.iKf.getLevel_id()));
                }
                if (TextUtils.isEmpty(bVar.iKe)) {
                    this.iJS.setVisibility(8);
                } else {
                    this.iJS.setVisibility(0);
                    this.iJS.setText(bVar.iKe);
                }
                if (this.alC == null && this.mPageContext != null) {
                    this.alC = new c(this.mPageContext, this.iJT);
                    this.alC.l(this.mPageContext.getUniqueId());
                }
                this.alC.a(bVar.iKf);
                this.iJT.setOnClickEvent(new DynamicUserLikeButton.a() { // from class: com.baidu.tieba.enterForum.hotuserrank.RankListViewController.RankListViewHolder.1
                    @Override // com.baidu.tieba.view.DynamicUserLikeButton.a
                    public void cQ(View view) {
                        if (!TextUtils.isEmpty(RankListViewHolder.this.mCategory)) {
                            aq aqVar = new aq("c13661");
                            aqVar.w("uid", TbadkCoreApplication.getCurrentAccountId());
                            aqVar.dX("resource_id", RankListViewHolder.this.mCategory);
                            aqVar.dX("friend_uid", bVar.rankNum);
                            aqVar.an("obj_type", bVar.iKf.getIsLike() ? 2 : 1);
                            TiebaStatic.log(aqVar);
                            return;
                        }
                        aq aqVar2 = new aq("c13672");
                        aqVar2.dX("obj_id", bVar.iKf.getUserId());
                        aqVar2.w("uid", TbadkCoreApplication.getCurrentAccountId());
                        aqVar2.dX("resource_id", RankListViewHolder.this.mCategory);
                        aqVar2.w("fid", RankListViewHolder.this.mForumId);
                        aqVar2.dX("friend_uid", bVar.rankNum);
                        aqVar2.an("obj_type", bVar.iKf.getIsLike() ? 2 : 1);
                        TiebaStatic.log(aqVar2);
                    }
                });
                if (bVar.iKf != null && bVar.iKf.getUserId() != null && bVar.iKf.getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                    this.iJT.setVisibility(8);
                } else {
                    this.iJT.setVisibility(0);
                }
                onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            }
        }

        private TbPageContext gi(Context context) {
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
                if (!this.iJV) {
                    ao.setViewTextColor(this.eLt, R.color.CAM_X0105);
                } else {
                    ao.setViewTextColor(this.eLt, R.color.CAM_X0301);
                }
                ao.setViewTextColor(this.iJQ, R.color.CAM_X0109);
                ao.setViewTextColor(this.iJS, R.color.CAM_X0109);
                this.iJT.onChangeSkinType(this.mSkinType);
            }
        }

        public void setCategory(String str) {
            this.mCategory = str;
        }

        public void setForumId(long j) {
            this.mForumId = j;
        }

        public void zf(int i) {
            this.iJU = i;
        }

        public void czb() {
            this.iJQ.setVisibility(8);
            this.iJT.setVisibility(8);
        }
    }
}
