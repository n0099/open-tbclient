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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import tbclient.AlaLiveInfo;
/* loaded from: classes16.dex */
public class a extends RecyclerView.Adapter<C0646a> {
    private Context mContext;
    private List<com.baidu.tieba.homepage.personalize.data.j> mDatas;
    private int mSkinType = 3;
    private HashSet<Long> iza = new HashSet<>();

    public a(Context context) {
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
                    jVar2.eE(alaLiveInfo.user_info.ala_id.longValue());
                    jVar2.xF(alaLiveInfo.live_type.intValue());
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
    public C0646a onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new C0646a(LayoutInflater.from(this.mContext).inflate(R.layout.ala_recommend_item, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(@NonNull C0646a c0646a, int i) {
        final com.baidu.tieba.homepage.personalize.data.j jVar;
        if (c0646a != null && this.mDatas != null && this.mDatas.size() > i && (jVar = this.mDatas.get(i)) != null) {
            if (jVar.getType() != 1) {
                if (jVar.getType() != 0) {
                    if (jVar.getType() == 2) {
                        c0646a.izh.setVisibility(8);
                        c0646a.izi.setVisibility(8);
                        c0646a.izf.setVisibility(8);
                        c0646a.dKI.setText(TbadkCoreApplication.getInst().getString(R.string.attention_all));
                        c0646a.izg.setVisibility(0);
                        c0646a.izg.setImageResource(R.drawable.icon_pure_live_moe22);
                        c0646a.izd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.a.a.3
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                if (bf.checkUpIsLogin(a.this.mContext)) {
                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveTabMyConcernActivityConfig(a.this.mContext)));
                                    ap apVar = new ap("c13624");
                                    apVar.t("uid", TbadkApplication.getCurrentAccountId());
                                    apVar.ah("fid", 0);
                                    TiebaStatic.log(apVar);
                                }
                            }
                        });
                    }
                } else {
                    c0646a.izh.setText(TbadkCoreApplication.getInst().getString(R.string.live_in));
                    c0646a.egg.setPlaceHolder(1);
                    c0646a.egg.setDefaultResource(R.drawable.transparent_bg);
                    if (!StringUtils.isNull(jVar.getPortrait())) {
                        c0646a.egg.startLoad(jVar.getPortrait(), 10, false);
                    }
                    if (as.getChineseAndEnglishLength(jVar.getUsername()) > 8) {
                        c0646a.dKI.setText(as.cutChineseAndEnglishWithSuffix(jVar.getUsername(), 6, StringHelper.STRING_MORE));
                    } else {
                        c0646a.dKI.setText(jVar.getUsername());
                    }
                    final long liveId = jVar.getLiveId();
                    c0646a.izd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.a.a.2
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                            alaLiveInfoCoreData.liveID = liveId;
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(a.this.mContext, alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_PB_USER_ICON_LIVE, null, false, "")));
                            ap apVar = new ap("c13623");
                            apVar.t("uid", TbadkApplication.getCurrentAccountId());
                            apVar.ah("fid", 0);
                            apVar.t("tid", jVar.getThreadId());
                            apVar.ah("obj_type", jVar.bHw());
                            apVar.t("star_id", jVar.cnF());
                            apVar.t(AlaSDKShareEmptyActivityConfig.SHARE_ALA_SDK_LIVE_ID, liveId);
                            TiebaStatic.log(apVar);
                        }
                    });
                    if (!this.iza.contains(Long.valueOf(liveId))) {
                        ap apVar = new ap("c13622");
                        apVar.t("uid", TbadkApplication.getCurrentAccountId());
                        apVar.ah("fid", 0);
                        apVar.t("tid", jVar.getThreadId());
                        apVar.ah("obj_type", jVar.bHw());
                        apVar.t("star_id", jVar.cnF());
                        apVar.t(AlaSDKShareEmptyActivityConfig.SHARE_ALA_SDK_LIVE_ID, liveId);
                        TiebaStatic.log(apVar);
                        this.iza.add(Long.valueOf(liveId));
                    }
                }
            } else {
                c0646a.izh.setText(TbadkCoreApplication.getInst().getString(R.string.recommend_hot_live));
                c0646a.egg.setImageResource(R.drawable.pic_live_hand_n);
                c0646a.dKI.setText(TbadkCoreApplication.getInst().getString(R.string.recommend_live_square));
                c0646a.izd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.a.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921445));
                        ap apVar2 = new ap("c13621");
                        apVar2.t("uid", TbadkApplication.getCurrentAccountId());
                        apVar2.ah("fid", 0);
                        TiebaStatic.log(apVar2);
                    }
                });
            }
            c0646a.cn(TbadkCoreApplication.getInst().getSkinType(), jVar.getType());
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
    public void onViewDetachedFromWindow(@NonNull C0646a c0646a) {
        super.onViewDetachedFromWindow(c0646a);
        if (c0646a != null && c0646a.ize != null) {
            c0646a.ize.cancel();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: b */
    public void onViewAttachedToWindow(@NonNull C0646a c0646a) {
        super.onViewAttachedToWindow(c0646a);
        if (c0646a != null && c0646a.ize != null) {
            c0646a.ize.start();
        }
    }

    /* renamed from: com.baidu.tieba.homepage.personalize.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes16.dex */
    public class C0646a extends RecyclerView.ViewHolder {
        private TextView dKI;
        private HeadImageView egg;
        private View izd;
        public ObjectAnimator ize;
        private ImageView izf;
        private TbImageView izg;
        private TBSpecificationBtn izh;
        private TbImageView izi;

        public C0646a(View view) {
            super(view);
            this.izd = view.findViewById(R.id.ala_recommend_container);
            this.izi = (TbImageView) view.findViewById(R.id.ala_animation_background);
            ao.setImageResource(this.izi, R.drawable.icon_mask_live);
            this.ize = ObjectAnimator.ofFloat(this.izi, "rotation", 0.0f, 359.0f);
            this.ize.setRepeatCount(-1);
            this.ize.setDuration(10000L);
            this.ize.setInterpolator(new LinearInterpolator());
            this.izf = (ImageView) view.findViewById(R.id.ala_gradient_background);
            this.egg = (HeadImageView) view.findViewById(R.id.ala_protrait);
            this.egg.setRadius(com.baidu.adp.lib.util.l.getDimens(a.this.mContext, R.dimen.tbds63));
            this.izg = (TbImageView) view.findViewById(R.id.ala_recommend_more);
            this.izh = (TBSpecificationBtn) view.findViewById(R.id.ala_sign_icon);
            com.baidu.tbadk.core.view.commonBtn.b bVar = new com.baidu.tbadk.core.view.commonBtn.b();
            bVar.mV(R.color.cp_other_d);
            bVar.mT(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds15));
            bVar.aR(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds120), com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds46));
            this.izh.setTextSize(R.dimen.tbds26);
            this.izh.setClickState(false);
            this.izh.setConfig(bVar);
            this.dKI = (TextView) view.findViewById(R.id.ala_recommend_user_name);
        }

        public void cn(int i, int i2) {
            if (i != a.this.mSkinType) {
                ao.setViewTextColor(this.izh, R.color.cp_cont_a);
                ao.setViewTextColor(this.dKI, R.color.cp_cont_b);
                ao.setImageResource(this.izi, R.drawable.icon_mask_live);
                SvgManager.baR().a(this.izf, R.drawable.ic_icon_pure_live_stroke, SvgManager.SvgResourceStateType.NORMAL);
                this.izh.bci();
                if (i2 == 1) {
                    ao.setImageResource(this.egg, R.drawable.pic_live_hand_n);
                } else if (i2 == 2) {
                    ao.setImageResource(this.izg, R.drawable.icon_pure_live_moe22);
                    ao.c(this.egg, com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds63), R.color.cp_bg_line_b, R.color.cp_bg_line_b);
                }
                ao.setViewTextColor(this.dKI, R.color.cp_cont_b);
            }
        }
    }
}
