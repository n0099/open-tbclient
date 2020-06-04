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
import com.baidu.adp.widget.ListView.o;
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
/* loaded from: classes3.dex */
public class AlaEnterEffectFragment extends AbsFragment {
    private static final String TITLE = TbadkCoreApplication.getInst().getResources().getString(R.string.ala_enter_effect_fragment_title);
    private View djM;
    private BdTypeListView fbb;
    private g flb;
    private ImageView gqM;
    private AlaNetRefreshView gqO;
    private HeadImageView grd;
    private TextView gre;
    private TextView grf;
    private TbImageView grg;
    private com.baidu.tieba.ala.personcenter.privilege.entereffect.a.b grh;
    private a gri;
    private TextView grj;
    private TextView grk;
    private RelativeLayout grl;
    private CustomMessageListener grm = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_ENTER_EFFECT_BUY_SUCCESS) { // from class: com.baidu.tieba.ala.personcenter.privilege.entereffect.AlaEnterEffectFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (AlaEnterEffectFragment.this.grh != null && customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                AlaEnterEffectFragment.this.grh.au((String) customResponsedMessage.getData(), true);
            }
        }
    };
    private b.a grn = new b.a() { // from class: com.baidu.tieba.ala.personcenter.privilege.entereffect.AlaEnterEffectFragment.2
    };
    private a.InterfaceC0589a gro = new a.InterfaceC0589a() { // from class: com.baidu.tieba.ala.personcenter.privilege.entereffect.AlaEnterEffectFragment.4
        @Override // com.baidu.tieba.ala.personcenter.privilege.entereffect.a.InterfaceC0589a
        public void a(AlaGetEnterEffectResponsedMessage alaGetEnterEffectResponsedMessage) {
            AlaEnterEffectFragment.this.hideLoadingView();
            AlaEnterEffectFragment.this.bqQ();
            if (alaGetEnterEffectResponsedMessage == null || alaGetEnterEffectResponsedMessage.getError() != 0) {
                AlaEnterEffectFragment.this.CZ(TbadkCoreApplication.getCurrentPortrait());
                AlaEnterEffectFragment.this.grf.setText(AlaEnterEffectFragment.this.getString(R.string.ala_enter_effect_count, 0));
                AlaEnterEffectFragment.this.gre.setText(TbadkCoreApplication.getCurrentAccountNameShow());
                if (j.isNetWorkAvailable()) {
                    AlaEnterEffectFragment.this.a(R.drawable.pic_live_empty04, R.string.ala_net_data_error_fail_tip, false, null);
                    return;
                } else {
                    AlaEnterEffectFragment.this.a(R.drawable.pic_live_empty03, R.string.ala_net_fail_tip, true, new View.OnClickListener() { // from class: com.baidu.tieba.ala.personcenter.privilege.entereffect.AlaEnterEffectFragment.4.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            AlaEnterEffectFragment.this.bqQ();
                            AlaEnterEffectFragment.this.showLoadingView();
                            AlaEnterEffectFragment.this.gri.bIL();
                        }
                    });
                    return;
                }
            }
            AlaEnterEffectFragment.this.CZ(alaGetEnterEffectResponsedMessage.getPortrait());
            AlaEnterEffectFragment.this.gre.setText(alaGetEnterEffectResponsedMessage.getUserName());
            AlaEnterEffectFragment.this.grf.setText(AlaEnterEffectFragment.this.getString(R.string.ala_enter_effect_count, Integer.valueOf(alaGetEnterEffectResponsedMessage.getEnterEffectCount())));
            List<o> effectList = alaGetEnterEffectResponsedMessage.getEffectList();
            AlaEnterEffectFragment.this.grh.setData(effectList);
            if (!v.isEmpty(effectList) && j.isWifiNet()) {
                for (o oVar : effectList) {
                    if (oVar instanceof AlaEnterEffectData) {
                        AlaEnterEffectData alaEnterEffectData = (AlaEnterEffectData) oVar;
                        if (alaEnterEffectData.type == 1 && alaEnterEffectData.downLoadStatus == 100) {
                            ResourceDownloader.checkAndDownloadResZipInMainThread(alaEnterEffectData.gift.giftId, alaEnterEffectData.gift.giftZip.zipDownloadUrl, alaEnterEffectData.gift.giftName, AlaDynamicGiftLocalInfoConfig.DIR_PATH + alaEnterEffectData.gift.giftZip.zipName, AlaDynamicGiftLocalInfoConfig.PIC_MD5_PREFIX, alaEnterEffectData.gift.giftZip.zipMD5, false);
                            AlaEnterEffectFragment.this.grh.aG(alaEnterEffectData.gift.giftId, 102);
                        }
                    }
                }
            }
        }
    };
    private CustomMessageListener grp = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_RES_ZIP_DOWNLOADED_STATUS) { // from class: com.baidu.tieba.ala.personcenter.privilege.entereffect.AlaEnterEffectFragment.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            DownloadData downloadData;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof WrapDownloadData)) {
                WrapDownloadData wrapDownloadData = (WrapDownloadData) customResponsedMessage.getData();
                if (wrapDownloadData.status == 4 && (downloadData = wrapDownloadData.data) != null && !StringUtils.isNull(downloadData.getId())) {
                    AlaEnterEffectFragment.this.grh.aG(downloadData.getId(), 101);
                }
            }
        }
    };
    private View mEmptyView;
    private View mRootView;

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(this.grp);
        registerListener(this.grm);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        this.mRootView = LayoutInflater.from(getContext()).inflate(R.layout.ala_enter_effect_fragment_layout, (ViewGroup) null);
        initView();
        this.gri = new a(getPageContext(), this.gro);
        showLoadingView();
        this.gri.bIL();
        return this.mRootView;
    }

    private void initView() {
        if (this.mRootView != null) {
            this.grd = (HeadImageView) this.mRootView.findViewById(R.id.ala_enter_effect_header);
            this.grd.setIsRound(true);
            this.grg = (TbImageView) this.mRootView.findViewById(R.id.ala_enter_effect_header_container_bg);
            this.gre = (TextView) this.mRootView.findViewById(R.id.ala_enter_effect_name);
            this.grf = (TextView) this.mRootView.findViewById(R.id.ala_enter_effect_count);
            this.grj = (TextView) this.mRootView.findViewById(R.id.ala_enter_effect_description_txt);
            this.djM = this.mRootView.findViewById(R.id.ala_enter_effect_mask);
            this.gqM = (ImageView) this.mRootView.findViewById(R.id.empty_image);
            this.grk = (TextView) this.mRootView.findViewById(R.id.empty_text);
            this.grl = (RelativeLayout) this.mRootView.findViewById(R.id.ala_enter_effect_list_layout);
            this.fbb = (BdTypeListView) this.mRootView.findViewById(R.id.ala_enter_effect_list_view);
            this.mEmptyView = this.mRootView.findViewById(R.id.emptyview);
            this.fbb.setEmptyView(this.mEmptyView);
            this.grh = new com.baidu.tieba.ala.personcenter.privilege.entereffect.a.b(getPageContext(), this.fbb);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void CZ(String str) {
        if (!StringUtils.isNull(str)) {
            this.grd.startLoad(str, 25, false);
            c.kX().a(str, 25, new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.ala.personcenter.privilege.entereffect.AlaEnterEffectFragment.3
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.e.b
                public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str2, int i) {
                    super.onLoaded((AnonymousClass3) aVar, str2, i);
                    if (aVar != null && aVar.getRawBitmap() != null) {
                        AlaEnterEffectFragment.this.grg.setScaleType(ImageView.ScaleType.CENTER_CROP);
                        AlaEnterEffectFragment.this.grg.setImageBitmap(BitmapHelper.fastblur(aVar.getRawBitmap(), 15, 0.75f));
                    }
                }
            }, null);
            return;
        }
        this.grd.startLoad(String.valueOf((int) R.drawable.icon_default_avatar100_bg), 24, false);
        this.grg.startLoad(String.valueOf((int) R.drawable.icon_default_avatar100_bg), 24, false);
    }

    public void a(int i, int i2, boolean z, View.OnClickListener onClickListener) {
        if (this.gqO == null) {
            this.gqO = new AlaNetRefreshView(getContext());
        }
        this.gqO.setImageResource(i);
        this.gqO.setNetFailTipText(getContext().getString(i2));
        this.gqO.onChangeSkinType();
        this.gqO.setIsShowRefreshButton(z);
        if (z) {
            this.gqO.setOnRefreshClickListener(onClickListener);
        }
        this.gqO.attachView(this.grl);
    }

    public void bqQ() {
        if (this.gqO != null) {
            this.gqO.dettachView(this.grl);
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
        if (this.flb == null) {
            this.flb = new g(getPageContext().getPageActivity(), getContext().getResources().getDimensionPixelSize(R.dimen.ds386));
        }
        this.flb.attachView(this.mRootView, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideLoadingView() {
        if (this.flb != null) {
            this.flb.dettachView(this.mRootView);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.flb != null) {
            this.flb.onChangeSkinType();
        }
        if (this.gqO != null) {
            this.gqO.onChangeSkinType();
        }
        am.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
        am.setViewTextColor(this.gre, R.color.common_color_10310, 1, i);
        am.setViewTextColor(this.grf, R.color.white_alpha70, 1, i);
        am.setViewTextColor(this.grj, R.color.cp_cont_d, 1, i);
        am.setViewTextColor(this.grk, R.color.cp_cont_f, 1, i);
        if (i == 1) {
            if (this.gqM != null) {
                this.gqM.setAlpha(0.4f);
            }
            if (this.djM != null) {
                this.djM.setBackgroundColor(TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha60));
                return;
            }
            return;
        }
        if (this.gqM != null) {
            this.gqM.setAlpha(1.0f);
        }
        if (this.djM != null) {
            this.djM.setBackgroundColor(TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha30));
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 1001 && i2 == -1 && intent != null) {
            this.grh.at(intent.getStringExtra("key_selected_effect_id"), intent.getBooleanExtra("key_status_is_selected", false));
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
        if (this.gri != null) {
            this.gri.onDestory();
        }
    }
}
