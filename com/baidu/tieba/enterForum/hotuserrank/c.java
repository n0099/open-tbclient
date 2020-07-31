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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.util.ae;
import com.baidu.tieba.R;
import com.baidu.tieba.enterForum.hotuserrank.view.HotUserRankLikeButton;
import com.baidu.tieba.enterForum.hotuserrank.view.UserHeadCoverView;
import com.baidu.tieba.view.DynamicUserLikeButton;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes16.dex */
public class c {
    private PbListView fsC;
    private BdRecyclerView gPM;
    private com.baidu.tieba.enterForum.hotuserrank.a hku;
    private String mCategory;
    private long mForumId;
    private List<com.baidu.tieba.enterForum.hotuserrank.a.b> mDataList = new ArrayList();
    private BdRecyclerView.a UW = new BdRecyclerView.a() { // from class: com.baidu.tieba.enterForum.hotuserrank.c.1
        @Override // com.baidu.adp.widget.ListView.BdRecyclerView.a
        public void a(ViewGroup viewGroup, View view, Object obj, int i, long j) {
            com.baidu.tieba.enterForum.hotuserrank.a.b bVar = (com.baidu.tieba.enterForum.hotuserrank.a.b) c.this.mDataList.get(i);
            if (bVar != null && bVar.hkQ != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(c.this.gPM.getContext(), bVar.hkQ.getUserId(), bVar.hkQ.getName_show())));
                if (!TextUtils.isEmpty(c.this.mCategory)) {
                    ap apVar = new ap("c13660");
                    apVar.t("uid", TbadkCoreApplication.getCurrentAccountId());
                    apVar.dn("resource_id", c.this.mCategory);
                    apVar.dn("friend_uid", bVar.rankNum);
                    TiebaStatic.log(apVar);
                    return;
                }
                ap apVar2 = new ap("c13668");
                apVar2.dn("uid", bVar.hkQ.getUserId());
                apVar2.t("fid", c.this.mForumId);
                TiebaStatic.log(apVar2);
            }
        }
    };
    private RecyclerView.Adapter mAdapter = new RecyclerView.Adapter<a>() { // from class: com.baidu.tieba.enterForum.hotuserrank.c.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.support.v7.widget.RecyclerView.Adapter
        /* renamed from: r */
        public a onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            a aVar = new a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.hot_user_rank_item_view, (ViewGroup) null));
            aVar.tP(0);
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
        this.gPM = (BdRecyclerView) view;
        this.gPM.setLayoutManager(new LinearLayoutManager(view.getContext()));
        this.gPM.setAdapter(this.mAdapter);
        View inflate = LayoutInflater.from(view.getContext()).inflate(R.layout.hot_user_rank_top_user, (ViewGroup) null);
        this.hku = new com.baidu.tieba.enterForum.hotuserrank.a(inflate, this.mCategory, this.mForumId);
        inflate.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
        this.gPM.addHeaderView(inflate);
        this.fsC = new PbListView(view.getContext());
        this.fsC.createView();
        this.fsC.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.fsC.setLineGone();
        this.fsC.setTextColor(ao.getColor(R.color.cp_cont_j));
        this.fsC.setTextSize(R.dimen.tbfontsize33);
        this.fsC.setNoMoreTextColorId(R.color.cp_cont_e);
        this.gPM.setNextPage(this.fsC);
        this.gPM.setOnItemClickListener(this.UW);
    }

    public void b(com.baidu.tieba.enterForum.hotuserrank.a.a aVar, boolean z) {
        this.hku.a(aVar, z);
    }

    public void cj(List<com.baidu.tieba.enterForum.hotuserrank.a.b> list) {
        if (list != null) {
            this.mDataList.clear();
            this.mDataList.addAll(list);
            this.mAdapter.notifyDataSetChanged();
        }
    }

    public void setOnSrollToBottomListener(BdListView.e eVar) {
        this.gPM.setOnSrollToBottomListener(eVar);
    }

    public void bxS() {
        this.fsC.setTopExtraViewGone();
        this.fsC.startLoadData();
        this.fsC.setText(this.gPM.getContext().getString(R.string.list_loading));
        this.fsC.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
    }

    public void EX(String str) {
        String string;
        this.fsC.mI(l.getDimens(this.gPM.getContext(), R.dimen.tbds96));
        if (!TextUtils.isEmpty(str)) {
            string = String.format(this.gPM.getContext().getString(R.string.hot_user_rank_list_no_more), str);
        } else {
            string = this.gPM.getContext().getString(R.string.forum_hot_user_rank_list_no_more);
        }
        this.fsC.an(string, l.getDimens(this.gPM.getContext(), R.dimen.tbds156));
        this.fsC.endLoadData();
        this.fsC.showEmptyView(l.getDimens(this.gPM.getContext(), R.dimen.tbds44));
    }

    public void onChangeSkinType(int i) {
        this.hku.onChangeSkinType(i);
        this.mAdapter.notifyDataSetChanged();
        if (this.fsC != null) {
            this.fsC.setTextColor(ao.getColor(R.color.cp_cont_d));
            this.fsC.changeSkin(i);
        }
    }

    /* loaded from: classes16.dex */
    public static class a extends RecyclerView.ViewHolder {
        private com.baidu.tbadk.core.view.userLike.c ahO;
        private TextView dKI;
        private ImageView hkA;
        private TextView hkB;
        private HotUserRankLikeButton hkC;
        private int hkD;
        private boolean hkE;
        private TextView hkw;
        private HeadImageView hkx;
        private UserHeadCoverView hky;
        private TextView hkz;
        private String mCategory;
        private long mForumId;
        private TbPageContext mPageContext;
        private int mSkinType;

        public a(View view) {
            super(view);
            this.mSkinType = 3;
            this.mCategory = "";
            this.hkD = 0;
            this.mPageContext = eL(view.getContext());
            this.hkw = (TextView) view.findViewById(R.id.rank_num);
            this.hkw.getPaint().setFakeBoldText(true);
            this.hkx = (HeadImageView) view.findViewById(R.id.head_icon);
            this.hkx.setIsRound(true);
            this.hkx.setPlaceHolder(2);
            this.hkx.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.hky = (UserHeadCoverView) view.findViewById(R.id.head_cover);
            this.dKI = (TextView) view.findViewById(R.id.user_name);
            this.hkz = (TextView) view.findViewById(R.id.user_intro);
            this.hkA = (ImageView) view.findViewById(R.id.grade);
            this.hkB = (TextView) view.findViewById(R.id.user_influence);
            this.hkC = (HotUserRankLikeButton) view.findViewById(R.id.like_button);
        }

        public void a(final com.baidu.tieba.enterForum.hotuserrank.a.b bVar) {
            int i;
            if (bVar != null) {
                if (!TextUtils.isEmpty(bVar.rankNum)) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hkw.getLayoutParams();
                    int dimension = (int) this.mPageContext.getResources().getDimension(R.dimen.tbds44);
                    this.hkw.setText(bVar.rankNum);
                    if (this.hkD == 1) {
                        dimension = (int) this.mPageContext.getResources().getDimension(R.dimen.tbds26);
                        layoutParams.width = (int) this.mPageContext.getResources().getDimension(R.dimen.tbds129);
                    }
                    layoutParams.setMargins(dimension, 0, 0, 0);
                    this.hkw.setLayoutParams(layoutParams);
                }
                int i2 = R.color.cp_cont_b;
                if ("1".equals(this.hkw.getText())) {
                    i = R.color.cp_other_h;
                } else if ("2".equals(this.hkw.getText())) {
                    i = R.color.cp_other_i;
                } else if ("3".equals(this.hkw.getText())) {
                    i = R.color.cp_other_j;
                } else {
                    i = R.color.cp_cont_b;
                }
                ao.setViewTextColor(this.hkw, i);
                this.hkx.startLoad(bVar.hkN, 10, false);
                this.hky.setData(bVar);
                String str = bVar.userName;
                if (ae.getTextLengthWithEmoji(str) > 12) {
                    str = ae.subStringWithEmoji(str, 10) + StringHelper.STRING_MORE;
                }
                this.dKI.setText(str);
                this.hkE = bVar.hkE;
                if (bVar.hkE) {
                    ao.setViewTextColor(this.dKI, R.color.cp_cont_h);
                }
                if (TextUtils.isEmpty(bVar.hkO)) {
                    this.hkz.setVisibility(8);
                } else {
                    this.hkz.setVisibility(0);
                    this.hkz.setText(as.ai(bVar.hkO, 26));
                }
                if (bVar.hkQ.getLevel_id() == 0) {
                    this.hkA.setVisibility(8);
                } else {
                    this.hkA.setVisibility(0);
                    ao.setImageResource(this.hkA, BitmapHelper.getGradeResourceIdInEnterForum(bVar.hkQ.getLevel_id()));
                }
                if (TextUtils.isEmpty(bVar.hkP)) {
                    this.hkB.setVisibility(8);
                } else {
                    this.hkB.setVisibility(0);
                    this.hkB.setText(bVar.hkP);
                }
                if (this.ahO == null && this.mPageContext != null) {
                    this.ahO = new com.baidu.tbadk.core.view.userLike.c(this.mPageContext, this.hkC);
                    this.ahO.m(this.mPageContext.getUniqueId());
                }
                this.ahO.a(bVar.hkQ);
                this.hkC.setOnClickEvent(new DynamicUserLikeButton.a() { // from class: com.baidu.tieba.enterForum.hotuserrank.c.a.1
                    @Override // com.baidu.tieba.view.DynamicUserLikeButton.a
                    public void bX(View view) {
                        if (!TextUtils.isEmpty(a.this.mCategory)) {
                            ap apVar = new ap("c13661");
                            apVar.t("uid", TbadkCoreApplication.getCurrentAccountId());
                            apVar.dn("resource_id", a.this.mCategory);
                            apVar.dn("friend_uid", bVar.rankNum);
                            apVar.ah("obj_type", bVar.hkQ.getIsLike() ? 2 : 1);
                            TiebaStatic.log(apVar);
                            return;
                        }
                        ap apVar2 = new ap("c13672");
                        apVar2.dn("obj_id", bVar.hkQ.getUserId());
                        apVar2.t("uid", TbadkCoreApplication.getCurrentAccountId());
                        apVar2.dn("resource_id", a.this.mCategory);
                        apVar2.t("fid", a.this.mForumId);
                        apVar2.dn("friend_uid", bVar.rankNum);
                        apVar2.ah("obj_type", bVar.hkQ.getIsLike() ? 2 : 1);
                        TiebaStatic.log(apVar2);
                    }
                });
                if (bVar.hkQ != null && bVar.hkQ.getUserId() != null && bVar.hkQ.getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                    this.hkC.setVisibility(8);
                } else {
                    this.hkC.setVisibility(0);
                }
                onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            }
        }

        private TbPageContext eL(Context context) {
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
                if (!this.hkE) {
                    ao.setViewTextColor(this.dKI, R.color.cp_cont_b);
                } else {
                    ao.setViewTextColor(this.dKI, R.color.cp_cont_h);
                }
                ao.setViewTextColor(this.hkz, R.color.cp_cont_d);
                ao.setViewTextColor(this.hkB, R.color.cp_cont_d);
                this.hkC.onChangeSkinType(this.mSkinType);
            }
        }

        public void setCategory(String str) {
            this.mCategory = str;
        }

        public void setForumId(long j) {
            this.mForumId = j;
        }

        public void tP(int i) {
            this.hkD = i;
        }

        public void bVG() {
            this.hkz.setVisibility(8);
            this.hkC.setVisibility(8);
        }
    }
}
