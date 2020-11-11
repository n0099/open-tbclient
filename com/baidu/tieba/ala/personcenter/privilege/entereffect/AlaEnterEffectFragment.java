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
import com.baidu.tbadk.k.g;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.personcenter.privilege.entereffect.a;
import com.baidu.tieba.ala.personcenter.privilege.entereffect.a.b;
import com.baidu.tieba.ala.personcenter.privilege.entereffect.data.AlaEnterEffectData;
import java.util.List;
/* loaded from: classes4.dex */
public class AlaEnterEffectFragment extends AbsFragment {
    private static final String TITLE = TbadkCoreApplication.getInst().getResources().getString(R.string.ala_enter_effect_fragment_title);
    private View dfT;
    private BdTypeListView gih;
    private g gso;
    private com.baidu.tieba.ala.personcenter.privilege.entereffect.a.b hGA;
    private a hGB;
    private TextView hGC;
    private TextView hGD;
    private RelativeLayout hGE;
    private CustomMessageListener hGF = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_ENTER_EFFECT_BUY_SUCCESS) { // from class: com.baidu.tieba.ala.personcenter.privilege.entereffect.AlaEnterEffectFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (AlaEnterEffectFragment.this.hGA != null && customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                AlaEnterEffectFragment.this.hGA.aE((String) customResponsedMessage.getData(), true);
            }
        }
    };
    private b.a hGG = new b.a() { // from class: com.baidu.tieba.ala.personcenter.privilege.entereffect.AlaEnterEffectFragment.2
    };
    private a.InterfaceC0702a hGH = new a.InterfaceC0702a() { // from class: com.baidu.tieba.ala.personcenter.privilege.entereffect.AlaEnterEffectFragment.4
        @Override // com.baidu.tieba.ala.personcenter.privilege.entereffect.a.InterfaceC0702a
        public void a(AlaGetEnterEffectResponsedMessage alaGetEnterEffectResponsedMessage) {
            AlaEnterEffectFragment.this.hideLoadingView();
            AlaEnterEffectFragment.this.Wk();
            if (alaGetEnterEffectResponsedMessage == null || alaGetEnterEffectResponsedMessage.getError() != 0) {
                AlaEnterEffectFragment.this.II(TbadkCoreApplication.getCurrentPortrait());
                AlaEnterEffectFragment.this.hGy.setText(AlaEnterEffectFragment.this.getString(R.string.ala_enter_effect_count, 0));
                AlaEnterEffectFragment.this.hGx.setText(TbadkCoreApplication.getCurrentAccountNameShow());
                if (j.isNetWorkAvailable()) {
                    AlaEnterEffectFragment.this.a(R.drawable.pic_live_empty04, R.string.ala_net_data_error_fail_tip, false, null);
                    return;
                } else {
                    AlaEnterEffectFragment.this.a(R.drawable.pic_live_empty03, R.string.ala_net_fail_tip, true, new View.OnClickListener() { // from class: com.baidu.tieba.ala.personcenter.privilege.entereffect.AlaEnterEffectFragment.4.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            AlaEnterEffectFragment.this.Wk();
                            AlaEnterEffectFragment.this.showLoadingView();
                            AlaEnterEffectFragment.this.hGB.cjY();
                        }
                    });
                    return;
                }
            }
            AlaEnterEffectFragment.this.II(alaGetEnterEffectResponsedMessage.getPortrait());
            AlaEnterEffectFragment.this.hGx.setText(alaGetEnterEffectResponsedMessage.getUserName());
            AlaEnterEffectFragment.this.hGy.setText(AlaEnterEffectFragment.this.getString(R.string.ala_enter_effect_count, Integer.valueOf(alaGetEnterEffectResponsedMessage.getEnterEffectCount())));
            List<q> effectList = alaGetEnterEffectResponsedMessage.getEffectList();
            AlaEnterEffectFragment.this.hGA.setData(effectList);
            if (!y.isEmpty(effectList) && j.isWifiNet()) {
                for (q qVar : effectList) {
                    if (qVar instanceof AlaEnterEffectData) {
                        AlaEnterEffectData alaEnterEffectData = (AlaEnterEffectData) qVar;
                        if (alaEnterEffectData.type == 1 && alaEnterEffectData.downLoadStatus == 100) {
                            ResourceDownloader.checkAndDownloadResZipInMainThread(alaEnterEffectData.gift.giftId, alaEnterEffectData.gift.giftZip.zipDownloadUrl, alaEnterEffectData.gift.giftName, AlaDynamicGiftLocalInfoConfig.DIR_PATH + alaEnterEffectData.gift.giftZip.zipName, AlaDynamicGiftLocalInfoConfig.PIC_MD5_PREFIX, alaEnterEffectData.gift.giftZip.zipMD5, false);
                            AlaEnterEffectFragment.this.hGA.aL(alaEnterEffectData.gift.giftId, 102);
                        }
                    }
                }
            }
        }
    };
    private CustomMessageListener hGI = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_RES_ZIP_DOWNLOADED_STATUS) { // from class: com.baidu.tieba.ala.personcenter.privilege.entereffect.AlaEnterEffectFragment.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            DownloadData downloadData;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof WrapDownloadData)) {
                WrapDownloadData wrapDownloadData = (WrapDownloadData) customResponsedMessage.getData();
                if (wrapDownloadData.status == 4 && (downloadData = wrapDownloadData.data) != null && !StringUtils.isNull(downloadData.getId())) {
                    AlaEnterEffectFragment.this.hGA.aL(downloadData.getId(), 101);
                }
            }
        }
    };
    private ImageView hGf;
    private AlaNetRefreshView hGh;
    private HeadImageView hGw;
    private TextView hGx;
    private TextView hGy;
    private TbImageView hGz;
    private View mEmptyView;
    private View mRootView;

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(this.hGI);
        registerListener(this.hGF);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        this.mRootView = LayoutInflater.from(getContext()).inflate(R.layout.ala_enter_effect_fragment_layout, (ViewGroup) null);
        initView();
        this.hGB = new a(getPageContext(), this.hGH);
        showLoadingView();
        this.hGB.cjY();
        return this.mRootView;
    }

    private void initView() {
        if (this.mRootView != null) {
            this.hGw = (HeadImageView) this.mRootView.findViewById(R.id.ala_enter_effect_header);
            this.hGw.setIsRound(true);
            this.hGz = (TbImageView) this.mRootView.findViewById(R.id.ala_enter_effect_header_container_bg);
            this.hGx = (TextView) this.mRootView.findViewById(R.id.ala_enter_effect_name);
            this.hGy = (TextView) this.mRootView.findViewById(R.id.ala_enter_effect_count);
            this.hGC = (TextView) this.mRootView.findViewById(R.id.ala_enter_effect_description_txt);
            this.dfT = this.mRootView.findViewById(R.id.ala_enter_effect_mask);
            this.hGf = (ImageView) this.mRootView.findViewById(R.id.empty_image);
            this.hGD = (TextView) this.mRootView.findViewById(R.id.empty_text);
            this.hGE = (RelativeLayout) this.mRootView.findViewById(R.id.ala_enter_effect_list_layout);
            this.gih = (BdTypeListView) this.mRootView.findViewById(R.id.ala_enter_effect_list_view);
            this.mEmptyView = this.mRootView.findViewById(R.id.emptyview);
            this.gih.setEmptyView(this.mEmptyView);
            this.hGA = new com.baidu.tieba.ala.personcenter.privilege.entereffect.a.b(getPageContext(), this.gih);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void II(String str) {
        if (!StringUtils.isNull(str)) {
            this.hGw.startLoad(str, 25, false);
            c.mS().a(str, 25, new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.ala.personcenter.privilege.entereffect.AlaEnterEffectFragment.3
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.e.b
                public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str2, int i) {
                    super.onLoaded((AnonymousClass3) aVar, str2, i);
                    if (aVar != null && aVar.getRawBitmap() != null) {
                        AlaEnterEffectFragment.this.hGz.setScaleType(ImageView.ScaleType.CENTER_CROP);
                        AlaEnterEffectFragment.this.hGz.setImageBitmap(BitmapHelper.fastblur(aVar.getRawBitmap(), 15, 0.75f));
                    }
                }
            }, null);
            return;
        }
        this.hGw.startLoad(String.valueOf((int) R.drawable.icon_default_avatar100_bg), 24, false);
        this.hGz.startLoad(String.valueOf((int) R.drawable.icon_default_avatar100_bg), 24, false);
    }

    public void a(int i, int i2, boolean z, View.OnClickListener onClickListener) {
        if (this.hGh == null) {
            this.hGh = new AlaNetRefreshView(getContext());
        }
        this.hGh.setImageResource(i);
        this.hGh.setNetFailTipText(getContext().getString(i2));
        this.hGh.onChangeSkinType();
        this.hGh.setIsShowRefreshButton(z);
        if (z) {
            this.hGh.setOnRefreshClickListener(onClickListener);
        }
        this.hGh.attachView(this.hGE);
    }

    public void Wk() {
        if (this.hGh != null) {
            this.hGh.dettachView(this.hGE);
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
        if (this.gso == null) {
            this.gso = new g(getPageContext().getPageActivity(), getContext().getResources().getDimensionPixelSize(R.dimen.ds386));
        }
        this.gso.attachView(this.mRootView, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideLoadingView() {
        if (this.gso != null) {
            this.gso.dettachView(this.mRootView);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.gso != null) {
            this.gso.onChangeSkinType();
        }
        if (this.hGh != null) {
            this.hGh.onChangeSkinType();
        }
        ap.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
        ap.setViewTextColor(this.hGx, R.color.common_color_10310, 1, i);
        ap.setViewTextColor(this.hGy, R.color.white_alpha70, 1, i);
        ap.setViewTextColor(this.hGC, R.color.cp_cont_d, 1, i);
        ap.setViewTextColor(this.hGD, R.color.cp_cont_f, 1, i);
        if (i == 1) {
            if (this.hGf != null) {
                this.hGf.setAlpha(0.4f);
            }
            if (this.dfT != null) {
                this.dfT.setBackgroundColor(TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha60));
                return;
            }
            return;
        }
        if (this.hGf != null) {
            this.hGf.setAlpha(1.0f);
        }
        if (this.dfT != null) {
            this.dfT.setBackgroundColor(TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha30));
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 1001 && i2 == -1 && intent != null) {
            this.hGA.aD(intent.getStringExtra("key_selected_effect_id"), intent.getBooleanExtra("key_status_is_selected", false));
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
        if (this.hGB != null) {
            this.hGB.onDestory();
        }
    }
}
