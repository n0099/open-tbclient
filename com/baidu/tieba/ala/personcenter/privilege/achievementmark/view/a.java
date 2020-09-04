package com.baidu.tieba.ala.personcenter.privilege.achievementmark.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
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
/* loaded from: classes4.dex */
public class a {
    private View cDw;
    private TbPageContext<BaseFragmentActivity> efr;
    private HeadImageView fGX;
    private BdListView gVA;
    private b gVB;
    private TextView gVC;
    private TbImageView gVD;
    private RelativeLayout gVE;
    private ImageView gVF;
    private LinearLayout gVG;
    private AlaNetRefreshView gVH;
    private RelativeLayout gVI;
    private TextView gVJ;
    private InterfaceC0655a gVK;
    private List<AlaLiveMarkData> gVL = new ArrayList();
    private b.a gVM = new b.a() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.view.a.2
        @Override // com.baidu.tieba.ala.personcenter.privilege.achievementmark.b.a
        public void a(com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.b bVar) {
            if (a.this.gVK != null) {
                a.this.gVK.a(bVar);
            }
        }
    };
    private TextView ghA;
    private TextView mName;
    private View mRootView;

    /* renamed from: com.baidu.tieba.ala.personcenter.privilege.achievementmark.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0655a {
        void a(com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.b bVar);
    }

    public a(TbPageContext<BaseFragmentActivity> tbPageContext, InterfaceC0655a interfaceC0655a) {
        this.efr = tbPageContext;
        this.gVK = interfaceC0655a;
        initView();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.efr.getPageActivity()).inflate(R.layout.ala_achievement_mark_fragment_layout, (ViewGroup) null);
        this.mRootView.setPadding(0, (int) this.efr.getResources().getDimension(R.dimen.ds80), 0, 0);
        this.fGX = (HeadImageView) this.mRootView.findViewById(R.id.ala_person_center_privilege_header_iv);
        this.mName = (TextView) this.mRootView.findViewById(R.id.ala_person_center_privilege_header_name_tv);
        this.gVC = (TextView) this.mRootView.findViewById(R.id.ala_person_center_privilege_header_desc_tv);
        this.gVD = (TbImageView) this.mRootView.findViewById(R.id.ala_person_center_privilege_header_container_bg);
        this.gVI = (RelativeLayout) this.mRootView.findViewById(R.id.ala_person_center_privilege_mark_list_container);
        this.gVG = (LinearLayout) this.mRootView.findViewById(R.id.ala_person_center_privilege_header_has_wears);
        this.gVJ = (TextView) this.mRootView.findViewById(R.id.ala_person_center_privilege_jump_rule_text);
        this.gVF = (ImageView) this.mRootView.findViewById(R.id.empty_image);
        this.ghA = (TextView) this.mRootView.findViewById(R.id.empty_text);
        this.cDw = this.mRootView.findViewById(R.id.ala_person_center_privilege_mask);
        this.gVA = (BdListView) this.mRootView.findViewById(R.id.ala_person_center_privilege_mark_list);
        this.gVB = new b(this.efr, this.gVM);
        this.gVA.setAdapter((ListAdapter) this.gVB);
        this.gVE = (RelativeLayout) this.mRootView.findViewById(R.id.emptyview);
        this.gVA.setEmptyView(this.gVE);
        this.fGX.setIsRound(true);
        this.fGX.setDefaultBgResource(R.color.transparent);
        this.fGX.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.gVD.setDefaultBgResource(R.color.transparent);
        this.gVD.setScaleType(ImageView.ScaleType.CENTER_CROP);
        onChangeSkinType();
    }

    private void onChangeSkinType() {
        ap.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
        ap.setViewTextColor(this.mName, (int) R.color.common_color_10310);
        ap.setViewTextColor(this.gVC, (int) R.color.white_alpha70);
        ap.setViewTextColor(this.gVJ, (int) R.color.cp_cont_d);
        ap.setViewTextColor(this.ghA, (int) R.color.cp_cont_f);
        if (TbadkApplication.getInst().getSkinType() == 1) {
            this.gVF.setAlpha(0.4f);
            this.cDw.setBackgroundColor(this.efr.getResources().getColor(R.color.black_alpha60));
            return;
        }
        this.gVF.setAlpha(1.0f);
        this.cDw.setBackgroundColor(this.efr.getResources().getColor(R.color.black_alpha30));
    }

    public void a(AlaUserInfoData alaUserInfoData, List<c> list) {
        if (this.gVB != null && list != null) {
            this.gVB.setData(list);
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
                format = String.format(this.efr.getString(R.string.ala_achievement_mark_get_text), 0);
            } else {
                format = String.format(this.efr.getString(R.string.ala_achievement_mark_get_text), Long.valueOf(alaUserInfoData.mark_count.user_mark_count));
            }
            am(currentPortrait, str, format);
            int dimension = (int) this.efr.getResources().getDimension(R.dimen.ds32);
            if (this.gVL != null && this.gVL.size() > 0) {
                this.gVL.clear();
            }
            if (this.gVG != null) {
                this.gVG.removeAllViews();
                this.gVL = alaUserInfoData.live_mark_info_new;
                if (this.gVL != null) {
                    for (int i = 0; i < this.gVL.size(); i++) {
                        TbImageView tbImageView = new TbImageView(this.efr.getPageActivity());
                        tbImageView.setDefaultBgResource(R.color.transparent);
                        tbImageView.startLoad(this.gVL.get(i).mark_pic, 21, false);
                        tbImageView.setLayoutParams(new LinearLayout.LayoutParams(dimension, dimension));
                        tbImageView.setScaleType(ImageView.ScaleType.FIT_XY);
                        ((LinearLayout.LayoutParams) tbImageView.getLayoutParams()).rightMargin = (int) this.efr.getResources().getDimension(R.dimen.ds12);
                        this.gVG.addView(tbImageView);
                    }
                    return;
                }
                return;
            }
            return;
        }
        am(TbadkApplication.getCurrentPortrait(), TbadkApplication.getCurrentAccountNameShow(), String.format(this.efr.getString(R.string.ala_achievement_mark_get_text), 0));
        if (this.gVL != null && this.gVL.size() > 0) {
            this.gVL.clear();
        }
        if (this.gVG != null) {
            this.gVG.removeAllViews();
        }
    }

    private void am(String str, String str2, String str3) {
        if (!StringUtils.isNull(str)) {
            this.fGX.startLoad(str, 25, false);
            com.baidu.adp.lib.e.c.mM().a(str, 25, new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.view.a.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.e.b
                public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str4, int i) {
                    super.onLoaded((AnonymousClass1) aVar, str4, i);
                    if (aVar != null && aVar.getRawBitmap() != null) {
                        a.this.gVD.setScaleType(ImageView.ScaleType.CENTER_CROP);
                        a.this.gVD.setImageBitmap(BitmapHelper.fastblur(aVar.getRawBitmap(), 15, 0.75f));
                    }
                }
            }, null);
        } else {
            this.fGX.startLoad(String.valueOf((int) R.drawable.icon_default_avatar100_bg), 24, false);
            this.gVD.startLoad(String.valueOf((int) R.drawable.icon_default_avatar100_bg), 24, false);
        }
        if (!StringUtils.isNull(str2)) {
            this.mName.setText(str2);
        } else {
            this.mName.setText("");
        }
        if (!StringUtils.isNull(str3)) {
            this.gVC.setText(str3);
        } else {
            this.gVC.setText("");
        }
    }

    public View getView() {
        return this.mRootView;
    }

    public void a(int i, int i2, boolean z, View.OnClickListener onClickListener) {
        if (this.efr != null) {
            if (this.gVH == null) {
                this.gVH = new AlaNetRefreshView(this.efr.getPageActivity());
            }
            this.gVH.setImageResource(i);
            this.gVH.setNetFailTipText(this.efr.getString(i2));
            this.gVH.onChangeSkinType();
            this.gVH.setIsShowRefreshButton(z);
            if (z) {
                this.gVH.setOnRefreshClickListener(onClickListener);
            }
            this.gVH.attachView(this.gVI);
        }
    }

    public void bFX() {
        if (this.gVH != null) {
            this.gVH.dettachView(this.gVI);
        }
    }
}
