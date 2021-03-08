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
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.util.ag;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class e extends com.baidu.tieba.card.b<com.baidu.tieba.ala.alasquare.a.e> {
    private TextView aZX;
    private cb gAx;
    private com.baidu.tieba.ala.alasquare.a.e gEV;
    private TbImageView gKZ;
    private d gLF;
    private TextView gLP;
    private TextView gLQ;
    private LinearLayout gLR;
    private ImageView gLS;
    private LinearLayout gLT;
    private TextView gLU;
    private RelativeLayout gLV;
    private RelativeLayout gLW;
    private ClickableHeaderImageView gLX;
    private TextView gLY;
    private TextView gLZ;
    private TextView gLb;
    private RelativeLayout gLc;
    private ClickableHeaderImageView gLd;
    private TextView gLe;
    private View gMa;
    private boolean gMb;
    private int gMc;
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
        this.gMc = i;
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
        this.gLR.setVisibility(0);
        this.gLS.setVisibility(8);
        this.gLT.setVisibility(0);
        this.gLe.setMaxLines(1);
        ViewGroup.LayoutParams layoutParams = this.gLc.getLayoutParams();
        layoutParams.width = this.mViewWidth;
        layoutParams.height = this.mViewWidth;
        this.gLc.setLayoutParams(layoutParams);
        this.gLQ.setCompoundDrawablesWithIntrinsicBounds(R.drawable.icon_video_direct_seeding, 0, 0, 0);
        this.gLQ.setText(this.mContext.getResources().getString(R.string.square_live_tip));
        this.gKZ.startLoad(this.gAx.bol().cover, 10, false);
        String numberUniformFormatExtra = au.numberUniformFormatExtra(this.gAx.bol().audience_count);
        this.gLb.setText(this.mContext.getResources().getString(R.string.square_audience_label, numberUniformFormatExtra));
        this.gLd.setData(this.gAx);
        this.gLe.setText(this.gAx.getTitle());
        if (this.gAx.bnS() != null) {
            String name_show = eVar.gAx.bnS().getName_show();
            if (ag.getTextLengthWithEmoji(name_show) > 10) {
                name_show = ag.subStringWithEmoji(name_show, 10) + StringHelper.STRING_MORE;
            }
            this.aZX.setText(name_show);
            this.gLY.setText(name_show);
        }
        this.gLU.setText(au.getFormatTime(this.gAx.getCreateTime()));
        this.gLX.setData(this.gAx, false);
        this.gLP.setText(this.mContext.getResources().getString(R.string.square_audience_label, numberUniformFormatExtra));
        this.gLZ.setText(this.gAx.getTitle());
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    private void initView() {
        this.gKZ = (TbImageView) getView().findViewById(R.id.imgSquareView);
        this.gLQ = (TextView) getView().findViewById(R.id.tvSquareTip);
        this.gLR = (LinearLayout) getView().findViewById(R.id.llLiveTipPanel);
        this.gLS = (ImageView) getView().findViewById(R.id.imgLiveCountLabel);
        this.gLb = (TextView) getView().findViewById(R.id.tvLiveCount);
        this.gLT = (LinearLayout) getView().findViewById(R.id.llLiveBottomPanel);
        this.gLc = (RelativeLayout) getView().findViewById(R.id.rlSquareLivePanel);
        this.gLd = (ClickableHeaderImageView) getView().findViewById(R.id.imgUserCover);
        this.aZX = (TextView) getView().findViewById(R.id.tvUserName);
        this.gLU = (TextView) getView().findViewById(R.id.tvCreateTime);
        this.gLV = (RelativeLayout) getView().findViewById(R.id.rlSquareUserInfo);
        this.gLe = (TextView) getView().findViewById(R.id.tvSquareTitle);
        this.gMa = getView().findViewById(R.id.llSquareTitlePanel);
        this.gLW = (RelativeLayout) getView().findViewById(R.id.rlSquareNewUserInfo);
        this.gLX = (ClickableHeaderImageView) getView().findViewById(R.id.imgNewUserCover);
        this.gLY = (TextView) getView().findViewById(R.id.tvNewUserName);
        this.gLP = (TextView) getView().findViewById(R.id.tvNewCount);
        this.gLZ = (TextView) getView().findViewById(R.id.tvSquareNewTitle);
        this.gLX.setIsRound(true);
        if (this.gMc == 0) {
            this.gKZ.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        } else {
            this.gKZ.setDefaultBgResource(this.gMc);
        }
        this.gKZ.setDrawerType(0);
        this.gKZ.setBorderSurroundContent(true);
        this.gKZ.setDrawBorder(true);
        this.gLd.setIsRound(true);
        this.gLd.setBorderSurroundContent(true);
        getView().setOnClickListener(this);
    }

    public void setFromPage(String str) {
        this.mFromPage = str;
    }

    public void mO(boolean z) {
        this.gMb = z;
    }

    public void mP(boolean z) {
        this.gLV.setVisibility(z ? 0 : 8);
        if (z) {
            this.gMa.setVisibility(0);
            this.gLT.setVisibility(0);
            this.gLW.setVisibility(8);
            this.gLZ.setVisibility(8);
        }
    }

    public void mQ(boolean z) {
        this.gLW.setVisibility(z ? 0 : 8);
        this.gLZ.setVisibility(z ? 0 : 8);
        if (z) {
            this.gLV.setVisibility(8);
            this.gMa.setVisibility(8);
            this.gLT.setVisibility(8);
        }
    }

    public void a(d dVar) {
        this.gLF = dVar;
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundResource(this.gLc, R.drawable.addresslist_item_bg);
            ap.setViewTextColor(this.gLQ, R.color.CAM_X0101);
            ap.setViewTextColor(this.gLb, R.color.CAM_X0111);
            ap.setViewTextColor(this.aZX, R.color.CAM_X0108);
            ap.setViewTextColor(this.gLY, R.color.CAM_X0106);
            ap.setViewTextColor(this.gLU, R.color.CAM_X0108);
            ap.setViewTextColor(this.gLe, R.color.CAM_X0105);
            ap.setViewTextColor(this.gLZ, R.color.CAM_X0111);
            ap.setViewTextColor(this.gLP, R.color.CAM_X0106);
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
            if (this.gLF != null) {
                this.gLF.a(view, this.gEV);
            }
            com.baidu.tieba.ala.alasquare.b.a.bSk().mG(true);
            a(this.mTbPageContext, this.gAx);
        }
    }

    public void a(TbPageContext<?> tbPageContext, cb cbVar) {
        if (tbPageContext != null && cbVar != null && cbVar.bnS() != null && cbVar.bol() != null) {
            boolean z = false;
            String str = "";
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                String userId = cbVar.bnS().getUserId();
                str = TbadkCoreApplication.getCurrentAccount();
                z = TextUtils.equals(userId, str);
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(cbVar.bol());
            alaLiveInfoCoreData.userName = cbVar.bnS().getUserName();
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(tbPageContext.getPageActivity(), alaLiveInfoCoreData, this.mFromPage, str, z, "")));
        }
    }
}
