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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.bh;
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
    private HashSet<Long> kjC = new HashSet<>();

    public AlaRecommendListAdapter(Context context) {
        this.mContext = context;
    }

    public void setData(List<AlaLiveInfo> list) {
        if (!com.baidu.tbadk.core.util.y.isEmpty(list)) {
            if (this.mDatas == null) {
                this.mDatas = new ArrayList();
            }
            this.mDatas.clear();
            com.baidu.tieba.homepage.personalize.data.j jVar = new com.baidu.tieba.homepage.personalize.data.j();
            jVar.setType(1);
            this.mDatas.add(jVar);
            if (list != null && list.size() > 12) {
                list = com.baidu.tbadk.core.util.y.subList(list, 0, 12);
            }
            for (AlaLiveInfo alaLiveInfo : list) {
                if (alaLiveInfo != null && alaLiveInfo.user_info != null && !StringUtils.isNull(alaLiveInfo.user_info.user_name) && alaLiveInfo.live_id.longValue() != 0) {
                    com.baidu.tieba.homepage.personalize.data.j jVar2 = new com.baidu.tieba.homepage.personalize.data.j();
                    jVar2.setType(0);
                    jVar2.setPortrait(alaLiveInfo.user_info.portrait);
                    jVar2.setUsername(alaLiveInfo.user_info.user_name);
                    jVar2.setLiveId(alaLiveInfo.live_id.longValue());
                    jVar2.setThreadId(alaLiveInfo.thread_id.longValue());
                    jVar2.gG(alaLiveInfo.user_info.ala_id.longValue());
                    jVar2.BY(alaLiveInfo.live_type.intValue());
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
    /* renamed from: I */
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
                        alaUserInfoViewHolder.kjJ.setVisibility(8);
                        alaUserInfoViewHolder.kjK.setVisibility(8);
                        alaUserInfoViewHolder.kjH.setVisibility(8);
                        alaUserInfoViewHolder.eIO.setText(TbadkCoreApplication.getInst().getString(R.string.attention_all));
                        alaUserInfoViewHolder.kjI.setVisibility(0);
                        alaUserInfoViewHolder.kjI.setImageResource(R.drawable.icon_pure_live_moe22);
                        alaUserInfoViewHolder.kjF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.adapter.AlaRecommendListAdapter.3
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                if (bh.checkUpIsLogin(AlaRecommendListAdapter.this.mContext)) {
                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveTabMyConcernActivityConfig(AlaRecommendListAdapter.this.mContext)));
                                    ar arVar = new ar("c13624");
                                    arVar.v("uid", TbadkApplication.getCurrentAccountId());
                                    arVar.ap("fid", 0);
                                    TiebaStatic.log(arVar);
                                }
                            }
                        });
                    }
                } else {
                    alaUserInfoViewHolder.kjJ.setText(TbadkCoreApplication.getInst().getString(R.string.live_in));
                    alaUserInfoViewHolder.ffU.setPlaceHolder(1);
                    alaUserInfoViewHolder.ffU.setDefaultResource(R.drawable.transparent_bg);
                    if (!StringUtils.isNull(jVar.getPortrait())) {
                        alaUserInfoViewHolder.ffU.startLoad(jVar.getPortrait(), 10, false);
                    }
                    if (au.getChineseAndEnglishLength(jVar.getUsername()) > 8) {
                        alaUserInfoViewHolder.eIO.setText(au.cutChineseAndEnglishWithSuffix(jVar.getUsername(), 6, StringHelper.STRING_MORE));
                    } else {
                        alaUserInfoViewHolder.eIO.setText(jVar.getUsername());
                    }
                    final long liveId = jVar.getLiveId();
                    alaUserInfoViewHolder.kjF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.adapter.AlaRecommendListAdapter.2
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                            alaLiveInfoCoreData.liveID = liveId;
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(AlaRecommendListAdapter.this.mContext, alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_PB_USER_ICON_LIVE, null, false, "")));
                            ar arVar = new ar("c13623");
                            arVar.v("uid", TbadkApplication.getCurrentAccountId());
                            arVar.ap("fid", 0);
                            arVar.v("tid", jVar.getThreadId());
                            arVar.ap("obj_type", jVar.bRf());
                            arVar.v("star_id", jVar.cRN());
                            arVar.v(AlaSDKShareEmptyActivityConfig.SHARE_ALA_SDK_LIVE_ID, liveId);
                            TiebaStatic.log(arVar);
                        }
                    });
                    if (!this.kjC.contains(Long.valueOf(liveId))) {
                        ar arVar = new ar("c13622");
                        arVar.v("uid", TbadkApplication.getCurrentAccountId());
                        arVar.ap("fid", 0);
                        arVar.v("tid", jVar.getThreadId());
                        arVar.ap("obj_type", jVar.bRf());
                        arVar.v("star_id", jVar.cRN());
                        arVar.v(AlaSDKShareEmptyActivityConfig.SHARE_ALA_SDK_LIVE_ID, liveId);
                        TiebaStatic.log(arVar);
                        this.kjC.add(Long.valueOf(liveId));
                    }
                }
            } else {
                alaUserInfoViewHolder.kjJ.setText(TbadkCoreApplication.getInst().getString(R.string.recommend_hot_live));
                alaUserInfoViewHolder.ffU.setImageResource(R.drawable.pic_live_hand_n);
                alaUserInfoViewHolder.eIO.setText(TbadkCoreApplication.getInst().getString(R.string.recommend_live_square));
                alaUserInfoViewHolder.kjF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.adapter.AlaRecommendListAdapter.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921445));
                        ar arVar2 = new ar("c13621");
                        arVar2.v("uid", TbadkApplication.getCurrentAccountId());
                        arVar2.ap("fid", 0);
                        TiebaStatic.log(arVar2);
                    }
                });
            }
            alaUserInfoViewHolder.cC(TbadkCoreApplication.getInst().getSkinType(), jVar.getType());
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
        if (alaUserInfoViewHolder != null && alaUserInfoViewHolder.kjG != null) {
            alaUserInfoViewHolder.kjG.cancel();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: b */
    public void onViewAttachedToWindow(@NonNull AlaUserInfoViewHolder alaUserInfoViewHolder) {
        super.onViewAttachedToWindow(alaUserInfoViewHolder);
        if (alaUserInfoViewHolder != null && alaUserInfoViewHolder.kjG != null) {
            alaUserInfoViewHolder.kjG.start();
        }
    }

    /* loaded from: classes2.dex */
    public class AlaUserInfoViewHolder extends RecyclerView.ViewHolder {
        private TextView eIO;
        private HeadImageView ffU;
        private View kjF;
        public ObjectAnimator kjG;
        private ImageView kjH;
        private TbImageView kjI;
        private TBSpecificationBtn kjJ;
        private TbImageView kjK;

        public AlaUserInfoViewHolder(View view) {
            super(view);
            this.kjF = view.findViewById(R.id.ala_recommend_container);
            this.kjK = (TbImageView) view.findViewById(R.id.ala_animation_background);
            ap.setImageResource(this.kjK, R.drawable.icon_mask_live);
            this.kjG = ObjectAnimator.ofFloat(this.kjK, "rotation", 0.0f, 359.0f);
            this.kjG.setRepeatCount(-1);
            this.kjG.setDuration(10000L);
            this.kjG.setInterpolator(new LinearInterpolator());
            this.kjH = (ImageView) view.findViewById(R.id.ala_gradient_background);
            this.ffU = (HeadImageView) view.findViewById(R.id.ala_protrait);
            this.ffU.setRadius(com.baidu.adp.lib.util.l.getDimens(AlaRecommendListAdapter.this.mContext, R.dimen.tbds63));
            this.kjI = (TbImageView) view.findViewById(R.id.ala_recommend_more);
            this.kjJ = (TBSpecificationBtn) view.findViewById(R.id.ala_sign_icon);
            com.baidu.tbadk.core.view.commonBtn.a aVar = new com.baidu.tbadk.core.view.commonBtn.a();
            aVar.pR(R.color.CAM_X0310);
            aVar.pO(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds15));
            aVar.aW(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds120), com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds46));
            this.kjJ.setTextSize(R.dimen.tbds26);
            this.kjJ.setClickState(false);
            this.kjJ.setConfig(aVar);
            this.eIO = (TextView) view.findViewById(R.id.ala_recommend_user_name);
        }

        public void cC(int i, int i2) {
            if (i != AlaRecommendListAdapter.this.mSkinType) {
                ap.setViewTextColor(this.kjJ, R.color.CAM_X0101);
                ap.setViewTextColor(this.eIO, R.color.CAM_X0105);
                ap.setImageResource(this.kjK, R.drawable.icon_mask_live);
                SvgManager.bsR().a(this.kjH, R.drawable.ic_icon_pure_live_stroke, SvgManager.SvgResourceStateType.NORMAL);
                this.kjJ.bup();
                if (i2 == 1) {
                    ap.setImageResource(this.ffU, R.drawable.pic_live_hand_n);
                } else if (i2 == 2) {
                    ap.setImageResource(this.kjI, R.drawable.icon_pure_live_moe22);
                    ap.d(this.ffU, com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds63), R.color.CAM_X0203, R.color.CAM_X0203);
                }
                ap.setViewTextColor(this.eIO, R.color.CAM_X0105);
            }
        }
    }
}
