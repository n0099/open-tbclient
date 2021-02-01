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
/* loaded from: classes10.dex */
public class e extends com.baidu.tieba.card.b<com.baidu.tieba.ala.alasquare.a.e> {
    private TextView aYx;
    private com.baidu.tieba.ala.alasquare.a.e gCY;
    private d gJI;
    private TextView gJS;
    private TextView gJT;
    private LinearLayout gJU;
    private ImageView gJV;
    private LinearLayout gJW;
    private TextView gJX;
    private RelativeLayout gJY;
    private RelativeLayout gJZ;
    private TbImageView gJc;
    private TextView gJe;
    private RelativeLayout gJf;
    private ClickableHeaderImageView gJg;
    private TextView gJh;
    private ClickableHeaderImageView gKa;
    private TextView gKb;
    private TextView gKc;
    private View gKd;
    private boolean gKe;
    private int gKf;
    private cb gyA;
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
        this.gKf = i;
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
        if (eVar == null || eVar.gyA == null) {
            getView().setVisibility(4);
            return;
        }
        getView().setVisibility(0);
        this.gCY = eVar;
        this.gyA = eVar.gyA;
        this.gJU.setVisibility(0);
        this.gJV.setVisibility(8);
        this.gJW.setVisibility(0);
        this.gJh.setMaxLines(1);
        ViewGroup.LayoutParams layoutParams = this.gJf.getLayoutParams();
        layoutParams.width = this.mViewWidth;
        layoutParams.height = this.mViewWidth;
        this.gJf.setLayoutParams(layoutParams);
        this.gJT.setCompoundDrawablesWithIntrinsicBounds(R.drawable.icon_video_direct_seeding, 0, 0, 0);
        this.gJT.setText(this.mContext.getResources().getString(R.string.square_live_tip));
        this.gJc.startLoad(this.gyA.boj().cover, 10, false);
        String numberUniformFormatExtra = au.numberUniformFormatExtra(this.gyA.boj().audience_count);
        this.gJe.setText(this.mContext.getResources().getString(R.string.square_audience_label, numberUniformFormatExtra));
        this.gJg.setData(this.gyA);
        this.gJh.setText(this.gyA.getTitle());
        if (this.gyA.bnQ() != null) {
            String name_show = eVar.gyA.bnQ().getName_show();
            if (ag.getTextLengthWithEmoji(name_show) > 10) {
                name_show = ag.subStringWithEmoji(name_show, 10) + StringHelper.STRING_MORE;
            }
            this.aYx.setText(name_show);
            this.gKb.setText(name_show);
        }
        this.gJX.setText(au.getFormatTime(this.gyA.getCreateTime()));
        this.gKa.setData(this.gyA, false);
        this.gJS.setText(this.mContext.getResources().getString(R.string.square_audience_label, numberUniformFormatExtra));
        this.gKc.setText(this.gyA.getTitle());
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    private void initView() {
        this.gJc = (TbImageView) getView().findViewById(R.id.imgSquareView);
        this.gJT = (TextView) getView().findViewById(R.id.tvSquareTip);
        this.gJU = (LinearLayout) getView().findViewById(R.id.llLiveTipPanel);
        this.gJV = (ImageView) getView().findViewById(R.id.imgLiveCountLabel);
        this.gJe = (TextView) getView().findViewById(R.id.tvLiveCount);
        this.gJW = (LinearLayout) getView().findViewById(R.id.llLiveBottomPanel);
        this.gJf = (RelativeLayout) getView().findViewById(R.id.rlSquareLivePanel);
        this.gJg = (ClickableHeaderImageView) getView().findViewById(R.id.imgUserCover);
        this.aYx = (TextView) getView().findViewById(R.id.tvUserName);
        this.gJX = (TextView) getView().findViewById(R.id.tvCreateTime);
        this.gJY = (RelativeLayout) getView().findViewById(R.id.rlSquareUserInfo);
        this.gJh = (TextView) getView().findViewById(R.id.tvSquareTitle);
        this.gKd = getView().findViewById(R.id.llSquareTitlePanel);
        this.gJZ = (RelativeLayout) getView().findViewById(R.id.rlSquareNewUserInfo);
        this.gKa = (ClickableHeaderImageView) getView().findViewById(R.id.imgNewUserCover);
        this.gKb = (TextView) getView().findViewById(R.id.tvNewUserName);
        this.gJS = (TextView) getView().findViewById(R.id.tvNewCount);
        this.gKc = (TextView) getView().findViewById(R.id.tvSquareNewTitle);
        this.gKa.setIsRound(true);
        if (this.gKf == 0) {
            this.gJc.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        } else {
            this.gJc.setDefaultBgResource(this.gKf);
        }
        this.gJc.setDrawerType(0);
        this.gJc.setBorderSurroundContent(true);
        this.gJc.setDrawBorder(true);
        this.gJg.setIsRound(true);
        this.gJg.setBorderSurroundContent(true);
        getView().setOnClickListener(this);
    }

    public void setFromPage(String str) {
        this.mFromPage = str;
    }

    public void mO(boolean z) {
        this.gKe = z;
    }

    public void mP(boolean z) {
        this.gJY.setVisibility(z ? 0 : 8);
        if (z) {
            this.gKd.setVisibility(0);
            this.gJW.setVisibility(0);
            this.gJZ.setVisibility(8);
            this.gKc.setVisibility(8);
        }
    }

    public void mQ(boolean z) {
        this.gJZ.setVisibility(z ? 0 : 8);
        this.gKc.setVisibility(z ? 0 : 8);
        if (z) {
            this.gJY.setVisibility(8);
            this.gKd.setVisibility(8);
            this.gJW.setVisibility(8);
        }
    }

    public void a(d dVar) {
        this.gJI = dVar;
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundResource(this.gJf, R.drawable.addresslist_item_bg);
            ap.setViewTextColor(this.gJT, R.color.CAM_X0101);
            ap.setViewTextColor(this.gJe, R.color.CAM_X0111);
            ap.setViewTextColor(this.aYx, R.color.CAM_X0108);
            ap.setViewTextColor(this.gKb, R.color.CAM_X0106);
            ap.setViewTextColor(this.gJX, R.color.CAM_X0108);
            ap.setViewTextColor(this.gJh, R.color.CAM_X0105);
            ap.setViewTextColor(this.gKc, R.color.CAM_X0111);
            ap.setViewTextColor(this.gJS, R.color.CAM_X0106);
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
            if (this.gJI != null) {
                this.gJI.a(view, this.gCY);
            }
            com.baidu.tieba.ala.alasquare.b.a.bRX().mG(true);
            a(this.mTbPageContext, this.gyA);
        }
    }

    public void a(TbPageContext<?> tbPageContext, cb cbVar) {
        if (tbPageContext != null && cbVar != null && cbVar.bnQ() != null && cbVar.boj() != null) {
            boolean z = false;
            String str = "";
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                String userId = cbVar.bnQ().getUserId();
                str = TbadkCoreApplication.getCurrentAccount();
                z = TextUtils.equals(userId, str);
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(cbVar.boj());
            alaLiveInfoCoreData.userName = cbVar.bnQ().getUserName();
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(tbPageContext.getPageActivity(), alaLiveInfoCoreData, this.mFromPage, str, z, "")));
        }
    }
}
