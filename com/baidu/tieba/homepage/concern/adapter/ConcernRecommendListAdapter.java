package com.baidu.tieba.homepage.concern.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
import com.baidu.tbadk.util.ag;
import com.baidu.tieba.R;
import com.baidu.tieba.view.DynamicUserLikeButton;
import java.util.List;
/* loaded from: classes2.dex */
public class ConcernRecommendListAdapter extends RecyclerView.Adapter<ForumViewHolder> {
    private com.baidu.tbadk.h.f<MetaData> aks;
    private BdUniqueId fqR;
    private boolean jYe;
    private Context mContext;
    private List<MetaData> mData;
    private TbPageContext mPageContext;
    private int mSkinType = 3;

    public void setOnItemCoverListener(com.baidu.tbadk.h.f<MetaData> fVar) {
        this.aks = fVar;
    }

    public ConcernRecommendListAdapter(Context context) {
        this.mContext = context;
    }

    public void setData(List<MetaData> list) {
        this.mData = list;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: F */
    public ForumViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new ForumViewHolder(LayoutInflater.from(this.mContext).inflate(R.layout.concern_recommend_item, (ViewGroup) null));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.mData == null) {
            return 0;
        }
        return this.mData.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(ForumViewHolder forumViewHolder, int i) {
        MetaData metaData;
        if (forumViewHolder != null && this.mData != null && (metaData = this.mData.get(i)) != null) {
            forumViewHolder.rP(metaData.isNewGod());
            a(metaData, forumViewHolder);
            c(metaData, forumViewHolder);
            e(metaData, forumViewHolder);
            b(metaData, forumViewHolder);
            if (this.aks != null) {
                this.aks.b(forumViewHolder.itemView, metaData, i, i);
            }
            forumViewHolder.onChangeSkinType(this.mSkinType);
        }
    }

