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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
import com.baidu.tbadk.util.ah;
import com.baidu.tieba.R;
import com.baidu.tieba.view.DynamicUserLikeButton;
import java.util.List;
/* loaded from: classes22.dex */
public class t extends RecyclerView.Adapter<a> {
    private com.baidu.tbadk.h.f<MetaData> ajQ;
    private BdUniqueId fhh;
    private boolean jKN;
    private Context mContext;
    private List<MetaData> mData;
    private TbPageContext mPageContext;
    private int mSkinType = 3;

    public void setOnItemCoverListener(com.baidu.tbadk.h.f<MetaData> fVar) {
        this.ajQ = fVar;
    }

    public t(Context context) {
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
            aVar.rs(metaData.isNewGod());
            a(metaData, aVar);
            c(metaData, aVar);
            e(metaData, aVar);
            b(metaData, aVar);
            if (this.ajQ != null) {
                this.ajQ.b(aVar.itemView, metaData, i, i);
            }
            aVar.onChangeSkinType(this.mSkinType);
        }
    }

    private void a(final MetaData metaData, final a aVar) {
        aVar.jKT.setData(metaData, true);
        aVar.jKT.setAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.adapter.t.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ar arVar = new ar("c13566");
                arVar.al("obj_locate", 2);
                TiebaStatic.log(arVar);
                t.this.d(metaData, aVar);
            }
        });
    }

    private void b(final MetaData metaData, a aVar) {
        aVar.jKU.setOnClickEvent(new DynamicUserLikeButton.a() { // from class: com.baidu.tieba.homepage.concern.adapter.t.2
            @Override // com.baidu.tieba.view.DynamicUserLikeButton.a
            public void cG(View view) {
                if (metaData != null) {
                    if (metaData.getIsLike()) {
                        TiebaStatic.log(new ar("c13571"));
                        return;
                    }
                    ar arVar = new ar("c13566");
                    arVar.al("obj_locate", 1);
                    arVar.w("obj_id", TbadkCoreApplication.getCurrentAccountId());
                    arVar.dY("obj_param1", metaData.getUserId());
                    TiebaStatic.log(arVar);
                }
            }
        });
        com.baidu.tbadk.core.view.userLike.c cVar = aVar.akZ;
        if (cVar != null) {
            cVar.l(this.fhh);
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
            aVar.eBQ.setText(str);
            if (metaData.isNewGod()) {
                ap.setViewTextColor(aVar.eBQ, R.color.CAM_X0301);
            }
            aVar.eBQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.adapter.t.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (metaData != null && !StringUtils.isNull(metaData.getUserId())) {
                        ar arVar = new ar("c13566");
                        arVar.al("obj_locate", 2);
                        TiebaStatic.log(arVar);
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(t.this.mContext, metaData.getUserId(), metaData.getName_show())));
                        t.this.d(metaData, aVar);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(MetaData metaData, a aVar) {
        if (this.ajQ != null) {
            this.ajQ.a(aVar.itemView, metaData, aVar.getAdapterPosition(), aVar.getItemId());
        }
    }

    private void e(MetaData metaData, a aVar) {
        if (metaData != null && aVar != null) {
            String str = "";
            if (metaData.isBaijiahaoUser()) {
                str = metaData.getBaijiahaoInfo().auth_desc;
                if (au.isEmpty(str)) {
                    str = "";
                }
            } else if (metaData.isNewGod()) {
                String fieldName = metaData.getNewGodData().getFieldName();
                if (!au.isEmpty(fieldName)) {
                    str = fieldName + ah.lf(metaData.isVideoGod());
                } else {
                    str = "";
                }
            }
            aVar.jKS.setText(str);
        }
    }

    public void onChangeSkinType(int i) {
        this.mSkinType = i;
    }

    public void setHasBorder(boolean z) {
        this.jKN = z;
    }

    /* loaded from: classes22.dex */
    public class a extends RecyclerView.ViewHolder {
        public com.baidu.tbadk.core.view.userLike.c akZ;
        public TextView eBQ;
        public TextView jKS;
        public HeadPendantClickableView jKT;
        public DynamicUserLikeButton jKU;
        private boolean jKV;
        public LinearLayout mContainer;

        public a(View view) {
            super(view);
            this.jKV = false;
            this.mContainer = (LinearLayout) view.findViewById(R.id.concern_container);
            this.jKT = (HeadPendantClickableView) view.findViewById(R.id.concern_user_image);
            this.jKT.getHeadView().setIsRound(true);
            this.jKT.getHeadView().setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.jKT.getHeadView().setDefaultResource(17170445);
            this.jKT.getHeadView().setDefaultErrorResource(R.drawable.icon_default_avatar100);
            this.jKT.getHeadView().setPlaceHolder(1);
            this.jKT.getHeadView().setBorderWidth(com.baidu.adp.lib.util.l.getDimens(t.this.mContext, R.dimen.tbds1));
            this.jKT.getHeadView().setBorderColor(ap.getColor(R.color.CAM_X0401));
            this.eBQ = (TextView) view.findViewById(R.id.concern_user_name);
            this.jKS = (TextView) view.findViewById(R.id.concern_user_desc);
            this.jKU = (DynamicUserLikeButton) view.findViewById(R.id.user_recommend_like_btn);
            this.akZ = new com.baidu.tbadk.core.view.userLike.c(t.this.mPageContext, this.jKU);
        }

        public void onChangeSkinType(int i) {
            if (!this.jKV) {
                ap.setViewTextColor(this.eBQ, R.color.CAM_X0105);
            } else {
                ap.setViewTextColor(this.eBQ, R.color.CAM_X0301);
            }
            ap.setViewTextColor(this.jKS, R.color.CAM_X0109);
            this.jKU.onChangeSkinType(i);
            com.baidu.tbadk.core.elementsMaven.c.bm(this.mContainer).pA(R.string.J_X05).setBackGroundColor(R.color.CAM_X0206);
        }

        public void rs(boolean z) {
            this.jKV = z;
        }
    }

    public void setPageContext(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.fhh = bdUniqueId;
    }
}
