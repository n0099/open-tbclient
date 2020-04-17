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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
import com.baidu.tieba.R;
import com.baidu.tieba.view.DynamicUserLikeButton;
import java.util.List;
import tbclient.BaijiahaoInfo;
/* loaded from: classes9.dex */
public class o extends RecyclerView.Adapter<a> {
    private BdUniqueId dKA;
    private Context mContext;
    private List<MetaData> mData;
    private TbPageContext mPageContext;
    private int mSkinType = 3;

    public o(Context context) {
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
            a(metaData, aVar);
            c(metaData, aVar);
            d(metaData, aVar);
            b(metaData, aVar);
            aVar.onChangeSkinType(this.mSkinType);
        }
    }

    private void a(MetaData metaData, a aVar) {
        aVar.hIX.setData(metaData, true);
        aVar.hIX.setAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.a.o.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                an anVar = new an("c13566");
                anVar.af("obj_locate", 2);
                TiebaStatic.log(anVar);
            }
        });
    }

    private void b(final MetaData metaData, a aVar) {
        aVar.hIY.setOnClickEvent(new DynamicUserLikeButton.a() { // from class: com.baidu.tieba.homepage.concern.a.o.2
            @Override // com.baidu.tieba.view.DynamicUserLikeButton.a
            public void G(View view) {
                if (metaData != null) {
                    if (metaData.getIsLike()) {
                        TiebaStatic.log(new an("c13571"));
                        return;
                    }
                    an anVar = new an("c13566");
                    anVar.af("obj_locate", 1);
                    anVar.t("obj_id", TbadkCoreApplication.getCurrentAccountId());
                    anVar.cI("obj_param1", metaData.getUserId());
                    TiebaStatic.log(anVar);
                }
            }
        });
        com.baidu.tbadk.core.view.userLike.c cVar = aVar.agm;
        if (cVar != null) {
            cVar.j(this.dKA);
            cVar.a(metaData);
        }
    }

    private void c(final MetaData metaData, a aVar) {
        if (metaData != null && aVar != null) {
            String str = "";
            if (!StringUtils.isNull(metaData.getName_show())) {
                str = metaData.getName_show();
            } else if (metaData.getBaijiahaoInfo() != null && !StringUtils.isNull(metaData.getBaijiahaoInfo().name)) {
                str = metaData.getBaijiahaoInfo().name;
            }
            aVar.cAX.setText(str);
            aVar.cAX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.a.o.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (metaData != null && !StringUtils.isNull(metaData.getUserId())) {
                        an anVar = new an("c13566");
                        anVar.af("obj_locate", 2);
                        TiebaStatic.log(anVar);
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(o.this.mContext, metaData.getUserId(), metaData.getName_show())));
                    }
                }
            });
        }
    }

    private void d(MetaData metaData, a aVar) {
        BaijiahaoInfo baijiahaoInfo;
        if (metaData != null && aVar != null && (baijiahaoInfo = metaData.getBaijiahaoInfo()) != null && baijiahaoInfo.auth_id.intValue() > 0) {
            String str = baijiahaoInfo.auth_desc;
            if (aq.isEmpty(str)) {
                str = "";
            }
            aVar.hIW.setText(str);
        }
    }

    public void onChangeSkinType(int i) {
        this.mSkinType = i;
    }

    /* loaded from: classes9.dex */
    public class a extends RecyclerView.ViewHolder {
        public com.baidu.tbadk.core.view.userLike.c agm;
        public TextView cAX;
        public TextView hIW;
        public HeadPendantClickableView hIX;
        public DynamicUserLikeButton hIY;
        public LinearLayout mContainer;

        public a(View view) {
            super(view);
            this.mContainer = (LinearLayout) view.findViewById(R.id.concern_container);
            this.hIX = (HeadPendantClickableView) view.findViewById(R.id.concern_user_image);
            this.hIX.getHeadView().setIsRound(true);
            this.hIX.getHeadView().setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.hIX.getHeadView().setDefaultResource(17170445);
            this.hIX.getHeadView().setDefaultErrorResource(R.drawable.icon_default_avatar100);
            this.hIX.getHeadView().setPlaceHolder(2);
            this.hIX.getHeadView().setBorderWidth(com.baidu.adp.lib.util.l.getDimens(o.this.mContext, R.dimen.tbds1));
            this.hIX.getHeadView().setBorderColor(am.getColor(R.color.cp_border_a));
            this.cAX = (TextView) view.findViewById(R.id.concern_user_name);
            this.hIW = (TextView) view.findViewById(R.id.concern_user_desc);
            this.hIY = (DynamicUserLikeButton) view.findViewById(R.id.user_recommend_like_btn);
            this.agm = new com.baidu.tbadk.core.view.userLike.c(o.this.mPageContext, this.hIY);
        }

        public void onChangeSkinType(int i) {
            am.setViewTextColor(this.cAX, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.hIW, (int) R.color.cp_cont_d);
            this.hIY.onChangeSkinType(i);
        }
    }

    public void setPageContext(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.dKA = bdUniqueId;
    }
}
