package com.baidu.tieba.ala.personcenter.privilege.achievementmark.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.e.d;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.ala.data.AlaLiveMarkData;
import com.baidu.ala.data.AlaUserInfoData;
import com.baidu.ala.view.AlaNetRefreshView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.c;
import com.baidu.tieba.ala.personcenter.privilege.achievementmark.b;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes10.dex */
public class a {
    private View dnE;
    private TbPageContext<BaseFragmentActivity> eUY;
    private HeadImageView gDn;
    private TextView hkW;
    private TextView ibA;
    private TbImageView ibB;
    private RelativeLayout ibC;
    private ImageView ibD;
    private LinearLayout ibE;
    private AlaNetRefreshView ibF;
    private RelativeLayout ibG;
    private TextView ibH;
    private InterfaceC0688a ibI;
    private List<AlaLiveMarkData> ibJ = new ArrayList();
    private b.a ibK = new b.a() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.view.a.2
        @Override // com.baidu.tieba.ala.personcenter.privilege.achievementmark.b.a
        public void a(com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.b bVar) {
            if (a.this.ibI != null) {
                a.this.ibI.a(bVar);
            }
        }
    };
    private BdListView iby;
    private b ibz;
    private TextView mName;
    private View mRootView;

    /* renamed from: com.baidu.tieba.ala.personcenter.privilege.achievementmark.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public interface InterfaceC0688a {
        void a(com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.b bVar);
    }

    public a(TbPageContext<BaseFragmentActivity> tbPageContext, InterfaceC0688a interfaceC0688a) {
        this.eUY = tbPageContext;
        this.ibI = interfaceC0688a;
        initView();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.eUY.getPageActivity()).inflate(R.layout.ala_achievement_mark_fragment_layout, (ViewGroup) null);
        this.mRootView.setPadding(0, (int) this.eUY.getResources().getDimension(R.dimen.ds80), 0, 0);
        this.gDn = (HeadImageView) this.mRootView.findViewById(R.id.ala_person_center_privilege_header_iv);
        this.mName = (TextView) this.mRootView.findViewById(R.id.ala_person_center_privilege_header_name_tv);
        this.ibA = (TextView) this.mRootView.findViewById(R.id.ala_person_center_privilege_header_desc_tv);
        this.ibB = (TbImageView) this.mRootView.findViewById(R.id.ala_person_center_privilege_header_container_bg);
        this.ibG = (RelativeLayout) this.mRootView.findViewById(R.id.ala_person_center_privilege_mark_list_container);
        this.ibE = (LinearLayout) this.mRootView.findViewById(R.id.ala_person_center_privilege_header_has_wears);
        this.ibH = (TextView) this.mRootView.findViewById(R.id.ala_person_center_privilege_jump_rule_text);
        this.ibD = (ImageView) this.mRootView.findViewById(R.id.empty_image);
        this.hkW = (TextView) this.mRootView.findViewById(R.id.empty_text);
        this.dnE = this.mRootView.findViewById(R.id.ala_person_center_privilege_mask);
        this.iby = (BdListView) this.mRootView.findViewById(R.id.ala_person_center_privilege_mark_list);
        this.ibz = new b(this.eUY, this.ibK);
        this.iby.setAdapter((ListAdapter) this.ibz);
        this.ibC = (RelativeLayout) this.mRootView.findViewById(R.id.emptyview);
        this.iby.setEmptyView(this.ibC);
        this.gDn.setIsRound(true);
        this.gDn.setDefaultBgResource(R.color.transparent);
        this.gDn.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.ibB.setDefaultBgResource(R.color.transparent);
        this.ibB.setScaleType(ImageView.ScaleType.CENTER_CROP);
        onChangeSkinType();
    }

    private void onChangeSkinType() {
        ap.setBackgroundColor(this.mRootView, R.color.CAM_X0201);
        ap.setViewTextColor(this.mName, R.color.common_color_10310);
        ap.setViewTextColor(this.ibA, R.color.white_alpha70);
        ap.setViewTextColor(this.ibH, R.color.CAM_X0109);
        ap.setViewTextColor(this.hkW, R.color.CAM_X0106);
        if (TbadkApplication.getInst().getSkinType() == 1) {
            this.ibD.setAlpha(0.4f);
            this.dnE.setBackgroundColor(this.eUY.getResources().getColor(R.color.black_alpha60));
            return;
        }
        this.ibD.setAlpha(1.0f);
        this.dnE.setBackgroundColor(this.eUY.getResources().getColor(R.color.black_alpha30));
    }

    public void a(AlaUserInfoData alaUserInfoData, List<c> list) {
        if (this.ibz != null && list != null) {
            this.ibz.setData(list);
        }
        a(alaUserInfoData);
    }

    private void a(AlaUserInfoData alaUserInfoData) {
        String format;
        if (alaUserInfoData != null) {
            String str = alaUserInfoData.user_nickname;
            String str2 = alaUserInfoData.user_name;
            if (str == null) {
                str = str2 != null ? str2 : TbadkApplication.getCurrentAccountNameShow();
            }
            String currentPortrait = alaUserInfoData.portrait == null ? TbadkApplication.getCurrentPortrait() : alaUserInfoData.portrait;
            if (alaUserInfoData.mark_count == null) {
                format = String.format(this.eUY.getString(R.string.ala_achievement_mark_get_text), 0);
            } else {
                format = String.format(this.eUY.getString(R.string.ala_achievement_mark_get_text), Long.valueOf(alaUserInfoData.mark_count.user_mark_count));
            }
            aB(currentPortrait, str, format);
            int dimension = (int) this.eUY.getResources().getDimension(R.dimen.ds32);
            if (this.ibJ != null && this.ibJ.size() > 0) {
                this.ibJ.clear();
            }
            if (this.ibE != null) {
                this.ibE.removeAllViews();
                this.ibJ = alaUserInfoData.live_mark_info_new;
                if (this.ibJ != null) {
                    for (int i = 0; i < this.ibJ.size(); i++) {
                        TbImageView tbImageView = new TbImageView(this.eUY.getPageActivity());
                        tbImageView.setDefaultBgResource(R.color.transparent);
                        tbImageView.startLoad(this.ibJ.get(i).mark_pic, 21, false);
                        tbImageView.setLayoutParams(new LinearLayout.LayoutParams(dimension, dimension));
                        tbImageView.setScaleType(ImageView.ScaleType.FIT_XY);
                        ((LinearLayout.LayoutParams) tbImageView.getLayoutParams()).rightMargin = (int) this.eUY.getResources().getDimension(R.dimen.ds12);
                        this.ibE.addView(tbImageView);
                    }
                    return;
                }
                return;
            }
            return;
        }
        aB(TbadkApplication.getCurrentPortrait(), TbadkApplication.getCurrentAccountNameShow(), String.format(this.eUY.getString(R.string.ala_achievement_mark_get_text), 0));
        if (this.ibJ != null && this.ibJ.size() > 0) {
            this.ibJ.clear();
        }
        if (this.ibE != null) {
            this.ibE.removeAllViews();
        }
    }

    private void aB(String str, String str2, String str3) {
        if (!StringUtils.isNull(str)) {
            this.gDn.startLoad(str, 25, false);
            d.mw().a(str, 25, new com.baidu.adp.lib.e.c<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.view.a.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.e.c
                public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str4, int i) {
                    super.onLoaded((AnonymousClass1) aVar, str4, i);
                    if (aVar != null && aVar.getRawBitmap() != null) {
                        a.this.ibB.setScaleType(ImageView.ScaleType.CENTER_CROP);
                        a.this.ibB.setImageBitmap(BitmapHelper.fastblur(aVar.getRawBitmap(), 15, 0.75f));
                    }
                }
            }, null);
        } else {
            this.gDn.startLoad(String.valueOf(R.drawable.icon_default_avatar100_bg), 24, false);
            this.ibB.startLoad(String.valueOf(R.drawable.icon_default_avatar100_bg), 24, false);
        }
        if (!StringUtils.isNull(str2)) {
            this.mName.setText(str2);
        } else {
            this.mName.setText("");
        }
        if (!StringUtils.isNull(str3)) {
            this.ibA.setText(str3);
        } else {
            this.ibA.setText("");
        }
    }

    public View getView() {
        return this.mRootView;
    }

    public void a(int i, int i2, boolean z, View.OnClickListener onClickListener) {
        if (this.eUY != null) {
            if (this.ibF == null) {
                this.ibF = new AlaNetRefreshView(this.eUY.getPageActivity());
            }
            this.ibF.setImageResource(i);
            this.ibF.setNetFailTipText(this.eUY.getString(i2));
            this.ibF.onChangeSkinType();
            this.ibF.setIsShowRefreshButton(z);
            if (z) {
                this.ibF.setOnRefreshClickListener(onClickListener);
            }
            this.ibF.attachView(this.ibG);
        }
    }

    public void WZ() {
        if (this.ibF != null) {
            this.ibF.dettachView(this.ibG);
        }
    }
}
