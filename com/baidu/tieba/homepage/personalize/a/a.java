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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import tbclient.AlaLiveInfo;
/* loaded from: classes9.dex */
public class a extends RecyclerView.Adapter<C0627a> {
    private Context mContext;
    private List<com.baidu.tieba.homepage.personalize.data.i> mDatas;
    private int mSkinType = 3;
    private HashSet<Long> idR = new HashSet<>();

    public a(Context context) {
        this.mContext = context;
    }

    public void setData(List<AlaLiveInfo> list) {
        if (!com.baidu.tbadk.core.util.v.isEmpty(list)) {
            if (this.mDatas == null) {
                this.mDatas = new ArrayList();
            }
            this.mDatas.clear();
            com.baidu.tieba.homepage.personalize.data.i iVar = new com.baidu.tieba.homepage.personalize.data.i();
            iVar.setType(1);
            this.mDatas.add(iVar);
            if (list != null && list.size() > 12) {
                list = com.baidu.tbadk.core.util.v.subList(list, 0, 12);
            }
            for (AlaLiveInfo alaLiveInfo : list) {
                if (alaLiveInfo != null && alaLiveInfo.user_info != null && !StringUtils.isNull(alaLiveInfo.user_info.user_name) && alaLiveInfo.live_id.longValue() != 0) {
                    com.baidu.tieba.homepage.personalize.data.i iVar2 = new com.baidu.tieba.homepage.personalize.data.i();
                    iVar2.setType(0);
                    iVar2.setPortrait(alaLiveInfo.user_info.portrait);
                    iVar2.setUsername(alaLiveInfo.user_info.user_name);
                    iVar2.setLiveId(alaLiveInfo.live_id.longValue());
                    iVar2.setThreadId(alaLiveInfo.thread_id.longValue());
                    iVar2.eo(alaLiveInfo.user_info.ala_id.longValue());
                    iVar2.wH(alaLiveInfo.live_type.intValue());
                    this.mDatas.add(iVar2);
                }
            }
            if (this.mDatas.size() > 12) {
                com.baidu.tieba.homepage.personalize.data.i iVar3 = new com.baidu.tieba.homepage.personalize.data.i();
                iVar3.setType(2);
                this.mDatas.add(iVar3);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    @NonNull
    /* renamed from: w */
    public C0627a onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new C0627a(LayoutInflater.from(this.mContext).inflate(R.layout.ala_recommend_item, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(@NonNull C0627a c0627a, int i) {
        final com.baidu.tieba.homepage.personalize.data.i iVar;
        if (c0627a != null && this.mDatas != null && this.mDatas.size() > i && (iVar = this.mDatas.get(i)) != null) {
            if (iVar.getType() != 1) {
                if (iVar.getType() != 0) {
                    if (iVar.getType() == 2) {
                        c0627a.idY.setVisibility(8);
                        c0627a.idZ.setVisibility(8);
                        c0627a.idW.setVisibility(8);
                        c0627a.dXU.setText(TbadkCoreApplication.getInst().getString(R.string.attention_all));
                        c0627a.idX.setVisibility(0);
                        c0627a.idX.setImageResource(R.drawable.icon_pure_live_moe22);
                        c0627a.idU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.a.a.3
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                if (bc.checkUpIsLogin(a.this.mContext)) {
                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveTabMyConcernActivityConfig(a.this.mContext)));
                                    an anVar = new an("c13624");
                                    anVar.s("uid", TbadkApplication.getCurrentAccountId());
                                    anVar.ag("fid", 0);
                                    TiebaStatic.log(anVar);
                                }
                            }
                        });
                    }
                } else {
                    c0627a.idY.setText(TbadkCoreApplication.getInst().getString(R.string.live_in));
                    c0627a.dTc.setPlaceHolder(1);
                    c0627a.dTc.setDefaultResource(R.drawable.transparent_bg);
                    if (!StringUtils.isNull(iVar.getPortrait())) {
                        c0627a.dTc.startLoad(iVar.getPortrait(), 10, false);
                    }
                    if (aq.getChineseAndEnglishLength(iVar.getUsername()) > 8) {
                        c0627a.dXU.setText(aq.cutChineseAndEnglishWithSuffix(iVar.getUsername(), 6, StringHelper.STRING_MORE));
                    } else {
                        c0627a.dXU.setText(iVar.getUsername());
                    }
                    final long liveId = iVar.getLiveId();
                    c0627a.idU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.a.a.2
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                            alaLiveInfoCoreData.liveID = liveId;
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(a.this.mContext, alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_PB_USER_ICON_LIVE, null, false, "")));
                            an anVar = new an("c13623");
                            anVar.s("uid", TbadkApplication.getCurrentAccountId());
                            anVar.ag("fid", 0);
                            anVar.s("tid", iVar.getThreadId());
                            anVar.ag("obj_type", iVar.bBi());
                            anVar.s("star_id", iVar.cgD());
                            anVar.s(AlaSDKShareEmptyActivityConfig.SHARE_ALA_SDK_LIVE_ID, liveId);
                            TiebaStatic.log(anVar);
                        }
                    });
                    if (!this.idR.contains(Long.valueOf(liveId))) {
                        an anVar = new an("c13622");
                        anVar.s("uid", TbadkApplication.getCurrentAccountId());
                        anVar.ag("fid", 0);
                        anVar.s("tid", iVar.getThreadId());
                        anVar.ag("obj_type", iVar.bBi());
                        anVar.s("star_id", iVar.cgD());
                        anVar.s(AlaSDKShareEmptyActivityConfig.SHARE_ALA_SDK_LIVE_ID, liveId);
                        TiebaStatic.log(anVar);
                        this.idR.add(Long.valueOf(liveId));
                    }
                }
            } else {
                c0627a.idY.setText(TbadkCoreApplication.getInst().getString(R.string.recommend_hot_live));
                c0627a.dTc.setImageResource(R.drawable.pic_live_hand_n);
                c0627a.dXU.setText(TbadkCoreApplication.getInst().getString(R.string.recommend_live_square));
                c0627a.idU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.a.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921445));
                        an anVar2 = new an("c13621");
                        anVar2.s("uid", TbadkApplication.getCurrentAccountId());
                        anVar2.ag("fid", 0);
                        TiebaStatic.log(anVar2);
                    }
                });
            }
            c0627a.ce(TbadkCoreApplication.getInst().getSkinType(), iVar.getType());
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
    public void onViewDetachedFromWindow(@NonNull C0627a c0627a) {
        super.onViewDetachedFromWindow(c0627a);
        if (c0627a != null && c0627a.idV != null) {
            c0627a.idV.cancel();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: b */
    public void onViewAttachedToWindow(@NonNull C0627a c0627a) {
        super.onViewAttachedToWindow(c0627a);
        if (c0627a != null && c0627a.idV != null) {
            c0627a.idV.start();
        }
    }

    /* renamed from: com.baidu.tieba.homepage.personalize.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class C0627a extends RecyclerView.ViewHolder {
        private HeadImageView dTc;
        private TextView dXU;
        private View idU;
        public ObjectAnimator idV;
        private ImageView idW;
        private TbImageView idX;
        private TBSpecificationBtn idY;
        private TbImageView idZ;

        public C0627a(View view) {
            super(view);
            this.idU = view.findViewById(R.id.ala_recommend_container);
            this.idZ = (TbImageView) view.findViewById(R.id.ala_animation_background);
            am.setImageResource(this.idZ, R.drawable.icon_mask_live);
            this.idV = ObjectAnimator.ofFloat(this.idZ, "rotation", 0.0f, 359.0f);
            this.idV.setRepeatCount(-1);
            this.idV.setDuration(10000L);
            this.idV.setInterpolator(new LinearInterpolator());
            this.idW = (ImageView) view.findViewById(R.id.ala_gradient_background);
            this.dTc = (HeadImageView) view.findViewById(R.id.ala_protrait);
            this.dTc.setRadius(com.baidu.adp.lib.util.l.getDimens(a.this.mContext, R.dimen.tbds63));
            this.idX = (TbImageView) view.findViewById(R.id.ala_recommend_more);
            this.idY = (TBSpecificationBtn) view.findViewById(R.id.ala_sign_icon);
            com.baidu.tbadk.core.view.commonBtn.b bVar = new com.baidu.tbadk.core.view.commonBtn.b();
            bVar.mk(R.color.cp_other_d);
            bVar.mi(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds15));
            bVar.aN(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds120), com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds46));
            this.idY.setTextSize(R.dimen.tbds26);
            this.idY.setClickState(false);
            this.idY.setConfig(bVar);
            this.dXU = (TextView) view.findViewById(R.id.ala_recommend_user_name);
        }

        public void ce(int i, int i2) {
            if (i != a.this.mSkinType) {
                am.setViewTextColor(this.idY, (int) R.color.cp_cont_a);
                am.setViewTextColor(this.dXU, (int) R.color.cp_cont_b);
                am.setImageResource(this.idZ, R.drawable.icon_mask_live);
                SvgManager.aUW().a(this.idW, R.drawable.ic_icon_pure_live_stroke, SvgManager.SvgResourceStateType.NORMAL);
                this.idY.aWr();
                if (i2 == 1) {
                    am.setImageResource(this.dTc, R.drawable.pic_live_hand_n);
                } else if (i2 == 2) {
                    am.setImageResource(this.idX, R.drawable.icon_pure_live_moe22);
                    am.c(this.dTc, com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds63), R.color.cp_bg_line_b, R.color.cp_bg_line_b);
                }
                am.setViewTextColor(this.dXU, (int) R.color.cp_cont_b);
            }
        }
    }
}
