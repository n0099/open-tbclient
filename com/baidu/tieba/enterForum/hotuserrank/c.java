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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.util.ad;
import com.baidu.tieba.R;
import com.baidu.tieba.enterForum.hotuserrank.view.HotUserRankLikeButton;
import com.baidu.tieba.enterForum.hotuserrank.view.UserHeadCoverView;
import com.baidu.tieba.view.DynamicUserLikeButton;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class c {
    private PbListView ePm;
    private com.baidu.tieba.enterForum.hotuserrank.a gDc;
    private BdRecyclerView gil;
    private String mCategory;
    private long mForumId;
    private List<com.baidu.tieba.enterForum.hotuserrank.a.b> mDataList = new ArrayList();
    private BdRecyclerView.a Ui = new BdRecyclerView.a() { // from class: com.baidu.tieba.enterForum.hotuserrank.c.1
        @Override // com.baidu.adp.widget.ListView.BdRecyclerView.a
        public void a(ViewGroup viewGroup, View view, Object obj, int i, long j) {
            com.baidu.tieba.enterForum.hotuserrank.a.b bVar = (com.baidu.tieba.enterForum.hotuserrank.a.b) c.this.mDataList.get(i);
            if (bVar != null && bVar.gDx != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(c.this.gil.getContext(), bVar.gDx.getUserId(), bVar.gDx.getName_show())));
                if (!TextUtils.isEmpty(c.this.mCategory)) {
                    an anVar = new an("c13660");
                    anVar.t("uid", TbadkCoreApplication.getCurrentAccountId());
                    anVar.cI("resource_id", c.this.mCategory);
                    anVar.cI("friend_uid", bVar.rankNum);
                    TiebaStatic.log(anVar);
                    return;
                }
                an anVar2 = new an("c13668");
                anVar2.cI("uid", bVar.gDx.getUserId());
                anVar2.t("fid", c.this.mForumId);
                TiebaStatic.log(anVar2);
            }
        }
    };
    private RecyclerView.Adapter mAdapter = new RecyclerView.Adapter<a>() { // from class: com.baidu.tieba.enterForum.hotuserrank.c.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.support.v7.widget.RecyclerView.Adapter
        /* renamed from: s */
        public a onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            a aVar = new a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.hot_user_rank_item_view, (ViewGroup) null));
            aVar.sp(0);
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
        this.gil = (BdRecyclerView) view;
        this.gil.setLayoutManager(new LinearLayoutManager(view.getContext()));
        this.gil.setAdapter(this.mAdapter);
        View inflate = LayoutInflater.from(view.getContext()).inflate(R.layout.hot_user_rank_top_user, (ViewGroup) null);
        this.gDc = new com.baidu.tieba.enterForum.hotuserrank.a(inflate, this.mCategory, this.mForumId);
        inflate.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
        this.gil.addHeaderView(inflate);
        this.ePm = new PbListView(view.getContext());
        this.ePm.createView();
        this.ePm.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.ePm.setLineGone();
        this.ePm.setTextColor(am.getColor(R.color.cp_cont_j));
        this.ePm.setTextSize(R.dimen.tbfontsize33);
        this.ePm.setNoMoreTextColorId(R.color.cp_cont_e);
        this.gil.setNextPage(this.ePm);
        this.gil.setOnItemClickListener(this.Ui);
    }

    public void b(com.baidu.tieba.enterForum.hotuserrank.a.a aVar, boolean z) {
        this.gDc.a(aVar, z);
    }

    public void bY(List<com.baidu.tieba.enterForum.hotuserrank.a.b> list) {
        if (list != null) {
            this.mDataList.clear();
            this.mDataList.addAll(list);
            this.mAdapter.notifyDataSetChanged();
        }
    }

    public void setOnSrollToBottomListener(BdListView.e eVar) {
        this.gil.setOnSrollToBottomListener(eVar);
    }

    public void bmo() {
        this.ePm.setTopExtraViewGone();
        this.ePm.startLoadData();
        this.ePm.setText(this.gil.getContext().getString(R.string.list_loading));
        this.ePm.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
    }

    public void BZ(String str) {
        String string;
        this.ePm.lu(l.getDimens(this.gil.getContext(), R.dimen.tbds96));
        if (!TextUtils.isEmpty(str)) {
            string = String.format(this.gil.getContext().getString(R.string.hot_user_rank_list_no_more), str);
        } else {
            string = this.gil.getContext().getString(R.string.forum_hot_user_rank_list_no_more);
        }
        this.ePm.al(string, l.getDimens(this.gil.getContext(), R.dimen.tbds156));
        this.ePm.endLoadData();
        this.ePm.showEmptyView(l.getDimens(this.gil.getContext(), R.dimen.tbds44));
    }

    public void onChangeSkinType(int i) {
        this.gDc.onChangeSkinType(i);
        this.mAdapter.notifyDataSetChanged();
        if (this.ePm != null) {
            this.ePm.setTextColor(am.getColor(R.color.cp_cont_d));
            this.ePm.changeSkin(i);
        }
    }

    /* loaded from: classes9.dex */
    public static class a extends RecyclerView.ViewHolder {
        private com.baidu.tbadk.core.view.userLike.c agm;
        private TextView cAX;
        private TextView gDe;
        private HeadImageView gDf;
        private UserHeadCoverView gDg;
        private TextView gDh;
        private ImageView gDi;
        private TextView gDj;
        private HotUserRankLikeButton gDk;
        private int gDl;
        private String mCategory;
        private long mForumId;
        private TbPageContext mPageContext;
        private int mSkinType;

        public a(View view) {
            super(view);
            this.mSkinType = 3;
            this.mCategory = "";
            this.gDl = 0;
            this.mPageContext = eD(view.getContext());
            this.gDe = (TextView) view.findViewById(R.id.rank_num);
            this.gDe.getPaint().setFakeBoldText(true);
            this.gDf = (HeadImageView) view.findViewById(R.id.head_icon);
            this.gDf.setIsRound(true);
            this.gDf.setPlaceHolder(2);
            this.gDf.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.gDg = (UserHeadCoverView) view.findViewById(R.id.head_cover);
            this.cAX = (TextView) view.findViewById(R.id.user_name);
            this.gDh = (TextView) view.findViewById(R.id.user_intro);
            this.gDi = (ImageView) view.findViewById(R.id.grade);
            this.gDj = (TextView) view.findViewById(R.id.user_influence);
            this.gDk = (HotUserRankLikeButton) view.findViewById(R.id.like_button);
        }

        public void a(final com.baidu.tieba.enterForum.hotuserrank.a.b bVar) {
            int i;
            if (bVar != null) {
                if (!TextUtils.isEmpty(bVar.rankNum)) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gDe.getLayoutParams();
                    int dimension = (int) this.mPageContext.getResources().getDimension(R.dimen.tbds44);
                    this.gDe.setText(bVar.rankNum);
                    if (this.gDl == 1) {
                        dimension = (int) this.mPageContext.getResources().getDimension(R.dimen.tbds26);
                        layoutParams.width = (int) this.mPageContext.getResources().getDimension(R.dimen.tbds129);
                    }
                    layoutParams.setMargins(dimension, 0, 0, 0);
                    this.gDe.setLayoutParams(layoutParams);
                }
                if ("1".equals(this.gDe.getText())) {
                    i = R.color.cp_other_h;
                } else if ("2".equals(this.gDe.getText())) {
                    i = R.color.cp_other_i;
                } else if ("3".equals(this.gDe.getText())) {
                    i = R.color.cp_other_j;
                } else {
                    i = R.color.cp_cont_b;
                }
                am.setViewTextColor(this.gDe, i);
                this.gDf.startLoad(bVar.gDu, 10, false);
                this.gDg.setData(bVar);
                String str = bVar.userName;
                if (ad.getTextLengthWithEmoji(str) > 12) {
                    str = ad.subStringWithEmoji(str, 10) + StringHelper.STRING_MORE;
                }
                this.cAX.setText(str);
                if (TextUtils.isEmpty(bVar.gDv)) {
                    this.gDh.setVisibility(8);
                } else {
                    this.gDh.setVisibility(0);
                    this.gDh.setText(aq.ag(bVar.gDv, 26));
                }
                if (bVar.gDx.getLevel_id() == 0) {
                    this.gDi.setVisibility(8);
                } else {
                    this.gDi.setVisibility(0);
                    am.setImageResource(this.gDi, BitmapHelper.getGradeResourceIdInEnterForum(bVar.gDx.getLevel_id()));
                }
                if (TextUtils.isEmpty(bVar.gDw)) {
                    this.gDj.setVisibility(8);
                } else {
                    this.gDj.setVisibility(0);
                    this.gDj.setText(bVar.gDw);
                }
                if (this.agm == null && this.mPageContext != null) {
                    this.agm = new com.baidu.tbadk.core.view.userLike.c(this.mPageContext, this.gDk);
                    this.agm.j(this.mPageContext.getUniqueId());
                }
                this.agm.a(bVar.gDx);
                this.gDk.setOnClickEvent(new DynamicUserLikeButton.a() { // from class: com.baidu.tieba.enterForum.hotuserrank.c.a.1
                    @Override // com.baidu.tieba.view.DynamicUserLikeButton.a
                    public void G(View view) {
                        if (!TextUtils.isEmpty(a.this.mCategory)) {
                            an anVar = new an("c13661");
                            anVar.t("uid", TbadkCoreApplication.getCurrentAccountId());
                            anVar.cI("resource_id", a.this.mCategory);
                            anVar.cI("friend_uid", bVar.rankNum);
                            anVar.af("obj_type", bVar.gDx.getIsLike() ? 2 : 1);
                            TiebaStatic.log(anVar);
                            return;
                        }
                        an anVar2 = new an("c13672");
                        anVar2.cI("obj_id", bVar.gDx.getUserId());
                        anVar2.t("uid", TbadkCoreApplication.getCurrentAccountId());
                        anVar2.cI("resource_id", a.this.mCategory);
                        anVar2.t("fid", a.this.mForumId);
                        anVar2.cI("friend_uid", bVar.rankNum);
                        anVar2.af("obj_type", bVar.gDx.getIsLike() ? 2 : 1);
                        TiebaStatic.log(anVar2);
                    }
                });
                if (bVar.gDx != null && bVar.gDx.getUserId() != null && bVar.gDx.getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                    this.gDk.setVisibility(8);
                } else {
                    this.gDk.setVisibility(0);
                }
                onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            }
        }

        private TbPageContext eD(Context context) {
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
                am.setViewTextColor(this.cAX, (int) R.color.cp_cont_b);
                am.setViewTextColor(this.gDh, (int) R.color.cp_cont_d);
                am.setViewTextColor(this.gDj, (int) R.color.cp_cont_d);
                this.gDk.onChangeSkinType(this.mSkinType);
            }
        }

        public void setCategory(String str) {
            this.mCategory = str;
        }

        public void setForumId(long j) {
            this.mForumId = j;
        }

        public void sp(int i) {
            this.gDl = i;
        }

        public void bIR() {
            this.gDh.setVisibility(8);
            this.gDk.setVisibility(8);
        }
    }
}
