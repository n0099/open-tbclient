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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
import com.baidu.tieba.R;
import com.baidu.tieba.view.DynamicUserLikeButton;
import java.util.List;
/* loaded from: classes9.dex */
public class q extends RecyclerView.Adapter<a> {
    private com.baidu.tbadk.h.f<MetaData> agW;
    private BdUniqueId ehF;
    private Context mContext;
    private List<MetaData> mData;
    private TbPageContext mPageContext;
    private int mSkinType = 3;

    public void setOnItemCoverListener(com.baidu.tbadk.h.f<MetaData> fVar) {
        this.agW = fVar;
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
            aVar.op(metaData.isNewGod());
            a(metaData, aVar);
            c(metaData, aVar);
            e(metaData, aVar);
            b(metaData, aVar);
            if (this.agW != null) {
                this.agW.b(aVar.itemView, metaData, i, i);
            }
            aVar.onChangeSkinType(this.mSkinType);
        }
    }

    private void a(final MetaData metaData, final a aVar) {
        aVar.ina.setData(metaData, true);
        aVar.ina.setAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.a.q.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ao aoVar = new ao("c13566");
                aoVar.ag("obj_locate", 2);
                TiebaStatic.log(aoVar);
                q.this.d(metaData, aVar);
            }
        });
    }

    private void b(final MetaData metaData, a aVar) {
        aVar.inb.setOnClickEvent(new DynamicUserLikeButton.a() { // from class: com.baidu.tieba.homepage.concern.a.q.2
            @Override // com.baidu.tieba.view.DynamicUserLikeButton.a
            public void bR(View view) {
                if (metaData != null) {
                    if (metaData.getIsLike()) {
                        TiebaStatic.log(new ao("c13571"));
                        return;
                    }
                    ao aoVar = new ao("c13566");
                    aoVar.ag("obj_locate", 1);
                    aoVar.s("obj_id", TbadkCoreApplication.getCurrentAccountId());
                    aoVar.dk("obj_param1", metaData.getUserId());
                    TiebaStatic.log(aoVar);
                }
            }
        });
        com.baidu.tbadk.core.view.userLike.c cVar = aVar.ahX;
        if (cVar != null) {
            cVar.l(this.ehF);
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
            aVar.dEL.setText(str);
            if (metaData.isNewGod()) {
                an.setViewTextColor(aVar.dEL, (int) R.color.cp_cont_h);
            }
            aVar.dEL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.a.q.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (metaData != null && !StringUtils.isNull(metaData.getUserId())) {
                        ao aoVar = new ao("c13566");
                        aoVar.ag("obj_locate", 2);
                        TiebaStatic.log(aoVar);
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(q.this.mContext, metaData.getUserId(), metaData.getName_show())));
                        q.this.d(metaData, aVar);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(MetaData metaData, a aVar) {
        if (this.agW != null) {
            this.agW.a(aVar.itemView, metaData, aVar.getAdapterPosition(), aVar.getItemId());
        }
    }

    private void e(MetaData metaData, a aVar) {
        if (metaData != null && aVar != null) {
            String str = "";
            if (metaData.isBaijiahaoUser()) {
                str = metaData.getBaijiahaoInfo().auth_desc;
                if (ar.isEmpty(str)) {
                    str = "";
                }
            } else if (metaData.isNewGod()) {
                String fieldName = metaData.getNewGodData().getFieldName();
                if (!ar.isEmpty(fieldName)) {
                    str = fieldName + TbadkCoreApplication.getInst().getApp().getString(R.string.field_new_god);
                } else {
                    str = "";
                }
            }
            aVar.imZ.setText(str);
        }
    }

    public void onChangeSkinType(int i) {
        this.mSkinType = i;
    }

    /* loaded from: classes9.dex */
    public class a extends RecyclerView.ViewHolder {
        public com.baidu.tbadk.core.view.userLike.c ahX;
        public TextView dEL;
        public TextView imZ;
        public HeadPendantClickableView ina;
        public DynamicUserLikeButton inb;
        private boolean inc;
        public LinearLayout mContainer;

        public a(View view) {
            super(view);
            this.inc = false;
            this.mContainer = (LinearLayout) view.findViewById(R.id.concern_container);
            this.ina = (HeadPendantClickableView) view.findViewById(R.id.concern_user_image);
            this.ina.getHeadView().setIsRound(true);
            this.ina.getHeadView().setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.ina.getHeadView().setDefaultResource(17170445);
            this.ina.getHeadView().setDefaultErrorResource(R.drawable.icon_default_avatar100);
            this.ina.getHeadView().setPlaceHolder(2);
            this.ina.getHeadView().setBorderWidth(com.baidu.adp.lib.util.l.getDimens(q.this.mContext, R.dimen.tbds1));
            this.ina.getHeadView().setBorderColor(an.getColor(R.color.cp_border_a));
            this.dEL = (TextView) view.findViewById(R.id.concern_user_name);
            this.imZ = (TextView) view.findViewById(R.id.concern_user_desc);
            this.inb = (DynamicUserLikeButton) view.findViewById(R.id.user_recommend_like_btn);
            this.ahX = new com.baidu.tbadk.core.view.userLike.c(q.this.mPageContext, this.inb);
        }

        public void onChangeSkinType(int i) {
            if (!this.inc) {
                an.setViewTextColor(this.dEL, (int) R.color.cp_cont_b);
            } else {
                an.setViewTextColor(this.dEL, (int) R.color.cp_cont_h);
            }
            an.setViewTextColor(this.imZ, (int) R.color.cp_cont_d);
            this.inb.onChangeSkinType(i);
        }

        public void op(boolean z) {
            this.inc = z;
        }
    }

    public void setPageContext(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.ehF = bdUniqueId;
    }
}
