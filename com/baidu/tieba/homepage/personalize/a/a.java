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
/* loaded from: classes22.dex */
public class a extends RecyclerView.Adapter<C0742a> {
    private Context mContext;
    private List<com.baidu.tieba.homepage.personalize.data.j> mDatas;
    private int mSkinType = 3;
    private HashSet<Long> jDW = new HashSet<>();

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
                    jVar2.fT(alaLiveInfo.user_info.ala_id.longValue());
                    jVar2.BM(alaLiveInfo.live_type.intValue());
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
    public C0742a onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new C0742a(LayoutInflater.from(this.mContext).inflate(R.layout.ala_recommend_item, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(@NonNull C0742a c0742a, int i) {
        final com.baidu.tieba.homepage.personalize.data.j jVar;
        if (c0742a != null && this.mDatas != null && this.mDatas.size() > i && (jVar = this.mDatas.get(i)) != null) {
            if (jVar.getType() != 1) {
                if (jVar.getType() != 0) {
                    if (jVar.getType() == 2) {
                        c0742a.jEd.setVisibility(8);
                        c0742a.jEe.setVisibility(8);
                        c0742a.jEb.setVisibility(8);
                        c0742a.ewx.setText(TbadkCoreApplication.getInst().getString(R.string.attention_all));
                        c0742a.jEc.setVisibility(0);
                        c0742a.jEc.setImageResource(R.drawable.icon_pure_live_moe22);
                        c0742a.jDZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.a.a.3
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                if (bg.checkUpIsLogin(a.this.mContext)) {
                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveTabMyConcernActivityConfig(a.this.mContext)));
                                    aq aqVar = new aq("c13624");
                                    aqVar.w("uid", TbadkApplication.getCurrentAccountId());
                                    aqVar.al("fid", 0);
                                    TiebaStatic.log(aqVar);
                                }
                            }
                        });
                    }
                } else {
                    c0742a.jEd.setText(TbadkCoreApplication.getInst().getString(R.string.live_in));
                    c0742a.eSs.setPlaceHolder(1);
                    c0742a.eSs.setDefaultResource(R.drawable.transparent_bg);
                    if (!StringUtils.isNull(jVar.getPortrait())) {
                        c0742a.eSs.startLoad(jVar.getPortrait(), 10, false);
                    }
                    if (at.getChineseAndEnglishLength(jVar.getUsername()) > 8) {
                        c0742a.ewx.setText(at.cutChineseAndEnglishWithSuffix(jVar.getUsername(), 6, StringHelper.STRING_MORE));
                    } else {
                        c0742a.ewx.setText(jVar.getUsername());
                    }
                    final long liveId = jVar.getLiveId();
                    c0742a.jDZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.a.a.2
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                            alaLiveInfoCoreData.liveID = liveId;
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(a.this.mContext, alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_PB_USER_ICON_LIVE, null, false, "")));
                            aq aqVar = new aq("c13623");
                            aqVar.w("uid", TbadkApplication.getCurrentAccountId());
                            aqVar.al("fid", 0);
                            aqVar.w("tid", jVar.getThreadId());
                            aqVar.al("obj_type", jVar.cbr());
                            aqVar.w("star_id", jVar.cLx());
                            aqVar.w(AlaSDKShareEmptyActivityConfig.SHARE_ALA_SDK_LIVE_ID, liveId);
                            TiebaStatic.log(aqVar);
                        }
                    });
                    if (!this.jDW.contains(Long.valueOf(liveId))) {
                        aq aqVar = new aq("c13622");
                        aqVar.w("uid", TbadkApplication.getCurrentAccountId());
                        aqVar.al("fid", 0);
                        aqVar.w("tid", jVar.getThreadId());
                        aqVar.al("obj_type", jVar.cbr());
                        aqVar.w("star_id", jVar.cLx());
                        aqVar.w(AlaSDKShareEmptyActivityConfig.SHARE_ALA_SDK_LIVE_ID, liveId);
                        TiebaStatic.log(aqVar);
                        this.jDW.add(Long.valueOf(liveId));
                    }
                }
            } else {
                c0742a.jEd.setText(TbadkCoreApplication.getInst().getString(R.string.recommend_hot_live));
                c0742a.eSs.setImageResource(R.drawable.pic_live_hand_n);
                c0742a.ewx.setText(TbadkCoreApplication.getInst().getString(R.string.recommend_live_square));
                c0742a.jDZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.a.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921445));
                        aq aqVar2 = new aq("c13621");
                        aqVar2.w("uid", TbadkApplication.getCurrentAccountId());
                        aqVar2.al("fid", 0);
                        TiebaStatic.log(aqVar2);
                    }
                });
            }
            c0742a.cC(TbadkCoreApplication.getInst().getSkinType(), jVar.getType());
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
    public void onViewDetachedFromWindow(@NonNull C0742a c0742a) {
        super.onViewDetachedFromWindow(c0742a);
        if (c0742a != null && c0742a.jEa != null) {
            c0742a.jEa.cancel();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: b */
    public void onViewAttachedToWindow(@NonNull C0742a c0742a) {
        super.onViewAttachedToWindow(c0742a);
        if (c0742a != null && c0742a.jEa != null) {
            c0742a.jEa.start();
        }
    }

    /* renamed from: com.baidu.tieba.homepage.personalize.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes22.dex */
    public class C0742a extends RecyclerView.ViewHolder {
        private HeadImageView eSs;
        private TextView ewx;
        private View jDZ;
        public ObjectAnimator jEa;
        private ImageView jEb;
        private TbImageView jEc;
        private TBSpecificationBtn jEd;
        private TbImageView jEe;

        public C0742a(View view) {
            super(view);
            this.jDZ = view.findViewById(R.id.ala_recommend_container);
            this.jEe = (TbImageView) view.findViewById(R.id.ala_animation_background);
            ap.setImageResource(this.jEe, R.drawable.icon_mask_live);
            this.jEa = ObjectAnimator.ofFloat(this.jEe, MapBundleKey.MapObjKey.OBJ_SS_ARROW_ROTATION, 0.0f, 359.0f);
            this.jEa.setRepeatCount(-1);
            this.jEa.setDuration(10000L);
            this.jEa.setInterpolator(new LinearInterpolator());
            this.jEb = (ImageView) view.findViewById(R.id.ala_gradient_background);
            this.eSs = (HeadImageView) view.findViewById(R.id.ala_protrait);
            this.eSs.setRadius(com.baidu.adp.lib.util.l.getDimens(a.this.mContext, R.dimen.tbds63));
            this.jEc = (TbImageView) view.findViewById(R.id.ala_recommend_more);
            this.jEd = (TBSpecificationBtn) view.findViewById(R.id.ala_sign_icon);
            com.baidu.tbadk.core.view.commonBtn.a aVar = new com.baidu.tbadk.core.view.commonBtn.a();
            aVar.qi(R.color.cp_other_d);
            aVar.qf(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds15));
            aVar.aZ(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds120), com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds46));
            this.jEd.setTextSize(R.dimen.tbds26);
            this.jEd.setClickState(false);
            this.jEd.setConfig(aVar);
            this.ewx = (TextView) view.findViewById(R.id.ala_recommend_user_name);
        }

        public void cC(int i, int i2) {
            if (i != a.this.mSkinType) {
                ap.setViewTextColor(this.jEd, R.color.cp_cont_a);
                ap.setViewTextColor(this.ewx, R.color.cp_cont_b);
                ap.setImageResource(this.jEe, R.drawable.icon_mask_live);
                SvgManager.brn().a(this.jEb, R.drawable.ic_icon_pure_live_stroke, SvgManager.SvgResourceStateType.NORMAL);
                this.jEd.bsD();
                if (i2 == 1) {
                    ap.setImageResource(this.eSs, R.drawable.pic_live_hand_n);
                } else if (i2 == 2) {
                    ap.setImageResource(this.jEc, R.drawable.icon_pure_live_moe22);
                    ap.c(this.eSs, com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds63), R.color.cp_bg_line_b, R.color.cp_bg_line_b);
                }
                ap.setViewTextColor(this.ewx, R.color.cp_cont_b);
            }
        }
    }
}
