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
/* loaded from: classes21.dex */
public class c {
    private PbListView giV;
    private BdRecyclerView hRt;
    private com.baidu.tieba.enterForum.hotuserrank.a imD;
    private String mCategory;
    private long mForumId;
    private List<com.baidu.tieba.enterForum.hotuserrank.a.b> mDataList = new ArrayList();
    private BdRecyclerView.a Wn = new BdRecyclerView.a() { // from class: com.baidu.tieba.enterForum.hotuserrank.c.1
        @Override // com.baidu.adp.widget.ListView.BdRecyclerView.a
        public void a(ViewGroup viewGroup, View view, Object obj, int i, long j) {
            com.baidu.tieba.enterForum.hotuserrank.a.b bVar = (com.baidu.tieba.enterForum.hotuserrank.a.b) c.this.mDataList.get(i);
            if (bVar != null && bVar.imX != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(c.this.hRt.getContext(), bVar.imX.getUserId(), bVar.imX.getName_show())));
                if (!TextUtils.isEmpty(c.this.mCategory)) {
                    ar arVar = new ar("c13660");
                    arVar.w("uid", TbadkCoreApplication.getCurrentAccountId());
                    arVar.dR("resource_id", c.this.mCategory);
                    arVar.dR("friend_uid", bVar.rankNum);
                    TiebaStatic.log(arVar);
                    return;
                }
                ar arVar2 = new ar("c13668");
                arVar2.dR("uid", bVar.imX.getUserId());
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
            aVar.yn(0);
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
        this.hRt = (BdRecyclerView) view;
        this.hRt.setLayoutManager(new LinearLayoutManager(view.getContext()));
        this.hRt.setAdapter(this.mAdapter);
        View inflate = LayoutInflater.from(view.getContext()).inflate(R.layout.hot_user_rank_top_user, (ViewGroup) null);
        this.imD = new com.baidu.tieba.enterForum.hotuserrank.a(inflate, this.mCategory, this.mForumId);
        inflate.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
        this.hRt.addHeaderView(inflate);
        this.giV = new PbListView(view.getContext());
        this.giV.createView();
        this.giV.setContainerBackgroundColorResId(R.color.CAM_X0205);
        this.giV.setLineGone();
        this.giV.setTextColor(ap.getColor(R.color.CAM_X0107));
        this.giV.setTextSize(R.dimen.tbfontsize33);
        this.giV.setNoMoreTextColorId(R.color.CAM_X0110);
        this.hRt.setNextPage(this.giV);
        this.hRt.setOnItemClickListener(this.Wn);
    }

    public void b(com.baidu.tieba.enterForum.hotuserrank.a.a aVar, boolean z) {
        this.imD.a(aVar, z);
    }

    public void cL(List<com.baidu.tieba.enterForum.hotuserrank.a.b> list) {
        if (list != null) {
            this.mDataList.clear();
            this.mDataList.addAll(list);
            this.mAdapter.notifyDataSetChanged();
        }
    }

    public void setOnSrollToBottomListener(BdListView.e eVar) {
        this.hRt.setOnSrollToBottomListener(eVar);
    }

    public void Vz() {
        this.giV.setTopExtraViewGone();
        this.giV.startLoadData();
        this.giV.setText(this.hRt.getContext().getString(R.string.list_loading));
        this.giV.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
    }

    public void IY(String str) {
        String string;
        this.giV.qr(l.getDimens(this.hRt.getContext(), R.dimen.tbds96));
        if (!TextUtils.isEmpty(str)) {
            string = String.format(this.hRt.getContext().getString(R.string.hot_user_rank_list_no_more), str);
        } else {
            string = this.hRt.getContext().getString(R.string.forum_hot_user_rank_list_no_more);
        }
        this.giV.aq(string, l.getDimens(this.hRt.getContext(), R.dimen.tbds156));
        this.giV.endLoadData();
        this.giV.showEmptyView(l.getDimens(this.hRt.getContext(), R.dimen.tbds44));
    }

    public void onChangeSkinType(int i) {
        this.imD.onChangeSkinType(i);
        this.mAdapter.notifyDataSetChanged();
        if (this.giV != null) {
            this.giV.setTextColor(ap.getColor(R.color.CAM_X0109));
            this.giV.changeSkin(i);
        }
    }

    /* loaded from: classes21.dex */
    public static class a extends RecyclerView.ViewHolder {
        private com.baidu.tbadk.core.view.userLike.c ajZ;
        private TextView euO;
        private TextView imF;
        private HeadImageView imG;
        private UserHeadCoverView imH;
        private TextView imI;
        private ImageView imJ;
        private TextView imK;
        private HotUserRankLikeButton imL;
        private int imM;
        private boolean imN;
        private String mCategory;
        private long mForumId;
        private TbPageContext mPageContext;
        private int mSkinType;

        public a(View view) {
            super(view);
            this.mSkinType = 3;
            this.mCategory = "";
            this.imM = 0;
            this.mPageContext = fj(view.getContext());
            this.imF = (TextView) view.findViewById(R.id.rank_num);
            this.imF.getPaint().setFakeBoldText(true);
            this.imG = (HeadImageView) view.findViewById(R.id.head_icon);
            this.imG.setIsRound(true);
            this.imG.setPlaceHolder(1);
            this.imG.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.imH = (UserHeadCoverView) view.findViewById(R.id.head_cover);
            this.euO = (TextView) view.findViewById(R.id.user_name);
            this.imI = (TextView) view.findViewById(R.id.user_intro);
            this.imJ = (ImageView) view.findViewById(R.id.grade);
            this.imK = (TextView) view.findViewById(R.id.user_influence);
            this.imL = (HotUserRankLikeButton) view.findViewById(R.id.like_button);
        }

