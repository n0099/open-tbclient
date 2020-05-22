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
    private PbListView fbY;
    private com.baidu.tieba.enterForum.hotuserrank.a gRQ;
    private BdRecyclerView gxh;
    private String mCategory;
    private long mForumId;
    private List<com.baidu.tieba.enterForum.hotuserrank.a.b> mDataList = new ArrayList();
    private BdRecyclerView.a Uw = new BdRecyclerView.a() { // from class: com.baidu.tieba.enterForum.hotuserrank.c.1
        @Override // com.baidu.adp.widget.ListView.BdRecyclerView.a
        public void a(ViewGroup viewGroup, View view, Object obj, int i, long j) {
            com.baidu.tieba.enterForum.hotuserrank.a.b bVar = (com.baidu.tieba.enterForum.hotuserrank.a.b) c.this.mDataList.get(i);
            if (bVar != null && bVar.gSm != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(c.this.gxh.getContext(), bVar.gSm.getUserId(), bVar.gSm.getName_show())));
                if (!TextUtils.isEmpty(c.this.mCategory)) {
                    an anVar = new an("c13660");
                    anVar.s("uid", TbadkCoreApplication.getCurrentAccountId());
                    anVar.dh("resource_id", c.this.mCategory);
                    anVar.dh("friend_uid", bVar.rankNum);
                    TiebaStatic.log(anVar);
                    return;
                }
                an anVar2 = new an("c13668");
                anVar2.dh("uid", bVar.gSm.getUserId());
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
            aVar.sU(0);
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
        this.gxh = (BdRecyclerView) view;
        this.gxh.setLayoutManager(new LinearLayoutManager(view.getContext()));
        this.gxh.setAdapter(this.mAdapter);
        View inflate = LayoutInflater.from(view.getContext()).inflate(R.layout.hot_user_rank_top_user, (ViewGroup) null);
        this.gRQ = new com.baidu.tieba.enterForum.hotuserrank.a(inflate, this.mCategory, this.mForumId);
        inflate.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
        this.gxh.addHeaderView(inflate);
        this.fbY = new PbListView(view.getContext());
        this.fbY.createView();
        this.fbY.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.fbY.setLineGone();
        this.fbY.setTextColor(am.getColor(R.color.cp_cont_j));
        this.fbY.setTextSize(R.dimen.tbfontsize33);
        this.fbY.setNoMoreTextColorId(R.color.cp_cont_e);
        this.gxh.setNextPage(this.fbY);
        this.gxh.setOnItemClickListener(this.Uw);
    }

    public void b(com.baidu.tieba.enterForum.hotuserrank.a.a aVar, boolean z) {
        this.gRQ.a(aVar, z);
    }

    public void bV(List<com.baidu.tieba.enterForum.hotuserrank.a.b> list) {
        if (list != null) {
            this.mDataList.clear();
            this.mDataList.addAll(list);
            this.mAdapter.notifyDataSetChanged();
        }
    }

    public void setOnSrollToBottomListener(BdListView.e eVar) {
        this.gxh.setOnSrollToBottomListener(eVar);
    }

    public void brK() {
        this.fbY.setTopExtraViewGone();
        this.fbY.startLoadData();
        this.fbY.setText(this.gxh.getContext().getString(R.string.list_loading));
        this.fbY.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
    }

    public void DL(String str) {
        String string;
        this.fbY.lW(l.getDimens(this.gxh.getContext(), R.dimen.tbds96));
        if (!TextUtils.isEmpty(str)) {
            string = String.format(this.gxh.getContext().getString(R.string.hot_user_rank_list_no_more), str);
        } else {
            string = this.gxh.getContext().getString(R.string.forum_hot_user_rank_list_no_more);
        }
        this.fbY.am(string, l.getDimens(this.gxh.getContext(), R.dimen.tbds156));
        this.fbY.endLoadData();
        this.fbY.showEmptyView(l.getDimens(this.gxh.getContext(), R.dimen.tbds44));
    }

    public void onChangeSkinType(int i) {
        this.gRQ.onChangeSkinType(i);
        this.mAdapter.notifyDataSetChanged();
        if (this.fbY != null) {
            this.fbY.setTextColor(am.getColor(R.color.cp_cont_d));
            this.fbY.changeSkin(i);
        }
    }

    /* loaded from: classes9.dex */
    public static class a extends RecyclerView.ViewHolder {
        private com.baidu.tbadk.core.view.userLike.c agS;
        private TextView dXU;
        private TextView gRS;
        private HeadImageView gRT;
        private UserHeadCoverView gRU;
        private TextView gRV;
        private ImageView gRW;
        private TextView gRX;
        private HotUserRankLikeButton gRY;
        private int gRZ;
        private boolean gSa;
        private String mCategory;
        private long mForumId;
        private TbPageContext mPageContext;
        private int mSkinType;

        public a(View view) {
            super(view);
            this.mSkinType = 3;
            this.mCategory = "";
            this.gRZ = 0;
            this.mPageContext = eG(view.getContext());
            this.gRS = (TextView) view.findViewById(R.id.rank_num);
            this.gRS.getPaint().setFakeBoldText(true);
            this.gRT = (HeadImageView) view.findViewById(R.id.head_icon);
            this.gRT.setIsRound(true);
            this.gRT.setPlaceHolder(2);
            this.gRT.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.gRU = (UserHeadCoverView) view.findViewById(R.id.head_cover);
            this.dXU = (TextView) view.findViewById(R.id.user_name);
            this.gRV = (TextView) view.findViewById(R.id.user_intro);
            this.gRW = (ImageView) view.findViewById(R.id.grade);
            this.gRX = (TextView) view.findViewById(R.id.user_influence);
            this.gRY = (HotUserRankLikeButton) view.findViewById(R.id.like_button);
        }

        public void a(final com.baidu.tieba.enterForum.hotuserrank.a.b bVar) {
            int i;
            if (bVar != null) {
                if (!TextUtils.isEmpty(bVar.rankNum)) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gRS.getLayoutParams();
                    int dimension = (int) this.mPageContext.getResources().getDimension(R.dimen.tbds44);
                    this.gRS.setText(bVar.rankNum);
                    if (this.gRZ == 1) {
                        dimension = (int) this.mPageContext.getResources().getDimension(R.dimen.tbds26);
                        layoutParams.width = (int) this.mPageContext.getResources().getDimension(R.dimen.tbds129);
                    }
                    layoutParams.setMargins(dimension, 0, 0, 0);
                    this.gRS.setLayoutParams(layoutParams);
                }
                if ("1".equals(this.gRS.getText())) {
                    i = R.color.cp_other_h;
                } else if ("2".equals(this.gRS.getText())) {
                    i = R.color.cp_other_i;
                } else if ("3".equals(this.gRS.getText())) {
                    i = R.color.cp_other_j;
                } else {
                    i = R.color.cp_cont_b;
                }
                am.setViewTextColor(this.gRS, i);
                this.gRT.startLoad(bVar.gSj, 10, false);
                this.gRU.setData(bVar);
                String str = bVar.userName;
                if (ae.getTextLengthWithEmoji(str) > 12) {
                    str = ae.subStringWithEmoji(str, 10) + StringHelper.STRING_MORE;
                }
                this.dXU.setText(str);
                this.gSa = bVar.gSa;
                if (bVar.gSa) {
                    am.setViewTextColor(this.dXU, (int) R.color.cp_cont_h);
                }
                if (TextUtils.isEmpty(bVar.gSk)) {
                    this.gRV.setVisibility(8);
                } else {
                    this.gRV.setVisibility(0);
                    this.gRV.setText(aq.ah(bVar.gSk, 26));
                }
                if (bVar.gSm.getLevel_id() == 0) {
                    this.gRW.setVisibility(8);
                } else {
                    this.gRW.setVisibility(0);
                    am.setImageResource(this.gRW, BitmapHelper.getGradeResourceIdInEnterForum(bVar.gSm.getLevel_id()));
                }
                if (TextUtils.isEmpty(bVar.gSl)) {
                    this.gRX.setVisibility(8);
                } else {
                    this.gRX.setVisibility(0);
                    this.gRX.setText(bVar.gSl);
                }
                if (this.agS == null && this.mPageContext != null) {
                    this.agS = new com.baidu.tbadk.core.view.userLike.c(this.mPageContext, this.gRY);
                    this.agS.l(this.mPageContext.getUniqueId());
                }
                this.agS.a(bVar.gSm);
                this.gRY.setOnClickEvent(new DynamicUserLikeButton.a() { // from class: com.baidu.tieba.enterForum.hotuserrank.c.a.1
                    @Override // com.baidu.tieba.view.DynamicUserLikeButton.a
                    public void bO(View view) {
                        if (!TextUtils.isEmpty(a.this.mCategory)) {
                            an anVar = new an("c13661");
                            anVar.s("uid", TbadkCoreApplication.getCurrentAccountId());
                            anVar.dh("resource_id", a.this.mCategory);
                            anVar.dh("friend_uid", bVar.rankNum);
                            anVar.ag("obj_type", bVar.gSm.getIsLike() ? 2 : 1);
                            TiebaStatic.log(anVar);
                            return;
                        }
                        an anVar2 = new an("c13672");
                        anVar2.dh("obj_id", bVar.gSm.getUserId());
                        anVar2.s("uid", TbadkCoreApplication.getCurrentAccountId());
                        anVar2.dh("resource_id", a.this.mCategory);
                        anVar2.s("fid", a.this.mForumId);
                        anVar2.dh("friend_uid", bVar.rankNum);
                        anVar2.ag("obj_type", bVar.gSm.getIsLike() ? 2 : 1);
                        TiebaStatic.log(anVar2);
                    }
                });
                if (bVar.gSm != null && bVar.gSm.getUserId() != null && bVar.gSm.getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                    this.gRY.setVisibility(8);
                } else {
                    this.gRY.setVisibility(0);
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
                if (!this.gSa) {
                    am.setViewTextColor(this.dXU, (int) R.color.cp_cont_b);
                } else {
                    am.setViewTextColor(this.dXU, (int) R.color.cp_cont_h);
                }
                am.setViewTextColor(this.gRV, (int) R.color.cp_cont_d);
                am.setViewTextColor(this.gRX, (int) R.color.cp_cont_d);
                this.gRY.onChangeSkinType(this.mSkinType);
            }
        }

        public void setCategory(String str) {
            this.mCategory = str;
        }

        public void setForumId(long j) {
            this.mForumId = j;
        }

        public void sU(int i) {
            this.gRZ = i;
        }

        public void bPj() {
            this.gRV.setVisibility(8);
            this.gRY.setVisibility(8);
        }
    }
}
