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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
import com.baidu.tbadk.util.aj;
import com.baidu.tieba.R;
import com.baidu.tieba.view.DynamicUserLikeButton;
import java.util.List;
/* loaded from: classes2.dex */
public class ConcernRecommendListAdapter extends RecyclerView.Adapter<ForumViewHolder> {
    private com.baidu.tbadk.h.f<MetaData> ajq;
    private BdUniqueId foA;
    private boolean kba;
    private Context mContext;
    private List<MetaData> mData;
    private TbPageContext mPageContext;
    private int mSkinType = 3;

    public void setOnItemCoverListener(com.baidu.tbadk.h.f<MetaData> fVar) {
        this.ajq = fVar;
    }

    public ConcernRecommendListAdapter(Context context) {
        this.mContext = context;
    }

    public void setData(List<MetaData> list) {
        this.mData = list;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: G */
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
            forumViewHolder.rX(metaData.isNewGod());
            a(metaData, forumViewHolder);
            c(metaData, forumViewHolder);
            e(metaData, forumViewHolder);
            b(metaData, forumViewHolder);
            if (this.ajq != null) {
                this.ajq.b(forumViewHolder.itemView, metaData, i, i);
            }
            forumViewHolder.onChangeSkinType(this.mSkinType);
        }
    }

    private void a(final MetaData metaData, final ForumViewHolder forumViewHolder) {
        forumViewHolder.kbg.setData(metaData, true);
        forumViewHolder.kbg.setAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.adapter.ConcernRecommendListAdapter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ar arVar = new ar("c13566");
                arVar.ap("obj_locate", 2);
                TiebaStatic.log(arVar);
                ConcernRecommendListAdapter.this.d(metaData, forumViewHolder);
            }
        });
    }

    private void b(final MetaData metaData, ForumViewHolder forumViewHolder) {
        forumViewHolder.kbh.setOnClickEvent(new DynamicUserLikeButton.a() { // from class: com.baidu.tieba.homepage.concern.adapter.ConcernRecommendListAdapter.2
            @Override // com.baidu.tieba.view.DynamicUserLikeButton.a
            public void cO(View view) {
                if (metaData != null) {
                    if (metaData.getIsLike()) {
                        TiebaStatic.log(new ar("c13571"));
                        return;
                    }
                    ar arVar = new ar("c13566");
                    arVar.ap("obj_locate", 1);
                    arVar.v("obj_id", TbadkCoreApplication.getCurrentAccountId());
                    arVar.dR("obj_param1", metaData.getUserId());
                    TiebaStatic.log(arVar);
                }
            }
        });
        com.baidu.tbadk.core.view.userLike.c cVar = forumViewHolder.akz;
        if (cVar != null) {
            cVar.l(this.foA);
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
            forumViewHolder.eIO.setText(str);
            if (metaData.isNewGod()) {
                ap.setViewTextColor(forumViewHolder.eIO, R.color.CAM_X0301);
            }
            forumViewHolder.eIO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.adapter.ConcernRecommendListAdapter.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (metaData != null && !StringUtils.isNull(metaData.getUserId())) {
                        ar arVar = new ar("c13566");
                        arVar.ap("obj_locate", 2);
                        TiebaStatic.log(arVar);
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(ConcernRecommendListAdapter.this.mContext, metaData.getUserId(), metaData.getName_show())));
                        ConcernRecommendListAdapter.this.d(metaData, forumViewHolder);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(MetaData metaData, ForumViewHolder forumViewHolder) {
        if (this.ajq != null) {
            this.ajq.a(forumViewHolder.itemView, metaData, forumViewHolder.getAdapterPosition(), forumViewHolder.getItemId());
        }
    }

    private void e(MetaData metaData, ForumViewHolder forumViewHolder) {
        if (metaData != null && forumViewHolder != null) {
            String str = "";
            if (metaData.isBaijiahaoUser()) {
                str = metaData.getBaijiahaoInfo().auth_desc;
                if (au.isEmpty(str)) {
                    str = "";
                }
            } else if (metaData.isNewGod()) {
                String fieldName = metaData.getNewGodData().getFieldName();
                if (!au.isEmpty(fieldName)) {
                    str = fieldName + aj.lA(metaData.isVideoGod());
                } else {
                    str = "";
                }
            }
            forumViewHolder.kbf.setText(str);
        }
    }

    public void onChangeSkinType(int i) {
        this.mSkinType = i;
    }

    public void setHasBorder(boolean z) {
        this.kba = z;
    }

    /* loaded from: classes2.dex */
    public class ForumViewHolder extends RecyclerView.ViewHolder {
        public com.baidu.tbadk.core.view.userLike.c akz;
        public TextView eIO;
        public TextView kbf;
        public HeadPendantClickableView kbg;
        public DynamicUserLikeButton kbh;
        private boolean kbi;
        public LinearLayout mContainer;

        public ForumViewHolder(View view) {
            super(view);
            this.kbi = false;
            this.mContainer = (LinearLayout) view.findViewById(R.id.concern_container);
            this.kbg = (HeadPendantClickableView) view.findViewById(R.id.concern_user_image);
            this.kbg.getHeadView().setIsRound(true);
            this.kbg.getHeadView().setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.kbg.getHeadView().setDefaultResource(17170445);
            this.kbg.getHeadView().setPlaceHolder(1);
            this.kbg.getHeadView().setBorderWidth(com.baidu.adp.lib.util.l.getDimens(ConcernRecommendListAdapter.this.mContext, R.dimen.tbds1));
            this.kbg.getHeadView().setBorderColor(ap.getColor(R.color.CAM_X0401));
            this.eIO = (TextView) view.findViewById(R.id.concern_user_name);
            this.kbf = (TextView) view.findViewById(R.id.concern_user_desc);
            this.kbh = (DynamicUserLikeButton) view.findViewById(R.id.user_recommend_like_btn);
            this.akz = new com.baidu.tbadk.core.view.userLike.c(ConcernRecommendListAdapter.this.mPageContext, this.kbh);
        }

        public void onChangeSkinType(int i) {
            if (!this.kbi) {
                ap.setViewTextColor(this.eIO, R.color.CAM_X0105);
            } else {
                ap.setViewTextColor(this.eIO, R.color.CAM_X0301);
            }
            ap.setViewTextColor(this.kbf, R.color.CAM_X0109);
            this.kbh.onChangeSkinType(i);
            com.baidu.tbadk.core.elementsMaven.c.br(this.mContainer).og(R.string.J_X05).setBackGroundColor(R.color.CAM_X0206);
        }

        public void rX(boolean z) {
            this.kbi = z;
        }
    }

    public void setPageContext(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.foA = bdUniqueId;
    }
}
