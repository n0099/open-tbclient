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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.userLike.c;
import com.baidu.tbadk.util.ag;
import com.baidu.tieba.R;
import com.baidu.tieba.enterForum.hotuserrank.view.HotUserRankLikeButton;
import com.baidu.tieba.enterForum.hotuserrank.view.UserHeadCoverView;
import com.baidu.tieba.view.DynamicUserLikeButton;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class RankListViewController {
    private PbListView gCf;
    private a iMK;
    private BdRecyclerView irL;
    private String mCategory;
    private long mForumId;
    private List<com.baidu.tieba.enterForum.hotuserrank.a.b> mDataList = new ArrayList();
    private BdRecyclerView.a Yv = new BdRecyclerView.a() { // from class: com.baidu.tieba.enterForum.hotuserrank.RankListViewController.1
        @Override // com.baidu.adp.widget.ListView.BdRecyclerView.a
        public void a(ViewGroup viewGroup, View view, Object obj, int i, long j) {
            com.baidu.tieba.enterForum.hotuserrank.a.b bVar = (com.baidu.tieba.enterForum.hotuserrank.a.b) RankListViewController.this.mDataList.get(i);
            if (bVar != null && bVar.iNe != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(RankListViewController.this.irL.getContext(), bVar.iNe.getUserId(), bVar.iNe.getName_show())));
                if (!TextUtils.isEmpty(RankListViewController.this.mCategory)) {
                    ar arVar = new ar("c13660");
                    arVar.v("uid", TbadkCoreApplication.getCurrentAccountId());
                    arVar.dR("resource_id", RankListViewController.this.mCategory);
                    arVar.dR("friend_uid", bVar.rankNum);
                    TiebaStatic.log(arVar);
                    return;
                }
                ar arVar2 = new ar("c13668");
                arVar2.dR("uid", bVar.iNe.getUserId());
                arVar2.v("fid", RankListViewController.this.mForumId);
                TiebaStatic.log(arVar2);
            }
        }
    };
    private RecyclerView.Adapter mAdapter = new RecyclerView.Adapter<RankListViewHolder>() { // from class: com.baidu.tieba.enterForum.hotuserrank.RankListViewController.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: A */
        public RankListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            RankListViewHolder rankListViewHolder = new RankListViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.hot_user_rank_item_view, (ViewGroup) null));
            rankListViewHolder.xK(0);
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
        this.irL = (BdRecyclerView) view;
        this.irL.setLayoutManager(new LinearLayoutManager(view.getContext()));
        this.irL.setAdapter(this.mAdapter);
        View inflate = LayoutInflater.from(view.getContext()).inflate(R.layout.hot_user_rank_top_user, (ViewGroup) null);
        this.iMK = new a(inflate, this.mCategory, this.mForumId);
        inflate.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
        this.irL.addHeaderView(inflate);
        this.gCf = new PbListView(view.getContext());
        this.gCf.createView();
        this.gCf.setContainerBackgroundColorResId(R.color.CAM_X0205);
        this.gCf.setLineGone();
        this.gCf.setTextColor(ap.getColor(R.color.CAM_X0107));
        this.gCf.setTextSize(R.dimen.tbfontsize33);
        this.gCf.setNoMoreTextColorId(R.color.CAM_X0110);
        this.irL.setNextPage(this.gCf);
        this.irL.setOnItemClickListener(this.Yv);
    }

    public void b(com.baidu.tieba.enterForum.hotuserrank.a.a aVar, boolean z) {
        this.iMK.a(aVar, z);
    }

    public void cR(List<com.baidu.tieba.enterForum.hotuserrank.a.b> list) {
        if (list != null) {
            this.mDataList.clear();
            this.mDataList.addAll(list);
            this.mAdapter.notifyDataSetChanged();
        }
    }

    public void setOnSrollToBottomListener(BdListView.e eVar) {
        this.irL.setOnSrollToBottomListener(eVar);
    }

    public void Xa() {
        this.gCf.setTopExtraViewGone();
        this.gCf.startLoadData();
        this.gCf.setText(this.irL.getContext().getString(R.string.list_loading));
        this.gCf.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
    }

    public void Jv(String str) {
        String string;
        this.gCf.pD(l.getDimens(this.irL.getContext(), R.dimen.tbds96));
        if (!TextUtils.isEmpty(str)) {
            string = String.format(this.irL.getContext().getString(R.string.hot_user_rank_list_no_more), str);
        } else {
            string = this.irL.getContext().getString(R.string.forum_hot_user_rank_list_no_more);
        }
        this.gCf.setText(string, l.getDimens(this.irL.getContext(), R.dimen.tbds156));
        this.gCf.endLoadData();
        this.gCf.showEmptyView(l.getDimens(this.irL.getContext(), R.dimen.tbds44));
    }

    public void onChangeSkinType(int i) {
        this.iMK.onChangeSkinType(i);
        this.mAdapter.notifyDataSetChanged();
        if (this.gCf != null) {
            this.gCf.setTextColor(ap.getColor(R.color.CAM_X0109));
            this.gCf.changeSkin(i);
        }
    }

    /* loaded from: classes2.dex */
    public static class RankListViewHolder extends RecyclerView.ViewHolder {
        private c alS;
        private TextView eKp;
        private TextView iMM;
        private HeadImageView iMN;
        private UserHeadCoverView iMO;
        private TextView iMP;
        private ImageView iMQ;
        private TextView iMR;
        private HotUserRankLikeButton iMS;
        private int iMT;
        private boolean iMU;
        private String mCategory;
        private long mForumId;
        private TbPageContext mPageContext;
        private int mSkinType;

        public RankListViewHolder(View view) {
            super(view);
            this.mSkinType = 3;
            this.mCategory = "";
            this.iMT = 0;
            this.mPageContext = gg(view.getContext());
            this.iMM = (TextView) view.findViewById(R.id.rank_num);
            this.iMM.getPaint().setFakeBoldText(true);
            this.iMN = (HeadImageView) view.findViewById(R.id.head_icon);
            this.iMN.setIsRound(true);
            this.iMN.setPlaceHolder(1);
            this.iMN.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.iMO = (UserHeadCoverView) view.findViewById(R.id.head_cover);
            this.eKp = (TextView) view.findViewById(R.id.user_name);
            this.iMP = (TextView) view.findViewById(R.id.user_intro);
            this.iMQ = (ImageView) view.findViewById(R.id.grade);
            this.iMR = (TextView) view.findViewById(R.id.user_influence);
            this.iMS = (HotUserRankLikeButton) view.findViewById(R.id.like_button);
        }

        public void a(final com.baidu.tieba.enterForum.hotuserrank.a.b bVar) {
            int i;
            if (bVar != null) {
                if (!TextUtils.isEmpty(bVar.rankNum)) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.iMM.getLayoutParams();
                    int dimension = (int) this.mPageContext.getResources().getDimension(R.dimen.tbds44);
                    this.iMM.setText(bVar.rankNum);
                    if (this.iMT == 1) {
                        dimension = (int) this.mPageContext.getResources().getDimension(R.dimen.tbds26);
                        layoutParams.width = (int) this.mPageContext.getResources().getDimension(R.dimen.tbds129);
                    }
                    layoutParams.setMargins(dimension, 0, 0, 0);
                    this.iMM.setLayoutParams(layoutParams);
                }
                int i2 = R.color.CAM_X0105;
                if ("1".equals(this.iMM.getText())) {
                    i = R.color.CAM_X0314;
                } else if ("2".equals(this.iMM.getText())) {
                    i = R.color.CAM_X0315;
                } else if ("3".equals(this.iMM.getText())) {
                    i = R.color.CAM_X0316;
                } else {
                    i = R.color.CAM_X0105;
                }
                ap.setViewTextColor(this.iMM, i);
                this.iMN.startLoad(bVar.headUrl, 10, false);
                this.iMO.setData(bVar);
                String str = bVar.userName;
                if (ag.getTextLengthWithEmoji(str) > 12) {
                    str = ag.subStringWithEmoji(str, 10) + StringHelper.STRING_MORE;
                }
                this.eKp.setText(str);
                this.iMU = bVar.iMU;
                if (bVar.iMU) {
                    ap.setViewTextColor(this.eKp, R.color.CAM_X0301);
                }
                if (TextUtils.isEmpty(bVar.iNc)) {
                    this.iMP.setVisibility(8);
                } else {
                    this.iMP.setVisibility(0);
                    this.iMP.setText(au.ar(bVar.iNc, 26));
                }
                if (bVar.iNe.getLevel_id() == 0) {
                    this.iMQ.setVisibility(8);
                } else {
                    this.iMQ.setVisibility(0);
                    ap.setImageResource(this.iMQ, BitmapHelper.getGradeResourceIdInEnterForum(bVar.iNe.getLevel_id()));
                }
                if (TextUtils.isEmpty(bVar.iNd)) {
                    this.iMR.setVisibility(8);
                } else {
                    this.iMR.setVisibility(0);
                    this.iMR.setText(bVar.iNd);
                }
                if (this.alS == null && this.mPageContext != null) {
                    this.alS = new c(this.mPageContext, this.iMS);
                    this.alS.l(this.mPageContext.getUniqueId());
                }
                this.alS.a(bVar.iNe);
                this.iMS.setOnClickEvent(new DynamicUserLikeButton.a() { // from class: com.baidu.tieba.enterForum.hotuserrank.RankListViewController.RankListViewHolder.1
                    @Override // com.baidu.tieba.view.DynamicUserLikeButton.a
                    public void cO(View view) {
                        if (!TextUtils.isEmpty(RankListViewHolder.this.mCategory)) {
                            ar arVar = new ar("c13661");
                            arVar.v("uid", TbadkCoreApplication.getCurrentAccountId());
                            arVar.dR("resource_id", RankListViewHolder.this.mCategory);
                            arVar.dR("friend_uid", bVar.rankNum);
                            arVar.aq("obj_type", bVar.iNe.getIsLike() ? 2 : 1);
                            TiebaStatic.log(arVar);
                            return;
                        }
                        ar arVar2 = new ar("c13672");
                        arVar2.dR("obj_id", bVar.iNe.getUserId());
                        arVar2.v("uid", TbadkCoreApplication.getCurrentAccountId());
                        arVar2.dR("resource_id", RankListViewHolder.this.mCategory);
                        arVar2.v("fid", RankListViewHolder.this.mForumId);
                        arVar2.dR("friend_uid", bVar.rankNum);
                        arVar2.aq("obj_type", bVar.iNe.getIsLike() ? 2 : 1);
                        TiebaStatic.log(arVar2);
                    }
                });
                if (bVar.iNe != null && bVar.iNe.getUserId() != null && bVar.iNe.getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                    this.iMS.setVisibility(8);
                } else {
                    this.iMS.setVisibility(0);
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
                if (!this.iMU) {
                    ap.setViewTextColor(this.eKp, R.color.CAM_X0105);
                } else {
                    ap.setViewTextColor(this.eKp, R.color.CAM_X0301);
                }
                ap.setViewTextColor(this.iMP, R.color.CAM_X0109);
                ap.setViewTextColor(this.iMR, R.color.CAM_X0109);
                this.iMS.onChangeSkinType(this.mSkinType);
            }
        }

        public void setCategory(String str) {
            this.mCategory = str;
        }

        public void setForumId(long j) {
            this.mForumId = j;
        }

        public void xK(int i) {
            this.iMT = i;
        }

        public void cwJ() {
            this.iMP.setVisibility(8);
            this.iMS.setVisibility(8);
        }
    }
}
