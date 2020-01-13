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
/* loaded from: classes2.dex */
public class a {
    private TbPageContext<BaseFragmentActivity> cRe;
    private View cvu;
    private TextView eHP;
    private HeadImageView ejV;
    private BdListView ftC;
    private b ftD;
    private TextView ftE;
    private TbImageView ftF;
    private RelativeLayout ftG;
    private ImageView ftH;
    private LinearLayout ftI;
    private AlaNetRefreshView ftJ;
    private RelativeLayout ftK;
    private TextView ftL;
    private InterfaceC0472a ftM;
    private List<AlaLiveMarkData> ftN = new ArrayList();
    private b.a ftO = new b.a() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.view.a.2
        @Override // com.baidu.tieba.ala.personcenter.privilege.achievementmark.b.a
        public void a(com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.b bVar) {
            if (a.this.ftM != null) {
                a.this.ftM.a(bVar);
            }
        }
    };
    private TextView mName;
    private View mRootView;

    /* renamed from: com.baidu.tieba.ala.personcenter.privilege.achievementmark.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0472a {
        void a(com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.b bVar);
    }

    public a(TbPageContext<BaseFragmentActivity> tbPageContext, InterfaceC0472a interfaceC0472a) {
        this.cRe = tbPageContext;
        this.ftM = interfaceC0472a;
        initView();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.cRe.getPageActivity()).inflate(R.layout.ala_achievement_mark_fragment_layout, (ViewGroup) null);
        this.mRootView.setPadding(0, (int) this.cRe.getResources().getDimension(R.dimen.ds80), 0, 0);
        this.ejV = (HeadImageView) this.mRootView.findViewById(R.id.ala_person_center_privilege_header_iv);
        this.mName = (TextView) this.mRootView.findViewById(R.id.ala_person_center_privilege_header_name_tv);
        this.ftE = (TextView) this.mRootView.findViewById(R.id.ala_person_center_privilege_header_desc_tv);
        this.ftF = (TbImageView) this.mRootView.findViewById(R.id.ala_person_center_privilege_header_container_bg);
        this.ftK = (RelativeLayout) this.mRootView.findViewById(R.id.ala_person_center_privilege_mark_list_container);
        this.ftI = (LinearLayout) this.mRootView.findViewById(R.id.ala_person_center_privilege_header_has_wears);
        this.ftL = (TextView) this.mRootView.findViewById(R.id.ala_person_center_privilege_jump_rule_text);
        this.ftH = (ImageView) this.mRootView.findViewById(R.id.empty_image);
        this.eHP = (TextView) this.mRootView.findViewById(R.id.empty_text);
        this.cvu = this.mRootView.findViewById(R.id.ala_person_center_privilege_mask);
        this.ftC = (BdListView) this.mRootView.findViewById(R.id.ala_person_center_privilege_mark_list);
        this.ftD = new b(this.cRe, this.ftO);
        this.ftC.setAdapter((ListAdapter) this.ftD);
        this.ftG = (RelativeLayout) this.mRootView.findViewById(R.id.emptyview);
        this.ftC.setEmptyView(this.ftG);
        this.ejV.setIsRound(true);
        this.ejV.setDefaultBgResource(R.color.transparent);
        this.ejV.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.ftF.setDefaultBgResource(R.color.transparent);
        this.ftF.setScaleType(ImageView.ScaleType.CENTER_CROP);
        onChangeSkinType();
    }

    private void onChangeSkinType() {
        am.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
        am.setViewTextColor(this.mName, (int) R.color.common_color_10310);
        am.setViewTextColor(this.ftE, (int) R.color.white_alpha70);
        am.setViewTextColor(this.ftL, (int) R.color.cp_cont_d);
        am.setViewTextColor(this.eHP, (int) R.color.cp_cont_f);
        if (TbadkApplication.getInst().getSkinType() == 1) {
            this.ftH.setAlpha(0.4f);
            this.cvu.setBackgroundColor(this.cRe.getResources().getColor(R.color.black_alpha60));
            return;
        }
        this.ftH.setAlpha(1.0f);
        this.cvu.setBackgroundColor(this.cRe.getResources().getColor(R.color.black_alpha30));
    }

    public void a(AlaUserInfoData alaUserInfoData, List<c> list) {
        if (this.ftD != null && list != null) {
            this.ftD.setData(list);
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
                format = String.format(this.cRe.getString(R.string.ala_achievement_mark_get_text), 0);
            } else {
                format = String.format(this.cRe.getString(R.string.ala_achievement_mark_get_text), Long.valueOf(alaUserInfoData.mark_count.user_mark_count));
            }
            ah(currentPortrait, str, format);
            int dimension = (int) this.cRe.getResources().getDimension(R.dimen.ds32);
            if (this.ftN != null && this.ftN.size() > 0) {
                this.ftN.clear();
            }
            if (this.ftI != null) {
                this.ftI.removeAllViews();
                this.ftN = alaUserInfoData.live_mark_info_new;
                if (this.ftN != null) {
                    for (int i = 0; i < this.ftN.size(); i++) {
                        TbImageView tbImageView = new TbImageView(this.cRe.getPageActivity());
                        tbImageView.setDefaultBgResource(R.color.transparent);
                        tbImageView.startLoad(this.ftN.get(i).mark_pic, 21, false);
                        tbImageView.setLayoutParams(new LinearLayout.LayoutParams(dimension, dimension));
                        tbImageView.setScaleType(ImageView.ScaleType.FIT_XY);
                        ((LinearLayout.LayoutParams) tbImageView.getLayoutParams()).rightMargin = (int) this.cRe.getResources().getDimension(R.dimen.ds12);
                        this.ftI.addView(tbImageView);
                    }
                    return;
                }
                return;
            }
            return;
        }
        ah(TbadkApplication.getCurrentPortrait(), TbadkApplication.getCurrentAccountNameShow(), String.format(this.cRe.getString(R.string.ala_achievement_mark_get_text), 0));
        if (this.ftN != null && this.ftN.size() > 0) {
            this.ftN.clear();
        }
        if (this.ftI != null) {
            this.ftI.removeAllViews();
        }
    }

    private void ah(String str, String str2, String str3) {
        if (!StringUtils.isNull(str)) {
            this.ejV.startLoad(str, 25, false);
            com.baidu.adp.lib.e.c.gr().a(str, 25, new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.view.a.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.e.b
                public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str4, int i) {
                    super.onLoaded((AnonymousClass1) aVar, str4, i);
                    if (aVar != null && aVar.getRawBitmap() != null) {
                        a.this.ftF.setScaleType(ImageView.ScaleType.CENTER_CROP);
                        a.this.ftF.setImageBitmap(BitmapHelper.fastblur(aVar.getRawBitmap(), 15, 0.75f));
                    }
                }
            }, null);
        } else {
            this.ejV.startLoad(String.valueOf((int) R.drawable.icon_default_avatar100_bg), 24, false);
            this.ftF.startLoad(String.valueOf((int) R.drawable.icon_default_avatar100_bg), 24, false);
        }
        if (!StringUtils.isNull(str2)) {
            this.mName.setText(str2);
        } else {
            this.mName.setText("");
        }
        if (!StringUtils.isNull(str3)) {
            this.ftE.setText(str3);
        } else {
            this.ftE.setText("");
        }
    }

    public View getView() {
        return this.mRootView;
    }

    public void a(int i, int i2, boolean z, View.OnClickListener onClickListener) {
        if (this.cRe != null) {
            if (this.ftJ == null) {
                this.ftJ = new AlaNetRefreshView(this.cRe.getPageActivity());
            }
            this.ftJ.setImageResource(i);
            this.ftJ.setNetFailTipText(this.cRe.getString(i2));
            this.ftJ.onChangeSkinType();
            this.ftJ.setIsShowRefreshButton(z);
            if (z) {
                this.ftJ.setOnRefreshClickListener(onClickListener);
            }
            this.ftJ.attachView(this.ftK);
        }
    }

    public void baf() {
        if (this.ftJ != null) {
            this.ftJ.dettachView(this.ftK);
        }
    }
}