        public void a(final com.baidu.tieba.enterForum.hotuserrank.a.b bVar) {
            int i;
            if (bVar != null) {
                if (!TextUtils.isEmpty(bVar.rankNum)) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.imF.getLayoutParams();
                    int dimension = (int) this.mPageContext.getResources().getDimension(R.dimen.tbds44);
                    this.imF.setText(bVar.rankNum);
                    if (this.imM == 1) {
                        dimension = (int) this.mPageContext.getResources().getDimension(R.dimen.tbds26);
                        layoutParams.width = (int) this.mPageContext.getResources().getDimension(R.dimen.tbds129);
                    }
                    layoutParams.setMargins(dimension, 0, 0, 0);
                    this.imF.setLayoutParams(layoutParams);
                }
                int i2 = R.color.CAM_X0105;
                if ("1".equals(this.imF.getText())) {
                    i = R.color.CAM_X0314;
                } else if ("2".equals(this.imF.getText())) {
                    i = R.color.CAM_X0315;
                } else if ("3".equals(this.imF.getText())) {
                    i = R.color.CAM_X0316;
                } else {
                    i = R.color.CAM_X0105;
                }
                ap.setViewTextColor(this.imF, i);
                this.imG.startLoad(bVar.headUrl, 10, false);
                this.imH.setData(bVar);
                String str = bVar.userName;
                if (ae.getTextLengthWithEmoji(str) > 12) {
                    str = ae.subStringWithEmoji(str, 10) + StringHelper.STRING_MORE;
                }
                this.euO.setText(str);
                this.imN = bVar.imN;
                if (bVar.imN) {
                    ap.setViewTextColor(this.euO, R.color.CAM_X0301);
                }
                if (TextUtils.isEmpty(bVar.imV)) {
                    this.imI.setVisibility(8);
                } else {
                    this.imI.setVisibility(0);
                    this.imI.setText(au.al(bVar.imV, 26));
                }
                if (bVar.imX.getLevel_id() == 0) {
                    this.imJ.setVisibility(8);
                } else {
                    this.imJ.setVisibility(0);
                    ap.setImageResource(this.imJ, BitmapHelper.getGradeResourceIdInEnterForum(bVar.imX.getLevel_id()));
                }
                if (TextUtils.isEmpty(bVar.imW)) {
                    this.imK.setVisibility(8);
                } else {
                    this.imK.setVisibility(0);
                    this.imK.setText(bVar.imW);
                }
                if (this.ajZ == null && this.mPageContext != null) {
                    this.ajZ = new com.baidu.tbadk.core.view.userLike.c(this.mPageContext, this.imL);
                    this.ajZ.l(this.mPageContext.getUniqueId());
                }
                this.ajZ.a(bVar.imX);
                this.imL.setOnClickEvent(new DynamicUserLikeButton.a() { // from class: com.baidu.tieba.enterForum.hotuserrank.c.a.1
                    @Override // com.baidu.tieba.view.DynamicUserLikeButton.a
                    public void cz(View view) {
                        if (!TextUtils.isEmpty(a.this.mCategory)) {
                            ar arVar = new ar("c13661");
                            arVar.w("uid", TbadkCoreApplication.getCurrentAccountId());
                            arVar.dR("resource_id", a.this.mCategory);
                            arVar.dR("friend_uid", bVar.rankNum);
                            arVar.ak("obj_type", bVar.imX.getIsLike() ? 2 : 1);
                            TiebaStatic.log(arVar);
                            return;
                        }
                        ar arVar2 = new ar("c13672");
                        arVar2.dR("obj_id", bVar.imX.getUserId());
                        arVar2.w("uid", TbadkCoreApplication.getCurrentAccountId());
                        arVar2.dR("resource_id", a.this.mCategory);
                        arVar2.w("fid", a.this.mForumId);
                        arVar2.dR("friend_uid", bVar.rankNum);
                        arVar2.ak("obj_type", bVar.imX.getIsLike() ? 2 : 1);
                        TiebaStatic.log(arVar2);
                    }
                });
                if (bVar.imX != null && bVar.imX.getUserId() != null && bVar.imX.getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                    this.imL.setVisibility(8);
                } else {
                    this.imL.setVisibility(0);
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
                if (!this.imN) {
                    ap.setViewTextColor(this.euO, R.color.CAM_X0105);
                } else {
                    ap.setViewTextColor(this.euO, R.color.CAM_X0301);
                }
                ap.setViewTextColor(this.imI, R.color.CAM_X0109);
                ap.setViewTextColor(this.imK, R.color.CAM_X0109);
                this.imL.onChangeSkinType(this.mSkinType);
            }
        }

        public void setCategory(String str) {
            this.mCategory = str;
        }

        public void setForumId(long j) {
            this.mForumId = j;
        }

        public void yn(int i) {
            this.imM = i;
        }

        public void crS() {
            this.imI.setVisibility(8);
            this.imL.setVisibility(8);
        }
    }
}
