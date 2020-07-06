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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.c;
import com.baidu.tieba.ala.personcenter.privilege.achievementmark.b;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class a {
    private TbPageContext<BaseFragmentActivity> dPv;
    private View dox;
    private TextView fQe;
    private HeadImageView fqr;
    private RelativeLayout gDA;
    private ImageView gDB;
    private LinearLayout gDC;
    private AlaNetRefreshView gDD;
    private RelativeLayout gDE;
    private TextView gDF;
    private InterfaceC0596a gDG;
    private List<AlaLiveMarkData> gDH = new ArrayList();
    private b.a gDI = new b.a() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.view.a.2
        @Override // com.baidu.tieba.ala.personcenter.privilege.achievementmark.b.a
        public void a(com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.b bVar) {
            if (a.this.gDG != null) {
                a.this.gDG.a(bVar);
            }
        }
    };
    private BdListView gDw;
    private b gDx;
    private TextView gDy;
    private TbImageView gDz;
    private TextView mName;
    private View mRootView;

    /* renamed from: com.baidu.tieba.ala.personcenter.privilege.achievementmark.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0596a {
        void a(com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.b bVar);
    }

    public a(TbPageContext<BaseFragmentActivity> tbPageContext, InterfaceC0596a interfaceC0596a) {
        this.dPv = tbPageContext;
        this.gDG = interfaceC0596a;
        initView();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.dPv.getPageActivity()).inflate(R.layout.ala_achievement_mark_fragment_layout, (ViewGroup) null);
        this.mRootView.setPadding(0, (int) this.dPv.getResources().getDimension(R.dimen.ds80), 0, 0);
        this.fqr = (HeadImageView) this.mRootView.findViewById(R.id.ala_person_center_privilege_header_iv);
        this.mName = (TextView) this.mRootView.findViewById(R.id.ala_person_center_privilege_header_name_tv);
        this.gDy = (TextView) this.mRootView.findViewById(R.id.ala_person_center_privilege_header_desc_tv);
        this.gDz = (TbImageView) this.mRootView.findViewById(R.id.ala_person_center_privilege_header_container_bg);
        this.gDE = (RelativeLayout) this.mRootView.findViewById(R.id.ala_person_center_privilege_mark_list_container);
        this.gDC = (LinearLayout) this.mRootView.findViewById(R.id.ala_person_center_privilege_header_has_wears);
        this.gDF = (TextView) this.mRootView.findViewById(R.id.ala_person_center_privilege_jump_rule_text);
        this.gDB = (ImageView) this.mRootView.findViewById(R.id.empty_image);
        this.fQe = (TextView) this.mRootView.findViewById(R.id.empty_text);
        this.dox = this.mRootView.findViewById(R.id.ala_person_center_privilege_mask);
        this.gDw = (BdListView) this.mRootView.findViewById(R.id.ala_person_center_privilege_mark_list);
        this.gDx = new b(this.dPv, this.gDI);
        this.gDw.setAdapter((ListAdapter) this.gDx);
        this.gDA = (RelativeLayout) this.mRootView.findViewById(R.id.emptyview);
        this.gDw.setEmptyView(this.gDA);
        this.fqr.setIsRound(true);
        this.fqr.setDefaultBgResource(R.color.transparent);
        this.fqr.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.gDz.setDefaultBgResource(R.color.transparent);
        this.gDz.setScaleType(ImageView.ScaleType.CENTER_CROP);
        onChangeSkinType();
    }

    private void onChangeSkinType() {
        an.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
        an.setViewTextColor(this.mName, (int) R.color.common_color_10310);
        an.setViewTextColor(this.gDy, (int) R.color.white_alpha70);
        an.setViewTextColor(this.gDF, (int) R.color.cp_cont_d);
        an.setViewTextColor(this.fQe, (int) R.color.cp_cont_f);
        if (TbadkApplication.getInst().getSkinType() == 1) {
            this.gDB.setAlpha(0.4f);
            this.dox.setBackgroundColor(this.dPv.getResources().getColor(R.color.black_alpha60));
            return;
        }
        this.gDB.setAlpha(1.0f);
        this.dox.setBackgroundColor(this.dPv.getResources().getColor(R.color.black_alpha30));
    }

    public void a(AlaUserInfoData alaUserInfoData, List<c> list) {
        if (this.gDx != null && list != null) {
            this.gDx.setData(list);
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
                format = String.format(this.dPv.getString(R.string.ala_achievement_mark_get_text), 0);
            } else {
                format = String.format(this.dPv.getString(R.string.ala_achievement_mark_get_text), Long.valueOf(alaUserInfoData.mark_count.user_mark_count));
            }
            al(currentPortrait, str, format);
            int dimension = (int) this.dPv.getResources().getDimension(R.dimen.ds32);
            if (this.gDH != null && this.gDH.size() > 0) {
                this.gDH.clear();
            }
            if (this.gDC != null) {
                this.gDC.removeAllViews();
                this.gDH = alaUserInfoData.live_mark_info_new;
                if (this.gDH != null) {
                    for (int i = 0; i < this.gDH.size(); i++) {
                        TbImageView tbImageView = new TbImageView(this.dPv.getPageActivity());
                        tbImageView.setDefaultBgResource(R.color.transparent);
                        tbImageView.startLoad(this.gDH.get(i).mark_pic, 21, false);
                        tbImageView.setLayoutParams(new LinearLayout.LayoutParams(dimension, dimension));
                        tbImageView.setScaleType(ImageView.ScaleType.FIT_XY);
                        ((LinearLayout.LayoutParams) tbImageView.getLayoutParams()).rightMargin = (int) this.dPv.getResources().getDimension(R.dimen.ds12);
                        this.gDC.addView(tbImageView);
                    }
                    return;
                }
                return;
            }
            return;
        }
        al(TbadkApplication.getCurrentPortrait(), TbadkApplication.getCurrentAccountNameShow(), String.format(this.dPv.getString(R.string.ala_achievement_mark_get_text), 0));
        if (this.gDH != null && this.gDH.size() > 0) {
            this.gDH.clear();
        }
        if (this.gDC != null) {
            this.gDC.removeAllViews();
        }
    }

    private void al(String str, String str2, String str3) {
        if (!StringUtils.isNull(str)) {
            this.fqr.startLoad(str, 25, false);
            com.baidu.adp.lib.e.c.ln().a(str, 25, new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.view.a.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.e.b
                public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str4, int i) {
                    super.onLoaded((AnonymousClass1) aVar, str4, i);
                    if (aVar != null && aVar.getRawBitmap() != null) {
                        a.this.gDz.setScaleType(ImageView.ScaleType.CENTER_CROP);
                        a.this.gDz.setImageBitmap(BitmapHelper.fastblur(aVar.getRawBitmap(), 15, 0.75f));
                    }
                }
            }, null);
        } else {
            this.fqr.startLoad(String.valueOf((int) R.drawable.icon_default_avatar100_bg), 24, false);
            this.gDz.startLoad(String.valueOf((int) R.drawable.icon_default_avatar100_bg), 24, false);
        }
        if (!StringUtils.isNull(str2)) {
            this.mName.setText(str2);
        } else {
            this.mName.setText("");
        }
        if (!StringUtils.isNull(str3)) {
            this.gDy.setText(str3);
        } else {
            this.gDy.setText("");
        }
    }

    public View getView() {
        return this.mRootView;
    }

    public void a(int i, int i2, boolean z, View.OnClickListener onClickListener) {
        if (this.dPv != null) {
            if (this.gDD == null) {
                this.gDD = new AlaNetRefreshView(this.dPv.getPageActivity());
            }
            this.gDD.setImageResource(i);
            this.gDD.setNetFailTipText(this.dPv.getString(i2));
            this.gDD.onChangeSkinType();
            this.gDD.setIsShowRefreshButton(z);
            if (z) {
                this.gDD.setOnRefreshClickListener(onClickListener);
            }
            this.gDD.attachView(this.gDE);
        }
    }

    public void btO() {
        if (this.gDD != null) {
            this.gDD.dettachView(this.gDE);
        }
    }
}
