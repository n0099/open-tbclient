package com.baidu.tieba.ala.personcenter.privilege.entereffect;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.e.c;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.ala.AlaCmdConfigCustom;
import com.baidu.ala.downloader.ResourceDownloader;
import com.baidu.ala.downloader.WrapDownloadData;
import com.baidu.ala.gift.AlaDynamicGiftLocalInfoConfig;
import com.baidu.ala.view.AlaNetRefreshView;
import com.baidu.ala.widget.multicolumn.absView.AbsFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.l.g;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.personcenter.privilege.entereffect.a;
import com.baidu.tieba.ala.personcenter.privilege.entereffect.a.b;
import com.baidu.tieba.ala.personcenter.privilege.entereffect.data.AlaEnterEffectData;
import java.util.List;
/* loaded from: classes6.dex */
public class AlaEnterEffectFragment extends AbsFragment {
    private static final String TITLE = TbadkCoreApplication.getInst().getResources().getString(R.string.ala_enter_effect_fragment_title);
    private View dlk;
    private g gAg;
    private BdTypeListView gpZ;
    private HeadImageView hPM;
    private TextView hPN;
    private TextView hPO;
    private TbImageView hPP;
    private com.baidu.tieba.ala.personcenter.privilege.entereffect.a.b hPQ;
    private a hPR;
    private TextView hPS;
    private TextView hPT;
    private RelativeLayout hPU;
    private CustomMessageListener hPV = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_ENTER_EFFECT_BUY_SUCCESS) { // from class: com.baidu.tieba.ala.personcenter.privilege.entereffect.AlaEnterEffectFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (AlaEnterEffectFragment.this.hPQ != null && customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                AlaEnterEffectFragment.this.hPQ.aF((String) customResponsedMessage.getData(), true);
            }
        }
    };
    private b.a hPW = new b.a() { // from class: com.baidu.tieba.ala.personcenter.privilege.entereffect.AlaEnterEffectFragment.2
    };
    private a.InterfaceC0715a hPX = new a.InterfaceC0715a() { // from class: com.baidu.tieba.ala.personcenter.privilege.entereffect.AlaEnterEffectFragment.4
        @Override // com.baidu.tieba.ala.personcenter.privilege.entereffect.a.InterfaceC0715a
        public void a(AlaGetEnterEffectResponsedMessage alaGetEnterEffectResponsedMessage) {
            AlaEnterEffectFragment.this.hideLoadingView();
            AlaEnterEffectFragment.this.Yb();
            if (alaGetEnterEffectResponsedMessage == null || alaGetEnterEffectResponsedMessage.getError() != 0) {
                AlaEnterEffectFragment.this.IY(TbadkCoreApplication.getCurrentPortrait());
                AlaEnterEffectFragment.this.hPO.setText(AlaEnterEffectFragment.this.getString(R.string.ala_enter_effect_count, 0));
                AlaEnterEffectFragment.this.hPN.setText(TbadkCoreApplication.getCurrentAccountNameShow());
                if (j.isNetWorkAvailable()) {
                    AlaEnterEffectFragment.this.a(R.drawable.pic_live_empty04, R.string.ala_net_data_error_fail_tip, false, null);
                    return;
                } else {
                    AlaEnterEffectFragment.this.a(R.drawable.pic_live_empty03, R.string.ala_net_fail_tip, true, new View.OnClickListener() { // from class: com.baidu.tieba.ala.personcenter.privilege.entereffect.AlaEnterEffectFragment.4.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            AlaEnterEffectFragment.this.Yb();
                            AlaEnterEffectFragment.this.showLoadingView();
                            AlaEnterEffectFragment.this.hPR.cnm();
                        }
                    });
                    return;
                }
            }
            AlaEnterEffectFragment.this.IY(alaGetEnterEffectResponsedMessage.getPortrait());
            AlaEnterEffectFragment.this.hPN.setText(alaGetEnterEffectResponsedMessage.getUserName());
            AlaEnterEffectFragment.this.hPO.setText(AlaEnterEffectFragment.this.getString(R.string.ala_enter_effect_count, Integer.valueOf(alaGetEnterEffectResponsedMessage.getEnterEffectCount())));
            List<q> effectList = alaGetEnterEffectResponsedMessage.getEffectList();
            AlaEnterEffectFragment.this.hPQ.setData(effectList);
            if (!y.isEmpty(effectList) && j.isWifiNet()) {
                for (q qVar : effectList) {
                    if (qVar instanceof AlaEnterEffectData) {
                        AlaEnterEffectData alaEnterEffectData = (AlaEnterEffectData) qVar;
                        if (alaEnterEffectData.type == 1 && alaEnterEffectData.downLoadStatus == 100) {
                            ResourceDownloader.checkAndDownloadResZipInMainThread(alaEnterEffectData.gift.giftId, alaEnterEffectData.gift.giftZip.zipDownloadUrl, alaEnterEffectData.gift.giftName, AlaDynamicGiftLocalInfoConfig.DIR_PATH + alaEnterEffectData.gift.giftZip.zipName, AlaDynamicGiftLocalInfoConfig.PIC_MD5_PREFIX, alaEnterEffectData.gift.giftZip.zipMD5, false);
                            AlaEnterEffectFragment.this.hPQ.aL(alaEnterEffectData.gift.giftId, 102);
                        }
                    }
                }
            }
        }
    };
    private CustomMessageListener hPY = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_RES_ZIP_DOWNLOADED_STATUS) { // from class: com.baidu.tieba.ala.personcenter.privilege.entereffect.AlaEnterEffectFragment.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            DownloadData downloadData;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof WrapDownloadData)) {
                WrapDownloadData wrapDownloadData = (WrapDownloadData) customResponsedMessage.getData();
                if (wrapDownloadData.status == 4 && (downloadData = wrapDownloadData.data) != null && !StringUtils.isNull(downloadData.getId())) {
                    AlaEnterEffectFragment.this.hPQ.aL(downloadData.getId(), 101);
                }
            }
        }
    };
    private ImageView hPv;
    private AlaNetRefreshView hPx;
    private View mEmptyView;
    private View mRootView;

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(this.hPY);
        registerListener(this.hPV);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        this.mRootView = LayoutInflater.from(getContext()).inflate(R.layout.ala_enter_effect_fragment_layout, (ViewGroup) null);
        initView();
        this.hPR = new a(getPageContext(), this.hPX);
        showLoadingView();
        this.hPR.cnm();
        return this.mRootView;
    }

    private void initView() {
        if (this.mRootView != null) {
            this.hPM = (HeadImageView) this.mRootView.findViewById(R.id.ala_enter_effect_header);
            this.hPM.setIsRound(true);
            this.hPP = (TbImageView) this.mRootView.findViewById(R.id.ala_enter_effect_header_container_bg);
            this.hPN = (TextView) this.mRootView.findViewById(R.id.ala_enter_effect_name);
            this.hPO = (TextView) this.mRootView.findViewById(R.id.ala_enter_effect_count);
            this.hPS = (TextView) this.mRootView.findViewById(R.id.ala_enter_effect_description_txt);
            this.dlk = this.mRootView.findViewById(R.id.ala_enter_effect_mask);
            this.hPv = (ImageView) this.mRootView.findViewById(R.id.empty_image);
            this.hPT = (TextView) this.mRootView.findViewById(R.id.empty_text);
            this.hPU = (RelativeLayout) this.mRootView.findViewById(R.id.ala_enter_effect_list_layout);
            this.gpZ = (BdTypeListView) this.mRootView.findViewById(R.id.ala_enter_effect_list_view);
            this.mEmptyView = this.mRootView.findViewById(R.id.emptyview);
            this.gpZ.setEmptyView(this.mEmptyView);
            this.hPQ = new com.baidu.tieba.ala.personcenter.privilege.entereffect.a.b(getPageContext(), this.gpZ);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void IY(String str) {
        if (!StringUtils.isNull(str)) {
            this.hPM.startLoad(str, 25, false);
            c.mS().a(str, 25, new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.ala.personcenter.privilege.entereffect.AlaEnterEffectFragment.3
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.e.b
                public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str2, int i) {
                    super.onLoaded((AnonymousClass3) aVar, str2, i);
                    if (aVar != null && aVar.getRawBitmap() != null) {
                        AlaEnterEffectFragment.this.hPP.setScaleType(ImageView.ScaleType.CENTER_CROP);
                        AlaEnterEffectFragment.this.hPP.setImageBitmap(BitmapHelper.fastblur(aVar.getRawBitmap(), 15, 0.75f));
                    }
                }
            }, null);
            return;
        }
        this.hPM.startLoad(String.valueOf((int) R.drawable.icon_default_avatar100_bg), 24, false);
        this.hPP.startLoad(String.valueOf((int) R.drawable.icon_default_avatar100_bg), 24, false);
    }

    public void a(int i, int i2, boolean z, View.OnClickListener onClickListener) {
        if (this.hPx == null) {
            this.hPx = new AlaNetRefreshView(getContext());
        }
        this.hPx.setImageResource(i);
        this.hPx.setNetFailTipText(getContext().getString(i2));
        this.hPx.onChangeSkinType();
        this.hPx.setIsShowRefreshButton(z);
        if (z) {
            this.hPx.setOnRefreshClickListener(onClickListener);
        }
        this.hPx.attachView(this.hPU);
    }

    public void Yb() {
        if (this.hPx != null) {
            this.hPx.dettachView(this.hPU);
        }
    }

    @Override // com.baidu.ala.widget.multicolumn.absView.AbsFragment
    public int getPageType() {
        return 0;
    }

    @Override // com.baidu.ala.widget.multicolumn.absView.AbsFragment
    public String getTabTitle() {
        return TITLE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showLoadingView() {
        if (this.gAg == null) {
            this.gAg = new g(getPageContext().getPageActivity(), getContext().getResources().getDimensionPixelSize(R.dimen.ds386));
        }
        this.gAg.attachView(this.mRootView, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideLoadingView() {
        if (this.gAg != null) {
            this.gAg.dettachView(this.mRootView);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.gAg != null) {
            this.gAg.onChangeSkinType();
        }
        if (this.hPx != null) {
            this.hPx.onChangeSkinType();
        }
        ap.setBackgroundColor(this.mRootView, R.color.CAM_X0201);
        ap.setViewTextColor(this.hPN, R.color.common_color_10310, 1, i);
        ap.setViewTextColor(this.hPO, R.color.white_alpha70, 1, i);
        ap.setViewTextColor(this.hPS, R.color.CAM_X0109, 1, i);
        ap.setViewTextColor(this.hPT, R.color.CAM_X0106, 1, i);
        if (i == 1) {
            if (this.hPv != null) {
                this.hPv.setAlpha(0.4f);
            }
            if (this.dlk != null) {
                this.dlk.setBackgroundColor(TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha60));
                return;
            }
            return;
        }
        if (this.hPv != null) {
            this.hPv.setAlpha(1.0f);
        }
        if (this.dlk != null) {
            this.dlk.setBackgroundColor(TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha30));
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 1001 && i2 == -1 && intent != null) {
            this.hPQ.aE(intent.getStringExtra("key_selected_effect_id"), intent.getBooleanExtra("key_status_is_selected", false));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded() && isPrimary()) {
            TiebaStatic.log("c13335");
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        hideLoadingView();
        if (this.hPR != null) {
            this.hPR.onDestory();
        }
    }
}
