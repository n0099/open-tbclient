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
    private PbListView gxy;
    private a iFe;
    private BdRecyclerView ikg;
    private String mCategory;
    private long mForumId;
    private List<com.baidu.tieba.enterForum.hotuserrank.a.b> mDataList = new ArrayList();
    private BdRecyclerView.a Xg = new BdRecyclerView.a() { // from class: com.baidu.tieba.enterForum.hotuserrank.RankListViewController.1
        @Override // com.baidu.adp.widget.ListView.BdRecyclerView.a
        public void a(ViewGroup viewGroup, View view, Object obj, int i, long j) {
            com.baidu.tieba.enterForum.hotuserrank.a.b bVar = (com.baidu.tieba.enterForum.hotuserrank.a.b) RankListViewController.this.mDataList.get(i);
            if (bVar != null && bVar.iFy != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(RankListViewController.this.ikg.getContext(), bVar.iFy.getUserId(), bVar.iFy.getName_show())));
                if (!TextUtils.isEmpty(RankListViewController.this.mCategory)) {
                    aq aqVar = new aq("c13660");
                    aqVar.w("uid", TbadkCoreApplication.getCurrentAccountId());
                    aqVar.dW("resource_id", RankListViewController.this.mCategory);
                    aqVar.dW("friend_uid", bVar.rankNum);
                    TiebaStatic.log(aqVar);
                    return;
                }
                aq aqVar2 = new aq("c13668");
                aqVar2.dW("uid", bVar.iFy.getUserId());
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
            rankListViewHolder.xz(0);
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
        this.ikg = (BdRecyclerView) view;
        this.ikg.setLayoutManager(new LinearLayoutManager(view.getContext()));
        this.ikg.setAdapter(this.mAdapter);
        View inflate = LayoutInflater.from(view.getContext()).inflate(R.layout.hot_user_rank_top_user, (ViewGroup) null);
        this.iFe = new a(inflate, this.mCategory, this.mForumId);
        inflate.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
        this.ikg.addHeaderView(inflate);
        this.gxy = new PbListView(view.getContext());
        this.gxy.createView();
        this.gxy.setContainerBackgroundColorResId(R.color.CAM_X0205);
        this.gxy.setLineGone();
        this.gxy.setTextColor(ao.getColor(R.color.CAM_X0107));
        this.gxy.setTextSize(R.dimen.tbfontsize33);
        this.gxy.setNoMoreTextColorId(R.color.CAM_X0110);
        this.ikg.setNextPage(this.gxy);
        this.ikg.setOnItemClickListener(this.Xg);
    }

    public void b(com.baidu.tieba.enterForum.hotuserrank.a.a aVar, boolean z) {
        this.iFe.a(aVar, z);
    }

    public void cW(List<com.baidu.tieba.enterForum.hotuserrank.a.b> list) {
        if (list != null) {
            this.mDataList.clear();
            this.mDataList.addAll(list);
            this.mAdapter.notifyDataSetChanged();
        }
    }

    public void setOnSrollToBottomListener(BdListView.e eVar) {
        this.ikg.setOnSrollToBottomListener(eVar);
    }

    public void Vo() {
        this.gxy.setTopExtraViewGone();
        this.gxy.startLoadData();
        this.gxy.setText(this.ikg.getContext().getString(R.string.list_loading));
        this.gxy.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
    }

    public void IA(String str) {
        String string;
        this.gxy.px(l.getDimens(this.ikg.getContext(), R.dimen.tbds96));
        if (!TextUtils.isEmpty(str)) {
            string = String.format(this.ikg.getContext().getString(R.string.hot_user_rank_list_no_more), str);
        } else {
            string = this.ikg.getContext().getString(R.string.forum_hot_user_rank_list_no_more);
        }
        this.gxy.at(string, l.getDimens(this.ikg.getContext(), R.dimen.tbds156));
        this.gxy.endLoadData();
        this.gxy.showEmptyView(l.getDimens(this.ikg.getContext(), R.dimen.tbds44));
    }

    public void onChangeSkinType(int i) {
        this.iFe.onChangeSkinType(i);
        this.mAdapter.notifyDataSetChanged();
        if (this.gxy != null) {
            this.gxy.setTextColor(ao.getColor(R.color.CAM_X0109));
            this.gxy.changeSkin(i);
        }
    }

    /* loaded from: classes2.dex */
    public static class RankListViewHolder extends RecyclerView.ViewHolder {
        private c akK;
        private TextView eGI;
        private TextView iFg;
        private HeadImageView iFh;
        private UserHeadCoverView iFi;
        private TextView iFj;
        private ImageView iFk;
        private TextView iFl;
        private HotUserRankLikeButton iFm;
        private int iFn;
        private boolean iFo;
        private String mCategory;
        private long mForumId;
        private TbPageContext mPageContext;
        private int mSkinType;

        public RankListViewHolder(View view) {
            super(view);
            this.mSkinType = 3;
            this.mCategory = "";
            this.iFn = 0;
            this.mPageContext = gg(view.getContext());
            this.iFg = (TextView) view.findViewById(R.id.rank_num);
            this.iFg.getPaint().setFakeBoldText(true);
            this.iFh = (HeadImageView) view.findViewById(R.id.head_icon);
            this.iFh.setIsRound(true);
            this.iFh.setPlaceHolder(1);
            this.iFh.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.iFi = (UserHeadCoverView) view.findViewById(R.id.head_cover);
            this.eGI = (TextView) view.findViewById(R.id.user_name);
            this.iFj = (TextView) view.findViewById(R.id.user_intro);
            this.iFk = (ImageView) view.findViewById(R.id.grade);
            this.iFl = (TextView) view.findViewById(R.id.user_influence);
            this.iFm = (HotUserRankLikeButton) view.findViewById(R.id.like_button);
        }

        public void a(final com.baidu.tieba.enterForum.hotuserrank.a.b bVar) {
            int i;
            if (bVar != null) {
                if (!TextUtils.isEmpty(bVar.rankNum)) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.iFg.getLayoutParams();
                    int dimension = (int) this.mPageContext.getResources().getDimension(R.dimen.tbds44);
                    this.iFg.setText(bVar.rankNum);
                    if (this.iFn == 1) {
                        dimension = (int) this.mPageContext.getResources().getDimension(R.dimen.tbds26);
                        layoutParams.width = (int) this.mPageContext.getResources().getDimension(R.dimen.tbds129);
                    }
                    layoutParams.setMargins(dimension, 0, 0, 0);
                    this.iFg.setLayoutParams(layoutParams);
                }
                int i2 = R.color.CAM_X0105;
                if ("1".equals(this.iFg.getText())) {
                    i = R.color.CAM_X0314;
                } else if ("2".equals(this.iFg.getText())) {
                    i = R.color.CAM_X0315;
                } else if ("3".equals(this.iFg.getText())) {
                    i = R.color.CAM_X0316;
                } else {
                    i = R.color.CAM_X0105;
                }
                ao.setViewTextColor(this.iFg, i);
                this.iFh.startLoad(bVar.headUrl, 10, false);
                this.iFi.setData(bVar);
                String str = bVar.userName;
                if (ad.getTextLengthWithEmoji(str) > 12) {
                    str = ad.subStringWithEmoji(str, 10) + StringHelper.STRING_MORE;
                }
                this.eGI.setText(str);
                this.iFo = bVar.iFo;
                if (bVar.iFo) {
                    ao.setViewTextColor(this.eGI, R.color.CAM_X0301);
                }
                if (TextUtils.isEmpty(bVar.iFw)) {
                    this.iFj.setVisibility(8);
                } else {
                    this.iFj.setVisibility(0);
                    this.iFj.setText(at.ao(bVar.iFw, 26));
                }
                if (bVar.iFy.getLevel_id() == 0) {
                    this.iFk.setVisibility(8);
                } else {
                    this.iFk.setVisibility(0);
                    ao.setImageResource(this.iFk, BitmapHelper.getGradeResourceIdInEnterForum(bVar.iFy.getLevel_id()));
                }
                if (TextUtils.isEmpty(bVar.iFx)) {
                    this.iFl.setVisibility(8);
                } else {
                    this.iFl.setVisibility(0);
                    this.iFl.setText(bVar.iFx);
                }
                if (this.akK == null && this.mPageContext != null) {
                    this.akK = new c(this.mPageContext, this.iFm);
                    this.akK.l(this.mPageContext.getUniqueId());
                }
                this.akK.a(bVar.iFy);
                this.iFm.setOnClickEvent(new DynamicUserLikeButton.a() { // from class: com.baidu.tieba.enterForum.hotuserrank.RankListViewController.RankListViewHolder.1
                    @Override // com.baidu.tieba.view.DynamicUserLikeButton.a
                    public void cQ(View view) {
                        if (!TextUtils.isEmpty(RankListViewHolder.this.mCategory)) {
                            aq aqVar = new aq("c13661");
                            aqVar.w("uid", TbadkCoreApplication.getCurrentAccountId());
                            aqVar.dW("resource_id", RankListViewHolder.this.mCategory);
                            aqVar.dW("friend_uid", bVar.rankNum);
                            aqVar.an("obj_type", bVar.iFy.getIsLike() ? 2 : 1);
                            TiebaStatic.log(aqVar);
                            return;
                        }
                        aq aqVar2 = new aq("c13672");
                        aqVar2.dW("obj_id", bVar.iFy.getUserId());
                        aqVar2.w("uid", TbadkCoreApplication.getCurrentAccountId());
                        aqVar2.dW("resource_id", RankListViewHolder.this.mCategory);
                        aqVar2.w("fid", RankListViewHolder.this.mForumId);
                        aqVar2.dW("friend_uid", bVar.rankNum);
                        aqVar2.an("obj_type", bVar.iFy.getIsLike() ? 2 : 1);
                        TiebaStatic.log(aqVar2);
                    }
                });
                if (bVar.iFy != null && bVar.iFy.getUserId() != null && bVar.iFy.getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                    this.iFm.setVisibility(8);
                } else {
                    this.iFm.setVisibility(0);
                }
                onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            }
        }

        private TbPageContext gg(Context context) {
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
                if (!this.iFo) {
                    ao.setViewTextColor(this.eGI, R.color.CAM_X0105);
                } else {
                    ao.setViewTextColor(this.eGI, R.color.CAM_X0301);
                }
                ao.setViewTextColor(this.iFj, R.color.CAM_X0109);
                ao.setViewTextColor(this.iFl, R.color.CAM_X0109);
                this.iFm.onChangeSkinType(this.mSkinType);
            }
        }

        public void setCategory(String str) {
            this.mCategory = str;
        }

        public void setForumId(long j) {
            this.mForumId = j;
        }

        public void xz(int i) {
            this.iFn = i;
        }

        public void cvk() {
            this.iFj.setVisibility(8);
            this.iFm.setVisibility(8);
        }
    }
}
