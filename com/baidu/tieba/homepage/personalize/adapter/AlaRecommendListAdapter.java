package com.baidu.tieba.homepage.personalize.adapter;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import tbclient.AlaLiveInfo;
/* loaded from: classes2.dex */
public class AlaRecommendListAdapter extends RecyclerView.Adapter<AlaUserInfoViewHolder> {
    private Context mContext;
    private List<com.baidu.tieba.homepage.personalize.data.j> mDatas;
    private int mSkinType = 3;
    private HashSet<Long> kbe = new HashSet<>();

    public AlaRecommendListAdapter(Context context) {
        this.mContext = context;
    }

    public void setData(List<AlaLiveInfo> list) {
        if (!com.baidu.tbadk.core.util.x.isEmpty(list)) {
            if (this.mDatas == null) {
                this.mDatas = new ArrayList();
            }
            this.mDatas.clear();
            com.baidu.tieba.homepage.personalize.data.j jVar = new com.baidu.tieba.homepage.personalize.data.j();
            jVar.setType(1);
            this.mDatas.add(jVar);
            if (list != null && list.size() > 12) {
                list = com.baidu.tbadk.core.util.x.subList(list, 0, 12);
            }
            for (AlaLiveInfo alaLiveInfo : list) {
                if (alaLiveInfo != null && alaLiveInfo.user_info != null && !StringUtils.isNull(alaLiveInfo.user_info.user_name) && alaLiveInfo.live_id.longValue() != 0) {
                    com.baidu.tieba.homepage.personalize.data.j jVar2 = new com.baidu.tieba.homepage.personalize.data.j();
                    jVar2.setType(0);
                    jVar2.setPortrait(alaLiveInfo.user_info.portrait);
                    jVar2.setUsername(alaLiveInfo.user_info.user_name);
                    jVar2.setLiveId(alaLiveInfo.live_id.longValue());
                    jVar2.setThreadId(alaLiveInfo.thread_id.longValue());
                    jVar2.gB(alaLiveInfo.user_info.ala_id.longValue());
                    jVar2.BG(alaLiveInfo.live_type.intValue());
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
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    /* renamed from: H */
    public AlaUserInfoViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new AlaUserInfoViewHolder(LayoutInflater.from(this.mContext).inflate(R.layout.ala_recommend_item, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(@NonNull AlaUserInfoViewHolder alaUserInfoViewHolder, int i) {
        final com.baidu.tieba.homepage.personalize.data.j jVar;
        if (alaUserInfoViewHolder != null && this.mDatas != null && this.mDatas.size() > i && (jVar = this.mDatas.get(i)) != null) {
            if (jVar.getType() != 1) {
                if (jVar.getType() != 0) {
                    if (jVar.getType() == 2) {
                        alaUserInfoViewHolder.kbl.setVisibility(8);
                        alaUserInfoViewHolder.kbm.setVisibility(8);
                        alaUserInfoViewHolder.kbj.setVisibility(8);
                        alaUserInfoViewHolder.eGI.setText(TbadkCoreApplication.getInst().getString(R.string.attention_all));
                        alaUserInfoViewHolder.kbk.setVisibility(0);
                        alaUserInfoViewHolder.kbk.setImageResource(R.drawable.icon_pure_live_moe22);
                        alaUserInfoViewHolder.kbh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.adapter.AlaRecommendListAdapter.3
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                if (bg.checkUpIsLogin(AlaRecommendListAdapter.this.mContext)) {
                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveTabMyConcernActivityConfig(AlaRecommendListAdapter.this.mContext)));
                                    aq aqVar = new aq("c13624");
                                    aqVar.w("uid", TbadkApplication.getCurrentAccountId());
                                    aqVar.an("fid", 0);
                                    TiebaStatic.log(aqVar);
                                }
                            }
                        });
                    }
                } else {
                    alaUserInfoViewHolder.kbl.setText(TbadkCoreApplication.getInst().getString(R.string.live_in));
                    alaUserInfoViewHolder.fdF.setPlaceHolder(1);
                    alaUserInfoViewHolder.fdF.setDefaultResource(R.drawable.transparent_bg);
                    if (!StringUtils.isNull(jVar.getPortrait())) {
                        alaUserInfoViewHolder.fdF.startLoad(jVar.getPortrait(), 10, false);
                    }
                    if (at.getChineseAndEnglishLength(jVar.getUsername()) > 8) {
                        alaUserInfoViewHolder.eGI.setText(at.cutChineseAndEnglishWithSuffix(jVar.getUsername(), 6, StringHelper.STRING_MORE));
                    } else {
                        alaUserInfoViewHolder.eGI.setText(jVar.getUsername());
                    }
                    final long liveId = jVar.getLiveId();
                    alaUserInfoViewHolder.kbh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.adapter.AlaRecommendListAdapter.2
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                            alaLiveInfoCoreData.liveID = liveId;
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(AlaRecommendListAdapter.this.mContext, alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_PB_USER_ICON_LIVE, null, false, "")));
                            aq aqVar = new aq("c13623");
                            aqVar.w("uid", TbadkApplication.getCurrentAccountId());
                            aqVar.an("fid", 0);
                            aqVar.w("tid", jVar.getThreadId());
                            aqVar.an("obj_type", jVar.bQu());
                            aqVar.w("star_id", jVar.cPH());
                            aqVar.w(AlaSDKShareEmptyActivityConfig.SHARE_ALA_SDK_LIVE_ID, liveId);
                            TiebaStatic.log(aqVar);
                        }
                    });
                    if (!this.kbe.contains(Long.valueOf(liveId))) {
                        aq aqVar = new aq("c13622");
                        aqVar.w("uid", TbadkApplication.getCurrentAccountId());
                        aqVar.an("fid", 0);
                        aqVar.w("tid", jVar.getThreadId());
                        aqVar.an("obj_type", jVar.bQu());
                        aqVar.w("star_id", jVar.cPH());
                        aqVar.w(AlaSDKShareEmptyActivityConfig.SHARE_ALA_SDK_LIVE_ID, liveId);
                        TiebaStatic.log(aqVar);
                        this.kbe.add(Long.valueOf(liveId));
                    }
                }
            } else {
                alaUserInfoViewHolder.kbl.setText(TbadkCoreApplication.getInst().getString(R.string.recommend_hot_live));
                alaUserInfoViewHolder.fdF.setImageResource(R.drawable.pic_live_hand_n);
                alaUserInfoViewHolder.eGI.setText(TbadkCoreApplication.getInst().getString(R.string.recommend_live_square));
                alaUserInfoViewHolder.kbh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.adapter.AlaRecommendListAdapter.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921445));
                        aq aqVar2 = new aq("c13621");
                        aqVar2.w("uid", TbadkApplication.getCurrentAccountId());
                        aqVar2.an("fid", 0);
                        TiebaStatic.log(aqVar2);
                    }
                });
            }
            alaUserInfoViewHolder.cE(TbadkCoreApplication.getInst().getSkinType(), jVar.getType());
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.mDatas == null) {
            return 0;
        }
        return this.mDatas.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        if (this.mDatas == null || this.mDatas.get(i) == null) {
            return 0;
        }
        return this.mDatas.get(i).getType();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onViewDetachedFromWindow(@NonNull AlaUserInfoViewHolder alaUserInfoViewHolder) {
        super.onViewDetachedFromWindow(alaUserInfoViewHolder);
        if (alaUserInfoViewHolder != null && alaUserInfoViewHolder.kbi != null) {
            alaUserInfoViewHolder.kbi.cancel();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: b */
    public void onViewAttachedToWindow(@NonNull AlaUserInfoViewHolder alaUserInfoViewHolder) {
        super.onViewAttachedToWindow(alaUserInfoViewHolder);
        if (alaUserInfoViewHolder != null && alaUserInfoViewHolder.kbi != null) {
            alaUserInfoViewHolder.kbi.start();
        }
    }

    /* loaded from: classes2.dex */
    public class AlaUserInfoViewHolder extends RecyclerView.ViewHolder {
        private TextView eGI;
        private HeadImageView fdF;
        private View kbh;
        public ObjectAnimator kbi;
        private ImageView kbj;
        private TbImageView kbk;
        private TBSpecificationBtn kbl;
        private TbImageView kbm;

        public AlaUserInfoViewHolder(View view) {
            super(view);
            this.kbh = view.findViewById(R.id.ala_recommend_container);
            this.kbm = (TbImageView) view.findViewById(R.id.ala_animation_background);
            ao.setImageResource(this.kbm, R.drawable.icon_mask_live);
            this.kbi = ObjectAnimator.ofFloat(this.kbm, "rotation", 0.0f, 359.0f);
            this.kbi.setRepeatCount(-1);
            this.kbi.setDuration(10000L);
            this.kbi.setInterpolator(new LinearInterpolator());
            this.kbj = (ImageView) view.findViewById(R.id.ala_gradient_background);
            this.fdF = (HeadImageView) view.findViewById(R.id.ala_protrait);
            this.fdF.setRadius(com.baidu.adp.lib.util.l.getDimens(AlaRecommendListAdapter.this.mContext, R.dimen.tbds63));
            this.kbk = (TbImageView) view.findViewById(R.id.ala_recommend_more);
            this.kbl = (TBSpecificationBtn) view.findViewById(R.id.ala_sign_icon);
            com.baidu.tbadk.core.view.commonBtn.a aVar = new com.baidu.tbadk.core.view.commonBtn.a();
            aVar.pM(R.color.CAM_X0310);
            aVar.pJ(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds15));
            aVar.aZ(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds120), com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds46));
            this.kbl.setTextSize(R.dimen.tbds26);
            this.kbl.setClickState(false);
            this.kbl.setConfig(aVar);
            this.eGI = (TextView) view.findViewById(R.id.ala_recommend_user_name);
        }

        public void cE(int i, int i2) {
            if (i != AlaRecommendListAdapter.this.mSkinType) {
                ao.setViewTextColor(this.kbl, R.color.CAM_X0101);
                ao.setViewTextColor(this.eGI, R.color.CAM_X0105);
                ao.setImageResource(this.kbm, R.drawable.icon_mask_live);
                SvgManager.bsx().a(this.kbj, R.drawable.ic_icon_pure_live_stroke, SvgManager.SvgResourceStateType.NORMAL);
                this.kbl.btV();
                if (i2 == 1) {
                    ao.setImageResource(this.fdF, R.drawable.pic_live_hand_n);
                } else if (i2 == 2) {
                    ao.setImageResource(this.kbk, R.drawable.icon_pure_live_moe22);
                    ao.d(this.fdF, com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds63), R.color.CAM_X0203, R.color.CAM_X0203);
                }
                ao.setViewTextColor(this.eGI, R.color.CAM_X0105);
            }
        }
    }
}
