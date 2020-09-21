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
import com.baidu.tbadk.util.af;
import com.baidu.tieba.R;
import com.baidu.tieba.enterForum.hotuserrank.view.HotUserRankLikeButton;
import com.baidu.tieba.enterForum.hotuserrank.view.UserHeadCoverView;
import com.baidu.tieba.view.DynamicUserLikeButton;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes21.dex */
public class c {
    private PbListView fHm;
    private com.baidu.tieba.enterForum.hotuserrank.a hEu;
    private BdRecyclerView hjF;
    private String mCategory;
    private long mForumId;
    private List<com.baidu.tieba.enterForum.hotuserrank.a.b> mDataList = new ArrayList();
    private BdRecyclerView.a VR = new BdRecyclerView.a() { // from class: com.baidu.tieba.enterForum.hotuserrank.c.1
        @Override // com.baidu.adp.widget.ListView.BdRecyclerView.a
        public void a(ViewGroup viewGroup, View view, Object obj, int i, long j) {
            com.baidu.tieba.enterForum.hotuserrank.a.b bVar = (com.baidu.tieba.enterForum.hotuserrank.a.b) c.this.mDataList.get(i);
            if (bVar != null && bVar.hEP != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(c.this.hjF.getContext(), bVar.hEP.getUserId(), bVar.hEP.getName_show())));
                if (!TextUtils.isEmpty(c.this.mCategory)) {
                    aq aqVar = new aq("c13660");
                    aqVar.u("uid", TbadkCoreApplication.getCurrentAccountId());
                    aqVar.dF("resource_id", c.this.mCategory);
                    aqVar.dF("friend_uid", bVar.rankNum);
                    TiebaStatic.log(aqVar);
                    return;
                }
                aq aqVar2 = new aq("c13668");
                aqVar2.dF("uid", bVar.hEP.getUserId());
                aqVar2.u("fid", c.this.mForumId);
                TiebaStatic.log(aqVar2);
            }
        }
    };
    private RecyclerView.Adapter mAdapter = new RecyclerView.Adapter<a>() { // from class: com.baidu.tieba.enterForum.hotuserrank.c.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.support.v7.widget.RecyclerView.Adapter
        /* renamed from: t */
        public a onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            a aVar = new a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.hot_user_rank_item_view, (ViewGroup) null));
            aVar.wD(0);
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
        this.hjF = (BdRecyclerView) view;
        this.hjF.setLayoutManager(new LinearLayoutManager(view.getContext()));
        this.hjF.setAdapter(this.mAdapter);
        View inflate = LayoutInflater.from(view.getContext()).inflate(R.layout.hot_user_rank_top_user, (ViewGroup) null);
        this.hEu = new com.baidu.tieba.enterForum.hotuserrank.a(inflate, this.mCategory, this.mForumId);
        inflate.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
        this.hjF.addHeaderView(inflate);
        this.fHm = new PbListView(view.getContext());
        this.fHm.createView();
        this.fHm.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.fHm.setLineGone();
        this.fHm.setTextColor(ap.getColor(R.color.cp_cont_j));
        this.fHm.setTextSize(R.dimen.tbfontsize33);
        this.fHm.setNoMoreTextColorId(R.color.cp_cont_e);
        this.hjF.setNextPage(this.fHm);
        this.hjF.setOnItemClickListener(this.VR);
    }

    public void b(com.baidu.tieba.enterForum.hotuserrank.a.a aVar, boolean z) {
        this.hEu.a(aVar, z);
    }

    public void cr(List<com.baidu.tieba.enterForum.hotuserrank.a.b> list) {
        if (list != null) {
            this.mDataList.clear();
            this.mDataList.addAll(list);
            this.mAdapter.notifyDataSetChanged();
        }
    }

    public void setOnSrollToBottomListener(BdListView.e eVar) {
        this.hjF.setOnSrollToBottomListener(eVar);
    }

    public void bIi() {
        this.fHm.setTopExtraViewGone();
        this.fHm.startLoadData();
        this.fHm.setText(this.hjF.getContext().getString(R.string.list_loading));
        this.fHm.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
    }

    public void HU(String str) {
        String string;
        this.fHm.oZ(l.getDimens(this.hjF.getContext(), R.dimen.tbds96));
        if (!TextUtils.isEmpty(str)) {
            string = String.format(this.hjF.getContext().getString(R.string.hot_user_rank_list_no_more), str);
        } else {
            string = this.hjF.getContext().getString(R.string.forum_hot_user_rank_list_no_more);
        }
        this.fHm.ao(string, l.getDimens(this.hjF.getContext(), R.dimen.tbds156));
        this.fHm.endLoadData();
        this.fHm.showEmptyView(l.getDimens(this.hjF.getContext(), R.dimen.tbds44));
    }

    public void onChangeSkinType(int i) {
        this.hEu.onChangeSkinType(i);
        this.mAdapter.notifyDataSetChanged();
        if (this.fHm != null) {
            this.fHm.setTextColor(ap.getColor(R.color.cp_cont_d));
            this.fHm.changeSkin(i);
        }
    }

    /* loaded from: classes21.dex */
    public static class a extends RecyclerView.ViewHolder {
        private com.baidu.tbadk.core.view.userLike.c ajD;
        private TextView dWe;
        private ImageView hEA;
        private TextView hEB;
        private HotUserRankLikeButton hEC;
        private int hED;
        private boolean hEE;
        private TextView hEw;
        private HeadImageView hEx;
        private UserHeadCoverView hEy;
        private TextView hEz;
        private String mCategory;
        private long mForumId;
        private TbPageContext mPageContext;
        private int mSkinType;

        public a(View view) {
            super(view);
            this.mSkinType = 3;
            this.mCategory = "";
            this.hED = 0;
            this.mPageContext = fb(view.getContext());
            this.hEw = (TextView) view.findViewById(R.id.rank_num);
            this.hEw.getPaint().setFakeBoldText(true);
            this.hEx = (HeadImageView) view.findViewById(R.id.head_icon);
            this.hEx.setIsRound(true);
            this.hEx.setPlaceHolder(2);
            this.hEx.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.hEy = (UserHeadCoverView) view.findViewById(R.id.head_cover);
            this.dWe = (TextView) view.findViewById(R.id.user_name);
            this.hEz = (TextView) view.findViewById(R.id.user_intro);
            this.hEA = (ImageView) view.findViewById(R.id.grade);
            this.hEB = (TextView) view.findViewById(R.id.user_influence);
            this.hEC = (HotUserRankLikeButton) view.findViewById(R.id.like_button);
        }

        public void a(final com.baidu.tieba.enterForum.hotuserrank.a.b bVar) {
            int i;
            if (bVar != null) {
                if (!TextUtils.isEmpty(bVar.rankNum)) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hEw.getLayoutParams();
                    int dimension = (int) this.mPageContext.getResources().getDimension(R.dimen.tbds44);
                    this.hEw.setText(bVar.rankNum);
                    if (this.hED == 1) {
                        dimension = (int) this.mPageContext.getResources().getDimension(R.dimen.tbds26);
                        layoutParams.width = (int) this.mPageContext.getResources().getDimension(R.dimen.tbds129);
                    }
                    layoutParams.setMargins(dimension, 0, 0, 0);
                    this.hEw.setLayoutParams(layoutParams);
                }
                int i2 = R.color.cp_cont_b;
                if ("1".equals(this.hEw.getText())) {
                    i = R.color.cp_other_h;
                } else if ("2".equals(this.hEw.getText())) {
                    i = R.color.cp_other_i;
                } else if ("3".equals(this.hEw.getText())) {
                    i = R.color.cp_other_j;
                } else {
                    i = R.color.cp_cont_b;
                }
                ap.setViewTextColor(this.hEw, i);
                this.hEx.startLoad(bVar.hEM, 10, false);
                this.hEy.setData(bVar);
                String str = bVar.userName;
                if (af.getTextLengthWithEmoji(str) > 12) {
                    str = af.subStringWithEmoji(str, 10) + StringHelper.STRING_MORE;
                }
                this.dWe.setText(str);
                this.hEE = bVar.hEE;
                if (bVar.hEE) {
                    ap.setViewTextColor(this.dWe, R.color.cp_cont_h);
                }
                if (TextUtils.isEmpty(bVar.hEN)) {
                    this.hEz.setVisibility(8);
                } else {
                    this.hEz.setVisibility(0);
                    this.hEz.setText(at.aj(bVar.hEN, 26));
                }
                if (bVar.hEP.getLevel_id() == 0) {
                    this.hEA.setVisibility(8);
                } else {
                    this.hEA.setVisibility(0);
                    ap.setImageResource(this.hEA, BitmapHelper.getGradeResourceIdInEnterForum(bVar.hEP.getLevel_id()));
                }
                if (TextUtils.isEmpty(bVar.hEO)) {
                    this.hEB.setVisibility(8);
                } else {
                    this.hEB.setVisibility(0);
                    this.hEB.setText(bVar.hEO);
                }
                if (this.ajD == null && this.mPageContext != null) {
                    this.ajD = new com.baidu.tbadk.core.view.userLike.c(this.mPageContext, this.hEC);
                    this.ajD.l(this.mPageContext.getUniqueId());
                }
                this.ajD.a(bVar.hEP);
                this.hEC.setOnClickEvent(new DynamicUserLikeButton.a() { // from class: com.baidu.tieba.enterForum.hotuserrank.c.a.1
                    @Override // com.baidu.tieba.view.DynamicUserLikeButton.a
                    public void ci(View view) {
                        if (!TextUtils.isEmpty(a.this.mCategory)) {
                            aq aqVar = new aq("c13661");
                            aqVar.u("uid", TbadkCoreApplication.getCurrentAccountId());
                            aqVar.dF("resource_id", a.this.mCategory);
                            aqVar.dF("friend_uid", bVar.rankNum);
                            aqVar.ai("obj_type", bVar.hEP.getIsLike() ? 2 : 1);
                            TiebaStatic.log(aqVar);
                            return;
                        }
                        aq aqVar2 = new aq("c13672");
                        aqVar2.dF("obj_id", bVar.hEP.getUserId());
                        aqVar2.u("uid", TbadkCoreApplication.getCurrentAccountId());
                        aqVar2.dF("resource_id", a.this.mCategory);
                        aqVar2.u("fid", a.this.mForumId);
                        aqVar2.dF("friend_uid", bVar.rankNum);
                        aqVar2.ai("obj_type", bVar.hEP.getIsLike() ? 2 : 1);
                        TiebaStatic.log(aqVar2);
                    }
                });
                if (bVar.hEP != null && bVar.hEP.getUserId() != null && bVar.hEP.getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                    this.hEC.setVisibility(8);
                } else {
                    this.hEC.setVisibility(0);
                }
                onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            }
        }

        private TbPageContext fb(Context context) {
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
                if (!this.hEE) {
                    ap.setViewTextColor(this.dWe, R.color.cp_cont_b);
                } else {
                    ap.setViewTextColor(this.dWe, R.color.cp_cont_h);
                }
                ap.setViewTextColor(this.hEz, R.color.cp_cont_d);
                ap.setViewTextColor(this.hEB, R.color.cp_cont_d);
                this.hEC.onChangeSkinType(this.mSkinType);
            }
        }

        public void setCategory(String str) {
            this.mCategory = str;
        }

        public void setForumId(long j) {
            this.mForumId = j;
        }

        public void wD(int i) {
            this.hED = i;
        }

        public void cjl() {
            this.hEz.setVisibility(8);
            this.hEC.setVisibility(8);
        }
    }
}
