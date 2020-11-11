package com.baidu.tieba.homepage.concern.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
import com.baidu.tieba.R;
import com.baidu.tieba.view.DynamicUserLikeButton;
import java.util.List;
/* loaded from: classes22.dex */
public class s extends RecyclerView.Adapter<a> {
    private com.baidu.tbadk.h.f<MetaData> aiM;
    private BdUniqueId faC;
    private boolean jww;
    private Context mContext;
    private List<MetaData> mData;
    private TbPageContext mPageContext;
    private int mSkinType = 3;

    public void setOnItemCoverListener(com.baidu.tbadk.h.f<MetaData> fVar) {
        this.aiM = fVar;
    }

    public s(Context context) {
        this.mContext = context;
    }

    public void setData(List<MetaData> list) {
        this.mData = list;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: B */
    public a onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new a(LayoutInflater.from(this.mContext).inflate(R.layout.concern_recommend_item, (ViewGroup) null));
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.mData == null) {
            return 0;
        }
        return this.mData.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(a aVar, int i) {
        MetaData metaData;
        if (aVar != null && this.mData != null && (metaData = this.mData.get(i)) != null) {
            aVar.qO(metaData.isNewGod());
            a(metaData, aVar);
            c(metaData, aVar);
            e(metaData, aVar);
            b(metaData, aVar);
            if (this.aiM != null) {
                this.aiM.b(aVar.itemView, metaData, i, i);
            }
            aVar.onChangeSkinType(this.mSkinType);
        }
    }

    private void a(final MetaData metaData, final a aVar) {
        aVar.jwC.setData(metaData, true);
        aVar.jwC.setAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.adapter.s.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                aq aqVar = new aq("c13566");
                aqVar.al("obj_locate", 2);
                TiebaStatic.log(aqVar);
                s.this.d(metaData, aVar);
            }
        });
    }

    private void b(final MetaData metaData, a aVar) {
        aVar.jwD.setOnClickEvent(new DynamicUserLikeButton.a() { // from class: com.baidu.tieba.homepage.concern.adapter.s.2
            @Override // com.baidu.tieba.view.DynamicUserLikeButton.a
            public void cv(View view) {
                if (metaData != null) {
                    if (metaData.getIsLike()) {
                        TiebaStatic.log(new aq("c13571"));
                        return;
                    }
                    aq aqVar = new aq("c13566");
                    aqVar.al("obj_locate", 1);
                    aqVar.w("obj_id", TbadkCoreApplication.getCurrentAccountId());
                    aqVar.dR("obj_param1", metaData.getUserId());
                    TiebaStatic.log(aqVar);
                }
            }
        });
        com.baidu.tbadk.core.view.userLike.c cVar = aVar.ajW;
        if (cVar != null) {
            cVar.l(this.faC);
            cVar.a(metaData);
        }
    }

    private void c(final MetaData metaData, final a aVar) {
        if (metaData != null && aVar != null) {
            String str = "";
            if (!StringUtils.isNull(metaData.getName_show())) {
                str = metaData.getName_show();
            } else if (metaData.getBaijiahaoInfo() != null && !StringUtils.isNull(metaData.getBaijiahaoInfo().name)) {
                str = metaData.getBaijiahaoInfo().name;
            }
            aVar.ewx.setText(str);
            if (metaData.isNewGod()) {
                ap.setViewTextColor(aVar.ewx, R.color.cp_cont_h);
            }
            aVar.ewx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.adapter.s.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (metaData != null && !StringUtils.isNull(metaData.getUserId())) {
                        aq aqVar = new aq("c13566");
                        aqVar.al("obj_locate", 2);
                        TiebaStatic.log(aqVar);
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(s.this.mContext, metaData.getUserId(), metaData.getName_show())));
                        s.this.d(metaData, aVar);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(MetaData metaData, a aVar) {
        if (this.aiM != null) {
            this.aiM.a(aVar.itemView, metaData, aVar.getAdapterPosition(), aVar.getItemId());
        }
    }

    private void e(MetaData metaData, a aVar) {
        if (metaData != null && aVar != null) {
            String str = "";
            if (metaData.isBaijiahaoUser()) {
                str = metaData.getBaijiahaoInfo().auth_desc;
                if (at.isEmpty(str)) {
                    str = "";
                }
            } else if (metaData.isNewGod()) {
                String fieldName = metaData.getNewGodData().getFieldName();
                if (!at.isEmpty(fieldName)) {
                    str = fieldName + TbadkCoreApplication.getInst().getApp().getString(R.string.field_new_god);
                } else {
                    str = "";
                }
            }
            aVar.jwB.setText(str);
        }
    }

    public void onChangeSkinType(int i) {
        this.mSkinType = i;
    }

    public void setHasBorder(boolean z) {
        this.jww = z;
    }

    /* loaded from: classes22.dex */
    public class a extends RecyclerView.ViewHolder {
        public com.baidu.tbadk.core.view.userLike.c ajW;
        public TextView ewx;
        public TextView jwB;
        public HeadPendantClickableView jwC;
        public DynamicUserLikeButton jwD;
        private boolean jwE;
        public LinearLayout mContainer;

        public a(View view) {
            super(view);
            this.jwE = false;
            this.mContainer = (LinearLayout) view.findViewById(R.id.concern_container);
            this.jwC = (HeadPendantClickableView) view.findViewById(R.id.concern_user_image);
            this.jwC.getHeadView().setIsRound(true);
            this.jwC.getHeadView().setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.jwC.getHeadView().setDefaultResource(17170445);
            this.jwC.getHeadView().setDefaultErrorResource(R.drawable.icon_default_avatar100);
            this.jwC.getHeadView().setPlaceHolder(2);
            this.jwC.getHeadView().setBorderWidth(com.baidu.adp.lib.util.l.getDimens(s.this.mContext, R.dimen.tbds1));
            this.jwC.getHeadView().setBorderColor(ap.getColor(R.color.cp_border_a));
            this.ewx = (TextView) view.findViewById(R.id.concern_user_name);
            this.jwB = (TextView) view.findViewById(R.id.concern_user_desc);
            this.jwD = (DynamicUserLikeButton) view.findViewById(R.id.user_recommend_like_btn);
            this.jwD.setUseNewStyle(true);
            this.ajW = new com.baidu.tbadk.core.view.userLike.c(s.this.mPageContext, this.jwD);
        }

        public void onChangeSkinType(int i) {
            if (!this.jwE) {
                ap.setViewTextColor(this.ewx, R.color.cp_cont_b);
            } else {
                ap.setViewTextColor(this.ewx, R.color.cp_cont_h);
            }
            ap.setViewTextColor(this.jwB, R.color.cp_cont_d);
            this.jwD.onChangeSkinType(i);
            if (s.this.jww) {
                com.baidu.tbadk.core.util.e.a.brO().pj(0).po(R.color.cp_bg_line_j).pq(com.baidu.adp.lib.util.l.getDimens(s.this.mContext, R.dimen.tbds1)).ab(com.baidu.adp.lib.util.l.getDimens(s.this.mContext, R.dimen.tbds10)).bk(this.mContainer);
            }
        }

        public void qO(boolean z) {
            this.jwE = z;
        }
    }

    public void setPageContext(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.faC = bdUniqueId;
    }
}
