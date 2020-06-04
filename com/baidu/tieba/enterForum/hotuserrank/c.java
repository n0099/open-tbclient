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
import com.baidu.tbadk.util.ae;
import com.baidu.tieba.R;
import com.baidu.tieba.enterForum.hotuserrank.view.HotUserRankLikeButton;
import com.baidu.tieba.enterForum.hotuserrank.view.UserHeadCoverView;
import com.baidu.tieba.view.DynamicUserLikeButton;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class c {
    private PbListView fcj;
    private com.baidu.tieba.enterForum.hotuserrank.a gSb;
    private BdRecyclerView gxs;
    private String mCategory;
    private long mForumId;
    private List<com.baidu.tieba.enterForum.hotuserrank.a.b> mDataList = new ArrayList();
    private BdRecyclerView.a Uw = new BdRecyclerView.a() { // from class: com.baidu.tieba.enterForum.hotuserrank.c.1
        @Override // com.baidu.adp.widget.ListView.BdRecyclerView.a
        public void a(ViewGroup viewGroup, View view, Object obj, int i, long j) {
            com.baidu.tieba.enterForum.hotuserrank.a.b bVar = (com.baidu.tieba.enterForum.hotuserrank.a.b) c.this.mDataList.get(i);
            if (bVar != null && bVar.gSx != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(c.this.gxs.getContext(), bVar.gSx.getUserId(), bVar.gSx.getName_show())));
                if (!TextUtils.isEmpty(c.this.mCategory)) {
                    an anVar = new an("c13660");
                    anVar.s("uid", TbadkCoreApplication.getCurrentAccountId());
                    anVar.dh("resource_id", c.this.mCategory);
                    anVar.dh("friend_uid", bVar.rankNum);
                    TiebaStatic.log(anVar);
                    return;
                }
                an anVar2 = new an("c13668");
                anVar2.dh("uid", bVar.gSx.getUserId());
                anVar2.s("fid", c.this.mForumId);
                TiebaStatic.log(anVar2);
            }
        }
    };
    private RecyclerView.Adapter mAdapter = new RecyclerView.Adapter<a>() { // from class: com.baidu.tieba.enterForum.hotuserrank.c.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.support.v7.widget.RecyclerView.Adapter
        /* renamed from: q */
        public a onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            a aVar = new a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.hot_user_rank_item_view, (ViewGroup) null));
            aVar.sW(0);
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
        this.gxs = (BdRecyclerView) view;
        this.gxs.setLayoutManager(new LinearLayoutManager(view.getContext()));
        this.gxs.setAdapter(this.mAdapter);
        View inflate = LayoutInflater.from(view.getContext()).inflate(R.layout.hot_user_rank_top_user, (ViewGroup) null);
        this.gSb = new com.baidu.tieba.enterForum.hotuserrank.a(inflate, this.mCategory, this.mForumId);
        inflate.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
        this.gxs.addHeaderView(inflate);
        this.fcj = new PbListView(view.getContext());
        this.fcj.createView();
        this.fcj.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.fcj.setLineGone();
        this.fcj.setTextColor(am.getColor(R.color.cp_cont_j));
        this.fcj.setTextSize(R.dimen.tbfontsize33);
        this.fcj.setNoMoreTextColorId(R.color.cp_cont_e);
        this.gxs.setNextPage(this.fcj);
        this.gxs.setOnItemClickListener(this.Uw);
    }

    public void b(com.baidu.tieba.enterForum.hotuserrank.a.a aVar, boolean z) {
        this.gSb.a(aVar, z);
    }

    public void bV(List<com.baidu.tieba.enterForum.hotuserrank.a.b> list) {
        if (list != null) {
            this.mDataList.clear();
            this.mDataList.addAll(list);
            this.mAdapter.notifyDataSetChanged();
        }
    }

    public void setOnSrollToBottomListener(BdListView.e eVar) {
        this.gxs.setOnSrollToBottomListener(eVar);
    }

    public void brM() {
        this.fcj.setTopExtraViewGone();
        this.fcj.startLoadData();
        this.fcj.setText(this.gxs.getContext().getString(R.string.list_loading));
        this.fcj.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
    }

    public void DL(String str) {
        String string;
        this.fcj.lY(l.getDimens(this.gxs.getContext(), R.dimen.tbds96));
        if (!TextUtils.isEmpty(str)) {
            string = String.format(this.gxs.getContext().getString(R.string.hot_user_rank_list_no_more), str);
        } else {
            string = this.gxs.getContext().getString(R.string.forum_hot_user_rank_list_no_more);
        }
        this.fcj.am(string, l.getDimens(this.gxs.getContext(), R.dimen.tbds156));
        this.fcj.endLoadData();
        this.fcj.showEmptyView(l.getDimens(this.gxs.getContext(), R.dimen.tbds44));
    }

    public void onChangeSkinType(int i) {
        this.gSb.onChangeSkinType(i);
        this.mAdapter.notifyDataSetChanged();
        if (this.fcj != null) {
            this.fcj.setTextColor(am.getColor(R.color.cp_cont_d));
            this.fcj.changeSkin(i);
        }
    }

    /* loaded from: classes9.dex */
    public static class a extends RecyclerView.ViewHolder {
        private com.baidu.tbadk.core.view.userLike.c agS;
        private TextView dXU;
        private TextView gSd;
        private HeadImageView gSe;
        private UserHeadCoverView gSf;
        private TextView gSg;
        private ImageView gSh;
        private TextView gSi;
        private HotUserRankLikeButton gSj;
        private int gSk;
        private boolean gSl;
        private String mCategory;
        private long mForumId;
        private TbPageContext mPageContext;
        private int mSkinType;

        public a(View view) {
            super(view);
            this.mSkinType = 3;
            this.mCategory = "";
            this.gSk = 0;
            this.mPageContext = eG(view.getContext());
            this.gSd = (TextView) view.findViewById(R.id.rank_num);
            this.gSd.getPaint().setFakeBoldText(true);
            this.gSe = (HeadImageView) view.findViewById(R.id.head_icon);
            this.gSe.setIsRound(true);
            this.gSe.setPlaceHolder(2);
            this.gSe.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.gSf = (UserHeadCoverView) view.findViewById(R.id.head_cover);
            this.dXU = (TextView) view.findViewById(R.id.user_name);
            this.gSg = (TextView) view.findViewById(R.id.user_intro);
            this.gSh = (ImageView) view.findViewById(R.id.grade);
            this.gSi = (TextView) view.findViewById(R.id.user_influence);
            this.gSj = (HotUserRankLikeButton) view.findViewById(R.id.like_button);
        }

        public void a(final com.baidu.tieba.enterForum.hotuserrank.a.b bVar) {
            int i;
            if (bVar != null) {
                if (!TextUtils.isEmpty(bVar.rankNum)) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gSd.getLayoutParams();
                    int dimension = (int) this.mPageContext.getResources().getDimension(R.dimen.tbds44);
                    this.gSd.setText(bVar.rankNum);
                    if (this.gSk == 1) {
                        dimension = (int) this.mPageContext.getResources().getDimension(R.dimen.tbds26);
                        layoutParams.width = (int) this.mPageContext.getResources().getDimension(R.dimen.tbds129);
                    }
                    layoutParams.setMargins(dimension, 0, 0, 0);
                    this.gSd.setLayoutParams(layoutParams);
                }
                if ("1".equals(this.gSd.getText())) {
                    i = R.color.cp_other_h;
                } else if ("2".equals(this.gSd.getText())) {
                    i = R.color.cp_other_i;
                } else if ("3".equals(this.gSd.getText())) {
                    i = R.color.cp_other_j;
                } else {
                    i = R.color.cp_cont_b;
                }
                am.setViewTextColor(this.gSd, i);
                this.gSe.startLoad(bVar.gSu, 10, false);
                this.gSf.setData(bVar);
                String str = bVar.userName;
                if (ae.getTextLengthWithEmoji(str) > 12) {
                    str = ae.subStringWithEmoji(str, 10) + StringHelper.STRING_MORE;
                }
                this.dXU.setText(str);
                this.gSl = bVar.gSl;
                if (bVar.gSl) {
                    am.setViewTextColor(this.dXU, (int) R.color.cp_cont_h);
                }
                if (TextUtils.isEmpty(bVar.gSv)) {
                    this.gSg.setVisibility(8);
                } else {
                    this.gSg.setVisibility(0);
                    this.gSg.setText(aq.ah(bVar.gSv, 26));
                }
                if (bVar.gSx.getLevel_id() == 0) {
                    this.gSh.setVisibility(8);
                } else {
                    this.gSh.setVisibility(0);
                    am.setImageResource(this.gSh, BitmapHelper.getGradeResourceIdInEnterForum(bVar.gSx.getLevel_id()));
                }
                if (TextUtils.isEmpty(bVar.gSw)) {
                    this.gSi.setVisibility(8);
                } else {
                    this.gSi.setVisibility(0);
                    this.gSi.setText(bVar.gSw);
                }
                if (this.agS == null && this.mPageContext != null) {
                    this.agS = new com.baidu.tbadk.core.view.userLike.c(this.mPageContext, this.gSj);
                    this.agS.l(this.mPageContext.getUniqueId());
                }
                this.agS.a(bVar.gSx);
                this.gSj.setOnClickEvent(new DynamicUserLikeButton.a() { // from class: com.baidu.tieba.enterForum.hotuserrank.c.a.1
                    @Override // com.baidu.tieba.view.DynamicUserLikeButton.a
                    public void bO(View view) {
                        if (!TextUtils.isEmpty(a.this.mCategory)) {
                            an anVar = new an("c13661");
                            anVar.s("uid", TbadkCoreApplication.getCurrentAccountId());
                            anVar.dh("resource_id", a.this.mCategory);
                            anVar.dh("friend_uid", bVar.rankNum);
                            anVar.ag("obj_type", bVar.gSx.getIsLike() ? 2 : 1);
                            TiebaStatic.log(anVar);
                            return;
                        }
                        an anVar2 = new an("c13672");
                        anVar2.dh("obj_id", bVar.gSx.getUserId());
                        anVar2.s("uid", TbadkCoreApplication.getCurrentAccountId());
                        anVar2.dh("resource_id", a.this.mCategory);
                        anVar2.s("fid", a.this.mForumId);
                        anVar2.dh("friend_uid", bVar.rankNum);
                        anVar2.ag("obj_type", bVar.gSx.getIsLike() ? 2 : 1);
                        TiebaStatic.log(anVar2);
                    }
                });
                if (bVar.gSx != null && bVar.gSx.getUserId() != null && bVar.gSx.getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                    this.gSj.setVisibility(8);
                } else {
                    this.gSj.setVisibility(0);
                }
                onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            }
        }

        private TbPageContext eG(Context context) {
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
                if (!this.gSl) {
                    am.setViewTextColor(this.dXU, (int) R.color.cp_cont_b);
                } else {
                    am.setViewTextColor(this.dXU, (int) R.color.cp_cont_h);
                }
                am.setViewTextColor(this.gSg, (int) R.color.cp_cont_d);
                am.setViewTextColor(this.gSi, (int) R.color.cp_cont_d);
                this.gSj.onChangeSkinType(this.mSkinType);
            }
        }

        public void setCategory(String str) {
            this.mCategory = str;
        }

        public void setForumId(long j) {
            this.mForumId = j;
        }

        public void sW(int i) {
            this.gSk = i;
        }

        public void bPl() {
            this.gSg.setVisibility(8);
            this.gSj.setVisibility(8);
        }
    }
}
