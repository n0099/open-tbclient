package com.baidu.tieba.ala.personcenter.privilege.entereffect;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.e.c;
import com.baidu.adp.lib.e.d;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.n;
import com.baidu.ala.AlaCmdConfigCustom;
import com.baidu.ala.downloader.ResourceDownloader;
import com.baidu.ala.downloader.WrapDownloadData;
import com.baidu.ala.gift.AlaDynamicGiftLocalInfoConfig;
import com.baidu.ala.view.AlaNetRefreshView;
import com.baidu.ala.widget.multicolumn.absView.AbsFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.l.g;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.personcenter.privilege.entereffect.a;
import com.baidu.tieba.ala.personcenter.privilege.entereffect.adapter.a;
import com.baidu.tieba.ala.personcenter.privilege.entereffect.data.AlaEnterEffectData;
import java.util.List;
/* loaded from: classes9.dex */
public class AlaEnterEffectFragment extends AbsFragment {
    private static final String TITLE = TbadkCoreApplication.getInst().getResources().getString(R.string.ala_enter_effect_fragment_title);
    private View dlt;
    private g gGD;
    private BdTypeListView gwr;
    private HeadImageView hXB;
    private TextView hXC;
    private TextView hXD;
    private TbImageView hXE;
    private com.baidu.tieba.ala.personcenter.privilege.entereffect.adapter.a hXF;
    private a hXG;
    private TextView hXH;
    private TextView hXI;
    private RelativeLayout hXJ;
    private CustomMessageListener hXK = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_ENTER_EFFECT_BUY_SUCCESS) { // from class: com.baidu.tieba.ala.personcenter.privilege.entereffect.AlaEnterEffectFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (AlaEnterEffectFragment.this.hXF != null && customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                AlaEnterEffectFragment.this.hXF.aG((String) customResponsedMessage.getData(), true);
            }
        }
    };
    private a.InterfaceC0691a hXL = new a.InterfaceC0691a() { // from class: com.baidu.tieba.ala.personcenter.privilege.entereffect.AlaEnterEffectFragment.2
    };
    private a.InterfaceC0690a hXM = new a.InterfaceC0690a() { // from class: com.baidu.tieba.ala.personcenter.privilege.entereffect.AlaEnterEffectFragment.4
        @Override // com.baidu.tieba.ala.personcenter.privilege.entereffect.a.InterfaceC0690a
        public void a(AlaGetEnterEffectResponsedMessage alaGetEnterEffectResponsedMessage) {
            AlaEnterEffectFragment.this.hideLoadingView();
            AlaEnterEffectFragment.this.Vq();
            if (alaGetEnterEffectResponsedMessage == null || alaGetEnterEffectResponsedMessage.getError() != 0) {
                AlaEnterEffectFragment.this.HK(TbadkCoreApplication.getCurrentPortrait());
                AlaEnterEffectFragment.this.hXD.setText(AlaEnterEffectFragment.this.getString(R.string.ala_enter_effect_count, 0));
                AlaEnterEffectFragment.this.hXC.setText(TbadkCoreApplication.getCurrentAccountNameShow());
                if (j.isNetWorkAvailable()) {
                    AlaEnterEffectFragment.this.a(R.drawable.pic_live_empty04, R.string.ala_net_data_error_fail_tip, false, null);
                    return;
                } else {
                    AlaEnterEffectFragment.this.a(R.drawable.pic_live_empty03, R.string.ala_net_fail_tip, true, new View.OnClickListener() { // from class: com.baidu.tieba.ala.personcenter.privilege.entereffect.AlaEnterEffectFragment.4.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            AlaEnterEffectFragment.this.Vq();
                            AlaEnterEffectFragment.this.showLoadingView();
                            AlaEnterEffectFragment.this.hXG.cmn();
                        }
                    });
                    return;
                }
            }
            AlaEnterEffectFragment.this.HK(alaGetEnterEffectResponsedMessage.getPortrait());
            AlaEnterEffectFragment.this.hXC.setText(alaGetEnterEffectResponsedMessage.getUserName());
            AlaEnterEffectFragment.this.hXD.setText(AlaEnterEffectFragment.this.getString(R.string.ala_enter_effect_count, Integer.valueOf(alaGetEnterEffectResponsedMessage.getEnterEffectCount())));
            List<n> effectList = alaGetEnterEffectResponsedMessage.getEffectList();
            AlaEnterEffectFragment.this.hXF.setData(effectList);
            if (!x.isEmpty(effectList) && j.isWifiNet()) {
                for (n nVar : effectList) {
                    if (nVar instanceof AlaEnterEffectData) {
                        AlaEnterEffectData alaEnterEffectData = (AlaEnterEffectData) nVar;
                        if (alaEnterEffectData.type == 1 && alaEnterEffectData.downLoadStatus == 100) {
                            ResourceDownloader.checkAndDownloadResZipInMainThread(alaEnterEffectData.gift.giftId, alaEnterEffectData.gift.giftZip.zipDownloadUrl, alaEnterEffectData.gift.giftName, AlaDynamicGiftLocalInfoConfig.DIR_PATH + alaEnterEffectData.gift.giftZip.zipName, AlaDynamicGiftLocalInfoConfig.PIC_MD5_PREFIX, alaEnterEffectData.gift.giftZip.zipMD5, false);
                            AlaEnterEffectFragment.this.hXF.aT(alaEnterEffectData.gift.giftId, 102);
                        }
                    }
                }
            }
        }
    };
    private CustomMessageListener hXN = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_RES_ZIP_DOWNLOADED_STATUS) { // from class: com.baidu.tieba.ala.personcenter.privilege.entereffect.AlaEnterEffectFragment.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            DownloadData downloadData;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof WrapDownloadData)) {
                WrapDownloadData wrapDownloadData = (WrapDownloadData) customResponsedMessage.getData();
                if (wrapDownloadData.status == 4 && (downloadData = wrapDownloadData.data) != null && !StringUtils.isNull(downloadData.getId())) {
                    AlaEnterEffectFragment.this.hXF.aT(downloadData.getId(), 101);
                }
            }
        }
    };
    private ImageView hXj;
    private AlaNetRefreshView hXl;
    private View mEmptyView;
    private View mRootView;

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(this.hXN);
        registerListener(this.hXK);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        this.mRootView = LayoutInflater.from(getContext()).inflate(R.layout.ala_enter_effect_fragment_layout, (ViewGroup) null);
        initView();
        this.hXG = new a(getPageContext(), this.hXM);
        showLoadingView();
        this.hXG.cmn();
        return this.mRootView;
    }

    private void initView() {
        if (this.mRootView != null) {
            this.hXB = (HeadImageView) this.mRootView.findViewById(R.id.ala_enter_effect_header);
            this.hXB.setIsRound(true);
            this.hXE = (TbImageView) this.mRootView.findViewById(R.id.ala_enter_effect_header_container_bg);
            this.hXC = (TextView) this.mRootView.findViewById(R.id.ala_enter_effect_name);
            this.hXD = (TextView) this.mRootView.findViewById(R.id.ala_enter_effect_count);
            this.hXH = (TextView) this.mRootView.findViewById(R.id.ala_enter_effect_description_txt);
            this.dlt = this.mRootView.findViewById(R.id.ala_enter_effect_mask);
            this.hXj = (ImageView) this.mRootView.findViewById(R.id.empty_image);
            this.hXI = (TextView) this.mRootView.findViewById(R.id.empty_text);
            this.hXJ = (RelativeLayout) this.mRootView.findViewById(R.id.ala_enter_effect_list_layout);
            this.gwr = (BdTypeListView) this.mRootView.findViewById(R.id.ala_enter_effect_list_view);
            this.mEmptyView = this.mRootView.findViewById(R.id.emptyview);
            this.gwr.setEmptyView(this.mEmptyView);
            this.hXF = new com.baidu.tieba.ala.personcenter.privilege.entereffect.adapter.a(getPageContext(), this.gwr);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void HK(String str) {
        if (!StringUtils.isNull(str)) {
            this.hXB.startLoad(str, 25, false);
            d.mx().a(str, 25, new c<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.ala.personcenter.privilege.entereffect.AlaEnterEffectFragment.3
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.e.c
                public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str2, int i) {
                    super.onLoaded((AnonymousClass3) aVar, str2, i);
                    if (aVar != null && aVar.getRawBitmap() != null) {
                        AlaEnterEffectFragment.this.hXE.setScaleType(ImageView.ScaleType.CENTER_CROP);
                        AlaEnterEffectFragment.this.hXE.setImageBitmap(BitmapHelper.fastblur(aVar.getRawBitmap(), 15, 0.75f));
                    }
                }
            }, null);
            return;
        }
        this.hXB.startLoad(String.valueOf(R.drawable.icon_default_avatar100_bg), 24, false);
        this.hXE.startLoad(String.valueOf(R.drawable.icon_default_avatar100_bg), 24, false);
    }

    public void a(int i, int i2, boolean z, View.OnClickListener onClickListener) {
        if (this.hXl == null) {
            this.hXl = new AlaNetRefreshView(getContext());
        }
        this.hXl.setImageResource(i);
        this.hXl.setNetFailTipText(getContext().getString(i2));
        this.hXl.onChangeSkinType();
        this.hXl.setIsShowRefreshButton(z);
        if (z) {
            this.hXl.setOnRefreshClickListener(onClickListener);
        }
        this.hXl.attachView(this.hXJ);
    }

    public void Vq() {
        if (this.hXl != null) {
            this.hXl.dettachView(this.hXJ);
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
        if (this.gGD == null) {
            this.gGD = new g(getPageContext().getPageActivity(), getContext().getResources().getDimensionPixelSize(R.dimen.ds386));
        }
        this.gGD.attachView(this.mRootView, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideLoadingView() {
        if (this.gGD != null) {
            this.gGD.dettachView(this.mRootView);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.gGD != null) {
            this.gGD.onChangeSkinType();
        }
        if (this.hXl != null) {
            this.hXl.onChangeSkinType();
        }
        ao.setBackgroundColor(this.mRootView, R.color.CAM_X0201);
        ao.setViewTextColor(this.hXC, R.color.common_color_10310, 1, i);
        ao.setViewTextColor(this.hXD, R.color.white_alpha70, 1, i);
        ao.setViewTextColor(this.hXH, R.color.CAM_X0109, 1, i);
        ao.setViewTextColor(this.hXI, R.color.CAM_X0106, 1, i);
        if (i == 1) {
            if (this.hXj != null) {
                this.hXj.setAlpha(0.4f);
            }
            if (this.dlt != null) {
                this.dlt.setBackgroundColor(TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha60));
                return;
            }
            return;
        }
        if (this.hXj != null) {
            this.hXj.setAlpha(1.0f);
        }
        if (this.dlt != null) {
            this.dlt.setBackgroundColor(TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha30));
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 1001 && i2 == -1 && intent != null) {
            this.hXF.aF(intent.getStringExtra("key_selected_effect_id"), intent.getBooleanExtra("key_status_is_selected", false));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded() && isPrimary()) {
            TiebaStatic.log("c13335");
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        hideLoadingView();
        if (this.hXG != null) {
            this.hXG.onDestory();
        }
    }
}
