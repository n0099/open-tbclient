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
import com.baidu.platform.comapi.map.MapBundleKey;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.atomData.AlaLiveTabMyConcernActivityConfig;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
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
/* loaded from: classes21.dex */
public class a extends RecyclerView.Adapter<C0694a> {
    private Context mContext;
    private List<com.baidu.tieba.homepage.personalize.data.j> mDatas;
    private int mSkinType = 3;
    private HashSet<Long> iWE = new HashSet<>();

    public a(Context context) {
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
                    jVar2.fe(alaLiveInfo.user_info.ala_id.longValue());
                    jVar2.AA(alaLiveInfo.live_type.intValue());
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
    /* renamed from: B */
    public C0694a onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new C0694a(LayoutInflater.from(this.mContext).inflate(R.layout.ala_recommend_item, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(@NonNull C0694a c0694a, int i) {
        final com.baidu.tieba.homepage.personalize.data.j jVar;
        if (c0694a != null && this.mDatas != null && this.mDatas.size() > i && (jVar = this.mDatas.get(i)) != null) {
            if (jVar.getType() != 1) {
                if (jVar.getType() != 0) {
                    if (jVar.getType() == 2) {
                        c0694a.iWL.setVisibility(8);
                        c0694a.iWM.setVisibility(8);
                        c0694a.iWJ.setVisibility(8);
                        c0694a.dWe.setText(TbadkCoreApplication.getInst().getString(R.string.attention_all));
                        c0694a.iWK.setVisibility(0);
                        c0694a.iWK.setImageResource(R.drawable.icon_pure_live_moe22);
                        c0694a.iWH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.a.a.3
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                if (bg.checkUpIsLogin(a.this.mContext)) {
                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveTabMyConcernActivityConfig(a.this.mContext)));
                                    aq aqVar = new aq("c13624");
                                    aqVar.u("uid", TbadkApplication.getCurrentAccountId());
                                    aqVar.ai("fid", 0);
                                    TiebaStatic.log(aqVar);
                                }
                            }
                        });
                    }
                } else {
                    c0694a.iWL.setText(TbadkCoreApplication.getInst().getString(R.string.live_in));
                    c0694a.erW.setPlaceHolder(1);
                    c0694a.erW.setDefaultResource(R.drawable.transparent_bg);
                    if (!StringUtils.isNull(jVar.getPortrait())) {
                        c0694a.erW.startLoad(jVar.getPortrait(), 10, false);
                    }
                    if (at.getChineseAndEnglishLength(jVar.getUsername()) > 8) {
                        c0694a.dWe.setText(at.cutChineseAndEnglishWithSuffix(jVar.getUsername(), 6, StringHelper.STRING_MORE));
                    } else {
                        c0694a.dWe.setText(jVar.getUsername());
                    }
                    final long liveId = jVar.getLiveId();
                    c0694a.iWH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.a.a.2
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                            alaLiveInfoCoreData.liveID = liveId;
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(a.this.mContext, alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_PB_USER_ICON_LIVE, null, false, "")));
                            aq aqVar = new aq("c13623");
                            aqVar.u("uid", TbadkApplication.getCurrentAccountId());
                            aqVar.ai("fid", 0);
                            aqVar.u("tid", jVar.getThreadId());
                            aqVar.ai("obj_type", jVar.bSx());
                            aqVar.u("star_id", jVar.cCg());
                            aqVar.u(AlaSDKShareEmptyActivityConfig.SHARE_ALA_SDK_LIVE_ID, liveId);
                            TiebaStatic.log(aqVar);
                        }
                    });
                    if (!this.iWE.contains(Long.valueOf(liveId))) {
                        aq aqVar = new aq("c13622");
                        aqVar.u("uid", TbadkApplication.getCurrentAccountId());
                        aqVar.ai("fid", 0);
                        aqVar.u("tid", jVar.getThreadId());
                        aqVar.ai("obj_type", jVar.bSx());
                        aqVar.u("star_id", jVar.cCg());
                        aqVar.u(AlaSDKShareEmptyActivityConfig.SHARE_ALA_SDK_LIVE_ID, liveId);
                        TiebaStatic.log(aqVar);
                        this.iWE.add(Long.valueOf(liveId));
                    }
                }
            } else {
                c0694a.iWL.setText(TbadkCoreApplication.getInst().getString(R.string.recommend_hot_live));
                c0694a.erW.setImageResource(R.drawable.pic_live_hand_n);
                c0694a.dWe.setText(TbadkCoreApplication.getInst().getString(R.string.recommend_live_square));
                c0694a.iWH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.a.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921445));
                        aq aqVar2 = new aq("c13621");
                        aqVar2.u("uid", TbadkApplication.getCurrentAccountId());
                        aqVar2.ai("fid", 0);
                        TiebaStatic.log(aqVar2);
                    }
                });
            }
            c0694a.cy(TbadkCoreApplication.getInst().getSkinType(), jVar.getType());
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
    public void onViewDetachedFromWindow(@NonNull C0694a c0694a) {
        super.onViewDetachedFromWindow(c0694a);
        if (c0694a != null && c0694a.iWI != null) {
            c0694a.iWI.cancel();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: b */
    public void onViewAttachedToWindow(@NonNull C0694a c0694a) {
        super.onViewAttachedToWindow(c0694a);
        if (c0694a != null && c0694a.iWI != null) {
            c0694a.iWI.start();
        }
    }

    /* renamed from: com.baidu.tieba.homepage.personalize.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes21.dex */
    public class C0694a extends RecyclerView.ViewHolder {
        private TextView dWe;
        private HeadImageView erW;
        private View iWH;
        public ObjectAnimator iWI;
        private ImageView iWJ;
        private TbImageView iWK;
        private TBSpecificationBtn iWL;
        private TbImageView iWM;

        public C0694a(View view) {
            super(view);
            this.iWH = view.findViewById(R.id.ala_recommend_container);
            this.iWM = (TbImageView) view.findViewById(R.id.ala_animation_background);
            ap.setImageResource(this.iWM, R.drawable.icon_mask_live);
            this.iWI = ObjectAnimator.ofFloat(this.iWM, MapBundleKey.MapObjKey.OBJ_SS_ARROW_ROTATION, 0.0f, 359.0f);
            this.iWI.setRepeatCount(-1);
            this.iWI.setDuration(10000L);
            this.iWI.setInterpolator(new LinearInterpolator());
            this.iWJ = (ImageView) view.findViewById(R.id.ala_gradient_background);
            this.erW = (HeadImageView) view.findViewById(R.id.ala_protrait);
            this.erW.setRadius(com.baidu.adp.lib.util.l.getDimens(a.this.mContext, R.dimen.tbds63));
            this.iWK = (TbImageView) view.findViewById(R.id.ala_recommend_more);
            this.iWL = (TBSpecificationBtn) view.findViewById(R.id.ala_sign_icon);
            com.baidu.tbadk.core.view.commonBtn.a aVar = new com.baidu.tbadk.core.view.commonBtn.a();
            aVar.pp(R.color.cp_other_d);
            aVar.pl(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds15));
            aVar.aZ(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds120), com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds46));
            this.iWL.setTextSize(R.dimen.tbds26);
            this.iWL.setClickState(false);
            this.iWL.setConfig(aVar);
            this.dWe = (TextView) view.findViewById(R.id.ala_recommend_user_name);
        }

        public void cy(int i, int i2) {
            if (i != a.this.mSkinType) {
                ap.setViewTextColor(this.iWL, R.color.cp_cont_a);
                ap.setViewTextColor(this.dWe, R.color.cp_cont_b);
                ap.setImageResource(this.iWM, R.drawable.icon_mask_live);
                SvgManager.bkl().a(this.iWJ, R.drawable.ic_icon_pure_live_stroke, SvgManager.SvgResourceStateType.NORMAL);
                this.iWL.blA();
                if (i2 == 1) {
                    ap.setImageResource(this.erW, R.drawable.pic_live_hand_n);
                } else if (i2 == 2) {
                    ap.setImageResource(this.iWK, R.drawable.icon_pure_live_moe22);
                    ap.c(this.erW, com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds63), R.color.cp_bg_line_b, R.color.cp_bg_line_b);
                }
                ap.setViewTextColor(this.dWe, R.color.cp_cont_b);
            }
        }
    }
}
