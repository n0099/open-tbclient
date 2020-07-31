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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
import com.baidu.tieba.R;
import com.baidu.tieba.view.DynamicUserLikeButton;
import java.util.List;
/* loaded from: classes16.dex */
public class q extends RecyclerView.Adapter<a> {
    private com.baidu.tbadk.h.f<MetaData> agN;
    private BdUniqueId enQ;
    private boolean isX;
    private Context mContext;
    private List<MetaData> mData;
    private TbPageContext mPageContext;
    private int mSkinType = 3;

    public void setOnItemCoverListener(com.baidu.tbadk.h.f<MetaData> fVar) {
        this.agN = fVar;
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
            aVar.oU(metaData.isNewGod());
            a(metaData, aVar);
            c(metaData, aVar);
            e(metaData, aVar);
            b(metaData, aVar);
            if (this.agN != null) {
                this.agN.b(aVar.itemView, metaData, i, i);
            }
            aVar.onChangeSkinType(this.mSkinType);
        }
    }

    private void a(final MetaData metaData, final a aVar) {
        aVar.itd.setData(metaData, true);
        aVar.itd.setAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.a.q.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ap apVar = new ap("c13566");
                apVar.ah("obj_locate", 2);
                TiebaStatic.log(apVar);
                q.this.d(metaData, aVar);
            }
        });
    }

    private void b(final MetaData metaData, a aVar) {
        aVar.ite.setOnClickEvent(new DynamicUserLikeButton.a() { // from class: com.baidu.tieba.homepage.concern.a.q.2
            @Override // com.baidu.tieba.view.DynamicUserLikeButton.a
            public void bX(View view) {
                if (metaData != null) {
                    if (metaData.getIsLike()) {
                        TiebaStatic.log(new ap("c13571"));
                        return;
                    }
                    ap apVar = new ap("c13566");
                    apVar.ah("obj_locate", 1);
                    apVar.t("obj_id", TbadkCoreApplication.getCurrentAccountId());
                    apVar.dn("obj_param1", metaData.getUserId());
                    TiebaStatic.log(apVar);
                }
            }
        });
        com.baidu.tbadk.core.view.userLike.c cVar = aVar.ahO;
        if (cVar != null) {
            cVar.m(this.enQ);
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
            aVar.dKI.setText(str);
            if (metaData.isNewGod()) {
                ao.setViewTextColor(aVar.dKI, R.color.cp_cont_h);
            }
            aVar.dKI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.a.q.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (metaData != null && !StringUtils.isNull(metaData.getUserId())) {
                        ap apVar = new ap("c13566");
                        apVar.ah("obj_locate", 2);
                        TiebaStatic.log(apVar);
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(q.this.mContext, metaData.getUserId(), metaData.getName_show())));
                        q.this.d(metaData, aVar);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(MetaData metaData, a aVar) {
        if (this.agN != null) {
            this.agN.a(aVar.itemView, metaData, aVar.getAdapterPosition(), aVar.getItemId());
        }
    }

    private void e(MetaData metaData, a aVar) {
        if (metaData != null && aVar != null) {
            String str = "";
            if (metaData.isBaijiahaoUser()) {
                str = metaData.getBaijiahaoInfo().auth_desc;
                if (as.isEmpty(str)) {
                    str = "";
                }
            } else if (metaData.isNewGod()) {
                String fieldName = metaData.getNewGodData().getFieldName();
                if (!as.isEmpty(fieldName)) {
                    str = fieldName + TbadkCoreApplication.getInst().getApp().getString(R.string.field_new_god);
                } else {
                    str = "";
                }
            }
            aVar.itc.setText(str);
        }
    }

    public void onChangeSkinType(int i) {
        this.mSkinType = i;
    }

    public void setHasBorder(boolean z) {
        this.isX = z;
    }

    /* loaded from: classes16.dex */
    public class a extends RecyclerView.ViewHolder {
        public com.baidu.tbadk.core.view.userLike.c ahO;
        public TextView dKI;
        public TextView itc;
        public HeadPendantClickableView itd;
        public DynamicUserLikeButton ite;
        private boolean itf;
        public LinearLayout mContainer;

        public a(View view) {
            super(view);
            this.itf = false;
            this.mContainer = (LinearLayout) view.findViewById(R.id.concern_container);
            this.itd = (HeadPendantClickableView) view.findViewById(R.id.concern_user_image);
            this.itd.getHeadView().setIsRound(true);
            this.itd.getHeadView().setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.itd.getHeadView().setDefaultResource(17170445);
            this.itd.getHeadView().setDefaultErrorResource(R.drawable.icon_default_avatar100);
            this.itd.getHeadView().setPlaceHolder(2);
            this.itd.getHeadView().setBorderWidth(com.baidu.adp.lib.util.l.getDimens(q.this.mContext, R.dimen.tbds1));
            this.itd.getHeadView().setBorderColor(ao.getColor(R.color.cp_border_a));
            this.dKI = (TextView) view.findViewById(R.id.concern_user_name);
            this.itc = (TextView) view.findViewById(R.id.concern_user_desc);
            this.ite = (DynamicUserLikeButton) view.findViewById(R.id.user_recommend_like_btn);
            this.ite.setUseNewStyle(true);
            this.ahO = new com.baidu.tbadk.core.view.userLike.c(q.this.mPageContext, this.ite);
        }

        public void onChangeSkinType(int i) {
            if (!this.itf) {
                ao.setViewTextColor(this.dKI, R.color.cp_cont_b);
            } else {
                ao.setViewTextColor(this.dKI, R.color.cp_cont_h);
            }
            ao.setViewTextColor(this.itc, R.color.cp_cont_d);
            this.ite.onChangeSkinType(i);
            if (q.this.isX) {
                com.baidu.tbadk.core.util.e.a.bbr().ma(0).me(R.color.cp_bg_line_j).mg(com.baidu.adp.lib.util.l.getDimens(q.this.mContext, R.dimen.tbds1)).Q(com.baidu.adp.lib.util.l.getDimens(q.this.mContext, R.dimen.tbds10)).aX(this.mContainer);
            }
        }

        public void oU(boolean z) {
            this.itf = z;
        }
    }

    public void setPageContext(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.enQ = bdUniqueId;
    }
}
