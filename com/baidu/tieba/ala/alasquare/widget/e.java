package com.baidu.tieba.ala.alasquare.widget;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.util.ad;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes10.dex */
public class e extends com.baidu.tieba.card.b<com.baidu.tieba.ala.alasquare.a.e> {
    private TextView bac;
    private bz gAx;
    private com.baidu.tieba.ala.alasquare.a.e gEV;
    private TbImageView gKY;
    private d gLE;
    private TextView gLO;
    private TextView gLP;
    private LinearLayout gLQ;
    private ImageView gLR;
    private LinearLayout gLS;
    private TextView gLT;
    private RelativeLayout gLU;
    private RelativeLayout gLV;
    private ClickableHeaderImageView gLW;
    private TextView gLX;
    private TextView gLY;
    private View gLZ;
    private TextView gLa;
    private RelativeLayout gLb;
    private ClickableHeaderImageView gLc;
    private TextView gLd;
    private boolean gMa;
    private int gMb;
    private String mFromPage;
    public int mSkinType;
    private int mViewWidth;

    public e(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.mFromPage = "square_recommend";
        this.mViewWidth = (l.getEquipmentWidth(this.mContext) - this.mContext.getResources().getDimensionPixelSize(R.dimen.ds16)) / 2;
        initView();
    }

