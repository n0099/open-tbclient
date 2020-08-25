package com.baidu.tieba.homepage.concern.a;

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
/* loaded from: classes16.dex */
public class q extends RecyclerView.Adapter<a> {
    private com.baidu.tbadk.h.f<MetaData> ahW;
    private BdUniqueId eya;
    private boolean iHo;
    private Context mContext;
    private List<MetaData> mData;
    private TbPageContext mPageContext;
    private int mSkinType = 3;

    public void setOnItemCoverListener(com.baidu.tbadk.h.f<MetaData> fVar) {
        this.ahW = fVar;
    }

    public q(Context context) {
        this.mContext = context;
    }

    public void setData(List<MetaData> list) {
        this.mData = list;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: x */
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
            aVar.pz(metaData.isNewGod());
            a(metaData, aVar);
            c(metaData, aVar);
            e(metaData, aVar);
            b(metaData, aVar);
            if (this.ahW != null) {
                this.ahW.b(aVar.itemView, metaData, i, i);
            }
            aVar.onChangeSkinType(this.mSkinType);
        }
    }

    private void a(final MetaData metaData, final a aVar) {
        aVar.iHu.setData(metaData, true);
        aVar.iHu.setAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.a.q.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                aq aqVar = new aq("c13566");
                aqVar.ai("obj_locate", 2);
                TiebaStatic.log(aqVar);
                q.this.d(metaData, aVar);
            }
        });
    }

    private void b(final MetaData metaData, a aVar) {
        aVar.iHv.setOnClickEvent(new DynamicUserLikeButton.a() { // from class: com.baidu.tieba.homepage.concern.a.q.2
            @Override // com.baidu.tieba.view.DynamicUserLikeButton.a
            public void bZ(View view) {
                if (metaData != null) {
                    if (metaData.getIsLike()) {
                        TiebaStatic.log(new aq("c13571"));
                        return;
                    }
                    aq aqVar = new aq("c13566");
                    aqVar.ai("obj_locate", 1);
                    aqVar.u("obj_id", TbadkCoreApplication.getCurrentAccountId());
                    aqVar.dD("obj_param1", metaData.getUserId());
                    TiebaStatic.log(aqVar);
                }
            }
        });
        com.baidu.tbadk.core.view.userLike.c cVar = aVar.ajc;
        if (cVar != null) {
            cVar.m(this.eya);
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
            aVar.dTQ.setText(str);
            if (metaData.isNewGod()) {
                ap.setViewTextColor(aVar.dTQ, R.color.cp_cont_h);
            }
            aVar.dTQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.a.q.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (metaData != null && !StringUtils.isNull(metaData.getUserId())) {
                        aq aqVar = new aq("c13566");
                        aqVar.ai("obj_locate", 2);
                        TiebaStatic.log(aqVar);
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(q.this.mContext, metaData.getUserId(), metaData.getName_show())));
                        q.this.d(metaData, aVar);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(MetaData metaData, a aVar) {
        if (this.ahW != null) {
            this.ahW.a(aVar.itemView, metaData, aVar.getAdapterPosition(), aVar.getItemId());
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
            aVar.iHt.setText(str);
        }
    }

    public void onChangeSkinType(int i) {
        this.mSkinType = i;
    }

    public void setHasBorder(boolean z) {
        this.iHo = z;
    }

    /* loaded from: classes16.dex */
    public class a extends RecyclerView.ViewHolder {
        public com.baidu.tbadk.core.view.userLike.c ajc;
        public TextView dTQ;
        public TextView iHt;
        public HeadPendantClickableView iHu;
        public DynamicUserLikeButton iHv;
        private boolean iHw;
        public LinearLayout mContainer;

        public a(View view) {
            super(view);
            this.iHw = false;
            this.mContainer = (LinearLayout) view.findViewById(R.id.concern_container);
            this.iHu = (HeadPendantClickableView) view.findViewById(R.id.concern_user_image);
            this.iHu.getHeadView().setIsRound(true);
            this.iHu.getHeadView().setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.iHu.getHeadView().setDefaultResource(17170445);
            this.iHu.getHeadView().setDefaultErrorResource(R.drawable.icon_default_avatar100);
            this.iHu.getHeadView().setPlaceHolder(2);
            this.iHu.getHeadView().setBorderWidth(com.baidu.adp.lib.util.l.getDimens(q.this.mContext, R.dimen.tbds1));
            this.iHu.getHeadView().setBorderColor(ap.getColor(R.color.cp_border_a));
            this.dTQ = (TextView) view.findViewById(R.id.concern_user_name);
            this.iHt = (TextView) view.findViewById(R.id.concern_user_desc);
            this.iHv = (DynamicUserLikeButton) view.findViewById(R.id.user_recommend_like_btn);
            this.iHv.setUseNewStyle(true);
            this.ajc = new com.baidu.tbadk.core.view.userLike.c(q.this.mPageContext, this.iHv);
        }

        public void onChangeSkinType(int i) {
            if (!this.iHw) {
                ap.setViewTextColor(this.dTQ, R.color.cp_cont_b);
            } else {
                ap.setViewTextColor(this.dTQ, R.color.cp_cont_h);
            }
            ap.setViewTextColor(this.iHt, R.color.cp_cont_d);
            this.iHv.onChangeSkinType(i);
            if (q.this.iHo) {
                com.baidu.tbadk.core.util.e.a.bjQ().oe(0).oi(R.color.cp_bg_line_j).ok(com.baidu.adp.lib.util.l.getDimens(q.this.mContext, R.dimen.tbds1)).V(com.baidu.adp.lib.util.l.getDimens(q.this.mContext, R.dimen.tbds10)).aZ(this.mContainer);
            }
        }

        public void pz(boolean z) {
            this.iHw = z;
        }
    }

    public void setPageContext(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.eya = bdUniqueId;
    }
}
