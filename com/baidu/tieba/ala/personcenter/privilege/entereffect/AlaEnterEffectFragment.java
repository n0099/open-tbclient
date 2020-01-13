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
import com.baidu.adp.widget.ListView.m;
import com.baidu.ala.AlaCmdConfigCustom;
import com.baidu.ala.downloader.ResourceDownloader;
import com.baidu.ala.downloader.WrapDownloadData;
import com.baidu.ala.gift.AlaDynamicGiftLocalInfoConfig;
import com.baidu.ala.view.AlaNetRefreshView;
import com.baidu.ala.widget.multicolumn.absView.AbsFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.k.g;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.personcenter.privilege.entereffect.a;
import com.baidu.tieba.ala.personcenter.privilege.entereffect.a.b;
import com.baidu.tieba.ala.personcenter.privilege.entereffect.data.AlaEnterEffectData;
import java.util.List;
/* loaded from: classes2.dex */
public class AlaEnterEffectFragment extends AbsFragment {
    private static final String TITLE = TbadkCoreApplication.getInst().getResources().getString(R.string.ala_enter_effect_fragment_title);
    private View cvu;
    private BdTypeListView efW;
    private g epL;
    private ImageView ftH;
    private AlaNetRefreshView ftJ;
    private HeadImageView ftY;
    private TextView ftZ;
    private TextView fua;
    private TbImageView fub;
    private com.baidu.tieba.ala.personcenter.privilege.entereffect.a.b fuc;
    private a fud;
    private TextView fue;
    private TextView fuf;
    private RelativeLayout fug;
    private CustomMessageListener fuh = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_ENTER_EFFECT_BUY_SUCCESS) { // from class: com.baidu.tieba.ala.personcenter.privilege.entereffect.AlaEnterEffectFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (AlaEnterEffectFragment.this.fuc != null && customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                AlaEnterEffectFragment.this.fuc.ab((String) customResponsedMessage.getData(), true);
            }
        }
    };
    private b.a fui = new b.a() { // from class: com.baidu.tieba.ala.personcenter.privilege.entereffect.AlaEnterEffectFragment.2
    };
    private a.InterfaceC0474a fuj = new a.InterfaceC0474a() { // from class: com.baidu.tieba.ala.personcenter.privilege.entereffect.AlaEnterEffectFragment.4
        @Override // com.baidu.tieba.ala.personcenter.privilege.entereffect.a.InterfaceC0474a
        public void a(AlaGetEnterEffectResponsedMessage alaGetEnterEffectResponsedMessage) {
            AlaEnterEffectFragment.this.hideLoadingView();
            AlaEnterEffectFragment.this.baf();
            if (alaGetEnterEffectResponsedMessage == null || alaGetEnterEffectResponsedMessage.getError() != 0) {
                AlaEnterEffectFragment.this.zo(TbadkCoreApplication.getCurrentPortrait());
                AlaEnterEffectFragment.this.fua.setText(AlaEnterEffectFragment.this.getString(R.string.ala_enter_effect_count, 0));
                AlaEnterEffectFragment.this.ftZ.setText(TbadkCoreApplication.getCurrentAccountNameShow());
                if (j.isNetWorkAvailable()) {
                    AlaEnterEffectFragment.this.a(R.drawable.pic_live_empty04, R.string.ala_net_data_error_fail_tip, false, null);
                    return;
                } else {
                    AlaEnterEffectFragment.this.a(R.drawable.pic_live_empty03, R.string.ala_net_fail_tip, true, new View.OnClickListener() { // from class: com.baidu.tieba.ala.personcenter.privilege.entereffect.AlaEnterEffectFragment.4.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            AlaEnterEffectFragment.this.baf();
                            AlaEnterEffectFragment.this.showLoadingView();
                            AlaEnterEffectFragment.this.fud.bqW();
                        }
                    });
                    return;
                }
            }
            AlaEnterEffectFragment.this.zo(alaGetEnterEffectResponsedMessage.getPortrait());
            AlaEnterEffectFragment.this.ftZ.setText(alaGetEnterEffectResponsedMessage.getUserName());
            AlaEnterEffectFragment.this.fua.setText(AlaEnterEffectFragment.this.getString(R.string.ala_enter_effect_count, Integer.valueOf(alaGetEnterEffectResponsedMessage.getEnterEffectCount())));
            List<m> effectList = alaGetEnterEffectResponsedMessage.getEffectList();
            AlaEnterEffectFragment.this.fuc.setData(effectList);
            if (!v.isEmpty(effectList) && j.isWifiNet()) {
                for (m mVar : effectList) {
                    if (mVar instanceof AlaEnterEffectData) {
                        AlaEnterEffectData alaEnterEffectData = (AlaEnterEffectData) mVar;
                        if (alaEnterEffectData.type == 1 && alaEnterEffectData.downLoadStatus == 100) {
                            ResourceDownloader.checkAndDownloadResZipInMainThread(alaEnterEffectData.gift.giftId, alaEnterEffectData.gift.giftZip.zipDownloadUrl, alaEnterEffectData.gift.giftName, AlaDynamicGiftLocalInfoConfig.DIR_PATH + alaEnterEffectData.gift.giftZip.zipName, AlaDynamicGiftLocalInfoConfig.PIC_MD5_PREFIX, alaEnterEffectData.gift.giftZip.zipMD5, false);
                            AlaEnterEffectFragment.this.fuc.ax(alaEnterEffectData.gift.giftId, 102);
                        }
                    }
                }
            }
        }
    };
    private CustomMessageListener fuk = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_RES_ZIP_DOWNLOADED_STATUS) { // from class: com.baidu.tieba.ala.personcenter.privilege.entereffect.AlaEnterEffectFragment.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            DownloadData downloadData;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof WrapDownloadData)) {
                WrapDownloadData wrapDownloadData = (WrapDownloadData) customResponsedMessage.getData();
                if (wrapDownloadData.status == 4 && (downloadData = wrapDownloadData.data) != null && !StringUtils.isNull(downloadData.getId())) {
                    AlaEnterEffectFragment.this.fuc.ax(downloadData.getId(), 101);
                }
            }
        }
    };
    private View mEmptyView;
    private View mRootView;

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(this.fuk);
        registerListener(this.fuh);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        this.mRootView = LayoutInflater.from(getContext()).inflate(R.layout.ala_enter_effect_fragment_layout, (ViewGroup) null);
        initView();
        this.fud = new a(getPageContext(), this.fuj);
        showLoadingView();
        this.fud.bqW();
        return this.mRootView;
    }

    private void initView() {
        if (this.mRootView != null) {
            this.ftY = (HeadImageView) this.mRootView.findViewById(R.id.ala_enter_effect_header);
            this.ftY.setIsRound(true);
            this.fub = (TbImageView) this.mRootView.findViewById(R.id.ala_enter_effect_header_container_bg);
            this.ftZ = (TextView) this.mRootView.findViewById(R.id.ala_enter_effect_name);
            this.fua = (TextView) this.mRootView.findViewById(R.id.ala_enter_effect_count);
            this.fue = (TextView) this.mRootView.findViewById(R.id.ala_enter_effect_description_txt);
            this.cvu = this.mRootView.findViewById(R.id.ala_enter_effect_mask);
            this.ftH = (ImageView) this.mRootView.findViewById(R.id.empty_image);
            this.fuf = (TextView) this.mRootView.findViewById(R.id.empty_text);
            this.fug = (RelativeLayout) this.mRootView.findViewById(R.id.ala_enter_effect_list_layout);
            this.efW = (BdTypeListView) this.mRootView.findViewById(R.id.ala_enter_effect_list_view);
            this.mEmptyView = this.mRootView.findViewById(R.id.emptyview);
            this.efW.setEmptyView(this.mEmptyView);
            this.fuc = new com.baidu.tieba.ala.personcenter.privilege.entereffect.a.b(getPageContext(), this.efW);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zo(String str) {
        if (!StringUtils.isNull(str)) {
            this.ftY.startLoad(str, 25, false);
            c.gr().a(str, 25, new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.ala.personcenter.privilege.entereffect.AlaEnterEffectFragment.3
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.e.b
                public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str2, int i) {
                    super.onLoaded((AnonymousClass3) aVar, str2, i);
                    if (aVar != null && aVar.getRawBitmap() != null) {
                        AlaEnterEffectFragment.this.fub.setScaleType(ImageView.ScaleType.CENTER_CROP);
                        AlaEnterEffectFragment.this.fub.setImageBitmap(BitmapHelper.fastblur(aVar.getRawBitmap(), 15, 0.75f));
                    }
                }
            }, null);
            return;
        }
        this.ftY.startLoad(String.valueOf((int) R.drawable.icon_default_avatar100_bg), 24, false);
        this.fub.startLoad(String.valueOf((int) R.drawable.icon_default_avatar100_bg), 24, false);
    }

    public void a(int i, int i2, boolean z, View.OnClickListener onClickListener) {
        if (this.ftJ == null) {
            this.ftJ = new AlaNetRefreshView(getContext());
        }
        this.ftJ.setImageResource(i);
        this.ftJ.setNetFailTipText(getContext().getString(i2));
        this.ftJ.onChangeSkinType();
        this.ftJ.setIsShowRefreshButton(z);
        if (z) {
            this.ftJ.setOnRefreshClickListener(onClickListener);
        }
        this.ftJ.attachView(this.fug);
    }

    public void baf() {
        if (this.ftJ != null) {
            this.ftJ.dettachView(this.fug);
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
        if (this.epL == null) {
            this.epL = new g(getPageContext().getPageActivity(), getContext().getResources().getDimensionPixelSize(R.dimen.ds386));
        }
        this.epL.attachView(this.mRootView, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideLoadingView() {
        if (this.epL != null) {
            this.epL.dettachView(this.mRootView);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.epL != null) {
            this.epL.onChangeSkinType();
        }
        if (this.ftJ != null) {
            this.ftJ.onChangeSkinType();
        }
        am.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
        am.setViewTextColor(this.ftZ, R.color.common_color_10310, 1, i);
        am.setViewTextColor(this.fua, R.color.white_alpha70, 1, i);
        am.setViewTextColor(this.fue, R.color.cp_cont_d, 1, i);
        am.setViewTextColor(this.fuf, R.color.cp_cont_f, 1, i);
        if (i == 1) {
            if (this.ftH != null) {
                this.ftH.setAlpha(0.4f);
            }
            if (this.cvu != null) {
                this.cvu.setBackgroundColor(TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha60));
                return;
            }
            return;
        }
        if (this.ftH != null) {
            this.ftH.setAlpha(1.0f);
        }
        if (this.cvu != null) {
            this.cvu.setBackgroundColor(TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha30));
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 1001 && i2 == -1 && intent != null) {
            this.fuc.aa(intent.getStringExtra("key_selected_effect_id"), intent.getBooleanExtra("key_status_is_selected", false));
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
        if (this.fud != null) {
            this.fud.onDestory();
        }
    }
}
