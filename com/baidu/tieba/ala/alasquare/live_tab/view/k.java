package com.baidu.tieba.ala.alasquare.live_tab.view;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.ala.data.SdkLiveInfoData;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class k {
    private static final float eoq = TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds20);
    private static final float[] eor = {0.0f, 0.0f, 0.0f, 0.0f, eoq, eoq, eoq, eoq};
    private static final float[] eos = {0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, eoq, eoq};
    private static final float[] eot = {0.0f, 0.0f, 0.0f, 0.0f, eoq, eoq, 0.0f, 0.0f};
    private SdkLiveInfoData ekj;
    public TextView eln;
    public TbImageView eok;
    public TextView eol;
    public TextView eon;
    private AlphaAnimation eoy;
    public View eqi;
    public ViewGroup eqj;
    public TbImageView eqk;
    public ImageView eql;
    private com.baidu.tieba.ala.alasquare.a.a eqm;
    private String mCoverUrl;
    public View mRootView;
    private TbPageContext<?> mTbPageContext;
    public int mSkinType = 3;
    private int[] eou = {TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha0), TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha40)};
    private boolean eox = false;
    private boolean eoz = true;
    private boolean eoA = false;
    private int eqn = 0;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.k.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (k.this.eqm != null && k.this.ekj != null) {
                if (k.this.ekj.shouldJumpChushouLiveRoom()) {
                    com.baidu.tieba.ala.alasquare.live_tab.c.a(k.this.mTbPageContext, k.this.ekj.roomId, String.valueOf(k.this.ekj.liveInfo.liveType));
                } else {
                    AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                    alaLiveInfoCoreData.liveID = com.baidu.adp.lib.f.b.toLong(k.this.ekj.roomId, 0L);
                    if (k.this.ekj.liveInfo != null) {
                        alaLiveInfoCoreData.hslUrl = k.this.ekj.liveInfo.hlsUrl;
                        alaLiveInfoCoreData.liveCover = k.this.ekj.liveInfo.cover;
                        alaLiveInfoCoreData.rtmpUrl = k.this.ekj.liveInfo.rtmpUrl;
                        alaLiveInfoCoreData.liveTitle = k.this.ekj.title;
                        alaLiveInfoCoreData.audienceCount = k.this.ekj.liveInfo.audienceCount;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(k.this.mTbPageContext.getPageActivity(), alaLiveInfoCoreData, null, AlaLiveRoomActivityConfig.FROM_TYPE_HOME_LIVE_TAB_MAIN, TbadkCoreApplication.getCurrentAccount(), false, "", null)));
                }
                if (k.this.eqm.cUE) {
                    an anVar = new an("c13611");
                    anVar.cx("obj_param1", k.this.ekj.roomId);
                    anVar.cx("fid", k.this.eqm.fid);
                    anVar.cx("fname", k.this.eqm.fname);
                    anVar.X("obj_locate", k.this.eqm.position);
                    TiebaStatic.log(anVar);
                    return;
                }
                an anVar2 = new an("c13557");
                anVar2.cx("obj_param1", k.this.ekj.roomId);
                anVar2.cx("entryname", "游戏");
                TiebaStatic.log(anVar2);
            }
        }
    };

    public k(TbPageContext<?> tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.mRootView = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(R.layout.tab_game_live_item_view, (ViewGroup) null, false);
        this.eok = (TbImageView) this.mRootView.findViewById(R.id.imgSquareView);
        this.eok.setBorderSurroundContent(true);
        this.eok.setDrawBorder(true);
        this.eok.setPlaceHolder(2);
        this.eok.setBorderWidth(com.baidu.adp.lib.util.l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds1));
        this.eqi = this.mRootView.findViewById(R.id.rlSquareLivePanel);
        this.eln = (TextView) this.mRootView.findViewById(R.id.live_title);
        this.eol = (TextView) this.mRootView.findViewById(R.id.tvLiveCount);
        this.eon = (TextView) this.mRootView.findViewById(R.id.tvUserName);
        this.eqj = (ViewGroup) this.mRootView.findViewById(R.id.tvUserNameWrapper);
        this.eqk = (TbImageView) this.mRootView.findViewById(R.id.live_label);
        this.eql = (ImageView) this.mRootView.findViewById(R.id.live_redpacket_label);
        this.mRootView.setOnClickListener(this.mOnClickListener);
        this.eoy = new AlphaAnimation(0.0f, 1.0f);
        this.eoy.setDuration(200L);
        this.eoy.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.k.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                k.this.eoA = true;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                k.this.eoA = false;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
    }

    public View getView() {
        return this.mRootView;
    }

    public void a(com.baidu.tieba.ala.alasquare.a.a aVar) {
        String str;
        int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(this.mRootView.getContext());
        if (equipmentWidth != this.eqn) {
            ViewGroup.LayoutParams layoutParams = this.eqi.getLayoutParams();
            int equipmentWidth2 = (int) (((com.baidu.adp.lib.util.l.getEquipmentWidth(this.mRootView.getContext()) - this.mRootView.getContext().getResources().getDimensionPixelSize(R.dimen.tbds12)) - (this.mRootView.getContext().getResources().getDimensionPixelSize(R.dimen.tbds44) * 2)) / 2.0d);
            int i = (int) ((equipmentWidth2 * 9) / 16.0d);
            ViewGroup.LayoutParams layoutParams2 = this.mRootView.getLayoutParams();
            layoutParams2.width = equipmentWidth2;
            this.mRootView.setLayoutParams(layoutParams2);
            if (layoutParams == null) {
                layoutParams = new ViewGroup.LayoutParams(equipmentWidth2, i);
            } else {
                layoutParams.width = equipmentWidth2;
                layoutParams.height = i;
            }
            this.eqi.setLayoutParams(layoutParams);
            this.eqn = equipmentWidth;
        }
        if (aVar == null || aVar.ekj == null) {
            getView().setVisibility(4);
            return;
        }
        getView().setVisibility(0);
        this.eqm = aVar;
        this.ekj = aVar.ekj;
        Object tag = this.eok.getTag();
        if (this.eoz) {
            this.eox = true;
            this.eoz = false;
        } else if ((tag instanceof String) && !StringUtils.isNull(this.ekj.liveInfo.cover) && !((String) tag).equals(this.ekj.liveInfo.cover)) {
            this.eox = true;
        } else if (!StringUtils.isNull(this.mCoverUrl) && !StringUtils.isNull(this.ekj.liveInfo.cover) && !this.mCoverUrl.equals(this.ekj.liveInfo.cover)) {
            this.eox = true;
        } else {
            this.eox = false;
        }
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, this.eou);
        this.mCoverUrl = this.ekj.liveInfo.cover;
        this.eok.setTag(this.mCoverUrl);
        if (aVar.isLeft) {
            this.eok.setConrers(5);
            gradientDrawable.setCornerRadii(eos);
            this.eok.setPlaceHolder(2);
        } else if (aVar.isRight) {
            this.eok.setConrers(10);
            gradientDrawable.setCornerRadii(eot);
            this.eok.setPlaceHolder(2);
        } else if (aVar.ekk) {
            this.eok.setConrers(15);
            gradientDrawable.setCornerRadii(eor);
            this.eok.setPlaceHolder(2);
        }
        this.eok.setRadius((int) eoq);
        this.eok.startLoad(this.ekj.liveInfo.cover, 10, false);
        this.eqj.setBackgroundDrawable(gradientDrawable);
        this.eok.setEvent(new TbImageView.a() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.k.2
            String url;

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str2, boolean z) {
                if (z && k.this.eox && !k.this.eoA) {
                    if (StringUtils.isNull(this.url) || !this.url.equals(str2)) {
                        k.this.eok.startAnimation(k.this.eoy);
                        this.url = str2;
                    }
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        });
        this.eol.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.square_sub_live_audience_label, aq.bE(this.ekj.liveInfo.audienceCount)));
        this.eon.setText(this.ekj.liveAuthor.name);
        this.eln.setText(this.ekj.title);
        if (TbadkCoreApplication.getInst().getSkinType() == 1 || TbadkCoreApplication.getInst().getSkinType() == 4) {
            str = this.ekj.recom_extra_img_night;
        } else {
            str = this.ekj.recom_extra_img;
        }
        if (!StringUtils.isNull(str) && this.ekj.recom_extra_img_width > 0 && this.ekj.recom_extra_img_height > 0) {
            if (aVar.isLeft) {
                this.eqk.setConrers(1);
            } else if (aVar.isRight) {
                this.eqk.setConrers(0);
            } else if (aVar.ekk) {
                this.eqk.setConrers(1);
            } else {
                this.eqk.setConrers(0);
            }
            this.eqk.setRadius((int) eoq);
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.eqk.getLayoutParams();
            if (layoutParams3 != null) {
                int dimensionPixelSize = this.mTbPageContext.getResources().getDimensionPixelSize(R.dimen.ds42);
                layoutParams3.height = dimensionPixelSize;
                layoutParams3.width = (int) ((this.ekj.recom_extra_img_width / this.ekj.recom_extra_img_height) * dimensionPixelSize);
                this.eqk.setLayoutParams(layoutParams3);
            }
            this.eqk.startLoad(str, 10, false);
            this.eqk.setVisibility(0);
        } else {
            this.eqk.setVisibility(8);
        }
        this.eql.setVisibility(8);
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
        if (aVar.cUE) {
            an anVar = new an("c13610");
            anVar.cx("obj_param1", this.ekj.roomId);
            anVar.cx("fid", aVar.fid);
            anVar.cx("fname", aVar.fname);
            anVar.X("obj_locate", aVar.position);
            TiebaStatic.log(anVar);
            return;
        }
        an anVar2 = new an("c13544");
        anVar2.cx("obj_param1", this.ekj.roomId);
        anVar2.cx("entryname", "游戏");
        TiebaStatic.log(anVar2);
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setViewTextColor(this.eol, (int) R.color.cp_cont_a);
            am.setViewTextColor(this.eon, (int) R.color.cp_cont_a);
            am.setViewTextColor(this.eln, (int) R.color.cp_cont_b);
            Drawable drawable = am.getDrawable(this.mTbPageContext.getResources(), (int) R.drawable.tab_icon_living_seeding);
            drawable.setBounds(0, 0, this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds18), this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds18));
            this.eol.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
            this.eol.setCompoundDrawablePadding(this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds8));
            this.mSkinType = i;
        }
    }
}
