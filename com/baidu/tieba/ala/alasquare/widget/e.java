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
    private com.baidu.tieba.ala.alasquare.a.e gDm;
    private d gJW;
    private TbImageView gJq;
    private TextView gJs;
    private RelativeLayout gJt;
    private ClickableHeaderImageView gJu;
    private TextView gJv;
    private TextView gKg;
    private TextView gKh;
    private LinearLayout gKi;
    private ImageView gKj;
    private LinearLayout gKk;
    private TextView gKl;
    private RelativeLayout gKm;
    private RelativeLayout gKn;
    private ClickableHeaderImageView gKo;
    private TextView gKp;
    private TextView gKq;
    private View gKr;
    private boolean gKs;
    private int gKt;
    private cb gyO;
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
        this.gKt = i;
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
        if (eVar == null || eVar.gyO == null) {
            getView().setVisibility(4);
            return;
        }
        getView().setVisibility(0);
        this.gDm = eVar;
        this.gyO = eVar.gyO;
        this.gKi.setVisibility(0);
        this.gKj.setVisibility(8);
        this.gKk.setVisibility(0);
        this.gJv.setMaxLines(1);
        ViewGroup.LayoutParams layoutParams = this.gJt.getLayoutParams();
        layoutParams.width = this.mViewWidth;
        layoutParams.height = this.mViewWidth;
        this.gJt.setLayoutParams(layoutParams);
        this.gKh.setCompoundDrawablesWithIntrinsicBounds(R.drawable.icon_video_direct_seeding, 0, 0, 0);
        this.gKh.setText(this.mContext.getResources().getString(R.string.square_live_tip));
        this.gJq.startLoad(this.gyO.boj().cover, 10, false);
        String numberUniformFormatExtra = au.numberUniformFormatExtra(this.gyO.boj().audience_count);
        this.gJs.setText(this.mContext.getResources().getString(R.string.square_audience_label, numberUniformFormatExtra));
        this.gJu.setData(this.gyO);
        this.gJv.setText(this.gyO.getTitle());
        if (this.gyO.bnQ() != null) {
            String name_show = eVar.gyO.bnQ().getName_show();
            if (ag.getTextLengthWithEmoji(name_show) > 10) {
                name_show = ag.subStringWithEmoji(name_show, 10) + StringHelper.STRING_MORE;
            }
            this.aYx.setText(name_show);
            this.gKp.setText(name_show);
        }
        this.gKl.setText(au.getFormatTime(this.gyO.getCreateTime()));
        this.gKo.setData(this.gyO, false);
        this.gKg.setText(this.mContext.getResources().getString(R.string.square_audience_label, numberUniformFormatExtra));
        this.gKq.setText(this.gyO.getTitle());
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    private void initView() {
        this.gJq = (TbImageView) getView().findViewById(R.id.imgSquareView);
        this.gKh = (TextView) getView().findViewById(R.id.tvSquareTip);
        this.gKi = (LinearLayout) getView().findViewById(R.id.llLiveTipPanel);
        this.gKj = (ImageView) getView().findViewById(R.id.imgLiveCountLabel);
        this.gJs = (TextView) getView().findViewById(R.id.tvLiveCount);
        this.gKk = (LinearLayout) getView().findViewById(R.id.llLiveBottomPanel);
        this.gJt = (RelativeLayout) getView().findViewById(R.id.rlSquareLivePanel);
        this.gJu = (ClickableHeaderImageView) getView().findViewById(R.id.imgUserCover);
        this.aYx = (TextView) getView().findViewById(R.id.tvUserName);
        this.gKl = (TextView) getView().findViewById(R.id.tvCreateTime);
        this.gKm = (RelativeLayout) getView().findViewById(R.id.rlSquareUserInfo);
        this.gJv = (TextView) getView().findViewById(R.id.tvSquareTitle);
        this.gKr = getView().findViewById(R.id.llSquareTitlePanel);
        this.gKn = (RelativeLayout) getView().findViewById(R.id.rlSquareNewUserInfo);
        this.gKo = (ClickableHeaderImageView) getView().findViewById(R.id.imgNewUserCover);
        this.gKp = (TextView) getView().findViewById(R.id.tvNewUserName);
        this.gKg = (TextView) getView().findViewById(R.id.tvNewCount);
        this.gKq = (TextView) getView().findViewById(R.id.tvSquareNewTitle);
        this.gKo.setIsRound(true);
        if (this.gKt == 0) {
            this.gJq.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        } else {
            this.gJq.setDefaultBgResource(this.gKt);
        }
        this.gJq.setDrawerType(0);
        this.gJq.setBorderSurroundContent(true);
        this.gJq.setDrawBorder(true);
        this.gJu.setIsRound(true);
        this.gJu.setBorderSurroundContent(true);
        getView().setOnClickListener(this);
    }

    public void setFromPage(String str) {
        this.mFromPage = str;
    }

    public void mO(boolean z) {
        this.gKs = z;
    }

    public void mP(boolean z) {
        this.gKm.setVisibility(z ? 0 : 8);
        if (z) {
            this.gKr.setVisibility(0);
            this.gKk.setVisibility(0);
            this.gKn.setVisibility(8);
            this.gKq.setVisibility(8);
        }
    }

    public void mQ(boolean z) {
        this.gKn.setVisibility(z ? 0 : 8);
        this.gKq.setVisibility(z ? 0 : 8);
        if (z) {
            this.gKm.setVisibility(8);
            this.gKr.setVisibility(8);
            this.gKk.setVisibility(8);
        }
    }

    public void a(d dVar) {
        this.gJW = dVar;
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundResource(this.gJt, R.drawable.addresslist_item_bg);
            ap.setViewTextColor(this.gKh, R.color.CAM_X0101);
            ap.setViewTextColor(this.gJs, R.color.CAM_X0111);
            ap.setViewTextColor(this.aYx, R.color.CAM_X0108);
            ap.setViewTextColor(this.gKp, R.color.CAM_X0106);
            ap.setViewTextColor(this.gKl, R.color.CAM_X0108);
            ap.setViewTextColor(this.gJv, R.color.CAM_X0105);
            ap.setViewTextColor(this.gKq, R.color.CAM_X0111);
            ap.setViewTextColor(this.gKg, R.color.CAM_X0106);
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
            if (this.gJW != null) {
                this.gJW.a(view, this.gDm);
            }
            com.baidu.tieba.ala.alasquare.b.a.bSe().mG(true);
            a(this.mTbPageContext, this.gyO);
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
