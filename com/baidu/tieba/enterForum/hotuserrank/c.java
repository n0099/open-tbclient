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
    private PbListView gjo;
    private BdRecyclerView hQT;
    private com.baidu.tieba.enterForum.hotuserrank.a ilO;
    private String mCategory;
    private long mForumId;
    private List<com.baidu.tieba.enterForum.hotuserrank.a.b> mDataList = new ArrayList();
    private BdRecyclerView.a Wj = new BdRecyclerView.a() { // from class: com.baidu.tieba.enterForum.hotuserrank.c.1
        @Override // com.baidu.adp.widget.ListView.BdRecyclerView.a
        public void a(ViewGroup viewGroup, View view, Object obj, int i, long j) {
            com.baidu.tieba.enterForum.hotuserrank.a.b bVar = (com.baidu.tieba.enterForum.hotuserrank.a.b) c.this.mDataList.get(i);
            if (bVar != null && bVar.imj != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(c.this.hQT.getContext(), bVar.imj.getUserId(), bVar.imj.getName_show())));
                if (!TextUtils.isEmpty(c.this.mCategory)) {
                    aq aqVar = new aq("c13660");
                    aqVar.w("uid", TbadkCoreApplication.getCurrentAccountId());
                    aqVar.dR("resource_id", c.this.mCategory);
                    aqVar.dR("friend_uid", bVar.rankNum);
                    TiebaStatic.log(aqVar);
                    return;
                }
                aq aqVar2 = new aq("c13668");
                aqVar2.dR("uid", bVar.imj.getUserId());
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
            aVar.xP(0);
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
        this.hQT = (BdRecyclerView) view;
        this.hQT.setLayoutManager(new LinearLayoutManager(view.getContext()));
        this.hQT.setAdapter(this.mAdapter);
        View inflate = LayoutInflater.from(view.getContext()).inflate(R.layout.hot_user_rank_top_user, (ViewGroup) null);
        this.ilO = new com.baidu.tieba.enterForum.hotuserrank.a(inflate, this.mCategory, this.mForumId);
        inflate.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
        this.hQT.addHeaderView(inflate);
        this.gjo = new PbListView(view.getContext());
        this.gjo.createView();
        this.gjo.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.gjo.setLineGone();
        this.gjo.setTextColor(ap.getColor(R.color.cp_cont_j));
        this.gjo.setTextSize(R.dimen.tbfontsize33);
        this.gjo.setNoMoreTextColorId(R.color.cp_cont_e);
        this.hQT.setNextPage(this.gjo);
        this.hQT.setOnItemClickListener(this.Wj);
    }

    public void b(com.baidu.tieba.enterForum.hotuserrank.a.a aVar, boolean z) {
        this.ilO.a(aVar, z);
    }

    public void cL(List<com.baidu.tieba.enterForum.hotuserrank.a.b> list) {
        if (list != null) {
            this.mDataList.clear();
            this.mDataList.addAll(list);
            this.mAdapter.notifyDataSetChanged();
        }
    }

    public void setOnSrollToBottomListener(BdListView.e eVar) {
        this.hQT.setOnSrollToBottomListener(eVar);
    }

    public void Wi() {
        this.gjo.setTopExtraViewGone();
        this.gjo.startLoadData();
        this.gjo.setText(this.hQT.getContext().getString(R.string.list_loading));
        this.gjo.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
    }

    public void Jx(String str) {
        String string;
        this.gjo.pT(l.getDimens(this.hQT.getContext(), R.dimen.tbds96));
        if (!TextUtils.isEmpty(str)) {
            string = String.format(this.hQT.getContext().getString(R.string.hot_user_rank_list_no_more), str);
        } else {
            string = this.hQT.getContext().getString(R.string.forum_hot_user_rank_list_no_more);
        }
        this.gjo.ar(string, l.getDimens(this.hQT.getContext(), R.dimen.tbds156));
        this.gjo.endLoadData();
        this.gjo.showEmptyView(l.getDimens(this.hQT.getContext(), R.dimen.tbds44));
    }

    public void onChangeSkinType(int i) {
        this.ilO.onChangeSkinType(i);
        this.mAdapter.notifyDataSetChanged();
        if (this.gjo != null) {
            this.gjo.setTextColor(ap.getColor(R.color.cp_cont_d));
            this.gjo.changeSkin(i);
        }
    }

    /* loaded from: classes22.dex */
    public static class a extends RecyclerView.ViewHolder {
        private com.baidu.tbadk.core.view.userLike.c ajW;
        private TextView ewx;
        private TextView ilQ;
        private HeadImageView ilR;
        private UserHeadCoverView ilS;
        private TextView ilT;
        private ImageView ilU;
        private TextView ilV;
        private HotUserRankLikeButton ilW;
        private int ilX;
        private boolean ilY;
        private String mCategory;
        private long mForumId;
        private TbPageContext mPageContext;
        private int mSkinType;

        public a(View view) {
            super(view);
            this.mSkinType = 3;
            this.mCategory = "";
            this.ilX = 0;
            this.mPageContext = fj(view.getContext());
            this.ilQ = (TextView) view.findViewById(R.id.rank_num);
            this.ilQ.getPaint().setFakeBoldText(true);
            this.ilR = (HeadImageView) view.findViewById(R.id.head_icon);
            this.ilR.setIsRound(true);
            this.ilR.setPlaceHolder(2);
            this.ilR.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.ilS = (UserHeadCoverView) view.findViewById(R.id.head_cover);
            this.ewx = (TextView) view.findViewById(R.id.user_name);
            this.ilT = (TextView) view.findViewById(R.id.user_intro);
            this.ilU = (ImageView) view.findViewById(R.id.grade);
            this.ilV = (TextView) view.findViewById(R.id.user_influence);
            this.ilW = (HotUserRankLikeButton) view.findViewById(R.id.like_button);
        }

        public void a(final com.baidu.tieba.enterForum.hotuserrank.a.b bVar) {
            int i;
            if (bVar != null) {
                if (!TextUtils.isEmpty(bVar.rankNum)) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.ilQ.getLayoutParams();
                    int dimension = (int) this.mPageContext.getResources().getDimension(R.dimen.tbds44);
                    this.ilQ.setText(bVar.rankNum);
                    if (this.ilX == 1) {
                        dimension = (int) this.mPageContext.getResources().getDimension(R.dimen.tbds26);
                        layoutParams.width = (int) this.mPageContext.getResources().getDimension(R.dimen.tbds129);
                    }
                    layoutParams.setMargins(dimension, 0, 0, 0);
                    this.ilQ.setLayoutParams(layoutParams);
                }
                int i2 = R.color.cp_cont_b;
                if ("1".equals(this.ilQ.getText())) {
                    i = R.color.cp_other_h;
                } else if ("2".equals(this.ilQ.getText())) {
                    i = R.color.cp_other_i;
                } else if ("3".equals(this.ilQ.getText())) {
                    i = R.color.cp_other_j;
                } else {
                    i = R.color.cp_cont_b;
                }
                ap.setViewTextColor(this.ilQ, i);
                this.ilR.startLoad(bVar.headUrl, 10, false);
                this.ilS.setData(bVar);
                String str = bVar.userName;
                if (af.getTextLengthWithEmoji(str) > 12) {
                    str = af.subStringWithEmoji(str, 10) + StringHelper.STRING_MORE;
                }
                this.ewx.setText(str);
                this.ilY = bVar.ilY;
                if (bVar.ilY) {
                    ap.setViewTextColor(this.ewx, R.color.cp_cont_h);
                }
                if (TextUtils.isEmpty(bVar.imh)) {
                    this.ilT.setVisibility(8);
                } else {
                    this.ilT.setVisibility(0);
                    this.ilT.setText(at.am(bVar.imh, 26));
                }
                if (bVar.imj.getLevel_id() == 0) {
                    this.ilU.setVisibility(8);
                } else {
                    this.ilU.setVisibility(0);
                    ap.setImageResource(this.ilU, BitmapHelper.getGradeResourceIdInEnterForum(bVar.imj.getLevel_id()));
                }
                if (TextUtils.isEmpty(bVar.imi)) {
                    this.ilV.setVisibility(8);
                } else {
                    this.ilV.setVisibility(0);
                    this.ilV.setText(bVar.imi);
                }
                if (this.ajW == null && this.mPageContext != null) {
                    this.ajW = new com.baidu.tbadk.core.view.userLike.c(this.mPageContext, this.ilW);
                    this.ajW.l(this.mPageContext.getUniqueId());
                }
                this.ajW.a(bVar.imj);
                this.ilW.setOnClickEvent(new DynamicUserLikeButton.a() { // from class: com.baidu.tieba.enterForum.hotuserrank.c.a.1
                    @Override // com.baidu.tieba.view.DynamicUserLikeButton.a
                    public void cv(View view) {
                        if (!TextUtils.isEmpty(a.this.mCategory)) {
                            aq aqVar = new aq("c13661");
                            aqVar.w("uid", TbadkCoreApplication.getCurrentAccountId());
                            aqVar.dR("resource_id", a.this.mCategory);
                            aqVar.dR("friend_uid", bVar.rankNum);
                            aqVar.al("obj_type", bVar.imj.getIsLike() ? 2 : 1);
                            TiebaStatic.log(aqVar);
                            return;
                        }
                        aq aqVar2 = new aq("c13672");
                        aqVar2.dR("obj_id", bVar.imj.getUserId());
                        aqVar2.w("uid", TbadkCoreApplication.getCurrentAccountId());
                        aqVar2.dR("resource_id", a.this.mCategory);
                        aqVar2.w("fid", a.this.mForumId);
                        aqVar2.dR("friend_uid", bVar.rankNum);
                        aqVar2.al("obj_type", bVar.imj.getIsLike() ? 2 : 1);
                        TiebaStatic.log(aqVar2);
                    }
                });
                if (bVar.imj != null && bVar.imj.getUserId() != null && bVar.imj.getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                    this.ilW.setVisibility(8);
                } else {
                    this.ilW.setVisibility(0);
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
                if (!this.ilY) {
                    ap.setViewTextColor(this.ewx, R.color.cp_cont_b);
                } else {
                    ap.setViewTextColor(this.ewx, R.color.cp_cont_h);
                }
                ap.setViewTextColor(this.ilT, R.color.cp_cont_d);
                ap.setViewTextColor(this.ilV, R.color.cp_cont_d);
                this.ilW.onChangeSkinType(this.mSkinType);
            }
        }

        public void setCategory(String str) {
            this.mCategory = str;
        }

        public void setForumId(long j) {
            this.mForumId = j;
        }

        public void xP(int i) {
            this.ilX = i;
        }

        public void csp() {
            this.ilT.setVisibility(8);
            this.ilW.setVisibility(8);
        }
    }
}
