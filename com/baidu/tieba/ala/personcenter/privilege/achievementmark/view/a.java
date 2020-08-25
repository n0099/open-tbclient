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
    private View cDs;
    private TbPageContext<BaseFragmentActivity> efn;
    private HeadImageView fGT;
    private RelativeLayout gVA;
    private ImageView gVB;
    private LinearLayout gVC;
    private AlaNetRefreshView gVD;
    private RelativeLayout gVE;
    private TextView gVF;
    private InterfaceC0655a gVG;
    private List<AlaLiveMarkData> gVH = new ArrayList();
    private b.a gVI = new b.a() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.view.a.2
        @Override // com.baidu.tieba.ala.personcenter.privilege.achievementmark.b.a
        public void a(com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.b bVar) {
            if (a.this.gVG != null) {
                a.this.gVG.a(bVar);
            }
        }
    };
    private BdListView gVw;
    private b gVx;
    private TextView gVy;
    private TbImageView gVz;
    private TextView ghw;
    private TextView mName;
    private View mRootView;

    /* renamed from: com.baidu.tieba.ala.personcenter.privilege.achievementmark.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0655a {
        void a(com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.b bVar);
    }

    public a(TbPageContext<BaseFragmentActivity> tbPageContext, InterfaceC0655a interfaceC0655a) {
        this.efn = tbPageContext;
        this.gVG = interfaceC0655a;
        initView();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.efn.getPageActivity()).inflate(R.layout.ala_achievement_mark_fragment_layout, (ViewGroup) null);
        this.mRootView.setPadding(0, (int) this.efn.getResources().getDimension(R.dimen.ds80), 0, 0);
        this.fGT = (HeadImageView) this.mRootView.findViewById(R.id.ala_person_center_privilege_header_iv);
        this.mName = (TextView) this.mRootView.findViewById(R.id.ala_person_center_privilege_header_name_tv);
        this.gVy = (TextView) this.mRootView.findViewById(R.id.ala_person_center_privilege_header_desc_tv);
        this.gVz = (TbImageView) this.mRootView.findViewById(R.id.ala_person_center_privilege_header_container_bg);
        this.gVE = (RelativeLayout) this.mRootView.findViewById(R.id.ala_person_center_privilege_mark_list_container);
        this.gVC = (LinearLayout) this.mRootView.findViewById(R.id.ala_person_center_privilege_header_has_wears);
        this.gVF = (TextView) this.mRootView.findViewById(R.id.ala_person_center_privilege_jump_rule_text);
        this.gVB = (ImageView) this.mRootView.findViewById(R.id.empty_image);
        this.ghw = (TextView) this.mRootView.findViewById(R.id.empty_text);
        this.cDs = this.mRootView.findViewById(R.id.ala_person_center_privilege_mask);
        this.gVw = (BdListView) this.mRootView.findViewById(R.id.ala_person_center_privilege_mark_list);
        this.gVx = new b(this.efn, this.gVI);
        this.gVw.setAdapter((ListAdapter) this.gVx);
        this.gVA = (RelativeLayout) this.mRootView.findViewById(R.id.emptyview);
        this.gVw.setEmptyView(this.gVA);
        this.fGT.setIsRound(true);
        this.fGT.setDefaultBgResource(R.color.transparent);
        this.fGT.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.gVz.setDefaultBgResource(R.color.transparent);
        this.gVz.setScaleType(ImageView.ScaleType.CENTER_CROP);
        onChangeSkinType();
    }

    private void onChangeSkinType() {
        ap.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
        ap.setViewTextColor(this.mName, (int) R.color.common_color_10310);
        ap.setViewTextColor(this.gVy, (int) R.color.white_alpha70);
        ap.setViewTextColor(this.gVF, (int) R.color.cp_cont_d);
        ap.setViewTextColor(this.ghw, (int) R.color.cp_cont_f);
        if (TbadkApplication.getInst().getSkinType() == 1) {
            this.gVB.setAlpha(0.4f);
            this.cDs.setBackgroundColor(this.efn.getResources().getColor(R.color.black_alpha60));
            return;
        }
        this.gVB.setAlpha(1.0f);
        this.cDs.setBackgroundColor(this.efn.getResources().getColor(R.color.black_alpha30));
    }

    public void a(AlaUserInfoData alaUserInfoData, List<c> list) {
        if (this.gVx != null && list != null) {
            this.gVx.setData(list);
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
                format = String.format(this.efn.getString(R.string.ala_achievement_mark_get_text), 0);
            } else {
                format = String.format(this.efn.getString(R.string.ala_achievement_mark_get_text), Long.valueOf(alaUserInfoData.mark_count.user_mark_count));
            }
            am(currentPortrait, str, format);
            int dimension = (int) this.efn.getResources().getDimension(R.dimen.ds32);
            if (this.gVH != null && this.gVH.size() > 0) {
                this.gVH.clear();
            }
            if (this.gVC != null) {
                this.gVC.removeAllViews();
                this.gVH = alaUserInfoData.live_mark_info_new;
                if (this.gVH != null) {
                    for (int i = 0; i < this.gVH.size(); i++) {
                        TbImageView tbImageView = new TbImageView(this.efn.getPageActivity());
                        tbImageView.setDefaultBgResource(R.color.transparent);
                        tbImageView.startLoad(this.gVH.get(i).mark_pic, 21, false);
                        tbImageView.setLayoutParams(new LinearLayout.LayoutParams(dimension, dimension));
                        tbImageView.setScaleType(ImageView.ScaleType.FIT_XY);
                        ((LinearLayout.LayoutParams) tbImageView.getLayoutParams()).rightMargin = (int) this.efn.getResources().getDimension(R.dimen.ds12);
                        this.gVC.addView(tbImageView);
                    }
                    return;
                }
                return;
            }
            return;
        }
        am(TbadkApplication.getCurrentPortrait(), TbadkApplication.getCurrentAccountNameShow(), String.format(this.efn.getString(R.string.ala_achievement_mark_get_text), 0));
        if (this.gVH != null && this.gVH.size() > 0) {
            this.gVH.clear();
        }
        if (this.gVC != null) {
            this.gVC.removeAllViews();
        }
    }

    private void am(String str, String str2, String str3) {
        if (!StringUtils.isNull(str)) {
            this.fGT.startLoad(str, 25, false);
            com.baidu.adp.lib.e.c.mM().a(str, 25, new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.view.a.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.e.b
                public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str4, int i) {
                    super.onLoaded((AnonymousClass1) aVar, str4, i);
                    if (aVar != null && aVar.getRawBitmap() != null) {
                        a.this.gVz.setScaleType(ImageView.ScaleType.CENTER_CROP);
                        a.this.gVz.setImageBitmap(BitmapHelper.fastblur(aVar.getRawBitmap(), 15, 0.75f));
                    }
                }
            }, null);
        } else {
            this.fGT.startLoad(String.valueOf((int) R.drawable.icon_default_avatar100_bg), 24, false);
            this.gVz.startLoad(String.valueOf((int) R.drawable.icon_default_avatar100_bg), 24, false);
        }
        if (!StringUtils.isNull(str2)) {
            this.mName.setText(str2);
        } else {
            this.mName.setText("");
        }
        if (!StringUtils.isNull(str3)) {
            this.gVy.setText(str3);
        } else {
            this.gVy.setText("");
        }
    }

    public View getView() {
        return this.mRootView;
    }

    public void a(int i, int i2, boolean z, View.OnClickListener onClickListener) {
        if (this.efn != null) {
            if (this.gVD == null) {
                this.gVD = new AlaNetRefreshView(this.efn.getPageActivity());
            }
            this.gVD.setImageResource(i);
            this.gVD.setNetFailTipText(this.efn.getString(i2));
            this.gVD.onChangeSkinType();
            this.gVD.setIsShowRefreshButton(z);
            if (z) {
                this.gVD.setOnRefreshClickListener(onClickListener);
            }
            this.gVD.attachView(this.gVE);
        }
    }

    public void bFW() {
        if (this.gVD != null) {
            this.gVD.dettachView(this.gVE);
        }
    }
}
