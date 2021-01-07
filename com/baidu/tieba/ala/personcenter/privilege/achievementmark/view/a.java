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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.c;
import com.baidu.tieba.ala.personcenter.privilege.achievementmark.b;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes10.dex */
public class a {
    private View dqj;
    private TbPageContext<BaseFragmentActivity> eXu;
    private HeadImageView gFj;
    private TextView hln;
    private BdListView ibL;
    private b ibM;
    private TextView ibN;
    private TbImageView ibO;
    private RelativeLayout ibP;
    private ImageView ibQ;
    private LinearLayout ibR;
    private AlaNetRefreshView ibS;
    private RelativeLayout ibT;
    private TextView ibU;
    private InterfaceC0705a ibV;
    private List<AlaLiveMarkData> ibW = new ArrayList();
    private b.a ibX = new b.a() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.view.a.2
        @Override // com.baidu.tieba.ala.personcenter.privilege.achievementmark.b.a
        public void a(com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.b bVar) {
            if (a.this.ibV != null) {
                a.this.ibV.a(bVar);
            }
        }
    };
    private TextView mName;
    private View mRootView;

    /* renamed from: com.baidu.tieba.ala.personcenter.privilege.achievementmark.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public interface InterfaceC0705a {
        void a(com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.b bVar);
    }

    public a(TbPageContext<BaseFragmentActivity> tbPageContext, InterfaceC0705a interfaceC0705a) {
        this.eXu = tbPageContext;
        this.ibV = interfaceC0705a;
        initView();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.eXu.getPageActivity()).inflate(R.layout.ala_achievement_mark_fragment_layout, (ViewGroup) null);
        this.mRootView.setPadding(0, (int) this.eXu.getResources().getDimension(R.dimen.ds80), 0, 0);
        this.gFj = (HeadImageView) this.mRootView.findViewById(R.id.ala_person_center_privilege_header_iv);
        this.mName = (TextView) this.mRootView.findViewById(R.id.ala_person_center_privilege_header_name_tv);
        this.ibN = (TextView) this.mRootView.findViewById(R.id.ala_person_center_privilege_header_desc_tv);
        this.ibO = (TbImageView) this.mRootView.findViewById(R.id.ala_person_center_privilege_header_container_bg);
        this.ibT = (RelativeLayout) this.mRootView.findViewById(R.id.ala_person_center_privilege_mark_list_container);
        this.ibR = (LinearLayout) this.mRootView.findViewById(R.id.ala_person_center_privilege_header_has_wears);
        this.ibU = (TextView) this.mRootView.findViewById(R.id.ala_person_center_privilege_jump_rule_text);
        this.ibQ = (ImageView) this.mRootView.findViewById(R.id.empty_image);
        this.hln = (TextView) this.mRootView.findViewById(R.id.empty_text);
        this.dqj = this.mRootView.findViewById(R.id.ala_person_center_privilege_mask);
        this.ibL = (BdListView) this.mRootView.findViewById(R.id.ala_person_center_privilege_mark_list);
        this.ibM = new b(this.eXu, this.ibX);
        this.ibL.setAdapter((ListAdapter) this.ibM);
        this.ibP = (RelativeLayout) this.mRootView.findViewById(R.id.emptyview);
        this.ibL.setEmptyView(this.ibP);
        this.gFj.setIsRound(true);
        this.gFj.setDefaultBgResource(R.color.transparent);
        this.gFj.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.ibO.setDefaultBgResource(R.color.transparent);
        this.ibO.setScaleType(ImageView.ScaleType.CENTER_CROP);
        onChangeSkinType();
    }

    private void onChangeSkinType() {
        ao.setBackgroundColor(this.mRootView, R.color.CAM_X0201);
        ao.setViewTextColor(this.mName, R.color.common_color_10310);
        ao.setViewTextColor(this.ibN, R.color.white_alpha70);
        ao.setViewTextColor(this.ibU, R.color.CAM_X0109);
        ao.setViewTextColor(this.hln, R.color.CAM_X0106);
        if (TbadkApplication.getInst().getSkinType() == 1) {
            this.ibQ.setAlpha(0.4f);
            this.dqj.setBackgroundColor(this.eXu.getResources().getColor(R.color.black_alpha60));
            return;
        }
        this.ibQ.setAlpha(1.0f);
        this.dqj.setBackgroundColor(this.eXu.getResources().getColor(R.color.black_alpha30));
    }

    public void a(AlaUserInfoData alaUserInfoData, List<c> list) {
        if (this.ibM != null && list != null) {
            this.ibM.setData(list);
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
                format = String.format(this.eXu.getString(R.string.ala_achievement_mark_get_text), 0);
            } else {
                format = String.format(this.eXu.getString(R.string.ala_achievement_mark_get_text), Long.valueOf(alaUserInfoData.mark_count.user_mark_count));
            }
            aB(currentPortrait, str, format);
            int dimension = (int) this.eXu.getResources().getDimension(R.dimen.ds32);
            if (this.ibW != null && this.ibW.size() > 0) {
                this.ibW.clear();
            }
            if (this.ibR != null) {
                this.ibR.removeAllViews();
                this.ibW = alaUserInfoData.live_mark_info_new;
                if (this.ibW != null) {
                    for (int i = 0; i < this.ibW.size(); i++) {
                        TbImageView tbImageView = new TbImageView(this.eXu.getPageActivity());
                        tbImageView.setDefaultBgResource(R.color.transparent);
                        tbImageView.startLoad(this.ibW.get(i).mark_pic, 21, false);
                        tbImageView.setLayoutParams(new LinearLayout.LayoutParams(dimension, dimension));
                        tbImageView.setScaleType(ImageView.ScaleType.FIT_XY);
                        ((LinearLayout.LayoutParams) tbImageView.getLayoutParams()).rightMargin = (int) this.eXu.getResources().getDimension(R.dimen.ds12);
                        this.ibR.addView(tbImageView);
                    }
                    return;
                }
                return;
            }
            return;
        }
        aB(TbadkApplication.getCurrentPortrait(), TbadkApplication.getCurrentAccountNameShow(), String.format(this.eXu.getString(R.string.ala_achievement_mark_get_text), 0));
        if (this.ibW != null && this.ibW.size() > 0) {
            this.ibW.clear();
        }
        if (this.ibR != null) {
            this.ibR.removeAllViews();
        }
    }

    private void aB(String str, String str2, String str3) {
        if (!StringUtils.isNull(str)) {
            this.gFj.startLoad(str, 25, false);
            d.mx().a(str, 25, new com.baidu.adp.lib.e.c<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.view.a.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.e.c
                public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str4, int i) {
                    super.onLoaded((AnonymousClass1) aVar, str4, i);
                    if (aVar != null && aVar.getRawBitmap() != null) {
                        a.this.ibO.setScaleType(ImageView.ScaleType.CENTER_CROP);
                        a.this.ibO.setImageBitmap(BitmapHelper.fastblur(aVar.getRawBitmap(), 15, 0.75f));
                    }
                }
            }, null);
        } else {
            this.gFj.startLoad(String.valueOf(R.drawable.icon_default_avatar100_bg), 24, false);
            this.ibO.startLoad(String.valueOf(R.drawable.icon_default_avatar100_bg), 24, false);
        }
        if (!StringUtils.isNull(str2)) {
            this.mName.setText(str2);
        } else {
            this.mName.setText("");
        }
        if (!StringUtils.isNull(str3)) {
            this.ibN.setText(str3);
        } else {
            this.ibN.setText("");
        }
    }

    public View getView() {
        return this.mRootView;
    }

    public void a(int i, int i2, boolean z, View.OnClickListener onClickListener) {
        if (this.eXu != null) {
            if (this.ibS == null) {
                this.ibS = new AlaNetRefreshView(this.eXu.getPageActivity());
            }
            this.ibS.setImageResource(i);
            this.ibS.setNetFailTipText(this.eXu.getString(i2));
            this.ibS.onChangeSkinType();
            this.ibS.setIsShowRefreshButton(z);
            if (z) {
                this.ibS.setOnRefreshClickListener(onClickListener);
            }
            this.ibS.attachView(this.ibT);
        }
    }

    public void Zj() {
        if (this.ibS != null) {
            this.ibS.dettachView(this.ibT);
        }
    }
}
