package com.baidu.tieba.homepage.personalize.a;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.ala.atomdata.AlaSDKShareEmptyActivityConfig;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.atomData.AlaLiveTabMyConcernActivityConfig;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import tbclient.AlaLiveInfo;
/* loaded from: classes9.dex */
public class a extends RecyclerView.Adapter<C0636a> {
    private Context mContext;
    private List<com.baidu.tieba.homepage.personalize.data.j> mDatas;
    private int mSkinType = 3;
    private HashSet<Long> isU = new HashSet<>();

    public a(Context context) {
        this.mContext = context;
    }

    public void setData(List<AlaLiveInfo> list) {
        if (!com.baidu.tbadk.core.util.w.isEmpty(list)) {
            if (this.mDatas == null) {
                this.mDatas = new ArrayList();
            }
            this.mDatas.clear();
            com.baidu.tieba.homepage.personalize.data.j jVar = new com.baidu.tieba.homepage.personalize.data.j();
            jVar.setType(1);
            this.mDatas.add(jVar);
            if (list != null && list.size() > 12) {
                list = com.baidu.tbadk.core.util.w.subList(list, 0, 12);
            }
            for (AlaLiveInfo alaLiveInfo : list) {
                if (alaLiveInfo != null && alaLiveInfo.user_info != null && !StringUtils.isNull(alaLiveInfo.user_info.user_name) && alaLiveInfo.live_id.longValue() != 0) {
                    com.baidu.tieba.homepage.personalize.data.j jVar2 = new com.baidu.tieba.homepage.personalize.data.j();
                    jVar2.setType(0);
                    jVar2.setPortrait(alaLiveInfo.user_info.portrait);
                    jVar2.setUsername(alaLiveInfo.user_info.user_name);
                    jVar2.setLiveId(alaLiveInfo.live_id.longValue());
                    jVar2.setThreadId(alaLiveInfo.thread_id.longValue());
                    jVar2.er(alaLiveInfo.user_info.ala_id.longValue());
                    jVar2.xn(alaLiveInfo.live_type.intValue());
                    this.mDatas.add(jVar2);
                }
            }
            if (this.mDatas.size() > 12) {
                com.baidu.tieba.homepage.personalize.data.j jVar3 = new com.baidu.tieba.homepage.personalize.data.j();
                jVar3.setType(2);
                this.mDatas.add(jVar3);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    @NonNull
    /* renamed from: z */
    public C0636a onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new C0636a(LayoutInflater.from(this.mContext).inflate(R.layout.ala_recommend_item, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(@NonNull C0636a c0636a, int i) {
        final com.baidu.tieba.homepage.personalize.data.j jVar;
        if (c0636a != null && this.mDatas != null && this.mDatas.size() > i && (jVar = this.mDatas.get(i)) != null) {
            if (jVar.getType() != 1) {
                if (jVar.getType() != 0) {
                    if (jVar.getType() == 2) {
                        c0636a.itb.setVisibility(8);
                        c0636a.itc.setVisibility(8);
                        c0636a.isZ.setVisibility(8);
                        c0636a.dEL.setText(TbadkCoreApplication.getInst().getString(R.string.attention_all));
                        c0636a.ita.setVisibility(0);
                        c0636a.ita.setImageResource(R.drawable.icon_pure_live_moe22);
                        c0636a.isX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.a.a.3
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                if (be.checkUpIsLogin(a.this.mContext)) {
                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveTabMyConcernActivityConfig(a.this.mContext)));
                                    ao aoVar = new ao("c13624");
                                    aoVar.s("uid", TbadkApplication.getCurrentAccountId());
                                    aoVar.ag("fid", 0);
                                    TiebaStatic.log(aoVar);
                                }
                            }
                        });
                    }
                } else {
                    c0636a.itb.setText(TbadkCoreApplication.getInst().getString(R.string.live_in));
                    c0636a.dZV.setPlaceHolder(1);
                    c0636a.dZV.setDefaultResource(R.drawable.transparent_bg);
                    if (!StringUtils.isNull(jVar.getPortrait())) {
                        c0636a.dZV.startLoad(jVar.getPortrait(), 10, false);
                    }
                    if (ar.getChineseAndEnglishLength(jVar.getUsername()) > 8) {
                        c0636a.dEL.setText(ar.cutChineseAndEnglishWithSuffix(jVar.getUsername(), 6, StringHelper.STRING_MORE));
                    } else {
                        c0636a.dEL.setText(jVar.getUsername());
                    }
                    final long liveId = jVar.getLiveId();
                    c0636a.isX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.a.a.2
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                            alaLiveInfoCoreData.liveID = liveId;
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(a.this.mContext, alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_PB_USER_ICON_LIVE, null, false, "")));
                            ao aoVar = new ao("c13623");
                            aoVar.s("uid", TbadkApplication.getCurrentAccountId());
                            aoVar.ag("fid", 0);
                            aoVar.s("tid", jVar.getThreadId());
                            aoVar.ag("obj_type", jVar.bEl());
                            aoVar.s("star_id", jVar.cke());
                            aoVar.s(AlaSDKShareEmptyActivityConfig.SHARE_ALA_SDK_LIVE_ID, liveId);
                            TiebaStatic.log(aoVar);
                        }
                    });
                    if (!this.isU.contains(Long.valueOf(liveId))) {
                        ao aoVar = new ao("c13622");
                        aoVar.s("uid", TbadkApplication.getCurrentAccountId());
                        aoVar.ag("fid", 0);
                        aoVar.s("tid", jVar.getThreadId());
                        aoVar.ag("obj_type", jVar.bEl());
                        aoVar.s("star_id", jVar.cke());
                        aoVar.s(AlaSDKShareEmptyActivityConfig.SHARE_ALA_SDK_LIVE_ID, liveId);
                        TiebaStatic.log(aoVar);
                        this.isU.add(Long.valueOf(liveId));
                    }
                }
            } else {
                c0636a.itb.setText(TbadkCoreApplication.getInst().getString(R.string.recommend_hot_live));
                c0636a.dZV.setImageResource(R.drawable.pic_live_hand_n);
                c0636a.dEL.setText(TbadkCoreApplication.getInst().getString(R.string.recommend_live_square));
                c0636a.isX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.a.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921445));
                        ao aoVar2 = new ao("c13621");
                        aoVar2.s("uid", TbadkApplication.getCurrentAccountId());
                        aoVar2.ag("fid", 0);
                        TiebaStatic.log(aoVar2);
                    }
                });
            }
            c0636a.ck(TbadkCoreApplication.getInst().getSkinType(), jVar.getType());
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.mDatas == null) {
            return 0;
        }
        return this.mDatas.size();
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        if (this.mDatas == null || this.mDatas.get(i) == null) {
            return 0;
        }
        return this.mDatas.get(i).getType();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onViewDetachedFromWindow(@NonNull C0636a c0636a) {
        super.onViewDetachedFromWindow(c0636a);
        if (c0636a != null && c0636a.isY != null) {
            c0636a.isY.cancel();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: b */
    public void onViewAttachedToWindow(@NonNull C0636a c0636a) {
        super.onViewAttachedToWindow(c0636a);
        if (c0636a != null && c0636a.isY != null) {
            c0636a.isY.start();
        }
    }

    /* renamed from: com.baidu.tieba.homepage.personalize.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class C0636a extends RecyclerView.ViewHolder {
        private TextView dEL;
        private HeadImageView dZV;
        private View isX;
        public ObjectAnimator isY;
        private ImageView isZ;
        private TbImageView ita;
        private TBSpecificationBtn itb;
        private TbImageView itc;

        public C0636a(View view) {
            super(view);
            this.isX = view.findViewById(R.id.ala_recommend_container);
            this.itc = (TbImageView) view.findViewById(R.id.ala_animation_background);
            an.setImageResource(this.itc, R.drawable.icon_mask_live);
            this.isY = ObjectAnimator.ofFloat(this.itc, "rotation", 0.0f, 359.0f);
            this.isY.setRepeatCount(-1);
            this.isY.setDuration(10000L);
            this.isY.setInterpolator(new LinearInterpolator());
            this.isZ = (ImageView) view.findViewById(R.id.ala_gradient_background);
            this.dZV = (HeadImageView) view.findViewById(R.id.ala_protrait);
            this.dZV.setRadius(com.baidu.adp.lib.util.l.getDimens(a.this.mContext, R.dimen.tbds63));
            this.ita = (TbImageView) view.findViewById(R.id.ala_recommend_more);
            this.itb = (TBSpecificationBtn) view.findViewById(R.id.ala_sign_icon);
            com.baidu.tbadk.core.view.commonBtn.b bVar = new com.baidu.tbadk.core.view.commonBtn.b();
            bVar.mC(R.color.cp_other_d);
            bVar.mA(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds15));
            bVar.aQ(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds120), com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds46));
            this.itb.setTextSize(R.dimen.tbds26);
            this.itb.setClickState(false);
            this.itb.setConfig(bVar);
            this.dEL = (TextView) view.findViewById(R.id.ala_recommend_user_name);
        }

        public void ck(int i, int i2) {
            if (i != a.this.mSkinType) {
                an.setViewTextColor(this.itb, (int) R.color.cp_cont_a);
                an.setViewTextColor(this.dEL, (int) R.color.cp_cont_b);
                an.setImageResource(this.itc, R.drawable.icon_mask_live);
                SvgManager.aWQ().a(this.isZ, R.drawable.ic_icon_pure_live_stroke, SvgManager.SvgResourceStateType.NORMAL);
                this.itb.aYj();
                if (i2 == 1) {
                    an.setImageResource(this.dZV, R.drawable.pic_live_hand_n);
                } else if (i2 == 2) {
                    an.setImageResource(this.ita, R.drawable.icon_pure_live_moe22);
                    an.c(this.dZV, com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds63), R.color.cp_bg_line_b, R.color.cp_bg_line_b);
                }
                an.setViewTextColor(this.dEL, (int) R.color.cp_cont_b);
            }
        }
    }
}
