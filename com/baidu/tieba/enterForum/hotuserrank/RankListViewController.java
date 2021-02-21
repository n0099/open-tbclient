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
    private PbListView gAw;
    private a iLb;
    private BdRecyclerView iqc;
    private String mCategory;
    private long mForumId;
    private List<com.baidu.tieba.enterForum.hotuserrank.a.b> mDataList = new ArrayList();
    private BdRecyclerView.a Xb = new BdRecyclerView.a() { // from class: com.baidu.tieba.enterForum.hotuserrank.RankListViewController.1
        @Override // com.baidu.adp.widget.ListView.BdRecyclerView.a
        public void a(ViewGroup viewGroup, View view, Object obj, int i, long j) {
            com.baidu.tieba.enterForum.hotuserrank.a.b bVar = (com.baidu.tieba.enterForum.hotuserrank.a.b) RankListViewController.this.mDataList.get(i);
            if (bVar != null && bVar.iLv != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(RankListViewController.this.iqc.getContext(), bVar.iLv.getUserId(), bVar.iLv.getName_show())));
                if (!TextUtils.isEmpty(RankListViewController.this.mCategory)) {
                    ar arVar = new ar("c13660");
                    arVar.v("uid", TbadkCoreApplication.getCurrentAccountId());
                    arVar.dR("resource_id", RankListViewController.this.mCategory);
                    arVar.dR("friend_uid", bVar.rankNum);
                    TiebaStatic.log(arVar);
                    return;
                }
                ar arVar2 = new ar("c13668");
                arVar2.dR("uid", bVar.iLv.getUserId());
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
            rankListViewHolder.xJ(0);
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
        this.iqc = (BdRecyclerView) view;
        this.iqc.setLayoutManager(new LinearLayoutManager(view.getContext()));
        this.iqc.setAdapter(this.mAdapter);
        View inflate = LayoutInflater.from(view.getContext()).inflate(R.layout.hot_user_rank_top_user, (ViewGroup) null);
        this.iLb = new a(inflate, this.mCategory, this.mForumId);
        inflate.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
        this.iqc.addHeaderView(inflate);
        this.gAw = new PbListView(view.getContext());
        this.gAw.createView();
        this.gAw.setContainerBackgroundColorResId(R.color.CAM_X0205);
        this.gAw.setLineGone();
        this.gAw.setTextColor(ap.getColor(R.color.CAM_X0107));
        this.gAw.setTextSize(R.dimen.tbfontsize33);
        this.gAw.setNoMoreTextColorId(R.color.CAM_X0110);
        this.iqc.setNextPage(this.gAw);
        this.iqc.setOnItemClickListener(this.Xb);
    }

    public void b(com.baidu.tieba.enterForum.hotuserrank.a.a aVar, boolean z) {
        this.iLb.a(aVar, z);
    }

    public void cR(List<com.baidu.tieba.enterForum.hotuserrank.a.b> list) {
        if (list != null) {
            this.mDataList.clear();
            this.mDataList.addAll(list);
            this.mAdapter.notifyDataSetChanged();
        }
    }

    public void setOnSrollToBottomListener(BdListView.e eVar) {
        this.iqc.setOnSrollToBottomListener(eVar);
    }

    public void WX() {
        this.gAw.setTopExtraViewGone();
        this.gAw.startLoadData();
        this.gAw.setText(this.iqc.getContext().getString(R.string.list_loading));
        this.gAw.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
    }

    public void Jm(String str) {
        String string;
        this.gAw.pC(l.getDimens(this.iqc.getContext(), R.dimen.tbds96));
        if (!TextUtils.isEmpty(str)) {
            string = String.format(this.iqc.getContext().getString(R.string.hot_user_rank_list_no_more), str);
        } else {
            string = this.iqc.getContext().getString(R.string.forum_hot_user_rank_list_no_more);
        }
        this.gAw.av(string, l.getDimens(this.iqc.getContext(), R.dimen.tbds156));
        this.gAw.endLoadData();
        this.gAw.showEmptyView(l.getDimens(this.iqc.getContext(), R.dimen.tbds44));
    }

    public void onChangeSkinType(int i) {
        this.iLb.onChangeSkinType(i);
        this.mAdapter.notifyDataSetChanged();
        if (this.gAw != null) {
            this.gAw.setTextColor(ap.getColor(R.color.CAM_X0109));
            this.gAw.changeSkin(i);
        }
    }

    /* loaded from: classes2.dex */
    public static class RankListViewHolder extends RecyclerView.ViewHolder {
        private c akz;
        private TextView eIO;
        private TextView iLd;
        private HeadImageView iLe;
        private UserHeadCoverView iLf;
        private TextView iLg;
        private ImageView iLh;
        private TextView iLi;
        private HotUserRankLikeButton iLj;
        private int iLk;
        private boolean iLl;
        private String mCategory;
        private long mForumId;
        private TbPageContext mPageContext;
        private int mSkinType;

        public RankListViewHolder(View view) {
            super(view);
            this.mSkinType = 3;
            this.mCategory = "";
            this.iLk = 0;
            this.mPageContext = gh(view.getContext());
            this.iLd = (TextView) view.findViewById(R.id.rank_num);
            this.iLd.getPaint().setFakeBoldText(true);
            this.iLe = (HeadImageView) view.findViewById(R.id.head_icon);
            this.iLe.setIsRound(true);
            this.iLe.setPlaceHolder(1);
            this.iLe.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.iLf = (UserHeadCoverView) view.findViewById(R.id.head_cover);
            this.eIO = (TextView) view.findViewById(R.id.user_name);
            this.iLg = (TextView) view.findViewById(R.id.user_intro);
            this.iLh = (ImageView) view.findViewById(R.id.grade);
            this.iLi = (TextView) view.findViewById(R.id.user_influence);
            this.iLj = (HotUserRankLikeButton) view.findViewById(R.id.like_button);
        }

        public void a(final com.baidu.tieba.enterForum.hotuserrank.a.b bVar) {
            int i;
            if (bVar != null) {
                if (!TextUtils.isEmpty(bVar.rankNum)) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.iLd.getLayoutParams();
                    int dimension = (int) this.mPageContext.getResources().getDimension(R.dimen.tbds44);
                    this.iLd.setText(bVar.rankNum);
                    if (this.iLk == 1) {
                        dimension = (int) this.mPageContext.getResources().getDimension(R.dimen.tbds26);
                        layoutParams.width = (int) this.mPageContext.getResources().getDimension(R.dimen.tbds129);
                    }
                    layoutParams.setMargins(dimension, 0, 0, 0);
                    this.iLd.setLayoutParams(layoutParams);
                }
                int i2 = R.color.CAM_X0105;
                if ("1".equals(this.iLd.getText())) {
                    i = R.color.CAM_X0314;
                } else if ("2".equals(this.iLd.getText())) {
                    i = R.color.CAM_X0315;
                } else if ("3".equals(this.iLd.getText())) {
                    i = R.color.CAM_X0316;
                } else {
                    i = R.color.CAM_X0105;
                }
                ap.setViewTextColor(this.iLd, i);
                this.iLe.startLoad(bVar.headUrl, 10, false);
                this.iLf.setData(bVar);
                String str = bVar.userName;
                if (ag.getTextLengthWithEmoji(str) > 12) {
                    str = ag.subStringWithEmoji(str, 10) + StringHelper.STRING_MORE;
                }
                this.eIO.setText(str);
                this.iLl = bVar.iLl;
                if (bVar.iLl) {
                    ap.setViewTextColor(this.eIO, R.color.CAM_X0301);
                }
                if (TextUtils.isEmpty(bVar.iLt)) {
                    this.iLg.setVisibility(8);
                } else {
                    this.iLg.setVisibility(0);
                    this.iLg.setText(au.aq(bVar.iLt, 26));
                }
                if (bVar.iLv.getLevel_id() == 0) {
                    this.iLh.setVisibility(8);
                } else {
                    this.iLh.setVisibility(0);
                    ap.setImageResource(this.iLh, BitmapHelper.getGradeResourceIdInEnterForum(bVar.iLv.getLevel_id()));
                }
                if (TextUtils.isEmpty(bVar.iLu)) {
                    this.iLi.setVisibility(8);
                } else {
                    this.iLi.setVisibility(0);
                    this.iLi.setText(bVar.iLu);
                }
                if (this.akz == null && this.mPageContext != null) {
                    this.akz = new c(this.mPageContext, this.iLj);
                    this.akz.l(this.mPageContext.getUniqueId());
                }
                this.akz.a(bVar.iLv);
                this.iLj.setOnClickEvent(new DynamicUserLikeButton.a() { // from class: com.baidu.tieba.enterForum.hotuserrank.RankListViewController.RankListViewHolder.1
                    @Override // com.baidu.tieba.view.DynamicUserLikeButton.a
                    public void cO(View view) {
                        if (!TextUtils.isEmpty(RankListViewHolder.this.mCategory)) {
                            ar arVar = new ar("c13661");
                            arVar.v("uid", TbadkCoreApplication.getCurrentAccountId());
                            arVar.dR("resource_id", RankListViewHolder.this.mCategory);
                            arVar.dR("friend_uid", bVar.rankNum);
                            arVar.ap("obj_type", bVar.iLv.getIsLike() ? 2 : 1);
                            TiebaStatic.log(arVar);
                            return;
                        }
                        ar arVar2 = new ar("c13672");
                        arVar2.dR("obj_id", bVar.iLv.getUserId());
                        arVar2.v("uid", TbadkCoreApplication.getCurrentAccountId());
                        arVar2.dR("resource_id", RankListViewHolder.this.mCategory);
                        arVar2.v("fid", RankListViewHolder.this.mForumId);
                        arVar2.dR("friend_uid", bVar.rankNum);
                        arVar2.ap("obj_type", bVar.iLv.getIsLike() ? 2 : 1);
                        TiebaStatic.log(arVar2);
                    }
                });
                if (bVar.iLv != null && bVar.iLv.getUserId() != null && bVar.iLv.getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                    this.iLj.setVisibility(8);
                } else {
                    this.iLj.setVisibility(0);
                }
                onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            }
        }

        private TbPageContext gh(Context context) {
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
                if (!this.iLl) {
                    ap.setViewTextColor(this.eIO, R.color.CAM_X0105);
                } else {
                    ap.setViewTextColor(this.eIO, R.color.CAM_X0301);
                }
                ap.setViewTextColor(this.iLg, R.color.CAM_X0109);
                ap.setViewTextColor(this.iLi, R.color.CAM_X0109);
                this.iLj.onChangeSkinType(this.mSkinType);
            }
        }

        public void setCategory(String str) {
            this.mCategory = str;
        }

        public void setForumId(long j) {
            this.mForumId = j;
        }

        public void xJ(int i) {
            this.iLk = i;
        }

        public void cwD() {
            this.iLg.setVisibility(8);
            this.iLj.setVisibility(8);
        }
    }
}
