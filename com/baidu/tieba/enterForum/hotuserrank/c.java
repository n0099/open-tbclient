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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ar;
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
    private PbListView fnt;
    private BdRecyclerView gKg;
    private com.baidu.tieba.enterForum.hotuserrank.a heK;
    private String mCategory;
    private long mForumId;
    private List<com.baidu.tieba.enterForum.hotuserrank.a.b> mDataList = new ArrayList();
    private BdRecyclerView.a Vc = new BdRecyclerView.a() { // from class: com.baidu.tieba.enterForum.hotuserrank.c.1
        @Override // com.baidu.adp.widget.ListView.BdRecyclerView.a
        public void a(ViewGroup viewGroup, View view, Object obj, int i, long j) {
            com.baidu.tieba.enterForum.hotuserrank.a.b bVar = (com.baidu.tieba.enterForum.hotuserrank.a.b) c.this.mDataList.get(i);
            if (bVar != null && bVar.hfg != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(c.this.gKg.getContext(), bVar.hfg.getUserId(), bVar.hfg.getName_show())));
                if (!TextUtils.isEmpty(c.this.mCategory)) {
                    ao aoVar = new ao("c13660");
                    aoVar.s("uid", TbadkCoreApplication.getCurrentAccountId());
                    aoVar.dk("resource_id", c.this.mCategory);
                    aoVar.dk("friend_uid", bVar.rankNum);
                    TiebaStatic.log(aoVar);
                    return;
                }
                ao aoVar2 = new ao("c13668");
                aoVar2.dk("uid", bVar.hfg.getUserId());
                aoVar2.s("fid", c.this.mForumId);
                TiebaStatic.log(aoVar2);
            }
        }
    };
    private RecyclerView.Adapter mAdapter = new RecyclerView.Adapter<a>() { // from class: com.baidu.tieba.enterForum.hotuserrank.c.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.support.v7.widget.RecyclerView.Adapter
        /* renamed from: r */
        public a onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            a aVar = new a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.hot_user_rank_item_view, (ViewGroup) null));
            aVar.tx(0);
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
        this.gKg = (BdRecyclerView) view;
        this.gKg.setLayoutManager(new LinearLayoutManager(view.getContext()));
        this.gKg.setAdapter(this.mAdapter);
        View inflate = LayoutInflater.from(view.getContext()).inflate(R.layout.hot_user_rank_top_user, (ViewGroup) null);
        this.heK = new com.baidu.tieba.enterForum.hotuserrank.a(inflate, this.mCategory, this.mForumId);
        inflate.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
        this.gKg.addHeaderView(inflate);
        this.fnt = new PbListView(view.getContext());
        this.fnt.createView();
        this.fnt.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.fnt.setLineGone();
        this.fnt.setTextColor(an.getColor(R.color.cp_cont_j));
        this.fnt.setTextSize(R.dimen.tbfontsize33);
        this.fnt.setNoMoreTextColorId(R.color.cp_cont_e);
        this.gKg.setNextPage(this.fnt);
        this.gKg.setOnItemClickListener(this.Vc);
    }

    public void b(com.baidu.tieba.enterForum.hotuserrank.a.a aVar, boolean z) {
        this.heK.a(aVar, z);
    }

    public void ce(List<com.baidu.tieba.enterForum.hotuserrank.a.b> list) {
        if (list != null) {
            this.mDataList.clear();
            this.mDataList.addAll(list);
            this.mAdapter.notifyDataSetChanged();
        }
    }

    public void setOnSrollToBottomListener(BdListView.e eVar) {
        this.gKg.setOnSrollToBottomListener(eVar);
    }

    public void buI() {
        this.fnt.setTopExtraViewGone();
        this.fnt.startLoadData();
        this.fnt.setText(this.gKg.getContext().getString(R.string.list_loading));
        this.fnt.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
    }

    public void Em(String str) {
        String string;
        this.fnt.mp(l.getDimens(this.gKg.getContext(), R.dimen.tbds96));
        if (!TextUtils.isEmpty(str)) {
            string = String.format(this.gKg.getContext().getString(R.string.hot_user_rank_list_no_more), str);
        } else {
            string = this.gKg.getContext().getString(R.string.forum_hot_user_rank_list_no_more);
        }
        this.fnt.am(string, l.getDimens(this.gKg.getContext(), R.dimen.tbds156));
        this.fnt.endLoadData();
        this.fnt.showEmptyView(l.getDimens(this.gKg.getContext(), R.dimen.tbds44));
    }

    public void onChangeSkinType(int i) {
        this.heK.onChangeSkinType(i);
        this.mAdapter.notifyDataSetChanged();
        if (this.fnt != null) {
            this.fnt.setTextColor(an.getColor(R.color.cp_cont_d));
            this.fnt.changeSkin(i);
        }
    }

    /* loaded from: classes9.dex */
    public static class a extends RecyclerView.ViewHolder {
        private com.baidu.tbadk.core.view.userLike.c ahX;
        private TextView dEL;
        private TextView heM;
        private HeadImageView heN;
        private UserHeadCoverView heO;
        private TextView heP;
        private ImageView heQ;
        private TextView heR;
        private HotUserRankLikeButton heS;
        private int heT;
        private boolean heU;
        private String mCategory;
        private long mForumId;
        private TbPageContext mPageContext;
        private int mSkinType;

        public a(View view) {
            super(view);
            this.mSkinType = 3;
            this.mCategory = "";
            this.heT = 0;
            this.mPageContext = eH(view.getContext());
            this.heM = (TextView) view.findViewById(R.id.rank_num);
            this.heM.getPaint().setFakeBoldText(true);
            this.heN = (HeadImageView) view.findViewById(R.id.head_icon);
            this.heN.setIsRound(true);
            this.heN.setPlaceHolder(2);
            this.heN.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.heO = (UserHeadCoverView) view.findViewById(R.id.head_cover);
            this.dEL = (TextView) view.findViewById(R.id.user_name);
            this.heP = (TextView) view.findViewById(R.id.user_intro);
            this.heQ = (ImageView) view.findViewById(R.id.grade);
            this.heR = (TextView) view.findViewById(R.id.user_influence);
            this.heS = (HotUserRankLikeButton) view.findViewById(R.id.like_button);
        }

        public void a(final com.baidu.tieba.enterForum.hotuserrank.a.b bVar) {
            int i;
            if (bVar != null) {
                if (!TextUtils.isEmpty(bVar.rankNum)) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.heM.getLayoutParams();
                    int dimension = (int) this.mPageContext.getResources().getDimension(R.dimen.tbds44);
                    this.heM.setText(bVar.rankNum);
                    if (this.heT == 1) {
                        dimension = (int) this.mPageContext.getResources().getDimension(R.dimen.tbds26);
                        layoutParams.width = (int) this.mPageContext.getResources().getDimension(R.dimen.tbds129);
                    }
                    layoutParams.setMargins(dimension, 0, 0, 0);
                    this.heM.setLayoutParams(layoutParams);
                }
                if ("1".equals(this.heM.getText())) {
                    i = R.color.cp_other_h;
                } else if ("2".equals(this.heM.getText())) {
                    i = R.color.cp_other_i;
                } else if ("3".equals(this.heM.getText())) {
                    i = R.color.cp_other_j;
                } else {
                    i = R.color.cp_cont_b;
                }
                an.setViewTextColor(this.heM, i);
                this.heN.startLoad(bVar.hfd, 10, false);
                this.heO.setData(bVar);
                String str = bVar.userName;
                if (ae.getTextLengthWithEmoji(str) > 12) {
                    str = ae.subStringWithEmoji(str, 10) + StringHelper.STRING_MORE;
                }
                this.dEL.setText(str);
                this.heU = bVar.heU;
                if (bVar.heU) {
                    an.setViewTextColor(this.dEL, (int) R.color.cp_cont_h);
                }
                if (TextUtils.isEmpty(bVar.hfe)) {
                    this.heP.setVisibility(8);
                } else {
                    this.heP.setVisibility(0);
                    this.heP.setText(ar.ah(bVar.hfe, 26));
                }
                if (bVar.hfg.getLevel_id() == 0) {
                    this.heQ.setVisibility(8);
                } else {
                    this.heQ.setVisibility(0);
                    an.setImageResource(this.heQ, BitmapHelper.getGradeResourceIdInEnterForum(bVar.hfg.getLevel_id()));
                }
                if (TextUtils.isEmpty(bVar.hff)) {
                    this.heR.setVisibility(8);
                } else {
                    this.heR.setVisibility(0);
                    this.heR.setText(bVar.hff);
                }
                if (this.ahX == null && this.mPageContext != null) {
                    this.ahX = new com.baidu.tbadk.core.view.userLike.c(this.mPageContext, this.heS);
                    this.ahX.l(this.mPageContext.getUniqueId());
                }
                this.ahX.a(bVar.hfg);
                this.heS.setOnClickEvent(new DynamicUserLikeButton.a() { // from class: com.baidu.tieba.enterForum.hotuserrank.c.a.1
                    @Override // com.baidu.tieba.view.DynamicUserLikeButton.a
                    public void bR(View view) {
                        if (!TextUtils.isEmpty(a.this.mCategory)) {
                            ao aoVar = new ao("c13661");
                            aoVar.s("uid", TbadkCoreApplication.getCurrentAccountId());
                            aoVar.dk("resource_id", a.this.mCategory);
                            aoVar.dk("friend_uid", bVar.rankNum);
                            aoVar.ag("obj_type", bVar.hfg.getIsLike() ? 2 : 1);
                            TiebaStatic.log(aoVar);
                            return;
                        }
                        ao aoVar2 = new ao("c13672");
                        aoVar2.dk("obj_id", bVar.hfg.getUserId());
                        aoVar2.s("uid", TbadkCoreApplication.getCurrentAccountId());
                        aoVar2.dk("resource_id", a.this.mCategory);
                        aoVar2.s("fid", a.this.mForumId);
                        aoVar2.dk("friend_uid", bVar.rankNum);
                        aoVar2.ag("obj_type", bVar.hfg.getIsLike() ? 2 : 1);
                        TiebaStatic.log(aoVar2);
                    }
                });
                if (bVar.hfg != null && bVar.hfg.getUserId() != null && bVar.hfg.getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                    this.heS.setVisibility(8);
                } else {
                    this.heS.setVisibility(0);
                }
                onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            }
        }

        private TbPageContext eH(Context context) {
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
                if (!this.heU) {
                    an.setViewTextColor(this.dEL, (int) R.color.cp_cont_b);
                } else {
                    an.setViewTextColor(this.dEL, (int) R.color.cp_cont_h);
                }
                an.setViewTextColor(this.heP, (int) R.color.cp_cont_d);
                an.setViewTextColor(this.heR, (int) R.color.cp_cont_d);
                this.heS.onChangeSkinType(this.mSkinType);
            }
        }

        public void setCategory(String str) {
            this.mCategory = str;
        }

        public void setForumId(long j) {
            this.mForumId = j;
        }

        public void tx(int i) {
            this.heT = i;
        }

        public void bSo() {
            this.heP.setVisibility(8);
            this.heS.setVisibility(8);
        }
    }
}
