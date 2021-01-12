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
/* loaded from: classes9.dex */
public class e extends com.baidu.tieba.card.b<com.baidu.tieba.ala.alasquare.a.e> {
    private TextView aVp;
    private com.baidu.tieba.ala.alasquare.a.e gAo;
    private d gGY;
    private TbImageView gGs;
    private TextView gGu;
    private RelativeLayout gGv;
    private ClickableHeaderImageView gGw;
    private TextView gGx;
    private TextView gHi;
    private TextView gHj;
    private LinearLayout gHk;
    private ImageView gHl;
    private LinearLayout gHm;
    private TextView gHn;
    private RelativeLayout gHo;
    private RelativeLayout gHp;
    private ClickableHeaderImageView gHq;
    private TextView gHr;
    private TextView gHs;
    private View gHt;
    private boolean gHu;
    private int gHv;
    private bz gvQ;
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
        this.gHv = i;
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
        if (eVar == null || eVar.gvQ == null) {
            getView().setVisibility(4);
            return;
        }
        getView().setVisibility(0);
        this.gAo = eVar;
        this.gvQ = eVar.gvQ;
        this.gHk.setVisibility(0);
        this.gHl.setVisibility(8);
        this.gHm.setVisibility(0);
        this.gGx.setMaxLines(1);
        ViewGroup.LayoutParams layoutParams = this.gGv.getLayoutParams();
        layoutParams.width = this.mViewWidth;
        layoutParams.height = this.mViewWidth;
        this.gGv.setLayoutParams(layoutParams);
        this.gHj.setCompoundDrawablesWithIntrinsicBounds(R.drawable.icon_video_direct_seeding, 0, 0, 0);
        this.gHj.setText(this.mContext.getResources().getString(R.string.square_live_tip));
        this.gGs.startLoad(this.gvQ.bnQ().cover, 10, false);
        String numberUniformFormatExtra = at.numberUniformFormatExtra(this.gvQ.bnQ().audience_count);
        this.gGu.setText(this.mContext.getResources().getString(R.string.square_audience_label, numberUniformFormatExtra));
        this.gGw.setData(this.gvQ);
        this.gGx.setText(this.gvQ.getTitle());
        if (this.gvQ.bnx() != null) {
            String name_show = eVar.gvQ.bnx().getName_show();
            if (ad.getTextLengthWithEmoji(name_show) > 10) {
                name_show = ad.subStringWithEmoji(name_show, 10) + StringHelper.STRING_MORE;
            }
            this.aVp.setText(name_show);
            this.gHr.setText(name_show);
        }
        this.gHn.setText(at.getFormatTime(this.gvQ.getCreateTime()));
        this.gHq.setData(this.gvQ, false);
        this.gHi.setText(this.mContext.getResources().getString(R.string.square_audience_label, numberUniformFormatExtra));
        this.gHs.setText(this.gvQ.getTitle());
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    private void initView() {
        this.gGs = (TbImageView) getView().findViewById(R.id.imgSquareView);
        this.gHj = (TextView) getView().findViewById(R.id.tvSquareTip);
        this.gHk = (LinearLayout) getView().findViewById(R.id.llLiveTipPanel);
        this.gHl = (ImageView) getView().findViewById(R.id.imgLiveCountLabel);
        this.gGu = (TextView) getView().findViewById(R.id.tvLiveCount);
        this.gHm = (LinearLayout) getView().findViewById(R.id.llLiveBottomPanel);
        this.gGv = (RelativeLayout) getView().findViewById(R.id.rlSquareLivePanel);
        this.gGw = (ClickableHeaderImageView) getView().findViewById(R.id.imgUserCover);
        this.aVp = (TextView) getView().findViewById(R.id.tvUserName);
        this.gHn = (TextView) getView().findViewById(R.id.tvCreateTime);
        this.gHo = (RelativeLayout) getView().findViewById(R.id.rlSquareUserInfo);
        this.gGx = (TextView) getView().findViewById(R.id.tvSquareTitle);
        this.gHt = getView().findViewById(R.id.llSquareTitlePanel);
        this.gHp = (RelativeLayout) getView().findViewById(R.id.rlSquareNewUserInfo);
        this.gHq = (ClickableHeaderImageView) getView().findViewById(R.id.imgNewUserCover);
        this.gHr = (TextView) getView().findViewById(R.id.tvNewUserName);
        this.gHi = (TextView) getView().findViewById(R.id.tvNewCount);
        this.gHs = (TextView) getView().findViewById(R.id.tvSquareNewTitle);
        this.gHq.setIsRound(true);
        if (this.gHv == 0) {
            this.gGs.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        } else {
            this.gGs.setDefaultBgResource(this.gHv);
        }
        this.gGs.setDrawerType(0);
        this.gGs.setBorderSurroundContent(true);
        this.gGs.setDrawBorder(true);
        this.gGw.setIsRound(true);
        this.gGw.setBorderSurroundContent(true);
        getView().setOnClickListener(this);
    }

    public void setFromPage(String str) {
        this.mFromPage = str;
    }

    public void mK(boolean z) {
        this.gHu = z;
    }

    public void mL(boolean z) {
        this.gHo.setVisibility(z ? 0 : 8);
        if (z) {
            this.gHt.setVisibility(0);
            this.gHm.setVisibility(0);
            this.gHp.setVisibility(8);
            this.gHs.setVisibility(8);
        }
    }

    public void mM(boolean z) {
        this.gHp.setVisibility(z ? 0 : 8);
        this.gHs.setVisibility(z ? 0 : 8);
        if (z) {
            this.gHo.setVisibility(8);
            this.gHt.setVisibility(8);
            this.gHm.setVisibility(8);
        }
    }

    public void a(d dVar) {
        this.gGY = dVar;
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ao.setBackgroundResource(this.gGv, R.drawable.addresslist_item_bg);
            ao.setViewTextColor(this.gHj, R.color.CAM_X0101);
            ao.setViewTextColor(this.gGu, R.color.CAM_X0111);
            ao.setViewTextColor(this.aVp, R.color.CAM_X0108);
            ao.setViewTextColor(this.gHr, R.color.CAM_X0106);
            ao.setViewTextColor(this.gHn, R.color.CAM_X0108);
            ao.setViewTextColor(this.gGx, R.color.CAM_X0105);
            ao.setViewTextColor(this.gHs, R.color.CAM_X0111);
            ao.setViewTextColor(this.gHi, R.color.CAM_X0106);
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
            if (this.gGY != null) {
                this.gGY.a(view, this.gAo);
            }
            com.baidu.tieba.ala.alasquare.b.a.bRu().mC(true);
            a(this.mTbPageContext, this.gvQ);
        }
    }

    public void a(TbPageContext<?> tbPageContext, bz bzVar) {
        if (tbPageContext != null && bzVar != null && bzVar.bnx() != null && bzVar.bnQ() != null) {
            boolean z = false;
            String str = "";
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                String userId = bzVar.bnx().getUserId();
                str = TbadkCoreApplication.getCurrentAccount();
                z = TextUtils.equals(userId, str);
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(bzVar.bnQ());
            alaLiveInfoCoreData.userName = bzVar.bnx().getUserName();
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(tbPageContext.getPageActivity(), alaLiveInfoCoreData, this.mFromPage, str, z, "")));
        }
    }
}
