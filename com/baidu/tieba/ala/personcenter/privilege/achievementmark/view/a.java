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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.c;
import com.baidu.tieba.ala.personcenter.privilege.achievementmark.b;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class a {
    private TbPageContext<BaseFragmentActivity> dVN;
    private View duo;
    private TextView fVx;
    private HeadImageView fvB;
    private BdListView gIT;
    private b gIU;
    private TextView gIV;
    private TbImageView gIW;
    private RelativeLayout gIX;
    private ImageView gIY;
    private LinearLayout gIZ;
    private AlaNetRefreshView gJa;
    private RelativeLayout gJb;
    private TextView gJc;
    private InterfaceC0605a gJd;
    private List<AlaLiveMarkData> gJe = new ArrayList();
    private b.a gJf = new b.a() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.view.a.2
        @Override // com.baidu.tieba.ala.personcenter.privilege.achievementmark.b.a
        public void a(com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.b bVar) {
            if (a.this.gJd != null) {
                a.this.gJd.a(bVar);
            }
        }
    };
    private TextView mName;
    private View mRootView;

    /* renamed from: com.baidu.tieba.ala.personcenter.privilege.achievementmark.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0605a {
        void a(com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.b bVar);
    }

    public a(TbPageContext<BaseFragmentActivity> tbPageContext, InterfaceC0605a interfaceC0605a) {
        this.dVN = tbPageContext;
        this.gJd = interfaceC0605a;
        initView();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.dVN.getPageActivity()).inflate(R.layout.ala_achievement_mark_fragment_layout, (ViewGroup) null);
        this.mRootView.setPadding(0, (int) this.dVN.getResources().getDimension(R.dimen.ds80), 0, 0);
        this.fvB = (HeadImageView) this.mRootView.findViewById(R.id.ala_person_center_privilege_header_iv);
        this.mName = (TextView) this.mRootView.findViewById(R.id.ala_person_center_privilege_header_name_tv);
        this.gIV = (TextView) this.mRootView.findViewById(R.id.ala_person_center_privilege_header_desc_tv);
        this.gIW = (TbImageView) this.mRootView.findViewById(R.id.ala_person_center_privilege_header_container_bg);
        this.gJb = (RelativeLayout) this.mRootView.findViewById(R.id.ala_person_center_privilege_mark_list_container);
        this.gIZ = (LinearLayout) this.mRootView.findViewById(R.id.ala_person_center_privilege_header_has_wears);
        this.gJc = (TextView) this.mRootView.findViewById(R.id.ala_person_center_privilege_jump_rule_text);
        this.gIY = (ImageView) this.mRootView.findViewById(R.id.empty_image);
        this.fVx = (TextView) this.mRootView.findViewById(R.id.empty_text);
        this.duo = this.mRootView.findViewById(R.id.ala_person_center_privilege_mask);
        this.gIT = (BdListView) this.mRootView.findViewById(R.id.ala_person_center_privilege_mark_list);
        this.gIU = new b(this.dVN, this.gJf);
        this.gIT.setAdapter((ListAdapter) this.gIU);
        this.gIX = (RelativeLayout) this.mRootView.findViewById(R.id.emptyview);
        this.gIT.setEmptyView(this.gIX);
        this.fvB.setIsRound(true);
        this.fvB.setDefaultBgResource(R.color.transparent);
        this.fvB.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.gIW.setDefaultBgResource(R.color.transparent);
        this.gIW.setScaleType(ImageView.ScaleType.CENTER_CROP);
        onChangeSkinType();
    }

    private void onChangeSkinType() {
        ao.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
        ao.setViewTextColor(this.mName, R.color.common_color_10310);
        ao.setViewTextColor(this.gIV, R.color.white_alpha70);
        ao.setViewTextColor(this.gJc, R.color.cp_cont_d);
        ao.setViewTextColor(this.fVx, R.color.cp_cont_f);
        if (TbadkApplication.getInst().getSkinType() == 1) {
            this.gIY.setAlpha(0.4f);
            this.duo.setBackgroundColor(this.dVN.getResources().getColor(R.color.black_alpha60));
            return;
        }
        this.gIY.setAlpha(1.0f);
        this.duo.setBackgroundColor(this.dVN.getResources().getColor(R.color.black_alpha30));
    }

    public void a(AlaUserInfoData alaUserInfoData, List<c> list) {
        if (this.gIU != null && list != null) {
            this.gIU.setData(list);
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
                format = String.format(this.dVN.getString(R.string.ala_achievement_mark_get_text), 0);
            } else {
                format = String.format(this.dVN.getString(R.string.ala_achievement_mark_get_text), Long.valueOf(alaUserInfoData.mark_count.user_mark_count));
            }
            am(currentPortrait, str, format);
            int dimension = (int) this.dVN.getResources().getDimension(R.dimen.ds32);
            if (this.gJe != null && this.gJe.size() > 0) {
                this.gJe.clear();
            }
            if (this.gIZ != null) {
                this.gIZ.removeAllViews();
                this.gJe = alaUserInfoData.live_mark_info_new;
                if (this.gJe != null) {
                    for (int i = 0; i < this.gJe.size(); i++) {
                        TbImageView tbImageView = new TbImageView(this.dVN.getPageActivity());
                        tbImageView.setDefaultBgResource(R.color.transparent);
                        tbImageView.startLoad(this.gJe.get(i).mark_pic, 21, false);
                        tbImageView.setLayoutParams(new LinearLayout.LayoutParams(dimension, dimension));
                        tbImageView.setScaleType(ImageView.ScaleType.FIT_XY);
                        ((LinearLayout.LayoutParams) tbImageView.getLayoutParams()).rightMargin = (int) this.dVN.getResources().getDimension(R.dimen.ds12);
                        this.gIZ.addView(tbImageView);
                    }
                    return;
                }
                return;
            }
            return;
        }
        am(TbadkApplication.getCurrentPortrait(), TbadkApplication.getCurrentAccountNameShow(), String.format(this.dVN.getString(R.string.ala_achievement_mark_get_text), 0));
        if (this.gJe != null && this.gJe.size() > 0) {
            this.gJe.clear();
        }
        if (this.gIZ != null) {
            this.gIZ.removeAllViews();
        }
    }

    private void am(String str, String str2, String str3) {
        if (!StringUtils.isNull(str)) {
            this.fvB.startLoad(str, 25, false);
            com.baidu.adp.lib.e.c.ln().a(str, 25, new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.view.a.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.e.b
                public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str4, int i) {
                    super.onLoaded((AnonymousClass1) aVar, str4, i);
                    if (aVar != null && aVar.getRawBitmap() != null) {
                        a.this.gIW.setScaleType(ImageView.ScaleType.CENTER_CROP);
                        a.this.gIW.setImageBitmap(BitmapHelper.fastblur(aVar.getRawBitmap(), 15, 0.75f));
                    }
                }
            }, null);
        } else {
            this.fvB.startLoad(String.valueOf(R.drawable.icon_default_avatar100_bg), 24, false);
            this.gIW.startLoad(String.valueOf(R.drawable.icon_default_avatar100_bg), 24, false);
        }
        if (!StringUtils.isNull(str2)) {
            this.mName.setText(str2);
        } else {
            this.mName.setText("");
        }
        if (!StringUtils.isNull(str3)) {
            this.gIV.setText(str3);
        } else {
            this.gIV.setText("");
        }
    }

    public View getView() {
        return this.mRootView;
    }

    public void a(int i, int i2, boolean z, View.OnClickListener onClickListener) {
        if (this.dVN != null) {
            if (this.gJa == null) {
                this.gJa = new AlaNetRefreshView(this.dVN.getPageActivity());
            }
            this.gJa.setImageResource(i);
            this.gJa.setNetFailTipText(this.dVN.getString(i2));
            this.gJa.onChangeSkinType();
            this.gJa.setIsShowRefreshButton(z);
            if (z) {
                this.gJa.setOnRefreshClickListener(onClickListener);
            }
            this.gJa.attachView(this.gJb);
        }
    }

    public void bwX() {
        if (this.gJa != null) {
            this.gJa.dettachView(this.gJb);
        }
    }
}
