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
    private PbListView gdy;
    private BdRecyclerView hKW;
    private com.baidu.tieba.enterForum.hotuserrank.a ifR;
    private String mCategory;
    private long mForumId;
    private List<com.baidu.tieba.enterForum.hotuserrank.a.b> mDataList = new ArrayList();
    private BdRecyclerView.a Wj = new BdRecyclerView.a() { // from class: com.baidu.tieba.enterForum.hotuserrank.c.1
        @Override // com.baidu.adp.widget.ListView.BdRecyclerView.a
        public void a(ViewGroup viewGroup, View view, Object obj, int i, long j) {
            com.baidu.tieba.enterForum.hotuserrank.a.b bVar = (com.baidu.tieba.enterForum.hotuserrank.a.b) c.this.mDataList.get(i);
            if (bVar != null && bVar.igl != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(c.this.hKW.getContext(), bVar.igl.getUserId(), bVar.igl.getName_show())));
                if (!TextUtils.isEmpty(c.this.mCategory)) {
                    aq aqVar = new aq("c13660");
                    aqVar.w("uid", TbadkCoreApplication.getCurrentAccountId());
                    aqVar.dR("resource_id", c.this.mCategory);
                    aqVar.dR("friend_uid", bVar.rankNum);
                    TiebaStatic.log(aqVar);
                    return;
                }
                aq aqVar2 = new aq("c13668");
                aqVar2.dR("uid", bVar.igl.getUserId());
                aqVar2.w("fid", c.this.mForumId);
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
            aVar.xC(0);
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
        this.hKW = (BdRecyclerView) view;
        this.hKW.setLayoutManager(new LinearLayoutManager(view.getContext()));
        this.hKW.setAdapter(this.mAdapter);
        View inflate = LayoutInflater.from(view.getContext()).inflate(R.layout.hot_user_rank_top_user, (ViewGroup) null);
        this.ifR = new com.baidu.tieba.enterForum.hotuserrank.a(inflate, this.mCategory, this.mForumId);
        inflate.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
        this.hKW.addHeaderView(inflate);
        this.gdy = new PbListView(view.getContext());
        this.gdy.createView();
        this.gdy.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.gdy.setLineGone();
        this.gdy.setTextColor(ap.getColor(R.color.cp_cont_j));
        this.gdy.setTextSize(R.dimen.tbfontsize33);
        this.gdy.setNoMoreTextColorId(R.color.cp_cont_e);
        this.hKW.setNextPage(this.gdy);
        this.hKW.setOnItemClickListener(this.Wj);
    }

    public void b(com.baidu.tieba.enterForum.hotuserrank.a.a aVar, boolean z) {
        this.ifR.a(aVar, z);
    }

    public void cD(List<com.baidu.tieba.enterForum.hotuserrank.a.b> list) {
        if (list != null) {
            this.mDataList.clear();
            this.mDataList.addAll(list);
            this.mAdapter.notifyDataSetChanged();
        }
    }

    public void setOnSrollToBottomListener(BdListView.e eVar) {
        this.hKW.setOnSrollToBottomListener(eVar);
    }

    public void TI() {
        this.gdy.setTopExtraViewGone();
        this.gdy.startLoadData();
        this.gdy.setText(this.hKW.getContext().getString(R.string.list_loading));
        this.gdy.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
    }

    public void Jg(String str) {
        String string;
        this.gdy.pJ(l.getDimens(this.hKW.getContext(), R.dimen.tbds96));
        if (!TextUtils.isEmpty(str)) {
            string = String.format(this.hKW.getContext().getString(R.string.hot_user_rank_list_no_more), str);
        } else {
            string = this.hKW.getContext().getString(R.string.forum_hot_user_rank_list_no_more);
        }
        this.gdy.ap(string, l.getDimens(this.hKW.getContext(), R.dimen.tbds156));
        this.gdy.endLoadData();
        this.gdy.showEmptyView(l.getDimens(this.hKW.getContext(), R.dimen.tbds44));
    }

    public void onChangeSkinType(int i) {
        this.ifR.onChangeSkinType(i);
        this.mAdapter.notifyDataSetChanged();
        if (this.gdy != null) {
            this.gdy.setTextColor(ap.getColor(R.color.cp_cont_d));
            this.gdy.changeSkin(i);
        }
    }

    /* loaded from: classes22.dex */
    public static class a extends RecyclerView.ViewHolder {
        private com.baidu.tbadk.core.view.userLike.c ajW;
        private TextView eqE;
        private TextView ifT;
        private HeadImageView ifU;
        private UserHeadCoverView ifV;
        private TextView ifW;
        private ImageView ifX;
        private TextView ifY;
        private HotUserRankLikeButton ifZ;
        private int iga;
        private boolean igb;
        private String mCategory;
        private long mForumId;
        private TbPageContext mPageContext;
        private int mSkinType;

        public a(View view) {
            super(view);
            this.mSkinType = 3;
            this.mCategory = "";
            this.iga = 0;
            this.mPageContext = fj(view.getContext());
            this.ifT = (TextView) view.findViewById(R.id.rank_num);
            this.ifT.getPaint().setFakeBoldText(true);
            this.ifU = (HeadImageView) view.findViewById(R.id.head_icon);
            this.ifU.setIsRound(true);
            this.ifU.setPlaceHolder(2);
            this.ifU.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.ifV = (UserHeadCoverView) view.findViewById(R.id.head_cover);
            this.eqE = (TextView) view.findViewById(R.id.user_name);
            this.ifW = (TextView) view.findViewById(R.id.user_intro);
            this.ifX = (ImageView) view.findViewById(R.id.grade);
            this.ifY = (TextView) view.findViewById(R.id.user_influence);
            this.ifZ = (HotUserRankLikeButton) view.findViewById(R.id.like_button);
        }

        public void a(final com.baidu.tieba.enterForum.hotuserrank.a.b bVar) {
            int i;
            if (bVar != null) {
                if (!TextUtils.isEmpty(bVar.rankNum)) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.ifT.getLayoutParams();
                    int dimension = (int) this.mPageContext.getResources().getDimension(R.dimen.tbds44);
                    this.ifT.setText(bVar.rankNum);
                    if (this.iga == 1) {
                        dimension = (int) this.mPageContext.getResources().getDimension(R.dimen.tbds26);
                        layoutParams.width = (int) this.mPageContext.getResources().getDimension(R.dimen.tbds129);
                    }
                    layoutParams.setMargins(dimension, 0, 0, 0);
                    this.ifT.setLayoutParams(layoutParams);
                }
                int i2 = R.color.cp_cont_b;
                if ("1".equals(this.ifT.getText())) {
                    i = R.color.cp_other_h;
                } else if ("2".equals(this.ifT.getText())) {
                    i = R.color.cp_other_i;
                } else if ("3".equals(this.ifT.getText())) {
                    i = R.color.cp_other_j;
                } else {
                    i = R.color.cp_cont_b;
                }
                ap.setViewTextColor(this.ifT, i);
                this.ifU.startLoad(bVar.headUrl, 10, false);
                this.ifV.setData(bVar);
                String str = bVar.userName;
                if (af.getTextLengthWithEmoji(str) > 12) {
                    str = af.subStringWithEmoji(str, 10) + StringHelper.STRING_MORE;
                }
                this.eqE.setText(str);
                this.igb = bVar.igb;
                if (bVar.igb) {
                    ap.setViewTextColor(this.eqE, R.color.cp_cont_h);
                }
                if (TextUtils.isEmpty(bVar.igj)) {
                    this.ifW.setVisibility(8);
                } else {
                    this.ifW.setVisibility(0);
                    this.ifW.setText(at.ak(bVar.igj, 26));
                }
                if (bVar.igl.getLevel_id() == 0) {
                    this.ifX.setVisibility(8);
                } else {
                    this.ifX.setVisibility(0);
                    ap.setImageResource(this.ifX, BitmapHelper.getGradeResourceIdInEnterForum(bVar.igl.getLevel_id()));
                }
                if (TextUtils.isEmpty(bVar.igk)) {
                    this.ifY.setVisibility(8);
                } else {
                    this.ifY.setVisibility(0);
                    this.ifY.setText(bVar.igk);
                }
                if (this.ajW == null && this.mPageContext != null) {
                    this.ajW = new com.baidu.tbadk.core.view.userLike.c(this.mPageContext, this.ifZ);
                    this.ajW.l(this.mPageContext.getUniqueId());
                }
                this.ajW.a(bVar.igl);
                this.ifZ.setOnClickEvent(new DynamicUserLikeButton.a() { // from class: com.baidu.tieba.enterForum.hotuserrank.c.a.1
                    @Override // com.baidu.tieba.view.DynamicUserLikeButton.a
                    public void cq(View view) {
                        if (!TextUtils.isEmpty(a.this.mCategory)) {
                            aq aqVar = new aq("c13661");
                            aqVar.w("uid", TbadkCoreApplication.getCurrentAccountId());
                            aqVar.dR("resource_id", a.this.mCategory);
                            aqVar.dR("friend_uid", bVar.rankNum);
                            aqVar.aj("obj_type", bVar.igl.getIsLike() ? 2 : 1);
                            TiebaStatic.log(aqVar);
                            return;
                        }
                        aq aqVar2 = new aq("c13672");
                        aqVar2.dR("obj_id", bVar.igl.getUserId());
                        aqVar2.w("uid", TbadkCoreApplication.getCurrentAccountId());
                        aqVar2.dR("resource_id", a.this.mCategory);
                        aqVar2.w("fid", a.this.mForumId);
                        aqVar2.dR("friend_uid", bVar.rankNum);
                        aqVar2.aj("obj_type", bVar.igl.getIsLike() ? 2 : 1);
                        TiebaStatic.log(aqVar2);
                    }
                });
                if (bVar.igl != null && bVar.igl.getUserId() != null && bVar.igl.getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                    this.ifZ.setVisibility(8);
                } else {
                    this.ifZ.setVisibility(0);
                }
                onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            }
        }

        private TbPageContext fj(Context context) {
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
                if (!this.igb) {
                    ap.setViewTextColor(this.eqE, R.color.cp_cont_b);
                } else {
                    ap.setViewTextColor(this.eqE, R.color.cp_cont_h);
                }
                ap.setViewTextColor(this.ifW, R.color.cp_cont_d);
                ap.setViewTextColor(this.ifY, R.color.cp_cont_d);
                this.ifZ.onChangeSkinType(this.mSkinType);
            }
        }

        public void setCategory(String str) {
            this.mCategory = str;
        }

        public void setForumId(long j) {
            this.mForumId = j;
        }

        public void xC(int i) {
            this.iga = i;
        }

        public void cpO() {
            this.ifW.setVisibility(8);
            this.ifZ.setVisibility(8);
        }
    }
}