    private void a(final MetaData metaData, final ForumViewHolder forumViewHolder) {
        forumViewHolder.jYk.setData(metaData, true);
        forumViewHolder.jYk.setAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.adapter.ConcernRecommendListAdapter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                aq aqVar = new aq("c13566");
                aqVar.an("obj_locate", 2);
                TiebaStatic.log(aqVar);
                ConcernRecommendListAdapter.this.d(metaData, forumViewHolder);
            }
        });
    }

    private void b(final MetaData metaData, ForumViewHolder forumViewHolder) {
        forumViewHolder.jYl.setOnClickEvent(new DynamicUserLikeButton.a() { // from class: com.baidu.tieba.homepage.concern.adapter.ConcernRecommendListAdapter.2
            @Override // com.baidu.tieba.view.DynamicUserLikeButton.a
            public void cQ(View view) {
                if (metaData != null) {
                    if (metaData.getIsLike()) {
                        TiebaStatic.log(new aq("c13571"));
                        return;
                    }
                    aq aqVar = new aq("c13566");
                    aqVar.an("obj_locate", 1);
                    aqVar.w("obj_id", TbadkCoreApplication.getCurrentAccountId());
                    aqVar.dX("obj_param1", metaData.getUserId());
                    TiebaStatic.log(aqVar);
                }
            }
        });
        com.baidu.tbadk.core.view.userLike.c cVar = forumViewHolder.alC;
        if (cVar != null) {
            cVar.l(this.fqR);
            cVar.a(metaData);
        }
    }

    private void c(final MetaData metaData, final ForumViewHolder forumViewHolder) {
        if (metaData != null && forumViewHolder != null) {
            String str = "";
            if (!StringUtils.isNull(metaData.getName_show())) {
                str = metaData.getName_show();
            } else if (metaData.getBaijiahaoInfo() != null && !StringUtils.isNull(metaData.getBaijiahaoInfo().name)) {
                str = metaData.getBaijiahaoInfo().name;
            }
            forumViewHolder.eLt.setText(str);
            if (metaData.isNewGod()) {
                ao.setViewTextColor(forumViewHolder.eLt, R.color.CAM_X0301);
            }
            forumViewHolder.eLt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.adapter.ConcernRecommendListAdapter.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (metaData != null && !StringUtils.isNull(metaData.getUserId())) {
                        aq aqVar = new aq("c13566");
                        aqVar.an("obj_locate", 2);
                        TiebaStatic.log(aqVar);
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(ConcernRecommendListAdapter.this.mContext, metaData.getUserId(), metaData.getName_show())));
                        ConcernRecommendListAdapter.this.d(metaData, forumViewHolder);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(MetaData metaData, ForumViewHolder forumViewHolder) {
        if (this.aks != null) {
            this.aks.a(forumViewHolder.itemView, metaData, forumViewHolder.getAdapterPosition(), forumViewHolder.getItemId());
        }
    }

    private void e(MetaData metaData, ForumViewHolder forumViewHolder) {
        if (metaData != null && forumViewHolder != null) {
            String str = "";
            if (metaData.isBaijiahaoUser()) {
                str = metaData.getBaijiahaoInfo().auth_desc;
                if (at.isEmpty(str)) {
                    str = "";
                }
            } else if (metaData.isNewGod()) {
                String fieldName = metaData.getNewGodData().getFieldName();
                if (!at.isEmpty(fieldName)) {
                    str = fieldName + ag.lB(metaData.isVideoGod());
                } else {
                    str = "";
                }
            }
            forumViewHolder.jYj.setText(str);
        }
    }

    public void onChangeSkinType(int i) {
        this.mSkinType = i;
    }

    public void setHasBorder(boolean z) {
        this.jYe = z;
    }

    /* loaded from: classes2.dex */
    public class ForumViewHolder extends RecyclerView.ViewHolder {
        public com.baidu.tbadk.core.view.userLike.c alC;
        public TextView eLt;
        public TextView jYj;
        public HeadPendantClickableView jYk;
        public DynamicUserLikeButton jYl;
        private boolean jYm;
        public LinearLayout mContainer;

        public ForumViewHolder(View view) {
            super(view);
            this.jYm = false;
            this.mContainer = (LinearLayout) view.findViewById(R.id.concern_container);
            this.jYk = (HeadPendantClickableView) view.findViewById(R.id.concern_user_image);
            this.jYk.getHeadView().setIsRound(true);
            this.jYk.getHeadView().setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.jYk.getHeadView().setDefaultResource(17170445);
            this.jYk.getHeadView().setPlaceHolder(1);
            this.jYk.getHeadView().setBorderWidth(com.baidu.adp.lib.util.l.getDimens(ConcernRecommendListAdapter.this.mContext, R.dimen.tbds1));
            this.jYk.getHeadView().setBorderColor(ao.getColor(R.color.CAM_X0401));
            this.eLt = (TextView) view.findViewById(R.id.concern_user_name);
            this.jYj = (TextView) view.findViewById(R.id.concern_user_desc);
            this.jYl = (DynamicUserLikeButton) view.findViewById(R.id.user_recommend_like_btn);
            this.alC = new com.baidu.tbadk.core.view.userLike.c(ConcernRecommendListAdapter.this.mPageContext, this.jYl);
        }

        public void onChangeSkinType(int i) {
            if (!this.jYm) {
                ao.setViewTextColor(this.eLt, R.color.CAM_X0105);
            } else {
                ao.setViewTextColor(this.eLt, R.color.CAM_X0301);
            }
            ao.setViewTextColor(this.jYj, R.color.CAM_X0109);
            this.jYl.onChangeSkinType(i);
            com.baidu.tbadk.core.elementsMaven.c.bv(this.mContainer).pK(R.string.J_X05).setBackGroundColor(R.color.CAM_X0206);
        }

        public void rP(boolean z) {
            this.jYm = z;
        }
    }

    public void setPageContext(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.fqR = bdUniqueId;
    }
}
