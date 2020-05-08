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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.c;
import com.baidu.tieba.ala.personcenter.privilege.achievementmark.b;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class a {
    private View cYI;
    private TbPageContext<BaseFragmentActivity> duK;
    private HeadImageView eSn;
    private TextView fqQ;
    private BdListView gbC;
    private b gbD;
    private TextView gbE;
    private TbImageView gbF;
    private RelativeLayout gbG;
    private ImageView gbH;
    private LinearLayout gbI;
    private AlaNetRefreshView gbJ;
    private RelativeLayout gbK;
    private TextView gbL;
    private InterfaceC0537a gbM;
    private List<AlaLiveMarkData> gbN = new ArrayList();
    private b.a gbO = new b.a() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.view.a.2
        @Override // com.baidu.tieba.ala.personcenter.privilege.achievementmark.b.a
        public void a(com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.b bVar) {
            if (a.this.gbM != null) {
                a.this.gbM.a(bVar);
            }
        }
    };
    private TextView mName;
    private View mRootView;

    /* renamed from: com.baidu.tieba.ala.personcenter.privilege.achievementmark.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0537a {
        void a(com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.b bVar);
    }

    public a(TbPageContext<BaseFragmentActivity> tbPageContext, InterfaceC0537a interfaceC0537a) {
        this.duK = tbPageContext;
        this.gbM = interfaceC0537a;
        initView();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.duK.getPageActivity()).inflate(R.layout.ala_achievement_mark_fragment_layout, (ViewGroup) null);
        this.mRootView.setPadding(0, (int) this.duK.getResources().getDimension(R.dimen.ds80), 0, 0);
        this.eSn = (HeadImageView) this.mRootView.findViewById(R.id.ala_person_center_privilege_header_iv);
        this.mName = (TextView) this.mRootView.findViewById(R.id.ala_person_center_privilege_header_name_tv);
        this.gbE = (TextView) this.mRootView.findViewById(R.id.ala_person_center_privilege_header_desc_tv);
        this.gbF = (TbImageView) this.mRootView.findViewById(R.id.ala_person_center_privilege_header_container_bg);
        this.gbK = (RelativeLayout) this.mRootView.findViewById(R.id.ala_person_center_privilege_mark_list_container);
        this.gbI = (LinearLayout) this.mRootView.findViewById(R.id.ala_person_center_privilege_header_has_wears);
        this.gbL = (TextView) this.mRootView.findViewById(R.id.ala_person_center_privilege_jump_rule_text);
        this.gbH = (ImageView) this.mRootView.findViewById(R.id.empty_image);
        this.fqQ = (TextView) this.mRootView.findViewById(R.id.empty_text);
        this.cYI = this.mRootView.findViewById(R.id.ala_person_center_privilege_mask);
        this.gbC = (BdListView) this.mRootView.findViewById(R.id.ala_person_center_privilege_mark_list);
        this.gbD = new b(this.duK, this.gbO);
        this.gbC.setAdapter((ListAdapter) this.gbD);
        this.gbG = (RelativeLayout) this.mRootView.findViewById(R.id.emptyview);
        this.gbC.setEmptyView(this.gbG);
        this.eSn.setIsRound(true);
        this.eSn.setDefaultBgResource(R.color.transparent);
        this.eSn.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.gbF.setDefaultBgResource(R.color.transparent);
        this.gbF.setScaleType(ImageView.ScaleType.CENTER_CROP);
        onChangeSkinType();
    }

    private void onChangeSkinType() {
        am.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
        am.setViewTextColor(this.mName, (int) R.color.common_color_10310);
        am.setViewTextColor(this.gbE, (int) R.color.white_alpha70);
        am.setViewTextColor(this.gbL, (int) R.color.cp_cont_d);
        am.setViewTextColor(this.fqQ, (int) R.color.cp_cont_f);
        if (TbadkApplication.getInst().getSkinType() == 1) {
            this.gbH.setAlpha(0.4f);
            this.cYI.setBackgroundColor(this.duK.getResources().getColor(R.color.black_alpha60));
            return;
        }
        this.gbH.setAlpha(1.0f);
        this.cYI.setBackgroundColor(this.duK.getResources().getColor(R.color.black_alpha30));
    }

    public void a(AlaUserInfoData alaUserInfoData, List<c> list) {
        if (this.gbD != null && list != null) {
            this.gbD.setData(list);
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
                format = String.format(this.duK.getString(R.string.ala_achievement_mark_get_text), 0);
            } else {
                format = String.format(this.duK.getString(R.string.ala_achievement_mark_get_text), Long.valueOf(alaUserInfoData.mark_count.user_mark_count));
            }
            ag(currentPortrait, str, format);
            int dimension = (int) this.duK.getResources().getDimension(R.dimen.ds32);
            if (this.gbN != null && this.gbN.size() > 0) {
                this.gbN.clear();
            }
            if (this.gbI != null) {
                this.gbI.removeAllViews();
                this.gbN = alaUserInfoData.live_mark_info_new;
                if (this.gbN != null) {
                    for (int i = 0; i < this.gbN.size(); i++) {
                        TbImageView tbImageView = new TbImageView(this.duK.getPageActivity());
                        tbImageView.setDefaultBgResource(R.color.transparent);
                        tbImageView.startLoad(this.gbN.get(i).mark_pic, 21, false);
                        tbImageView.setLayoutParams(new LinearLayout.LayoutParams(dimension, dimension));
                        tbImageView.setScaleType(ImageView.ScaleType.FIT_XY);
                        ((LinearLayout.LayoutParams) tbImageView.getLayoutParams()).rightMargin = (int) this.duK.getResources().getDimension(R.dimen.ds12);
                        this.gbI.addView(tbImageView);
                    }
                    return;
                }
                return;
            }
            return;
        }
        ag(TbadkApplication.getCurrentPortrait(), TbadkApplication.getCurrentAccountNameShow(), String.format(this.duK.getString(R.string.ala_achievement_mark_get_text), 0));
        if (this.gbN != null && this.gbN.size() > 0) {
            this.gbN.clear();
        }
        if (this.gbI != null) {
            this.gbI.removeAllViews();
        }
    }

    private void ag(String str, String str2, String str3) {
        if (!StringUtils.isNull(str)) {
            this.eSn.startLoad(str, 25, false);
            com.baidu.adp.lib.e.c.kV().a(str, 25, new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.view.a.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.e.b
                public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str4, int i) {
                    super.onLoaded((AnonymousClass1) aVar, str4, i);
                    if (aVar != null && aVar.getRawBitmap() != null) {
                        a.this.gbF.setScaleType(ImageView.ScaleType.CENTER_CROP);
                        a.this.gbF.setImageBitmap(BitmapHelper.fastblur(aVar.getRawBitmap(), 15, 0.75f));
                    }
                }
            }, null);
        } else {
            this.eSn.startLoad(String.valueOf((int) R.drawable.icon_default_avatar100_bg), 24, false);
            this.gbF.startLoad(String.valueOf((int) R.drawable.icon_default_avatar100_bg), 24, false);
        }
        if (!StringUtils.isNull(str2)) {
            this.mName.setText(str2);
        } else {
            this.mName.setText("");
        }
        if (!StringUtils.isNull(str3)) {
            this.gbE.setText(str3);
        } else {
            this.gbE.setText("");
        }
    }

    public View getView() {
        return this.mRootView;
    }

    public void a(int i, int i2, boolean z, View.OnClickListener onClickListener) {
        if (this.duK != null) {
            if (this.gbJ == null) {
                this.gbJ = new AlaNetRefreshView(this.duK.getPageActivity());
            }
            this.gbJ.setImageResource(i);
            this.gbJ.setNetFailTipText(this.duK.getString(i2));
            this.gbJ.onChangeSkinType();
            this.gbJ.setIsShowRefreshButton(z);
            if (z) {
                this.gbJ.setOnRefreshClickListener(onClickListener);
            }
            this.gbJ.attachView(this.gbK);
        }
    }

    public void blr() {
        if (this.gbJ != null) {
            this.gbJ.dettachView(this.gbK);
        }
    }
}