    public e(TbPageContext<?> tbPageContext, int i) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.mFromPage = "square_recommend";
        this.mViewWidth = (l.getEquipmentWidth(this.mContext) - this.mContext.getResources().getDimensionPixelSize(R.dimen.ds16)) / 2;
        this.gMb = i;
        initView();
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.square_live_layout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    /* renamed from: b */
    public void a(com.baidu.tieba.ala.alasquare.a.e eVar) {
        if (eVar == null || eVar.gAx == null) {
            getView().setVisibility(4);
            return;
        }
        getView().setVisibility(0);
        this.gEV = eVar;
        this.gAx = eVar.gAx;
        this.gLQ.setVisibility(0);
        this.gLR.setVisibility(8);
        this.gLS.setVisibility(0);
        this.gLd.setMaxLines(1);
        ViewGroup.LayoutParams layoutParams = this.gLb.getLayoutParams();
        layoutParams.width = this.mViewWidth;
        layoutParams.height = this.mViewWidth;
        this.gLb.setLayoutParams(layoutParams);
        this.gLP.setCompoundDrawablesWithIntrinsicBounds(R.drawable.icon_video_direct_seeding, 0, 0, 0);
        this.gLP.setText(this.mContext.getResources().getString(R.string.square_live_tip));
        this.gKY.startLoad(this.gAx.brJ().cover, 10, false);
        String numberUniformFormatExtra = at.numberUniformFormatExtra(this.gAx.brJ().audience_count);
        this.gLa.setText(this.mContext.getResources().getString(R.string.square_audience_label, numberUniformFormatExtra));
        this.gLc.setData(this.gAx);
        this.gLd.setText(this.gAx.getTitle());
        if (this.gAx.brq() != null) {
            String name_show = eVar.gAx.brq().getName_show();
            if (ad.getTextLengthWithEmoji(name_show) > 10) {
                name_show = ad.subStringWithEmoji(name_show, 10) + StringHelper.STRING_MORE;
            }
            this.bac.setText(name_show);
            this.gLX.setText(name_show);
        }
        this.gLT.setText(at.getFormatTime(this.gAx.getCreateTime()));
        this.gLW.setData(this.gAx, false);
        this.gLO.setText(this.mContext.getResources().getString(R.string.square_audience_label, numberUniformFormatExtra));
        this.gLY.setText(this.gAx.getTitle());
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    private void initView() {
        this.gKY = (TbImageView) getView().findViewById(R.id.imgSquareView);
        this.gLP = (TextView) getView().findViewById(R.id.tvSquareTip);
        this.gLQ = (LinearLayout) getView().findViewById(R.id.llLiveTipPanel);
        this.gLR = (ImageView) getView().findViewById(R.id.imgLiveCountLabel);
        this.gLa = (TextView) getView().findViewById(R.id.tvLiveCount);
        this.gLS = (LinearLayout) getView().findViewById(R.id.llLiveBottomPanel);
        this.gLb = (RelativeLayout) getView().findViewById(R.id.rlSquareLivePanel);
        this.gLc = (ClickableHeaderImageView) getView().findViewById(R.id.imgUserCover);
        this.bac = (TextView) getView().findViewById(R.id.tvUserName);
        this.gLT = (TextView) getView().findViewById(R.id.tvCreateTime);
        this.gLU = (RelativeLayout) getView().findViewById(R.id.rlSquareUserInfo);
        this.gLd = (TextView) getView().findViewById(R.id.tvSquareTitle);
        this.gLZ = getView().findViewById(R.id.llSquareTitlePanel);
        this.gLV = (RelativeLayout) getView().findViewById(R.id.rlSquareNewUserInfo);
        this.gLW = (ClickableHeaderImageView) getView().findViewById(R.id.imgNewUserCover);
        this.gLX = (TextView) getView().findViewById(R.id.tvNewUserName);
        this.gLO = (TextView) getView().findViewById(R.id.tvNewCount);
        this.gLY = (TextView) getView().findViewById(R.id.tvSquareNewTitle);
        this.gLW.setIsRound(true);
        if (this.gMb == 0) {
            this.gKY.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        } else {
            this.gKY.setDefaultBgResource(this.gMb);
        }
        this.gKY.setDrawerType(0);
        this.gKY.setBorderSurroundContent(true);
        this.gKY.setDrawBorder(true);
        this.gLc.setIsRound(true);
        this.gLc.setBorderSurroundContent(true);
        getView().setOnClickListener(this);
    }

    public void setFromPage(String str) {
        this.mFromPage = str;
    }

    public void mO(boolean z) {
        this.gMa = z;
    }

    public void mP(boolean z) {
        this.gLU.setVisibility(z ? 0 : 8);
        if (z) {
            this.gLZ.setVisibility(0);
            this.gLS.setVisibility(0);
            this.gLV.setVisibility(8);
            this.gLY.setVisibility(8);
        }
    }

    public void mQ(boolean z) {
        this.gLV.setVisibility(z ? 0 : 8);
        this.gLY.setVisibility(z ? 0 : 8);
        if (z) {
            this.gLU.setVisibility(8);
            this.gLZ.setVisibility(8);
            this.gLS.setVisibility(8);
        }
    }

    public void a(d dVar) {
        this.gLE = dVar;
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ao.setBackgroundResource(this.gLb, R.drawable.addresslist_item_bg);
            ao.setViewTextColor(this.gLP, R.color.CAM_X0101);
            ao.setViewTextColor(this.gLa, R.color.CAM_X0111);
            ao.setViewTextColor(this.bac, R.color.CAM_X0108);
            ao.setViewTextColor(this.gLX, R.color.CAM_X0106);
            ao.setViewTextColor(this.gLT, R.color.CAM_X0108);
            ao.setViewTextColor(this.gLd, R.color.CAM_X0105);
            ao.setViewTextColor(this.gLY, R.color.CAM_X0111);
            ao.setViewTextColor(this.gLO, R.color.CAM_X0106);
            this.mSkinType = i;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == getView()) {
            if (!j.isNetWorkAvailable()) {
                l.showLongToast(this.mContext, this.mContext.getString(R.string.no_network_guide));
                return;
            }
            if (this.gLE != null) {
                this.gLE.a(view, this.gEV);
            }
            com.baidu.tieba.ala.alasquare.b.a.bVl().mG(true);
            a(this.mTbPageContext, this.gAx);
        }
    }

    public void a(TbPageContext<?> tbPageContext, bz bzVar) {
        if (tbPageContext != null && bzVar != null && bzVar.brq() != null && bzVar.brJ() != null) {
            boolean z = false;
            String str = "";
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                String userId = bzVar.brq().getUserId();
                str = TbadkCoreApplication.getCurrentAccount();
                z = TextUtils.equals(userId, str);
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(bzVar.brJ());
            alaLiveInfoCoreData.userName = bzVar.brq().getUserName();
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(tbPageContext.getPageActivity(), alaLiveInfoCoreData, this.mFromPage, str, z, "")));
        }
    }
}
