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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.util.ae;
import com.baidu.tieba.R;
import com.baidu.tieba.enterForum.hotuserrank.view.HotUserRankLikeButton;
import com.baidu.tieba.enterForum.hotuserrank.view.UserHeadCoverView;
import com.baidu.tieba.view.DynamicUserLikeButton;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes22.dex */
public class c {
    private PbListView grg;
    private BdRecyclerView icp;
    private com.baidu.tieba.enterForum.hotuserrank.a ixy;
    private String mCategory;
    private long mForumId;
    private List<com.baidu.tieba.enterForum.hotuserrank.a.b> mDataList = new ArrayList();
    private BdRecyclerView.a Xk = new BdRecyclerView.a() { // from class: com.baidu.tieba.enterForum.hotuserrank.c.1
        @Override // com.baidu.adp.widget.ListView.BdRecyclerView.a
        public void a(ViewGroup viewGroup, View view, Object obj, int i, long j) {
            com.baidu.tieba.enterForum.hotuserrank.a.b bVar = (com.baidu.tieba.enterForum.hotuserrank.a.b) c.this.mDataList.get(i);
            if (bVar != null && bVar.ixS != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(c.this.icp.getContext(), bVar.ixS.getUserId(), bVar.ixS.getName_show())));
                if (!TextUtils.isEmpty(c.this.mCategory)) {
                    ar arVar = new ar("c13660");
                    arVar.w("uid", TbadkCoreApplication.getCurrentAccountId());
                    arVar.dY("resource_id", c.this.mCategory);
                    arVar.dY("friend_uid", bVar.rankNum);
                    TiebaStatic.log(arVar);
                    return;
                }
                ar arVar2 = new ar("c13668");
                arVar2.dY("uid", bVar.ixS.getUserId());
                arVar2.w("fid", c.this.mForumId);
                TiebaStatic.log(arVar2);
            }
        }
    };
    private RecyclerView.Adapter mAdapter = new RecyclerView.Adapter<a>() { // from class: com.baidu.tieba.enterForum.hotuserrank.c.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.support.v7.widget.RecyclerView.Adapter
        /* renamed from: v */
        public a onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            a aVar = new a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.hot_user_rank_item_view, (ViewGroup) null));
            aVar.yS(0);
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
        this.icp = (BdRecyclerView) view;
        this.icp.setLayoutManager(new LinearLayoutManager(view.getContext()));
        this.icp.setAdapter(this.mAdapter);
        View inflate = LayoutInflater.from(view.getContext()).inflate(R.layout.hot_user_rank_top_user, (ViewGroup) null);
        this.ixy = new com.baidu.tieba.enterForum.hotuserrank.a(inflate, this.mCategory, this.mForumId);
        inflate.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
        this.icp.addHeaderView(inflate);
        this.grg = new PbListView(view.getContext());
        this.grg.createView();
        this.grg.setContainerBackgroundColorResId(R.color.CAM_X0205);
        this.grg.setLineGone();
        this.grg.setTextColor(ap.getColor(R.color.CAM_X0107));
        this.grg.setTextSize(R.dimen.tbfontsize33);
        this.grg.setNoMoreTextColorId(R.color.CAM_X0110);
        this.icp.setNextPage(this.grg);
        this.icp.setOnItemClickListener(this.Xk);
    }

    public void b(com.baidu.tieba.enterForum.hotuserrank.a.a aVar, boolean z) {
        this.ixy.a(aVar, z);
    }

    public void cP(List<com.baidu.tieba.enterForum.hotuserrank.a.b> list) {
        if (list != null) {
            this.mDataList.clear();
            this.mDataList.addAll(list);
            this.mAdapter.notifyDataSetChanged();
        }
    }

    public void setOnSrollToBottomListener(BdListView.e eVar) {
        this.icp.setOnSrollToBottomListener(eVar);
    }

    public void XZ() {
        this.grg.setTopExtraViewGone();
        this.grg.startLoadData();
        this.grg.setText(this.icp.getContext().getString(R.string.list_loading));
        this.grg.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
    }

    public void JO(String str) {
        String string;
        this.grg.qS(l.getDimens(this.icp.getContext(), R.dimen.tbds96));
        if (!TextUtils.isEmpty(str)) {
            string = String.format(this.icp.getContext().getString(R.string.hot_user_rank_list_no_more), str);
        } else {
            string = this.icp.getContext().getString(R.string.forum_hot_user_rank_list_no_more);
        }
        this.grg.ar(string, l.getDimens(this.icp.getContext(), R.dimen.tbds156));
        this.grg.endLoadData();
        this.grg.showEmptyView(l.getDimens(this.icp.getContext(), R.dimen.tbds44));
    }

    public void onChangeSkinType(int i) {
        this.ixy.onChangeSkinType(i);
        this.mAdapter.notifyDataSetChanged();
        if (this.grg != null) {
            this.grg.setTextColor(ap.getColor(R.color.CAM_X0109));
            this.grg.changeSkin(i);
        }
    }

    /* loaded from: classes22.dex */
    public static class a extends RecyclerView.ViewHolder {
        private com.baidu.tbadk.core.view.userLike.c akZ;
        private TextView eBQ;
        private TextView ixA;
        private HeadImageView ixB;
        private UserHeadCoverView ixC;
        private TextView ixD;
        private ImageView ixE;
        private TextView ixF;
        private HotUserRankLikeButton ixG;
        private int ixH;
        private boolean ixI;
        private String mCategory;
        private long mForumId;
        private TbPageContext mPageContext;
        private int mSkinType;

        public a(View view) {
            super(view);
            this.mSkinType = 3;
            this.mCategory = "";
            this.ixH = 0;
            this.mPageContext = fP(view.getContext());
            this.ixA = (TextView) view.findViewById(R.id.rank_num);
            this.ixA.getPaint().setFakeBoldText(true);
            this.ixB = (HeadImageView) view.findViewById(R.id.head_icon);
            this.ixB.setIsRound(true);
            this.ixB.setPlaceHolder(1);
            this.ixB.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.ixC = (UserHeadCoverView) view.findViewById(R.id.head_cover);
            this.eBQ = (TextView) view.findViewById(R.id.user_name);
            this.ixD = (TextView) view.findViewById(R.id.user_intro);
            this.ixE = (ImageView) view.findViewById(R.id.grade);
            this.ixF = (TextView) view.findViewById(R.id.user_influence);
            this.ixG = (HotUserRankLikeButton) view.findViewById(R.id.like_button);
        }

        public void a(final com.baidu.tieba.enterForum.hotuserrank.a.b bVar) {
            int i;
            if (bVar != null) {
                if (!TextUtils.isEmpty(bVar.rankNum)) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.ixA.getLayoutParams();
                    int dimension = (int) this.mPageContext.getResources().getDimension(R.dimen.tbds44);
                    this.ixA.setText(bVar.rankNum);
                    if (this.ixH == 1) {
                        dimension = (int) this.mPageContext.getResources().getDimension(R.dimen.tbds26);
                        layoutParams.width = (int) this.mPageContext.getResources().getDimension(R.dimen.tbds129);
                    }
                    layoutParams.setMargins(dimension, 0, 0, 0);
                    this.ixA.setLayoutParams(layoutParams);
                }
                int i2 = R.color.CAM_X0105;
                if ("1".equals(this.ixA.getText())) {
                    i = R.color.CAM_X0314;
                } else if ("2".equals(this.ixA.getText())) {
                    i = R.color.CAM_X0315;
                } else if ("3".equals(this.ixA.getText())) {
                    i = R.color.CAM_X0316;
                } else {
                    i = R.color.CAM_X0105;
                }
                ap.setViewTextColor(this.ixA, i);
                this.ixB.startLoad(bVar.headUrl, 10, false);
                this.ixC.setData(bVar);
                String str = bVar.userName;
                if (ae.getTextLengthWithEmoji(str) > 12) {
                    str = ae.subStringWithEmoji(str, 10) + StringHelper.STRING_MORE;
                }
                this.eBQ.setText(str);
                this.ixI = bVar.ixI;
                if (bVar.ixI) {
                    ap.setViewTextColor(this.eBQ, R.color.CAM_X0301);
                }
                if (TextUtils.isEmpty(bVar.ixQ)) {
                    this.ixD.setVisibility(8);
                } else {
                    this.ixD.setVisibility(0);
                    this.ixD.setText(au.am(bVar.ixQ, 26));
                }
                if (bVar.ixS.getLevel_id() == 0) {
                    this.ixE.setVisibility(8);
                } else {
                    this.ixE.setVisibility(0);
                    ap.setImageResource(this.ixE, BitmapHelper.getGradeResourceIdInEnterForum(bVar.ixS.getLevel_id()));
                }
                if (TextUtils.isEmpty(bVar.ixR)) {
                    this.ixF.setVisibility(8);
                } else {
                    this.ixF.setVisibility(0);
                    this.ixF.setText(bVar.ixR);
                }
                if (this.akZ == null && this.mPageContext != null) {
                    this.akZ = new com.baidu.tbadk.core.view.userLike.c(this.mPageContext, this.ixG);
                    this.akZ.l(this.mPageContext.getUniqueId());
                }
                this.akZ.a(bVar.ixS);
                this.ixG.setOnClickEvent(new DynamicUserLikeButton.a() { // from class: com.baidu.tieba.enterForum.hotuserrank.c.a.1
                    @Override // com.baidu.tieba.view.DynamicUserLikeButton.a
                    public void cG(View view) {
                        if (!TextUtils.isEmpty(a.this.mCategory)) {
                            ar arVar = new ar("c13661");
                            arVar.w("uid", TbadkCoreApplication.getCurrentAccountId());
                            arVar.dY("resource_id", a.this.mCategory);
                            arVar.dY("friend_uid", bVar.rankNum);
                            arVar.al("obj_type", bVar.ixS.getIsLike() ? 2 : 1);
                            TiebaStatic.log(arVar);
                            return;
                        }
                        ar arVar2 = new ar("c13672");
                        arVar2.dY("obj_id", bVar.ixS.getUserId());
                        arVar2.w("uid", TbadkCoreApplication.getCurrentAccountId());
                        arVar2.dY("resource_id", a.this.mCategory);
                        arVar2.w("fid", a.this.mForumId);
                        arVar2.dY("friend_uid", bVar.rankNum);
                        arVar2.al("obj_type", bVar.ixS.getIsLike() ? 2 : 1);
                        TiebaStatic.log(arVar2);
                    }
                });
                if (bVar.ixS != null && bVar.ixS.getUserId() != null && bVar.ixS.getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                    this.ixG.setVisibility(8);
                } else {
                    this.ixG.setVisibility(0);
                }
                onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            }
        }

        private TbPageContext fP(Context context) {
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
                if (!this.ixI) {
                    ap.setViewTextColor(this.eBQ, R.color.CAM_X0105);
                } else {
                    ap.setViewTextColor(this.eBQ, R.color.CAM_X0301);
                }
                ap.setViewTextColor(this.ixD, R.color.CAM_X0109);
                ap.setViewTextColor(this.ixF, R.color.CAM_X0109);
                this.ixG.onChangeSkinType(this.mSkinType);
            }
        }

        public void setCategory(String str) {
            this.mCategory = str;
        }

        public void setForumId(long j) {
            this.mForumId = j;
        }

        public void yS(int i) {
            this.ixH = i;
        }

        public void cwi() {
            this.ixD.setVisibility(8);
            this.ixG.setVisibility(8);
        }
    }
}
