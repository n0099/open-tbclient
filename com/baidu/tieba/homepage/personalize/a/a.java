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
/* loaded from: classes22.dex */
public class a extends RecyclerView.Adapter<C0761a> {
    private Context mContext;
    private List<com.baidu.tieba.homepage.personalize.data.j> mDatas;
    private int mSkinType = 3;
    private HashSet<Long> jSx = new HashSet<>();

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
                    jVar2.gB(alaLiveInfo.user_info.ala_id.longValue());
                    jVar2.CZ(alaLiveInfo.live_type.intValue());
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
    /* renamed from: D */
    public C0761a onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new C0761a(LayoutInflater.from(this.mContext).inflate(R.layout.ala_recommend_item, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(@NonNull C0761a c0761a, int i) {
        final com.baidu.tieba.homepage.personalize.data.j jVar;
        if (c0761a != null && this.mDatas != null && this.mDatas.size() > i && (jVar = this.mDatas.get(i)) != null) {
            if (jVar.getType() != 1) {
                if (jVar.getType() != 0) {
                    if (jVar.getType() == 2) {
                        c0761a.jSE.setVisibility(8);
                        c0761a.jSF.setVisibility(8);
                        c0761a.jSC.setVisibility(8);
                        c0761a.eBQ.setText(TbadkCoreApplication.getInst().getString(R.string.attention_all));
                        c0761a.jSD.setVisibility(0);
                        c0761a.jSD.setImageResource(R.drawable.icon_pure_live_moe22);
                        c0761a.jSA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.a.a.3
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                if (bh.checkUpIsLogin(a.this.mContext)) {
                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveTabMyConcernActivityConfig(a.this.mContext)));
                                    ar arVar = new ar("c13624");
                                    arVar.w("uid", TbadkApplication.getCurrentAccountId());
                                    arVar.al("fid", 0);
                                    TiebaStatic.log(arVar);
                                }
                            }
                        });
                    }
                } else {
                    c0761a.jSE.setText(TbadkCoreApplication.getInst().getString(R.string.live_in));
                    c0761a.eYM.setPlaceHolder(1);
                    c0761a.eYM.setDefaultResource(R.drawable.transparent_bg);
                    if (!StringUtils.isNull(jVar.getPortrait())) {
                        c0761a.eYM.startLoad(jVar.getPortrait(), 10, false);
                    }
                    if (au.getChineseAndEnglishLength(jVar.getUsername()) > 8) {
                        c0761a.eBQ.setText(au.cutChineseAndEnglishWithSuffix(jVar.getUsername(), 6, StringHelper.STRING_MORE));
                    } else {
                        c0761a.eBQ.setText(jVar.getUsername());
                    }
                    final long liveId = jVar.getLiveId();
                    c0761a.jSA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.a.a.2
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                            alaLiveInfoCoreData.liveID = liveId;
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(a.this.mContext, alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_PB_USER_ICON_LIVE, null, false, "")));
                            ar arVar = new ar("c13623");
                            arVar.w("uid", TbadkApplication.getCurrentAccountId());
                            arVar.al("fid", 0);
                            arVar.w("tid", jVar.getThreadId());
                            arVar.al("obj_type", jVar.ceF());
                            arVar.w("star_id", jVar.cQr());
                            arVar.w(AlaSDKShareEmptyActivityConfig.SHARE_ALA_SDK_LIVE_ID, liveId);
                            TiebaStatic.log(arVar);
                        }
                    });
                    if (!this.jSx.contains(Long.valueOf(liveId))) {
                        ar arVar = new ar("c13622");
                        arVar.w("uid", TbadkApplication.getCurrentAccountId());
                        arVar.al("fid", 0);
                        arVar.w("tid", jVar.getThreadId());
                        arVar.al("obj_type", jVar.ceF());
                        arVar.w("star_id", jVar.cQr());
                        arVar.w(AlaSDKShareEmptyActivityConfig.SHARE_ALA_SDK_LIVE_ID, liveId);
                        TiebaStatic.log(arVar);
                        this.jSx.add(Long.valueOf(liveId));
                    }
                }
            } else {
                c0761a.jSE.setText(TbadkCoreApplication.getInst().getString(R.string.recommend_hot_live));
                c0761a.eYM.setImageResource(R.drawable.pic_live_hand_n);
                c0761a.eBQ.setText(TbadkCoreApplication.getInst().getString(R.string.recommend_live_square));
                c0761a.jSA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.a.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921445));
                        ar arVar2 = new ar("c13621");
                        arVar2.w("uid", TbadkApplication.getCurrentAccountId());
                        arVar2.al("fid", 0);
                        TiebaStatic.log(arVar2);
                    }
                });
            }
            c0761a.cH(TbadkCoreApplication.getInst().getSkinType(), jVar.getType());
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
    public void onViewDetachedFromWindow(@NonNull C0761a c0761a) {
        super.onViewDetachedFromWindow(c0761a);
        if (c0761a != null && c0761a.jSB != null) {
            c0761a.jSB.cancel();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: b */
    public void onViewAttachedToWindow(@NonNull C0761a c0761a) {
        super.onViewAttachedToWindow(c0761a);
        if (c0761a != null && c0761a.jSB != null) {
            c0761a.jSB.start();
        }
    }

    /* renamed from: com.baidu.tieba.homepage.personalize.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes22.dex */
    public class C0761a extends RecyclerView.ViewHolder {
        private TextView eBQ;
        private HeadImageView eYM;
        private View jSA;
        public ObjectAnimator jSB;
        private ImageView jSC;
        private TbImageView jSD;
        private TBSpecificationBtn jSE;
        private TbImageView jSF;

        public C0761a(View view) {
            super(view);
            this.jSA = view.findViewById(R.id.ala_recommend_container);
            this.jSF = (TbImageView) view.findViewById(R.id.ala_animation_background);
            ap.setImageResource(this.jSF, R.drawable.icon_mask_live);
            this.jSB = ObjectAnimator.ofFloat(this.jSF, MapBundleKey.MapObjKey.OBJ_SS_ARROW_ROTATION, 0.0f, 359.0f);
            this.jSB.setRepeatCount(-1);
            this.jSB.setDuration(10000L);
            this.jSB.setInterpolator(new LinearInterpolator());
            this.jSC = (ImageView) view.findViewById(R.id.ala_gradient_background);
            this.eYM = (HeadImageView) view.findViewById(R.id.ala_protrait);
            this.eYM.setRadius(com.baidu.adp.lib.util.l.getDimens(a.this.mContext, R.dimen.tbds63));
            this.jSD = (TbImageView) view.findViewById(R.id.ala_recommend_more);
            this.jSE = (TBSpecificationBtn) view.findViewById(R.id.ala_sign_icon);
            com.baidu.tbadk.core.view.commonBtn.a aVar = new com.baidu.tbadk.core.view.commonBtn.a();
            aVar.rh(R.color.CAM_X0310);
            aVar.re(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds15));
            aVar.bb(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds120), com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds46));
            this.jSE.setTextSize(R.dimen.tbds26);
            this.jSE.setClickState(false);
            this.jSE.setConfig(aVar);
            this.eBQ = (TextView) view.findViewById(R.id.ala_recommend_user_name);
        }

        public void cH(int i, int i2) {
            if (i != a.this.mSkinType) {
                ap.setViewTextColor(this.jSE, R.color.CAM_X0101);
                ap.setViewTextColor(this.eBQ, R.color.CAM_X0105);
                ap.setImageResource(this.jSF, R.drawable.icon_mask_live);
                SvgManager.btW().a(this.jSC, R.drawable.ic_icon_pure_live_stroke, SvgManager.SvgResourceStateType.NORMAL);
                this.jSE.bvt();
                if (i2 == 1) {
                    ap.setImageResource(this.eYM, R.drawable.pic_live_hand_n);
                } else if (i2 == 2) {
                    ap.setImageResource(this.jSD, R.drawable.icon_pure_live_moe22);
                    ap.d(this.eYM, com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds63), R.color.CAM_X0203, R.color.CAM_X0203);
                }
                ap.setViewTextColor(this.eBQ, R.color.CAM_X0105);
            }
        }
    }
}
