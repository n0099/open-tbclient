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
/* loaded from: classes22.dex */
public class c {
    private PbListView fTv;
    private com.baidu.tieba.enterForum.hotuserrank.a hTq;
    private BdRecyclerView hyA;
    private String mCategory;
    private long mForumId;
    private List<com.baidu.tieba.enterForum.hotuserrank.a.b> mDataList = new ArrayList();
    private BdRecyclerView.a Wi = new BdRecyclerView.a() { // from class: com.baidu.tieba.enterForum.hotuserrank.c.1
        @Override // com.baidu.adp.widget.ListView.BdRecyclerView.a
        public void a(ViewGroup viewGroup, View view, Object obj, int i, long j) {
            com.baidu.tieba.enterForum.hotuserrank.a.b bVar = (com.baidu.tieba.enterForum.hotuserrank.a.b) c.this.mDataList.get(i);
            if (bVar != null && bVar.hTL != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(c.this.hyA.getContext(), bVar.hTL.getUserId(), bVar.hTL.getName_show())));
                if (!TextUtils.isEmpty(c.this.mCategory)) {
                    aq aqVar = new aq("c13660");
                    aqVar.u("uid", TbadkCoreApplication.getCurrentAccountId());
                    aqVar.dK("resource_id", c.this.mCategory);
                    aqVar.dK("friend_uid", bVar.rankNum);
                    TiebaStatic.log(aqVar);
                    return;
                }
                aq aqVar2 = new aq("c13668");
                aqVar2.dK("uid", bVar.hTL.getUserId());
                aqVar2.u("fid", c.this.mForumId);
                TiebaStatic.log(aqVar2);
            }
        }
    };
    private RecyclerView.Adapter mAdapter = new RecyclerView.Adapter<a>() { // from class: com.baidu.tieba.enterForum.hotuserrank.c.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.support.v7.widget.RecyclerView.Adapter
        /* renamed from: v */
        public a onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            a aVar = new a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.hot_user_rank_item_view, (ViewGroup) null));
            aVar.xj(0);
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
        this.hyA = (BdRecyclerView) view;
        this.hyA.setLayoutManager(new LinearLayoutManager(view.getContext()));
        this.hyA.setAdapter(this.mAdapter);
        View inflate = LayoutInflater.from(view.getContext()).inflate(R.layout.hot_user_rank_top_user, (ViewGroup) null);
        this.hTq = new com.baidu.tieba.enterForum.hotuserrank.a(inflate, this.mCategory, this.mForumId);
        inflate.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
        this.hyA.addHeaderView(inflate);
        this.fTv = new PbListView(view.getContext());
        this.fTv.createView();
        this.fTv.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.fTv.setLineGone();
        this.fTv.setTextColor(ap.getColor(R.color.cp_cont_j));
        this.fTv.setTextSize(R.dimen.tbfontsize33);
        this.fTv.setNoMoreTextColorId(R.color.cp_cont_e);
        this.hyA.setNextPage(this.fTv);
        this.hyA.setOnItemClickListener(this.Wi);
    }

    public void b(com.baidu.tieba.enterForum.hotuserrank.a.a aVar, boolean z) {
        this.hTq.a(aVar, z);
    }

    public void cu(List<com.baidu.tieba.enterForum.hotuserrank.a.b> list) {
        if (list != null) {
            this.mDataList.clear();
            this.mDataList.addAll(list);
            this.mAdapter.notifyDataSetChanged();
        }
    }

    public void setOnSrollToBottomListener(BdListView.e eVar) {
        this.hyA.setOnSrollToBottomListener(eVar);
    }

    public void SI() {
        this.fTv.setTopExtraViewGone();
        this.fTv.startLoadData();
        this.fTv.setText(this.hyA.getContext().getString(R.string.list_loading));
        this.fTv.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
    }

    public void IH(String str) {
        String string;
        this.fTv.py(l.getDimens(this.hyA.getContext(), R.dimen.tbds96));
        if (!TextUtils.isEmpty(str)) {
            string = String.format(this.hyA.getContext().getString(R.string.hot_user_rank_list_no_more), str);
        } else {
            string = this.hyA.getContext().getString(R.string.forum_hot_user_rank_list_no_more);
        }
        this.fTv.ap(string, l.getDimens(this.hyA.getContext(), R.dimen.tbds156));
        this.fTv.endLoadData();
        this.fTv.showEmptyView(l.getDimens(this.hyA.getContext(), R.dimen.tbds44));
    }

    public void onChangeSkinType(int i) {
        this.hTq.onChangeSkinType(i);
        this.mAdapter.notifyDataSetChanged();
        if (this.fTv != null) {
            this.fTv.setTextColor(ap.getColor(R.color.cp_cont_d));
            this.fTv.changeSkin(i);
        }
    }

    /* loaded from: classes22.dex */
    public static class a extends RecyclerView.ViewHolder {
        private com.baidu.tbadk.core.view.userLike.c ajV;
        private TextView eig;
        private boolean hTA;
        private TextView hTs;
        private HeadImageView hTt;
        private UserHeadCoverView hTu;
        private TextView hTv;
        private ImageView hTw;
        private TextView hTx;
        private HotUserRankLikeButton hTy;
        private int hTz;
        private String mCategory;
        private long mForumId;
        private TbPageContext mPageContext;
        private int mSkinType;

        public a(View view) {
            super(view);
            this.mSkinType = 3;
            this.mCategory = "";
            this.hTz = 0;
            this.mPageContext = fi(view.getContext());
            this.hTs = (TextView) view.findViewById(R.id.rank_num);
            this.hTs.getPaint().setFakeBoldText(true);
            this.hTt = (HeadImageView) view.findViewById(R.id.head_icon);
            this.hTt.setIsRound(true);
            this.hTt.setPlaceHolder(2);
            this.hTt.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.hTu = (UserHeadCoverView) view.findViewById(R.id.head_cover);
            this.eig = (TextView) view.findViewById(R.id.user_name);
            this.hTv = (TextView) view.findViewById(R.id.user_intro);
            this.hTw = (ImageView) view.findViewById(R.id.grade);
            this.hTx = (TextView) view.findViewById(R.id.user_influence);
            this.hTy = (HotUserRankLikeButton) view.findViewById(R.id.like_button);
        }

        public void a(final com.baidu.tieba.enterForum.hotuserrank.a.b bVar) {
            int i;
            if (bVar != null) {
                if (!TextUtils.isEmpty(bVar.rankNum)) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hTs.getLayoutParams();
                    int dimension = (int) this.mPageContext.getResources().getDimension(R.dimen.tbds44);
                    this.hTs.setText(bVar.rankNum);
                    if (this.hTz == 1) {
                        dimension = (int) this.mPageContext.getResources().getDimension(R.dimen.tbds26);
                        layoutParams.width = (int) this.mPageContext.getResources().getDimension(R.dimen.tbds129);
                    }
                    layoutParams.setMargins(dimension, 0, 0, 0);
                    this.hTs.setLayoutParams(layoutParams);
                }
                int i2 = R.color.cp_cont_b;
                if ("1".equals(this.hTs.getText())) {
                    i = R.color.cp_other_h;
                } else if ("2".equals(this.hTs.getText())) {
                    i = R.color.cp_other_i;
                } else if ("3".equals(this.hTs.getText())) {
                    i = R.color.cp_other_j;
                } else {
                    i = R.color.cp_cont_b;
                }
                ap.setViewTextColor(this.hTs, i);
                this.hTt.startLoad(bVar.hTI, 10, false);
                this.hTu.setData(bVar);
                String str = bVar.userName;
                if (af.getTextLengthWithEmoji(str) > 12) {
                    str = af.subStringWithEmoji(str, 10) + StringHelper.STRING_MORE;
                }
                this.eig.setText(str);
                this.hTA = bVar.hTA;
                if (bVar.hTA) {
                    ap.setViewTextColor(this.eig, R.color.cp_cont_h);
                }
                if (TextUtils.isEmpty(bVar.hTJ)) {
                    this.hTv.setVisibility(8);
                } else {
                    this.hTv.setVisibility(0);
                    this.hTv.setText(at.ak(bVar.hTJ, 26));
                }
                if (bVar.hTL.getLevel_id() == 0) {
                    this.hTw.setVisibility(8);
                } else {
                    this.hTw.setVisibility(0);
                    ap.setImageResource(this.hTw, BitmapHelper.getGradeResourceIdInEnterForum(bVar.hTL.getLevel_id()));
                }
                if (TextUtils.isEmpty(bVar.hTK)) {
                    this.hTx.setVisibility(8);
                } else {
                    this.hTx.setVisibility(0);
                    this.hTx.setText(bVar.hTK);
                }
                if (this.ajV == null && this.mPageContext != null) {
                    this.ajV = new com.baidu.tbadk.core.view.userLike.c(this.mPageContext, this.hTy);
                    this.ajV.l(this.mPageContext.getUniqueId());
                }
                this.ajV.a(bVar.hTL);
                this.hTy.setOnClickEvent(new DynamicUserLikeButton.a() { // from class: com.baidu.tieba.enterForum.hotuserrank.c.a.1
                    @Override // com.baidu.tieba.view.DynamicUserLikeButton.a
                    public void cm(View view) {
                        if (!TextUtils.isEmpty(a.this.mCategory)) {
                            aq aqVar = new aq("c13661");
                            aqVar.u("uid", TbadkCoreApplication.getCurrentAccountId());
                            aqVar.dK("resource_id", a.this.mCategory);
                            aqVar.dK("friend_uid", bVar.rankNum);
                            aqVar.aj("obj_type", bVar.hTL.getIsLike() ? 2 : 1);
                            TiebaStatic.log(aqVar);
                            return;
                        }
                        aq aqVar2 = new aq("c13672");
                        aqVar2.dK("obj_id", bVar.hTL.getUserId());
                        aqVar2.u("uid", TbadkCoreApplication.getCurrentAccountId());
                        aqVar2.dK("resource_id", a.this.mCategory);
                        aqVar2.u("fid", a.this.mForumId);
                        aqVar2.dK("friend_uid", bVar.rankNum);
                        aqVar2.aj("obj_type", bVar.hTL.getIsLike() ? 2 : 1);
                        TiebaStatic.log(aqVar2);
                    }
                });
                if (bVar.hTL != null && bVar.hTL.getUserId() != null && bVar.hTL.getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                    this.hTy.setVisibility(8);
                } else {
                    this.hTy.setVisibility(0);
                }
                onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            }
        }

        private TbPageContext fi(Context context) {
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
                if (!this.hTA) {
                    ap.setViewTextColor(this.eig, R.color.cp_cont_b);
                } else {
                    ap.setViewTextColor(this.eig, R.color.cp_cont_h);
                }
                ap.setViewTextColor(this.hTv, R.color.cp_cont_d);
                ap.setViewTextColor(this.hTx, R.color.cp_cont_d);
                this.hTy.onChangeSkinType(this.mSkinType);
            }
        }

        public void setCategory(String str) {
            this.mCategory = str;
        }

        public void setForumId(long j) {
            this.mForumId = j;
        }

        public void xj(int i) {
            this.hTz = i;
        }

        public void cmH() {
            this.hTv.setVisibility(8);
            this.hTy.setVisibility(8);
        }
    }
}
