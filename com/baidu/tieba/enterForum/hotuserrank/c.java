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
    private PbListView ePr;
    private com.baidu.tieba.enterForum.hotuserrank.a gDi;
    private BdRecyclerView gir;
    private String mCategory;
    private long mForumId;
    private List<com.baidu.tieba.enterForum.hotuserrank.a.b> mDataList = new ArrayList();
    private BdRecyclerView.a Ul = new BdRecyclerView.a() { // from class: com.baidu.tieba.enterForum.hotuserrank.c.1
        @Override // com.baidu.adp.widget.ListView.BdRecyclerView.a
        public void a(ViewGroup viewGroup, View view, Object obj, int i, long j) {
            com.baidu.tieba.enterForum.hotuserrank.a.b bVar = (com.baidu.tieba.enterForum.hotuserrank.a.b) c.this.mDataList.get(i);
            if (bVar != null && bVar.gDD != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(c.this.gir.getContext(), bVar.gDD.getUserId(), bVar.gDD.getName_show())));
                if (!TextUtils.isEmpty(c.this.mCategory)) {
                    an anVar = new an("c13660");
                    anVar.t("uid", TbadkCoreApplication.getCurrentAccountId());
                    anVar.cI("resource_id", c.this.mCategory);
                    anVar.cI("friend_uid", bVar.rankNum);
                    TiebaStatic.log(anVar);
                    return;
                }
                an anVar2 = new an("c13668");
                anVar2.cI("uid", bVar.gDD.getUserId());
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
        this.gir = (BdRecyclerView) view;
        this.gir.setLayoutManager(new LinearLayoutManager(view.getContext()));
        this.gir.setAdapter(this.mAdapter);
        View inflate = LayoutInflater.from(view.getContext()).inflate(R.layout.hot_user_rank_top_user, (ViewGroup) null);
        this.gDi = new com.baidu.tieba.enterForum.hotuserrank.a(inflate, this.mCategory, this.mForumId);
        inflate.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
        this.gir.addHeaderView(inflate);
        this.ePr = new PbListView(view.getContext());
        this.ePr.createView();
        this.ePr.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.ePr.setLineGone();
        this.ePr.setTextColor(am.getColor(R.color.cp_cont_j));
        this.ePr.setTextSize(R.dimen.tbfontsize33);
        this.ePr.setNoMoreTextColorId(R.color.cp_cont_e);
        this.gir.setNextPage(this.ePr);
        this.gir.setOnItemClickListener(this.Ul);
    }

    public void b(com.baidu.tieba.enterForum.hotuserrank.a.a aVar, boolean z) {
        this.gDi.a(aVar, z);
    }

    public void bY(List<com.baidu.tieba.enterForum.hotuserrank.a.b> list) {
        if (list != null) {
            this.mDataList.clear();
            this.mDataList.addAll(list);
            this.mAdapter.notifyDataSetChanged();
        }
    }

    public void setOnSrollToBottomListener(BdListView.e eVar) {
        this.gir.setOnSrollToBottomListener(eVar);
    }

    public void bmm() {
        this.ePr.setTopExtraViewGone();
        this.ePr.startLoadData();
        this.ePr.setText(this.gir.getContext().getString(R.string.list_loading));
        this.ePr.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
    }

    public void Cc(String str) {
        String string;
        this.ePr.lu(l.getDimens(this.gir.getContext(), R.dimen.tbds96));
        if (!TextUtils.isEmpty(str)) {
            string = String.format(this.gir.getContext().getString(R.string.hot_user_rank_list_no_more), str);
        } else {
            string = this.gir.getContext().getString(R.string.forum_hot_user_rank_list_no_more);
        }
        this.ePr.al(string, l.getDimens(this.gir.getContext(), R.dimen.tbds156));
        this.ePr.endLoadData();
        this.ePr.showEmptyView(l.getDimens(this.gir.getContext(), R.dimen.tbds44));
    }

    public void onChangeSkinType(int i) {
        this.gDi.onChangeSkinType(i);
        this.mAdapter.notifyDataSetChanged();
        if (this.ePr != null) {
            this.ePr.setTextColor(am.getColor(R.color.cp_cont_d));
            this.ePr.changeSkin(i);
        }
    }

    /* loaded from: classes9.dex */
    public static class a extends RecyclerView.ViewHolder {
        private com.baidu.tbadk.core.view.userLike.c agp;
        private TextView cBd;
        private TextView gDk;
        private HeadImageView gDl;
        private UserHeadCoverView gDm;
        private TextView gDn;
        private ImageView gDo;
        private TextView gDp;
        private HotUserRankLikeButton gDq;
        private int gDr;
        private String mCategory;
        private long mForumId;
        private TbPageContext mPageContext;
        private int mSkinType;

        public a(View view) {
            super(view);
            this.mSkinType = 3;
            this.mCategory = "";
            this.gDr = 0;
            this.mPageContext = er(view.getContext());
            this.gDk = (TextView) view.findViewById(R.id.rank_num);
            this.gDk.getPaint().setFakeBoldText(true);
            this.gDl = (HeadImageView) view.findViewById(R.id.head_icon);
            this.gDl.setIsRound(true);
            this.gDl.setPlaceHolder(2);
            this.gDl.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.gDm = (UserHeadCoverView) view.findViewById(R.id.head_cover);
            this.cBd = (TextView) view.findViewById(R.id.user_name);
            this.gDn = (TextView) view.findViewById(R.id.user_intro);
            this.gDo = (ImageView) view.findViewById(R.id.grade);
            this.gDp = (TextView) view.findViewById(R.id.user_influence);
            this.gDq = (HotUserRankLikeButton) view.findViewById(R.id.like_button);
        }

        public void a(final com.baidu.tieba.enterForum.hotuserrank.a.b bVar) {
            int i;
            if (bVar != null) {
                if (!TextUtils.isEmpty(bVar.rankNum)) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gDk.getLayoutParams();
                    int dimension = (int) this.mPageContext.getResources().getDimension(R.dimen.tbds44);
                    this.gDk.setText(bVar.rankNum);
                    if (this.gDr == 1) {
                        dimension = (int) this.mPageContext.getResources().getDimension(R.dimen.tbds26);
                        layoutParams.width = (int) this.mPageContext.getResources().getDimension(R.dimen.tbds129);
                    }
                    layoutParams.setMargins(dimension, 0, 0, 0);
                    this.gDk.setLayoutParams(layoutParams);
                }
                if ("1".equals(this.gDk.getText())) {
                    i = R.color.cp_other_h;
                } else if ("2".equals(this.gDk.getText())) {
                    i = R.color.cp_other_i;
                } else if ("3".equals(this.gDk.getText())) {
                    i = R.color.cp_other_j;
                } else {
                    i = R.color.cp_cont_b;
                }
                am.setViewTextColor(this.gDk, i);
                this.gDl.startLoad(bVar.gDA, 10, false);
                this.gDm.setData(bVar);
                String str = bVar.userName;
                if (ad.getTextLengthWithEmoji(str) > 12) {
                    str = ad.subStringWithEmoji(str, 10) + StringHelper.STRING_MORE;
                }
                this.cBd.setText(str);
                if (TextUtils.isEmpty(bVar.gDB)) {
                    this.gDn.setVisibility(8);
                } else {
                    this.gDn.setVisibility(0);
                    this.gDn.setText(aq.ag(bVar.gDB, 26));
                }
                if (bVar.gDD.getLevel_id() == 0) {
                    this.gDo.setVisibility(8);
                } else {
                    this.gDo.setVisibility(0);
                    am.setImageResource(this.gDo, BitmapHelper.getGradeResourceIdInEnterForum(bVar.gDD.getLevel_id()));
                }
                if (TextUtils.isEmpty(bVar.gDC)) {
                    this.gDp.setVisibility(8);
                } else {
                    this.gDp.setVisibility(0);
                    this.gDp.setText(bVar.gDC);
                }
                if (this.agp == null && this.mPageContext != null) {
                    this.agp = new com.baidu.tbadk.core.view.userLike.c(this.mPageContext, this.gDq);
                    this.agp.j(this.mPageContext.getUniqueId());
                }
                this.agp.a(bVar.gDD);
                this.gDq.setOnClickEvent(new DynamicUserLikeButton.a() { // from class: com.baidu.tieba.enterForum.hotuserrank.c.a.1
                    @Override // com.baidu.tieba.view.DynamicUserLikeButton.a
                    public void G(View view) {
                        if (!TextUtils.isEmpty(a.this.mCategory)) {
                            an anVar = new an("c13661");
                            anVar.t("uid", TbadkCoreApplication.getCurrentAccountId());
                            anVar.cI("resource_id", a.this.mCategory);
                            anVar.cI("friend_uid", bVar.rankNum);
                            anVar.af("obj_type", bVar.gDD.getIsLike() ? 2 : 1);
                            TiebaStatic.log(anVar);
                            return;
                        }
                        an anVar2 = new an("c13672");
                        anVar2.cI("obj_id", bVar.gDD.getUserId());
                        anVar2.t("uid", TbadkCoreApplication.getCurrentAccountId());
                        anVar2.cI("resource_id", a.this.mCategory);
                        anVar2.t("fid", a.this.mForumId);
                        anVar2.cI("friend_uid", bVar.rankNum);
                        anVar2.af("obj_type", bVar.gDD.getIsLike() ? 2 : 1);
                        TiebaStatic.log(anVar2);
                    }
                });
                if (bVar.gDD != null && bVar.gDD.getUserId() != null && bVar.gDD.getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                    this.gDq.setVisibility(8);
                } else {
                    this.gDq.setVisibility(0);
                }
                onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            }
        }

        private TbPageContext er(Context context) {
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
                am.setViewTextColor(this.cBd, (int) R.color.cp_cont_b);
                am.setViewTextColor(this.gDn, (int) R.color.cp_cont_d);
                am.setViewTextColor(this.gDp, (int) R.color.cp_cont_d);
                this.gDq.onChangeSkinType(this.mSkinType);
            }
        }

        public void setCategory(String str) {
            this.mCategory = str;
        }

        public void setForumId(long j) {
            this.mForumId = j;
        }

        public void sp(int i) {
            this.gDr = i;
        }

        public void bIP() {
            this.gDn.setVisibility(8);
            this.gDq.setVisibility(8);
        }
    }
}
