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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.x;
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
    private View duo;
    private g fBv;
    private BdTypeListView frv;
    private ImageView gIY;
    private AlaNetRefreshView gJa;
    private HeadImageView gJp;
    private TextView gJq;
    private TextView gJr;
    private TbImageView gJs;
    private com.baidu.tieba.ala.personcenter.privilege.entereffect.a.b gJt;
    private a gJu;
    private TextView gJv;
    private TextView gJw;
    private RelativeLayout gJx;
    private View mEmptyView;
    private View mRootView;
    private CustomMessageListener gJy = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_ENTER_EFFECT_BUY_SUCCESS) { // from class: com.baidu.tieba.ala.personcenter.privilege.entereffect.AlaEnterEffectFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (AlaEnterEffectFragment.this.gJt != null && customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                AlaEnterEffectFragment.this.gJt.au((String) customResponsedMessage.getData(), true);
            }
        }
    };
    private b.a gJz = new b.a() { // from class: com.baidu.tieba.ala.personcenter.privilege.entereffect.AlaEnterEffectFragment.2
    };
    private a.InterfaceC0607a gJA = new a.InterfaceC0607a() { // from class: com.baidu.tieba.ala.personcenter.privilege.entereffect.AlaEnterEffectFragment.4
        @Override // com.baidu.tieba.ala.personcenter.privilege.entereffect.a.InterfaceC0607a
        public void a(AlaGetEnterEffectResponsedMessage alaGetEnterEffectResponsedMessage) {
            AlaEnterEffectFragment.this.hideLoadingView();
            AlaEnterEffectFragment.this.bwX();
            if (alaGetEnterEffectResponsedMessage == null || alaGetEnterEffectResponsedMessage.getError() != 0) {
                AlaEnterEffectFragment.this.El(TbadkCoreApplication.getCurrentPortrait());
                AlaEnterEffectFragment.this.gJr.setText(AlaEnterEffectFragment.this.getString(R.string.ala_enter_effect_count, 0));
                AlaEnterEffectFragment.this.gJq.setText(TbadkCoreApplication.getCurrentAccountNameShow());
                if (j.isNetWorkAvailable()) {
                    AlaEnterEffectFragment.this.a(R.drawable.pic_live_empty04, R.string.ala_net_data_error_fail_tip, false, null);
                    return;
                } else {
                    AlaEnterEffectFragment.this.a(R.drawable.pic_live_empty03, R.string.ala_net_fail_tip, true, new View.OnClickListener() { // from class: com.baidu.tieba.ala.personcenter.privilege.entereffect.AlaEnterEffectFragment.4.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            AlaEnterEffectFragment.this.bwX();
                            AlaEnterEffectFragment.this.showLoadingView();
                            AlaEnterEffectFragment.this.gJu.bOZ();
                        }
                    });
                    return;
                }
            }
            AlaEnterEffectFragment.this.El(alaGetEnterEffectResponsedMessage.getPortrait());
            AlaEnterEffectFragment.this.gJq.setText(alaGetEnterEffectResponsedMessage.getUserName());
            AlaEnterEffectFragment.this.gJr.setText(AlaEnterEffectFragment.this.getString(R.string.ala_enter_effect_count, Integer.valueOf(alaGetEnterEffectResponsedMessage.getEnterEffectCount())));
            List<q> effectList = alaGetEnterEffectResponsedMessage.getEffectList();
            AlaEnterEffectFragment.this.gJt.setData(effectList);
            if (!x.isEmpty(effectList) && j.isWifiNet()) {
                for (q qVar : effectList) {
                    if (qVar instanceof AlaEnterEffectData) {
                        AlaEnterEffectData alaEnterEffectData = (AlaEnterEffectData) qVar;
                        if (alaEnterEffectData.type == 1 && alaEnterEffectData.downLoadStatus == 100) {
                            ResourceDownloader.checkAndDownloadResZipInMainThread(alaEnterEffectData.gift.giftId, alaEnterEffectData.gift.giftZip.zipDownloadUrl, alaEnterEffectData.gift.giftName, AlaDynamicGiftLocalInfoConfig.DIR_PATH + alaEnterEffectData.gift.giftZip.zipName, AlaDynamicGiftLocalInfoConfig.PIC_MD5_PREFIX, alaEnterEffectData.gift.giftZip.zipMD5, false);
                            AlaEnterEffectFragment.this.gJt.aE(alaEnterEffectData.gift.giftId, 102);
                        }
                    }
                }
            }
        }
    };
    private CustomMessageListener gJB = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_RES_ZIP_DOWNLOADED_STATUS) { // from class: com.baidu.tieba.ala.personcenter.privilege.entereffect.AlaEnterEffectFragment.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            DownloadData downloadData;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof WrapDownloadData)) {
                WrapDownloadData wrapDownloadData = (WrapDownloadData) customResponsedMessage.getData();
                if (wrapDownloadData.status == 4 && (downloadData = wrapDownloadData.data) != null && !StringUtils.isNull(downloadData.getId())) {
                    AlaEnterEffectFragment.this.gJt.aE(downloadData.getId(), 101);
                }
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(this.gJB);
        registerListener(this.gJy);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        this.mRootView = LayoutInflater.from(getContext()).inflate(R.layout.ala_enter_effect_fragment_layout, (ViewGroup) null);
        initView();
        this.gJu = new a(getPageContext(), this.gJA);
        showLoadingView();
        this.gJu.bOZ();
        return this.mRootView;
    }

    private void initView() {
        if (this.mRootView != null) {
            this.gJp = (HeadImageView) this.mRootView.findViewById(R.id.ala_enter_effect_header);
            this.gJp.setIsRound(true);
            this.gJs = (TbImageView) this.mRootView.findViewById(R.id.ala_enter_effect_header_container_bg);
            this.gJq = (TextView) this.mRootView.findViewById(R.id.ala_enter_effect_name);
            this.gJr = (TextView) this.mRootView.findViewById(R.id.ala_enter_effect_count);
            this.gJv = (TextView) this.mRootView.findViewById(R.id.ala_enter_effect_description_txt);
            this.duo = this.mRootView.findViewById(R.id.ala_enter_effect_mask);
            this.gIY = (ImageView) this.mRootView.findViewById(R.id.empty_image);
            this.gJw = (TextView) this.mRootView.findViewById(R.id.empty_text);
            this.gJx = (RelativeLayout) this.mRootView.findViewById(R.id.ala_enter_effect_list_layout);
            this.frv = (BdTypeListView) this.mRootView.findViewById(R.id.ala_enter_effect_list_view);
            this.mEmptyView = this.mRootView.findViewById(R.id.emptyview);
            this.frv.setEmptyView(this.mEmptyView);
            this.gJt = new com.baidu.tieba.ala.personcenter.privilege.entereffect.a.b(getPageContext(), this.frv);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void El(String str) {
        if (!StringUtils.isNull(str)) {
            this.gJp.startLoad(str, 25, false);
            c.ln().a(str, 25, new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.ala.personcenter.privilege.entereffect.AlaEnterEffectFragment.3
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.e.b
                public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str2, int i) {
                    super.onLoaded((AnonymousClass3) aVar, str2, i);
                    if (aVar != null && aVar.getRawBitmap() != null) {
                        AlaEnterEffectFragment.this.gJs.setScaleType(ImageView.ScaleType.CENTER_CROP);
                        AlaEnterEffectFragment.this.gJs.setImageBitmap(BitmapHelper.fastblur(aVar.getRawBitmap(), 15, 0.75f));
                    }
                }
            }, null);
            return;
        }
        this.gJp.startLoad(String.valueOf(R.drawable.icon_default_avatar100_bg), 24, false);
        this.gJs.startLoad(String.valueOf(R.drawable.icon_default_avatar100_bg), 24, false);
    }

    public void a(int i, int i2, boolean z, View.OnClickListener onClickListener) {
        if (this.gJa == null) {
            this.gJa = new AlaNetRefreshView(getContext());
        }
        this.gJa.setImageResource(i);
        this.gJa.setNetFailTipText(getContext().getString(i2));
        this.gJa.onChangeSkinType();
        this.gJa.setIsShowRefreshButton(z);
        if (z) {
            this.gJa.setOnRefreshClickListener(onClickListener);
        }
        this.gJa.attachView(this.gJx);
    }

    public void bwX() {
        if (this.gJa != null) {
            this.gJa.dettachView(this.gJx);
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
        if (this.fBv == null) {
            this.fBv = new g(getPageContext().getPageActivity(), getContext().getResources().getDimensionPixelSize(R.dimen.ds386));
        }
        this.fBv.attachView(this.mRootView, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideLoadingView() {
        if (this.fBv != null) {
            this.fBv.dettachView(this.mRootView);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.fBv != null) {
            this.fBv.onChangeSkinType();
        }
        if (this.gJa != null) {
            this.gJa.onChangeSkinType();
        }
        ao.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
        ao.setViewTextColor(this.gJq, R.color.common_color_10310, 1, i);
        ao.setViewTextColor(this.gJr, R.color.white_alpha70, 1, i);
        ao.setViewTextColor(this.gJv, R.color.cp_cont_d, 1, i);
        ao.setViewTextColor(this.gJw, R.color.cp_cont_f, 1, i);
        if (i == 1) {
            if (this.gIY != null) {
                this.gIY.setAlpha(0.4f);
            }
            if (this.duo != null) {
                this.duo.setBackgroundColor(TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha60));
                return;
            }
            return;
        }
        if (this.gIY != null) {
            this.gIY.setAlpha(1.0f);
        }
        if (this.duo != null) {
            this.duo.setBackgroundColor(TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha30));
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 1001 && i2 == -1 && intent != null) {
            this.gJt.at(intent.getStringExtra("key_selected_effect_id"), intent.getBooleanExtra("key_status_is_selected", false));
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
        if (this.gJu != null) {
            this.gJu.onDestory();
        }
    }
}
