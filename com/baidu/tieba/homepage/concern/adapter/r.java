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
public class r extends RecyclerView.Adapter<a> {
    private com.baidu.tbadk.h.f<MetaData> aiL;
    private BdUniqueId eMr;
    private boolean jeb;
    private Context mContext;
    private List<MetaData> mData;
    private TbPageContext mPageContext;
    private int mSkinType = 3;

    public void setOnItemCoverListener(com.baidu.tbadk.h.f<MetaData> fVar) {
        this.aiL = fVar;
    }

    public r(Context context) {
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
            aVar.qn(metaData.isNewGod());
            a(metaData, aVar);
            c(metaData, aVar);
            e(metaData, aVar);
            b(metaData, aVar);
            if (this.aiL != null) {
                this.aiL.b(aVar.itemView, metaData, i, i);
            }
            aVar.onChangeSkinType(this.mSkinType);
        }
    }

    private void a(final MetaData metaData, final a aVar) {
        aVar.jeh.setData(metaData, true);
        aVar.jeh.setAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.adapter.r.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                aq aqVar = new aq("c13566");
                aqVar.aj("obj_locate", 2);
                TiebaStatic.log(aqVar);
                r.this.d(metaData, aVar);
            }
        });
    }

    private void b(final MetaData metaData, a aVar) {
        aVar.jei.setOnClickEvent(new DynamicUserLikeButton.a() { // from class: com.baidu.tieba.homepage.concern.adapter.r.2
            @Override // com.baidu.tieba.view.DynamicUserLikeButton.a
            public void cm(View view) {
                if (metaData != null) {
                    if (metaData.getIsLike()) {
                        TiebaStatic.log(new aq("c13571"));
                        return;
                    }
                    aq aqVar = new aq("c13566");
                    aqVar.aj("obj_locate", 1);
                    aqVar.u("obj_id", TbadkCoreApplication.getCurrentAccountId());
                    aqVar.dK("obj_param1", metaData.getUserId());
                    TiebaStatic.log(aqVar);
                }
            }
        });
        com.baidu.tbadk.core.view.userLike.c cVar = aVar.ajV;
        if (cVar != null) {
            cVar.l(this.eMr);
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
            aVar.eig.setText(str);
            if (metaData.isNewGod()) {
                ap.setViewTextColor(aVar.eig, R.color.cp_cont_h);
            }
            aVar.eig.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.adapter.r.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (metaData != null && !StringUtils.isNull(metaData.getUserId())) {
                        aq aqVar = new aq("c13566");
                        aqVar.aj("obj_locate", 2);
                        TiebaStatic.log(aqVar);
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(r.this.mContext, metaData.getUserId(), metaData.getName_show())));
                        r.this.d(metaData, aVar);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(MetaData metaData, a aVar) {
        if (this.aiL != null) {
            this.aiL.a(aVar.itemView, metaData, aVar.getAdapterPosition(), aVar.getItemId());
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
            aVar.jeg.setText(str);
        }
    }

    public void onChangeSkinType(int i) {
        this.mSkinType = i;
    }

    public void setHasBorder(boolean z) {
        this.jeb = z;
    }

    /* loaded from: classes22.dex */
    public class a extends RecyclerView.ViewHolder {
        public com.baidu.tbadk.core.view.userLike.c ajV;
        public TextView eig;
        public TextView jeg;
        public HeadPendantClickableView jeh;
        public DynamicUserLikeButton jei;
        private boolean jej;
        public LinearLayout mContainer;

        public a(View view) {
            super(view);
            this.jej = false;
            this.mContainer = (LinearLayout) view.findViewById(R.id.concern_container);
            this.jeh = (HeadPendantClickableView) view.findViewById(R.id.concern_user_image);
            this.jeh.getHeadView().setIsRound(true);
            this.jeh.getHeadView().setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.jeh.getHeadView().setDefaultResource(17170445);
            this.jeh.getHeadView().setDefaultErrorResource(R.drawable.icon_default_avatar100);
            this.jeh.getHeadView().setPlaceHolder(2);
            this.jeh.getHeadView().setBorderWidth(com.baidu.adp.lib.util.l.getDimens(r.this.mContext, R.dimen.tbds1));
            this.jeh.getHeadView().setBorderColor(ap.getColor(R.color.cp_border_a));
            this.eig = (TextView) view.findViewById(R.id.concern_user_name);
            this.jeg = (TextView) view.findViewById(R.id.concern_user_desc);
            this.jei = (DynamicUserLikeButton) view.findViewById(R.id.user_recommend_like_btn);
            this.jei.setUseNewStyle(true);
            this.ajV = new com.baidu.tbadk.core.view.userLike.c(r.this.mPageContext, this.jei);
        }

        public void onChangeSkinType(int i) {
            if (!this.jej) {
                ap.setViewTextColor(this.eig, R.color.cp_cont_b);
            } else {
                ap.setViewTextColor(this.eig, R.color.cp_cont_h);
            }
            ap.setViewTextColor(this.jeg, R.color.cp_cont_d);
            this.jei.onChangeSkinType(i);
            if (r.this.jeb) {
                com.baidu.tbadk.core.util.e.a.bnv().oO(0).oS(R.color.cp_bg_line_j).oU(com.baidu.adp.lib.util.l.getDimens(r.this.mContext, R.dimen.tbds1)).X(com.baidu.adp.lib.util.l.getDimens(r.this.mContext, R.dimen.tbds10)).bf(this.mContainer);
            }
        }

        public void qn(boolean z) {
            this.jej = z;
        }
    }

    public void setPageContext(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.eMr = bdUniqueId;
    }
}
